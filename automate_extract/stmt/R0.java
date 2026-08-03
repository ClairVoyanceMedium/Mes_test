package com.llamalab.automate.stmt;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.hardware.HardwareBuffer;
import android.os.Environment;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C2541R;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class R0 extends com.llamalab.automate.W implements AccessibilityService.TakeScreenshotCallback {

    /* renamed from: L1, reason: collision with root package name */
    public final com.llamalab.safs.n f17066L1;

    /* renamed from: M1, reason: collision with root package name */
    public a f17067M1;

    /* renamed from: y1, reason: collision with root package name */
    public final AtomicBoolean f17068y1 = new AtomicBoolean();

    public class a extends Thread {

        /* renamed from: X, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService.ScreenshotResult f17069X;

        public a(AccessibilityService.ScreenshotResult screenshotResult) {
            this.f17069X = screenshotResult;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            HardwareBuffer hardwareBuffer;
            HardwareBuffer hardwareBuffer2;
            ColorSpace colorSpace;
            Bitmap wrapHardwareBuffer;
            R0 r02 = R0.this;
            AccessibilityService.ScreenshotResult screenshotResult = this.f17069X;
            hardwareBuffer = screenshotResult.getHardwareBuffer();
            try {
                try {
                    com.llamalab.safs.n t8 = w0.L.t(r02.f17066L1, Environment.DIRECTORY_DCIM, null, C2541R.string.format_image_file, "png");
                    OutputStream l8 = com.llamalab.safs.i.l(t8, new com.llamalab.safs.l[0]);
                    try {
                        hardwareBuffer2 = screenshotResult.getHardwareBuffer();
                        colorSpace = screenshotResult.getColorSpace();
                        wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer2, colorSpace);
                        wrapHardwareBuffer.compress(Bitmap.CompressFormat.PNG, 100, l8);
                        try {
                            l8.close();
                        } catch (Throwable unused) {
                        }
                        if (!isInterrupted()) {
                            r02.q2(t8.toString(), false);
                        }
                        hardwareBuffer.close();
                    } finally {
                        Charset charset = com.llamalab.safs.internal.m.f17837a;
                        try {
                            l8.close();
                        } catch (Throwable unused2) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        r02.r2(th);
                        hardwareBuffer.close();
                    } catch (Throwable th2) {
                        try {
                            hardwareBuffer.close();
                        } catch (Throwable unused3) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable unused4) {
            }
        }
    }

    public R0(com.llamalab.safs.n nVar) {
        this.f17066L1 = nVar;
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        n2(1);
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        this.f17068y1.set(true);
        a aVar = this.f17067M1;
        if (aVar != null) {
            aVar.interrupt();
            this.f17067M1 = null;
        }
        u2();
    }

    @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
    public final void onFailure(int i8) {
        try {
            if (i8 == 1) {
                throw new IllegalStateException("Internal error");
            }
            if (i8 == 2) {
                throw new SecurityException("No accessibility access");
            }
            if (i8 == 3) {
                throw new IllegalStateException("Time interval short");
            }
            if (i8 == 4) {
                throw new IllegalStateException("Invalid display");
            }
            throw new IllegalStateException("Unknown error: " + i8);
        } catch (Throwable th) {
            r2(th);
        }
    }

    @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
    public final void onSuccess(AccessibilityService.ScreenshotResult screenshotResult) {
        if (this.f17068y1.get()) {
            return;
        }
        a aVar = new a(screenshotResult);
        this.f17067M1 = aVar;
        aVar.start();
    }
}
