package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.N2;
import com.llamalab.automate.stmt.AbstractC1638d;
import x3.C2425c;

@F3.f("airplane_mode_set_state.html")
@F3.a(C2541R.integer.ic_alerts_and_states_airplane_mode_off)
@F3.i(C2541R.string.stmt_airplane_mode_set_state_title)
@F3.h(C2541R.string.stmt_airplane_mode_set_state_summary)
@F3.e(C2541R.layout.stmt_airplane_mode_set_state_edit)
/* loaded from: classes.dex */
public final class AirplaneModeSetState extends SetStateAction implements AsyncStatement {

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f16238M1;

        public a(boolean z7) {
            this.f16238M1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.a0(this.f16238M1, lVar);
                lVar.c();
                p2(null);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return (23 > i8 || C2425c.c(context).getInt("airplaneModeWorkaround", 0) != 0) ? 17 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS")} : new E3.b[]{com.llamalab.automate.access.c.f15560u};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_airplane_mode_enable, C2541R.string.caption_airplane_mode_disable).r(C2541R.string.caption_airplane_mode_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        N2 aVar;
        c1708z0.q(C2541R.string.stmt_airplane_mode_set_state_title);
        boolean q8 = q(c1708z0, false);
        int i8 = Build.VERSION.SDK_INT;
        if (23 <= i8 && C2425c.c(c1708z0).getInt("airplaneModeWorkaround", 0) == 0) {
            aVar = new AbstractC1638d.a(new Intent("android.settings.VOICE_CONTROL_AIRPLANE_MODE").putExtra("airplane_mode_enabled", q8));
        } else {
            if (17 > i8) {
                Settings.System.putInt(c1708z0.getContentResolver(), "airplane_mode_on", q8 ? 1 : 0);
                c1708z0.sendBroadcast(new Intent("android.intent.action.AIRPLANE_MODE").putExtra(com.llamalab.auth3p.e.PARAM_STATE, q8));
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
            aVar = new a(q8);
        }
        c1708z0.w(aVar);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
