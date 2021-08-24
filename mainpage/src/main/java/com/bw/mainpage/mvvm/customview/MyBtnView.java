package com.bw.mainpage.mvvm.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * @ClassName MyBtnView
 * @Author 孔晨亮
 * @Date 2021/8/19 15:05
 * User: msi
 */
public class MyBtnView extends androidx.appcompat.widget.AppCompatTextView {
    private Paint mPaint;
    private Paint textPaint;
    private Paint xPaint;
    private String arr;
    public boolean ischeck=true;
    private RectF rectF=new RectF();

    public MyBtnView(Context context) {
        super(context);
        initPaint();
        textPaint();
        xPaint();
//        arr= this.getText().toString();

    }

    public MyBtnView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        textPaint();
        xPaint();
//        arr= this.getText().toString();

    }

    public MyBtnView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        textPaint();
        xPaint();
//        arr= this.getText().toString();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                int x = (int) event.getX();
                int y = (int) event.getY();
                if (x>=240){
                    this.setVisibility(GONE);
                }else {
                    if (ischeck){
                        mPaint.setColor(Color.parseColor("#E39A2F"));
                        invalidate();
                        ischeck=false;
                    }else {
                        mPaint.setColor(Color.GRAY);
                        invalidate();
                        ischeck=true;
                    }

                }

                break;
        }
        return true;

    }



    private int defaultWidth=300;
    private int defaultHeight=80;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        if (modeWidth == MeasureSpec.AT_MOST && modeHeight == MeasureSpec.AT_MOST) {
            setMeasuredDimension(defaultWidth, defaultHeight);
        } else if (modeWidth == MeasureSpec.AT_MOST) {
            setMeasuredDimension(defaultWidth, sizeHeight);
        } else if (modeHeight == MeasureSpec.AT_MOST) {
            setMeasuredDimension(sizeWidth, defaultHeight);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
//        canvas.drawRoundRect(0,0,defaultWidth,defaultHeight,30,30,mPaint);
        Paint.FontMetrics fm = textPaint.getFontMetrics();
        rectF.left=0;
        rectF.top=0;
        rectF.right=defaultWidth;
        rectF.bottom=defaultHeight;

        canvas.drawRoundRect(rectF,30,30,mPaint);
//        canvas.drawText(arr,90,60,textPaint);
        canvas.drawText("X",250,60,xPaint);

        canvas.drawText(getText().toString(), rectF.centerX()-15, rectF.centerY()- (fm.descent - (-fm.ascent + fm.descent)/2),textPaint);
    }

    private void initPaint() {

        mPaint=new Paint();
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setDither(true);
        mPaint.setAntiAlias(true);


    }
    private void textPaint() {
        textPaint=new Paint();
        textPaint.setTextSize(50f);
        textPaint.setColor(Color.WHITE);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setDither(true);
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }
    private void xPaint() {
        xPaint=new Paint();
        xPaint.setTextSize(50f);
        xPaint.setColor(Color.WHITE);
        xPaint.setStyle(Paint.Style.FILL);
        xPaint.setDither(true);
        xPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }


}
