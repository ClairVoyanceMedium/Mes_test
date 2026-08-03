package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import java.util.regex.Pattern;
import x3.C2425c;

@F3.f("plugin_condition.html")
@F3.a(C2541R.integer.ic_plugin_decision)
@F3.i(C2541R.string.stmt_plugin_condition_title)
@F3.h(C2541R.string.stmt_plugin_condition_summary)
@F3.e(C2541R.layout.stmt_plugin_condition_edit)
/* loaded from: classes.dex */
public final class PlugInCondition extends StatefulIntermittentDecision implements ReceiverStatement, AsyncStatement {
    public final C0 plugin = new C0();

    public final void B(C1708z0 c1708z0, boolean z7, Bundle bundle) {
        c1708z0.I(F0.class, this.f16218X);
        c1708z0.I(E0.class, this.f16218X);
        c1708z0.I(G0.class, this.f16218X);
        this.plugin.c(c1708z0, bundle);
        o(c1708z0, z7);
    }

    public final boolean C(C1708z0 c1708z0, int i8, Bundle bundle) {
        if (i8 != -1) {
            if (i8 != 0) {
                if (i8 != 3) {
                    switch (i8) {
                        case 16:
                            break;
                        case 17:
                            break;
                        case 18:
                            break;
                        default:
                            throw new IllegalStateException(B4.g.g("Plug-in returned an illegal result code: ", i8));
                    }
                }
                return false;
            }
            if (!(J1(1) == 0) && Boolean.FALSE.equals((Boolean) c1708z0.j(this.f17164L1))) {
                return false;
            }
            B(c1708z0, false, bundle);
            return true;
        }
        if (!(J1(1) == 0) && Boolean.TRUE.equals((Boolean) c1708z0.j(this.f17164L1))) {
            return false;
        }
        B(c1708z0, true, bundle);
        return true;
    }

    public final void D(C1708z0 c1708z0, E0 e02, G0 g02, Bundle bundle) {
        Intent b8 = this.plugin.b(c1708z0, "com.twofortyfouram.locale.intent.action.QUERY_CONDITION");
        if (bundle != null) {
            b8.putExtra("net.dinglisch.android.tasker.extras.PASS_THROUGH_DATA", bundle);
        }
        if (C0.h(c1708z0, b8, g02.f16676y1) == null) {
            c1708z0.sendOrderedBroadcast(C0.e(c1708z0, b8), null, e02, c1708z0.j2().f14581L1, 18, null, null);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.A(this.plugin.f16398x0);
        int[] iArr = {C2541R.string.caption_plugin_condition_immediate, C2541R.string.caption_plugin_condition_change};
        if (c1596k0.f16031d) {
            c1596k0.k(false);
        } else {
            c1596k0.j(this, 1, iArr);
        }
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Pattern pattern = C0.f16394L1;
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        String action = intent.getAction();
        if ("com.twofortyfouram.locale.intent.action.REQUEST_QUERY".equals(action)) {
            if (a8) {
                c1708z0.p("PlugInCondition ACTION_REQUEST_QUERY");
            }
            D(c1708z0, (E0) c1708z0.d(E0.class, this), (G0) c1708z0.d(G0.class, this), intent.getBundleExtra("net.dinglisch.android.tasker.extras.PASS_THROUGH_DATA"));
            return false;
        }
        if (!"com.twofortyfouram.locale.intent.action.QUERY_CONDITION".equals(action)) {
            return false;
        }
        int resultCode = abstractC1618p2.getResultCode();
        if (a8) {
            c1708z0.p("PlugInCondition ACTION_QUERY_CONDITION: resultCode=" + resultCode);
        }
        return C(c1708z0, resultCode, abstractC1618p2.getResultExtras(false));
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        this.plugin.Y0(dVar);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.plugin);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new C1680y0();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.plugin.o0(cVar);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_plugin_condition_title);
        Pattern pattern = C0.f16394L1;
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        E0 e02 = new E0();
        c1708z0.w(e02);
        e02.m(2, new IntentFilter());
        G0 g02 = new G0(c1708z0.j2().f14581L1);
        c1708z0.w(g02);
        if (!(J1(1) == 0)) {
            if (a8) {
                c1708z0.p("PlugInCondition lastState=" + ((Boolean) c1708z0.j(this.f17164L1)));
            }
            F0 f02 = new F0(this.plugin.f16396Y, a8);
            c1708z0.w(f02);
            f02.o(2, "com.twofortyfouram.locale.intent.action.REQUEST_QUERY");
        }
        D(c1708z0, e02, g02, null);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        Pattern pattern = C0.f16394L1;
        if (C1710z2.a(C2425c.c(c1708z0))) {
            c1708z0.p("PlugInCondition PlugInResultReceiverTask: resultCode=" + objArr[0]);
        }
        return C(c1708z0, ((Integer) objArr[0]).intValue(), (Bundle) objArr[1]);
    }
}
