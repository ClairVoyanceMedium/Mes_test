package com.llamalab.automate.stmt;

import android.media.RemoteController;
import android.os.SystemClock;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.R1;
import x3.C2437o;

/* renamed from: com.llamalab.automate.stmt.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC1643f0 extends R1 implements RemoteController.OnClientUpdateListener, Runnable {

    /* renamed from: L1, reason: collision with root package name */
    public C2437o f17402L1;

    /* renamed from: M1, reason: collision with root package name */
    public RemoteController.MetadataEditor f17403M1;

    /* renamed from: N1, reason: collision with root package name */
    public C2437o f17404N1;

    /* renamed from: O1, reason: collision with root package name */
    public long f17405O1 = Long.MAX_VALUE;

    /* renamed from: P1, reason: collision with root package name */
    public long f17406P1;

    /* renamed from: y1, reason: collision with root package name */
    public final boolean f17407y1;

    public RunnableC1643f0(boolean z7) {
        this.f17407y1 = z7;
    }

    @Override // com.llamalab.automate.R1, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        this.f17405O1 = SystemClock.elapsedRealtime() + 150;
        if (this.f17407y1) {
            automateService.f14581L1.postDelayed(this, 150L);
        }
    }

    @Override // com.llamalab.automate.R1, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        if (this.f17407y1) {
            automateService.f14581L1.removeCallbacks(this);
        }
        super.F(automateService);
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public final void onClientChange(boolean z7) {
        this.f17402L1 = null;
        this.f17403M1 = null;
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public final void onClientMetadataUpdate(RemoteController.MetadataEditor metadataEditor) {
        this.f17403M1 = metadataEditor;
        if (this.f17402L1 != null) {
            v2();
        }
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public final void onClientPlaybackStateUpdate(int i8) {
        this.f17402L1 = new C2437o(i8, SystemClock.elapsedRealtime(), -1L, 1.0f, null);
        if (this.f17403M1 != null) {
            v2();
        }
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public final void onClientTransportControlUpdate(int i8) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        q2(new Object[]{C2437o.c(null), null}, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r0.b(r7.f17404N1) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void v2() {
        if (!this.f17407y1) {
            if (this.f17405O1 < SystemClock.elapsedRealtime()) {
                long j8 = this.f17406P1;
                C2437o c2437o = this.f17402L1;
                if (j8 - c2437o.f23412b < 150) {
                    if (c2437o.f23411a != 1) {
                    }
                }
            }
            this.f17404N1 = this.f17402L1;
        }
        q2(new Object[]{this.f17402L1, this.f17403M1}, false);
        this.f17404N1 = this.f17402L1;
    }

    @Override // android.media.RemoteController.OnClientUpdateListener
    public final void onClientPlaybackStateUpdate(int i8, long j8, long j9, float f8) {
        this.f17406P1 = SystemClock.elapsedRealtime();
        this.f17402L1 = new C2437o(i8, j8, j9, f8 == 0.0f ? 1.0f : f8, null);
        if (this.f17403M1 != null) {
            v2();
        }
    }
}
