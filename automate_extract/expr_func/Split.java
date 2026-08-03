package com.llamalab.automate.expr.func;

import F3.g;
import J3.a;
import J3.h;
import com.llamalab.automate.C1708z0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@g(1)
/* loaded from: classes.dex */
public final class Split extends BinaryFunction {
    public static final String NAME = "split";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        String f02 = h.f0(null, this.f4950X.c2(c1708z0));
        if (f02 == null) {
            return null;
        }
        String x7 = h.x(c1708z0, this.f4951Y, "");
        int i8 = 0;
        if (x7.isEmpty()) {
            int length = f02.length();
            Object[] objArr = new Object[length];
            while (i8 < length) {
                objArr[i8] = String.valueOf(f02.charAt(i8));
                i8++;
            }
            return new a(length, objArr);
        }
        a aVar = new a();
        Matcher matcher = Pattern.compile(x7).matcher(f02);
        while (matcher.find()) {
            if (i8 != 0 || matcher.start() != 0 || matcher.end() != 0) {
                aVar.add(f02.substring(i8, matcher.start()));
                for (int i9 = 1; i9 <= matcher.groupCount(); i9++) {
                    aVar.add(matcher.group(i9));
                }
            }
            i8 = matcher.end();
        }
        aVar.add(f02.substring(i8));
        return aVar;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
