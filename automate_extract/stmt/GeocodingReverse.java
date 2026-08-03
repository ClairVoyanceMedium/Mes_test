package com.llamalab.automate.stmt;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

@F3.f("geocoding_reverse.html")
@F3.a(C2541R.integer.ic_location_directions)
@F3.i(C2541R.string.stmt_geocoding_reverse_title)
@F3.h(C2541R.string.stmt_geocoding_reverse_summary)
@F3.e(C2541R.layout.stmt_geocoding_reverse_edit)
/* loaded from: classes.dex */
public final class GeocodingReverse extends Decision implements AsyncStatement {
    public InterfaceC1700x0 language;
    public InterfaceC1700x0 latitude;
    public InterfaceC1700x0 longitude;
    public J3.l varAddressLines;
    public J3.l varAdminArea;
    public J3.l varCountryCode;
    public J3.l varCountryName;
    public J3.l varFeatureName;
    public J3.l varLocality;
    public J3.l varLocationName;
    public J3.l varPostalCode;
    public J3.l varSubAdminArea;
    public J3.l varSubLocality;
    public J3.l varSubThoroughfare;
    public J3.l varThoroughfare;

    public static final class a extends com.llamalab.automate.W implements Geocoder.GeocodeListener {

        /* renamed from: L1, reason: collision with root package name */
        public final double f16680L1;

        /* renamed from: M1, reason: collision with root package name */
        public final double f16681M1;

        /* renamed from: N1, reason: collision with root package name */
        public final Locale f16682N1;

        /* renamed from: y1, reason: collision with root package name */
        public final AtomicBoolean f16683y1 = new AtomicBoolean(true);

        public a(double d8, double d9, Locale locale) {
            this.f16680L1 = d8;
            this.f16681M1 = d9;
            this.f16682N1 = locale;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            (this.f16682N1 != null ? new Geocoder(this.f15400Y, this.f16682N1) : new Geocoder(this.f15400Y)).getFromLocation(this.f16680L1, this.f16681M1, 1, this);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            this.f16683y1.set(false);
            u2();
        }

        @Override // android.location.Geocoder.GeocodeListener
        public final void onError(String str) {
            if (this.f16683y1.compareAndSet(true, false)) {
                r2(new IllegalStateException(str).fillInStackTrace());
            }
        }

        @Override // android.location.Geocoder.GeocodeListener
        public final void onGeocode(List<Address> list) {
            if (this.f16683y1.compareAndSet(true, false)) {
                q2(list, false);
            }
        }
    }

    public static class b extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final double f16684L1;

        /* renamed from: M1, reason: collision with root package name */
        public final double f16685M1;

        /* renamed from: N1, reason: collision with root package name */
        public final Locale f16686N1;

