package com.llamalab.automate.stmt;

import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class AtomicDecision extends Decision {
    public J3.l varAtomic;

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varAtomic);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varAtomic);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.varAtomic = (J3.l) cVar.readObject();
    }
}
