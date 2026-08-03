package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("app_op_mode_set.html")
@F3.a(C2541R.integer.ic_handcuffs)
@F3.i(C2541R.string.stmt_app_op_mode_set_title)
@F3.h(C2541R.string.stmt_app_op_mode_set_summary)
@F3.e(C2541R.layout.stmt_app_op_mode_set_edit)
/* loaded from: classes.dex */
public final class AppOpModeSet extends PackageAction implements AsyncStatement {

    /* renamed from: L1, reason: collision with root package name */
    public static final int f16274L1;
    public InterfaceC1700x0 mode;
    public InterfaceC1700x0 opstr;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final String f16275M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16276N1;

        /* renamed from: O1, reason: collision with root package name */
        public final int f16277O1;

        public a(int i8, int i9, String str) {
            this.f16275M1 = str;
            this.f16276N1 = i8;
            this.f16277O1 = i9;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                int i8 = Build.VERSION.SDK_INT;
                String str = this.f16275M1;
                int packageUid = 24 <= i8 ? this.f15400Y.getPackageManager().getPackageUid(str, 0) : t3.o.a(this.f15400Y.getPackageManager().getApplicationInfo(str, 0).uid);
                t3.l lVar = new t3.l();
                interfaceC1585h1.d0(this.f16276N1, packageUid, this.f16275M1, this.f16277O1, lVar);
                lVar.c();
                q2(null, false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    static {
        f16274L1 = 21 >= Build.VERSION.SDK_INT ? 8 : 4;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_app_op_mode_set).e(this.mode, Integer.valueOf(f16274L1), C2541R.xml.app_op_modes).f(this.opstr, null, C2541R.xml.app_ops).o(2, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.PackageAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.opstr);
        dVar.g(this.mode);
    }

    @Override // com.llamalab.automate.stmt.PackageAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.opstr);
        visitor.b(this.mode);
    }

    @Override // com.llamalab.automate.stmt.PackageAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.opstr = (InterfaceC1700x0) cVar.readObject();
        this.mode = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (24 <= r3) goto L30;
     */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_app_op_mode_set_title);
        IncapableAndroidVersionException.a(18);
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("packageName");
        }
        if (c1708z0.getPackageName().equals(x7)) {
            throw new SecurityException("Changing Automate app ops are not permitted");
        }
        String x8 = J3.h.x(c1708z0, this.opstr, null);
        if (x8 == null) {
            throw new RequiredArgumentNullException("opstr");
        }
        com.llamalab.android.app.c g8 = com.llamalab.android.app.c.g(x8);
        int i8 = Build.VERSION.SDK_INT;
        int i9 = g8.f14138Z;
        if (i9 > i8) {
            throw new IncapableAndroidVersionException(i9, "operation ".concat(x8));
        }
        int m8 = J3.h.m(c1708z0, this.mode, f16274L1);
        int i10 = 1;
        if (m8 != 1) {
            if (m8 != 2) {
                i10 = 4;
                if (m8 != 4) {
                    if (m8 != 8) {
                        if (m8 != 16) {
                            throw new IllegalArgumentException("mode");
                        }
                    } else if (21 <= i8) {
                        i10 = 3;
                    }
                }
                i10 = 2;
            }
            c1708z0.w(new a(g8.f14136X, i10, x7));
            return false;
        }
        i10 = 0;
        c1708z0.w(new a(g8.f14136X, i10, x7));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
