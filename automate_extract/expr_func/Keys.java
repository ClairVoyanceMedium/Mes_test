package com.llamalab.automate.expr.func;

import J3.a;
import J3.e;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class Keys extends UnaryFunction {
    public static final String NAME = "keys";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        if (!(c22 instanceof a)) {
            if (!(c22 instanceof e)) {
                return null;
            }
            e eVar = (e) c22;
            eVar.getClass();
            Object[] t02 = eVar.t0(new Object[eVar.f4641x1]);
            return new a(t02.length, t02);
        }
        int i8 = ((a) c22).f4627Y;
        Object[] objArr = new Object[i8];
        int i9 = i8;
        while (true) {
            i9--;
            if (i9 < 0) {
                return new a(i8, objArr);
            }
            objArr[i9] = Double.valueOf(i9);
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
