package com.llamalab.automate.stmt;

import android.media.AudioManager;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("ringer_silence.html")
@F3.a(C2541R.integer.ic_task_stop)
@F3.i(C2541R.string.stmt_ringer_silence_title)
@F3.h(C2541R.string.stmt_ringer_silence_summary)
@F3.c(C2541R.string.caption_ringer_silence)
@F3.e(C2541R.layout.stmt_ringer_silence_edit)
/* loaded from: classes.dex */
public class RingerSilence extends Action {
    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_ringer_silence_title);
        AudioManager audioManager = (AudioManager) c1708z0.getSystemService("audio");
        int ringerMode = audioManager.getRingerMode();
        audioManager.setRingerMode(0);
        audioManager.setRingerMode(ringerMode);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
