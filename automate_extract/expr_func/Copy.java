package com.llamalab.automate.expr.func;

import F3.g;
import J3.d;
import J3.h;
import com.llamalab.automate.C1708z0;
import java.util.IdentityHashMap;

@g(1)
/* loaded from: classes.dex */
public class Copy extends BinaryFunction {
    public static final String NAME = "copy";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        if (c22 instanceof d) {
            return ((d) c22).o(h.f(c1708z0, this.f4951Y, false) ? new IdentityHashMap<>() : null);
        }
        return c22;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
