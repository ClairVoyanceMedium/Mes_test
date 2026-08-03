package com.llamalab.automate.stmt;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("ringer_mode_set.html")
@F3.a(C2541R.integer.ic_task)
@F3.i(C2541R.string.stmt_ringer_mode_set_title)
@F3.h(C2541R.string.stmt_ringer_mode_set_summary)
@F3.e(C2541R.layout.stmt_ringer_mode_set_edit)
/* loaded from: classes.dex */
public class RingerModeSet extends SetStateAction {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 24 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.MODIFY_AUDIO_SETTINGS"), com.llamalab.automate.access.c.f15555p} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.MODIFY_AUDIO_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_ringer_mode_set).e(this.state, 2, C2541R.xml.ringer_modes).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_ringer_mode_set_title);
        ((AudioManager) c1708z0.getSystemService("audio")).setRingerMode(J3.h.m(c1708z0, this.state, 2));
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
