package com.llamalab.automate.stmt;

import android.content.Context;
import android.telecom.CallScreeningService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("call_screening_response.html")
@F3.a(C2541R.integer.ic_call_missed)
@F3.i(C2541R.string.stmt_call_screening_response_title)
@F3.h(C2541R.string.stmt_call_screening_response_summary)
@F3.e(C2541R.layout.stmt_call_screening_response_edit)
/* loaded from: classes.dex */
public final class CallScreeningResponse extends Action {
    public InterfaceC1700x0 action;
    public InterfaceC1700x0 silence;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.stmt_call_screening_response_title).e(this.action, 0, C2541R.xml.call_screening_responses).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.action);
        dVar.g(this.silence);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.action);
        visitor.b(this.silence);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.action = (InterfaceC1700x0) cVar.readObject();
        this.silence = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_call_screening_response_title);
        C1664q c1664q = (C1664q) c1708z0.c(C1664q.class);
        if (c1664q != null) {
            try {
                CallScreeningService.CallResponse.Builder builder = new CallScreeningService.CallResponse.Builder();
                int m8 = J3.h.m(c1708z0, this.action, 0);
                if (m8 != 0) {
                    if (m8 != 1) {
                        if (m8 != 2) {
                            throw new IllegalArgumentException("action");
                        }
                        builder.setRejectCall(true);
                    }
                    builder.setDisallowCall(true).setSkipNotification(true).setSkipCallLog(true);
                }
                builder.setSilenceCall(J3.h.f(c1708z0, this.silence, false));
                CallScreeningService.CallResponse build = builder.build();
                com.llamalab.automate.X x7 = c1664q.f17498M1;
                if (x7 != null) {
                    x7.f15455b.b(build);
                }
            } finally {
                c1664q.a();
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
