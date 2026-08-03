package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import k0.RunnableC2034k;
import k0.RunnableC2035l;
import p.C2198d;
import w0.RunnableC2389q;
import x3.C2424b;
import x3.C2425c;
import x3.C2434l;
import x3.C2439q;
import x3.C2440r;

@F3.f("data_network_default.html")
@F3.a(C2541R.integer.ic_device_access_network_type)
@F3.i(C2541R.string.stmt_data_network_default_title)
@F3.h(C2541R.string.stmt_data_network_default_summary)
@F3.e(C2541R.layout.stmt_data_network_default_edit)
/* loaded from: classes.dex */
public final class DataNetworkDefault extends IntermittentDecision implements AsyncStatement, ReceiverStatement {

    /* renamed from: L1, reason: collision with root package name */
    public static final C2439q f16512L1 = new C2439q(1);
    public InterfaceC1700x0 capabilities;
    public InterfaceC1700x0 transports;
    public J3.l varDownloadBandwidth;
    public J3.l varInterfaceName;
    public J3.l varIpAddresses;
    public J3.l varUploadBandwidth;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public final int[] f16513L1;

        /* renamed from: M1, reason: collision with root package name */
        public Network f16514M1;

        /* renamed from: x1, reason: collision with root package name */
        public final ConnectivityManager f16515x1;

        /* renamed from: y1, reason: collision with root package name */
        public final int[] f16516y1;

