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

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float startAngle = 0;
    private float lineAngle;       // 当前扇形一半的角度

    private float lineStartX = 0f; // 直线开始的X坐标
    private float lineStartY = 0f; // 直线开始的Y坐标
    private float lineEndX;        // 直线结束的X坐标
    private float lineEndY;        // 直线结束的Y坐标
    private float space = 2.5f;
    private float total;
    private float totalSpace;
    private float realTotal;
    private float textSize = 30;
    private float radius = 300f;
    private RectF rectF = new RectF(-radius,-radius,radius,radius);
    private Path mPath = new Path();

    private ArrayList<VersionBean> list = new ArrayList<>();
    private void init(){
        list.add(new VersionBean("Froyo","Froyo",0.1f, Color.WHITE));
        list.add(new VersionBean("Gingerbread","GB",2f, Color.MAGENTA));
        list.add(new VersionBean("Ice Cream Sandwich","ICS",1.5f, Color.GRAY));
        list.add(new VersionBean("Jelly Bean","JB",16, Color.GREEN));
        list.add(new VersionBean("KitKat","KitKat",30, Color.BLUE));
        list.add(new VersionBean("Lollipop","LP",36f, Color.RED));
        list.add(new VersionBean("Marshmallow","MM",14.4f, Color.YELLOW));
        list.get(5).isChecked = true;
        for (VersionBean vd : list) {
            total += vd.number;
        }
        totalSpace = space * list.size();
        realTotal = 360 - totalSpace;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        //将（0,0）位置移到画布中心
        canvas.translate((float) getWidth()/2-100,(float)getHeight()/2);
        //起始角度要重置，否则从后台切回来的角度会继续累加，导致显示异常
        startAngle = 0;
        for (int i = 0; i < list.size(); i++) {
            VersionBean versionBean = list.get(i);
            versionBean.realAngle = versionBean.number / total * realTotal;
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(versionBean.color);
            lineAngle = startAngle + versionBean.realAngle / 2;
            lineStartX = radius * (float) Math.cos(lineAngle / 180 * Math.PI);
            lineStartY = radius * (float) Math.sin(lineAngle / 180 * Math.PI);
            lineEndX = (radius + 30) * (float) Math.cos(lineAngle / 180 * Math.PI);
            lineEndY = (radius + 30) * (float) Math.sin(lineAngle / 180 * Math.PI);
            if (versionBean.isChecked){
                canvas.save();
                canvas.translate(lineStartX*0.1f,lineStartY*0.1f);
                canvas.drawArc(rectF,startAngle,versionBean.realAngle,true,mPaint);
                canvas.restore(); //原点平移后要及时还原
            }else {
                canvas.drawArc(rectF,startAngle,versionBean.realAngle,true,mPaint);
            }
            mPaint.setColor(Color.LTGRAY);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(4);
            mPaint.setTextSize(textSize);
            if (versionBean.isChecked){
                canvas.drawLine(lineStartX*1.1f, lineStartY*1.1f, lineEndX*1.1f, lineEndY*1.1f, mPaint);
                if (lineAngle > 90 && lineAngle <= 270){
                    mPath.moveTo(lineEndX*1.1f,lineEndY*1.1f);
                    mPath.rLineTo(-50,0);
                    canvas.drawPath(mPath,mPaint);
                    mPaint.setStrokeWidth(0);
                    mPaint.setColor(versionBean.color);
                    canvas.drawText(versionBean.name+" "+versionBean.number,lineEndX*1.1f-60-mPaint.measureText(versionBean.name+" "+versionBean.number),lineEndY*1.1f+textSize/5*2,mPaint);
                }else {
                    mPath.moveTo(lineEndX*1.1f,lineEndY*1.1f);
                    mPath.rLineTo(50,0);
                    canvas.drawPath(mPath,mPaint);
                    mPaint.setStrokeWidth(0);
                    mPaint.setColor(versionBean.color);
                    canvas.drawText(versionBean.name+" "+versionBean.number,lineEndX*1.1f+60,lineEndY*1.1f+textSize/5*2,mPaint);
                }


            }else {
                canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, mPaint);
                if (lineAngle > 90 && lineAngle <= 270){
                    mPath.moveTo(lineEndX,lineEndY);
                    mPath.rLineTo(-50,0);
                    canvas.drawPath(mPath,mPaint);
                    mPaint.setStrokeWidth(0);
                    mPaint.setColor(versionBean.color);
                    canvas.drawText(versionBean.name+" "+versionBean.number,lineEndX-60-mPaint.measureText(versionBean.name+" "+versionBean.number),lineEndY+textSize/5*2,mPaint);
                }else {
                    mPath.moveTo(lineEndX,lineEndY);
                    mPath.rLineTo(50,0);
                    canvas.drawPath(mPath,mPaint);
                    mPaint.setStrokeWidth(0);
                    mPaint.setColor(versionBean.color);
                    canvas.drawText(versionBean.name+" "+versionBean.number,lineEndX+60,lineEndY+textSize/5*2,mPaint);
                }

            }

            startAngle += versionBean.realAngle+space;

        }
    }
}
