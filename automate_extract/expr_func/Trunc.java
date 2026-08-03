package com.llamalab.automate.expr.func;

import J3.b;
import J3.h;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class Trunc extends UnaryFunction {
    public static final String NAME = "trunc";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        if (c22 instanceof b) {
            return (b) c22;
        }
        double a02 = h.a0(c22);
        return Double.valueOf(a02 - (a02 % 1.0d));
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
