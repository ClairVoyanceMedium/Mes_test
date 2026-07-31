package L3;

import C1.H0;
import com.llamalab.automate.C1708z0;

/* renamed from: L3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1036a extends AbstractC1040e {
    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        Object c23 = this.f4951Y.c2(c1708z0);
        if (!(c22 instanceof J3.b) || !(c23 instanceof J3.b)) {
            return Double.valueOf(J3.h.a0(c23) + J3.h.a0(c22));
        }
        J3.b bVar = (J3.b) c22;
        bVar.getClass();
        return J3.b.g(bVar, (J3.b) c23, true);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder();
        H0.s(this.f4950X, i8, sb, " + ");
        return F5.n.m(this.f4951Y, i8, sb);
    }
}
