package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.Visitor;
import x3.C2425c;
import x3.C2446x;

@F3.f("battery_properties.html")
@F3.a(C2541R.integer.ic_device_access_battery)
@F3.i(C2541R.string.stmt_battery_properties_title)
@F3.h(C2541R.string.stmt_battery_properties_summary)
@F3.e(C2541R.layout.stmt_battery_properties_edit)
/* loaded from: classes.dex */
public final class BatteryProperties extends Action {
    public J3.l varCapacity;
    public J3.l varRemainingCharge;
    public J3.l varRemainingEnergy;
    public J3.l varRemainingPercent;
    public J3.l varTechnology;
    public J3.l varTemperature;
    public J3.l varUsageCurrentAverage;
    public J3.l varUsageCurrentNow;
    public J3.l varVoltage;

    public static Intent q(Context context, Intent intent) {
        if (intent != null) {
            return intent;
        }
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return registerReceiver == null ? new Intent() : registerReceiver;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varCapacity);
        dVar.g(this.varRemainingPercent);
        dVar.g(this.varRemainingCharge);
        dVar.g(this.varRemainingEnergy);
        dVar.g(this.varUsageCurrentNow);
        dVar.g(this.varUsageCurrentAverage);
        dVar.g(this.varVoltage);
        dVar.g(this.varTemperature);
        dVar.g(this.varTechnology);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.varCapacity);
        visitor.b(this.varRemainingPercent);
        visitor.b(this.varRemainingCharge);
        visitor.b(this.varRemainingEnergy);
        visitor.b(this.varUsageCurrentNow);
        visitor.b(this.varUsageCurrentAverage);
        visitor.b(this.varVoltage);
        visitor.b(this.varTemperature);
        visitor.b(this.varTechnology);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varCapacity = (J3.l) cVar.readObject();
        this.varRemainingPercent = (J3.l) cVar.readObject();
        this.varRemainingCharge = (J3.l) cVar.readObject();
        this.varRemainingEnergy = (J3.l) cVar.readObject();
        this.varUsageCurrentNow = (J3.l) cVar.readObject();
        this.varUsageCurrentAverage = (J3.l) cVar.readObject();
        this.varVoltage = (J3.l) cVar.readObject();
        this.varTemperature = (J3.l) cVar.readObject();
        this.varTechnology = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Intent intent;
        Double d8;
        Double d9;
        int intProperty;
        Double d10;
        double d11;
        int intProperty2;
        Double d12;
        double d13;
        long longProperty;
        Double d14;
        int intProperty3;
        Double d15;
        int intProperty4;
        c1708z0.q(C2541R.string.stmt_battery_properties_title);
        Double d16 = null;
        if (this.varCapacity != null) {
            double b8 = C2425c.b();
            c1708z0.z(this.varCapacity.f4659Y, b8 > 0.0d ? Double.valueOf(b8) : null);
        }
        if (21 <= Build.VERSION.SDK_INT) {
            BatteryManager batteryManager = (BatteryManager) c1708z0.getSystemService("batterymanager");
            if (this.varRemainingPercent != null) {
                intProperty4 = batteryManager.getIntProperty(4);
                c1708z0.z(this.varRemainingPercent.f4659Y, Integer.MIN_VALUE != intProperty4 ? Double.valueOf(intProperty4) : null);
            }
            if (this.varRemainingCharge != null) {
                intProperty3 = batteryManager.getIntProperty(1);
                J3.l lVar = this.varRemainingCharge;
                if (Integer.MIN_VALUE != intProperty3) {
                    double d17 = intProperty3;
                    Double.isNaN(d17);
                    Double.isNaN(d17);
                    Double.isNaN(d17);
                    Double.isNaN(d17);
                    d15 = Double.valueOf(d17 / 1000.0d);
                } else {
                    d15 = null;
                }
                c1708z0.z(lVar.f4659Y, d15);
            }
            if (this.varRemainingEnergy != null) {
                longProperty = batteryManager.getLongProperty(5);
                J3.l lVar2 = this.varRemainingEnergy;
                if (Long.MIN_VALUE != longProperty) {
                    double d18 = longProperty;
                    Double.isNaN(d18);
                    Double.isNaN(d18);
                    Double.isNaN(d18);
                    Double.isNaN(d18);
                    d14 = Double.valueOf(d18 / 1000000.0d);
                } else {
                    d14 = null;
                }
                c1708z0.z(lVar2.f4659Y, d14);
            }
            if (this.varUsageCurrentNow != null) {
                intProperty2 = batteryManager.getIntProperty(2);
                J3.l lVar3 = this.varUsageCurrentNow;
                if (Integer.MIN_VALUE != intProperty2) {
                    String str = Build.MANUFACTURER;
                    if (str == null || !C2446x.c(str, "samsung")) {
                        double d19 = intProperty2;
                        Double.isNaN(d19);
                        Double.isNaN(d19);
                        Double.isNaN(d19);
                        Double.isNaN(d19);
                        d13 = d19 / (-1000.0d);
                    } else {
                        d13 = -intProperty2;
                    }
                    d12 = Double.valueOf(d13);
                } else {
                    d12 = null;
                }
                c1708z0.z(lVar3.f4659Y, d12);
            }
            if (this.varUsageCurrentAverage != null) {
                intProperty = batteryManager.getIntProperty(3);
                J3.l lVar4 = this.varUsageCurrentAverage;
                if (Integer.MIN_VALUE != intProperty) {
                    String str2 = Build.MANUFACTURER;
                    if (str2 == null || !C2446x.c(str2, "motorola")) {
                        double d20 = intProperty;
                        Double.isNaN(d20);
                        Double.isNaN(d20);
                        Double.isNaN(d20);
                        Double.isNaN(d20);
                        d11 = d20 / (-1000.0d);
                    } else {
                        d11 = intProperty;
                    }
                    d10 = Double.valueOf(d11);
                } else {
                    d10 = null;
                }
                c1708z0.z(lVar4.f4659Y, d10);
            }
            intent = null;
        } else {
            if (this.varRemainingPercent != null) {
                intent = q(c1708z0, null);
                int intExtra = intent.getIntExtra("level", -1);
                int intExtra2 = intent.getIntExtra("scale", -1);
                J3.l lVar5 = this.varRemainingPercent;
                if (intExtra < 0 || intExtra2 < 1) {
                    d8 = null;
                } else {
                    double d21 = intExtra;
                    double d22 = intExtra2;
                    Double.isNaN(d21);
                    Double.isNaN(d22);
                    Double.isNaN(d21);
                    Double.isNaN(d22);
                    Double.isNaN(d21);
                    Double.isNaN(d22);
                    d8 = Double.valueOf((d21 / d22) * 100.0d);
                }
                c1708z0.z(lVar5.f4659Y, d8);
            } else {
                intent = null;
            }
            J3.l lVar6 = this.varRemainingCharge;
            if (lVar6 != null) {
                c1708z0.z(lVar6.f4659Y, null);
            }
            J3.l lVar7 = this.varRemainingEnergy;
            if (lVar7 != null) {
                c1708z0.z(lVar7.f4659Y, null);
            }
            J3.l lVar8 = this.varUsageCurrentNow;
            if (lVar8 != null) {
                c1708z0.z(lVar8.f4659Y, null);
            }
            J3.l lVar9 = this.varUsageCurrentAverage;
            if (lVar9 != null) {
                c1708z0.z(lVar9.f4659Y, null);
            }
        }
        if (this.varVoltage != null) {
            intent = q(c1708z0, intent);
            int intExtra3 = intent.getIntExtra("voltage", Integer.MIN_VALUE);
            J3.l lVar10 = this.varVoltage;
            if (Integer.MIN_VALUE != intExtra3) {
                double d23 = intExtra3;
                d9 = F5.n.l(d23, d23, d23, 1000.0d);
            } else {
                d9 = null;
            }
            c1708z0.z(lVar10.f4659Y, d9);
        }
        if (this.varTemperature != null) {
            intent = q(c1708z0, intent);
            int intExtra4 = intent.getIntExtra("temperature", Integer.MIN_VALUE);
            J3.l lVar11 = this.varTemperature;
            if (Integer.MIN_VALUE != intExtra4) {
                double d24 = intExtra4;
                d16 = F5.n.l(d24, d24, d24, 10.0d);
            }
            c1708z0.z(lVar11.f4659Y, d16);
        }
        if (this.varTechnology != null) {
            c1708z0.z(this.varTechnology.f4659Y, q(c1708z0, intent).getStringExtra("technology"));
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
