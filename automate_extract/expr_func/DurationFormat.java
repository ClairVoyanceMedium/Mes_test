package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import com.llamalab.automate.C1708z0;
import y4.C2469d;

@g(1)
/* loaded from: classes.dex */
public final class DurationFormat extends TernaryFunction {
    public static final String NAME = "durationFormat";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        return new C2469d(h.x(c1708z0, this.f4941Y, "H'h'm'm's's'"), h.r(c1708z0, this.f4942Z, c1708z0.h())).format(Long.valueOf((long) (h.W(this.f4940X.c2(c1708z0)) * 1000.0d)));
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
