package com.llamalab.automate.expr.func;

import F5.n;
import J3.h;
import android.net.Uri;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class Runtime extends UnaryFunction {
    public static final String NAME = "runtime";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Uri e8;
        String x7 = h.x(c1708z0, this.f4947X, null);
        if (x7 == null) {
            return null;
        }
        if ("fiberUri".equalsIgnoreCase(x7)) {
            c1708z0.getClass();
            e8 = n.d(c1708z0);
        } else {
            if (!"flowUri".equalsIgnoreCase(x7)) {
                throw new IllegalArgumentException("Illegal runtime property: ".concat(x7));
            }
            c1708z0.getClass();
            e8 = n.e(c1708z0);
        }
        return e8.toString();
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
