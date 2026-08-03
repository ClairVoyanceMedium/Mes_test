package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.auth3p.MicrosoftClient;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("system_property_get.html")
@F3.a(C2541R.integer.ic_action_about)
@F3.i(C2541R.string.stmt_system_property_get_title)
@F3.h(C2541R.string.stmt_system_property_get_summary)
@F3.e(C2541R.layout.stmt_system_property_get_edit)
/* loaded from: classes.dex */
public final class SystemPropertyGet extends Action {
    public InterfaceC1700x0 name;
    public J3.l varValue;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_system_property_get).o(0, this.name).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.name);
        dVar.g(this.varValue);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.name);
        visitor.b(this.varValue);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.name = (InterfaceC1700x0) cVar.readObject();
        this.varValue = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_system_property_get_title);
        String x7 = J3.h.x(c1708z0, this.name, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException(MicrosoftClient.PROP_NAME);
        }
        String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, x7);
        J3.l lVar = this.varValue;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
