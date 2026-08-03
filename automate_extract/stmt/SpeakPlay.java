package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.Locale;

@F3.f("speak_play.html")
@F3.a(C2541R.integer.ic_megaphone)
@F3.i(C2541R.string.stmt_speak_play_title)
@F3.h(C2541R.string.stmt_speak_play_summary)
@F3.e(C2541R.layout.stmt_speak_play_edit)
/* loaded from: classes.dex */
public final class SpeakPlay extends AudioPlaybackAction implements AsyncStatement {
    public InterfaceC1700x0 engine;
    public InterfaceC1700x0 language;
    public InterfaceC1700x0 message;
    public InterfaceC1700x0 offline;
    public InterfaceC1700x0 rate;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_speak_play_title);
        l8.v(this.message, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.AudioPlaybackAction, com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.engine);
        if (77 <= dVar.f6413Z) {
            dVar.g(this.offline);
        }
        dVar.g(this.language);
        dVar.g(this.message);
        if (67 <= dVar.f6413Z) {
            dVar.g(this.rate);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.stream);
        visitor.b(this.volume);
        visitor.b(this.focus);
        visitor.b(this.notificationChannelId);
        visitor.b(this.engine);
        visitor.b(this.offline);
        visitor.b(this.language);
        visitor.b(this.message);
        visitor.b(this.rate);
    }

    @Override // com.llamalab.automate.stmt.AudioPlaybackAction, com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.engine = (InterfaceC1700x0) cVar.readObject();
        if (77 <= cVar.f6409x0) {
            this.offline = (InterfaceC1700x0) cVar.readObject();
        }
        this.language = (InterfaceC1700x0) cVar.readObject();
        this.message = (InterfaceC1700x0) cVar.readObject();
        if (67 <= cVar.f6409x0) {
            this.rate = (InterfaceC1700x0) cVar.readObject();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
    
        r3 = android.speech.tts.TextToSpeech.getMaxSpeechInputLength();
     */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        int maxSpeechInputLength;
        c1708z0.q(C2541R.string.stmt_speak_play_title);
        c1708z0.I(C1635b1.class, this.f16218X);
        String x7 = J3.h.x(c1708z0, this.message, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("message");
        }
        if (18 <= Build.VERSION.SDK_INT && x7.length() > maxSpeechInputLength) {
            throw new IllegalArgumentException(C1.H0.o("Message to long, max ", maxSpeechInputLength, " characters"));
        }
        String x8 = J3.h.x(c1708z0, this.engine, null);
        boolean f8 = J3.h.f(c1708z0, this.offline, false);
        Locale r8 = J3.h.r(c1708z0, this.language, null);
        double i8 = J3.h.i(c1708z0, this.rate, 100.0d) / 100.0d;
        int m8 = J3.h.m(c1708z0, this.stream, 5);
        float l8 = J3.h.l(c1708z0, this.volume, 100.0f) / 100.0f;
        int m9 = J3.h.m(c1708z0, this.focus, 3);
        int i9 = 4 == m9 ? 2 : m9;
        String x9 = J3.h.x(c1708z0, this.notificationChannelId, null);
        boolean z7 = J1(1) == 0;
        C1635b1 c1635b1 = new C1635b1(!z7, x8, r8, x7, f8 ? 1 : 0, (float) i8, m8, l8, i9);
        c1708z0.w(c1635b1);
        if (x9 != null) {
            c1635b1.z2(c1708z0, x9, C2541R.drawable.ic_stat_notify_bullhorn, C2541R.string.stmt_speak_play_title);
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
