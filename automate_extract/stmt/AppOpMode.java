package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("app_op_mode.html")
@F3.a(C2541R.integer.ic_handcuffs)
@F3.i(C2541R.string.stmt_app_op_mode_title)
@F3.h(C2541R.string.stmt_app_op_mode_summary)
@F3.e(C2541R.layout.stmt_app_op_mode_edit)
/* loaded from: classes.dex */
public final class AppOpMode extends Decision implements AsyncStatement {
    public InterfaceC1700x0 mode;
    public InterfaceC1700x0 opstr;
    public InterfaceC1700x0 packageName;
    public J3.l varCurrentMode;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final String f16272M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16273N1;

        public a(String str, int i8) {
            this.f16272M1 = str;
            this.f16273N1 = i8;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                int i8 = Build.VERSION.SDK_INT;
                String str = this.f16272M1;
                int packageUid = 24 <= i8 ? this.f15400Y.getPackageManager().getPackageUid(str, 0) : t3.o.a(this.f15400Y.getPackageManager().getApplicationInfo(str, 0).uid);
                t3.l lVar = new t3.l();
                int t22 = interfaceC1585h1.t2(this.f16273N1, packageUid, lVar, str);
                lVar.c();
                q2(Integer.valueOf(t22), false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_app_op_mode);
        l8.h(this.mode, 1, C2541R.xml.app_op_modes);
        return l8.f(this.opstr, null, C2541R.xml.app_ops).o(2, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        dVar.g(this.opstr);
        dVar.g(this.mode);
        dVar.g(this.varCurrentMode);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.packageName);
        visitor.b(this.opstr);
        visitor.b(this.mode);
        visitor.b(this.varCurrentMode);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.opstr = (InterfaceC1700x0) cVar.readObject();
        this.mode = (InterfaceC1700x0) cVar.readObject();
        this.varCurrentMode = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_app_op_mode_title);
        IncapableAndroidVersionException.a(18);
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("packageName");
        }
        String x8 = J3.h.x(c1708z0, this.opstr, null);
        if (x8 == null) {
            throw new RequiredArgumentNullException("opstr");
        }
        com.llamalab.android.app.c g8 = com.llamalab.android.app.c.g(x8);
        IncapableAndroidVersionException.b(g8.f14138Z, "operation ".concat(x8));
        c1708z0.w(new a(x7, g8.f14136X));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        int i8;
        int m8 = J3.h.m(c1708z0, this.mode, 1);
        int intValue = ((Integer) obj).intValue();
        if (intValue != 0) {
            i8 = 2;
            if (intValue != 1) {
                if (intValue == 2) {
                    i8 = 4;
                } else if (intValue == 3) {
                    i8 = 8;
                } else {
                    if (intValue != 4) {
                        throw new IllegalStateException("Unknown mode: " + obj);
                    }
                    i8 = 16;
                }
            }
        } else {
            i8 = 1;
        }
        J3.l lVar = this.varCurrentMode;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, Double.valueOf(i8));
        }
        o(c1708z0, (m8 & i8) != 0);
        return true;
    }
}
