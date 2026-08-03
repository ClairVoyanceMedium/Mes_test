package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import com.llamalab.automate.C1708z0;

@g(1)
/* loaded from: classes.dex */
public final class Time extends QuaternaryFunction {
    public static final String NAME = "time";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        double W7 = h.W(this.f4936X.c2(c1708z0));
        double i8 = h.i(c1708z0, this.f4937Y, 0.0d);
        double i9 = h.i(c1708z0, this.f4938Z, 0.0d);
        return Double.valueOf((h.i(c1708z0, this.f4939x0, 0.0d) / 1000.0d) + (((W7 * 60.0d) + i8) * 60.0d) + i9);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
