package com.llamalab.automate.stmt;

import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredVariableMissingException;

/* loaded from: classes.dex */
public abstract class ArraySubscriptAction extends Action {
    public InterfaceC1700x0 index;
    public J3.l varArray;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.index);
        dVar.g(this.varArray);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.index = (InterfaceC1700x0) cVar.readObject();
        this.varArray = (J3.l) cVar.readObject();
    }

    public final J3.a q(C1708z0 c1708z0) {
        J3.l lVar = this.varArray;
        if (lVar == null) {
            throw new RequiredVariableMissingException("varArray");
        }
        Object j8 = c1708z0.j(lVar.f4659Y);
        if (!(j8 instanceof J3.a)) {
            J3.l lVar2 = this.varArray;
            J3.a aVar = new J3.a();
            c1708z0.z(lVar2.f4659Y, aVar);
            j8 = aVar;
        }
        return (J3.a) j8;
    }
}
