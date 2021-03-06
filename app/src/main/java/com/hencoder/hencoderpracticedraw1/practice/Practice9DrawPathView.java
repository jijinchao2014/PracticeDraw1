package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();
    private RectF re = new RectF();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        float length = (float) getWidth() / 2 - 120 ;
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        re.left = length;
        re.top = length-100;
        re.right = length + 120;
        re.bottom = length + 20;
        mPath.addArc(re,-225,225);
//        canvas.drawPath(mPath,mPaint);
        re.left = length + 120;
        re.top = length-100;
        re.right = length + 240;
        re.bottom = length + 20;
        mPath.arcTo(re,180,225);
//        canvas.drawPath(mPath,mPaint);
        mPath.lineTo(length+120,length+100);
//        mPath.close();
        canvas.drawPath(mPath,mPaint);

    }
}
