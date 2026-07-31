package L3;

import C1.H0;

/* renamed from: L3.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1051p extends AbstractC1045j {
    @Override // L3.AbstractC1045j
    public final boolean c(Object obj, Object obj2) {
        if (obj2 == null) {
            if (obj == null) {
                return false;
            }
        } else {
            if (obj == null) {
                return false;
            }
            if ((obj instanceof Comparable) && obj.getClass() == obj2.getClass()) {
                if (((Comparable) obj).compareTo(obj2) <= 0) {
                    return false;
                }
            } else if ((obj instanceof J3.b) && (obj2 instanceof Number)) {
                if (((J3.b) obj).s((Number) obj2) <= 0) {
                    return false;
                }
            } else if (!(obj2 instanceof J3.b) || !(obj instanceof Number) || ((J3.b) obj2).s((Number) obj) >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder();
        H0.s(this.f4950X, i8, sb, " > ");
        return F5.n.m(this.f4951Y, i8, sb);
    }
}