        public b(double d8, double d9, Locale locale) {
            this.f16684L1 = d8;
            this.f16685M1 = d9;
            this.f16686N1 = locale;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            Locale locale = this.f16686N1;
            q2((locale != null ? new Geocoder(this.f15400Y, locale) : new Geocoder(this.f15400Y)).getFromLocation(this.f16684L1, this.f16685M1, 1), false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_geocoding_reverse);
        l8.w(3, this.latitude);
        return l8.c(4, this.longitude).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.latitude);
        dVar.g(this.longitude);
        if (2 <= dVar.f6413Z) {
            dVar.g(this.language);
        }
        dVar.g(this.varLocationName);
        if (104 <= dVar.f6413Z) {
            dVar.g(this.varAddressLines);
            dVar.g(this.varFeatureName);
            dVar.g(this.varThoroughfare);
            dVar.g(this.varSubThoroughfare);
            dVar.g(this.varLocality);
            dVar.g(this.varSubLocality);
            dVar.g(this.varAdminArea);
            dVar.g(this.varSubAdminArea);
            dVar.g(this.varPostalCode);
            dVar.g(this.varCountryName);
            dVar.g(this.varCountryCode);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.latitude);
        visitor.b(this.longitude);
        visitor.b(this.language);
        visitor.b(this.varLocationName);
        visitor.b(this.varAddressLines);
        visitor.b(this.varFeatureName);
        visitor.b(this.varThoroughfare);
        visitor.b(this.varSubThoroughfare);
        visitor.b(this.varLocality);
        visitor.b(this.varSubLocality);
        visitor.b(this.varAdminArea);
        visitor.b(this.varSubAdminArea);
        visitor.b(this.varPostalCode);
        visitor.b(this.varCountryName);
        visitor.b(this.varCountryCode);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1634b0();
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.latitude = (InterfaceC1700x0) cVar.readObject();
        this.longitude = (InterfaceC1700x0) cVar.readObject();
        if (2 <= cVar.f6409x0) {
            this.language = (InterfaceC1700x0) cVar.readObject();
        }
        this.varLocationName = (J3.l) cVar.readObject();
        if (104 <= cVar.f6409x0) {
            this.varAddressLines = (J3.l) cVar.readObject();
            this.varFeatureName = (J3.l) cVar.readObject();
            this.varThoroughfare = (J3.l) cVar.readObject();
            this.varSubThoroughfare = (J3.l) cVar.readObject();
            this.varLocality = (J3.l) cVar.readObject();
            this.varSubLocality = (J3.l) cVar.readObject();
            this.varAdminArea = (J3.l) cVar.readObject();
            this.varSubAdminArea = (J3.l) cVar.readObject();
            this.varPostalCode = (J3.l) cVar.readObject();
            this.varCountryName = (J3.l) cVar.readObject();
            this.varCountryCode = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_geocoding_reverse_title);
        Double j8 = J3.h.j(c1708z0, this.latitude);
        if (j8 == null) {
            throw new RequiredArgumentNullException("latitude");
        }
        Double j9 = J3.h.j(c1708z0, this.longitude);
        if (j9 == null) {
            throw new RequiredArgumentNullException("longitude");
        }
        Locale r8 = J3.h.r(c1708z0, this.language, null);
        if (33 <= Build.VERSION.SDK_INT) {
            c1708z0.w(new a(j8.doubleValue(), j9.doubleValue(), r8));
            return false;
        }
        b bVar = new b(j8.doubleValue(), j9.doubleValue(), r8);
        c1708z0.w(bVar);
        bVar.w2();
        return false;
    }

    public final void w(C1708z0 c1708z0, boolean z7, Address address) {
        J3.a aVar;
        int maxAddressLineIndex;
        String str;
        J3.l lVar = this.varLocationName;
        if (lVar != null) {
            if (z7) {
                int maxAddressLineIndex2 = address.getMaxAddressLineIndex() + 1;
                if (maxAddressLineIndex2 <= 0) {
                    str = address.getFeatureName();
                } else {
                    StringBuilder sb = new StringBuilder();
                    String str2 = "";
                    int i8 = 0;
                    while (i8 < maxAddressLineIndex2) {
                        sb.append(str2);
                        sb.append(address.getAddressLine(i8));
                        i8++;
                        str2 = ", ";
                    }
                    str = sb.toString();
                }
            } else {
                str = null;
            }
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varAddressLines;
        if (lVar2 != null) {
            if (!z7 || (maxAddressLineIndex = address.getMaxAddressLineIndex() + 1) <= 0) {
                aVar = null;
            } else {
                aVar = new J3.a(maxAddressLineIndex);
                for (int i9 = 0; i9 < maxAddressLineIndex; i9++) {
                    aVar.add(address.getAddressLine(i9));
                }
            }
            c1708z0.z(lVar2.f4659Y, aVar);
        }
        J3.l lVar3 = this.varFeatureName;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, z7 ? address.getFeatureName() : null);
        }
        J3.l lVar4 = this.varThoroughfare;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, z7 ? address.getThoroughfare() : null);
        }
        J3.l lVar5 = this.varSubThoroughfare;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, z7 ? address.getSubThoroughfare() : null);
        }
        J3.l lVar6 = this.varAdminArea;
        if (lVar6 != null) {
            c1708z0.z(lVar6.f4659Y, z7 ? address.getAdminArea() : null);
        }
        J3.l lVar7 = this.varSubAdminArea;
        if (lVar7 != null) {
            c1708z0.z(lVar7.f4659Y, z7 ? address.getSubAdminArea() : null);
        }
        J3.l lVar8 = this.varLocality;
        if (lVar8 != null) {
            c1708z0.z(lVar8.f4659Y, z7 ? address.getLocality() : null);
        }
        J3.l lVar9 = this.varSubLocality;
        if (lVar9 != null) {
            c1708z0.z(lVar9.f4659Y, z7 ? address.getSubLocality() : null);
        }
        J3.l lVar10 = this.varPostalCode;
        if (lVar10 != null) {
            c1708z0.z(lVar10.f4659Y, z7 ? address.getPostalCode() : null);
        }
        J3.l lVar11 = this.varCountryName;
        if (lVar11 != null) {
            c1708z0.z(lVar11.f4659Y, z7 ? address.getCountryName() : null);
        }
        J3.l lVar12 = this.varCountryCode;
        if (lVar12 != null) {
            c1708z0.z(lVar12.f4659Y, z7 ? address.getCountryCode() : null);
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        List list = (List) obj;
        if (list == null || list.isEmpty()) {
            w(c1708z0, false, null);
            return true;
        }
        w(c1708z0, true, (Address) list.get(0));
        return true;
    }
}
