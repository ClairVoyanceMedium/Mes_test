package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1699x;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.N2;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.expr.ConversionType;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import x3.C2434l;
import x3.C2440r;

@F3.f("bluetooth_device_scan.html")
@F3.a(C2541R.integer.ic_device_access_network_wifi_scan)
@F3.i(C2541R.string.stmt_bluetooth_device_scan_title)
@F3.h(C2541R.string.stmt_bluetooth_device_scan_summary)
@F3.e(C2541R.layout.stmt_bluetooth_device_scan_edit)
/* loaded from: classes.dex */
public final class BluetoothDeviceScan extends Action implements ReceiverStatement, AsyncStatement {
    public InterfaceC1700x0 connectableOnly;
    public InterfaceC1700x0 deviceClass;
    public InterfaceC1700x0 mode;
    public InterfaceC1700x0 pairedOnly;
    public J3.l varDeviceAddresses;
    public J3.l varDeviceAdvertisements;
    public J3.l varDeviceNames;
    public J3.l varDeviceRssis;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public boolean f16352L1;

        /* renamed from: x1, reason: collision with root package name */
        public final HashMap f16353x1 = new HashMap();

        /* renamed from: y1, reason: collision with root package name */
        public final BluetoothAdapter f16354y1;

        public a(BluetoothAdapter bluetoothAdapter) {
            this.f16354y1 = bluetoothAdapter;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            j("android.bluetooth.adapter.action.DISCOVERY_STARTED", "android.bluetooth.adapter.action.DISCOVERY_FINISHED", "android.bluetooth.device.action.FOUND", "android.bluetooth.device.action.NAME_CHANGED");
            BluetoothAdapter bluetoothAdapter = this.f16354y1;
            if (bluetoothAdapter != null && !bluetoothAdapter.startDiscovery()) {
                throw new IllegalStateException("Failed to start discovery, Bluetooth enabled?");
            }
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                boolean equals = "android.bluetooth.device.action.FOUND".equals(action);
                HashMap hashMap = this.f16353x1;
                if (!equals && !"android.bluetooth.device.action.NAME_CHANGED".equals(action)) {
                    if ("android.bluetooth.adapter.action.DISCOVERY_STARTED".equals(action)) {
                        hashMap.clear();
                        this.f16352L1 = true;
                        return;
                    } else {
                        if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                            if (this.f16352L1) {
                                c(intent, hashMap, false);
                                return;
                            }
                            BluetoothAdapter bluetoothAdapter = this.f16354y1;
                            if (bluetoothAdapter != null && !bluetoothAdapter.startDiscovery()) {
                                throw new IllegalStateException("Failed to start discovery, Bluetooth enabled?");
                            }
                            return;
                        }
                        return;
                    }
                }
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice != null) {
                    short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) 0);
                    double d8 = shortExtra == 0 ? Double.NEGATIVE_INFINITY : shortExtra;
                    e eVar = (e) hashMap.get(bluetoothDevice);
                    if (eVar == null || d8 < eVar.f16362X) {
                        hashMap.put(bluetoothDevice, new e(d8, null, false));
                    }
                }
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public static abstract class b extends com.llamalab.automate.W implements Runnable {

        /* renamed from: y1, reason: collision with root package name */
        public final HashMap f16356y1 = new HashMap();

        /* renamed from: L1, reason: collision with root package name */
        public long f16355L1 = Long.MAX_VALUE;

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            this.f16355L1 = SystemClock.elapsedRealtime() + 12000;
            automateService.f14581L1.postDelayed(this, 12000L);
        }

        @Override // java.lang.Runnable
        public final void run() {
            q2(this.f16356y1, false);
        }

        public final boolean v2(BluetoothDevice bluetoothDevice, int i8, byte[] bArr, boolean z7) {
            boolean z8 = this.f16356y1.put(bluetoothDevice, new e(i8 == 0 ? Double.NEGATIVE_INFINITY : (double) i8, bArr, z7)) == null;
            if (this.f16355L1 < SystemClock.elapsedRealtime()) {
                return true;
            }
            if (z8) {
                Handler handler = this.f15400Y.f14581L1;
                handler.removeCallbacks(this);
                handler.postDelayed(this, 6000L);
            }
            return false;
        }
    }

    public static final class c extends b implements BluetoothAdapter.LeScanCallback {

        /* renamed from: M1, reason: collision with root package name */
        public final BluetoothAdapter f16357M1;

        public c(BluetoothAdapter bluetoothAdapter) {
            this.f16357M1 = bluetoothAdapter;
        }

        @Override // com.llamalab.automate.stmt.BluetoothDeviceScan.b, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            boolean startLeScan;
            super.C(automateService, j8, j9, j10);
            startLeScan = this.f16357M1.startLeScan(this);
            if (!startLeScan) {
                throw new IllegalStateException("Failed to start LE scan, Bluetooth enabled?");
            }
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            try {
                this.f16357M1.stopLeScan(this);
            } catch (Throwable unused) {
            }
            automateService.f14581L1.removeCallbacks(this);
            u2();
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public final void onLeScan(BluetoothDevice bluetoothDevice, int i8, byte[] bArr) {
            if (v2(bluetoothDevice, i8, bArr, false)) {
                q2(this.f16356y1, false);
            }
        }
    }

    public static final class d extends b {

        /* renamed from: M1, reason: collision with root package name */
        public final BluetoothLeScanner f16358M1;

        /* renamed from: N1, reason: collision with root package name */
        public final ScanSettings f16359N1;

        /* renamed from: O1, reason: collision with root package name */
        public final a f16360O1 = new a();

        public class a extends ScanCallback {
            public a() {
            }

            @Override // android.bluetooth.le.ScanCallback
            public final void onBatchScanResults(List<ScanResult> list) {
                Iterator<ScanResult> it = list.iterator();
                boolean z7 = false;
                while (it.hasNext()) {
                    if (d.w2(d.this, C1699x.i(it.next()))) {
                        z7 = true;
                    }
                }
                if (z7) {
                    d dVar = d.this;
                    dVar.q2(dVar.f16356y1, false);
                }
            }

            @Override // android.bluetooth.le.ScanCallback
            public final void onScanFailed(int i8) {
                try {
                    if (i8 == 1) {
                        throw new IllegalStateException("Scan already started");
                    }
                    if (i8 == 2) {
                        throw new IllegalStateException("Application registration failed");
                    }
                    if (i8 == 3) {
                        throw new IllegalStateException("Internal error");
                    }
                    if (i8 == 4) {
                        throw new UnsupportedOperationException("Power optimized scan not supported");
                    }
                    throw new IllegalStateException("Unknown error: " + i8);
                } catch (Throwable th) {
                    d.this.r2(th);
                }
            }

            @Override // android.bluetooth.le.ScanCallback
            public final void onScanResult(int i8, ScanResult scanResult) {
                if (d.w2(d.this, scanResult)) {
                    d dVar = d.this;
                    dVar.q2(dVar.f16356y1, false);
                }
            }
        }

        public d(BluetoothAdapter bluetoothAdapter, ScanSettings scanSettings) {
            BluetoothLeScanner bluetoothLeScanner;
            bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();
            this.f16358M1 = bluetoothLeScanner;
            if (bluetoothLeScanner == null) {
                throw new NullPointerException("Null LE scanner, Bluetooth enabled?");
            }
            this.f16359N1 = scanSettings;
        }

        public static boolean w2(d dVar, ScanResult scanResult) {
            ScanRecord scanRecord;
            BluetoothDevice device;
            int rssi;
            dVar.getClass();
            scanRecord = scanResult.getScanRecord();
            byte[] bytes = scanRecord != null ? scanRecord.getBytes() : null;
            boolean isConnectable = 26 <= Build.VERSION.SDK_INT ? scanResult.isConnectable() : false;
            device = scanResult.getDevice();
            rssi = scanResult.getRssi();
            return dVar.v2(device, rssi, bytes, isConnectable);
        }

        @Override // com.llamalab.automate.stmt.BluetoothDeviceScan.b, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            List<ScanFilter> singletonList = 27 <= Build.VERSION.SDK_INT ? Collections.singletonList(new ScanFilter.Builder().build()) : null;
            BluetoothLeScanner bluetoothLeScanner = this.f16358M1;
            ScanSettings scanSettings = this.f16359N1;
            a aVar = this.f16360O1;
            bluetoothLeScanner.startScan(singletonList, scanSettings, aVar);
            bluetoothLeScanner.flushPendingScanResults(aVar);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            try {
                this.f16358M1.stopScan(this.f16360O1);
            } catch (Throwable unused) {
            }
            automateService.f14581L1.removeCallbacks(this);
            u2();
        }
    }

    public static final class e implements Comparable<e> {

        /* renamed from: X, reason: collision with root package name */
        public final double f16362X;

        /* renamed from: Y, reason: collision with root package name */
        public final byte[] f16363Y;

        /* renamed from: Z, reason: collision with root package name */
        public final boolean f16364Z;

        public e(double d8, byte[] bArr, boolean z7) {
            this.f16362X = d8;
            this.f16363Y = bArr;
            this.f16364Z = z7;
        }

        @Override // java.lang.Comparable
        public final int compareTo(e eVar) {
            return Double.compare(this.f16362X, eVar.f16362X);
        }
    }

    public static J3.e r(J3.e eVar, String str) {
        J3.e eVar2 = (J3.e) eVar.j0(str);
        if (eVar2 != null) {
            return eVar2;
        }
        J3.e eVar3 = new J3.e(4);
        eVar.m0(str, eVar3, null);
        return eVar3;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 31 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_SCAN"), com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")} : 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH"), com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN"), com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")} : 23 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH"), com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN"), com.llamalab.automate.access.c.j("android.permission.ACCESS_COARSE_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH"), com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_bluetooth_device_scan).e(this.mode, 0, C2541R.xml.bluetooth_scan_modes).y(this.pairedOnly, C2541R.string.caption_paired, 0).y(this.connectableOnly, C2541R.string.caption_connectable, 0).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        q(c1708z0, (Map) obj);
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.mode);
        dVar.g(this.deviceClass);
        if (97 <= dVar.f6413Z) {
            dVar.g(this.connectableOnly);
        }
        dVar.g(this.pairedOnly);
        dVar.g(this.varDeviceNames);
        dVar.g(this.varDeviceAddresses);
        if (54 <= dVar.f6413Z) {
            dVar.g(this.varDeviceAdvertisements);
        }
        if (52 <= dVar.f6413Z) {
            dVar.g(this.varDeviceRssis);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.mode);
        visitor.b(this.deviceClass);
        visitor.b(this.connectableOnly);
        visitor.b(this.pairedOnly);
        visitor.b(this.varDeviceNames);
        visitor.b(this.varDeviceAddresses);
        visitor.b(this.varDeviceAdvertisements);
        visitor.b(this.varDeviceRssis);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.mode = (InterfaceC1700x0) cVar.readObject();
        this.deviceClass = (InterfaceC1700x0) cVar.readObject();
        if (97 <= cVar.f6409x0) {
            this.connectableOnly = (InterfaceC1700x0) cVar.readObject();
        }
        this.pairedOnly = (InterfaceC1700x0) cVar.readObject();
        this.varDeviceNames = (J3.l) cVar.readObject();
        this.varDeviceAddresses = (J3.l) cVar.readObject();
        if (54 <= cVar.f6409x0) {
            this.varDeviceAdvertisements = (J3.l) cVar.readObject();
        }
        if (52 <= cVar.f6409x0) {
            this.varDeviceRssis = (J3.l) cVar.readObject();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ba, code lost:
    
        if (r2.equals(r15 != null ? java.lang.Integer.valueOf(r15.getDeviceClass()) : r3) == false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0286 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(C1708z0 c1708z0, Map map) {
        J3.a aVar;
        J3.a aVar2;
        J3.a aVar3;
        J3.a aVar4;
        Integer num;
        boolean z7;
        Map.Entry[] entryArr;
        int i8;
        J3.a aVar5;
        J3.e eVar;
        J3.e eVar2;
        U3.d dVar;
        boolean z8;
        Map.Entry[] entryArr2;
        int i9;
        J3.a aVar6;
        J3.e r8;
        Object obj;
        ConversionType conversionType;
        String str;
        String str2;
        J3.e eVar3 = null;
        Integer o6 = J3.h.o(c1708z0, this.deviceClass, null);
        int i10 = 0;
        boolean f8 = J3.h.f(c1708z0, this.connectableOnly, false);
        if (J3.h.f(c1708z0, this.pairedOnly, false)) {
            Set<BluetoothDevice> bondedDevices = AbstractStatement.h(c1708z0).getBondedDevices();
            if (bondedDevices != null) {
                map.keySet().retainAll(bondedDevices);
            } else {
                map.clear();
            }
        }
        int size = map.size();
        J3.l lVar = this.varDeviceNames;
        if (lVar != null) {
            aVar = new J3.a(size);
            c1708z0.z(lVar.f4659Y, aVar);
        } else {
            aVar = null;
        }
        J3.l lVar2 = this.varDeviceAddresses;
        if (lVar2 != null) {
            aVar2 = new J3.a(size);
            c1708z0.z(lVar2.f4659Y, aVar2);
        } else {
            aVar2 = null;
        }
        J3.l lVar3 = this.varDeviceAdvertisements;
        if (lVar3 != null) {
            aVar3 = new J3.a(size);
            c1708z0.z(lVar3.f4659Y, aVar3);
        } else {
            aVar3 = null;
        }
        J3.l lVar4 = this.varDeviceRssis;
        if (lVar4 != null) {
            aVar4 = new J3.a(size);
            c1708z0.z(lVar4.f4659Y, aVar4);
        } else {
            aVar4 = null;
        }
        if (size != 0 && (aVar != null || aVar2 != null || aVar3 != null || aVar4 != null)) {
            Map.Entry[] entryArr3 = (Map.Entry[]) map.entrySet().toArray(C2434l.f23401l);
            Arrays.sort(entryArr3, Collections.reverseOrder(C2440r.f23418b));
            int length = entryArr3.length;
            int i11 = 0;
            while (i11 < length) {
                Map.Entry entry = entryArr3[i11];
                BluetoothDevice bluetoothDevice = (BluetoothDevice) entry.getKey();
                e eVar4 = (e) entry.getValue();
                if (o6 != null) {
                    BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
                }
                if (!f8 || eVar4.f16364Z) {
                    if (aVar != null) {
                        aVar.add(bluetoothDevice.getName());
                    }
                    if (aVar2 != null) {
                        aVar2.add(bluetoothDevice.getAddress());
                    }
                    if (aVar3 != null) {
                        byte[] bArr = eVar4.f16363Y;
                        if (bArr == null || bArr.length == 0) {
                            num = o6;
                            z7 = f8;
                            entryArr = entryArr3;
                            i8 = length;
                            aVar5 = aVar;
                            eVar = eVar3;
                            eVar2 = eVar;
                        } else {
                            U3.d dVar2 = new U3.d(bArr, i10, bArr.length);
                            HashSet hashSet = null;
                            eVar2 = null;
                            while (dVar2.hasNext()) {
                                U3.e eVar5 = (U3.e) dVar2.next();
                                Integer num2 = o6;
                                if (eVar5 instanceof U3.j) {
                                    U3.j jVar = (U3.j) eVar5;
                                    if (eVar2 == null) {
                                        eVar2 = new J3.e();
                                    }
                                    dVar = dVar2;
                                    r8 = r(eVar2, "iBeacon");
                                    z8 = f8;
                                    entryArr2 = entryArr3;
                                    i9 = length;
                                    r8.m0("uuid", jVar.f6918X.toString(), null);
                                    Double valueOf = Double.valueOf(jVar.f6919Y);
                                    conversionType = ConversionType.Int;
                                    r8.m0("major", valueOf, conversionType);
                                    aVar6 = aVar;
                                    obj = Double.valueOf(jVar.f6920Z);
                                    str = "minor";
                                } else {
                                    dVar = dVar2;
                                    z8 = f8;
                                    entryArr2 = entryArr3;
                                    i9 = length;
                                    aVar6 = aVar;
                                    if (eVar5 instanceof U3.h) {
                                        U3.h hVar = (U3.h) eVar5;
                                        if (eVar2 == null) {
                                            eVar2 = new J3.e();
                                        }
                                        J3.e eVar6 = eVar2;
                                        J3.e r9 = r(eVar6, "eddystone");
                                        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(hVar.f6914Y).asReadOnlyBuffer();
                                        Charset charset = V3.b.f6987a;
                                        if (asReadOnlyBuffer.hasRemaining()) {
                                            char[] cArr = new char[asReadOnlyBuffer.remaining() * 2];
                                            int i12 = -1;
                                            while (asReadOnlyBuffer.hasRemaining()) {
                                                int i13 = asReadOnlyBuffer.get() & 255;
                                                int i14 = i12 + 1;
                                                char[] cArr2 = V3.b.f6989c;
                                                cArr[i14] = cArr2[i13 >> 4];
                                                i12 = i14 + 1;
                                                cArr[i12] = cArr2[i13 & 15];
                                            }
                                            str2 = new String(cArr);
                                        } else {
                                            str2 = "";
                                        }
                                        r9.m0("uid", str2, null);
                                        eVar2 = eVar6;
                                    } else if (eVar5 instanceof U3.i) {
                                        U3.i iVar = (U3.i) eVar5;
                                        if (eVar2 == null) {
                                            eVar2 = new J3.e();
                                        }
                                        r8 = r(eVar2, "eddystone");
                                        obj = iVar.f6916Y;
                                        conversionType = ConversionType.Uri;
                                        str = "url";
                                    } else if (eVar5 instanceof U3.g) {
                                        U3.g gVar = (U3.g) eVar5;
                                        if (eVar2 == null) {
                                            eVar2 = new J3.e();
                                        }
                                        J3.e r10 = r(eVar2, "eddystone");
                                        r10.m0("batteryVoltage", Double.valueOf(gVar.f6910Y), ConversionType.Int);
                                        r10.m0("hardwareTemperature", Double.valueOf(gVar.f6911Z), ConversionType.Float);
                                        r10.m0("framesEmitted", Double.valueOf(gVar.f6912x0), ConversionType.Long);
                                        double d8 = gVar.f6913y0;
                                        Double.isNaN(d8);
                                        Double.isNaN(d8);
                                        Double.isNaN(d8);
                                        r10.m0("uptime", Double.valueOf(d8 / 1000.0d), null);
                                    } else if (eVar5 instanceof U3.c) {
                                        U3.c cVar = (U3.c) eVar5;
                                        if (eVar2 == null) {
                                            eVar2 = new J3.e();
                                        }
                                        eVar2.m0("uri", cVar.f6905X, ConversionType.Uri);
                                    } else if (eVar5 instanceof U3.s) {
                                        if (hashSet == null) {
                                            hashSet = new HashSet();
                                        }
                                        Iterator<UUID> it = ((U3.s) eVar5).iterator();
                                        while (true) {
                                            V3.a aVar7 = (V3.a) it;
                                            if (!aVar7.hasNext()) {
                                                break;
                                            } else {
                                                hashSet.add((UUID) aVar7.next());
                                            }
                                        }
                                    }
                                    if (!(eVar5 instanceof U3.q)) {
                                        U3.q qVar = (U3.q) eVar5;
                                        if (eVar2 == null) {
                                            eVar2 = new J3.e();
                                        }
                                        eVar2.m0("txPower", Double.valueOf(qVar.a()), ConversionType.Int);
                                    }
                                    dVar2 = dVar;
                                    aVar = aVar6;
                                    o6 = num2;
                                    f8 = z8;
                                    entryArr3 = entryArr2;
                                    length = i9;
                                }
                                r8.m0(str, obj, conversionType);
                                if (!(eVar5 instanceof U3.q)) {
                                }
                                dVar2 = dVar;
                                aVar = aVar6;
                                o6 = num2;
                                f8 = z8;
                                entryArr3 = entryArr2;
                                length = i9;
                            }
                            num = o6;
                            z7 = f8;
                            entryArr = entryArr3;
                            i8 = length;
                            aVar5 = aVar;
                            eVar = null;
                            if (hashSet != null && !hashSet.isEmpty()) {
                                if (eVar2 == null) {
                                    eVar2 = new J3.e();
                                }
                                eVar2.m0("services", J3.h.g0(hashSet), ConversionType.StringArray);
                            }
                        }
                        aVar3.add(eVar2);
                    } else {
                        num = o6;
                        z7 = f8;
                        entryArr = entryArr3;
                        i8 = length;
                        aVar5 = aVar;
                        eVar = eVar3;
                    }
                    if (aVar4 != null) {
                        aVar4.add(Double.valueOf(eVar4.f16362X));
                    }
                    i11++;
                    aVar = aVar5;
                    eVar3 = eVar;
                    o6 = num;
                    f8 = z7;
                    entryArr3 = entryArr;
                    length = i8;
                    i10 = 0;
                }
                num = o6;
                z7 = f8;
                entryArr = entryArr3;
                i8 = length;
                aVar5 = aVar;
                eVar = eVar3;
                i11++;
                aVar = aVar5;
                eVar3 = eVar;
                o6 = num;
                f8 = z7;
                entryArr3 = entryArr;
                length = i8;
                i10 = 0;
            }
        }
        c1708z0.f17642x0 = this.onComplete;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        N2 cVar;
        ScanSettings.Builder callbackType;
        ScanSettings.Builder matchMode;
        ScanSettings.Builder callbackType2;
        ScanSettings.Builder matchMode2;
        ScanSettings.Builder numOfMatches;
        ScanSettings.Builder callbackType3;
        ScanSettings.Builder matchMode3;
        c1708z0.q(C2541R.string.stmt_bluetooth_device_scan_title);
        int m8 = J3.h.m(c1708z0, this.mode, 0);
        BluetoothAdapter h8 = AbstractStatement.h(c1708z0);
        if (m8 == 0) {
            c1708z0.w(new a(h8));
            return false;
        }
        if (m8 == 1) {
            c1708z0.w(new a(null));
            return false;
        }
        if (m8 == 2) {
            IncapableAndroidVersionException.b(18, "Bluetooth LE");
            int i8 = Build.VERSION.SDK_INT;
            if (21 <= i8) {
                ScanSettings.Builder scanMode = new ScanSettings.Builder().setReportDelay(0L).setScanMode(0);
                if (23 <= i8) {
                    callbackType = scanMode.setCallbackType(1);
                    matchMode = callbackType.setMatchMode(1);
                    matchMode.setNumOfMatches(3);
                }
                if (26 <= i8) {
                    scanMode.setPhy(255);
                }
                cVar = new d(h8, scanMode.build());
            } else {
                cVar = new c(h8);
            }
            c1708z0.w(cVar);
            return false;
        }
        if (m8 == 3) {
            IncapableAndroidVersionException.b(23, "Bluetooth LE passive mode");
            callbackType2 = new ScanSettings.Builder().setReportDelay(0L).setScanMode(-1).setCallbackType(1);
            matchMode2 = callbackType2.setMatchMode(1);
            numOfMatches = matchMode2.setNumOfMatches(3);
            if (26 <= Build.VERSION.SDK_INT) {
                numOfMatches.setPhy(255);
            }
            c1708z0.w(new d(h8, numOfMatches.build()));
            return false;
        }
        if (m8 != 4) {
            throw new IllegalArgumentException("mode");
        }
        IncapableAndroidVersionException.b(21, "Bluetooth LE low latency mode");
        ScanSettings.Builder scanMode2 = new ScanSettings.Builder().setReportDelay(0L).setScanMode(2);
        int i9 = Build.VERSION.SDK_INT;
        if (23 <= i9) {
            callbackType3 = scanMode2.setCallbackType(1);
            matchMode3 = callbackType3.setMatchMode(1);
            matchMode3.setNumOfMatches(3);
        }
        if (26 <= i9) {
            scanMode2.setPhy(255);
        }
        c1708z0.w(new d(h8, scanMode2.build()));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        q(c1708z0, (Map) obj);
        return true;
    }
}
