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

@F3.f("ringer_mode.html")
@F3.a(C2541R.integer.ic_task)
@F3.i(C2541R.string.stmt_ringer_mode_title)
@F3.h(C2541R.string.stmt_ringer_mode_summary)
@F3.e(C2541R.layout.stmt_ringer_mode_edit)
/* loaded from: classes.dex */
public final class RingerMode extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 mode;
    public J3.l varCurrentMode;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public int f17072L1;

        /* renamed from: x1, reason: collision with root package name */
        public final int f17073x1;

        /* renamed from: y1, reason: collision with root package name */
        public final boolean f17074y1;

        public a(int i8, boolean z7) {
            this.f17073x1 = i8;
            this.f17074y1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            int intExtra = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", -1);
            this.f17072L1 = intExtra;
            if (intExtra != -1) {
                if (this.f17074y1 != (this.f17073x1 == intExtra)) {
                    b(intent);
                }
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_ringer_mode_immediate, C2541R.string.caption_ringer_mode_change);
        return c1596k0.e(this.mode, 2, C2541R.xml.ringer_modes).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        boolean z7 = !((a) abstractC1618p2).f17074y1;
        Double valueOf = Double.valueOf(r4.f17072L1);
        J3.l lVar = this.varCurrentMode;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, valueOf);
        }
        o(c1708z0, z7);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.mode);
        if (38 <= dVar.f6413Z) {
            dVar.g(this.varCurrentMode);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.mode);
        visitor.b(this.varCurrentMode);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.mode = (InterfaceC1700x0) cVar.readObject();
        if (38 <= cVar.f6409x0) {
            this.varCurrentMode = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_ringer_mode_title);
        int m8 = J3.h.m(c1708z0, this.mode, 2);
        int ringerMode = ((AudioManager) c1708z0.getSystemService("audio")).getRingerMode();
        boolean z7 = m8 == ringerMode;
        if (J1(1) != 0) {
            a aVar = new a(m8, z7);
            c1708z0.w(aVar);
            aVar.h("android.media.RINGER_MODE_CHANGED");
            return false;
        }
        Double valueOf = Double.valueOf(ringerMode);
        J3.l lVar = this.varCurrentMode;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, valueOf);
        }
        o(c1708z0, z7);
        return true;
    }
}
