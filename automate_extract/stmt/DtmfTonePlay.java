package com.llamalab.automate.stmt;

import B.C0281h;
import android.content.Context;
import android.os.Build;
import android.telecom.Call;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateInCallService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Iterator;

@F3.f("dtmf_tone_play.html")
@F3.a(C2541R.integer.ic_note)
@F3.i(C2541R.string.stmt_dtmf_tone_play_title)
@F3.h(C2541R.string.stmt_dtmf_tone_play_summary)
@F3.e(C2541R.layout.stmt_dtmf_tone_play_edit)
/* loaded from: classes.dex */
public final class DtmfTonePlay extends IntermittentAction implements AsyncStatement {
    public InterfaceC1700x0 duration;
    public InterfaceC1700x0 tone;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 31 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15552m} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_dtmf_tone_play).e(this.tone, 10, C2541R.xml.dtmf_tones).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.tone);
        dVar.g(this.duration);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.tone);
        visitor.b(this.duration);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.tone = (InterfaceC1700x0) cVar.readObject();
        this.duration = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Call call;
        int state;
        c1708z0.q(C2541R.string.stmt_dtmf_tone_play_title);
        IncapableAndroidVersionException.b(31, "in-call service");
        c1708z0.H(C.class);
        int m8 = J3.h.m(c1708z0, this.tone, 10);
        long t8 = J3.h.t(c1708z0, this.duration, -1L);
        boolean z7 = J1(0) == 0;
        if (m8 < 0 || m8 >= 12) {
            throw new IllegalArgumentException("tone");
        }
        char charAt = "0123456789*#".charAt(m8);
        AutomateInCallService automateInCallService = AutomateInCallService.f14550X.get();
        if (automateInCallService != null) {
            Iterator<Call> it = automateInCallService.getCalls().iterator();
            while (true) {
                if (!it.hasNext()) {
                    call = null;
                    break;
                }
                call = C0281h.k(it.next());
                state = call.getState();
                if (4 == state) {
                    break;
                }
            }
            if (call != null) {
                C c8 = new C(call);
                c1708z0.w(c8);
                if (t8 < 0) {
                    Call call2 = c8.f16392y1;
                    call2.playDtmfTone(charAt);
                    call2.registerCallback(c8.f16391M1, c8.f15400Y.f14581L1);
                } else {
                    c8.f16390L1 = !z7;
                    Call call3 = c8.f16392y1;
                    call3.playDtmfTone(charAt);
                    call3.registerCallback(c8.f16391M1, c8.f15400Y.f14581L1);
                    c8.f15400Y.f14581L1.postDelayed(c8, t8);
                }
                if (!z7) {
                    return false;
                }
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
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
