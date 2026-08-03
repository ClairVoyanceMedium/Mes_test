package com.llamalab.automate.stmt;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.io.IOException;

@F3.f("ussd_request.html")
@F3.a(C2541R.integer.ic_action_ussd)
@F3.i(C2541R.string.stmt_ussd_request_title)
@F3.h(C2541R.string.stmt_ussd_request_summary)
@F3.e(C2541R.layout.stmt_ussd_request_edit)
/* loaded from: classes.dex */
public final class UssdRequest extends Action implements AsyncStatement {
    public InterfaceC1700x0 request;
    public InterfaceC1700x0 subscriptionId;
    public J3.l varResponse;

    public static final class a extends com.llamalab.automate.W {

        /* renamed from: L1, reason: collision with root package name */
        public final C0183a f17225L1 = new C0183a();

        /* renamed from: y1, reason: collision with root package name */
        public final TelephonyManager f17226y1;

        /* renamed from: com.llamalab.automate.stmt.UssdRequest$a$a, reason: collision with other inner class name */
        public class C0183a extends TelephonyManager.UssdResponseCallback {
            public C0183a() {
            }

            @Override // android.telephony.TelephonyManager.UssdResponseCallback
            public final void onReceiveUssdResponse(TelephonyManager telephonyManager, String str, CharSequence charSequence) {
                a.this.q2(charSequence != null ? charSequence.toString() : null, false);
            }

            @Override // android.telephony.TelephonyManager.UssdResponseCallback
            public final void onReceiveUssdResponseFailed(TelephonyManager telephonyManager, String str, int i8) {
                try {
                    if (i8 == -2) {
                        throw new IllegalStateException("Telephony service unavailable");
                    }
                    if (i8 == -1) {
                        throw new IOException("Request failed");
                    }
                    throw new RuntimeException("Unknown error: " + i8);
                } catch (Throwable th) {
                    a.this.r2(th);
                }
            }
        }

        public a(TelephonyManager telephonyManager) {
            this.f17226y1 = telephonyManager;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CALL_PHONE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_ussd_request_title);
        l8.v(this.request, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.request);
        dVar.g(this.subscriptionId);
        dVar.g(this.varResponse);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.request);
        visitor.b(this.subscriptionId);
        visitor.b(this.varResponse);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.request = (InterfaceC1700x0) cVar.readObject();
        this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        this.varResponse = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        TelephonyManager createForSubscriptionId;
        c1708z0.q(C2541R.string.stmt_ussd_request_title);
        IncapableAndroidVersionException.a(26);
        String x7 = J3.h.x(c1708z0, this.request, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("request");
        }
        if (x7.isEmpty()) {
            throw new IllegalArgumentException("request");
        }
        if (x7.length() > 182) {
            throw new IllegalArgumentException("Request too long: max 182 characters");
        }
        createForSubscriptionId = ((TelephonyManager) c1708z0.getSystemService("phone")).createForSubscriptionId(J3.h.m(c1708z0, this.subscriptionId, w3.n.e()));
        a aVar = new a(createForSubscriptionId);
        c1708z0.w(aVar);
        aVar.n2(1);
        aVar.f17226y1.sendUssdRequest(x7, aVar.f17225L1, aVar.f15400Y.f14581L1);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varResponse;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
