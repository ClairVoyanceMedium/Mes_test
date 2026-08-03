package com.llamalab.automate.expr.func;

import F3.g;
import J3.a;
import J3.e;
import J3.h;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1708z0;
import java.util.Iterator;
import java.util.NoSuchElementException;

@g(1)
/* loaded from: classes.dex */
public final class Filter extends BinaryFunction {
    public static final String NAME = "filter";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        boolean z7 = h.x(c1708z0, this.f4951Y, "").indexOf(102) == -1;
        Object c22 = this.f4950X.c2(c1708z0);
        if (c22 instanceof a) {
            a aVar = (a) c22;
            a aVar2 = new a(aVar.f4627Y);
            Iterator<Object> it = aVar.iterator();
            while (true) {
                a.C0026a c0026a = (a.C0026a) it;
                if (!c0026a.hasNext()) {
                    return aVar2;
                }
                Object next = c0026a.next();
                if (next != null && (z7 || h.J(next))) {
                    aVar2.add(next);
                }
            }
        } else {
            if (!(c22 instanceof e)) {
                return null;
            }
            e eVar = (e) c22;
            e eVar2 = new e(eVar.f4641x1);
            C1231k c1231k = (C1231k) eVar.f9362Z;
            while (true) {
                if (!(c1231k != eVar)) {
                    return eVar2;
                }
                if (c1231k == eVar) {
                    throw new NoSuchElementException();
                }
                C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                e.a aVar3 = (e.a) c1231k;
                Object obj = aVar3.f4644x1;
                if (obj != null && (z7 || h.J(obj))) {
                    eVar2.m0(aVar3.f4645y0, obj, aVar3.f4646y1);
                }
                c1231k = c1231k2;
            }
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
