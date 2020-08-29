package com.example.uireplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.uireplication.Adapter.ImageAdapter;
import com.example.uireplication.Fragments.Book;
import com.example.uireplication.Fragments.Start;

public class Movie1 extends AppCompatActivity {

    private LinearLayout dotsLayout;
    private ImageView[] ivArrayDotsPager;
    ViewPager viewPager;
    ImageAdapter startAdapter;
    Button button;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie1);
        cardView=findViewById(R.id.cardd);
        cardView.setBackgroundResource(R.drawable.round);

        dotsLayout = findViewById(R.id.pager_dots1);


        startAdapter = new ImageAdapter(this);
        viewPager = findViewById(R.id.viewpager1);
        viewPager.setPageTransformer(true,new Pager());
        viewPager.setAdapter(startAdapter);
        viewPager.setPadding(100,0,100,0);
        setupPagerIndidcatorDots();
        ivArrayDotsPager[0].setImageResource(R.drawable.seleted_dot);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                for (int i = 0; i < ivArrayDotsPager.length; i++) {
                    ivArrayDotsPager[i].setImageResource(R.drawable.default_dot);
                }
                ivArrayDotsPager[position].setImageResource(R.drawable.seleted_dot);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        button=findViewById(R.id.buttonm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment= new Book();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.setCustomAnimations(R.anim.fadein,
                        R.anim.fadeout);
                ft.replace(R.id.frame1, fragment);
                ft.commit();
            }
        });
    }
    private void setupPagerIndidcatorDots() {
        ivArrayDotsPager = new ImageView[3];
        for (int i = 0; i < ivArrayDotsPager.length; i++) {
            ivArrayDotsPager[i] = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 0, 5, 0);
            ivArrayDotsPager[i].setLayoutParams(params);
            ivArrayDotsPager[i].setImageResource(R.drawable.default_dot);
            //ivArrayDotsPager[i].setAlpha(0.4f);
            ivArrayDotsPager[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setAlpha(1);
                }
            });
            dotsLayout.addView(ivArrayDotsPager[i]);
            dotsLayout.bringToFront();
        }
    }

    private class Pager implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        @Override
        public void transformPage(@NonNull final View view, float position) {




            Log.w("asd","FRT "+position);
            if (position < 0) { //[-infinity,1)
                //off to the left by a lot
                view.setRotationY(-10);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        view.setRotationY(0);
                    }
                }, 50);

            } else { //[-1,1]
                 //shift the view over
                view.setRotationY(0); //rotate it
                 //rotate it
                // Fade the page relative to its distance from the center

            }
        }
    }
}