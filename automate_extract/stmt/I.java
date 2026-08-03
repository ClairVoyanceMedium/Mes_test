package com.llamalab.automate.stmt;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class I<T> extends com.llamalab.automate.W implements N1.c<T> {

    /* renamed from: y1, reason: collision with root package name */
    public final boolean f16708y1;

    public I(boolean z7) {
        this.f16708y1 = z7;
    }

    @Override // N1.c
    public final void S0(N1.h<T> hVar) {
        if (this.f16708y1) {
            F5.n.f(this, "GoogleApiFailureTask onComplete: success=" + hVar.l());
        }
        try {
            if (hVar.l()) {
                a();
            } else {
                if (hVar.j()) {
                    throw new CancellationException();
                }
                Exception g8 = hVar.g();
                if (g8 == null) {
                    throw new IllegalStateException("Unknown error");
                }
            }
        } catch (Throwable th) {
            r2(th);
        }
    }
}
