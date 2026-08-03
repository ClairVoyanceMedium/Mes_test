package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.stmt.CallEvent;

@F3.f("call_incoming.html")
@F3.a(C2541R.integer.ic_call_incoming)
@F3.i(C2541R.string.stmt_call_incoming_title)
@F3.h(C2541R.string.stmt_call_incoming_summary)
@F3.e(C2541R.layout.stmt_call_incoming_edit)
/* loaded from: classes.dex */
public final class CallIncoming extends CallEvent {

    public static final class a extends CallEvent.a {
        public a(int i8, int i9, String str) {
            super(i8, i9, str);
        }

        @Override // com.llamalab.automate.stmt.CallEvent.a
        public final void s(Intent intent, int i8, int i9, CallEvent.a.C0169a c0169a) {
            String str;
            int i10 = this.f16414x1;
            if (i8 == 1) {
                int i11 = c0169a.f16416a;
                if ((i11 & 2) == 0 || (i10 != 0 && ((i11 & 4) != 0 || 3 != i10))) {
                    this.f16413N1.delete(i9);
                    return;
                }
            } else {
                if (i8 == 2) {
                    str = intent.getStringExtra("incoming_number");
                    if (TextUtils.isEmpty(str)) {
                        str = null;
                    }
                    c0169a.f16417b = str;
                    if (1 != i10) {
                        return;
                    }
                    u(i9, intent, str);
                }
                if (i8 != 4 || (c0169a.f16416a & 2) == 0 || 2 != i10) {
                    return;
                }
            }
            str = c0169a.f16417b;
            u(i9, intent, str);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 28 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE"), com.llamalab.automate.access.c.j("android.permission.READ_CALL_LOG")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_call_incoming_complete, C2541R.string.caption_call_incoming_ringing, C2541R.string.caption_call_incoming_answered, C2541R.string.caption_call_incoming_missed);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_call_incoming_title);
        e(c1708z0);
        a aVar = new a(J1(1), J3.h.m(c1708z0, this.subscriptionId, -1), J3.h.x(c1708z0, this.phoneNumber, null));
        c1708z0.w(aVar);
        if (23 <= Build.VERSION.SDK_INT) {
            aVar.o(2, "android.intent.action.SUBSCRIPTION_PHONE_STATE");
            return false;
        }
        aVar.h("android.intent.action.PHONE_STATE");
        return false;
    }
}
