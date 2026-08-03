package com.llamalab.automate.stmt;

import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class LevelDecision extends IntermittentDecision {
    public InterfaceC1700x0 maxLevel;
    public InterfaceC1700x0 minLevel;
    public J3.l varLevel;

    public static boolean E(double d8, Double d9, Double d10) {
        return (d9 == null || d8 >= d9.doubleValue()) && (d10 == null || d8 <= d10.doubleValue());
    }

    public final boolean B(C1708z0 c1708z0, boolean z7, Double d8) {
        J3.l lVar = this.varLevel;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, z7);
        return true;
    }

    public final Double C(C1708z0 c1708z0) {
        return J3.h.j(c1708z0, this.maxLevel);
    }

    public final Double D(C1708z0 c1708z0) {
        return J3.h.j(c1708z0, this.minLevel);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.minLevel);
        dVar.g(this.maxLevel);
        dVar.g(this.varLevel);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.minLevel);
        visitor.b(this.maxLevel);
        visitor.b(this.varLevel);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.minLevel = (InterfaceC1700x0) cVar.readObject();
        this.maxLevel = (InterfaceC1700x0) cVar.readObject();
        this.varLevel = (J3.l) cVar.readObject();
    }
}
