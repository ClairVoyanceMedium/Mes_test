package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.util.Log;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.field.CyanogenModProfileConstants;
import java.util.UUID;

@F3.f("cm_profile_set.html")
@F3.a(C2541R.integer.ic_cyanogenmod_cid)
@F3.i(C2541R.string.stmt_cm_profile_set_title)
@F3.h(C2541R.string.stmt_cm_profile_set_summary)
@F3.e(C2541R.layout.stmt_cm_profile_set_edit)
/* loaded from: classes.dex */
public class CyanogenModProfileSet extends Action {
    public InterfaceC1700x0 uuid;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15561v} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_cm_profile_set);
        InterfaceC1700x0 interfaceC1700x0 = this.uuid;
        if (interfaceC1700x0 instanceof J3.k) {
            l8.g(J3.h.f0(null, interfaceC1700x0), CyanogenModProfileConstants.class);
        } else {
            l8.k(false);
        }
        return l8.q(this.uuid).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.uuid);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.uuid);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.uuid = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_cm_profile_set_title);
        e(c1708z0);
        String x7 = J3.h.x(c1708z0, this.uuid, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("uuid");
        }
        if (2 <= C4.a.f1771a) {
            B4.h a8 = B4.h.a(c1708z0);
            UUID fromString = UUID.fromString(x7);
            a8.getClass();
            try {
                B4.h.b().a1(new ParcelUuid(fromString));
            } catch (RemoteException e8) {
                Log.e("ProfileManager", e8.getLocalizedMessage(), e8);
            }
        } else {
            Object systemService = c1708z0.getSystemService("profile");
            if (systemService == null) {
                throw new UnsupportedOperationException("No ProfileManager, CyanogenMod device required");
            }
            systemService.getClass().getMethod("setActiveProfile", UUID.class).invoke(systemService, UUID.fromString(x7));
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
