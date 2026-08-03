package com.llamalab.automate.stmt;

import B.C0276c;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.net.InetAddress;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import p3.C2213b;
import x3.C2440r;

@F3.f("nsd_discover.html")
@F3.a(C2541R.integer.ic_device_access_network_wifi_scan)
@F3.i(C2541R.string.stmt_nsd_discover_title)
@F3.h(C2541R.string.stmt_nsd_discover_summary)
@F3.e(C2541R.layout.stmt_nsd_discover_edit)
/* loaded from: classes.dex */
public final class NsdDiscover extends Action implements AsyncStatement {
    public InterfaceC1700x0 duration;
    public InterfaceC1700x0 protocolType;
    public InterfaceC1700x0 resultLimit;
    public InterfaceC1700x0 serviceName;
    public InterfaceC1700x0 serviceType;
    public J3.l varFoundServiceNames;
    public J3.l varResolvedAttributes;
    public J3.l varResolvedHosts;
    public J3.l varResolvedPorts;

    public class a implements Comparator<NsdServiceInfo> {

        /* renamed from: X, reason: collision with root package name */
        public final Collator f16990X = Collator.getInstance();

        @Override // java.util.Comparator
        public final int compare(NsdServiceInfo nsdServiceInfo, NsdServiceInfo nsdServiceInfo2) {
            String serviceName;
            String serviceName2;
            NsdServiceInfo l8 = C0276c.l(nsdServiceInfo);
            NsdServiceInfo l9 = C0276c.l(nsdServiceInfo2);
            serviceName = l8.getServiceName();
            serviceName2 = l9.getServiceName();
            return this.f16990X.compare(serviceName, serviceName2);
        }
    }

    public static final class b extends com.llamalab.automate.W implements NsdManager.DiscoveryListener, Runnable {

        /* renamed from: M1, reason: collision with root package name */
        public final String f16992M1;

        /* renamed from: N1, reason: collision with root package name */
        public final String f16993N1;

        /* renamed from: O1, reason: collision with root package name */
        public final int f16994O1;

        /* renamed from: P1, reason: collision with root package name */
        public final int f16995P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final int f16996Q1;

        /* renamed from: R1, reason: collision with root package name */
        public NsdManager f16997R1;

        /* renamed from: y1, reason: collision with root package name */
        public final ArrayList f16998y1 = new ArrayList();

        /* renamed from: L1, reason: collision with root package name */
        public final AtomicBoolean f16991L1 = new AtomicBoolean();

        public final class a implements NsdManager.ResolveListener {
            public a() {
            }

            @Override // android.net.nsd.NsdManager.ResolveListener
            public final /* synthetic */ void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i8) {
            }

