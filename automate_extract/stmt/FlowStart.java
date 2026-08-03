package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.llamalab.automate.A2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.BeginningStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.FlowStore;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.K1;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import g4.C1827a;
import m3.C2145c;
import p3.C2212a;

@F3.f("flow_start.html")
@F3.a(C2541R.integer.ic_gear_play)
@F3.i(C2541R.string.stmt_flow_start_title)
@F3.h(C2541R.string.stmt_flow_start_summary)
@F3.e(C2541R.layout.stmt_flow_start_edit)
/* loaded from: classes.dex */
public final class FlowStart extends Action {
    public InterfaceC1700x0 flowUri;
    public InterfaceC1700x0 payload;
    public boolean stopWithParent;
    public J3.l varChildFiberUri;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_flow_start);
        l8.p(this.flowUri, -2, '/');
        return l8.q(this.flowUri).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (18 <= dVar.f6413Z) {
            dVar.write(this.stopWithParent ? 1 : 0);
        }
        dVar.g(this.flowUri);
        dVar.g(this.payload);
        if (18 <= dVar.f6413Z) {
            dVar.g(this.varChildFiberUri);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.flowUri);
        visitor.b(this.payload);
        visitor.b(this.varChildFiberUri);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (18 <= cVar.f6409x0) {
            this.stopWithParent = cVar.readBoolean();
        }
        this.flowUri = (InterfaceC1700x0) cVar.readObject();
        this.payload = (InterfaceC1700x0) cVar.readObject();
        if (18 <= cVar.f6409x0) {
            this.varChildFiberUri = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_flow_start_title);
        Uri A7 = J3.h.A(c1708z0, this.flowUri, null);
        if (A7 == null) {
            throw new RequiredArgumentNullException("Flow URI");
        }
        Uri a8 = C2212a.a(F5.n.e(c1708z0), A7);
        Object u8 = J3.h.u(c1708z0, this.payload, null);
        boolean z7 = !(u8 instanceof J3.d);
        AutomateService j22 = c1708z0.j2();
        boolean z8 = this.stopWithParent;
        j22.getClass();
        try {
            if (3 != C1827a.m.a(a8)) {
                throw new IllegalArgumentException("Not a flow URI");
            }
            com.llamalab.automate.F0 f8 = j22.f14588S1.f(C2145c.a(a8, 2));
            if (f8 == null) {
                throw new IllegalArgumentException("Flow not found: " + a8);
            }
            A2 b8 = f8.b(C2145c.b(a8, 3));
            if (!(b8 instanceof BeginningStatement)) {
                throw new IllegalArgumentException("Not a beginning block");
            }
            BeginningStatement beginningStatement = (BeginningStatement) b8;
            if (!beginningStatement.G1() && j22.f14588S1.g(f8, beginningStatement)) {
                throw new IllegalStateException("Parallel launch not allowed");
            }
            if (!j22.f(f8, beginningStatement, u8, false)) {
                throw new IllegalStateException(j22.getString(C2541R.string.log_premium_purchase, 30L));
            }
            C1708z0 c1708z02 = new C1708z0(j22, f8, 15, new Object[f8.c(15).f14851b]);
            c1708z02.f17642x0 = beginningStatement;
            c1708z02.f17643x1 = beginningStatement.g();
            if (z8) {
                c1708z02.f17645y1 = c1708z0.f17644y0;
            }
            beginningStatement.l1(c1708z02, u8);
            j22.E(c1708z02, z7);
            j22.Y(c1708z02);
            J3.l lVar = this.varChildFiberUri;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, F5.n.d(c1708z02).toString());
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        } catch (FlowStore.CorruptFlowException e8) {
            Log.e("AutomateService", e8.getMessage(), e8);
            K1.e(j22, e8.f14948X).c(0L, 0L, e8);
            throw e8;
        }
    }
}
