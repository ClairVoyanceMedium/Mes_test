package com.llamalab.automate.stmt;

import com.llamalab.automate.J1;

/* loaded from: classes.dex */
public final class l1 extends J1 {

    /* renamed from: L1, reason: collision with root package name */
    public final int f17469L1;

    public l1(int i8) {
        this.f17469L1 = i8;
    }

    @Override // com.llamalab.automate.J1
    public final void w2(O3.a aVar) {
        try {
            t3.l lVar = new t3.l();
            aVar.f(this.f17469L1, lVar);
            lVar.c();
            p2(null);
        } catch (Throwable th) {
            r2(th);
        }
    }
}
