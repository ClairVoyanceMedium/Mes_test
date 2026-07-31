package com.llamalab.automate.stmt;

import com.llamalab.automate.A2;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1704y0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.a(C2541R.integer.ic_action_error)
@F3.f("failure_catch.html")
@F3.i(C2541R.string.stmt_failure_catch_title)
@F3.h(C2541R.string.stmt_failure_catch_summary)
@F3.c(C2541R.string.caption_failure_catch)
@F3.b(C2541R.layout.block_failure_catch)
@F3.e(C2541R.layout.stmt_failure_catch_edit)
/* loaded from: classes.dex */
public final class FailureCatch extends Action implements InterfaceC1622q2 {

    /* renamed from: L1, reason: collision with root package name */
    public int f16618L1 = -1;

    @F3.d(C2541R.id.right)
    public A2 onFailure;
    public InterfaceC1700x0 retryLimit;
    public J3.l varFailureMessage;
    public J3.l varFailureStatementId;
    public J3.l varFailureType;
    public J3.l varRetryCount;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.onFailure);
        dVar.g(this.retryLimit);
        dVar.g(this.varRetryCount);
        dVar.g(this.varFailureStatementId);
        dVar.g(this.varFailureType);
        dVar.g(this.varFailureMessage);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.onFailure);
        visitor.b(this.retryLimit);
        visitor.b(this.varRetryCount);
        visitor.b(this.varFailureStatementId);
        visitor.b(this.varFailureType);
        visitor.b(this.varFailureMessage);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f16618L1 = c1625r2.d(false);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.onFailure = (A2) cVar.readObject();
        this.retryLimit = (InterfaceC1700x0) cVar.readObject();
        this.varRetryCount = (J3.l) cVar.readObject();
        this.varFailureStatementId = (J3.l) cVar.readObject();
        this.varFailureType = (J3.l) cVar.readObject();
        this.varFailureMessage = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_failure_catch_title);
        c1708z0.z(this.f16618L1, null);
        if (this.onFailure != null) {
            C1704y0 c1704y0 = (C1704y0) c1708z0.c(C1704y0.class);
            if (c1704y0 != null) {
                c1704y0.a();
            } else {
                c1704y0 = new C1704y0();
            }
            c1708z0.w(c1704y0);
        } else {
            c1708z0.H(C1704y0.class);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
