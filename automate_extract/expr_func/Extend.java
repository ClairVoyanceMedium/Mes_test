package com.llamalab.automate.expr.func;

import F3.g;
import J3.e;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;

@g(2)
/* loaded from: classes.dex */
public final class Extend extends VariadicFunction {
    public static final String NAME = "extend";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        e eVar = null;
        for (InterfaceC1700x0 interfaceC1700x0 : this.f4948X) {
            Object c22 = interfaceC1700x0.c2(c1708z0);
            if (c22 instanceof e) {
                e eVar2 = (e) c22;
                if (!eVar2.isEmpty()) {
                    if (eVar != null) {
                        eVar.n0(eVar2);
                    } else {
                        eVar = new e(eVar2);
                    }
                }
            }
        }
        return eVar;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
