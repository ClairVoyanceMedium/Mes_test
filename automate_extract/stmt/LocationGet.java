package com.llamalab.automate.stmt;

import D1.f5;
import G1.C0968b;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.gms.internal.play_billing.I2;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.N2;
import com.llamalab.automate.Visitor;
import i1.C1922i;
import j1.C1988p;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import x3.C2425c;
import y6.C2472a;
import z1.C2487j;

@F3.f("location_get.html")
@F3.a(C2541R.integer.ic_device_access_location_found)
@F3.i(C2541R.string.stmt_location_get_title)
@F3.h(C2541R.string.stmt_location_get_summary)
@F3.e(C2541R.layout.stmt_location_get_edit)
/* loaded from: classes.dex */
public final class LocationGet extends IntermittentAction implements AsyncStatement {
    public InterfaceC1700x0 maxFixAge;
    public InterfaceC1700x0 minDistance;
    public InterfaceC1700x0 provider;
    public J3.l varFixAccuracy;
    public J3.l varFixAltitude;
    public J3.l varFixBearing;
    public J3.l varFixFlags;
    public J3.l varFixLatitude;
    public J3.l varFixLongitude;
    public J3.l varFixProvider;
    public J3.l varFixSpeed;
    public J3.l varFixTimestamp;

    public static final class a extends com.llamalab.automate.W implements N1.c<Location> {

        /* renamed from: L1, reason: collision with root package name */
        public final C0968b f16850L1;

        /* renamed from: y1, reason: collision with root package name */
        public final S2.b f16852y1 = new S2.b(5);

        /* renamed from: M1, reason: collision with root package name */
        public int f16851M1 = 1;

        public a(C0968b c0968b) {
            this.f16850L1 = c0968b;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            AutomateService automateService2 = this.f15400Y;
            int i8 = G1.g.f3928a;
            new C2487j(automateService2).d(this.f16850L1, (C2472a) this.f16852y1.f6477Y).n(this);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            this.f16852y1.a();
            u2();
        }

