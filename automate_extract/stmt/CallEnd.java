package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.Z2;
import java.lang.reflect.Method;

@F3.f("call_end.html")
@F3.a(C2541R.integer.ic_device_access_end_call)
@F3.i(C2541R.string.stmt_call_end_title)
@F3.h(C2541R.string.stmt_call_end_summary)
@F3.c(C2541R.string.caption_call_end)
@F3.e(C2541R.layout.stmt_call_end_edit)
/* loaded from: classes.dex */
public final class CallEnd extends Action implements AsyncStatement {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 28 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ANSWER_PHONE_CALLS")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CALL_PHONE")};
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_call_end_title);
        int i8 = Build.VERSION.SDK_INT;
        if (28 <= i8) {
            Z2.o(c1708z0.getSystemService("telecom")).endCall();
        } else if (21 <= i8) {
            TelephonyManager telephonyManager = (TelephonyManager) c1708z0.getSystemService("phone");
            telephonyManager.getClass().getMethod("endCall", new Class[0]).invoke(telephonyManager, new Object[0]);
        } else {
            TelephonyManager telephonyManager2 = (TelephonyManager) c1708z0.getSystemService("phone");
            Method declaredMethod = telephonyManager2.getClass().getDeclaredMethod("getITelephony", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(telephonyManager2, new Object[0]);
            invoke.getClass().getMethod("endCall", new Class[0]).invoke(invoke, new Object[0]);
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
