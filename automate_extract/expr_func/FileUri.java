package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import android.net.Uri;
import android.util.Base64;
import com.google.android.gms.internal.play_billing.I2;
import com.llamalab.automate.AutomateSignatureFileProvider;
import com.llamalab.automate.C1708z0;
import com.llamalab.safs.n;
import g4.C1828b;
import i4.C1949c;
import i4.C1951e;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import s4.d;
import x3.C2442t;

@g(1)
/* loaded from: classes.dex */
public final class FileUri extends BinaryFunction {
    public static final String NAME = "fileUri";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.llamalab.safs.n] */
    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        char c8;
        Uri d8;
        Object c22 = this.f4950X.c2(c1708z0);
        if (c22 != null) {
            d k8 = I2.k(c22.toString(), new String[0]);
            C1949c c1949c = (C1949c) k8.f22249X;
            boolean M7 = k8.M();
            d dVar = k8;
            if (!M7) {
                dVar = ((d) c1949c.v()).F(k8);
            }
            String x7 = h.x(c1708z0, this.f4951Y, "");
            int length = x7.length();
            loop0: while (true) {
                c8 = 'a';
                while (true) {
                    length--;
                    if (length < 0) {
                        break loop0;
                    }
                    char charAt = x7.charAt(length);
                    if (charAt != 'a') {
                        if (charAt == 'd') {
                            c8 = 'd';
                        } else if (charAt == 'f') {
                            c8 = 'f';
                        } else if (charAt == 's') {
                            c8 = 's';
                        }
                    }
                }
            }
            if (c8 != 'd') {
                if (c8 == 'f') {
                    d8 = C1951e.d(dVar);
                } else if (c8 != 's') {
                    d8 = C1828b.a(dVar).build();
                } else {
                    Uri uri = C1828b.a.f18792a;
                    if (!dVar.M()) {
                        throw new IllegalArgumentException();
                    }
                    Uri.Builder buildUpon = C1828b.a.f18792a.buildUpon();
                    Iterator<n> it = dVar.iterator();
                    while (it.hasNext()) {
                        String obj = it.next().toString();
                        if (!obj.isEmpty()) {
                            buildUpon.appendPath(obj);
                        }
                    }
                    Uri build = buildUpon.build();
                    C2442t c2442t = AutomateSignatureFileProvider.f14634X;
                    try {
                        d8 = build.buildUpon().fragment("1." + Base64.encodeToString(AutomateSignatureFileProvider.b(build.getPath()), 11)).build();
                    } catch (IOException | GeneralSecurityException e8) {
                        throw new SecurityException(e8);
                    }
                }
                return d8.toString();
            }
            try {
                return C1951e.c(dVar).buildDocumentUri(dVar).toString();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
