package com.llamalab.automate.stmt;

import android.content.Intent;
import android.os.Parcelable;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.CellSitePickActivity;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.field.CellSiteExprField;
import java.util.LinkedHashSet;
import x3.C2434l;

@F3.f("cell_site_pick.html")
@F3.a(C2541R.integer.ic_cell_tower_select)
@F3.i(C2541R.string.stmt_cell_site_pick_title)
@F3.h(C2541R.string.stmt_cell_site_pick_summary)
@F3.c(C2541R.string.caption_cell_site_pick)
@F3.e(C2541R.layout.stmt_cell_site_pick_edit)
/* loaded from: classes.dex */
public final class CellSitePick extends ActivityDecision {
    public InterfaceC1700x0 initialCells;
    public InterfaceC1700x0 subscriptionId;
    public J3.l varPickedCells;

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (95 <= dVar.f6413Z) {
            dVar.g(this.initialCells);
            dVar.g(this.subscriptionId);
        }
        dVar.g(this.varPickedCells);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.initialCells);
        visitor.b(this.subscriptionId);
        visitor.b(this.varPickedCells);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (95 <= cVar.f6409x0) {
            this.initialCells = (InterfaceC1700x0) cVar.readObject();
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
        this.varPickedCells = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varPickedCells;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        intent.setExtrasClassLoader(CellSitePick.class.getClassLoader());
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("com.llamalab.automate.intent.extra.CELLS");
        J3.l lVar2 = this.varPickedCells;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, parcelableArrayExtra != null ? J3.h.h0(parcelableArrayExtra) : null);
        }
        o(c1708z0, true);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_cell_site_pick_title);
        LinkedHashSet o6 = CellSiteExprField.o(c1708z0, this.initialCells);
        c1708z0.D(new Intent("android.intent.action.PICK", null, c1708z0, CellSitePickActivity.class).putExtra("com.llamalab.automate.intent.extra.EXISTING_CELLS", (Parcelable[]) o6.toArray(C2434l.f23399j)).putExtra("com.llamalab.automate.intent.extra.SUBSCRIPTION_ID", J3.h.m(c1708z0, this.subscriptionId, w3.n.d())), null, this, c1708z0.f(C2541R.integer.ic_cell_tower_select), c1708z0.getText(C2541R.string.stmt_cell_site_pick_title));
        return false;
    }
}
