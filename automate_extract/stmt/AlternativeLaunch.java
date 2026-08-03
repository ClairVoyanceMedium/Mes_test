package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.llamalab.automate.C1701x1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("alternative_launch.html")
@F3.a(C2541R.integer.ic_android_app)
@F3.i(C2541R.string.stmt_alternative_launch_title)
@F3.h(C2541R.string.stmt_alternative_launch_summary)
@F3.c(C2541R.string.caption_alternative_launch)
@F3.e(C2541R.layout.stmt_alternative_launch_edit)
/* loaded from: classes.dex */
public final class AlternativeLaunch extends Action implements IntentStatement {
    public InterfaceC1700x0 title;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15543d};
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        c1708z0.H(C1701x1.class);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.title);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.title);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.title = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_alternative_launch_title);
        Intent s8 = C1701x1.s(c1708z0, "com.llamalab.automate.intent.action.ALTERNATIVE_LAUNCH", J3.h.x(c1708z0, this.title, null));
        IntentFilter intentFilter = new IntentFilter("com.llamalab.automate.intent.action.ALTERNATIVE_LAUNCH_ANNOUNCE");
        C1701x1 c1701x1 = new C1701x1(s8);
        c1708z0.w(c1701x1);
        c1701x1.m(4, intentFilter);
        return false;
    }
}
