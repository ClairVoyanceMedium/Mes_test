package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.stmt.SensorLevelDecision;

@F3.f("magnetic_field_strength.html")
@F3.a(C2541R.integer.ic_magnet)
@F3.i(C2541R.string.stmt_magnetic_field_strength_title)
@F3.h(C2541R.string.stmt_magnetic_field_strength_summary)
@F3.e(C2541R.layout.stmt_magnetic_field_strength_edit)
/* loaded from: classes.dex */
public class MagneticFieldStrength extends SensorLevelDecision {
    @Override // com.llamalab.automate.stmt.SensorLevelDecision
    public final SensorLevelDecision.a G(boolean z7, Double d8, Double d9) {
        return new SensorLevelDecision.a.C0178a(d8, d9, z7);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_magnetic_field_strength_immediate, C2541R.string.caption_magnetic_field_strength_change);
        c1596k0.n(this.minLevel, this.maxLevel, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_magnetic_field_strength_title);
        F(c1708z0, 2);
        return false;
    }
}
