package com.llamalab.automate.stmt;

import L3.C1047l;
import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.WifiNetworkPickActivity;

@F3.f("wifi_network_pick.html")
@F3.a(C2541R.integer.ic_device_access_network_wifi_pick)
@F3.i(C2541R.string.stmt_wifi_network_pick_title)
@F3.h(C2541R.string.stmt_wifi_network_pick_summary)
@F3.e(C2541R.layout.stmt_wifi_network_pick_edit)
/* loaded from: classes.dex */
public final class WifiNetworkPick extends ActivityDecision {
    public InterfaceC1700x0 security;
    public J3.l varBssid;
    public J3.l varSsid;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_wifi_network_pick).f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.security);
        dVar.g(this.varSsid);
        dVar.g(this.varBssid);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.security);
        visitor.b(this.varSsid);
        visitor.b(this.varBssid);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        this.security = interfaceC1700x0;
        if (73 > cVar.f6409x0 && interfaceC1700x0 != null) {
            if (interfaceC1700x0 instanceof J3.k) {
                this.security = J3.h.J(interfaceC1700x0) ? new L3.J(0) : null;
            } else {
                this.security = new C1047l(interfaceC1700x0, new L3.J(0), L3.I.f4933X);
            }
        }
        this.varSsid = (J3.l) cVar.readObject();
        this.varBssid = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varSsid;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            J3.l lVar2 = this.varBssid;
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        String stringExtra = intent.getStringExtra("com.llamalab.automate.intent.extra.SSID");
        String stringExtra2 = intent.getStringExtra("com.llamalab.automate.intent.extra.BSSID");
        J3.l lVar3 = this.varSsid;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, stringExtra);
        }
        J3.l lVar4 = this.varBssid;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, stringExtra2);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_wifi_network_pick_title);
        Integer o6 = J3.h.o(c1708z0, this.security, null);
        Intent intent = new Intent("android.intent.action.PICK", null, c1708z0, WifiNetworkPickActivity.class);
        if (o6 != null) {
            intent.putExtra("com.llamalab.automate.intent.extra.REQUIRED_SECURITY", o6);
        }
        c1708z0.D(intent, null, this, c1708z0.f(C2541R.integer.ic_device_access_network_wifi_pick), c1708z0.getText(C2541R.string.stmt_wifi_network_pick_title));
        return false;
    }
}
