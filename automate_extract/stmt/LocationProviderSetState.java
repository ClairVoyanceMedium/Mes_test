package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Arrays;

@F3.f("location_provider_set_state.html")
@F3.a(C2541R.integer.ic_device_access_location_query)
@F3.i(C2541R.string.stmt_location_provider_set_state_title)
@F3.h(C2541R.string.stmt_location_provider_set_state_summary)
@F3.e(C2541R.layout.stmt_location_provider_set_state_edit)
/* loaded from: classes.dex */
public final class LocationProviderSetState extends SetStateAction {

    /* renamed from: L1, reason: collision with root package name */
    public static final String[] f16868L1 = {"fused", "gps", "network", "passive"};
    public InterfaceC1700x0 provider;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 23 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SECURE_SETTINGS"), com.llamalab.automate.access.c.f15561v} : 17 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS"), com.llamalab.automate.access.c.j("android.permission.WRITE_SECURE_SETTINGS")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_location_provider_enable, C2541R.string.caption_location_provider_disable).r(C2541R.string.caption_location_provider_set_state).b(this.state).v(this.provider, 0).f16030c;
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.provider);
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.provider);
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.provider = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_location_provider_set_state_title);
        boolean f8 = J3.h.f(c1708z0, this.state, false);
        if (28 <= Build.VERSION.SDK_INT) {
            Settings.Secure.putInt(c1708z0.getContentResolver(), "location_mode", f8 ? 3 : 0);
        } else {
            String x7 = J3.h.x(c1708z0, this.provider, "gps");
            if (Arrays.binarySearch(f16868L1, x7) < 0) {
                throw new IllegalArgumentException("provider");
            }
            Settings.Secure.setLocationProviderEnabled(c1708z0.getContentResolver(), x7, f8);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
