package com.llamalab.automate.expr.func;

import F3.g;
import F5.n;
import J3.h;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import java.util.Calendar;
import java.util.regex.Pattern;

@g(3)
/* loaded from: classes.dex */
public final class Date extends QuaternaryFunction {
    public static final String NAME = "date";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        InterfaceC1700x0 interfaceC1700x0 = this.f4939x0;
        Pattern pattern = h.f4650a;
        Calendar calendar = Calendar.getInstance(h.z(c1708z0, interfaceC1700x0, c1708z0.o()));
        calendar.set(1, h.R(this.f4936X.c2(c1708z0)));
        calendar.set(2, h.R(this.f4937Y.c2(c1708z0)));
        calendar.set(5, h.R(this.f4938Z.c2(c1708z0)));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        double timeInMillis = calendar.getTimeInMillis();
        return n.l(timeInMillis, timeInMillis, timeInMillis, 1000.0d);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
