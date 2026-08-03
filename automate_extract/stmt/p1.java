package com.llamalab.automate.stmt;

import android.media.ToneGenerator;
import com.llamalab.automate.AutomateService;

/* loaded from: classes.dex */
public final class p1 extends com.llamalab.automate.W implements Runnable {

    /* renamed from: L1, reason: collision with root package name */
    public boolean f17495L1;

    /* renamed from: y1, reason: collision with root package name */
    public ToneGenerator f17496y1;

    public p1(int i8, int i9) {
        this.f17496y1 = new ToneGenerator(i8, i9);
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        ToneGenerator toneGenerator = this.f17496y1;
        if (toneGenerator != null) {
            try {
                toneGenerator.release();
            } catch (Throwable unused) {
            }
            this.f17496y1 = null;
        }
        u2();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f17495L1) {
            p2(null);
        } else {
            a();
        }
    }
}
