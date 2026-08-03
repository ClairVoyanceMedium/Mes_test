package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import x3.C2425c;

@F3.f("wifi_ap_set_state.html")
@F3.a(C2541R.integer.ic_wifi_access_point)
@F3.i(C2541R.string.stmt_wifi_ap_set_state_title)
@F3.h(C2541R.string.stmt_wifi_ap_set_state_summary)
@F3.e(C2541R.layout.stmt_wifi_ap_set_state_edit)
/* loaded from: classes.dex */
public final class WifiApSetState extends SetStateAction implements AsyncStatement {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        SharedPreferences c8 = C2425c.c(context);
        int i8 = c8.contains("wifiApWorkaround") ? c8.getInt("wifiApWorkaround", 0) : c8.getBoolean("suWifiApEnabled", false);
        if (i8 == 1) {
            return new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
        }
        if (i8 == 2 || i8 == 3) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CHANGE_WIFI_STATE"), com.llamalab.automate.access.c.f15550k};
        }
        int i9 = Build.VERSION.SDK_INT;
        return 23 <= i9 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CHANGE_WIFI_STATE"), com.llamalab.automate.access.c.f15561v} : 23 <= i9 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CHANGE_WIFI_STATE"), com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CHANGE_WIFI_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, true, C2541R.string.caption_wifi_ap_enable, C2541R.string.caption_wifi_ap_disable).r(C2541R.string.caption_wifi_ap_set_state).b(this.state).f16030c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        if (r3 != 3) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_wifi_ap_set_state_title);
        boolean q8 = q(c1708z0, true);
        String packageName = c1708z0.getPackageName();
        SharedPreferences c8 = C2425c.c(c1708z0);
        int i8 = c8.contains("wifiApWorkaround") ? c8.getInt("wifiApWorkaround", 0) : c8.getBoolean("suWifiApEnabled", false);
        if (i8 == 1) {
            c1708z0.w(q8 ? new j1(0) : new m1(0));
            return false;
        }
        if (i8 == 2) {
            if (27 <= Build.VERSION.SDK_INT && e1.c(c1708z0)) {
                packageName = "com.llamalab.automate.ext.settings";
                if (26 <= Build.VERSION.SDK_INT) {
                    WifiManager l8 = AbstractStatement.l(c1708z0);
                    l8.getClass().getMethod("setWifiApEnabled", WifiConfiguration.class, Boolean.TYPE).invoke(l8, null, Boolean.valueOf(q8));
                } else {
                    if (q8) {
                        c1708z0.w(new TetheringStartTask(0, packageName));
                        return false;
                    }
                    TetheringStartTask.v2(0, c1708z0, packageName);
                }
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
            if (com.llamalab.automate.access.c.f15550k.A(c1708z0)) {
                c1708z0.w(q8 ? new i1(0) : new l1(0));
                return false;
            }
            if (c1708z0.getPackageManager().checkSignatures(c1708z0.getPackageName(), "com.llamalab.automate.ext.tethering") == 0) {
                c1708z0.w(q8 ? new k1(0) : new n1(0));
                return false;
            }
            if (26 <= Build.VERSION.SDK_INT) {
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
