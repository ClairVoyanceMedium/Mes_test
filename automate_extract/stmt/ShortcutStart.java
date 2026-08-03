package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.RequiredArgumentNullException;

@F3.f("shortcut_start.html")
@F3.a(C2541R.integer.ic_shortcut)
@F3.i(C2541R.string.stmt_shortcut_start_title)
@F3.h(C2541R.string.stmt_shortcut_start_summary)
@F3.e(C2541R.layout.stmt_shortcut_start_edit)
/* loaded from: classes.dex */
public final class ShortcutStart extends Action {
    public Intent intent;
    public String label;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15547h} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_shortcut_start);
        l8.C(this.label);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.i(this.intent);
        dVar.k(this.label);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new W0();
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.intent = (Intent) cVar.h(Intent.CREATOR);
        this.label = cVar.i();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_shortcut_start_title);
        e(c1708z0);
        if (this.intent == null) {
            throw new RequiredArgumentNullException("intent");
        }
        c1708z0.startActivity(new Intent(this.intent).addFlags(268697600));
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
