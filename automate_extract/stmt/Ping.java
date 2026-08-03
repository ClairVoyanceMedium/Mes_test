package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import x3.C2446x;

@F3.f("ping.html")
@F3.a(C2541R.integer.ic_device_access_network_ping)
@F3.i(C2541R.string.stmt_ping_title)
@F3.h(C2541R.string.stmt_ping_summary)
@F3.e(C2541R.layout.stmt_ping_edit)
/* loaded from: classes.dex */
public class Ping extends Decision implements AsyncStatement {
    public InterfaceC1700x0 host;
    public InterfaceC1700x0 networkInterface;
    public InterfaceC1700x0 protocol;
    public InterfaceC1700x0 timeout;
    public InterfaceC1700x0 ttl;

    public static class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f17032L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f17033M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f17034N1;

        /* renamed from: O1, reason: collision with root package name */
        public final int f17035O1;

        /* renamed from: P1, reason: collision with root package name */
        public Process f17036P1;

        public a(String str, int i8, int i9, int i10) {
            this.f17033M1 = i8;
            this.f17032L1 = str;
            this.f17034N1 = i9;
            this.f17035O1 = i10;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
        public void F(AutomateService automateService) {
            Process process = this.f17036P1;
            if (process != null) {
                process.destroy();
                this.f17036P1 = null;
            }
            super.F(automateService);
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public void x2() {
            y2(this.f17033M1, this.f17034N1, this.f17035O1, this.f17032L1, null);
        }

        public final void y2(int i8, int i9, int i10, String str, String str2) {
            Boolean bool;
            ArrayList arrayList = new ArrayList();
            arrayList.add(i8 == 6 ? "ping6" : "ping");
            arrayList.add("-c");
            arrayList.add("1");
            if (str2 != null) {
                arrayList.add("-I");
                arrayList.add(str2);
            }
            if (i9 > 0) {
                arrayList.add("-t");
                arrayList.add(Integer.toString(i9));
            }
            if (i10 > 0) {
                arrayList.add("-W");
                arrayList.add(Integer.toString(Math.max(i10 / 1000, 1)));
            }
            arrayList.add(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f17036P1 = new ProcessBuilder(arrayList).start();
            try {
                d4.k kVar = new d4.k(this.f17036P1.getInputStream(), null, "Ping-stdout");
                try {
                    kVar = new d4.k(this.f17036P1.getErrorStream(), byteArrayOutputStream, "Ping-stderr");
                    kVar.f18009x0 = 1000;
                    try {
                        kVar.start();
                        kVar.start();
                        int waitFor = this.f17036P1.waitFor();
                        kVar.close();
                        kVar.close();
                        if (waitFor == 0) {
                            bool = Boolean.TRUE;
                        } else {
                            if (waitFor != 1) {
                                String n8 = C2446x.n(byteArrayOutputStream.toString("UTF-8"));
                                if (n8.isEmpty()) {
                                    n8 = B4.g.g("Unknown error ", waitFor);
                                }
                                throw new IOException(n8);
                            }
                            bool = Boolean.FALSE;
                        }
                        q2(bool, false);
                    } finally {
                        try {
                        } catch (Throwable th) {
                            try {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th);
                            } catch (Exception unused) {
                            }
                        }
                    }
                } finally {
                    try {
                    } catch (Throwable th2) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        } catch (Exception unused2) {
                        }
                    }
                }
            } finally {
                this.f17036P1.destroy();
                this.f17036P1 = null;
            }
        }
    }

    public static class b extends a {

        /* renamed from: Q1, reason: collision with root package name */
        public ConnectivityManager f17037Q1;

        /* renamed from: R1, reason: collision with root package name */
        public RunnableC1678x0 f17038R1;

        /* renamed from: S1, reason: collision with root package name */
        public Network f17039S1;

        /* renamed from: T1, reason: collision with root package name */
        public final a f17040T1;

        public class a extends ConnectivityManager.NetworkCallback {
            public a() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                try {
                    b bVar = b.this;
                    bVar.getClass();
                    try {
                        bVar.f17037Q1.unregisterNetworkCallback(bVar.f17040T1);
                    } catch (Throwable unused) {
                    }
                    if (26 > Build.VERSION.SDK_INT) {
                        b bVar2 = b.this;
                        AutomateService automateService = bVar2.f15400Y;
                        RunnableC1678x0 runnableC1678x0 = bVar2.f17038R1;
                        if (runnableC1678x0 != null) {
                            automateService.f14581L1.removeCallbacks(runnableC1678x0);
                            bVar2.f17038R1 = null;
                        }
                    }
                    b bVar3 = b.this;
                    bVar3.f17039S1 = network;
                    bVar3.v2();
                } catch (Throwable th) {
                    b.this.r2(th);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onUnavailable() {
                b bVar = b.this;
                bVar.getClass();
                bVar.r2(new SocketTimeoutException("Network interface unavailable").fillInStackTrace());
            }
        }

        public b(String str, int i8, int i9, int i10) {
            super(str, i8, i9, i10);
            this.f17040T1 = new a();
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            this.f17037Q1 = (ConnectivityManager) automateService.getSystemService("connectivity");
        }

        @Override // com.llamalab.automate.stmt.Ping.a, com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            RunnableC1678x0 runnableC1678x0;
            if (26 > Build.VERSION.SDK_INT && (runnableC1678x0 = this.f17038R1) != null) {
                automateService.f14581L1.removeCallbacks(runnableC1678x0);
                this.f17038R1 = null;
            }
            try {
                this.f17037Q1.unregisterNetworkCallback(this.f17040T1);
            } catch (Throwable unused) {
            }
            super.F(automateService);
        }

        @Override // com.llamalab.automate.stmt.Ping.a, com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            LinkProperties linkProperties;
            String interfaceName;
            this.f15400Y.f14581L1.removeCallbacks(this.f17038R1);
            linkProperties = this.f17037Q1.getLinkProperties(this.f17039S1);
            if (linkProperties != null) {
                interfaceName = linkProperties.getInterfaceName();
                if (!TextUtils.isEmpty(interfaceName)) {
                    y2(this.f17033M1, this.f17034N1, this.f17035O1, this.f17032L1, interfaceName);
                    return;
                }
            }
            throw new IOException("Network interface not found");
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 21 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_ping_title);
        l8.v(this.host, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.host);
        if (74 <= dVar.f6413Z) {
            dVar.g(this.protocol);
        }
        dVar.g(this.networkInterface);
        dVar.g(this.ttl);
        dVar.g(this.timeout);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.host);
        visitor.b(this.protocol);
        visitor.b(this.networkInterface);
        visitor.b(this.ttl);
        visitor.b(this.timeout);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.host = (InterfaceC1700x0) cVar.readObject();
        if (74 <= cVar.f6409x0) {
            this.protocol = (InterfaceC1700x0) cVar.readObject();
        }
        this.networkInterface = (InterfaceC1700x0) cVar.readObject();
        this.ttl = (InterfaceC1700x0) cVar.readObject();
        this.timeout = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int m8;
        c1708z0.q(C2541R.string.stmt_ping_title);
        String x7 = J3.h.x(c1708z0, this.host, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("host");
        }
        int m9 = J3.h.m(c1708z0, this.protocol, 4);
        if (m9 != 4 && m9 != 6) {
            throw new IllegalArgumentException("protocol");
        }
        int d8 = y4.j.d(J3.h.m(c1708z0, this.ttl, 0), 0, 255);
        int e8 = (int) y4.j.e(J3.h.t(c1708z0, this.timeout, 3000L), 0L, 2147483647L);
        int i8 = Build.VERSION.SDK_INT;
        if (21 > i8 || (m8 = J3.h.m(c1708z0, this.networkInterface, -1)) == -1) {
            a aVar = new a(x7, m9, d8, e8);
            c1708z0.w(aVar);
            aVar.w2();
            return false;
        }
        NetworkRequest build = new NetworkRequest.Builder().addTransportType(m8).build();
        b bVar = new b(x7, m9, d8, e8);
        c1708z0.w(bVar);
        b.a aVar2 = bVar.f17040T1;
        if (26 <= i8) {
            bVar.f17037Q1.requestNetwork(build, aVar2, 15000);
        } else {
            RunnableC1678x0 runnableC1678x0 = new RunnableC1678x0(bVar);
            bVar.f17038R1 = runnableC1678x0;
            bVar.f15400Y.f14581L1.postDelayed(runnableC1678x0, 15000L);
            bVar.f17037Q1.requestNetwork(build, aVar2);
        }
        bVar.n2(1);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
