package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.Uri;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.L1;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import g4.C1827a;
import java.util.IdentityHashMap;
import m3.C2145c;

@F3.f("variables_give.html")
@F3.a(C2541R.integer.ic_var_give)
@F3.i(C2541R.string.stmt_variables_give_title)
@F3.h(C2541R.string.stmt_variables_give_summary)
@F3.e(C2541R.layout.stmt_variables_give_edit)
/* loaded from: classes.dex */
public class VariablesGive extends Action {
    public L1<VariablesTake> taker = new L1<>(null);
    public InterfaceC1700x0 takerFiberUri;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_variables_give);
        VariablesTake variablesTake = this.taker.f15102X;
        if (variablesTake == null) {
            l8.k(false);
        } else {
            l8.m(C2541R.string.caption_to_id, Long.valueOf(variablesTake.g()), variablesTake.A(context));
        }
        l8.v(this.takerFiberUri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.taker.f15102X);
        dVar.g(this.takerFiberUri);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.taker);
        visitor.b(this.takerFiberUri);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new r1();
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.taker = new L1<>((VariablesTake) cVar.readObject());
        this.takerFiberUri = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_variables_give_title);
        VariablesTake variablesTake = this.taker.f15102X;
        if (variablesTake == null) {
            throw new IllegalStateException("No take block");
        }
        Uri A7 = J3.h.A(c1708z0, this.takerFiberUri, null);
        if (A7 == null) {
            throw new RequiredArgumentNullException("Fiber URI");
        }
        AutomateService j22 = c1708z0.j2();
        if (5 != C1827a.m.a(A7)) {
            throw new IllegalArgumentException("Not a flow fiber URI");
        }
        if (c1708z0.f17641Z.f14847y0 != C2145c.b(A7, 1)) {
            throw new IllegalArgumentException("Flow mismatch");
        }
        if (c1708z0.f17644y0 == C2145c.b(A7, 3)) {
            variablesTake.B(c1708z0, variablesTake.C(c1708z0, new IdentityHashMap<>()));
        } else {
            C1708z0 v8 = j22.v(A7);
            if (v8 != null) {
                variablesTake.B(v8, variablesTake.C(c1708z0, null));
                j22.g(v8);
                j22.f14588S1.f14942a.remove(Long.valueOf(v8.f17644y0));
                if (v8.g() == variablesTake.f16218X) {
                    j22.Y(v8);
                }
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
