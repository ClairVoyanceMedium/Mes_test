package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.InterfaceC1590i2;
import com.llamalab.automate.InterfaceC1606m2;
import com.llamalab.image.PixelFormat;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public final class O extends com.llamalab.automate.W implements InterfaceC1590i2 {

    /* renamed from: M1, reason: collision with root package name */
    public PixelFormat f17001M1;

    /* renamed from: N1, reason: collision with root package name */
    public PixelFormat f17002N1;

    /* renamed from: O1, reason: collision with root package name */
    public String f17003O1;

    /* renamed from: P1, reason: collision with root package name */
    public int f17004P1;

    /* renamed from: Q1, reason: collision with root package name */
    public int f17005Q1;

    /* renamed from: y1, reason: collision with root package name */
    public WeakReference<MappedByteBuffer> f17006y1 = new WeakReference<>(null);

    /* renamed from: L1, reason: collision with root package name */
    public WeakReference<MappedByteBuffer> f17000L1 = new WeakReference<>(null);

    public O() {
        PixelFormat pixelFormat = PixelFormat.UNKNOWN;
        this.f17001M1 = pixelFormat;
        this.f17002N1 = pixelFormat;
    }

    public static File x2(Context context, InterfaceC1606m2 interfaceC1606m2, String str) {
        return new File(context.getCacheDir(), "image-" + interfaceC1606m2.h1() + str);
    }

    public static MappedByteBuffer z2(File file, int i8) {
        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
        try {
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, i8);
            channel.close();
            return map;
        } catch (Throwable th) {
            if (channel != null) {
                try {
                    channel.close();
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
    public final void F(AutomateService automateService) {
        u2();
        x2(automateService, this, ".bmp").delete();
        x2(automateService, this, ".plt").delete();
    }

    @Override // com.llamalab.automate.W, R3.e
    public final void Y0(R3.d dVar) {
        dVar.d(this.f15404y0);
        dVar.c(this.f17001M1.ordinal());
        dVar.c(this.f17002N1.ordinal());
        dVar.k(this.f17003O1);
        dVar.c(this.f17004P1);
        dVar.c(this.f17005Q1);
    }

    @Override // com.llamalab.automate.W, R3.e
    public final void o0(R3.c cVar) {
        this.f15404y0 = cVar.b();
        PixelFormat[] values = PixelFormat.values();
        this.f17001M1 = values[cVar.a()];
        this.f17002N1 = values[cVar.a()];
        this.f17003O1 = cVar.i();
        this.f17004P1 = cVar.a();
        this.f17005Q1 = cVar.a();
    }

    public final MappedByteBuffer v2(AutomateService automateService) {
        MappedByteBuffer mappedByteBuffer = this.f17006y1.get();
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        MappedByteBuffer z22 = z2(x2(automateService, this, ".bmp"), this.f17001M1.getBitmapSize(this.f17004P1, this.f17005Q1));
        this.f17006y1 = new WeakReference<>(z22);
        return z22;
    }

    public final MappedByteBuffer w2(AutomateService automateService, int i8) {
        if (i8 <= this.f17001M1.getBitmapSize(this.f17004P1, this.f17005Q1)) {
            return v2(automateService);
        }
        this.f17006y1.clear();
        MappedByteBuffer z22 = z2(x2(automateService, this, ".bmp"), i8);
        this.f17006y1 = new WeakReference<>(z22);
        return z22;
    }

    public final MappedByteBuffer y2(AutomateService automateService) {
        MappedByteBuffer mappedByteBuffer = this.f17000L1.get();
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        MappedByteBuffer z22 = z2(x2(automateService, this, ".plt"), this.f17002N1.getPaletteSize(this.f17001M1.getPaletteEntryCount()));
        this.f17000L1 = new WeakReference<>(z22);
        return z22;
    }
}
