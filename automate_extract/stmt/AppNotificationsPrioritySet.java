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

@F3.f("app_notifications_priority_set.html")
@F3.a(C2541R.integer.ic_notification_app)
@F3.i(C2541R.string.stmt_app_notifications_priority_set_title)
@F3.h(C2541R.string.stmt_app_notifications_priority_set_summary)
@F3.e(C2541R.layout.stmt_app_notifications_priority_set_edit)
/* loaded from: classes.dex */
public final class AppNotificationsPrioritySet extends Action implements AsyncStatement {
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 priority;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final String f16265M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16266N1;

        public a(String str, int i8) {
            this.f16265M1 = str;
            this.f16266N1 = i8;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            String str = this.f16265M1;
            try {
                int a8 = t3.o.a(this.f15400Y.getPackageManager().getApplicationInfo(str, 0).uid);
                t3.l lVar = new t3.l();
                interfaceC1585h1.f0(a8, this.f16266N1, lVar, str);
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
        return D1.P.l(context, C2541R.string.caption_app_notifications_priority_set).o(0, this.packageName).q(this.packageName).e(this.priority, 2, C2541R.xml.notification_priorities).q(this.priority).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        dVar.g(this.priority);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.packageName);
        visitor.b(this.priority);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.priority = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_app_notifications_priority_set_title);
        int i8 = Build.VERSION.SDK_INT;
        if (21 > i8) {
            throw new IncapableAndroidVersionException(21, "Notification priority");
        }
        if (26 < i8) {
            throw new IncapableAndroidVersionException(26, "Notification priority");
        }
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("packageName");
        }
        if (c1708z0.getPackageName().equals(x7)) {
            throw new SecurityException("Changing Automate notifications are not permitted");
        }
        c1708z0.w(new a(x7, J3.h.m(c1708z0, this.priority, 2)));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
