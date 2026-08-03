package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("process_text_result.html")
@F3.a(C2541R.integer.ic_action_process_text)
@F3.i(C2541R.string.stmt_process_text_result_title)
@F3.h(C2541R.string.stmt_process_text_result_summary)
@F3.e(C2541R.layout.stmt_process_text_result_edit)
/* loaded from: classes.dex */
public final class ProcessTextResult extends Action {
    public InterfaceC1700x0 replacementText;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_process_text_result);
        l8.v(this.replacementText, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.replacementText);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.replacementText);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.replacementText = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_process_text_result_title);
        K0 k02 = (K0) c1708z0.c(K0.class);
        if (k02 != null) {
            try {
                String str = k02.f16830L1;
                String x7 = J3.h.x(c1708z0, this.replacementText, str);
                if (!x7.equals(str)) {
                    k02.v2(new Intent().putExtra("android.intent.extra.PROCESS_TEXT", x7));
                }
            } finally {
                k02.a();
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
