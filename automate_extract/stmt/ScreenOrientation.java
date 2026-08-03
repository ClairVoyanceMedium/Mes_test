package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("screen_orientation.html")
@F3.a(C2541R.integer.ic_device_access_screen_rotation)
@F3.i(C2541R.string.stmt_screen_orientation_title)
@F3.h(C2541R.string.stmt_screen_orientation_summary)
@F3.e(C2541R.layout.stmt_screen_orientation_edit)
/* loaded from: classes.dex */
public class ScreenOrientation extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 orientation;

    public static class a extends C1671u {

        /* renamed from: L1, reason: collision with root package name */
        public final int f17098L1;

        public a(Configuration configuration, int i8) {
            super(configuration, 128);
            this.f17098L1 = i8;
        }

        @Override // com.llamalab.automate.stmt.C1671u
        public final void r(Configuration configuration, Intent intent) {
            c(intent, Boolean.valueOf(this.f17098L1 == configuration.orientation), false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_screen_orientation_immediate, C2541R.string.caption_screen_orientation_change);
        return c1596k0.e(this.orientation, 1, C2541R.xml.screen_orientations_config).q(this.orientation).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.orientation);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.orientation);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.orientation = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_screen_orientation_title);
        int m8 = J3.h.m(c1708z0, this.orientation, 1);
        if (m8 != 1 && m8 != 2) {
            throw new IllegalArgumentException("orientation");
        }
        Configuration configuration = c1708z0.getResources().getConfiguration();
        if (J1(1) == 0) {
            o(c1708z0, m8 == configuration.orientation);
            return true;
        }
        c1708z0.w(new a(configuration, m8));
        return false;
    }
}
