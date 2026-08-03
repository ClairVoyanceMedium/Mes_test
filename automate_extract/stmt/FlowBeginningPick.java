package com.llamalab.automate.stmt;

import android.content.Intent;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.FlowBeginningPickActivity;
import com.llamalab.automate.Visitor;

@F3.f("flow_beginning_pick.html")
@F3.a(C2541R.integer.ic_gear_select)
@F3.i(C2541R.string.stmt_flow_beginning_pick_title)
@F3.h(C2541R.string.stmt_flow_beginning_pick_summary)
@F3.c(C2541R.string.caption_flow_beginning_pick)
@F3.e(C2541R.layout.stmt_flow_beginning_pick_edit)
/* loaded from: classes.dex */
public class FlowBeginningPick extends FlowPickDecision {
    public J3.l varBeginningTitle;

    @Override // com.llamalab.automate.stmt.FlowPickDecision, com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (43 <= dVar.f6413Z) {
            dVar.g(this.varBeginningTitle);
        }
    }

    @Override // com.llamalab.automate.stmt.FlowPickDecision, com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varBeginningTitle);
    }

    @Override // com.llamalab.automate.stmt.FlowPickDecision, com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (43 <= cVar.f6409x0) {
            this.varBeginningTitle = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varBeginningTitle;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            C(c1708z0, false, null, null, null);
            return;
        }
        String dataString = intent.getDataString();
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TITLE");
        CharSequence charSequenceExtra2 = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        CharSequence charSequenceExtra3 = intent.getCharSequenceExtra("com.llamalab.automate.intent.extra.EXTRA_BEGINNING_TITLE");
        J3.l lVar2 = this.varBeginningTitle;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, charSequenceExtra3 != null ? charSequenceExtra3.toString() : null);
        }
        C(c1708z0, true, dataString, charSequenceExtra, charSequenceExtra2);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_flow_beginning_pick_title);
        c1708z0.D(new Intent(c1708z0, (Class<?>) FlowBeginningPickActivity.class), null, this, c1708z0.f(C2541R.integer.ic_gear_select), c1708z0.getText(C2541R.string.stmt_flow_beginning_pick_title));
        return false;
    }
}
