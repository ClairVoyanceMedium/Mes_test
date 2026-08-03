package com.llamalab.automate.stmt;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("car_mode_set_state.html")
@F3.a(C2541R.integer.ic_milage)
@F3.i(C2541R.string.stmt_car_mode_set_state_title)
@F3.h(C2541R.string.stmt_car_mode_set_state_summary)
@F3.e(C2541R.layout.stmt_car_mode_set_state_edit)
/* loaded from: classes.dex */
public final class CarModeSetState extends SetStateAction {
    public InterfaceC1700x0 goHome;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_car_mode_enable, C2541R.string.caption_car_mode_disable).r(C2541R.string.caption_car_mode_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.goHome);
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.goHome);
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.goHome = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_car_mode_set_state_title);
        UiModeManager uiModeManager = (UiModeManager) c1708z0.getSystemService("uimode");
        boolean f8 = J3.h.f(c1708z0, this.goHome, false);
        int m8 = J3.h.m(c1708z0, this.state, 0);
        int i8 = f8;
        if (m8 != 1) {
            if (m8 != 2) {
                uiModeManager.disableCarMode(f8 ? 1 : 0);
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
            i8 = f8;
            if (21 <= Build.VERSION.SDK_INT) {
                i8 = (f8 ? 1 : 0) | 2;
            }
        }
        uiModeManager.enableCarMode(i8);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
