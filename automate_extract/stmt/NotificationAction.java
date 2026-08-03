package com.llamalab.automate.stmt;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1617p1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import g4.C1827a;
import x3.C2424b;

@F3.f("notification_action.html")
@F3.a(C2541R.integer.ic_notification_select)
@F3.i(C2541R.string.stmt_notification_action_title)
@F3.h(C2541R.string.stmt_notification_action_summary)
@F3.e(C2541R.layout.stmt_notification_action_edit)
/* loaded from: classes.dex */
public final class NotificationAction extends Decision implements AsyncStatement, IntentStatement {
    public InterfaceC1700x0 primaryIconUri;
    public InterfaceC1700x0 primaryLabel;
    public InterfaceC1700x0 secondaryIconUri;
    public InterfaceC1700x0 secondaryLabel;
    public InterfaceC1700x0 tertiaryIconUri;
    public InterfaceC1700x0 tertiaryLabel;
    public InterfaceC1700x0 timeout;
    public J3.l varActionIndex;

    public static boolean z(C1708z0 c1708z0, int i8, InterfaceC1700x0 interfaceC1700x0, InterfaceC1700x0 interfaceC1700x02, int i9, int i10, Notification.Builder builder, Notification.WearableExtender wearableExtender) {
        Notification.Action.Builder builder2;
        String x7 = J3.h.x(c1708z0, interfaceC1700x0, null);
        if (TextUtils.isEmpty(x7)) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("com.llamalab.automate.intent.extra.ACTION_INDEX", i8);
        PendingIntent m8 = c1708z0.m("com.llamalab.automate.intent.action.ACTION_CLICKED", bundle, 1207959552 | C2424b.f23370a, i8);
        int i11 = Build.VERSION.SDK_INT;
        if (20 > i11) {
            builder.addAction(i10, x7, m8).build();
            return true;
        }
        if (23 > i11 || C2424b.n()) {
            builder2 = new Notification.Action.Builder(i10, x7, m8);
        } else {
            Uri g8 = J3.h.g(c1708z0, interfaceC1700x02, C1827a.h.a(c1708z0.getResources().getInteger(i9)).build());
            try {
                C1617p1 u8 = C1617p1.u(c1708z0);
                builder2 = new Notification.Action.Builder(u8.f(g8, u8.m(C2541R.dimen.notification_action_icon_width, C2541R.dimen.notification_action_icon_height), u8.i(C2541R.color.notification_action_icon)), x7, m8);
            } catch (Exception unused) {
                builder2 = new Notification.Action.Builder(i10, x7, m8);
            }
        }
        builder.addAction(builder2.build());
        Notification.Action.WearableExtender availableOffline = new Notification.Action.WearableExtender().setAvailableOffline(false);
        int i12 = Build.VERSION.SDK_INT;
        if (24 <= i12) {
            availableOffline.setHintLaunchesActivity(false);
        }
        if (25 <= i12) {
            availableOffline.setHintDisplayActionInline(true);
        }
        wearableExtender.addAction(availableOffline.extend(builder2).build());
        return true;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 33 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.POST_NOTIFICATIONS")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_notification_action);
        l8.v(this.primaryLabel, 0);
        l8.v(this.secondaryLabel, 0);
        l8.v(this.tertiaryLabel, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        int intExtra = intent.getIntExtra("com.llamalab.automate.intent.extra.ACTION_INDEX", -1);
        if (intExtra != -1) {
            w(c1708z0, true, Double.valueOf(intExtra));
            return true;
        }
        w(c1708z0, false, null);
        return true;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.primaryLabel);
        dVar.g(this.primaryIconUri);
        dVar.g(this.secondaryLabel);
        dVar.g(this.secondaryIconUri);
        dVar.g(this.tertiaryLabel);
        dVar.g(this.tertiaryIconUri);
        dVar.g(this.timeout);
        dVar.g(this.varActionIndex);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.primaryLabel);
        visitor.b(this.primaryIconUri);
        visitor.b(this.secondaryLabel);
        visitor.b(this.secondaryIconUri);
        visitor.b(this.tertiaryLabel);
        visitor.b(this.tertiaryIconUri);
        visitor.b(this.timeout);
        visitor.b(this.varActionIndex);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.primaryLabel = (InterfaceC1700x0) cVar.readObject();
        this.primaryIconUri = N.b(cVar);
        this.secondaryLabel = (InterfaceC1700x0) cVar.readObject();
        this.secondaryIconUri = N.b(cVar);
        this.tertiaryLabel = (InterfaceC1700x0) cVar.readObject();
        this.tertiaryIconUri = N.b(cVar);
        this.timeout = (InterfaceC1700x0) cVar.readObject();
        this.varActionIndex = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_notification_action_title);
        IncapableAndroidVersionException.a(16);
        RunnableC1672u0 runnableC1672u0 = (RunnableC1672u0) c1708z0.c(RunnableC1672u0.class);
        Notification.WearableExtender wearableExtender = null;
        if (runnableC1672u0 == null) {
            w(c1708z0, false, null);
            return true;
        }
        Notification.Builder B22 = runnableC1672u0.B2(c1708z0.j2(), c1708z0.f17641Z, c1708z0, true, new Bundle());
        int i8 = Build.VERSION.SDK_INT;
        if (20 <= i8) {
            wearableExtender = new Notification.WearableExtender().setContentIntentAvailableOffline(false);
            if (24 <= i8) {
                wearableExtender.setHintContentIntentLaunchesActivity(false);
            }
        }
        Notification.WearableExtender wearableExtender2 = wearableExtender;
        if (!(z(c1708z0, 0, this.primaryLabel, this.primaryIconUri, C2541R.integer.ic_bullet_1, C2541R.drawable.ic_bullet_1_dark_32dp, B22, wearableExtender2) | false | z(c1708z0, 1, this.secondaryLabel, this.secondaryIconUri, C2541R.integer.ic_bullet_2, C2541R.drawable.ic_bullet_2_dark_32dp, B22, wearableExtender2)) && !z(c1708z0, 2, this.tertiaryLabel, this.tertiaryIconUri, C2541R.integer.ic_bullet_3, C2541R.drawable.ic_bullet_3_dark_32dp, B22, wearableExtender2)) {
            throw new RequiredArgumentNullException("No labels");
        }
        long t8 = J3.h.t(c1708z0, this.timeout, 0L);
        if (20 <= i8) {
            B22.extend(wearableExtender2);
        }
        runnableC1672u0.f15404y0 = this.f16218X;
        runnableC1672u0.f17548e2 = true;
        runnableC1672u0.y2(c1708z0.j2(), C2424b.a(B22));
        if (t8 > 0) {
            runnableC1672u0.f15400Y.f14581L1.postDelayed(runnableC1672u0, t8);
        }
        return false;
    }

    public final boolean w(C1708z0 c1708z0, boolean z7, Double d8) {
        RunnableC1672u0 runnableC1672u0 = (RunnableC1672u0) c1708z0.c(RunnableC1672u0.class);
        if (runnableC1672u0 != null) {
            runnableC1672u0.f15400Y.f14581L1.removeCallbacks(runnableC1672u0);
            runnableC1672u0.f17548e2 = false;
            runnableC1672u0.A2(c1708z0.j2(), c1708z0.f17641Z, c1708z0, true, new Bundle());
        }
        J3.l lVar = this.varActionIndex;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, z7);
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        w(c1708z0, false, null);
        return true;
    }
}
