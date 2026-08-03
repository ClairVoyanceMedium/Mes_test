package com.llamalab.automate.stmt;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateDreamService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.AutomateWallpaperService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1692v0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.W;
import com.llamalab.automate.X2;
import g4.C1827a;
import java.util.HashSet;

@F3.a(C2541R.integer.ic_frame_reload)
@F3.f("interface_request.html")
@F3.i(C2541R.string.stmt_interface_request_title)
@F3.h(C2541R.string.stmt_interface_request_summary)
@F3.c(C2541R.string.caption_interface_request)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_interface_request_edit)
/* loaded from: classes.dex */
public final class InterfaceRequest extends Decision implements ReceiverStatement, AsyncStatement {

    /* renamed from: L1, reason: collision with root package name */
    public static final Object[] f16800L1 = {Boolean.FALSE, null, null, null, null, null};
    public InterfaceC1700x0 interfaceUri;
    public J3.l varDisplayId;
    public J3.l varMaxHeight;
    public J3.l varMaxWidth;
    public J3.l varMinHeight;
    public J3.l varMinWidth;

    public static final class a extends AbstractC1618p2.b.a {

        /* renamed from: M1, reason: collision with root package name */
        public final int f16801M1;

        public a(int i8) {
            super(256, 1000L);
            this.f16801M1 = i8;
        }

        @Override // com.llamalab.automate.AbstractC1618p2
        public final void e(AutomateService automateService, Intent intent) {
            Bundle bundle;
            String action = intent.getAction();
            action.getClass();
            switch (action) {
                case "android.appwidget.action.APPWIDGET_UPDATE_OPTIONS":
                case "android.appwidget.action.APPWIDGET_UPDATE":
                    if (16 <= Build.VERSION.SDK_INT) {
                        bundle = intent.getBundleExtra("appWidgetOptions");
                        if (bundle == null) {
                            try {
                                bundle = AppWidgetManager.getInstance(automateService).getAppWidgetOptions(this.f16801M1);
                            } catch (IllegalArgumentException unused) {
                                c(intent, InterfaceRequest.f16800L1, false);
                            }
                        }
                    } else {
                        bundle = null;
                    }
                    c(intent, InterfaceRequest.w(bundle), false);
                    break;
                case "android.appwidget.action.APPWIDGET_DELETED":
                    a();
                    c(intent, InterfaceRequest.f16800L1, false);
                    break;
            }
        }

