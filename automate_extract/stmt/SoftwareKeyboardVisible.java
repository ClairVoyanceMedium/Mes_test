package com.llamalab.automate.stmt;

import android.content.Context;
import android.graphics.Insets;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1553a2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("software_keyboard_visible.html")
@F3.a(C2541R.integer.ic_hardware_keyboard)
@F3.i(C2541R.string.stmt_software_keyboard_visible_title)
@F3.h(C2541R.string.stmt_software_keyboard_visible_summary)
@F3.e(C2541R.layout.stmt_software_keyboard_visible_edit)
/* loaded from: classes.dex */
public final class SoftwareKeyboardVisible extends IntermittentDecision implements AsyncStatement {

    public static final class a extends AbstractC1553a2 implements View.OnApplyWindowInsetsListener {

        /* renamed from: N1, reason: collision with root package name */
        public boolean f17134N1;

        @Override // com.llamalab.automate.AbstractC1553a2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            this.f17134N1 = SoftwareKeyboardVisible.B(this.f15482y1);
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            WindowInsets windowInsets2;
            boolean B7 = SoftwareKeyboardVisible.B(this.f15482y1);
            boolean z7 = this.f17134N1;
            if (B7 != z7) {
                boolean z8 = !z7;
                this.f17134N1 = z8;
                q2(Boolean.valueOf(z8), false);
            }
            windowInsets2 = WindowInsets.CONSUMED;
            return windowInsets2;
        }

        @Override // com.llamalab.automate.AbstractC1553a2
        public final View v2(AutomateService automateService) {
            View view = new View(automateService);
            view.setFitsSystemWindows(false);
            view.setOnApplyWindowInsetsListener(this);
            return view;
        }
    }

    public static boolean B(WindowManager windowManager) {
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        int ime;
        Insets insets;
        int i8;
        int i9;
        int i10;
        int i11;
        currentWindowMetrics = windowManager.getCurrentWindowMetrics();
        windowInsets = currentWindowMetrics.getWindowInsets();
        ime = WindowInsets.Type.ime();
        insets = windowInsets.getInsets(ime);
        i8 = insets.left;
        i9 = insets.top;
        int i12 = i8 | i9;
        i10 = insets.right;
        i11 = insets.bottom;
        return (i11 | (i12 | i10)) != 0;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 30 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15547h} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_software_keyboard_visible_immediate, C2541R.string.caption_software_keyboard_visible_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int ime;
        c1708z0.q(C2541R.string.stmt_software_keyboard_visible_title);
        IncapableAndroidVersionException.b(30, "img window-inset");
        if (J1(1) == 0) {
            o(c1708z0, B((WindowManager) c1708z0.getSystemService("window")));
            return true;
        }
        a aVar = new a();
        c1708z0.w(aVar);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, AbstractC1553a2.f15480M1, 131096, -1);
        layoutParams.gravity = 51;
        layoutParams.softInputMode = 1;
        ime = WindowInsets.Type.ime();
        layoutParams.setFitInsetsTypes(ime);
        aVar.w2(layoutParams);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
