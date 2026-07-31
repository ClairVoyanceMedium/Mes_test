package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.automate.BeginningStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.Visitor;

@F3.f("flow_beginning.html")
@F3.a(C2541R.integer.ic_gear)
@F3.i(C2541R.string.stmt_flow_beginning_title)
@F3.h(C2541R.string.stmt_flow_beginning_summary)
@F3.b(C2541R.layout.block_beginning)
@F3.e(C2541R.layout.stmt_flow_beginning_edit)
/* loaded from: classes.dex */
public final class FlowBeginning extends Action implements BeginningStatement {
    public boolean hidden;
    public boolean parallel;
    public String title;

    @Deprecated
    public J3.l varFiberUri;
    public J3.l varPayload;

    @Override // com.llamalab.automate.BeginningStatement
    public final boolean G1() {
        return this.parallel;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 33 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.f15544e, com.llamalab.automate.access.c.f15548i, com.llamalab.automate.access.c.j("android.permission.POST_NOTIFICATIONS")} : 23 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.f15544e, com.llamalab.automate.access.c.f15548i} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_flow_beginning_title);
        l8.C(this.title);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.k(this.title);
        if (66 <= dVar.f6413Z) {
            dVar.write(this.hidden ? 1 : 0);
        }
        dVar.write(this.parallel ? 1 : 0);
        dVar.g(this.varPayload);
        if (43 <= dVar.f6413Z) {
            dVar.g(this.varFiberUri);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.varPayload);
        visitor.b(this.varFiberUri);
    }

    @Override // com.llamalab.automate.BeginningStatement
    public final String a0() {
        return this.title;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new G();
    }

    @Override // com.llamalab.automate.BeginningStatement
    public final void l1(C1708z0 c1708z0, Object obj) {
        J3.l lVar = this.varPayload;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
    }

    @Override // com.llamalab.automate.BeginningStatement
    public final boolean n() {
        return this.hidden;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.title = cVar.i();
        if (66 <= cVar.f6409x0) {
            this.hidden = cVar.readBoolean();
        }
        this.parallel = cVar.readBoolean();
        this.varPayload = (J3.l) cVar.readObject();
        if (43 <= cVar.f6409x0) {
            this.varFiberUri = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_flow_beginning_title);
        J3.l lVar = this.varFiberUri;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, F5.n.d(c1708z0).toString());
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
