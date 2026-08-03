package com.llamalab.automate.expr.func;

import J3.a;
import J3.e;
import J3.h;
import com.llamalab.automate.C1708z0;
import java.util.BitSet;
import java.util.NoSuchElementException;
import y4.j;

/* loaded from: classes.dex */
public final class Sift extends BinaryFunction {
    public static final String NAME = "sift";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4951Y.c2(c1708z0);
        if (!(c22 instanceof a)) {
            return null;
        }
        a aVar = (a) c22;
        Object c23 = this.f4950X.c2(c1708z0);
        int i8 = 0;
        if (c23 instanceof a) {
            a aVar2 = (a) c23;
            int i9 = aVar2.f4627Y;
            BitSet bitSet = new BitSet(i9);
            aVar.getClass();
            int i10 = 0;
            while (true) {
                if (!(i10 < aVar.f4627Y)) {
                    a aVar3 = new a(aVar.f4627Y);
                    while (true) {
                        int nextSetBit = bitSet.nextSetBit(i8);
                        if (nextSetBit == -1) {
                            return aVar3;
                        }
                        aVar3.add(aVar2.get(nextSetBit));
                        i8 = nextSetBit + 1;
                    }
                } else {
                    if (i10 >= aVar.f4627Y) {
                        throw new NoSuchElementException();
                    }
                    int i11 = i10 + 1;
                    int i12 = j.i((int) h.W(aVar.get(i10)), i9);
                    if (i12 < i9) {
                        bitSet.set(i12);
                    }
                    i10 = i11;
                }
            }
        } else {
            if (!(c23 instanceof e)) {
                return null;
            }
            e eVar = (e) c23;
            e eVar2 = new e(aVar.f4627Y);
            int i13 = 0;
            while (true) {
                if (!(i13 < aVar.f4627Y)) {
                    return eVar2;
                }
                if (i13 >= aVar.f4627Y) {
                    throw new NoSuchElementException();
                }
                int i14 = i13 + 1;
                e.a k02 = eVar.k0(h.e0(aVar.get(i13)));
                if (k02 != null) {
                    eVar2.m0(k02.f4645y0, k02.f4644x1, k02.f4646y1);
                }
                i13 = i14;
            }
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
