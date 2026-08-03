package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import com.llamalab.automate.C1708z0;
import x3.C2440r;

@g(1)
/* loaded from: classes.dex */
public final class SizeFormat extends TernaryFunction {
    public static final String NAME = "sizeFormat";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        long s8 = h.s(c1708z0, this.f4940X);
        String x7 = h.x(c1708z0, this.f4941Y, null);
        h.r(c1708z0, this.f4942Z, c1708z0.h());
        return C2440r.m(s8, "long".equals(x7) ? 2 : 1);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
