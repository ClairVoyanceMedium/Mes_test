package com.llamalab.automate.stmt;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("sound_play.html")
@F3.a(C2541R.integer.ic_note)
@F3.i(C2541R.string.stmt_sound_play_title)
@F3.h(C2541R.string.stmt_sound_play_summary)
@F3.e(C2541R.layout.stmt_sound_play_edit)
/* loaded from: classes.dex */
public final class SoundPlay extends AudioPlaybackAction implements AsyncStatement {
    public InterfaceC1700x0 pitch;
    public InterfaceC1700x0 position;
    public InterfaceC1700x0 repeat;
    public InterfaceC1700x0 speed;
    public InterfaceC1700x0 uri;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_sound_play);
        l8.v(this.uri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.AudioPlaybackAction, com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.uri);
        dVar.g(this.repeat);
        if (22 <= dVar.f6413Z) {
            dVar.g(this.position);
        }
        if (105 <= dVar.f6413Z) {
            dVar.g(this.speed);
            dVar.g(this.pitch);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.stream);
        visitor.b(this.volume);
        visitor.b(this.focus);
        visitor.b(this.notificationChannelId);
        visitor.b(this.uri);
        visitor.b(this.repeat);
        visitor.b(this.position);
        visitor.b(this.speed);
        visitor.b(this.pitch);
    }

    @Override // com.llamalab.automate.stmt.AudioPlaybackAction, com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.repeat = (InterfaceC1700x0) cVar.readObject();
        if (22 <= cVar.f6409x0) {
            this.position = (InterfaceC1700x0) cVar.readObject();
        }
        if (105 <= cVar.f6409x0) {
            this.speed = (InterfaceC1700x0) cVar.readObject();
            this.pitch = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        MediaPlayer mediaPlayer;
        float f8;
        C1632a1 c1632a1;
        PlaybackParams playbackParams;
        c1708z0.q(C2541R.string.stmt_sound_play_title);
        c1708z0.I(C1632a1.class, this.f16218X);
        Uri g8 = J3.h.g(c1708z0, this.uri, null);
        if (g8 == null) {
            throw new RequiredArgumentNullException("uri");
        }
        int m8 = J3.h.m(c1708z0, this.stream, 5);
        float l8 = J3.h.l(c1708z0, this.volume, 100.0f) / 100.0f;
        int m9 = J3.h.m(c1708z0, this.focus, 3 == m8 ? 1 : 3);
        int i8 = 4 == m9 ? 2 : m9;
        boolean f9 = J3.h.f(c1708z0, this.repeat, false);
        int e8 = (int) y4.j.e(J3.h.t(c1708z0, this.position, 0L), 0L, 2147483647L);
        float l9 = J3.h.l(c1708z0, this.speed, 100.0f) / 100.0f;
        float l10 = J3.h.l(c1708z0, this.pitch, 100.0f) / 100.0f;
        String x7 = J3.h.x(c1708z0, this.notificationChannelId, null);
        boolean z7 = J1(1) == 0;
        MediaPlayer mediaPlayer2 = new MediaPlayer();
        mediaPlayer2.setLooping(f9);
        mediaPlayer2.setAudioStreamType(m8);
        int i9 = Build.VERSION.SDK_INT;
        if (26 <= i9) {
            AudioAttributes build = new AudioAttributes.Builder().setLegacyStreamType(m8).build();
            mediaPlayer2.setAudioAttributes(build);
            mediaPlayer = mediaPlayer2;
            f8 = l9;
            c1632a1 = new C1632a1(mediaPlayer2, build, l8, i8, e8, !z7);
        } else {
            mediaPlayer = mediaPlayer2;
            f8 = l9;
            if (21 <= i9) {
                mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(m8).build());
                c1632a1 = new C1632a1(mediaPlayer, Integer.valueOf(m8), l8, i8, e8, !z7);
            } else {
                c1632a1 = new C1632a1(mediaPlayer, Integer.valueOf(m8), l8, i8, e8, !z7);
            }
        }
        C1632a1 c1632a12 = c1632a1;
        MediaPlayer mediaPlayer3 = mediaPlayer;
        mediaPlayer3.setDataSource(c1708z0, g8);
        c1708z0.w(c1632a12);
        if (23 <= i9 && (f8 != 1.0f || l10 != 1.0f)) {
            playbackParams = mediaPlayer3.getPlaybackParams();
            playbackParams.setAudioFallbackMode(2);
            playbackParams.setSpeed(f8);
            playbackParams.setPitch(l10);
            mediaPlayer3.setPlaybackParams(playbackParams);
        }
        mediaPlayer3.prepareAsync();
        if (x7 != null) {
            c1632a12.z2(c1708z0, x7, C2541R.drawable.ic_stat_notify_note, C2541R.string.stmt_sound_play_title);
        }
        if (!z7) {
            return false;
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
