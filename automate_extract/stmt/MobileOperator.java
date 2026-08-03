package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1594j2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import x3.C2440r;

@F3.f("mobile_operator.html")
@F3.a(C2541R.integer.ic_simcard)
@F3.i(C2541R.string.stmt_mobile_operator_title)
@F3.h(C2541R.string.stmt_mobile_operator_summary)
@F3.e(C2541R.layout.stmt_mobile_operator_edit)
/* loaded from: classes.dex */
public final class MobileOperator extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 operatorCode;
    public InterfaceC1700x0 operatorName;
    public InterfaceC1700x0 subscriptionId;
    public J3.l varCurrentCountryCode;
    public J3.l varCurrentOperatorCode;
    public J3.l varCurrentOperatorName;

    public static final class a extends C1594j2 {

        /* renamed from: O1, reason: collision with root package name */
        public final String f16937O1;

        /* renamed from: P1, reason: collision with root package name */
        public final String f16938P1;

        /* renamed from: Q1, reason: collision with root package name */
        public boolean f16939Q1;

        /* renamed from: R1, reason: collision with root package name */
        public boolean f16940R1;

        public a(int i8, String str, String str2, boolean z7) {
            super(i8);
            this.f16940R1 = true;
            this.f16939Q1 = z7;
            this.f16937O1 = str;
            this.f16938P1 = str2;
        }

        @Override // com.llamalab.automate.C1594j2
        public final void y2(ServiceState serviceState) {
            try {
                if (this.f16940R1) {
                    this.f16940R1 = false;
                    return;
                }
                String operatorAlphaLong = serviceState.getOperatorAlphaLong();
                String operatorNumeric = serviceState.getOperatorNumeric();
                String str = this.f16937O1;
                String str2 = this.f16938P1;
                if (str == null && str2 == null) {
                    this.f16939Q1 = true;
                } else if (this.f16939Q1 == MobileOperator.C(str, str2, operatorAlphaLong, operatorNumeric)) {
                    return;
                } else {
                    this.f16939Q1 = !this.f16939Q1;
                }
                q2(new Object[]{Boolean.valueOf(this.f16939Q1), operatorAlphaLong, operatorNumeric, w3.n.i(this.f16023y1, this.f16020L1)}, false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (x3.C2440r.v(r1, r3) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean C(String str, String str2, String str3, String str4) {
        if (str != null) {
            if (str3 == null) {
                str3 = "";
            }
        }
        if (str2 != null) {
            if (str4 == null) {
                str4 = "";
            }
            if (!C2440r.v(str2, str4)) {
                return false;
            }
        }
        return true;
    }

    public final void B(C1708z0 c1708z0, boolean z7, String str, String str2, String str3) {
        J3.l lVar = this.varCurrentOperatorName;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varCurrentOperatorCode;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str2);
        }
        J3.l lVar3 = this.varCurrentCountryCode;
        if (lVar3 != null) {
            if (TextUtils.isEmpty(str3)) {
                str3 = null;
            }
            c1708z0.z(lVar3.f4659Y, str3);
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_mobile_operator_immediate, C2541R.string.caption_mobile_operator_change);
        c1596k0.v(this.operatorName, 0);
        c1596k0.v(this.operatorCode, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.operatorName);
        dVar.g(this.operatorCode);
        if (64 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
        dVar.g(this.varCurrentOperatorName);
        dVar.g(this.varCurrentOperatorCode);
        if (104 <= dVar.f6413Z) {
            dVar.g(this.varCurrentCountryCode);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.operatorName);
        visitor.b(this.operatorCode);
        visitor.b(this.subscriptionId);
        visitor.b(this.varCurrentOperatorName);
        visitor.b(this.varCurrentOperatorCode);
        visitor.b(this.varCurrentCountryCode);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1659n0();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.operatorName = (InterfaceC1700x0) cVar.readObject();
        this.operatorCode = (InterfaceC1700x0) cVar.readObject();
        if (64 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
        this.varCurrentOperatorName = (J3.l) cVar.readObject();
        this.varCurrentOperatorCode = (J3.l) cVar.readObject();
        if (104 <= cVar.f6409x0) {
            this.varCurrentCountryCode = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        String networkOperatorName;
        Object invoke;
        String networkOperator;
        Object invoke2;
        TelephonyManager createForSubscriptionId;
        TelephonyManager createForSubscriptionId2;
        c1708z0.q(C2541R.string.stmt_mobile_operator_title);
        String x7 = J3.h.x(c1708z0, this.operatorName, null);
        String x8 = J3.h.x(c1708z0, this.operatorCode, null);
        int m8 = J3.h.m(c1708z0, this.subscriptionId, w3.n.d());
        TelephonyManager telephonyManager = (TelephonyManager) c1708z0.getSystemService("phone");
        int i8 = Build.VERSION.SDK_INT;
        if (24 <= i8) {
            createForSubscriptionId2 = telephonyManager.createForSubscriptionId(m8);
            networkOperatorName = createForSubscriptionId2.getNetworkOperatorName();
        } else {
            if (22 <= i8) {
                invoke = telephonyManager.getClass().getMethod("getNetworkOperatorName", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(m8));
            } else if (21 <= i8) {
                invoke = telephonyManager.getClass().getMethod("getNetworkOperatorName", Long.TYPE).invoke(telephonyManager, Long.valueOf(w3.n.a(m8)));
            } else {
                networkOperatorName = telephonyManager.getNetworkOperatorName();
            }
            networkOperatorName = (String) invoke;
        }
        if (24 <= i8) {
            createForSubscriptionId = telephonyManager.createForSubscriptionId(m8);
            networkOperator = createForSubscriptionId.getNetworkOperator();
        } else {
            if (22 <= i8) {
                invoke2 = telephonyManager.getClass().getMethod("getNetworkOperatorForSubscription", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(m8));
            } else if (21 <= i8) {
                invoke2 = telephonyManager.getClass().getMethod("getNetworkOperator", Long.TYPE).invoke(telephonyManager, Long.valueOf(w3.n.a(m8)));
            } else {
                networkOperator = telephonyManager.getNetworkOperator();
            }
            networkOperator = (String) invoke2;
        }
        boolean C7 = C(x7, x8, networkOperatorName, networkOperator);
        if (J1(1) == 0) {
            B(c1708z0, C7, networkOperatorName, networkOperator, w3.n.i(telephonyManager, m8));
            return true;
        }
        a aVar = new a(m8, x7, x8, C7);
        c1708z0.w(aVar);
        aVar.v2(1);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (String) objArr[1], (String) objArr[2], (String) objArr[3]);
        return true;
    }
}