            @Override // android.net.nsd.NsdManager.ResolveListener
            public final void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
                b bVar = b.this;
                if (bVar.f16995P1 - 1 != bVar.f16998y1.size()) {
                    if (b.this.f16991L1.get()) {
                        return;
                    }
                    b.this.f16998y1.add(nsdServiceInfo);
                } else if (b.this.f16991L1.compareAndSet(false, true)) {
                    b.this.f16998y1.add(nsdServiceInfo);
                    b bVar2 = b.this;
                    bVar2.q2(bVar2.f16998y1, false);
                }
            }
        }

        public b(int i8, int i9, int i10, String str, String str2) {
            this.f16992M1 = str;
            this.f16993N1 = str2;
            this.f16994O1 = i8;
            this.f16995P1 = i9;
            this.f16996Q1 = i10;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            NsdManager e8 = D.a.e(automateService.getSystemService("servicediscovery"));
            this.f16997R1 = e8;
            e8.discoverServices(this.f16993N1, this.f16994O1, this);
            int i8 = this.f16996Q1;
            if (i8 > 0) {
                automateService.f14581L1.postDelayed(this, i8);
            }
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            this.f16991L1.set(true);
            if (this.f16996Q1 > 0) {
                automateService.f14581L1.removeCallbacks(this);
            }
            try {
                this.f16997R1.stopServiceDiscovery(this);
            } catch (Throwable unused) {
            }
            u2();
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final /* synthetic */ void onDiscoveryStarted(String str) {
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final /* synthetic */ void onDiscoveryStopped(String str) {
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onServiceFound(NsdServiceInfo nsdServiceInfo) {
            String serviceName;
            if (this.f16991L1.get()) {
                return;
            }
            try {
                String str = this.f16992M1;
                if (str != null) {
                    serviceName = nsdServiceInfo.getServiceName();
                    if (!C2440r.v(str, serviceName)) {
                        return;
                    }
                }
                this.f16997R1.resolveService(nsdServiceInfo, new a());
            } catch (Throwable th) {
                if (this.f16991L1.compareAndSet(false, true)) {
                    r2(th);
                }
            }
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final /* synthetic */ void onServiceLost(NsdServiceInfo nsdServiceInfo) {
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final void onStartDiscoveryFailed(String str, int i8) {
            try {
                if (i8 == 0) {
                    throw new IllegalStateException("Internal error");
                }
                if (i8 == 1) {
                    throw new IllegalStateException("NSD disabled");
                }
                if (i8 != 2) {
                    if (i8 == 3) {
                        throw new IllegalStateException("Already active");
                    }
                    if (i8 == 4) {
                        throw new IllegalStateException("Max limit");
                    }
                    throw new IllegalStateException("Unknown error: " + i8);
                }
            } catch (Throwable th) {
                if (this.f16991L1.compareAndSet(false, true)) {
                    r2(th);
                }
            }
        }

        @Override // android.net.nsd.NsdManager.DiscoveryListener
        public final /* synthetic */ void onStopDiscoveryFailed(String str, int i8) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f16991L1.compareAndSet(false, true)) {
                q2(this.f16998y1, false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")} : 23 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_COARSE_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_nsd_discover_title);
        l8.v(this.serviceName, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.serviceName);
        dVar.g(this.serviceType);
        dVar.g(this.protocolType);
        if (94 <= dVar.f6413Z) {
            dVar.g(this.resultLimit);
            dVar.g(this.duration);
        }
        dVar.g(this.varFoundServiceNames);
        dVar.g(this.varResolvedHosts);
        dVar.g(this.varResolvedPorts);
        dVar.g(this.varResolvedAttributes);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.serviceName);
        visitor.b(this.serviceType);
        visitor.b(this.protocolType);
        visitor.b(this.resultLimit);
        visitor.b(this.duration);
        visitor.b(this.varFoundServiceNames);
        visitor.b(this.varResolvedHosts);
        visitor.b(this.varResolvedPorts);
        visitor.b(this.varResolvedAttributes);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.serviceName = (InterfaceC1700x0) cVar.readObject();
        this.serviceType = (InterfaceC1700x0) cVar.readObject();
        this.protocolType = (InterfaceC1700x0) cVar.readObject();
        if (94 <= cVar.f6409x0) {
            this.resultLimit = (InterfaceC1700x0) cVar.readObject();
            this.duration = (InterfaceC1700x0) cVar.readObject();
        }
        this.varFoundServiceNames = (J3.l) cVar.readObject();
        this.varResolvedHosts = (J3.l) cVar.readObject();
        this.varResolvedPorts = (J3.l) cVar.readObject();
        this.varResolvedAttributes = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_nsd_discover_title);
        IncapableAndroidVersionException.a(16);
        String x7 = J3.h.x(c1708z0, this.serviceName, null);
        String x8 = J3.h.x(c1708z0, this.serviceType, null);
        int m8 = J3.h.m(c1708z0, this.protocolType, 1);
        int m9 = J3.h.m(c1708z0, this.resultLimit, Integer.MAX_VALUE);
        long t8 = J3.h.t(c1708z0, this.duration, 3000L);
        if (m9 <= 0) {
            throw new IllegalArgumentException("result limit");
        }
        c1708z0.w(new b(m8, m9, (int) y4.j.e(t8, 0L, 2147483647L), x7, x8));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Map attributes;
        J3.e eVar;
        J3.a aVar;
        int port;
        J3.a aVar2;
        InetAddress host;
        J3.a aVar3;
        String serviceName;
        List list = (List) obj;
        int size = list.size();
        if (size != 0) {
            Collections.sort(list, new a());
        }
        J3.a aVar4 = null;
        if (this.varFoundServiceNames != null) {
            if (size != 0) {
                aVar3 = new J3.a(size);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    serviceName = C0276c.l(it.next()).getServiceName();
                    aVar3.add(serviceName);
                }
            } else {
                aVar3 = null;
            }
            c1708z0.z(this.varFoundServiceNames.f4659Y, aVar3);
        }
        if (this.varResolvedHosts != null) {
            if (size != 0) {
                aVar2 = new J3.a(size);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    host = C0276c.l(it2.next()).getHost();
                    aVar2.add(host.getHostAddress());
                }
            } else {
                aVar2 = null;
            }
            c1708z0.z(this.varResolvedHosts.f4659Y, aVar2);
        }
        if (this.varResolvedPorts != null) {
            if (size != 0) {
                aVar = new J3.a(size);
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    port = C0276c.l(it3.next()).getPort();
                    aVar.add(Double.valueOf(port));
                }
            } else {
                aVar = null;
            }
            c1708z0.z(this.varResolvedPorts.f4659Y, aVar);
        }
        if (this.varResolvedAttributes != null) {
            if (21 <= Build.VERSION.SDK_INT && size != 0) {
                J3.a aVar5 = new J3.a(size);
                Iterator it4 = list.iterator();
                while (it4.hasNext()) {
                    attributes = C0276c.l(it4.next()).getAttributes();
                    if (attributes.isEmpty()) {
                        eVar = null;
                    } else {
                        eVar = new J3.e(attributes.size());
                        for (Map.Entry entry : attributes.entrySet()) {
                            byte[] bArr = (byte[]) entry.getValue();
                            eVar.m0((String) entry.getKey(), (bArr == null || bArr.length == 0) ? null : new String(bArr, C2213b.f21561c), null);
                        }
                    }
                    aVar5.add(eVar);
                }
                aVar4 = aVar5;
            }
            c1708z0.z(this.varResolvedAttributes.f4659Y, aVar4);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
