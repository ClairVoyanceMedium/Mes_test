package com.llamalab.automate.stmt;

import android.telecom.Call;
import com.llamalab.automate.AutomateService;

/* loaded from: classes.dex */
public final class C extends com.llamalab.automate.W implements Runnable {

    /* renamed from: L1, reason: collision with root package name */
    public boolean f16390L1;

    /* renamed from: M1, reason: collision with root package name */
    public final a f16391M1 = new a();

    /* renamed from: y1, reason: collision with root package name */
    public final Call f16392y1;

    public class a extends Call.Callback {
        public a() {
        }

        @Override // android.telecom.Call.Callback
        public final void onCallDestroyed(Call call) {
            C.this.run();
        }
    }

    public C(Call call) {
        this.f16392y1 = call;
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        try {
            this.f16392y1.stopDtmfTone();
        } catch (Throwable unused) {
        }
        u2();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f16390L1) {
            p2(null);
        } else {
            a();
        }
    }
}
