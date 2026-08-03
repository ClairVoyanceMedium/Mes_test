package com.llamalab.automate.expr.func;

import J3.h;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class Fahrenheit extends UnaryFunction {
    public static final String NAME = "fahrenheit";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        return Double.valueOf((h.a0(this.f4947X.c2(c1708z0)) * 1.8d) + 32.0d);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
