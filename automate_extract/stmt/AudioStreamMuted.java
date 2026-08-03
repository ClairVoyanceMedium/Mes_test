package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("audio_stream_muted.html")
@F3.a(C2541R.integer.ic_device_access_volume_muted)
@F3.i(C2541R.string.stmt_audio_stream_muted_title)
@F3.h(C2541R.string.stmt_audio_stream_muted_summary)
@F3.e(C2541R.layout.stmt_audio_stream_muted_edit)
/* loaded from: classes.dex */
public final class AudioStreamMuted extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 stream;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final int f16303x1;

        /* renamed from: y1, reason: collision with root package name */
        public final boolean f16304y1;

        public a(int i8, boolean z7) {
            this.f16303x1 = i8;
            this.f16304y1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (this.f16303x1 == intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1)) {
                boolean z7 = this.f16304y1;
                if (z7 != intent.getBooleanExtra("android.media.EXTRA_STREAM_VOLUME_MUTED", z7)) {
                    c(intent, Boolean.valueOf(!z7), false);
                }
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_audio_stream_muted_immediate, C2541R.string.caption_audio_stream_muted_change);
        return c1596k0.e(this.stream, 2, C2541R.xml.audio_streams).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.stream);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.stream);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.stream = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_audio_stream_muted_title);
        int m8 = J3.h.m(c1708z0, this.stream, 2);
        boolean z7 = J1(1) == 0;
        AudioManager audioManager = (AudioManager) c1708z0.getSystemService("audio");
        boolean isStreamMute = 23 <= Build.VERSION.SDK_INT ? audioManager.isStreamMute(m8) : ((Boolean) audioManager.getClass().getMethod("isStreamMute", Integer.TYPE).invoke(audioManager, Integer.valueOf(m8))).booleanValue();
        if (z7) {
            o(c1708z0, isStreamMute);
            return true;
        }
        a aVar = new a(m8, isStreamMute);
        c1708z0.w(aVar);
        aVar.h("android.media.STREAM_MUTE_CHANGED_ACTION");
        return false;
    }
}
