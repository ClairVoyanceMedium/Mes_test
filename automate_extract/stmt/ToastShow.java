package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.concurrent.atomic.AtomicInteger;

@F3.f("toast_show.html")
@F3.a(C2541R.integer.ic_toast_show)
@F3.i(C2541R.string.stmt_toast_show_title)
@F3.h(C2541R.string.stmt_toast_show_summary)
@F3.e(C2541R.layout.stmt_toast_show_edit)
/* loaded from: classes.dex */
public final class ToastShow extends IntermittentAction implements AsyncStatement {
    public InterfaceC1700x0 duration;
    public InterfaceC1700x0 message;

    public static final class a extends com.llamalab.automate.W implements Runnable {

        /* renamed from: L1, reason: collision with root package name */
        public final AtomicInteger f17206L1;

        /* renamed from: M1, reason: collision with root package name */
        public final C0182a f17207M1 = new C0182a();

        /* renamed from: y1, reason: collision with root package name */
        public final Toast f17208y1;

        /* renamed from: com.llamalab.automate.stmt.ToastShow$a$a, reason: collision with other inner class name */
        public class C0182a extends Toast.Callback {
            public C0182a() {
            }

            @Override // android.widget.Toast.Callback
            public final void onToastHidden() {
                if (a.this.f17206L1.compareAndSet(2, 0)) {
                    a.this.p2(null);
                }
            }

            @Override // android.widget.Toast.Callback
            public final void onToastShown() {
                if (a.this.f17206L1.compareAndSet(1, 0)) {
                    a.this.p2(null);
                }
            }
        }

        public a(Toast toast, int i8) {
            this.f17208y1 = toast;
            this.f17206L1 = new AtomicInteger(i8);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            this.f17208y1.addCallback(this.f17207M1);
            automateService.Z(this);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            boolean z7 = this.f17206L1.getAndSet(0) != 0;
            automateService.f14581L1.removeCallbacks(this);
            if (z7) {
                try {
                    this.f17208y1.cancel();
                } catch (Throwable unused) {
                }
            }
            u2();
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f17208y1.show();
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 0, C2541R.string.caption_toast_show_immediate, C2541R.string.caption_toast_show_shown, C2541R.string.caption_toast_show_hidden);
        c1596k0.v(this.message, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        r(dVar, 99);
        dVar.g(this.message);
        if (46 <= dVar.f6413Z) {
            dVar.g(this.duration);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.message);
        visitor.b(this.duration);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        q(cVar, 99);
        this.message = (InterfaceC1700x0) cVar.readObject();
        if (46 <= cVar.f6409x0) {
            this.duration = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_toast_show_title);
        String x7 = J3.h.x(c1708z0, this.message, null);
        if (x7 != null) {
            Toast makeText = Toast.makeText(c1708z0.j2(), x7, J3.h.t(c1708z0, this.duration, x7.length() < 30 ? 2000L : 3500L) <= 2000 ? 0 : 1);
            int J12 = J1(0);
            if (J12 != 0) {
                if (J12 != 1 && J12 != 2) {
                    throw new IllegalStateException();
                }
                if (30 > Build.VERSION.SDK_INT) {
                    throw new IncapableAndroidVersionException(30, "proceed when shown or hidden");
                }
                c1708z0.w(new a(makeText, this.continuity.intValue()));
                return false;
            }
            AutomateService j22 = c1708z0.j2();
            makeText.getClass();
            j22.Z(new androidx.activity.b(22, makeText));
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
