package com.llamalab.automate.stmt;

import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public final class L implements Runnable {

    /* renamed from: X, reason: collision with root package name */
    public final /* synthetic */ M f16847X;

    public L(M m8) {
        this.f16847X = m8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        M m8 = this.f16847X;
        m8.getClass();
        m8.r2(new SocketTimeoutException("Network interface unavailable").fillInStackTrace());
    }
}
