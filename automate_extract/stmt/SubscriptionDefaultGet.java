package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.J2;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("subscription_default_get.html")
@F3.a(C2541R.integer.ic_simcard)
@F3.i(C2541R.string.stmt_subscription_default_get_title)
@F3.h(C2541R.string.stmt_subscription_default_get_summary)
@F3.e(C2541R.layout.stmt_subscription_default_get_edit)
/* loaded from: classes.dex */
public final class SubscriptionDefaultGet extends IntermittentAction implements ReceiverStatement {
    public InterfaceC1700x0 usage;
    public J3.l varSimSlotIndex;
    public J3.l varSubscriptionId;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final int f17168x1;

        /* renamed from: y1, reason: collision with root package name */
        public int f17169y1;

        public a(int i8, int i9) {
            this.f17168x1 = i8;
            this.f17169y1 = i9;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            try {
                int u8 = SubscriptionDefaultGet.u(this.f17168x1);
                if (this.f17169y1 != u8) {
                    this.f17169y1 = u8;
                    if (-1 != u8) {
                        c(intent, new Object[]{SubscriptionDefaultGet.s(context, u8), Double.valueOf(u8)}, false);
                    } else {
                        c(intent, new Object[]{null, null}, false);
                    }
                }
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public static Double s(Context context, int i8) {
        int k8;
        if (22 > Build.VERSION.SDK_INT || -1 == (k8 = w3.n.k(J2.a(context.getSystemService("telephony_subscription_service")), i8))) {
            return null;
        }
        return Double.valueOf(k8);
    }

    public static int u(int i8) {
        if (i8 == 0) {
            return w3.n.d();
        }
        if (i8 == 1) {
            return w3.n.e();
        }
        if (i8 == 2) {
            return w3.n.b();
        }
        if (i8 == 3) {
            return w3.n.c();
        }
        throw new IllegalArgumentException("usage");
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_subscription_default_get_immediate, C2541R.string.caption_subscription_default_get_change);
        return c1596k0.e(this.usage, 0, C2541R.xml.subscription_usages_generic).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        w(c1708z0, (Double) objArr[0], (Double) objArr[1]);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.usage);
        dVar.g(this.varSimSlotIndex);
        dVar.g(this.varSubscriptionId);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.usage);
        visitor.b(this.varSimSlotIndex);
        visitor.b(this.varSubscriptionId);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.usage = (InterfaceC1700x0) cVar.readObject();
        this.varSimSlotIndex = (J3.l) cVar.readObject();
        this.varSubscriptionId = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_subscription_default_get_title);
        IncapableAndroidVersionException.a(21);
        int m8 = J3.h.m(c1708z0, this.usage, 0);
        int u8 = u(m8);
        if (J1(1) == 0) {
            if (-1 != u8) {
                w(c1708z0, s(c1708z0, u8), Double.valueOf(u8));
                return true;
            }
            w(c1708z0, null, null);
            return true;
        }
        if (26 > Build.VERSION.SDK_INT) {
            throw new IncapableAndroidVersionException(26, "proceed");
        }
        a aVar = new a(m8, u8);
        c1708z0.w(aVar);
        aVar.h("android.intent.action.SUB_DEFAULT_CHANGED");
        return false;
    }

    public final boolean w(C1708z0 c1708z0, Double d8, Double d9) {
        J3.l lVar = this.varSimSlotIndex;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        J3.l lVar2 = this.varSubscriptionId;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d9);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
