package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import x3.C2440r;

@F3.f("bluetooth_device_bond_create.html")
@F3.a(C2541R.integer.ic_device_access_bluetooth_searching)
@F3.i(C2541R.string.stmt_bluetooth_device_bond_create_title)
@F3.h(C2541R.string.stmt_bluetooth_device_bond_create_summary)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_bluetooth_device_bond_create_edit)
/* loaded from: classes.dex */
public final class BluetoothDeviceBondCreate extends Decision implements ReceiverStatement {
    public InterfaceC1700x0 deviceAddress;
    public InterfaceC1700x0 deviceName;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final BluetoothDevice f16340x1;

        public a(BluetoothDevice bluetoothDevice) {
            this.f16340x1 = bluetoothDevice;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Boolean bool;
            if (C2440r.h(this.f16340x1, (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"))) {
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 10);
                if (intExtra == 10) {
                    bool = Boolean.FALSE;
                } else if (intExtra != 12) {
                    return;
                } else {
                    bool = Boolean.TRUE;
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
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_bluetooth_device_bond_create);
        l8.v(this.deviceAddress, 0);
        l8.v(this.deviceName, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
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
        boolean createBond;
        c1708z0.q(C2541R.string.stmt_bluetooth_device_bond_create_title);
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
        if (12 == u8.getBondState()) {
            o(c1708z0, true);
            return true;
        }
        a aVar = new a(u8);
        c1708z0.w(aVar);
        AbstractC1618p2 h9 = aVar.h("android.bluetooth.device.action.BOND_STATE_CHANGED");
        try {
            createBond = u8.createBond();
            if (createBond) {
                return false;
            }
            h9.a();
            o(c1708z0, false);
            return true;
        } catch (Throwable th) {
            h9.a();
            throw th;
        }
    }
}
