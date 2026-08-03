package com.llamalab.automate.stmt;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Build;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.TimeZone;

@F3.f("time_zone_set.html")
@F3.a(C2541R.integer.ic_device_access_time_zone)
@F3.i(C2541R.string.stmt_time_zone_set_title)
@F3.h(C2541R.string.stmt_time_zone_set_summary)
@F3.e(C2541R.layout.stmt_time_zone_set_edit)
/* loaded from: classes.dex */
public final class TimeZoneSet extends Action implements AsyncStatement {
    public InterfaceC1700x0 timeZone;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final String f17203M1;

        public a(String str) {
            this.f17203M1 = str;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.I(this.f17203M1, lVar);
                lVar.c();
                p2(null);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 26 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.SET_TIME_ZONE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_time_zone_set);
        l8.p(this.timeZone, -1, '/');
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.timeZone);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.timeZone);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.timeZone = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_time_zone_set_title);
        TimeZone z7 = J3.h.z(c1708z0, this.timeZone, null);
        if (z7 == null) {
            throw new RequiredArgumentNullException("timezone");
        }
        if (26 <= Build.VERSION.SDK_INT) {
            c1708z0.w(new a(z7.getID()));
        } else {
            ((AlarmManager) c1708z0.getSystemService("alarm")).setTimeZone(z7.getID());
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
