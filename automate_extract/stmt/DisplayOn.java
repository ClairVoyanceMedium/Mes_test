package com.llamalab.automate.stmt;

import P.C1091g;
import android.content.Context;
import android.view.Display;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("display_on.html")
@F3.a(C2541R.integer.ic_screen_power_on)
@F3.i(C2541R.string.stmt_display_on_title)
@F3.h(C2541R.string.stmt_display_on_summary)
@F3.e(C2541R.layout.stmt_display_on_edit)
/* loaded from: classes.dex */
public final class DisplayOn extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 displayId;

    public static final class a extends B {

        /* renamed from: L1, reason: collision with root package name */
        public final int f16591L1;

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f16592M1;

        public a(int i8, boolean z7) {
            this.f16591L1 = i8;
            this.f16592M1 = z7;
        }

        @Override // com.llamalab.automate.stmt.B, android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i8) {
            Display display;
            if (this.f16591L1 == i8) {
                boolean z7 = this.f16592M1;
                display = this.f16311y1.getDisplay(i8);
                if (z7 != DisplayOn.B(display)) {
                    q2(Boolean.valueOf(!this.f16592M1), false);
                }
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int i8) {
            Display display;
            if (this.f16591L1 == i8) {
                boolean z7 = this.f16592M1;
                display = this.f16311y1.getDisplay(i8);
                if (z7 != DisplayOn.B(display)) {
                    q2(Boolean.valueOf(!this.f16592M1), false);
                }
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i8) {
            if (this.f16591L1 == i8 && this.f16592M1) {
                q2(Boolean.FALSE, false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0004, code lost:
    
        r2 = r2.getState();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean B(Display display) {
        int state;
        return (display == null || state == 0 || state == 1) ? false : true;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_display_on_immediate, C2541R.string.caption_display_on_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (89 <= dVar.f6413Z) {
            dVar.g(this.displayId);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.displayId);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (89 <= cVar.f6409x0) {
            this.displayId = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Display display;
        c1708z0.q(C2541R.string.stmt_display_on_title);
        IncapableAndroidVersionException.a(20);
        int m8 = J3.h.m(c1708z0, this.displayId, 0);
        display = C1091g.e(c1708z0.getSystemService("display")).getDisplay(m8);
        boolean B7 = B(display);
        if (J1(1) == 0) {
            o(c1708z0, B7);
            return true;
        }
        c1708z0.w(new a(m8, B7));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
