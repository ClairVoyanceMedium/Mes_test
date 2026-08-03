package com.llamalab.automate.stmt;

import com.llamalab.automate.InterfaceC1700x0;

/* loaded from: classes.dex */
public abstract class RingtoneAction extends Action {
    public InterfaceC1700x0 ringtoneType;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.ringtoneType);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.ringtoneType = (InterfaceC1700x0) cVar.readObject();
    }
}
