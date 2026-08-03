package com.llamalab.automate.stmt;

import L3.C1053s;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.expr.func.Coalesce;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import x3.C2429g;
import x3.C2434l;

@F3.f("wake_on_lan_send.html")
@F3.a(C2541R.integer.ic_device_access_network_ping)
@F3.i(C2541R.string.stmt_wake_on_lan_send_title)
@F3.h(C2541R.string.stmt_wake_on_lan_send_summary)
@F3.e(C2541R.layout.stmt_wake_on_lan_send_edit)
/* loaded from: classes.dex */
public final class WakeOnLanSend extends Action implements AsyncStatement {
    public InterfaceC1700x0 account;
    public InterfaceC1700x0 host;
    public InterfaceC1700x0 macAddress;
    public InterfaceC1700x0 networkInterface;
    public InterfaceC1700x0 port;

    public static class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f17253L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f17254M1;

        /* renamed from: N1, reason: collision with root package name */
        public final byte[] f17255N1;

        public a(String str, int i8, byte[] bArr) {
            this.f17253L1 = str;
            this.f17254M1 = i8;
            this.f17255N1 = bArr;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            String str = this.f17253L1;
            DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
            try {
                y2(datagramSocket);
                boolean isEmpty = TextUtils.isEmpty(str);
                int i8 = 4;
                int i9 = this.f17254M1;
                byte[] bArr = this.f17255N1;
                if (isEmpty) {
                    datagramSocket.setBroadcast(true);
                    DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, InetAddress.getByAddress(new byte[]{-1, -1, -1, -1}), i9);
                    while (true) {
                        i8--;
                        if (i8 < 0) {
                            break;
                        } else {
                            datagramSocket.send(datagramPacket);
                        }
                    }
                } else {
                    for (InetAddress inetAddress : z2(str)) {
                        DatagramPacket datagramPacket2 = new DatagramPacket(bArr, bArr.length, inetAddress, i9);
                        int i10 = 4;
                        while (true) {
                            i10--;
                            if (i10 >= 0) {
                                datagramSocket.send(datagramPacket2);
                            }
                        }
                    }
                }
                q2(null, false);
            } finally {
                datagramSocket.close();
            }
        }

        public void y2(DatagramSocket datagramSocket) {
            datagramSocket.bind(null);
        }

        public InetAddress[] z2(String str) {
            return InetAddress.getAllByName(str);
        }
    }

    public static class b extends a {

        /* renamed from: O1, reason: collision with root package name */
        public ConnectivityManager f17256O1;

        /* renamed from: P1, reason: collision with root package name */
        public v1 f17257P1;

        /* renamed from: Q1, reason: collision with root package name */
        public Network f17258Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final int f17259R1;

        /* renamed from: S1, reason: collision with root package name */
        public final a f17260S1;

        public class a extends ConnectivityManager.NetworkCallback {

            /* renamed from: a, reason: collision with root package name */
            public boolean f17261a;

            public a() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                if (this.f17261a) {
                    return;
                }
                this.f17261a = true;
                try {
                    b bVar = b.this;
                    bVar.getClass();
                    try {
                        bVar.f17256O1.unregisterNetworkCallback(bVar.f17260S1);
                    } catch (Throwable unused) {
                    }
                    if (26 > Build.VERSION.SDK_INT) {
                        b bVar2 = b.this;
                        AutomateService automateService = bVar2.f15400Y;
                        v1 v1Var = bVar2.f17257P1;
                        if (v1Var != null) {
                            automateService.f14581L1.removeCallbacks(v1Var);
                            bVar2.f17257P1 = null;
                        }
                    }
                    b bVar3 = b.this;
                    bVar3.f17258Q1 = network;
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

        public b(String str, int i8, byte[] bArr) {
            super(str, i8, bArr);
            this.f17260S1 = new a();
            this.f17259R1 = 15000;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            this.f17256O1 = (ConnectivityManager) automateService.getSystemService("connectivity");
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            v1 v1Var;
            if (26 > Build.VERSION.SDK_INT && (v1Var = this.f17257P1) != null) {
                automateService.f14581L1.removeCallbacks(v1Var);
                this.f17257P1 = null;
            }
            try {
                this.f17256O1.unregisterNetworkCallback(this.f17260S1);
            } catch (Throwable unused) {
            }
            super.F(automateService);
        }

        @Override // com.llamalab.automate.stmt.WakeOnLanSend.a
        public final void y2(DatagramSocket datagramSocket) {
            this.f17258Q1.bindSocket(datagramSocket);
        }

        @Override // com.llamalab.automate.stmt.WakeOnLanSend.a
        public final InetAddress[] z2(String str) {
            InetAddress[] allByName;
            allByName = this.f17258Q1.getAllByName(str);
            return allByName;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_wake_on_lan_send);
        l8.v(this.host, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (85 <= dVar.f6413Z) {
            dVar.g(this.networkInterface);
        }
        dVar.g(this.host);
        dVar.g(this.port);
        dVar.g(this.macAddress);
        if (68 <= dVar.f6413Z) {
            dVar.g(this.account);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.networkInterface);
        visitor.b(this.host);
        visitor.b(this.port);
        visitor.b(this.macAddress);
        visitor.b(this.account);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (85 <= cVar.f6409x0) {
            this.networkInterface = (InterfaceC1700x0) cVar.readObject();
        }
        if (106 > cVar.f6409x0) {
            InterfaceC1700x0 interfaceC1700x0 = this.networkInterface;
            if (interfaceC1700x0 == null || (interfaceC1700x0 instanceof L3.I)) {
                this.networkInterface = new C1053s(1);
            } else if (!(interfaceC1700x0 instanceof J3.k)) {
                this.networkInterface = new Coalesce(interfaceC1700x0, new C1053s(1));
            }
        }
        this.host = (InterfaceC1700x0) cVar.readObject();
        this.port = (InterfaceC1700x0) cVar.readObject();
        this.macAddress = (InterfaceC1700x0) cVar.readObject();
        if (68 <= cVar.f6409x0) {
            this.account = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int m8;
        ConnectivityManager connectivityManager;
        String str;
        c1708z0.q(C2541R.string.stmt_wake_on_lan_send_title);
        String x7 = J3.h.x(c1708z0, this.host, null);
        String x8 = J3.h.x(c1708z0, this.macAddress, null);
        if (x8 == null) {
            throw new RequiredArgumentNullException("mac");
        }
        byte[] l8 = C2429g.l(x8);
        if (l8 == null) {
            throw new IllegalArgumentException("Invalid MAC address");
        }
        int m9 = J3.h.m(c1708z0, this.port, 9);
        C1231k c8 = J3.h.c(c1708z0, this.account);
        byte[] bArr = C2434l.f23390a;
        if (c8 != null && (str = (String) c8.f9362Z) != null) {
            bArr = str.getBytes(V3.b.f6987a);
        }
        byte[] bArr2 = new byte[bArr.length + 102];
        Arrays.fill(bArr2, 0, 6, (byte) -1);
        for (int i8 = 6; i8 < 102; i8 += 6) {
            System.arraycopy(l8, 0, bArr2, i8, 6);
        }
        System.arraycopy(bArr, 0, bArr2, 102, bArr.length);
        int i9 = Build.VERSION.SDK_INT;
        if (22 > i9 || (m8 = J3.h.m(c1708z0, this.networkInterface, -1)) < 0) {
            a aVar = new a(x7, m9, bArr2);
            c1708z0.w(aVar);
            aVar.w2();
            return false;
        }
        NetworkRequest build = new NetworkRequest.Builder().addTransportType(m8).build();
        b bVar = new b(x7, m9, bArr2);
        c1708z0.w(bVar);
        b.a aVar2 = bVar.f17260S1;
        int i10 = bVar.f17259R1;
        if (26 <= i9) {
            connectivityManager = bVar.f17256O1;
            if (i10 > 0) {
                connectivityManager.requestNetwork(build, aVar2, i10);
                bVar.n2(1);
                return false;
            }
        } else {
            if (i10 > 0) {
                v1 v1Var = new v1(bVar);
                bVar.f17257P1 = v1Var;
                bVar.f15400Y.f14581L1.postDelayed(v1Var, i10);
            }
            connectivityManager = bVar.f17256O1;
        }
        connectivityManager.requestNetwork(build, aVar2);
        bVar.n2(1);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
