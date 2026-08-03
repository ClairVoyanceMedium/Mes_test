package com.llamalab.automate.expr.func;

import J3.h;
import android.telephony.PhoneNumberUtils;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public class PhoneEqual extends BinaryFunction {
    public static final String NAME = "phoneq";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        String f02 = h.f0(null, this.f4950X.c2(c1708z0));
        String f03 = h.f0(null, this.f4951Y.c2(c1708z0));
        return Double.valueOf(h.Y(f02 != null ? !(f03 == null || !PhoneNumberUtils.compare(c1708z0, f02, f03)) : f03 == null));
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
