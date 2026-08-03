package com.llamalab.automate.stmt;

import android.content.Intent;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.SubscriptionPickActivity;
import com.llamalab.automate.Visitor;

@F3.f("subscription_pick.html")
@F3.a(C2541R.integer.ic_simcard_select)
@F3.i(C2541R.string.stmt_subscription_pick_title)
@F3.h(C2541R.string.stmt_subscription_pick_summary)
@F3.e(C2541R.layout.stmt_subscription_pick_edit)
/* loaded from: classes.dex */
public final class SubscriptionPick extends ActivityDecision {
    public J3.l varSimSlotIndex;
    public J3.l varSubscriptionId;

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varSimSlotIndex);
        dVar.g(this.varSubscriptionId);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varSimSlotIndex);
        visitor.b(this.varSubscriptionId);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varSimSlotIndex = (J3.l) cVar.readObject();
        this.varSubscriptionId = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varSimSlotIndex;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            J3.l lVar2 = this.varSubscriptionId;
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        int intExtra = intent.getIntExtra("com.llamalab.automate.intent.extra.SIM_SLOT_INDEX", -1);
        int intExtra2 = intent.getIntExtra("com.llamalab.automate.intent.extra.SUBSCRIPTION_ID", -1);
        Double valueOf = intExtra != -1 ? Double.valueOf(intExtra) : null;
        Double valueOf2 = intExtra2 != -1 ? Double.valueOf(intExtra2) : null;
        J3.l lVar3 = this.varSimSlotIndex;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, valueOf);
        }
        J3.l lVar4 = this.varSubscriptionId;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, valueOf2);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_subscription_pick_title);
        c1708z0.D(new Intent("android.intent.action.PICK", null, c1708z0, SubscriptionPickActivity.class), null, this, c1708z0.f(C2541R.integer.ic_simcard_select), c1708z0.getText(C2541R.string.stmt_subscription_pick_title));
        return false;
    }
}
