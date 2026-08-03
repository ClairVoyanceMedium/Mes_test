package com.llamalab.automate.stmt;

import android.app.usage.UsageStats;
import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.C1695w;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.expr.func.Coalesce;
import java.util.Iterator;
import java.util.List;

@F3.f("app_usage.html")
@F3.a(C2541R.integer.ic_device_access_data_usage)
@F3.i(C2541R.string.stmt_app_usage_title)
@F3.h(C2541R.string.stmt_app_usage_summary)
@F3.e(C2541R.layout.stmt_app_usage_edit)
/* loaded from: classes.dex */
public final class AppUsage extends Action {
    public InterfaceC1700x0 interval;
    public InterfaceC1700x0 maxTimestamp;
    public InterfaceC1700x0 minTimestamp;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 statistic;
    public J3.l varLastUsedTimestamp;
    public J3.l varStatsEndTimestamp;
    public J3.l varStatsStartTimestamp;
    public J3.l varUsageDuration;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 21 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15559t} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.stmt_app_usage_title).e(this.statistic, 1, C2541R.xml.app_usage_statistics).q(this.statistic).o(2, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.minTimestamp);
        dVar.g(this.maxTimestamp);
        if (103 <= dVar.f6413Z) {
            dVar.g(this.interval);
        }
        dVar.g(this.packageName);
        if (83 <= dVar.f6413Z) {
            dVar.g(this.statistic);
        }
        dVar.g(this.varUsageDuration);
        dVar.g(this.varLastUsedTimestamp);
        if (102 <= dVar.f6413Z) {
            dVar.g(this.varStatsStartTimestamp);
            dVar.g(this.varStatsEndTimestamp);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.minTimestamp);
        visitor.b(this.maxTimestamp);
        visitor.b(this.interval);
        visitor.b(this.packageName);
        visitor.b(this.statistic);
        visitor.b(this.varUsageDuration);
        visitor.b(this.varLastUsedTimestamp);
        visitor.b(this.varStatsStartTimestamp);
        visitor.b(this.varStatsEndTimestamp);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.minTimestamp = (InterfaceC1700x0) cVar.readObject();
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        this.maxTimestamp = interfaceC1700x0;
        int i8 = cVar.f6409x0;
        if (106 > i8) {
            L3.H h8 = L3.H.f4932X;
            if (interfaceC1700x0 == null || (interfaceC1700x0 instanceof L3.I)) {
                this.maxTimestamp = h8;
            } else if (!(interfaceC1700x0 instanceof J3.k)) {
                this.maxTimestamp = new Coalesce(interfaceC1700x0, h8);
            }
        }
        if (103 <= i8) {
            this.interval = (InterfaceC1700x0) cVar.readObject();
        }
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        if (83 <= cVar.f6409x0) {
            this.statistic = (InterfaceC1700x0) cVar.readObject();
        }
        this.varUsageDuration = (J3.l) cVar.readObject();
        this.varLastUsedTimestamp = (J3.l) cVar.readObject();
        if (102 <= cVar.f6409x0) {
            this.varStatsStartTimestamp = (J3.l) cVar.readObject();
            this.varStatsEndTimestamp = (J3.l) cVar.readObject();
        }
    }

    public final void q(C1708z0 c1708z0, Double d8, Double d9, Double d10, Double d11) {
        J3.l lVar = this.varUsageDuration;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        J3.l lVar2 = this.varLastUsedTimestamp;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d9);
        }
        J3.l lVar3 = this.varStatsStartTimestamp;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d10);
        }
        J3.l lVar4 = this.varStatsEndTimestamp;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, d11);
        }
        c1708z0.f17642x0 = this.onComplete;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        List queryUsageStats;
        Double valueOf;
        Double d8;
        Double d9;
        Double d10;
        long totalTimeInForeground;
        long j8;
        long lastTimeUsed;
        long firstTimeStamp;
        long lastTimeStamp;
        long lastTimeStamp2;
        long firstTimeStamp2;
        long totalTimeForegroundServiceUsed;
        long totalTimeVisible;
        String packageName;
        c1708z0.q(C2541R.string.stmt_app_usage_title);
        IncapableAndroidVersionException.a(21);
        long j9 = 0;
        long t8 = J3.h.t(c1708z0, this.minTimestamp, 0L);
        long j10 = Long.MAX_VALUE;
        long t9 = J3.h.t(c1708z0, this.maxTimestamp, Long.MAX_VALUE);
        int m8 = J3.h.m(c1708z0, this.interval, 4);
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        int i8 = 1;
        int m9 = J3.h.m(c1708z0, this.statistic, 1);
        queryUsageStats = C1695w.i(c1708z0.getSystemService("usagestats")).queryUsageStats(m8, t8, t9);
        if (queryUsageStats == null || queryUsageStats.isEmpty()) {
            valueOf = Double.valueOf(0.0d);
            d8 = null;
            d9 = null;
        } else {
            Iterator it = queryUsageStats.iterator();
            long j11 = Long.MIN_VALUE;
            long j12 = Long.MIN_VALUE;
            while (it.hasNext()) {
                UsageStats h8 = C1695w.h(it.next());
                if (x7 != null) {
                    packageName = h8.getPackageName();
                    if (!x7.equals(packageName)) {
                        continue;
                    }
                }
                if (m9 == i8) {
                    totalTimeInForeground = h8.getTotalTimeInForeground();
                    j8 = totalTimeInForeground + j9;
                    lastTimeUsed = h8.getLastTimeUsed();
                } else if (m9 == 2) {
                    IncapableAndroidVersionException.b(29, "foreground-service statistic");
                    totalTimeForegroundServiceUsed = h8.getTotalTimeForegroundServiceUsed();
                    j8 = totalTimeForegroundServiceUsed + j9;
                    lastTimeUsed = h8.getLastTimeForegroundServiceUsed();
                } else {
                    if (m9 != 3) {
                        throw new IllegalArgumentException("statistic");
                    }
                    IncapableAndroidVersionException.b(29, "visible statistic");
                    totalTimeVisible = h8.getTotalTimeVisible();
                    j8 = totalTimeVisible + j9;
                    lastTimeUsed = h8.getLastTimeVisible();
                }
                if (j12 < lastTimeUsed) {
                    j12 = lastTimeUsed;
                }
                firstTimeStamp = h8.getFirstTimeStamp();
                if (j10 > firstTimeStamp) {
                    firstTimeStamp2 = h8.getFirstTimeStamp();
                    j10 = firstTimeStamp2;
                }
                lastTimeStamp = h8.getLastTimeStamp();
                if (j11 < lastTimeStamp) {
                    lastTimeStamp2 = h8.getLastTimeStamp();
                    j11 = lastTimeStamp2;
                }
                i8 = 1;
                j9 = j8;
            }
            double d11 = j9;
            valueOf = F5.n.l(d11, d11, d11, 1000.0d);
            if (Long.MIN_VALUE != j12) {
                double d12 = j12;
                d8 = F5.n.l(d12, d12, d12, 1000.0d);
            } else {
                d8 = null;
            }
            if (Long.MAX_VALUE != j10) {
                double d13 = j10;
                d9 = F5.n.l(d13, d13, d13, 1000.0d);
            } else {
                d9 = null;
            }
            if (Long.MIN_VALUE != j11) {
                double d14 = j11;
                d10 = F5.n.l(d14, d14, d14, 1000.0d);
                Double d15 = d10;
                q(c1708z0, valueOf, d8, d9, d15);
                return true;
            }
        }
        d10 = null;
        Double d152 = d10;
        q(c1708z0, valueOf, d8, d9, d152);
        return true;
    }
}
