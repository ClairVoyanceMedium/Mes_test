package com.llamalab.automate.stmt;

import android.app.KeyguardManager;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("device_secure.html")
@F3.a(C2541R.integer.ic_device_access_secure)
@F3.i(C2541R.string.stmt_device_secure_title)
@F3.h(C2541R.string.stmt_device_secure_summary)
@F3.e(C2541R.layout.stmt_device_secure_edit)
/* loaded from: classes.dex */
public final class DeviceSecure extends Decision {
    public InterfaceC1700x0 ignoreSimLock;

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.ignoreSimLock);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.ignoreSimLock);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.ignoreSimLock = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        boolean isKeyguardSecure;
        c1708z0.q(C2541R.string.stmt_device_secure_title);
        IncapableAndroidVersionException.a(16);
        boolean f8 = J3.h.f(c1708z0, this.ignoreSimLock, false);
        KeyguardManager keyguardManager = (KeyguardManager) c1708z0.getSystemService("keyguard");
        if (f8) {
            IncapableAndroidVersionException.b(23, "Ignore SIM lock");
            isKeyguardSecure = keyguardManager.isDeviceSecure();
        } else {
            isKeyguardSecure = keyguardManager.isKeyguardSecure();
        }
        o(c1708z0, isKeyguardSecure);
        return true;
    }
}
