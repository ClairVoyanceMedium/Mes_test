package com.llamalab.automate.expr.func;

import J3.a;
import J3.e;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1708z0;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class Values extends UnaryFunction {
    public static final String NAME = "values";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        if (c22 instanceof a) {
            return new a((a) c22);
        }
        if (!(c22 instanceof e)) {
            return null;
        }
        e eVar = (e) c22;
        a aVar = new a(eVar.f4641x1);
        C1231k c1231k = (C1231k) eVar.f9362Z;
        while (true) {
            if (!(c1231k != eVar)) {
                return aVar;
            }
            if (c1231k == eVar) {
                throw new NoSuchElementException();
            }
            C1231k c1231k2 = (C1231k) c1231k.f9362Z;
            aVar.add(((e.a) c1231k).f4644x1);
            c1231k = c1231k2;
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
