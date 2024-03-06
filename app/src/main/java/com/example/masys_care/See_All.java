package com.example.masys_care;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

public class See_All extends AppCompatActivity {

    private String[] imageurls = new String[]{
            "https://media.licdn.com/dms/image/D4D22AQEhWO3cj0xblg/feedshare-shrink_800/0/1705061862875?e=1709164800&v=beta&t=AOYrhxICI-o0QZEmLuvFgEUHgzk_an7A48mwnSmGGuE",
            "https://media.licdn.com/dms/image/D4D22AQGW3V7t_DG34Q/feedshare-shrink_800/0/1704523990803?e=1709164800&v=beta&t=zK4l5NOn4AZKKlea8tpkXNPcr-FKclamxRKGnWq6Ye0",
            "https://www.masyseducare.com/App_Assets/assets/images/about/about_1nw.png",
            "https://media.licdn.com/dms/image/D4D22AQEMPvKzxX9HQQ/feedshare-shrink_800/0/1704460658164?e=1709164800&v=beta&t=Mr5epDLBCnyqTz58kk-B8SbZRXkgr-cqwWrWd0ULtRc",
            "https://media.licdn.com/dms/image/D4D22AQF5xfetpYpRiw/feedshare-shrink_800/0/1704892409353?e=1709164800&v=beta&t=o3N5hl7tkoNGfpMiO6b6YPV0W3sd7OHS_0-1A4tCr80",
            "https://media.licdn.com/dms/image/D4D22AQFzh55DxASJKA/feedshare-shrink_800/0/1703766897759?e=1709164800&v=beta&t=CDSJdMb3ke-SN8i4x6Y9Jao4J-KlHErKg1evJjdnOxY"
    };

    private ViewPager viewPager;
    private int currentPage = 0;
    private final int DELAY_MS = 2000;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_all);

        viewPager = findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageurls);
        viewPager.setAdapter(adapter);

        CardView backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                Intent intent = new Intent(See_All.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        startAutoSlider();
    }

    private void startAutoSlider() {
        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == imageurls.length) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
                handler.postDelayed(this, 3000);
            }
        };

        handler.postDelayed(update, 3000);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
