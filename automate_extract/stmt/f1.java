package com.llamalab.automate.stmt;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Environment;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C2541R;
import java.io.OutputStream;
import x3.C2433k;

/* loaded from: classes.dex */
public final class f1 extends com.llamalab.automate.W implements Camera.ErrorCallback, Camera.PictureCallback, Camera.AutoFocusCallback {

    /* renamed from: L1, reason: collision with root package name */
    public SurfaceTexture f17408L1;

    /* renamed from: M1, reason: collision with root package name */
    public final com.llamalab.safs.n f17409M1;

    /* renamed from: N1, reason: collision with root package name */
    public b f17410N1;

    /* renamed from: O1, reason: collision with root package name */
    public final long f17411O1;

    /* renamed from: P1, reason: collision with root package name */
    public final a f17412P1 = new a();

    /* renamed from: y1, reason: collision with root package name */
    public Camera f17413y1;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            f1 f1Var = f1.this;
            try {
                f1Var.f17413y1.takePicture(null, null, null, f1Var);
            } catch (Throwable th) {
                f1Var.r2(th);
            }
        }
    }

    public final class b extends Thread {

        /* renamed from: X, reason: collision with root package name */
        public final byte[] f17415X;

        public b(byte[] bArr) {
            this.f17415X = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            f1 f1Var = f1.this;
            try {
                com.llamalab.safs.n t8 = w0.L.t(f1Var.f17409M1, Environment.DIRECTORY_DCIM, null, C2541R.string.format_image_file, "jpg");
                byte[] bArr = this.f17415X;
                OutputStream l8 = com.llamalab.safs.i.l(t8, new com.llamalab.safs.l[0]);
                try {
                    l8.write(bArr);
                    l8.close();
                    f1Var.q2(t8.toString(), false);
                } catch (Throwable th) {
                    l8.close();
                    throw th;
                }
            } catch (Throwable th2) {
                f1Var.r2(th2);
            }
        }
    }

    public f1(Camera camera, C2433k c2433k, com.llamalab.safs.n nVar, long j8) {
        this.f17413y1 = camera;
        this.f17408L1 = c2433k;
        this.f17409M1 = nVar;
        this.f17411O1 = j8;
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        this.f17413y1.setErrorCallback(this);
        this.f17413y1.startPreview();
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        automateService.f14581L1.removeCallbacks(this.f17412P1);
        Camera camera = this.f17413y1;
        if (camera != null) {
            try {
                camera.release();
            } catch (Throwable unused) {
            }
            this.f17413y1 = null;
        }
        SurfaceTexture surfaceTexture = this.f17408L1;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.release();
            } catch (Throwable unused2) {
            }
            this.f17408L1 = null;
        }
        b bVar = this.f17410N1;
        if (bVar != null) {
            bVar.interrupt();
            this.f17410N1 = null;
        }
        u2();
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public final void onAutoFocus(boolean z7, Camera camera) {
        a aVar = this.f17412P1;
        long j8 = this.f17411O1;
        if (j8 > 0) {
            this.f15400Y.f14581L1.postDelayed(aVar, Math.min(j8, 5000L));
        } else {
            aVar.run();
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public final void onError(int i8, Camera camera) {
        r2(100 == i8 ? new RuntimeException("Media server died").fillInStackTrace() : new RuntimeException(B4.g.f(i8, new StringBuilder("Unknown camera error: 0x"))).fillInStackTrace());
    }

    @Override // android.hardware.Camera.PictureCallback
    public final void onPictureTaken(byte[] bArr, Camera camera) {
        try {
            if (this.f17410N1 != null) {
                throw new IllegalStateException("onPictureTaken called twice");
            }
            b bVar = new b(bArr);
            this.f17410N1 = bVar;
            bVar.start();
        } catch (Throwable th) {
            r2(th);
        }
    }
}
