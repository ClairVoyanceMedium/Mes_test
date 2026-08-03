package com.llamalab.automate.stmt;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.RequiredArgumentNullException;

@F3.f("app_kill_background.html")
@F3.a(C2541R.integer.ic_app_terminate)
@F3.i(C2541R.string.stmt_app_kill_background_title)
@F3.h(C2541R.string.stmt_app_kill_background_summary)
@F3.e(C2541R.layout.stmt_app_kill_background_edit)
/* loaded from: classes.dex */
public final class AppKillBackground extends PackageAction implements AsyncStatement {

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final String f16257M1;

        public a(String str) {
            this.f16257M1 = str;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.z1(t3.o.b(), lVar, this.f16257M1);
                lVar.c();
                p2(null);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 34 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.KILL_BACKGROUND_PROCESSES")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_app_kill_background).o(0, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_app_kill_background_title);
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("packageName");
        }
        if (c1708z0.getPackageName().equals(x7)) {
            throw new SecurityException("Killing Automate is not permitted");
        }
        if (34 <= Build.VERSION.SDK_INT) {
            c1708z0.w(new a(x7));
            return false;
        }
        ((ActivityManager) c1708z0.getSystemService("activity")).killBackgroundProcesses(x7);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
