package com.llamalab.automate.stmt;

import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.stmt.EmailSend;
import i5.C1954b;
import j5.C2020a;
import j5.C2022c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import k5.C2049a;
import s.C2279g;
import x3.C2434l;
import x3.C2440r;

/* loaded from: classes.dex */
public abstract class Y0 extends P0 {

    /* renamed from: R1, reason: collision with root package name */
    public C2020a f17325R1;

    public Y0(C2020a c2020a, String[] strArr, String[] strArr2, String[] strArr3, String str, String str2, com.llamalab.safs.n[] nVarArr) {
        super(strArr, strArr2, strArr3, str, str2, nVarArr);
        this.f17325R1 = c2020a;
    }

    public final <T> void C2(int i8) {
        int i9 = this.f17325R1.f20235p;
        if (i9 >= 400 && i9 < 500) {
            throw new IOException(C2022c.f20239a[i8] + " transient failure: " + this.f17325R1.j());
        }
        if (i9 >= 500 && i9 < 600) {
            throw new IOException(C2022c.f20239a[i8] + " permanent failure: " + this.f17325R1.j());
        }
    }

    public final void D2(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (str != null) {
                    String trim = str.trim();
                    if (!trim.isEmpty()) {
                        C2020a c2020a = this.f17325R1;
                        c2020a.getClass();
                        c2020a.k(C2022c.f20239a[2], "<" + trim + ">", false);
                        C2(2);
                    }
                }
            }
        }
    }

    @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        super.F(automateService);
        C2020a c2020a = this.f17325R1;
        if (c2020a != null) {
            Socket socket = c2020a.f18583b;
            if (socket == null ? false : socket.isConnected()) {
                try {
                    this.f17325R1.l(13, null);
                } catch (Throwable unused) {
                }
                try {
                    this.f17325R1.h();
                } catch (Throwable unused2) {
                }
            }
            this.f17325R1 = null;
        }
    }

    @Override // com.llamalab.automate.AbstractRunnableC1694v2
    public final void x2() {
        int i8;
        String[] strArr;
        String b8;
        EmailSend.a aVar = (EmailSend.a) this;
        C2020a c2020a = aVar.f17325R1;
        c2020a.f18589h = 15000;
        c2020a.f18582a = 15000;
        String str = aVar.f16614T1;
        c2020a.f18584c = str;
        InetAddress byName = InetAddress.getByName(str);
        Socket createSocket = c2020a.f18587f.createSocket();
        c2020a.f18583b = createSocket;
        createSocket.connect(new InetSocketAddress(byName, aVar.U1), c2020a.f18589h);
        c2020a.g();
        boolean z7 = aVar.f16615V1;
        C1231k c1231k = aVar.W1;
        if (c1231k != null) {
            C2020a c2020a2 = aVar.f17325R1;
            String hostName = c2020a2.e().getHostName();
            if (hostName != null) {
                c2020a2.l(15, hostName);
            }
            aVar.C2(15);
            if (z7) {
                aVar.E2();
            }
            String[] strArr2 = (String[]) aVar.f17325R1.f20236q.toArray(w0.L.f23030Y);
            if (strArr2 != null) {
                for (String str2 : strArr2) {
                    if (str2.startsWith("250-AUTH ") || str2.startsWith("250 AUTH ")) {
                        strArr = str2.substring(9).split("\\s+");
                        break;
                    }
                }
            }
            strArr = C2434l.f23396g;
            C2020a c2020a3 = aVar.f17325R1;
            String str3 = "LOGIN";
            int i9 = C2440r.f(strArr, "LOGIN") ? 2 : 1;
            String str4 = (String) c1231k.f9361Y;
            if (str4 == null) {
                str4 = "";
            }
            String str5 = (String) c1231k.f9362Z;
            String str6 = str5 != null ? str5 : "";
            c2020a3.getClass();
            if (C2279g.a(i9, 1)) {
                str3 = "PLAIN";
            } else if (!C2279g.a(i9, 2)) {
                str3 = C2279g.a(i9, 3) ? "XOAUTH" : C2279g.a(i9, 4) ? "XOAUTH2" : null;
            }
            int l8 = c2020a3.l(14, str3);
            if (l8 >= 300 && l8 < 400) {
                boolean a8 = C2279g.a(i9, 1);
                Charset charset = c2020a3.f18590i;
                if (a8) {
                    b8 = C2049a.b(("\u0000" + str4 + "\u0000" + str6).getBytes(charset));
                } else if (C2279g.a(i9, 2)) {
                    int k8 = c2020a3.k(C2049a.b(str4.getBytes(charset)), null, true);
                    if (k8 >= 300 && k8 < 400) {
                        b8 = C2049a.b(str6.getBytes(charset));
                    }
                } else if (C2279g.a(i9, 3) || C2279g.a(i9, 4)) {
                    b8 = C2049a.b(str4.getBytes(charset));
                }
                c2020a3.k(b8, null, true);
            }
            aVar.C2(14);
        } else {
            C2020a c2020a4 = aVar.f17325R1;
            String hostName2 = c2020a4.e().getHostName();
            if (hostName2 == null) {
                i8 = 0;
            } else {
                i8 = 0;
                c2020a4.l(0, hostName2);
            }
            aVar.C2(i8);
            if (z7) {
                aVar.E2();
            }
        }
        String str7 = aVar.f16613S1;
        if (str7 != null) {
            C2020a c2020a5 = this.f17325R1;
            c2020a5.getClass();
            c2020a5.k(C2022c.f20239a[1], "<" + str7 + ">", false);
            C2(1);
        }
        D2(this.f17014L1);
        D2(this.f17015M1);
        D2(this.f17016N1);
        C2020a c2020a6 = this.f17325R1;
        int l9 = c2020a6.l(3, null);
        C1954b c1954b = !(l9 >= 300 && l9 < 400) ? null : new C1954b(c2020a6.f20234o);
        if (c1954b != null) {
            try {
                B2(c1954b, false);
                c1954b.close();
                this.f17325R1.i();
            } catch (Throwable th) {
                c1954b.close();
                throw th;
            }
        }
        C2(3);
        q2(null, false);
    }

    @Override // com.llamalab.automate.stmt.P0
    public final String y2() {
        return this.f17325R1.e().getHostName();
    }
}
