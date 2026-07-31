package com.llamalab.automate.stmt;

import android.content.Intent;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;

/* loaded from: classes.dex */
public abstract class ActivityAction extends Action implements StartActivityForResultStatement {
    public InterfaceC1700x0 notificationChannelId;
    public InterfaceC1700x0 startActivity;
    public InterfaceC1700x0 timeout;

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final String P(C1708z0 c1708z0) {
        return q(c1708z0);
    }

    @Override // com.llamalab.automate.IntentStatement
    public final /* synthetic */ boolean V(C1708z0 c1708z0, Intent intent) {
        D1.P.d(this, c1708z0, intent);
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.timeout);
        dVar.g(this.startActivity);
        dVar.g(this.notificationChannelId);
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final long k2(C1708z0 c1708z0) {
        return s(c1708z0);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.timeout = (InterfaceC1700x0) cVar.readObject();
        this.startActivity = (InterfaceC1700x0) cVar.readObject();
        this.notificationChannelId = (InterfaceC1700x0) cVar.readObject();
    }

    public final String q(C1708z0 c1708z0) {
        return J3.h.x(c1708z0, this.notificationChannelId, null);
    }

    public final boolean r(C1708z0 c1708z0) {
        return J3.h.f(c1708z0, this.startActivity, false);
    }

    public final long s(C1708z0 c1708z0) {
        return J3.h.t(c1708z0, this.timeout, 0L);
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final boolean v(C1708z0 c1708z0) {
        return r(c1708z0);
    }
}
