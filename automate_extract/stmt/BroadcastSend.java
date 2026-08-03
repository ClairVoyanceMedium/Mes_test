package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;

@F3.f("broadcast_send.html")
@F3.a(C2541R.integer.ic_app_broadcast)
@F3.i(C2541R.string.stmt_broadcast_send_title)
@F3.h(C2541R.string.stmt_broadcast_send_summary)
@F3.e(C2541R.layout.stmt_broadcast_send_edit)
/* loaded from: classes.dex */
public class BroadcastSend extends IntentAction {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_broadcast_send).o(-1, this.action).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        s(dVar, 45);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return ViewOnClickListenerC1667s.w(null, 2);
    }

    @Override // com.llamalab.automate.stmt.IntentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        r(cVar, 45);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_broadcast_send_title);
        c1708z0.sendBroadcast(q(1342177495, c1708z0, false));
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
