package com.llamalab.automate.stmt;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("audio_stream_set_mute.html")
@F3.a(C2541R.integer.ic_device_access_volume_muted)
@F3.i(C2541R.string.stmt_audio_stream_set_mute_title)
@F3.h(C2541R.string.stmt_audio_stream_set_mute_summary)
@F3.e(C2541R.layout.stmt_audio_stream_set_mute_edit)
/* loaded from: classes.dex */
public class AudioStreamSetMute extends SetStateAction {
    public InterfaceC1700x0 playSound;
    public InterfaceC1700x0 showPopup;
    public InterfaceC1700x0 stream;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 24 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.MODIFY_AUDIO_SETTINGS"), com.llamalab.automate.access.c.f15555p} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.MODIFY_AUDIO_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, true, C2541R.string.caption_audio_stream_mute_enable, C2541R.string.caption_audio_stream_mute_disable).r(C2541R.string.caption_audio_stream_set_mute).b(this.state).e(this.stream, 2, C2541R.xml.audio_streams).f16030c;
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.stream);
        dVar.g(this.playSound);
        dVar.g(this.showPopup);
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.stream);
        visitor.b(this.playSound);
        visitor.b(this.showPopup);
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.stream = (InterfaceC1700x0) cVar.readObject();
        this.playSound = (InterfaceC1700x0) cVar.readObject();
        this.showPopup = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_audio_stream_set_mute_title);
        boolean q8 = q(c1708z0, true);
        int m8 = J3.h.m(c1708z0, this.stream, 2);
        int i8 = J3.h.f(c1708z0, this.playSound, false) ? 20 : 0;
        if (J3.h.f(c1708z0, this.showPopup, false)) {
            i8 |= 1;
        }
        AudioManager audioManager = (AudioManager) c1708z0.getSystemService("audio");
        if (23 <= Build.VERSION.SDK_INT) {
            audioManager.adjustStreamVolume(m8, q8 ? -100 : 100, i8);
        } else {
            audioManager.setStreamMute(m8, q8);
            if (i8 != 0) {
                audioManager.adjustStreamVolume(m8, 0, i8);
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
