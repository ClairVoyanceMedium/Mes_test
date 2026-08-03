package com.llamalab.automate.stmt;

import android.os.Build;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.C1677x;

/* loaded from: classes.dex */
public abstract class DatabaseAction extends Action implements AsyncStatement {
    public InterfaceC1700x0 databaseFile;
    public InterfaceC1700x0 parameters;
    public InterfaceC1700x0 resultType;
    public InterfaceC1700x0 statement;
    public J3.l varResult;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.databaseFile);
        dVar.g(this.statement);
        dVar.g(this.parameters);
        dVar.g(this.resultType);
        dVar.g(this.varResult);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.databaseFile);
        visitor.b(this.statement);
        visitor.b(this.parameters);
        visitor.b(this.resultType);
        visitor.b(this.varResult);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.databaseFile = (InterfaceC1700x0) cVar.readObject();
        this.statement = (InterfaceC1700x0) cVar.readObject();
        this.parameters = (InterfaceC1700x0) cVar.readObject();
        this.resultType = (InterfaceC1700x0) cVar.readObject();
        this.varResult = (J3.l) cVar.readObject();
    }

    public final void q(C1708z0 c1708z0, com.llamalab.safs.n nVar, int i8, C1677x.a aVar) {
        for (C1677x c1677x : c1708z0.j2().r(C1677x.class, c1708z0.f17644y0)) {
            if (nVar.equals(c1677x.f17565y1)) {
                F5.n.h(c1677x);
                c1677x.f15404y0 = this.f16218X;
                if (c1677x.f17564M1 != null) {
                    throw new IllegalStateException("Already running");
                }
                c1677x.n2(1);
                C1675w c1675w = new C1675w(c1677x, i8, aVar);
                c1677x.f17564M1 = c1675w;
                c1675w.start();
                return;
            }
        }
        C1677x c1679y = 16 <= Build.VERSION.SDK_INT ? new C1679y(nVar) : new C1677x(nVar);
        c1708z0.w(c1679y);
        if (c1679y.f17564M1 != null) {
            throw new IllegalStateException("Already running");
        }
        c1679y.n2(1);
        C1675w c1675w2 = new C1675w(c1679y, i8, aVar);
        c1679y.f17564M1 = c1675w2;
        c1675w2.start();
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varResult;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
