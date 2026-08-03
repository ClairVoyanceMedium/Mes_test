package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredVariableMissingException;
import com.llamalab.automate.Visitor;

@F3.f("variable_assign.html")
@F3.a(C2541R.integer.ic_var_assign)
@F3.i(C2541R.string.stmt_variable_assign_title)
@F3.h(C2541R.string.stmt_variable_assign_summary)
@F3.e(C2541R.layout.stmt_variable_assign_edit)
/* loaded from: classes.dex */
public class VariableAssign extends Action {
    public InterfaceC1700x0 value;
    public J3.l variable;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_variable_assign);
        l8.v(this.variable, 0);
        if (l8.f16031d) {
            l8.B(C2541R.string.caption_to);
        } else {
            l8.k(false);
        }
        return l8.b(this.value).s("null").f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.value);
        dVar.g(this.variable);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.value);
        visitor.b(this.variable);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.value = (InterfaceC1700x0) cVar.readObject();
        this.variable = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_variable_assign_title);
        J3.l lVar = this.variable;
        if (lVar == null) {
            throw new RequiredVariableMissingException("variable");
        }
        c1708z0.z(lVar.f4659Y, J3.h.u(c1708z0, this.value, null));
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
