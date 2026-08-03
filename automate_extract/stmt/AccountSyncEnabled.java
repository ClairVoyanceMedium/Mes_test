package com.llamalab.automate.stmt;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncAdapterType;
import android.content.SyncStatusObserver;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("account_sync_enabled.html")
@F3.a(C2541R.integer.ic_auto_sync)
@F3.i(C2541R.string.stmt_account_sync_enabled_title)
@F3.h(C2541R.string.stmt_account_sync_enabled_summary)
@F3.e(C2541R.layout.stmt_account_sync_enabled_edit)
/* loaded from: classes.dex */
public class AccountSyncEnabled extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 accountName;
    public InterfaceC1700x0 accountType;
    public InterfaceC1700x0 authority;

    public static final class a extends com.llamalab.automate.W implements SyncStatusObserver {

        /* renamed from: L1, reason: collision with root package name */
        public final String f16224L1;

        /* renamed from: M1, reason: collision with root package name */
        public final String f16225M1;

        /* renamed from: N1, reason: collision with root package name */
        public final boolean f16226N1;

        /* renamed from: O1, reason: collision with root package name */
        public Object f16227O1;

        /* renamed from: y1, reason: collision with root package name */
        public final String f16228y1;

        public a(String str, String str2, String str3, boolean z7) {
            this.f16228y1 = str;
            this.f16224L1 = str2;
            this.f16225M1 = str3;
            this.f16226N1 = z7;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            this.f16227O1 = ContentResolver.addStatusChangeListener(1, this);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            Object obj = this.f16227O1;
            if (obj != null) {
                ContentResolver.removeStatusChangeListener(obj);
                this.f16227O1 = null;
            }
            u2();
        }

        @Override // android.content.SyncStatusObserver
        public final void onStatusChanged(int i8) {
            try {
                boolean B7 = AccountSyncEnabled.B(this.f15400Y, this.f16228y1, this.f16224L1, this.f16225M1);
                boolean z7 = this.f16226N1;
                if (z7 != B7) {
                    q2(Boolean.valueOf(!z7), false);
                }
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static boolean B(Context context, String str, String str2, String str3) {
        if (str == null && str2 == null && str3 == null) {
            return ContentResolver.getMasterSyncAutomatically();
        }
        if (str != null && str2 != null && str3 != null) {
            return ContentResolver.getSyncAutomatically(new Account(str, str2), str3);
        }
        SyncAdapterType[] syncAdapterTypes = ContentResolver.getSyncAdapterTypes();
        if (syncAdapterTypes == null) {
            return false;
        }
        AccountManager accountManager = null;
        int i8 = 0;
        int i9 = 0;
        for (SyncAdapterType syncAdapterType : syncAdapterTypes) {
            if ((str2 == null || str2.equals(syncAdapterType.accountType)) && (str3 == null || str3.equals(syncAdapterType.authority))) {
                if (str != null) {
                    i8++;
                    if (ContentResolver.getSyncAutomatically(new Account(str, syncAdapterType.accountType), syncAdapterType.authority)) {
                        i9++;
                    }
                } else {
                    if (accountManager == null) {
                        accountManager = AccountManager.get(context);
                    }
                    for (Account account : accountManager.getAccountsByType(syncAdapterType.accountType)) {
                        i8++;
                        if (ContentResolver.getSyncAutomatically(account, syncAdapterType.authority)) {
                            i9++;
                        }
                    }
                }
            }
        }
        return i8 == i9;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.GET_ACCOUNTS"), com.llamalab.automate.access.c.j("android.permission.READ_SYNC_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_account_sync_enabled_immediate, C2541R.string.caption_account_sync_enabled_change);
        c1596k0.v(this.accountName, 0);
        return c1596k0.o(2, this.accountType).o(2, this.authority).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.accountName);
        dVar.g(this.accountType);
        dVar.g(this.authority);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.accountName);
        visitor.b(this.accountType);
        visitor.b(this.authority);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1633b();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.accountName = (InterfaceC1700x0) cVar.readObject();
        this.accountType = (InterfaceC1700x0) cVar.readObject();
        this.authority = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_account_sync_enabled_title);
        String x7 = J3.h.x(c1708z0, this.accountName, null);
        String x8 = J3.h.x(c1708z0, this.accountType, null);
        String x9 = J3.h.x(c1708z0, this.authority, null);
        boolean B7 = B(c1708z0, x7, x8, x9);
        if (J1(1) == 0) {
            o(c1708z0, B7);
            return true;
        }
        c1708z0.w(new a(x7, x8, x9, B7));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
