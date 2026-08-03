package com.llamalab.automate.expr.func;

import J3.h;
import com.llamalab.automate.C1708z0;
import x3.C2440r;

/* loaded from: classes.dex */
public class Glob extends BinaryFunction {
    public static final String NAME = "glob";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        Object c23 = this.f4951Y.c2(c1708z0);
        return Double.valueOf(h.Y((c22 == null || c23 == null || !C2440r.v(h.e0(c23), h.e0(c22))) ? false : true));
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
