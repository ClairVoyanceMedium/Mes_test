package com.llamalab.automate.stmt;

import com.llamalab.automate.stmt.WakeOnLanSend;
import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public final class v1 implements Runnable {

    /* renamed from: X, reason: collision with root package name */
    public final /* synthetic */ WakeOnLanSend.b f17557X;

    public v1(WakeOnLanSend.b bVar) {
        this.f17557X = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WakeOnLanSend.b bVar = this.f17557X;
        bVar.getClass();
        bVar.r2(new SocketTimeoutException("Network interface unavailable").fillInStackTrace());
    }
}
