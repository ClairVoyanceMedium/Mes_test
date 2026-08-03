package com.llamalab.automate.stmt;

import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class SetStateAction extends Action {
    public InterfaceC1700x0 state;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.state);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.state);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.state = (InterfaceC1700x0) cVar.readObject();
    }

    public final boolean q(C1708z0 c1708z0, boolean z7) {
        return J3.h.f(c1708z0, this.state, z7);
    }
}
