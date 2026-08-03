package com.llamalab.automate.stmt;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.R1;
import com.llamalab.automate.Visitor;

@F3.f("interruption_filter.html")
@F3.a(C2541R.integer.ic_device_access_dnd)
@F3.i(C2541R.string.stmt_interruption_filter_title)
@F3.h(C2541R.string.stmt_interruption_filter_summary)
@F3.e(C2541R.layout.stmt_interruption_filter_edit)
/* loaded from: classes.dex */
public final class InterruptionFilter extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 filter;
    public J3.l varCurrentFilter;

    public static final class a extends R1 {

        /* renamed from: L1, reason: collision with root package name */
        public boolean f16808L1;

        /* renamed from: y1, reason: collision with root package name */
        public final int f16809y1;

        public a(int i8, boolean z7) {
            this.f16809y1 = i8;
            this.f16808L1 = z7;
        }

        @Override // com.llamalab.automate.R1, com.llamalab.automate.Z1
        public final void R(int i8) {
            if (i8 > 0) {
                int i9 = 1 << (i8 - 1);
                int i10 = this.f16809y1;
                boolean z7 = i10 == 0 || (i10 & i9) != 0;
                if (this.f16808L1 != z7) {
                    this.f16808L1 = z7;
                    q2(new Object[]{Boolean.valueOf(z7), Double.valueOf(i9)}, false);
                }
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return (23 > i8 || J1(1) != 0) ? 21 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.f15554o} : com.llamalab.automate.access.c.f15562w : new E3.b[]{com.llamalab.automate.access.c.f15555p};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_interruption_filter_immediate, C2541R.string.caption_interruption_filter_change);
        c1596k0.h(this.filter, 0, C2541R.xml.interruption_filters_short);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.filter);
        dVar.g(this.varCurrentFilter);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.filter);
        visitor.b(this.varCurrentFilter);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.filter = (InterfaceC1700x0) cVar.readObject();
        this.varCurrentFilter = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_interruption_filter_title);
        IncapableAndroidVersionException.a(21);
        int m8 = J3.h.m(c1708z0, this.filter, 0) & 15;
        boolean z7 = J1(1) == 0;
        int currentInterruptionFilter = (23 > Build.VERSION.SDK_INT || !z7) ? AbstractStatement.j().getCurrentInterruptionFilter() : ((NotificationManager) c1708z0.getSystemService("notification")).getCurrentInterruptionFilter();
        if (currentInterruptionFilter <= 0) {
            throw new IllegalStateException("Failed to get current interruption filter");
        }
        int i8 = 1 << (currentInterruptionFilter - 1);
        if (!z7) {
            c1708z0.w(new a(m8, (i8 & m8) != 0));
            return false;
        }
        boolean z8 = m8 == 0 || (m8 & i8) != 0;
        Double valueOf = Double.valueOf(i8);
        J3.l lVar = this.varCurrentFilter;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, valueOf);
        }
        o(c1708z0, z8);
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        Double d8 = (Double) objArr[1];
        J3.l lVar = this.varCurrentFilter;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, booleanValue);
        return true;
    }
}
