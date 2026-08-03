package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.bt.android.BluetoothGattClient;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Pattern;
import x3.C2440r;

@F3.f("bluetooth_gatt_read.html")
@F3.a(C2541R.integer.ic_device_access_bluetooth_searching)
@F3.i(C2541R.string.stmt_bluetooth_gatt_read_title)
@F3.h(C2541R.string.stmt_bluetooth_gatt_read_summary)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_bluetooth_gatt_read_edit)
/* loaded from: classes.dex */
public final class BluetoothGattRead extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 characteristicInstanceId;
    public InterfaceC1700x0 characteristicUuid;
    public InterfaceC1700x0 deviceAddress;
    public InterfaceC1700x0 deviceName;
    public InterfaceC1700x0 serviceInstanceId;
    public InterfaceC1700x0 serviceUuid;
    public InterfaceC1700x0 valueFormat;
    public InterfaceC1700x0 valueOffset;
    public J3.l varResult;

    public static final class a extends com.llamalab.automate.W implements com.llamalab.bt.android.f {

        /* renamed from: L1, reason: collision with root package name */
        public final BluetoothDevice f16366L1;

        /* renamed from: M1, reason: collision with root package name */
        public b f16367M1;

        /* renamed from: N1, reason: collision with root package name */
        public BluetoothGattClient f16368N1;

        /* renamed from: O1, reason: collision with root package name */
        public BluetoothGattCharacteristic f16369O1;

        /* renamed from: P1, reason: collision with root package name */
        public Object f16370P1;

        /* renamed from: Q1, reason: collision with root package name */
        public boolean f16371Q1;

        /* renamed from: R1, reason: collision with root package name */
        public boolean f16372R1;

        /* renamed from: y1, reason: collision with root package name */
        public final ArrayBlockingQueue f16373y1 = new ArrayBlockingQueue(512);

        public a(BluetoothDevice bluetoothDevice, b bVar, boolean z7) {
            this.f16366L1 = bluetoothDevice;
            this.f16367M1 = bVar;
            this.f16371Q1 = z7;
        }

        public static void A2(final BluetoothGattClient bluetoothGattClient, BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr) {
            final BluetoothGattDescriptor descriptor;
            UUID uuid;
            descriptor = bluetoothGattCharacteristic.getDescriptor(com.llamalab.bt.android.h.f17692b);
            if (descriptor == null) {
                StringBuilder sb = new StringBuilder("Characteristic missing CCCD: ");
                uuid = bluetoothGattCharacteristic.getUuid();
                sb.append(uuid);
                throw new IOException(sb.toString());
            }
            bluetoothGattClient.getClass();
            if (bArr.length == 0) {
                throw new IllegalArgumentException();
            }
            bluetoothGattClient.f(new BluetoothGattClient.d() { // from class: com.llamalab.bt.android.a
                /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void run() {
                    int i8;
                    boolean value;
                    int writeDescriptor;
                    BluetoothGattClient bluetoothGattClient2 = BluetoothGattClient.this;
                    BluetoothGattDescriptor bluetoothGattDescriptor = descriptor;
                    byte[] bArr2 = bArr;
                    BluetoothGatt bluetoothGatt = bluetoothGattClient2.f17663g;
                    if (bluetoothGatt != null && 2 == bluetoothGattClient2.f17659c.get()) {
                        try {
                            bluetoothGattClient2.f17665i = bArr2;
                        } catch (Exception e8) {
                            Log.w("BluetoothGattClient", "writeDescriptor failed", e8);
                        }
                        if (33 <= Build.VERSION.SDK_INT) {
                            writeDescriptor = bluetoothGatt.writeDescriptor(bluetoothGattDescriptor, bArr2);
                            if (writeDescriptor == 0) {
                                i8 = 0;
                            } else if (writeDescriptor != 4) {
                                if (writeDescriptor == 6) {
                                    i8 = MoreOsConstants.KEY_MENU;
                                } else if (writeDescriptor == 9) {
                                    i8 = 5;
                                } else if (writeDescriptor == 200) {
                                    i8 = 3;
                                } else if (writeDescriptor == 201) {
                                    i8 = 132;
                                }
                            }
                            if (-1 != bluetoothGattClient2.f17659c.get()) {
                                bluetoothGattClient2.f17661e.b1(bluetoothGattClient2, bluetoothGattDescriptor, i8);
                            }
                            bluetoothGattClient2.d();
                        }
                        value = bluetoothGattDescriptor.setValue(bArr2);
                        if (value && i.a(bluetoothGatt, bluetoothGattDescriptor)) {
                            return;
                        }
                        i8 = 129;
                        if (-1 != bluetoothGattClient2.f17659c.get()) {
                        }
                        bluetoothGattClient2.d();
                    }
                    i8 = 130;
                    if (-1 != bluetoothGattClient2.f17659c.get()) {
                    }
                    bluetoothGattClient2.d();
                }

                @Override // com.llamalab.bt.android.BluetoothGattClient.d
                public final /* synthetic */ void y0() {
                }
            });
        }

        public static Object v2(byte[] bArr, int i8, int i9) {
            float f8;
            float f9;
            int i10 = i9;
            int i11 = 64;
            int i12 = 0;
            try {
                switch (i8) {
                    case 1:
                        Charset charset = com.llamalab.bt.android.g.f17689a;
                        return Double.valueOf(J3.h.Y((bArr[i10 >> 3] & (1 << (i10 & 7))) != 0));
                    case 2:
                        int a8 = com.llamalab.bt.android.g.a(bArr, i10, 2, false);
                        Pattern pattern = J3.h.f4650a;
                        return Double.valueOf(a8);
                    case 3:
                        int a9 = com.llamalab.bt.android.g.a(bArr, i10, 4, false);
                        Pattern pattern2 = J3.h.f4650a;
                        return Double.valueOf(a9);
                    case 4:
                        int a10 = com.llamalab.bt.android.g.a(bArr, i10, 8, false);
                        Pattern pattern3 = J3.h.f4650a;
                        return Double.valueOf(a10);
                    case 5:
                        int a11 = com.llamalab.bt.android.g.a(bArr, i10, 12, false);
                        Pattern pattern4 = J3.h.f4650a;
                        return Double.valueOf(a11);
                    case 6:
                        int a12 = com.llamalab.bt.android.g.a(bArr, i10, 16, false);
                        Pattern pattern5 = J3.h.f4650a;
                        return Double.valueOf(a12);
                    case 7:
                        int a13 = com.llamalab.bt.android.g.a(bArr, i10, 24, false);
                        Pattern pattern6 = J3.h.f4650a;
                        return Double.valueOf(a13);
                    case 8:
                        long b8 = com.llamalab.bt.android.g.b(bArr, i10, 32, false);
                        Pattern pattern7 = J3.h.f4650a;
                        return Double.valueOf(b8);
                    case 9:
                        long b9 = com.llamalab.bt.android.g.b(bArr, i10, 48, false);
                        Pattern pattern8 = J3.h.f4650a;
                        return Double.valueOf(b9);
                    case 10:
                        Charset charset2 = com.llamalab.bt.android.g.f17689a;
                        BigInteger bigInteger = BigInteger.ZERO;
                        while (true) {
                            i11--;
                            if (i11 < 0) {
                                Pattern pattern9 = J3.h.f4650a;
                                return Double.valueOf(bigInteger.doubleValue());
                            }
                            if ((bArr[i10 >> 3] & (1 << (i10 & 7))) != 0) {
                                bigInteger = bigInteger.setBit(i12);
                            }
                            i12++;
                            i10++;
                        }
                    case 11:
                    case 19:
                    default:
                        throw new IllegalArgumentException("Invalid value type: " + i8);
                    case 12:
                        int a14 = com.llamalab.bt.android.g.a(bArr, i10, 8, true);
                        Pattern pattern10 = J3.h.f4650a;
                        return Double.valueOf(a14);
                    case 13:
                        int a15 = com.llamalab.bt.android.g.a(bArr, i10, 12, true);
                        Pattern pattern11 = J3.h.f4650a;
                        return Double.valueOf(a15);
                    case 14:
                        int a16 = com.llamalab.bt.android.g.a(bArr, i10, 16, true);
                        Pattern pattern12 = J3.h.f4650a;
                        return Double.valueOf(a16);
                    case 15:
                        int a17 = com.llamalab.bt.android.g.a(bArr, i10, 24, true);
                        Pattern pattern13 = J3.h.f4650a;
                        return Double.valueOf(a17);
                    case 16:
                        int a18 = com.llamalab.bt.android.g.a(bArr, i10, 32, true);
                        Pattern pattern14 = J3.h.f4650a;
                        return Double.valueOf(a18);
                    case 17:
                        long b10 = com.llamalab.bt.android.g.b(bArr, i10, 48, true);
                        Pattern pattern15 = J3.h.f4650a;
                        return Double.valueOf(b10);
                    case 18:
                        long b11 = com.llamalab.bt.android.g.b(bArr, i10, 64, true);
                        Pattern pattern16 = J3.h.f4650a;
                        return Double.valueOf(b11);
                    case 20:
                        float intBitsToFloat = Float.intBitsToFloat(Integer.reverseBytes(com.llamalab.bt.android.g.a(bArr, i10, 32, true)));
                        Pattern pattern17 = J3.h.f4650a;
                        return Double.valueOf(intBitsToFloat);
                    case 21:
                        double longBitsToDouble = Double.longBitsToDouble(Long.reverseBytes(com.llamalab.bt.android.g.b(bArr, i10, 64, true)));
                        Pattern pattern18 = J3.h.f4650a;
                        return Double.valueOf(longBitsToDouble);
                    case 22:
                        int a19 = com.llamalab.bt.android.g.a(bArr, i10, 12, true);
                        int a20 = com.llamalab.bt.android.g.a(bArr, i10 + 12, 4, true);
                        if (a20 == 0) {
                            if (a19 == -2046) {
                                f8 = Float.NEGATIVE_INFINITY;
                            } else if (a19 == 2046) {
                                f8 = Float.POSITIVE_INFINITY;
                            } else if (a19 == 2047) {
                                f8 = Float.NaN;
                            }
                            Pattern pattern19 = J3.h.f4650a;
                            return Double.valueOf(f8);
                        }
                        double d8 = a19;
                        double pow = Math.pow(10.0d, a20);
                        Double.isNaN(d8);
                        Double.isNaN(d8);
                        f8 = (float) (pow * d8);
                        Pattern pattern192 = J3.h.f4650a;
                        return Double.valueOf(f8);
                    case 23:
                        int a21 = com.llamalab.bt.android.g.a(bArr, i10, 24, true);
                        int a22 = com.llamalab.bt.android.g.a(bArr, i10 + 24, 8, true);
                        if (a22 == 0) {
                            switch (a21) {
                                case -8388606:
                                    f9 = Float.NEGATIVE_INFINITY;
                                    break;
                                case 8388606:
                                    f9 = Float.POSITIVE_INFINITY;
                                    break;
                                case 8388607:
                                    f9 = Float.NaN;
                                    break;
                            }
                            Pattern pattern20 = J3.h.f4650a;
                            return Double.valueOf(f9);
                        }
                        double d9 = a21;
                        double pow2 = Math.pow(10.0d, a22);
                        Double.isNaN(d9);
                        Double.isNaN(d9);
                        f9 = (float) (pow2 * d9);
                        Pattern pattern202 = J3.h.f4650a;
                        return Double.valueOf(f9);
                    case 24:
                        return J3.h.H(new int[]{com.llamalab.bt.android.g.a(bArr, i10, 16, false), com.llamalab.bt.android.g.a(bArr, i10 + 16, 16, false)});
                    case 25:
                        Charset charset3 = com.llamalab.bt.android.g.f17689a;
                        if (i10 % 8 != 0) {
                            throw new IllegalArgumentException("Unaligned utf8s not supported");
                        }
                        int i13 = i10 / 8;
                        return new String(bArr, i13, bArr.length - i13, com.llamalab.bt.android.g.f17689a);
                    case 26:
                        Charset charset4 = com.llamalab.bt.android.g.f17689a;
                        if (i10 % 8 != 0) {
                            throw new IllegalArgumentException("Unaligned utf16s not supported");
                        }
                        int i14 = i10 / 8;
                        return new String(bArr, i14, bArr.length - i14, com.llamalab.bt.android.g.f17690b);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IllegalArgumentException("Invalid value type or offset");
            }
        }

        public static boolean x2(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i8) {
            int properties;
            properties = bluetoothGattCharacteristic.getProperties();
            return (properties & i8) != 0;
        }

        public static BluetoothGattCharacteristic y2(BluetoothGattClient bluetoothGattClient, b bVar) {
            UUID uuid;
            List characteristics;
            UUID uuid2;
            int instanceId;
            int instanceId2;
            BluetoothGatt bluetoothGatt = bluetoothGattClient.f17663g;
            Iterator it = (bluetoothGatt != null ? bluetoothGatt.getServices() : Collections.emptyList()).iterator();
            while (it.hasNext()) {
                BluetoothGattService e8 = T.h.e(it.next());
                UUID uuid3 = bVar.f16374a;
                uuid = e8.getUuid();
                if (uuid3.equals(uuid)) {
                    int i8 = bVar.f16375b;
                    if (i8 >= 0) {
                        instanceId2 = e8.getInstanceId();
                        if (i8 != instanceId2) {
                            continue;
                        }
                    }
                    characteristics = e8.getCharacteristics();
                    Iterator it2 = characteristics.iterator();
                    while (it2.hasNext()) {
                        BluetoothGattCharacteristic e9 = L.n.e(it2.next());
                        UUID uuid4 = bVar.f16376c;
                        uuid2 = e9.getUuid();
                        if (uuid4.equals(uuid2)) {
                            int i9 = bVar.f16377d;
                            if (i9 >= 0) {
                                instanceId = e9.getInstanceId();
                                if (i9 == instanceId) {
                                }
                            }
                            return e9;
                        }
                    }
                }
            }
            return null;
        }

        @Override // com.llamalab.bt.android.f
        public final void B1(BluetoothGattClient bluetoothGattClient, int i8) {
            try {
                if (i8 != 0) {
                    throw new IOException(BluetoothGattClient.c(i8));
                }
                BluetoothGattCharacteristic y22 = y2(bluetoothGattClient, this.f16367M1);
                if (y22 == null) {
                    w2(null, false);
                    return;
                }
                this.f16367M1 = this.f16367M1.c(y22);
                this.f16369O1 = y22;
                z2(y22, false);
            } catch (Throwable th) {
                r2(th);
            }
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            BluetoothGattClient bluetoothGattClient = new BluetoothGattClient(automateService, this, automateService.f14581L1);
            this.f16368N1 = bluetoothGattClient;
            int i8 = Build.VERSION.SDK_INT;
            BluetoothDevice bluetoothDevice = this.f16366L1;
            if (23 <= i8) {
                bluetoothGattClient.b(bluetoothDevice, 2);
            } else {
                bluetoothGattClient.b(bluetoothDevice, 0);
            }
        }

        @Override // com.llamalab.bt.android.f
        public final /* synthetic */ void E0() {
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            BluetoothGattClient bluetoothGattClient = this.f16368N1;
            if (bluetoothGattClient != null) {
                try {
                    bluetoothGattClient.f17659c.set(-1);
                    bluetoothGattClient.f17657a.clear();
                    bluetoothGattClient.f17658b.clear();
                    BluetoothGatt bluetoothGatt = bluetoothGattClient.f17663g;
                    bluetoothGattClient.f17663g = null;
                    if (bluetoothGatt != null) {
                        bluetoothGatt.close();
                    }
                } catch (Throwable unused) {
                }
            }
            u2();
        }

        @Override // com.llamalab.bt.android.f
        public final void H(final BluetoothGattClient bluetoothGattClient, int i8, int i9) {
            try {
                if (i9 != 0) {
                    throw new IOException(BluetoothGattClient.c(i9));
                }
                if (2 == i8) {
                    bluetoothGattClient.getClass();
                    bluetoothGattClient.f(new BluetoothGattClient.b() { // from class: com.llamalab.bt.android.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i10;
                            boolean discoverServices;
                            BluetoothGattClient bluetoothGattClient2 = BluetoothGattClient.this;
                            BluetoothGatt bluetoothGatt = bluetoothGattClient2.f17663g;
                            if (bluetoothGatt == null || 2 != bluetoothGattClient2.f17659c.get()) {
                                i10 = 130;
                            } else {
                                try {
                                    discoverServices = bluetoothGatt.discoverServices();
                                    if (discoverServices) {
                                        return;
                                    }
                                } catch (Exception e8) {
                                    Log.w("BluetoothGattClient", "discoverServices failed", e8);
                                }
                                i10 = 129;
                            }
                            if (-1 != bluetoothGattClient2.f17659c.get()) {
                                bluetoothGattClient2.f17661e.B1(bluetoothGattClient2, i10);
                            }
                            bluetoothGattClient2.d();
                        }

                        @Override // com.llamalab.bt.android.BluetoothGattClient.d
                        public final /* synthetic */ void y0() {
                        }
                    });
                }
            } catch (Throwable th) {
                r2(th);
            }
        }

        @Override // com.llamalab.bt.android.f
        public final void O(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            Object poll;
            try {
                b bVar = this.f16367M1;
                if (bVar.a(bluetoothGattCharacteristic)) {
                    Object v22 = v2(bArr, bVar.f16378e, bVar.f16379f);
                    ArrayBlockingQueue arrayBlockingQueue = this.f16373y1;
                    if (!arrayBlockingQueue.offer(v22)) {
                        F5.n.g(this, "BluetoothGattRead Queue full, skipping values");
                    }
                    if (this.f16372R1 || (poll = arrayBlockingQueue.poll()) == null) {
                        return;
                    }
                    if (!this.f16371Q1 && x2(bluetoothGattCharacteristic, 2) && C2440r.h(this.f16370P1, poll)) {
                        return;
                    }
                    w2(poll, true);
                }
            } catch (Throwable th) {
                r2(th);
            }
        }

        @Override // com.llamalab.bt.android.f
        public final /* synthetic */ void P1() {
        }

        @Override // com.llamalab.bt.android.f
        public final /* synthetic */ void T() {
        }

        @Override // com.llamalab.bt.android.f
        public final /* synthetic */ void W() {
        }

        @Override // com.llamalab.bt.android.f
        public final void W0(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i8) {
            Object poll;
            try {
                if (i8 != 0) {
                    throw new IOException(BluetoothGattClient.c(i8));
                }
                b bVar = this.f16367M1;
                if (bVar.a(bluetoothGattCharacteristic)) {
                    Object v22 = v2(bArr, bVar.f16378e, bVar.f16379f);
                    ArrayBlockingQueue arrayBlockingQueue = this.f16373y1;
                    if (!arrayBlockingQueue.offer(v22)) {
                        F5.n.g(this, "BluetoothGattRead Queue full, skipping values");
                    }
                    if (this.f16372R1 || (poll = arrayBlockingQueue.poll()) == null) {
                        return;
                    }
                    if (this.f16371Q1) {
                        w2(poll, true);
                    } else {
                        this.f16370P1 = poll;
                    }
                }
            } catch (Throwable th) {
                r2(th);
            }
        }

        @Override // com.llamalab.bt.android.f
        public final void b1(BluetoothGattClient bluetoothGattClient, BluetoothGattDescriptor bluetoothGattDescriptor, int i8) {
            BluetoothGattCharacteristic characteristic;
            try {
                if (i8 != 0) {
                    throw new IOException(BluetoothGattClient.c(i8));
                }
                if (this.f16372R1) {
                    return;
                }
                b bVar = this.f16367M1;
                characteristic = bluetoothGattDescriptor.getCharacteristic();
                if (bVar.a(characteristic)) {
                    if (this.f16371Q1 || x2(characteristic, 2)) {
                        bluetoothGattClient.getClass();
                        bluetoothGattClient.f(new com.llamalab.bt.android.c(bluetoothGattClient, characteristic));
                    }
                }
            } catch (Throwable th) {
                r2(th);
            }
        }

        @Override // com.llamalab.bt.android.f
        public final /* synthetic */ void c() {
        }

        @Override // com.llamalab.bt.android.f
        public final /* synthetic */ void d() {
        }

        @Override // com.llamalab.bt.android.f
        public final /* synthetic */ void f2() {
        }

        @Override // com.llamalab.bt.android.f
        public final /* synthetic */ void m0() {
        }

        @Override // com.llamalab.bt.android.f
        public final /* synthetic */ void s0() {
        }

        public final void w2(Object obj, boolean z7) {
            this.f16372R1 = true;
            this.f16370P1 = obj;
            o2(z7 ? 1000L : 0L, new Object[]{Boolean.valueOf(z7), obj});
        }

        public final void z2(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z7) {
            byte[] bArr;
            byte[] bArr2;
            byte[] bArr3;
            if (this.f16371Q1) {
                if (z7) {
                    BluetoothGattClient bluetoothGattClient = this.f16368N1;
                    bArr3 = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                    A2(bluetoothGattClient, bluetoothGattCharacteristic, bArr3);
                    return;
                } else {
                    BluetoothGattClient bluetoothGattClient2 = this.f16368N1;
                    bluetoothGattClient2.getClass();
                    bluetoothGattClient2.f(new com.llamalab.bt.android.c(bluetoothGattClient2, bluetoothGattCharacteristic));
                    return;
                }
            }
            if (x2(bluetoothGattCharacteristic, 16)) {
                BluetoothGattClient bluetoothGattClient3 = this.f16368N1;
                bArr2 = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                A2(bluetoothGattClient3, bluetoothGattCharacteristic, bArr2);
            } else {
                if (!x2(bluetoothGattCharacteristic, 32)) {
                    throw new IOException("Characteristic do not support notification nor indication");
                }
                BluetoothGattClient bluetoothGattClient4 = this.f16368N1;
                bArr = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
                A2(bluetoothGattClient4, bluetoothGattCharacteristic, bArr);
            }
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f16374a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16375b;

        /* renamed from: c, reason: collision with root package name */
        public final UUID f16376c;

        /* renamed from: d, reason: collision with root package name */
        public final int f16377d;

        /* renamed from: e, reason: collision with root package name */
        public final int f16378e;

        /* renamed from: f, reason: collision with root package name */
        public final int f16379f;

        public b(UUID uuid, int i8, UUID uuid2, int i9, int i10, int i11) {
            this.f16374a = uuid;
            this.f16375b = i8;
            this.f16376c = uuid2;
            this.f16377d = i9;
            this.f16378e = i10;
            this.f16379f = i11;
        }

        public final boolean a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BluetoothGattService service;
            UUID uuid;
            int instanceId;
            UUID uuid2;
            int instanceId2;
            service = bluetoothGattCharacteristic.getService();
            UUID uuid3 = this.f16376c;
            uuid = bluetoothGattCharacteristic.getUuid();
            if (uuid3.equals(uuid)) {
                int i8 = this.f16377d;
                instanceId = bluetoothGattCharacteristic.getInstanceId();
                if (i8 == instanceId) {
                    uuid2 = service.getUuid();
                    if (this.f16374a.equals(uuid2)) {
                        int i9 = this.f16375b;
                        instanceId2 = service.getInstanceId();
                        if (i9 == instanceId2) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public final boolean b(b bVar) {
            return this.f16374a.equals(bVar.f16374a) && this.f16375b == bVar.f16375b && this.f16376c.equals(bVar.f16376c) && this.f16377d == bVar.f16377d;
        }

        public final b c(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            BluetoothGattService service;
            int instanceId;
            int instanceId2;
            service = bluetoothGattCharacteristic.getService();
            instanceId = service.getInstanceId();
            instanceId2 = bluetoothGattCharacteristic.getInstanceId();
            return (this.f16375b == instanceId && this.f16377d == instanceId2) ? this : new b(this.f16374a, instanceId, this.f16376c, instanceId2, this.f16378e, this.f16379f);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (b(bVar)) {
                    if (this.f16378e == bVar.f16378e && this.f16379f == bVar.f16379f) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 31 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_CONNECT")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH")};
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.deviceAddress);
        dVar.g(this.deviceName);
        dVar.g(this.serviceUuid);
        dVar.g(this.serviceInstanceId);
        dVar.g(this.characteristicUuid);
        dVar.g(this.characteristicInstanceId);
        dVar.g(this.valueFormat);
        dVar.g(this.valueOffset);
        dVar.g(this.varResult);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.deviceAddress);
        visitor.b(this.deviceName);
        visitor.b(this.serviceUuid);
        visitor.b(this.serviceInstanceId);
        visitor.b(this.characteristicUuid);
        visitor.b(this.characteristicInstanceId);
        visitor.b(this.valueFormat);
        visitor.b(this.valueOffset);
        visitor.b(this.varResult);
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
        this.serviceUuid = (InterfaceC1700x0) cVar.readObject();
        this.serviceInstanceId = (InterfaceC1700x0) cVar.readObject();
        this.characteristicUuid = (InterfaceC1700x0) cVar.readObject();
        this.characteristicInstanceId = (InterfaceC1700x0) cVar.readObject();
        this.valueFormat = (InterfaceC1700x0) cVar.readObject();
        this.valueOffset = (InterfaceC1700x0) cVar.readObject();
        this.varResult = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        a aVar;
        c1708z0.q(C2541R.string.stmt_bluetooth_gatt_read_title);
        IncapableAndroidVersionException.b(18, "Bluetooth gatt");
        String r8 = H1.b.r(c1708z0, this.deviceAddress);
        String x7 = J3.h.x(c1708z0, this.deviceName, null);
        UUID s8 = H1.b.s(c1708z0, this.serviceUuid);
        if (s8 == null) {
            throw new RequiredArgumentNullException("Service UUID");
        }
        int m8 = J3.h.m(c1708z0, this.serviceInstanceId, -1);
        UUID s9 = H1.b.s(c1708z0, this.characteristicUuid);
        if (s9 == null) {
            throw new RequiredArgumentNullException("Characteristic UUID");
        }
        int m9 = J3.h.m(c1708z0, this.characteristicInstanceId, -1);
        int m10 = J3.h.m(c1708z0, this.valueFormat, -1);
        int max = Math.max(J3.h.m(c1708z0, this.valueOffset, 0), 0);
        boolean z7 = J1(1) == 0;
        BluetoothAdapter h8 = AbstractStatement.h(c1708z0);
        if (!h8.isEnabled()) {
            throw new IllegalStateException("Bluetooth disabled");
        }
        BluetoothDevice u8 = H1.b.u(h8, r8, x7);
        if (u8 == null) {
            c1708z0.H(a.class);
            J3.l lVar = this.varResult;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return true;
        }
        b bVar = new b(s8, m8, s9, m9, m10, max);
        a aVar2 = (a) c1708z0.c(a.class);
        if (aVar2 == null) {
            aVar = new a(u8, bVar, z7);
        } else {
            if (aVar2.f16366L1.equals(u8)) {
                aVar2.f15404y0 = c1708z0.g();
                F5.n.h(aVar2);
                aVar2.f15400Y.f14581L1.post(new w0.r(aVar2, bVar, z7, 1));
                return false;
            }
            aVar2.a();
            aVar = new a(u8, bVar, z7);
        }
        c1708z0.w(aVar);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        Object obj2 = objArr[1];
        J3.l lVar = this.varResult;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj2);
        }
        o(c1708z0, booleanValue);
        return true;
    }
}
