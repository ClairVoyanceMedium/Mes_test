package com.llamalab.automate.stmt;

import android.view.inputmethod.InputConnection;
import com.llamalab.automate.AutomateInputMethodService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.InterfaceC1624r1;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class Q extends com.llamalab.automate.W implements Runnable, InterfaceC1624r1 {

    /* renamed from: y1, reason: collision with root package name */
    public final AtomicBoolean f17051y1 = new AtomicBoolean();

    @Override // com.llamalab.automate.InterfaceC1624r1
    public final void A0(AutomateInputMethodService automateInputMethodService) {
        AtomicBoolean atomicBoolean = this.f17051y1;
        try {
            InputConnection currentInputConnection = automateInputMethodService.getCurrentInputConnection();
            boolean z7 = currentInputConnection != null && v2(currentInputConnection);
            if (atomicBoolean.compareAndSet(false, true)) {
                q2(Boolean.valueOf(z7), false);
            }
        } catch (Throwable th) {
            if (atomicBoolean.compareAndSet(false, true)) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        AutomateInputMethodService automateInputMethodService;
        super.C(automateService, j8, j9, j10);
        if (AutomateInputMethodService.f14551X.add(this) && (automateInputMethodService = AutomateInputMethodService.f14552Y.get()) != null) {
            A0(automateInputMethodService);
        }
        automateService.f14581L1.postDelayed(this, 500L);
    }

    @Override // com.llamalab.automate.InterfaceC1624r1
    public final /* bridge */ /* synthetic */ void E1() {
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        automateService.f14581L1.removeCallbacks(this);
        if (AutomateInputMethodService.f14551X.remove(this)) {
            AutomateInputMethodService.f14552Y.get();
        }
        u2();
    }

    @Override // com.llamalab.automate.InterfaceC1624r1
    public final /* bridge */ /* synthetic */ void f() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f17051y1.compareAndSet(false, true)) {
            q2(Boolean.FALSE, false);
        }
    }

    @Override // com.llamalab.automate.InterfaceC1624r1
    public final /* bridge */ /* synthetic */ void v0() {
    }

    public abstract boolean v2(InputConnection inputConnection);
}
