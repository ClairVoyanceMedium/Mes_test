package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothProfile;
import com.llamalab.automate.AutomateService;
import java.util.concurrent.TimeoutException;

/* renamed from: com.llamalab.automate.stmt.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC1658n extends com.llamalab.automate.W implements BluetoothProfile.ServiceListener, Runnable {

    /* renamed from: L1, reason: collision with root package name */
    public BluetoothProfile f17475L1;

    /* renamed from: M1, reason: collision with root package name */
    public int f17476M1;

    /* renamed from: y1, reason: collision with root package name */
    public BluetoothAdapter f17477y1;

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        BluetoothProfile bluetoothProfile;
        automateService.f14581L1.removeCallbacks(this);
        BluetoothAdapter bluetoothAdapter = this.f17477y1;
        if (bluetoothAdapter != null && (bluetoothProfile = this.f17475L1) != null) {
            try {
                bluetoothAdapter.closeProfileProxy(this.f17476M1, bluetoothProfile);
            } catch (Throwable unused) {
            }
            this.f17475L1 = null;
        }
        u2();
    }

    public void onServiceConnected(int i8, BluetoothProfile bluetoothProfile) {
        this.f15400Y.f14581L1.removeCallbacks(this);
        this.f17475L1 = bluetoothProfile;
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public final void onServiceDisconnected(int i8) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        r2(new TimeoutException("Bluetooth profile service connect timeout").fillInStackTrace());
    }

    public final void v2(BluetoothAdapter bluetoothAdapter, int i8) {
        this.f17477y1 = bluetoothAdapter;
        this.f17476M1 = i8;
        AutomateService automateService = this.f15400Y;
        automateService.f14581L1.postDelayed(this, 3000L);
        if (!bluetoothAdapter.getProfileProxy(automateService, this, i8)) {
            throw new IllegalStateException("Failed to get proxy");
        }
    }
}
