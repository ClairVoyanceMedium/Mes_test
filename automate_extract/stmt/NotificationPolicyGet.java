package com.llamalab.automate.stmt;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("notification_policy_get.html")
@F3.a(C2541R.integer.ic_device_access_dnd)
@F3.i(C2541R.string.stmt_notification_policy_get_title)
@F3.h(C2541R.string.stmt_notification_policy_get_summary)
@F3.e(C2541R.layout.stmt_notification_policy_get_edit)
/* loaded from: classes.dex */
public final class NotificationPolicyGet extends IntermittentAction implements ReceiverStatement {
    public J3.l varCurrentAlarms;
    public J3.l varCurrentCalls;
    public J3.l varCurrentConversations;
    public J3.l varCurrentEvents;
    public J3.l varCurrentMedia;
    public J3.l varCurrentMessages;
    public J3.l varCurrentReminders;
    public J3.l varCurrentRepeatCallers;
    public J3.l varCurrentSuppressedEffects;
    public J3.l varCurrentSystem;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final NotificationManager.Policy f16970x1;

        public a(NotificationManager.Policy policy) {
            this.f16970x1 = policy;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            NotificationManager.Policy notificationPolicy;
            boolean equals;
            notificationPolicy = ((NotificationManager) context.getSystemService("notification")).getNotificationPolicy();
            equals = this.f16970x1.equals(notificationPolicy);
            if (equals) {
                return;
            }
            c(intent, notificationPolicy, false);
        }
    }

    public static double s(int i8, int i9) {
        return (i8 & i9) != 0 ? 1.0d : 0.0d;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NOTIFICATION_POLICY"), com.llamalab.automate.access.c.f15555p} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_notification_policy_get_immediate, C2541R.string.caption_notification_policy_get_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        u(c1708z0, C1649i0.a(obj));
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varCurrentReminders);
        dVar.g(this.varCurrentEvents);
        dVar.g(this.varCurrentMessages);
        dVar.g(this.varCurrentCalls);
        dVar.g(this.varCurrentRepeatCallers);
        if (86 <= dVar.f6413Z) {
            dVar.g(this.varCurrentAlarms);
            dVar.g(this.varCurrentMedia);
            dVar.g(this.varCurrentSystem);
            dVar.g(this.varCurrentConversations);
        }
        dVar.g(this.varCurrentSuppressedEffects);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.varCurrentReminders);
        visitor.b(this.varCurrentEvents);
        visitor.b(this.varCurrentMessages);
        visitor.b(this.varCurrentCalls);
        visitor.b(this.varCurrentRepeatCallers);
        visitor.b(this.varCurrentAlarms);
        visitor.b(this.varCurrentMedia);
        visitor.b(this.varCurrentSystem);
        visitor.b(this.varCurrentConversations);
        visitor.b(this.varCurrentSuppressedEffects);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varCurrentReminders = (J3.l) cVar.readObject();
        this.varCurrentEvents = (J3.l) cVar.readObject();
        this.varCurrentMessages = (J3.l) cVar.readObject();
        this.varCurrentCalls = (J3.l) cVar.readObject();
        this.varCurrentRepeatCallers = (J3.l) cVar.readObject();
        if (86 <= cVar.f6409x0) {
            this.varCurrentAlarms = (J3.l) cVar.readObject();
            this.varCurrentMedia = (J3.l) cVar.readObject();
            this.varCurrentSystem = (J3.l) cVar.readObject();
            this.varCurrentConversations = (J3.l) cVar.readObject();
        }
        this.varCurrentSuppressedEffects = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        NotificationManager.Policy notificationPolicy;
        c1708z0.q(C2541R.string.stmt_notification_policy_get_title);
        IncapableAndroidVersionException.a(23);
        notificationPolicy = ((NotificationManager) c1708z0.getSystemService("notification")).getNotificationPolicy();
        if (J1(1) == 0) {
            u(c1708z0, notificationPolicy);
            return true;
        }
        a aVar = new a(notificationPolicy);
        c1708z0.w(aVar);
        aVar.h("android.app.action.NOTIFICATION_POLICY_CHANGED");
        return false;
    }

    public final void u(C1708z0 c1708z0, NotificationManager.Policy policy) {
        int i8;
        J3.l lVar;
        int i9;
        int i10;
        int i11;
        int i12;
        i8 = policy.priorityCategories;
        J3.l lVar2 = this.varCurrentReminders;
        int i13 = 1;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, Double.valueOf(s(i8, 1)));
        }
        J3.l lVar3 = this.varCurrentEvents;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, Double.valueOf(s(i8, 2)));
        }
        J3.l lVar4 = this.varCurrentRepeatCallers;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, Double.valueOf(s(i8, 16)));
        }
        J3.l lVar5 = this.varCurrentMessages;
        if (lVar5 != null) {
            i12 = policy.priorityMessageSenders;
            c1708z0.z(lVar5.f4659Y, Double.valueOf((i8 & 4) != 0 ? 1 << i12 : 0.0d));
        }
        J3.l lVar6 = this.varCurrentCalls;
        if (lVar6 != null) {
            i11 = policy.priorityCallSenders;
            c1708z0.z(lVar6.f4659Y, Double.valueOf((i8 & 8) != 0 ? 1 << i11 : 0.0d));
        }
        int i14 = Build.VERSION.SDK_INT;
        if (28 <= i14) {
            J3.l lVar7 = this.varCurrentAlarms;
            if (lVar7 != null) {
                c1708z0.z(lVar7.f4659Y, Double.valueOf(s(i8, 32)));
            }
            J3.l lVar8 = this.varCurrentMedia;
            if (lVar8 != null) {
                c1708z0.z(lVar8.f4659Y, Double.valueOf(s(i8, 64)));
            }
            J3.l lVar9 = this.varCurrentSystem;
            if (lVar9 != null) {
                c1708z0.z(lVar9.f4659Y, Double.valueOf(s(i8, 128)));
            }
        }
        if (30 <= i14 && this.varCurrentConversations != null) {
            if ((i8 & 256) != 0) {
                i10 = policy.priorityConversationSenders;
                if (i10 != 1) {
                    if (i10 == 2) {
                        i13 = 2;
                    }
                }
                c1708z0.z(this.varCurrentConversations.f4659Y, Double.valueOf(i13));
            }
            i13 = 0;
            c1708z0.z(this.varCurrentConversations.f4659Y, Double.valueOf(i13));
        }
        if (24 <= i14 && (lVar = this.varCurrentSuppressedEffects) != null) {
            i9 = policy.suppressedVisualEffects;
            c1708z0.z(lVar.f4659Y, Double.valueOf(i9));
        }
        c1708z0.f17642x0 = this.onComplete;
    }
}
