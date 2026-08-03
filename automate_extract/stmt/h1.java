package com.llamalab.automate.stmt;

import N3.a;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import com.llamalab.automate.AbstractServiceConnectionC1580g0;
import com.llamalab.automate.AutomateService;

@Deprecated
/* loaded from: classes.dex */
public abstract class h1 extends AbstractServiceConnectionC1580g0 {
    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        v2(new Intent("com.llamalab.automate.ext.TetheringService").setPackage("com.llamalab.automate.ext.tethering"), 3000L);
    }

    @Override // com.llamalab.automate.AbstractServiceConnectionC1580g0, android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        N3.a c0037a;
        super.onServiceConnected(componentName, iBinder);
        int i8 = a.AbstractBinderC0036a.f5544X;
        if (iBinder == null) {
            c0037a = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.llamalab.automate.ext.ITetheringService");
            c0037a = (queryLocalInterface == null || !(queryLocalInterface instanceof N3.a)) ? new a.AbstractBinderC0036a.C0037a(iBinder) : (N3.a) queryLocalInterface;
        }
        w2(c0037a);
    }

    public abstract void w2(N3.a aVar);
}
