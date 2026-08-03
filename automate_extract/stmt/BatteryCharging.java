package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;

@F3.f("battery_charging.html")
@F3.a(C2541R.integer.ic_device_access_battery)
@F3.i(C2541R.string.stmt_battery_charging_title)
@F3.h(C2541R.string.stmt_battery_charging_summary)
@F3.e(C2541R.layout.stmt_battery_charging_edit)
/* loaded from: classes.dex */
public final class BatteryCharging extends IntermittentDecision implements ReceiverStatement {
    public J3.l varUntilFullyCharged;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: x1, reason: collision with root package name */
        public final boolean f16329x1;

        /* renamed from: y1, reason: collision with root package name */
        public Boolean f16330y1;

        public a(boolean z7, Boolean bool) {
            this.f16329x1 = z7;
            this.f16330y1 = bool;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Boolean valueOf;
            Boolean bool = this.f16330y1;
            if (bool == null) {
                valueOf = Boolean.valueOf(BatteryCharging.C(intent));
                this.f16330y1 = valueOf;
                if (!this.f16329x1) {
                    return;
                }
            } else {
                if (bool.booleanValue() == BatteryCharging.C(intent)) {
                    return;
                }
                valueOf = Boolean.valueOf(!this.f16330y1.booleanValue());
                this.f16330y1 = valueOf;
            }
            c(intent, valueOf, false);
        }
    }

    public static boolean C(Intent intent) {
        int intExtra = intent.getIntExtra("status", 1);
        return intExtra == 2 || intExtra == 5;
    }

    public final boolean B(C1708z0 c1708z0, boolean z7, Double d8) {
        J3.l lVar = this.varUntilFullyCharged;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, z7);
        return true;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_battery_charging_immediate, C2541R.string.caption_battery_charging_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        long computeChargeTimeRemaining;
        int i8 = Build.VERSION.SDK_INT;
        Double d8 = null;
        if (28 > i8 || this.varUntilFullyCharged == null) {
            B(c1708z0, 23 <= i8 ? "android.os.action.CHARGING".equals(intent.getAction()) : ((Boolean) obj).booleanValue(), null);
            return true;
        }
        BatteryManager batteryManager = (BatteryManager) c1708z0.getSystemService("batterymanager");
        boolean equals = "android.os.action.CHARGING".equals(intent.getAction());
        computeChargeTimeRemaining = batteryManager.computeChargeTimeRemaining();
        if (computeChargeTimeRemaining >= 0) {
            double d9 = computeChargeTimeRemaining;
            Double.isNaN(d9);
            Double.isNaN(d9);
            Double.isNaN(d9);
            d8 = Double.valueOf(d9 / 1000.0d);
        }
        B(c1708z0, equals, d8);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varUntilFullyCharged);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varUntilFullyCharged);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varUntilFullyCharged = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        a aVar;
        boolean C7;
        boolean isCharging;
        long computeChargeTimeRemaining;
        c1708z0.q(C2541R.string.stmt_battery_charging_title);
        boolean z7 = J1(1) == 0;
        int i8 = Build.VERSION.SDK_INT;
        Double d8 = null;
        if (23 > i8) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            Intent registerReceiver = c1708z0.registerReceiver(null, intentFilter);
            if (registerReceiver == null) {
                aVar = new a(z7, null);
            } else if (z7) {
                C7 = C(registerReceiver);
            } else {
                aVar = new a(false, Boolean.valueOf(C(registerReceiver)));
            }
            c1708z0.w(aVar);
            aVar.q(intentFilter);
            return false;
        }
        if (!z7) {
            AbstractC1618p2.c cVar = new AbstractC1618p2.c();
            c1708z0.w(cVar);
            cVar.p(2, "android.os.action.CHARGING", "android.os.action.DISCHARGING");
            return false;
        }
        BatteryManager batteryManager = (BatteryManager) c1708z0.getSystemService("batterymanager");
        if (28 <= i8 && this.varUntilFullyCharged != null) {
            isCharging = batteryManager.isCharging();
            computeChargeTimeRemaining = batteryManager.computeChargeTimeRemaining();
            if (computeChargeTimeRemaining >= 0) {
                double d9 = computeChargeTimeRemaining;
                Double.isNaN(d9);
                Double.isNaN(d9);
                Double.isNaN(d9);
                d8 = Double.valueOf(d9 / 1000.0d);
            }
            B(c1708z0, isCharging, d8);
            return true;
        }
        C7 = batteryManager.isCharging();
        B(c1708z0, C7, null);
        return true;
    }
}
