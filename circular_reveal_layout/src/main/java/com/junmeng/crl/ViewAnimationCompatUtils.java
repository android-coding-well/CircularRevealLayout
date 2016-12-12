package com.junmeng.crl;

import android.animation.Animator;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;

/**
 * Created by HWJ on 2016/12/2.
 */

public class ViewAnimationCompatUtils {

    private static final String TAG = "ViewAnimationCompatUtil";
    public static Animator createCircularReveal(@NonNull View view, int centerX, int centerY, float startRadius, float endRadius) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return ViewAnimationUtils.createCircularReveal(view,centerX,centerY,startRadius,endRadius);
        }

        if(view==null){
            return null;
        }

        //如果父view已经是CircularRevealLayout，则设置参数后直接返回animator
        if(view.getParent()!=null&&view.getParent() instanceof CircularRevealLayout){
            Log.e(TAG,"parent is CircularRevealLayout");
            CircularRevealLayout circularRevealLayout=(CircularRevealLayout)view.getParent();
            circularRevealLayout.setCenterX(centerX);
            circularRevealLayout.setCenterY(centerY);
            circularRevealLayout.setStartRadius(startRadius);
            circularRevealLayout.setEndRadius(endRadius);
            circularRevealLayout.setChildRevealView(view);
            return circularRevealLayout.getAnimator();
        }

        Log.e(TAG,"parent is not CircularRevealLayout");

        //如果父view不是CircularRevealLayout，则先为view添加父view CircularRevealLayout
        //之后将CircularRevealLayout替换掉原来的view
        CircularRevealLayout circularRevealLayout =new CircularRevealLayout(view.getContext());

        if(Build.VERSION.SDK_INT>=11){
            //开启硬件加速
            circularRevealLayout.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        circularRevealLayout.setCenterX(centerX);
        circularRevealLayout.setCenterY(centerY);
        circularRevealLayout.setStartRadius(startRadius);
        circularRevealLayout.setEndRadius(endRadius);
        circularRevealLayout.setChildRevealView(view);

        ViewGroup.LayoutParams params = view.getLayoutParams();
        ViewGroup parent = (ViewGroup) view.getParent();

        int index=0;
        if(parent!=null){
            index=parent.indexOfChild(view);//记录view在原先父view的下标
            Log.e(TAG,"index="+index);
            parent.removeView(view);
            circularRevealLayout.addView(view,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            parent.addView(circularRevealLayout,index,params);
        }



        return circularRevealLayout.getAnimator();
    }



}
