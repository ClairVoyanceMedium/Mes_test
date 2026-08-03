package com.llamalab.automate.stmt;

import P.C1092h;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;
import java.util.Iterator;
import java.util.List;

@F3.f("profile_quiet_mode_enabled.html")
@F3.a(C2541R.integer.ic_corp_off)
@F3.i(C2541R.string.stmt_profile_quiet_mode_enabled_title)
@F3.h(C2541R.string.stmt_profile_quiet_mode_enabled_summary)
@F3.e(C2541R.layout.stmt_profile_quiet_mode_enabled_edit)
/* loaded from: classes.dex */
public final class ProfileQuietModeEnabled extends IntermittentDecision implements ReceiverStatement {

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final UserHandle f17047x1;

        /* renamed from: y1, reason: collision with root package name */
        public boolean f17048y1;

        public a(UserHandle userHandle, boolean z7) {
            this.f17047x1 = userHandle;
            this.f17048y1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            boolean equals;
            equals = this.f17047x1.equals(intent.getParcelableExtra("android.intent.extra.USER"));
            if (equals) {
                boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.QUIET_MODE", false);
                boolean z7 = this.f17048y1;
                if (booleanExtra != z7) {
                    boolean z8 = !z7;
                    this.f17048y1 = z8;
                    c(intent, Boolean.valueOf(z8), false);
                }
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_profile_quiet_mode_enabled_immediate, C2541R.string.caption_profile_quiet_mode_enabled_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        UserHandle myUserHandle;
        List userProfiles;
        boolean equals;
        boolean isQuietModeEnabled;
        c1708z0.q(C2541R.string.stmt_profile_quiet_mode_enabled_title);
        IncapableAndroidVersionException.a(24);
        UserManager h8 = C1092h.h(c1708z0.getSystemService("user"));
        myUserHandle = Process.myUserHandle();
        userProfiles = h8.getUserProfiles();
        Iterator it = userProfiles.iterator();
        while (it.hasNext()) {
            UserHandle g8 = N.c.g(it.next());
            equals = myUserHandle.equals(g8);
            if (!equals) {
                isQuietModeEnabled = h8.isQuietModeEnabled(g8);
                if (J1(1) == 0) {
                    o(c1708z0, isQuietModeEnabled);
                    return true;
                }
                a aVar = new a(g8, isQuietModeEnabled);
                c1708z0.w(aVar);
                aVar.p(2, "android.intent.action.MANAGED_PROFILE_AVAILABLE", "android.intent.action.MANAGED_PROFILE_UNAVAILABLE");
                return false;
            }
        }
        throw new IllegalStateException("No managed profile user found");
    }
}
