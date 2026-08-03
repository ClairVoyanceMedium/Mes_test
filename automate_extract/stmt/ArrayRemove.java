package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.Visitor;

@F3.f("array_remove.html")
@F3.a(C2541R.integer.ic_array_remove)
@F3.i(C2541R.string.stmt_array_remove_title)
@F3.h(C2541R.string.stmt_array_remove_summary)
@F3.e(C2541R.layout.stmt_array_remove_edit)
/* loaded from: classes.dex */
public class ArrayRemove extends ArraySubscriptAction {
    public J3.l varOldValue;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_array_remove);
        l8.v(this.varArray, 0);
        l8.u(C2541R.string.caption_at, this.index);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ArraySubscriptAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (2 <= dVar.f6413Z) {
            dVar.g(this.varOldValue);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.index);
        visitor.b(this.varArray);
        visitor.b(this.varOldValue);
    }

    @Override // com.llamalab.automate.stmt.ArraySubscriptAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (2 <= cVar.f6409x0) {
            this.varOldValue = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_array_remove_title);
        J3.a q8 = q(c1708z0);
        int m8 = J3.h.m(c1708z0, this.index, 0);
        J3.l lVar = this.varOldValue;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, q8.remove(m8));
        } else {
            q8.remove(m8);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
