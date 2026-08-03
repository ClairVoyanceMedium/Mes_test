package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import android.util.Base64;
import com.llamalab.automate.C1708z0;
import p3.C2213b;
import x3.C2440r;

@g(1)
/* loaded from: classes.dex */
public final class Base64Encode extends BinaryFunction {
    public static final String NAME = "base64Encode";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        if (c22 != null) {
            String x7 = h.x(c1708z0, this.f4951Y, "");
            int length = x7.length();
            boolean z7 = false;
            int i8 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                char charAt = x7.charAt(length);
                if (charAt == 'c') {
                    i8 |= 4;
                } else if (charAt == 'h') {
                    z7 = true;
                } else if (charAt == 'p') {
                    i8 |= 1;
                } else if (charAt == 'u') {
                    i8 |= 8;
                } else if (charAt == 'w') {
                    i8 |= 2;
                }
            }
            String e02 = h.e0(c22);
            if (!e02.isEmpty()) {
                return Base64.encodeToString(z7 ? C2440r.z(e02) : e02.getBytes(C2213b.f21561c), i8);
            }
        }
        return null;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
