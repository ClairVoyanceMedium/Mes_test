package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("tone_play.html")
@F3.a(C2541R.integer.ic_note)
@F3.i(C2541R.string.stmt_tone_play_title)
@F3.h(C2541R.string.stmt_tone_play_summary)
@F3.e(C2541R.layout.stmt_tone_play_edit)
/* loaded from: classes.dex */
public final class TonePlay extends IntermittentAction implements AsyncStatement {
    public InterfaceC1700x0 duration;
    public InterfaceC1700x0 stream;
    public InterfaceC1700x0 tone;
    public InterfaceC1700x0 volume;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_tone_play).e(this.tone, 24, C2541R.xml.tones).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        r(dVar, 77);
        dVar.g(this.stream);
        if (94 <= dVar.f6413Z) {
            dVar.g(this.volume);
        }
        dVar.g(this.tone);
        dVar.g(this.duration);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.stream);
        visitor.b(this.volume);
        visitor.b(this.tone);
        visitor.b(this.duration);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        q(cVar, 77);
        this.stream = (InterfaceC1700x0) cVar.readObject();
        if (94 <= cVar.f6409x0) {
            this.volume = (InterfaceC1700x0) cVar.readObject();
        }
        this.tone = (InterfaceC1700x0) cVar.readObject();
        this.duration = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_tone_play_title);
        c1708z0.H(p1.class);
        int m8 = J3.h.m(c1708z0, this.stream, 8);
        int m9 = J3.h.m(c1708z0, this.volume, 100);
        int m10 = J3.h.m(c1708z0, this.tone, 24);
        long t8 = J3.h.t(c1708z0, this.duration, -1L);
        boolean z7 = J1(0) == 0;
        p1 p1Var = new p1(m8, y4.j.d(m9, 0, 100));
        c1708z0.w(p1Var);
        if (t8 < 0) {
            p1Var.f17496y1.startTone(m10);
        } else {
            int min = (int) Math.min(t8, 2147483647L);
            p1Var.f17496y1.startTone(m10, min);
            p1Var.f17495L1 = !z7;
            p1Var.f15400Y.f14581L1.postDelayed(p1Var, min);
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
