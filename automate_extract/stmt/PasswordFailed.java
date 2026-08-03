package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("password_failed.html")
@F3.a(C2541R.integer.ic_device_access_lock_shield)
@F3.i(C2541R.string.stmt_password_failed_title)
@F3.h(C2541R.string.stmt_password_failed_summary)
@F3.c(C2541R.string.caption_password_failed)
@F3.e(C2541R.layout.stmt_password_failed_edit)
/* loaded from: classes.dex */
public final class PasswordFailed extends Decision implements ReceiverStatement {
    public J3.l varAttempts;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15546g};
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        String action = intent.getAction();
        if ("android.app.action.ACTION_PASSWORD_FAILED".equals(action)) {
            Double valueOf = Double.valueOf(intent.getIntExtra("com.llamalab.automate.intent.extra.FAILED_ATTEMPT_COUNT", 1));
            J3.l lVar = this.varAttempts;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, valueOf);
            }
            o(c1708z0, true);
            return true;
        }
        if (!"android.app.action.ACTION_PASSWORD_SUCCEEDED".equals(action)) {
            return false;
        }
        J3.l lVar2 = this.varAttempts;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, null);
        }
        o(c1708z0, false);
        return true;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varAttempts);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varAttempts);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varAttempts = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_password_failed_title);
        e(c1708z0);
        AbstractC1618p2.a aVar = new AbstractC1618p2.a();
        c1708z0.w(aVar);
        aVar.j("android.app.action.ACTION_PASSWORD_FAILED", "android.app.action.ACTION_PASSWORD_SUCCEEDED");
        return false;
    }
}
