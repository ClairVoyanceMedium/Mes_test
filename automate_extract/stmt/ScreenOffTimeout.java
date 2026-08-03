package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1616p0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("screen_off_timeout.html")
@F3.a(C2541R.integer.ic_screen_off_timer)
@F3.i(C2541R.string.stmt_screen_off_timeout_title)
@F3.h(C2541R.string.stmt_screen_off_timeout_summary)
@F3.e(C2541R.layout.stmt_screen_off_timeout_edit)
/* loaded from: classes.dex */
public class ScreenOffTimeout extends LevelDecision implements AsyncStatement {

    public static class a extends C1616p0 {

        /* renamed from: L1, reason: collision with root package name */
        public final Double f17093L1;

        /* renamed from: M1, reason: collision with root package name */
        public final Double f17094M1;

        /* renamed from: N1, reason: collision with root package name */
        public final boolean f17095N1;

        /* renamed from: O1, reason: collision with root package name */
        public double f17096O1;

        /* renamed from: P1, reason: collision with root package name */
        public Boolean f17097P1;

        public a(Boolean bool, Double d8, Double d9, boolean z7) {
            this.f17097P1 = bool;
            this.f17095N1 = z7;
            this.f17093L1 = d8;
            this.f17094M1 = d9;
        }

        @Override // com.llamalab.automate.C1616p0
        public final void x2(Uri uri) {
            Boolean bool;
            try {
                double d8 = Settings.System.getInt(v2(), "screen_off_timeout");
                Double.isNaN(d8);
                Double.isNaN(d8);
                double d9 = d8 / 1000.0d;
                this.f17096O1 = d9;
                Boolean valueOf = Boolean.valueOf(LevelDecision.E(d9, this.f17093L1, this.f17094M1));
                if (!this.f17095N1 && ((bool = this.f17097P1) == null || valueOf.equals(bool))) {
                    this.f17097P1 = valueOf;
                    return;
                }
                this.f17097P1 = valueOf;
                q2(null, false);
            } catch (Exception e8) {
                r2(e8);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_screen_off_timeout_immediate, C2541R.string.caption_screen_off_timeout_change);
        c1596k0.n(this.minLevel, this.maxLevel, 1);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_screen_off_timeout_title);
        boolean z7 = J1(1) == 0;
        Double D7 = D(c1708z0);
        Double C7 = C(c1708z0);
        double d8 = Settings.System.getInt(c1708z0.getContentResolver(), "screen_off_timeout");
        Double.isNaN(d8);
        Double.isNaN(d8);
        double d9 = d8 / 1000.0d;
        boolean E7 = LevelDecision.E(d9, D7, C7);
        if (z7) {
            B(c1708z0, E7, Double.valueOf(d9));
            return true;
        }
        a aVar = new a(Boolean.valueOf(E7), D7, C7, (D7 == null && C7 == null) ? true : z7);
        c1708z0.w(aVar);
        aVar.w2(false, Settings.System.getUriFor("screen_off_timeout"));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        a aVar = (a) w8;
        B(c1708z0, aVar.f17097P1.booleanValue(), Double.valueOf(aVar.f17096O1));
        return true;
    }
}
