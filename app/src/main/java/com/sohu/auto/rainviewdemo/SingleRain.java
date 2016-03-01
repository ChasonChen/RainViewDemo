package com.sohu.auto.rainviewdemo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by ChenXingchao on 16/3/1.
 */
public class SingleRain {

    private Random mRandom;
    private float mWidth, mHeight;
    private float mStartX, mStartY;
    private float mStopX, mStopY;
    private float mDropXSize, mDropYSize;
    private Paint mPaint;

    public SingleRain(float width, float height) {
        this.mWidth = width;
        this.mHeight = height;
        init();
    }

    private void init() {
        mRandom = new Random();
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(5);

        mStartX = mRandom.nextInt((int) mWidth);
        mStartY = mRandom.nextInt((int) mHeight);

        mDropXSize = 1 + mRandom.nextInt(50);
        mDropYSize = mDropXSize + mRandom.nextInt(30);

        mStopX = mStartX + mDropXSize;
        mStopY = mStartY + mDropYSize;
    }

    public void move() {

        float opt = 0.5f;

        mStartX += mDropXSize * opt;
        mStopX += mDropXSize * opt;

        mStartY += mDropYSize * opt;
        mStopY += mDropYSize * opt;

        if (mStartY > mHeight) {
            init();
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawLine(mStartX, mStartY, mStopX, mStopY, mPaint);
    }
}
