package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("bluetooth_device_bond_remove.html")
@F3.a(C2541R.integer.ic_device_access_bluetooth_searching)
@F3.i(C2541R.string.stmt_bluetooth_device_bond_remove_title)
@F3.h(C2541R.string.stmt_bluetooth_device_bond_remove_summary)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_bluetooth_device_bond_remove_edit)
/* loaded from: classes.dex */
public final class BluetoothDeviceBondRemove extends Decision {
    public InterfaceC1700x0 deviceAddress;
    public InterfaceC1700x0 deviceName;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 31 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_CONNECT")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH"), com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_bluetooth_device_bond_remove);
        l8.v(this.deviceAddress, 0);
        l8.v(this.deviceName, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.deviceAddress);
        dVar.g(this.deviceName);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
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
        this.deviceAddress = (InterfaceC1700x0) cVar.readObject();
        this.deviceName = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_bluetooth_device_bond_remove_title);
        String r8 = H1.b.r(c1708z0, this.deviceAddress);
        String x7 = J3.h.x(c1708z0, this.deviceName, null);
        BluetoothAdapter h8 = AbstractStatement.h(c1708z0);
        if (!h8.isEnabled()) {
            throw new IllegalStateException("Bluetooth disabled");
        }
        BluetoothDevice u8 = H1.b.u(h8, r8, x7);
        if (u8 == null) {
            o(c1708z0, false);
            return true;
        }
        if (10 == u8.getBondState()) {
            o(c1708z0, true);
            return true;
        }
        o(c1708z0, ((Boolean) BluetoothDevice.class.getMethod("removeBond", new Class[0]).invoke(u8, new Object[0])).booleanValue());
        return true;
    }
}
