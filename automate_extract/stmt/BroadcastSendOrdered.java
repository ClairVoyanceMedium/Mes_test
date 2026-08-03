package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("broadcast_send_ordered.html")
@F3.a(C2541R.integer.ic_app_broadcast)
@F3.i(C2541R.string.stmt_broadcast_send_ordered_title)
@F3.h(C2541R.string.stmt_broadcast_send_ordered_summary)
@F3.e(C2541R.layout.stmt_broadcast_send_ordered_edit)
/* loaded from: classes.dex */
public class BroadcastSendOrdered extends IntentDecision implements ReceiverStatement {
    public J3.l varResultCode;
    public J3.l varResultData;
    public J3.l varResultExtras;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_broadcast_send_ordered).o(-1, this.action).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        int resultCode = abstractC1618p2.getResultCode();
        J3.l lVar = this.varResultCode;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, Double.valueOf(resultCode));
        }
        J3.l lVar2 = this.varResultData;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, abstractC1618p2.getResultData());
        }
        if (this.varResultExtras != null) {
            Bundle resultExtras = abstractC1618p2.getResultExtras(false);
            c1708z0.z(this.varResultExtras.f4659Y, resultExtras != null ? J3.h.O(0, resultExtras) : null);
        }
        o(c1708z0, -1 == resultCode);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varResultCode);
        dVar.g(this.varResultData);
        dVar.g(this.varResultExtras);
    }

    @Override // com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varResultCode);
        visitor.b(this.varResultData);
        visitor.b(this.varResultExtras);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return ViewOnClickListenerC1667s.w(null, 2);
    }

    @Override // com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varResultCode = (J3.l) cVar.readObject();
        this.varResultData = (J3.l) cVar.readObject();
        this.varResultExtras = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_broadcast_send_ordered_title);
        Intent w8 = w(1476395223, c1708z0, false);
        AbstractC1618p2.c cVar = new AbstractC1618p2.c();
        c1708z0.w(cVar);
        c1708z0.sendOrderedBroadcast(w8, null, cVar, c1708z0.j2().f14581L1, -1, null, null);
        return false;
    }
}
