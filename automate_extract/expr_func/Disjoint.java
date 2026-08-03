package com.llamalab.automate.expr.func;

import J3.a;
import J3.e;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class Disjoint extends BinaryFunction {
    public static final String NAME = "disjoint";

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
            if (aVar.isEmpty()) {
                return aVar2.isEmpty() ? new a() : new a(aVar2);
            }
            if (aVar2.isEmpty()) {
                return new a(aVar);
            }
            a aVar3 = new a(aVar);
            a aVar4 = new a(aVar2);
            aVar3.removeAll(aVar2);
            aVar4.removeAll(aVar);
            Object[] objArr = aVar4.f4626X;
            int i8 = aVar4.f4627Y;
            if (i8 > 0) {
                aVar3.j(aVar3.f4627Y + i8);
                System.arraycopy(objArr, 0, aVar3.f4626X, aVar3.f4627Y, i8);
                aVar3.f4627Y += i8;
            }
            return aVar3;
        }
        if (!(c22 instanceof e)) {
            if (c22 != null) {
                return null;
            }
            if (c23 instanceof a) {
                return new a((a) c23);
            }
            if (c23 instanceof e) {
                return new e((e) c23);
            }
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
        if (eVar.isEmpty()) {
            return eVar2.isEmpty() ? new e() : new e(eVar2);
        }
        if (eVar2.isEmpty()) {
            return new e(eVar);
        }
        e eVar3 = new e(eVar);
        e eVar4 = new e(eVar2);
        eVar3.r0(eVar2);
        eVar4.r0(eVar);
        eVar3.n0(eVar4);
        return eVar3;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
