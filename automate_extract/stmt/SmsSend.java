package com.llamalab.automate.stmt;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.telephony.TelephonyManager;
import com.llamalab.android.telephony.SmsDeliveryException;
import com.llamalab.android.telephony.SmsPermanentDeliveryException;
import com.llamalab.android.telephony.SmsSendException;
import com.llamalab.android.telephony.SmsTemporaryDeliveryException;
import com.llamalab.automate.AutomateApplication;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.ArrayList;
import x3.C2424b;
import x3.C2425c;
import x3.C2443u;

@F3.f("sms_send.html")
@F3.a(C2541R.integer.ic_social_chat)
@F3.i(C2541R.string.stmt_sms_send_title)
@F3.h(C2541R.string.stmt_sms_send_summary)
@F3.e(C2541R.layout.stmt_sms_send_edit)
/* loaded from: classes.dex */
public final class SmsSend extends IntermittentAction implements InterfaceC1622q2, IntentStatement {

    /* renamed from: L1, reason: collision with root package name */
    public int f17130L1;

    @Deprecated
    public InterfaceC1700x0 hidden;
    public InterfaceC1700x0 message;
    public InterfaceC1700x0 multipartLimit;
    public InterfaceC1700x0 phoneNumber;
    public InterfaceC1700x0 subscriptionId;
    public J3.l varMultipartCount;

