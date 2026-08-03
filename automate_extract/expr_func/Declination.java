package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import android.hardware.GeomagneticField;
import com.llamalab.automate.C1708z0;

@g(2)
/* loaded from: classes.dex */
public final class Declination extends QuaternaryFunction {
    public static final String NAME = "declination";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        return Double.valueOf(new GeomagneticField((float) h.W(this.f4936X.c2(c1708z0)), (float) h.W(this.f4937Y.c2(c1708z0)), (float) h.i(c1708z0, this.f4938Z, 0.0d), h.t(c1708z0, this.f4939x0, c1708z0.b())).getDeclination());
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
