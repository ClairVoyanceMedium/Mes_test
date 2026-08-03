package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InputMethodPickActivity;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("input_method_pick.html")
@F3.a(C2541R.integer.ic_input_method_select)
@F3.i(C2541R.string.stmt_input_method_pick_title)
@F3.h(C2541R.string.stmt_input_method_pick_summary)
@F3.e(C2541R.layout.stmt_input_method_pick_edit)
/* loaded from: classes.dex */
public class InputMethodPick extends ActivityDecision {
    public InterfaceC1700x0 enabledOnly;
    public InterfaceC1700x0 showSubtypes;
    public J3.l varInputMethod;
    public J3.l varInputMethodSubtype;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_input_method_pick).y(this.enabledOnly, C2541R.string.caption_enabled, 0).y(this.showSubtypes, C2541R.string.caption_subtypes, 0).f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.enabledOnly);
        dVar.g(this.showSubtypes);
        dVar.g(this.varInputMethod);
        dVar.g(this.varInputMethodSubtype);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.enabledOnly);
        visitor.b(this.showSubtypes);
        visitor.b(this.varInputMethod);
        visitor.b(this.varInputMethodSubtype);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.enabledOnly = (InterfaceC1700x0) cVar.readObject();
        this.showSubtypes = (InterfaceC1700x0) cVar.readObject();
        this.varInputMethod = (J3.l) cVar.readObject();
        this.varInputMethodSubtype = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varInputMethod;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            J3.l lVar2 = this.varInputMethodSubtype;
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        int intExtra = intent.getIntExtra("com.llamalab.automate.intent.extra.INPUT_METHOD_SUBTYPE_HASH", -1);
        String stringExtra = intent.getStringExtra("com.llamalab.automate.intent.extra.INPUT_METHOD_ID");
        String num = intExtra != -1 ? Integer.toString(intExtra) : null;
        J3.l lVar3 = this.varInputMethod;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, stringExtra);
        }
        J3.l lVar4 = this.varInputMethodSubtype;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, num);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_input_method_pick_title);
        boolean f8 = J3.h.f(c1708z0, this.enabledOnly, false);
        c1708z0.D(new Intent(c1708z0, (Class<?>) InputMethodPickActivity.class).putExtra("com.llamalab.automate.intent.extra.ENABLED_ONLY", f8).putExtra("com.llamalab.automate.intent.extra.SHOW_SUBTYPES", J3.h.f(c1708z0, this.showSubtypes, true)), null, this, c1708z0.f(C2541R.integer.ic_input_method_select), c1708z0.getText(C2541R.string.stmt_input_method_pick_title));
        return false;
    }
}
