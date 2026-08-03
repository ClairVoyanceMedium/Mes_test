package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1594j2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("mobile_data_network_type.html")
@F3.a(C2541R.integer.ic_mobile_data)
@F3.i(C2541R.string.stmt_mobile_data_network_type_title)
@F3.h(C2541R.string.stmt_mobile_data_network_type_summary)
@F3.e(C2541R.layout.stmt_mobile_data_network_type_edit)
/* loaded from: classes.dex */
public final class MobileDataNetworkType extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 networkTypes;
    public InterfaceC1700x0 subscriptionId;
    public J3.l varNetworkType;

    public static final class a extends C1594j2 {

        /* renamed from: O1, reason: collision with root package name */
        public final int f16924O1;

        /* renamed from: P1, reason: collision with root package name */
        public Boolean f16925P1;

        public a(int i8, int i9) {
            super(i8);
            this.f16924O1 = i9;
        }

        @Override // com.llamalab.automate.C1594j2
        public final void x2(int i8) {
            int i9 = 1 << i8;
            int i10 = this.f16924O1;
            Boolean valueOf = Boolean.valueOf((i9 & i10) != 0);
            Boolean bool = this.f16925P1;
            if (bool != null) {
                if (i10 == 0) {
                    q2(new Object[]{Boolean.TRUE, Double.valueOf(i9)}, false);
                } else if (bool != valueOf) {
                    q2(new Object[]{valueOf, Double.valueOf(i9)}, false);
                }
            }
            this.f16925P1 = valueOf;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_mobile_data_network_type_immediate, C2541R.string.caption_mobile_data_network_type_change);
        c1596k0.h(this.networkTypes, null, C2541R.xml.mobile_data_network_types);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.networkTypes);
        if (64 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
        dVar.g(this.varNetworkType);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.networkTypes);
        visitor.b(this.subscriptionId);
        visitor.b(this.varNetworkType);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.networkTypes = (InterfaceC1700x0) cVar.readObject();
        if (64 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
        this.varNetworkType = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int networkType;
        Object invoke;
        TelephonyManager createForSubscriptionId;
        c1708z0.q(C2541R.string.stmt_mobile_data_enabled_title);
        int m8 = J3.h.m(c1708z0, this.networkTypes, 0);
        int m9 = J3.h.m(c1708z0, this.subscriptionId, w3.n.b());
        if (J1(1) != 0) {
            a aVar = new a(m9, m8);
            c1708z0.w(aVar);
            aVar.v2(64);
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) c1708z0.getSystemService("phone");
        int i8 = Build.VERSION.SDK_INT;
        if (24 <= i8) {
            createForSubscriptionId = telephonyManager.createForSubscriptionId(m9);
            networkType = createForSubscriptionId.getNetworkType();
        } else {
            if (22 <= i8) {
                invoke = telephonyManager.getClass().getMethod("getNetworkType", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(m9));
            } else if (21 <= i8) {
                invoke = telephonyManager.getClass().getMethod("getNetworkType", Long.TYPE).invoke(telephonyManager, Long.valueOf(w3.n.a(m9)));
            } else {
                networkType = telephonyManager.getNetworkType();
            }
            networkType = ((Integer) invoke).intValue();
        }
        int i9 = 1 << networkType;
        boolean z7 = m8 == 0 || (m8 & i9) != 0;
        Double valueOf = Double.valueOf(i9);
        J3.l lVar = this.varNetworkType;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, valueOf);
        }
        o(c1708z0, z7);
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
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
}
