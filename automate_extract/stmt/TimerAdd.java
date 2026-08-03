package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("timer_add.html")
@F3.a(C2541R.integer.ic_device_access_add_timer)
@F3.i(C2541R.string.stmt_timer_add_title)
@F3.h(C2541R.string.stmt_timer_add_summary)
@F3.e(C2541R.layout.stmt_timer_add_edit)
/* loaded from: classes.dex */
public final class TimerAdd extends Action {
    public InterfaceC1700x0 duration;
    public InterfaceC1700x0 label;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("com.android.alarm.permission.SET_ALARM"), com.llamalab.automate.access.c.f15547h} : new E3.b[]{com.llamalab.automate.access.c.j("com.android.alarm.permission.SET_ALARM")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_timer_add);
        l8.w(1, this.duration);
        C1596k0 q8 = l8.q(this.duration);
        q8.v(this.label, 0);
        return q8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.duration);
        dVar.g(this.label);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.duration);
        visitor.b(this.label);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.duration = (InterfaceC1700x0) cVar.readObject();
        this.label = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_timer_add_title);
        e(c1708z0);
        int m8 = J3.h.m(c1708z0, this.duration, 600);
        c1708z0.startActivity(new Intent("android.intent.action.SET_TIMER").addFlags(268697600).putExtra("android.intent.extra.alarm.SKIP_UI", true).putExtra("android.intent.extra.alarm.LENGTH", Math.max(0, m8)).putExtra("android.intent.extra.alarm.MESSAGE", J3.h.x(c1708z0, this.label, null)));
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
