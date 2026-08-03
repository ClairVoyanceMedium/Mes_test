package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.KeypadTimePickActivity;
import com.llamalab.automate.RadialTimePickActivity;
import com.llamalab.automate.Visitor;
import java.util.Calendar;

@F3.f("time_pick.html")
@F3.a(C2541R.integer.ic_target_time)
@F3.i(C2541R.string.stmt_time_pick_title)
@F3.h(C2541R.string.stmt_time_pick_summary)
@F3.e(C2541R.layout.stmt_time_pick_edit)
/* loaded from: classes.dex */
public final class TimePick extends ActivityDecision {
    public InterfaceC1700x0 initialTimeOfDay;
    public InterfaceC1700x0 style;
    public InterfaceC1700x0 title;
    public J3.l varTimeOfDay;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_time_pick);
        l8.v(this.varTimeOfDay, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (103 <= dVar.f6413Z) {
            dVar.g(this.title);
        }
        if (62 <= dVar.f6413Z) {
            dVar.g(this.style);
        }
        if (31 <= dVar.f6413Z) {
            dVar.g(this.initialTimeOfDay);
        }
        dVar.g(this.varTimeOfDay);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.title);
        visitor.b(this.style);
        visitor.b(this.initialTimeOfDay);
        visitor.b(this.varTimeOfDay);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (103 <= cVar.f6409x0) {
            this.title = (InterfaceC1700x0) cVar.readObject();
        }
        if (62 <= cVar.f6409x0) {
            this.style = (InterfaceC1700x0) cVar.readObject();
        }
        if (31 <= cVar.f6409x0) {
            this.initialTimeOfDay = (InterfaceC1700x0) cVar.readObject();
        }
        this.varTimeOfDay = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varTimeOfDay;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        int intExtra = intent.getIntExtra("com.llamalab.automate.intent.extra.HOUR_OF_DAY", 0);
        int intExtra2 = intent.getIntExtra("com.llamalab.automate.intent.extra.MINUTE", 0);
        double d8 = intExtra;
        Double.isNaN(d8);
        Double.isNaN(d8);
        double d9 = intExtra2;
        Double.isNaN(d9);
        Double.isNaN(d9);
        Double valueOf = Double.valueOf(((d8 * 60.0d) + d9) * 60.0d);
        J3.l lVar2 = this.varTimeOfDay;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, valueOf);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        CharSequence charSequence;
        int i8;
        int i9;
        c1708z0.q(C2541R.string.stmt_time_pick_title);
        Intent intent = new Intent("android.intent.action.PICK");
        String x7 = J3.h.x(c1708z0, this.title, null);
        if (TextUtils.isEmpty(x7)) {
            charSequence = c1708z0.getText(C2541R.string.stmt_time_pick_title);
        } else {
            intent.putExtra("android.intent.extra.TITLE", (CharSequence) x7);
            charSequence = x7;
        }
        intent.setClass(c1708z0, J3.h.m(c1708z0, this.style, 0) != 1 ? KeypadTimePickActivity.class : RadialTimePickActivity.class);
        Double j8 = J3.h.j(c1708z0, this.initialTimeOfDay);
        if (j8 != null) {
            if (j8.doubleValue() < 86400.0d) {
                int abs = Math.abs(j8.intValue()) / 60;
                i9 = abs % 60;
                i8 = abs / 60;
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis((long) (j8.doubleValue() * 1000.0d));
                i8 = calendar.get(11);
                i9 = calendar.get(12);
            }
            intent.putExtra("com.llamalab.automate.intent.extra.HOUR_OF_DAY", i8).putExtra("com.llamalab.automate.intent.extra.MINUTE", i9);
        }
        c1708z0.D(intent, null, this, c1708z0.f(C2541R.integer.ic_target_time), charSequence);
        return false;
    }
}
