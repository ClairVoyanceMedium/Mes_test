package com.llamalab.automate.stmt;

import C1.D1;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.llamalab.automate.A2;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.AutomateNotificationListenerService;
import com.llamalab.automate.BlockView;
import com.llamalab.automate.C1617p1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.D;
import com.llamalab.automate.FlowDetailsActivity;
import com.llamalab.automate.Flowchart;
import x3.C2424b;
import x3.C2425c;
import x3.C2440r;
import z3.C2514f;

@F3.a(C2541R.integer.ic_todo)
/* loaded from: classes.dex */
public abstract class AbstractStatement implements A2 {

    /* renamed from: X, reason: collision with root package name */
    public long f16218X;

    /* renamed from: Y, reason: collision with root package name */
    public int f16219Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f16220Z;

    public static void d(C1708z0 c1708z0, A2 a22, String str) {
        if (21 <= Build.VERSION.SDK_INT) {
            c1708z0.getClass();
            c1708z0.I(com.llamalab.automate.D.class, a22.g());
        }
        PendingIntent l8 = c1708z0.l(536870912 | C2424b.f23371b, str);
        if (l8 != null) {
            ((AlarmManager) c1708z0.getSystemService("alarm")).cancel(l8);
            l8.cancel();
        }
    }

    public static AutomateAccessibilityService f() {
        AutomateAccessibilityService automateAccessibilityService = AutomateAccessibilityService.f14500S1.get();
        if (automateAccessibilityService != null) {
            return automateAccessibilityService;
        }
        throw new IllegalStateException("Accessibility service not running");
    }

