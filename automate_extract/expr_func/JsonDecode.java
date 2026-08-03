package com.llamalab.automate.expr.func;

import J3.a;
import J3.e;
import J3.h;
import com.llamalab.automate.C1708z0;
import com.llamalab.json.UnexpectedEventException;
import com.llamalab.safs.internal.m;
import e4.C1759b;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class JsonDecode extends UnaryFunction {
    public static final String NAME = "jsonDecode";

    public static Object b(C1759b c1759b, int i8) {
        double Y7;
        if (i8 == 0) {
            throw null;
        }
        int i9 = i8 - 1;
        if (i9 == 1) {
            c1759b.f();
            return null;
        }
        if (i9 == 2) {
            Y7 = h.Y(c1759b.h(false));
        } else {
            if (i9 != 3) {
                if (i9 == 4) {
                    return c1759b.m();
                }
                if (i9 == 5) {
                    a aVar = new a();
                    c1759b.t();
                    while (c1759b.c(true)) {
                        int i10 = c1759b.f18175y0;
                        aVar.add(b(c1759b, i10 == -1 ? 0 : C1759b.f18164M1[i10]));
                    }
                    return aVar;
                }
                if (i9 != 7) {
                    throw new UnexpectedEventException(c1759b, 2, 3, 4, 5, 6, 8);
                }
                e eVar = new e();
                c1759b.v();
                while (c1759b.p(true)) {
                    eVar.m0(c1759b.toString(), b(c1759b, c1759b.f()), null);
                }
                return eVar;
            }
            Y7 = c1759b.i().doubleValue();
        }
        return Double.valueOf(Y7);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        if (c22 == null) {
            return null;
        }
        C1759b c1759b = new C1759b(new StringReader(h.e0(c22)));
        try {
            try {
                Object b8 = b(c1759b, c1759b.f());
                c1759b.d();
                try {
                    c1759b.close();
                } catch (Throwable unused) {
                }
                return b8;
            } catch (IOException e8) {
                throw new RuntimeException(e8);
            }
        } finally {
            Charset charset = m.f17837a;
            try {
                c1759b.close();
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
