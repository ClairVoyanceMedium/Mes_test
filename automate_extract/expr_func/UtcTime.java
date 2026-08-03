package com.llamalab.automate.expr.func;

import F3.g;
import F5.n;
import J3.h;
import com.llamalab.automate.C1708z0;

@g(1)
/* loaded from: classes.dex */
public class UtcTime extends BinaryFunction {
    public static final String NAME = "utcTime";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        long W7 = (long) (h.W(this.f4950X.c2(c1708z0)) * 1000.0d);
        android.text.format.Time time = new android.text.format.Time(h.z(c1708z0, this.f4951Y, c1708z0.o()).getID());
        time.set(W7);
        time.timezone = "UTC";
        double millis = time.toMillis(true);
        return n.l(millis, millis, millis, 1000.0d);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