    public static BluetoothAdapter h(Context context) {
        BluetoothAdapter defaultAdapter;
        if (18 <= Build.VERSION.SDK_INT) {
            BluetoothManager d8 = L.o.d(context.getSystemService("bluetooth"));
            if (d8 == null) {
                throw new IllegalStateException("Bluetooth not supported");
            }
            defaultAdapter = d8.getAdapter();
        } else {
            defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        if (defaultAdapter != null) {
            return defaultAdapter;
        }
        throw new IllegalStateException("Bluetooth not supported");
    }

    public static AutomateNotificationListenerService j() {
        AutomateNotificationListenerService automateNotificationListenerService = AutomateNotificationListenerService.f14554Y.get();
        if (automateNotificationListenerService != null) {
            return automateNotificationListenerService;
        }
        throw new IllegalStateException("Notification listener service not running");
    }

    public static WifiManager l(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager != null) {
            return wifiManager;
        }
        throw new IllegalStateException("Wi-Fi not supported");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m(C1708z0 c1708z0, int i8, boolean z7, long j8, long j9, String str, Bundle bundle) {
        boolean z8;
        long j10 = j8;
        int i9 = C2425c.c(c1708z0).getInt("alarmWorkarounds", 0);
        int i10 = Build.VERSION.SDK_INT;
        if (21 <= i10) {
            if (!z7 || (i9 & 2) == 0) {
                long currentTimeMillis = j10 - (i8 == 1 || i8 == 0 ? System.currentTimeMillis() : SystemClock.elapsedRealtime());
                long j11 = 100 + currentTimeMillis;
                synchronized (com.llamalab.android.app.a.class) {
                    if (com.llamalab.android.app.a.f13997b == null) {
                        com.llamalab.android.app.a.f13997b = new com.llamalab.android.app.a(c1708z0.getApplicationContext());
                    }
                }
                if (j11 < com.llamalab.android.app.a.f13997b.f13998a) {
                    D.a aVar = new D.a(bundle);
                    c1708z0.w(aVar);
                    if (i8 == 0 || i8 == 2) {
                        aVar.n2(1);
                    }
                    c1708z0.j2().f14581L1.postDelayed(aVar, currentTimeMillis);
                } else {
                    z8 = false;
                    if (z8) {
                        return;
                    }
                }
            } else {
                try {
                    D.b bVar = new D.b(bundle);
                    c1708z0.w(bVar);
                    com.llamalab.android.app.e.d().e(i8, j10, bVar);
                } catch (Throwable th) {
                    Log.e("AbstractStatement", "Native timer failure", th);
                    throw new UnsupportedOperationException("Native timer workaround failed");
                }
            }
            z8 = true;
            if (z8) {
            }
        }
        int i11 = C2424b.f23371b | 134217728;
        PendingIntent m8 = c1708z0.m(str, bundle, i11, 0);
        AlarmManager alarmManager = (AlarmManager) c1708z0.getSystemService("alarm");
        if (z7) {
            if (21 <= i10 && (i9 & 1) != 0) {
                if (i8 == 0 || i8 == 2) {
                    boolean z9 = true;
                    if (i8 != 1 && i8 != 0) {
                        z9 = false;
                    }
                    if (!z9) {
                        j10 = (j10 - SystemClock.elapsedRealtime()) + System.currentTimeMillis();
                    }
                    alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j10 + 1, PendingIntent.getActivity(c1708z0, 0, new Intent("android.intent.action.VIEW", F5.n.e(c1708z0), c1708z0, FlowDetailsActivity.class), i11)), m8);
                    return;
                }
            }
            if (23 <= i10) {
                if (i8 == 0 || i8 == 2) {
                    alarmManager.setExactAndAllowWhileIdle(i8, j10, m8);
                    return;
                }
            }
            if (19 <= i10) {
                alarmManager.setExact(i8, j10, m8);
                return;
            }
        } else {
            if (23 <= i10) {
                if (i8 == 0 || i8 == 2) {
                    alarmManager.setAndAllowWhileIdle(i8, j10, m8);
                    return;
                }
            }
            if (19 <= i10 && j9 > 0) {
                alarmManager.setWindow(i8, j8, j9, m8);
                return;
            }
        }
        alarmManager.set(i8, j10, m8);
    }

    @Override // com.llamalab.automate.A2
    public final CharSequence A(Context context) {
        return context.getText(((F3.i) C2440r.t(F3.i.class, getClass())).value());
    }

    @Override // com.llamalab.automate.A2
    public void C1(C1708z0 c1708z0) {
    }

    @Override // com.llamalab.automate.A2
    public E3.b[] K0(Context context) {
        return com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.A2
    public CharSequence M1(Context context) {
        F3.c cVar = (F3.c) C2440r.t(F3.c.class, getClass());
        return cVar != null ? context.getText(cVar.value()) : A(context);
    }

    @Override // com.llamalab.automate.A2
    public final C1617p1.b N1(Context context, int i8, ColorStateList colorStateList) {
        return C1617p1.u(context).q((char) context.getResources().getInteger(((F3.a) C2440r.t(F3.a.class, getClass())).value()), i8, colorStateList);
    }

    @Override // com.llamalab.automate.A2
    public final String O0(Context context) {
        F3.f fVar = (F3.f) C2440r.t(F3.f.class, getClass());
        String string = context.getString(C2541R.string.assets_help_root);
        if (fVar == null) {
            return D1.P.n(string, "/block/todo.html");
        }
        StringBuilder p8 = C1.H0.p(string, "/block/");
        p8.append(fVar.value());
        return p8.toString();
    }

    @Override // R3.e
    public void Y0(R3.d dVar) {
        dVar.d(this.f16218X);
        dVar.c(this.f16219Y);
        dVar.c(this.f16220Z);
    }

    @Override // com.llamalab.automate.A2
    public final BlockView c0(Flowchart flowchart, LayoutInflater layoutInflater) {
        Context context = layoutInflater.getContext();
        BlockView blockView = (BlockView) layoutInflater.inflate(((F3.b) C2440r.t(F3.b.class, getClass())).value(), (ViewGroup) flowchart, false);
        blockView.setStatement(this);
        ViewGroup.LayoutParams layoutParams = blockView.getLayoutParams();
        if (layoutParams instanceof C2514f.a) {
            C2514f.a aVar = (C2514f.a) layoutParams;
            int i8 = this.f16219Y;
            int i9 = this.f16220Z;
            aVar.f23673a = i8;
            aVar.f23674b = i9;
        }
        blockView.getIdentity().setText(Long.toString(this.f16218X));
        AppCompatTextView center = blockView.getCenter();
        center.setText(M1(context));
        center.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, N1(context, context.getResources().getDimensionPixelSize(C2541R.dimen.flowchart_center_icon_size), ColorStateList.valueOf(-16777216)), (Drawable) null, (Drawable) null);
        return blockView;
    }

    public final void e(Context context) {
        for (E3.b bVar : K0(context)) {
            bVar.w(context);
        }
    }

    @Override // com.llamalab.automate.A2
    public C2 e0() {
        return new C2();
    }

    @Override // com.llamalab.automate.A2
    public final long g() {
        return this.f16218X;
    }

    @Override // R3.e
    public void o0(R3.c cVar) {
        this.f16218X = cVar.b();
        this.f16219Y = cVar.a();
        this.f16220Z = cVar.a();
    }

    @Override // com.llamalab.automate.A2
    public final CharSequence q0(Context context) {
        return context.getText(((F3.h) C2440r.t(F3.h.class, getClass())).value());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[statementId=");
        sb.append(this.f16218X);
        sb.append(", cell={");
        sb.append(this.f16219Y);
        sb.append(",");
        return D1.l(sb, this.f16220Z, "}]");
    }

    @Override // com.llamalab.automate.A2
    public final void u0(int i8, int i9) {
        this.f16219Y = i8;
        this.f16220Z = i9;
    }

    @Override // com.llamalab.automate.A2
    public final void y(long j8) {
        this.f16218X = j8;
    }
}
