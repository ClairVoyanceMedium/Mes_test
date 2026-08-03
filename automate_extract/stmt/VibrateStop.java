package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Vibrator;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("vibrate_stop.html")
@F3.a(C2541R.integer.ic_audio_ring_notif_vibrate_am_stop)
@F3.i(C2541R.string.stmt_vibrate_stop_title)
@F3.h(C2541R.string.stmt_vibrate_stop_summary)
@F3.e(C2541R.layout.stmt_vibrate_stop_edit)
/* loaded from: classes.dex */
public final class VibrateStop extends Action {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.VIBRATE")};
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_vibrate_stop_title);
        if (c1708z0.H(s1.class) == 0) {
            ((Vibrator) c1708z0.getSystemService("vibrator")).cancel();
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
