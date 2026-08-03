package com.llamalab.automate.stmt;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.List;
import java.util.Locale;

@F3.f("geocoding.html")
@F3.a(C2541R.integer.ic_location_directions)
@F3.i(C2541R.string.stmt_geocoding_title)
@F3.h(C2541R.string.stmt_geocoding_summary)
@F3.e(C2541R.layout.stmt_geocoding_edit)
/* loaded from: classes.dex */
public class Geocoding extends Decision implements AsyncStatement {
    public InterfaceC1700x0 language;
    public InterfaceC1700x0 locationName;
    public J3.l varDecodedLatitude;
    public J3.l varDecodedLongitude;

    public static class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f16678L1;

        /* renamed from: M1, reason: collision with root package name */
        public final Locale f16679M1;

        public a(String str, Locale locale) {
            this.f16678L1 = str;
            this.f16679M1 = locale;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            Locale locale = this.f16679M1;
            q2((locale != null ? new Geocoder(this.f15400Y, locale) : new Geocoder(this.f15400Y)).getFromLocationName(this.f16678L1, 1), false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_geocoding);
        l8.v(this.locationName, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.locationName);
        if (2 <= dVar.f6413Z) {
            dVar.g(this.language);
        }
        dVar.g(this.varDecodedLatitude);
        dVar.g(this.varDecodedLongitude);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.locationName);
        visitor.b(this.language);
        visitor.b(this.varDecodedLatitude);
        visitor.b(this.varDecodedLongitude);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.locationName = (InterfaceC1700x0) cVar.readObject();
        if (2 <= cVar.f6409x0) {
            this.language = (InterfaceC1700x0) cVar.readObject();
        }
        this.varDecodedLatitude = (J3.l) cVar.readObject();
        this.varDecodedLongitude = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_geocoding_title);
        String x7 = J3.h.x(c1708z0, this.locationName, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("locationName");
        }
        a aVar = new a(x7, J3.h.r(c1708z0, this.language, null));
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        List list = (List) obj;
        if (list == null || list.isEmpty()) {
            J3.l lVar = this.varDecodedLatitude;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            J3.l lVar2 = this.varDecodedLongitude;
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, null);
            }
            o(c1708z0, false);
            return true;
        }
        Address address = (Address) list.get(0);
        Double valueOf = Double.valueOf(address.getLatitude());
        Double valueOf2 = Double.valueOf(address.getLongitude());
        J3.l lVar3 = this.varDecodedLatitude;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, valueOf);
        }
        J3.l lVar4 = this.varDecodedLongitude;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, valueOf2);
        }
        o(c1708z0, true);
        return true;
    }
}
