package com.llamalab.automate.expr.func;

import F3.g;
import J3.a;
import J3.h;
import com.llamalab.automate.C1708z0;
import java.util.Arrays;
import y4.j;

@g(1)
/* loaded from: classes.dex */
public final class Slice extends TernaryFunction {
    public static final String NAME = "slice";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4940X.c2(c1708z0);
        if (c22 instanceof String) {
            String str = (String) c22;
            int length = str.length();
            int i8 = j.i(h.m(c1708z0, this.f4941Y, 0), length);
            int i9 = j.i(h.m(c1708z0, this.f4942Z, length), length);
            return i8 < i9 ? str.substring(i8, i9) : "";
        }
        if (!(c22 instanceof a)) {
            return null;
        }
        a aVar = (a) c22;
        int i10 = aVar.f4627Y;
        int i11 = j.i(h.m(c1708z0, this.f4941Y, 0), i10);
        int i12 = j.i(h.m(c1708z0, this.f4942Z, i10), i10);
        if (i11 >= i12) {
            return new a();
        }
        Object[] copyOfRange = Arrays.copyOfRange(aVar.f4626X, i11, i12);
        return new a(copyOfRange.length, copyOfRange);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
