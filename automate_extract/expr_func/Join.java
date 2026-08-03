package com.llamalab.automate.expr.func;

import F3.g;
import J3.a;
import J3.e;
import J3.h;
import com.llamalab.automate.C1708z0;

@g(1)
/* loaded from: classes.dex */
public class Join extends BinaryFunction {
    public static final String NAME = "join";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        String x7 = h.x(c1708z0, this.f4951Y, null);
        if (c22 instanceof a) {
            return ((a) c22).l(x7);
        }
        if (c22 instanceof e) {
            return ((e) c22).v0(x7);
        }
        if (c22 != null) {
            return h.e0(c22);
        }
        return null;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
