package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.Uri;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateApplication;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.io.HttpStatusException;
import e4.C1759b;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import x3.C2443u;

@F3.f("weather.html")
@F3.a(C2541R.integer.ic_weather)
@F3.i(C2541R.string.stmt_weather_title)
@F3.h(C2541R.string.stmt_weather_summary)
@F3.e(C2541R.layout.stmt_weather_edit)
/* loaded from: classes.dex */
public class Weather extends Decision implements AsyncStatement {
    public InterfaceC1700x0 advance;
    public InterfaceC1700x0 latitude;
    public InterfaceC1700x0 longitude;
    public InterfaceC1700x0 period;
    public J3.l varCloudiness;
    public J3.l varForecastTime;
    public J3.l varHumidity;
    public J3.l varPressure;
    public J3.l varRain;
    public J3.l varSnow;
    public J3.l varTemperature;
    public J3.l varWindDirection;
    public J3.l varWindSpeed;

    public static class a extends d {
        public a(double d8, double d9) {
            super(d8, d9);
        }

        @Override // com.llamalab.automate.stmt.Weather.d
        public final void A2(C1759b c1759b) {
            c1759b.v();
            String str = "500";
            String str2 = "Unknown";
            while (c1759b.p(true)) {
                if ("cod".contentEquals(c1759b)) {
                    str = c1759b.m();
                } else if ("message".contentEquals(c1759b)) {
                    str2 = c1759b.m();
                } else if ("dt".contentEquals(c1759b)) {
                    this.f17281N1 = Double.valueOf(c1759b.i().doubleValue());
                } else if (B2(c1759b)) {
                    this.W1 = true;
                } else {
                    c1759b.r();
                }
            }
            if (this.W1) {
                return;
            }
            C2();
            d.z2(str, str2);
        }

        @Override // com.llamalab.automate.stmt.Weather.d
        public final Uri.Builder y2() {
            return d.f17278X1.buildUpon().appendEncodedPath("weather");
        }
    }

    public static class b extends d {

        /* renamed from: Y1, reason: collision with root package name */
        public final long f17276Y1;

        public b(double d8, double d9, long j8) {
            super(d8, d9);
            this.f17276Y1 = j8;
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x014e A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x003c A[SYNTHETIC] */
        @Override // com.llamalab.automate.stmt.Weather.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void A2(C1759b c1759b) {
            boolean z7;
            c1759b.v();
            String str = "500";
            String str2 = "Unknown";
            while (c1759b.p(true)) {
                if ("cod".contentEquals(c1759b)) {
                    str = c1759b.m();
                } else if ("message".contentEquals(c1759b)) {
                    str2 = c1759b.m();
                } else if ("list".contentEquals(c1759b)) {
                    c1759b.t();
                    while (c1759b.c(true)) {
                        c1759b.v();
                        while (c1759b.p(true)) {
                            if ("dt".contentEquals(c1759b)) {
                                long longValue = c1759b.i().longValue() * 1000;
                                double d8 = longValue;
                                this.f17281N1 = F5.n.l(d8, d8, d8, 1000.0d);
                                long j8 = this.f17276Y1;
                                if (j8 >= longValue && j8 <= longValue + 86400000) {
                                    this.W1 = true;
                                }
                            } else {
                                if ("temp".contentEquals(c1759b)) {
                                    c1759b.v();
                                    while (c1759b.p(true)) {
                                        if ("day".contentEquals(c1759b)) {
                                            this.f17282O1 = Double.valueOf(c1759b.i().doubleValue() - 273.15d);
                                        } else {
                                            c1759b.r();
                                        }
                                    }
                                } else if ("humidity".contentEquals(c1759b)) {
                                    this.f17283P1 = Double.valueOf(c1759b.i().doubleValue());
                                } else if ("pressure".contentEquals(c1759b)) {
                                    this.f17284Q1 = Double.valueOf(c1759b.i().doubleValue());
                                } else if ("speed".contentEquals(c1759b)) {
                                    this.f17286S1 = Double.valueOf(c1759b.i().doubleValue());
                                } else if ("deg".contentEquals(c1759b)) {
                                    this.f17287T1 = Double.valueOf(c1759b.i().doubleValue());
                                } else if ("clouds".contentEquals(c1759b)) {
                                    this.f17285R1 = Double.valueOf(c1759b.i().doubleValue());
                                } else if ("rain".contentEquals(c1759b)) {
                                    this.U1 = Double.valueOf(c1759b.i().doubleValue());
                                } else if ("snow".contentEquals(c1759b)) {
                                    this.f17288V1 = Double.valueOf(c1759b.i().doubleValue());
                                } else {
                                    z7 = false;
                                    if (z7) {
                                        c1759b.r();
                                    }
                                }
                                z7 = true;
                                if (z7) {
                                }
                            }
                        }
                        if (this.W1) {
                            return;
                        } else {
                            C2();
                        }
                    }
                } else {
                    c1759b.r();
                }
            }
            d.z2(str, str2);
        }

