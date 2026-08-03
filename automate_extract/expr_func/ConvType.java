package com.llamalab.automate.expr.func;

import J3.e;
import J3.h;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.expr.ConversionType;

/* loaded from: classes.dex */
public final class ConvType extends BinaryFunction {
    public static final String NAME = "convType";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        e.a k02;
        ConversionType conversionType;
        Object c22 = this.f4950X.c2(c1708z0);
        if (!(c22 instanceof e) || (k02 = ((e) c22).k0(h.e0(this.f4951Y.c2(c1708z0)))) == null || (conversionType = k02.f4646y1) == null) {
            return null;
        }
        return conversionType.name();
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
