package com.llamalab.automate.stmt;

import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1622q2;

/* loaded from: classes.dex */
public abstract class StatefulIntermittentDecision extends IntermittentDecision implements InterfaceC1622q2 {

    /* renamed from: L1, reason: collision with root package name */
    public int f17164L1 = -1;

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f17164L1 = c1625r2.d(false);
    }

    @Override // com.llamalab.automate.stmt.Decision
    public final void o(C1708z0 c1708z0, boolean z7) {
        c1708z0.z(this.f17164L1, Boolean.valueOf(z7));
        super.o(c1708z0, z7);
    }
}
