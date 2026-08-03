package com.llamalab.automate.stmt;

import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.Visitor;

@F3.f("sound_stop.html")
@F3.a(C2541R.integer.ic_note_stop)
@F3.i(C2541R.string.stmt_sound_stop_title)
@F3.h(C2541R.string.stmt_sound_stop_summary)
@F3.c(C2541R.string.caption_sound_stop)
@F3.e(C2541R.layout.stmt_sound_stop_edit)
/* loaded from: classes.dex */
public class SoundStop extends Action {
    public J3.l varStopPosition;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (22 <= dVar.f6413Z) {
            dVar.g(this.varStopPosition);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.varStopPosition);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (22 <= cVar.f6409x0) {
            this.varStopPosition = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_sound_stop_title);
        C1632a1 c1632a1 = (C1632a1) c1708z0.c(C1632a1.class);
        if (c1632a1 != null) {
            J3.l lVar = this.varStopPosition;
            if (lVar != null) {
                try {
                    double currentPosition = c1632a1.f17382L1.getCurrentPosition();
                    Double.isNaN(currentPosition);
                    Double.isNaN(currentPosition);
                    c1708z0.z(lVar.f4659Y, Double.valueOf(currentPosition / 1000.0d));
                } catch (Throwable unused) {
                    c1708z0.z(this.varStopPosition.f4659Y, null);
                }
            }
            c1632a1.a();
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
