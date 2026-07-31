package L3;

import C1.H0;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class Q extends AbstractC1040e {
    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        return Double.valueOf(((int) J3.h.a0(this.f4950X.c2(c1708z0))) >>> ((int) J3.h.a0(this.f4951Y.c2(c1708z0))));
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder();
        H0.s(this.f4950X, i8, sb, " >>> ");
        return F5.n.m(this.f4951Y, i8, sb);
    }
}
