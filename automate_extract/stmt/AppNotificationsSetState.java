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

@F3.f("app_notifications_set_state.html")
@F3.a(C2541R.integer.ic_notification_app)
@F3.i(C2541R.string.stmt_app_notifications_set_state_title)
@F3.h(C2541R.string.stmt_app_notifications_set_state_summary)
@F3.e(C2541R.layout.stmt_app_notifications_set_state_edit)
/* loaded from: classes.dex */
public final class AppNotificationsSetState extends Action implements AsyncStatement {
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 state;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final String f16267M1;

        /* renamed from: N1, reason: collision with root package name */
        public final boolean f16268N1;

        public a(String str, boolean z7) {
            this.f16267M1 = str;
            this.f16268N1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                int i8 = Build.VERSION.SDK_INT;
                String str = this.f16267M1;
                int a8 = 18 <= i8 ? t3.o.a(this.f15400Y.getPackageManager().getApplicationInfo(str, 0).uid) : -2;
                t3.l lVar = new t3.l();
                interfaceC1585h1.i0(str, a8, this.f16268N1, lVar);
                lVar.c();
                p2(null);
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
        return new C1596k0(context).z(this.state, true, C2541R.string.caption_app_notifications_enable, C2541R.string.caption_app_notifications_disable).r(C2541R.string.caption_app_notifications_set_state).b(this.state).o(0, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        dVar.g(this.state);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.packageName);
        visitor.b(this.state);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.state = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_app_notifications_set_state_title);
        IncapableAndroidVersionException.a(16);
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("packageName");
        }
        if (c1708z0.getPackageName().equals(x7)) {
            throw new SecurityException("Changing Automate notifications are not permitted");
        }
        c1708z0.w(new a(x7, J3.h.f(c1708z0, this.state, false)));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
