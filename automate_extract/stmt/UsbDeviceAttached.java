package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Build;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@F3.f("usb_device_attached.html")
@F3.a(C2541R.integer.ic_device_access_usb)
@F3.i(C2541R.string.stmt_usb_device_attached_title)
@F3.h(C2541R.string.stmt_usb_device_attached_summary)
@F3.e(C2541R.layout.stmt_usb_device_attached_edit)
/* loaded from: classes.dex */
public final class UsbDeviceAttached extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 deviceClass;
    public InterfaceC1700x0 deviceManufacturerName;
    public InterfaceC1700x0 deviceProductId;
    public InterfaceC1700x0 deviceProductName;
    public InterfaceC1700x0 deviceSubclass;
    public InterfaceC1700x0 deviceVendorId;
    public J3.l varAttachedDeviceClass;
    public J3.l varAttachedDeviceManufacturerName;
    public J3.l varAttachedDeviceProductId;
    public J3.l varAttachedDeviceProductName;
    public J3.l varAttachedDeviceSubclass;
    public J3.l varAttachedDeviceVendorId;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final b f17215x1;

        public a(b bVar) {
            this.f17215x1 = bVar;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
            if (this.f17215x1.a(usbDevice)) {
                c(intent, new Object[]{Boolean.valueOf("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(intent.getAction())), usbDevice}, false);
            }
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Integer f17216a;

        /* renamed from: b, reason: collision with root package name */
        public final String f17217b;

        /* renamed from: c, reason: collision with root package name */
        public final Integer f17218c;

        /* renamed from: d, reason: collision with root package name */
        public final String f17219d;

        /* renamed from: e, reason: collision with root package name */
        public final Integer f17220e;

        /* renamed from: f, reason: collision with root package name */
        public final Integer f17221f;

        public b(Integer num, String str, Integer num2, String str2, Integer num3, Integer num4) {
            this.f17216a = num;
            this.f17217b = str;
            this.f17218c = num2;
            this.f17219d = str2;
            this.f17220e = num3;
            this.f17221f = num4;
        }

        public final boolean a(UsbDevice usbDevice) {
            String manufacturerName;
            String productName;
            if (usbDevice == null) {
                return false;
            }
            int i8 = Build.VERSION.SDK_INT;
            Integer num = this.f17221f;
            Integer num2 = this.f17220e;
            String str = this.f17219d;
            Integer num3 = this.f17218c;
            String str2 = this.f17217b;
            Integer num4 = this.f17216a;
            if (21 > i8) {
                if ((num4 != null && num4.intValue() != usbDevice.getProductId()) || str2 != null) {
                    return false;
                }
                if ((num3 != null && num3.intValue() != usbDevice.getVendorId()) || str != null) {
                    return false;
                }
                if (num2 == null || num2.intValue() == usbDevice.getDeviceClass()) {
                    return num == null || num.intValue() == usbDevice.getDeviceSubclass();
                }
                return false;
            }
            if (num4 != null && num4.intValue() != usbDevice.getProductId()) {
                return false;
            }
            if (str2 != null) {
                productName = usbDevice.getProductName();
                if (!str2.equalsIgnoreCase(productName)) {
                    return false;
                }
            }
            if (num3 != null && num3.intValue() != usbDevice.getVendorId()) {
                return false;
            }
            if (str != null) {
                manufacturerName = usbDevice.getManufacturerName();
                if (!str.equalsIgnoreCase(manufacturerName)) {
                    return false;
                }
            }
            if (num2 == null || num2.intValue() == usbDevice.getDeviceClass()) {
                return num == null || num.intValue() == usbDevice.getDeviceSubclass();
            }
            return false;
        }
    }

    public final void B(C1708z0 c1708z0, boolean z7, UsbDevice usbDevice) {
        String productName;
        String manufacturerName;
        if (usbDevice == null) {
            C(c1708z0, z7, null, null, null, null, null, null);
            return;
        }
        if (21 > Build.VERSION.SDK_INT) {
            C(c1708z0, z7, Double.valueOf(usbDevice.getProductId()), null, Double.valueOf(usbDevice.getVendorId()), null, Double.valueOf(usbDevice.getDeviceClass()), Double.valueOf(usbDevice.getDeviceSubclass()));
            return;
        }
        Double valueOf = Double.valueOf(usbDevice.getProductId());
        productName = usbDevice.getProductName();
        Double valueOf2 = Double.valueOf(usbDevice.getVendorId());
        manufacturerName = usbDevice.getManufacturerName();
        C(c1708z0, z7, valueOf, productName, valueOf2, manufacturerName, Double.valueOf(usbDevice.getDeviceClass()), Double.valueOf(usbDevice.getDeviceSubclass()));
    }

    public final void C(C1708z0 c1708z0, boolean z7, Double d8, String str, Double d9, String str2, Double d10, Double d11) {
        J3.l lVar = this.varAttachedDeviceProductId;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        J3.l lVar2 = this.varAttachedDeviceProductName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str);
        }
        J3.l lVar3 = this.varAttachedDeviceVendorId;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d9);
        }
        J3.l lVar4 = this.varAttachedDeviceManufacturerName;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, str2);
        }
        J3.l lVar5 = this.varAttachedDeviceClass;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, d10);
        }
        J3.l lVar6 = this.varAttachedDeviceSubclass;
        if (lVar6 != null) {
            c1708z0.z(lVar6.f4659Y, d11);
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_usb_device_attached_immediate, C2541R.string.caption_usb_device_attached_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (UsbDevice) objArr[1]);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.deviceProductId);
        dVar.g(this.deviceProductName);
        dVar.g(this.deviceVendorId);
        dVar.g(this.deviceManufacturerName);
        dVar.g(this.deviceClass);
        dVar.g(this.deviceSubclass);
        dVar.g(this.varAttachedDeviceProductId);
        dVar.g(this.varAttachedDeviceProductName);
        dVar.g(this.varAttachedDeviceVendorId);
        dVar.g(this.varAttachedDeviceManufacturerName);
        dVar.g(this.varAttachedDeviceClass);
        dVar.g(this.varAttachedDeviceSubclass);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.deviceProductId);
        visitor.b(this.deviceProductName);
        visitor.b(this.deviceVendorId);
        visitor.b(this.deviceManufacturerName);
        visitor.b(this.deviceClass);
        visitor.b(this.deviceSubclass);
        visitor.b(this.varAttachedDeviceProductId);
        visitor.b(this.varAttachedDeviceProductName);
        visitor.b(this.varAttachedDeviceVendorId);
        visitor.b(this.varAttachedDeviceManufacturerName);
        visitor.b(this.varAttachedDeviceClass);
        visitor.b(this.varAttachedDeviceSubclass);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new q1();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.deviceProductId = (InterfaceC1700x0) cVar.readObject();
        this.deviceProductName = (InterfaceC1700x0) cVar.readObject();
        this.deviceVendorId = (InterfaceC1700x0) cVar.readObject();
        this.deviceManufacturerName = (InterfaceC1700x0) cVar.readObject();
        this.deviceClass = (InterfaceC1700x0) cVar.readObject();
        this.deviceSubclass = (InterfaceC1700x0) cVar.readObject();
        this.varAttachedDeviceProductId = (J3.l) cVar.readObject();
        this.varAttachedDeviceProductName = (J3.l) cVar.readObject();
        this.varAttachedDeviceVendorId = (J3.l) cVar.readObject();
        this.varAttachedDeviceManufacturerName = (J3.l) cVar.readObject();
        this.varAttachedDeviceClass = (J3.l) cVar.readObject();
        this.varAttachedDeviceSubclass = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_usb_device_attached_title);
        Integer o6 = J3.h.o(c1708z0, this.deviceProductId, null);
        String x7 = J3.h.x(c1708z0, this.deviceProductName, null);
        Integer o8 = J3.h.o(c1708z0, this.deviceVendorId, null);
        String x8 = J3.h.x(c1708z0, this.deviceManufacturerName, null);
        Integer o9 = J3.h.o(c1708z0, this.deviceClass, null);
        Integer o10 = J3.h.o(c1708z0, this.deviceSubclass, null);
        b bVar = new b(o6, x7, o8, x8, o9, o10);
        UsbManager usbManager = (UsbManager) c1708z0.getSystemService("usb");
        if (usbManager == null) {
            throw new UnsupportedOperationException("USB");
        }
        Object deviceList = usbManager.getDeviceList();
        Object emptyMap = Collections.emptyMap();
        if (deviceList == null) {
            deviceList = emptyMap;
        }
        HashMap<String, UsbDevice> hashMap = (Map) deviceList;
        if (J1(1) == 0) {
            for (UsbDevice usbDevice : hashMap.values()) {
                if (bVar.a(usbDevice)) {
                    B(c1708z0, true, usbDevice);
                    return true;
                }
            }
            B(c1708z0, false, null);
            return true;
        }
        if (o6 == null && x7 == null && o8 == null && x8 == null && o9 == null && o10 == null) {
            a aVar = new a(bVar);
            c1708z0.w(aVar);
            aVar.j("android.hardware.usb.action.USB_DEVICE_ATTACHED", "android.hardware.usb.action.USB_DEVICE_DETACHED");
            return false;
        }
        Iterator<UsbDevice> it = hashMap.values().iterator();
        while (it.hasNext()) {
            if (bVar.a(it.next())) {
                a aVar2 = new a(bVar);
                c1708z0.w(aVar2);
                aVar2.h("android.hardware.usb.action.USB_DEVICE_DETACHED");
                return false;
            }
        }
        a aVar3 = new a(bVar);
        c1708z0.w(aVar3);
        aVar3.h("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        return false;
    }
}
