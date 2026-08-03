package com.llamalab.automate.stmt;

import android.content.Intent;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.FlowPickActivity;

@F3.f("flow_pick.html")
@F3.a(C2541R.integer.ic_gear_select)
@F3.i(C2541R.string.stmt_flow_pick_title)
@F3.h(C2541R.string.stmt_flow_pick_summary)
@F3.c(C2541R.string.caption_flow_pick)
@F3.e(C2541R.layout.stmt_flow_pick_edit)
/* loaded from: classes.dex */
public class FlowPick extends FlowPickDecision {
    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 == i8) {
            C(c1708z0, true, intent.getDataString(), intent.getCharSequenceExtra("android.intent.extra.TITLE"), intent.getCharSequenceExtra("android.intent.extra.TEXT"));
        } else {
            C(c1708z0, false, null, null, null);
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_flow_pick_title);
        c1708z0.D(new Intent(c1708z0, (Class<?>) FlowPickActivity.class), null, this, c1708z0.f(C2541R.integer.ic_gear_select), c1708z0.getText(C2541R.string.stmt_flow_pick_title));
        return false;
    }
}
