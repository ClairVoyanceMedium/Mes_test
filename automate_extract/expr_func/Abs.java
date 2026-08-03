package com.llamalab.automate.expr.func;

import J3.b;
import J3.h;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class Abs extends UnaryFunction {
    public static final String NAME = "abs";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        if (!(c22 instanceof b)) {
            return Double.valueOf(Math.abs(h.a0(c22)));
        }
        b bVar = (b) c22;
        int i8 = bVar.f4638X;
        return i8 < 0 ? new b(-i8, bVar.f4639Y) : bVar;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
