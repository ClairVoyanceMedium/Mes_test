package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("service_start.html")
@F3.a(C2541R.integer.ic_app_service)
@F3.i(C2541R.string.stmt_service_start_title)
@F3.h(C2541R.string.stmt_service_start_summary)
@F3.e(C2541R.layout.stmt_service_start_edit)
/* loaded from: classes.dex */
public final class ServiceStart extends IntentAction {
    public InterfaceC1700x0 foreground;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_service_start).o(-1, this.action).o(-1, this.className).q(this.className).o(-1, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        s(dVar, 73);
        if (93 <= dVar.f6413Z) {
            dVar.g(this.foreground);
        }
    }

    @Override // com.llamalab.automate.stmt.IntentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.foreground);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return ViewOnClickListenerC1667s.w(null, 4);
    }

    @Override // com.llamalab.automate.stmt.IntentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        InterfaceC1700x0 j8;
        r(cVar, 73);
        if (93 <= cVar.f6409x0) {
            j8 = (InterfaceC1700x0) cVar.readObject();
        } else {
            InterfaceC1700x0 interfaceC1700x0 = this.flags;
            if (!(interfaceC1700x0 instanceof J3.k) || (((int) J3.h.W(interfaceC1700x0)) & 268435456) == 0) {
                return;
            } else {
                j8 = new L3.J(1);
            }
        }
        this.foreground = j8;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_service_start_title);
        Intent q8 = q(MoreOsConstants.KEY_EMAIL, c1708z0, false);
        boolean f8 = J3.h.f(c1708z0, this.foreground, false);
        if (26 > Build.VERSION.SDK_INT || !f8) {
            c1708z0.startService(q8);
        } else {
            c1708z0.startForegroundService(q8);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
