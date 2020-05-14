package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF re = new RectF();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        float length = (float) getWidth() / 3 ;
        mPaint.setColor(Color.BLACK);
        re.left = length;
        re.top = length;
        re.right = length * 2;
        re.bottom = length + 200;
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(re,-110,100,true,mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(re,-180,60,false,mPaint);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(re,20,140,false,mPaint);
    }
}
