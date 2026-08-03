package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import java.util.Locale;

@F3.f("system_language_get.html")
@F3.a(C2541R.integer.ic_device_access_language)
@F3.i(C2541R.string.stmt_system_language_get_title)
@F3.h(C2541R.string.stmt_system_language_get_summary)
@F3.e(C2541R.layout.stmt_system_language_get_edit)
/* loaded from: classes.dex */
public final class SystemLanguageGet extends IntermittentAction implements ReceiverStatement {
    public J3.l varLanguage;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_system_language_get_immediate, C2541R.string.caption_system_language_get_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        String locale = Locale.getDefault().toString();
        J3.l lVar = this.varLanguage;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, locale);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varLanguage);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.varLanguage);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varLanguage = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_system_language_get_title);
        if (J1(1) != 0) {
            AbstractC1618p2.c cVar = new AbstractC1618p2.c();
            c1708z0.w(cVar);
            cVar.h("android.intent.action.LOCALE_CHANGED");
            return false;
        }
        String locale = Locale.getDefault().toString();
        J3.l lVar = this.varLanguage;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, locale);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
