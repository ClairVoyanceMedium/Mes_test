package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("resolve_activity.html")
@F3.i(C2541R.string.stmt_resolve_activity_title)
@F3.h(C2541R.string.stmt_resolve_activity_summary)
@F3.e(C2541R.layout.stmt_resolve_activity_edit)
/* loaded from: classes.dex */
public class ResolveActivity extends ResolveComponentDecision {
    @Override // com.llamalab.automate.stmt.ResolveComponentDecision
    public final int G() {
        return 1;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_resolve_activity_immediate, C2541R.string.caption_resolve_activity_interactive, C2541R.string.caption_resolve_activity_immediate_maybe);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_resolve_activity_title);
        return F(c1708z0, c1708z0.getText(C2541R.string.stmt_resolve_activity_title));
    }
}
