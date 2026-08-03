package com.llamalab.automate.stmt;

import com.llamalab.android.system.MoreOsConstants;
import h4.C1883i;
import h4.C1885k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* renamed from: com.llamalab.automate.stmt.s0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1668s0 implements X {

    /* renamed from: a, reason: collision with root package name */
    public final C1883i f17518a;

    /* renamed from: b, reason: collision with root package name */
    public final C1885k f17519b;

    /* renamed from: c, reason: collision with root package name */
    public final C1885k f17520c;

    /* renamed from: d, reason: collision with root package name */
    public final C1885k f17521d;

    public C1668s0(byte[] bArr) {
        if (bArr == null) {
            this.f17518a = new C1883i();
            this.f17519b = new C1885k();
            this.f17520c = new C1885k();
            this.f17521d = new C1885k();
            return;
        }
        R3.c cVar = new R3.c(new ByteArrayInputStream(bArr));
        try {
            cVar.f6410y0 = true;
            cVar.n(1);
            this.f17518a = new C1883i(cVar);
            this.f17519b = new C1885k(cVar);
            this.f17520c = new C1885k(cVar);
            this.f17521d = new C1885k(cVar);
            cVar.close();
        } catch (Throwable th) {
            try {
                cVar.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }

    @Override // com.llamalab.automate.stmt.X
    public final byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(MoreOsConstants.O_DSYNC);
        R3.d dVar = new R3.d(byteArrayOutputStream);
        try {
            dVar.f6414x0 = true;
            dVar.p(1);
            this.f17518a.a(dVar);
            this.f17519b.c(dVar);
            this.f17520c.c(dVar);
            this.f17521d.c(dVar);
            dVar.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                dVar.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }
}
