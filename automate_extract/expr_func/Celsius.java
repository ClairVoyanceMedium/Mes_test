package com.llamalab.automate.expr.func;

import J3.h;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class Celsius extends UnaryFunction {
    public static final String NAME = "celsius";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        return Double.valueOf((h.a0(this.f4947X.c2(c1708z0)) - 32.0d) / 1.8d);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
