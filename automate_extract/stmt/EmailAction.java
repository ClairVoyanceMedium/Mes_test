package com.llamalab.automate.stmt;

import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class EmailAction extends Action {
    public InterfaceC1700x0 attachments;
    public InterfaceC1700x0 bcc;
    public InterfaceC1700x0 cc;
    public InterfaceC1700x0 message;
    public InterfaceC1700x0 subject;
    public InterfaceC1700x0 to;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.to);
        dVar.g(this.cc);
        dVar.g(this.bcc);
        dVar.g(this.subject);
        dVar.g(this.message);
        dVar.g(this.attachments);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.to);
        visitor.b(this.cc);
        visitor.b(this.bcc);
        visitor.b(this.subject);
        visitor.b(this.message);
        visitor.b(this.attachments);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.to = (InterfaceC1700x0) cVar.readObject();
        this.cc = (InterfaceC1700x0) cVar.readObject();
        this.bcc = (InterfaceC1700x0) cVar.readObject();
        this.subject = (InterfaceC1700x0) cVar.readObject();
        this.message = (InterfaceC1700x0) cVar.readObject();
        this.attachments = (InterfaceC1700x0) cVar.readObject();
    }
}
