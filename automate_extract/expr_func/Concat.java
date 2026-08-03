package com.llamalab.automate.expr.func;

import F3.g;
import J3.a;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;

@g(2)
/* loaded from: classes.dex */
public final class Concat extends VariadicFunction {
    public static final String NAME = "concat";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        a aVar = new a();
        for (InterfaceC1700x0 interfaceC1700x0 : this.f4948X) {
            Object c22 = interfaceC1700x0.c2(c1708z0);
            if (c22 instanceof a) {
                a aVar2 = (a) c22;
                Object[] objArr = aVar2.f4626X;
                int i8 = aVar2.f4627Y;
                if (i8 > 0) {
                    aVar.j(aVar.f4627Y + i8);
                    System.arraycopy(objArr, 0, aVar.f4626X, aVar.f4627Y, i8);
                    aVar.f4627Y += i8;
                }
            } else if (c22 != null) {
                aVar.add(c22);
            }
        }
        return aVar;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
