package com.llamalab.automate.stmt;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.content.Intent;
import android.os.Bundle;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.RequiredArgumentNullException;

/* loaded from: classes.dex */
public final class ThirdPartyAuthorized {

    public interface Statement extends AuthTokenStatement, AsyncStatement {
    }

    public static void a(Statement statement, C1708z0 c1708z0) {
        String x7 = J3.h.x(c1708z0, statement.N0(), null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("account");
        }
        Account account = new Account(x7, "com.llamalab.automate.microsoft");
        AccountManager accountManager = AccountManager.get(c1708z0.j2());
        C1630a c1630a = new C1630a();
        c1708z0.w(c1630a);
        try {
            accountManager.getAuthToken(account, "openid profile files.readwrite", (Bundle) null, false, (AccountManagerCallback<Bundle>) c1630a, c1708z0.j2().f14581L1);
        } catch (Throwable th) {
            c1630a.a();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(Statement statement, C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Bundle bundle = (Bundle) obj;
        Intent intent = (Intent) bundle.getParcelable("intent");
        if (intent != null) {
            c1708z0.B(intent, null, 30000L, false, c1708z0.f(C2541R.integer.ic_device_access_accounts), c1708z0.getString(C2541R.string.format_authorize_decision, ((AbstractStatement) statement).A(c1708z0)), c1708z0.r());
            return false;
        }
        String string = bundle.getString("authAccount");
        if (string == null) {
            throw new IllegalStateException("No authorized account");
        }
        String string2 = bundle.getString("com.llamalab.auth3p.authtokenUncached");
        if (string2 != null) {
            return statement.B0(c1708z0, string, string2, bundle.getLong("android.accounts.expiry", Long.MAX_VALUE));
        }
        throw new IllegalStateException("No authentication token");
    }
}
