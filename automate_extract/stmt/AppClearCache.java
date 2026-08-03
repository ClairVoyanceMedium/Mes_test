package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.RequiredArgumentNullException;

@F3.f("app_clear_cache.html")
@F3.a(C2541R.integer.ic_content_clean)
@F3.i(C2541R.string.stmt_app_clear_cache_title)
@F3.h(C2541R.string.stmt_app_clear_cache_summary)
@F3.e(C2541R.layout.stmt_app_clear_cache_edit)
/* loaded from: classes.dex */
public final class AppClearCache extends PackageAction implements AsyncStatement {

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final String f16240M1;

        public a(String str) {
            this.f16240M1 = str;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.y(this.f16240M1, lVar);
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
        return D1.P.l(context, C2541R.string.caption_app_clear_cache).o(0, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_app_clear_cache_title);
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("packageName");
        }
        if (c1708z0.getPackageName().equals(x7)) {
            throw new SecurityException("Clearing Automate cache is not permitted");
        }
        c1708z0.w(new a(x7));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
