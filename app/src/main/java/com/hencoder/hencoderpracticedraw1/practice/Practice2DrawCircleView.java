package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

    private Paint mPaint;
    public Practice2DrawCircleView(Context context) {
        super(context);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(getWidth()/2-200-40,220,200,mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);
        canvas.drawCircle(getWidth()/2+40+200,220,200,mPaint);

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(getWidth()/2-200-40,400+60+200,200,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#28d19d"));
        canvas.drawCircle(getWidth()/2+200+40,400+60+200,200,mPaint);

        //由此可见，描边会增大圆的半径，新的半径=旧圆半径+StrokeWidth/2
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor("#55000000"));
        mPaint.setStrokeWidth(60);
        canvas.drawCircle(getWidth()/2+200+40,400+60+200,200,mPaint);

    }
}
