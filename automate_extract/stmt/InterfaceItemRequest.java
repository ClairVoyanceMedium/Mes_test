package com.llamalab.automate.stmt;

import C1.D1;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateDreamService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.AutomateWallpaperService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.E1;
import com.llamalab.automate.F1;
import com.llamalab.automate.G1;
import com.llamalab.automate.InterfaceC1692v0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.X2;
import g4.C1827a;
import i0.C1896a;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import x3.C2434l;

@F3.a(C2541R.integer.ic_frame_reload)
@F3.f("interface_item_request.html")
@F3.i(C2541R.string.stmt_interface_item_request_title)
@F3.h(C2541R.string.stmt_interface_item_request_summary)
@F3.c(C2541R.string.caption_interface_item_request)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_interface_item_request_edit)
/* loaded from: classes.dex */
public final class InterfaceItemRequest extends Decision implements AsyncStatement {

    /* renamed from: L1, reason: collision with root package name */
    public static final Object[] f16776L1 = {Boolean.FALSE, null};
    public InterfaceC1700x0 adapterViewId;
    public InterfaceC1700x0 interfaceUri;
    public J3.l varItemPosition;

    public static abstract class a extends com.llamalab.automate.W implements G1, Runnable {

        /* renamed from: L1, reason: collision with root package name */
        public final Uri f16777L1;

        /* renamed from: N1, reason: collision with root package name */
        public int f16779N1;

        /* renamed from: O1, reason: collision with root package name */
        public volatile boolean f16780O1;

        /* renamed from: P1, reason: collision with root package name */
        public volatile boolean f16781P1;

        /* renamed from: y1, reason: collision with root package name */
        public final Object f16782y1 = new Object();

        /* renamed from: M1, reason: collision with root package name */
        public int[] f16778M1 = C2434l.f23393d;

        public a(Uri uri) {
            this.f16777L1 = uri;
        }

        @Override // com.llamalab.automate.G1
        public final void A1(int[] iArr) {
            synchronized (this.f16782y1) {
                this.f16778M1 = iArr;
                this.f16779N1 = 0;
            }
            if (this.f16780O1) {
                this.f15400Y.f14581L1.post(this);
            }
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public void C(AutomateService automateService, long j8, long j9, long j10) {
            E1 e12;
            super.C(automateService, j8, j9, j10);
            this.f16780O1 = true;
            F1 c8 = F1.c(automateService);
            Uri uri = this.f16777L1;
            synchronized (c8.f14854X) {
                HashMap hashMap = c8.f14856Z;
                uri.getClass();
                Set set = (Set) hashMap.get(uri);
                if (set == null) {
                    HashMap hashMap2 = c8.f14856Z;
                    Set newSetFromMap = Collections.newSetFromMap(new WeakHashMap());
                    hashMap2.put(uri, newSetFromMap);
                    set = newSetFromMap;
                }
                if (set.add(this) && (e12 = c8.f14855Y.get(uri)) != null) {
                    e12.g(this);
                }
            }
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public void F(AutomateService automateService) {
            E1 e12;
            this.f16780O1 = false;
            F1 c8 = F1.c(automateService);
            Uri uri = this.f16777L1;
            synchronized (c8.f14854X) {
                HashMap hashMap = c8.f14856Z;
                uri.getClass();
                Set set = (Set) hashMap.get(uri);
                if (set != null && set.remove(this) && (e12 = c8.f14855Y.get(uri)) != null) {
                    e12.a(this);
                }
            }
            automateService.f14581L1.removeCallbacks(this);
            u2();
        }

        public void q1() {
            v2();
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i8;
            while (this.f16780O1) {
                if (this.f16781P1) {
                    this.f16780O1 = false;
                    q2(InterfaceItemRequest.f16776L1, false);
                    return;
                }
                synchronized (this.f16782y1) {
                    int i9 = this.f16779N1;
                    int[] iArr = this.f16778M1;
                    if (i9 >= iArr.length) {
                        return;
                    }
                    this.f16779N1 = i9 + 1;
                    i8 = iArr[i9];
                }
                this.f16780O1 = false;
                q2(new Object[]{Boolean.TRUE, Double.valueOf(i8)}, false);
            }
        }

        public void t0() {
            v2();
        }

        public final void v2() {
            this.f16781P1 = true;
            if (this.f16780O1) {
                this.f15400Y.f14581L1.post(this);
            }
        }

        public final void w2() {
            this.f16780O1 = true;
            this.f15400Y.f14581L1.post(this);
        }
    }

    public static final class b extends a {

        /* renamed from: Q1, reason: collision with root package name */
        public final int f16783Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final a f16784R1;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                b bVar = b.this;
                if (Y.a(intent, bVar.f16783Q1)) {
                    bVar.v2();
                }
            }
        }

