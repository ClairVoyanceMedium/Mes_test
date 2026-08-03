package com.llamalab.automate.expr.func;

import F3.g;
import J3.a;
import J3.h;
import J3.i;
import J3.j;
import com.llamalab.automate.C1708z0;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import x3.C2446x;

@g(1)
/* loaded from: classes.dex */
public class Sort extends TernaryFunction {
    public static final String NAME = "sort";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Comparator comparator;
        Comparator comparator2;
        Object c22 = this.f4940X.c2(c1708z0);
        if (c22 instanceof a) {
            a aVar = (a) c22;
            if (!aVar.isEmpty()) {
                a aVar2 = new a(aVar);
                String x7 = h.x(c1708z0, this.f4941Y, "");
                int length = x7.length();
                int i8 = 2;
                while (true) {
                    length--;
                    if (length < 0) {
                        break;
                    }
                    char charAt = x7.charAt(length);
                    if (charAt == 'c') {
                        i8 |= 8;
                    } else if (charAt == 'i') {
                        i8 |= 4;
                    } else if (charAt == 'l') {
                        i8 = (i8 & (-4)) | 2;
                    } else if (charAt == 'n') {
                        i8 = (i8 & (-4)) | 1;
                    } else if (charAt == 'r') {
                        i8 |= 32;
                    } else if (charAt == 'u') {
                        i8 |= 16;
                    }
                }
                int i9 = i8 & (-33);
                if (i9 != 1) {
                    if (i9 == 2) {
                        comparator2 = C2446x.f23435c;
                    } else if (i9 == 6) {
                        comparator2 = C2446x.f23436d;
                    } else if (i9 == 10) {
                        comparator = new i(new IdentityHashMap(), Collator.getInstance(h.r(c1708z0, this.f4942Z, c1708z0.h())));
                    } else {
                        if (i9 != 22) {
                            throw new IllegalArgumentException("flags");
                        }
                        comparator2 = String.CASE_INSENSITIVE_ORDER;
                    }
                    comparator = new j(new IdentityHashMap(), comparator2);
                } else {
                    comparator = h.f4651b;
                }
                if ((i8 & 32) != 0) {
                    comparator = Collections.reverseOrder(comparator);
                }
                Arrays.sort(aVar2.f4626X, 0, aVar2.f4627Y, comparator);
                return aVar2;
            }
        }
        return null;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
