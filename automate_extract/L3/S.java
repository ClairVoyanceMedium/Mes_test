package L3;

import C1.H0;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class S extends AbstractC1040e {
    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        if (!(c22 instanceof CharSequence)) {
            if (c22 instanceof J3.a) {
                return ((J3.a) c22).get((int) J3.h.W(this.f4951Y.c2(c1708z0)));
            }
            if (c22 instanceof J3.e) {
                return ((J3.e) c22).j0(J3.h.e0(this.f4951Y.c2(c1708z0)));
            }
            return null;
        }
        int length = ((CharSequence) c22).length();
        if (y4.j.i((int) J3.h.W(this.f4951Y.c2(c1708z0)), length) < length) {
            return Double.valueOf(r0.charAt(r6));
        }
        return null;
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder();
        H0.s(this.f4950X, i8, sb, "[");
        sb.append(this.f4951Y.x(i8));
        sb.append("]");
        return sb.toString();
    }
}
