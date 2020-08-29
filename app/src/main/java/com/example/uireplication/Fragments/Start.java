package com.example.uireplication.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.uireplication.Adapter.StartAdapter;
import com.example.uireplication.R;
import com.google.android.material.tabs.TabLayout;


public class Start extends Fragment {

    ViewPager viewPager;
    StartAdapter startAdapter;
    Integer[] colors = null;
    private LinearLayout dotsLayout;
    private ImageView[] ivArrayDotsPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start, container, false);


        dotsLayout = view.findViewById(R.id.pager_dots);


        startAdapter = new StartAdapter(getContext());
        viewPager = view.findViewById(R.id.viewpager);

        viewPager.setPageTransformer(true,new ViewPagerStack());

        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(startAdapter);
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


        return view;
    }

    private void setupPagerIndidcatorDots() {
        ivArrayDotsPager = new ImageView[3];
        for (int i = 0; i < ivArrayDotsPager.length; i++) {
            ivArrayDotsPager[i] = new ImageView(getActivity());
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

    private class ViewPagerStack implements ViewPager.PageTransformer {
        @Override
        public void transformPage(@NonNull View page, float position) {
            if(position>=0){


                page.setTranslationX(-page.getWidth()*position);
                page.setTranslationY(15*position);
            }
        }
    }
}