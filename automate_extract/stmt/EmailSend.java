package com.llamalab.automate.stmt;

import android.content.Context;
import androidx.appcompat.widget.C1231k;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import j5.C2020a;
import java.io.IOException;
import k5.C2051c;
import x3.C2434l;

@F3.f("email_send.html")
@F3.a(C2541R.integer.ic_content_email)
@F3.i(C2541R.string.stmt_email_send_title)
@F3.h(C2541R.string.stmt_email_send_summary)
@F3.e(C2541R.layout.stmt_email_send_edit)
/* loaded from: classes.dex */
public final class EmailSend extends EmailAction implements AsyncStatement {
    public InterfaceC1700x0 account;
    public InterfaceC1700x0 from;
    public InterfaceC1700x0 host;
    public InterfaceC1700x0 port;
    public InterfaceC1700x0 security;
    public InterfaceC1700x0 trust;

    public static final class a extends Y0 {

        /* renamed from: S1, reason: collision with root package name */
        public final String f16613S1;

        /* renamed from: T1, reason: collision with root package name */
        public final String f16614T1;
        public final int U1;

        /* renamed from: V1, reason: collision with root package name */
        public final boolean f16615V1;
        public final C1231k W1;

        public a(C2020a c2020a, String str, int i8, boolean z7, C1231k c1231k, String str2, String[] strArr, String[] strArr2, String[] strArr3, String str3, String str4, com.llamalab.safs.n[] nVarArr) {
            super(c2020a, strArr, strArr2, strArr3, str3, str4, nVarArr);
            this.f16614T1 = str;
            this.U1 = i8;
            this.f16615V1 = z7;
            this.W1 = c1231k;
            this.f16613S1 = str2;
        }

        public final void E2() {
            C2020a c2020a = this.f17325R1;
            boolean z7 = true;
            int k8 = c2020a.k("STARTTLS", null, true);
            if (k8 >= 200 && k8 < 300) {
                c2020a.m();
            } else {
                z7 = false;
            }
            if (!z7) {
                throw new IOException("Host rejected STARTTLS");
            }
            C2020a c2020a2 = this.f17325R1;
            String hostName = c2020a2.e().getHostName();
            if (hostName != null) {
                c2020a2.l(15, hostName);
            }
            C2(15);
        }

        @Override // com.llamalab.automate.stmt.P0
        public final String z2() {
            return this.f16613S1;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_email_send);
        l8.u(C2541R.string.caption_to, this.to);
        l8.v(this.message, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.EmailAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.from);
        dVar.g(this.host);
        dVar.g(this.port);
        dVar.g(this.security);
        if (26 <= dVar.f6413Z) {
            dVar.g(this.trust);
        }
        dVar.g(this.account);
    }

    @Override // com.llamalab.automate.stmt.EmailAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.from);
        visitor.b(this.host);
        visitor.b(this.port);
        visitor.b(this.security);
        visitor.b(this.trust);
        visitor.b(this.account);
    }

    @Override // com.llamalab.automate.stmt.EmailAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.from = (InterfaceC1700x0) cVar.readObject();
        this.host = (InterfaceC1700x0) cVar.readObject();
        this.port = (InterfaceC1700x0) cVar.readObject();
        this.security = (InterfaceC1700x0) cVar.readObject();
        if (26 <= cVar.f6409x0) {
            this.trust = (InterfaceC1700x0) cVar.readObject();
        }
        this.account = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_email_send_title);
        String x7 = J3.h.x(c1708z0, this.host, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("host");
        }
        int m8 = J3.h.m(c1708z0, this.security, 0);
        int m9 = J3.h.m(c1708z0, this.port, 2 == m8 ? MoreOsConstants.KEY_FN_ESC : 25);
        C2020a c2020a = 2 == m8 ? new C2020a(0) : new C2020a();
        if (m8 != 0 && J3.h.f(c1708z0, this.trust, false)) {
            c2020a.f20243w = C2051c.f20520a;
        }
        C1231k c8 = J3.h.c(c1708z0, this.account);
        String x8 = J3.h.x(c1708z0, this.from, c8 != null ? (String) c8.f9361Y : null);
        InterfaceC1700x0 interfaceC1700x0 = this.to;
        String[] strArr = C2434l.f23396g;
        a aVar = new a(c2020a, x7, m9, 1 == m8, c8, x8, J3.h.w(c1708z0, interfaceC1700x0, strArr), J3.h.w(c1708z0, this.cc, strArr), J3.h.w(c1708z0, this.bcc, strArr), J3.h.x(c1708z0, this.subject, null), J3.h.x(c1708z0, this.message, null), J3.h.q(c1708z0, this.attachments, C2434l.f23404o));
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
