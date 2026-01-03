package com.remine.elibrary.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.remine.elibrary.R;
import com.remine.elibrary.adapters.BookAdapter;
import com.remine.elibrary.adapters.PopularBookAdapter;
import com.remine.elibrary.adapters.NewsAdapter;
import com.remine.elibrary.models.Book;
import com.remine.elibrary.models.News;
import com.remine.elibrary.utils.BookData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookAdapter.OnBookClickListener, PopularBookAdapter.OnBookClickListener {

    private DrawerLayout drawerLayout;
    private RecyclerView rvRecommended;
    private RecyclerView rvPopular;
    private RecyclerView rvNews;
    private EditText etSearch;
    private ImageView ivMenu;
    private View featuredBook;

    private BookAdapter recommendedAdapter;
    private PopularBookAdapter popularAdapter;
    private NewsAdapter newsAdapter;

    private List<Book> allBooks;
    private List<Book> filteredBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupDrawer();
        setupRecyclerViews();
        setupSearch();
        setupFeaturedBook();
        setupBottomNavigation();
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.drawerLayout);
        rvRecommended = findViewById(R.id.rvRecommended);
        rvPopular = findViewById(R.id.rvPopular);
        rvNews = findViewById(R.id.rvNews);
        etSearch = findViewById(R.id.etSearch);
        ivMenu = findViewById(R.id.ivMenu);
        featuredBook = findViewById(R.id.featuredBookCard);
    }

    private void setupDrawer() {
        ivMenu.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
                drawerLayout.closeDrawer(GravityCompat.END);
            } else {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                // Already on home
            } else if (id == R.id.nav_mybooks) {
                // Navigate to My Books
            } else if (id == R.id.nav_favorites) {
                // Navigate to Favorites
            } else if (id == R.id.nav_downloads) {
                // Navigate to Downloads
            } else if (id == R.id.nav_settings) {
                // Navigate to Settings
            } else if (id == R.id.nav_about) {
                // Navigate to About
            } else if (id == R.id.nav_logout) {
                // Logout
            }
            drawerLayout.closeDrawer(GravityCompat.END);
            return true;
        });
    }

    private void setupRecyclerViews() {
        allBooks = BookData.getBooks();
        filteredBooks = new ArrayList<>(allBooks);

        // Recommended Books (Horizontal)
        recommendedAdapter = new BookAdapter(filteredBooks.subList(0, Math.min(5, filteredBooks.size())), this);
        rvRecommended.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvRecommended.setAdapter(recommendedAdapter);

        // Popular Books (Vertical)
        popularAdapter = new PopularBookAdapter(filteredBooks.subList(3, Math.min(8, filteredBooks.size())), this);
        rvPopular.setLayoutManager(new LinearLayoutManager(this));
        rvPopular.setAdapter(popularAdapter);
        rvPopular.setNestedScrollingEnabled(false);

        // News
        List<News> newsList = BookData.getNews();
        newsAdapter = new NewsAdapter(newsList);
        rvNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvNews.setAdapter(newsAdapter);
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterBooks(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filterBooks(String query) {
        filteredBooks.clear();
        if (query.isEmpty()) {
            filteredBooks.addAll(allBooks);
        } else {
            for (Book book : allBooks) {
                if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                    filteredBooks.add(book);
                }
            }
        }
        popularAdapter.updateBooks(filteredBooks);
    }

    private void setupFeaturedBook() {
        Book featured = allBooks.get(0);
        
        TextView tvTitle = featuredBook.findViewById(R.id.tvFeaturedTitle);
        TextView tvAuthor = featuredBook.findViewById(R.id.tvFeaturedAuthor);
        ImageView ivCover = featuredBook.findViewById(R.id.ivFeaturedCover);

        tvTitle.setText(featured.getTitle());
        tvAuthor.setText(featured.getAuthor());
        ivCover.setImageResource(featured.getCoverResId());

        featuredBook.setOnClickListener(v -> openBookDetail(featured));
        
        View btnReadNow = featuredBook.findViewById(R.id.btnFeaturedRead);
        btnReadNow.setOnClickListener(v -> openBookDetail(featured));
    }

    private void setupBottomNavigation() {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_bottom_home) {
                return true;
            } else if (id == R.id.nav_bottom_library) {
                // Navigate to Library
                return true;
            } else if (id == R.id.nav_bottom_favorites) {
                // Navigate to Favorites
                return true;
            } else if (id == R.id.nav_bottom_profile) {
                // Navigate to Profile
                return true;
            }
            return false;
        });
    }

    @Override
    public void onBookClick(Book book) {
        openBookDetail(book);
    }

    private void openBookDetail(Book book) {
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.putExtra("book_id", book.getId());
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }
}
