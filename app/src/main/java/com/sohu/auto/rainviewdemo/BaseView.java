package com.sohu.auto.rainviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ChenXingchao on 16/3/1.
 */
public abstract class BaseView extends View {

    private boolean isRun = true;
    private ThreadU mThreadU;

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDetachedFromWindow() {
        isRun = false;
        super.onDetachedFromWindow();
    }

    protected abstract void init();

    protected abstract void runView();

    protected abstract void drawOnCanvas(Canvas canvas);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (null == mThreadU){
            mThreadU = new ThreadU();
            mThreadU.start();
        }else {
            drawOnCanvas(canvas);
        }
    }

    private class ThreadU extends Thread{

        @Override
        public void run() {
            init();
            while (isRun){
                runView();
                postInvalidate();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
