package com.llamalab.automate.stmt;

import com.llamalab.automate.stmt.C1677x;

/* renamed from: com.llamalab.automate.stmt.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1675w extends Thread {

    /* renamed from: X, reason: collision with root package name */
    public final /* synthetic */ int f17558X;

    /* renamed from: Y, reason: collision with root package name */
    public final /* synthetic */ C1677x.a f17559Y;

    /* renamed from: Z, reason: collision with root package name */
    public final /* synthetic */ C1677x f17560Z;

    public C1675w(C1677x c1677x, int i8, C1677x.a aVar) {
        this.f17560Z = c1677x;
        this.f17558X = i8;
        this.f17559Y = aVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        C1677x c1677x = this.f17560Z;
        try {
            C1677x.v2(c1677x, this.f17558X);
            C1677x.a aVar = this.f17559Y;
            Object a8 = aVar != null ? aVar.a(c1677x, c1677x.f17563L1) : null;
            long j8 = c1677x.f17563L1.inTransaction() ? 300000L : 30000L;
            c1677x.f17564M1 = null;
            c1677x.o2(j8, a8);
        } finally {
            try {
            } finally {
            }
        }
    }
}
