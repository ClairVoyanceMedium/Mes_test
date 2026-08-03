package com.llamalab.automate.stmt;

import L3.C1060z;
import android.R;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.llamalab.automate.C1617p1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.K1;
import com.llamalab.automate.Visitor;
import m3.C2146d;

@F3.b(C2541R.layout.block_try)
@F3.a(C2541R.integer.ic_shortcut)
/* loaded from: classes.dex */
abstract class ShortcutDecision extends IntentDecision {
    public InterfaceC1700x0 iconStyle;
    public InterfaceC1700x0 iconUri;
    public InterfaceC1700x0 label;

    public final String B(C1708z0 c1708z0, ActivityInfo activityInfo) {
        String x7 = J3.h.x(c1708z0, this.label, null);
        return !TextUtils.isEmpty(x7) ? x7 : activityInfo != null ? activityInfo.loadLabel(c1708z0.getPackageManager()).toString() : c1708z0.getString(C2541R.string.untitled);
    }

    @Override // com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.label);
        dVar.g(this.iconUri);
        if (99 <= dVar.f6413Z) {
            dVar.g(this.iconStyle);
        }
    }

    @Override // com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.label);
        visitor.b(this.iconUri);
        visitor.b(this.iconStyle);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return ViewOnClickListenerC1667s.w(null, 1);
    }

    @Override // com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.label = (InterfaceC1700x0) cVar.readObject();
        if (99 <= cVar.f6409x0) {
            this.iconUri = (InterfaceC1700x0) cVar.readObject();
            this.iconStyle = (InterfaceC1700x0) cVar.readObject();
        } else {
            InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
            this.iconUri = N.a(interfaceC1700x0);
            this.iconStyle = interfaceC1700x0 instanceof J3.k ? new L3.J(J3.h.J(interfaceC1700x0)) : interfaceC1700x0 != null ? new C1060z(new C1060z(interfaceC1700x0)) : null;
        }
    }

    public final Icon z(C1708z0 c1708z0, ActivityInfo activityInfo, boolean z7) {
        ApplicationInfo applicationInfo;
        int i8;
        int i9;
        Uri g8 = J3.h.g(c1708z0, this.iconUri, null);
        boolean f8 = J3.h.f(c1708z0, this.iconStyle, false);
        try {
        } catch (Resources.NotFoundException e8) {
            Log.w("ShortcutDecision", "Missing icon resource", e8);
        } catch (Exception e9) {
            e = e9;
            Log.w("ShortcutDecision", "Failed to load icon", e);
            if (z7) {
                K1 g12 = c1708z0.g1();
                long j8 = c1708z0.f17644y0;
                long g9 = c1708z0.g();
                while (true) {
                    Throwable cause = e.getCause();
                    if (cause == null) {
                        break;
                    }
                    e = cause;
                }
                g12.g(j8, g9, "W", e.toString());
            }
        }
        if (g8 != null) {
            return C1617p1.u(c1708z0).v(f8, g8);
        }
        if (activityInfo != null && (i9 = activityInfo.icon) != 0) {
            return C2146d.a(i9, c1708z0, activityInfo.packageName);
        }
        if (activityInfo != null && (i8 = (applicationInfo = activityInfo.applicationInfo).icon) != 0) {
            return C2146d.a(i8, c1708z0, applicationInfo.packageName);
        }
        return C2146d.a(R.drawable.sym_def_app_icon, c1708z0, "android");
    }
}
