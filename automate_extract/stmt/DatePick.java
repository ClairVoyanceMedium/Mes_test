package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.CalendarDatePickActivity;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.KeypadDatePickActivity;
import com.llamalab.automate.Visitor;
import java.util.Calendar;

@F3.f("date_pick.html")
@F3.a(C2541R.integer.ic_collections_go_to_today)
@F3.i(C2541R.string.stmt_date_pick_title)
@F3.h(C2541R.string.stmt_date_pick_summary)
@F3.e(C2541R.layout.stmt_date_pick_edit)
/* loaded from: classes.dex */
public final class DatePick extends ActivityDecision {
    public InterfaceC1700x0 initialTimestamp;
    public InterfaceC1700x0 style;
    public InterfaceC1700x0 title;
    public J3.l varTimestamp;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_date_pick);
        l8.v(this.varTimestamp, 0);
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
            dVar.g(this.initialTimestamp);
        }
        dVar.g(this.varTimestamp);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.title);
        visitor.b(this.style);
        visitor.b(this.initialTimestamp);
        visitor.b(this.varTimestamp);
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
            this.initialTimestamp = (InterfaceC1700x0) cVar.readObject();
        }
        this.varTimestamp = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varTimestamp;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1, intent.getIntExtra("com.llamalab.automate.intent.extra.YEAR", 0));
        calendar.set(2, intent.getIntExtra("com.llamalab.automate.intent.extra.MONTH", 0));
        calendar.set(5, intent.getIntExtra("com.llamalab.automate.intent.extra.DAY_OF_MONTH", 0));
        double timeInMillis = calendar.getTimeInMillis();
        Double l8 = F5.n.l(timeInMillis, timeInMillis, timeInMillis, 1000.0d);
        J3.l lVar2 = this.varTimestamp;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, l8);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        CharSequence charSequence;
        c1708z0.q(C2541R.string.stmt_date_pick_title);
        Intent intent = new Intent("android.intent.action.PICK");
        String x7 = J3.h.x(c1708z0, this.title, null);
        if (TextUtils.isEmpty(x7)) {
            charSequence = c1708z0.getText(C2541R.string.stmt_date_pick_title);
        } else {
            intent.putExtra("android.intent.extra.TITLE", (CharSequence) x7);
            charSequence = x7;
        }
        intent.setClass(c1708z0, J3.h.m(c1708z0, this.style, 0) != 1 ? KeypadDatePickActivity.class : CalendarDatePickActivity.class);
        Double j8 = J3.h.j(c1708z0, this.initialTimestamp);
        if (j8 != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis((long) (j8.doubleValue() * 1000.0d));
            intent.putExtra("com.llamalab.automate.intent.extra.YEAR", calendar.get(1)).putExtra("com.llamalab.automate.intent.extra.MONTH", calendar.get(2)).putExtra("com.llamalab.automate.intent.extra.DAY_OF_MONTH", calendar.get(5));
        }
        c1708z0.D(intent, null, this, c1708z0.f(C2541R.integer.ic_collections_go_to_today), charSequence);
        return false;
    }
}
