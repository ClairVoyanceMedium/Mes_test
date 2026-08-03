package com.llamalab.automate.stmt;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.util.Log;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import x3.C2440r;

@F3.f("alarm.html")
@F3.a(C2541R.integer.ic_device_access_alarms)
@F3.i(C2541R.string.stmt_alarm_title)
@F3.h(C2541R.string.stmt_alarm_summary)
@F3.e(C2541R.layout.stmt_alarm_edit)
/* loaded from: classes.dex */
public final class Alarm extends IntermittentDecision implements ReceiverStatement, AsyncStatement, IntentStatement {
    public J3.l varAlarmTimestamp;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public Long f16239x1;

        public a(Long l8) {
            this.f16239x1 = l8;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            h(21 <= Build.VERSION.SDK_INT ? "android.app.action.NEXT_ALARM_CLOCK_CHANGED" : "android.intent.action.ALARM_CHANGED");
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            try {
                Long D7 = Alarm.D(context);
                if (C2440r.h(this.f16239x1, D7)) {
                    return;
                }
                this.f16239x1 = D7;
                c(intent, D7, true);
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public static Long D(Context context) {
        AlarmManager.AlarmClockInfo nextAlarmClock;
        long triggerTime;
        if (21 <= Build.VERSION.SDK_INT) {
            nextAlarmClock = ((AlarmManager) context.getSystemService("alarm")).getNextAlarmClock();
            if (nextAlarmClock == null) {
                return null;
            }
            triggerTime = nextAlarmClock.getTriggerTime();
            return Long.valueOf(triggerTime);
        }
        String string = Settings.System.getString(context.getContentResolver(), "next_alarm_formatted");
        if (string != null && !string.isEmpty()) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormat.is24HourFormat(context) ? "E k:mm" : "E h:mm aa");
                simpleDateFormat.parse(string);
                Calendar calendar = simpleDateFormat.getCalendar();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(7, calendar.get(7));
                calendar2.set(11, calendar.get(11));
                calendar2.set(12, calendar.get(12));
                calendar2.set(13, 0);
                calendar2.set(14, 0);
                if (calendar2.before(Calendar.getInstance())) {
                    calendar2.add(5, 7);
                }
                return Long.valueOf(calendar2.getTimeInMillis());
            } catch (ParseException e8) {
                Log.w("Alarm", "Illegal next_alarm_formatted: ".concat(string), e8);
            }
        }
        return null;
    }

    public static boolean E(Long l8) {
        return l8 != null && l8.longValue() > System.currentTimeMillis();
    }

    public final void B(C1708z0 c1708z0, boolean z7, Long l8) {
        Double d8;
        J3.l lVar = this.varAlarmTimestamp;
        if (lVar != null) {
            if (l8 != null) {
                double longValue = l8.longValue();
                d8 = F5.n.l(longValue, longValue, longValue, 1000.0d);
            } else {
                d8 = null;
            }
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, z7);
    }

    public final void C(C1708z0 c1708z0, Bundle bundle) {
        a aVar;
        if (J1(1) != 0 && (aVar = (a) c1708z0.c(a.class)) != null) {
            F5.n.i(aVar, 500L);
        }
        B(c1708z0, true, Long.valueOf(bundle.getLong("com.llamalab.automate.intent.extra.ALARM_MILLIS", c1708z0.b())));
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final void C1(C1708z0 c1708z0) {
        if (2 == J1(1)) {
            AbstractStatement.d(c1708z0, this, "com.llamalab.automate.intent.action.ALARM_TRIGGER");
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 31 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15557r} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_alarm_immediate, C2541R.string.caption_alarm_change, C2541R.string.caption_alarm_trigger);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        C(c1708z0, intent.getExtras());
        return true;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Long l8 = (Long) obj;
        int J12 = J1(1);
        if (J12 != 0) {
            if (J12 != 2) {
                F5.n.i(abstractC1618p2, 500L);
                B(c1708z0, l8 != null, l8);
                return true;
            }
            if (l8 == null) {
                F5.n.i(abstractC1618p2, 500L);
                AbstractStatement.d(c1708z0, this, "com.llamalab.automate.intent.action.ALARM_TRIGGER");
                B(c1708z0, false, null);
                return true;
            }
            if (E(l8)) {
                long longValue = l8.longValue();
                Bundle bundle = new Bundle();
                bundle.putLong("com.llamalab.automate.intent.extra.ALARM_MILLIS", longValue);
                AbstractStatement.m(c1708z0, 0, true, longValue, 0L, "com.llamalab.automate.intent.action.ALARM_TRIGGER", bundle);
            } else {
                AbstractStatement.d(c1708z0, this, "com.llamalab.automate.intent.action.ALARM_TRIGGER");
            }
        }
        return false;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varAlarmTimestamp);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varAlarmTimestamp);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varAlarmTimestamp = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_alarm_title);
        Long D7 = D(c1708z0);
        int J12 = J1(1);
        if (J12 == 0) {
            if (E(D7)) {
                B(c1708z0, true, D7);
                return true;
            }
            B(c1708z0, false, null);
            return true;
        }
        if (J12 == 2 && E(D7)) {
            long longValue = D7.longValue();
            Bundle bundle = new Bundle();
            bundle.putLong("com.llamalab.automate.intent.extra.ALARM_MILLIS", longValue);
            AbstractStatement.m(c1708z0, 0, true, longValue, 0L, "com.llamalab.automate.intent.action.ALARM_TRIGGER", bundle);
        }
        a aVar = (a) c1708z0.c(a.class);
        if (aVar != null) {
            F5.n.h(aVar);
        } else {
            c1708z0.w(new a(D7));
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        C(c1708z0, (Bundle) obj);
        return true;
    }
}
