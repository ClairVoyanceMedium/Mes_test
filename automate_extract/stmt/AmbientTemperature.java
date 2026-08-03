package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("ambient_temperature.html")
@F3.a(C2541R.integer.ic_thermometer)
@F3.i(C2541R.string.stmt_ambient_temperature_title)
@F3.h(C2541R.string.stmt_ambient_temperature_summary)
@F3.e(C2541R.layout.stmt_ambient_temperature_edit)
/* loaded from: classes.dex */
public class AmbientTemperature extends SensorLevelDecision {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_ambient_temperature_immediate, C2541R.string.caption_ambient_temperature_change);
        c1596k0.n(this.minLevel, this.maxLevel, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_ambient_temperature_title);
        F(c1708z0, 13);
        return false;
    }
}
