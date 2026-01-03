package com.remine.elibrary.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.remine.elibrary.R;
import com.remine.elibrary.models.Book;
import com.remine.elibrary.utils.BookData;

public class ReadingActivity extends AppCompatActivity {

    private ImageView ivBack;
    private TextView tvTitle;
    private TextView tvChapter;
    private TextView tvContent;
    private TextView tvPageInfo;
    private ImageView ivPrevious;
    private ImageView ivNext;

    private Book currentBook;
    private int currentPage = 1;
    private int totalPages = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);

        initViews();
        loadBookData();
        setupListeners();
        loadContent();
    }

    private void initViews() {
        ivBack = findViewById(R.id.ivBack);
        tvTitle = findViewById(R.id.tvReadingTitle);
        tvChapter = findViewById(R.id.tvChapter);
        tvContent = findViewById(R.id.tvContent);
        tvPageInfo = findViewById(R.id.tvPageInfo);
        ivPrevious = findViewById(R.id.ivPrevious);
        ivNext = findViewById(R.id.ivNext);
    }

    private void loadBookData() {
        int bookId = getIntent().getIntExtra("book_id", 1);
        currentBook = BookData.getBookById(bookId);

        if (currentBook != null) {
            tvTitle.setText(currentBook.getTitle());
        }
    }

    private void setupListeners() {
        ivBack.setOnClickListener(v -> finish());

        ivPrevious.setOnClickListener(v -> {
            if (currentPage > 1) {
                currentPage--;
                loadContent();
            }
        });

        ivNext.setOnClickListener(v -> {
            if (currentPage < totalPages) {
                currentPage++;
                loadContent();
            }
        });
    }

    private void loadContent() {
        tvChapter.setText("Chapter " + currentPage);
        tvPageInfo.setText("Page " + currentPage + " of " + totalPages);

        // Sample content - in real app, this would come from database/API
        String content = "Chapter " + currentPage + "\n\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n\n" +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n\n" +
                "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, " +
                "totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.\n\n" +
                "Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, " +
                "sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.";

        tvContent.setText(content);
    }
}
