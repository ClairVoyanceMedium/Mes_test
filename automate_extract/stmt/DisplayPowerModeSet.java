package com.llamalab.automate.stmt;

import L3.C1052q;
import L3.C1053s;
import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.expr.func.Ctz;

@F3.f("display_power_mode_set.html")
@F3.a(C2541R.integer.ic_screen_power_on)
@F3.i(C2541R.string.stmt_display_power_mode_set_title)
@F3.h(C2541R.string.stmt_display_power_mode_set_summary)
@F3.e(C2541R.layout.stmt_display_power_mode_set_edit)
/* loaded from: classes.dex */
public final class DisplayPowerModeSet extends Action implements AsyncStatement {
    public InterfaceC1700x0 displayId;
    public InterfaceC1700x0 mode;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final int f16596M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16597N1;

        public a(int i8, int i9) {
            this.f16596M1 = i8;
            this.f16597N1 = i9;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.L0(this.f16596M1, this.f16597N1, lVar);
                lVar.c();
                p2(null);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 18 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_display_power_mode_set).e(this.mode, 4, C2541R.xml.display_power_modes).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        Object ctz;
        super.Y0(dVar);
        dVar.g(this.displayId);
        if (104 > dVar.f6413Z) {
            InterfaceC1700x0 interfaceC1700x0 = this.mode;
            if (interfaceC1700x0 instanceof L3.K) {
                dVar.g(new L3.J(Integer.numberOfTrailingZeros(J3.h.Q((L3.K) interfaceC1700x0))));
                return;
            } else if (!J3.h.B(interfaceC1700x0)) {
                ctz = new Ctz(this.mode);
                dVar.g(ctz);
            }
        }
        ctz = this.mode;
        dVar.g(ctz);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.displayId);
        visitor.b(this.mode);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.displayId = (InterfaceC1700x0) cVar.readObject();
        int i8 = cVar.f6409x0;
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        this.mode = interfaceC1700x0;
        if (104 <= i8) {
            return;
        }
        if (interfaceC1700x0 instanceof L3.K) {
            this.mode = new C1053s(1 << J3.h.Q((L3.K) interfaceC1700x0));
        } else {
            if (J3.h.B(interfaceC1700x0)) {
                return;
            }
            this.mode = new L3.O(new L3.J(1), new C1052q(this.mode));
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_display_power_mode_set_title);
        IncapableAndroidVersionException.a(18);
        int m8 = J3.h.m(c1708z0, this.displayId, 0);
        int i8 = 4;
        int m9 = J3.h.m(c1708z0, this.mode, 4);
        if (m9 == 2) {
            i8 = 0;
        } else if (m9 == 4) {
            i8 = 2;
        } else if (m9 == 8) {
            i8 = 1;
        } else if (m9 == 16) {
            i8 = 3;
        } else if (m9 != 64) {
            throw new IllegalArgumentException("mode");
        }
        c1708z0.w(new a(m8, i8));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
