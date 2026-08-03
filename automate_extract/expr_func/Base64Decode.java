package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import V3.b;
import android.util.Base64;
import com.llamalab.automate.C1708z0;

@g(1)
/* loaded from: classes.dex */
public final class Base64Decode extends BinaryFunction {
    public static final String NAME = "base64Decode";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        if (c22 == null) {
            return null;
        }
        String x7 = h.x(c1708z0, this.f4951Y, "");
        int length = x7.length();
        int i8 = 0;
        boolean z7 = false;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            char charAt = x7.charAt(length);
            if (charAt == 'h') {
                z7 = true;
            } else if (charAt == 'u') {
                i8 |= 8;
            }
        }
        String e02 = h.e0(c22);
        if (e02.isEmpty()) {
            return null;
        }
        byte[] decode = Base64.decode(e02, i8);
        return z7 ? b.g(decode) : new String(decode, b.f6987a);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
