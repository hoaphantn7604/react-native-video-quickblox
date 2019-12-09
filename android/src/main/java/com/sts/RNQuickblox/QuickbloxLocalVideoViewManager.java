package com.sts.RNQuickblox;

import android.graphics.Color;
import android.util.Log;

import com.quickblox.videochat.webrtc.QBMediaStreamManager;
import com.quickblox.videochat.webrtc.QBRTCCameraVideoCapturer;
import com.quickblox.videochat.webrtc.QBRTCSession;
import com.quickblox.videochat.webrtc.view.QBRTCVideoTrack;

public class QuickbloxLocalVideoViewManager extends QuickbloxVideoViewManager {

    public static final String VIEW_NAME = "QuickbloxLocalVideoView";
    private static final String TAG = RNQuickbloxModule.class.getSimpleName();

    @Override
    public String getName() {
        return VIEW_NAME;
    }

    public QuickbloxLocalVideoViewManager() {
        QuickbloxHandler.getInstance().setLocalViewManager(this);

    }

    @Override
    protected QBRTCVideoTrack getVideoTrack() {

        if (QuickbloxHandler.getInstance().getSession() != null) {
            QBRTCSession session = QuickbloxHandler.getInstance().getSession();
            QBMediaStreamManager mediaStreamManager = session.getMediaStreamManager();
            if (mediaStreamManager != null) {
                try {
                    QBRTCCameraVideoCapturer videoCapturer = (QBRTCCameraVideoCapturer) (mediaStreamManager.getVideoCapturer());
                    videoCapturer.changeCaptureFormat(768, 1024, 30);
                    return mediaStreamManager.getLocalVideoTrack();
                }catch (Exception e) {
                    Log.i(TAG, "Log video track: " + e);
                }

            }
        }
        return null;
    }
}