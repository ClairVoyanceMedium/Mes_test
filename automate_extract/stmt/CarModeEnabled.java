package com.llamalab.automate.stmt;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;

@F3.f("car_mode_enabled.html")
@F3.a(C2541R.integer.ic_milage)
@F3.i(C2541R.string.stmt_car_mode_enabled_title)
@F3.h(C2541R.string.stmt_car_mode_enabled_summary)
@F3.e(C2541R.layout.stmt_car_mode_enabled_edit)
/* loaded from: classes.dex */
public final class CarModeEnabled extends IntermittentDecision implements ReceiverStatement {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_car_mode_enabled_immediate, C2541R.string.caption_car_mode_enabled_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, UiModeManager.ACTION_ENTER_CAR_MODE.equals(intent.getAction()));
        return true;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_car_mode_enabled_title);
        boolean z7 = 3 == ((UiModeManager) c1708z0.getSystemService("uimode")).getCurrentModeType();
        if (J1(1) == 0) {
            o(c1708z0, z7);
            return true;
        }
        AbstractC1618p2.c cVar = new AbstractC1618p2.c();
        c1708z0.w(cVar);
        cVar.o(2, z7 ? UiModeManager.ACTION_EXIT_CAR_MODE : UiModeManager.ACTION_ENTER_CAR_MODE);
        return false;
    }
}
