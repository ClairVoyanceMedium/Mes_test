package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;

@F3.f("power_save_mode_enabled.html")
@F3.a(C2541R.integer.ic_device_access_battery_save)
@F3.i(C2541R.string.stmt_power_save_mode_enabled_title)
@F3.h(C2541R.string.stmt_power_save_mode_enabled_summary)
@F3.e(C2541R.layout.stmt_power_save_mode_enabled_edit)
/* loaded from: classes.dex */
public final class PowerSaveModeEnabled extends IntermittentDecision implements ReceiverStatement {

    public static class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final boolean f17043x1;

        public a(boolean z7) {
            this.f17043x1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            boolean isPowerSaveMode;
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            boolean z7 = this.f17043x1;
            isPowerSaveMode = powerManager.isPowerSaveMode();
            if (z7 != isPowerSaveMode) {
                b(intent);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_power_save_mode_enabled_immediate, C2541R.string.caption_power_save_mode_enabled_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, !((a) abstractC1618p2).f17043x1);
        return true;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        boolean isPowerSaveMode;
        c1708z0.q(C2541R.string.stmt_power_save_mode_enabled_title);
        IncapableAndroidVersionException.a(21);
        isPowerSaveMode = ((PowerManager) c1708z0.getSystemService("power")).isPowerSaveMode();
        if (J1(1) == 0) {
            o(c1708z0, isPowerSaveMode);
            return true;
        }
        a aVar = new a(isPowerSaveMode);
        c1708z0.w(aVar);
        aVar.h("android.os.action.POWER_SAVE_MODE_CHANGED");
        return false;
    }
}
