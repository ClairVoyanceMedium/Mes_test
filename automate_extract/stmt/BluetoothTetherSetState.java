package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Build;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import x3.C2425c;

@F3.f("bluetooth_tether_set_state.html")
@F3.a(C2541R.integer.ic_device_access_bluetooth_tether)
@F3.i(C2541R.string.stmt_bluetooth_tether_set_state_title)
@F3.h(C2541R.string.stmt_bluetooth_tether_set_state_summary)
@F3.e(C2541R.layout.stmt_bluetooth_tether_set_state_edit)
/* loaded from: classes.dex */
public final class BluetoothTetherSetState extends SetStateAction implements AsyncStatement {

    public static final class a extends AbstractRunnableC1658n {

        /* renamed from: N1, reason: collision with root package name */
        public final boolean f16387N1;

        public a(boolean z7) {
            this.f16387N1 = z7;
        }

        @Override // com.llamalab.automate.stmt.AbstractRunnableC1658n, android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceConnected(int i8, BluetoothProfile bluetoothProfile) {
            super.onServiceConnected(i8, bluetoothProfile);
            try {
                bluetoothProfile.getClass().getMethod("setBluetoothTethering", Boolean.TYPE).invoke(bluetoothProfile, Boolean.valueOf(this.f16387N1));
                p2(null);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = C2425c.c(context).getInt("btTetherWorkaround", 0);
        if (i8 == 1) {
            return new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
        }
        if (i8 == 2 || i8 == 3) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN"), com.llamalab.automate.access.c.f15550k};
        }
        int i9 = Build.VERSION.SDK_INT;
        return 23 <= i9 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN"), com.llamalab.automate.access.c.f15561v} : 23 <= i9 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN"), com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_bluetooth_tether_enable, C2541R.string.caption_bluetooth_tether_disable).r(C2541R.string.caption_bluetooth_tether_set_state).b(this.state).f16030c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
    
        if (r3 != 3) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_bluetooth_tether_set_state_title);
        boolean q8 = q(c1708z0, false);
        String packageName = c1708z0.getPackageName();
        int i8 = C2425c.c(c1708z0).getInt("btTetherWorkaround", 0);
        if (i8 == 1) {
            c1708z0.w(q8 ? new j1(2) : new m1(2));
            return false;
        }
        if (i8 == 2) {
            if (27 <= Build.VERSION.SDK_INT && e1.c(c1708z0)) {
                packageName = "com.llamalab.automate.ext.settings";
                if (26 > Build.VERSION.SDK_INT) {
                    if (q8) {
                        c1708z0.w(new TetheringStartTask(2, packageName));
                        return false;
                    }
                    TetheringStartTask.v2(2, c1708z0, packageName);
                    c1708z0.f17642x0 = this.onComplete;
                    return true;
                }
                BluetoothAdapter h8 = AbstractStatement.h(c1708z0);
                if (!h8.isEnabled()) {
                    throw new IllegalStateException("Bluetooth disabled");
                }
                a aVar = new a(q8);
                c1708z0.w(aVar);
                aVar.v2(h8, 5);
                return false;
            }
            if (com.llamalab.automate.access.c.f15550k.A(c1708z0)) {
                c1708z0.w(q8 ? new i1(2) : new l1(2));
                return false;
            }
            if (c1708z0.getPackageManager().checkSignatures(c1708z0.getPackageName(), "com.llamalab.automate.ext.tethering") == 0) {
                c1708z0.w(q8 ? new k1(2) : new n1(2));
                return false;
            }
            if (26 > Build.VERSION.SDK_INT) {
            }
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
