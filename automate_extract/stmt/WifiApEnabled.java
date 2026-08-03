package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;

@F3.f("wifi_ap_enabled.html")
@F3.a(C2541R.integer.ic_wifi_access_point)
@F3.i(C2541R.string.stmt_wifi_ap_enabled_title)
@F3.h(C2541R.string.stmt_wifi_ap_enabled_summary)
@F3.e(C2541R.layout.stmt_wifi_ap_enabled_edit)
/* loaded from: classes.dex */
public final class WifiApEnabled extends IntermittentDecision implements ReceiverStatement {

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final boolean f17295x1;

        public a(boolean z7) {
            this.f17295x1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Boolean bool;
            int intExtra = intent.getIntExtra("wifi_state", -1);
            boolean z7 = this.f17295x1;
            if (intExtra != 11) {
                if (intExtra != 13 || z7) {
                    return;
                } else {
                    bool = Boolean.TRUE;
                }
            } else if (!z7) {
                return;
            } else {
                bool = Boolean.FALSE;
            }
            c(intent, bool, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_WIFI_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_wifi_ap_enabled_immediate, C2541R.string.caption_wifi_ap_enabled_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_wifi_ap_enabled_title);
        WifiManager l8 = AbstractStatement.l(c1708z0);
        boolean z7 = 13 == ((Integer) l8.getClass().getMethod("getWifiApState", new Class[0]).invoke(l8, new Object[0])).intValue();
        if (J1(1) == 0) {
            o(c1708z0, z7);
            return true;
        }
        a aVar = new a(z7);
        c1708z0.w(aVar);
        aVar.o(2, "android.net.wifi.WIFI_AP_STATE_CHANGED");
        return false;
    }
}
