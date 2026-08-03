package com.llamalab.automate.stmt;

import android.content.Intent;
import com.llamalab.automate.C1701x1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.Visitor;

@F3.f("google_assistant_action.html")
@F3.a(C2541R.integer.ic_voice_search)
@F3.i(C2541R.string.stmt_gassistant_action_title)
@F3.h(C2541R.string.stmt_gassistant_action_summary)
@F3.e(C2541R.layout.stmt_gassistant_action_edit)
/* loaded from: classes.dex */
public final class GoogleAssistantAction extends Action implements IntentStatement {
    public J3.l varSpokenText;

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        c1708z0.H(C1701x1.class);
        String stringExtra = ((Intent) intent.getParcelableExtra("android.intent.extra.INTENT")).getStringExtra("android.intent.extra.TEXT");
        J3.l lVar = this.varSpokenText;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, stringExtra);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varSpokenText);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.varSpokenText);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varSpokenText = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_gassistant_action_title);
        C1701x1 c1701x1 = new C1701x1(C1701x1.s(c1708z0, "com.llamalab.automate.intent.action.GOOGLE_ASSISTANT_ACTION", null));
        c1708z0.w(c1701x1);
        c1701x1.o(4, "com.llamalab.automate.intent.action.GOOGLE_ASSISTANT_ACTION_ANNOUNCE");
        return false;
    }
}
