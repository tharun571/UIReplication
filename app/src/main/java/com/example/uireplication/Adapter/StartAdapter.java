package com.example.uireplication.Adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;

import com.example.uireplication.Fragments.Movie;
import com.example.uireplication.Fragments.Start;
import com.example.uireplication.MainActivity;
import com.example.uireplication.Movie1;
import com.example.uireplication.R;

public class StartAdapter extends PagerAdapter {

    LayoutInflater layoutInflater;
    Context context;

    public StartAdapter(Context c ){
        this.context=c;
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    View view;
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=LayoutInflater.from(context);
         view=layoutInflater.inflate(R.layout.item_start,container,false);

        container.addView(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CardView cardView=v.findViewById(R.id.infocard1);
                CardView cardView1=v.findViewById(R.id.imagecard1);
                TextView t1=v.findViewById(R.id.title);
                TextView t2=v.findViewById(R.id.lol);
                TextView t3=v.findViewById(R.id.lol1);
                TextView t4=v.findViewById(R.id.lol2);
                TextView t5=v.findViewById(R.id.story);

                Pair[] pairs=new Pair[2];
                pairs[0] = new Pair<CardView,String>(cardView1,"imagecard");
                pairs[1] = new Pair<CardView,String>(cardView,"infocard");


                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(((MainActivity)context),pairs);
                    Intent intent=new Intent(context, Movie1.class);
                    ((MainActivity)context).startActivity(intent,options.toBundle());
                    ((MainActivity)context).overridePendingTransition(R.anim.fadein, R.anim.fadeout);

                }




            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
