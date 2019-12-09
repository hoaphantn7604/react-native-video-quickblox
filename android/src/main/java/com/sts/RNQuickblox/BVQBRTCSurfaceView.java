package com.sts.RNQuickblox;

import android.content.Context;
import android.util.AttributeSet;

import com.quickblox.videochat.webrtc.view.QBRTCSurfaceView;

public class BVQBRTCSurfaceView extends QBRTCSurfaceView {

    private final String TAG = "ahihi - " + this.getClass().getSimpleName();


    public BVQBRTCSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setMirror(true);
    }

    public BVQBRTCSurfaceView(Context context) {
        super(context);
        this.setMirror(true);
    }




}
