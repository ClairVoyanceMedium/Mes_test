package com.llamalab.automate.stmt;

import android.content.Context;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.AbstractC1647h0;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import x3.C2433k;
import x3.C2440r;

@F3.f("video_record_start.html")
@F3.a(C2541R.integer.ic_device_access_video)
@F3.i(C2541R.string.stmt_video_record_start_title)
@F3.h(C2541R.string.stmt_video_record_start_summary)
@F3.c(C2541R.string.caption_video_record_start)
@F3.e(C2541R.layout.stmt_video_record_start_edit)
/* loaded from: classes.dex */
public final class VideoRecordStart extends IntermittentAction implements AsyncStatement {
    public InterfaceC1700x0 audioFocus;
    public InterfaceC1700x0 audioSource;
    public InterfaceC1700x0 cameraId;
    public InterfaceC1700x0 colorEffect;
    public InterfaceC1700x0 flashMode;
    public InterfaceC1700x0 focusMode;
    public InterfaceC1700x0 maxDuration;
    public InterfaceC1700x0 maxFileSize;
    public InterfaceC1700x0 notificationChannelId;
    public InterfaceC1700x0 profile;
    public InterfaceC1700x0 quiet;
    public InterfaceC1700x0 rotation;
    public InterfaceC1700x0 sceneMode;
    public InterfaceC1700x0 stabilization;
    public InterfaceC1700x0 targetPath;
    public J3.l varVideoFile;
    public InterfaceC1700x0 whiteBalance;
    public InterfaceC1700x0 zoom;

    public static boolean s(String str, List list) {
        return (list == null || str == null || !list.contains(str)) ? false : true;
    }

