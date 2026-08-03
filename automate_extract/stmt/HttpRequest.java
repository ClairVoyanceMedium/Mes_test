package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.expr.func.JsonEncode;
import com.llamalab.automate.expr.func.UrlEncode;
import com.llamalab.automate.stmt.M;
import java.util.AbstractMap;
import p3.C2213b;
import x3.C2434l;

@F3.f("http_request.html")
@F3.a(C2541R.integer.ic_location_web_site)
@F3.i(C2541R.string.stmt_http_request_title)
@F3.h(C2541R.string.stmt_http_request_summary)
@F3.e(C2541R.layout.stmt_http_request_edit)
/* loaded from: classes.dex */
public final class HttpRequest extends Action implements AsyncStatement {
    public InterfaceC1700x0 account;
    public InterfaceC1700x0 alias;
    public InterfaceC1700x0 bodyPart;
    public InterfaceC1700x0 bodyPath;
    public InterfaceC1700x0 contentType;
    public InterfaceC1700x0 dontRedirect;
    public InterfaceC1700x0 headers;
    public InterfaceC1700x0 method;
    public InterfaceC1700x0 networkInterface;
    public InterfaceC1700x0 responsePath;
    public InterfaceC1700x0 saveResponse;
    public InterfaceC1700x0 timeout;
    public InterfaceC1700x0 trust;
    public InterfaceC1700x0 url;
    public J3.l varResponseBody;
    public J3.l varResponseCode;
    public J3.l varResponseHeaders;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        int i8 = Build.VERSION.SDK_INT;
        if (30 > i8) {
            return 21 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_http_request_title);
        l8.v(this.url, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (74 <= dVar.f6413Z) {
            dVar.g(this.networkInterface);
        }
        dVar.g(this.url);
        dVar.g(this.method);
        dVar.g(this.account);
        if (82 <= dVar.f6413Z) {
            dVar.g(this.timeout);
        }
        if (109 <= dVar.f6413Z) {
            dVar.g(this.alias);
        }
        if (45 <= dVar.f6413Z) {
            dVar.g(this.trust);
        }
        if (47 <= dVar.f6413Z) {
            dVar.g(this.dontRedirect);
        }
        dVar.g(this.contentType);
        dVar.g(this.bodyPart);
        if (82 <= dVar.f6413Z) {
            dVar.g(this.bodyPath);
        }
        if (35 <= dVar.f6413Z) {
            dVar.g(this.headers);
        }
        dVar.g(this.saveResponse);
        dVar.g(this.responsePath);
        dVar.g(this.varResponseCode);
        dVar.g(this.varResponseBody);
        if (35 <= dVar.f6413Z) {
            dVar.g(this.varResponseHeaders);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.networkInterface);
        visitor.b(this.url);
        visitor.b(this.method);
        visitor.b(this.account);
        visitor.b(this.timeout);
        visitor.b(this.alias);
        visitor.b(this.trust);
        visitor.b(this.dontRedirect);
        visitor.b(this.contentType);
        visitor.b(this.bodyPart);
        visitor.b(this.bodyPath);
        visitor.b(this.headers);
        visitor.b(this.saveResponse);
        visitor.b(this.responsePath);
        visitor.b(this.varResponseCode);
        visitor.b(this.varResponseBody);
        visitor.b(this.varResponseHeaders);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (74 <= cVar.f6409x0) {
            this.networkInterface = (InterfaceC1700x0) cVar.readObject();
        }
        this.url = (InterfaceC1700x0) cVar.readObject();
        this.method = (InterfaceC1700x0) cVar.readObject();
        this.account = (InterfaceC1700x0) cVar.readObject();
        if (82 <= cVar.f6409x0) {
            this.timeout = (InterfaceC1700x0) cVar.readObject();
        }
        if (109 <= cVar.f6409x0) {
            this.alias = (InterfaceC1700x0) cVar.readObject();
        }
        if (45 <= cVar.f6409x0) {
            this.trust = (InterfaceC1700x0) cVar.readObject();
        }
        if (47 <= cVar.f6409x0) {
            this.dontRedirect = (InterfaceC1700x0) cVar.readObject();
        }
        this.contentType = (InterfaceC1700x0) cVar.readObject();
        this.bodyPart = (InterfaceC1700x0) cVar.readObject();
        if (82 <= cVar.f6409x0) {
            this.bodyPath = (InterfaceC1700x0) cVar.readObject();
        }
        if (35 <= cVar.f6409x0) {
            this.headers = (InterfaceC1700x0) cVar.readObject();
        }
        this.saveResponse = (InterfaceC1700x0) cVar.readObject();
        this.responsePath = (InterfaceC1700x0) cVar.readObject();
        this.varResponseCode = (J3.l) cVar.readObject();
        this.varResponseBody = (J3.l) cVar.readObject();
        if (35 <= cVar.f6409x0) {
            this.varResponseHeaders = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        String x7;
        CharSequence[] charSequenceArr;
        com.llamalab.safs.n nVar;
        int i8;
        int m8;
        ConnectivityManager connectivityManager;
        c1708z0.q(C2541R.string.stmt_http_request_title);
        String x8 = J3.h.x(c1708z0, this.url, null);
        if (x8 == null) {
            throw new RequiredArgumentNullException("url");
        }
        if (!x8.regionMatches(true, 0, "http://", 0, 7) && !x8.regionMatches(true, 0, "https://", 0, 8)) {
            x8 = "http://".concat(x8);
        }
        Object u8 = J3.h.u(c1708z0, this.bodyPart, null);
        if (u8 instanceof J3.e) {
            x7 = J3.h.x(c1708z0, this.contentType, "application/x-www-form-urlencoded");
            AbstractMap.SimpleImmutableEntry a8 = Y3.F.a(x7, C2213b.f21561c);
            charSequenceArr = "application/x-www-form-urlencoded".contentEquals((CharSequence) a8.getKey()) ? new CharSequence[]{UrlEncode.c((J3.e) u8, Y3.F.b(a8, "charset", "UTF-8").toString())} : "application/json".contentEquals((CharSequence) a8.getKey()) ? new CharSequence[]{JsonEncode.b(u8)} : new CharSequence[]{J3.h.e0(u8)};
        } else if (u8 instanceof J3.a) {
            x7 = J3.h.x(c1708z0, this.contentType, "text/plain");
            charSequenceArr = J3.h.M((J3.a) u8);
        } else if (u8 != null) {
            x7 = J3.h.x(c1708z0, this.contentType, "text/plain");
            charSequenceArr = new CharSequence[]{J3.h.e0(u8)};
        } else {
            x7 = J3.h.x(c1708z0, this.contentType, null);
            charSequenceArr = C2434l.f23398i;
        }
        CharSequence[] charSequenceArr2 = charSequenceArr;
        com.llamalab.safs.n[] q8 = J3.h.q(c1708z0, this.bodyPath, C2434l.f23404o);
        String x9 = J3.h.x(c1708z0, this.method, (charSequenceArr2.length == 0 && q8.length == 0) ? "GET" : "POST");
        J3.e h8 = J3.h.h(c1708z0, this.headers);
        J3.e eVar = h8 != null ? new J3.e(h8) : new J3.e(4);
        if (x7 != null) {
            eVar.m0("Content-Type", x7, null);
        }
        int e8 = (int) y4.j.e(J3.h.t(c1708z0, this.timeout, 15000L), 0L, 2147483647L);
        String x10 = J3.h.x(c1708z0, this.alias, null);
        boolean f8 = J3.h.f(c1708z0, this.trust, false);
        boolean z7 = !J3.h.f(c1708z0, this.dontRedirect, false);
        C1231k c8 = J3.h.c(c1708z0, this.account);
        if (c8 != null) {
            eVar.m0("Authorization", "Basic " + Base64.encodeToString((((String) c8.f9361Y) + ":" + ((String) c8.f9362Z)).getBytes(C2213b.f21561c), 2), null);
        }
        int m9 = J3.h.m(c1708z0, this.saveResponse, 0);
        if (m9 != 1) {
            if (m9 == 2) {
                nVar = J3.h.p(c1708z0, this.responsePath);
                i8 = 2;
            }
            nVar = null;
            i8 = 0;
        } else {
            if (this.varResponseBody != null) {
                nVar = null;
                i8 = 1;
            }
            nVar = null;
            i8 = 0;
        }
        int i9 = Build.VERSION.SDK_INT;
        if (21 > i9 || (m8 = J3.h.m(c1708z0, this.networkInterface, -1)) < 0) {
            K k8 = new K(Uri.parse(x8), e8, x10, f8, z7, x9, eVar, charSequenceArr2, q8, i8, nVar);
            c1708z0.w(k8);
            k8.w2();
            return false;
        }
        NetworkRequest build = new NetworkRequest.Builder().addTransportType(m8).build();
        M m10 = new M(Uri.parse(x8), e8, x10, f8, z7, x9, eVar, charSequenceArr2, q8, i8, nVar);
        c1708z0.w(m10);
        M.a aVar = m10.f16882Z1;
        int i10 = m10.f16827S1;
        if (26 <= i9) {
            connectivityManager = m10.W1;
            if (i10 > 0) {
                connectivityManager.requestNetwork(build, aVar, i10);
                m10.n2(1);
                return false;
            }
        } else {
            if (i10 > 0) {
                L l8 = new L(m10);
                m10.f16880X1 = l8;
                m10.f15400Y.f14581L1.postDelayed(l8, i10);
            }
            connectivityManager = m10.W1;
        }
        connectivityManager.requestNetwork(build, aVar);
        m10.n2(1);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varResponseCode;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[0]);
        }
        J3.l lVar2 = this.varResponseHeaders;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[1]);
        }
        J3.l lVar3 = this.varResponseBody;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, objArr[2]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
