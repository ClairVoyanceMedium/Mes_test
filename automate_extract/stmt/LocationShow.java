package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("location_show.html")
@F3.a(C2541R.integer.ic_location_map)
@F3.i(C2541R.string.stmt_location_show_title)
@F3.h(C2541R.string.stmt_location_show_summary)
@F3.e(C2541R.layout.stmt_location_show_edit)
/* loaded from: classes.dex */
public class LocationShow extends Action {
    public InterfaceC1700x0 label;
    public InterfaceC1700x0 latitude;
    public InterfaceC1700x0 locationName;
    public InterfaceC1700x0 longitude;
    public InterfaceC1700x0 zoom;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15547h} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_location_show);
        l8.v(this.locationName, 0);
        return l8.q(this.label).c(3, this.latitude).c(4, this.longitude).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.latitude);
        dVar.g(this.longitude);
        dVar.g(this.locationName);
        dVar.g(this.zoom);
        dVar.g(this.label);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.latitude);
        visitor.b(this.longitude);
        visitor.b(this.locationName);
        visitor.b(this.zoom);
        visitor.b(this.label);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1634b0();
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.latitude = (InterfaceC1700x0) cVar.readObject();
        this.longitude = (InterfaceC1700x0) cVar.readObject();
        this.locationName = (InterfaceC1700x0) cVar.readObject();
        this.zoom = (InterfaceC1700x0) cVar.readObject();
        this.label = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        char c8;
        c1708z0.q(C2541R.string.stmt_location_show_title);
        e(c1708z0);
        StringBuilder sb = new StringBuilder("geo:");
        Double j8 = J3.h.j(c1708z0, this.latitude);
        Double j9 = J3.h.j(c1708z0, this.longitude);
        if (j8 == null || j9 == null) {
            sb.append("0,0");
            String x7 = J3.h.x(c1708z0, this.locationName, null);
            if (!TextUtils.isEmpty(x7)) {
                sb.append("?q=");
                sb.append(Uri.encode(x7));
                c8 = '&';
            }
            c8 = '?';
        } else {
            String x8 = J3.h.x(c1708z0, this.label, null);
            if (TextUtils.isEmpty(x8)) {
                sb.append(j8);
                sb.append(',');
                sb.append(j9);
                c8 = '?';
            } else {
                sb.append("0,0?q=");
                sb.append(j8);
                sb.append(',');
                sb.append(j9);
                sb.append('(');
                sb.append(Uri.encode(x8));
                sb.append(')');
                c8 = '&';
            }
        }
        Double j10 = J3.h.j(c1708z0, this.zoom);
        if (j10 != null) {
            sb.append(c8);
            sb.append("z=");
            sb.append((int) y4.j.b((j10.doubleValue() * 0.22d) + 1.0d, 1.0d, 23.0d));
        }
        c1708z0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())).addFlags(268697600));
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
