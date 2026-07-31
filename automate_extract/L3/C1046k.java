package L3;

import C1.H0;
import com.llamalab.automate.C1708z0;

/* renamed from: L3.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1046k extends AbstractC1040e {
    public C1046k() {
    }

    public C1046k(W w8, C1052q c1052q) {
        super(w8, c1052q);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        Object c23 = this.f4951Y.c2(c1708z0);
        if (c22 == null) {
            return J3.h.e0(c23);
        }
        if (c23 == null) {
            return J3.h.e0(c22);
        }
        return J3.h.e0(c22) + J3.h.e0(c23);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder();
        H0.s(this.f4950X, i8, sb, " ++ ");
        return F5.n.m(this.f4951Y, i8, sb);
    }
}
