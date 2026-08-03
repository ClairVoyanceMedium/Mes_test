package com.llamalab.automate.stmt;

import android.content.Intent;
import android.os.Bundle;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.AutomateVoiceInteractionService;
import com.llamalab.automate.U2;
import com.llamalab.automate.V2;
import com.llamalab.automate.W2;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.llamalab.automate.stmt.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1638d extends com.llamalab.automate.W implements U2, W2 {

    /* renamed from: L1, reason: collision with root package name */
    public final AtomicBoolean f17367L1 = new AtomicBoolean();

    /* renamed from: M1, reason: collision with root package name */
    public V2 f17368M1;

    /* renamed from: y1, reason: collision with root package name */
    public final Intent f17369y1;

    /* renamed from: com.llamalab.automate.stmt.d$a */
    public static final class a extends AbstractC1638d {
        public a(Intent intent) {
            super(intent);
        }

        @Override // com.llamalab.automate.stmt.AbstractC1638d, com.llamalab.automate.W2
        public final void r(int i8) {
            p2(null);
        }
    }

    /* renamed from: com.llamalab.automate.stmt.d$b */
    public static final class b extends AbstractC1638d {
        public b(Intent intent) {
            super(intent);
        }

        @Override // com.llamalab.automate.stmt.AbstractC1638d, com.llamalab.automate.W2
        public final void m(int i8) {
            p2(null);
        }
    }

    public AbstractC1638d(Intent intent) {
        this.f17369y1 = intent;
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        AutomateVoiceInteractionService automateVoiceInteractionService;
        super.C(automateService, j8, j9, j10);
        this.f17368M1 = new V2(this, automateService.f14581L1);
        if (!AutomateVoiceInteractionService.f14646y1.add(this) || (automateVoiceInteractionService = AutomateVoiceInteractionService.f14645L1.get()) == null) {
            return;
        }
        d1(automateVoiceInteractionService);
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        if (AutomateVoiceInteractionService.f14646y1.remove(this)) {
            AutomateVoiceInteractionService.f14645L1.get();
        }
        this.f17368M1 = null;
        u2();
    }

    @Override // com.llamalab.automate.U2
    public final /* synthetic */ void X0(Throwable th) {
    }

    @Override // com.llamalab.automate.U2
    public final /* synthetic */ void Y() {
    }

    @Override // com.llamalab.automate.U2
    public final void b0(AutomateVoiceInteractionService automateVoiceInteractionService) {
    }

    @Override // com.llamalab.automate.U2
    public final void d1(AutomateVoiceInteractionService automateVoiceInteractionService) {
        if (this.f17367L1.compareAndSet(false, true)) {
            try {
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.llamalab.automate.arg.VOICE_CALLBACK", this.f17368M1);
                bundle.putParcelable("com.llamalab.automate.arg.VOICE_INTENT", this.f17369y1);
                automateVoiceInteractionService.showSession(bundle, 8);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.W2
    public /* synthetic */ void m(int i8) {
    }

    @Override // com.llamalab.automate.W2
    public /* synthetic */ void r(int i8) {
    }
}
