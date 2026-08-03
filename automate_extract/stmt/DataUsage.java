package com.llamalab.automate.stmt;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.expr.func.Coalesce;
import java.lang.reflect.Method;
import x3.C2424b;
import x3.C2425c;

@F3.f("data_usage.html")
@F3.a(C2541R.integer.ic_device_access_data_usage)
@F3.i(C2541R.string.stmt_data_usage_title)
@F3.h(C2541R.string.stmt_data_usage_summary)
@F3.e(C2541R.layout.stmt_data_usage_edit)
/* loaded from: classes.dex */
public final class DataUsage extends Action implements AsyncStatement {
    public InterfaceC1700x0 maxTimestamp;
    public InterfaceC1700x0 minTimestamp;
    public InterfaceC1700x0 networkInterface;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 ssid;
    public InterfaceC1700x0 subscriptionId;
    public J3.l varDownloaded;
    public J3.l varTransferred;
    public J3.l varUploaded;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final int f16531L1;

        /* renamed from: M1, reason: collision with root package name */
        public final String f16532M1;

        /* renamed from: N1, reason: collision with root package name */
        public final String f16533N1;

        /* renamed from: O1, reason: collision with root package name */
        public final long f16534O1;

        /* renamed from: P1, reason: collision with root package name */
        public final long f16535P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final int f16536Q1;

