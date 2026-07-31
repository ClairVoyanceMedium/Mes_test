package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("delay.html")
@F3.a(C2541R.integer.ic_tab_timer)
@F3.i(C2541R.string.stmt_delay_title)
@F3.h(C2541R.string.stmt_delay_summary)
@F3.e(C2541R.layout.stmt_delay_edit)
/* loaded from: classes.dex */
public final class Delay extends IntermittentAction implements IntentStatement, AsyncStatement, InterfaceC1622q2 {

    /* renamed from: L1, reason: collision with root package name */
    public int f16554L1 = -1;
    public InterfaceC1700x0 duration;
    public InterfaceC1700x0 wakeup;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final void C1(C1708z0 c1708z0) {
        AbstractStatement.d(c1708z0, this, "com.llamalab.automate.intent.action.DELAY");
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return (31 > Build.VERSION.SDK_INT || 1 != J1(1)) ? com.llamalab.automate.access.c.f15562w : new E3.b[]{com.llamalab.automate.access.c.f15557r};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_delay_inexact, C2541R.string.caption_delay_exact);
        c1596k0.w(1, this.duration);
        return c1596k0.z(this.wakeup, true, C2541R.string.caption_wakeup, 0).f16030c;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        c1708z0.z(this.f16554L1, null);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.wakeup);
        dVar.g(this.duration);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.wakeup);
        visitor.b(this.duration);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f16554L1 = c1625r2.d(false);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.wakeup = (InterfaceC1700x0) cVar.readObject();
        this.duration = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_delay_title);
        Long l8 = (Long) c1708z0.j(this.f16554L1);
        if (l8 == null) {
            long t8 = J3.h.t(c1708z0, this.duration, 0L);
            if (t8 <= 0) {
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
            l8 = Long.valueOf(System.currentTimeMillis() + t8);
            c1708z0.z(this.f16554L1, l8);
        }
        AbstractStatement.m(c1708z0, !J3.h.f(c1708z0, this.wakeup, true) ? 1 : 0, 1 == J1(1), l8.longValue(), 0L, "com.llamalab.automate.intent.action.DELAY", null);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.z(this.f16554L1, null);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
