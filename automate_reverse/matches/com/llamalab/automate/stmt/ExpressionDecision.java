package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("expression_decision.html")
@F3.a(C2541R.integer.ic_formula)
@F3.i(C2541R.string.stmt_expression_decision_title)
@F3.h(C2541R.string.stmt_expression_decision_summary)
@F3.e(C2541R.layout.stmt_expression_decision_edit)
/* loaded from: classes.dex */
public class ExpressionDecision extends Decision {
    public InterfaceC1700x0 expression;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).v(this.expression, 0).r(C2541R.string.caption_expression_decision).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.expression);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.expression);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.expression = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_expression_decision_title);
        o(c1708z0, J3.h.f(c1708z0, this.expression, false));
        return true;
    }
}
