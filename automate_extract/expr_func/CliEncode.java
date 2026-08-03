package com.llamalab.automate.expr.func;

import J3.h;
import com.llamalab.automate.C1708z0;
import p3.C2212a;

/* loaded from: classes.dex */
public class CliEncode extends UnaryFunction {
    public static final String NAME = "cliEncode";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        return c22 != null ? C2212a.b(h.e0(c22)) : "''";
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
