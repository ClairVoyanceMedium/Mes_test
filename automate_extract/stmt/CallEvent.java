package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import x3.C2425c;

/* loaded from: classes.dex */
public abstract class CallEvent extends IntermittentAction implements ReceiverStatement, InterfaceC1622q2 {
    public InterfaceC1700x0 phoneNumber;
    public InterfaceC1700x0 subscriptionId;
    public J3.l varPhoneNumber;
    public J3.l varSubscriptionId;

    public static abstract class a extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public final int f16411L1;

        /* renamed from: M1, reason: collision with root package name */
        public final String f16412M1;

        /* renamed from: N1, reason: collision with root package name */
        public final SparseArray<C0169a> f16413N1 = new SparseArray<>();

        /* renamed from: x1, reason: collision with root package name */
        public final int f16414x1;

        /* renamed from: y1, reason: collision with root package name */
        public boolean f16415y1;

        /* renamed from: com.llamalab.automate.stmt.CallEvent$a$a, reason: collision with other inner class name */
        public static final class C0169a {

            /* renamed from: a, reason: collision with root package name */
            public int f16416a;

            /* renamed from: b, reason: collision with root package name */
            public String f16417b;
        }

        public a(int i8, int i9, String str) {
            this.f16414x1 = i8;
            this.f16411L1 = i9;
            this.f16412M1 = str;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            this.f16415y1 = C1710z2.a(C2425c.c(automateService));
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i8;
            String stringExtra = intent.getStringExtra(com.llamalab.auth3p.e.PARAM_STATE);
            if (TelephonyManager.EXTRA_STATE_IDLE.equals(stringExtra)) {
                i8 = 1;
            } else if (TelephonyManager.EXTRA_STATE_RINGING.equals(stringExtra)) {
                i8 = 2;
            } else if (!TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stringExtra)) {
                return;
            } else {
                i8 = 4;
            }
            r(context, intent, i8);
        }

        public final void r(Context context, Intent intent, int i8) {
            int m8 = w3.n.m(intent.getExtras());
            if (m8 == -1 || m8 == Integer.MAX_VALUE) {
                m8 = w3.n.d();
            }
            SparseArray<C0169a> sparseArray = this.f16413N1;
            C0169a c0169a = sparseArray.get(m8);
            if (c0169a == null) {
                c0169a = new C0169a();
                sparseArray.put(m8, c0169a);
            }
            if (this.f16415y1) {
                F5.n.f(this, "CallEventTask onCallStateChanged: subscriptionId=" + m8 + ", newState=0x" + Integer.toHexString(i8) + ", knownState=0x" + Integer.toHexString(c0169a.f16416a));
            }
            if (28 <= Build.VERSION.SDK_INT && D.c.a(context, "android.permission.READ_CALL_LOG") == 0) {
                int i9 = c0169a.f16416a;
                if ((i9 & i8) == 0) {
                    c0169a.f16416a = i9 | i8;
                    return;
                }
            }
            c0169a.f16416a |= i8;
            s(intent, i8, m8, c0169a);
        }

        public abstract void s(Intent intent, int i8, int i9, C0169a c0169a);

        public final void u(int i8, Intent intent, String str) {
            this.f16413N1.delete(i8);
            int i9 = this.f16411L1;
            if (i9 == -1 || i9 == i8) {
                String str2 = this.f16412M1;
                if (str2 == null || (str != null && PhoneNumberUtils.compare(this.f16157Y, str2, str))) {
                    c(intent, new Object[]{str, Double.valueOf(i8)}, false);
                }
            }
        }
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varPhoneNumber;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[0]);
        }
        J3.l lVar2 = this.varSubscriptionId;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[1]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (31 <= dVar.f6413Z) {
            dVar.g(this.phoneNumber);
        }
        if (45 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
        dVar.g(this.varPhoneNumber);
        if (66 <= dVar.f6413Z) {
            dVar.g(this.varSubscriptionId);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.phoneNumber);
        visitor.b(this.subscriptionId);
        visitor.b(this.varPhoneNumber);
        visitor.b(this.varSubscriptionId);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        if (4 > c1625r2.f16204b) {
            c1625r2.d(false);
        }
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (31 <= cVar.f6409x0) {
            this.phoneNumber = (InterfaceC1700x0) cVar.readObject();
        }
        if (45 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
        this.varPhoneNumber = (J3.l) cVar.readObject();
        if (66 <= cVar.f6409x0) {
            this.varSubscriptionId = (J3.l) cVar.readObject();
        }
    }
}