        @Override // com.llamalab.automate.AbstractC1618p2.b, com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (Y.a(intent, this.f16801M1)) {
                super.onReceive(context, intent);
            }
        }
    }

    public static final class b extends W.a<Object[]> implements InterfaceC1692v0 {

        /* renamed from: N1, reason: collision with root package name */
        public final long f16802N1;

        /* renamed from: O1, reason: collision with root package name */
        public final a f16803O1;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                b.this.v2(InterfaceRequest.f16800L1);
            }
        }

        public b(long j8) {
            super(256, 1000L);
            this.f16803O1 = new a();
            this.f16802N1 = j8;
        }

        @Override // com.llamalab.automate.W.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            D.c.j(automateService, this.f16803O1, new IntentFilter("com.llamalab.automate.intent.action.DREAM_SETTINGS_CHANGED"), 4);
            AutomateDreamService.a(this);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            AutomateDreamService.f14534P1.remove(this);
            try {
                automateService.unregisterReceiver(this.f16803O1);
            } catch (IllegalArgumentException unused) {
            }
            u2();
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final void Q0(AutomateDreamService automateDreamService, Configuration configuration) {
            y2(automateDreamService, configuration);
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final boolean Y1(AutomateDreamService automateDreamService) {
            if (this.f16802N1 != automateDreamService.f14546y1) {
                v2(InterfaceRequest.f16800L1);
                return false;
            }
            boolean z7 = automateDreamService.f14537M1;
            automateDreamService.f14537M1 = false;
            if (!z7) {
                return true;
            }
            y2(automateDreamService, automateDreamService.getResources().getConfiguration());
            return true;
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final void t0() {
            v2(InterfaceRequest.f16800L1);
        }

        @Override // com.llamalab.automate.W.a
        public final void w2(Object[] objArr) {
            q2(objArr, false);
        }

        public final void y2(AutomateDreamService automateDreamService, Configuration configuration) {
            Display d8 = D.c.d(automateDreamService);
            Double valueOf = Double.valueOf(configuration.screenWidthDp);
            Double valueOf2 = Double.valueOf(configuration.screenHeightDp);
            v2(new Object[]{Boolean.TRUE, valueOf, valueOf2, valueOf, valueOf2, Double.valueOf(d8.getDisplayId())});
        }
    }

    public static final class c extends W.a<Object[]> implements X2 {

        /* renamed from: N1, reason: collision with root package name */
        public final long f16805N1;

        /* renamed from: O1, reason: collision with root package name */
        public final a f16806O1;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                c.this.v2(InterfaceRequest.f16800L1);
            }
        }

        public c(long j8) {
            super(256, 1000L);
            this.f16806O1 = new a();
            this.f16805N1 = j8;
        }

        @Override // com.llamalab.automate.X2
        public final void B(int i8, int i9, DisplayMetrics displayMetrics, Display display, AutomateWallpaperService.b bVar) {
            if (this.f16805N1 != bVar.f14668g) {
                return;
            }
            y2(i8, i9, displayMetrics, display);
        }

        @Override // com.llamalab.automate.W.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            D.c.j(automateService, this.f16806O1, new IntentFilter("com.llamalab.automate.intent.action.WALLPAPER_SETTINGS_CHANGED"), 4);
            AutomateWallpaperService.a(this);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            AutomateWallpaperService.f14654x1.remove(this);
            try {
                automateService.unregisterReceiver(this.f16806O1);
            } catch (IllegalArgumentException unused) {
            }
            u2();
        }

        @Override // com.llamalab.automate.X2
        public final boolean Z(AutomateWallpaperService.b bVar) {
            if (this.f16805N1 != bVar.f14668g) {
                return false;
            }
            boolean z7 = bVar.f14672k;
            bVar.f14672k = false;
            if (z7) {
                Display d8 = D.c.d(bVar.getDisplayContext());
                Rect surfaceFrame = bVar.getSurfaceHolder().getSurfaceFrame();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                d8.getMetrics(displayMetrics);
                y2(surfaceFrame.width(), surfaceFrame.height(), displayMetrics, d8);
            }
            return false;
        }

        @Override // com.llamalab.automate.X2
        public final /* synthetic */ void h2(HashSet hashSet) {
        }

        @Override // com.llamalab.automate.X2
        public final void q1() {
            v2(InterfaceRequest.f16800L1);
        }

        @Override // com.llamalab.automate.W.a
        public final void w2(Object[] objArr) {
            q2(objArr, false);
        }

        public final void y2(int i8, int i9, DisplayMetrics displayMetrics, Display display) {
            double d8 = i8 / displayMetrics.density;
            Double.isNaN(d8);
            Double.isNaN(d8);
            Double valueOf = Double.valueOf(Math.floor(d8 + 0.5d));
            double d9 = i9 / displayMetrics.density;
            Double.isNaN(d9);
            Double.isNaN(d9);
            Double valueOf2 = Double.valueOf(Math.floor(d9 + 0.5d));
            v2(new Object[]{Boolean.TRUE, valueOf, valueOf2, valueOf, valueOf2, Double.valueOf(display.getDisplayId())});
        }
    }

    public static Object[] w(Bundle bundle) {
        Object[] objArr = (Object[]) f16800L1.clone();
        objArr[0] = Boolean.TRUE;
        if (bundle != null) {
            int i8 = bundle.getInt("appWidgetMinWidth", -1);
            if (i8 >= 0) {
                objArr[1] = Double.valueOf(i8);
            }
            int i9 = bundle.getInt("appWidgetMinHeight", -1);
            if (i9 >= 0) {
                objArr[2] = Double.valueOf(i9);
            }
            int i10 = bundle.getInt("appWidgetMaxWidth", -1);
            if (i10 >= 0) {
                objArr[3] = Double.valueOf(i10);
            }
            int i11 = bundle.getInt("appWidgetMaxHeight", -1);
            if (i11 >= 0) {
                objArr[4] = Double.valueOf(i11);
            }
            int i12 = bundle.getInt("appWidgetDisplayId", -1);
            if (i12 >= 0) {
                objArr[5] = Double.valueOf(i12);
            }
        }
        return objArr;
    }

    public final boolean B(int i8, C1708z0 c1708z0, boolean z7) {
        Bundle bundle;
        a aVar = (a) c1708z0.d(a.class, this);
        if (aVar != null) {
            if (aVar.f16801M1 == i8) {
                aVar.i0();
                return false;
            }
            aVar.a();
        }
        a aVar2 = new a(i8);
        c1708z0.w(aVar2);
        aVar2.j("android.appwidget.action.APPWIDGET_DELETED", "android.appwidget.action.APPWIDGET_UPDATE", "android.appwidget.action.APPWIDGET_UPDATE_OPTIONS");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(c1708z0);
        try {
            if (16 <= Build.VERSION.SDK_INT) {
                bundle = appWidgetManager.getAppWidgetOptions(i8);
            } else {
                if (!Y.e(c1708z0, appWidgetManager.getAppWidgetInfo(i8))) {
                    throw new IllegalArgumentException();
                }
                bundle = null;
            }
            if (!z7) {
                return false;
            }
            z(c1708z0, w(bundle));
            return true;
        } catch (IllegalArgumentException unused) {
            aVar.a();
            z(c1708z0, f16800L1);
            return true;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_interface_request);
        l8.v(this.interfaceUri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        z(c1708z0, (Object[]) obj);
        return true;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.interfaceUri);
        dVar.g(this.varMinWidth);
        dVar.g(this.varMinHeight);
        dVar.g(this.varMaxWidth);
        dVar.g(this.varMaxHeight);
        dVar.g(this.varDisplayId);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.interfaceUri);
        visitor.b(this.varMinWidth);
        visitor.b(this.varMinHeight);
        visitor.b(this.varMaxWidth);
        visitor.b(this.varMaxHeight);
        visitor.b(this.varDisplayId);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.interfaceUri = (InterfaceC1700x0) cVar.readObject();
        this.varMinWidth = (J3.l) cVar.readObject();
        this.varMinHeight = (J3.l) cVar.readObject();
        this.varMaxWidth = (J3.l) cVar.readObject();
        this.varMaxHeight = (J3.l) cVar.readObject();
        this.varDisplayId = (J3.l) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0155, code lost:
    
        if (r0 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0168, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0166, code lost:
    
        if (r0 != null) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0175  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        Cursor query;
        c1708z0.q(C2541R.string.stmt_interface_request_title);
        C1644g c1644g = null;
        Uri A7 = J3.h.A(c1708z0, this.interfaceUri, null);
        if (A7 == null) {
            throw new RequiredArgumentNullException("interfaceUri");
        }
        int match = C1827a.m.C0206a.f18790a.match(A7);
        Object[] objArr = f16800L1;
        boolean z7 = true;
        com.llamalab.automate.F0 f02 = c1708z0.f17641Z;
        if (match != 10) {
            if (match == 12) {
                Y.h(f02.f14847y0, A7);
                IncapableAndroidVersionException.a(17);
                query = c1708z0.getContentResolver().query(A7, new String[]{"native_id"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
                try {
                    if (!query.moveToNext()) {
                        z(c1708z0, objArr);
                        query.close();
                        return true;
                    }
                    long j8 = query.getLong(0);
                    query.close();
                    b bVar = (b) c1708z0.d(b.class, this);
                    if (bVar != null) {
                        if (bVar.f16802N1 == j8) {
                            bVar.x2();
                            return false;
                        }
                        bVar.a();
                    }
                    c1708z0.w(new b(j8));
                    return false;
                } finally {
                }
            }
            if (match != 14) {
                throw new IllegalArgumentException("Unsupported interface URI");
            }
            Y.h(f02.f14847y0, A7);
            IncapableAndroidVersionException.a(21);
            if (Y.f(c1708z0)) {
                query = c1708z0.getContentResolver().query(A7, new String[]{"native_id"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
                try {
                    if (query.moveToNext()) {
                        long j9 = query.getLong(0);
                        query.close();
                        c cVar = (c) c1708z0.d(c.class, this);
                        if (cVar != null) {
                            if (cVar.f16805N1 == j9) {
                                cVar.x2();
                                return false;
                            }
                            cVar.a();
                        }
                        c1708z0.w(new c(j9));
                        return false;
                    }
                    z(c1708z0, objArr);
                } finally {
                }
            } else {
                z(c1708z0, objArr);
            }
            return true;
        }
        Y.h(f02.f14847y0, A7);
        C1644g c1644g2 = (C1644g) c1708z0.c(C1644g.class);
        try {
            if (c1644g2 != null) {
                try {
                    if (A7.equals(c1644g2.f17417L1)) {
                        try {
                            z7 = B(c1644g2.f17418M1, c1708z0, true);
                            c1644g2.v2(new Intent());
                            return z7;
                        } catch (Throwable th) {
                            c1644g2.v2(new Intent());
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                                if (c1644g != null) {
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    c1644g = c1644g2;
                    if (c1644g != null) {
                        c1644g.a();
                    }
                    throw th;
                }
            }
            if (query.moveToNext()) {
                z7 = B(query.getInt(0), c1708z0, c1644g2 != null);
            } else {
                z(c1708z0, objArr);
            }
        } finally {
        }
        query = c1708z0.getContentResolver().query(A7, new String[]{"native_id"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        z(c1708z0, (Object[]) obj);
        return true;
    }

    public final void z(C1708z0 c1708z0, Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        Double d8 = (Double) objArr[1];
        Double d9 = (Double) objArr[2];
        Double d10 = (Double) objArr[3];
        Double d11 = (Double) objArr[4];
        Double d12 = (Double) objArr[5];
        J3.l lVar = this.varMinWidth;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        J3.l lVar2 = this.varMinHeight;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d9);
        }
        J3.l lVar3 = this.varMaxWidth;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d10);
        }
        J3.l lVar4 = this.varMaxHeight;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, d11);
        }
        J3.l lVar5 = this.varDisplayId;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, d12);
        }
        o(c1708z0, booleanValue);
    }
}
