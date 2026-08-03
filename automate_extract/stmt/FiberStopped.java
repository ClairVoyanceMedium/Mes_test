package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.FlowStore;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import g4.C1827a;
import i0.C1896a;
import m3.C2145c;

@F3.f("fiber_stopped.html")
@F3.a(C2541R.integer.ic_content_merge)
@F3.i(C2541R.string.stmt_fiber_stopped_title)
@F3.h(C2541R.string.stmt_fiber_stopped_summary)
@F3.e(C2541R.layout.stmt_fiber_stopped_edit)
/* loaded from: classes.dex */
public final class FiberStopped extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 fiberUri;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_fiber_stopped_immediate, C2541R.string.caption_fiber_stopped_stopped);
        c1596k0.p(this.fiberUri, -4, '/');
        return c1596k0.q(this.fiberUri).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, true);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.fiberUri);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.fiberUri);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.fiberUri = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0056, code lost:
    
        if (r3.d(r0, "flow_version=" + r4.f14848y1) != 0) goto L15;
     */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        boolean z7;
        boolean z8;
        c1708z0.q(C2541R.string.stmt_fiber_stopped_title);
        Uri A7 = J3.h.A(c1708z0, this.fiberUri, null);
        if (A7 == null) {
            o(c1708z0, true);
            return true;
        }
        AutomateService j22 = c1708z0.j2();
        j22.getClass();
        if (5 != C1827a.m.a(A7)) {
            throw new IllegalArgumentException("Not a fiber URI");
        }
        FlowStore flowStore = j22.f14588S1;
        if (!flowStore.f14942a.containsKey(Long.valueOf(C2145c.b(A7, 3)))) {
            com.llamalab.automate.F0 f8 = flowStore.f(C2145c.a(A7, 2));
            if (f8 != null) {
            }
            z7 = false;
            z8 = !z7;
            if (!z8 || J1(1) == 0) {
                o(c1708z0, z8);
                return true;
            }
            IntentFilter intentFilter = new IntentFilter("com.llamalab.automate.intent.action.FIBER_STOPPED");
            intentFilter.addDataScheme(A7.getScheme());
            intentFilter.addDataAuthority(A7.getAuthority(), null);
            intentFilter.addDataPath(A7.getPath(), 0);
            intentFilter.addDataType("vnd.android.cursor.item/vnd.com.llamalab.automate.provider.fiber");
            AbstractC1618p2.a aVar = new AbstractC1618p2.a();
            c1708z0.w(aVar);
            C1896a.a(aVar.f16157Y).b(aVar, intentFilter);
            return false;
        }
        z7 = true;
        z8 = !z7;
        if (z8) {
        }
        o(c1708z0, z8);
        return true;
    }
}
