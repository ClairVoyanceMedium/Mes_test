package com.llamalab.automate.stmt;

import L3.C1047l;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.J1;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import x3.C2421B;
import x3.C2429g;
import x3.C2439q;

@F3.f("wifi_network_scan.html")
@F3.a(C2541R.integer.ic_device_access_network_wifi_scan)
@F3.i(C2541R.string.stmt_wifi_network_scan_title)
@F3.h(C2541R.string.stmt_wifi_network_scan_summary)
@F3.e(C2541R.layout.stmt_wifi_network_scan_edit)
/* loaded from: classes.dex */
public final class WifiNetworkScan extends IntermittentAction implements ReceiverStatement, AsyncStatement {
    public InterfaceC1700x0 configuredOnly;
    public InterfaceC1700x0 passive;
    public InterfaceC1700x0 security;
    public J3.l varNetworkBssids;
    public J3.l varNetworkCapabilities;
    public J3.l varNetworkRssis;
    public J3.l varNetworkSsids;

    public static final class a extends J1 {

        /* renamed from: L1, reason: collision with root package name */
        public final List<ScanResult> f17315L1;

        public a(List list) {
            this.f17315L1 = list;
        }

        @Override // com.llamalab.automate.J1
        public final void w2(O3.a aVar) {
            try {
                t3.l lVar = new t3.l();
                ArrayList J02 = aVar.J0(lVar);
                lVar.c();
                q2(new Object[]{this.f17315L1, J02, Boolean.TRUE}, false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static final class b extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final WifiManager f17316x1;

        /* renamed from: y1, reason: collision with root package name */
        public final boolean f17317y1;

        public b(WifiManager wifiManager, boolean z7) {
            this.f17316x1 = wifiManager;
            this.f17317y1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (23 > Build.VERSION.SDK_INT || intent.getBooleanExtra("resultsUpdated", false)) {
                c(intent, new Object[]{this.f17316x1.getScanResults(), null, Boolean.valueOf(this.f17317y1)}, false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        if (29 > i8) {
            return 23 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_COARSE_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE")};
        }
        InterfaceC1700x0 interfaceC1700x0 = this.configuredOnly;
        return (interfaceC1700x0 == null || ((interfaceC1700x0 instanceof J3.k) && !J3.h.J(((J3.k) interfaceC1700x0).value()))) ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION"), com.llamalab.automate.access.c.f15550k};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_wifi_network_scan_immediate, C2541R.string.caption_wifi_network_scan_complete);
        return c1596k0.y(this.passive, C2541R.string.caption_passive, 0).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        if (((Boolean) objArr[2]).booleanValue()) {
            c1708z0.w(new a((List) objArr[0]));
            return false;
        }
        s(c1708z0, (List) objArr[0], (List) objArr[1], ((Boolean) objArr[2]).booleanValue());
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.security);
        if (48 <= dVar.f6413Z) {
            dVar.g(this.configuredOnly);
        }
        if (2 <= dVar.f6413Z) {
            dVar.g(this.passive);
        }
        dVar.g(this.varNetworkSsids);
        dVar.g(this.varNetworkBssids);
        if (73 <= dVar.f6413Z) {
            dVar.g(this.varNetworkCapabilities);
        }
        if (52 <= dVar.f6413Z) {
            dVar.g(this.varNetworkRssis);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.security);
        visitor.b(this.configuredOnly);
        visitor.b(this.passive);
        visitor.b(this.varNetworkSsids);
        visitor.b(this.varNetworkBssids);
        visitor.b(this.varNetworkCapabilities);
        visitor.b(this.varNetworkRssis);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        this.security = interfaceC1700x0;
        if (73 > cVar.f6409x0 && interfaceC1700x0 != null) {
            if (interfaceC1700x0 instanceof J3.k) {
                this.security = J3.h.J(interfaceC1700x0) ? new L3.J(0) : null;
            } else {
                this.security = new C1047l(interfaceC1700x0, new L3.J(0), L3.I.f4933X);
            }
        }
        if (48 <= cVar.f6409x0) {
            this.configuredOnly = (InterfaceC1700x0) cVar.readObject();
        }
        if (2 <= cVar.f6409x0) {
            this.passive = (InterfaceC1700x0) cVar.readObject();
        }
        this.varNetworkSsids = (J3.l) cVar.readObject();
        this.varNetworkBssids = (J3.l) cVar.readObject();
        if (73 <= cVar.f6409x0) {
            this.varNetworkCapabilities = (J3.l) cVar.readObject();
        }
        if (52 <= cVar.f6409x0) {
            this.varNetworkRssis = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_wifi_network_scan_title);
        boolean f8 = J3.h.f(c1708z0, this.configuredOnly, false);
        boolean f9 = J3.h.f(c1708z0, this.passive, false);
        WifiManager l8 = AbstractStatement.l(c1708z0);
        if (J1(1) != 0) {
            b bVar = new b(l8, f8);
            c1708z0.w(bVar);
            bVar.h("android.net.wifi.SCAN_RESULTS");
            if (!f9) {
                l8.startScan();
            }
            return false;
        }
        if (!f8) {
            s(c1708z0, l8.getScanResults(), null, false);
            return true;
        }
        if (29 <= Build.VERSION.SDK_INT) {
            c1708z0.w(new a(l8.getScanResults()));
            return false;
        }
        s(c1708z0, l8.getScanResults(), l8.getConfiguredNetworks(), true);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d2, code lost:
    
        if (r16 == false) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s(C1708z0 c1708z0, List list, List list2, boolean z7) {
        J3.a aVar;
        J3.a aVar2;
        J3.a aVar3;
        J3.a aVar4;
        boolean z8;
        String str = null;
        Integer o6 = J3.h.o(c1708z0, this.security, null);
        int size = list != null ? list.size() : 0;
        J3.l lVar = this.varNetworkSsids;
        if (lVar != null) {
            aVar = new J3.a(size);
            c1708z0.z(lVar.f4659Y, aVar);
        } else {
            aVar = null;
        }
        J3.l lVar2 = this.varNetworkBssids;
        if (lVar2 != null) {
            aVar2 = new J3.a(size);
            c1708z0.z(lVar2.f4659Y, aVar2);
        } else {
            aVar2 = null;
        }
        J3.l lVar3 = this.varNetworkCapabilities;
        if (lVar3 != null) {
            aVar3 = new J3.a(size);
            c1708z0.z(lVar3.f4659Y, aVar3);
        } else {
            aVar3 = null;
        }
        J3.l lVar4 = this.varNetworkRssis;
        if (lVar4 != null) {
            aVar4 = new J3.a(size);
            c1708z0.z(lVar4.f4659Y, aVar4);
        } else {
            aVar4 = null;
        }
        if (size != 0 && (aVar != null || aVar2 != null || aVar3 != null || aVar4 != null)) {
            Collections.sort(list, new C2439q(2));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ScanResult scanResult = (ScanResult) it.next();
                int a8 = C2421B.a(scanResult);
                if (o6 != null) {
                    if (o6.intValue() != 0) {
                        if ((a8 & 7 & o6.intValue()) == 0) {
                        }
                    } else if ((a8 & 7) != 0) {
                    }
                }
                String str2 = scanResult.SSID;
                if (str2 == null || str2.isEmpty()) {
                    str2 = str;
                }
                String str3 = scanResult.BSSID;
                if (z7) {
                    if (list2 != null) {
                        Iterator it2 = list2.iterator();
                        while (it2.hasNext()) {
                            WifiConfiguration wifiConfiguration = (WifiConfiguration) it2.next();
                            String str4 = wifiConfiguration.SSID;
                            z8 = true;
                            if ((str4 == null ? str2 == null : C2429g.e(str2, str4)) && C2429g.b(str3, wifiConfiguration)) {
                                break;
                            }
                        }
                    }
                    z8 = false;
                }
                if (aVar != null) {
                    aVar.add(str2);
                }
                if (aVar2 != null) {
                    aVar2.add(str3);
                }
                if (aVar3 != null) {
                    aVar3.add(Double.valueOf(a8));
                }
                if (aVar4 != null) {
                    int i8 = scanResult.level;
                    aVar4.add(Double.valueOf(i8 == 0 ? Double.NEGATIVE_INFINITY : i8));
                }
                str = null;
            }
        }
        c1708z0.f17642x0 = this.onComplete;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        s(c1708z0, (List) objArr[0], (List) objArr[1], ((Boolean) objArr[2]).booleanValue());
        return true;
    }
}
