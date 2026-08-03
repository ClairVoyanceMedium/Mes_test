package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import x3.C2429g;

@F3.f("network_connected.html")
@F3.a(C2541R.integer.ic_device_access_network_type)
@F3.i(C2541R.string.stmt_network_connected_title)
@F3.h(C2541R.string.stmt_network_connected_summary)
@Deprecated
@F3.e(C2541R.layout.stmt_network_connected_edit)
/* loaded from: classes.dex */
public final class NetworkConnected extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 networkTypes;
    public J3.l varNetworkType;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public ConnectivityManager f16948L1;

        /* renamed from: x1, reason: collision with root package name */
        public final int f16949x1;

        /* renamed from: y1, reason: collision with root package name */
        public final boolean f16950y1;

        public a(int i8, boolean z7) {
            this.f16950y1 = z7;
            this.f16949x1 = i8;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            this.f16948L1 = (ConnectivityManager) automateService.getSystemService("connectivity");
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            NetworkInfo activeNetworkInfo = this.f16948L1.getActiveNetworkInfo();
            boolean z7 = this.f16950y1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int f8 = C2429g.f(activeNetworkInfo.getType());
                int i8 = this.f16949x1;
                if ((i8 == 0 || (i8 & (1 << f8)) != 0) && !z7) {
                    c(intent, new Object[]{Boolean.TRUE, Double.valueOf(f8)}, false);
                    return;
                }
            }
            if (z7) {
                c(intent, new Object[]{Boolean.FALSE, null}, false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_network_connected_immediate, C2541R.string.caption_network_connected_change);
        c1596k0.h(this.networkTypes, null, C2541R.xml.network_types);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        Double d8 = (Double) objArr[1];
        J3.l lVar = this.varNetworkType;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, booleanValue);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.networkTypes);
        dVar.g(this.varNetworkType);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.networkTypes);
        visitor.b(this.varNetworkType);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.networkTypes = (InterfaceC1700x0) cVar.readObject();
        this.varNetworkType = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Double d8;
        boolean z7;
        c1708z0.q(C2541R.string.stmt_network_connected_title);
        int m8 = J3.h.m(c1708z0, this.networkTypes, 0) & 131779;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) c1708z0.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            d8 = null;
            z7 = false;
        } else {
            int f8 = C2429g.f(activeNetworkInfo.getType());
            z7 = m8 == 0 || ((1 << f8) & m8) != 0;
            d8 = Double.valueOf(f8);
        }
        if (J1(1) != 0) {
            a aVar = new a(m8, z7);
            c1708z0.w(aVar);
            aVar.h("android.net.conn.CONNECTIVITY_CHANGE");
            return false;
        }
        J3.l lVar = this.varNetworkType;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, z7);
        return true;
    }
}
