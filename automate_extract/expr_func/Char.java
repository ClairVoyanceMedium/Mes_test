package com.llamalab.automate.expr.func;

import J3.h;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class Char extends UnaryFunction {
    public static final String NAME = "char";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        return c22 != null ? new String(Character.toChars(h.R(c22))) : "";
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
