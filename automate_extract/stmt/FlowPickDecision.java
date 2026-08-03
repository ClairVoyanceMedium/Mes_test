package com.llamalab.automate.stmt;

import com.llamalab.automate.C1708z0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class FlowPickDecision extends ActivityDecision {
    public J3.l varFlowDescription;
    public J3.l varFlowTitle;
    public J3.l varFlowUri;

    public final void C(C1708z0 c1708z0, boolean z7, String str, CharSequence charSequence, CharSequence charSequence2) {
        J3.l lVar = this.varFlowUri;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varFlowTitle;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, charSequence != null ? charSequence.toString() : null);
        }
        J3.l lVar3 = this.varFlowDescription;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, charSequence2 != null ? charSequence2.toString() : null);
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varFlowUri);
        dVar.g(this.varFlowTitle);
        dVar.g(this.varFlowDescription);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varFlowUri);
        visitor.b(this.varFlowTitle);
        visitor.b(this.varFlowDescription);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.varFlowUri = (J3.l) cVar.readObject();
        this.varFlowTitle = (J3.l) cVar.readObject();
        this.varFlowDescription = (J3.l) cVar.readObject();
    }
}
