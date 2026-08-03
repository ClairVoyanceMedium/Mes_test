package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsMessage;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.ReceiverStatement;

@F3.f("sms_received.html")
@F3.a(C2541R.integer.ic_social_chat_in)
@F3.i(C2541R.string.stmt_sms_received_title)
@F3.h(C2541R.string.stmt_sms_received_summary)
@F3.e(C2541R.layout.stmt_sms_received_edit)
/* loaded from: classes.dex */
public final class SmsReceived extends SmsEvent implements InterfaceC1622q2, ReceiverStatement {

    public static final class a extends AbstractC1618p2.b.C0164b {

        /* renamed from: M1, reason: collision with root package name */
        public String f17128M1;

        /* renamed from: N1, reason: collision with root package name */
        public int f17129N1;

        public a(String str, int i8) {
            super(256, 30000L);
            this.f17128M1 = str;
            this.f17129N1 = i8;
        }

        @Override // com.llamalab.automate.AbstractC1618p2
        public final void e(AutomateService automateService, Intent intent) {
            int length;
            String messageBody;
            Double d8;
            Object[] objArr = (Object[]) intent.getSerializableExtra("pdus");
            if (objArr == null || (length = objArr.length) == 0) {
                return;
            }
            String stringExtra = intent.getStringExtra("format");
            int m8 = w3.n.m(intent.getExtras());
            if (m8 == -1 || m8 == Integer.MAX_VALUE) {
                m8 = w3.n.c();
            }
            int i8 = this.f17129N1;
            if (i8 == -1 || i8 == m8) {
                SmsMessage createFromPdu = (23 > Build.VERSION.SDK_INT || stringExtra == null) ? SmsMessage.createFromPdu((byte[]) objArr[0]) : SmsMessage.createFromPdu((byte[]) objArr[0], stringExtra);
                String originatingAddress = createFromPdu.getOriginatingAddress();
                String str = this.f17128M1;
                if (str == null || (originatingAddress != null && (str.equals(originatingAddress) || PhoneNumberUtils.compare(automateService, this.f17128M1, originatingAddress)))) {
                    if (length > 1) {
                        StringBuilder sb = new StringBuilder(createFromPdu.getMessageBody());
                        for (int i9 = 1; i9 < length; i9++) {
                            sb.append(((23 > Build.VERSION.SDK_INT || stringExtra == null) ? SmsMessage.createFromPdu((byte[]) objArr[i9]) : SmsMessage.createFromPdu((byte[]) objArr[i9], stringExtra)).getMessageBody());
                        }
                        messageBody = sb.toString();
                    } else {
                        messageBody = createFromPdu.getMessageBody();
                        if (messageBody == null) {
                            messageBody = "";
                        }
                    }
                    long timestampMillis = createFromPdu.getTimestampMillis();
                    Object[] objArr2 = new Object[4];
                    objArr2[0] = originatingAddress;
                    objArr2[1] = Double.valueOf(m8);
                    objArr2[2] = messageBody;
                    if (timestampMillis > 0) {
                        double d9 = timestampMillis;
                        d8 = F5.n.l(d9, d9, d9, 1000.0d);
                    } else {
                        d8 = null;
                    }
                    objArr2[3] = d8;
                    c(intent, objArr2, false);
                }
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.RECEIVE_SMS")};
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        q(c1708z0, (String) objArr[0], (Double) objArr[1], (String) objArr[2], (Double) objArr[3]);
        return true;
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        if (7 > c1625r2.f16204b) {
            c1625r2.d(false);
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_sms_received_title);
        e(c1708z0);
        String x7 = J3.h.x(c1708z0, this.phoneNumber, null);
        int m8 = J3.h.m(c1708z0, this.subscriptionId, -1);
        a aVar = (a) c1708z0.d(a.class, this);
        if (aVar != null) {
            aVar.f17128M1 = x7;
            aVar.f17129N1 = m8;
            aVar.i0();
            return false;
        }
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        intentFilter.setPriority(Integer.MAX_VALUE);
        a aVar2 = new a(x7, m8);
        c1708z0.w(aVar2);
        aVar2.f(intentFilter);
        return false;
    }
}
