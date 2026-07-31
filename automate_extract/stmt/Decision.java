package com.llamalab.automate.stmt;

import com.llamalab.automate.A2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.Visitor;

@F3.b(C2541R.layout.block_decision)
/* loaded from: classes.dex */
public abstract class Decision extends AbstractStatement {

    @F3.d(C2541R.id.right)
    public A2 onNegative;

    @F3.d(C2541R.id.bottom)
    public A2 onPositive;

    @Override // com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.onPositive);
        dVar.g(this.onNegative);
        u(dVar);
    }

    public void a(Visitor visitor) {
        visitor.b(this.onPositive);
        visitor.b(this.onNegative);
        r(visitor);
    }

    public void o(C1708z0 c1708z0, boolean z7) {
        c1708z0.f17642x0 = z7 ? this.onPositive : this.onNegative;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.onPositive = (A2) cVar.readObject();
        this.onNegative = (A2) cVar.readObject();
        q(cVar);
    }

    public final void p(R3.c cVar, int i8) {
        super.o0(cVar);
        this.onPositive = (A2) cVar.readObject();
        if (i8 <= cVar.f6409x0) {
            this.onNegative = (A2) cVar.readObject();
        }
    }

    public void q(R3.c cVar) {
    }

    public void r(Visitor visitor) {
    }

    public final void s(R3.d dVar, int i8) {
        super.Y0(dVar);
        dVar.g(this.onPositive);
        if (i8 <= dVar.f6413Z) {
            dVar.g(this.onNegative);
        }
    }

    public void u(R3.d dVar) {
    }
}
