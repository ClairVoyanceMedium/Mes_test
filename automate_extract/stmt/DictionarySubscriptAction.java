package com.llamalab.automate.stmt;

import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredVariableMissingException;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class DictionarySubscriptAction extends Action {
    public InterfaceC1700x0 key;
    public J3.l varDictionary;
    public J3.l varOldValue;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.key);
        dVar.g(this.varDictionary);
        if (2 <= dVar.f6413Z) {
            dVar.g(this.varOldValue);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.key);
        visitor.b(this.varDictionary);
        visitor.b(this.varOldValue);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.key = (InterfaceC1700x0) cVar.readObject();
        this.varDictionary = (J3.l) cVar.readObject();
        if (2 <= cVar.f6409x0) {
            this.varOldValue = (J3.l) cVar.readObject();
        }
    }

    public final J3.e q(C1708z0 c1708z0) {
        J3.l lVar = this.varDictionary;
        if (lVar == null) {
            throw new RequiredVariableMissingException("varDictionary");
        }
        Object j8 = c1708z0.j(lVar.f4659Y);
        if (!(j8 instanceof J3.e)) {
            J3.l lVar2 = this.varDictionary;
            J3.e eVar = new J3.e();
            c1708z0.z(lVar2.f4659Y, eVar);
            j8 = eVar;
        }
        return (J3.e) j8;
    }
}
