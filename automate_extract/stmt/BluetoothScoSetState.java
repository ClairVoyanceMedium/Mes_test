package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1590i2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import x3.C2425c;

@F3.f("bluetooth_sco_set_state.html")
@F3.a(C2541R.integer.ic_device_access_bluetooth_sco)
@F3.i(C2541R.string.stmt_bluetooth_sco_set_state_title)
@F3.h(C2541R.string.stmt_bluetooth_sco_set_state_summary)
@F3.e(C2541R.layout.stmt_bluetooth_sco_set_state_edit)
/* loaded from: classes.dex */
public final class BluetoothScoSetState extends SetStateAction implements ReceiverStatement {
    public InterfaceC1700x0 reenable;

    public static final class BluetoothScoTask extends AbstractC1618p2.c implements Runnable, InterfaceC1590i2 {

        /* renamed from: N1, reason: collision with root package name */
        public static boolean f16380N1;

        /* renamed from: L1, reason: collision with root package name */
        public boolean f16381L1;

        /* renamed from: M1, reason: collision with root package name */
        public boolean f16382M1;

        /* renamed from: x1, reason: collision with root package name */
        public AudioManager f16383x1;

        /* renamed from: y1, reason: collision with root package name */
        public boolean f16384y1;

        @Override // com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            boolean z7;
            boolean z8 = this.f16160y0 != 0;
            boolean isEmpty = automateService.q(BluetoothScoTask.class).isEmpty();
            super.C(automateService, j8, j9, j10);
            this.f16381L1 = C1710z2.a(C2425c.c(automateService));
            AudioManager audioManager = (AudioManager) automateService.getSystemService("audio");
            this.f16383x1 = audioManager;
            if (isEmpty) {
                f16380N1 = audioManager.isBluetoothScoOn();
            }
            if (!z8) {
                Intent registerReceiver = automateService.registerReceiver(null, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
                if (!(registerReceiver != null && 1 == registerReceiver.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1))) {
                    z7 = true;
                    this.f16382M1 = z7;
                    j("android.media.ACTION_SCO_AUDIO_STATE_UPDATED", "android.intent.action.PHONE_STATE");
                    if (z8 || !this.f16384y1) {
                    }
                    s();
                    return;
                }
            }
            z7 = false;
            this.f16382M1 = z7;
            j("android.media.ACTION_SCO_AUDIO_STATE_UPDATED", "android.intent.action.PHONE_STATE");
            if (z8) {
            }
        }

        @Override // com.llamalab.automate.AbstractC1618p2.c, com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            automateService.f14581L1.removeCallbacks(this);
            if (automateService.q(BluetoothScoTask.class).isEmpty()) {
                try {
                    this.f16383x1.stopBluetoothSco();
                    this.f16383x1.setBluetoothScoOn(f16380N1);
                } catch (Throwable unused) {
                }
            }
            try {
                automateService.unregisterReceiver(this);
            } catch (Throwable unused2) {
            }
        }

        @Override // R3.e
        public final void Y0(R3.d dVar) {
            dVar.d(this.f16160y0);
            dVar.write(this.f16384y1 ? 1 : 0);
        }

        @Override // R3.e
        public final void o0(R3.c cVar) {
            this.f16160y0 = cVar.b();
            this.f16384y1 = cVar.readBoolean();
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            try {
                String action = intent.getAction();
                if ("android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(action)) {
                    r(context, intent);
                    return;
                }
                if ("android.intent.action.PHONE_STATE".equals(action)) {
                    String stringExtra = intent.getStringExtra(com.llamalab.auth3p.e.PARAM_STATE);
                    if (this.f16381L1) {
                        F5.n.f(this, "BluetoothScoSetState ACTION_PHONE_STATE_CHANGED: " + stringExtra);
                    }
                    if (TelephonyManager.EXTRA_STATE_IDLE.equals(stringExtra)) {
                        s();
                    }
                }
            } catch (Throwable th) {
                d(th);
            }
        }

        public final void r(Context context, Intent intent) {
            String str;
            int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            if (intExtra == -1) {
                if (this.f16381L1) {
                    F5.n.f(this, "BluetoothScoSetState ACTION_SCO_AUDIO_STATE_UPDATED: error");
                }
                if (this.f16382M1) {
                    throw new IllegalStateException("Failed establish Bluetooth SCO connection: error");
                }
                return;
            }
            if (intExtra != 0) {
                if (intExtra != 1) {
                    if (intExtra == 2 && this.f16381L1) {
                        str = "BluetoothScoSetState ACTION_SCO_AUDIO_STATE_UPDATED: connecting";
                        F5.n.f(this, str);
                        return;
                    }
                    return;
                }
                if (this.f16381L1) {
                    F5.n.f(this, "BluetoothScoSetState ACTION_SCO_AUDIO_STATE_UPDATED: connected");
                }
                if (this.f16382M1) {
                    this.f16382M1 = false;
                    c(intent, null, this.f16384y1);
                    return;
                } else {
                    if (this.f16384y1) {
                        return;
                    }
                    a();
                }
            }
            if (this.f16381L1) {
                F5.n.f(this, "BluetoothScoSetState ACTION_SCO_AUDIO_STATE_UPDATED: disconnected");
            }
            if (this.f16382M1) {
                throw new IllegalStateException("Failed establish Bluetooth SCO connection: disconnect");
            }
            if (this.f16384y1) {
                if (2 == AbstractStatement.h(context).getProfileConnectionState(1)) {
                    Handler handler = this.f16157Y.f14581L1;
                    handler.removeCallbacks(this);
                    handler.postDelayed(this, 1000L);
                    return;
                } else {
                    if (this.f16381L1) {
                        str = "BluetoothScoSetState Headset not connected";
                        F5.n.f(this, str);
                        return;
                    }
                    return;
                }
            }
            a();
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                s();
            } catch (Throwable th) {
                d(th);
            }
        }

        public final boolean s() {
            if (this.f16381L1) {
                F5.n.f(this, "BluetoothScoSetState startBluetoothSco");
            }
            this.f16383x1.setBluetoothScoOn(true);
            this.f16383x1.startBluetoothSco();
            return !this.f16382M1;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 34 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_CONNECT"), com.llamalab.automate.access.c.j("android.permission.MODIFY_AUDIO_SETTINGS"), com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH"), com.llamalab.automate.access.c.j("android.permission.MODIFY_AUDIO_SETTINGS"), com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_bluetooth_sco_enable, C2541R.string.caption_bluetooth_sco_disable).r(C2541R.string.caption_bluetooth_sco_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.reenable);
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.reenable);
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.reenable = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_bluetooth_sco_set_state_title);
        BluetoothScoTask bluetoothScoTask = (BluetoothScoTask) c1708z0.c(BluetoothScoTask.class);
        if (q(c1708z0, false)) {
            if (bluetoothScoTask == null) {
                bluetoothScoTask = new BluetoothScoTask();
                c1708z0.w(bluetoothScoTask);
            }
            bluetoothScoTask.f16384y1 = J3.h.f(c1708z0, this.reenable, true);
            if (!bluetoothScoTask.s()) {
                return false;
            }
        } else if (bluetoothScoTask != null) {
            bluetoothScoTask.a();
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
