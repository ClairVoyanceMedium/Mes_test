package com.llamalab.automate.stmt;

import Y3.F;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.HttpAccept;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.SSLContext;
import x3.C2434l;

@F3.f("http_accept_tcp.html")
@F3.i(C2541R.string.stmt_http_accept_tcp_title)
@F3.h(C2541R.string.stmt_http_accept_tcp_summary)
@F3.e(C2541R.layout.stmt_http_accept_tcp_edit)
/* loaded from: classes.dex */
public final class HttpAcceptTcp extends HttpAccept {

    /* renamed from: L1, reason: collision with root package name */
    public static final int[] f16702L1 = {1073741825};
    public InterfaceC1700x0 networkInterface;
    public InterfaceC1700x0 port;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        int i8 = Build.VERSION.SDK_INT;
        if (30 > i8) {
            return 21 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return !isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.f15551l} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_http_accept_tcp_title);
        l8.v(this.uri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.HttpAccept, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.networkInterface);
        dVar.g(this.port);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.alias);
        visitor.b(this.method);
        visitor.b(this.uri);
        visitor.b(this.contentType);
        visitor.b(this.saveBody);
        visitor.b(this.bodyPath);
        visitor.b(this.varRequestUri);
        visitor.b(this.varRequestBody);
        visitor.b(this.varRequestHeaders);
        visitor.b(this.networkInterface);
        visitor.b(this.port);
    }

    @Override // com.llamalab.automate.stmt.HttpAccept, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.networkInterface = (InterfaceC1700x0) cVar.readObject();
        this.port = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0079, code lost:
    
        if (r12.varRequestBody != null) goto L32;
     */
    @Override // com.llamalab.automate.stmt.HttpAccept
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(C1708z0 c1708z0, SSLContext sSLContext) {
        int[] iArr;
        int i8 = 1;
        int[] iArr2 = new int[Q3.e.f6174f + 1];
        int i9 = 0;
        boolean z7 = false;
        for (int i10 : J3.h.n(c1708z0, this.networkInterface, f16702L1)) {
            if (1073741825 == i10) {
                z7 = true;
            } else if (i10 >= 0 && i10 <= Q3.e.f6174f) {
                iArr2[i9] = i10;
                i9++;
            }
        }
        if (i9 > 0) {
            iArr = Arrays.copyOf(iArr2, i9);
        } else {
            if (!z7) {
                throw new IllegalArgumentException("No supported network interface");
            }
            iArr = C2434l.f23393d;
        }
        int m8 = J3.h.m(c1708z0, this.port, sSLContext != null ? 8443 : 8080);
        if (m8 <= 0) {
            throw new IllegalArgumentException("port");
        }
        Q3.q qVar = new Q3.q(m8, z7, iArr, sSLContext);
        String x7 = J3.h.x(c1708z0, this.method, "GET");
        String x8 = J3.h.x(c1708z0, this.uri, "/");
        String x9 = J3.h.x(c1708z0, this.contentType, "*/*");
        int m9 = J3.h.m(c1708z0, this.saveBody, 0);
        com.llamalab.safs.n nVar = null;
        if (m9 != 1) {
            i8 = 2;
            if (m9 == 2) {
                nVar = J3.h.p(c1708z0, this.bodyPath);
            }
            i8 = 0;
        }
        Pattern compile = Pattern.compile(x8);
        F.a aVar = Y3.F.f7826a;
        int length = x9.length();
        List emptyList = Collections.emptyList();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (',' == x9.charAt(i12)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(Y3.F.g(x9, i11, i12));
                i11 = i12 + 1;
            }
        }
        if (i11 < length) {
            if (emptyList.isEmpty()) {
                emptyList = new ArrayList();
            }
            emptyList.add(Y3.F.g(x9, i11, length));
        }
        c1708z0.w(new J(qVar, new Q3.c(x7, compile, emptyList), i8, nVar));
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_http_accept_tcp_title);
        c1708z0.H(J.class);
        String x7 = J3.h.x(c1708z0, this.alias, null);
        if (x7 == null) {
            q(c1708z0, null);
            return false;
        }
        HttpAccept.a aVar = new HttpAccept.a(x7);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }
}
