package com.llamalab.automate.stmt;

import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import g4.C1827a;

@F3.f("atomic_clear_all.html")
@F3.a(C2541R.integer.ic_atomic_clear)
@F3.i(C2541R.string.stmt_atomic_clear_all_title)
@F3.h(C2541R.string.stmt_atomic_clear_all_summary)
@F3.c(C2541R.string.caption_atomic_clear_all)
@F3.e(C2541R.layout.stmt_atomic_clear_all_edit)
/* loaded from: classes.dex */
public class AtomicClearAll extends Action {
    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_atomic_clear_all_title);
        com.llamalab.automate.F0 f02 = c1708z0.f17641Z;
        c1708z0.j2().f14586Q1.delete(C1827a.g.a(f02.f14847y0).appendEncodedPath("variables").build(), "flow_version=" + f02.f14848y1, null);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
