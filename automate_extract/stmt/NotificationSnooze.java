package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AutomateNotificationListenerService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("notification_snooze.html")
@F3.a(C2541R.integer.ic_action_notification_snooze)
@F3.i(C2541R.string.stmt_notification_snooze_title)
@F3.h(C2541R.string.stmt_notification_snooze_summary)
@F3.e(C2541R.layout.stmt_notification_snooze_edit)
/* loaded from: classes.dex */
public class NotificationSnooze extends Action {
    public InterfaceC1700x0 duration;
    public InterfaceC1700x0 key;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 26 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15554o} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_notification_snooze);
        l8.w(1, this.duration);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.key);
        dVar.g(this.duration);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.key);
        visitor.b(this.duration);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.key = (InterfaceC1700x0) cVar.readObject();
        this.duration = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        AutomateNotificationListenerService j8;
        c1708z0.q(C2541R.string.stmt_notification_snooze_title);
        IncapableAndroidVersionException.b(26, "snooze notification");
        long t8 = J3.h.t(c1708z0, this.duration, 3600000L);
        String x7 = J3.h.x(c1708z0, this.key, null);
        if (x7 == null) {
            RunnableC1672u0 runnableC1672u0 = (RunnableC1672u0) c1708z0.c(RunnableC1672u0.class);
            if (runnableC1672u0 != null) {
                j8 = AbstractStatement.j();
                x7 = runnableC1672u0.w2();
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        j8 = AbstractStatement.j();
        j8.snoozeNotification(x7, t8);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
