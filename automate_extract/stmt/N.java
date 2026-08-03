package com.llamalab.automate.stmt;

import L3.C1059y;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.expr.func.UrlEncode;
import g4.C1827a;

/* loaded from: classes.dex */
public final class N {

    /* renamed from: a, reason: collision with root package name */
    public static final String f16945a = C1827a.h.f18784a + "/";

    public static InterfaceC1700x0 a(InterfaceC1700x0 interfaceC1700x0) {
        if (interfaceC1700x0 instanceof J3.k) {
            if (!(interfaceC1700x0 instanceof L3.I)) {
                return new L3.W(C1827a.h.f18784a.buildUpon().appendPath(J3.h.e0(interfaceC1700x0)).toString());
            }
        } else if (interfaceC1700x0 != null) {
            L3.V v8 = new L3.V(1);
            String[] strArr = v8.f4943X;
            strArr[0] = f16945a;
            v8.f4944Y[0] = new UrlEncode(interfaceC1700x0);
            strArr[1] = "";
            v8.f4945Z[0] = 1;
            return new C1059y(interfaceC1700x0, v8);
        }
        return interfaceC1700x0;
    }

    public static InterfaceC1700x0 b(R3.c cVar) {
        int i8 = cVar.f6409x0;
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        return 99 <= i8 ? interfaceC1700x0 : a(interfaceC1700x0);
    }
}
