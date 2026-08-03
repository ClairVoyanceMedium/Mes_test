package com.llamalab.automate.expr.func;

import J3.a;
import J3.e;
import J3.h;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1708z0;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class Sum extends UnaryFunction {
    public static final String NAME = "sum";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        double d8 = 0.0d;
        if (c22 instanceof a) {
            Iterator<Object> it = ((a) c22).iterator();
            while (true) {
                a.C0026a c0026a = (a.C0026a) it;
                if (!c0026a.hasNext()) {
                    break;
                }
                d8 += h.W(c0026a.next());
            }
        } else if (c22 instanceof e) {
            e eVar = (e) c22;
            eVar.getClass();
            C1231k c1231k = (C1231k) eVar.f9362Z;
            while (true) {
                if (!(c1231k != eVar)) {
                    break;
                }
                if (c1231k == eVar) {
                    throw new NoSuchElementException();
                }
                C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                d8 += h.W(((e.a) c1231k).f4644x1);
                c1231k = c1231k2;
            }
        } else {
            d8 = h.W(c22);
        }
        return Double.valueOf(d8);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
