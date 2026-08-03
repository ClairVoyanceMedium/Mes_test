package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("location_provider_enabled.html")
@F3.a(C2541R.integer.ic_device_access_location_query)
@F3.i(C2541R.string.stmt_location_provider_enabled_title)
@F3.h(C2541R.string.stmt_location_provider_enabled_summary)
@F3.e(C2541R.layout.stmt_location_provider_enabled_edit)
/* loaded from: classes.dex */
public final class LocationProviderEnabled extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 provider;

    public static class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final String f16865x1;

        /* renamed from: y1, reason: collision with root package name */
        public final boolean f16866y1;

        public a(String str, boolean z7) {
            this.f16865x1 = str;
            this.f16866y1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            boolean isProviderEnabled = ((LocationManager) context.getSystemService("location")).isProviderEnabled(this.f16865x1);
            boolean z7 = this.f16866y1;
            if (z7 != isProviderEnabled) {
                c(intent, Boolean.valueOf(!z7), false);
            }
        }
    }

    public static class b extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final boolean f16867x1;

        public b(boolean z7) {
            this.f16867x1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            boolean isLocationEnabled;
            isLocationEnabled = ((LocationManager) context.getSystemService("location")).isLocationEnabled();
            boolean z7 = this.f16867x1;
            if (z7 != isLocationEnabled) {
                c(intent, Boolean.valueOf(!z7), false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 21 <= Build.VERSION.SDK_INT ? com.llamalab.automate.access.c.f15562w : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_FINE_LOCATION")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_location_provider_enabled_immediate, C2541R.string.caption_location_provider_enabled_change);
        return c1596k0.f(this.provider, "gps", C2541R.xml.location_providers_all).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.provider);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.provider);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.provider = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        boolean isLocationEnabled;
        c1708z0.q(C2541R.string.stmt_location_provider_enabled_title);
        LocationManager locationManager = (LocationManager) c1708z0.getSystemService("location");
        if (28 <= Build.VERSION.SDK_INT) {
            isLocationEnabled = locationManager.isLocationEnabled();
            if (J1(1) == 0) {
                o(c1708z0, isLocationEnabled);
                return true;
            }
            b bVar = new b(isLocationEnabled);
            c1708z0.w(bVar);
            bVar.h("android.location.MODE_CHANGED");
            return false;
        }
        String x7 = J3.h.x(c1708z0, this.provider, "gps");
        boolean isProviderEnabled = locationManager.isProviderEnabled(x7);
        if (J1(1) == 0) {
            o(c1708z0, isProviderEnabled);
            return true;
        }
        a aVar = new a(x7, isProviderEnabled);
        c1708z0.w(aVar);
        aVar.h("android.location.PROVIDERS_CHANGED");
        return false;
    }
}
