package com.llamalab.automate.stmt;

import android.graphics.Point;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import l4.InterfaceC2065a;
import x3.C2425c;

/* loaded from: classes.dex */
public final class Q0 extends com.llamalab.automate.W implements ImageReader.OnImageAvailableListener {

    /* renamed from: L1, reason: collision with root package name */
    public MediaProjection f17052L1;

    /* renamed from: M1, reason: collision with root package name */
    public HandlerThread f17053M1;

    /* renamed from: N1, reason: collision with root package name */
    public Handler f17054N1;

    /* renamed from: O1, reason: collision with root package name */
    public VirtualDisplay f17055O1;

    /* renamed from: P1, reason: collision with root package name */
    public ImageReader f17056P1;

    /* renamed from: Q1, reason: collision with root package name */
    public boolean f17057Q1;

    /* renamed from: R1, reason: collision with root package name */
    public boolean f17058R1;

    /* renamed from: y1, reason: collision with root package name */
    public final com.llamalab.safs.n f17059y1;

    public Q0(MediaProjection mediaProjection, com.llamalab.safs.n nVar) {
        this.f17052L1 = mediaProjection;
        this.f17059y1 = nVar;
    }

    public static void v2(Image image, com.llamalab.safs.n nVar) {
        Image.Plane[] planes;
        int width;
        int height;
        int rowStride;
        ByteBuffer buffer;
        planes = image.getPlanes();
        Image.Plane plane = planes[0];
        width = image.getWidth();
        height = image.getHeight();
        rowStride = plane.getRowStride();
        InterfaceC2065a j8 = com.llamalab.safs.i.j(nVar, com.llamalab.safs.p.WRITE, com.llamalab.safs.p.CREATE, com.llamalab.safs.p.TRUNCATE_EXISTING);
        try {
            CRC32 crc32 = new CRC32();
            DataOutputStream dataOutputStream = new DataOutputStream(new CheckedOutputStream(Channels.newOutputStream(j8), crc32));
            dataOutputStream.write(new byte[]{-119, 80, 78, 71, 13, 10, 26, 10});
            dataOutputStream.writeInt(13);
            crc32.reset();
            dataOutputStream.write(new byte[]{73, 72, 68, 82});
            dataOutputStream.writeInt(width);
            dataOutputStream.writeInt(height);
            dataOutputStream.write(8);
            dataOutputStream.write(2);
            dataOutputStream.write(0);
            dataOutputStream.write(0);
            dataOutputStream.write(0);
            dataOutputStream.writeInt((int) crc32.getValue());
            long n12 = j8.n1();
            dataOutputStream.writeInt(0);
            crc32.reset();
            dataOutputStream.write(new byte[]{73, 68, 65, 84});
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(dataOutputStream, new Deflater(1));
            buffer = plane.getBuffer();
            byte[] bArr = new byte[rowStride + 1];
            int i8 = (width * 3) + 1;
            while (true) {
                height--;
                if (height < 0) {
                    deflaterOutputStream.finish();
                    long n13 = (j8.n1() - n12) - 8;
                    dataOutputStream.writeInt((int) crc32.getValue());
                    dataOutputStream.writeInt(0);
                    crc32.reset();
                    dataOutputStream.write(new byte[]{73, 69, 78, 68});
                    dataOutputStream.writeInt((int) crc32.getValue());
                    dataOutputStream.flush();
                    dataOutputStream.flush();
                    j8.T1(n12);
                    dataOutputStream.writeInt((int) n13);
                    j8.close();
                    return;
                }
                buffer.get(bArr, 1, rowStride);
                int i9 = 1;
                int i10 = 1;
                while (i9 < i8) {
                    int i11 = i9 + 1;
                    int i12 = i10 + 1;
                    bArr[i9] = bArr[i10];
                    int i13 = i11 + 1;
                    int i14 = i12 + 1;
                    bArr[i11] = bArr[i12];
                    bArr[i13] = bArr[i14];
                    i10 = i14 + 1 + 1;
                    i9 = i13 + 1;
                }
                deflaterOutputStream.write(bArr, 0, i8);
            }
        } catch (Throwable th) {
            if (j8 != null) {
                try {
                    j8.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
            }
            throw th;
        }
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        ImageReader newInstance;
        Surface surface;
        VirtualDisplay createVirtualDisplay;
        super.C(automateService, j8, j9, j10);
        n2(1);
        this.f17058R1 = C1710z2.a(C2425c.c(automateService));
        HandlerThread handlerThread = new HandlerThread("ScreenshotTaskApi21", -8);
        this.f17053M1 = handlerThread;
        handlerThread.start();
        this.f17054N1 = new Handler(this.f17053M1.getLooper());
        Display defaultDisplay = ((WindowManager) automateService.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        displayMetrics.widthPixels = point.x;
        displayMetrics.heightPixels = point.y;
        if (this.f17058R1) {
            F5.n.f(this, "ScreenshotTaskApi21 startVirtualDisplay: width=" + displayMetrics.widthPixels + ", height=" + displayMetrics.heightPixels + ", dpi=" + displayMetrics.densityDpi);
        }
        newInstance = ImageReader.newInstance(displayMetrics.widthPixels, displayMetrics.heightPixels, 1, 2);
        this.f17056P1 = newInstance;
        newInstance.setOnImageAvailableListener(this, this.f17054N1);
        MediaProjection mediaProjection = this.f17052L1;
        int i8 = displayMetrics.widthPixels;
        int i9 = displayMetrics.heightPixels;
        int i10 = displayMetrics.densityDpi;
        surface = this.f17056P1.getSurface();
        createVirtualDisplay = mediaProjection.createVirtualDisplay("ScreenshotTaskApi21", i8, i9, i10, 1, surface, null, null);
        this.f17055O1 = createVirtualDisplay;
        if (createVirtualDisplay == null) {
            throw new NullPointerException("createVirtualDisplay failed");
        }
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        ImageReader imageReader = this.f17056P1;
        if (imageReader != null) {
            try {
                imageReader.close();
            } catch (Throwable unused) {
            }
            this.f17056P1 = null;
        }
        MediaProjection mediaProjection = this.f17052L1;
        if (mediaProjection != null) {
            try {
                mediaProjection.stop();
            } catch (Throwable unused2) {
            }
            this.f17052L1 = null;
        }
        VirtualDisplay virtualDisplay = this.f17055O1;
        if (virtualDisplay != null) {
            try {
                virtualDisplay.release();
            } catch (Throwable unused3) {
            }
            this.f17055O1 = null;
        }
        HandlerThread handlerThread = this.f17053M1;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f17053M1 = null;
        }
        u2();
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        Image acquireLatestImage;
        try {
            if (this.f17057Q1) {
                return;
            }
            if (this.f17058R1) {
                F5.n.f(this, "ScreenshotTaskApi21 onImageAvailable");
            }
            acquireLatestImage = imageReader.acquireLatestImage();
            if (acquireLatestImage == null) {
                if (acquireLatestImage != null) {
                    acquireLatestImage.close();
                    return;
                }
                return;
            }
            try {
                this.f17057Q1 = true;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                com.llamalab.safs.n t8 = w0.L.t(this.f17059y1, Environment.DIRECTORY_DCIM, null, C2541R.string.format_image_file, "png");
                v2(acquireLatestImage, t8);
                if (this.f17058R1) {
                    F5.n.f(this, "ScreenshotTaskApi21 writeImageSoftware took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                }
                acquireLatestImage.close();
                VirtualDisplay virtualDisplay = this.f17055O1;
                if (virtualDisplay != null) {
                    virtualDisplay.setSurface(null);
                }
                q2(t8.toString(), false);
            } catch (Throwable th) {
                try {
                    acquireLatestImage.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            r2(th3);
        }
    }
}
