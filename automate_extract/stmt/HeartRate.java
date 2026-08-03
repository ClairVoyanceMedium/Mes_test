package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("heart_rate.html")
@F3.a(C2541R.integer.ic_action_favorite)
@F3.i(C2541R.string.stmt_heart_rate_title)
@F3.h(C2541R.string.stmt_heart_rate_summary)
@F3.e(C2541R.layout.stmt_heart_rate_edit)
/* loaded from: classes.dex */
public final class HeartRate extends SensorLevelDecision {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 33 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BODY_SENSORS_BACKGROUND")} : 20 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BODY_SENSORS")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_heart_rate_immediate, C2541R.string.caption_heart_rate_change);
        c1596k0.n(this.minLevel, this.maxLevel, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_heart_rate_title);
        IncapableAndroidVersionException.b(20, "heart rate sensor");
        F(c1708z0, 21);
        return false;
    }
}
