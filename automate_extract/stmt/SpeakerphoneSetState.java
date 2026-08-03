package com.llamalab.automate.stmt;

import android.content.Context;
import android.media.AudioManager;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("speakerphone_set_state.html")
@F3.a(C2541R.integer.ic_device_access_volume_on)
@F3.i(C2541R.string.stmt_speakerphone_set_state_title)
@F3.h(C2541R.string.stmt_speakerphone_set_state_summary)
@F3.e(C2541R.layout.stmt_speakerphone_set_state_edit)
/* loaded from: classes.dex */
public class SpeakerphoneSetState extends SetStateAction {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.MODIFY_AUDIO_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, true, C2541R.string.caption_speakerphone_enable, C2541R.string.caption_speakerphone_disable).r(C2541R.string.caption_speakerphone_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_speakerphone_set_state_title);
        ((AudioManager) c1708z0.getSystemService("audio")).setSpeakerphoneOn(q(c1708z0, true));
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