        public a(int i8, String str, String str2, long j8, long j9, int i9) {
            this.f16531L1 = i8;
            this.f16532M1 = str;
            this.f16533N1 = str2;
            this.f16534O1 = j8;
            this.f16535P1 = j9;
            this.f16536Q1 = i9;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            Method method = C2425c.f23378a;
            q2(C2424b.j(this.f16536Q1, C2424b.k(C2425c.a((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "netstats"), "android.net.INetworkStatsService"), C2424b.b(this.f16531L1, this.f16532M1, this.f16533N1), this.f16534O1, this.f16535P1, this.f16536Q1, this.f15400Y.getPackageName(), true)), false);
        }
    }

    public static final class b extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final int f16537L1;

        /* renamed from: M1, reason: collision with root package name */
        public final long f16538M1;

        /* renamed from: N1, reason: collision with root package name */
        public final long f16539N1;

        /* renamed from: O1, reason: collision with root package name */
        public final int f16540O1;

        public b(int i8, int i9, long j8, long j9) {
            this.f16537L1 = i8;
            this.f16538M1 = j8;
            this.f16539N1 = j9;
            this.f16540O1 = i9;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            NetworkStatsManager networkStatsManager = (NetworkStatsManager) this.f15400Y.getSystemService("netstats");
            int i8 = this.f16540O1;
            if (-1 == i8) {
                NetworkStats.Bucket querySummaryForDevice = networkStatsManager.querySummaryForDevice(this.f16537L1, null, this.f16538M1, this.f16539N1);
                if (querySummaryForDevice == null) {
                    throw new IllegalStateException("Failed to get bucket");
                }
                q2(new long[]{querySummaryForDevice.getRxBytes(), querySummaryForDevice.getTxBytes()}, false);
                return;
            }
            long[] jArr = new long[2];
            NetworkStats queryDetailsForUid = networkStatsManager.queryDetailsForUid(this.f16537L1, null, this.f16538M1, this.f16539N1, i8);
            try {
                NetworkStats.Bucket bucket = new NetworkStats.Bucket();
                while (queryDetailsForUid.hasNextBucket()) {
                    if (!queryDetailsForUid.getNextBucket(bucket)) {
                        throw new IllegalStateException("Failed to get bucket");
                    }
                    jArr[0] = jArr[0] + bucket.getRxBytes();
                    jArr[1] = jArr[1] + bucket.getTxBytes();
                }
                queryDetailsForUid.close();
                q2(jArr, false);
            } catch (Throwable th) {
                if (queryDetailsForUid != null) {
                    try {
                        queryDetailsForUid.close();
                    } catch (Throwable th2) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        } catch (Exception unused) {
                        }
                    }
                }
                throw th;
            }
        }
    }

    public static final class c extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final int f16541M1;

        /* renamed from: N1, reason: collision with root package name */
        public final String f16542N1;

        /* renamed from: O1, reason: collision with root package name */
        public final String f16543O1;

        /* renamed from: P1, reason: collision with root package name */
        public final long f16544P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final long f16545Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final int f16546R1;

        public c(int i8, String str, String str2, long j8, long j9, int i9) {
            this.f16541M1 = i8;
            this.f16542N1 = str;
            this.f16543O1 = str2;
            this.f16544P1 = j8;
            this.f16545Q1 = j9;
            this.f16546R1 = i9;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                long[] X7 = interfaceC1585h1.X(this.f16541M1, this.f16542N1, this.f16543O1, this.f16544P1, this.f16545Q1, this.f16546R1, lVar);
                lVar.c();
                q2(X7, false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE"), com.llamalab.automate.access.c.f15559t} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE"), com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.stmt_data_usage_title).e(this.networkInterface, 6, C2541R.xml.data_usage_interfaces).q(this.networkInterface).o(2, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.networkInterface);
        dVar.g(this.minTimestamp);
        dVar.g(this.maxTimestamp);
        dVar.g(this.packageName);
        if (64 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
            dVar.g(this.ssid);
        }
        dVar.g(this.varTransferred);
        dVar.g(this.varDownloaded);
        dVar.g(this.varUploaded);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.networkInterface);
        visitor.b(this.minTimestamp);
        visitor.b(this.maxTimestamp);
        visitor.b(this.packageName);
        visitor.b(this.subscriptionId);
        visitor.b(this.ssid);
        visitor.b(this.varTransferred);
        visitor.b(this.varDownloaded);
        visitor.b(this.varUploaded);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.networkInterface = (InterfaceC1700x0) cVar.readObject();
        this.minTimestamp = (InterfaceC1700x0) cVar.readObject();
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        this.maxTimestamp = interfaceC1700x0;
        if (106 > cVar.f6409x0) {
            L3.H h8 = L3.H.f4932X;
            if (interfaceC1700x0 == null || (interfaceC1700x0 instanceof L3.I)) {
                this.maxTimestamp = h8;
            } else if (!(interfaceC1700x0 instanceof J3.k)) {
                this.maxTimestamp = new Coalesce(interfaceC1700x0, h8);
            }
        }
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        if (64 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
            this.ssid = (InterfaceC1700x0) cVar.readObject();
        }
        this.varTransferred = (J3.l) cVar.readObject();
        this.varDownloaded = (J3.l) cVar.readObject();
        this.varUploaded = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int i8;
        String str;
        String str2;
        int i9;
        String str3;
        String str4;
        Object invoke;
        c1708z0.q(C2541R.string.stmt_data_usage_title);
        int m8 = J3.h.m(c1708z0, this.networkInterface, 6);
        long t8 = J3.h.t(c1708z0, this.minTimestamp, 0L);
        long t9 = J3.h.t(c1708z0, this.maxTimestamp, Long.MAX_VALUE);
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        if (x7 != null) {
            try {
                i8 = c1708z0.getPackageManager().getApplicationInfo(x7, 0).uid;
            } catch (PackageManager.NameNotFoundException unused) {
                throw new IllegalArgumentException("Package not installed: ".concat(x7));
            }
        } else {
            i8 = -1;
        }
        if (m8 != 5) {
            int i10 = 1;
            if (m8 == 6) {
                int i11 = Build.VERSION.SDK_INT;
                if (29 > i11) {
                    int m9 = J3.h.m(c1708z0, this.subscriptionId, -1);
                    if (-1 != m9) {
                        TelephonyManager telephonyManager = (TelephonyManager) c1708z0.getSystemService("phone");
                        String[] strArr = w3.n.f23254a;
                        if (24 <= i11) {
                            telephonyManager = telephonyManager.createForSubscriptionId(m9);
                        } else {
                            if (22 <= i11) {
                                invoke = telephonyManager.getClass().getMethod("getSubscriberId", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(m9));
                            } else if (21 <= i11) {
                                invoke = telephonyManager.getClass().getMethod("getSubscriberId", Long.TYPE).invoke(telephonyManager, Long.valueOf(w3.n.a(m9)));
                            }
                            str4 = (String) invoke;
                        }
                        str4 = telephonyManager.getSubscriberId();
                    } else {
                        i10 = m8;
                        str4 = null;
                    }
                    str3 = str4;
                    m8 = i10;
                } else {
                    str3 = null;
                }
                str = str3;
                str2 = null;
                i9 = 0;
            } else {
                if (m8 != 7) {
                    throw new IllegalArgumentException("networkInterface");
                }
                String x8 = J3.h.x(c1708z0, this.ssid, null);
                if (TextUtils.isEmpty(x8)) {
                    x8 = null;
                } else {
                    m8 = 4;
                }
                str2 = x8;
                str = null;
                i9 = 1;
            }
        } else {
            str = null;
            str2 = null;
            i9 = 9;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (31 <= i12) {
            b bVar = new b(i9, i8, t8, t9);
            c1708z0.w(bVar);
            bVar.w2();
        } else if (23 <= i12) {
            a aVar = new a(m8, str, str2, t8, t9, i8);
            c1708z0.w(aVar);
            aVar.w2();
        } else {
            c1708z0.w(new c(m8, str, str2, t8, t9, i8));
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        long[] jArr = (long[]) obj;
        double d8 = jArr[0];
        double d9 = jArr[1];
        J3.l lVar = this.varTransferred;
        if (lVar != null) {
            Double.isNaN(d8);
            Double.isNaN(d9);
            Double.isNaN(d8);
            Double.isNaN(d9);
            c1708z0.z(lVar.f4659Y, Double.valueOf(d8 + d9));
        }
        J3.l lVar2 = this.varDownloaded;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, Double.valueOf(d8));
        }
        J3.l lVar3 = this.varUploaded;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, Double.valueOf(d9));
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
