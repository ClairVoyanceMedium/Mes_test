package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1592j0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Iterator;
import java.util.regex.Matcher;
import x3.C2424b;
import x3.C2440r;

@F3.f("notification_cancel.html")
@F3.a(C2541R.integer.ic_notification_stop)
@F3.i(C2541R.string.stmt_notification_cancel_title)
@F3.h(C2541R.string.stmt_notification_cancel_summary)
@F3.c(C2541R.string.caption_notification_cancel)
@F3.e(C2541R.layout.stmt_notification_cancel_edit)
/* loaded from: classes.dex */
public final class NotificationCancel extends Action {
    public InterfaceC1700x0 key;

    public static void q(AutomateService automateService, String str) {
        AutomateService.f fVar;
        int i8 = Build.VERSION.SDK_INT;
        if (21 <= i8) {
            AbstractStatement.j().cancelNotification(str);
            return;
        }
        Matcher matcher = C2424b.f23373d.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("key");
        }
        String group = matcher.group(2);
        int parseInt = Integer.parseInt(matcher.group(3));
        String group2 = matcher.group(4);
        if (18 <= i8) {
            AbstractStatement.j().cancelNotification(group, group2, parseInt);
            return;
        }
        if (!automateService.getPackageName().equals(group)) {
            throw new IncapableAndroidVersionException(18, "Cancel non-flow notification");
        }
        Iterator<AutomateService.f> it = automateService.f14591X.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                fVar = null;
                break;
            }
            fVar = it.next();
            if (C2440r.h(group2, fVar.f14625Z) && parseInt == fVar.f14626x0) {
                break;
            }
        }
        if (fVar == null) {
            Object o6 = automateService.o(parseInt, group2);
            if (o6 instanceof InterfaceC1592j0) {
                ((InterfaceC1592j0) o6).P0(automateService, new Intent());
                return;
            }
            return;
        }
        int i9 = Build.VERSION.SDK_INT;
        AutomateService automateService2 = AutomateService.this;
        if (26 > i9) {
            automateService2.f14581L1.removeCallbacks(fVar);
        }
        automateService2.f14615y0.cancel(fVar.f14625Z, fVar.f14626x0);
        fVar.a();
        fVar.b(0);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return (18 > Build.VERSION.SDK_INT || this.key == null) ? com.llamalab.automate.access.c.f15562w : new E3.b[]{com.llamalab.automate.access.c.f15554o};
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (70 <= dVar.f6413Z) {
            dVar.g(this.key);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.key);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (70 <= cVar.f6409x0) {
            this.key = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_notification_cancel_title);
        String x7 = J3.h.x(c1708z0, this.key, null);
        RunnableC1672u0 runnableC1672u0 = (RunnableC1672u0) c1708z0.c(RunnableC1672u0.class);
        if (runnableC1672u0 != null && (x7 == null || x7.equals(runnableC1672u0.w2()))) {
            runnableC1672u0.a();
        } else if (x7 != null) {
            q(c1708z0.j2(), x7);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
