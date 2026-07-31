package com.llamalab.automate.stmt;

import com.llamalab.automate.A2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.Visitor;

@F3.b(C2541R.layout.block_action)
/* loaded from: classes.dex */
public abstract class Action extends AbstractStatement {

    @F3.d(C2541R.id.bottom)
    public A2 onComplete;

    @Override // com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.onComplete);
    }

    public void a(Visitor visitor) {
        visitor.b(this.onComplete);
    }

    public final void o(R3.c cVar) {
        super.o0(cVar);
        if (26 <= cVar.f6409x0) {
            this.onComplete = (A2) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.onComplete = (A2) cVar.readObject();
    }

    public final void p(R3.d dVar) {
        super.Y0(dVar);
        if (26 <= dVar.f6413Z) {
            dVar.g(this.onComplete);
        }
    }
}
