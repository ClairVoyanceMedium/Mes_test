package com.llamalab.automate.stmt;

import L3.C1041f;
import L3.C1047l;
import L3.C1052q;
import L3.C1053s;
import L3.C1060z;
import android.content.Context;
import android.content.Intent;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.PackagePickActivity;
import com.llamalab.automate.Visitor;

@F3.f("app_pick.html")
@F3.a(C2541R.integer.ic_app_select)
@F3.i(C2541R.string.stmt_app_pick_title)
@F3.h(C2541R.string.stmt_app_pick_summary)
@F3.e(C2541R.layout.stmt_app_pick_edit)
/* loaded from: classes.dex */
public final class AppPick extends ActivityDecision {
    public InterfaceC1700x0 flagsExclude;
    public InterfaceC1700x0 flagsInclude;
    public InterfaceC1700x0 states;
    public J3.l varPackageName;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_app_pick);
        l8.v(this.varPackageName, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        Object j8;
        super.Y0(dVar);
        if (106 <= dVar.f6413Z) {
            dVar.g(this.flagsInclude);
            dVar.g(this.flagsExclude);
            dVar.g(this.states);
        } else {
            InterfaceC1700x0 interfaceC1700x0 = this.flagsExclude;
            if (interfaceC1700x0 == null || (interfaceC1700x0 instanceof J3.k)) {
                j8 = new L3.J((((int) J3.h.W(interfaceC1700x0)) & MoreOsConstants.IN_ONLYDIR) == 0);
            } else {
                j8 = new C1060z(new C1052q(new C1041f(interfaceC1700x0, new C1053s(MoreOsConstants.IN_ONLYDIR))));
            }
            dVar.g(j8);
        }
        dVar.g(this.varPackageName);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.flagsInclude);
        visitor.b(this.flagsExclude);
        visitor.b(this.states);
        visitor.b(this.varPackageName);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (106 <= cVar.f6409x0) {
            this.flagsInclude = (InterfaceC1700x0) cVar.readObject();
            this.flagsExclude = (InterfaceC1700x0) cVar.readObject();
            this.states = (InterfaceC1700x0) cVar.readObject();
        } else {
            InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
            if (interfaceC1700x0 == null || (interfaceC1700x0 instanceof J3.k)) {
                this.flagsExclude = J3.h.J(interfaceC1700x0) ? null : new C1053s(MoreOsConstants.IN_ONLYDIR);
            } else {
                this.flagsExclude = new C1047l(interfaceC1700x0, L3.I.f4933X, new C1053s(MoreOsConstants.IN_ONLYDIR));
            }
        }
        this.varPackageName = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varPackageName;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        J3.l lVar2 = this.varPackageName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, schemeSpecificPart);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_app_pick_title);
        int m8 = J3.h.m(c1708z0, this.flagsInclude, 0);
        int m9 = J3.h.m(c1708z0, this.flagsExclude, 0);
        c1708z0.D(new Intent("android.intent.action.PICK", null, c1708z0, PackagePickActivity.class).putExtra("com.llamalab.automate.intent.extra.FLAGS_INCLUDE", m8).putExtra("com.llamalab.automate.intent.extra.FLAGS_EXCLUDE", m9).putExtra("com.llamalab.automate.intent.extra.STATES", J3.h.m(c1708z0, this.states, 3)), null, this, c1708z0.f(C2541R.integer.ic_app_select), c1708z0.getText(C2541R.string.stmt_app_pick_title));
        return false;
    }
}
