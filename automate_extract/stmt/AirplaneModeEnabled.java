package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;

@F3.f("airplane_mode_enabled.html")
@F3.a(C2541R.integer.ic_alerts_and_states_airplane_mode_off)
@F3.i(C2541R.string.stmt_airplane_mode_enabled_title)
@F3.h(C2541R.string.stmt_airplane_mode_enabled_summary)
@F3.e(C2541R.layout.stmt_airplane_mode_enabled_edit)
/* loaded from: classes.dex */
public final class AirplaneModeEnabled extends IntermittentDecision implements ReceiverStatement {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_airplane_mode_enabled_immediate, C2541R.string.caption_airplane_mode_enabled_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, intent.getBooleanExtra(com.llamalab.auth3p.e.PARAM_STATE, false));
        return true;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_airplane_mode_enabled_title);
        if (J1(1) == 0) {
            o(c1708z0, (17 <= Build.VERSION.SDK_INT ? Settings.Global.getInt(c1708z0.getContentResolver(), "airplane_mode_on") : Settings.System.getInt(c1708z0.getContentResolver(), "airplane_mode_on")) != 0);
            return true;
        }
        AbstractC1618p2.c cVar = new AbstractC1618p2.c();
        c1708z0.w(cVar);
        cVar.h("android.intent.action.AIRPLANE_MODE");
        return false;
    }
}
