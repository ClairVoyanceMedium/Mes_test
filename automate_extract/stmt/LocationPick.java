package com.llamalab.automate.stmt;

import android.content.Intent;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.LocationPickActivity;
import com.llamalab.automate.Visitor;

@F3.f("location_pick.html")
@F3.a(C2541R.integer.ic_av_make_available_offline)
@F3.i(C2541R.string.stmt_location_pick_title)
@F3.h(C2541R.string.stmt_location_pick_summary)
@F3.c(C2541R.string.caption_location_pick)
@F3.e(C2541R.layout.stmt_location_pick_edit)
/* loaded from: classes.dex */
public final class LocationPick extends ActivityDecision {
    public InterfaceC1700x0 defaultRadius;
    public InterfaceC1700x0 initialLatitude;
    public InterfaceC1700x0 initialLongitude;
    public InterfaceC1700x0 radiusSelection;
    public J3.l varPickedLatitude;
    public J3.l varPickedLongitude;
    public J3.l varPickedRadius;

    public final void C(C1708z0 c1708z0, boolean z7, Double d8, Double d9, Double d10) {
        J3.l lVar = this.varPickedLatitude;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        J3.l lVar2 = this.varPickedLongitude;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d9);
        }
        J3.l lVar3 = this.varPickedRadius;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d10);
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (79 <= dVar.f6413Z) {
            dVar.g(this.initialLatitude);
            dVar.g(this.initialLongitude);
            dVar.g(this.defaultRadius);
        }
        dVar.g(this.radiusSelection);
        dVar.g(this.varPickedLatitude);
        dVar.g(this.varPickedLongitude);
        dVar.g(this.varPickedRadius);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.initialLatitude);
        visitor.b(this.initialLongitude);
        visitor.b(this.defaultRadius);
        visitor.b(this.radiusSelection);
        visitor.b(this.varPickedLatitude);
        visitor.b(this.varPickedLongitude);
        visitor.b(this.varPickedRadius);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (79 <= cVar.f6409x0) {
            this.initialLatitude = (InterfaceC1700x0) cVar.readObject();
            this.initialLongitude = (InterfaceC1700x0) cVar.readObject();
            this.defaultRadius = (InterfaceC1700x0) cVar.readObject();
        }
        this.radiusSelection = (InterfaceC1700x0) cVar.readObject();
        this.varPickedLatitude = (J3.l) cVar.readObject();
        this.varPickedLongitude = (J3.l) cVar.readObject();
        this.varPickedRadius = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            C(c1708z0, false, null, null, null);
            return;
        }
        double doubleExtra = intent.getDoubleExtra("com.llamalab.automate.intent.extra.LATITUDE", 0.0d);
        double doubleExtra2 = intent.getDoubleExtra("com.llamalab.automate.intent.extra.LONGITUDE", 0.0d);
        C(c1708z0, true, Double.valueOf(doubleExtra), Double.valueOf(doubleExtra2), intent.hasExtra("com.llamalab.automate.intent.extra.RADIUS") ? Double.valueOf(intent.getDoubleExtra("com.llamalab.automate.intent.extra.RADIUS", 0.0d)) : null);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_location_pick_title);
        Double j8 = J3.h.j(c1708z0, this.initialLatitude);
        Double j9 = J3.h.j(c1708z0, this.initialLongitude);
        Double j10 = J3.h.j(c1708z0, this.defaultRadius);
        Intent putExtra = new Intent("android.intent.action.PICK", null, c1708z0, LocationPickActivity.class).putExtra("com.llamalab.automate.intent.extra.RADIUS_SELECTION", J3.h.f(c1708z0, this.radiusSelection, false));
        if (j8 != null && j9 != null) {
            putExtra.putExtra("com.llamalab.automate.intent.extra.LATITUDE", j8).putExtra("com.llamalab.automate.intent.extra.LONGITUDE", j9);
        }
        if (j10 != null) {
            putExtra.putExtra("com.llamalab.automate.intent.extra.RADIUS", j10);
        }
        c1708z0.D(putExtra, null, this, c1708z0.f(C2541R.integer.ic_av_make_available_offline), c1708z0.getText(C2541R.string.stmt_location_pick_title));
        return false;
    }
}
