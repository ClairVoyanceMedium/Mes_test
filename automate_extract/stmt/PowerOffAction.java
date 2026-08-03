package com.llamalab.automate.stmt;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.BootCompletedReceiver;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.CautionStatement;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.ReceiverStatement;

/* loaded from: classes.dex */
public abstract class PowerOffAction extends Action implements InterfaceC1622q2, ReceiverStatement, CautionStatement {

    /* renamed from: L1, reason: collision with root package name */
    public int f17042L1 = -1;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        c1708z0.z(this.f17042L1, null);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f17042L1 = c1625r2.d(false);
    }

    public abstract void q(C1708z0 c1708z0);

    public boolean r(C1708z0 c1708z0, long j8) {
        if (!(c1708z0.getPackageManager().getComponentEnabledSetting(new ComponentName(c1708z0.getPackageName(), BootCompletedReceiver.class.getName())) == 1)) {
            c1708z0.z(this.f17042L1, null);
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        AbstractC1618p2.a aVar = new AbstractC1618p2.a();
        c1708z0.w(aVar);
        aVar.h("android.intent.action.BOOT_COMPLETED");
        return false;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Long l8 = (Long) c1708z0.j(this.f17042L1);
        if (l8 != null) {
            return r(c1708z0, l8.longValue());
        }
        c1708z0.z(this.f17042L1, Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        q(c1708z0);
        return false;
    }
}
