package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1594j2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1616p0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("mobile_data_enabled.html")
@F3.a(C2541R.integer.ic_mobile_data)
@F3.i(C2541R.string.stmt_mobile_data_enabled_title)
@F3.h(C2541R.string.stmt_mobile_data_enabled_summary)
@F3.e(C2541R.layout.stmt_mobile_data_enabled_edit)
/* loaded from: classes.dex */
public final class MobileDataEnabled extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 subscriptionId;

    public static final class a extends C1594j2 {

        /* renamed from: O1, reason: collision with root package name */
        public final boolean f16921O1;

        public a(int i8, boolean z7) {
            super(i8);
            this.f16921O1 = z7;
        }

        @Override // com.llamalab.automate.C1594j2
        public final void A2(boolean z7) {
            if (this.f16921O1 != z7) {
                q2(Boolean.valueOf(z7), false);
            }
        }
    }

    public static final class b extends C1616p0 {

        /* renamed from: L1, reason: collision with root package name */
        public final int f16922L1;

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f16923M1;

        public b(int i8, boolean z7) {
            this.f16922L1 = i8;
            this.f16923M1 = z7;
        }

        @Override // com.llamalab.automate.C1616p0, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            Uri uriFor;
            Uri uriFor2;
            super.C(automateService, j8, j9, j10);
            int i8 = Build.VERSION.SDK_INT;
            if (26 <= i8) {
                uriFor2 = Settings.Global.getUriFor("mobile_data" + this.f16922L1);
                if (uriFor2 != null) {
                    w2(false, uriFor2);
                }
                uriFor = Settings.Global.getUriFor("mobile_data");
            } else {
                uriFor = 17 <= i8 ? Settings.Global.getUriFor("mobile_data") : Settings.Secure.getUriFor("mobile_data");
            }
            w2(false, uriFor);
        }

        @Override // com.llamalab.automate.C1616p0
        public final void x2(Uri uri) {
            try {
                int i8 = Build.VERSION.SDK_INT;
                int i9 = 26 <= i8 ? Settings.Global.getInt(v2(), uri.getLastPathSegment()) : 17 <= i8 ? Settings.Global.getInt(v2(), "mobile_data") : Settings.Secure.getInt(v2(), "mobile_data");
                boolean z7 = this.f16923M1;
                boolean z8 = true;
                if (z7 != (i9 != 0)) {
                    if (z7) {
                        z8 = false;
                    }
                    q2(Boolean.valueOf(z8), false);
                }
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 26 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_mobile_data_enabled_immediate, C2541R.string.caption_mobile_data_enabled_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (94 <= dVar.f6413Z) {
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
        if (94 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        boolean booleanValue;
        TelephonyManager createForSubscriptionId;
        c1708z0.q(C2541R.string.stmt_mobile_data_enabled_title);
        int m8 = J3.h.m(c1708z0, this.subscriptionId, w3.n.b());
        int i8 = Build.VERSION.SDK_INT;
        if (26 <= i8) {
            createForSubscriptionId = ((TelephonyManager) c1708z0.getSystemService("phone")).createForSubscriptionId(m8);
            booleanValue = createForSubscriptionId.isDataEnabled();
        } else {
            ConnectivityManager connectivityManager = (ConnectivityManager) c1708z0.getSystemService("connectivity");
            booleanValue = ((Boolean) connectivityManager.getClass().getMethod("getMobileDataEnabled", new Class[0]).invoke(connectivityManager, new Object[0])).booleanValue();
        }
        if (J1(1) == 0) {
            o(c1708z0, booleanValue);
            return true;
        }
        if (28 <= i8) {
            a aVar = new a(m8, booleanValue);
            c1708z0.w(aVar);
            aVar.v2(524288);
        } else {
            c1708z0.w(new b(m8, booleanValue));
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
