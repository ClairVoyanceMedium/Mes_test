package com.llamalab.automate.stmt;

import android.content.Intent;
import android.provider.CalendarContract;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.CalendarPickActivity;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("calendar_pick.html")
@F3.a(C2541R.integer.ic_content_calendar_select)
@F3.i(C2541R.string.stmt_calendar_pick_title)
@F3.h(C2541R.string.stmt_calendar_pick_summary)
@F3.c(C2541R.string.caption_calendar_pick)
@F3.e(C2541R.layout.stmt_calendar_pick_edit)
/* loaded from: classes.dex */
public final class CalendarPick extends ActivityDecision {
    public InterfaceC1700x0 hidden;
    public J3.l varCalendarUri;
    public InterfaceC1700x0 writable;

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.writable);
        if (66 <= dVar.f6413Z) {
            dVar.g(this.hidden);
        }
        dVar.g(this.varCalendarUri);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.writable);
        visitor.b(this.hidden);
        visitor.b(this.varCalendarUri);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.writable = (InterfaceC1700x0) cVar.readObject();
        if (66 <= cVar.f6409x0) {
            this.hidden = (InterfaceC1700x0) cVar.readObject();
        }
        this.varCalendarUri = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varCalendarUri;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        String dataString = intent.getDataString();
        J3.l lVar2 = this.varCalendarUri;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, dataString);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_calendar_pick_title);
        boolean f8 = J3.h.f(c1708z0, this.writable, true);
        c1708z0.D(new Intent("android.intent.action.PICK", CalendarContract.Calendars.CONTENT_URI, c1708z0, CalendarPickActivity.class).putExtra("com.llamalab.automate.intent.extra.WRITABLE", f8).putExtra("com.llamalab.automate.intent.extra.HIDDEN", J3.h.f(c1708z0, this.hidden, false)), null, this, c1708z0.f(C2541R.integer.ic_content_calendar_select), c1708z0.getText(C2541R.string.stmt_calendar_pick_title));
        return false;
    }
}
