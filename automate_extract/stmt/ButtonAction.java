package com.llamalab.automate.stmt;

import com.llamalab.automate.InterfaceC1700x0;

/* loaded from: classes.dex */
public abstract class ButtonAction extends Action {
    public InterfaceC1700x0 buttons;
    public J3.l varButtonPressed;

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.buttons);
        dVar.g(this.varButtonPressed);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.buttons = (InterfaceC1700x0) cVar.readObject();
        this.varButtonPressed = (J3.l) cVar.readObject();
    }
}
