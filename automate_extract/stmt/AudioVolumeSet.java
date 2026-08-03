package com.llamalab.automate.stmt;

import android.content.Context;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("audio_volume_set.html")
@F3.a(C2541R.integer.ic_device_access_volume_on)
@F3.i(C2541R.string.stmt_audio_volume_set_title)
@F3.h(C2541R.string.stmt_audio_volume_set_summary)
@F3.e(C2541R.layout.stmt_audio_volume_set_edit)
/* loaded from: classes.dex */
public class AudioVolumeSet extends Action {
    public InterfaceC1700x0 level;
    public InterfaceC1700x0 playSound;
    public InterfaceC1700x0 showPopup;
    public InterfaceC1700x0 stream;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 24 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.MODIFY_AUDIO_SETTINGS"), com.llamalab.automate.access.c.f15555p} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.MODIFY_AUDIO_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 e8 = D1.P.l(context, C2541R.string.caption_audio_volume_set).e(this.stream, 0, C2541R.xml.audio_streams);
        e8.v(this.level, 0);
        return e8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.stream);
        dVar.g(this.level);
        dVar.g(this.playSound);
        dVar.g(this.showPopup);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.stream);
        visitor.b(this.level);
        visitor.b(this.playSound);
        visitor.b(this.showPopup);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.stream = (InterfaceC1700x0) cVar.readObject();
        this.level = (InterfaceC1700x0) cVar.readObject();
        this.playSound = (InterfaceC1700x0) cVar.readObject();
        this.showPopup = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_audio_volume_set_title);
        Double j8 = J3.h.j(c1708z0, this.level);
        if (j8 == null) {
            throw new RequiredArgumentNullException("level");
        }
        AudioManager audioManager = (AudioManager) c1708z0.getSystemService("audio");
        int m8 = J3.h.m(c1708z0, this.stream, 0);
        double streamMaxVolume = audioManager.getStreamMaxVolume(m8);
        double b8 = y4.j.b(j8.doubleValue() / 100.0d, 0.0d, 1.0d);
        Double.isNaN(streamMaxVolume);
        Double.isNaN(streamMaxVolume);
        int round = (int) Math.round(((streamMaxVolume - 0.0d) * b8) + 0.0d);
        int i8 = J3.h.f(c1708z0, this.playSound, false) ? 20 : 0;
        if (J3.h.f(c1708z0, this.showPopup, false)) {
            i8 |= 1;
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            audioManager.setStreamVolume(m8, round, i8);
            Binder.restoreCallingIdentity(clearCallingIdentity);
            c1708z0.f17642x0 = this.onComplete;
            return true;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
