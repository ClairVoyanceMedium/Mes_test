package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;
import x3.C2425c;

@F3.f("time_window.html")
@F3.a(C2541R.integer.ic_device_access_time_window)
@F3.i(C2541R.string.stmt_time_window_title)
@F3.h(C2541R.string.stmt_time_window_summary)
@F3.e(C2541R.layout.stmt_time_window_edit)
/* loaded from: classes.dex */
public class TimeWindow extends IntermittentDecision implements IntentStatement, AsyncStatement, InterfaceC1622q2 {

    /* renamed from: L1, reason: collision with root package name */
    public int f17201L1 = -1;

    /* renamed from: M1, reason: collision with root package name */
    public int f17202M1 = -1;
    public InterfaceC1700x0 dayOfMonth;
    public InterfaceC1700x0 duration;
    public InterfaceC1700x0 months;
    public InterfaceC1700x0 timeOfDay;
    public InterfaceC1700x0 timeZone;
    public InterfaceC1700x0 timestamp;
    public InterfaceC1700x0 wakeup;
    public InterfaceC1700x0 weekdays;
    public InterfaceC1700x0 year;

    public final void B(C1708z0 c1708z0) {
        boolean z7;
        if (((Long) c1708z0.j(this.f17201L1)) != null) {
            c1708z0.z(this.f17201L1, null);
            z7 = true;
        } else {
            c1708z0.z(this.f17202M1, null);
            z7 = false;
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final void C1(C1708z0 c1708z0) {
        AbstractStatement.d(c1708z0, this, "com.llamalab.automate.intent.action.TIME_WINDOW");
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return (31 > Build.VERSION.SDK_INT || 2 != J1(2)) ? com.llamalab.automate.access.c.f15562w : new E3.b[]{com.llamalab.automate.access.c.f15557r};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        if (this.timestamp != null) {
            c1596k0.B(C2541R.string.caption_time_window_timestamp);
        } else {
            c1596k0.j(this, 2, C2541R.string.caption_time_window_immediate, C2541R.string.caption_time_window_inexact, C2541R.string.caption_time_window_exact);
        }
        c1596k0.w(2, this.timeOfDay);
        C1596k0 q8 = c1596k0.q(this.timeOfDay);
        q8.w(1, this.duration);
        return q8.z(this.wakeup, true, C2541R.string.caption_wakeup, 0).f16030c;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        B(c1708z0);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.wakeup);
        dVar.g(this.timestamp);
        dVar.g(this.timeZone);
        dVar.g(this.timeOfDay);
        dVar.g(this.duration);
        dVar.g(this.weekdays);
        dVar.g(this.dayOfMonth);
        dVar.g(this.months);
        dVar.g(this.year);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.wakeup);
        visitor.b(this.timestamp);
        visitor.b(this.timeZone);
        visitor.b(this.timeOfDay);
        visitor.b(this.duration);
        visitor.b(this.weekdays);
        visitor.b(this.dayOfMonth);
        visitor.b(this.months);
        visitor.b(this.year);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f17201L1 = c1625r2.d(false);
        this.f17202M1 = c1625r2.d(false);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new o1();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.wakeup = (InterfaceC1700x0) cVar.readObject();
        this.timestamp = (InterfaceC1700x0) cVar.readObject();
        this.timeZone = (InterfaceC1700x0) cVar.readObject();
        this.timeOfDay = (InterfaceC1700x0) cVar.readObject();
        this.duration = (InterfaceC1700x0) cVar.readObject();
        this.weekdays = (InterfaceC1700x0) cVar.readObject();
        this.dayOfMonth = (InterfaceC1700x0) cVar.readObject();
        this.months = (InterfaceC1700x0) cVar.readObject();
        this.year = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        long j8;
        long j9;
        long longValue;
        long j10;
        c1708z0.q(C2541R.string.stmt_time_window_title);
        InterfaceC1700x0 interfaceC1700x0 = this.timeZone;
        Pattern pattern = J3.h.f4650a;
        Calendar calendar = Calendar.getInstance(J3.h.z(c1708z0, interfaceC1700x0, c1708z0.o()));
        calendar.setTimeInMillis(c1708z0.b());
        int m8 = J3.h.m(c1708z0, this.year, -1);
        int m9 = J3.h.m(c1708z0, this.months, MoreOsConstants.IN_ALL_EVENTS) & MoreOsConstants.IN_ALL_EVENTS;
        int m10 = J3.h.m(c1708z0, this.dayOfMonth, -1);
        boolean z7 = false;
        int m11 = J3.h.m(c1708z0, this.weekdays, 0) & 127;
        long e8 = y4.j.e(J3.h.t(c1708z0, this.timeOfDay, 0L), 0L, 86399999L);
        long t8 = J3.h.t(c1708z0, this.duration, -1L);
        int J12 = J1(2);
        if (J12 == 0) {
            long t9 = J3.h.t(c1708z0, this.timestamp, calendar.getTimeInMillis());
            calendar.setTimeInMillis(t9);
            Calendar v8 = H1.b.v(calendar, -1, m8, m9, m10, m11, e8);
            if (v8 == null) {
                o(c1708z0, false);
                return true;
            }
            long timeInMillis = v8.getTimeInMillis();
            long j11 = t8 > 0 ? t8 + timeInMillis : (timeInMillis - e8) + 86400000;
            if (t9 >= timeInMillis && t9 < j11) {
                z7 = true;
            }
            o(c1708z0, z7);
            return true;
        }
        int i8 = !J3.h.f(c1708z0, this.wakeup, true) ? 1 : 0;
        boolean z8 = 2 == J12;
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        Long l8 = (Long) c1708z0.j(this.f17201L1);
        Long l9 = (Long) c1708z0.j(this.f17202M1);
        if (l8 != null) {
            if (a8) {
                c1708z0.p(String.format(Locale.US, "Reset start of window alarm at %Tc", l8));
            }
            j8 = l8.longValue();
            j9 = l9.longValue() - l8.longValue();
        } else {
            if (l9 != null) {
                if (a8) {
                    c1708z0.p(String.format(Locale.US, "Reset end of window alarm at %Tc", l9));
                }
                longValue = l9.longValue();
                j10 = 0;
                AbstractStatement.m(c1708z0, i8, z8, longValue, j10, "com.llamalab.automate.intent.action.TIME_WINDOW", null);
                return false;
            }
            Calendar v9 = H1.b.v(calendar, 1, m8, m9, m10, m11, e8);
            if (v9 == null) {
                throw new IllegalStateException("Start time not found");
            }
            Long valueOf = Long.valueOf(v9.getTimeInMillis());
            Long valueOf2 = Long.valueOf(t8 > 0 ? valueOf.longValue() + t8 : (valueOf.longValue() - e8) + 86400000);
            c1708z0.z(this.f17201L1, valueOf);
            c1708z0.z(this.f17202M1, valueOf2);
            if (a8) {
                c1708z0.p(String.format(Locale.US, "Set start of window alarm %Tc, ending at %Tc", valueOf, valueOf2));
            }
            long longValue2 = valueOf.longValue();
            long longValue3 = valueOf2.longValue() - valueOf.longValue();
            j8 = longValue2;
            j9 = longValue3;
        }
        longValue = j8;
        j10 = j9;
        AbstractStatement.m(c1708z0, i8, z8, longValue, j10, "com.llamalab.automate.intent.action.TIME_WINDOW", null);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        B(c1708z0);
        return true;
    }
}
