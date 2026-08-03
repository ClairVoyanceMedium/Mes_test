package com.llamalab.automate.expr.func;

import F3.g;
import F5.n;
import J3.h;
import com.llamalab.automate.C1708z0;
import java.util.Calendar;

@g(1)
/* loaded from: classes.dex */
public class TimeMerge extends TernaryFunction {
    public static final String NAME = "timeMerge";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        long W7 = (long) (h.W(this.f4940X.c2(c1708z0)) * 1000.0d);
        long t8 = h.t(c1708z0, this.f4941Y, 0L);
        Calendar calendar = Calendar.getInstance(h.z(c1708z0, this.f4942Z, c1708z0.o()));
        calendar.setTimeInMillis(W7);
        calendar.set(11, (int) ((t8 / 3600000) % 24));
        calendar.set(12, (int) ((t8 / 60000) % 60));
        calendar.set(13, (int) ((t8 / 1000) % 60));
        calendar.set(14, (int) (t8 % 1000));
        double timeInMillis = calendar.getTimeInMillis();
        return n.l(timeInMillis, timeInMillis, timeInMillis, 1000.0d);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