        @Override // com.llamalab.automate.stmt.Weather.d
        public final Uri.Builder y2() {
            return d.f17278X1.buildUpon().appendEncodedPath("forecast").appendEncodedPath("daily");
        }
    }

    public static class c extends d {

        /* renamed from: Y1, reason: collision with root package name */
        public final long f17277Y1;

        public c(double d8, double d9, long j8) {
            super(d8, d9);
            this.f17277Y1 = j8;
        }

        @Override // com.llamalab.automate.stmt.Weather.d
        public final void A2(C1759b c1759b) {
            c1759b.v();
            String str = "500";
            String str2 = "Unknown";
            while (c1759b.p(true)) {
                if ("cod".contentEquals(c1759b)) {
                    str = c1759b.m();
                } else if ("message".contentEquals(c1759b)) {
                    str2 = c1759b.m();
                } else if ("list".contentEquals(c1759b)) {
                    c1759b.t();
                    while (c1759b.c(true)) {
                        c1759b.v();
                        while (c1759b.p(true)) {
                            if ("dt".contentEquals(c1759b)) {
                                long longValue = c1759b.i().longValue() * 1000;
                                double d8 = longValue;
                                this.f17281N1 = F5.n.l(d8, d8, d8, 1000.0d);
                                long j8 = this.f17277Y1;
                                if (j8 >= longValue && j8 <= longValue + 10800000) {
                                    this.W1 = true;
                                }
                            } else if (!B2(c1759b)) {
                                c1759b.r();
                            }
                        }
                        if (this.W1) {
                            return;
                        } else {
                            C2();
                        }
                    }
                } else {
                    c1759b.r();
                }
            }
            d.z2(str, str2);
        }

        @Override // com.llamalab.automate.stmt.Weather.d
        public final Uri.Builder y2() {
            return d.f17278X1.buildUpon().appendEncodedPath("forecast");
        }
    }

    public static abstract class d extends AbstractRunnableC1694v2 {

        /* renamed from: X1, reason: collision with root package name */
        public static final Uri f17278X1 = Uri.parse("https://api.openweathermap.org/data/2.5/");

        /* renamed from: L1, reason: collision with root package name */
        public final double f17279L1;

        /* renamed from: M1, reason: collision with root package name */
        public final double f17280M1;

        /* renamed from: N1, reason: collision with root package name */
        public Double f17281N1;

        /* renamed from: O1, reason: collision with root package name */
        public Double f17282O1;

        /* renamed from: P1, reason: collision with root package name */
        public Double f17283P1;

        /* renamed from: Q1, reason: collision with root package name */
        public Double f17284Q1;

        /* renamed from: R1, reason: collision with root package name */
        public Double f17285R1;

        /* renamed from: S1, reason: collision with root package name */
        public Double f17286S1;

        /* renamed from: T1, reason: collision with root package name */
        public Double f17287T1;
        public Double U1;

        /* renamed from: V1, reason: collision with root package name */
        public Double f17288V1;
        public boolean W1;

        public d(double d8, double d9) {
            this.f17279L1 = d8;
            this.f17280M1 = d9;
        }

