package L3;

import C1.H0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;

/* renamed from: L3.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1059y extends AbstractC1040e {
    public C1059y() {
    }

    public C1059y(InterfaceC1700x0 interfaceC1700x0, V v8) {
        super(interfaceC1700x0, v8);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        return J3.h.J(c22) ? this.f4951Y.c2(c1708z0) : c22;
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder();
        H0.s(this.f4950X, i8, sb, " && ");
        return F5.n.m(this.f4951Y, i8, sb);
    }
}
