package com.llamalab.automate.expr.func;

import J3.h;
import android.location.Location;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public class Bearing extends QuaternaryFunction {
    public static final String NAME = "bearing";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Location.distanceBetween(h.W(this.f4936X.c2(c1708z0)), h.W(this.f4937Y.c2(c1708z0)), h.W(this.f4938Z.c2(c1708z0)), h.W(this.f4939x0.c2(c1708z0)), new float[2]);
        return Double.valueOf(r0[1]);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
