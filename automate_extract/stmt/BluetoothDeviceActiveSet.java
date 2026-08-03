package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("bluetooth_device_active_set.html")
@F3.a(C2541R.integer.ic_device_access_bluetooth_sco)
@F3.i(C2541R.string.stmt_bluetooth_device_active_set_title)
@F3.h(C2541R.string.stmt_bluetooth_device_active_set_summary)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_bluetooth_device_active_set_edit)
/* loaded from: classes.dex */
public final class BluetoothDeviceActiveSet extends Decision implements AsyncStatement {
    public InterfaceC1700x0 deviceAddress;
    public InterfaceC1700x0 deviceName;
    public InterfaceC1700x0 profile;

    public static final class a extends AbstractRunnableC1658n {

        /* renamed from: N1, reason: collision with root package name */
        public final String f16335N1;

        /* renamed from: O1, reason: collision with root package name */
        public final String f16336O1;

        public a(String str, String str2) {
            this.f16335N1 = str;
            this.f16336O1 = str2;
        }

        @Override // com.llamalab.automate.stmt.AbstractRunnableC1658n, android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceConnected(int i8, BluetoothProfile bluetoothProfile) {
            BluetoothDevice u8;
            boolean z7;
            super.onServiceConnected(i8, bluetoothProfile);
            try {
                String str = this.f16335N1;
                String str2 = this.f16336O1;
                if (str == null && str2 == null) {
                    u8 = null;
                } else {
                    u8 = H1.b.u(this.f17477y1, str, str2);
                    if (u8 == null) {
                        z7 = false;
                        q2(Boolean.valueOf(z7), false);
                    }
                }
                z7 = ((Boolean) bluetoothProfile.getClass().getMethod("setActiveDevice", BluetoothDevice.class).invoke(bluetoothProfile, u8)).booleanValue();
                q2(Boolean.valueOf(z7), false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static final class b extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final String f16337M1;

        /* renamed from: N1, reason: collision with root package name */
        public final String f16338N1;

        /* renamed from: O1, reason: collision with root package name */
        public final int f16339O1;

        public b(int i8, String str, String str2) {
            this.f16337M1 = str;
            this.f16338N1 = str2;
            this.f16339O1 = i8;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            BluetoothDevice u8;
            boolean z7;
            String str = this.f16338N1;
            String str2 = this.f16337M1;
            if (str2 == null && str == null) {
                u8 = null;
            } else {
                try {
                    u8 = H1.b.u(AbstractStatement.h(this.f15400Y), str2, str);
                    if (u8 == null) {
                        z7 = false;
                        q2(Boolean.valueOf(z7), false);
                    }
                } catch (Throwable th) {
                    r2(th);
                    return;
                }
            }
            t3.l lVar = new t3.l();
            z7 = interfaceC1585h1.Q(this.f16339O1, u8, lVar);
            lVar.c();
            q2(Boolean.valueOf(z7), false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 31 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH"), com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN"), com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH"), com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_bluetooth_device_active_set);
        l8.v(this.deviceAddress, 0);
        l8.v(this.deviceName, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.profile);
        dVar.g(this.deviceAddress);
        dVar.g(this.deviceName);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.profile);
        visitor.b(this.deviceAddress);
        visitor.b(this.deviceName);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1656m();
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.profile = (InterfaceC1700x0) cVar.readObject();
        this.deviceAddress = (InterfaceC1700x0) cVar.readObject();
        this.deviceName = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_bluetooth_device_active_set_title);
        IncapableAndroidVersionException.a(28);
        int m8 = J3.h.m(c1708z0, this.profile, 1);
        String r8 = H1.b.r(c1708z0, this.deviceAddress);
        String x7 = J3.h.x(c1708z0, this.deviceName, null);
        BluetoothAdapter h8 = AbstractStatement.h(c1708z0);
        if (!h8.isEnabled()) {
            o(c1708z0, false);
            return true;
        }
        if (31 <= Build.VERSION.SDK_INT) {
            c1708z0.w(new b(m8, r8, x7));
        } else {
            a aVar = new a(r8, x7);
            c1708z0.w(aVar);
            aVar.v2(h8, m8);
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
