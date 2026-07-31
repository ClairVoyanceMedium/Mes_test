package com.llamalab.automate.stmt;

import android.content.Intent;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class ActivityDecision extends Decision implements StartActivityForResultStatement {
    public InterfaceC1700x0 notificationChannelId;
    public InterfaceC1700x0 startActivity;
    public InterfaceC1700x0 timeout;

    public final long B(C1708z0 c1708z0) {
        return J3.h.t(c1708z0, this.timeout, 0L);
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final String P(C1708z0 c1708z0) {
        return w(c1708z0);
    }

    @Override // com.llamalab.automate.IntentStatement
    public /* synthetic */ boolean V(C1708z0 c1708z0, Intent intent) {
        D1.P.d(this, c1708z0, intent);
        return true;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.timeout);
        if (9 <= dVar.f6413Z) {
            dVar.g(this.startActivity);
        }
        if (77 <= dVar.f6413Z) {
            dVar.g(this.notificationChannelId);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.timeout);
        visitor.b(this.startActivity);
        visitor.b(this.notificationChannelId);
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final long k2(C1708z0 c1708z0) {
        return B(c1708z0);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.timeout = (InterfaceC1700x0) cVar.readObject();
        if (9 <= cVar.f6409x0) {
            this.startActivity = (InterfaceC1700x0) cVar.readObject();
        }
        if (77 <= cVar.f6409x0) {
            this.notificationChannelId = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final boolean v(C1708z0 c1708z0) {
        return z(c1708z0);
    }

    public final String w(C1708z0 c1708z0) {
        return J3.h.x(c1708z0, this.notificationChannelId, null);
    }

    public final boolean z(C1708z0 c1708z0) {
        return J3.h.f(c1708z0, this.startActivity, false);
    }
}
