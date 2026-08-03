package com.llamalab.automate.stmt;

import android.app.UiModeManager;
import android.content.Context;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("night_mode_set_state.html")
@F3.a(C2541R.integer.ic_moon)
@F3.i(C2541R.string.stmt_night_mode_set_state_title)
@F3.h(C2541R.string.stmt_night_mode_set_state_summary)
@F3.e(C2541R.layout.stmt_night_mode_set_state_edit)
/* loaded from: classes.dex */
public final class NightModeSetState extends SetStateAction {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_night_mode_set_state).e(this.state, 0, C2541R.xml.night_modes).q(this.state).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_night_mode_set_state_title);
        ((UiModeManager) c1708z0.getSystemService("uimode")).setNightMode(J3.h.m(c1708z0, this.state, 0));
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
