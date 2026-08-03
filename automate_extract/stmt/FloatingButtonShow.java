package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.google.android.material.datepicker.RunnableC1541d;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import f.RunnableC1764A;
import g4.C1827a;
import k0.RunnableC2034k;

@F3.f("floating_button_show.html")
@F3.a(C2541R.integer.ic_buttonbar_right)
@F3.i(C2541R.string.stmt_floating_button_show_title)
@F3.h(C2541R.string.stmt_floating_button_show_summary)
@F3.e(C2541R.layout.stmt_floating_button_show_edit)
/* loaded from: classes.dex */
public final class FloatingButtonShow extends Action implements AsyncStatement {
    public InterfaceC1700x0 color;
    public InterfaceC1700x0 iconUri;

    public static final class a extends com.llamalab.automate.W implements C0.a {

        /* renamed from: L1, reason: collision with root package name */
        public Uri f16644L1;

        /* renamed from: M1, reason: collision with root package name */
        public int f16645M1;

        /* renamed from: N1, reason: collision with root package name */
        public long f16646N1;

        /* renamed from: y1, reason: collision with root package name */
        public final Object f16647y1 = new Object();

        public a(Uri uri, int i8) {
            this.f16644L1 = uri;
            this.f16645M1 = i8;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            com.llamalab.automate.C0 w8 = automateService.w();
            Uri uri = this.f16644L1;
            int i8 = this.f16645M1;
            long incrementAndGet = w8.f14725a.incrementAndGet();
            w8.b(new RunnableC1764A(w8, 13, new C0.b(incrementAndGet, uri, w8.a(i8 | (-16777216)), true, this)));
            this.f16646N1 = incrementAndGet;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            com.llamalab.automate.C0 w8 = automateService.w();
            long j8 = this.f16646N1;
            w8.getClass();
            w8.b(new RunnableC1541d(1, j8, w8));
            u2();
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15547h} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.iconUri);
        dVar.g(this.color);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.iconUri);
        visitor.b(this.color);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.iconUri = (InterfaceC1700x0) cVar.readObject();
        this.color = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_floating_button_show_title);
        Uri g8 = J3.h.g(c1708z0, this.iconUri, C1827a.h.a(c1708z0.getResources().getInteger(C2541R.integer.ic_quick_settings)).build());
        int m8 = J3.h.m(c1708z0, this.color, D.c.b(c1708z0, C2541R.color.primary_light));
        a aVar = (a) c1708z0.c(a.class);
        if (aVar == null) {
            c1708z0.w(new a(g8, m8));
            return false;
        }
        F5.n.h(aVar);
        aVar.f15404y0 = this.f16218X;
        synchronized (aVar.f16647y1) {
            aVar.f16644L1 = g8;
            aVar.f16645M1 = m8;
            com.llamalab.automate.C0 w8 = aVar.f15400Y.w();
            w8.b(new RunnableC2034k(w8, 14, new C0.b(aVar.f16646N1, g8, w8.a(m8 | (-16777216)), true, aVar)));
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
