package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("call_screening.html")
@F3.a(C2541R.integer.ic_call_missed)
@F3.i(C2541R.string.stmt_call_screening_title)
@F3.h(C2541R.string.stmt_call_screening_summary)
@F3.e(C2541R.layout.stmt_call_screening_edit)
/* loaded from: classes.dex */
public final class CallScreening extends Action implements AsyncStatement {
    public InterfaceC1700x0 phoneNumber;
    public J3.l varPhoneNumber;
    public J3.l varVerificationStatus;
    public InterfaceC1700x0 verificationStatus;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.l(), com.llamalab.automate.access.c.j("android.permission.READ_CONTACTS")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.phoneNumber);
        dVar.g(this.verificationStatus);
        dVar.g(this.varPhoneNumber);
        dVar.g(this.varVerificationStatus);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.phoneNumber);
        visitor.b(this.verificationStatus);
        visitor.b(this.varPhoneNumber);
        visitor.b(this.varVerificationStatus);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.phoneNumber = (InterfaceC1700x0) cVar.readObject();
        this.verificationStatus = (InterfaceC1700x0) cVar.readObject();
        this.varPhoneNumber = (J3.l) cVar.readObject();
        this.varVerificationStatus = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_call_screening_title);
        IncapableAndroidVersionException.b(29, "call screening");
        e(c1708z0);
        c1708z0.w(new C1664q(J3.h.x(c1708z0, this.phoneNumber, null), J3.h.m(c1708z0, this.verificationStatus, 7) & 7));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varPhoneNumber;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[0]);
        }
        J3.l lVar2 = this.varVerificationStatus;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[1]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
