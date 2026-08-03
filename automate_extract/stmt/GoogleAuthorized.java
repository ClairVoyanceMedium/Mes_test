package com.llamalab.automate.stmt;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import c1.C1305a;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.RequiredArgumentNullException;

/* loaded from: classes.dex */
public final class GoogleAuthorized {

    public interface Statement extends AuthTokenStatement {
    }

    public static boolean a(Statement statement, C1708z0 c1708z0, Intent intent) {
        int i8 = C1708z0.f17633Q1;
        if (-1 != intent.getIntExtra("com.llamalab.automate.intent.extra.RESULT_CODE", 0)) {
            throw new GoogleAuthException("Authorization canceled");
        }
        Intent intent2 = (Intent) intent.getParcelableExtra("com.llamalab.automate.intent.extra.RESULT_INTENT");
        String stringExtra = intent2.getStringExtra("authAccount");
        if (stringExtra == null) {
            throw new IllegalStateException("No authorized account");
        }
        String stringExtra2 = intent2.getStringExtra("authtoken");
        if (stringExtra2 != null) {
            return statement.B0(c1708z0, stringExtra, stringExtra2, Long.MAX_VALUE);
        }
        throw new IllegalStateException("No authentication token");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(Statement statement, C1708z0 c1708z0, String str) {
        String x7 = J3.h.x(c1708z0, statement.N0(), null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("account");
        }
        try {
            String c8 = c(c1708z0, x7, str);
            if (c8 != null) {
                return statement.B0(c1708z0, x7, c8, Long.MAX_VALUE);
            }
            throw new IllegalStateException("No authentication token");
        } catch (GooglePlayServicesAvailabilityException e8) {
            throw e8;
        } catch (UserRecoverableAuthException e9) {
            Intent a8 = e9.a();
            if (a8 == null) {
                throw e9;
            }
            c1708z0.B(a8, null, 30000L, false, c1708z0.f(C2541R.integer.ic_device_access_accounts), c1708z0.getString(C2541R.string.format_authorize_decision, ((AbstractStatement) statement).A(c1708z0)), c1708z0.r());
            return false;
        }
    }

    public static String c(Context context, String str, String str2) {
        Account account = new Account(str, "com.google");
        Bundle bundle = new Bundle();
        bundle.putBoolean("suppressProgressScreen", true);
        return C1305a.i(context, account, str2, bundle);
    }
}
