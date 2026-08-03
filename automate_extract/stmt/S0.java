package com.llamalab.automate.stmt;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.InterfaceC1585h1;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class S0 extends AbstractC1602l2 {

    /* renamed from: M1, reason: collision with root package name */
    public final AtomicBoolean f17078M1 = new AtomicBoolean();

    /* renamed from: N1, reason: collision with root package name */
    public final com.llamalab.safs.n f17079N1;

    /* renamed from: O1, reason: collision with root package name */
    public a f17080O1;

    /* renamed from: P1, reason: collision with root package name */
    public T0 f17081P1;

    public class a extends ResultReceiver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i8, Bundle bundle) {
            bundle.setClassLoader(a.class.getClassLoader());
            S0 s02 = S0.this;
            s02.getClass();
            try {
                if (s02.f17078M1.get()) {
                    return;
                }
                t3.l lVar = (t3.l) bundle.getParcelable("throwable");
                if (lVar != null) {
                    lVar.c();
                    return;
                }
                Bitmap bitmap = (Bitmap) bundle.getParcelable("bitmap");
                if (bitmap == null) {
                    throw new IllegalStateException("screencap failed: " + i8);
                }
                if (s02.f17081P1 != null) {
                    return;
                }
                T0 t02 = new T0(s02, bitmap);
                s02.f17081P1 = t02;
                t02.start();
            } catch (Throwable th) {
                s02.r2(th);
            }
        }
    }

    public S0(com.llamalab.safs.n nVar) {
        this.f17079N1 = nVar;
    }

    @Override // com.llamalab.automate.AbstractC1602l2, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        n2(1);
    }

    @Override // com.llamalab.automate.AbstractC1602l2, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        this.f17078M1.set(true);
        T0 t02 = this.f17081P1;
        if (t02 != null) {
            t02.interrupt();
            this.f17081P1 = null;
        }
        super.F(automateService);
    }

    @Override // com.llamalab.automate.AbstractC1602l2
    public final void w2(InterfaceC1585h1 interfaceC1585h1) {
        try {
            if (this.f17080O1 != null) {
                return;
            }
            a aVar = new a(this.f15400Y.f14581L1);
            this.f17080O1 = aVar;
            interfaceC1585h1.D(aVar);
        } catch (Throwable th) {
            r2(th);
        }
    }
}
