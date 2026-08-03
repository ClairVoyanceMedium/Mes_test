package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.KeyChainAliasPickActivity;
import com.llamalab.automate.Visitor;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;

@F3.f("keychain_alias_pick.html")
@F3.a(C2541R.integer.ic_device_access_accounts)
@F3.i(C2541R.string.stmt_keychain_alias_pick_title)
@F3.h(C2541R.string.stmt_keychain_alias_pick_summary)
@F3.e(C2541R.layout.stmt_keychain_alias_pick_edit)
/* loaded from: classes.dex */
public final class KeyChainAliasPick extends ActivityDecision {
    public InterfaceC1700x0 issuers;
    public InterfaceC1700x0 keyTypes;
    public InterfaceC1700x0 preselectedAlias;
    public J3.l varAlias;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_keychain_alias_pick);
        l8.v(this.keyTypes, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.preselectedAlias);
        dVar.g(this.keyTypes);
        dVar.g(this.issuers);
        dVar.g(this.varAlias);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.preselectedAlias);
        visitor.b(this.keyTypes);
        visitor.b(this.issuers);
        visitor.b(this.varAlias);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.preselectedAlias = (InterfaceC1700x0) cVar.readObject();
        this.keyTypes = (InterfaceC1700x0) cVar.readObject();
        this.issuers = (InterfaceC1700x0) cVar.readObject();
        this.varAlias = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varAlias;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        String stringExtra = intent.getStringExtra("android.security.extra.KEY_ALIAS");
        J3.l lVar2 = this.varAlias;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, stringExtra);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_keychain_alias_pick_title);
        Intent intent = new Intent("android.intent.action.PICK", null, c1708z0, KeyChainAliasPickActivity.class);
        String x7 = J3.h.x(c1708z0, this.preselectedAlias, null);
        if (x7 != null) {
            intent.putExtra("android.security.extra.KEY_ALIAS", x7);
        }
        String[] y7 = J3.h.y(c1708z0, this.keyTypes);
        if (y7 != null && y7.length != 0) {
            intent.putExtra("com.llamalab.automate.intent.extra.KEY_TYPES", y7);
        }
        String[] y8 = J3.h.y(c1708z0, this.issuers);
        if (y8 != null && y8.length != 0) {
            ArrayList arrayList = new ArrayList(y8.length);
            for (String str : y8) {
                arrayList.add(new X500Principal(str));
            }
            intent.putExtra("com.llamalab.automate.intent.extra.ISSUERS", arrayList);
        }
        c1708z0.D(intent, null, this, c1708z0.f(C2541R.integer.ic_palette), c1708z0.getText(C2541R.string.stmt_keychain_alias_pick_title));
        return false;
    }
}
