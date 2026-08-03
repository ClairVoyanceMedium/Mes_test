package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Build;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("bluetooth_device_disconnect.html")
@F3.a(C2541R.integer.ic_device_access_bluetooth_searching)
@F3.i(C2541R.string.stmt_bluetooth_device_disconnect_title)
@F3.h(C2541R.string.stmt_bluetooth_device_disconnect_summary)
@F3.e(C2541R.layout.stmt_bluetooth_device_disconnect_edit)
/* loaded from: classes.dex */
public final class BluetoothDeviceDisconnect extends Action implements AsyncStatement {
    public InterfaceC1700x0 deviceAddress;
    public InterfaceC1700x0 deviceName;
    public InterfaceC1700x0 profile;

    public static final class a extends AbstractRunnableC1658n {

        /* renamed from: N1, reason: collision with root package name */
        public final String f16350N1;

        /* renamed from: O1, reason: collision with root package name */
        public final String f16351O1;

        public a(String str, String str2) {
            this.f16350N1 = str;
            this.f16351O1 = str2;
        }

        @Override // com.llamalab.automate.stmt.AbstractRunnableC1658n, android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceConnected(int i8, BluetoothProfile bluetoothProfile) {
            super.onServiceConnected(i8, bluetoothProfile);
            try {
                BluetoothDevice u8 = H1.b.u(this.f17477y1, this.f16350N1, this.f16351O1);
                if (u8 != null) {
                    if (6 != i8 || 28 <= Build.VERSION.SDK_INT) {
                        bluetoothProfile.getClass().getMethod("disconnect", BluetoothDevice.class).invoke(bluetoothProfile, u8);
                    } else {
                        bluetoothProfile.getClass().getMethod("disconnect", new Class[0]).invoke(bluetoothProfile, new Object[0]);
                    }
                }
                p2(null);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 31 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_CONNECT")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH"), com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 q8 = D1.P.l(context, C2541R.string.caption_bluetooth_device_disconnect).e(this.profile, null, C2541R.xml.bluetooth_disconnect_profiles).q(this.profile);
        q8.v(this.deviceAddress, 0);
        q8.v(this.deviceName, 0);
        return q8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.profile);
        dVar.g(this.deviceAddress);
        dVar.g(this.deviceName);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.profile);
        visitor.b(this.deviceAddress);
        visitor.b(this.deviceName);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1656m();
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.profile = (InterfaceC1700x0) cVar.readObject();
        this.deviceAddress = (InterfaceC1700x0) cVar.readObject();
        this.deviceName = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_bluetooth_device_disconnect_title);
        int m8 = J3.h.m(c1708z0, this.profile, 1);
        String r8 = H1.b.r(c1708z0, this.deviceAddress);
        String x7 = J3.h.x(c1708z0, this.deviceName, null);
        BluetoothAdapter h8 = AbstractStatement.h(c1708z0);
        if (!h8.isEnabled()) {
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        a aVar = new a(r8, x7);
        c1708z0.w(aVar);
        aVar.v2(h8, m8);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
