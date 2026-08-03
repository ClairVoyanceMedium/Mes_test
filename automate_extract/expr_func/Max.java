package com.llamalab.automate.expr.func;

import F3.g;
import L3.C1050o;
import R3.c;
import R3.d;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;

@g(2)
/* loaded from: classes.dex */
public final class Max extends VariadicFunction {
    public static final String NAME = "max";

    @Override // L3.a0, R3.e
    public final void Y0(d dVar) {
        d(dVar);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        InterfaceC1700x0[] interfaceC1700x0Arr = this.f4948X;
        int length = interfaceC1700x0Arr.length - 1;
        Object c22 = interfaceC1700x0Arr[length].c2(c1708z0);
        while (true) {
            length--;
            if (length < 0) {
                return c22;
            }
            Object c23 = this.f4948X[length].c2(c1708z0);
            if (C1050o.d(c23, c22)) {
                c22 = c23;
            }
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }

    @Override // L3.a0, R3.e
    public final void o0(c cVar) {
        b(cVar);
    }
}
