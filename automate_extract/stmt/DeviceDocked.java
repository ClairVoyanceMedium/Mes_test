package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("device_docked.html")
@F3.a(C2541R.integer.ic_device_dock)
@F3.i(C2541R.string.stmt_device_docked_title)
@F3.h(C2541R.string.stmt_device_docked_summary)
@F3.e(C2541R.layout.stmt_device_docked_edit)
/* loaded from: classes.dex */
public final class DeviceDocked extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 modes;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_device_docked_immediate, C2541R.string.caption_device_docked_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        int intExtra;
        boolean z7 = false;
        int m8 = J3.h.m(c1708z0, this.modes, 0);
        if (intent != null && (intExtra = intent.getIntExtra("android.intent.extra.DOCK_STATE", 0)) != 0 && (m8 & (1 << intExtra)) != 0) {
            z7 = true;
        }
        o(c1708z0, z7);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.modes);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.modes);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.modes = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int intExtra;
        c1708z0.q(C2541R.string.stmt_device_docked_title);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOCK_EVENT");
        boolean z7 = false;
        if (J1(1) != 0) {
            AbstractC1618p2.c.a aVar = new AbstractC1618p2.c.a();
            c1708z0.w(aVar);
            aVar.q(intentFilter);
            return false;
        }
        int m8 = J3.h.m(c1708z0, this.modes, 0);
        Intent registerReceiver = c1708z0.registerReceiver(null, intentFilter);
        if (registerReceiver != null && (intExtra = registerReceiver.getIntExtra("android.intent.extra.DOCK_STATE", 0)) != 0 && ((1 << intExtra) & m8) != 0) {
            z7 = true;
        }
        o(c1708z0, z7);
        return true;
    }
}
