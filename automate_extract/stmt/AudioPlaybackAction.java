package com.llamalab.automate.stmt;

import com.llamalab.automate.InterfaceC1700x0;

/* loaded from: classes.dex */
public abstract class AudioPlaybackAction extends IntermittentAction {
    public InterfaceC1700x0 focus;
    public InterfaceC1700x0 notificationChannelId;
    public InterfaceC1700x0 stream;
    public InterfaceC1700x0 volume;

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.stream);
        if (93 <= dVar.f6413Z) {
            dVar.g(this.volume);
        }
        if (80 <= dVar.f6413Z) {
            dVar.g(this.focus);
        }
        dVar.g(this.notificationChannelId);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.stream = (InterfaceC1700x0) cVar.readObject();
        if (93 <= cVar.f6409x0) {
            this.volume = (InterfaceC1700x0) cVar.readObject();
        }
        if (80 <= cVar.f6409x0) {
            this.focus = (InterfaceC1700x0) cVar.readObject();
        }
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        this.notificationChannelId = interfaceC1700x0;
        if (77 <= cVar.f6409x0 || interfaceC1700x0 == null) {
            return;
        }
        this.notificationChannelId = new L3.A(interfaceC1700x0);
    }
}
