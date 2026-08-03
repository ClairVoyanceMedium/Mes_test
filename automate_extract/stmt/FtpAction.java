package com.llamalab.automate.stmt;

import androidx.appcompat.widget.C1231k;
import com.google.android.gms.internal.play_billing.I2;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import f5.AbstractC1793d;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.SSLException;
import k5.C2051c;

/* loaded from: classes.dex */
public abstract class FtpAction extends Action implements AsyncStatement {
    public InterfaceC1700x0 account;
    public InterfaceC1700x0 charset;
    public InterfaceC1700x0 host;
    public InterfaceC1700x0 port;
    public InterfaceC1700x0 prot;
    public InterfaceC1700x0 security;
    public InterfaceC1700x0 trust;

    public static abstract class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public g5.c f16651L1;

        /* renamed from: M1, reason: collision with root package name */
        public final String f16652M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16653N1;

        /* renamed from: O1, reason: collision with root package name */
        public final C1231k f16654O1;

        /* renamed from: P1, reason: collision with root package name */
        public final String f16655P1;

        public a(g5.c cVar, String str, int i8, C1231k c1231k, String str2) {
            this.f16651L1 = cVar;
            this.f16652M1 = str;
            this.f16653N1 = i8;
            this.f16654O1 = c1231k;
            this.f16655P1 = str2;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            g5.c cVar = this.f16651L1;
            if (cVar != null) {
                try {
                    cVar.h();
                } catch (Throwable unused) {
                }
                this.f16651L1 = null;
            }
            super.F(automateService);
        }

        public void y2() {
            String str;
            g5.c cVar = this.f16651L1;
            String str2 = this.f16652M1;
            cVar.f18584c = str2;
            InetAddress byName = InetAddress.getByName(str2);
            Socket createSocket = cVar.f18587f.createSocket();
            cVar.f18583b = createSocket;
            int i8 = this.f16653N1;
            createSocket.connect(new InetSocketAddress(byName, i8), cVar.f18589h);
            cVar.m();
            if (!I2.o(this.f16651L1.f18793l)) {
                throw new IOException("connect failed: " + str2 + ":" + i8);
            }
            C1231k c1231k = this.f16654O1;
            if (c1231k == null ? !this.f16651L1.s("anonymous", null) : !this.f16651L1.s((String) c1231k.f9361Y, (String) c1231k.f9362Z)) {
                throw new IOException("login failed");
            }
            g5.c cVar2 = this.f16651L1;
            if ((cVar2 instanceof g5.i) && (str = this.f16655P1) != null) {
                g5.i iVar = (g5.i) cVar2;
                iVar.getClass();
                if (200 != iVar.l("PBSZ", String.valueOf(0L))) {
                    throw new SSLException(iVar.k());
                }
                String[] strArr = g5.i.f18835P;
                boolean z7 = false;
                int i9 = 0;
                while (true) {
                    if (i9 >= 4) {
                        break;
                    }
                    if (strArr[i9].equals(str)) {
                        z7 = true;
                        break;
                    }
                    i9++;
                }
                if (!z7) {
                    throw new IllegalArgumentException();
                }
                if (200 != iVar.l("PROT", str)) {
                    throw new SSLException(iVar.k());
                }
                if ("C".equals(str)) {
                    iVar.f18587f = AbstractC1793d.f18580j;
                    iVar.f18588g = AbstractC1793d.f18581k;
                } else {
                    iVar.f18587f = new g5.k(iVar.f18839K);
                    iVar.f18588g = new g5.j(iVar.f18839K);
                    if (iVar.f18839K == null) {
                        iVar.f18839K = I2.d(iVar.f18837I, iVar.f18843O);
                    }
                }
            }
            g5.c cVar3 = this.f16651L1;
            cVar3.f18809u = 2;
            cVar3.f18812x = null;
            cVar3.f18811w = -1;
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.host);
        dVar.g(this.port);
        dVar.g(this.security);
        if (26 <= dVar.f6413Z) {
            dVar.g(this.trust);
        }
        if (85 <= dVar.f6413Z) {
            dVar.g(this.prot);
        }
        dVar.g(this.account);
        dVar.g(this.charset);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.host);
        visitor.b(this.port);
        visitor.b(this.security);
        visitor.b(this.trust);
        visitor.b(this.prot);
        visitor.b(this.account);
        visitor.b(this.charset);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.host = (InterfaceC1700x0) cVar.readObject();
        this.port = (InterfaceC1700x0) cVar.readObject();
        this.security = (InterfaceC1700x0) cVar.readObject();
        if (26 <= cVar.f6409x0) {
            this.trust = (InterfaceC1700x0) cVar.readObject();
        }
        if (85 <= cVar.f6409x0) {
            this.prot = (InterfaceC1700x0) cVar.readObject();
        }
        this.account = (InterfaceC1700x0) cVar.readObject();
        this.charset = (InterfaceC1700x0) cVar.readObject();
    }

    public abstract void q(C1708z0 c1708z0, g5.c cVar, String str, int i8, C1231k c1231k, String str2);

    @Override // com.llamalab.automate.A2
    public boolean r1(C1708z0 c1708z0) {
        InterfaceC1700x0 interfaceC1700x0;
        int i8;
        g5.c cVar;
        String x7 = J3.h.x(c1708z0, this.host, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("host");
        }
        if (J3.h.f(c1708z0, this.security, false)) {
            g5.i iVar = new g5.i();
            if (J3.h.f(c1708z0, this.trust, false)) {
                iVar.f18843O = C2051c.f20520a;
            }
            interfaceC1700x0 = this.port;
            i8 = 990;
            cVar = iVar;
        } else {
            g5.c cVar2 = new g5.c();
            interfaceC1700x0 = this.port;
            i8 = 21;
            cVar = cVar2;
        }
        g5.c cVar3 = cVar;
        int m8 = J3.h.m(c1708z0, interfaceC1700x0, i8);
        String x8 = J3.h.x(c1708z0, this.charset, null);
        if (x8 != null) {
            cVar3.f18797p = x8;
        }
        cVar3.f18589h = 15000;
        cVar3.f18810v = 15000;
        cVar3.f18804B = 1048576;
        q(c1708z0, cVar3, x7, m8, J3.h.c(c1708z0, this.account), J3.h.x(c1708z0, this.prot, null));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
