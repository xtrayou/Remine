package com.remine.elibrary.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.remine.elibrary.R;
import com.remine.elibrary.adapters.OnboardingAdapter;
import com.remine.elibrary.models.OnboardingItem;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private LinearLayout indicatorsContainer;
    private Button btnNext;
    private Button btnGetStarted;
    private TextView tvSkip;
    private OnboardingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        initViews();
        setupOnboardingItems();
        setupIndicators();
        setCurrentIndicator(0);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
                updateButtons(position);
            }
        });

        btnNext.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() + 1 < adapter.getItemCount()) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });

        btnGetStarted.setOnClickListener(v -> finishOnboarding());
        tvSkip.setOnClickListener(v -> finishOnboarding());
    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPagerOnboarding);
        indicatorsContainer = findViewById(R.id.indicatorsContainer);
        btnNext = findViewById(R.id.btnNext);
        btnGetStarted = findViewById(R.id.btnGetStarted);
        tvSkip = findViewById(R.id.tvSkip);
    }

    private void setupOnboardingItems() {
        List<OnboardingItem> items = new ArrayList<>();

        items.add(new OnboardingItem(
                R.drawable.onboarding_1,
                "Only Books Can Help You",
                "Books can help you to increase your knowledge and become more successfully."
        ));

        items.add(new OnboardingItem(
                R.drawable.onboarding_2,
                "Learn Smartly",
                "It's 2026 and it's time to learn every quickly and smartly. All books are storage in cloud and you can access all of them from your laptop or PC."
        ));

        items.add(new OnboardingItem(
                R.drawable.onboarding_3,
                "Book Has Power To Change Everything",
                "We have true friend in our life and the books is that. Book has power to change yourself and make you more valuable."
        ));

        adapter = new OnboardingAdapter(items);
        viewPager.setAdapter(adapter);
    }

    private void setupIndicators() {
        ImageView[] indicators = new ImageView[adapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8, 0, 8, 0);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageResource(R.drawable.indicator_inactive);
            indicators[i].setLayoutParams(layoutParams);
            indicatorsContainer.addView(indicators[i]);
        }
    }

    private void setCurrentIndicator(int index) {
        int childCount = indicatorsContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) indicatorsContainer.getChildAt(i);
            if (i == index) {
                imageView.setImageResource(R.drawable.indicator_active);
            } else {
                imageView.setImageResource(R.drawable.indicator_inactive);
            }
        }
    }

    private void updateButtons(int position) {
        if (position == adapter.getItemCount() - 1) {
            btnNext.setVisibility(View.GONE);
            btnGetStarted.setVisibility(View.VISIBLE);
            tvSkip.setVisibility(View.GONE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
            btnGetStarted.setVisibility(View.GONE);
            tvSkip.setVisibility(View.VISIBLE);
        }
    }

    private void finishOnboarding() {
        SharedPreferences prefs = getSharedPreferences("ReminePrefs", MODE_PRIVATE);
        prefs.edit().putBoolean("onboardingCompleted", true).apply();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
