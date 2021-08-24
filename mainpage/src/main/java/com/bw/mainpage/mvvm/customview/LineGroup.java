package com.bw.mainpage.mvvm.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * @ClassName LineGroup
 * @Author 孔晨亮
 * @Date 2021/8/19 13:44
 * User: msi
 */
public class LineGroup extends ViewGroup {
    int groupWidth,groupHeight;
    public LineGroup(Context context) {
        super(context);
    }

    public LineGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private int defaultWidth;
    private int defaultHeight;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int mode = MeasureSpec.getMode(widthMeasureSpec);
//        int size = MeasureSpec.getSize(widthMeasureSpec);
//        switch (mode){
//            case MeasureSpec.EXACTLY:
//                groupWidth =size;
//                break;
//            case MeasureSpec.AT_MOST:
//                groupWidth=500;
//                break;
//        }
//        int mode1 = MeasureSpec.getMode(heightMeasureSpec);
//        int size1 = MeasureSpec.getSize(heightMeasureSpec);
//
//        switch (mode1){
//            case MeasureSpec.EXACTLY:
//                groupWidth =size1;
//                break;
//            case MeasureSpec.AT_MOST:
//                groupWidth=500;
//                break;
//        }
//        setMeasuredDimension(groupWidth,groupHeight);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();

        // C、用于记录单行的动态宽和高
        int lineWidth = 0;
        int lineHeight = 0;

        // D、根据内容决定的动态宽和高
        int contentWidth = 0;
        int contentHeight = 0;

        for(int i = 0; i < getChildCount(); i ++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility()==View.GONE){
                continue;
            }
            measureChild(childAt,widthMeasureSpec,heightMeasureSpec);

            MarginLayoutParams  childAtLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            int childWidth = childAtLayoutParams.leftMargin + childAt.getMeasuredWidth() + childAtLayoutParams.rightMargin;
            int childHeight = childAtLayoutParams.topMargin + childAt.getMeasuredHeight() + childAtLayoutParams.bottomMargin;

            if (lineWidth+childWidth>sizeWidth-paddingLeft-paddingRight){
                contentWidth = Math.max(contentWidth, lineWidth);
                contentHeight+=lineHeight;

                lineWidth=0;
                lineHeight=0;
            }
            lineWidth+=childWidth;
            lineHeight = Math.max(lineHeight, childHeight);

            if (i==getChildCount()-1){
                contentWidth = Math.max(contentWidth, lineWidth);
                contentHeight+=lineHeight;
            }
        }
        contentWidth+=(paddingLeft+paddingRight);
        contentHeight+=(paddingTop+paddingBottom);

        if (contentWidth>sizeWidth){
            contentWidth=sizeWidth;
        }
        if (contentHeight>sizeHeight){
            contentHeight=sizeHeight;
        }

        if (modeWidth==MeasureSpec.AT_MOST&&modeHeight==MeasureSpec.AT_MOST){
            setMeasuredDimension(contentWidth,contentHeight);
        }else if (modeWidth==MeasureSpec.AT_MOST){
            setMeasuredDimension(contentWidth,sizeHeight);
        }else if (modeHeight==MeasureSpec.AT_MOST){
            setMeasuredDimension(sizeWidth,contentHeight);
        }
    }


    public void addViews(String msg){
//        LayoutParams layoutParams = this.getLayoutParams();
//        layoutParams.height=LayoutParams.WRAP_CONTENT;
//        layoutParams.width=LayoutParams.WRAP_CONTENT;

        LayoutParams layoutParams= new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        LayoutParams  layoutParams = (MarginLayoutParams) getLayoutParams();
        MyBtnView myBtnView = new MyBtnView(getContext());
        myBtnView.setLayoutParams(layoutParams);
        myBtnView.setText(msg);

        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        addView(myBtnView,layoutParams);



    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        int childCountWidth = 0;
//        int left=0;
//        int childCount = getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            View childAt = getChildAt(i);
//            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
//            childCountWidth +=layoutParams.width;
//
//            int width = getWidth();
//            if (width>childCountWidth){
//                childAt.layout(left,0,layoutParams.width+left,layoutParams.height);
//                left+=layoutParams.width;
//            }else {
//                childAt.layout(0,layoutParams.height,layoutParams.width,layoutParams.height*2);
//            }
//        }
        int paddingLeftSize = getPaddingLeft();
        int paddingRightSize = getPaddingRight();
        int paddingTopSize = getPaddingTop();

        // 开始的坐标
        int startLeft = 0;
        int startTop = 0;

        // 用于记录单行的高
        int lineHeight = 0;

        for (int i=0;i<getChildCount();i++){
            View childAt = getChildAt(i);
            if (childAt.getVisibility()==GONE){
                continue;
            }
            MarginLayoutParams  childAtLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            int childWidth = childAtLayoutParams.leftMargin + childAt.getMeasuredWidth() + childAtLayoutParams.rightMargin;
            int childHeight = childAtLayoutParams.topMargin + childAt.getMeasuredHeight() + childAtLayoutParams.bottomMargin;

            if (startLeft+childWidth>getWidth()-paddingLeftSize-paddingRightSize){
                startLeft=0;
                startTop+=lineHeight;
                lineHeight=0;
            }

            // 子View的layout
            int childLeft = paddingLeftSize + startLeft +childAtLayoutParams.leftMargin;
            int chileTop = paddingTopSize + startTop +childAtLayoutParams.topMargin;
            int chileRight = childLeft + childAt.getMeasuredWidth();
            int chileBottom = chileTop + childAt.getMeasuredHeight();
            childAt.layout(childLeft, chileTop, chileRight, chileBottom);

            // 更新开始左坐标
            startLeft += childWidth;

            // 更新行高
            lineHeight = Math.max(lineHeight, childHeight);


        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }
}
