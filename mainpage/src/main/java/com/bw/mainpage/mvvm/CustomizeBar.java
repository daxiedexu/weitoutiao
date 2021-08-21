package com.bw.mainpage.mvvm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @ClassName CustomizeBar
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/8/20 13:58
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public class CustomizeBar extends androidx.appcompat.widget.AppCompatEditText {

    public CustomizeBar(Context context) {
        super(context);
        init();
    }

    public CustomizeBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomizeBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    Paint paintText;


    private void init() {

//        this.setBackground(getResources().getDrawable(R.drawable.backgrount_y));
//        paintText=new Paint( );

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 文字居中
         *         Paint.FontMetrics fontMetrics=paintText.getFontMetrics();
         *         float distance=(fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
         *         float baseline=this.getPivotY()+distance;
         *         canvas.drawText("微头条", this.getPivotX(), baseline,paintText);
         */

//        Bitmap bitmap=BitmapFactory.decodeResource(getResources( ), R.drawable.ss32);
//        canvas.drawBitmap(bitmap,0,5,paintText);

    }
}
