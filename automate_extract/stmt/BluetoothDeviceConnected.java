package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.BluetoothDeviceReceiver;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import java.util.Collections;
import java.util.Map;

@F3.f("bluetooth_device_connected.html")
@F3.a(C2541R.integer.ic_device_access_bluetooth_connected)
@F3.i(C2541R.string.stmt_bluetooth_device_connected_title)
@F3.h(C2541R.string.stmt_bluetooth_device_connected_summary)
@F3.e(C2541R.layout.stmt_bluetooth_device_connected_edit)
/* loaded from: classes.dex */
public final class BluetoothDeviceConnected extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 deviceAddress;
    public InterfaceC1700x0 deviceClass;
    public InterfaceC1700x0 deviceName;
    public InterfaceC1700x0 pairedOnly;
    public J3.l varConnectedDeviceAddress;
    public J3.l varConnectedDeviceClass;
    public J3.l varConnectedDeviceName;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public final Integer f16345L1;

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f16346M1;

        /* renamed from: N1, reason: collision with root package name */
        public boolean f16347N1;

        /* renamed from: x1, reason: collision with root package name */
        public final String f16348x1;

        /* renamed from: y1, reason: collision with root package name */
        public final String f16349y1;

        public a(String str, String str2, Integer num, boolean z7, boolean z8) {
            this.f16348x1 = str;
            this.f16349y1 = str2;
            this.f16345L1 = num;
            this.f16346M1 = z7;
            this.f16347N1 = z8;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Integer num;
            char c8;
            String action = intent.getAction();
            boolean equals = "android.bluetooth.adapter.action.STATE_CHANGED".equals(action);
            String str = this.f16349y1;
            String str2 = this.f16348x1;
            if (equals) {
                if (10 == intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1) && this.f16347N1) {
                    this.f16347N1 = false;
                    c(intent, new Object[]{Boolean.FALSE, str2, str, null}, false);
                    return;
                }
                return;
            }
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null) {
                String address = bluetoothDevice.getAddress();
                String name = bluetoothDevice.getName();
                Integer C7 = BluetoothDeviceConnected.C(bluetoothDevice);
                if ((str2 == null || str2.equalsIgnoreCase(address)) && (str == null || str.equals(name)) && ((num = this.f16345L1) == null || num.equals(C7))) {
                    action.getClass();
                    switch (action.hashCode()) {
                        case -301431627:
                            if (action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
                                c8 = 0;
                                break;
                            }
                            c8 = 65535;
                            break;
                        case 1821585647:
                            if (action.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
                                c8 = 1;
                                break;
                            }
                            c8 = 65535;
                            break;
                        case 2116862345:
                            if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                                c8 = 2;
                                break;
                            }
                            c8 = 65535;
                            break;
                        default:
                            c8 = 65535;
                            break;
                    }
                    boolean z7 = this.f16346M1;
                    switch (c8) {
                        case 0:
                            this.f16347N1 = true;
                            if (!z7 || 12 == bluetoothDevice.getBondState()) {
                                c(intent, new Object[]{Boolean.TRUE, address, name, C7}, false);
                                break;
                            }
                            break;
                        case 1:
                            this.f16347N1 = false;
                            c(intent, new Object[]{Boolean.FALSE, address, name, C7}, false);
                            break;
                        case 2:
                            if (z7) {
                                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
                                if (intExtra == 10) {
                                    c(intent, new Object[]{Boolean.FALSE, address, name, C7}, false);
                                    break;
                                } else if (intExtra == 12) {
                                    c(intent, new Object[]{Boolean.TRUE, address, name, C7}, false);
                                    break;
                                }
                            }
                            break;
                    }
                }
            }
        }
    }

    public static Integer C(BluetoothDevice bluetoothDevice) {
        BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
        if (bluetoothClass != null) {
            return Integer.valueOf(bluetoothClass.getDeviceClass());
        }
        return null;
    }

    public final void B(C1708z0 c1708z0, boolean z7, String str, String str2, Integer num) {
        J3.l lVar = this.varConnectedDeviceAddress;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varConnectedDeviceName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str2);
        }
        J3.l lVar3 = this.varConnectedDeviceClass;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, num != null ? Double.valueOf(num.doubleValue()) : null);
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 31 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_CONNECT")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_bluetooth_device_connected_immediate, C2541R.string.caption_bluetooth_device_connected_change);
        c1596k0.v(this.deviceAddress, 0);
        c1596k0.v(this.deviceName, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (String) objArr[1], (String) objArr[2], (Integer) objArr[3]);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.deviceAddress);
        dVar.g(this.deviceName);
        if (39 <= dVar.f6413Z) {
            dVar.g(this.deviceClass);
        }
        dVar.g(this.pairedOnly);
        dVar.g(this.varConnectedDeviceAddress);
        dVar.g(this.varConnectedDeviceName);
        if (39 <= dVar.f6413Z) {
            dVar.g(this.varConnectedDeviceClass);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.deviceAddress);
        visitor.b(this.deviceName);
        visitor.b(this.deviceClass);
        visitor.b(this.pairedOnly);
        visitor.b(this.varConnectedDeviceAddress);
        visitor.b(this.varConnectedDeviceName);
        visitor.b(this.varConnectedDeviceClass);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1656m();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.deviceAddress = (InterfaceC1700x0) cVar.readObject();
        this.deviceName = (InterfaceC1700x0) cVar.readObject();
        if (39 <= cVar.f6409x0) {
            this.deviceClass = (InterfaceC1700x0) cVar.readObject();
        }
        this.pairedOnly = (InterfaceC1700x0) cVar.readObject();
        this.varConnectedDeviceAddress = (J3.l) cVar.readObject();
        this.varConnectedDeviceName = (J3.l) cVar.readObject();
        if (39 <= cVar.f6409x0) {
            this.varConnectedDeviceClass = (J3.l) cVar.readObject();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        Map<String, ?> emptyMap;
        boolean z7;
        String str;
        Integer num;
        String str2;
        boolean z8;
        boolean z9;
        c1708z0.q(C2541R.string.stmt_bluetooth_device_connected_title);
        String r8 = H1.b.r(c1708z0, this.deviceAddress);
        String x7 = J3.h.x(c1708z0, this.deviceName, null);
        Integer o6 = J3.h.o(c1708z0, this.deviceClass, null);
        boolean f8 = J3.h.f(c1708z0, this.pairedOnly, false);
        boolean z10 = J1(1) == 0;
        BluetoothAdapter h8 = AbstractStatement.h(c1708z0);
        boolean isEnabled = h8.isEnabled();
        int i8 = BluetoothDeviceReceiver.f14723a;
        SharedPreferences sharedPreferences = c1708z0.getSharedPreferences("btdevices_preference", 0);
        if (isEnabled) {
            emptyMap = sharedPreferences.getAll();
        } else {
            sharedPreferences.edit().clear().apply();
            emptyMap = Collections.emptyMap();
        }
        if (r8 != null) {
            BluetoothDevice remoteDevice = h8.getRemoteDevice(r8);
            Integer C7 = C(remoteDevice);
            if (!emptyMap.containsKey(r8) || (!(o6 == null || o6.equals(C7)) || (f8 && 12 != remoteDevice.getBondState()))) {
                z9 = false;
            } else if (z10) {
                str = r8;
                str2 = x7;
                num = C7;
                z8 = true;
            } else {
                z9 = true;
            }
            z7 = z9;
            if (z10) {
                a aVar = new a(r8, x7, o6, f8, z7);
                c1708z0.w(aVar);
                aVar.j("android.bluetooth.device.action.ACL_CONNECTED", "android.bluetooth.device.action.ACL_DISCONNECTED", "android.bluetooth.device.action.BOND_STATE_CHANGED", "android.bluetooth.adapter.action.STATE_CHANGED");
                return false;
            }
            num = null;
            str = r8;
            str2 = x7;
            z8 = false;
        } else {
            for (Map.Entry<String, ?> entry : emptyMap.entrySet()) {
                BluetoothDevice remoteDevice2 = h8.getRemoteDevice(entry.getKey());
                if (x7 == null || x7.equals(entry.getValue()) || x7.equals(remoteDevice2.getName())) {
                    Integer C8 = C(remoteDevice2);
                    if ((o6 == null || o6.equals(C8)) && (!f8 || 12 == remoteDevice2.getBondState())) {
                        if (z10) {
                            String address = remoteDevice2.getAddress();
                            String name = remoteDevice2.getName();
                            String str3 = (String) entry.getValue();
                            if (name == null) {
                                name = str3;
                            }
                            str = address;
                            num = C8;
                            str2 = name;
                            z8 = true;
                        } else {
                            z7 = true;
                            if (z10) {
                            }
                        }
                    }
                    z7 = false;
                    if (z10) {
                    }
                }
            }
            z7 = false;
            if (z10) {
            }
        }
        B(c1708z0, z8, str, str2, num);
        return true;
    }
}
