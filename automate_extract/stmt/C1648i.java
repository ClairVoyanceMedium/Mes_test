package com.llamalab.automate.stmt;

import android.os.ParcelFileDescriptor;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* renamed from: com.llamalab.automate.stmt.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1648i {
    public static byte[] a(Object obj) {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        R3.d dVar = new R3.d(byteArrayOutputStream);
        try {
            dVar.f6414x0 = true;
            dVar.p(1);
            dVar.g(obj);
            dVar.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            dVar.close();
            throw th;
        }
    }

    public static Object b(ParcelFileDescriptor parcelFileDescriptor) {
        R3.c cVar = new R3.c(new BufferedInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), 1024));
        try {
            cVar.f6410y0 = true;
            cVar.n(1);
            return cVar.readObject();
        } finally {
            cVar.close();
        }
    }

    public static Object c(byte[] bArr) {
        R3.c cVar = new R3.c(new ByteArrayInputStream(bArr));
        try {
            cVar.f6410y0 = true;
            cVar.n(1);
            return cVar.readObject();
        } finally {
            cVar.close();
        }
    }
}
