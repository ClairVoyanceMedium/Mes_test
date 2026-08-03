package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.llamalab.auth3p.MicrosoftClient;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("wired_headset.html")
@F3.a(C2541R.integer.ic_hardware_headset)
@F3.i(C2541R.string.stmt_wired_headset_title)
@F3.h(C2541R.string.stmt_wired_headset_summary)
@F3.e(C2541R.layout.stmt_wired_headset_edit)
/* loaded from: classes.dex */
public final class WiredHeadset extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 ignoreHeadphone;
    public J3.l varDisplayName;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final boolean f17324x1;

        public a(boolean z7) {
            this.f17324x1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast() || intent.getBooleanExtra("com.llamalab.automate.intent.extra.HACK", false)) {
                return;
            }
            if (this.f17324x1 && intent.getIntExtra("microphone", 0) == 0) {
                return;
            }
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(intent.getIntExtra(com.llamalab.auth3p.e.PARAM_STATE, 0) != 0);
            objArr[1] = intent.getStringExtra(MicrosoftClient.PROP_NAME);
            c(intent, objArr, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_wired_headset_immediate, C2541R.string.caption_wired_headset_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        String str = (String) objArr[1];
        J3.l lVar = this.varDisplayName;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        o(c1708z0, booleanValue);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (106 <= dVar.f6413Z) {
            dVar.g(this.ignoreHeadphone);
            dVar.g(this.varDisplayName);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.ignoreHeadphone);
        visitor.b(this.varDisplayName);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (106 <= cVar.f6409x0) {
            this.ignoreHeadphone = (InterfaceC1700x0) cVar.readObject();
            this.varDisplayName = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_wired_headset_title);
        boolean z7 = false;
        boolean f8 = J3.h.f(c1708z0, this.ignoreHeadphone, false);
        if (J1(1) != 0) {
            a aVar = new a(f8);
            c1708z0.w(aVar);
            aVar.h("android.intent.action.HEADSET_PLUG");
            return false;
        }
        Intent registerReceiver = c1708z0.registerReceiver(null, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        if (registerReceiver == null) {
            J3.l lVar = this.varDisplayName;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return true;
        }
        if (registerReceiver.getIntExtra(com.llamalab.auth3p.e.PARAM_STATE, 0) != 0 && (!f8 || registerReceiver.getIntExtra("microphone", 0) != 0)) {
            z7 = true;
        }
        String stringExtra = registerReceiver.getStringExtra(MicrosoftClient.PROP_NAME);
        J3.l lVar2 = this.varDisplayName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, stringExtra);
        }
        o(c1708z0, z7);
        return true;
    }
}
