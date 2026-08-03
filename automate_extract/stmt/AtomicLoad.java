package com.llamalab.automate.stmt;

import android.content.Context;
import android.database.Cursor;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.RequiredVariableMissingException;
import g4.C1827a;

@F3.f("atomic_load.html")
@F3.a(C2541R.integer.ic_atomic_load)
@F3.i(C2541R.string.stmt_atomic_load_title)
@F3.h(C2541R.string.stmt_atomic_load_summary)
@F3.e(C2541R.layout.stmt_atomic_load_edit)
/* loaded from: classes.dex */
public final class AtomicLoad extends AtomicAction {

    /* renamed from: L1, reason: collision with root package name */
    public static final String[] f16278L1 = {"data"};

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_atomic_load);
        l8.v(this.varAtomic, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_atomic_load_title);
        if (this.varAtomic == null) {
            throw new RequiredVariableMissingException("varAtomic");
        }
        com.llamalab.automate.F0 f02 = c1708z0.f17641Z;
        Cursor query = c1708z0.j2().f14586Q1.query(C1827a.g.a(f02.f14847y0).appendEncodedPath("variables").build(), f16278L1, "flow_version=" + f02.f14848y1 + " and register=" + this.varAtomic.f4659Y, null, null);
        try {
            c1708z0.z(this.varAtomic.f4659Y, query.moveToFirst() ? C1648i.c(query.getBlob(0)) : null);
            query.close();
            c1708z0.f17642x0 = this.onComplete;
            return true;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }
}
