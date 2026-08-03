package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import com.llamalab.automate.C1708z0;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import y4.f;

@g(1)
/* loaded from: classes.dex */
public final class DateFormat extends QuaternaryFunction {
    public static final String NAME = "dateFormat";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        java.text.DateFormat dateTimeInstance;
        SimpleDateFormat simpleDateFormat;
        long t8 = h.t(c1708z0, this.f4936X, c1708z0.b());
        String x7 = h.x(c1708z0, this.f4937Y, null);
        TimeZone z7 = h.z(c1708z0, this.f4938Z, c1708z0.o());
        Locale r8 = h.r(c1708z0, this.f4939x0, null);
        if (x7 == null || "datetime".equalsIgnoreCase(x7)) {
            if (r8 == null) {
                r8 = c1708z0.h();
                java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(c1708z0);
                java.text.DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(c1708z0);
                if ((dateFormat instanceof SimpleDateFormat) && (timeFormat instanceof SimpleDateFormat)) {
                    simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) dateFormat).toPattern() + " " + ((SimpleDateFormat) timeFormat).toPattern(), r8);
                    dateTimeInstance = simpleDateFormat;
                }
            }
            dateTimeInstance = java.text.DateFormat.getDateTimeInstance(3, 3, r8);
        } else if (Date.NAME.equalsIgnoreCase(x7)) {
            dateTimeInstance = r8 != null ? java.text.DateFormat.getDateInstance(3, r8) : android.text.format.DateFormat.getDateFormat(c1708z0);
        } else if (Time.NAME.equalsIgnoreCase(x7)) {
            dateTimeInstance = r8 != null ? java.text.DateFormat.getTimeInstance(3, r8) : android.text.format.DateFormat.getTimeFormat(c1708z0);
        } else if ("iso8601".equalsIgnoreCase(x7)) {
            dateTimeInstance = new f();
        } else {
            if (r8 == null) {
                r8 = c1708z0.h();
            }
            simpleDateFormat = new SimpleDateFormat(x7, r8);
            dateTimeInstance = simpleDateFormat;
        }
        dateTimeInstance.setTimeZone(z7);
        return dateTimeInstance.format(new java.util.Date(t8));
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
