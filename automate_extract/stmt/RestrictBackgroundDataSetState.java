package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;

@F3.f("restrict_background_data_set_state.html")
@F3.a(C2541R.integer.ic_faucet)
@F3.i(C2541R.string.stmt_restrict_background_data_set_state_title)
@F3.h(C2541R.string.stmt_restrict_background_data_set_state_summary)
@F3.e(C2541R.layout.stmt_restrict_background_data_set_state_edit)
/* loaded from: classes.dex */
public final class RestrictBackgroundDataSetState extends SetStateAction implements AsyncStatement {

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f17071M1;

        public a(boolean z7) {
            this.f17071M1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.e0(this.f17071M1, lVar);
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
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_restrict_background_data_enable, C2541R.string.caption_restrict_background_data_disable).r(C2541R.string.caption_restrict_background_data_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_restrict_background_data_set_state_title);
        c1708z0.w(new a(q(c1708z0, false)));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
