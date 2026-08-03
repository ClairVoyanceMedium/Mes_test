package com.llamalab.automate.expr.func;

import J3.a;
import J3.h;
import com.llamalab.automate.C1708z0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class FindAll extends BinaryFunction {
    public static final String NAME = "findAll";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        String f02 = h.f0(null, this.f4950X.c2(c1708z0));
        String f03 = h.f0(null, this.f4951Y.c2(c1708z0));
        if (f02 == null || f03 == null) {
            return null;
        }
        Matcher matcher = Pattern.compile(f03).matcher(f02);
        if (!matcher.find()) {
            return null;
        }
        a aVar = new a();
        do {
            for (int i8 = 0; i8 <= matcher.groupCount(); i8++) {
                aVar.add(matcher.group(i8));
            }
        } while (matcher.find());
        return aVar;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
