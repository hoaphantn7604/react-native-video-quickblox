package com.sts.RNQuickblox;

import android.util.Log;

import com.quickblox.videochat.webrtc.view.QBRTCVideoTrack;


public class QuickbloxRemoteVideoViewManager extends QuickbloxVideoViewManager {

    public static final String VIEW_NAME = "QuickbloxRemoteVideoView";
    private static final String TAG = RNQuickbloxModule.class.getSimpleName();


    @Override
    public String getName() {
        return VIEW_NAME;
    }

    public QuickbloxRemoteVideoViewManager() {
        QuickbloxHandler.getInstance().setRemoteVideoViewManager(this);
    }

    @Override
    protected QBRTCVideoTrack getVideoTrack() {

        if (QuickbloxHandler.getInstance().getCaller() != null) {
            try {
                QBRTCVideoTrack videoTrack = QuickbloxHandler.getInstance().getSession().getMediaStreamManager().getVideoTrack(QuickbloxHandler.getInstance().getCaller());
                this.renderVideoTrack(videoTrack);
            }
            catch(Exception e) {
                //  Block of code to handle errors
                Log.i(TAG, "Log video track: " + e);
            }

        }
        return null;
    }
}