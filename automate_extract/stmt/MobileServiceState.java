package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1594j2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("mobile_service_state.html")
@F3.a(C2541R.integer.ic_simcard)
@F3.i(C2541R.string.stmt_mobile_service_state_title)
@F3.h(C2541R.string.stmt_mobile_service_state_summary)
@F3.e(C2541R.layout.stmt_mobile_service_state_edit)
/* loaded from: classes.dex */
public final class MobileServiceState extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 serviceStates;
    public InterfaceC1700x0 subscriptionId;
    public J3.l varCurrentServiceState;

    public static final class a extends C1594j2 {

        /* renamed from: O1, reason: collision with root package name */
        public final int f16941O1;

        /* renamed from: P1, reason: collision with root package name */
        public final boolean f16942P1;

        /* renamed from: Q1, reason: collision with root package name */
        public int f16943Q1;

        /* renamed from: R1, reason: collision with root package name */
        public boolean f16944R1;

        public a(int i8, boolean z7, int i9) {
            super(i8);
            this.f16944R1 = true;
            this.f16942P1 = z7;
            this.f16941O1 = i9;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x005e A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:2:0x0000, B:5:0x000f, B:7:0x0013, B:11:0x001a, B:12:0x0070, B:17:0x002b, B:19:0x002f, B:20:0x0032, B:23:0x0038, B:25:0x004b, B:30:0x0055, B:35:0x005e), top: B:1:0x0000 }] */
        @Override // com.llamalab.automate.C1594j2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void y2(ServiceState serviceState) {
            boolean z7;
            boolean z8;
            boolean z9;
            try {
                int state = 1 << serviceState.getState();
                boolean z10 = this.f16942P1;
                int i8 = this.f16941O1;
                if (z10) {
                    Object[] objArr = new Object[2];
                    if (i8 != 0 && (i8 & state) == 0) {
                        z9 = false;
                        objArr[0] = Boolean.valueOf(z9);
                        objArr[1] = Double.valueOf(state);
                        q2(objArr, false);
                    }
                    z9 = true;
                    objArr[0] = Boolean.valueOf(z9);
                    objArr[1] = Double.valueOf(state);
                    q2(objArr, false);
                } else if (this.f16944R1) {
                    this.f16944R1 = false;
                } else {
                    int i9 = this.f16943Q1;
                    if (state != i9) {
                        if (i8 == 0) {
                            q2(new Object[]{Boolean.TRUE, Double.valueOf(state)}, false);
                        } else {
                            if (i8 != 0 && (state & i8) == 0) {
                                z7 = false;
                                if (i8 != 0 && (i9 & i8) == 0) {
                                    z8 = false;
                                    if (z7 != z8) {
                                        q2(new Object[]{Boolean.valueOf(z7), Double.valueOf(state)}, false);
                                    }
                                }
                                z8 = true;
                                if (z7 != z8) {
                                }
                            }
                            z7 = true;
                            if (i8 != 0) {
                                z8 = false;
                                if (z7 != z8) {
                                }
                            }
                            z8 = true;
                            if (z7 != z8) {
                            }
                        }
                    }
                }
                this.f16943Q1 = state;
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_mobile_service_state_immediate, C2541R.string.caption_mobile_service_state_change);
        c1596k0.h(this.serviceStates, null, C2541R.xml.mobile_service_states);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.serviceStates);
        dVar.g(this.subscriptionId);
        dVar.g(this.varCurrentServiceState);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.serviceStates);
        visitor.b(this.subscriptionId);
        visitor.b(this.varCurrentServiceState);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.serviceStates = (InterfaceC1700x0) cVar.readObject();
        this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        this.varCurrentServiceState = (J3.l) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        r4 = r4.createForSubscriptionId(r2);
     */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        ServiceState serviceState;
        c1708z0.q(C2541R.string.stmt_mobile_service_state_title);
        int m8 = J3.h.m(c1708z0, this.serviceStates, 0) & 15;
        int m9 = J3.h.m(c1708z0, this.subscriptionId, w3.n.d());
        boolean z7 = J1(1) == 0;
        int i8 = Build.VERSION.SDK_INT;
        if (26 > i8 || !z7) {
            a aVar = new a(m9, z7, m8);
            c1708z0.w(aVar);
            aVar.v2(1);
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) c1708z0.getSystemService("phone");
        if (telephonyManager == null) {
            throw new NullPointerException("Null TelephonyManager, maybe the SIM/subscription is disabled");
        }
        if (24 <= i8 && Integer.MAX_VALUE != m9 && -1 != m9 && telephonyManager == null) {
            throw new NullPointerException("Null TelephonyManager, maybe the SIM/subscription is disabled");
        }
        serviceState = telephonyManager.getServiceState();
        int state = 1 << serviceState.getState();
        boolean z8 = m8 == 0 || (m8 & state) != 0;
        Double valueOf = Double.valueOf(state);
        J3.l lVar = this.varCurrentServiceState;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, valueOf);
        }
        o(c1708z0, z8);
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        Double d8 = (Double) objArr[1];
        J3.l lVar = this.varCurrentServiceState;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, booleanValue);
        return true;
    }
}
