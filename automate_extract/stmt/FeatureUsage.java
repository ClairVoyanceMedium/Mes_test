package com.llamalab.automate.stmt;

import android.app.usage.EventStats;
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

@F3.f("feature_usage.html")
@F3.a(C2541R.integer.ic_device_access_data_usage)
@F3.i(C2541R.string.stmt_feature_usage_title)
@F3.h(C2541R.string.stmt_feature_usage_summary)
@F3.e(C2541R.layout.stmt_feature_usage_edit)
/* loaded from: classes.dex */
public final class FeatureUsage extends Action {
    public InterfaceC1700x0 interval;
    public InterfaceC1700x0 maxTimestamp;
    public InterfaceC1700x0 minTimestamp;
    public InterfaceC1700x0 statistic;
    public J3.l varLastUsedTimestamp;
    public J3.l varStatsEndTimestamp;
    public J3.l varStatsStartTimestamp;
    public J3.l varUsageCount;
    public J3.l varUsageDuration;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 28 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15559t} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.stmt_feature_usage_title).e(this.statistic, 15, C2541R.xml.usage_event_types).q(this.statistic).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.minTimestamp);
        dVar.g(this.maxTimestamp);
        if (103 <= dVar.f6413Z) {
            dVar.g(this.interval);
        }
        dVar.g(this.statistic);
        dVar.g(this.varUsageCount);
        dVar.g(this.varUsageDuration);
        dVar.g(this.varLastUsedTimestamp);
        dVar.g(this.varStatsStartTimestamp);
        dVar.g(this.varStatsEndTimestamp);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.minTimestamp);
        visitor.b(this.maxTimestamp);
        visitor.b(this.interval);
        visitor.b(this.statistic);
        visitor.b(this.varUsageCount);
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
        if (109 > i8) {
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
        this.statistic = (InterfaceC1700x0) cVar.readObject();
        this.varUsageCount = (J3.l) cVar.readObject();
        this.varUsageDuration = (J3.l) cVar.readObject();
        this.varLastUsedTimestamp = (J3.l) cVar.readObject();
        this.varStatsStartTimestamp = (J3.l) cVar.readObject();
        this.varStatsEndTimestamp = (J3.l) cVar.readObject();
    }

    public final void q(C1708z0 c1708z0, Double d8, Double d9, Double d10, Double d11, Double d12) {
        J3.l lVar = this.varUsageCount;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        J3.l lVar2 = this.varUsageDuration;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d9);
        }
        J3.l lVar3 = this.varLastUsedTimestamp;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d10);
        }
        J3.l lVar4 = this.varStatsStartTimestamp;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, d11);
        }
        J3.l lVar5 = this.varStatsEndTimestamp;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, d12);
        }
        c1708z0.f17642x0 = this.onComplete;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        List queryEventStats;
        Double valueOf;
        Double d8;
        Double d9;
        Double valueOf2;
        Double d10;
        Double d11;
        Double d12;
        int eventType;
        int count;
        long totalTime;
        long lastEventTime;
        long firstTimeStamp;
        long lastTimeStamp;
        long lastTimeStamp2;
        long firstTimeStamp2;
        long lastEventTime2;
        c1708z0.q(C2541R.string.stmt_feature_usage_title);
        IncapableAndroidVersionException.a(28);
        long j8 = 0;
        long t8 = J3.h.t(c1708z0, this.minTimestamp, 0L);
        long t9 = J3.h.t(c1708z0, this.maxTimestamp, Long.MAX_VALUE);
        int m8 = J3.h.m(c1708z0, this.interval, 4);
        int m9 = J3.h.m(c1708z0, this.statistic, 15);
        queryEventStats = C1695w.i(c1708z0.getSystemService("usagestats")).queryEventStats(m8, t8, t9);
        if (queryEventStats == null || queryEventStats.isEmpty()) {
            valueOf = Double.valueOf(0.0d);
            d8 = null;
            d9 = null;
            valueOf2 = Double.valueOf(0.0d);
            d10 = null;
        } else {
            Iterator it = queryEventStats.iterator();
            long j9 = Long.MIN_VALUE;
            long j10 = Long.MIN_VALUE;
            long j11 = Long.MAX_VALUE;
            long j12 = 0;
            while (it.hasNext()) {
                EventStats c8 = B.o0.c(it.next());
                eventType = c8.getEventType();
                if (m9 == eventType) {
                    count = c8.getCount();
                    int i8 = m9;
                    j8 += count;
                    totalTime = c8.getTotalTime();
                    j12 += totalTime;
                    lastEventTime = c8.getLastEventTime();
                    if (j9 < lastEventTime) {
                        lastEventTime2 = c8.getLastEventTime();
                        j9 = lastEventTime2;
                    }
                    firstTimeStamp = c8.getFirstTimeStamp();
                    if (j11 > firstTimeStamp) {
                        firstTimeStamp2 = c8.getFirstTimeStamp();
                        j11 = firstTimeStamp2;
                    }
                    lastTimeStamp = c8.getLastTimeStamp();
                    if (j10 < lastTimeStamp) {
                        lastTimeStamp2 = c8.getLastTimeStamp();
                        j10 = lastTimeStamp2;
                    }
                    m9 = i8;
                }
            }
            Double valueOf3 = Double.valueOf(j8);
            double d13 = j12;
            Double l8 = F5.n.l(d13, d13, d13, 1000.0d);
            if (Long.MIN_VALUE != j9) {
                double d14 = j9;
                d11 = F5.n.l(d14, d14, d14, 1000.0d);
            } else {
                d11 = null;
            }
            if (Long.MAX_VALUE != j11) {
                double d15 = j11;
                d8 = F5.n.l(d15, d15, d15, 1000.0d);
            } else {
                d8 = null;
            }
            if (Long.MIN_VALUE != j10) {
                double d16 = j10;
                d12 = F5.n.l(d16, d16, d16, 1000.0d);
            } else {
                d12 = null;
            }
            d10 = d11;
            d9 = d12;
            valueOf = valueOf3;
            valueOf2 = l8;
        }
        q(c1708z0, valueOf, valueOf2, d10, d8, d9);
        return true;
    }
}
