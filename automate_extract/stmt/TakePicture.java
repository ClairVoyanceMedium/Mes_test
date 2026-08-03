package com.llamalab.automate.stmt;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.field.CameraConstants;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import x3.C2425c;
import x3.C2433k;
import x3.C2440r;

@F3.f("take_picture.html")
@F3.a(C2541R.integer.ic_device_access_camera)
@F3.i(C2541R.string.stmt_take_picture_title)
@F3.h(C2541R.string.stmt_take_picture_summary)
@F3.e(C2541R.layout.stmt_take_picture_edit)
/* loaded from: classes.dex */
public final class TakePicture extends Action implements AsyncStatement {

    /* renamed from: L1, reason: collision with root package name */
    public static final String[] f17190L1 = {"auto", "macro"};
    public InterfaceC1700x0 cameraId;
    public InterfaceC1700x0 colorEffect;
    public InterfaceC1700x0 exifLatitude;
    public InterfaceC1700x0 exifLongitude;
    public InterfaceC1700x0 flashMode;
    public InterfaceC1700x0 focusMode;
    public InterfaceC1700x0 pictureSize;
    public InterfaceC1700x0 quality;
    public InterfaceC1700x0 quiet;
    public InterfaceC1700x0 rotation;
    public InterfaceC1700x0 sceneMode;
    public InterfaceC1700x0 shutterDelay;
    public InterfaceC1700x0 targetPath;
    public J3.l varImageFile;
    public InterfaceC1700x0 whiteBalance;
    public InterfaceC1700x0 zoom;

