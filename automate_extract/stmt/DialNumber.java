package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("dial_number.html")
@F3.a(C2541R.integer.ic_device_access_dial_pad)
@F3.i(C2541R.string.stmt_dial_number_title)
@F3.h(C2541R.string.stmt_dial_number_summary)
@F3.e(C2541R.layout.stmt_dial_number_edit)
/* loaded from: classes.dex */
public final class DialNumber extends DialerAction {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE"), com.llamalab.automate.access.c.f15547h} : 22 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_dial_number);
        l8.v(this.phoneNumber, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_dial_number_title);
        e(c1708z0);
        c1708z0.startActivity(q(c1708z0, "android.intent.action.DIAL").addFlags(268697600));
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
