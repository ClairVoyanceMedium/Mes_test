package com.llamalab.automate.expr.func;

import J3.a;
import J3.e;
import J3.h;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class Reverse extends UnaryFunction {
    public static final String NAME = "reverse";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        int i8 = 0;
        if (c22 instanceof a) {
            a aVar = new a((a) c22);
            Object[] objArr = aVar.f4626X;
            int i9 = aVar.f4627Y;
            while (true) {
                i9--;
                if (i8 >= i9) {
                    return aVar;
                }
                Object obj = objArr[i8];
                objArr[i8] = objArr[i9];
                objArr[i9] = obj;
                i8++;
            }
        } else {
            if ((c22 instanceof e) || c22 == null) {
                return null;
            }
            char[] charArray = h.e0(c22).toCharArray();
            int length = charArray.length;
            while (true) {
                length--;
                if (i8 >= length) {
                    return new String(charArray);
                }
                char c8 = charArray[i8];
                charArray[i8] = charArray[length];
                charArray[length] = c8;
                i8++;
            }
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