        public a(ConnectivityManager connectivityManager, int[] iArr, int[] iArr2) {
            Network activeNetwork;
            NetworkCapabilities networkCapabilities;
            this.f16515x1 = connectivityManager;
            this.f16516y1 = iArr;
            this.f16513L1 = iArr2;
            activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null) {
                networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (DataNetworkDefault.C(iArr, iArr2, networkCapabilities)) {
                    this.f16514M1 = activeNetwork;
                }
            }
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Network activeNetwork;
            NetworkCapabilities networkCapabilities;
            LinkProperties linkProperties;
            int linkDownstreamBandwidthKbps;
            int linkUpstreamBandwidthKbps;
            ConnectivityManager connectivityManager = this.f16515x1;
            if (isInitialStickyBroadcast()) {
                return;
            }
            try {
                activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork != null) {
                    int[] iArr = this.f16516y1;
                    int[] iArr2 = this.f16513L1;
                    networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                    if (DataNetworkDefault.C(iArr, iArr2, networkCapabilities)) {
                        if (!C2440r.h(this.f16514M1, activeNetwork)) {
                            linkProperties = connectivityManager.getLinkProperties(activeNetwork);
                            Object[] objArr = new Object[5];
                            objArr[0] = Boolean.TRUE;
                            objArr[1] = linkProperties != null ? DataNetworkDefault.G(linkProperties) : null;
                            objArr[2] = linkProperties != null ? linkProperties.getInterfaceName() : null;
                            linkDownstreamBandwidthKbps = networkCapabilities.getLinkDownstreamBandwidthKbps();
                            objArr[3] = DataNetworkDefault.B(linkDownstreamBandwidthKbps);
                            linkUpstreamBandwidthKbps = networkCapabilities.getLinkUpstreamBandwidthKbps();
                            objArr[4] = DataNetworkDefault.B(linkUpstreamBandwidthKbps);
                            c(intent, objArr, false);
                        }
                        this.f16514M1 = activeNetwork;
                        return;
                    }
                }
                if (this.f16514M1 != null) {
                    this.f16514M1 = null;
                    c(intent, new Object[]{Boolean.FALSE, null, null, null, null}, false);
                }
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public static final class b extends com.llamalab.automate.W {

        /* renamed from: L1, reason: collision with root package name */
        public final ConnectivityManager f16517L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int[] f16518M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int[] f16519N1;

        /* renamed from: O1, reason: collision with root package name */
        public final boolean f16520O1;

        /* renamed from: P1, reason: collision with root package name */
        public NetworkCapabilities f16521P1;

        /* renamed from: Q1, reason: collision with root package name */
        public Network f16522Q1;

        /* renamed from: R1, reason: collision with root package name */
        public boolean f16523R1;

        /* renamed from: y1, reason: collision with root package name */
        public final a f16524y1;

        public final class a extends ConnectivityManager.NetworkCallback {

            /* renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int f16525b = 0;

            public a() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                b bVar = b.this;
                if (bVar.f16520O1) {
                    F5.n.f(bVar, "DataNetworkDefault onAvailable: " + network);
                }
                if (26 > Build.VERSION.SDK_INT) {
                    b.this.w2(50, new RunnableC2034k(this, 25, network));
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onBlockedStatusChanged(Network network, boolean z7) {
                b bVar = b.this;
                if (bVar.f16520O1) {
                    F5.n.f(bVar, "DataNetworkDefault onBlockedStatusChanged: " + network + ", " + z7);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                b bVar = b.this;
                if (bVar.f16520O1) {
                    F5.n.f(bVar, "DataNetworkDefault onCapabilitiesChanged: " + network + ", " + networkCapabilities);
                }
                b bVar2 = b.this;
                bVar2.f16521P1 = networkCapabilities;
                bVar2.w2(50, new RunnableC2035l(this, network, networkCapabilities, 5));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                b bVar = b.this;
                if (bVar.f16520O1) {
                    F5.n.f(bVar, "DataNetworkDefault onLinkPropertiesChanged: " + network + ", " + linkProperties);
                }
                b bVar2 = b.this;
                if (bVar2.f16521P1 == null) {
                    bVar2.w2(50, new RunnableC2389q(this, network, linkProperties, 6));
                    return;
                }
                try {
                    bVar2.f15400Y.f14581L1.removeCallbacksAndMessages(bVar2);
                    b bVar3 = b.this;
                    bVar3.v2(network, bVar3.f16521P1, linkProperties);
                } catch (Throwable th) {
                    b.this.r2(th);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                b bVar = b.this;
                if (bVar.f16520O1) {
                    F5.n.f(bVar, "DataNetworkDefault onLost: " + b.this.f16522Q1 + " vs " + network);
                }
                b bVar2 = b.this;
                bVar2.f16523R1 = true;
                bVar2.w2(MoreOsConstants.KEY_PLAYCD, new androidx.activity.g(26, this));
            }

            public a(int i8) {
                super(1);
            }
        }

        public b(ConnectivityManager connectivityManager, int[] iArr, int[] iArr2, boolean z7) {
            this.f16524y1 = 31 <= Build.VERSION.SDK_INT ? new a(0) : new a();
            this.f16517L1 = connectivityManager;
            this.f16518M1 = iArr;
            this.f16519N1 = iArr2;
            this.f16520O1 = z7;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            w2(100, new androidx.activity.b(21, this));
            this.f16517L1.registerDefaultNetworkCallback(this.f16524y1);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            this.f15400Y.f14581L1.removeCallbacksAndMessages(this);
            try {
                this.f16517L1.unregisterNetworkCallback(this.f16524y1);
            } catch (Throwable unused) {
            }
            u2();
        }

        public final void v2(Network network, NetworkCapabilities networkCapabilities, LinkProperties linkProperties) {
            int linkDownstreamBandwidthKbps;
            int linkUpstreamBandwidthKbps;
            if (this.f16520O1) {
                F5.n.f(this, "DataNetworkDefault onNetworkChanged: " + this.f16522Q1 + " vs " + network + ", " + networkCapabilities + ", " + linkProperties);
            }
            if (DataNetworkDefault.C(this.f16518M1, this.f16519N1, networkCapabilities)) {
                if (this.f16523R1 && !C2440r.h(this.f16522Q1, network)) {
                    Object[] objArr = new Object[5];
                    objArr[0] = Boolean.TRUE;
                    objArr[1] = linkProperties != null ? DataNetworkDefault.G(linkProperties) : null;
                    objArr[2] = linkProperties != null ? linkProperties.getInterfaceName() : null;
                    linkDownstreamBandwidthKbps = networkCapabilities.getLinkDownstreamBandwidthKbps();
                    objArr[3] = DataNetworkDefault.B(linkDownstreamBandwidthKbps);
                    linkUpstreamBandwidthKbps = networkCapabilities.getLinkUpstreamBandwidthKbps();
                    objArr[4] = DataNetworkDefault.B(linkUpstreamBandwidthKbps);
                    q2(objArr, false);
                }
                this.f16522Q1 = network;
            } else if (this.f16522Q1 != null) {
                this.f16522Q1 = null;
                q2(new Object[]{Boolean.FALSE, null, null, null, null}, false);
            }
            this.f16523R1 = true;
        }

        public final void w2(int i8, Runnable runnable) {
            this.f15400Y.f14581L1.removeCallbacksAndMessages(this);
            Handler handler = this.f15400Y.f14581L1;
            long j8 = i8;
            if (Build.VERSION.SDK_INT >= 28) {
                handler.postDelayed(runnable, this, j8);
                return;
            }
            Message obtain = Message.obtain(handler, runnable);
            obtain.obj = this;
            handler.sendMessageDelayed(obtain, j8);
        }
    }

    public static final class c extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public final int[] f16527L1;

        /* renamed from: M1, reason: collision with root package name */
        public NetworkInfo f16528M1;

        /* renamed from: x1, reason: collision with root package name */
        public final ConnectivityManager f16529x1;

        /* renamed from: y1, reason: collision with root package name */
        public final int[] f16530y1;

        public c(ConnectivityManager connectivityManager, int[] iArr, int[] iArr2) {
            this.f16529x1 = connectivityManager;
            this.f16530y1 = iArr;
            this.f16527L1 = iArr2;
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !DataNetworkDefault.D(iArr, iArr2, activeNetworkInfo, DataNetworkDefault.H(connectivityManager))) {
                return;
            }
            this.f16528M1 = activeNetworkInfo;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0046 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:6:0x0009, B:8:0x0016, B:10:0x0024, B:15:0x0046, B:17:0x0052, B:18:0x0058, B:20:0x005c, B:21:0x0062, B:24:0x006b, B:26:0x0029, B:28:0x0033, B:31:0x006e, B:33:0x0072), top: B:5:0x0009 }] */
        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onReceive(Context context, Intent intent) {
            boolean z7;
            ConnectivityManager connectivityManager = this.f16529x1;
            if (isInitialStickyBroadcast()) {
                return;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !DataNetworkDefault.D(this.f16530y1, this.f16527L1, activeNetworkInfo, DataNetworkDefault.H(connectivityManager))) {
                    if (this.f16528M1 != null) {
                        this.f16528M1 = null;
                        c(intent, new Object[]{Boolean.FALSE, null, null, null, null}, false);
                        return;
                    }
                    return;
                }
                NetworkInfo networkInfo = this.f16528M1;
                if (networkInfo != null && networkInfo.getType() == activeNetworkInfo.getType() && C2440r.h(networkInfo.getExtraInfo(), activeNetworkInfo.getExtraInfo())) {
                    z7 = true;
                    if (!z7) {
                        LinkProperties e8 = C2424b.e(connectivityManager);
                        Object[] objArr = new Object[5];
                        objArr[0] = Boolean.TRUE;
                        objArr[1] = e8 != null ? DataNetworkDefault.G(e8) : null;
                        objArr[2] = e8 != null ? e8.getInterfaceName() : null;
                        objArr[3] = null;
                        objArr[4] = null;
                        c(intent, objArr, false);
                    }
                    this.f16528M1 = activeNetworkInfo;
                }
                z7 = false;
                if (!z7) {
                }
                this.f16528M1 = activeNetworkInfo;
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public static Double B(int i8) {
        if (i8 <= 0 || i8 >= Integer.MAX_VALUE) {
            return null;
        }
        double d8 = i8;
        Double.isNaN(d8);
        return Double.valueOf(d8 * 1000.0d);
    }

    public static boolean C(int[] iArr, int[] iArr2, NetworkCapabilities networkCapabilities) {
        boolean hasTransport;
        boolean hasCapability;
        if (networkCapabilities == null) {
            return false;
        }
        for (int i8 : iArr) {
            hasCapability = networkCapabilities.hasCapability(i8);
            if (!hasCapability) {
                return false;
            }
        }
        if (iArr2.length == 0) {
            return true;
        }
        for (int i9 : iArr2) {
            hasTransport = networkCapabilities.hasTransport(i9);
            if (hasTransport) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        if (14 == r10.getType()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
    
        if (13 == r10.getType()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        if (12 == r10.getType()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        if (11 == r10.getType()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
    
        if (10 == r10.getType()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
    
        if (4 == r10.getType()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        if (3 == r10.getType()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
    
        if (2 == r10.getType()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        if (17 != r10.getType()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        if (15 == r10.getType()) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean D(int[] iArr, int[] iArr2, NetworkInfo networkInfo, boolean z7) {
        int length = iArr.length;
        int i8 = 0;
        while (true) {
            boolean z8 = true;
            if (i8 >= length) {
                if (iArr2.length == 0) {
                    return true;
                }
                for (int i9 : iArr2) {
                    if (C2424b.m(networkInfo, i9)) {
                        return true;
                    }
                }
                return false;
            }
            int i10 = iArr[i8];
            if (i10 != 10) {
                if (i10 == 11) {
                    z8 = true ^ z7;
                } else if (i10 != 15) {
                    if (i10 != 18) {
                        switch (i10) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            default:
                                z8 = false;
                                break;
                        }
                    } else {
                        z8 = true ^ networkInfo.isRoaming();
                    }
                }
            }
            if (!z8) {
                return false;
            }
            i8++;
        }
    }

    public static J3.a G(LinkProperties linkProperties) {
        InetAddress address;
        Collection<LinkAddress> h8 = C2424b.h(linkProperties);
        if (h8.isEmpty()) {
            return null;
        }
        J3.a aVar = new J3.a(h8.size());
        Iterator<LinkAddress> it = h8.iterator();
        while (it.hasNext()) {
            address = C2198d.c(it.next()).getAddress();
            aVar.add(address.getHostAddress());
        }
        Arrays.sort(aVar.f4626X, 0, aVar.f4627Y, f16512L1);
        return aVar;
    }

    public static boolean H(ConnectivityManager connectivityManager) {
        boolean isActiveNetworkMetered;
        if (16 > Build.VERSION.SDK_INT) {
            return false;
        }
        isActiveNetworkMetered = connectivityManager.isActiveNetworkMetered();
        return isActiveNetworkMetered;
    }

    public final void E(C1708z0 c1708z0, boolean z7, J3.a aVar, String str, Double d8, Double d9) {
        J3.l lVar = this.varIpAddresses;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, aVar);
        }
        J3.l lVar2 = this.varInterfaceName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str);
        }
        J3.l lVar3 = this.varDownloadBandwidth;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d8);
        }
        J3.l lVar4 = this.varUploadBandwidth;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, d9);
        }
        o(c1708z0, z7);
    }

    public final void F(C1708z0 c1708z0, Object obj) {
        Object[] objArr = (Object[]) obj;
        E(c1708z0, ((Boolean) objArr[0]).booleanValue(), (J3.a) objArr[1], (String) objArr[2], (Double) objArr[3], (Double) objArr[4]);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")} : 28 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_COARSE_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_data_network_default_immediate, C2541R.string.caption_data_network_default_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        F(c1708z0, obj);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.capabilities);
        dVar.g(this.transports);
        dVar.g(this.varIpAddresses);
        dVar.g(this.varInterfaceName);
        dVar.g(this.varDownloadBandwidth);
        dVar.g(this.varUploadBandwidth);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.capabilities);
        visitor.b(this.transports);
        visitor.b(this.varIpAddresses);
        visitor.b(this.varInterfaceName);
        visitor.b(this.varDownloadBandwidth);
        visitor.b(this.varUploadBandwidth);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.capabilities = (InterfaceC1700x0) cVar.readObject();
        this.transports = (InterfaceC1700x0) cVar.readObject();
        this.varIpAddresses = (J3.l) cVar.readObject();
        this.varInterfaceName = (J3.l) cVar.readObject();
        this.varDownloadBandwidth = (J3.l) cVar.readObject();
        this.varUploadBandwidth = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        J3.a G7;
        String interfaceName;
        String str;
        J3.a aVar;
        boolean z7;
        Double d8;
        Double d9;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        LinkProperties linkProperties;
        int linkDownstreamBandwidthKbps;
        int linkUpstreamBandwidthKbps;
        c1708z0.q(C2541R.string.stmt_data_network_default_title);
        InterfaceC1700x0 interfaceC1700x0 = this.capabilities;
        int[] iArr = C2434l.f23393d;
        int[] n8 = J3.h.n(c1708z0, interfaceC1700x0, iArr);
        int[] n9 = J3.h.n(c1708z0, this.transports, iArr);
        ConnectivityManager connectivityManager = (ConnectivityManager) c1708z0.getSystemService("connectivity");
        boolean z8 = false;
        if (J1(1) != 0) {
            int i8 = Build.VERSION.SDK_INT;
            if (24 <= i8) {
                c1708z0.w(new b(connectivityManager, n8, n9, C1710z2.a(C2425c.c(c1708z0))));
            } else {
                AbstractC1618p2 aVar2 = 23 <= i8 ? new a(connectivityManager, n8, n9) : new c(connectivityManager, n8, n9);
                c1708z0.w(aVar2);
                aVar2.h("android.net.conn.CONNECTIVITY_CHANGE");
            }
            return false;
        }
        if (23 <= Build.VERSION.SDK_INT) {
            activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork != null) {
                networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (C(n8, n9, networkCapabilities)) {
                    linkProperties = connectivityManager.getLinkProperties(activeNetwork);
                    J3.a G8 = linkProperties != null ? G(linkProperties) : null;
                    String interfaceName2 = linkProperties != null ? linkProperties.getInterfaceName() : null;
                    linkDownstreamBandwidthKbps = networkCapabilities.getLinkDownstreamBandwidthKbps();
                    Double B7 = B(linkDownstreamBandwidthKbps);
                    linkUpstreamBandwidthKbps = networkCapabilities.getLinkUpstreamBandwidthKbps();
                    d8 = B7;
                    d9 = B(linkUpstreamBandwidthKbps);
                    str = interfaceName2;
                    aVar = G8;
                    z7 = true;
                    E(c1708z0, z7, aVar, str, d8, d9);
                    return true;
                }
            }
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && D(n8, n9, activeNetworkInfo, H(connectivityManager))) {
                LinkProperties e8 = C2424b.e(connectivityManager);
                G7 = e8 != null ? G(e8) : null;
                interfaceName = e8 != null ? e8.getInterfaceName() : null;
                z8 = true;
                str = interfaceName;
                aVar = G7;
                z7 = z8;
                d8 = null;
                d9 = null;
                E(c1708z0, z7, aVar, str, d8, d9);
                return true;
            }
        }
        interfaceName = null;
        G7 = null;
        str = interfaceName;
        aVar = G7;
        z7 = z8;
        d8 = null;
        d9 = null;
        E(c1708z0, z7, aVar, str, d8, d9);
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        F(c1708z0, obj);
        return true;
    }
}
