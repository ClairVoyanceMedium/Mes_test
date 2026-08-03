package com.llamalab.automate.stmt;

import C1.C1;
import C1.D1;
import android.security.KeyChainException;
import android.util.Pair;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import j3.AbstractC2007c;
import j3.C2017m;
import j3.InterfaceC2012h;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/* loaded from: classes.dex */
public abstract class AdbAction extends Action implements AsyncStatement {
    public InterfaceC1700x0 alias;
    public InterfaceC1700x0 host;
    public InterfaceC1700x0 port;
    public InterfaceC1700x0 security;

    public static abstract class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f16229L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16230M1;

        /* renamed from: N1, reason: collision with root package name */
        public final String f16231N1;

        /* renamed from: O1, reason: collision with root package name */
        public final boolean f16232O1;

        public a(int i8, String str, String str2, boolean z7) {
            this.f16229L1 = str;
            this.f16230M1 = i8;
            this.f16232O1 = z7;
            this.f16231N1 = str2;
        }

        public static void y2() {
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            AutomateService automateService = this.f15400Y;
            String str = this.f16231N1;
            Pair<X509Certificate[], PrivateKey> b8 = com.llamalab.automate.C.b(automateService, str);
            if (b8 == null) {
                throw new KeyChainException(D1.k("Certificate or private key inaccessible: ", str));
            }
            y2();
            InterfaceC2012h k8 = C1.k(new Socket(), new InetSocketAddress(this.f16229L1, this.f16230M1));
            try {
                y2();
                AbstractC2007c abstractC2007c = (AbstractC2007c) k8;
                abstractC2007c.b(((X509Certificate[]) b8.first)[0], (PrivateKey) b8.second, C2017m.f20197d, this.f16232O1, 3000);
                y2();
                z2(abstractC2007c);
                abstractC2007c.close();
            } catch (Throwable th) {
                if (k8 != null) {
                    try {
                        ((AbstractC2007c) k8).close();
                    } catch (Throwable th2) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        } catch (Exception unused) {
                        }
                    }
                }
                throw th;
            }
        }

        public abstract void z2(AbstractC2007c abstractC2007c);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.host);
        dVar.g(this.port);
        if (94 <= dVar.f6413Z) {
            dVar.g(this.security);
        }
        dVar.g(this.alias);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new C1642f();
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.host = (InterfaceC1700x0) cVar.readObject();
        this.port = (InterfaceC1700x0) cVar.readObject();
        if (94 <= cVar.f6409x0) {
            this.security = (InterfaceC1700x0) cVar.readObject();
        }
        this.alias = (InterfaceC1700x0) cVar.readObject();
    }

    public abstract void q(C1708z0 c1708z0, String str, int i8, boolean z7, String str2);

    @Override // com.llamalab.automate.A2
    public boolean r1(C1708z0 c1708z0) {
        String x7 = J3.h.x(c1708z0, this.host, "localhost");
        int m8 = J3.h.m(c1708z0, this.port, 5555);
        boolean f8 = J3.h.f(c1708z0, this.security, false);
        String x8 = J3.h.x(c1708z0, this.alias, null);
        if (x8 == null) {
            throw new RequiredArgumentNullException("alias");
        }
        q(c1708z0, x7, m8, f8, x8);
        return false;
    }
}
