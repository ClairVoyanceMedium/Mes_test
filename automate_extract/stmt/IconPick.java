package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IconPickActivity;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import g4.C1827a;
import m3.C2145c;

@F3.f("icon_pick.html")
@F3.a(C2541R.integer.ic_content_picture)
@F3.i(C2541R.string.stmt_icon_pick_title)
@F3.h(C2541R.string.stmt_icon_pick_summary)
@F3.e(C2541R.layout.stmt_icon_pick_edit)
/* loaded from: classes.dex */
public final class IconPick extends ActivityDecision {
    public InterfaceC1700x0 initialIconUri;

    @Deprecated
    public J3.l varIconChar;
    public J3.l varIconUri;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_icon_pick);
        l8.v(this.varIconUri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.initialIconUri);
        if (99 <= dVar.f6413Z) {
            dVar.g(this.varIconUri);
        }
        dVar.g(this.varIconChar);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.initialIconUri);
        visitor.b(this.varIconUri);
        visitor.b(this.varIconChar);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.initialIconUri = N.b(cVar);
        if (99 <= cVar.f6409x0) {
            this.varIconUri = (J3.l) cVar.readObject();
        }
        this.varIconChar = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        Uri data;
        if (-1 != i8 || intent == null || (data = intent.getData()) == null) {
            J3.l lVar = this.varIconUri;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            J3.l lVar2 = this.varIconChar;
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        Double valueOf = 32 == C1827a.m.a(data) ? Double.valueOf(C2145c.b(data, 1)) : null;
        String d8 = O.b.d(null, data);
        J3.l lVar3 = this.varIconUri;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d8);
        }
        J3.l lVar4 = this.varIconChar;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, valueOf);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_icon_pick_title);
        c1708z0.D(new Intent("android.intent.action.PICK", J3.h.g(c1708z0, this.initialIconUri, null), c1708z0, IconPickActivity.class), null, this, c1708z0.f(C2541R.integer.ic_content_picture), c1708z0.getText(C2541R.string.stmt_icon_pick_title));
        return false;
    }
}
