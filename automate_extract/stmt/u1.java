package com.llamalab.automate.stmt;

import C1.G6;
import C1.RunnableC0361e9;
import D1.C0674n3;
import D1.C0709t3;
import D1.EnumC0638h3;
import D1.EnumC0668m3;
import D1.EnumC0703s3;
import D1.V4;
import D1.a5;
import D1.b5;
import D1.f5;
import a3.InterfaceC1191a;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.MediaStore;
import b0.C1286a;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AutomateService;
import j1.C1981i;
import j1.C1985m;
import j1.C1988p;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract class u1<T, D extends InterfaceC1191a<T>> extends AbstractRunnableC1694v2 implements N1.e<T>, N1.d, N1.b {

    /* renamed from: L1, reason: collision with root package name */
    public final D f17550L1;

    /* renamed from: M1, reason: collision with root package name */
    public final Uri f17551M1;

    public u1(D d8, Uri uri) {
        this.f17550L1 = d8;
        this.f17551M1 = uri;
    }

    @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        super.F(automateService);
        try {
            this.f17550L1.close();
        } catch (Throwable unused) {
        }
    }

    @Override // N1.e
    public final void J0(T t8) {
        q2(t8, false);
    }

    @Override // N1.b
    public final void b() {
        r2(new CancellationException().fillInStackTrace());
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0144, code lost:
    
        if ((r10 - ((java.lang.Long) r4.get(r3)).longValue()) <= java.util.concurrent.TimeUnit.SECONDS.toMillis(30)) goto L74;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00d8 A[Catch: FileNotFoundException -> 0x0246, TryCatch #6 {FileNotFoundException -> 0x0246, blocks: (B:3:0x0023, B:5:0x0029, B:7:0x0037, B:10:0x0098, B:11:0x00ad, B:14:0x00d8, B:16:0x00e6, B:52:0x00b2, B:54:0x00b6, B:55:0x00d2, B:56:0x00ba, B:57:0x00be, B:58:0x00c2, B:59:0x00c6, B:60:0x00cd, B:67:0x0087, B:71:0x0090, B:78:0x0076, B:100:0x023e, B:101:0x0245), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b2 A[Catch: FileNotFoundException -> 0x0246, TryCatch #6 {FileNotFoundException -> 0x0246, blocks: (B:3:0x0023, B:5:0x0029, B:7:0x0037, B:10:0x0098, B:11:0x00ad, B:14:0x00d8, B:16:0x00e6, B:52:0x00b2, B:54:0x00b6, B:55:0x00d2, B:56:0x00ba, B:57:0x00be, B:58:0x00c2, B:59:0x00c6, B:60:0x00cd, B:67:0x0087, B:71:0x0090, B:78:0x0076, B:100:0x023e, B:101:0x0245), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b6 A[Catch: FileNotFoundException -> 0x0246, TryCatch #6 {FileNotFoundException -> 0x0246, blocks: (B:3:0x0023, B:5:0x0029, B:7:0x0037, B:10:0x0098, B:11:0x00ad, B:14:0x00d8, B:16:0x00e6, B:52:0x00b2, B:54:0x00b6, B:55:0x00d2, B:56:0x00ba, B:57:0x00be, B:58:0x00c2, B:59:0x00c6, B:60:0x00cd, B:67:0x0087, B:71:0x0090, B:78:0x0076, B:100:0x023e, B:101:0x0245), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ba A[Catch: FileNotFoundException -> 0x0246, TryCatch #6 {FileNotFoundException -> 0x0246, blocks: (B:3:0x0023, B:5:0x0029, B:7:0x0037, B:10:0x0098, B:11:0x00ad, B:14:0x00d8, B:16:0x00e6, B:52:0x00b2, B:54:0x00b6, B:55:0x00d2, B:56:0x00ba, B:57:0x00be, B:58:0x00c2, B:59:0x00c6, B:60:0x00cd, B:67:0x0087, B:71:0x0090, B:78:0x0076, B:100:0x023e, B:101:0x0245), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be A[Catch: FileNotFoundException -> 0x0246, TryCatch #6 {FileNotFoundException -> 0x0246, blocks: (B:3:0x0023, B:5:0x0029, B:7:0x0037, B:10:0x0098, B:11:0x00ad, B:14:0x00d8, B:16:0x00e6, B:52:0x00b2, B:54:0x00b6, B:55:0x00d2, B:56:0x00ba, B:57:0x00be, B:58:0x00c2, B:59:0x00c6, B:60:0x00cd, B:67:0x0087, B:71:0x0090, B:78:0x0076, B:100:0x023e, B:101:0x0245), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c2 A[Catch: FileNotFoundException -> 0x0246, TryCatch #6 {FileNotFoundException -> 0x0246, blocks: (B:3:0x0023, B:5:0x0029, B:7:0x0037, B:10:0x0098, B:11:0x00ad, B:14:0x00d8, B:16:0x00e6, B:52:0x00b2, B:54:0x00b6, B:55:0x00d2, B:56:0x00ba, B:57:0x00be, B:58:0x00c2, B:59:0x00c6, B:60:0x00cd, B:67:0x0087, B:71:0x0090, B:78:0x0076, B:100:0x023e, B:101:0x0245), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c6 A[Catch: FileNotFoundException -> 0x0246, TryCatch #6 {FileNotFoundException -> 0x0246, blocks: (B:3:0x0023, B:5:0x0029, B:7:0x0037, B:10:0x0098, B:11:0x00ad, B:14:0x00d8, B:16:0x00e6, B:52:0x00b2, B:54:0x00b6, B:55:0x00d2, B:56:0x00ba, B:57:0x00be, B:58:0x00c2, B:59:0x00c6, B:60:0x00cd, B:67:0x0087, B:71:0x0090, B:78:0x0076, B:100:0x023e, B:101:0x0245), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cd A[Catch: FileNotFoundException -> 0x0246, TryCatch #6 {FileNotFoundException -> 0x0246, blocks: (B:3:0x0023, B:5:0x0029, B:7:0x0037, B:10:0x0098, B:11:0x00ad, B:14:0x00d8, B:16:0x00e6, B:52:0x00b2, B:54:0x00b6, B:55:0x00d2, B:56:0x00ba, B:57:0x00be, B:58:0x00c2, B:59:0x00c6, B:60:0x00cd, B:67:0x0087, B:71:0x0090, B:78:0x0076, B:100:0x023e, B:101:0x0245), top: B:2:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0087 A[Catch: FileNotFoundException -> 0x0246, TRY_LEAVE, TryCatch #6 {FileNotFoundException -> 0x0246, blocks: (B:3:0x0023, B:5:0x0029, B:7:0x0037, B:10:0x0098, B:11:0x00ad, B:14:0x00d8, B:16:0x00e6, B:52:0x00b2, B:54:0x00b6, B:55:0x00d2, B:56:0x00ba, B:57:0x00be, B:58:0x00c2, B:59:0x00c6, B:60:0x00cd, B:67:0x0087, B:71:0x0090, B:78:0x0076, B:100:0x023e, B:101:0x0245), top: B:2:0x0023 }] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    @Override // com.llamalab.automate.AbstractRunnableC1694v2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x2() {
        C1286a c1286a;
        int f8;
        Matrix matrix;
        ?? r52;
        int i8;
        int allocationByteCount;
        a5 b8;
        Y2.a aVar;
        AutomateService automateService = this.f15400Y;
        Uri uri = this.f17551M1;
        C1988p.i(automateService, "Please provide a valid Context");
        C1988p.i(uri, "Please provide a valid imageUri");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Z2.d dVar = Z2.d.f7929b;
        ContentResolver contentResolver = automateService.getContentResolver();
        dVar.getClass();
        C1981i c1981i = Z2.d.f7928a;
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);
            if (bitmap == null) {
                throw new IOException("The image Uri could not be resolved.");
            }
            if ("content".equals(uri.getScheme()) || "file".equals(uri.getScheme())) {
                try {
                    InputStream openInputStream = contentResolver.openInputStream(uri);
                    if (openInputStream != null) {
                        try {
                            c1286a = new C1286a(openInputStream);
                        } catch (Throwable th) {
                            try {
                                openInputStream.close();
                                throw th;
                            } catch (Throwable th2) {
                                try {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                    throw th;
                                } catch (Exception unused) {
                                    throw th;
                                }
                            }
                        }
                    } else {
                        c1286a = null;
                    }
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e8) {
                            e = e8;
                            c1981i.b("MLKitImageUtils", "failed to open file to read rotation meta data: ".concat(String.valueOf(uri)), e);
                            if (c1286a != null) {
                            }
                            f8 = 0;
                            Matrix matrix2 = new Matrix();
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            switch (f8) {
                            }
                            if (matrix != null) {
                            }
                            Y2.a aVar2 = new Y2.a(bitmap);
                            int height2 = bitmap.getHeight();
                            int width2 = bitmap.getWidth();
                            allocationByteCount = bitmap.getAllocationByteCount();
                            synchronized (f5.class) {
                            }
                        }
                    }
                } catch (IOException e9) {
                    e = e9;
                    c1286a = null;
                    c1981i.b("MLKitImageUtils", "failed to open file to read rotation meta data: ".concat(String.valueOf(uri)), e);
                    if (c1286a != null) {
                    }
                    f8 = 0;
                    Matrix matrix22 = new Matrix();
                    int width3 = bitmap.getWidth();
                    int height3 = bitmap.getHeight();
                    switch (f8) {
                    }
                    if (matrix != null) {
                    }
                    Y2.a aVar22 = new Y2.a(bitmap);
                    int height22 = bitmap.getHeight();
                    int width22 = bitmap.getWidth();
                    allocationByteCount = bitmap.getAllocationByteCount();
                    synchronized (f5.class) {
                    }
                }
                if (c1286a != null) {
                    C1286a.c d8 = c1286a.d("Orientation");
                    if (d8 != null) {
                        try {
                            f8 = d8.f(c1286a.f11452f);
                        } catch (NumberFormatException unused2) {
                        }
                        Matrix matrix222 = new Matrix();
                        int width32 = bitmap.getWidth();
                        int height32 = bitmap.getHeight();
                        switch (f8) {
                            case 2:
                                matrix222 = new Matrix();
                                matrix222.postScale(-1.0f, 1.0f);
                                matrix = matrix222;
                                break;
                            case 3:
                                matrix222.postRotate(180.0f);
                                matrix = matrix222;
                                break;
                            case 4:
                                matrix222.postScale(1.0f, -1.0f);
                                matrix = matrix222;
                                break;
                            case 5:
                                matrix222.postRotate(90.0f);
                                matrix222.postScale(-1.0f, 1.0f);
                                matrix = matrix222;
                                break;
                            case 6:
                                matrix222.postRotate(90.0f);
                                matrix = matrix222;
                                break;
                            case 7:
                                matrix222.postRotate(-90.0f);
                                matrix222.postScale(-1.0f, 1.0f);
                                matrix = matrix222;
                                break;
                            case 8:
                                matrix222.postRotate(-90.0f);
                                matrix = matrix222;
                                break;
                            default:
                                matrix = null;
                                break;
                        }
                        if (matrix != null) {
                            r52 = 1;
                            r52 = 1;
                            i8 = 0;
                            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width32, height32, matrix, true);
                            if (bitmap != createBitmap) {
                                bitmap.recycle();
                                bitmap = createBitmap;
                            }
                        } else {
                            r52 = 1;
                            i8 = 0;
                        }
                        Y2.a aVar222 = new Y2.a(bitmap);
                        int height222 = bitmap.getHeight();
                        int width222 = bitmap.getWidth();
                        allocationByteCount = bitmap.getAllocationByteCount();
                        synchronized (f5.class) {
                            byte b9 = (byte) (((byte) r52) | 2);
                            if (b9 != 3) {
                                StringBuilder sb = new StringBuilder();
                                if ((b9 & 1) == 0) {
                                    sb.append(" enableFirelog");
                                }
                                if ((b9 & 2) == 0) {
                                    sb.append(" firelogEventType");
                                }
                                throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
                            }
                            b8 = f5.b(new V4("vision-common", r52, r52));
                        }
                        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                        EnumC0703s3 enumC0703s3 = EnumC0703s3.f2285f4;
                        b8.getClass();
                        long elapsedRealtime3 = SystemClock.elapsedRealtime();
                        HashMap hashMap = b8.f1925i;
                        if (hashMap.get(enumC0703s3) == null) {
                            aVar = aVar222;
                        } else {
                            aVar = aVar222;
                        }
                        hashMap.put(enumC0703s3, Long.valueOf(elapsedRealtime3));
                        G6 g62 = new G6();
                        g62.f1019Z = EnumC0638h3.f1976Y;
                        g62.f1018Y = EnumC0668m3.f2025Y;
                        g62.f1020x0 = Integer.valueOf(Integer.valueOf(allocationByteCount).intValue() & Integer.MAX_VALUE);
                        g62.f1021x1 = Integer.valueOf(Integer.valueOf(height222).intValue() & Integer.MAX_VALUE);
                        g62.f1022y0 = Integer.valueOf(Integer.valueOf(width222).intValue() & Integer.MAX_VALUE);
                        g62.f1017X = Long.valueOf(Long.valueOf(elapsedRealtime2).longValue() & Long.MAX_VALUE);
                        g62.f1023y1 = Integer.valueOf(Integer.valueOf(i8).intValue() & Integer.MAX_VALUE);
                        C0674n3 c0674n3 = new C0674n3(g62);
                        C0709t3 c0709t3 = new C0709t3(0);
                        c0709t3.f2393x0 = c0674n3;
                        b5 b5Var = new b5(c0709t3);
                        N1.t tVar = b8.f1921e;
                        String a8 = tVar.l() ? (String) tVar.h() : C1985m.f20083c.a(b8.f1923g);
                        Object obj = S2.g.f6481b;
                        S2.p.f6510X.execute(new RunnableC0361e9(b8, b5Var, enumC0703s3, a8, 1));
                        if (Thread.currentThread().isInterrupted()) {
                            return;
                        }
                        N1.t c8 = y2(this.f17550L1, aVar).c(this);
                        c8.getClass();
                        c8.b(N1.j.f5493a, this);
                        c8.m(this);
                        return;
                    }
                    f8 = 1;
                    Matrix matrix2222 = new Matrix();
                    int width322 = bitmap.getWidth();
                    int height322 = bitmap.getHeight();
                    switch (f8) {
                    }
                    if (matrix != null) {
                    }
                    Y2.a aVar2222 = new Y2.a(bitmap);
                    int height2222 = bitmap.getHeight();
                    int width2222 = bitmap.getWidth();
                    allocationByteCount = bitmap.getAllocationByteCount();
                    synchronized (f5.class) {
                    }
                }
            }
            f8 = 0;
            Matrix matrix22222 = new Matrix();
            int width3222 = bitmap.getWidth();
            int height3222 = bitmap.getHeight();
            switch (f8) {
            }
            if (matrix != null) {
            }
            Y2.a aVar22222 = new Y2.a(bitmap);
            int height22222 = bitmap.getHeight();
            int width22222 = bitmap.getWidth();
            allocationByteCount = bitmap.getAllocationByteCount();
            synchronized (f5.class) {
            }
        } catch (FileNotFoundException e10) {
            c1981i.b("MLKitImageUtils", "Could not open file: ".concat(String.valueOf(uri)), e10);
            throw e10;
        }
    }

    public abstract N1.h<T> y2(D d8, Y2.a aVar);
}
