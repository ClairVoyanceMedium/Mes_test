package com.llamalab.automate.stmt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.field.SpinnerExprField;
import com.llamalab.automate.field.TextExprField;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class q1 extends C2 implements View.OnClickListener {

    /* renamed from: L1, reason: collision with root package name */
    public TextExprField f17501L1;

    /* renamed from: M1, reason: collision with root package name */
    public TextExprField f17502M1;

    /* renamed from: N1, reason: collision with root package name */
    public TextExprField f17503N1;

    /* renamed from: O1, reason: collision with root package name */
    public SpinnerExprField f17504O1;

    /* renamed from: P1, reason: collision with root package name */
    public TextExprField f17505P1;

    /* renamed from: Q1, reason: collision with root package name */
    public Button f17506Q1;

    /* renamed from: R1, reason: collision with root package name */
    public final a f17507R1 = new a();

    /* renamed from: y1, reason: collision with root package name */
    public TextExprField f17508y1;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.getClass();
            boolean equals = action.equals("android.hardware.usb.action.USB_DEVICE_ATTACHED");
            q1 q1Var = q1.this;
            if (equals) {
                q1Var.f17506Q1.setEnabled(true);
            } else if (action.equals("android.hardware.usb.action.USB_DEVICE_DETACHED")) {
                q1Var.f17506Q1.setEnabled(!q1Var.w().isEmpty());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String productName;
        String manufacturerName;
        if (view.getId() != C2541R.id.pick_device) {
            return;
        }
        Iterator<UsbDevice> it = w().iterator();
        if (!it.hasNext()) {
            this.f17506Q1.setEnabled(false);
            return;
        }
        UsbDevice next = it.next();
        this.f17508y1.setValue((InterfaceC1700x0) new L3.J(next.getProductId()));
        this.f17502M1.setValue((InterfaceC1700x0) new L3.J(next.getVendorId()));
        this.f17504O1.setValue((InterfaceC1700x0) new L3.J(next.getDeviceClass()));
        this.f17505P1.setValue((InterfaceC1700x0) new L3.J(next.getDeviceSubclass()));
        if (21 <= Build.VERSION.SDK_INT) {
            TextExprField textExprField = this.f17501L1;
            productName = next.getProductName();
            textExprField.setValue((InterfaceC1700x0) L3.W.b(productName));
            TextExprField textExprField2 = this.f17503N1;
            manufacturerName = next.getManufacturerName();
            textExprField2.setValue((InterfaceC1700x0) L3.W.b(manufacturerName));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        try {
            getContext().unregisterReceiver(this.f17507R1);
        } catch (Throwable unused) {
        }
    }

    @Override // com.llamalab.automate.C2, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f17508y1 = (TextExprField) view.findViewById(C2541R.id.device_product_id);
        this.f17501L1 = (TextExprField) view.findViewById(C2541R.id.device_product_name);
        this.f17502M1 = (TextExprField) view.findViewById(C2541R.id.device_vendor_id);
        this.f17503N1 = (TextExprField) view.findViewById(C2541R.id.device_manufacturer_id);
        this.f17504O1 = (SpinnerExprField) view.findViewById(C2541R.id.device_class);
        this.f17505P1 = (TextExprField) view.findViewById(C2541R.id.device_subclass);
        Button button = (Button) view.findViewById(C2541R.id.pick_device);
        this.f17506Q1 = button;
        button.setOnClickListener(this);
        this.f17506Q1.setEnabled(!w().isEmpty());
        IntentFilter intentFilter = new IntentFilter("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        requireContext().registerReceiver(this.f17507R1, intentFilter);
    }

    public final Collection<UsbDevice> w() {
        HashMap<String, UsbDevice> deviceList;
        UsbManager usbManager = (UsbManager) getContext().getSystemService("usb");
        return (usbManager == null || (deviceList = usbManager.getDeviceList()) == null) ? Collections.emptySet() : deviceList.values();
    }
}
