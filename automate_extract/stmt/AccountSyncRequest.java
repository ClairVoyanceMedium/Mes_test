package com.llamalab.automate.stmt;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncAdapterType;
import android.os.Bundle;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("account_sync_request.html")
@F3.a(C2541R.integer.ic_auto_sync)
@F3.i(C2541R.string.stmt_account_sync_request_title)
@F3.h(C2541R.string.stmt_account_sync_request_summary)
@F3.e(C2541R.layout.stmt_account_sync_request_edit)
/* loaded from: classes.dex */
public class AccountSyncRequest extends Action {
    public InterfaceC1700x0 accountName;
    public InterfaceC1700x0 accountType;
    public InterfaceC1700x0 authority;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.GET_ACCOUNTS"), com.llamalab.automate.access.c.j("android.permission.READ_SYNC_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_account_sync_request);
        l8.v(this.accountName, 0);
        return l8.o(2, this.accountType).o(2, this.authority).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.accountName);
        dVar.g(this.accountType);
        dVar.g(this.authority);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.accountName);
        visitor.b(this.accountType);
        visitor.b(this.authority);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1633b();
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.accountName = (InterfaceC1700x0) cVar.readObject();
        this.accountType = (InterfaceC1700x0) cVar.readObject();
        this.authority = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_account_sync_request_title);
        AccountManager accountManager = null;
        String x7 = J3.h.x(c1708z0, this.accountName, null);
        String x8 = J3.h.x(c1708z0, this.accountType, null);
        String x9 = J3.h.x(c1708z0, this.authority, null);
        Bundle bundle = new Bundle();
        bundle.putBoolean("force", true);
        bundle.putBoolean("do_not_retry", true);
        if (x7 == null || x8 == null || x9 == null) {
            SyncAdapterType[] syncAdapterTypes = ContentResolver.getSyncAdapterTypes();
            if (syncAdapterTypes != null) {
                for (SyncAdapterType syncAdapterType : syncAdapterTypes) {
                    if ((x8 == null || x8.equals(syncAdapterType.accountType)) && (x9 == null || x9.equals(syncAdapterType.authority))) {
                        if (x7 != null) {
                            Account account = new Account(x7, syncAdapterType.accountType);
                            String str = syncAdapterType.authority;
                            if (ContentResolver.getIsSyncable(account, str) > 0) {
                                ContentResolver.requestSync(account, str, bundle);
                            }
                        } else {
                            if (accountManager == null) {
                                accountManager = AccountManager.get(c1708z0);
                            }
                            for (Account account2 : accountManager.getAccountsByType(syncAdapterType.accountType)) {
                                String str2 = syncAdapterType.authority;
                                if (ContentResolver.getIsSyncable(account2, str2) > 0) {
                                    ContentResolver.requestSync(account2, str2, bundle);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            Account account3 = new Account(x7, x8);
            if (ContentResolver.getIsSyncable(account3, x9) > 0) {
                ContentResolver.requestSync(account3, x9, bundle);
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
