package L3;

import com.llamalab.automate.C1708z0;

/* renamed from: L3.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1056v extends Z {
    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        double d8;
        int i8;
        Object c22 = this.f4947X.c2(c1708z0);
        if (c22 instanceof String) {
            i8 = ((String) c22).length();
        } else if (c22 instanceof J3.a) {
            i8 = ((J3.a) c22).f4627Y;
        } else {
            if (!(c22 instanceof J3.e)) {
                d8 = 0.0d;
                return Double.valueOf(d8);
            }
            i8 = ((J3.e) c22).f4641x1;
        }
        d8 = i8;
        return Double.valueOf(d8);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        return F5.n.m(this.f4947X, i8, new StringBuilder("#"));
    }
}
