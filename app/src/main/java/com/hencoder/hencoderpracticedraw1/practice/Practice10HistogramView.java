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

import java.util.ArrayList;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();
    private Path mLinePath = new Path();
    private RectF re = new RectF();
    private ArrayList<VersionBean> list = new ArrayList<>();
    {
        list.add(new VersionBean("Froyo","Froyo",1));
        list.add(new VersionBean("Gingerbread","GB",4));
        list.add(new VersionBean("Ice Cream Sandwich","ICS",3));
        list.add(new VersionBean("Jelly Bean","JB",20));
        list.add(new VersionBean("KitKat","KitKat",26));
        list.add(new VersionBean("Lollipop","LP",32));
        list.add(new VersionBean("Marshmallow","MM",14));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        //画线
        float width =getWidth()-300;
        //1%的高度
        float Dh = (float) (600-150)/100 * 2;
        int count = list.size();
        float Dd = 15;
        float Dx = (width - ((count+1) * Dd))/count;

        mLinePaint.setColor(Color.WHITE);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(2);
        mLinePath.moveTo(150,150);
        mLinePath.lineTo(150,600);
        mLinePath.rLineTo(width,0);
        canvas.drawPath(mLinePath,mLinePaint);


        mPaint.setTextSize(14);
        for (int i = 0; i < list.size(); i++) {
            VersionBean versionBean = list.get(i);
            re.left = 150 + Dd*(i+1) + Dx * i;
            re.top = 600 - versionBean.number * Dh;
            re.right = re.left + Dx;
            re.bottom = 600-1;
            mPath.addRect(re, Path.Direction.CW);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setStrokeWidth(0);
            mPaint.setColor(Color.BLACK);//Color.parseColor("#28d19d"));
            canvas.drawPath(mPath,mPaint);
            mPaint.setColor(Color.WHITE);
            mPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(versionBean.name,re.left+(Dx/2),615,mPaint);
        }


    }
}
