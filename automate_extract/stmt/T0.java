package com.llamalab.automate.stmt;

import android.graphics.Bitmap;
import android.os.Environment;
import com.llamalab.automate.C2541R;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class T0 extends Thread {

    /* renamed from: X, reason: collision with root package name */
    public final /* synthetic */ Bitmap f17188X;

    /* renamed from: Y, reason: collision with root package name */
    public final /* synthetic */ S0 f17189Y;

    public T0(S0 s02, Bitmap bitmap) {
        this.f17189Y = s02;
        this.f17188X = bitmap;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        S0 s02 = this.f17189Y;
        Bitmap bitmap = this.f17188X;
        try {
        } finally {
            try {
            } finally {
            }
        }
        if (!s02.f17078M1.get() && !isInterrupted()) {
            com.llamalab.safs.n t8 = w0.L.t(s02.f17079N1, Environment.DIRECTORY_DCIM, null, C2541R.string.format_image_file, "png");
            OutputStream l8 = com.llamalab.safs.i.l(t8, new com.llamalab.safs.l[0]);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, l8);
                if (l8 != null) {
                    l8.close();
                }
                if (!s02.f17078M1.get() && !isInterrupted()) {
                    s02.q2(t8.toString(), false);
                }
            } catch (Throwable th) {
                if (l8 != null) {
                    try {
                        l8.close();
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
    }
}
