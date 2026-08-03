package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.stmt.AbstractC1638d;
import x3.C2425c;

@F3.f("power_save_mode_set_state.html")
@F3.a(C2541R.integer.ic_device_access_battery_save)
@F3.i(C2541R.string.stmt_power_save_mode_set_state_title)
@F3.h(C2541R.string.stmt_power_save_mode_set_state_summary)
@F3.e(C2541R.layout.stmt_power_save_mode_set_state_edit)
/* loaded from: classes.dex */
public final class PowerSaveModeSetState extends SetStateAction implements AsyncStatement {

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f17044M1;

        public a(boolean z7) {
            this.f17044M1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.W1(this.f17044M1, lVar);
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
        return (23 > i8 || C2425c.c(context).getInt("powerSaverModeWorkaround", 0) != 0) ? 21 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : com.llamalab.automate.access.c.f15562w : new E3.b[]{com.llamalab.automate.access.c.f15560u};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_power_save_mode_enable, C2541R.string.caption_power_save_mode_disable).r(C2541R.string.caption_power_save_mode_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_power_save_mode_set_state_title);
        IncapableAndroidVersionException.a(21);
        boolean q8 = q(c1708z0, false);
        c1708z0.w((23 > Build.VERSION.SDK_INT || C2425c.c(c1708z0).getInt("powerSaverModeWorkaround", 0) != 0) ? new a(q8) : new AbstractC1638d.a(new Intent("android.settings.VOICE_CONTROL_BATTERY_SAVER_MODE").putExtra("android.settings.extra.battery_saver_mode_enabled", q8)));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