        public b(Uri uri, int i8) {
            super(uri);
            this.f16784R1 = new a();
            this.f16783Q1 = i8;
        }

        @Override // com.llamalab.automate.stmt.InterfaceItemRequest.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            C1896a.a(automateService).b(this.f16784R1, new IntentFilter("android.appwidget.action.APPWIDGET_DELETED"));
        }

        @Override // com.llamalab.automate.stmt.InterfaceItemRequest.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            C1896a.a(automateService).d(this.f16784R1);
            super.F(automateService);
        }
    }

    public static final class c extends a implements InterfaceC1692v0 {

        /* renamed from: Q1, reason: collision with root package name */
        public final long f16786Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final a f16787R1;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                c.this.v2();
            }
        }

        public c(long j8, Uri uri) {
            super(uri);
            this.f16787R1 = new a();
            this.f16786Q1 = j8;
        }

        @Override // com.llamalab.automate.stmt.InterfaceItemRequest.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            D.c.j(automateService, this.f16787R1, new IntentFilter("com.llamalab.automate.intent.action.DREAM_SETTINGS_CHANGED"), 4);
            AutomateDreamService.a(this);
        }

        @Override // com.llamalab.automate.stmt.InterfaceItemRequest.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            AutomateDreamService.f14534P1.remove(this);
            try {
                automateService.unregisterReceiver(this.f16787R1);
            } catch (IllegalArgumentException unused) {
            }
            super.F(automateService);
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final /* synthetic */ void Q0(AutomateDreamService automateDreamService, Configuration configuration) {
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final boolean Y1(AutomateDreamService automateDreamService) {
            if (this.f16786Q1 == automateDreamService.f14546y1) {
                return false;
            }
            v2();
            return false;
        }
    }

    public static final class d extends a implements X2 {

        /* renamed from: Q1, reason: collision with root package name */
        public final long f16789Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final a f16790R1;

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                d.this.v2();
            }
        }

        public d(long j8, Uri uri) {
            super(uri);
            this.f16790R1 = new a();
            this.f16789Q1 = j8;
        }

        @Override // com.llamalab.automate.X2
        public final /* synthetic */ void B(int i8, int i9, DisplayMetrics displayMetrics, Display display, AutomateWallpaperService.b bVar) {
        }

        @Override // com.llamalab.automate.stmt.InterfaceItemRequest.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            D.c.j(automateService, this.f16790R1, new IntentFilter("com.llamalab.automate.intent.action.WALLPAPER_SETTINGS_CHANGED"), 4);
            AutomateWallpaperService.a(this);
        }

        @Override // com.llamalab.automate.stmt.InterfaceItemRequest.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            AutomateWallpaperService.f14654x1.remove(this);
            try {
                automateService.unregisterReceiver(this.f16790R1);
            } catch (IllegalArgumentException unused) {
            }
            super.F(automateService);
        }

        @Override // com.llamalab.automate.X2
        public final /* synthetic */ boolean Z(AutomateWallpaperService.b bVar) {
            return false;
        }

        @Override // com.llamalab.automate.X2
        public final void h2(HashSet hashSet) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                if (this.f16789Q1 == ((AutomateWallpaperService.b) it.next()).f14668g) {
                    return;
                }
            }
            v2();
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_interface_item_request);
        l8.v(this.interfaceUri, 0);
        l8.v(this.adapterViewId, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.interfaceUri);
        dVar.g(this.adapterViewId);
        dVar.g(this.varItemPosition);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.interfaceUri);
        visitor.b(this.adapterViewId);
        visitor.b(this.varItemPosition);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.interfaceUri = (InterfaceC1700x0) cVar.readObject();
        this.adapterViewId = (InterfaceC1700x0) cVar.readObject();
        this.varItemPosition = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Cursor query;
        c1708z0.q(C2541R.string.stmt_interface_item_request_title);
        Uri A7 = J3.h.A(c1708z0, this.interfaceUri, null);
        if (A7 == null) {
            throw new RequiredArgumentNullException("interfaceUri");
        }
        if (J3.h.x(c1708z0, this.adapterViewId, null) == null) {
            throw new RequiredArgumentNullException("adapterViewId");
        }
        int match = C1827a.m.C0206a.f18790a.match(A7);
        Object[] objArr = f16776L1;
        com.llamalab.automate.F0 f02 = c1708z0.f17641Z;
        if (match == 10) {
            Y.h(f02.f14847y0, A7);
            query = c1708z0.getContentResolver().query(A7, new String[]{"native_id", "data"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
            try {
                if (query.moveToNext()) {
                    int i8 = query.getInt(0);
                    C1646h c1646h = new C1646h(query.getBlob(1));
                    query.close();
                    Uri build = C1827a.f.AbstractC0203a.b(Y.i(D1.u(c1708z0, c1646h.f16946a), r1), A7).build();
                    b bVar = (b) c1708z0.d(b.class, this);
                    if (bVar != null) {
                        if (bVar.f16777L1.equals(build) && bVar.f16783Q1 == i8) {
                            bVar.w2();
                            return false;
                        }
                        bVar.a();
                    }
                    b bVar2 = new b(build, i8);
                    c1708z0.w(bVar2);
                    if (Y.e(c1708z0, AppWidgetManager.getInstance(c1708z0).getAppWidgetInfo(i8))) {
                        return false;
                    }
                    bVar2.a();
                    w(c1708z0, objArr);
                } else {
                    w(c1708z0, objArr);
                }
                return true;
            } finally {
            }
        }
        if (match == 12) {
            Y.h(f02.f14847y0, A7);
            IncapableAndroidVersionException.a(17);
            query = c1708z0.getContentResolver().query(A7, new String[]{"native_id", "data"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
            try {
                if (!query.moveToNext()) {
                    w(c1708z0, objArr);
                    query.close();
                    return true;
                }
                long j8 = query.getLong(0);
                C1646h c1646h2 = new C1646h(query.getBlob(1));
                query.close();
                Uri build2 = C1827a.f.AbstractC0203a.b(Y.i(D1.u(c1708z0, c1646h2.f16946a), r1), A7).build();
                c cVar = (c) c1708z0.d(c.class, this);
                if (cVar != null) {
                    if (cVar.f16777L1.equals(build2) && cVar.f16786Q1 == j8) {
                        cVar.w2();
                        return false;
                    }
                    cVar.a();
                }
                c1708z0.w(new c(j8, build2));
                return false;
            } finally {
            }
        }
        if (match != 14) {
            throw new IllegalArgumentException("Unsupported interface URI");
        }
        Y.h(f02.f14847y0, A7);
        IncapableAndroidVersionException.a(21);
        query = c1708z0.getContentResolver().query(A7, new String[]{"native_id", "data"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
        try {
            if (!query.moveToNext()) {
                w(c1708z0, objArr);
                query.close();
                return true;
            }
            long j9 = query.getLong(0);
            C1646h c1646h3 = new C1646h(query.getBlob(1));
            query.close();
            Uri build3 = C1827a.f.AbstractC0203a.b(Y.i(D1.u(c1708z0, c1646h3.f16946a), r1), A7).build();
            d dVar = (d) c1708z0.d(d.class, this);
            if (dVar != null) {
                if (dVar.f16777L1.equals(build3) && dVar.f16789Q1 == j9) {
                    dVar.w2();
                    return false;
                }
                dVar.a();
            }
            c1708z0.w(new d(j9, build3));
            return false;
        } finally {
        }
    }

    public final void w(C1708z0 c1708z0, Object[] objArr) {
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        Double d8 = (Double) objArr[1];
        J3.l lVar = this.varItemPosition;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, booleanValue);
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        w(c1708z0, (Object[]) obj);
        return true;
    }
}
