package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import com.llamalab.auth3p.MicrosoftClient;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.field.CyanogenModProfileConstants;
import java.util.UUID;

@F3.f("cm_profile.html")
@F3.a(C2541R.integer.ic_cyanogenmod_cid)
@F3.i(C2541R.string.stmt_cm_profile_title)
@F3.h(C2541R.string.stmt_cm_profile_summary)
@F3.e(C2541R.layout.stmt_cm_profile_edit)
/* loaded from: classes.dex */
public final class CyanogenModProfile extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 uuid;
    public J3.l varActiveName;
    public J3.l varActiveUuid;

    public static final class a extends AbstractC1618p2.c {
        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Object invoke;
            try {
                if (isInitialStickyBroadcast()) {
                    return;
                }
                Object systemService = context.getSystemService("profile");
                if (systemService != null && (invoke = systemService.getClass().getMethod("getActiveProfile", new Class[0]).invoke(systemService, new Object[0])) != null) {
                    intent.putExtra("uuid", H1.b.A(invoke).toString());
                    intent.putExtra(MicrosoftClient.PROP_NAME, H1.b.z(invoke));
                }
                b(intent);
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public static final class b extends AbstractC1618p2.c {
        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            B4.e eVar;
            try {
                if (isInitialStickyBroadcast()) {
                    return;
                }
                if (B4.h.a(context) != null) {
                    try {
                        eVar = B4.h.b().N1();
                    } catch (RemoteException e8) {
                        Log.e("ProfileManager", e8.getLocalizedMessage(), e8);
                        eVar = null;
                    }
                    if (eVar != null) {
                        if (eVar.f445Z == null) {
                            eVar.f445Z = UUID.randomUUID();
                        }
                        intent.putExtra("uuid", eVar.f445Z.toString());
                        intent.putExtra(MicrosoftClient.PROP_NAME, eVar.f443X);
                    }
                }
                b(intent);
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public final void B(C1708z0 c1708z0, boolean z7, String str, String str2) {
        J3.l lVar = this.varActiveUuid;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varActiveName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str2);
        }
        o(c1708z0, z7);
    }

    public final void C(C1708z0 c1708z0, String str, String str2) {
        String x7 = J3.h.x(c1708z0, this.uuid, null);
        B(c1708z0, x7 == null || x7.equals(str), str, str2);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_cm_profile_immediate, C2541R.string.caption_cm_profile_change);
        InterfaceC1700x0 interfaceC1700x0 = this.uuid;
        if (interfaceC1700x0 instanceof J3.k) {
            c1596k0.g(J3.h.f0(null, interfaceC1700x0), CyanogenModProfileConstants.class);
        } else {
            c1596k0.k(false);
        }
        return c1596k0.q(this.uuid).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        C(c1708z0, intent.getStringExtra("uuid"), intent.getStringExtra(MicrosoftClient.PROP_NAME));
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.uuid);
        dVar.g(this.varActiveUuid);
        dVar.g(this.varActiveName);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.uuid);
        visitor.b(this.varActiveUuid);
        visitor.b(this.varActiveName);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.uuid = (InterfaceC1700x0) cVar.readObject();
        this.varActiveUuid = (J3.l) cVar.readObject();
        this.varActiveName = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        B4.e eVar;
        c1708z0.q(C2541R.string.stmt_cm_profile_title);
        if (2 > C4.a.f1771a) {
            Object systemService = c1708z0.getSystemService("profile");
            if (systemService == null) {
                throw new UnsupportedOperationException("No ProfileManager, CyanogenMod device required");
            }
            if (J1(1) != 0) {
                a aVar = new a();
                c1708z0.w(aVar);
                aVar.o(2, "android.intent.action.PROFILE_SELECTED");
                return false;
            }
            Object invoke = systemService.getClass().getMethod("getActiveProfile", new Class[0]).invoke(systemService, new Object[0]);
            if (invoke == null) {
                B(c1708z0, false, null, null);
            } else {
                C(c1708z0, H1.b.A(invoke).toString(), H1.b.z(invoke));
            }
            return true;
        }
        B4.h a8 = B4.h.a(c1708z0);
        if (J1(1) != 0) {
            b bVar = new b();
            c1708z0.w(bVar);
            bVar.o(2, "cyanogenmod.platform.intent.action.PROFILE_SELECTED");
            return false;
        }
        a8.getClass();
        try {
            eVar = B4.h.b().N1();
        } catch (RemoteException e8) {
            Log.e("ProfileManager", e8.getLocalizedMessage(), e8);
            eVar = null;
        }
        if (eVar == null) {
            B(c1708z0, false, null, null);
        } else {
            if (eVar.f445Z == null) {
                eVar.f445Z = UUID.randomUUID();
            }
            C(c1708z0, eVar.f445Z.toString(), eVar.f443X);
        }
        return true;
    }
}
