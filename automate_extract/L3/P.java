package L3;

import C1.H0;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class P extends AbstractC1040e {
    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        int[] Y7;
        Object c22 = this.f4950X.c2(c1708z0);
        Object c23 = this.f4951Y.c2(c1708z0);
        if (!(c22 instanceof J3.b) || !(c23 instanceof J3.b)) {
            return Double.valueOf(((int) J3.h.a0(c22)) >> ((int) J3.h.a0(c23)));
        }
        J3.b bVar = (J3.b) c22;
        J3.b bVar2 = (J3.b) c23;
        if (bVar2.f4639Y.length > 1 || bVar2.h() >= 32) {
            throw new ArithmeticException("bigint out of int range");
        }
        int intValue = bVar2.intValue();
        int i8 = bVar.f4638X;
        if (i8 == 0 || intValue == 0) {
            return bVar;
        }
        int[] iArr = bVar.f4639Y;
        if (intValue < 0) {
            Y7 = J3.b.W(-intValue, iArr);
        } else {
            Y7 = J3.b.Y(intValue, i8 < 0, iArr);
            if (Y7.length == 0) {
                return J3.b.f4633Z;
            }
        }
        return new J3.b(i8, Y7);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder();
        H0.s(this.f4950X, i8, sb, " >> ");
        return F5.n.m(this.f4951Y, i8, sb);
    }
}
