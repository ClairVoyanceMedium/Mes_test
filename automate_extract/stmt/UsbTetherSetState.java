package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("usb_tether_set_state.html")
@F3.a(C2541R.integer.ic_device_access_usb_tether)
@F3.i(C2541R.string.stmt_usb_tether_set_state_title)
@F3.h(C2541R.string.stmt_usb_tether_set_state_summary)
@F3.e(C2541R.layout.stmt_usb_tether_set_state_edit)
/* loaded from: classes.dex */
public final class UsbTetherSetState extends SetStateAction implements AsyncStatement {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_usb_tether_enable, C2541R.string.caption_usb_tether_disable).r(C2541R.string.caption_usb_tether_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_usb_tether_set_state_title);
        c1708z0.w(q(c1708z0, false) ? new j1(1) : new m1(1));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
