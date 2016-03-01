package com.sohu.auto.rainviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenXingchao on 16/3/1.
 */
public class RainView extends BaseView {

    private List<SingleRain> mSingleRains;
    private int rainsNum = 600;

    public RainView(Context context) {
        super(context);
    }

    public RainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RainView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init() {
        mSingleRains = new ArrayList<>();
        for (int i = 0; i< rainsNum;i++){
            mSingleRains.add(new SingleRain(getWidth(),getHeight()));
        }
    }

    @Override
    protected void runView() {
        for (SingleRain singleRain:mSingleRains){
            singleRain.move();
        }
    }

    @Override
    protected void drawOnCanvas(Canvas canvas) {
        for (SingleRain singleRain:mSingleRains){
            singleRain.draw(canvas);
        }
    }
}
