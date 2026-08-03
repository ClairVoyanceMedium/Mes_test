package com.llamalab.automate.expr.func;

import J3.h;
import com.llamalab.automate.C1708z0;
import x3.C2446x;

/* loaded from: classes.dex */
public final class Trim extends UnaryFunction {
    public static final String NAME = "trim";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        if (c22 != null) {
            return C2446x.n(h.e0(c22));
        }
        return null;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
