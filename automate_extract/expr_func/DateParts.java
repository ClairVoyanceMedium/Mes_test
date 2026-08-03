package com.llamalab.automate.expr.func;

import F3.g;
import F5.n;
import J3.a;
import J3.h;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import java.util.Calendar;
import java.util.regex.Pattern;

@g(1)
/* loaded from: classes.dex */
public final class DateParts extends BinaryFunction {
    public static final String NAME = "dateParts";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        long W7 = c22 != null ? (long) (h.W(c22) * 1000.0d) : c1708z0.b();
        InterfaceC1700x0 interfaceC1700x0 = this.f4951Y;
        Pattern pattern = h.f4650a;
        Calendar calendar = Calendar.getInstance(h.z(c1708z0, interfaceC1700x0, c1708z0.o()));
        calendar.setTimeInMillis(W7);
        double d8 = calendar.get(7);
        Double.isNaN(d8);
        Double.isNaN(d8);
        Double.isNaN(d8);
        double d9 = calendar.get(16);
        return new a(11, new Object[]{Double.valueOf(calendar.get(1)), Double.valueOf(calendar.get(2)), Double.valueOf(calendar.get(5)), Double.valueOf(calendar.get(11)), Double.valueOf(calendar.get(12)), Double.valueOf(calendar.get(13)), Double.valueOf(calendar.get(14)), Double.valueOf(d8 - 1.0d), Double.valueOf(calendar.get(3)), Double.valueOf(calendar.get(6)), n.l(d9, d9, d9, 1000.0d)});
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
