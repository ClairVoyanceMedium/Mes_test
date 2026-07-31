package com.llamalab.automate.stmt;

/* loaded from: classes.dex */
public abstract class IntermittentDecision extends Decision implements IntermittentStatement {
    public Integer continuity;

    @Override // com.llamalab.automate.stmt.IntermittentStatement
    public final int J1(int i8) {
        Integer num = this.continuity;
        return num != null ? num.intValue() : i8;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.continuity);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.continuity = (Integer) cVar.readObject();
    }

    public final void w(R3.c cVar, int i8) {
        super.o0(cVar);
        if (i8 <= cVar.f6409x0) {
            this.continuity = (Integer) cVar.readObject();
        }
    }

    public final void z(R3.d dVar, int i8) {
        super.Y0(dVar);
        if (i8 <= dVar.f6413Z) {
            dVar.g(this.continuity);
        }
    }
}
