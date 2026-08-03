package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("bluetooth_device_connect.html")
@F3.a(C2541R.integer.ic_device_access_bluetooth_searching)
@F3.i(C2541R.string.stmt_bluetooth_device_connect_title)
@F3.h(C2541R.string.stmt_bluetooth_device_connect_summary)
@F3.e(C2541R.layout.stmt_bluetooth_device_connect_edit)
/* loaded from: classes.dex */
public final class BluetoothDeviceConnect extends IntermittentDecision implements AsyncStatement, ReceiverStatement {
    public InterfaceC1700x0 deviceAddress;
    public InterfaceC1700x0 deviceName;
    public InterfaceC1700x0 profile;

    public static final class a extends AbstractRunnableC1658n {

        /* renamed from: N1, reason: collision with root package name */
        public final String f16341N1;

        /* renamed from: O1, reason: collision with root package name */
        public final String f16342O1;

        /* renamed from: P1, reason: collision with root package name */
        public final boolean f16343P1;

        public a(String str, String str2, boolean z7) {
            this.f16341N1 = str;
            this.f16342O1 = str2;
            this.f16343P1 = z7;
        }

        @Override // com.llamalab.automate.stmt.AbstractRunnableC1658n, android.bluetooth.BluetoothProfile.ServiceListener
        public final void onServiceConnected(int i8, BluetoothProfile bluetoothProfile) {
            super.onServiceConnected(i8, bluetoothProfile);
            try {
                BluetoothDevice u8 = H1.b.u(this.f17477y1, this.f16341N1, this.f16342O1);
                if (u8 == null) {
                    q2(Boolean.FALSE, false);
                    return;
                }
                int connectionState = bluetoothProfile.getConnectionState(u8);
                if (connectionState != 1) {
                    if (connectionState == 2) {
                        q2(Boolean.TRUE, false);
                        return;
                    } else if (!((Boolean) bluetoothProfile.getClass().getMethod("connect", BluetoothDevice.class).invoke(bluetoothProfile, u8)).booleanValue()) {
                        q2(Boolean.FALSE, false);
                        return;
                    } else if (this.f16343P1) {
                        q2(Boolean.TRUE, false);
                        return;
                    }
                }
                if (i8 == 1) {
                    b bVar = new b(u8);
                    t2(bVar);
                    bVar.h("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                    a();
                    return;
                }
                if (i8 == 2) {
                    b bVar2 = new b(u8);
                    t2(bVar2);
                    bVar2.h("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
                    a();
                    return;
                }
                if (i8 == 4) {
                    b bVar3 = new b(u8);
                    t2(bVar3);
                    bVar3.o(2, "android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED");
                    a();
                    return;
                }
                if (i8 != 5) {
                    throw new IllegalArgumentException("Unsupported profile: " + i8);
                }
                b bVar4 = new b(u8);
                t2(bVar4);
                bVar4.o(2, "android.bluetooth.pan.profile.action.CONNECTION_STATE_CHANGED");
                a();
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static final class b extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final BluetoothDevice f16344x1;

        public b(BluetoothDevice bluetoothDevice) {
            this.f16344x1 = bluetoothDevice;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Boolean bool;
            if (this.f16344x1.equals(intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"))) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                if (intExtra == 2) {
                    bool = Boolean.TRUE;
                } else if (intExtra != 3 || 1 != intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1)) {
                    return;
                } else {
                    bool = Boolean.FALSE;
                }
                c(intent, bool, false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 31 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_CONNECT")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH"), com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_bluetooth_device_connect_immediate, C2541R.string.caption_bluetooth_device_connect_connected);
        C1596k0 q8 = c1596k0.e(this.profile, null, C2541R.xml.bluetooth_connect_profiles).q(this.profile);
        q8.v(this.deviceAddress, 0);
        q8.v(this.deviceName, 0);
        return q8.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
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

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.profile = (InterfaceC1700x0) cVar.readObject();
        this.deviceAddress = (InterfaceC1700x0) cVar.readObject();
        this.deviceName = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_bluetooth_device_connect_title);
        int m8 = J3.h.m(c1708z0, this.profile, 1);
        String r8 = H1.b.r(c1708z0, this.deviceAddress);
        String x7 = J3.h.x(c1708z0, this.deviceName, null);
        boolean z7 = J1(1) == 0;
        BluetoothAdapter h8 = AbstractStatement.h(c1708z0);
        if (!h8.isEnabled()) {
            throw new IllegalStateException("Bluetooth disabled");
        }
        a aVar = new a(r8, x7, z7);
        c1708z0.w(aVar);
        aVar.v2(h8, m8);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
