package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("array_add.html")
@F3.a(C2541R.integer.ic_array_add)
@F3.i(C2541R.string.stmt_array_add_title)
@F3.h(C2541R.string.stmt_array_add_summary)
@F3.e(C2541R.layout.stmt_array_add_edit)
/* loaded from: classes.dex */
public class ArrayAdd extends ArraySubscriptAction {
    public InterfaceC1700x0 value;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_array_add);
        l8.v(this.value, 0);
        l8.u(C2541R.string.caption_to, this.varArray);
        l8.u(C2541R.string.caption_at, this.index);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ArraySubscriptAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.value);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.index);
        visitor.b(this.varArray);
        visitor.b(this.value);
    }

    @Override // com.llamalab.automate.stmt.ArraySubscriptAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.value = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_array_add_title);
        J3.a q8 = q(c1708z0);
        int m8 = J3.h.m(c1708z0, this.index, q8.f4627Y);
        Object u8 = J3.h.u(c1708z0, this.value, null);
        int i8 = y4.j.i(m8, q8.f4627Y);
        int i9 = q8.f4627Y;
        if (i8 < i9) {
            q8.j(i9 + 1);
            Object[] objArr = q8.f4626X;
            int i10 = q8.f4627Y;
            q8.f4627Y = i10 + 1;
            System.arraycopy(objArr, i8, objArr, i8 + 1, i10 - i8);
            q8.f4626X[i8] = u8;
        } else {
            int i11 = i8 + 1;
            q8.j(i11);
            q8.f4626X[i8] = u8;
            q8.f4627Y = i11;
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
