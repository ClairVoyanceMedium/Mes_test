package com.llamalab.automate.expr.func;

import J3.b;
import J3.h;
import com.llamalab.automate.C1708z0;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Sqrt extends UnaryFunction {
    public static final String NAME = "sqrt";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        int i8;
        Object c22 = this.f4947X.c2(c1708z0);
        if (!(c22 instanceof b)) {
            return Double.valueOf(Math.sqrt(h.a0(c22)));
        }
        b bVar = (b) c22;
        int i9 = bVar.f4638X;
        if (i9 == 0) {
            return b.f4633Z;
        }
        if (i9 < 0) {
            throw new ArithmeticException("Negative");
        }
        int[] iArr = bVar.f4639Y;
        int length = iArr.length;
        if (length <= 2) {
            long j8 = length == 2 ? (iArr[1] & 4294967295L) | (iArr[0] << 32) : iArr[0] & 4294967295L;
            double d8 = j8;
            if (j8 < 0) {
                Double.isNaN(d8);
                Double.isNaN(d8);
                Double.isNaN(d8);
                Double.isNaN(d8);
                Double.isNaN(d8);
                d8 += 1.8446744073709552E19d;
            }
            long sqrt = (long) Math.sqrt(d8);
            long j9 = sqrt * sqrt;
            long j10 = j8 ^ Long.MIN_VALUE;
            if (j10 < (j9 ^ Long.MIN_VALUE) || sqrt > 4294967295L) {
                sqrt--;
            } else if (j10 > ((j9 + (sqrt << 1)) ^ Long.MIN_VALUE)) {
                sqrt++;
            }
            return b.d0(sqrt);
        }
        int i10 = length + 1;
        int[] iArr2 = (int[]) iArr.clone();
        int[] iArr3 = new int[i10];
        int i11 = length;
        int i12 = 0;
        for (int i13 = b.i(iArr2) & (-2); i13 >= 0; i13 -= 2) {
            int i14 = length - (i13 / 32);
            int i15 = 1 << (i13 % 32);
            int min = Math.min(i11, i14);
            int i16 = iArr3[i14];
            boolean z7 = (i16 & i15) == 0;
            if (z7) {
                iArr3[i14] = i16 | i15;
            }
            int i17 = i11;
            if (b.t(i12, length - i12, min, i10 - min, iArr2, iArr3) >= 0) {
                i12 = b.Z(i12, length, min, i10, iArr2, iArr2, iArr3);
                int i18 = i13 + 1;
                int i19 = (i10 - 1) - (i18 / 32);
                iArr3[i19] = (1 << (i18 % 32)) | iArr3[i19];
                i8 = Math.min(i17, i19);
            } else {
                i8 = i17;
            }
            if (z7) {
                iArr3[i14] = iArr3[i14] & (i15 ^ (-1));
            }
            i11 = Math.min(length, b.X(i8, iArr3, i10, iArr3));
        }
        int i20 = i11;
        if (i20 != 0) {
            iArr3 = Arrays.copyOfRange(iArr3, i20, i10);
        }
        return new b(1, iArr3);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
