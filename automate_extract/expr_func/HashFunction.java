package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import V3.b;
import com.llamalab.automate.C1708z0;
import java.security.NoSuchAlgorithmException;
import x3.C2440r;

@g(1)
/* loaded from: classes.dex */
public abstract class HashFunction extends BinaryFunction {
    public abstract byte[] c(byte[] bArr);

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        if (c22 != null) {
            String x7 = h.x(c1708z0, this.f4951Y, "");
            int length = x7.length();
            boolean z7 = false;
            while (true) {
                length--;
                if (length < 0) {
                    break;
                }
                if (x7.charAt(length) == 'h') {
                    z7 = true;
                }
            }
            String e02 = h.e0(c22);
            if (!e02.isEmpty()) {
                try {
                    return b.g(c(z7 ? C2440r.z(e02) : e02.getBytes(b.f6987a)));
                } catch (NoSuchAlgorithmException e8) {
                    throw new UnsupportedOperationException(e8);
                }
            }
        }
        return null;
    }
}
