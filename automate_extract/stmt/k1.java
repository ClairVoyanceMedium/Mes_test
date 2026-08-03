package com.llamalab.automate.stmt;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import x3.C2429g;

@Deprecated
/* loaded from: classes.dex */
public final class k1 extends h1 {

    /* renamed from: L1, reason: collision with root package name */
    public final int f17459L1;

    /* renamed from: M1, reason: collision with root package name */
    public final boolean f17460M1 = false;

    /* renamed from: N1, reason: collision with root package name */
    public a f17461N1;

    public class a extends ResultReceiver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i8, Bundle bundle) {
            k1 k1Var = k1.this;
            if (i8 == 0) {
                k1Var.p2(null);
            } else {
                k1Var.r2(new IllegalStateException(C2429g.i(i8)).fillInStackTrace());
            }
        }
    }

    public k1(int i8) {
        this.f17459L1 = i8;
    }

    @Override // com.llamalab.automate.stmt.h1
    public final void w2(N3.a aVar) {
        try {
            this.f17461N1 = new a(this.f15400Y.f14581L1);
            t3.l lVar = new t3.l();
            aVar.a(this.f17459L1, this.f17461N1, this.f17460M1, lVar);
            lVar.c();
        } catch (Throwable th) {
            r2(th);
        }
    }
}
