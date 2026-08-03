package com.llamalab.automate.expr.func;

import F3.g;
import J3.b;
import J3.h;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import java.util.Arrays;
import y4.j;

@g(0)
/* loaded from: classes.dex */
public final class Random extends UnaryFunction {
    public static final String NAME = "random";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        double nextDouble;
        int i8;
        int[] iArr;
        InterfaceC1700x0 interfaceC1700x0 = this.f4947X;
        if (interfaceC1700x0 != null) {
            Object c22 = interfaceC1700x0.c2(c1708z0);
            if (c22 instanceof b) {
                b bVar = (b) c22;
                java.util.Random u8 = c1708z0.u();
                int i9 = bVar.f4638X;
                if (i9 < 0) {
                    throw new IllegalArgumentException();
                }
                b bVar2 = b.f4633Z;
                if (i9 == 0) {
                    return bVar2;
                }
                int h8 = bVar.h();
                int i10 = j.f23551b;
                int i11 = ((h8 + 32) - 1) / 32;
                int i12 = (1 << (h8 % 32)) - 1;
                int[] iArr2 = new int[i11];
                do {
                    int i13 = 0;
                    for (int i14 = 0; i14 < i11; i14++) {
                        iArr2[i14] = u8.nextInt();
                    }
                    if (i12 != 0) {
                        int i15 = iArr2[0] & i12;
                        iArr2[0] = i15;
                        if (i15 == 0) {
                            i13 = 1;
                        }
                    }
                    i8 = i13;
                    while (i8 < i11 && iArr2[i8] == 0) {
                        i8++;
                    }
                    iArr = bVar.f4639Y;
                } while (b.t(i8, i11 - i8, 0, iArr.length, iArr2, iArr) >= 0);
                if (i8 == i11) {
                    return bVar2;
                }
                if (i8 != 0) {
                    iArr2 = Arrays.copyOfRange(iArr2, i8, i11);
                }
                return new b(1, iArr2);
            }
            if (c22 != null) {
                nextDouble = h.R(c22) > 1 ? c1708z0.u().nextInt(r0) : 0.0d;
                return Double.valueOf(nextDouble);
            }
        }
        nextDouble = c1708z0.u().nextDouble();
        return Double.valueOf(nextDouble);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
