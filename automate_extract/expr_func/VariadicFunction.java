package com.llamalab.automate.expr.func;

import J3.f;
import J3.h;
import L3.a0;
import com.llamalab.automate.InterfaceC1700x0;

/* loaded from: classes.dex */
public abstract class VariadicFunction extends a0 implements f {
    public VariadicFunction() {
    }

    public VariadicFunction(InterfaceC1700x0... interfaceC1700x0Arr) {
        super(interfaceC1700x0Arr);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        return h.L(i8, k(), this.f4948X);
    }
}
