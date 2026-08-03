package com.llamalab.automate.stmt;

import android.os.Vibrator;
import com.llamalab.automate.AutomateService;

/* loaded from: classes.dex */
public final class s1 extends com.llamalab.automate.W {

    /* renamed from: y1, reason: collision with root package name */
    public final Vibrator f17522y1;

    public s1(Vibrator vibrator) {
        this.f17522y1 = vibrator;
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        try {
            this.f17522y1.cancel();
        } catch (Throwable unused) {
        }
        u2();
    }
}
