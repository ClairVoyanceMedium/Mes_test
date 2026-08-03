package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import com.llamalab.automate.C1708z0;
import y4.j;

@g(2)
/* loaded from: classes.dex */
public final class Substr extends TernaryFunction {
    public static final String NAME = "substr";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        String e02;
        int length;
        int i8;
        Object c22 = this.f4940X.c2(c1708z0);
        int m8 = h.m(c1708z0, this.f4942Z, Integer.MAX_VALUE);
        return (c22 == null || m8 == 0 || (i8 = j.i((int) h.W(this.f4941Y.c2(c1708z0)), (length = (e02 = h.e0(c22)).length()))) >= length) ? "" : e02.substring(i8, (int) Math.min(length, i8 + m8));
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
