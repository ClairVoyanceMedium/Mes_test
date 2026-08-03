package com.llamalab.automate.stmt;

import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class GDriveTransferAction extends GDriveAction {
    public InterfaceC1700x0 localPath;
    public InterfaceC1700x0 onlyNewerFiles;
    public InterfaceC1700x0 recursive;
    public InterfaceC1700x0 remotePath;

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.localPath);
        dVar.g(this.remotePath);
        dVar.g(this.recursive);
        if (57 <= dVar.f6413Z) {
            dVar.g(this.onlyNewerFiles);
        }
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.localPath);
        visitor.b(this.remotePath);
        visitor.b(this.recursive);
        visitor.b(this.onlyNewerFiles);
    }

    @Override // com.llamalab.automate.stmt.AuthTokenAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.localPath = (InterfaceC1700x0) cVar.readObject();
        this.remotePath = (InterfaceC1700x0) cVar.readObject();
        this.recursive = (InterfaceC1700x0) cVar.readObject();
        if (57 <= cVar.f6409x0) {
            this.onlyNewerFiles = (InterfaceC1700x0) cVar.readObject();
        }
    }
}
