package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;

@F3.f("microphone_muted.html")
@F3.a(C2541R.integer.ic_device_access_mic_muted)
@F3.i(C2541R.string.stmt_microphone_muted_title)
@F3.h(C2541R.string.stmt_microphone_muted_summary)
@F3.c(C2541R.string.caption_microphone_muted_immediate)
@F3.e(C2541R.layout.stmt_microphone_muted_edit)
/* loaded from: classes.dex */
public final class MicrophoneMuted extends IntermittentDecision implements ReceiverStatement {

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final AudioManager f16919x1;

        /* renamed from: y1, reason: collision with root package name */
        public final boolean f16920y1;

        public a(AudioManager audioManager, boolean z7) {
            this.f16919x1 = audioManager;
            this.f16920y1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            boolean isMicrophoneMute = this.f16919x1.isMicrophoneMute();
            boolean z7 = this.f16920y1;
            if (z7 != isMicrophoneMute) {
                c(intent, Boolean.valueOf(!z7), false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 0, C2541R.string.caption_microphone_muted_immediate, C2541R.string.caption_microphone_muted_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        z(dVar, 95);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        w(cVar, 95);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_microphone_muted_title);
        AudioManager audioManager = (AudioManager) c1708z0.getSystemService("audio");
        boolean isMicrophoneMute = audioManager.isMicrophoneMute();
        if (J1(0) == 0) {
            o(c1708z0, isMicrophoneMute);
            return true;
        }
        IncapableAndroidVersionException.b(28, "proceed when changed");
        a aVar = new a(audioManager, isMicrophoneMute);
        c1708z0.w(aVar);
        aVar.h("android.media.action.MICROPHONE_MUTE_CHANGED");
        return false;
    }
}
