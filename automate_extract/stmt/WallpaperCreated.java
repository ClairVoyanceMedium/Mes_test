package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.AutomateWallpaperService;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.X2;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

@F3.f("wallpaper_created.html")
@F3.a(C2541R.integer.ic_wallpaper)
@F3.i(C2541R.string.stmt_wallpaper_created_title)
@F3.h(C2541R.string.stmt_wallpaper_created_summary)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_wallpaper_created_edit)
/* loaded from: classes.dex */
public final class WallpaperCreated extends Decision implements InterfaceC1622q2, ReceiverStatement {

    /* renamed from: L1, reason: collision with root package name */
    public int f17268L1 = -1;
    public J3.l varFeatures;
    public J3.l varInterfaceUri;

    public static final class a extends AbstractC1618p2.c implements X2 {

        /* renamed from: L1, reason: collision with root package name */
        public static final Object[] f17269L1 = {Boolean.FALSE, null, null};

        /* renamed from: x1, reason: collision with root package name */
        public final AtomicBoolean f17270x1 = new AtomicBoolean();

        /* renamed from: y1, reason: collision with root package name */
        public final long f17271y1;

        public a(long j8) {
            this.f17271y1 = j8;
        }

        @Override // com.llamalab.automate.X2
        public final /* synthetic */ void B(int i8, int i9, DisplayMetrics displayMetrics, Display display, AutomateWallpaperService.b bVar) {
        }

        @Override // com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            AutomateWallpaperService.a(this);
        }

        @Override // com.llamalab.automate.AbstractC1618p2.c, com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            AutomateWallpaperService.b(this);
            try {
                automateService.unregisterReceiver(this);
            } catch (Throwable unused) {
            }
        }

        @Override // com.llamalab.automate.X2
        public final boolean Z(AutomateWallpaperService.b bVar) {
            long j8 = AutomateWallpaperService.this.f14658Z;
            AtomicBoolean atomicBoolean = this.f17270x1;
            if (this.f17271y1 != j8) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    c(new Intent(), f17269L1, false);
                }
                return false;
            }
            if (bVar.f14671j || !atomicBoolean.compareAndSet(false, true)) {
                return false;
            }
            bVar.f14671j = true;
            c(new Intent(), new Object[]{Boolean.TRUE, String.valueOf(bVar.f14668g), Double.valueOf(34 <= Build.VERSION.SDK_INT ? bVar.getWallpaperFlags() : 3)}, false);
            return true;
        }

        @Override // com.llamalab.automate.X2
        public final /* synthetic */ void h2(HashSet hashSet) {
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.getClass();
            boolean equals = action.equals("android.intent.action.WALLPAPER_CHANGED");
            Object[] objArr = f17269L1;
            AtomicBoolean atomicBoolean = this.f17270x1;
            if (equals) {
                if (Y.f(this.f16157Y) || atomicBoolean.compareAndSet(false, true)) {
                    return;
                }
            } else {
                if (!action.equals("com.llamalab.automate.intent.action.WALLPAPER_SETTINGS_CHANGED")) {
                    return;
                }
                if (this.f17271y1 == intent.getBundleExtra("com.llamalab.automate.intent.extra.WALLPAPER_OPTIONS").getLong("fiber_id") || !atomicBoolean.compareAndSet(false, true)) {
                    return;
                }
            }
            c(intent, objArr, false);
        }

        @Override // com.llamalab.automate.X2
        public final void q1() {
            if (Y.f(this.f16157Y) || this.f17270x1.compareAndSet(false, true)) {
                return;
            }
            c(new Intent(), f17269L1, false);
        }
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        if (objArr[1] != null) {
            objArr[1] = Y.c(c1708z0.getContentResolver(), c1708z0.f17641Z, 6, (String) objArr[1]).toString();
        }
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        String str = (String) objArr[1];
        Double d8 = (Double) objArr[2];
        J3.l lVar = this.varInterfaceUri;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varFeatures;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d8);
        }
        o(c1708z0, booleanValue);
        return true;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varInterfaceUri);
        dVar.g(this.varFeatures);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varInterfaceUri);
        visitor.b(this.varFeatures);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f17268L1 = c1625r2.d(true);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varInterfaceUri = (J3.l) cVar.readObject();
        this.varFeatures = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_wallpaper_created_title);
        IncapableAndroidVersionException.a(21);
        Long l8 = (Long) c1708z0.j(this.f17268L1);
        if (l8 == null) {
            l8 = Long.valueOf(c1708z0.f17644y0);
            c1708z0.z(this.f17268L1, l8);
        }
        a aVar = new a(l8.longValue());
        c1708z0.w(aVar);
        aVar.p(4, "com.llamalab.automate.intent.action.WALLPAPER_SETTINGS_CHANGED", "android.intent.action.WALLPAPER_CHANGED");
        return false;
    }
}
