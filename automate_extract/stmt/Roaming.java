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

@F3.f("roaming.html")
@F3.a(C2541R.integer.ic_device_access_roaming)
@F3.i(C2541R.string.stmt_roaming_title)
@F3.h(C2541R.string.stmt_roaming_summary)
@F3.e(C2541R.layout.stmt_roaming_edit)
/* loaded from: classes.dex */
public class Roaming extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 subscriptionId;

    public static final class a extends C1594j2 {

        /* renamed from: O1, reason: collision with root package name */
        public final boolean f17075O1;

        public a(int i8, boolean z7) {
            super(i8);
            this.f17075O1 = z7;
        }

        @Override // com.llamalab.automate.C1594j2
        public final void y2(ServiceState serviceState) {
            boolean roaming = serviceState.getRoaming();
            boolean z7 = this.f17075O1;
            if (z7 != roaming) {
                q2(Boolean.valueOf(!z7), false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_roaming_immediate, C2541R.string.caption_roaming_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (64 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.subscriptionId);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (64 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0079  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        Object invoke;
        boolean booleanValue;
        c1708z0.q(C2541R.string.stmt_roaming_title);
        int m8 = J3.h.m(c1708z0, this.subscriptionId, w3.n.d());
        TelephonyManager telephonyManager = (TelephonyManager) c1708z0.getSystemService("phone");
        int i8 = Build.VERSION.SDK_INT;
        if (24 > i8) {
            if (22 <= i8) {
                invoke = telephonyManager.getClass().getMethod("isNetworkRoaming", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(m8));
            } else if (21 <= i8) {
                invoke = telephonyManager.getClass().getMethod("isNetworkRoaming", Long.TYPE).invoke(telephonyManager, Long.valueOf(w3.n.a(m8)));
            }
            booleanValue = ((Boolean) invoke).booleanValue();
            if (J1(1) != 0) {
                o(c1708z0, booleanValue);
                return true;
            }
            a aVar = new a(m8, booleanValue);
            c1708z0.w(aVar);
            aVar.v2(1);
            return false;
        }
        telephonyManager = telephonyManager.createForSubscriptionId(m8);
        booleanValue = telephonyManager.isNetworkRoaming();
        if (J1(1) != 0) {
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
