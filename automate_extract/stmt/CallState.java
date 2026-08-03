package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1594j2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("call_state.html")
@F3.a(C2541R.integer.ic_call_state)
@F3.i(C2541R.string.stmt_call_state_title)
@F3.h(C2541R.string.stmt_call_state_summary)
@F3.e(C2541R.layout.stmt_call_state_edit)
/* loaded from: classes.dex */
public final class CallState extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 state;
    public InterfaceC1700x0 subscriptionId;

    public static final class a extends C1594j2 {

        /* renamed from: O1, reason: collision with root package name */
        public final int f16420O1;

        /* renamed from: P1, reason: collision with root package name */
        public final boolean f16421P1;

        public a(int i8, boolean z7, int i9) {
            super(i8);
            this.f16421P1 = z7;
            this.f16420O1 = i9;
        }

        @Override // com.llamalab.automate.C1594j2
        public final void w2(int i8) {
            boolean z7 = this.f16420O1 == i8;
            boolean z8 = this.f16421P1;
            if (z8 != z7) {
                q2(Boolean.valueOf(!z8), false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_call_state_immediate, C2541R.string.caption_call_state_change);
        return c1596k0.e(this.state, 0, C2541R.xml.call_states).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.state);
        if (64 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.state);
        visitor.b(this.subscriptionId);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.state = (InterfaceC1700x0) cVar.readObject();
        if (64 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007f  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        Object invoke;
        int intValue;
        c1708z0.q(C2541R.string.stmt_call_state_title);
        int m8 = J3.h.m(c1708z0, this.state, 0);
        int m9 = J3.h.m(c1708z0, this.subscriptionId, w3.n.e());
        TelephonyManager telephonyManager = (TelephonyManager) c1708z0.getSystemService("phone");
        int i8 = Build.VERSION.SDK_INT;
        if (24 > i8) {
            if (22 <= i8) {
                invoke = telephonyManager.getClass().getMethod("getCallState", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(m9));
            } else if (21 <= i8) {
                invoke = telephonyManager.getClass().getMethod("getCallState", Long.TYPE).invoke(telephonyManager, Long.valueOf(w3.n.a(m9)));
            }
            intValue = ((Integer) invoke).intValue();
            if (J1(1) != 0) {
                o(c1708z0, intValue == m8);
                return true;
            }
            a aVar = new a(m9, intValue == m8, m8);
            c1708z0.w(aVar);
            aVar.v2(32);
            return false;
        }
        telephonyManager = telephonyManager.createForSubscriptionId(m9);
        intValue = telephonyManager.getCallState();
        if (J1(1) != 0) {
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
