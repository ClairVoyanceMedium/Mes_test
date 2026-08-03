package com.llamalab.automate.stmt;

import com.llamalab.automate.stmt.Ping;
import java.net.SocketTimeoutException;

/* renamed from: com.llamalab.automate.stmt.x0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC1678x0 implements Runnable {

    /* renamed from: X, reason: collision with root package name */
    public final /* synthetic */ Ping.b f17566X;

    public RunnableC1678x0(Ping.b bVar) {
        this.f17566X = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ping.b bVar = this.f17566X;
        bVar.getClass();
        bVar.r2(new SocketTimeoutException("Network interface unavailable").fillInStackTrace());
    }
}
