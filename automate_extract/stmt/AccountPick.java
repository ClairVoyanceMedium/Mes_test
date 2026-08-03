package com.llamalab.automate.stmt;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("account_pick.html")
@F3.a(C2541R.integer.ic_device_access_accounts)
@F3.i(C2541R.string.stmt_account_pick_title)
@F3.h(C2541R.string.stmt_account_pick_summary)
@F3.e(C2541R.layout.stmt_account_pick_edit)
/* loaded from: classes.dex */
public class AccountPick extends ActivityDecision {
    public InterfaceC1700x0 accountType;
    public J3.l varPickedAccountName;
    public J3.l varPickedAccountType;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_account_pick).o(2, this.accountType).q(this.accountType).f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.accountType);
        dVar.g(this.varPickedAccountName);
        dVar.g(this.varPickedAccountType);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.accountType);
        visitor.b(this.varPickedAccountName);
        visitor.b(this.varPickedAccountType);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.accountType = (InterfaceC1700x0) cVar.readObject();
        this.varPickedAccountName = (J3.l) cVar.readObject();
        this.varPickedAccountType = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varPickedAccountName;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            J3.l lVar2 = this.varPickedAccountType;
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        String stringExtra = intent.getStringExtra("authAccount");
        String stringExtra2 = intent.getStringExtra("accountType");
        J3.l lVar3 = this.varPickedAccountName;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, stringExtra);
        }
        J3.l lVar4 = this.varPickedAccountType;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, stringExtra2);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_account_pick_title);
        String x7 = J3.h.x(c1708z0, this.accountType, null);
        c1708z0.D(AccountManager.newChooseAccountIntent(null, null, x7 != null ? new String[]{x7} : null, true, null, null, null, null), null, this, c1708z0.f(C2541R.integer.ic_device_access_accounts), c1708z0.getText(C2541R.string.stmt_account_pick_title));
        return false;
    }
}
