package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import com.llamalab.automate.AbstractC1553a2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import q.C2230e;

@F3.f("fullscreen.html")
@F3.a(C2541R.integer.ic_full_screen)
@F3.i(C2541R.string.stmt_fullscreen_title)
@F3.h(C2541R.string.stmt_fullscreen_summary)
@F3.e(C2541R.layout.stmt_fullscreen_edit)
/* loaded from: classes.dex */
public final class Fullscreen extends Decision implements AsyncStatement {
    public InterfaceC1700x0 visibility;

    public static final class a extends AbstractC1553a2 implements View.OnSystemUiVisibilityChangeListener, Runnable {

        /* renamed from: P1, reason: collision with root package name */
        public int f16671P1;

        /* renamed from: N1, reason: collision with root package name */
        public final C2230e f16669N1 = new C2230e();

        /* renamed from: O1, reason: collision with root package name */
        public volatile boolean f16670O1 = true;

        /* renamed from: Q1, reason: collision with root package name */
        public int f16672Q1 = -1;

        public a(int i8) {
            this.f16671P1 = i8;
        }

        @Override // com.llamalab.automate.AbstractC1553a2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            this.f16670O1 = false;
            this.f15400Y.f14581L1.removeCallbacks(this);
            super.F(automateService);
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public final void onSystemUiVisibilityChange(int i8) {
            C2230e c2230e = this.f16669N1;
            int[] iArr = (int[]) c2230e.f21630d;
            int i9 = c2230e.f21628b;
            iArr[i9] = i8;
            int i10 = c2230e.f21629c & (i9 + 1);
            c2230e.f21628b = i10;
            int i11 = c2230e.f21627a;
            if (i10 == i11) {
                int length = iArr.length;
                int i12 = length - i11;
                int i13 = length << 1;
                if (i13 < 0) {
                    throw new RuntimeException("Max array capacity exceeded");
                }
                int[] iArr2 = new int[i13];
                System.arraycopy(iArr, i11, iArr2, 0, i12);
                System.arraycopy((int[]) c2230e.f21630d, 0, iArr2, i12, c2230e.f21627a);
                c2230e.f21630d = iArr2;
                c2230e.f21627a = 0;
                c2230e.f21628b = length;
                c2230e.f21629c = i13 - 1;
            }
            x2();
        }

        @Override // com.llamalab.automate.W
        public final void q2(Object obj, boolean z7) {
            this.f16670O1 = false;
            o2(1000L, obj);
        }

        @Override // com.llamalab.automate.W
        public final void r2(Throwable th) {
            this.f16670O1 = false;
            super.r2(th);
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f16670O1 = true;
            x2();
        }

        @Override // com.llamalab.automate.AbstractC1553a2
        public final View v2(AutomateService automateService) {
            View view = new View(automateService);
            view.setOnSystemUiVisibilityChangeListener(this);
            return view;
        }

        public final void x2() {
            while (this.f16670O1) {
                C2230e c2230e = this.f16669N1;
                int i8 = c2230e.f21627a;
                int i9 = c2230e.f21628b;
                if (i8 == i9) {
                    return;
                }
                if (i8 == i9) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                int i10 = ((int[]) c2230e.f21630d)[i8];
                c2230e.f21627a = (i8 + 1) & c2230e.f21629c;
                int i11 = this.f16671P1;
                boolean z7 = (i10 & i11) != 0;
                int i12 = this.f16672Q1;
                if (i12 != -1) {
                    if (z7 == ((i11 & i12) != 0)) {
                        this.f16672Q1 = i10;
                    }
                }
                q2(Boolean.valueOf(z7), false);
                this.f16672Q1 = i10;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15547h} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.SYSTEM_ALERT_WINDOW")};
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.visibility);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.visibility);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.visibility = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_fullscreen_title);
        int m8 = J3.h.m(c1708z0, this.visibility, 7) & 7;
        if (m8 == 0) {
            throw new IllegalArgumentException("visibility");
        }
        a aVar = (a) c1708z0.d(a.class, this);
        if (aVar != null) {
            F5.n.h(aVar);
            aVar.f16671P1 = m8;
            aVar.f15400Y.f14581L1.post(aVar);
            return false;
        }
        a aVar2 = new a(m8);
        c1708z0.w(aVar2);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, AbstractC1553a2.f15480M1, 280, -3);
        layoutParams.gravity = 51;
        layoutParams.alpha = 0.0f;
        layoutParams.softInputMode = 1;
        aVar2.w2(layoutParams);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
