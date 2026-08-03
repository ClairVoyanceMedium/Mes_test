package com.llamalab.automate.stmt;

import android.content.Intent;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.NotificationChannelPickActivity;
import com.llamalab.automate.Visitor;

@F3.f("notification_channel_pick.html")
@F3.a(C2541R.integer.ic_notification)
@F3.i(C2541R.string.stmt_notification_channel_pick_title)
@F3.h(C2541R.string.stmt_notification_channel_pick_summary)
@F3.c(C2541R.string.caption_notification_channel_pick)
@F3.e(C2541R.layout.stmt_notification_channel_pick_edit)
/* loaded from: classes.dex */
public final class NotificationChannelPick extends ActivityDecision {
    public J3.l varChannelId;

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varChannelId);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varChannelId);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varChannelId = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varChannelId;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        String stringExtra = intent.getStringExtra("android.app.extra.NOTIFICATION_CHANNEL_ID");
        J3.l lVar2 = this.varChannelId;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, stringExtra);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_notification_channel_pick_title);
        c1708z0.D(new Intent("android.intent.action.PICK", null, c1708z0, NotificationChannelPickActivity.class), null, this, c1708z0.f(C2541R.integer.ic_notification), c1708z0.getText(C2541R.string.stmt_notification_channel_pick_title));
        return false;
    }
}
