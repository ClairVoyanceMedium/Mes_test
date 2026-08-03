package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.os.Build;
import android.os.SystemClock;
import com.llamalab.automate.AbstractRunnableC1586h2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.io.IOException;
import java.util.Iterator;
import p3.C2212a;
import p3.C2213b;
import x3.C2440r;

@F3.f("network_throughput.html")
@F3.a(C2541R.integer.ic_traffic_view)
@F3.i(C2541R.string.stmt_network_throughput_title)
@F3.h(C2541R.string.stmt_network_throughput_summary)
@F3.e(C2541R.layout.stmt_network_throughput_edit)
/* loaded from: classes.dex */
public final class NetworkThroughput extends LevelDecision implements AsyncStatement {
    public InterfaceC1700x0 direction;
    public InterfaceC1700x0 networkInterface;
    public InterfaceC1700x0 packageName;

    public static final class a extends com.llamalab.automate.W {

        /* renamed from: L1, reason: collision with root package name */
        public final Double f16951L1;

        /* renamed from: M1, reason: collision with root package name */
        public final String f16952M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16953N1;

        /* renamed from: O1, reason: collision with root package name */
        public final int f16954O1;

        /* renamed from: P1, reason: collision with root package name */
        public final boolean f16955P1;

        /* renamed from: Q1, reason: collision with root package name */
        public Boolean f16956Q1;

        /* renamed from: y1, reason: collision with root package name */
        public final Double f16957y1;

        public a(Boolean bool, boolean z7, Double d8, Double d9, String str, int i8, int i9) {
            this.f16956Q1 = bool;
            this.f16955P1 = z7 || (d8 == null && d9 == null);
            this.f16957y1 = d8;
            this.f16951L1 = d9;
            this.f16952M1 = str;
            this.f16953N1 = i8;
            this.f16954O1 = i9;
        }
    }

    public static final class b extends AbstractRunnableC1586h2 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f16958L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16959M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16960N1;

        /* renamed from: O1, reason: collision with root package name */
        public long f16961O1;

        /* renamed from: P1, reason: collision with root package name */
        public long f16962P1;

        /* renamed from: Q1, reason: collision with root package name */
        public volatile double f16963Q1;

        /* renamed from: R1, reason: collision with root package name */
        public int f16964R1;

