package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.llamalab.automate.BluetoothDevicePickActivity;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.field.SpinnerExprField;
import com.llamalab.automate.field.TextExprField;

/* renamed from: com.llamalab.automate.stmt.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC1656m extends C2 implements View.OnClickListener {

    /* renamed from: L1, reason: collision with root package name */
    public TextExprField f17470L1;

    /* renamed from: M1, reason: collision with root package name */
    public SpinnerExprField f17471M1;

    /* renamed from: y1, reason: collision with root package name */
    public TextExprField f17472y1;

    @Override // com.llamalab.automate.C2, com.llamalab.automate.C1563d0, androidx.fragment.app.Fragment
    public final void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 != 1) {
            super.onActivityResult(i8, i9, intent);
            return;
        }
        if (-1 == i9) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            TextExprField textExprField = this.f17472y1;
            if (textExprField != null) {
                textExprField.setValue((InterfaceC1700x0) L3.W.b(bluetoothDevice.getAddress()));
            }
            TextExprField textExprField2 = this.f17470L1;
            if (textExprField2 != null) {
                textExprField2.setValue((InterfaceC1700x0) L3.W.b(bluetoothDevice.getName()));
            }
            if (this.f17471M1 != null) {
                BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
                this.f17471M1.setValue((InterfaceC1700x0) (bluetoothClass != null ? new L3.J(bluetoothClass.getDeviceClass()) : null));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() != C2541R.id.pick_device) {
            return;
        }
        startActivityForResult(new Intent(o(), (Class<?>) BluetoothDevicePickActivity.class), 1);
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f17472y1 = (TextExprField) view.findViewById(C2541R.id.device_address);
        this.f17470L1 = (TextExprField) view.findViewById(C2541R.id.device_name);
        this.f17471M1 = (SpinnerExprField) view.findViewById(C2541R.id.device_class);
        ((Button) view.findViewById(C2541R.id.pick_device)).setOnClickListener(this);
    }
}
