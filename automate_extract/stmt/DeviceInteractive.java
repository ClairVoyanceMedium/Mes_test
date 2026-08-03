package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;

@F3.f("device_interactive.html")
@F3.a(C2541R.integer.ic_screen_power_on)
@F3.i(C2541R.string.stmt_device_interactive_title)
@F3.h(C2541R.string.stmt_device_interactive_summary)
@F3.e(C2541R.layout.stmt_device_interactive_edit)
/* loaded from: classes.dex */
public final class DeviceInteractive extends IntermittentDecision implements ReceiverStatement {

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final boolean f16561x1;

        public a(boolean z7) {
            this.f16561x1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            boolean equals = "android.intent.action.SCREEN_ON".equals(intent.getAction());
            boolean z7 = this.f16561x1;
            if (z7 != equals) {
                c(intent, Boolean.valueOf(!z7), false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_device_interactive_immediate, C2541R.string.caption_device_interactive_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_device_interactive_title);
        PowerManager powerManager = (PowerManager) c1708z0.getSystemService("power");
        boolean isInteractive = 20 <= Build.VERSION.SDK_INT ? powerManager.isInteractive() : powerManager.isScreenOn();
        if (J1(1) == 0) {
            o(c1708z0, isInteractive);
            return true;
        }
        a aVar = new a(isInteractive);
        c1708z0.w(aVar);
        aVar.j("android.intent.action.SCREEN_ON", "android.intent.action.SCREEN_OFF");
        return false;
    }
}
