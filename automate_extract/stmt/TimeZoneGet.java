package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import java.util.TimeZone;

@F3.f("time_zone_get.html")
@F3.a(C2541R.integer.ic_device_access_time_zone)
@F3.i(C2541R.string.stmt_time_zone_get_title)
@F3.h(C2541R.string.stmt_time_zone_get_summary)
@F3.e(C2541R.layout.stmt_time_zone_get_edit)
/* loaded from: classes.dex */
public final class TimeZoneGet extends IntermittentAction implements ReceiverStatement {
    public J3.l varTimezoneId;
    public J3.l varTimezoneOffset;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_time_zone_get_immediate, C2541R.string.caption_time_zone_get_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        String stringExtra = intent.getStringExtra("time-zone");
        s(c1708z0, stringExtra != null ? TimeZone.getTimeZone(stringExtra) : TimeZone.getDefault());
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varTimezoneId);
        if (109 <= dVar.f6413Z) {
            dVar.g(this.varTimezoneOffset);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.varTimezoneId);
        visitor.b(this.varTimezoneOffset);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varTimezoneId = (J3.l) cVar.readObject();
        if (109 <= cVar.f6409x0) {
            this.varTimezoneOffset = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_time_zone_get_title);
        if (J1(1) == 0) {
            s(c1708z0, TimeZone.getDefault());
            return true;
        }
        AbstractC1618p2.c cVar = new AbstractC1618p2.c();
        c1708z0.w(cVar);
        cVar.h("android.intent.action.TIMEZONE_CHANGED");
        return false;
    }

    public final void s(C1708z0 c1708z0, TimeZone timeZone) {
        J3.l lVar = this.varTimezoneId;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, timeZone.getID());
        }
        J3.l lVar2 = this.varTimezoneOffset;
        if (lVar2 != null) {
            double offset = timeZone.getOffset(System.currentTimeMillis());
            c1708z0.z(lVar2.f4659Y, F5.n.l(offset, offset, offset, 1000.0d));
        }
        c1708z0.f17642x0 = this.onComplete;
    }
}
