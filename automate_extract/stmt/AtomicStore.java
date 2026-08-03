package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Bundle;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.RequiredVariableMissingException;

@F3.f("atomic_store.html")
@F3.a(C2541R.integer.ic_atomic_store)
@F3.i(C2541R.string.stmt_atomic_store_title)
@F3.h(C2541R.string.stmt_atomic_store_summary)
@F3.e(C2541R.layout.stmt_atomic_store_edit)
/* loaded from: classes.dex */
public final class AtomicStore extends AtomicAction {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_atomic_store);
        l8.v(this.varAtomic, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_atomic_store_title);
        J3.l lVar = this.varAtomic;
        if (lVar == null) {
            throw new RequiredVariableMissingException("varAtomic");
        }
        Object j8 = c1708z0.j(lVar.f4659Y);
        com.llamalab.automate.F0 f02 = c1708z0.f17641Z;
        Bundle x7 = H1.b.x(f02.f14848y1, this.varAtomic.f4659Y, f02.f14847y0);
        x7.putByteArray("data", C1648i.a(j8));
        Exception exc = (Exception) c1708z0.j2().V("variablesModify", x7).getSerializable("exception");
        if (exc != null) {
            throw exc;
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
