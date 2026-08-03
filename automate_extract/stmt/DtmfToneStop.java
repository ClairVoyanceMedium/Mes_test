package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("dtmf_tone_stop.html")
@F3.a(C2541R.integer.ic_note_stop)
@F3.i(C2541R.string.stmt_dtmf_tone_stop_title)
@F3.h(C2541R.string.stmt_dtmf_tone_stop_summary)
@F3.c(C2541R.string.caption_dtmf_tone_stop)
@F3.e(C2541R.layout.stmt_dtmf_tone_stop_edit)
/* loaded from: classes.dex */
public final class DtmfToneStop extends Action {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 31 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15552m} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_dtmf_tone_stop_title);
        IncapableAndroidVersionException.b(31, "in-call service");
        c1708z0.H(C.class);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
