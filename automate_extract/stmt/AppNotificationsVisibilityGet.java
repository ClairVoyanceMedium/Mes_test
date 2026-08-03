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

@F3.f("app_notifications_visibility_get.html")
@F3.a(C2541R.integer.ic_notification_app)
@F3.i(C2541R.string.stmt_app_notifications_visibility_get_title)
@F3.h(C2541R.string.stmt_app_notifications_visibility_get_summary)
@F3.e(C2541R.layout.stmt_app_notifications_visibility_get_edit)
/* loaded from: classes.dex */
public final class AppNotificationsVisibilityGet extends Action implements AsyncStatement {
    public InterfaceC1700x0 packageName;
    public J3.l varVisibility;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final String f16269M1;

        public a(String str) {
            this.f16269M1 = str;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            String str = this.f16269M1;
            try {
                int a8 = t3.o.a(this.f15400Y.getPackageManager().getApplicationInfo(str, 0).uid);
                t3.l lVar = new t3.l();
                int X12 = interfaceC1585h1.X1(a8, lVar, str);
                lVar.c();
                q2(Double.valueOf(X12), false);
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
        return D1.P.l(context, C2541R.string.caption_app_notifications_visibility_get).o(0, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        dVar.g(this.varVisibility);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.packageName);
        visitor.b(this.varVisibility);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.varVisibility = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_app_notifications_visibility_get_title);
        int i8 = Build.VERSION.SDK_INT;
        if (21 > i8) {
            throw new IncapableAndroidVersionException(21, "Notification visibility override");
        }
        if (26 < i8) {
            throw new IncapableAndroidVersionException(26, "Notification visibility override");
        }
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("packageName");
        }
        c1708z0.w(new a(x7));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varVisibility;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
