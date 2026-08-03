package com.llamalab.automate.stmt;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.llamalab.automate.J1;
import x3.C2429g;

/* loaded from: classes.dex */
public final class i1 extends J1 {

    /* renamed from: L1, reason: collision with root package name */
    public final int f17434L1;

    /* renamed from: M1, reason: collision with root package name */
    public final boolean f17435M1 = false;

    /* renamed from: N1, reason: collision with root package name */
    public a f17436N1;

    public class a extends ResultReceiver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i8, Bundle bundle) {
            i1 i1Var = i1.this;
            if (i8 == 0) {
                i1Var.p2(null);
            } else {
                i1Var.r2(new IllegalStateException(C2429g.i(i8)).fillInStackTrace());
            }
        }
    }

    public i1(int i8) {
        this.f17434L1 = i8;
    }

    @Override // com.llamalab.automate.J1
    public final void w2(O3.a aVar) {
        try {
            this.f17436N1 = new a(this.f15400Y.f14581L1);
            t3.l lVar = new t3.l();
            aVar.a(this.f17434L1, this.f17436N1, this.f17435M1, lVar);
            lVar.c();
        } catch (Throwable th) {
            r2(th);
        }
    }
}
