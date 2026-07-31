package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("log_append.html")
@F3.a(C2541R.integer.ic_log_scroll)
@F3.i(C2541R.string.stmt_log_append_title)
@F3.h(C2541R.string.stmt_log_append_summary)
@F3.e(C2541R.layout.stmt_log_append_edit)
/* loaded from: classes.dex */
public final class LogAppend extends Action {
    public InterfaceC1700x0 message;
    public InterfaceC1700x0 whenLogging;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_log_append);
        l8.v(this.message, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.message);
        if (36 <= dVar.f6413Z) {
            dVar.g(this.whenLogging);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.message);
        visitor.b(this.whenLogging);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.message = (InterfaceC1700x0) cVar.readObject();
        if (36 <= cVar.f6409x0) {
            this.whenLogging = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        if (this.message != null && (c1708z0.f17641Z.f14841L1 != 0 || !J3.h.f(c1708z0, this.whenLogging, false))) {
            c1708z0.g1().g(c1708z0.f17644y0, c1708z0.f17642x0.g(), "U", J3.h.e0(this.message.c2(c1708z0)));
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
