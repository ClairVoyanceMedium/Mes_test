package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.stmt.CallEvent;

@F3.f("call_outgoing.html")
@F3.a(C2541R.integer.ic_call_outgoing)
@F3.i(C2541R.string.stmt_call_outgoing_title)
@F3.h(C2541R.string.stmt_call_outgoing_summary)
@F3.e(C2541R.layout.stmt_call_outgoing_edit)
/* loaded from: classes.dex */
public final class CallOutgoing extends CallEvent {

    public static final class a extends CallEvent.a {

        /* renamed from: O1, reason: collision with root package name */
        public String f16418O1;

        /* renamed from: P1, reason: collision with root package name */
        public boolean f16419P1;

        public a(int i8, int i9, String str) {
            super(i8, i9, str);
        }

        @Override // com.llamalab.automate.stmt.CallEvent.a, com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (!"android.intent.action.NEW_OUTGOING_CALL".equals(intent.getAction())) {
                super.onReceive(context, intent);
                return;
            }
            if (this.f16415y1) {
                F5.n.f(this, "CallOutgoing onReceive: " + intent.toUri(0));
            }
            String stringExtra = intent.getStringExtra("android.intent.extra.PHONE_NUMBER");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = null;
            }
            this.f16418O1 = stringExtra;
            this.f16419P1 = true;
        }

        @Override // com.llamalab.automate.stmt.CallEvent.a
        public final void s(Intent intent, int i8, int i9, CallEvent.a.C0169a c0169a) {
            int i10 = this.f16414x1;
            if (i8 == 1) {
                if (this.f16419P1) {
                    this.f16419P1 = false;
                    c0169a.f16416a |= 8;
                    c0169a.f16417b = this.f16418O1;
                }
                if ((c0169a.f16416a & 10) != 8 || i10 != 0) {
                    this.f16413N1.delete(i9);
                    this.f16419P1 = false;
                }
                u(i9, intent, c0169a.f16417b);
                return;
            }
            if (i8 != 2) {
                if (i8 != 4) {
                    return;
                }
                if (this.f16419P1) {
                    this.f16419P1 = false;
                    c0169a.f16416a |= 8;
                    c0169a.f16417b = this.f16418O1;
                }
                if ((c0169a.f16416a & 10) != 8 || 2 != i10) {
                    return;
                }
                u(i9, intent, c0169a.f16417b);
                return;
            }
            this.f16419P1 = false;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 28 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE"), com.llamalab.automate.access.c.j("android.permission.PROCESS_OUTGOING_CALLS"), com.llamalab.automate.access.c.j("android.permission.READ_CALL_LOG")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE"), com.llamalab.automate.access.c.j("android.permission.PROCESS_OUTGOING_CALLS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 2, C2541R.string.caption_call_outgoing_complete, C2541R.string.caption_call_outgoing_dialing);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_call_outgoing_title);
        e(c1708z0);
        a aVar = new a(J1(2), J3.h.m(c1708z0, this.subscriptionId, -1), J3.h.x(c1708z0, this.phoneNumber, null));
        c1708z0.w(aVar);
        aVar.h("android.intent.action.NEW_OUTGOING_CALL");
        if (23 <= Build.VERSION.SDK_INT) {
            aVar.o(2, "android.intent.action.SUBSCRIPTION_PHONE_STATE");
            return false;
        }
        aVar.h("android.intent.action.PHONE_STATE");
        return false;
    }
}
