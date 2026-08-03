package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;

@F3.f("night_mode_enabled.html")
@F3.a(C2541R.integer.ic_moon)
@F3.i(C2541R.string.stmt_night_mode_enabled_title)
@F3.h(C2541R.string.stmt_night_mode_enabled_summary)
@F3.e(C2541R.layout.stmt_night_mode_enabled_edit)
/* loaded from: classes.dex */
public class NightModeEnabled extends IntermittentDecision implements ReceiverStatement {

    public static final class a extends C1671u {

        /* renamed from: L1, reason: collision with root package name */
        public final boolean f16969L1;

        public a(boolean z7, Configuration configuration) {
            super(configuration, 512);
            this.f16969L1 = z7;
        }

        @Override // com.llamalab.automate.stmt.C1671u
        public final void r(Configuration configuration, Intent intent) {
            boolean z7 = 32 == (configuration.uiMode & 48);
            boolean z8 = this.f16969L1;
            if (z7 != z8) {
                c(intent, Boolean.valueOf(!z8), false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_night_mode_enabled_immediate, C2541R.string.caption_night_mode_enabled_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_night_mode_enabled_title);
        Configuration configuration = c1708z0.getResources().getConfiguration();
        boolean z7 = 32 == (configuration.uiMode & 48);
        if (J1(1) == 0) {
            o(c1708z0, z7);
            return true;
        }
        c1708z0.w(new a(z7, configuration));
        return false;
    }
}
