package com.llamalab.automate.expr.func;

import F3.g;
import J3.a;
import J3.h;
import L3.C1049n;
import com.llamalab.automate.C1708z0;
import y4.j;

@g(2)
/* loaded from: classes.dex */
public final class IndexOf extends TernaryFunction {
    public static final String NAME = "indexOf";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        int i8;
        double d8;
        Object c22 = this.f4940X.c2(c1708z0);
        Object c23 = this.f4941Y.c2(c1708z0);
        int m8 = h.m(c1708z0, this.f4942Z, 0);
        if (c22 instanceof String) {
            if (c23 != null) {
                String str = (String) c22;
                i8 = str.indexOf(h.e0(c23), j.i(m8, str.length()));
                d8 = i8;
            }
            d8 = -1.0d;
        } else {
            if (c22 instanceof a) {
                a aVar = (a) c22;
                i8 = j.i(m8, aVar.f4627Y);
                int i9 = aVar.f4627Y;
                while (true) {
                    if (i8 >= i9) {
                        i8 = -1;
                        break;
                    }
                    if (C1049n.d(c23, aVar.f4626X[i8])) {
                        break;
                    }
                    i8++;
                }
                d8 = i8;
            }
            d8 = -1.0d;
        }
        return Double.valueOf(d8);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
