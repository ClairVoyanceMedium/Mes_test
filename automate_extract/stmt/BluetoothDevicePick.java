package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import com.llamalab.automate.BluetoothDevicePickActivity;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("bluetooth_device_pick.html")
@F3.a(C2541R.integer.ic_device_access_bluetooth_select)
@F3.i(C2541R.string.stmt_bluetooth_device_pick_title)
@F3.h(C2541R.string.stmt_bluetooth_device_pick_summary)
@F3.c(C2541R.string.caption_bluetooth_device_pick)
@F3.e(C2541R.layout.stmt_bluetooth_device_pick_edit)
/* loaded from: classes.dex */
public final class BluetoothDevicePick extends ActivityDecision {
    public InterfaceC1700x0 deviceClass;
    public InterfaceC1700x0 pairedOnly;
    public J3.l varDeviceAddress;
    public J3.l varDeviceClass;
    public J3.l varDeviceName;

    public final void C(C1708z0 c1708z0, boolean z7, String str, String str2, Double d8) {
        J3.l lVar = this.varDeviceName;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varDeviceAddress;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str2);
        }
        J3.l lVar3 = this.varDeviceClass;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d8);
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (39 <= dVar.f6413Z) {
            dVar.g(this.deviceClass);
        }
        if (108 <= dVar.f6413Z) {
            dVar.g(this.pairedOnly);
        }
        dVar.g(this.varDeviceName);
        dVar.g(this.varDeviceAddress);
        if (39 <= dVar.f6413Z) {
            dVar.g(this.varDeviceClass);
        }
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.deviceClass);
        visitor.b(this.pairedOnly);
        visitor.b(this.varDeviceName);
        visitor.b(this.varDeviceAddress);
        visitor.b(this.varDeviceClass);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (39 <= cVar.f6409x0) {
            this.deviceClass = (InterfaceC1700x0) cVar.readObject();
        }
        if (108 <= cVar.f6409x0) {
            this.pairedOnly = (InterfaceC1700x0) cVar.readObject();
        }
        this.varDeviceName = (J3.l) cVar.readObject();
        this.varDeviceAddress = (J3.l) cVar.readObject();
        if (39 <= cVar.f6409x0) {
            this.varDeviceClass = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            C(c1708z0, false, null, null, null);
            return;
        }
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        C(c1708z0, true, bluetoothDevice.getName(), bluetoothDevice.getAddress(), bluetoothDevice.getBluetoothClass() != null ? Double.valueOf(r15.getDeviceClass()) : null);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_bluetooth_device_pick_title);
        int intValue = J3.h.o(c1708z0, this.deviceClass, 0).intValue();
        c1708z0.D(new Intent("android.intent.action.PICK", null, c1708z0, BluetoothDevicePickActivity.class).putExtra("com.llamalab.automate.intent.extra.DEVICE_CLASS", intValue).putExtra("com.llamalab.automate.intent.extra.BONDED_ONLY", J3.h.f(c1708z0, this.pairedOnly, false)), null, this, c1708z0.f(C2541R.integer.ic_device_access_bluetooth_select), c1708z0.getText(C2541R.string.stmt_bluetooth_device_pick_title));
        return false;
    }
}
