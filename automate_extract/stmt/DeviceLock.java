package com.llamalab.automate.stmt;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("device_lock.html")
@F3.a(C2541R.integer.ic_device_access_secure)
@F3.i(C2541R.string.stmt_device_lock_title)
@F3.h(C2541R.string.stmt_device_lock_summary)
@F3.c(C2541R.string.caption_device_lock)
@F3.e(C2541R.layout.stmt_device_lock_edit)
/* loaded from: classes.dex */
public class DeviceLock extends Action {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15546g};
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_device_lock_title);
        ((DevicePolicyManager) c1708z0.getSystemService("device_policy")).lockNow();
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
