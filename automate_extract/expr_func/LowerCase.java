package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import java.util.regex.Pattern;

@g(1)
/* loaded from: classes.dex */
public final class LowerCase extends BinaryFunction {
    public static final String NAME = "lowerCase";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        if (c22 == null) {
            return null;
        }
        InterfaceC1700x0 interfaceC1700x0 = this.f4951Y;
        Pattern pattern = h.f4650a;
        return h.e0(c22).toLowerCase(h.r(c1708z0, interfaceC1700x0, c1708z0.h()));
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
