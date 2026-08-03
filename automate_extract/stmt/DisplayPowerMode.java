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

@F3.f("display_power_mode.html")
@F3.a(C2541R.integer.ic_screen_power_on)
@F3.i(C2541R.string.stmt_display_power_mode_title)
@F3.h(C2541R.string.stmt_display_power_mode_summary)
@F3.e(C2541R.layout.stmt_display_power_mode_edit)
/* loaded from: classes.dex */
public final class DisplayPowerMode extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 displayId;
    public InterfaceC1700x0 modes;
    public J3.l varCurrentMode;

    public static final class a extends B {

        /* renamed from: L1, reason: collision with root package name */
        public final int f16593L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16594M1;

        /* renamed from: N1, reason: collision with root package name */
        public boolean f16595N1;

        public a(int i8, boolean z7, int i9) {
            this.f16593L1 = i8;
            this.f16594M1 = i9;
            this.f16595N1 = z7;
        }

        @Override // com.llamalab.automate.stmt.B, android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i8) {
            Display display;
            int i9 = this.f16593L1;
            if (i9 < 0 || i9 == i8) {
                display = this.f16311y1.getDisplay(i8);
                v2(DisplayPowerMode.B(display));
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int i8) {
            Display display;
            int i9 = this.f16593L1;
            if (i9 < 0 || i9 == i8) {
                display = this.f16311y1.getDisplay(i8);
                v2(DisplayPowerMode.B(display));
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i8) {
            int i9 = this.f16593L1;
            if (i9 < 0 || i9 == i8) {
                v2(0);
            }
        }

        public final void v2(int i8) {
            int i9 = this.f16594M1;
            if (i9 <= 0) {
                this.f16595N1 = true;
            } else {
                boolean z7 = this.f16595N1;
                if (z7 == ((i9 & i8) != 0)) {
                    return;
                } else {
                    this.f16595N1 = !z7;
                }
            }
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.f16595N1);
            objArr[1] = i8 != 0 ? Double.valueOf(i8) : null;
            q2(objArr, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r1 = r1.getState();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int B(Display display) {
        int state;
        if (display == null || state <= 0) {
            return 0;
        }
        return 1 << state;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_display_power_mode_immediate, C2541R.string.caption_display_power_mode_change);
        c1596k0.h(this.modes, null, C2541R.xml.display_power_modes);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.displayId);
        dVar.g(this.modes);
        dVar.g(this.varCurrentMode);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.displayId);
        visitor.b(this.modes);
        visitor.b(this.varCurrentMode);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.displayId = (InterfaceC1700x0) cVar.readObject();
        this.modes = (InterfaceC1700x0) cVar.readObject();
        this.varCurrentMode = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Display display;
        c1708z0.q(C2541R.string.stmt_display_power_mode_title);
        IncapableAndroidVersionException.a(21);
        int m8 = J3.h.m(c1708z0, this.displayId, 0);
        int m9 = J3.h.m(c1708z0, this.modes, 0);
        display = C1091g.e(c1708z0.getSystemService("display")).getDisplay(m8);
        int B7 = B(display);
        boolean z7 = m9 <= 0 || (B7 & m9) != 0;
        if (J1(1) != 0) {
            c1708z0.w(new a(m8, z7, m9));
            return false;
        }
        Double valueOf = B7 != 0 ? Double.valueOf(B7) : null;
        J3.l lVar = this.varCurrentMode;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, valueOf);
        }
        o(c1708z0, z7);
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        Double d8 = (Double) objArr[1];
        J3.l lVar = this.varCurrentMode;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, booleanValue);
        return true;
    }
}
