package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("screen_off_timeout_set.html")
@F3.a(C2541R.integer.ic_screen_off_timer)
@F3.i(C2541R.string.stmt_screen_off_timeout_set_title)
@F3.h(C2541R.string.stmt_screen_off_timeout_set_summary)
@F3.e(C2541R.layout.stmt_screen_off_timeout_set_edit)
/* loaded from: classes.dex */
public class ScreenOffTimeoutSet extends Action {
    public InterfaceC1700x0 level;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15561v} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_screen_off_timeout_set);
        l8.w(1, this.level);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.level);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.level);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.level = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_screen_off_timeout_set_title);
        Double j8 = J3.h.j(c1708z0, this.level);
        if (j8 != null) {
            Settings.System.putInt(c1708z0.getContentResolver(), "screen_off_timeout", j8.doubleValue() < 0.0d ? -1 : (int) Math.min(j8.doubleValue() * 1000.0d, 2.147483647E9d));
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