    public static void s(C1708z0 c1708z0) {
        int i8 = C2424b.f23371b;
        PendingIntent l8 = c1708z0.l(i8 | 536870912, "com.llamalab.automate.intent.action.SMS_SENT");
        if (l8 != null) {
            l8.cancel();
        }
        PendingIntent l9 = c1708z0.l(i8 | 536870912, "com.llamalab.automate.intent.action.SMS_DELIVERED");
        if (l9 != null) {
            l9.cancel();
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final void C1(C1708z0 c1708z0) {
        if (J1(0) != 0) {
            s(c1708z0);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.SEND_SMS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_sms_send);
        l8.u(C2541R.string.caption_to, this.phoneNumber);
        l8.v(this.message, 0);
        return l8.f16030c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:173:0x0282, code lost:
    
        if (r14 != false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0212, code lost:
    
        if (r14 != false) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0284, code lost:
    
        s(r13);
        r13.f17642x0 = r12.onComplete;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x028b, code lost:
    
        return true;
     */
    @Override // com.llamalab.automate.IntentStatement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        boolean z7;
        boolean z8;
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        if (action.equals("com.llamalab.automate.intent.action.SMS_SENT")) {
            int intExtra = intent.getIntExtra("errorCode", -1);
            if (intExtra != -1) {
                if (intExtra == 1) {
                    throw new SmsSendException("Generic failure");
                }
                if (intExtra == 2) {
                    throw new SmsSendException("Radio off");
                }
                if (intExtra == 3) {
                    throw new SmsSendException("No PDU");
                }
                if (intExtra != 4) {
                    throw new SmsSendException(C1.H0.o("Unknown error (", intExtra, ")"));
                }
                throw new SmsSendException("No service");
            }
            if (1 == J1(0)) {
                Integer num = (Integer) c1708z0.j(this.f17130L1);
                int intValue = num != null ? num.intValue() : 0;
                if (intValue > 1) {
                    c1708z0.z(this.f17130L1, Integer.valueOf(intValue - 1));
                    z7 = false;
                } else {
                    c1708z0.z(this.f17130L1, null);
                    z7 = true;
                }
            }
            return false;
        }
        if (action.equals("com.llamalab.automate.intent.action.SMS_DELIVERED")) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("pdu");
            if (byteArrayExtra == null) {
                throw new SmsDeliveryException("No delivery PDU");
            }
            String stringExtra = intent.getStringExtra("format");
            int phoneType = "3gpp".equals(stringExtra) ? 1 : "3gpp2".equals(stringExtra) ? 2 : ((TelephonyManager) c1708z0.getSystemService("phone")).getPhoneType();
            SmsMessage createFromPdu = (23 > Build.VERSION.SDK_INT || stringExtra == null) ? SmsMessage.createFromPdu(byteArrayExtra) : SmsMessage.createFromPdu(byteArrayExtra, stringExtra);
            if (!createFromPdu.isStatusReportMessage()) {
                throw new SmsDeliveryException("Not a status report");
            }
            int status = createFromPdu.getStatus();
            if (phoneType == 1) {
                int i8 = status & 96;
                if (i8 != 0) {
                    if (i8 == 32) {
                        switch (status & 127) {
                            case 32:
                                throw new SmsTemporaryDeliveryException("Congestion");
                            case 33:
                                throw new SmsTemporaryDeliveryException("SME busy");
                            case 34:
                                throw new SmsTemporaryDeliveryException("No response from SME");
                            case 35:
                                throw new SmsTemporaryDeliveryException("Service rejected");
                            case 36:
                                throw new SmsTemporaryDeliveryException("Quality of service not available");
                            case 37:
                                throw new SmsTemporaryDeliveryException("Error in SME");
                            default:
                                throw new SmsTemporaryDeliveryException(C1.H0.o("Unknown error (", status, ")"));
                        }
                    }
                    if (i8 != 64) {
                        if (i8 != 96) {
                            throw new SmsDeliveryException(C1.H0.o("Unknown error (", status, ")"));
                        }
                        switch (status & 127) {
                            case 96:
                                throw new SmsTemporaryDeliveryException("Congestion");
                            case 97:
                                throw new SmsTemporaryDeliveryException("SME busy");
                            case 98:
                                throw new SmsTemporaryDeliveryException("No response from SME");
                            case 99:
                                throw new SmsTemporaryDeliveryException("Service rejected");
                            case 100:
                                throw new SmsTemporaryDeliveryException("Quality of service not available");
                            case 101:
                                throw new SmsTemporaryDeliveryException("Error in SME");
                            default:
                                throw new SmsTemporaryDeliveryException(C1.H0.o("Unknown error (", status, ")"));
                        }
                    }
                    switch (status & 127) {
                        case 64:
                            throw new SmsPermanentDeliveryException("Remote procedure error");
                        case 65:
                            throw new SmsPermanentDeliveryException("Incompatible destination");
                        case 66:
                            throw new SmsPermanentDeliveryException("Connection rejected by SME");
                        case 67:
                            throw new SmsPermanentDeliveryException("Not obtainable");
                        case 68:
                            throw new SmsPermanentDeliveryException("Quality of service not available");
                        case 69:
                            throw new SmsPermanentDeliveryException("No interworking available");
                        case 70:
                            throw new SmsPermanentDeliveryException("SM validity period expired");
                        case 71:
                            throw new SmsPermanentDeliveryException("SM deleted by originating SME");
                        case 72:
                            throw new SmsPermanentDeliveryException("SM deleted by SC administration");
                        case 73:
                            throw new SmsPermanentDeliveryException("SM does not exist");
                        default:
                            throw new SmsPermanentDeliveryException(C1.H0.o("Unknown error (", status, ")"));
                    }
                }
            } else {
                if (phoneType != 2) {
                    throw new IllegalArgumentException(B4.g.g("Phone type: ", phoneType));
                }
                int i9 = (status >> 24) & 3;
                if (i9 != 0) {
                    if (i9 == 2) {
                        int i10 = (status >> 16) & 255;
                        if (i10 == 4) {
                            throw new SmsTemporaryDeliveryException("Network congestion");
                        }
                        if (i10 != 5) {
                            throw new SmsTemporaryDeliveryException(C1.H0.o("Unknown error (", status, ")"));
                        }
                        throw new SmsTemporaryDeliveryException("Network error");
                    }
                    if (i9 != 3) {
                        throw new SmsDeliveryException(C1.H0.o("Unknown error (", status, ")"));
                    }
                    int i11 = (status >> 16) & 255;
                    if (i11 == 13) {
                        throw new SmsPermanentDeliveryException("Message expired");
                    }
                    switch (i11) {
                        case 4:
                            throw new SmsPermanentDeliveryException("Network congestion");
                        case 5:
                            throw new SmsPermanentDeliveryException("Network error");
                        case 6:
                            throw new SmsPermanentDeliveryException("Cancel failed");
                        case 7:
                            throw new SmsPermanentDeliveryException("Destination blocked");
                        case 8:
                            throw new SmsPermanentDeliveryException("Text too long");
                        case 9:
                            throw new SmsPermanentDeliveryException("Duplicate message");
                        case 10:
                            throw new SmsPermanentDeliveryException("Invalid destination");
                        default:
                            throw new SmsPermanentDeliveryException(C1.H0.o("Unknown error (", status, ")"));
                    }
                }
            }
            Integer num2 = (Integer) c1708z0.j(this.f17130L1);
            int intValue2 = num2 != null ? num2.intValue() : 0;
            if (intValue2 > 1) {
                c1708z0.z(this.f17130L1, Integer.valueOf(intValue2 - 1));
                z8 = false;
            } else {
                c1708z0.z(this.f17130L1, null);
                z8 = true;
            }
        }
        return false;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        r(dVar, 47);
        dVar.g(this.phoneNumber);
        if (45 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
        dVar.g(this.message);
        dVar.g(this.multipartLimit);
        dVar.g(this.hidden);
        if (97 <= dVar.f6413Z) {
            dVar.g(this.varMultipartCount);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.phoneNumber);
        visitor.b(this.subscriptionId);
        visitor.b(this.message);
        visitor.b(this.multipartLimit);
        visitor.b(this.hidden);
        visitor.b(this.varMultipartCount);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        if (6 <= c1625r2.f16204b) {
            this.f17130L1 = c1625r2.d(false);
        }
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        q(cVar, 47);
        this.phoneNumber = (InterfaceC1700x0) cVar.readObject();
        if (45 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
        this.message = (InterfaceC1700x0) cVar.readObject();
        this.multipartLimit = (InterfaceC1700x0) cVar.readObject();
        this.hidden = (InterfaceC1700x0) cVar.readObject();
        if (97 <= cVar.f6409x0) {
            this.varMultipartCount = (J3.l) cVar.readObject();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010c  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        ArrayList<PendingIntent> arrayList;
        boolean z7;
        c1708z0.q(C2541R.string.stmt_sms_send_title);
        ArrayList<PendingIntent> arrayList2 = null;
        String x7 = J3.h.x(c1708z0, this.phoneNumber, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("phoneNumber");
        }
        if (x7.isEmpty()) {
            throw new IllegalArgumentException("Phone number is empty");
        }
        String x8 = J3.h.x(c1708z0, this.message, null);
        if (x8 == null) {
            throw new RequiredArgumentNullException("message");
        }
        if (x8.isEmpty()) {
            throw new IllegalArgumentException("Message is empty");
        }
        int c8 = w3.n.c();
        int m8 = J3.h.m(c1708z0, this.subscriptionId, c8);
        int max = Math.max(J3.h.m(c1708z0, this.multipartLimit, 1), 1);
        SmsManager smsManager = (22 > Build.VERSION.SDK_INT || c8 == m8) ? SmsManager.getDefault() : SmsManager.getSmsManagerForSubscriptionId(m8);
        ArrayList<String> divideMessage = smsManager.divideMessage(x8);
        int size = divideMessage.size();
        while (size > max) {
            size--;
            divideMessage.remove(size);
        }
        if (size <= 0) {
            throw new IllegalStateException("No parts");
        }
        int J12 = J1(0);
        if (J12 != 1) {
            if (J12 != 2) {
                arrayList = null;
                z7 = true;
                if (C1710z2.b(C2425c.c(c1708z0), "sms").a(size)) {
                    throw new SecurityException("User SMS send rate exceeded, see Settings.");
                }
                C2443u c2443u = AutomateApplication.f14523y0;
                synchronized (c2443u) {
                    if (!c2443u.a(size)) {
                        throw new SecurityException("Maximum SMS send rate exceeded.");
                    }
                }
                smsManager.sendMultipartTextMessage(x7, null, divideMessage, arrayList2, arrayList);
                c1708z0.g1().h(c1708z0.f17644y0, c1708z0.g(), C2541R.string.log_sms_sent, x7, Integer.valueOf(size));
                J3.l lVar = this.varMultipartCount;
                if (lVar != null) {
                    c1708z0.z(lVar.f4659Y, Double.valueOf(size));
                }
                if (!z7) {
                    return false;
                }
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
            int i8 = C2424b.f23371b | 268435456;
            ArrayList<PendingIntent> arrayList3 = new ArrayList<>(size);
            PendingIntent l8 = c1708z0.l(i8, "com.llamalab.automate.intent.action.SMS_DELIVERED");
            int i9 = size;
            while (true) {
                i9--;
                if (i9 < 0) {
                    break;
                }
                arrayList3.add(l8);
            }
            arrayList2 = arrayList3;
        }
        int i10 = 268435456 | C2424b.f23371b;
        ArrayList<PendingIntent> arrayList4 = new ArrayList<>(size);
        PendingIntent l9 = c1708z0.l(i10, "com.llamalab.automate.intent.action.SMS_SENT");
        int i11 = size;
        while (true) {
            i11--;
            if (i11 < 0) {
                break;
            }
            arrayList4.add(l9);
        }
        c1708z0.z(this.f17130L1, Integer.valueOf(size));
        arrayList = arrayList2;
        arrayList2 = arrayList4;
        z7 = false;
        if (C1710z2.b(C2425c.c(c1708z0), "sms").a(size)) {
        }
    }
}
