package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.Uri;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import g4.C1827a;

@F3.f("flow_stop.html")
@F3.a(C2541R.integer.ic_stop_hand)
@F3.i(C2541R.string.stmt_flow_stop_title)
@F3.h(C2541R.string.stmt_flow_stop_summary)
@F3.e(C2541R.layout.stmt_flow_stop_edit)
/* loaded from: classes.dex */
public final class FlowStop extends Action {
    public InterfaceC1700x0 flowUri;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_flow_stop);
        l8.p(this.flowUri, -2, '/');
        return l8.q(this.flowUri).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        p(dVar);
        if (26 <= dVar.f6413Z) {
            dVar.g(this.flowUri);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.flowUri);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        o(cVar);
        if (26 <= cVar.f6409x0) {
            this.flowUri = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_flow_stop_title);
        Uri A7 = J3.h.A(c1708z0, this.flowUri, F5.n.e(c1708z0));
        AutomateService j22 = c1708z0.j2();
        j22.getClass();
        if (2 != C1827a.m.a(A7)) {
            throw new IllegalArgumentException("Not a flow URI");
        }
        boolean[] zArr = new boolean[1];
        j22.M(A7, C2541R.string.log_fiber_stop_block, new X0.i(zArr, c1708z0));
        if (zArr[0]) {
            return false;
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
