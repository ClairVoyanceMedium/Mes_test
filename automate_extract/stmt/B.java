package com.llamalab.automate.stmt;

import P.C1091g;
import android.hardware.display.DisplayManager;
import com.llamalab.automate.AutomateService;

/* loaded from: classes.dex */
public abstract class B extends com.llamalab.automate.W implements DisplayManager.DisplayListener {

    /* renamed from: y1, reason: collision with root package name */
    public DisplayManager f16311y1;

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        DisplayManager e8 = C1091g.e(automateService.getSystemService("display"));
        this.f16311y1 = e8;
        e8.registerDisplayListener(this, automateService.f14581L1);
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        DisplayManager displayManager = this.f16311y1;
        if (displayManager != null) {
            try {
                displayManager.unregisterDisplayListener(this);
            } catch (Throwable unused) {
            }
        }
        u2();
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int i8) {
    }
}
