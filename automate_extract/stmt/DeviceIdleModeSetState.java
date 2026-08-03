package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;

@F3.f("device_idle_mode_set_state.html")
@F3.a(C2541R.integer.ic_device_doze)
@F3.i(C2541R.string.stmt_device_idle_mode_set_state_title)
@F3.h(C2541R.string.stmt_device_idle_mode_set_state_summary)
@F3.e(C2541R.layout.stmt_device_idle_mode_set_state_edit)
/* loaded from: classes.dex */
public final class DeviceIdleModeSetState extends SetStateAction implements AsyncStatement {

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final int f16560M1;

        public a(int i8) {
            this.f16560M1 = i8;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                int i8 = this.f16560M1;
                if (i8 == 0) {
                    interfaceC1585h1.j1("disabled", lVar);
                } else if (i8 == 1) {
                    interfaceC1585h1.Z1(lVar);
                } else {
                    if (i8 != 2) {
                        throw new IllegalArgumentException(com.llamalab.auth3p.e.PARAM_STATE);
                    }
                    interfaceC1585h1.e1(lVar);
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
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_device_idle_mode_enable, C2541R.string.caption_device_idle_mode_disable).r(C2541R.string.caption_device_idle_mode_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_device_idle_mode_set_state_title);
        IncapableAndroidVersionException.b(23, "device idle mode");
        c1708z0.w(new a(J3.h.m(c1708z0, this.state, 0)));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
