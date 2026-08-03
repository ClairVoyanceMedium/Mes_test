package com.llamalab.automate.expr.func;

import F3.g;
import J3.a;
import J3.e;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import java.util.Iterator;
import java.util.NoSuchElementException;

@g(2)
/* loaded from: classes.dex */
public final class Union extends VariadicFunction {
    public static final String NAME = "union";

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008a, code lost:
    
        continue;
     */
    @Override // com.llamalab.automate.InterfaceC1700x0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c2(C1708z0 c1708z0) {
        InterfaceC1700x0[] interfaceC1700x0Arr = this.f4948X;
        int length = interfaceC1700x0Arr.length;
        int i8 = 0;
        while (i8 < length) {
            int i9 = i8 + 1;
            Object c22 = interfaceC1700x0Arr[i8].c2(c1708z0);
            if (c22 instanceof a) {
                a aVar = new a((a) c22);
                while (i9 < length) {
                    int i10 = i9 + 1;
                    Object c23 = interfaceC1700x0Arr[i9].c2(c1708z0);
                    if (c23 instanceof a) {
                        Iterator<Object> it = ((a) c23).iterator();
                        while (true) {
                            a.C0026a c0026a = (a.C0026a) it;
                            if (c0026a.hasNext()) {
                                Object next = c0026a.next();
                                if (!aVar.contains(next)) {
                                    aVar.add(next);
                                }
                            }
                        }
                    }
                    i9 = i10;
                }
                return aVar;
            }
            if (c22 instanceof e) {
                e eVar = new e((e) c22);
                while (i9 < length) {
                    int i11 = i9 + 1;
                    Object c24 = interfaceC1700x0Arr[i9].c2(c1708z0);
                    if (c24 instanceof e) {
                        e eVar2 = (e) c24;
                        eVar2.getClass();
                        C1231k c1231k = (C1231k) eVar2.f9362Z;
                        while (true) {
                            if (c1231k != eVar2) {
                                if (c1231k == eVar2) {
                                    throw new NoSuchElementException();
                                }
                                C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                                e.a aVar2 = (e.a) c1231k;
                                eVar.p0(aVar2.f4645y0, aVar2.f4644x1, aVar2.f4646y1);
                                c1231k = c1231k2;
                            }
                        }
                    }
                    i9 = i11;
                }
                return eVar;
            }
            i8 = i9;
        }
        return null;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
