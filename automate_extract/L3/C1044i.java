package L3;

import C1.H0;
import com.llamalab.automate.C1708z0;

/* renamed from: L3.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1044i extends AbstractC1040e {
    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        Object c23 = this.f4951Y.c2(c1708z0);
        if (!(c22 instanceof J3.b) || !(c23 instanceof J3.b)) {
            return Double.valueOf(((int) J3.h.a0(c23)) ^ ((int) J3.h.a0(c22)));
        }
        J3.b bVar = (J3.b) c22;
        J3.b bVar2 = (J3.b) c23;
        int i8 = bVar.f4638X;
        if (i8 == 0) {
            return bVar2;
        }
        int i9 = bVar2.f4638X;
        if (i9 == 0) {
            return bVar;
        }
        int[] iArr = bVar.f4639Y;
        int length = iArr.length;
        boolean z7 = i8 < 0;
        int[] iArr2 = bVar2.f4639Y;
        return J3.b.k(iArr, length, z7, iArr2, iArr2.length, i9 < 0, 3);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder();
        H0.s(this.f4950X, i8, sb, " ^ ");
        return F5.n.m(this.f4951Y, i8, sb);
    }
}
