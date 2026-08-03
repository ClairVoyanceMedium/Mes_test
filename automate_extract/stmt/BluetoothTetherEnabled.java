package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("bluetooth_tether_enabled.html")
@F3.a(C2541R.integer.ic_device_access_bluetooth_tether)
@F3.i(C2541R.string.stmt_bluetooth_tether_enabled_title)
@F3.h(C2541R.string.stmt_bluetooth_tether_enabled_summary)
@F3.c(C2541R.string.caption_bluetooth_tether_enabled)
@F3.e(C2541R.layout.stmt_bluetooth_tether_enabled_edit)
/* loaded from: classes.dex */
public class BluetoothTetherEnabled extends Decision implements AsyncStatement {

    public static final class a extends AbstractRunnableC1658n {
        @Override // com.llamalab.automate.stmt.AbstractRunnableC1658n, android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceConnected(int i8, BluetoothProfile bluetoothProfile) {
            super.onServiceConnected(i8, bluetoothProfile);
            try {
                q2(bluetoothProfile.getClass().getMethod("isTetheringOn", new Class[0]).invoke(bluetoothProfile, new Object[0]), false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH")};
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_bluetooth_tether_enabled_title);
        BluetoothAdapter h8 = AbstractStatement.h(c1708z0);
        if (!h8.isEnabled()) {
            o(c1708z0, false);
            return true;
        }
        a aVar = new a();
        c1708z0.w(aVar);
        aVar.v2(h8, 5);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
