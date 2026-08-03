package com.llamalab.automate.stmt;

import B.C0280g;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionInfo;
import android.telephony.TelephonyManager;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.Z2;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class DialerAction extends Action {
    public InterfaceC1700x0 phoneNumber;
    public InterfaceC1700x0 simSlotIndex;
    public InterfaceC1700x0 subscriptionId;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.phoneNumber);
        if (69 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
        dVar.g(this.simSlotIndex);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.phoneNumber);
        visitor.b(this.subscriptionId);
        visitor.b(this.simSlotIndex);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.phoneNumber = (InterfaceC1700x0) cVar.readObject();
        if (69 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
        this.simSlotIndex = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0094, code lost:
    
        r9 = com.llamalab.automate.J2.a(r9.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfo(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Intent q(C1708z0 c1708z0, String str) {
        SubscriptionInfo activeSubscriptionInfo;
        List callCapablePhoneAccounts;
        TelephonyManager createForPhoneAccountHandle;
        String networkSpecifier;
        int parseInt;
        int e8 = w3.n.e();
        String x7 = J3.h.x(c1708z0, this.phoneNumber, null);
        int m8 = J3.h.m(c1708z0, this.subscriptionId, e8);
        int m9 = J3.h.m(c1708z0, this.simSlotIndex, -1);
        Intent intent = new Intent(str);
        if (x7 != null) {
            intent.setData(Uri.fromParts("tel", x7, null));
        }
        if (-1 != m8 && e8 != m8) {
            intent.putExtra("subscription", m8);
            if (26 <= Build.VERSION.SDK_INT) {
                TelecomManager o6 = Z2.o(c1708z0.getSystemService("telecom"));
                TelephonyManager telephonyManager = (TelephonyManager) c1708z0.getSystemService("phone");
                callCapablePhoneAccounts = o6.getCallCapablePhoneAccounts();
                List emptyList = Collections.emptyList();
                if (callCapablePhoneAccounts == null) {
                    callCapablePhoneAccounts = emptyList;
                }
                Iterator it = callCapablePhoneAccounts.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PhoneAccountHandle l8 = C0280g.l(it.next());
                    if (31 <= Build.VERSION.SDK_INT) {
                        parseInt = telephonyManager.getSubscriptionId(l8);
                    } else {
                        createForPhoneAccountHandle = telephonyManager.createForPhoneAccountHandle(l8);
                        if (createForPhoneAccountHandle != null) {
                            try {
                                networkSpecifier = createForPhoneAccountHandle.getNetworkSpecifier();
                                parseInt = Integer.parseInt(networkSpecifier);
                            } catch (NullPointerException | NumberFormatException unused) {
                            }
                        }
                        parseInt = -1;
                    }
                    if (m8 == parseInt) {
                        intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", l8);
                        break;
                    }
                }
            }
            if (22 <= Build.VERSION.SDK_INT && m9 < 0 && activeSubscriptionInfo != null) {
                m9 = activeSubscriptionInfo.getSimSlotIndex();
            }
        }
        if (m9 >= 0) {
            intent.putExtra("com.android.phone.extra.slot", m9).putExtra("simSlot", m9);
        }
        return intent;
    }
}
