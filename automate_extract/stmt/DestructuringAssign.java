package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredVariableMissingException;
import com.llamalab.automate.Visitor;

@F3.f("destructuring_assign.html")
@F3.a(C2541R.integer.ic_var_assign)
@F3.i(C2541R.string.stmt_destructuring_assign_title)
@F3.h(C2541R.string.stmt_destructuring_assign_summary)
@F3.e(C2541R.layout.stmt_destructuring_assign_edit)
/* loaded from: classes.dex */
public final class DestructuringAssign extends Action {
    public InterfaceC1700x0 value;
    public J3.l[] variables = J3.l.f4657Z;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_destructuring_assign);
        J3.l[] lVarArr = this.variables;
        if (lVarArr != null) {
            for (J3.l lVar : lVarArr) {
                l8.v(lVar, 0);
            }
        }
        if (l8.f16031d) {
            l8.B(C2541R.string.caption_from);
        } else {
            l8.k(false);
        }
        return l8.b(this.value).s("null").f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.value);
        dVar.h(this.variables);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.value);
        visitor.a(this.variables);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.value = (InterfaceC1700x0) cVar.readObject();
        this.variables = (J3.l[]) cVar.g(this.variables);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_destructuring_assign_title);
        if (this.variables.length == 0) {
            throw new RequiredVariableMissingException("variables");
        }
        Object obj = new Object();
        Object u8 = J3.h.u(c1708z0, this.value, obj);
        int i8 = 0;
        if (u8 instanceof J3.a) {
            J3.a aVar = (J3.a) u8;
            int min = Math.min(aVar.f4627Y, this.variables.length);
            while (i8 < min) {
                J3.l lVar = this.variables[i8];
                if (lVar != null) {
                    c1708z0.z(lVar.f4659Y, aVar.get(i8));
                }
                i8++;
            }
        } else if (u8 != obj) {
            throw new IllegalArgumentException("Value not an array or null");
        }
        int length = this.variables.length;
        while (i8 < length) {
            J3.l lVar2 = this.variables[i8];
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, null);
            }
            i8++;
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
