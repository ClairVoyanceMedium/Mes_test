package com.llamalab.automate.expr.func;

import J3.h;
import com.llamalab.automate.C1708z0;
import x3.C2446x;

/* loaded from: classes.dex */
public class VersionCompare extends BinaryFunction {
    public static final String NAME = "vercmp";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        return Double.valueOf(C2446x.f23433a.compare(h.f0("", this.f4950X.c2(c1708z0)), h.f0("", this.f4951Y.c2(c1708z0))));
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
