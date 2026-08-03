package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.regex.Pattern;

@g(2)
/* loaded from: classes.dex */
public class DateParse extends QuaternaryFunction {
    public static final String NAME = "dateParse";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4936X.c2(c1708z0);
        Object c23 = this.f4937Y.c2(c1708z0);
        if (c22 != null && c23 != null) {
            InterfaceC1700x0 interfaceC1700x0 = this.f4938Z;
            Pattern pattern = h.f4650a;
            TimeZone z7 = h.z(c1708z0, interfaceC1700x0, c1708z0.o());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(h.e0(c23), h.r(c1708z0, this.f4939x0, c1708z0.h()));
            simpleDateFormat.setTimeZone(z7);
            try {
                double time = simpleDateFormat.parse(h.e0(c22)).getTime();
                Double.isNaN(time);
                Double.isNaN(time);
                return Double.valueOf(time / 1000.0d);
            } catch (ParseException unused) {
            }
        }
        return null;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
