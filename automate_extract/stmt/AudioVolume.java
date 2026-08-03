package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("audio_volume.html")
@F3.a(C2541R.integer.ic_device_access_volume_on)
@F3.i(C2541R.string.stmt_audio_volume_title)
@F3.h(C2541R.string.stmt_audio_volume_summary)
@F3.e(C2541R.layout.stmt_audio_volume_edit)
/* loaded from: classes.dex */
public final class AudioVolume extends LevelDecision implements ReceiverStatement {
    public InterfaceC1700x0 stream;

    public static class a extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public final Double f16305L1;

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f16306M1;

        /* renamed from: N1, reason: collision with root package name */
        public double f16307N1;

        /* renamed from: O1, reason: collision with root package name */
        public Boolean f16308O1;

        /* renamed from: x1, reason: collision with root package name */
        public final int f16309x1;

        /* renamed from: y1, reason: collision with root package name */
        public final Double f16310y1;

        public a(Boolean bool, boolean z7, int i8, Double d8, Double d9) {
            this.f16308O1 = bool;
            this.f16306M1 = z7;
            this.f16309x1 = i8;
            this.f16310y1 = d8;
            this.f16305L1 = d9;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Boolean bool;
            int intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
            int i8 = this.f16309x1;
            if (i8 == intExtra) {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                double intExtra2 = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
                double max = Math.max(1, audioManager.getStreamMaxVolume(i8));
                Double.isNaN(intExtra2);
                Double.isNaN(max);
                Double.isNaN(intExtra2);
                Double.isNaN(max);
                double d8 = (intExtra2 / max) * 100.0d;
                this.f16307N1 = d8;
                Boolean valueOf = Boolean.valueOf(LevelDecision.E(d8, this.f16310y1, this.f16305L1));
                if (!this.f16306M1 && ((bool = this.f16308O1) == null || valueOf.equals(bool))) {
                    this.f16308O1 = valueOf;
                } else {
                    this.f16308O1 = valueOf;
                    b(intent);
                }
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_audio_volume_immediate, C2541R.string.caption_audio_volume_change);
        C1596k0 e8 = c1596k0.e(this.stream, 2, C2541R.xml.audio_streams);
        e8.n(this.minLevel, this.maxLevel, 0);
        return e8.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        a aVar = (a) abstractC1618p2;
        B(c1708z0, aVar.f16308O1.booleanValue(), Double.valueOf(aVar.f16307N1));
        return true;
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.stream);
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.stream);
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.stream = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_audio_volume_title);
        int m8 = J3.h.m(c1708z0, this.stream, 0);
        Double D7 = D(c1708z0);
        Double C7 = C(c1708z0);
        boolean z7 = J1(1) == 0;
        AudioManager audioManager = (AudioManager) c1708z0.getSystemService("audio");
        double streamVolume = audioManager.getStreamVolume(m8);
        double max = Math.max(1, audioManager.getStreamMaxVolume(m8));
        Double.isNaN(streamVolume);
        Double.isNaN(max);
        Double.isNaN(streamVolume);
        Double.isNaN(max);
        double d8 = (streamVolume / max) * 100.0d;
        boolean E7 = LevelDecision.E(d8, D7, C7);
        if (z7) {
            B(c1708z0, E7, Double.valueOf(d8));
            return true;
        }
        a aVar = new a(Boolean.valueOf(E7), (D7 == null && C7 == null) ? true : z7, m8, D7, C7);
        c1708z0.w(aVar);
        aVar.h("android.media.VOLUME_CHANGED_ACTION");
        return false;
    }
}
