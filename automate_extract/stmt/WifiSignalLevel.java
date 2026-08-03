package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;
import x3.C2429g;

@F3.f("wifi_signal_level.html")
@F3.a(C2541R.integer.ic_device_access_network_wifi_weak)
@F3.i(C2541R.string.stmt_wifi_signal_level_title)
@F3.h(C2541R.string.stmt_wifi_signal_level_summary)
@F3.e(C2541R.layout.stmt_wifi_signal_level_edit)
/* loaded from: classes.dex */
public final class WifiSignalLevel extends LevelDecision implements ReceiverStatement {

    public static class a extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public final boolean f17320L1;

        /* renamed from: M1, reason: collision with root package name */
        public double f17321M1;

        /* renamed from: x1, reason: collision with root package name */
        public final Double f17322x1;

        /* renamed from: y1, reason: collision with root package name */
        public final Double f17323y1;

        public a(boolean z7, Double d8, Double d9) {
            this.f17320L1 = z7;
            this.f17322x1 = d8;
            this.f17323y1 = d9;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            String action = intent.getAction();
            boolean equals = "android.net.wifi.RSSI_CHANGED".equals(action);
            Double d8 = this.f17323y1;
            Double d9 = this.f17322x1;
            boolean z7 = this.f17320L1;
            if (equals) {
                double a8 = C2429g.a(intent.getIntExtra("newRssi", -100)) * 100.0f;
                this.f17321M1 = a8;
                if (z7 == LevelDecision.E(a8, d9, d8)) {
                    return;
                }
            } else {
                if (!"android.net.wifi.WIFI_STATE_CHANGED".equals(action) || 1 != intent.getIntExtra("wifi_state", -1)) {
                    return;
                }
                this.f17321M1 = 0.0d;
                if (z7 == LevelDecision.E(0.0d, d9, d8)) {
                    return;
                }
            }
            b(intent);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_wifi_signal_level_immediate, C2541R.string.caption_wifi_signal_level_change);
        c1596k0.n(this.minLevel, this.maxLevel, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        B(c1708z0, !r4.f17320L1, Double.valueOf(((a) abstractC1618p2).f17321M1));
        return true;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_wifi_signal_level_title);
        Double D7 = D(c1708z0);
        Double C7 = C(c1708z0);
        double a8 = AbstractStatement.l(c1708z0).getConnectionInfo() != null ? C2429g.a(r2.getRssi()) * 100.0f : 0.0d;
        boolean E7 = LevelDecision.E(a8, D7, C7);
        if (J1(1) == 0) {
            B(c1708z0, E7, Double.valueOf(a8));
            return true;
        }
        a aVar = new a(E7, D7, C7);
        c1708z0.w(aVar);
        aVar.j("android.net.wifi.RSSI_CHANGED", "android.net.wifi.WIFI_STATE_CHANGED");
        return false;
    }
}
