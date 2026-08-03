package com.llamalab.automate.stmt;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AbstractRunnableC1586h2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;

@F3.f("device_unlocked.html")
@F3.a(C2541R.integer.ic_device_access_not_secure)
@F3.i(C2541R.string.stmt_device_unlocked_title)
@F3.h(C2541R.string.stmt_device_unlocked_summary)
@F3.e(C2541R.layout.stmt_device_unlocked_edit)
/* loaded from: classes.dex */
public final class DeviceUnlocked extends IntermittentDecision implements ReceiverStatement, AsyncStatement {

    public static final class a extends AbstractRunnableC1586h2 {

        /* renamed from: L1, reason: collision with root package name */
        public final KeyguardManager f16582L1;

        public a(KeyguardManager keyguardManager) {
            super(500L);
            this.f16582L1 = keyguardManager;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1586h2
        public final boolean v2() {
            if (!this.f16582L1.inKeyguardRestrictedInputMode()) {
                return true;
            }
            p2(null);
            return false;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_device_unlocked_immediate, C2541R.string.caption_device_unlocked_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, true);
        return true;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_device_unlocked_title);
        KeyguardManager keyguardManager = (KeyguardManager) c1708z0.getSystemService("keyguard");
        boolean inKeyguardRestrictedInputMode = keyguardManager.inKeyguardRestrictedInputMode();
        if (J1(1) == 0) {
            o(c1708z0, !inKeyguardRestrictedInputMode);
            return true;
        }
        if (inKeyguardRestrictedInputMode) {
            AbstractC1618p2.c cVar = new AbstractC1618p2.c();
            c1708z0.w(cVar);
            cVar.h("android.intent.action.USER_PRESENT");
            return false;
        }
        a aVar = new a(keyguardManager);
        c1708z0.w(aVar);
        aVar.f15400Y.f14581L1.post(aVar);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, false);
        return true;
    }
}
