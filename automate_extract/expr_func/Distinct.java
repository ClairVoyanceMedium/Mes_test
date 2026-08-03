package com.llamalab.automate.expr.func;

import J3.a;
import J3.e;
import com.llamalab.automate.C1708z0;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class Distinct extends UnaryFunction {
    public static final String NAME = "distinct";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        if (!(c22 instanceof a)) {
            if (c22 instanceof e) {
                return new e((e) c22);
            }
            return null;
        }
        a aVar = (a) c22;
        a aVar2 = new a(aVar.f4627Y);
        Iterator<Object> it = aVar.iterator();
        while (true) {
            a.C0026a c0026a = (a.C0026a) it;
            if (!c0026a.hasNext()) {
                return aVar2;
            }
            Object next = c0026a.next();
            if (!aVar2.contains(next)) {
                aVar2.add(next);
            }
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
