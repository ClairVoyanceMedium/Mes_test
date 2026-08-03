package com.llamalab.automate.stmt;

import android.content.Intent;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ColorPickActivity;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("color_pick.html")
@F3.a(C2541R.integer.ic_palette)
@F3.i(C2541R.string.stmt_color_pick_title)
@F3.h(C2541R.string.stmt_color_pick_summary)
@F3.c(C2541R.string.caption_color_pick)
@F3.e(C2541R.layout.stmt_color_pick_edit)
/* loaded from: classes.dex */
public class ColorPick extends ActivityDecision {
    public InterfaceC1700x0 hideOpacity;
    public InterfaceC1700x0 initialColor;
    public J3.l varColor;

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (31 <= dVar.f6413Z) {
            dVar.g(this.initialColor);
        }
        dVar.g(this.hideOpacity);
        dVar.g(this.varColor);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.initialColor);
        visitor.b(this.hideOpacity);
        visitor.b(this.varColor);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (31 <= cVar.f6409x0) {
            this.initialColor = (InterfaceC1700x0) cVar.readObject();
        }
        this.hideOpacity = (InterfaceC1700x0) cVar.readObject();
        this.varColor = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varColor;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        Double valueOf = Double.valueOf(intent.getIntExtra("com.llamalab.automate.intent.extra.COLOR", -1));
        J3.l lVar2 = this.varColor;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, valueOf);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_color_pick_title);
        Intent putExtra = new Intent("android.intent.action.PICK", null, c1708z0, ColorPickActivity.class).putExtra("com.llamalab.automate.intent.extra.HIDE_OPACITY", J3.h.f(c1708z0, this.hideOpacity, false));
        Integer o6 = J3.h.o(c1708z0, this.initialColor, null);
        if (o6 != null) {
            putExtra.putExtra("com.llamalab.automate.intent.extra.COLOR", o6);
        }
        c1708z0.D(putExtra, null, this, c1708z0.f(C2541R.integer.ic_palette), c1708z0.getText(C2541R.string.stmt_color_pick_title));
        return false;
    }
}
