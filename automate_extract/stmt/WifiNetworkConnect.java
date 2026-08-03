package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.J1;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.ArrayList;
import java.util.List;
import x3.C2425c;
import x3.C2429g;
import x3.C2440r;

@F3.f("wifi_network_connect.html")
@F3.a(C2541R.integer.ic_device_access_network_wifi_new)
@F3.i(C2541R.string.stmt_wifi_network_connect_title)
@F3.h(C2541R.string.stmt_wifi_network_connect_summary)
@F3.e(C2541R.layout.stmt_wifi_network_connect_edit)
/* loaded from: classes.dex */
public final class WifiNetworkConnect extends IntermittentDecision implements AsyncStatement, ReceiverStatement {
    public InterfaceC1700x0 account;
    public InterfaceC1700x0 addNetwork;
    public InterfaceC1700x0 bssid;
    public InterfaceC1700x0 disableOthers;
    public InterfaceC1700x0 ssid;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17297a;

        static {
            int[] iArr = new int[SupplicantState.values().length];
            f17297a = iArr;
            try {
                iArr[SupplicantState.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17297a[SupplicantState.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class b extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public final String f17298L1;

        /* renamed from: M1, reason: collision with root package name */
        public int f17299M1 = 3;

        /* renamed from: x1, reason: collision with root package name */
        public final boolean f17300x1;

        /* renamed from: y1, reason: collision with root package name */
        public final String f17301y1;

        public b(String str, String str2, boolean z7) {
            this.f17300x1 = z7;
            this.f17301y1 = str;
            this.f17298L1 = str2;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Boolean bool;
            try {
                if (isInitialStickyBroadcast()) {
                    return;
                }
                boolean z7 = this.f17300x1;
                if (z7) {
                    F5.n.f(this, "WifiConnect SUPPLICANT_STATE_CHANGED_ACTION: " + C2440r.b(intent.getExtras()));
                }
                if (1 == intent.getIntExtra("supplicantError", 0)) {
                    if (z7) {
                        F5.n.f(this, "WifiConnect ERROR_AUTHENTICATING");
                    }
                    bool = Boolean.FALSE;
                } else {
                    SupplicantState supplicantState = (SupplicantState) intent.getParcelableExtra("newState");
                    if (supplicantState == null) {
                        return;
                    }
                    int i8 = a.f17297a[supplicantState.ordinal()];
                    if (i8 == 1) {
                        if (z7) {
                            F5.n.f(this, "WifiConnect DISCONNECTED: " + this.f17299M1);
                        }
                        int i9 = this.f17299M1 - 1;
                        this.f17299M1 = i9;
                        if (i9 >= 0) {
                            return;
                        } else {
                            bool = Boolean.FALSE;
                        }
                    } else {
                        if (i8 != 2) {
                            return;
                        }
                        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                        if (z7) {
                            F5.n.f(this, "WifiConnect COMPLETED: " + connectionInfo);
                        }
                        String str = this.f17301y1;
                        String str2 = this.f17298L1;
                        if (str != null || str2 != null) {
                            if (connectionInfo == null) {
                                return;
                            }
                            if (str != null && !C2429g.d(str, connectionInfo)) {
                                return;
                            }
                            if (str2 != null && !C2429g.c(str2, connectionInfo)) {
                                return;
                            }
                        }
                        bool = Boolean.TRUE;
                    }
                }
                c(intent, bool, false);
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public static final class c extends J1 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f17302L1;

        /* renamed from: M1, reason: collision with root package name */
        public final String f17303M1;

        /* renamed from: N1, reason: collision with root package name */
        public final C1231k f17304N1;

        /* renamed from: O1, reason: collision with root package name */
        public final boolean f17305O1;

        /* renamed from: P1, reason: collision with root package name */
        public final boolean f17306P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final boolean f17307Q1;

        public c(String str, String str2, C1231k c1231k, boolean z7, boolean z8, boolean z9) {
            this.f17302L1 = str;
            this.f17303M1 = str2;
            this.f17304N1 = c1231k;
            this.f17305O1 = z7;
            this.f17306P1 = z8;
            this.f17307Q1 = z9;
        }

        /* JADX WARN: Code restructure failed: missing block: B:57:0x00d4, code lost:
        
            if ((r7 == null ? false : x3.C2429g.e(r10, r7)) != false) goto L58;
         */
        /* JADX WARN: Removed duplicated region for block: B:127:0x019a A[Catch: all -> 0x020e, TryCatch #0 {all -> 0x020e, blocks: (B:3:0x0004, B:9:0x0026, B:10:0x002b, B:12:0x0031, B:14:0x0036, B:15:0x003b, B:18:0x0041, B:20:0x0051, B:24:0x005b, B:27:0x0063, B:29:0x0069, B:32:0x0073, B:33:0x0078, B:36:0x0080, B:37:0x0085, B:39:0x008b, B:41:0x0090, B:42:0x0093, B:44:0x0099, B:46:0x00a9, B:48:0x00b2, B:49:0x00b8, B:51:0x00be, B:54:0x00ca, B:58:0x00d0, B:60:0x00d8, B:63:0x00df, B:67:0x00e8, B:74:0x00f1, B:75:0x01aa, B:77:0x01b0, B:79:0x01b5, B:80:0x01ba, B:82:0x01c0, B:84:0x01ca, B:86:0x01cf, B:87:0x01d4, B:90:0x01dc, B:91:0x01e1, B:93:0x01e7, B:95:0x01ec, B:96:0x01ef, B:98:0x01f5, B:100:0x00f5, B:103:0x00fb, B:104:0x0100, B:107:0x0108, B:108:0x011c, B:112:0x0133, B:113:0x0138, B:116:0x0142, B:118:0x014c, B:120:0x0156, B:122:0x0160, B:123:0x016e, B:124:0x018e, B:125:0x0191, B:127:0x019a, B:129:0x019f, B:130:0x01a4, B:132:0x0171, B:133:0x013e, B:135:0x0188, B:137:0x0206, B:138:0x020d), top: B:2:0x0004 }] */
        @Override // com.llamalab.automate.J1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void w2(O3.a aVar) {
            WifiConfiguration wifiConfiguration;
            int i8;
            int b02;
            try {
                AutomateService automateService = this.f15400Y;
                t3.l lVar = new t3.l();
                WifiManager l8 = AbstractStatement.l(automateService);
                if (!l8.isWifiEnabled()) {
                    throw new IllegalStateException("Wi-Fi disabled");
                }
                String str = this.f17303M1;
                String str2 = this.f17302L1;
                boolean z7 = this.f17307Q1;
                if (str2 == null && str == null) {
                    if (z7) {
                        F5.n.f(this, "WifiConnect Reconnecting to any network");
                    }
                    if (aVar.v2(lVar)) {
                        q2(new Object[]{Boolean.valueOf(z7), null, null}, false);
                        return;
                    }
                    lVar.c();
                    if (z7) {
                        F5.n.f(this, "WifiConnect Failed to reassociate");
                    }
                    q2(Boolean.FALSE, false);
                    return;
                }
                WifiInfo connectionInfo = l8.getConnectionInfo();
                if (connectionInfo != null && ((str2 == null || C2429g.d(str2, connectionInfo)) && (str == null || C2429g.c(str, connectionInfo)))) {
                    if (SupplicantState.COMPLETED == connectionInfo.getSupplicantState()) {
                        if (z7) {
                            F5.n.f(this, "WifiConnect Network already connected");
                        }
                        q2(Boolean.TRUE, false);
                        return;
                    }
                    if (z7) {
                        F5.n.f(this, "WifiConnect Reconnecting to network");
                    }
                    if (aVar.x2(lVar)) {
                        q2(new Object[]{Boolean.valueOf(z7), str2, str}, false);
                        return;
                    }
                    lVar.c();
                    if (z7) {
                        F5.n.f(this, "WifiConnect Failed to reconnect");
                    }
                    q2(Boolean.FALSE, false);
                    return;
                }
                ArrayList<WifiConfiguration> J02 = aVar.J0(lVar);
                lVar.c();
                if (J02 != null) {
                    wifiConfiguration = null;
                    i8 = 0;
                    for (WifiConfiguration wifiConfiguration2 : J02) {
                        if (wifiConfiguration == null) {
                            if (str2 != null) {
                                String str3 = wifiConfiguration2.SSID;
                            }
                            if (str == null || C2429g.b(str, wifiConfiguration2)) {
                                wifiConfiguration = wifiConfiguration2;
                            }
                        }
                        int i9 = wifiConfiguration2.priority;
                        if (i8 <= i9) {
                            i8 = Integer.MAX_VALUE;
                            if (i9 < Integer.MAX_VALUE) {
                                i8 = i9 + 1;
                            }
                        }
                    }
                } else {
                    wifiConfiguration = null;
                    i8 = 0;
                }
                if (wifiConfiguration != null) {
                    wifiConfiguration.priority = i8;
                } else {
                    if (!this.f17306P1) {
                        if (z7) {
                            F5.n.f(this, "WifiConnect Failed, not adding network");
                        }
                        q2(Boolean.FALSE, false);
                        return;
                    }
                    if (z7) {
                        F5.n.f(this, "WifiConnect Network priority: " + i8);
                    }
                    wifiConfiguration = new WifiConfiguration();
                    wifiConfiguration.SSID = WifiNetworkConnect.D(str2);
                    wifiConfiguration.BSSID = str;
                    wifiConfiguration.priority = i8;
                    wifiConfiguration.status = 2;
                    C1231k c1231k = this.f17304N1;
                    if (c1231k != null) {
                        if (z7) {
                            F5.n.f(this, "WifiConnect Configure secure network");
                        }
                        String str4 = wifiConfiguration.SSID;
                        ScanResult C7 = WifiNetworkConnect.C(l8, str4 == null ? null : C2429g.n(str4), C2429g.g(wifiConfiguration));
                        if (C7 == null || !C7.capabilities.contains("WEP") || C7.capabilities.contains("WPA")) {
                            wifiConfiguration.preSharedKey = WifiNetworkConnect.D((String) c1231k.f9362Z);
                            wifiConfiguration.allowedKeyManagement.set(2);
                            wifiConfiguration.allowedKeyManagement.set(1);
                            b02 = aVar.b0(wifiConfiguration, lVar);
                            wifiConfiguration.networkId = b02;
                            if (b02 == -1) {
                                lVar.c();
                                if (z7) {
                                    F5.n.f(this, "WifiConnect Failed to add network");
                                }
                                q2(Boolean.FALSE, false);
                                return;
                            }
                        } else {
                            wifiConfiguration.wepKeys[0] = WifiNetworkConnect.D((String) c1231k.f9362Z);
                            wifiConfiguration.wepTxKeyIndex = 0;
                        }
                    } else if (z7) {
                        F5.n.f(this, "WifiConnect Configure open network");
                    }
                    wifiConfiguration.allowedKeyManagement.set(0);
                    b02 = aVar.b0(wifiConfiguration, lVar);
                    wifiConfiguration.networkId = b02;
                    if (b02 == -1) {
                    }
                }
                if (!aVar.t0(lVar)) {
                    lVar.c();
                    if (z7) {
                        F5.n.f(this, "WifiConnect Failed to disconnect");
                    }
                    q2(Boolean.FALSE, false);
                    return;
                }
                if (!aVar.Q1(wifiConfiguration.networkId, lVar, this.f17305O1)) {
                    lVar.c();
                    if (z7) {
                        F5.n.f(this, "WifiConnect Failed to enable network");
                    }
                    q2(Boolean.FALSE, false);
                    return;
                }
                if (z7) {
                    F5.n.f(this, "WifiConnect Network enabled");
                }
                if (aVar.x2(lVar)) {
                    q2(new Object[]{Boolean.valueOf(z7), str2, str}, false);
                    return;
                }
                lVar.c();
                if (z7) {
                    F5.n.f(this, "WifiConnect Failed to reconnect");
                }
                q2(Boolean.FALSE, false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static ScanResult C(WifiManager wifiManager, String str, String str2) {
        List<ScanResult> scanResults;
        if ((str == null && str2 == null) || (scanResults = wifiManager.getScanResults()) == null) {
            return null;
        }
        for (ScanResult scanResult : scanResults) {
            boolean z7 = false;
            if (str != null) {
                String str3 = scanResult.SSID;
                if (!((str3 == null || str3.isEmpty()) ? false : str3.equals(str))) {
                    continue;
                }
            }
            if (str2 != null) {
                String str4 = scanResult.BSSID;
                if (str4 != null && !str4.isEmpty()) {
                    z7 = str4.equalsIgnoreCase(str2);
                }
                if (z7) {
                }
            }
            return scanResult;
        }
        return null;
    }

    public static String D(String str) {
        if (str == null) {
            return null;
        }
        return "\"" + ((Object) str) + "\"";
    }

    public final boolean B(C1708z0 c1708z0, boolean z7, String str, String str2) {
        if (J1(1) == 0) {
            o(c1708z0, true);
            return true;
        }
        b bVar = new b(str, str2, z7);
        c1708z0.w(bVar);
        bVar.h("android.net.wifi.supplicant.STATE_CHANGE");
        return false;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.CHANGE_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION"), com.llamalab.automate.access.c.f15550k} : 23 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.CHANGE_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_COARSE_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.CHANGE_WIFI_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_wifi_network_connect_immediate, C2541R.string.caption_wifi_network_connect_connected);
        c1596k0.v(this.ssid, 0);
        c1596k0.v(this.bssid, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.ssid);
        dVar.g(this.bssid);
        dVar.g(this.account);
        dVar.g(this.disableOthers);
        dVar.g(this.addNetwork);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.ssid);
        visitor.b(this.bssid);
        visitor.b(this.account);
        visitor.b(this.disableOthers);
        visitor.b(this.addNetwork);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1663p0();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.ssid = (InterfaceC1700x0) cVar.readObject();
        this.bssid = (InterfaceC1700x0) cVar.readObject();
        this.account = (InterfaceC1700x0) cVar.readObject();
        this.disableOthers = (InterfaceC1700x0) cVar.readObject();
        this.addNetwork = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ae, code lost:
    
        if (r10 != false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01be, code lost:
    
        r2 = "WifiConnect Failed to reconnect";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d8, code lost:
    
        if ((r3 == null ? false : x3.C2429g.e(r5, r3)) != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01bc, code lost:
    
        if (r10 != false) goto L111;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x018f  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        WifiConfiguration wifiConfiguration;
        int i8;
        int addNetwork;
        String str;
        c1708z0.q(C2541R.string.stmt_wifi_network_connect_title);
        String x7 = J3.h.x(c1708z0, this.ssid, null);
        String x8 = J3.h.x(c1708z0, this.bssid, null);
        C1231k c8 = J3.h.c(c1708z0, this.account);
        boolean f8 = J3.h.f(c1708z0, this.disableOthers, false);
        boolean f9 = J3.h.f(c1708z0, this.addNetwork, false);
        if (f9 && x7 == null) {
            throw new RequiredArgumentNullException("SSID required to configure new network");
        }
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        if (29 <= Build.VERSION.SDK_INT) {
            c1708z0.w(new c(x7, x8, c8, f8, f9, a8));
            return false;
        }
        WifiManager l8 = AbstractStatement.l(c1708z0);
        if (!l8.isWifiEnabled()) {
            throw new IllegalStateException("Wi-Fi disabled");
        }
        if (x7 == null && x8 == null) {
            if (a8) {
                c1708z0.p("WifiConnect Reconnecting to any network");
            }
            if (l8.reassociate()) {
                return B(c1708z0, a8, null, null);
            }
            if (a8) {
                str = "WifiConnect Failed to reassociate";
                c1708z0.p(str);
            }
            o(c1708z0, false);
            return true;
        }
        WifiInfo connectionInfo = l8.getConnectionInfo();
        if (connectionInfo != null && ((x7 == null || C2429g.d(x7, connectionInfo)) && (x8 == null || C2429g.c(x8, connectionInfo)))) {
            if (SupplicantState.COMPLETED == connectionInfo.getSupplicantState()) {
                if (a8) {
                    c1708z0.p("WifiConnect Network already connected");
                }
                o(c1708z0, true);
                return true;
            }
            if (a8) {
                c1708z0.p("WifiConnect Reconnecting to network");
            }
            if (!l8.reconnect()) {
            }
            return B(c1708z0, a8, x7, x8);
        }
        List<WifiConfiguration> configuredNetworks = l8.getConfiguredNetworks();
        if (configuredNetworks != null) {
            wifiConfiguration = null;
            i8 = 0;
            for (WifiConfiguration wifiConfiguration2 : configuredNetworks) {
                if (wifiConfiguration == null) {
                    if (x7 != null) {
                        String str2 = wifiConfiguration2.SSID;
                    }
                    if (x8 == null || C2429g.b(x8, wifiConfiguration2)) {
                        wifiConfiguration = wifiConfiguration2;
                    }
                }
                int i9 = wifiConfiguration2.priority;
                if (i8 <= i9) {
                    i8 = Integer.MAX_VALUE;
                    if (i9 < Integer.MAX_VALUE) {
                        i8 = i9 + 1;
                    }
                }
            }
        } else {
            wifiConfiguration = null;
            i8 = 0;
        }
        if (wifiConfiguration != null) {
            wifiConfiguration.priority = i8;
        } else {
            if (!f9) {
                if (a8) {
                    str = "WifiConnect Failed, not adding network";
                }
                o(c1708z0, false);
                return true;
            }
            if (a8) {
                c1708z0.p("WifiConnect Network priority: " + i8);
            }
            wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.SSID = D(x7);
            wifiConfiguration.BSSID = x8;
            wifiConfiguration.priority = i8;
            wifiConfiguration.status = 2;
            if (c8 != null) {
                if (a8) {
                    c1708z0.p("WifiConnect Configure secure network");
                }
                String str3 = wifiConfiguration.SSID;
                ScanResult C7 = C(l8, str3 == null ? null : C2429g.n(str3), C2429g.g(wifiConfiguration));
                if (C7 == null || !C7.capabilities.contains("WEP") || C7.capabilities.contains("WPA")) {
                    wifiConfiguration.preSharedKey = D((String) c8.f9362Z);
                    wifiConfiguration.allowedKeyManagement.set(2);
                    wifiConfiguration.allowedKeyManagement.set(1);
                    addNetwork = l8.addNetwork(wifiConfiguration);
                    wifiConfiguration.networkId = addNetwork;
                    if (addNetwork == -1) {
                        if (a8) {
                            str = "WifiConnect Failed to add network";
                        }
                        o(c1708z0, false);
                        return true;
                    }
                } else {
                    wifiConfiguration.wepKeys[0] = D((String) c8.f9362Z);
                    wifiConfiguration.wepTxKeyIndex = 0;
                }
            } else if (a8) {
                c1708z0.p("WifiConnect Configure open network");
            }
            wifiConfiguration.allowedKeyManagement.set(0);
            addNetwork = l8.addNetwork(wifiConfiguration);
            wifiConfiguration.networkId = addNetwork;
            if (addNetwork == -1) {
            }
        }
        if (!l8.disconnect()) {
            if (a8) {
                str = "WifiConnect Failed to disconnect";
            }
            o(c1708z0, false);
            return true;
        }
        if (l8.enableNetwork(wifiConfiguration.networkId, f8)) {
            if (a8) {
                c1708z0.p("WifiConnect Network enabled");
            }
            if (!l8.reconnect()) {
            }
            return B(c1708z0, a8, x7, x8);
        }
        if (a8) {
            str = "WifiConnect Failed to enable network";
        }
        o(c1708z0, false);
        return true;
        c1708z0.p(str);
        o(c1708z0, false);
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        if (obj instanceof Boolean) {
            o(c1708z0, ((Boolean) obj).booleanValue());
            return true;
        }
        Object[] objArr = (Object[]) obj;
        return B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (String) objArr[1], (String) objArr[2]);
    }
}
