package com.bw.common;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;


public class GlidUtils {
    public GlidUtils() {
    }
    private static GlidUtils glidUtils;


    public static GlidUtils getGlidUtils() {
        glidUtils = new GlidUtils();
        return glidUtils;
    }

    public void Glideimg(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).placeholder(R.drawable.ic_launcher_background).error(R.drawable.rubbish).into(imageView);
    }
    public void GlideCircle(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).transform(new CircleCrop()).into(imageView);
    }
    public void GlideRounded(Context context, String url, ImageView imageView,int arr){

        Glide.with(context).load(url).transform(new RoundedCorners(arr)).into(imageView);
    }
}
