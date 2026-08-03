package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Build;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import java.util.regex.Pattern;

@F3.f("usb_tether_enabled.html")
@F3.a(C2541R.integer.ic_device_access_usb_tether)
@F3.i(C2541R.string.stmt_usb_tether_enabled_title)
@F3.h(C2541R.string.stmt_usb_tether_enabled_summary)
@F3.c(C2541R.string.caption_usb_tether_enabled)
@F3.e(C2541R.layout.stmt_usb_tether_enabled_edit)
/* loaded from: classes.dex */
public class UsbTetherEnabled extends Decision {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE")};
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        String[] strArr;
        c1708z0.q(C2541R.string.stmt_usb_tether_enabled_title);
        ConnectivityManager connectivityManager = (ConnectivityManager) c1708z0.getSystemService("connectivity");
        if (24 <= Build.VERSION.SDK_INT) {
            Resources resources = c1708z0.getResources();
            int identifier = resources.getIdentifier("config_tether_usb_regexs", "array", "android");
            if (identifier == 0) {
                throw new IllegalStateException("Resource not found: config_tether_usb_regexs");
            }
            strArr = resources.getStringArray(identifier);
        } else {
            strArr = (String[]) connectivityManager.getClass().getMethod("getTetherableUsbRegexs", new Class[0]).invoke(connectivityManager, new Object[0]);
        }
        String[] strArr2 = (String[]) connectivityManager.getClass().getMethod("getTetheredIfaces", new Class[0]).invoke(connectivityManager, new Object[0]);
        if (strArr != null && strArr2 != null) {
            for (String str : strArr) {
                Pattern compile = Pattern.compile(str);
                for (String str2 : strArr2) {
                    if (compile.matcher(str2).matches()) {
                        o(c1708z0, true);
                        return true;
                    }
                }
            }
        }
        o(c1708z0, false);
        return true;
    }
}
