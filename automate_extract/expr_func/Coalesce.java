package com.llamalab.automate.expr.func;

import F3.g;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;

@g(2)
/* loaded from: classes.dex */
public final class Coalesce extends VariadicFunction {
    public static final String NAME = "coalesce";

    public Coalesce() {
    }

    public Coalesce(InterfaceC1700x0... interfaceC1700x0Arr) {
        super(interfaceC1700x0Arr);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        for (InterfaceC1700x0 interfaceC1700x0 : this.f4948X) {
            Object c22 = interfaceC1700x0.c2(c1708z0);
            if (c22 != null) {
                return c22;
            }
        }
        return null;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
