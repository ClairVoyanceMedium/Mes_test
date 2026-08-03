package com.llamalab.automate.expr.func;

import J3.a;
import J3.e;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1708z0;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class Except extends BinaryFunction {
    public static final String NAME = "except";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        Object c23 = this.f4951Y.c2(c1708z0);
        if (c22 instanceof a) {
            if (!(c23 instanceof a)) {
                if (c23 == null) {
                    return new a((a) c22);
                }
                return null;
            }
            a aVar = (a) c22;
            a aVar2 = (a) c23;
            if (aVar2.isEmpty()) {
                return new a(aVar);
            }
            a aVar3 = new a(aVar.f4627Y);
            int i8 = 0;
            while (true) {
                if (!(i8 < aVar.f4627Y)) {
                    return aVar3;
                }
                if (i8 >= aVar.f4627Y) {
                    throw new NoSuchElementException();
                }
                int i9 = i8 + 1;
                Object obj = aVar.get(i8);
                if (!aVar2.contains(obj)) {
                    aVar3.add(obj);
                }
                i8 = i9;
            }
        } else {
            if (!(c22 instanceof e)) {
                return null;
            }
            if (!(c23 instanceof e)) {
                if (c23 == null) {
                    return new e((e) c22);
                }
                return null;
            }
            e eVar = (e) c22;
            e eVar2 = (e) c23;
            if (eVar2.isEmpty()) {
                return new e(eVar);
            }
            e eVar3 = new e(eVar.f4641x1);
            C1231k c1231k = (C1231k) eVar.f9362Z;
            while (true) {
                if (!(c1231k != eVar)) {
                    return eVar3;
                }
                if (c1231k == eVar) {
                    throw new NoSuchElementException();
                }
                C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                e.a aVar4 = (e.a) c1231k;
                if (!eVar2.i0(aVar4.f4645y0)) {
                    eVar3.m0(aVar4.f4645y0, aVar4.f4644x1, aVar4.f4646y1);
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
