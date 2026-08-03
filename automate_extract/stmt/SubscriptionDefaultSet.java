package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("subscription_default_set.html")
@F3.a(C2541R.integer.ic_simcard)
@F3.i(C2541R.string.stmt_subscription_default_set_title)
@F3.h(C2541R.string.stmt_subscription_default_set_summary)
@F3.e(C2541R.layout.stmt_subscription_default_set_edit)
/* loaded from: classes.dex */
public final class SubscriptionDefaultSet extends Action implements AsyncStatement {
    public InterfaceC1700x0 subscriptionId;
    public InterfaceC1700x0 usage;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final int f17170M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f17171N1;

        public a(int i8, int i9) {
            this.f17170M1 = i8;
            this.f17171N1 = i9;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                int i8 = this.f17170M1;
                int i9 = this.f17171N1;
                if (i8 == 1) {
                    interfaceC1585h1.l0(i9, lVar);
                } else if (i8 == 2) {
                    interfaceC1585h1.w1(i9, lVar);
                } else if (i8 == 3) {
                    interfaceC1585h1.D0(i9, lVar);
                }
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
        C1596k0 e8 = D1.P.l(context, C2541R.string.caption_subscription_default_set).e(this.usage, 1, C2541R.xml.subscription_usages);
        e8.v(this.subscriptionId, 0);
        return e8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.usage);
        dVar.g(this.subscriptionId);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.usage);
        visitor.b(this.subscriptionId);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.usage = (InterfaceC1700x0) cVar.readObject();
        this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int e8;
        c1708z0.q(C2541R.string.stmt_subscription_default_set_title);
        IncapableAndroidVersionException.a(21);
        int m8 = J3.h.m(c1708z0, this.usage, 1);
        InterfaceC1700x0 interfaceC1700x0 = this.subscriptionId;
        if (m8 == 1) {
            e8 = w3.n.e();
        } else if (m8 == 2) {
            e8 = w3.n.b();
        } else {
            if (m8 != 3) {
                throw new IllegalArgumentException("usage");
            }
            e8 = w3.n.c();
        }
        c1708z0.w(new a(m8, J3.h.m(c1708z0, interfaceC1700x0, e8)));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
