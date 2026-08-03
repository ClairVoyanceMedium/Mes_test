package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.view.KeyEvent;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("microphone_set_mute.html")
@F3.a(C2541R.integer.ic_device_access_mic_muted)
@F3.i(C2541R.string.stmt_microphone_set_mute_title)
@F3.h(C2541R.string.stmt_microphone_set_mute_summary)
@F3.e(C2541R.layout.stmt_microphone_set_mute_edit)
/* loaded from: classes.dex */
public class MicrophoneSetMute extends SetStateAction {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.MODIFY_AUDIO_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, true, C2541R.string.caption_microphone_mute, C2541R.string.caption_microphone_unmute).r(C2541R.string.caption_microphone_set_mute).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_microphone_set_mute_title);
        AudioManager audioManager = (AudioManager) c1708z0.getSystemService("audio");
        boolean q8 = q(c1708z0, true);
        audioManager.setMicrophoneMute(q8);
        if (q8 != audioManager.isMicrophoneMute()) {
            try {
                c1708z0.sendOrderedBroadcast(new Intent("android.intent.action.MEDIA_BUTTON").putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, 91)).putExtra("com.llamalab.automate.intent.extra.HACK", true), "android.permission.CALL_PRIVILEGED");
            } catch (Throwable unused) {
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
