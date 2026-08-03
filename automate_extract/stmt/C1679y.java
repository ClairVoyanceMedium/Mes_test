package com.llamalab.automate.stmt;

import android.os.CancellationSignal;
import com.llamalab.automate.AutomateService;

/* renamed from: com.llamalab.automate.stmt.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1679y extends C1677x {

    /* renamed from: N1, reason: collision with root package name */
    public CancellationSignal f17567N1;

    public C1679y(com.llamalab.safs.n nVar) {
        super(nVar);
    }

    @Override // com.llamalab.automate.stmt.C1677x, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        CancellationSignal cancellationSignal = this.f17567N1;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        super.F(automateService);
    }

    public final CancellationSignal x2() {
        if (this.f17567N1 == null) {
            this.f17567N1 = new CancellationSignal();
        }
        return this.f17567N1;
    }
}
