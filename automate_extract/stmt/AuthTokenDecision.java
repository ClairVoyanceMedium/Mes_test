package com.llamalab.automate.stmt;

import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class AuthTokenDecision extends Decision implements AuthTokenStatement {
    public InterfaceC1700x0 account;

    @Override // com.llamalab.automate.stmt.AuthTokenStatement
    public final InterfaceC1700x0 N0() {
        return this.account;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.account);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.account);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.account = (InterfaceC1700x0) cVar.readObject();
    }
}
