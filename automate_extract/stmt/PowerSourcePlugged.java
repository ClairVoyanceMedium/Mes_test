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

@F3.f("power_source_plugged.html")
@F3.a(C2541R.integer.ic_power_plug)
@F3.i(C2541R.string.stmt_power_source_plugged_title)
@F3.h(C2541R.string.stmt_power_source_plugged_summary)
@F3.e(C2541R.layout.stmt_power_source_plugged_edit)
/* loaded from: classes.dex */
public final class PowerSourcePlugged extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 sources;
    public J3.l varCurrentSource;

    public static class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final int f17045x1;

        /* renamed from: y1, reason: collision with root package name */
        public final boolean f17046y1;

        public a(int i8, boolean z7) {
            this.f17045x1 = i8;
            this.f17046y1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            int intExtra = intent.getIntExtra("plugged", 0);
            boolean z7 = (this.f17045x1 & intExtra) != 0;
            boolean z8 = this.f17046y1;
            if (z8 != z7) {
                c(intent, new Object[]{Boolean.valueOf(!z8), Integer.valueOf(intExtra)}, false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_power_source_plugged_immediate, C2541R.string.caption_power_source_plugged_change);
        c1596k0.h(this.sources, null, C2541R.xml.power_sources);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        int intValue = ((Integer) objArr[1]).intValue();
        J3.l lVar = this.varCurrentSource;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, intValue != 0 ? Double.valueOf(intValue) : null);
        }
        o(c1708z0, booleanValue);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (38 <= dVar.f6413Z) {
            dVar.g(this.sources);
        }
        if (19 <= dVar.f6413Z) {
            dVar.g(this.varCurrentSource);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.sources);
        visitor.b(this.varCurrentSource);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (38 <= cVar.f6409x0) {
            this.sources = (InterfaceC1700x0) cVar.readObject();
        }
        if (19 <= cVar.f6409x0) {
            this.varCurrentSource = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_power_source_plugged_title);
        int m8 = J3.h.m(c1708z0, this.sources, 7) & 7;
        Intent registerReceiver = c1708z0.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("plugged", 0) : 0;
        boolean z7 = (intExtra & m8) != 0;
        if (J1(1) != 0) {
            a aVar = new a(m8, z7);
            c1708z0.w(aVar);
            aVar.h("android.intent.action.BATTERY_CHANGED");
            return false;
        }
        J3.l lVar = this.varCurrentSource;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, intExtra != 0 ? Double.valueOf(intExtra) : null);
        }
        o(c1708z0, z7);
        return true;
    }
}
