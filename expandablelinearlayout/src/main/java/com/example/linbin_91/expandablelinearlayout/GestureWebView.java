package com.example.linbin_91.expandablelinearlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * Created by linbin_91 on 2015/10/28.
 */
public class GestureWebView extends WebView{

    private  GestureControlCallBack mGestureControlCallBack;
    private  Context context;
    private  float movedDistanceX;
    private  float movedDistanceY;
    private  float lastXMove = -1;
    private  float lastYMove = -1;


    public  interface  GestureControlCallBack{
        public  void  FingerDown();
        public  void  FingerUp();
    }

    public void  setOnGestureChangeListener(GestureControlCallBack listener){
        this.mGestureControlCallBack = listener;
    }

    public GestureWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (this.getContentHeight() * this.getScale() - (this.getHeight() + this.getScrollY()) == 0){
            if (mGestureControlCallBack != null){
                mGestureControlCallBack.FingerDown();
            }
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                lastXMove = event.getX();
                lastYMove = event.getY();
                break;
            case  MotionEvent.ACTION_UP:
                movedDistanceX = event.getX() - lastXMove;
                movedDistanceY = event.getY() - lastYMove;
                float absDistance = Math.abs(movedDistanceX) - Math.abs(movedDistanceY);
                if (absDistance < 0 && movedDistanceY > 0){
                    if (mGestureControlCallBack != null){
                        mGestureControlCallBack.FingerDown();
                    }
                }
                if (absDistance < 0 && movedDistanceY < 0){
                    if (mGestureControlCallBack != null){
                        mGestureControlCallBack.FingerUp();
                    }
                }
                lastXMove = -1;
                lastYMove = -1;
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
