package com.llamalab.automate.stmt;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.N2;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.io.HttpStatusException;
import java.io.ByteArrayInputStream;
import x3.C2424b;
import x3.C2434l;

@F3.f("mms_send.html")
@F3.a(C2541R.integer.ic_social_chat_pic)
@F3.i(C2541R.string.stmt_mms_send_title)
@F3.h(C2541R.string.stmt_mms_send_summary)
@F3.e(C2541R.layout.stmt_mms_send_edit)
/* loaded from: classes.dex */
public final class MmsSend extends Action implements AsyncStatement, IntentStatement {
    public InterfaceC1700x0 attachment;

    @Deprecated
    public InterfaceC1700x0 hidden;
    public InterfaceC1700x0 message;
    public InterfaceC1700x0 phoneNumber;
    public InterfaceC1700x0 subject;
    public InterfaceC1700x0 subscriptionId;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final void C1(C1708z0 c1708z0) {
        PendingIntent l8 = c1708z0.l(536870912 | C2424b.f23371b, "com.llamalab.automate.intent.action.MMS_SENT");
        if (l8 != null) {
            l8.cancel();
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 30 == i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_NUMBERS"), com.llamalab.automate.access.c.j("android.permission.SEND_SMS")} : 21 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE"), com.llamalab.automate.access.c.j("android.permission.SEND_SMS")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.CHANGE_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE"), com.llamalab.automate.access.c.j("android.permission.SEND_SMS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_mms_send);
        l8.u(C2541R.string.caption_to, this.phoneNumber);
        l8.v(this.message, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        int intExtra = intent.getIntExtra("android.telephony.extra.MMS_HTTP_STATUS", MoreOsConstants.KEY_PLAYCD);
        if (200 != intExtra) {
            throw new HttpStatusException(HttpStatusException.a(intExtra), intExtra);
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("com.llamalab.automate.intent.extra.RECIPIENTS");
        String[] strArr = C2434l.f23396g;
        if (stringArrayExtra == null) {
            stringArrayExtra = strArr;
        }
        for (String str : stringArrayExtra) {
            c1708z0.g1().h(c1708z0.f17644y0, c1708z0.g(), C2541R.string.log_mms_sent, str);
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("android.telephony.extra.MMS_DATA");
        if (byteArrayExtra != null) {
            AbstractC1653k0.y2(new ByteArrayInputStream(byteArrayExtra));
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.phoneNumber);
        if (45 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
        dVar.g(this.subject);
        dVar.g(this.message);
        dVar.g(this.attachment);
        dVar.g(this.hidden);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.phoneNumber);
        visitor.b(this.subscriptionId);
        visitor.b(this.subject);
        visitor.b(this.message);
        visitor.b(this.attachment);
        visitor.b(this.hidden);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.phoneNumber = (InterfaceC1700x0) cVar.readObject();
        if (45 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
        this.subject = (InterfaceC1700x0) cVar.readObject();
        this.message = (InterfaceC1700x0) cVar.readObject();
        this.attachment = (InterfaceC1700x0) cVar.readObject();
        this.hidden = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        N2 c1655l0;
        String p8;
        c1708z0.q(C2541R.string.stmt_mms_send_title);
        String[] w8 = J3.h.w(c1708z0, this.phoneNumber, null);
        if (w8 == null) {
            throw new RequiredArgumentNullException("phoneNumber");
        }
        if (w8.length == 0) {
            throw new IllegalArgumentException("phoneNumber");
        }
        for (int i8 = 0; i8 < w8.length; i8++) {
            String str = w8[i8];
            if (str == null) {
                throw new IllegalArgumentException("phoneNumber");
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
                if (21 <= Build.VERSION.SDK_INT) {
                    String[] strArr = w3.n.f23254a;
                    p8 = PhoneNumberUtils.normalizeNumber(str);
                } else {
                    p8 = w3.n.p(str);
                }
                if (TextUtils.isEmpty(p8) || "+".equals(p8)) {
                    throw new IllegalArgumentException("phoneNumber");
                }
                w8[i8] = D1.P.n(p8, "/TYPE=PLMN");
            }
        }
        int m8 = J3.h.m(c1708z0, this.subscriptionId, w3.n.c());
        String x7 = J3.h.x(c1708z0, this.subject, null);
        String x8 = J3.h.x(c1708z0, this.message, "");
        com.llamalab.safs.n p9 = J3.h.p(c1708z0, this.attachment);
        if (21 <= Build.VERSION.SDK_INT) {
            Bundle bundle = new Bundle();
            bundle.putStringArray("com.llamalab.automate.intent.extra.RECIPIENTS", w8);
            c1655l0 = new C1657m0(w8, x7, x8, p9, m8, c1708z0.m("com.llamalab.automate.intent.action.MMS_SENT", bundle, 1342177280 | C2424b.f23371b, 0));
        } else {
            c1655l0 = new C1655l0(w8, x7, x8, p9, m8);
        }
        c1708z0.w(c1655l0);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
