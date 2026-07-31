package L3;

import com.llamalab.automate.C1708z0;

/* renamed from: L3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1042g extends Z {
    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        if (!(c22 instanceof J3.b)) {
            return Double.valueOf(((int) J3.h.a0(c22)) ^ (-1));
        }
        J3.b bVar = (J3.b) c22;
        int i8 = bVar.f4638X;
        if (i8 == 0) {
            return J3.b.f4636y0;
        }
        int[] iArr = bVar.f4639Y;
        return J3.b.k(iArr, iArr.length, i8 < 0, null, 0, false, 0);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        return F5.n.m(this.f4947X, i8, new StringBuilder("~"));
    }
}
