package com.llamalab.automate.stmt;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.LinkedHashMap;
import java.util.Map;
import x3.C2425c;

@F3.f("screen_brightness_set.html")
@F3.a(C2541R.integer.ic_device_access_brightness_medium)
@F3.i(C2541R.string.stmt_screen_brightness_set_title)
@F3.h(C2541R.string.stmt_screen_brightness_set_summary)
@F3.e(C2541R.layout.stmt_screen_brightness_set_edit)
/* loaded from: classes.dex */
public final class ScreenBrightnessSet extends Action implements AsyncStatement {
    public InterfaceC1700x0 adjustment;
    public InterfaceC1700x0 auto;
    public InterfaceC1700x0 level;
    public InterfaceC1700x0 scale;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? this.adjustment != null ? new E3.b[]{com.llamalab.automate.access.c.f15561v, com.llamalab.automate.access.c.f15550k} : new E3.b[]{com.llamalab.automate.access.c.f15561v} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_SETTINGS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_screen_brightness_set);
        l8.v(this.level, 0);
        return l8.y(this.auto, C2541R.string.caption_auto, 0).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.level);
        if (81 <= dVar.f6413Z) {
            dVar.g(this.scale);
        }
        dVar.g(this.auto);
        if (34 <= dVar.f6413Z) {
            dVar.g(this.adjustment);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.level);
        visitor.b(this.scale);
        visitor.b(this.auto);
        visitor.b(this.adjustment);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.level = (InterfaceC1700x0) cVar.readObject();
        if (81 <= cVar.f6409x0) {
            this.scale = (InterfaceC1700x0) cVar.readObject();
        }
        this.auto = (InterfaceC1700x0) cVar.readObject();
        if (34 <= cVar.f6409x0) {
            this.adjustment = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        float exp;
        Object c22;
        c1708z0.q(C2541R.string.stmt_screen_brightness_set_title);
        Double j8 = J3.h.j(c1708z0, this.level);
        int m8 = J3.h.m(c1708z0, this.scale, 0);
        Double j9 = J3.h.j(c1708z0, this.adjustment);
        InterfaceC1700x0 interfaceC1700x0 = this.auto;
        Boolean valueOf = (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) ? null : Boolean.valueOf(J3.h.J(c22));
        LinkedHashMap linkedHashMap = new LinkedHashMap(3);
        if (valueOf != null) {
            linkedHashMap.put("screen_brightness_mode", Integer.toString(valueOf.booleanValue() ? 1 : 0));
        }
        if (j8 != null) {
            float b8 = (float) y4.j.b(j8.doubleValue() / 100.0d, 0.0d, 1.0d);
            if (m8 != 0) {
                if (m8 != 1) {
                    throw new IllegalArgumentException("scale");
                }
                if (b8 <= 0.5f) {
                    float f8 = b8 / 0.5f;
                    exp = f8 * f8;
                } else {
                    exp = ((float) Math.exp((b8 - 0.5599107f) / 0.17883277f)) + 0.28466892f;
                }
                b8 = exp / 12.0f;
            }
            float f9 = C2425c.f("config_screenBrightnessSettingMinimumFloat", "config_screenBrightnessSettingMinimum", 0.039215688f);
            float f10 = C2425c.f("config_screenBrightnessSettingMaximumFloat", "config_screenBrightnessSettingMaximum", 1.0f);
            int round = Math.round((((f10 - f9) * b8) + f9) * 255.0f);
            if (C1710z2.a(C2425c.c(c1708z0))) {
                c1708z0.p("ScreenBrightnessSet value=" + round + ", min=" + f9 + ", max=" + f10);
            }
            linkedHashMap.put("screen_brightness", Integer.toString(round));
        }
        int i8 = Build.VERSION.SDK_INT;
        if (16 <= i8 && j9 != null) {
            linkedHashMap.put("screen_auto_brightness_adj", Float.toString((float) y4.j.b(j9.doubleValue() / 100.0d, -1.0d, 1.0d)));
        }
        if (23 <= i8 && linkedHashMap.containsKey("screen_auto_brightness_adj") && !e1.d("screen_auto_brightness_adj")) {
            if (com.llamalab.automate.access.c.f15550k.A(c1708z0)) {
                c1708z0.w(new L0(linkedHashMap));
                return false;
            }
            if (e1.c(c1708z0)) {
                ContentResolver contentResolver = c1708z0.getContentResolver();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (e1.d((String) entry.getKey())) {
                        Settings.System.putString(contentResolver, (String) entry.getKey(), (String) entry.getValue());
                    } else {
                        e1.e(c1708z0, (String) entry.getKey(), (String) entry.getValue());
                    }
                }
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
        }
        ContentResolver contentResolver2 = c1708z0.getContentResolver();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Settings.System.putString(contentResolver2, (String) entry2.getKey(), (String) entry2.getValue());
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
