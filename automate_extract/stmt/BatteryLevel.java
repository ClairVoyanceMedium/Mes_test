package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ReceiverStatement;

@F3.f("battery_level.html")
@F3.a(C2541R.integer.ic_device_access_battery)
@F3.i(C2541R.string.stmt_battery_level_title)
@F3.h(C2541R.string.stmt_battery_level_summary)
@F3.e(C2541R.layout.stmt_battery_level_edit)
/* loaded from: classes.dex */
public final class BatteryLevel extends LevelDecision implements ReceiverStatement {

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public final boolean f16331L1;

        /* renamed from: M1, reason: collision with root package name */
        public Boolean f16332M1;

        /* renamed from: x1, reason: collision with root package name */
        public final Double f16333x1;

        /* renamed from: y1, reason: collision with root package name */
        public final Double f16334y1;

        public a(Boolean bool, Double d8, Double d9, boolean z7) {
            this.f16331L1 = z7 || (d8 == null && d9 == null);
            this.f16332M1 = bool;
            this.f16333x1 = d8;
            this.f16334y1 = d9;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Boolean bool;
            if (isInitialStickyBroadcast()) {
                return;
            }
            double F7 = BatteryLevel.F(intent);
            Boolean valueOf = Boolean.valueOf(LevelDecision.E(F7, this.f16333x1, this.f16334y1));
            if (this.f16331L1 || ((bool = this.f16332M1) != null && !valueOf.equals(bool))) {
                c(intent, new Object[]{valueOf, Double.valueOf(F7)}, false);
            }
            this.f16332M1 = valueOf;
        }
    }

    public static double F(Intent intent) {
        double intExtra = intent.getIntExtra("level", 0);
        double max = Math.max(intent.getIntExtra("scale", 1), 1);
        Double.isNaN(intExtra);
        Double.isNaN(max);
        return (intExtra / max) * 100.0d;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_battery_level_immediate, C2541R.string.caption_battery_level_change);
        c1596k0.n(this.minLevel, this.maxLevel, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (Double) objArr[1]);
        return true;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_battery_level_title);
        Double D7 = D(c1708z0);
        Double C7 = C(c1708z0);
        boolean z7 = J1(1) == 0;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Boolean bool = null;
        Intent registerReceiver = c1708z0.registerReceiver(null, intentFilter);
        if (registerReceiver != null) {
            double F7 = F(registerReceiver);
            Boolean valueOf = Boolean.valueOf(LevelDecision.E(F7, D7, C7));
            if (z7) {
                B(c1708z0, valueOf.booleanValue(), Double.valueOf(F7));
                return true;
            }
            bool = valueOf;
        }
        a aVar = new a(bool, D7, C7, z7);
        c1708z0.w(aVar);
        aVar.q(intentFilter);
        return false;
    }
}
