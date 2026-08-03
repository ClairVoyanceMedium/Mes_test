package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("mobile_data_set_state.html")
@F3.a(C2541R.integer.ic_mobile_data)
@F3.i(C2541R.string.stmt_mobile_data_set_state_title)
@F3.h(C2541R.string.stmt_mobile_data_set_state_summary)
@F3.e(C2541R.layout.stmt_mobile_data_set_state_edit)
/* loaded from: classes.dex */
public final class MobileDataSetState extends SetStateAction implements AsyncStatement {
    public InterfaceC1700x0 subscriptionId;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final int f16926M1;

        /* renamed from: N1, reason: collision with root package name */
        public final boolean f16927N1;

        public a(int i8, boolean z7) {
            this.f16926M1 = i8;
            this.f16927N1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.y0(this.f16926M1, 0, this.f16927N1, "root", lVar);
                lVar.c();
                p2(null);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 21 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CHANGE_NETWORK_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, true, C2541R.string.caption_mobile_data_enable, C2541R.string.caption_mobile_data_disable).r(C2541R.string.caption_mobile_data_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (45 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.subscriptionId);
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (45 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_mobile_data_set_state_title);
        boolean q8 = q(c1708z0, true);
        int m8 = J3.h.m(c1708z0, this.subscriptionId, w3.n.b());
        if (21 <= Build.VERSION.SDK_INT) {
            c1708z0.w(new a(m8, q8));
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) c1708z0.getSystemService("connectivity");
        connectivityManager.getClass().getMethod("setMobileDataEnabled", Boolean.TYPE).invoke(connectivityManager, Boolean.valueOf(q8));
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
