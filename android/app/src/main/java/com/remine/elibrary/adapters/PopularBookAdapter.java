package com.remine.elibrary.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.remine.elibrary.R;
import com.remine.elibrary.models.Book;

import java.util.ArrayList;
import java.util.List;

public class PopularBookAdapter extends RecyclerView.Adapter<PopularBookAdapter.PopularBookViewHolder> {

    private List<Book> books;
    private OnBookClickListener listener;

    public interface OnBookClickListener {
        void onBookClick(Book book);
    }

    public PopularBookAdapter(List<Book> books, OnBookClickListener listener) {
        this.books = new ArrayList<>(books);
        this.listener = listener;
    }

    @NonNull
    @Override
    public PopularBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book_vertical, parent, false);
        return new PopularBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularBookViewHolder holder, int position) {
        holder.bind(books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void updateBooks(List<Book> newBooks) {
        this.books.clear();
        this.books.addAll(newBooks);
        notifyDataSetChanged();
    }

    class PopularBookViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivCover;
        private TextView tvTitle;
        private TextView tvAuthor;
        private RatingBar ratingBar;
        private TextView tvRating;
        private TextView tvPrice;
        private Button btnReadMore;

        public PopularBookViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.ivBookCover);
            tvTitle = itemView.findViewById(R.id.tvBookTitle);
            tvAuthor = itemView.findViewById(R.id.tvBookAuthor);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            btnReadMore = itemView.findViewById(R.id.btnReadMore);

            View.OnClickListener clickListener = v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onBookClick(books.get(position));
                }
            };

            itemView.setOnClickListener(clickListener);
            btnReadMore.setOnClickListener(clickListener);
        }

        public void bind(Book book) {
            ivCover.setImageResource(book.getCoverResId());
            tvTitle.setText(book.getTitle());
            tvAuthor.setText(book.getAuthor());
            ratingBar.setRating(book.getRating());
            tvRating.setText(String.valueOf(book.getRating()));
            tvPrice.setText(book.getPrice());
        }
    }
}
