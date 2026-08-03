package com.llamalab.automate.stmt;

import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.InterfaceC1585h1;

/* loaded from: classes.dex */
public final class m1 extends AbstractC1602l2 {

    /* renamed from: M1, reason: collision with root package name */
    public final int f17474M1;

    public m1(int i8) {
        this.f17474M1 = i8;
    }

    @Override // com.llamalab.automate.AbstractC1602l2
    public final void w2(InterfaceC1585h1 interfaceC1585h1) {
        try {
            t3.l lVar = new t3.l();
            interfaceC1585h1.f(this.f17474M1, lVar);
            lVar.c();
            p2(null);
        } catch (Throwable th) {
            r2(th);
        }
    }
}
