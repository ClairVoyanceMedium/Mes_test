package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1619q;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.Z2;
import java.util.Iterator;
import java.util.List;

@F3.f("split_screen_mode_enabled.html")
@F3.a(C2541R.integer.ic_splitscreen)
@F3.i(C2541R.string.stmt_split_screen_mode_enabled_title)
@F3.h(C2541R.string.stmt_split_screen_mode_enabled_summary)
@F3.e(C2541R.layout.stmt_split_screen_mode_enabled_edit)
/* loaded from: classes.dex */
public final class SplitScreenModeEnabled extends IntermittentDecision implements AsyncStatement {

    public static final class a extends C1619q {
        public a() {
            super(0, 64);
        }

        @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
        public final void U1(AutomateAccessibilityService automateAccessibilityService) {
            super.U1(automateAccessibilityService);
            q2(Boolean.valueOf(SplitScreenModeEnabled.B(automateAccessibilityService.getWindows())), false);
        }
    }

    public static final class b extends C1619q {

        /* renamed from: N1, reason: collision with root package name */
        public boolean f17163N1;

        public b() {
            super(4194304, 64);
        }

        @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
        public final void R0(AutomateAccessibilityService automateAccessibilityService, AccessibilityEvent accessibilityEvent) {
            int windowChanges;
            if (4194304 == accessibilityEvent.getEventType()) {
                if (28 <= Build.VERSION.SDK_INT) {
                    windowChanges = accessibilityEvent.getWindowChanges();
                    if ((windowChanges & 3) == 0) {
                        return;
                    }
                }
                if (this.f17163N1 != SplitScreenModeEnabled.B(automateAccessibilityService.getWindows())) {
                    q2(Boolean.valueOf(!this.f17163N1), false);
                }
            }
        }

        @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
        public final void U1(AutomateAccessibilityService automateAccessibilityService) {
            super.U1(automateAccessibilityService);
            this.f17163N1 = SplitScreenModeEnabled.B(automateAccessibilityService.getWindows());
        }
    }

    public static boolean B(List list) {
        int type;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            type = Z2.p(it.next()).getType();
            if (5 == type) {
                return true;
            }
        }
        return false;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15540a};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_split_screen_mode_enabled_immediate, C2541R.string.caption_split_screen_mode_enabled_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_split_screen_mode_enabled_title);
        IncapableAndroidVersionException.b(24, "split-screen mode");
        c1708z0.w(J1(1) == 0 ? new a() : new b());
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
