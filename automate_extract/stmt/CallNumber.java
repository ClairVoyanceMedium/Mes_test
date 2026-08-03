package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.automate.AutomateApplication;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import x3.C2425c;
import x3.C2443u;

@F3.f("call_number.html")
@F3.a(C2541R.integer.ic_device_access_call)
@F3.i(C2541R.string.stmt_call_number_title)
@F3.h(C2541R.string.stmt_call_number_summary)
@F3.e(C2541R.layout.stmt_call_number_edit)
/* loaded from: classes.dex */
public final class CallNumber extends DialerAction {
    public InterfaceC1700x0 flags;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CALL_PHONE"), com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE"), com.llamalab.automate.access.c.f15547h} : 22 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CALL_PHONE"), com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CALL_PHONE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_call_number);
        l8.v(this.phoneNumber, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.DialerAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (98 <= dVar.f6413Z) {
            dVar.g(this.flags);
        }
    }

    @Override // com.llamalab.automate.stmt.DialerAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.flags);
    }

    @Override // com.llamalab.automate.stmt.DialerAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (98 <= cVar.f6409x0) {
            this.flags = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_call_number_title);
        e(c1708z0);
        Intent addFlags = q(c1708z0, "android.intent.action.CALL").addFlags(268697600);
        if (addFlags.getData() == null) {
            throw new RequiredArgumentNullException("phoneNumber");
        }
        int m8 = J3.h.m(c1708z0, this.flags, 0);
        int i8 = Build.VERSION.SDK_INT;
        if (23 <= i8 && (m8 & 1) != 0) {
            addFlags.putExtra("android.telecom.extra.START_CALL_WITH_SPEAKERPHONE", true);
        }
        if (26 <= i8 && (m8 & 2) != 0) {
            addFlags.putExtra("android.telecom.extra.START_CALL_WITH_RTT", true);
        }
        if (!C1710z2.b(C2425c.c(c1708z0), "call").a(1)) {
            throw new SecurityException("User call rate limit exceeded, see Settings.");
        }
        C2443u c2443u = AutomateApplication.f14520Z;
        synchronized (c2443u) {
            if (!c2443u.a(1)) {
                throw new SecurityException("Maximum call rate exceeded");
            }
        }
        c1708z0.startActivity(addFlags);
        c1708z0.g1().h(c1708z0.f17644y0, c1708z0.g(), C2541R.string.log_call_made, addFlags.getData().getSchemeSpecificPart());
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
