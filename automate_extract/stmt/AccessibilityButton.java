package com.llamalab.automate.stmt;

import android.accessibilityservice.AccessibilityButtonController;
import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1607n;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("accessibility_button.html")
@F3.a(C2541R.integer.ic_assistance)
@F3.i(C2541R.string.stmt_accessibility_button_title)
@F3.h(C2541R.string.stmt_accessibility_button_summary)
@F3.c(C2541R.string.caption_accessibility_button)
@F3.e(C2541R.layout.stmt_accessibility_button_edit)
/* loaded from: classes.dex */
public final class AccessibilityButton extends Action implements AsyncStatement {
    public InterfaceC1700x0 displayId;

    public static final class a extends com.llamalab.automate.W {

        /* renamed from: L1, reason: collision with root package name */
        public final C0166a f16221L1 = new C0166a();

        /* renamed from: y1, reason: collision with root package name */
        public final int f16222y1;

        /* renamed from: com.llamalab.automate.stmt.AccessibilityButton$a$a, reason: collision with other inner class name */
        public class C0166a extends AccessibilityButtonController.AccessibilityButtonCallback {
            public C0166a() {
            }

            @Override // android.accessibilityservice.AccessibilityButtonController.AccessibilityButtonCallback
            public final void onAvailabilityChanged(AccessibilityButtonController accessibilityButtonController, boolean z7) {
            }

            @Override // android.accessibilityservice.AccessibilityButtonController.AccessibilityButtonCallback
            public final void onClicked(AccessibilityButtonController accessibilityButtonController) {
                a.this.p2(null);
            }
        }

        public a(int i8) {
            this.f16222y1 = i8;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            C1607n c1607n = C1607n.f16056d;
            int i8 = Build.VERSION.SDK_INT;
            C0166a c0166a = this.f16221L1;
            if (30 > i8) {
                c1607n.a(0, c0166a, this.f15400Y.f14581L1);
            } else {
                c1607n.a(this.f16222y1, c0166a, this.f15400Y.f14581L1);
            }
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            u2();
            C1607n c1607n = C1607n.f16056d;
            int i8 = Build.VERSION.SDK_INT;
            C0166a c0166a = this.f16221L1;
            if (30 <= i8) {
                c1607n.b(this.f16222y1, c0166a);
            } else {
                c1607n.b(0, c0166a);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 26 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15541b} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (94 <= dVar.f6413Z) {
            dVar.g(this.displayId);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.displayId);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (94 <= cVar.f6409x0) {
            this.displayId = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_accessibility_button_title);
        IncapableAndroidVersionException.a(26);
        c1708z0.w(new a(J3.h.m(c1708z0, this.displayId, 0)));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