    public static boolean q(String str, List list) {
        return (list == null || str == null || !list.contains(str)) ? false : true;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CAMERA"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CAMERA"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CAMERA"), com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_take_picture_title);
        InterfaceC1700x0 interfaceC1700x0 = this.cameraId;
        if (interfaceC1700x0 instanceof J3.k) {
            l8.g(Integer.valueOf(J3.h.R(interfaceC1700x0)), CameraConstants.class);
        } else {
            l8.k(false);
        }
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.cameraId);
        dVar.g(this.pictureSize);
        dVar.g(this.quality);
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
        if (44 <= dVar.f6413Z) {
            dVar.g(this.shutterDelay);
        }
        if (33 <= dVar.f6413Z) {
            dVar.g(this.exifLatitude);
            dVar.g(this.exifLongitude);
        }
        if (103 <= dVar.f6413Z) {
            dVar.g(this.quiet);
        }
        dVar.g(this.targetPath);
        dVar.g(this.varImageFile);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.cameraId);
        visitor.b(this.pictureSize);
        visitor.b(this.quality);
        visitor.b(this.rotation);
        visitor.b(this.zoom);
        visitor.b(this.flashMode);
        visitor.b(this.focusMode);
        visitor.b(this.sceneMode);
        visitor.b(this.whiteBalance);
        visitor.b(this.colorEffect);
        visitor.b(this.shutterDelay);
        visitor.b(this.exifLatitude);
        visitor.b(this.exifLongitude);
        visitor.b(this.quiet);
        visitor.b(this.targetPath);
        visitor.b(this.varImageFile);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        this.cameraId = interfaceC1700x0;
        if (98 > cVar.f6409x0 && (interfaceC1700x0 instanceof L3.K)) {
            Pattern pattern = J3.h.f4650a;
            this.cameraId = new L3.W(J3.h.e0(((L3.K) interfaceC1700x0).value()));
        }
        this.pictureSize = (InterfaceC1700x0) cVar.readObject();
        this.quality = (InterfaceC1700x0) cVar.readObject();
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
        if (44 <= cVar.f6409x0) {
            this.shutterDelay = (InterfaceC1700x0) cVar.readObject();
        }
        if (33 <= cVar.f6409x0) {
            this.exifLatitude = (InterfaceC1700x0) cVar.readObject();
            this.exifLongitude = (InterfaceC1700x0) cVar.readObject();
        }
        if (103 <= cVar.f6409x0) {
            this.quiet = (InterfaceC1700x0) cVar.readObject();
        }
        this.targetPath = (InterfaceC1700x0) cVar.readObject();
        this.varImageFile = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_take_picture_title);
        e(c1708z0);
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        int m8 = J3.h.m(c1708z0, this.cameraId, 0);
        Integer o6 = J3.h.o(c1708z0, this.pictureSize, null);
        Double j8 = J3.h.j(c1708z0, this.quality);
        Double j9 = J3.h.j(c1708z0, this.rotation);
        Double j10 = J3.h.j(c1708z0, this.zoom);
        String x7 = J3.h.x(c1708z0, this.flashMode, null);
        String x8 = J3.h.x(c1708z0, this.focusMode, null);
        String x9 = J3.h.x(c1708z0, this.sceneMode, null);
        String x10 = J3.h.x(c1708z0, this.whiteBalance, null);
        String x11 = J3.h.x(c1708z0, this.colorEffect, null);
        Double j11 = J3.h.j(c1708z0, this.exifLatitude);
        Double j12 = J3.h.j(c1708z0, this.exifLongitude);
        long t8 = J3.h.t(c1708z0, this.shutterDelay, 0L);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.targetPath);
        boolean f8 = J3.h.f(c1708z0, this.quiet, false);
        Camera open = Camera.open(m8);
        if (open == null) {
            throw new IllegalStateException("No such camera");
        }
        try {
            if (17 <= Build.VERSION.SDK_INT) {
                open.enableShutterSound(!f8);
            }
            Camera.Parameters parameters = open.getParameters();
            parameters.setPictureFormat(256);
            parameters.setRotation(j9 != null ? C2440r.s(j9.doubleValue()) : C2440r.r(c1708z0, m8));
            if (o6 != null) {
                Iterator<Camera.Size> it = parameters.getSupportedPictureSizes().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Camera.Size next = it.next();
                    if (a8) {
                        c1708z0.p("TakePicture supportedPictureSize=" + next.width + "x" + next.height);
                    }
                    int intValue = o6.intValue();
                    int i8 = next.width;
                    int i9 = next.height;
                    Iterator<Camera.Size> it2 = it;
                    if (intValue == (i9 | (i8 << 16))) {
                        parameters.setPictureSize(i8, i9);
                        break;
                    }
                    it = it2;
                }
            }
            if (j8 != null) {
                parameters.setJpegQuality(y4.j.d(j8.intValue(), 1, 100));
            }
            if (q(x7, parameters.getSupportedFlashModes())) {
                parameters.setFlashMode(x7);
            }
            if (q(x8, parameters.getSupportedFocusModes())) {
                parameters.setFocusMode(x8);
            }
            if (q(x9, parameters.getSupportedSceneModes())) {
                parameters.setSceneMode(x9);
            }
            if (q(x10, parameters.getSupportedWhiteBalance())) {
                parameters.setWhiteBalance(x10);
            }
            if (q(x11, parameters.getSupportedColorEffects())) {
                parameters.setColorEffect(x11);
            }
            if (j11 != null && j12 != null) {
                parameters.setGpsLatitude(j11.doubleValue());
                parameters.setGpsLongitude(j12.doubleValue());
                parameters.setGpsAltitude(0.0d);
                parameters.setGpsTimestamp(System.currentTimeMillis() / 1000);
                parameters.setGpsProcessingMethod("unknown");
            }
            Camera.Size size = (Camera.Size) Collections.min(parameters.getSupportedPreviewSizes(), C2440r.f23421e);
            parameters.setPreviewSize(size.width, size.height);
            if (j10 != null && parameters.isZoomSupported()) {
                double maxZoom = parameters.getMaxZoom();
                double b8 = y4.j.b(j10.doubleValue() / 100.0d, 0.0d, 1.0d);
                Double.isNaN(maxZoom);
                Double.isNaN(maxZoom);
                parameters.setZoom((int) Math.round(((maxZoom - 0.0d) * b8) + 0.0d));
            }
            open.setParameters(parameters);
            boolean z7 = Arrays.binarySearch(f17190L1, parameters.getFocusMode()) >= 0;
            if (a8) {
                c1708z0.p("TakePicture previewSize=" + size.width + "x" + size.height);
                StringBuilder sb = new StringBuilder();
                sb.append("TakePicture supportedFlashModes=");
                sb.append(parameters.getSupportedFlashModes());
                c1708z0.p(sb.toString());
                c1708z0.p("TakePicture supportedFocusModes=" + parameters.getSupportedFocusModes());
                c1708z0.p("TakePicture supportedSceneModes=" + parameters.getSupportedSceneModes());
                c1708z0.p("TakePicture supportedWhiteBalance=" + parameters.getSupportedWhiteBalance());
                c1708z0.p("TakePicture supportedColorEffects=" + parameters.getSupportedColorEffects());
            }
            C2433k c2433k = new C2433k();
            try {
                c2433k.a(size);
                open.setPreviewTexture(c2433k);
                f1 f1Var = new f1(open, c2433k, p8, t8);
                c1708z0.w(f1Var);
                f1Var.n2(1);
                if (z7) {
                    f1Var.f17413y1.autoFocus(f1Var);
                    return false;
                }
                f1Var.f15400Y.f14581L1.postDelayed(f1Var.f17412P1, y4.j.e(f1Var.f17411O1, 500L, 5000L));
                return false;
            } catch (Throwable th) {
                c2433k.release();
                throw th;
            }
        } catch (Throwable th2) {
            open.release();
            throw th2;
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varImageFile;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
