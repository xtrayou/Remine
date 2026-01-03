package com.remine.elibrary.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;
import com.remine.elibrary.R;
import com.remine.elibrary.models.Book;
import com.remine.elibrary.utils.BookData;

public class BookDetailActivity extends AppCompatActivity {

    private ImageView ivBack;
    private ImageView ivCover;
    private TextView tvTitle;
    private TextView tvAuthor;
    private RatingBar ratingBar;
    private TextView tvRating;
    private TextView tvPrice;
    private TabLayout tabLayout;
    private TextView tvDescription;
    private Button btnReadNow;

    private Book currentBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        initViews();
        loadBookData();
        setupListeners();
    }

    private void initViews() {
        ivBack = findViewById(R.id.ivBack);
        ivCover = findViewById(R.id.ivBookCover);
        tvTitle = findViewById(R.id.tvBookTitle);
        tvAuthor = findViewById(R.id.tvBookAuthor);
        ratingBar = findViewById(R.id.ratingBar);
        tvRating = findViewById(R.id.tvRating);
        tvPrice = findViewById(R.id.tvPrice);
        tabLayout = findViewById(R.id.tabLayout);
        tvDescription = findViewById(R.id.tvDescription);
        btnReadNow = findViewById(R.id.btnReadNow);
    }

    private void loadBookData() {
        int bookId = getIntent().getIntExtra("book_id", 1);
        currentBook = BookData.getBookById(bookId);

        if (currentBook != null) {
            ivCover.setImageResource(currentBook.getCoverResId());
            tvTitle.setText(currentBook.getTitle());
            tvAuthor.setText(currentBook.getAuthor());
            ratingBar.setRating(currentBook.getRating());
            tvRating.setText(String.valueOf(currentBook.getRating()));
            tvPrice.setText(currentBook.getPrice());
            tvDescription.setText(currentBook.getDescription());
        }
    }

    private void setupListeners() {
        ivBack.setOnClickListener(v -> finish());

        btnReadNow.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReadingActivity.class);
            intent.putExtra("book_id", currentBook.getId());
            startActivity(intent);
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    tvDescription.setText(currentBook.getDescription());
                } else {
                    tvDescription.setText("No reviews yet. Be the first to review this book!");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}
