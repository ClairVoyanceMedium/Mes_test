package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Bundle;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredVariableMissingException;
import com.llamalab.automate.Visitor;

@F3.f("atomic_cas.html")
@F3.a(C2541R.integer.ic_atomic_store)
@F3.i(C2541R.string.stmt_atomic_cas_title)
@F3.h(C2541R.string.stmt_atomic_cas_summary)
@F3.e(C2541R.layout.stmt_atomic_cas_edit)
/* loaded from: classes.dex */
public final class AtomicCompareAndStore extends AtomicDecision {
    public InterfaceC1700x0 expect;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_atomic_cas);
        l8.v(this.varAtomic, 0);
        l8.v(this.expect, 0);
        l8.r(C2541R.string.caption_null);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.AtomicDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.expect);
    }

    @Override // com.llamalab.automate.stmt.AtomicDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.expect);
    }

    @Override // com.llamalab.automate.stmt.AtomicDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.expect = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_atomic_cas_title);
        J3.l lVar = this.varAtomic;
        if (lVar == null) {
            throw new RequiredVariableMissingException("varAtomic");
        }
        Object j8 = c1708z0.j(lVar.f4659Y);
        Object u8 = J3.h.u(c1708z0, this.expect, null);
        com.llamalab.automate.F0 f02 = c1708z0.f17641Z;
        Bundle x7 = H1.b.x(f02.f14848y1, this.varAtomic.f4659Y, f02.f14847y0);
        x7.putByteArray("data", C1648i.a(j8));
        x7.putByteArray("expect", C1648i.a(u8));
        Bundle V7 = c1708z0.j2().V("variablesModify", x7);
        Exception exc = (Exception) V7.getSerializable("exception");
        if (exc != null) {
            throw exc;
        }
        o(c1708z0, V7.getBoolean("success"));
        return true;
    }
}