        public static void z2(String str, String str2) {
            int parseInt = Integer.parseInt(str);
            if (parseInt != 200 && parseInt != 404) {
                throw new HttpStatusException(str2, parseInt);
            }
        }

        public abstract void A2(C1759b c1759b);

        public final boolean B2(C1759b c1759b) {
            if ("main".contentEquals(c1759b)) {
                c1759b.v();
                while (c1759b.p(true)) {
                    if ("temp".contentEquals(c1759b)) {
                        this.f17282O1 = Double.valueOf(c1759b.i().doubleValue() - 273.15d);
                    } else if ("humidity".contentEquals(c1759b)) {
                        this.f17283P1 = Double.valueOf(c1759b.i().doubleValue());
                    } else if ("pressure".contentEquals(c1759b)) {
                        this.f17284Q1 = Double.valueOf(c1759b.i().doubleValue());
                    } else {
                        c1759b.r();
                    }
                }
                return true;
            }
            if ("wind".contentEquals(c1759b)) {
                c1759b.v();
                while (c1759b.p(true)) {
                    if ("speed".contentEquals(c1759b)) {
                        this.f17286S1 = Double.valueOf(c1759b.i().doubleValue());
                    } else if ("deg".contentEquals(c1759b)) {
                        this.f17287T1 = Double.valueOf(c1759b.i().doubleValue());
                    } else {
                        c1759b.r();
                    }
                }
                return true;
            }
            if ("clouds".contentEquals(c1759b)) {
                c1759b.v();
                while (c1759b.p(true)) {
                    if ("all".contentEquals(c1759b)) {
                        this.f17285R1 = Double.valueOf(c1759b.i().doubleValue());
                    } else {
                        c1759b.r();
                    }
                }
                return true;
            }
            if ("rain".contentEquals(c1759b)) {
                c1759b.v();
                while (c1759b.p(true)) {
                    if ("3h".contentEquals(c1759b)) {
                        this.U1 = Double.valueOf(c1759b.i().doubleValue() / 3.0d);
                    } else {
                        c1759b.r();
                    }
                }
                return true;
            }
            if (!"snow".contentEquals(c1759b)) {
                return false;
            }
            c1759b.v();
            while (c1759b.p(true)) {
                if ("3h".contentEquals(c1759b)) {
                    this.f17288V1 = Double.valueOf(c1759b.i().doubleValue() / 3.0d);
                } else {
                    c1759b.r();
                }
            }
            return true;
        }

        public final void C2() {
            this.f17288V1 = null;
            this.U1 = null;
            this.f17287T1 = null;
            this.f17286S1 = null;
            this.f17285R1 = null;
            this.f17284Q1 = null;
            this.f17283P1 = null;
            this.f17282O1 = null;
            this.f17281N1 = null;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            Uri build = y2().appendQueryParameter("lat", Double.toString(this.f17279L1)).appendQueryParameter("lon", Double.toString(this.f17280M1)).appendQueryParameter("mode", "json").appendQueryParameter("APPID", "745ade4321505105c08287a8dd251480").build();
            try {
                InetAddress.getByName(build.getHost());
            } catch (Throwable unused) {
            }
            C2443u c2443u = AutomateApplication.f14522x1;
            synchronized (c2443u) {
                if (!c2443u.a(1)) {
                    throw new SecurityException("Maximum weather request rate exceeded");
                }
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(build.toString()).openConnection();
            try {
                httpURLConnection.setUseCaches(true);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setRequestProperty("Connection", "close");
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    C1759b c1759b = new C1759b(httpURLConnection.getInputStream());
                    try {
                        A2(c1759b);
                    } finally {
                        c1759b.close();
                    }
                } else if (responseCode != 404) {
                    throw new HttpStatusException(httpURLConnection);
                }
                httpURLConnection.disconnect();
                p2(null);
            } catch (Throwable th) {
                httpURLConnection.disconnect();
                throw th;
            }
        }

