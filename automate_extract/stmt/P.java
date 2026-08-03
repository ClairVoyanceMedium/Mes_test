package com.llamalab.automate.stmt;

import android.accessibilityservice.InputMethod;
import com.google.android.gms.internal.play_billing.I2;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1619q;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class P extends C1619q implements Runnable {

    /* renamed from: N1, reason: collision with root package name */
    public final AtomicInteger f17010N1;

    /* renamed from: O1, reason: collision with root package name */
    public volatile AutomateAccessibilityService f17011O1;

    /* renamed from: P1, reason: collision with root package name */
    public final a f17012P1;

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        
            r3 = r3.getCurrentInputConnection();
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            InputMethod.AccessibilityInputConnection currentInputConnection;
            boolean z7 = true;
            try {
                InputMethod inputMethod = P.this.f17011O1.getInputMethod();
                if (inputMethod != null && currentInputConnection != null) {
                    P.this.v2(currentInputConnection);
                    if (P.this.f17010N1.getAndSet(8) != 8) {
                        P.this.q2(Boolean.TRUE, false);
                    }
                }
            } finally {
                try {
                    I2.f(P.this.f17010N1, this);
                } catch (Throwable th) {
                }
            }
            I2.f(P.this.f17010N1, this);
        }
    }

    public P() {
        super(0, 32768);
        this.f17010N1 = new AtomicInteger();
        this.f17012P1 = new a();
    }

    @Override // com.llamalab.automate.C1619q, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        automateService.f14581L1.postDelayed(this, 500L);
    }

    @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
    public final void C0(AutomateAccessibilityService automateAccessibilityService) {
        this.f17011O1 = automateAccessibilityService;
        I2.h(this.f17010N1, this.f17012P1);
    }

    @Override // com.llamalab.automate.C1619q, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        automateService.f14581L1.removeCallbacks(this);
        super.F(automateService);
    }

    @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
    public final void U1(AutomateAccessibilityService automateAccessibilityService) {
        super.U1(automateAccessibilityService);
        this.f17011O1 = automateAccessibilityService;
        I2.h(this.f17010N1, this.f17012P1);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f17010N1.getAndSet(8) != 8) {
            q2(Boolean.FALSE, false);
        }
    }

    public abstract void v2(InputMethod.AccessibilityInputConnection accessibilityInputConnection);
}
