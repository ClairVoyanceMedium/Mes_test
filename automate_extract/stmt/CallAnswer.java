package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import com.llamalab.auth3p.MicrosoftClient;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.Z2;

@F3.f("call_answer.html")
@F3.a(C2541R.integer.ic_device_access_answer_call)
@F3.i(C2541R.string.stmt_call_answer_title)
@F3.h(C2541R.string.stmt_call_answer_summary)
@F3.c(C2541R.string.caption_call_answer)
@F3.e(C2541R.layout.stmt_call_answer_edit)
/* loaded from: classes.dex */
public final class CallAnswer extends Action implements AsyncStatement {

    public static final class a extends AbstractC1602l2 {
        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.F1(this.f15400Y.getPackageName(), lVar);
                lVar.c();
                p2(null);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static void q(Context context, int i8) {
        try {
            context.sendOrderedBroadcast(new Intent("android.intent.action.HEADSET_PLUG").addFlags(1073741824).putExtra(com.llamalab.auth3p.e.PARAM_STATE, i8).putExtra(MicrosoftClient.PROP_NAME, "Fake Headset").putExtra("com.llamalab.automate.intent.extra.HACK", true), null);
        } catch (Throwable unused) {
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 26 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ANSWER_PHONE_CALLS")} : 21 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE")};
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_call_answer_title);
        int i8 = Build.VERSION.SDK_INT;
        if (26 <= i8) {
            Z2.o(c1708z0.getSystemService("telecom")).acceptRingingCall();
        } else {
            if (21 <= i8) {
                c1708z0.w(new a());
                return false;
            }
            if (1 == ((TelephonyManager) c1708z0.getSystemService("phone")).getCallState()) {
                q(c1708z0, 1);
                try {
                    c1708z0.sendOrderedBroadcast(new Intent("android.intent.action.MEDIA_BUTTON").putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(1, 79)).putExtra("com.llamalab.automate.intent.extra.HACK", true), "android.permission.CALL_PRIVILEGED");
                } catch (Throwable unused) {
                }
                q(c1708z0, 0);
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
