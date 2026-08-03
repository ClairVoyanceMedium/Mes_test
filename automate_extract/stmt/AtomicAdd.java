package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Bundle;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredVariableMissingException;
import com.llamalab.automate.Visitor;

@F3.f("atomic_add.html")
@F3.a(C2541R.integer.ic_atomic_add)
@F3.i(C2541R.string.stmt_atomic_add_title)
@F3.h(C2541R.string.stmt_atomic_add_summary)
@F3.e(C2541R.layout.stmt_atomic_add_edit)
/* loaded from: classes.dex */
public class AtomicAdd extends AtomicAction {
    public InterfaceC1700x0 delta;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_atomic_add);
        l8.v(this.varAtomic, 0);
        l8.v(this.delta, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.AtomicAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.delta);
    }

    @Override // com.llamalab.automate.stmt.AtomicAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.delta);
    }

    @Override // com.llamalab.automate.stmt.AtomicAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.delta = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_atomic_add_title);
        if (this.varAtomic == null) {
            throw new RequiredVariableMissingException("varAtomic");
        }
        double i8 = J3.h.i(c1708z0, this.delta, 0.0d);
        com.llamalab.automate.F0 f02 = c1708z0.f17641Z;
        Bundle x7 = H1.b.x(f02.f14848y1, this.varAtomic.f4659Y, f02.f14847y0);
        x7.putDouble("delta", i8);
        Bundle V7 = c1708z0.j2().V("variablesModify", x7);
        Exception exc = (Exception) V7.getSerializable("exception");
        if (exc != null) {
            throw exc;
        }
        J3.l lVar = this.varAtomic;
        c1708z0.z(lVar.f4659Y, Double.valueOf(V7.getDouble("value")));
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
