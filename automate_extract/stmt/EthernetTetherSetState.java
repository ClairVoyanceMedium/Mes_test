package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import x3.C2425c;

@F3.f("ethernet_tether_set_state.html")
@F3.a(C2541R.integer.ic_settings_ethernet)
@F3.i(C2541R.string.stmt_ethernet_tether_set_state_title)
@F3.h(C2541R.string.stmt_ethernet_tether_set_state_summary)
@F3.e(C2541R.layout.stmt_ethernet_tether_set_state_edit)
/* loaded from: classes.dex */
public final class EthernetTetherSetState extends SetStateAction implements AsyncStatement {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        if (30 > Build.VERSION.SDK_INT) {
            return com.llamalab.automate.access.c.f15562w;
        }
        int i8 = C2425c.c(context).getInt("ethernetTetherWorkaround", 0);
        return i8 != 1 ? (i8 == 2 || i8 == 3) ? new E3.b[]{com.llamalab.automate.access.c.f15550k} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS")} : new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_ethernet_tether_enable, C2541R.string.caption_ethernet_tether_disable).r(C2541R.string.caption_ethernet_tether_set_state).b(this.state).f16030c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        if (r3 != 3) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_ethernet_tether_set_state_title);
        IncapableAndroidVersionException.a(30);
        if (c1708z0.getSystemService("ethernet") == null) {
            throw new IllegalStateException("No EthernetManager");
        }
        boolean q8 = q(c1708z0, true);
        String packageName = c1708z0.getPackageName();
        int i8 = C2425c.c(c1708z0).getInt("ethernetTetherWorkaround", 0);
        if (i8 == 1) {
            c1708z0.w(q8 ? new j1(5) : new m1(5));
            return false;
        }
        if (i8 == 2) {
            if (27 <= Build.VERSION.SDK_INT && e1.c(c1708z0)) {
                packageName = "com.llamalab.automate.ext.settings";
                if (!q8) {
                    c1708z0.w(new TetheringStartTask(5, packageName));
                    return false;
                }
                TetheringStartTask.v2(5, c1708z0, packageName);
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
            if (com.llamalab.automate.access.c.f15550k.A(c1708z0)) {
                c1708z0.w(q8 ? new i1(5) : new l1(5));
                return false;
            }
            if (c1708z0.getPackageManager().checkSignatures(c1708z0.getPackageName(), "com.llamalab.automate.ext.tethering") == 0) {
                c1708z0.w(q8 ? new k1(5) : new n1(5));
                return false;
            }
            if (!q8) {
            }
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
