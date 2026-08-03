package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import com.llamalab.automate.C1708z0;
import y4.C2467b;

@g(2)
/* loaded from: classes.dex */
public final class CoordFormat extends TernaryFunction {
    public static final String NAME = "coordFormat";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        double W7 = h.W(this.f4940X.c2(c1708z0));
        String e02 = h.e0(this.f4941Y.c2(c1708z0));
        h.r(c1708z0, this.f4942Z, c1708z0.h());
        return new C2467b(e02, 0).format(Double.valueOf(W7));
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
