package com.llamalab.automate.expr.func;

import F3.g;
import J3.b;
import J3.h;
import R3.c;
import R3.d;
import com.llamalab.automate.C1708z0;
import java.io.UnsupportedEncodingException;

@g(1)
/* loaded from: classes.dex */
public final class HexEncode extends BinaryFunction {
    public static final String NAME = "hexEncode";

    @Override // L3.AbstractC1040e, R3.e
    public final void Y0(d dVar) {
        dVar.g(this.f4950X);
        if (66 <= dVar.f6413Z) {
            dVar.g(this.f4951Y);
        }
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        if (c22 == null) {
            return null;
        }
        if (c22 instanceof b) {
            return ((b) c22).a0(16);
        }
        if (c22 instanceof Number) {
            return Integer.toHexString(((Number) c22).intValue());
        }
        String f02 = h.f0("", c22);
        if (f02.isEmpty()) {
            return null;
        }
        try {
            return V3.b.g(f02.getBytes(h.x(c1708z0, this.f4951Y, "UTF-8")));
        } catch (UnsupportedEncodingException e8) {
            throw new IllegalArgumentException("charset", e8);
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }

    @Override // L3.AbstractC1040e, R3.e
    public final void o0(c cVar) {
        b(cVar, 66);
    }
}