        public b(int i8, int i9, String str) {
            super(1000L);
            this.f16961O1 = -1L;
            this.f16958L1 = str;
            this.f16959M1 = i8;
            this.f16960N1 = i9;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1586h2
        public final boolean v2() {
            long j8;
            long uidTxBytes;
            long rxBytes;
            Boolean bool;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i8 = Build.VERSION.SDK_INT;
            if (18 <= i8 && "rmnet*".equals(this.f16958L1)) {
                j8 = w2(1) ? Math.max(0L, TrafficStats.getMobileRxBytes()) + 0 : 0L;
                if (w2(2)) {
                    uidTxBytes = TrafficStats.getMobileTxBytes();
                    j8 += Math.max(0L, uidTxBytes);
                }
            } else if (31 <= i8 && this.f16958L1 != null) {
                if (w2(1)) {
                    rxBytes = TrafficStats.getRxBytes(this.f16958L1);
                    j8 = Math.max(0L, rxBytes) + 0;
                } else {
                    j8 = 0;
                }
                if (w2(2)) {
                    uidTxBytes = TrafficStats.getTxBytes(this.f16958L1);
                    j8 += Math.max(0L, uidTxBytes);
                }
            } else if (this.f16960N1 == -1) {
                j8 = w2(1) ? Math.max(0L, TrafficStats.getTotalRxBytes()) + 0 : 0L;
                if (w2(2)) {
                    uidTxBytes = TrafficStats.getTotalTxBytes();
                    j8 += Math.max(0L, uidTxBytes);
                }
            } else if (21 <= i8) {
                j8 = w2(1) ? Math.max(0L, TrafficStats.getUidRxBytes(this.f16960N1)) + 0 : 0L;
                if (w2(2)) {
                    uidTxBytes = TrafficStats.getUidTxBytes(this.f16960N1);
                    j8 += Math.max(0L, uidTxBytes);
                }
            } else {
                try {
                    r7 = w2(1) ? 0 + Long.parseLong(C2212a.l("/proc/uid_stat/" + this.f16960N1 + "/tcp_rcv", C2213b.f21560b), 10) : 0L;
                    if (w2(2)) {
                        r7 += Long.parseLong(C2212a.l("/proc/uid_stat/" + this.f16960N1 + "/tcp_snd", C2213b.f21560b), 10);
                    }
                } catch (IOException unused) {
                }
                j8 = r7;
            }
            long j9 = this.f16961O1;
            if (j9 != -1) {
                double d8 = j8 - this.f16962P1;
                double d9 = elapsedRealtime - j9;
                Double.isNaN(d9);
                Double.isNaN(d9);
                Double.isNaN(d8);
                Double.isNaN(d8);
                this.f16963Q1 = d8 / (d9 / 1000.0d);
                for (a aVar : this.f15400Y.r(a.class, this.f15402x0)) {
                    if (C2440r.h(this.f16958L1, aVar.f16952M1) && this.f16959M1 == aVar.f16953N1 && this.f16960N1 == aVar.f16954O1) {
                        double d10 = this.f16963Q1;
                        Boolean valueOf = Boolean.valueOf(LevelDecision.E(d10, aVar.f16957y1, aVar.f16951L1));
                        if (aVar.f16955P1 || !((bool = aVar.f16956Q1) == null || valueOf.equals(bool))) {
                            aVar.f16956Q1 = valueOf;
                            aVar.q2(new Object[]{valueOf, Double.valueOf(d10)}, false);
                        } else {
                            aVar.f16956Q1 = valueOf;
                        }
                        this.f16964R1 = 0;
                    }
                }
            }
            this.f16961O1 = elapsedRealtime;
            this.f16962P1 = j8;
            int i9 = this.f16964R1 + 1;
            this.f16964R1 = i9;
            if (i9 <= 10) {
                return true;
            }
            a();
            return false;
        }

        public final boolean w2(int i8) {
            return (i8 & this.f16959M1) != 0;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_network_throughput_immediate, C2541R.string.caption_network_throughput_change);
        c1596k0.n(this.minLevel, this.maxLevel, 0);
        return c1596k0.o(2, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.direction);
        if (109 <= dVar.f6413Z) {
            dVar.g(this.networkInterface);
        }
        dVar.g(this.packageName);
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.direction);
        visitor.b(this.networkInterface);
        visitor.b(this.packageName);
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.direction = (InterfaceC1700x0) cVar.readObject();
        if (109 <= cVar.f6409x0) {
            this.networkInterface = (InterfaceC1700x0) cVar.readObject();
        }
        this.packageName = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int i8;
        boolean z7;
        c1708z0.q(C2541R.string.stmt_network_throughput_title);
        Double D7 = D(c1708z0);
        Double C7 = C(c1708z0);
        int m8 = J3.h.m(c1708z0, this.direction, 3) & 3;
        if (m8 == 0) {
            m8 = 3;
        }
        Boolean bool = null;
        String x7 = J3.h.x(c1708z0, this.networkInterface, null);
        String x8 = J3.h.x(c1708z0, this.packageName, null);
        if (x8 != null) {
            try {
                i8 = c1708z0.getPackageManager().getApplicationInfo(x8, 0).uid;
            } catch (PackageManager.NameNotFoundException unused) {
                throw new IllegalArgumentException("Package not installed: ".concat(x8));
            }
        } else {
            i8 = -1;
        }
        boolean z8 = J1(1) == 0;
        Iterator it = c1708z0.j2().r(b.class, c1708z0.f17644y0).iterator();
        while (true) {
            if (!it.hasNext()) {
                z7 = false;
                break;
            }
            b bVar = (b) it.next();
            if (C2440r.h(bVar.f16958L1, x7) && bVar.f16959M1 == m8 && bVar.f16960N1 == i8) {
                bVar.f16964R1 = 0;
                if (bVar.f16961O1 != -1) {
                    bool = Boolean.valueOf(LevelDecision.E(bVar.f16963Q1, D7, C7));
                    if (z8) {
                        B(c1708z0, bool.booleanValue(), Double.valueOf(bVar.f16963Q1));
                        return true;
                    }
                }
                z7 = true;
            }
        }
        c1708z0.w(new a(bool, z8, D7, C7, x7, m8, i8));
        if (!z7) {
            b bVar2 = new b(m8, i8, x7);
            c1708z0.w(bVar2);
            bVar2.f15400Y.f14581L1.post(bVar2);
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (Double) objArr[1]);
        return true;
    }
}
