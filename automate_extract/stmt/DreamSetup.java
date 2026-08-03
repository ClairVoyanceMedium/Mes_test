package com.llamalab.automate.stmt;

import android.content.Intent;
import android.os.Bundle;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.C1701x1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("dream_setup.html")
@F3.a(C2541R.integer.ic_mobile_screensaver)
@F3.i(C2541R.string.stmt_dream_setup_title)
@F3.h(C2541R.string.stmt_dream_setup_summary)
@F3.e(C2541R.layout.stmt_dream_setup_edit)
/* loaded from: classes.dex */
public final class DreamSetup extends Action implements IntentStatement {
    public InterfaceC1700x0 flags;
    public InterfaceC1700x0 title;

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        c1708z0.I(C1701x1.class, this.f16218X);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.title);
        dVar.g(this.flags);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.title);
        visitor.b(this.flags);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.title = (InterfaceC1700x0) cVar.readObject();
        this.flags = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_dream_setup_title);
        IncapableAndroidVersionException.a(17);
        String x7 = J3.h.x(c1708z0, this.title, null);
        int m8 = J3.h.m(c1708z0, this.flags, 0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("interactive", (m8 & 1) != 0);
        bundle.putBoolean("fullscreen", (m8 & 2) != 0);
        bundle.putBoolean("screen_bright", (m8 & 4) != 0);
        C1701x1 c1701x1 = new C1701x1(C1701x1.s(c1708z0, "com.llamalab.automate.intent.action.DREAM_SETTINGS", x7).putExtra("com.llamalab.automate.intent.extra.DREAM_OPTIONS", bundle));
        c1708z0.w(c1701x1);
        c1701x1.o(4, "com.llamalab.automate.intent.action.DREAM_SETTINGS_ANNOUNCE");
        return false;
    }
}
