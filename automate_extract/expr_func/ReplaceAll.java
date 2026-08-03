package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import com.llamalab.automate.C1708z0;

@g(2)
/* loaded from: classes.dex */
public final class ReplaceAll extends TernaryFunction {
    public static final String NAME = "replaceAll";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4940X.c2(c1708z0);
        if (c22 == null) {
            return null;
        }
        return h.e0(c22).replaceAll(h.f0("", this.f4941Y.c2(c1708z0)), h.x(c1708z0, this.f4942Z, ""));
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
