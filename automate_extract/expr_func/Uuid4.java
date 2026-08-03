package com.llamalab.automate.expr.func;

import F3.g;
import com.llamalab.automate.C1708z0;
import java.util.UUID;

@g(0)
/* loaded from: classes.dex */
public final class Uuid4 extends UnaryFunction {
    public static final String NAME = "uuid4";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        return UUID.randomUUID().toString();
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
