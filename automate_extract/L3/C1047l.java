package L3;

import C1.H0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;

/* renamed from: L3.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1047l extends U {
    public C1047l() {
    }

    public C1047l(InterfaceC1700x0 interfaceC1700x0, J3.k kVar, InterfaceC1700x0 interfaceC1700x02) {
        super(interfaceC1700x0, kVar, interfaceC1700x02);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        return (J3.h.J(this.f4940X.c2(c1708z0)) ? this.f4941Y : this.f4942Z).c2(c1708z0);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder();
        H0.s(this.f4940X, i8, sb, " ? ");
        H0.s(this.f4941Y, i8, sb, " : ");
        return F5.n.m(this.f4942Z, i8, sb);
    }
}
