package com.llamalab.automate.expr.func;

import J3.b;
import J3.h;
import com.llamalab.automate.C1708z0;
import y4.j;

/* loaded from: classes.dex */
public final class Pow extends BinaryFunction {
    public static final String NAME = "pow";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        Object c23 = this.f4951Y.c2(c1708z0);
        if (!(c22 instanceof b) || !(c23 instanceof b)) {
            return Double.valueOf(Math.pow(h.a0(c22), h.a0(c23)));
        }
        b bVar = (b) c22;
        b bVar2 = (b) c23;
        bVar.getClass();
        int i8 = bVar2.f4638X;
        if (i8 < 0) {
            throw new ArithmeticException();
        }
        if (i8 == 0) {
            return b.f4634x0;
        }
        int i9 = bVar.f4638X;
        if (i9 == 0) {
            return b.f4633Z;
        }
        int[] iArr = bVar2.f4639Y;
        if (iArr.length > 1) {
            throw new ArithmeticException("Exponent too large");
        }
        int i10 = iArr[0];
        int[] iArr2 = bVar.f4639Y;
        int length = iArr2.length;
        int i11 = iArr2[0];
        boolean z7 = i9 < 0;
        if (length == 1 && i11 == 1) {
            if (z7 && (i10 & 1) == 0) {
                bVar = bVar.T();
            }
        } else if (i10 != 1) {
            boolean z8 = (i10 & 1) != 0;
            if (length == 1) {
                if (((-i11) & i11) == i11) {
                    int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i11);
                    int i12 = j.f23551b;
                    long j8 = i10 * numberOfLeadingZeros;
                    int i13 = (int) j8;
                    if (i13 != j8) {
                        throw new ArithmeticException("integer overflow");
                    }
                    int i14 = (((i13 + 1) + 32) - 1) / 32;
                    int[] iArr3 = new int[i14];
                    int i15 = (i14 - 1) - (i13 / 32);
                    iArr3[i15] = (1 << (i13 % 32)) | iArr3[i15];
                    if (z7 && z8) {
                        r3 = -1;
                    }
                    bVar = new b(r3, iArr3);
                }
            }
            int i16 = i10 / 2;
            b bVar3 = z8 ? bVar : null;
            if (b.i(iArr2) < (z7 ? 63 : 64)) {
                long abs = Math.abs(bVar.longValue());
                long j9 = z8 ? abs : 1L;
                while (!j.f(abs, abs)) {
                    long j10 = abs * abs;
                    if ((i16 & 1) != 0) {
                        if (j.f(j9, j10)) {
                            break;
                        }
                        j9 *= j10;
                    }
                    i16 /= 2;
                    if (i16 == 0) {
                        if (z7 && z8) {
                            r3 = -1;
                        }
                        bVar = b.c0(r3, (int) (j9 >>> 32), (int) j9);
                    } else {
                        abs = j10;
                    }
                }
                bVar3 = b.c0((z7 && z8) ? -1 : 1, (int) (j9 >>> 32), (int) j9);
                bVar = b.c0(z7 ? -1 : 1, (int) (abs >>> 32), (int) abs);
            }
            do {
                bVar = bVar.A(bVar);
                if ((i16 & 1) != 0) {
                    bVar3 = bVar3 == null ? bVar : bVar3.A(bVar);
                }
                i16 /= 2;
            } while (i16 > 0);
            bVar = bVar3;
        }
        return bVar;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
