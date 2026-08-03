package com.llamalab.automate.stmt;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.LaunchAdjacentActivity;
import com.llamalab.automate.Visitor;
import x3.C2424b;

@F3.f("activity_start.html")
@F3.a(C2541R.integer.ic_android_app)
@F3.i(C2541R.string.stmt_activity_start_title)
@F3.h(C2541R.string.stmt_activity_start_summary)
@F3.e(C2541R.layout.stmt_activity_start_edit)
/* loaded from: classes.dex */
public final class ActivityStart extends IntentAction implements IntentStatement {
    public InterfaceC1700x0 activityOptions;
    public InterfaceC1700x0 chooser;

    public static void u(Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        if (action.equals("android.intent.action.CALL")) {
            throw new SecurityException("Call action not permitted");
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final void C1(C1708z0 c1708z0) {
        PendingIntent m8 = c1708z0.m("com.llamalab.automate.intent.action.LAUNCH_ADJACENT_FINISHED", null, 1879048192 | C2424b.f23371b, 0);
        if (m8 != null) {
            m8.cancel();
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15547h} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_activity_start).o(-1, this.action).o(-1, this.className).q(this.className).o(-1, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        Throwable th;
        if (intent != null && (th = (Throwable) intent.getSerializableExtra("com.llamalab.automate.intent.extra.THROWABLE")) != null) {
            throw th;
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        s(dVar, 45);
        if (89 <= dVar.f6413Z) {
            dVar.g(this.activityOptions);
        }
        if (38 <= dVar.f6413Z) {
            dVar.g(this.chooser);
        }
    }

    @Override // com.llamalab.automate.stmt.IntentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.activityOptions);
        visitor.b(this.chooser);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return ViewOnClickListenerC1667s.x(C1636c.class, 1, null);
    }

    @Override // com.llamalab.automate.stmt.IntentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        r(cVar, 45);
        if (89 <= cVar.f6409x0) {
            this.activityOptions = (InterfaceC1700x0) cVar.readObject();
        }
        if (38 <= cVar.f6409x0) {
            this.chooser = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_activity_start_title);
        e(c1708z0);
        Intent q8 = q(1823209175, c1708z0, true);
        u(q8);
        Bundle d8 = J3.h.d(c1708z0, this.activityOptions);
        if (J3.h.f(c1708z0, this.chooser, false)) {
            q8 = Intent.createChooser(q8, c1708z0.getText(C2541R.string.stmt_activity_start_title));
        }
        q8.addFlags(268697600);
        int i8 = Build.VERSION.SDK_INT;
        if (24 <= i8) {
            C1631a0 c1631a0 = (C1631a0) c1708z0.c(C1631a0.class);
            if ((q8.getFlags() & MoreOsConstants.O_DSYNC) == 0 || !(this.onComplete instanceof ActivityStart)) {
                if (c1631a0 != null) {
                    c1631a0.a();
                    if (30 <= i8) {
                        q8.setFlags(q8.getFlags() & (-4097));
                    } else {
                        q8.addFlags(MoreOsConstants.O_DSYNC);
                    }
                    c1631a0.v2(q8, d8);
                    c1708z0.startActivity(new Intent(null, F5.n.c(c1708z0), c1708z0, LaunchAdjacentActivity.class).addFlags(268697600).putExtra("com.llamalab.automate.intent.extra.INTENTS", c1631a0.f17336y1).putExtra("com.llamalab.automate.intent.extra.ACTIVITY_OPTIONS", c1631a0.f17335L1).putExtra("com.llamalab.automate.intent.extra.PENDING_INTENT", c1708z0.m("com.llamalab.automate.intent.action.LAUNCH_ADJACENT_FINISHED", null, 1207959552 | C2424b.f23371b, 0)));
                    return false;
                }
                c1708z0.startActivity(q8, d8);
            } else {
                if (c1631a0 == null) {
                    c1631a0 = new C1631a0();
                    c1708z0.w(c1631a0);
                }
                if (c1631a0.f17336y1.length == 64) {
                    throw new IllegalStateException("too many subsequent FLAG_ACTIVITY_LAUNCH_ADJACENT");
                }
                c1631a0.v2(q8, d8);
            }
        } else {
            if (16 > i8) {
                c1708z0.startActivity(q8);
            }
            c1708z0.startActivity(q8, d8);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
