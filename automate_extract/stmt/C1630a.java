package com.llamalab.automate.stmt;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;

/* renamed from: com.llamalab.automate.stmt.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1630a<T> extends com.llamalab.automate.W implements AccountManagerCallback<T> {
    @Override // android.accounts.AccountManagerCallback
    public final void run(AccountManagerFuture<T> accountManagerFuture) {
        try {
            q2(accountManagerFuture.getResult(), false);
        } catch (Throwable th) {
            r2(th);
        }
    }
}
