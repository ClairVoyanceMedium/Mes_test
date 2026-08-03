package com.llamalab.automate.stmt;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("interruption_filter_set.html")
@F3.a(C2541R.integer.ic_device_access_dnd)
@F3.i(C2541R.string.stmt_interruption_filter_set_title)
@F3.h(C2541R.string.stmt_interruption_filter_set_summary)
@F3.e(C2541R.layout.stmt_interruption_filter_set_edit)
/* loaded from: classes.dex */
public final class InterruptionFilterSet extends SetStateAction {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 23 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.f15555p} : 21 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.f15554o} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_interruption_filter_set).e(this.state, 1, C2541R.xml.interruption_filters_short).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int i8;
        c1708z0.q(C2541R.string.stmt_interruption_filter_set_title);
        IncapableAndroidVersionException.a(21);
        int m8 = J3.h.m(c1708z0, this.state, 1);
        if (m8 != 1) {
            i8 = 2;
            if (m8 != 2) {
                i8 = 4;
                if (m8 == 4) {
                    i8 = 3;
                } else {
                    if (m8 != 8) {
                        throw new IllegalArgumentException("priority");
                    }
                    IncapableAndroidVersionException.b(23, "Alarms priority");
                }
            }
        } else {
            i8 = 1;
        }
        if (23 <= Build.VERSION.SDK_INT) {
            ((NotificationManager) c1708z0.getSystemService("notification")).setInterruptionFilter(i8);
        } else {
            AbstractStatement.j().requestInterruptionFilter(i8);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
