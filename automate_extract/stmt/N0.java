package com.llamalab.automate.stmt;

import com.llamalab.android.system.MoreOsConstants;
import h4.C1883i;
import h4.C1885k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public abstract class N0 implements X {

    /* renamed from: a, reason: collision with root package name */
    public final C1883i f16946a;

    /* renamed from: b, reason: collision with root package name */
    public final C1885k f16947b;

    public N0(byte[] bArr) {
        if (bArr == null) {
            this.f16946a = new C1883i();
            this.f16947b = new C1885k();
            return;
        }
        R3.c cVar = new R3.c(new ByteArrayInputStream(bArr));
        try {
            cVar.f6410y0 = true;
            cVar.n(1);
            this.f16946a = new C1883i(cVar);
            this.f16947b = new C1885k(cVar);
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
            this.f16946a.a(dVar);
            this.f16947b.c(dVar);
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
