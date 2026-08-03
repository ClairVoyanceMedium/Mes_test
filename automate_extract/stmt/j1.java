package com.llamalab.automate.stmt;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.InterfaceC1585h1;
import x3.C2429g;

/* loaded from: classes.dex */
public final class j1 extends AbstractC1602l2 {

    /* renamed from: M1, reason: collision with root package name */
    public final int f17440M1;

    /* renamed from: N1, reason: collision with root package name */
    public final boolean f17441N1 = false;

    /* renamed from: O1, reason: collision with root package name */
    public a f17442O1;

    public class a extends ResultReceiver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i8, Bundle bundle) {
            j1 j1Var = j1.this;
            if (i8 == 0) {
                j1Var.p2(null);
            } else {
                j1Var.r2(new IllegalStateException(C2429g.i(i8)).fillInStackTrace());
            }
        }
    }

    public j1(int i8) {
        this.f17440M1 = i8;
    }

    @Override // com.llamalab.automate.AbstractC1602l2
    public final void w2(InterfaceC1585h1 interfaceC1585h1) {
        try {
            this.f17442O1 = new a(this.f15400Y.f14581L1);
            t3.l lVar = new t3.l();
            interfaceC1585h1.a(this.f17440M1, this.f17442O1, this.f17441N1, lVar);
            lVar.c();
        } catch (Throwable th) {
            r2(th);
        }
    }
}
