package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import R3.c;
import R3.d;
import com.llamalab.automate.C1708z0;
import java.io.UnsupportedEncodingException;
import x3.C2440r;

@g(1)
/* loaded from: classes.dex */
public final class HexDecode extends BinaryFunction {
    public static final String NAME = "hexDecode";

    @Override // L3.AbstractC1040e, R3.e
    public final void Y0(d dVar) {
        dVar.g(this.f4950X);
        if (66 <= dVar.f6413Z) {
            dVar.g(this.f4951Y);
        }
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        String f02 = h.f0(null, this.f4950X.c2(c1708z0));
        if (f02 == null) {
            return null;
        }
        try {
            return new String(C2440r.z(f02), h.x(c1708z0, this.f4951Y, "UTF-8"));
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
