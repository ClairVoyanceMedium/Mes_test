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
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;
import x3.C2425c;

@F3.f("time_await.html")
@F3.a(C2541R.integer.ic_device_access_time)
@F3.i(C2541R.string.stmt_time_await_title)
@F3.h(C2541R.string.stmt_time_await_summary)
@F3.e(C2541R.layout.stmt_time_await_edit)
/* loaded from: classes.dex */
public class TimeAwait extends IntermittentAction implements IntentStatement, AsyncStatement, InterfaceC1622q2 {

    /* renamed from: L1, reason: collision with root package name */
    public int f17200L1 = -1;
    public InterfaceC1700x0 dayOfMonth;
    public InterfaceC1700x0 months;
    public InterfaceC1700x0 timeOfDay;
    public InterfaceC1700x0 timeZone;
    public InterfaceC1700x0 wakeup;
    public InterfaceC1700x0 weekdays;
    public InterfaceC1700x0 year;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final void C1(C1708z0 c1708z0) {
        AbstractStatement.d(c1708z0, this, "com.llamalab.automate.intent.action.TIME_AWAIT");
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return (31 > Build.VERSION.SDK_INT || 2 != J1(2)) ? com.llamalab.automate.access.c.f15562w : new E3.b[]{com.llamalab.automate.access.c.f15557r};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 2, C2541R.string.caption_time_await_inexact, C2541R.string.caption_time_await_exact);
        c1596k0.w(2, this.timeOfDay);
        return c1596k0.q(this.timeOfDay).z(this.wakeup, true, C2541R.string.caption_wakeup, 0).f16030c;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        c1708z0.z(this.f17200L1, null);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.wakeup);
        dVar.g(this.timeZone);
        dVar.g(this.timeOfDay);
        dVar.g(this.weekdays);
        dVar.g(this.dayOfMonth);
        dVar.g(this.months);
        dVar.g(this.year);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.wakeup);
        visitor.b(this.timeZone);
        visitor.b(this.timeOfDay);
        visitor.b(this.weekdays);
        visitor.b(this.dayOfMonth);
        visitor.b(this.months);
        visitor.b(this.year);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f17200L1 = c1625r2.d(false);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.wakeup = (InterfaceC1700x0) cVar.readObject();
        this.timeZone = (InterfaceC1700x0) cVar.readObject();
        this.timeOfDay = (InterfaceC1700x0) cVar.readObject();
        this.weekdays = (InterfaceC1700x0) cVar.readObject();
        this.dayOfMonth = (InterfaceC1700x0) cVar.readObject();
        this.months = (InterfaceC1700x0) cVar.readObject();
        this.year = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_time_await_title);
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        InterfaceC1700x0 interfaceC1700x0 = this.timeZone;
        Pattern pattern = J3.h.f4650a;
        Calendar calendar = Calendar.getInstance(J3.h.z(c1708z0, interfaceC1700x0, c1708z0.o()));
        calendar.setTimeInMillis(c1708z0.b());
        int m8 = J3.h.m(c1708z0, this.year, -1);
        int m9 = 4095 & J3.h.m(c1708z0, this.months, MoreOsConstants.IN_ALL_EVENTS);
        int m10 = J3.h.m(c1708z0, this.dayOfMonth, -1);
        int m11 = J3.h.m(c1708z0, this.weekdays, 0) & 127;
        long e8 = y4.j.e(J3.h.t(c1708z0, this.timeOfDay, 0L), 0L, 86399999L);
        int i8 = !J3.h.f(c1708z0, this.wakeup, true) ? 1 : 0;
        boolean z7 = 2 == J1(2);
        Long l8 = (Long) c1708z0.j(this.f17200L1);
        if (l8 == null) {
            Calendar v8 = H1.b.v(calendar, 1, m8, m9, m10, m11, e8);
            if (v8 == null) {
                throw new IllegalStateException("Start time not found");
            }
            l8 = Long.valueOf(v8.getTimeInMillis());
            c1708z0.z(this.f17200L1, l8);
        }
        if (a8) {
            c1708z0.p(String.format(Locale.US, "TimeAwait Next alarm set for %tc, exact=%b, type=%d", l8, Boolean.valueOf(z7), Integer.valueOf(i8)));
        }
        AbstractStatement.m(c1708z0, i8, z7, l8.longValue(), 0L, "com.llamalab.automate.intent.action.TIME_AWAIT", null);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.z(this.f17200L1, null);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