        @Override // N1.c
        public final void S0(N1.h<Location> hVar) {
            try {
                if (hVar.j()) {
                    return;
                }
                if (!hVar.l()) {
                    throw hVar.g();
                }
                Location h8 = hVar.h();
                if (h8 != null) {
                    q2(h8, false);
                    return;
                }
                int i8 = this.f16851M1 - 1;
                this.f16851M1 = i8;
                C0968b c0968b = this.f16850L1;
                if (i8 < 0) {
                    throw new IllegalStateException("Failed to get current location: " + c0968b);
                }
                AutomateService automateService = this.f15400Y;
                int i9 = G1.g.f3928a;
                new C2487j(automateService).d(c0968b, (C2472a) this.f16852y1.f6477Y).n(this);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static final class b extends com.llamalab.automate.W implements LocationListener {

        /* renamed from: L1, reason: collision with root package name */
        public Location f16853L1;

        /* renamed from: M1, reason: collision with root package name */
        public final float f16854M1;

        /* renamed from: N1, reason: collision with root package name */
        public final boolean f16855N1;

        /* renamed from: y1, reason: collision with root package name */
        public LocationManager f16856y1;

        public b(LocationManager locationManager, Location location, float f8, boolean z7) {
            this.f16856y1 = locationManager;
            this.f16853L1 = location;
            this.f16854M1 = f8;
            this.f16855N1 = z7;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            LocationManager locationManager = this.f16856y1;
            if (locationManager != null) {
                try {
                    locationManager.removeUpdates(this);
                } catch (Throwable unused) {
                }
                this.f16856y1 = null;
            }
            u2();
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            if (this.f16855N1) {
                F5.n.f(this, "LocationGetonLocationChanged: " + location);
            }
            float f8 = this.f16854M1;
            if (f8 > 0.0f) {
                Location location2 = this.f16853L1;
                if (location2 == null) {
                    this.f16853L1 = location;
                    return;
                } else if (f8 > location2.distanceTo(location)) {
                    return;
                }
            }
            q2(location, false);
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i8, Bundle bundle) {
        }
    }

    public static final class c extends com.llamalab.automate.W implements N1.d {

        /* renamed from: L1, reason: collision with root package name */
        public Location f16857L1;

        /* renamed from: M1, reason: collision with root package name */
        public final LocationRequest f16858M1;

        /* renamed from: O1, reason: collision with root package name */
        public final boolean f16860O1;

        /* renamed from: y1, reason: collision with root package name */
        public C2487j f16862y1;

        /* renamed from: N1, reason: collision with root package name */
        public final S2.b f16859N1 = new S2.b(5);

        /* renamed from: P1, reason: collision with root package name */
        public final b f16861P1 = new b();

        public class a implements N1.e<Location> {
            public a() {
            }

            @Override // N1.e
            public final void J0(Location location) {
                Location location2 = location;
                c cVar = c.this;
                if (cVar.f16860O1) {
                    F5.n.f(cVar, "LocationGet getCurrentLocation: " + location2);
                }
                cVar.f16857L1 = location2;
                if (((C2472a) cVar.f16859N1.f6477Y).x()) {
                    return;
                }
                cVar.v2();
            }
        }

        public class b extends G1.f {
            public b() {
            }

            @Override // G1.f
            public final void a(LocationResult locationResult) {
                c cVar = c.this;
                if (((C2472a) cVar.f16859N1.f6477Y).x()) {
                    return;
                }
                List list = locationResult.f12734X;
                int size = list.size();
                Location location = size == 0 ? null : (Location) list.get(size - 1);
                if (cVar.f16860O1) {
                    F5.n.f(cVar, "LocationGetonLocationResult: " + location);
                }
                if (location != null) {
                    float f8 = cVar.f16858M1.f12717y1;
                    if (f8 <= 0.0f) {
                        cVar.q2(location, false);
                        return;
                    }
                    Location location2 = cVar.f16857L1;
                    if (location2 == null) {
                        cVar.f16857L1 = location;
                    } else if (f8 <= location2.distanceTo(location)) {
                        cVar.q2(location, false);
                    }
                }
            }
        }

        public c(LocationRequest locationRequest, boolean z7) {
            this.f16858M1 = locationRequest;
            this.f16860O1 = z7;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            int i8 = G1.g.f3928a;
            C2487j c2487j = new C2487j(automateService);
            this.f16862y1 = c2487j;
            LocationRequest locationRequest = this.f16858M1;
            if (locationRequest.f12717y1 <= 0.0f) {
                v2();
                return;
            }
            int i9 = locationRequest.f12711X;
            f5.d(i9);
            N1.t d8 = c2487j.d(new C0968b(Long.MAX_VALUE, 0, i9, 500L, false, 0, null, new WorkSource(null), null), (C2472a) this.f16859N1.f6477Y);
            d8.b(this.f15400Y.f14582M1, this);
            d8.d(this.f15400Y.f14582M1, new a());
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            this.f16859N1.a();
            C2487j c2487j = this.f16862y1;
            if (c2487j != null) {
                try {
                    c2487j.b(C1922i.a(G1.f.class.getSimpleName(), this.f16861P1), 2418).e(new Executor() { // from class: z1.g
                        @Override // java.util.concurrent.Executor
                        public final void execute(Runnable runnable) {
                            runnable.run();
                        }
                    }, B1.D.W1);
                } catch (Throwable unused) {
                }
                this.f16862y1 = null;
            }
            u2();
        }

        @Override // com.llamalab.automate.W, N1.d
        public final void a2(Exception exc) {
            if (exc == null) {
                exc = (Exception) new IllegalStateException("Unknown error").fillInStackTrace();
            }
            r2(exc);
        }

        public final void v2() {
            try {
                this.f16862y1.e(this.f16858M1, this.f15400Y.f14582M1, this.f16861P1).b(this.f15400Y.f14582M1, this);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_FINE_LOCATION")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 0, C2541R.string.caption_location_get_immediate, C2541R.string.caption_location_get_change);
        C1596k0 q8 = c1596k0.f(this.provider, "balanced", C2541R.xml.location_providers_all).q(this.provider);
        q8.w(1, this.maxFixAge);
        q8.w(C2541R.string.caption_meters, this.minDistance);
        return q8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        r(dVar, 22);
        dVar.g(this.provider);
        dVar.g(this.maxFixAge);
        if (22 <= dVar.f6413Z) {
            dVar.g(this.minDistance);
        }
        dVar.g(this.varFixLatitude);
        dVar.g(this.varFixLongitude);
        if (41 <= dVar.f6413Z) {
            dVar.g(this.varFixAltitude);
            dVar.g(this.varFixBearing);
            dVar.g(this.varFixSpeed);
            dVar.g(this.varFixAccuracy);
        }
        if (110 <= dVar.f6413Z) {
            dVar.g(this.varFixFlags);
        }
        if (51 <= dVar.f6413Z) {
            dVar.g(this.varFixTimestamp);
            dVar.g(this.varFixProvider);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.provider);
        visitor.b(this.maxFixAge);
        visitor.b(this.minDistance);
        visitor.b(this.varFixLatitude);
        visitor.b(this.varFixLongitude);
        visitor.b(this.varFixAltitude);
        visitor.b(this.varFixBearing);
        visitor.b(this.varFixSpeed);
        visitor.b(this.varFixAccuracy);
        visitor.b(this.varFixFlags);
        visitor.b(this.varFixTimestamp);
        visitor.b(this.varFixProvider);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new C1637c0();
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        q(cVar, 22);
        this.provider = (InterfaceC1700x0) cVar.readObject();
        this.maxFixAge = (InterfaceC1700x0) cVar.readObject();
        if (22 <= cVar.f6409x0) {
            this.minDistance = (InterfaceC1700x0) cVar.readObject();
        }
        this.varFixLatitude = (J3.l) cVar.readObject();
        this.varFixLongitude = (J3.l) cVar.readObject();
        if (41 <= cVar.f6409x0) {
            this.varFixAltitude = (J3.l) cVar.readObject();
            this.varFixBearing = (J3.l) cVar.readObject();
            this.varFixSpeed = (J3.l) cVar.readObject();
            this.varFixAccuracy = (J3.l) cVar.readObject();
        }
        if (110 <= cVar.f6409x0) {
            this.varFixFlags = (J3.l) cVar.readObject();
        }
        if (51 <= cVar.f6409x0) {
            this.varFixTimestamp = (J3.l) cVar.readObject();
            this.varFixProvider = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        N2 cVar;
        c1708z0.q(C2541R.string.stmt_location_get_title);
        int g8 = I2.g(c1708z0, this.provider, 1);
        long t8 = J3.h.t(c1708z0, this.maxFixAge, Long.MAX_VALUE);
        float l8 = J3.h.l(c1708z0, this.minDistance, 100.0f);
        boolean z7 = J1(0) == 0;
        SharedPreferences c8 = C2425c.c(c1708z0);
        boolean a8 = C1710z2.a(c8);
        long j8 = 0;
        if (c8.getBoolean("gmsLocation", false)) {
            if (z7) {
                if (a8) {
                    c1708z0.p("LocationGet Using Google Play services: provider=" + C1.H0.x(g8) + ", maxFixAge=" + t8);
                }
                int g9 = C1.H0.g(g8);
                f5.d(g9);
                C1988p.a("maxUpdateAgeMillis must be greater than or equal to 0", t8 >= 0);
                cVar = new a(new C0968b(t8, 0, g9, Long.MAX_VALUE, false, 0, null, new WorkSource(null), null));
            } else {
                if (a8) {
                    c1708z0.p("LocationGet Using Google Play services: provider=" + C1.H0.x(g8) + ", minDistance=" + l8);
                }
                LocationRequest locationRequest = new LocationRequest(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, 3600000L, 0, 0, null, false, new WorkSource(), null);
                int g10 = C1.H0.g(g8);
                f5.d(g10);
                locationRequest.f12711X = g10;
                locationRequest.f12703L1 = true;
                locationRequest.f12716y0 = Math.max(1L, Long.MAX_VALUE - SystemClock.elapsedRealtime());
                if (l8 < 0.0f) {
                    throw new IllegalArgumentException("invalid displacement: " + l8);
                }
                locationRequest.f12717y1 = l8;
                cVar = new c(locationRequest, a8);
            }
            c1708z0.w(cVar);
            return false;
        }
        LocationManager locationManager = (LocationManager) c1708z0.getSystemService("location");
        String i8 = C1.H0.i(g8);
        Location lastKnownLocation = locationManager.getLastKnownLocation(i8);
        if (!z7) {
            if (a8) {
                c1708z0.p("LocationGet Using location manager: provider=" + C1.H0.x(g8) + ", knownLocation=" + lastKnownLocation + ", minDistance=" + l8);
            }
            b bVar = new b(locationManager, lastKnownLocation, l8, a8);
            c1708z0.w(bVar);
            locationManager.requestLocationUpdates(C1.H0.i(g8), 0L, l8, bVar, c1708z0.getMainLooper());
            return false;
        }
        if (a8) {
            c1708z0.p("LocationGet Using location manager: provider=" + C1.H0.x(g8) + ", knownLocation=" + lastKnownLocation + ", maxFixAge=" + t8);
        }
        if (lastKnownLocation != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (Build.VERSION.SDK_INT >= 17) {
                j8 = TimeUnit.NANOSECONDS.toMillis(J.a.a(lastKnownLocation));
            } else {
                long currentTimeMillis = System.currentTimeMillis() - lastKnownLocation.getTime();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                if (currentTimeMillis < 0) {
                    j8 = elapsedRealtime2;
                } else if (currentTimeMillis <= elapsedRealtime2) {
                    j8 = elapsedRealtime2 - currentTimeMillis;
                }
            }
            if (elapsedRealtime - j8 < t8) {
                s(c1708z0, lastKnownLocation);
                return true;
            }
        }
        b bVar2 = new b(locationManager, lastKnownLocation, 0.0f, a8);
        c1708z0.w(bVar2);
        locationManager.requestSingleUpdate(i8, bVar2, c1708z0.getMainLooper());
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0096, code lost:
    
        if (r0 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a3, code lost:
    
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a1, code lost:
    
        if (r0 != false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s(C1708z0 c1708z0, Location location) {
        boolean isFromMockProvider;
        int i8;
        boolean isMock;
        J3.l lVar = this.varFixLatitude;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, Double.valueOf(location.getLatitude()));
        }
        J3.l lVar2 = this.varFixLongitude;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, Double.valueOf(location.getLongitude()));
        }
        J3.l lVar3 = this.varFixAltitude;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, location.hasAltitude() ? Double.valueOf(location.getAltitude()) : null);
        }
        J3.l lVar4 = this.varFixBearing;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, location.hasBearing() ? Double.valueOf(location.getBearing()) : null);
        }
        J3.l lVar5 = this.varFixSpeed;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, location.hasSpeed() ? Double.valueOf(location.getSpeed()) : null);
        }
        J3.l lVar6 = this.varFixAccuracy;
        if (lVar6 != null) {
            c1708z0.z(lVar6.f4659Y, location.hasAccuracy() ? Double.valueOf(location.getAccuracy()) : null);
        }
        if (this.varFixFlags != null) {
            int i9 = Build.VERSION.SDK_INT;
            if (31 <= i9) {
                isMock = location.isMock();
            } else {
                if (18 <= i9) {
                    isFromMockProvider = location.isFromMockProvider();
                }
                i8 = 0;
            }
            c1708z0.z(this.varFixFlags.f4659Y, Double.valueOf(i8));
        }
        J3.l lVar7 = this.varFixTimestamp;
        if (lVar7 != null) {
            double time = location.getTime();
            c1708z0.z(lVar7.f4659Y, F5.n.l(time, time, time, 1000.0d));
        }
        J3.l lVar8 = this.varFixProvider;
        if (lVar8 != null) {
            c1708z0.z(lVar8.f4659Y, location.getProvider());
        }
        c1708z0.f17642x0 = this.onComplete;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        s(c1708z0, (Location) obj);
        return true;
    }
}
