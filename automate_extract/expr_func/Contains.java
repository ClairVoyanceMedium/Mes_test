package com.llamalab.automate.expr.func;

import F3.g;
import J3.a;
import J3.e;
import J3.h;
import R3.c;
import R3.d;
import androidx.appcompat.widget.C1231k;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import java.util.Iterator;
import java.util.NoSuchElementException;
import x3.C2446x;

@g(2)
/* loaded from: classes.dex */
public class Contains extends TernaryFunction {
    public static final String NAME = "contains";

    public static boolean b(Object obj, int i8, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (!(obj2 instanceof Comparable) || obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof String) {
            if (i8 == 2) {
                return C2446x.d((String) obj, (String) obj2);
            }
            if (i8 == 66) {
                return ((String) obj).equalsIgnoreCase((String) obj2);
            }
        }
        return ((Comparable) obj).compareTo(obj2) == 0;
    }

    @Override // L3.U, R3.e
    public final void Y0(d dVar) {
        dVar.g(this.f4940X);
        dVar.g(this.f4941Y);
        if (22 <= dVar.f6413Z) {
            dVar.g(this.f4942Z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x015e, code lost:
    
        if (r2 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00f7, code lost:
    
        if (((J3.e) r0).i0(J3.h.f0(null, r1)) != false) goto L22;
     */
    @Override // com.llamalab.automate.InterfaceC1700x0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c2(C1708z0 c1708z0) {
        a.C0026a c0026a;
        Object c22 = this.f4940X.c2(c1708z0);
        Object c23 = this.f4941Y.c2(c1708z0);
        String x7 = h.x(c1708z0, this.f4942Z, "");
        int length = x7.length();
        int i8 = 0;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            char charAt = x7.charAt(length);
            if (charAt == 'i') {
                i8 |= 2;
            } else if (charAt == 'k') {
                i8 |= MoreOsConstants.IN_ONLYDIR;
            } else if (charAt == 'u') {
                i8 |= 64;
            }
        }
        if (c22 instanceof a) {
            Iterator<Object> it = ((a) c22).iterator();
            do {
                c0026a = (a.C0026a) it;
                if (!c0026a.hasNext()) {
                    return Double.valueOf(0.0d);
                }
            } while (!b(c0026a.next(), i8, c23));
            return Double.valueOf(1.0d);
        }
        boolean z7 = true;
        if (!(c22 instanceof e)) {
            if (c22 != null) {
                if (i8 == 2) {
                    String e02 = h.e0(c22);
                    String e03 = h.e0(c23);
                    int length2 = e03.length();
                    if (length2 != 0) {
                        int length3 = e02.length();
                        int i9 = 0;
                        int i10 = 0;
                        while (true) {
                            length3--;
                            if (length3 >= 0) {
                                if (C2446x.k(e02.charAt(i10)) != C2446x.k(e03.charAt(i9))) {
                                    i10 -= i9;
                                    length3 += i9;
                                    i9 = 0;
                                } else {
                                    i9++;
                                    if (i9 == length2) {
                                        break;
                                    }
                                }
                                i10++;
                            } else {
                                z7 = i9 == length2;
                            }
                        }
                    }
                } else if (i8 == 66) {
                }
            }
            return Double.valueOf(0.0d);
        }
        if ((i8 & MoreOsConstants.IN_ONLYDIR) == 0) {
            e eVar = (e) c22;
            eVar.getClass();
            C1231k c1231k = (C1231k) eVar.f9362Z;
            while (true) {
                if (!(c1231k != eVar)) {
                    break;
                }
                if (c1231k == eVar) {
                    throw new NoSuchElementException();
                }
                C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                if (b(((e.a) c1231k).f4644x1, i8, c23)) {
                    break;
                }
                c1231k = c1231k2;
            }
        } else if ((i8 & 2) != 0) {
            if (c23 != null) {
                String e04 = h.e0(c23);
                int i11 = i8 & 64;
                e eVar2 = (e) c22;
                eVar2.getClass();
                if (i11 == 0) {
                    C1231k c1231k3 = (C1231k) eVar2.f9362Z;
                    while (true) {
                        if (!(c1231k3 != eVar2)) {
                            break;
                        }
                        if (c1231k3 == eVar2) {
                            throw new NoSuchElementException();
                        }
                        C1231k c1231k4 = (C1231k) c1231k3.f9362Z;
                        if (C2446x.d(((e.a) c1231k3).f4645y0, e04)) {
                            break;
                        }
                        c1231k3 = c1231k4;
                    }
                } else {
                    C1231k c1231k5 = (C1231k) eVar2.f9362Z;
                    while (true) {
                        if (!(c1231k5 != eVar2)) {
                            break;
                        }
                        if (c1231k5 == eVar2) {
                            throw new NoSuchElementException();
                        }
                        C1231k c1231k6 = (C1231k) c1231k5.f9362Z;
                        if (((e.a) c1231k5).f4645y0.equalsIgnoreCase(e04)) {
                            break;
                        }
                        c1231k5 = c1231k6;
                    }
                }
            }
            return Double.valueOf(0.0d);
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }

    @Override // L3.U, R3.e
    public final void o0(c cVar) {
        this.f4940X = (InterfaceC1700x0) cVar.readObject();
        this.f4941Y = (InterfaceC1700x0) cVar.readObject();
        if (22 <= cVar.f6409x0) {
            this.f4942Z = (InterfaceC1700x0) cVar.readObject();
        }
    }
}
