package com.llamalab.automate.expr.func;

import J3.a;
import J3.e;
import J3.h;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1708z0;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class Associate extends BinaryFunction {
    public static final String NAME = "associate";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        e eVar;
        Object c22 = this.f4950X.c2(c1708z0);
        Object c23 = this.f4951Y.c2(c1708z0);
        int i8 = 0;
        if (c22 instanceof a) {
            if (c23 instanceof a) {
                a aVar = (a) c22;
                a aVar2 = (a) c23;
                int i9 = aVar.f4627Y;
                e eVar2 = new e(i9);
                while (i8 < i9) {
                    eVar2.m0(h.e0(aVar.get(i8)), aVar2.get(i8), null);
                    i8++;
                }
                return eVar2;
            }
            a aVar3 = (a) c22;
            if (!(c23 instanceof e)) {
                int i10 = aVar3.f4627Y;
                e eVar3 = new e(i10);
                while (i8 < i10) {
                    eVar3.m0(h.e0(aVar3.get(i8)), c23, null);
                    i8++;
                }
                return eVar3;
            }
            e eVar4 = (e) c23;
            int i11 = aVar3.f4627Y;
            e eVar5 = new e(i11);
            while (i8 < i11) {
                String e02 = h.e0(aVar3.get(i8));
                eVar5.m0(e02, eVar4.j0(e02), null);
                i8++;
            }
            return eVar5;
        }
        if (c22 instanceof e) {
            if (!(c23 instanceof a)) {
                e eVar6 = (e) c22;
                if (!(c23 instanceof e)) {
                    eVar = new e(eVar6.f4641x1);
                    C1231k c1231k = (C1231k) eVar6.f9362Z;
                    while (true) {
                        if (!(c1231k != eVar6)) {
                            break;
                        }
                        if (c1231k == eVar6) {
                            throw new NoSuchElementException();
                        }
                        C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                        eVar.m0(((e.a) c1231k).f4645y0, c23, null);
                        c1231k = c1231k2;
                    }
                } else {
                    e eVar7 = (e) c23;
                    if (eVar6 != eVar7) {
                        eVar = new e(eVar6.f4641x1);
                        C1231k c1231k3 = (C1231k) eVar6.f9362Z;
                        while (true) {
                            if (!(c1231k3 != eVar6)) {
                                break;
                            }
                            if (c1231k3 == eVar6) {
                                throw new NoSuchElementException();
                            }
                            C1231k c1231k4 = (C1231k) c1231k3.f9362Z;
                            String str = ((e.a) c1231k3).f4645y0;
                            eVar.m0(str, eVar7.j0(str), null);
                            c1231k3 = c1231k4;
                        }
                    } else {
                        return new e(eVar6);
                    }
                }
            } else {
                e eVar8 = (e) c22;
                a aVar4 = (a) c23;
                eVar = new e(eVar8.f4641x1);
                C1231k c1231k5 = (C1231k) eVar8.f9362Z;
                int i12 = 0;
                while (true) {
                    if (!(c1231k5 != eVar8)) {
                        break;
                    }
                    if (c1231k5 == eVar8) {
                        throw new NoSuchElementException();
                    }
                    C1231k c1231k6 = (C1231k) c1231k5.f9362Z;
                    eVar.m0(((e.a) c1231k5).f4645y0, aVar4.get(i12), null);
                    c1231k5 = c1231k6;
                    i12++;
                }
            }
        } else if (c23 instanceof a) {
            String e03 = h.e0(c22);
            Object obj = ((a) c23).get(0);
            eVar = new e(1);
            eVar.l0(e03.hashCode() & (eVar.f4640x0.length - 1), e03, obj, null);
        } else if (c23 instanceof e) {
            String e04 = h.e0(c22);
            Object j02 = ((e) c23).j0(e04);
            eVar = new e(1);
            eVar.l0(e04.hashCode() & (eVar.f4640x0.length - 1), e04, j02, null);
        } else {
            String e05 = h.e0(c22);
            eVar = new e(1);
            eVar.l0(e05.hashCode() & (eVar.f4640x0.length - 1), e05, c23, null);
        }
        return eVar;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
