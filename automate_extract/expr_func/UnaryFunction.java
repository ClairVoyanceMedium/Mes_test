package com.llamalab.automate.expr.func;

import J3.f;
import J3.h;
import L3.Z;
import com.llamalab.automate.InterfaceC1700x0;

/* loaded from: classes.dex */
public abstract class UnaryFunction extends Z implements f {
    public UnaryFunction() {
    }

    public UnaryFunction(InterfaceC1700x0 interfaceC1700x0) {
        super(interfaceC1700x0);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        return h.L(i8, k(), this.f4947X);
    }
}
