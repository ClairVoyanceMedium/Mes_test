package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1594j2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("cell_signal_level.html")
@F3.a(C2541R.integer.ic_cell_signal)
@F3.i(C2541R.string.stmt_cell_signal_level_title)
@F3.h(C2541R.string.stmt_cell_signal_level_summary)
@F3.e(C2541R.layout.stmt_cell_signal_level_edit)
/* loaded from: classes.dex */
public final class CellSignalLevel extends LevelDecision implements AsyncStatement {
    public InterfaceC1700x0 subscriptionId;

    public static final class a extends C1594j2 {

        /* renamed from: O1, reason: collision with root package name */
        public final Double f16431O1;

        /* renamed from: P1, reason: collision with root package name */
        public final Double f16432P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final boolean f16433Q1;

        /* renamed from: R1, reason: collision with root package name */
        public double f16434R1;

        /* renamed from: S1, reason: collision with root package name */
        public boolean f16435S1;

        /* renamed from: T1, reason: collision with root package name */
        public boolean f16436T1;
        public boolean U1;

        public a(int i8, Double d8, Double d9, boolean z7) {
            super(i8);
            this.U1 = true;
            this.f16433Q1 = z7;
            this.f16431O1 = d8;
            this.f16432P1 = d9;
        }

        public final void B2(double d8) {
            boolean z7 = this.f16433Q1;
            Double d9 = this.f16431O1;
            Double d10 = this.f16432P1;
            if (z7) {
                q2(new Object[]{Boolean.valueOf(LevelDecision.E(d8, d9, d10)), Double.valueOf(d8)}, false);
                return;
            }
            if (d9 != null || d10 != null) {
                boolean E7 = LevelDecision.E(d8, d9, d10);
                if (this.U1) {
                    this.U1 = false;
                } else if (this.f16435S1 != E7) {
                    q2(new Object[]{Boolean.valueOf(E7), Double.valueOf(d8)}, false);
                }
                this.f16435S1 = E7;
                return;
            }
            if (this.U1) {
                this.U1 = false;
            } else {
                double d11 = this.f16434R1;
                int i8 = y4.j.f23551b;
                if (!(d11 == d8 || Math.abs(d11 - d8) <= y4.j.f23550a)) {
                    q2(new Object[]{Boolean.TRUE, Double.valueOf(d8)}, false);
                }
            }
            this.f16434R1 = d8;
        }

        @Override // com.llamalab.automate.C1594j2
        public final void y2(ServiceState serviceState) {
            boolean z7 = 3 == serviceState.getState();
            this.f16436T1 = z7;
            if (z7) {
                B2(0.0d);
            }
        }

        @Override // com.llamalab.automate.C1594j2
        public final void z2(SignalStrength signalStrength) {
            if (this.f16436T1) {
                return;
            }
            B2(w3.o.b(signalStrength) * 100.0f);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_COARSE_LOCATION")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_cell_signal_level_immediate, C2541R.string.caption_cell_signal_level_change);
        c1596k0.n(this.minLevel, this.maxLevel, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (72 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.subscriptionId);
    }

    @Override // com.llamalab.automate.stmt.LevelDecision, com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (72 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_cell_signal_level_title);
        a aVar = new a(J3.h.m(c1708z0, this.subscriptionId, w3.n.d()), D(c1708z0), C(c1708z0), J1(1) == 0);
        c1708z0.w(aVar);
        aVar.v2(MoreOsConstants.BTN_1);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (Double) objArr[1]);
        return true;
    }
}
