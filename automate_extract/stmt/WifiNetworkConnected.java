package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import x3.C2421B;
import x3.C2425c;
import x3.C2429g;
import x3.C2440r;

@F3.f("wifi_network_connected.html")
@F3.a(C2541R.integer.ic_device_access_network_wifi_connected)
@F3.i(C2541R.string.stmt_wifi_network_connected_title)
@F3.h(C2541R.string.stmt_wifi_network_connected_summary)
@F3.e(C2541R.layout.stmt_wifi_network_connected_edit)
/* loaded from: classes.dex */
public final class WifiNetworkConnected extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 bssid;
    public InterfaceC1700x0 ssid;
    public J3.l varConnectedBssid;
    public J3.l varConnectedCapabilities;
    public J3.l varConnectedFrequency;
    public J3.l varConnectedIpAddress;
    public J3.l varConnectedLinkSpeed;
    public J3.l varConnectedSsid;

    public static final class a extends AbstractC1618p2.b.C0164b {

        /* renamed from: M1, reason: collision with root package name */
        public final WifiManager f17308M1;

        /* renamed from: N1, reason: collision with root package name */
        public String f17309N1;

        /* renamed from: O1, reason: collision with root package name */
        public String f17310O1;

        /* renamed from: P1, reason: collision with root package name */
        public String f17311P1;

        /* renamed from: Q1, reason: collision with root package name */
        public String f17312Q1;

        /* renamed from: R1, reason: collision with root package name */
        public boolean f17313R1;

        /* renamed from: S1, reason: collision with root package name */
        public boolean f17314S1;

        public a(WifiManager wifiManager) {
            super(512, 1000L);
            this.f17308M1 = wifiManager;
        }

        @Override // com.llamalab.automate.AbstractC1618p2
        public final void e(AutomateService automateService, Intent intent) {
            try {
                if (this.f17314S1) {
                    F5.n.f(this, "WifiConnected NETWORK_STATE_CHANGED_ACTION: " + C2440r.b(intent.getExtras()));
                }
                WifiInfo wifiInfo = (WifiInfo) intent.getParcelableExtra("wifiInfo");
                Double d8 = null;
                if (!p(wifiInfo, (NetworkInfo) intent.getParcelableExtra("networkInfo"))) {
                    if (this.f17313R1) {
                        this.f17313R1 = false;
                        c(intent, new Object[]{Boolean.FALSE, null, null, null, null, null, null}, false);
                        return;
                    }
                    return;
                }
                if (this.f17313R1) {
                    return;
                }
                this.f17313R1 = true;
                Object[] objArr = new Object[7];
                objArr[0] = Boolean.TRUE;
                objArr[1] = this.f17311P1;
                objArr[2] = this.f17312Q1;
                objArr[3] = Double.valueOf(C2421B.c(wifiInfo, this.f17308M1));
                int linkSpeed = wifiInfo.getLinkSpeed();
                if (linkSpeed >= 0) {
                    double d9 = linkSpeed;
                    Double.isNaN(d9);
                    Double.isNaN(d9);
                    Double.isNaN(d9);
                    d8 = Double.valueOf(d9 * 1000000.0d);
                }
                objArr[4] = d8;
                objArr[5] = WifiNetworkConnected.C(wifiInfo);
                objArr[6] = WifiNetworkConnected.D(wifiInfo);
                c(intent, objArr, false);
            } catch (Throwable th) {
                d(th);
            }
        }

        public final boolean o() {
            String str;
            String str2 = this.f17309N1;
            return (str2 == null || str2.equals(this.f17311P1)) && ((str = this.f17310O1) == null || str.equalsIgnoreCase(this.f17312Q1));
        }

        @Override // com.llamalab.automate.AbstractC1618p2.b, com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            try {
                if (isInitialStickyBroadcast()) {
                    return;
                }
                if (28 <= Build.VERSION.SDK_INT) {
                    intent.putExtra("wifiInfo", this.f17308M1.getConnectionInfo());
                }
                super.onReceive(context, intent);
            } catch (Throwable th) {
                d(th);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        
            if (r4.getType() == 1) goto L11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean p(WifiInfo wifiInfo, NetworkInfo networkInfo) {
            boolean z7 = (wifiInfo == null || networkInfo == null || !networkInfo.isConnected()) ? false : true;
            String str = null;
            if (!z7) {
                this.f17312Q1 = null;
                this.f17311P1 = null;
                return false;
            }
            String ssid = wifiInfo.getSSID();
            if (ssid != null && !"<unknown ssid>".equals(ssid)) {
                str = C2429g.n(ssid);
            }
            this.f17311P1 = str;
            this.f17312Q1 = wifiInfo.getBSSID();
            return o();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r4 = r4.getFrequency();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Double C(WifiInfo wifiInfo) {
        int frequency;
        if (21 > Build.VERSION.SDK_INT || frequency < 0) {
            return null;
        }
        double d8 = frequency;
        Double.isNaN(d8);
        Double.isNaN(d8);
        return Double.valueOf(d8 * 1000000.0d);
    }

    public static String D(WifiInfo wifiInfo) {
        int ipAddress = wifiInfo.getIpAddress();
        if (ipAddress == 0) {
            return null;
        }
        return (ipAddress & 255) + "." + ((ipAddress >>> 8) & 255) + "." + ((ipAddress >>> 16) & 255) + "." + ((ipAddress >>> 24) & 255);
    }

    public final void B(C1708z0 c1708z0, boolean z7, String str, String str2, Double d8, Double d9, Double d10, String str3) {
        J3.l lVar = this.varConnectedSsid;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varConnectedBssid;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str2);
        }
        J3.l lVar3 = this.varConnectedCapabilities;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d8);
        }
        J3.l lVar4 = this.varConnectedLinkSpeed;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, d9);
        }
        J3.l lVar5 = this.varConnectedFrequency;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, d10);
        }
        J3.l lVar6 = this.varConnectedIpAddress;
        if (lVar6 != null) {
            c1708z0.z(lVar6.f4659Y, str3);
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")} : 28 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_COARSE_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_wifi_network_connected_immediate, C2541R.string.caption_wifi_network_connected_change);
        c1596k0.v(this.ssid, 0);
        c1596k0.v(this.bssid, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (String) objArr[1], (String) objArr[2], (Double) objArr[3], (Double) objArr[4], (Double) objArr[5], (String) objArr[6]);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (2 <= dVar.f6413Z) {
            dVar.g(this.ssid);
            dVar.g(this.bssid);
        }
        dVar.g(this.varConnectedSsid);
        dVar.g(this.varConnectedBssid);
        if (73 <= dVar.f6413Z) {
            dVar.g(this.varConnectedCapabilities);
            dVar.g(this.varConnectedLinkSpeed);
        }
        if (79 <= dVar.f6413Z) {
            dVar.g(this.varConnectedFrequency);
        }
        if (95 <= dVar.f6413Z) {
            dVar.g(this.varConnectedIpAddress);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.ssid);
        visitor.b(this.bssid);
        visitor.b(this.varConnectedSsid);
        visitor.b(this.varConnectedBssid);
        visitor.b(this.varConnectedCapabilities);
        visitor.b(this.varConnectedLinkSpeed);
        visitor.b(this.varConnectedFrequency);
        visitor.b(this.varConnectedIpAddress);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1663p0();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (2 <= cVar.f6409x0) {
            this.ssid = (InterfaceC1700x0) cVar.readObject();
            this.bssid = (InterfaceC1700x0) cVar.readObject();
        }
        this.varConnectedSsid = (J3.l) cVar.readObject();
        this.varConnectedBssid = (J3.l) cVar.readObject();
        if (73 <= cVar.f6409x0) {
            this.varConnectedCapabilities = (J3.l) cVar.readObject();
            this.varConnectedLinkSpeed = (J3.l) cVar.readObject();
        }
        if (79 <= cVar.f6409x0) {
            this.varConnectedFrequency = (J3.l) cVar.readObject();
        }
        if (95 <= cVar.f6409x0) {
            this.varConnectedIpAddress = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        NetworkInfo networkInfo;
        String str;
        String str2;
        Double d8;
        Double d9;
        Double d10;
        String str3;
        boolean z7;
        c1708z0.q(C2541R.string.stmt_wifi_network_connected_title);
        WifiInfo wifiInfo = null;
        Double d11 = null;
        String x7 = J3.h.x(c1708z0, this.ssid, null);
        String x8 = J3.h.x(c1708z0, this.bssid, null);
        boolean z8 = J1(1) == 0;
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        if (a8) {
            c1708z0.p("WifiConnected ssid=" + x7 + ", bssid=" + x8 + ", immediate=" + z8);
        }
        WifiManager l8 = AbstractStatement.l(c1708z0);
        if (!z8) {
            a aVar = (a) c1708z0.d(a.class, this);
            if (aVar != null) {
                aVar.f17314S1 = a8;
                aVar.f17309N1 = x7;
                aVar.f17310O1 = x8;
                boolean o6 = aVar.f17313R1 & aVar.o();
                aVar.f17313R1 = o6;
                if (a8) {
                    c1708z0.p(o6 ? "WifiConnected Still connected" : "WifiConnected Still disconnected");
                }
                aVar.i0();
            } else {
                a aVar2 = new a(l8);
                aVar2.f17314S1 = a8;
                aVar2.f17309N1 = x7;
                aVar2.f17310O1 = x8;
                IntentFilter intentFilter = new IntentFilter("android.net.wifi.STATE_CHANGE");
                Intent registerReceiver = c1708z0.registerReceiver(null, intentFilter);
                if (registerReceiver != null) {
                    wifiInfo = 28 <= Build.VERSION.SDK_INT ? l8.getConnectionInfo() : (WifiInfo) registerReceiver.getParcelableExtra("wifiInfo");
                    networkInfo = (NetworkInfo) registerReceiver.getParcelableExtra("networkInfo");
                } else {
                    networkInfo = null;
                }
                boolean p8 = aVar2.p(wifiInfo, networkInfo);
                aVar2.f17313R1 = p8;
                if (a8) {
                    c1708z0.p(p8 ? "WifiConnected Initially connected" : "WifiConnected Initially disconnected");
                }
                c1708z0.w(aVar2);
                aVar2.f(intentFilter);
            }
            return false;
        }
        Intent registerReceiver2 = c1708z0.registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        if (registerReceiver2 != null) {
            WifiInfo connectionInfo = 28 <= Build.VERSION.SDK_INT ? l8.getConnectionInfo() : (WifiInfo) registerReceiver2.getParcelableExtra("wifiInfo");
            NetworkInfo networkInfo2 = (NetworkInfo) registerReceiver2.getParcelableExtra("networkInfo");
            if (a8) {
                c1708z0.p("WifiConnected " + connectionInfo + ", " + networkInfo2);
            }
            if ((connectionInfo != null && networkInfo2 != null && networkInfo2.isConnected() && networkInfo2.getType() == 1) && ((x7 == null || C2429g.d(x7, connectionInfo)) && (x8 == null || C2429g.c(x8, connectionInfo)))) {
                String ssid = connectionInfo.getSSID();
                String n8 = (ssid == null || "<unknown ssid>".equals(ssid)) ? null : C2429g.n(ssid);
                String bssid = connectionInfo.getBSSID();
                Double valueOf = Double.valueOf(C2421B.c(connectionInfo, l8));
                int linkSpeed = connectionInfo.getLinkSpeed();
                if (linkSpeed >= 0) {
                    double d12 = linkSpeed;
                    Double.isNaN(d12);
                    Double.isNaN(d12);
                    Double.isNaN(d12);
                    d11 = Double.valueOf(d12 * 1000000.0d);
                }
                d10 = C(connectionInfo);
                str3 = D(connectionInfo);
                d9 = d11;
                d8 = valueOf;
                z7 = true;
                str2 = bssid;
                str = n8;
                B(c1708z0, z7, str, str2, d8, d9, d10, str3);
                return true;
            }
        }
        str = null;
        str2 = null;
        d8 = null;
        d9 = null;
        d10 = null;
        str3 = null;
        z7 = false;
        B(c1708z0, z7, str, str2, d8, d9, d10, str3);
        return true;
    }
}
