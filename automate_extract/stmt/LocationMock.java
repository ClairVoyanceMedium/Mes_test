package com.llamalab.automate.stmt;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.SystemClock;
import com.google.android.gms.internal.play_billing.I2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("location_mock.html")
@F3.a(C2541R.integer.ic_device_access_location_found)
@F3.i(C2541R.string.stmt_location_mock_title)
@F3.h(C2541R.string.stmt_location_mock_summary)
@F3.e(C2541R.layout.stmt_location_mock_edit)
/* loaded from: classes.dex */
public final class LocationMock extends Action {
    public static final Object lock = new Object();
    public InterfaceC1700x0 latitude;
    public InterfaceC1700x0 longitude;
    public InterfaceC1700x0 provider;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION"), com.llamalab.automate.access.c.j("android.permission.ACCESS_MOCK_LOCATION"), com.llamalab.automate.access.c.f15553n} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_COARSE_LOCATION"), com.llamalab.automate.access.c.j("android.permission.ACCESS_FINE_LOCATION"), com.llamalab.automate.access.c.j("android.permission.ACCESS_MOCK_LOCATION"), com.llamalab.automate.access.c.f15553n};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 q8 = D1.P.l(context, C2541R.string.caption_location_mock).f(this.provider, "gps", C2541R.xml.location_providers_all).q(this.provider);
        q8.w(3, this.latitude);
        q8.w(4, this.longitude);
        return q8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.provider);
        dVar.g(this.latitude);
        dVar.g(this.longitude);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.provider);
        visitor.b(this.latitude);
        visitor.b(this.longitude);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1634b0();
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.provider = (InterfaceC1700x0) cVar.readObject();
        this.latitude = (InterfaceC1700x0) cVar.readObject();
        this.longitude = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        boolean z7;
        long elapsedRealtimeNanos;
        c1708z0.q(C2541R.string.stmt_location_mock_title);
        int g8 = I2.g(c1708z0, this.provider, 2);
        Double j8 = J3.h.j(c1708z0, this.latitude);
        if (j8 == null) {
            throw new RequiredArgumentNullException("latitude");
        }
        Double j9 = J3.h.j(c1708z0, this.longitude);
        if (j9 == null) {
            throw new RequiredArgumentNullException("longitude");
        }
        Location location = new Location(C1.H0.i(g8));
        location.setTime(System.currentTimeMillis());
        if (17 <= Build.VERSION.SDK_INT) {
            elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            location.setElapsedRealtimeNanos(elapsedRealtimeNanos);
        }
        location.setLatitude(j8.doubleValue());
        location.setLongitude(j9.doubleValue());
        location.setAccuracy(0.01f);
        LocationManager locationManager = (LocationManager) c1708z0.getSystemService("location");
        String packageName = c1708z0.getPackageName();
        synchronized (lock) {
            if (locationManager.getProvider(packageName) == null) {
                locationManager.addTestProvider(packageName, false, false, false, false, false, false, false, 1, 1);
                z7 = true;
                locationManager.setTestProviderEnabled(packageName, true);
            } else {
                z7 = true;
            }
        }
        locationManager.setTestProviderLocation(packageName, location);
        c1708z0.f17642x0 = this.onComplete;
        return z7;
    }
}
