package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.ArrayList;

@F3.f("alarm_add.html")
@F3.a(C2541R.integer.ic_device_access_add_alarm)
@F3.i(C2541R.string.stmt_alarm_add_title)
@F3.h(C2541R.string.stmt_alarm_add_summary)
@F3.e(C2541R.layout.stmt_alarm_add_edit)
/* loaded from: classes.dex */
public class AlarmAdd extends Action {
    public InterfaceC1700x0 label;
    public InterfaceC1700x0 soundUri;
    public InterfaceC1700x0 timeOfDay;
    public InterfaceC1700x0 vibrate;
    public InterfaceC1700x0 weekdays;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("com.android.alarm.permission.SET_ALARM"), com.llamalab.automate.access.c.f15547h} : new E3.b[]{com.llamalab.automate.access.c.j("com.android.alarm.permission.SET_ALARM")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_alarm_add);
        l8.w(2, this.timeOfDay);
        C1596k0 q8 = l8.q(this.timeOfDay);
        q8.v(this.label, 0);
        return q8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.timeOfDay);
        dVar.g(this.weekdays);
        dVar.g(this.label);
        dVar.g(this.soundUri);
        dVar.g(this.vibrate);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.timeOfDay);
        visitor.b(this.weekdays);
        visitor.b(this.label);
        visitor.b(this.soundUri);
        visitor.b(this.vibrate);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.timeOfDay = (InterfaceC1700x0) cVar.readObject();
        this.weekdays = (InterfaceC1700x0) cVar.readObject();
        this.label = (InterfaceC1700x0) cVar.readObject();
        this.soundUri = (InterfaceC1700x0) cVar.readObject();
        this.vibrate = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_alarm_add_title);
        e(c1708z0);
        long e8 = y4.j.e(J3.h.t(c1708z0, this.timeOfDay, 0L), 0L, 86399999L) / 60000;
        int m8 = J3.h.m(c1708z0, this.weekdays, 0) & 127;
        String x7 = J3.h.x(c1708z0, this.label, null);
        String x8 = J3.h.x(c1708z0, this.soundUri, null);
        Intent putExtra = new Intent("android.intent.action.SET_ALARM").addFlags(268697600).putExtra("android.intent.extra.alarm.SKIP_UI", true).putExtra("android.intent.extra.alarm.HOUR", (int) (e8 / 60)).putExtra("android.intent.extra.alarm.MINUTES", (int) (e8 % 60)).putExtra("android.intent.extra.alarm.MESSAGE", x7).putExtra("android.intent.extra.alarm.VIBRATE", J3.h.f(c1708z0, this.vibrate, false));
        if (x8 != null) {
            putExtra.putExtra("android.intent.extra.alarm.RINGTONE", x8);
        }
        if (m8 != 0) {
            ArrayList arrayList = new ArrayList(7);
            for (int i8 = 0; i8 < 7; i8++) {
                if (((1 << i8) & m8) != 0) {
                    arrayList.add(Integer.valueOf(i8 + 1));
                }
            }
            putExtra.putExtra("android.intent.extra.alarm.DAYS", arrayList);
        }
        c1708z0.startActivity(putExtra);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
