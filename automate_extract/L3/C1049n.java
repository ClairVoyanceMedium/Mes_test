package L3;

import C1.H0;

/* renamed from: L3.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1049n extends AbstractC1045j {
    public C1049n() {
    }

    public C1049n(C1052q c1052q) {
        super(c1052q);
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return ((obj instanceof Comparable) && obj.getClass() == obj2.getClass()) ? ((Comparable) obj).compareTo(obj2) == 0 : ((obj instanceof J3.b) && (obj2 instanceof Number)) ? ((J3.b) obj).s((Number) obj2) == 0 : ((obj2 instanceof J3.b) && (obj instanceof Number)) ? ((J3.b) obj2).s((Number) obj) == 0 : obj.equals(obj2);
    }

    @Override // L3.AbstractC1045j
    public final boolean c(Object obj, Object obj2) {
        return d(obj, obj2);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder();
        H0.s(this.f4950X, i8, sb, " = ");
        return F5.n.m(this.f4951Y, i8, sb);
    }
}
