package com.llamalab.automate.stmt;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("notification_policy_set.html")
@F3.a(C2541R.integer.ic_device_access_dnd)
@F3.i(C2541R.string.stmt_notification_policy_set_title)
@F3.h(C2541R.string.stmt_notification_policy_set_summary)
@F3.c(C2541R.string.caption_notification_policy_set)
@F3.e(C2541R.layout.stmt_notification_policy_set_edit)
/* loaded from: classes.dex */
public final class NotificationPolicySet extends Action {
    public InterfaceC1700x0 alarms;
    public InterfaceC1700x0 calls;
    public InterfaceC1700x0 conversations;
    public InterfaceC1700x0 events;
    public InterfaceC1700x0 media;
    public InterfaceC1700x0 messages;
    public InterfaceC1700x0 reminders;
    public InterfaceC1700x0 repeatCallers;
    public InterfaceC1700x0 suppressedEffects;
    public InterfaceC1700x0 system;

    public static boolean q(int i8, int i9) {
        return (i8 & i9) != 0;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NOTIFICATION_POLICY"), com.llamalab.automate.access.c.f15555p} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.reminders);
        dVar.g(this.events);
        dVar.g(this.messages);
        dVar.g(this.calls);
        dVar.g(this.repeatCallers);
        if (86 <= dVar.f6413Z) {
            dVar.g(this.alarms);
            dVar.g(this.media);
            dVar.g(this.system);
            dVar.g(this.conversations);
        }
        dVar.g(this.suppressedEffects);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.reminders);
        visitor.b(this.events);
        visitor.b(this.messages);
        visitor.b(this.calls);
        visitor.b(this.repeatCallers);
        visitor.b(this.alarms);
        visitor.b(this.media);
        visitor.b(this.system);
        visitor.b(this.conversations);
        visitor.b(this.suppressedEffects);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.reminders = (InterfaceC1700x0) cVar.readObject();
        this.events = (InterfaceC1700x0) cVar.readObject();
        this.messages = (InterfaceC1700x0) cVar.readObject();
        this.calls = (InterfaceC1700x0) cVar.readObject();
        this.repeatCallers = (InterfaceC1700x0) cVar.readObject();
        if (86 <= cVar.f6409x0) {
            this.alarms = (InterfaceC1700x0) cVar.readObject();
            this.media = (InterfaceC1700x0) cVar.readObject();
            this.system = (InterfaceC1700x0) cVar.readObject();
            this.conversations = (InterfaceC1700x0) cVar.readObject();
        }
        this.suppressedEffects = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c6  */
    /* JADX WARN: Type inference failed for: r11v2 */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        int i8;
        int m8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        NotificationManager.Policy policy;
        c1708z0.q(C2541R.string.stmt_notification_policy_set_title);
        IncapableAndroidVersionException.a(23);
        NotificationManager notificationManager = (NotificationManager) c1708z0.getSystemService("notification");
        NotificationManager.Policy notificationPolicy = notificationManager.getNotificationPolicy();
        int i19 = notificationPolicy.priorityCategories;
        int i20 = notificationPolicy.priorityMessageSenders;
        int i21 = notificationPolicy.priorityCallSenders;
        int i22 = Build.VERSION.SDK_INT;
        int i23 = 30 <= i22 ? notificationPolicy.priorityConversationSenders : 0;
        boolean f8 = J3.h.f(c1708z0, this.reminders, q(i19, 1));
        boolean f9 = J3.h.f(c1708z0, this.events, q(i19, 2));
        int m9 = J3.h.m(c1708z0, this.messages, q(i19, 4) ? 1 << i20 : 0) & 7;
        int m10 = J3.h.m(c1708z0, this.calls, q(i19, 8) ? 1 << i21 : 0) & 7;
        boolean f10 = J3.h.f(c1708z0, this.repeatCallers, q(i19, 16));
        boolean f11 = J3.h.f(c1708z0, this.alarms, q(i19, 32));
        boolean f12 = J3.h.f(c1708z0, this.media, q(i19, 64));
        boolean f13 = J3.h.f(c1708z0, this.system, q(i19, 128));
        InterfaceC1700x0 interfaceC1700x0 = this.conversations;
        if (q(i19, 256)) {
            if (i23 == 1) {
                i8 = 1;
            } else if (i23 == 2) {
                i8 = 2;
            }
            m8 = J3.h.m(c1708z0, interfaceC1700x0, i8) & 3;
            if (24 > i22) {
                i9 = i23;
                i10 = J3.h.m(c1708z0, this.suppressedEffects, notificationPolicy.suppressedVisualEffects) & 3;
            } else {
                i9 = i23;
                i10 = 0;
            }
            if (f9) {
                f8 = (f8 ? 1 : 0) | 2;
            }
            if (m9 == 0) {
                i11 = 1;
                i12 = m9 >> 1;
                i13 = (f8 == true ? 1 : 0) | 4;
            } else {
                i11 = 1;
                i12 = 0;
                i13 = f8;
            }
            if (m10 == 0) {
                i14 = m10 >> i11;
                i15 = (i13 == true ? 1 : 0) | 8;
            } else {
                i14 = 0;
                i15 = i13;
            }
            if (f10) {
                i15 = (i15 == true ? 1 : 0) | 16;
            }
            if (f11) {
                i15 = (i15 == true ? 1 : 0) | 32;
            }
            if (f12) {
                i15 = (i15 == true ? 1 : 0) | 64;
            }
            if (f13) {
                i15 = (i15 == true ? 1 : 0) | 128;
            }
            if (m8 != 0) {
                i16 = i15;
                i17 = 30;
                i18 = 3;
            } else if (m8 == 1) {
                i16 = i15 | 256;
                i17 = 30;
                i18 = 1;
            } else if (m8 != 2) {
                i16 = i15;
                i18 = i9;
                i17 = 30;
            } else {
                i16 = i15 | 256;
                i17 = 30;
                i18 = 2;
            }
            policy = i17 > i22 ? new NotificationManager.Policy(i16, i14, i12, i10, i18) : 24 <= i22 ? new NotificationManager.Policy(i16, i14, i12, i10) : new NotificationManager.Policy(i16, i14, i12);
            if (!notificationPolicy.equals(policy)) {
                notificationManager.setNotificationPolicy(policy);
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        i8 = 0;
        m8 = J3.h.m(c1708z0, interfaceC1700x0, i8) & 3;
        if (24 > i22) {
        }
        if (f9) {
        }
        if (m9 == 0) {
        }
        if (m10 == 0) {
        }
        if (f10) {
        }
        if (f11) {
        }
        if (f12) {
        }
        if (f13) {
        }
        if (m8 != 0) {
        }
        if (i17 > i22) {
        }
        if (!notificationPolicy.equals(policy)) {
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
