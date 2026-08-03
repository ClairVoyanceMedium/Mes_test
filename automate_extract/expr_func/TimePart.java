package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import com.llamalab.automate.C1708z0;
import java.util.Calendar;

@g(1)
/* loaded from: classes.dex */
public class TimePart extends BinaryFunction {
    public static final String NAME = "timePart";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        long W7 = (long) (h.W(this.f4950X.c2(c1708z0)) * 1000.0d);
        Calendar calendar = Calendar.getInstance(h.z(c1708z0, this.f4951Y, c1708z0.o()));
        calendar.setTimeInMillis(W7);
        double d8 = calendar.get(13) + ((calendar.get(12) + (calendar.get(11) * 60)) * 60);
        double d9 = calendar.get(14);
        Double.isNaN(d9);
        Double.isNaN(d9);
        Double.isNaN(d8);
        Double.isNaN(d8);
        return Double.valueOf((d9 / 1000.0d) + d8);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
