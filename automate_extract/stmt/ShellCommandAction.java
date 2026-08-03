package com.llamalab.automate.stmt;

import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class ShellCommandAction extends Action implements AsyncStatement {
    public InterfaceC1700x0 command;
    public J3.l varExitCode;
    public J3.l varStderr;
    public J3.l varStdout;
    public InterfaceC1700x0 workDir;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.command);
        dVar.g(this.workDir);
        dVar.g(this.varStdout);
        dVar.g(this.varStderr);
        dVar.g(this.varExitCode);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.command);
        visitor.b(this.workDir);
        visitor.b(this.varStdout);
        visitor.b(this.varStderr);
        visitor.b(this.varExitCode);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.command = (InterfaceC1700x0) cVar.readObject();
        this.workDir = (InterfaceC1700x0) cVar.readObject();
        this.varStdout = (J3.l) cVar.readObject();
        this.varStderr = (J3.l) cVar.readObject();
        this.varExitCode = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varExitCode;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[0]);
        }
        J3.l lVar2 = this.varStdout;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[1]);
        }
        J3.l lVar3 = this.varStderr;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, objArr[2]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
