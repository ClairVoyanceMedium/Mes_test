package com.llamalab.automate.stmt;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.HashMap;
import x3.C2430h;

@F3.f("account_generic_add.html")
@F3.a(C2541R.integer.ic_device_access_new_account)
@F3.i(C2541R.string.stmt_account_generic_add_title)
@F3.h(C2541R.string.stmt_account_generic_add_summary)
@F3.e(C2541R.layout.stmt_account_generic_add_edit)
/* loaded from: classes.dex */
public final class AccountGenericAdd extends Action {
    public InterfaceC1700x0 accountName;
    public InterfaceC1700x0 password;
    public InterfaceC1700x0 username;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_account_generic_add);
        l8.v(this.accountName, 0);
        l8.v(this.username, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.accountName);
        dVar.g(this.username);
        dVar.g(this.password);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.accountName);
        visitor.b(this.username);
        visitor.b(this.password);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.accountName = (InterfaceC1700x0) cVar.readObject();
        this.username = (InterfaceC1700x0) cVar.readObject();
        this.password = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        boolean addAccountExplicitly;
        c1708z0.q(C2541R.string.stmt_account_generic_add_title);
        String x7 = J3.h.x(c1708z0, this.accountName, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("accountName");
        }
        if (x7.isEmpty()) {
            throw new IllegalArgumentException("accountName");
        }
        String x8 = J3.h.x(c1708z0, this.username, "");
        String x9 = J3.h.x(c1708z0, this.password, "");
        if (x8.isEmpty() && x9.isEmpty()) {
            throw new IllegalArgumentException("Neither username nor password");
        }
        Account account = new Account(x7, "com.llamalab.automate.generic");
        Bundle bundle = new Bundle();
        bundle.putString("username", x8);
        AccountManager accountManager = AccountManager.get(c1708z0);
        if (26 <= Build.VERSION.SDK_INT) {
            HashMap hashMap = new HashMap();
            hashMap.put(c1708z0.getPackageName(), 1);
            addAccountExplicitly = accountManager.addAccountExplicitly(account, C2430h.b(c1708z0, x9), bundle, hashMap);
        } else {
            addAccountExplicitly = accountManager.addAccountExplicitly(account, C2430h.b(c1708z0, x9), bundle);
        }
        if (!addAccountExplicitly) {
            String userData = accountManager.getUserData(account, "username");
            if (userData == null) {
                throw new SecurityException("Failed to add account");
            }
            String password = accountManager.getPassword(account);
            if (password == null || !C2430h.a(c1708z0, password).equals(x9)) {
                accountManager.setPassword(account, C2430h.b(c1708z0, x9));
            }
            if (!userData.equals(x8)) {
                accountManager.setUserData(account, "username", x8);
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
