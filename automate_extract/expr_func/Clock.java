package com.llamalab.automate.expr.func;

import F5.n;
import J3.h;
import android.os.Build;
import android.os.SystemClock;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class Clock extends UnaryFunction {
    public static final String NAME = "clock";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        long currentTimeMillis;
        long elapsedRealtimeNanos;
        String e02 = h.e0(this.f4947X.c2(c1708z0));
        if ("boottime".equalsIgnoreCase(e02)) {
            if (17 <= Build.VERSION.SDK_INT) {
                elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                double d8 = elapsedRealtimeNanos;
                return n.l(d8, d8, d8, 1.0E9d);
            }
            currentTimeMillis = SystemClock.elapsedRealtime();
        } else if ("monotonic".equalsIgnoreCase(e02)) {
            currentTimeMillis = SystemClock.uptimeMillis();
        } else {
            if (!"realtime".equalsIgnoreCase(e02)) {
                return null;
            }
            currentTimeMillis = System.currentTimeMillis();
        }
        double d9 = currentTimeMillis;
        return n.l(d9, d9, d9, 1000.0d);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
