package com.llamalab.automate.expr.func;

import J3.a;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public class Shuffle extends UnaryFunction {
    public static final String NAME = "shuffle";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        if (!(c22 instanceof a)) {
            return null;
        }
        Object[] array = ((a) c22).toArray();
        java.util.Random u8 = c1708z0.u();
        int length = array.length;
        while (true) {
            length--;
            if (length < 0) {
                return new a(array.length, array);
            }
            int nextInt = u8.nextInt(length + 1);
            Object obj = array[nextInt];
            array[nextInt] = array[length];
            array[length] = obj;
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
