package com.gmail.peeman34.eglisaofficial;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kosalgeek.android.json.JsonConverter;

import java.util.ArrayList;

/**
 * Created by pee on 1/19/2016.
 */
public class Swipe extends PagerAdapter {

   private  int[] imageresource ={R.drawable.godwin, R.drawable.kayout,R.drawable.kaypose, R.drawable.mafuasquad, R.drawable.maameserwaa, R.drawable.mafuathinking,R.drawable.mehappy,R.drawable.mewatching};

    private Context ctx;

    private LayoutInflater layoutinflater;

    public Swipe(Context ctx){
        this.ctx = ctx;

    }
    @Override
    public int getCount() {
        return imageresource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view== object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup  container, int position) {
        layoutinflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         View itemview =layoutinflater.inflate(R.layout.swipe, container , false);
        ImageView imageView = (ImageView)itemview.findViewById(R.id.albumlooker);
        TextView Churchphotograph = (TextView)itemview.findViewById(R.id.imagecount);


                       {
                          imageView.setImageResource(imageresource[position]);
                          Churchphotograph.setText("image:" + position);
                          container.addView(itemview);

                          return itemview;

                  }

        // maybe we have to increase the position to maybe position++;

    }
}
