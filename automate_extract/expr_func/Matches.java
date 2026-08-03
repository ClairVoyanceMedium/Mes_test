package com.llamalab.automate.expr.func;

import J3.a;
import J3.e;
import J3.h;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1708z0;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class Matches extends BinaryFunction {
    public static final String NAME = "matches";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        Object c23 = this.f4951Y.c2(c1708z0);
        if (c23 == null) {
            return null;
        }
        Pattern compile = Pattern.compile(h.e0(c23));
        if (c22 instanceof a) {
            Iterator<Object> it = ((a) c22).iterator();
            Matcher matcher = null;
            while (true) {
                a.C0026a c0026a = (a.C0026a) it;
                if (!c0026a.hasNext()) {
                    return null;
                }
                Object next = c0026a.next();
                if (next != null) {
                    if (matcher != null) {
                        matcher.reset(h.e0(next));
                    } else {
                        matcher = compile.matcher(h.e0(next));
                    }
                    if (matcher.matches()) {
                        return h.F(matcher);
                    }
                }
            }
        } else {
            if (!(c22 instanceof e)) {
                if (c22 == null) {
                    return null;
                }
                Matcher matcher2 = compile.matcher(h.e0(c22));
                if (matcher2.matches()) {
                    return h.F(matcher2);
                }
                return null;
            }
            e eVar = (e) c22;
            eVar.getClass();
            C1231k c1231k = (C1231k) eVar.f9362Z;
            Matcher matcher3 = null;
            while (true) {
                if (!(c1231k != eVar)) {
                    return null;
                }
                if (c1231k == eVar) {
                    throw new NoSuchElementException();
                }
                C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                String str = ((e.a) c1231k).f4645y0;
                if (matcher3 != null) {
                    matcher3.reset(str);
                } else {
                    matcher3 = compile.matcher(str);
                }
                if (matcher3.matches()) {
                    return h.F(matcher3);
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
