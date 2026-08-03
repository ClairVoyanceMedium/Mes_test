package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.AdbAction;
import j3.AbstractC2007c;
import j3.C2015k;
import j3.C2016l;
import java.io.IOException;

@F3.f("adb_protocol_set.html")
@F3.a(C2541R.integer.ic_device_access_network_type)
@F3.i(C2541R.string.stmt_adb_protocol_set_title)
@F3.h(C2541R.string.stmt_adb_protocol_set_summary)
@F3.e(C2541R.layout.stmt_adb_protocol_set_edit)
/* loaded from: classes.dex */
public final class AdbProtocolSet extends AdbAction {
    public InterfaceC1700x0 protocol;
    public InterfaceC1700x0 tcpipPort;

    public static final class a extends AdbAction.a {

        /* renamed from: P1, reason: collision with root package name */
        public final String f16233P1;

        public a(String str, int i8, boolean z7, String str2, String str3) {
            super(i8, str, str2, z7);
            this.f16233P1 = str3;
        }

        @Override // com.llamalab.automate.stmt.AdbAction.a
        public final void z2(AbstractC2007c abstractC2007c) {
            C2016l h8 = abstractC2007c.h(this.f16233P1);
            try {
                C2015k c2015k = h8.f20192Z;
                try {
                    String trim = new String(com.llamalab.safs.internal.m.f(1024, c2015k), com.llamalab.safs.internal.m.f17838b).trim();
                    if (!trim.isEmpty() && !trim.startsWith("restarting in ")) {
                        throw new IOException(trim);
                    }
                    c2015k.close();
                    h8.close();
                    q2(null, false);
                } catch (Throwable th) {
                    if (c2015k != null) {
                        try {
                            c2015k.close();
                        } catch (Throwable th2) {
                            try {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                            } catch (Exception unused) {
                            }
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                try {
                    h8.close();
                } catch (Throwable th4) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th3, th4);
                    } catch (Exception unused2) {
                    }
                }
                throw th3;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 21 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 e8 = D1.P.l(context, C2541R.string.stmt_adb_protocol_set_title).e(this.protocol, 1, C2541R.xml.adb_protocols);
        e8.v(this.tcpipPort, 0);
        return e8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.AdbAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.protocol);
        dVar.g(this.tcpipPort);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.host);
        visitor.b(this.port);
        visitor.b(this.security);
        visitor.b(this.alias);
        visitor.b(this.protocol);
        visitor.b(this.tcpipPort);
    }

    @Override // com.llamalab.automate.stmt.AdbAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.protocol = (InterfaceC1700x0) cVar.readObject();
        this.tcpipPort = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.AdbAction
    public final void q(C1708z0 c1708z0, String str, int i8, boolean z7, String str2) {
        String str3;
        int m8 = J3.h.m(c1708z0, this.protocol, 1);
        if (m8 == 1) {
            str3 = "usb:";
        } else {
            if (m8 != 2) {
                throw new IllegalArgumentException("protocol");
            }
            int m9 = J3.h.m(c1708z0, this.tcpipPort, 5555);
            if (m9 < 0 || m9 > 65535) {
                throw new IllegalArgumentException("tcpipPort");
            }
            str3 = B4.g.g("tcpip:", m9);
        }
        a aVar = new a(str, i8, z7, str2, str3);
        c1708z0.w(aVar);
        aVar.w2();
    }

    @Override // com.llamalab.automate.stmt.AdbAction, com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_adb_protocol_set_title);
        super.r1(c1708z0);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
