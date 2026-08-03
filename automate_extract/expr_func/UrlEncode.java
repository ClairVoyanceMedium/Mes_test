package com.llamalab.automate.expr.func;

import F3.g;
import J3.a;
import J3.e;
import J3.h;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.NoSuchElementException;

@g(1)
/* loaded from: classes.dex */
public final class UrlEncode extends BinaryFunction {
    public static final String NAME = "urlEncode";

    public UrlEncode() {
    }

    public UrlEncode(InterfaceC1700x0 interfaceC1700x0) {
        super(interfaceC1700x0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static StringBuilder c(e eVar, String str) {
        StringBuilder sb = new StringBuilder();
        eVar.getClass();
        C1231k c1231k = (C1231k) eVar.f9362Z;
        String str2 = "";
        while (true) {
            if (!(c1231k != eVar)) {
                return sb;
            }
            if (c1231k == eVar) {
                throw new NoSuchElementException();
            }
            C1231k c1231k2 = (C1231k) c1231k.f9362Z;
            e.a aVar = (e.a) c1231k;
            Object obj = aVar.f4644x1;
            boolean z7 = obj instanceof a;
            String str3 = aVar.f4645y0;
            if (z7) {
                a aVar2 = (a) obj;
                aVar2.getClass();
                int i8 = 0;
                while (true) {
                    if (i8 < aVar2.f4627Y) {
                        if (i8 >= aVar2.f4627Y) {
                            throw new NoSuchElementException();
                        }
                        int i9 = i8 + 1;
                        Object obj2 = aVar2.get(i8);
                        sb.append(str2);
                        sb.append(URLEncoder.encode(str3, str));
                        sb.append('=');
                        if (obj2 != null) {
                            sb.append(URLEncoder.encode(h.e0(obj2), str));
                        }
                        str2 = "&";
                        i8 = i9;
                    }
                }
            } else {
                sb.append(str2);
                sb.append(URLEncoder.encode(str3, str));
                sb.append('=');
                if (obj != null) {
                    sb.append(URLEncoder.encode(h.e0(obj), str));
                }
                str2 = "&";
            }
            c1231k = c1231k2;
        }
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4950X.c2(c1708z0);
        if (c22 == null) {
            return null;
        }
        String x7 = h.x(c1708z0, this.f4951Y, "UTF-8");
        try {
            return c22 instanceof e ? c((e) c22, x7).toString() : URLEncoder.encode(h.e0(c22), x7);
        } catch (UnsupportedEncodingException e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
