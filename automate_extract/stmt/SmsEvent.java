package com.llamalab.automate.stmt;

import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class SmsEvent extends Action {
    public InterfaceC1700x0 phoneNumber;
    public InterfaceC1700x0 subscriptionId;
    public J3.l varMessage;
    public J3.l varPhoneNumber;
    public J3.l varSubscriptionId;
    public J3.l varTimestamp;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (31 <= dVar.f6413Z) {
            dVar.g(this.phoneNumber);
        }
        if (73 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
        dVar.g(this.varPhoneNumber);
        if (73 <= dVar.f6413Z) {
            dVar.g(this.varSubscriptionId);
        }
        dVar.g(this.varMessage);
        if (2 <= dVar.f6413Z) {
            dVar.g(this.varTimestamp);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.phoneNumber);
        visitor.b(this.subscriptionId);
        visitor.b(this.varPhoneNumber);
        visitor.b(this.varSubscriptionId);
        visitor.b(this.varMessage);
        visitor.b(this.varTimestamp);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (31 <= cVar.f6409x0) {
            this.phoneNumber = (InterfaceC1700x0) cVar.readObject();
        }
        if (73 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
        this.varPhoneNumber = (J3.l) cVar.readObject();
        if (73 <= cVar.f6409x0) {
            this.varSubscriptionId = (J3.l) cVar.readObject();
        }
        this.varMessage = (J3.l) cVar.readObject();
        if (2 <= cVar.f6409x0) {
            this.varTimestamp = (J3.l) cVar.readObject();
        }
    }

    public final void q(C1708z0 c1708z0, String str, Double d8, String str2, Double d9) {
        J3.l lVar = this.varPhoneNumber;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varSubscriptionId;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d8);
        }
        J3.l lVar3 = this.varMessage;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, str2);
        }
        J3.l lVar4 = this.varTimestamp;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, d9);
        }
        c1708z0.f17642x0 = this.onComplete;
    }
}