    public static Camera.Size u(Camera.Parameters parameters, int i8, int i9) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            for (Camera.Size size : supportedVideoSizes) {
                if (size.width == i8 && size.height == i9) {
                    return (Camera.Size) Collections.min(supportedPreviewSizes, C2440r.f23421e);
                }
            }
            return null;
        }
        for (Camera.Size size2 : supportedPreviewSizes) {
            if (size2.width == i8 && size2.height == i9) {
                return size2;
            }
        }
        return null;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CAMERA"), com.llamalab.automate.access.c.j("android.permission.RECORD_AUDIO"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CAMERA"), com.llamalab.automate.access.c.j("android.permission.RECORD_AUDIO"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CAMERA"), com.llamalab.automate.access.c.j("android.permission.RECORD_AUDIO"), com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_video_record_start).e(this.profile, 1, C2541R.xml.camcorder_profiles).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.cameraId);
        dVar.g(this.audioSource);
        if (80 <= dVar.f6413Z) {
            dVar.g(this.audioFocus);
        }
        dVar.g(this.profile);
        if (82 <= dVar.f6413Z) {
            dVar.g(this.rotation);
        }
        if (54 <= dVar.f6413Z) {
            dVar.g(this.zoom);
        }
        dVar.g(this.flashMode);
        dVar.g(this.focusMode);
        dVar.g(this.sceneMode);
        dVar.g(this.whiteBalance);
        dVar.g(this.colorEffect);
        dVar.g(this.stabilization);
        dVar.g(this.maxDuration);
        if (79 <= dVar.f6413Z) {
            dVar.g(this.maxFileSize);
        }
        dVar.g(this.notificationChannelId);
        if (103 <= dVar.f6413Z) {
            dVar.g(this.quiet);
        }
        dVar.g(this.targetPath);
        dVar.g(this.varVideoFile);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.cameraId);
        visitor.b(this.audioSource);
        visitor.b(this.audioFocus);
        visitor.b(this.profile);
        visitor.b(this.rotation);
        visitor.b(this.zoom);
        visitor.b(this.flashMode);
        visitor.b(this.focusMode);
        visitor.b(this.sceneMode);
        visitor.b(this.whiteBalance);
        visitor.b(this.colorEffect);
        visitor.b(this.stabilization);
        visitor.b(this.maxDuration);
        visitor.b(this.maxFileSize);
        visitor.b(this.notificationChannelId);
        visitor.b(this.quiet);
        visitor.b(this.targetPath);
        visitor.b(this.varVideoFile);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        this.cameraId = interfaceC1700x0;
        if (98 > cVar.f6409x0 && (interfaceC1700x0 instanceof L3.K)) {
            Pattern pattern = J3.h.f4650a;
            this.cameraId = new L3.W(J3.h.e0(((L3.K) interfaceC1700x0).value()));
        }
        this.audioSource = (InterfaceC1700x0) cVar.readObject();
        if (80 <= cVar.f6409x0) {
            this.audioFocus = (InterfaceC1700x0) cVar.readObject();
        }
        this.profile = (InterfaceC1700x0) cVar.readObject();
        if (82 <= cVar.f6409x0) {
            this.rotation = (InterfaceC1700x0) cVar.readObject();
        }
        if (54 <= cVar.f6409x0) {
            this.zoom = (InterfaceC1700x0) cVar.readObject();
        }
        this.flashMode = (InterfaceC1700x0) cVar.readObject();
        this.focusMode = (InterfaceC1700x0) cVar.readObject();
        this.sceneMode = (InterfaceC1700x0) cVar.readObject();
        this.whiteBalance = (InterfaceC1700x0) cVar.readObject();
        this.colorEffect = (InterfaceC1700x0) cVar.readObject();
        this.stabilization = (InterfaceC1700x0) cVar.readObject();
        this.maxDuration = (InterfaceC1700x0) cVar.readObject();
        if (79 <= cVar.f6409x0) {
            this.maxFileSize = (InterfaceC1700x0) cVar.readObject();
        }
        InterfaceC1700x0 interfaceC1700x02 = (InterfaceC1700x0) cVar.readObject();
        this.notificationChannelId = interfaceC1700x02;
        int i8 = cVar.f6409x0;
        if (77 > i8 && interfaceC1700x02 != null) {
            this.notificationChannelId = new L3.A(interfaceC1700x02);
        }
        if (103 <= i8) {
            this.quiet = (InterfaceC1700x0) cVar.readObject();
        }
        this.targetPath = (InterfaceC1700x0) cVar.readObject();
        this.varVideoFile = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        C1708z0 c1708z02;
        boolean isVideoStabilizationSupported;
        c1708z0.q(C2541R.string.stmt_video_record_start_title);
        c1708z0.H(t1.class);
        int m8 = J3.h.m(c1708z0, this.cameraId, 0);
        int m9 = J3.h.m(c1708z0, this.audioSource, 5);
        int m10 = J3.h.m(c1708z0, this.audioFocus, 4);
        int m11 = J3.h.m(c1708z0, this.profile, 1);
        Double j8 = J3.h.j(c1708z0, this.rotation);
        Double j9 = J3.h.j(c1708z0, this.zoom);
        String x7 = J3.h.x(c1708z0, this.flashMode, null);
        String x8 = J3.h.x(c1708z0, this.focusMode, null);
        String x9 = J3.h.x(c1708z0, this.sceneMode, null);
        String x10 = J3.h.x(c1708z0, this.whiteBalance, null);
        String x11 = J3.h.x(c1708z0, this.colorEffect, null);
        boolean f8 = J3.h.f(c1708z0, this.stabilization, false);
        long t8 = J3.h.t(c1708z0, this.maxDuration, 0L);
        long s8 = J3.h.s(c1708z0, this.maxFileSize);
        String x12 = J3.h.x(c1708z0, this.notificationChannelId, null);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.targetPath);
        boolean f9 = J3.h.f(c1708z0, this.quiet, false);
        boolean z7 = J1(1) == 0;
        if (!CamcorderProfile.hasProfile(m8, m11)) {
            throw new IllegalArgumentException("Profile not supported");
        }
        CamcorderProfile camcorderProfile = CamcorderProfile.get(m8, m11);
        if (camcorderProfile == null) {
            throw new IllegalStateException("No such profile");
        }
        int i8 = 4 == m10 ? 2 : m10;
        Camera open = Camera.open(m8);
        if (open == null) {
            throw new IllegalStateException("No such camera");
        }
        try {
            int i9 = Build.VERSION.SDK_INT;
            if (17 <= i9) {
                open.enableShutterSound(!f9);
            }
            Camera.Parameters parameters = open.getParameters();
            parameters.setRecordingHint(true);
            parameters.set("cam_mode", 1);
            Camera.Size u8 = u(parameters, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
            if (u8 == null) {
                throw new IllegalStateException("Profile resolution not supported");
            }
            parameters.setPreviewSize(u8.width, u8.height);
            if (s(x7, parameters.getSupportedFlashModes())) {
                parameters.setFlashMode(x7);
            }
            if (s(x8, parameters.getSupportedFocusModes())) {
                parameters.setFocusMode(x8);
            }
            if (s(x9, parameters.getSupportedSceneModes())) {
                parameters.setSceneMode(x9);
            }
            if (s(x10, parameters.getSupportedWhiteBalance())) {
                parameters.setWhiteBalance(x10);
            }
            if (s(x11, parameters.getSupportedColorEffects())) {
                parameters.setColorEffect(x11);
            }
            if (15 <= i9) {
                isVideoStabilizationSupported = parameters.isVideoStabilizationSupported();
                if (isVideoStabilizationSupported) {
                    parameters.setVideoStabilization(f8);
                }
            } else if ("true".equals(parameters.get("video-stabilization-supported"))) {
                parameters.set("video-stabilization", Boolean.toString(f8));
            }
            if (j9 != null && parameters.isZoomSupported()) {
                parameters.setZoom(y4.j.d(j9.intValue(), 0, parameters.getMaxZoom()));
            }
            open.setParameters(parameters);
            C2433k c2433k = new C2433k();
            try {
                c2433k.a(u8);
                open.setPreviewTexture(c2433k);
                open.startPreview();
                open.unlock();
                MediaRecorder mediaRecorder = new MediaRecorder();
                boolean z8 = m11 >= 1000 && m11 < 2000;
                try {
                    mediaRecorder.setCamera(open);
                    if (m9 < 0 || z8) {
                        mediaRecorder.setVideoSource(1);
                        mediaRecorder.setOutputFormat(camcorderProfile.fileFormat);
                        mediaRecorder.setVideoFrameRate(camcorderProfile.videoFrameRate);
                        mediaRecorder.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
                        mediaRecorder.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
                        mediaRecorder.setVideoEncoder(camcorderProfile.videoCodec);
                    } else {
                        mediaRecorder.setAudioSource(m9);
                        mediaRecorder.setVideoSource(1);
                        mediaRecorder.setProfile(camcorderProfile);
                    }
                    if (j8 != null) {
                        parameters.setRotation(C2440r.s(j8.doubleValue()));
                        c1708z02 = c1708z0;
                    } else {
                        c1708z02 = c1708z0;
                        mediaRecorder.setOrientationHint(C2440r.r(c1708z02, m8));
                    }
                    if (t8 > 0) {
                        mediaRecorder.setMaxDuration((int) Math.min(t8, 2147483647L));
                    }
                    if (s8 > 0) {
                        mediaRecorder.setMaxFileSize(s8);
                    }
                    t1 t1Var = new t1(mediaRecorder, i8, open, c2433k, camcorderProfile, p8, z7);
                    c1708z02.w(t1Var);
                    if (x12 != null) {
                        t1Var.z2(c1708z02, x12, C2541R.drawable.ic_stat_notify_videocam, C2541R.string.stmt_video_record_start_title);
                    }
                    t1Var.n2(1);
                    if (t1Var.f17430M1 != null) {
                        return false;
                    }
                    AbstractC1647h0.a aVar = new AbstractC1647h0.a();
                    t1Var.f17430M1 = aVar;
                    aVar.start();
                    return false;
                } catch (Throwable th) {
                    mediaRecorder.release();
                    throw th;
                }
            } catch (Throwable th2) {
                c2433k.release();
                throw th2;
            }
        } catch (Throwable th3) {
            open.release();
            throw th3;
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varVideoFile;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