        public abstract Uri.Builder y2();
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_weather_title);
        l8.w(3, this.latitude);
        C1596k0 c8 = l8.c(4, this.longitude);
        c8.w(1, this.advance);
        return c8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.latitude);
        dVar.g(this.longitude);
        dVar.g(this.advance);
        if (45 <= dVar.f6413Z) {
            dVar.g(this.period);
        }
        dVar.g(this.varForecastTime);
        dVar.g(this.varTemperature);
        dVar.g(this.varHumidity);
        dVar.g(this.varPressure);
        dVar.g(this.varCloudiness);
        dVar.g(this.varWindSpeed);
        dVar.g(this.varWindDirection);
        dVar.g(this.varRain);
        dVar.g(this.varSnow);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.latitude);
        visitor.b(this.longitude);
        visitor.b(this.advance);
        visitor.b(this.period);
        visitor.b(this.varForecastTime);
        visitor.b(this.varTemperature);
        visitor.b(this.varHumidity);
        visitor.b(this.varPressure);
        visitor.b(this.varCloudiness);
        visitor.b(this.varWindSpeed);
        visitor.b(this.varWindDirection);
        visitor.b(this.varRain);
        visitor.b(this.varSnow);
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
        this.advance = (InterfaceC1700x0) cVar.readObject();
        if (45 <= cVar.f6409x0) {
            this.period = (InterfaceC1700x0) cVar.readObject();
        }
        this.varForecastTime = (J3.l) cVar.readObject();
        this.varTemperature = (J3.l) cVar.readObject();
        this.varHumidity = (J3.l) cVar.readObject();
        this.varPressure = (J3.l) cVar.readObject();
        this.varCloudiness = (J3.l) cVar.readObject();
        this.varWindSpeed = (J3.l) cVar.readObject();
        this.varWindDirection = (J3.l) cVar.readObject();
        this.varRain = (J3.l) cVar.readObject();
        this.varSnow = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_weather_title);
        Double j8 = J3.h.j(c1708z0, this.latitude);
        if (j8 == null) {
            throw new RequiredArgumentNullException("latitude");
        }
        Double j9 = J3.h.j(c1708z0, this.longitude);
        if (j9 == null) {
            throw new RequiredArgumentNullException("longitude");
        }
        long t8 = J3.h.t(c1708z0, this.advance, 0L);
        if (t8 > 1382400000) {
            throw new IllegalArgumentException("Forecast beyond 16 day not available");
        }
        long t9 = J3.h.t(c1708z0, this.period, 3600000L);
        if (3600000 != t9 && 86400000 != t9) {
            throw new IllegalArgumentException("Only hourly or daily forecasts available");
        }
        AbstractRunnableC1694v2 bVar = (t8 > 432000000 || 86400000 == t9) ? new b(j8.doubleValue(), j9.doubleValue(), c1708z0.b() + t8) : t8 > 10800000 ? new c(j8.doubleValue(), j9.doubleValue(), c1708z0.b() + t8) : new a(j8.doubleValue(), j9.doubleValue());
        c1708z0.w(bVar);
        bVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        d dVar = (d) w8;
        J3.l lVar = this.varForecastTime;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, dVar.f17281N1);
        }
        J3.l lVar2 = this.varTemperature;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, dVar.f17282O1);
        }
        J3.l lVar3 = this.varHumidity;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, dVar.f17283P1);
        }
        J3.l lVar4 = this.varPressure;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, dVar.f17284Q1);
        }
        J3.l lVar5 = this.varCloudiness;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, dVar.f17285R1);
        }
        J3.l lVar6 = this.varWindSpeed;
        if (lVar6 != null) {
            c1708z0.z(lVar6.f4659Y, dVar.f17286S1);
        }
        J3.l lVar7 = this.varWindDirection;
        if (lVar7 != null) {
            c1708z0.z(lVar7.f4659Y, dVar.f17287T1);
        }
        J3.l lVar8 = this.varRain;
        if (lVar8 != null) {
            c1708z0.z(lVar8.f4659Y, dVar.U1);
        }
        J3.l lVar9 = this.varSnow;
        if (lVar9 != null) {
            c1708z0.z(lVar9.f4659Y, dVar.f17288V1);
        }
        o(c1708z0, dVar.W1);
        return true;
    }
}
