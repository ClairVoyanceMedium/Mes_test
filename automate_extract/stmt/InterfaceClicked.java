package com.llamalab.automate.stmt;

import C1.D1;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.RadioButton;
import com.llamalab.automate.AbstractC1618p2;
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
import com.llamalab.automate.X2;
import g4.C1827a;
import java.util.HashSet;
import java.util.Iterator;
import x3.C2440r;

@F3.a(C2541R.integer.ic_left_click)
@F3.f("interface_clicked.html")
@F3.i(C2541R.string.stmt_interface_clicked_title)
@F3.h(C2541R.string.stmt_interface_clicked_summary)
@F3.c(C2541R.string.caption_interface_clicked)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_interface_clicked_edit)
/* loaded from: classes.dex */
public final class InterfaceClicked extends Decision implements ReceiverStatement {
    public InterfaceC1700x0 interfaceUri;
    public J3.l varChecked;
    public J3.l varItemPosition;
    public J3.l varViewId;

    public static abstract class a extends AbstractC1618p2.b.a {

        /* renamed from: M1, reason: collision with root package name */
        public final Uri f16770M1;

        public a(Uri uri) {
            super(256, 1000L);
            this.f16770M1 = uri;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[Catch: all -> 0x00a1, TryCatch #0 {all -> 0x00a1, blocks: (B:3:0x0002, B:15:0x0037, B:17:0x004a, B:19:0x005c, B:21:0x0062, B:23:0x0068, B:24:0x008a, B:26:0x0094, B:27:0x0099, B:29:0x006f, B:33:0x0082, B:35:0x0018, B:38:0x0022), top: B:2:0x0002 }] */
        @Override // com.llamalab.automate.AbstractC1618p2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void e(AutomateService automateService, Intent intent) {
            char c8;
            Double d8;
            try {
                String action = intent.getAction();
                int hashCode = action.hashCode();
                if (hashCode != -977337332) {
                    if (hashCode == 703313515 && action.equals("com.llamalab.automate.intent.action.INTERFACE_CLICK")) {
                        c8 = 0;
                        if (c8 == 0) {
                            if (c8 != 1) {
                                return;
                            }
                            a();
                            c(intent, new Object[]{Boolean.FALSE, null, null, null}, false);
                            return;
                        }
                        String stringExtra = intent.getStringExtra("com.llamalab.automate.intent.extra.VIEW_ID_NAME");
                        int intExtra = intent.getIntExtra("com.llamalab.automate.intent.extra.ITEM_POSITION", -1);
                        if (31 > Build.VERSION.SDK_INT || !intent.hasExtra("android.widget.extra.CHECKED")) {
                            d8 = null;
                        } else if (intent.getBooleanExtra("android.widget.extra.CHECKED", false)) {
                            d8 = Double.valueOf(1.0d);
                        } else if (RadioButton.class.isAssignableFrom(Class.forName(intent.getStringExtra("com.llamalab.automate.intent.extra.VIEW_CLASS")))) {
                            return;
                        } else {
                            d8 = Double.valueOf(0.0d);
                        }
                        Object[] objArr = new Object[4];
                        objArr[0] = Boolean.TRUE;
                        objArr[1] = stringExtra;
                        objArr[2] = intExtra >= 0 ? Double.valueOf(intExtra) : null;
                        objArr[3] = d8;
                        c(intent, objArr, false);
                        return;
                    }
                    c8 = 65535;
                    if (c8 == 0) {
                    }
                } else {
                    if (action.equals("com.llamalab.automate.intent.action.INTERFACE_DISMISSED")) {
                        c8 = 1;
                        if (c8 == 0) {
                        }
                    }
                    c8 = 65535;
                    if (c8 == 0) {
                    }
                }
            } catch (Throwable th) {
                d(th);
            }
        }

        public final void o() {
            onReceive(this.f16157Y, new Intent("com.llamalab.automate.intent.action.INTERFACE_DISMISSED"));
        }

        public void q1() {
            o();
        }

        public void t0() {
            o();
        }
    }

    public static final class b extends a {

        /* renamed from: N1, reason: collision with root package name */
        public final int f16771N1;

        public b(Uri uri, int i8) {
            super(uri);
            this.f16771N1 = i8;
        }

        @Override // com.llamalab.automate.stmt.InterfaceClicked.a, com.llamalab.automate.AbstractC1618p2
        public final void e(AutomateService automateService, Intent intent) {
            String action = intent.getAction();
            action.getClass();
            if (action.equals("android.appwidget.action.APPWIDGET_DELETED")) {
                o();
            } else {
                super.e(automateService, intent);
            }
        }

        @Override // com.llamalab.automate.AbstractC1618p2.b, com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (!"android.appwidget.action.APPWIDGET_DELETED".equals(intent.getAction()) || Y.a(intent, this.f16771N1)) {
                super.onReceive(context, intent);
            }
        }
    }

    public static final class c extends a implements InterfaceC1692v0 {

        /* renamed from: N1, reason: collision with root package name */
        public final long f16772N1;

        public c(long j8, Uri uri) {
            super(uri);
            this.f16772N1 = j8;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            AutomateDreamService.a(this);
        }

        @Override // com.llamalab.automate.AbstractC1618p2.b.a, com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            AutomateDreamService.e(this);
            super.F(automateService);
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final /* synthetic */ void Q0(AutomateDreamService automateDreamService, Configuration configuration) {
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final /* synthetic */ boolean Y1(AutomateDreamService automateDreamService) {
            return false;
        }

        @Override // com.llamalab.automate.stmt.InterfaceClicked.a, com.llamalab.automate.AbstractC1618p2
        public final void e(AutomateService automateService, Intent intent) {
            String action = intent.getAction();
            action.getClass();
            if (action.equals("com.llamalab.automate.intent.action.DREAM_SETTINGS_CHANGED")) {
                o();
            } else {
                super.e(automateService, intent);
            }
        }
    }

    public static final class d extends a {

        /* renamed from: N1, reason: collision with root package name */
        public final int f16773N1;

        /* renamed from: O1, reason: collision with root package name */
        public final String f16774O1;

        public d(int i8, Uri uri, String str) {
            super(uri);
            this.f16773N1 = i8;
            this.f16774O1 = str;
        }
    }

    public static final class e extends a implements X2 {

        /* renamed from: N1, reason: collision with root package name */
        public final long f16775N1;

        public e(long j8, Uri uri) {
            super(uri);
            this.f16775N1 = j8;
        }

        @Override // com.llamalab.automate.X2
        public final /* synthetic */ void B(int i8, int i9, DisplayMetrics displayMetrics, Display display, AutomateWallpaperService.b bVar) {
        }

        @Override // com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            AutomateWallpaperService.a(this);
        }

        @Override // com.llamalab.automate.AbstractC1618p2.b.a, com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            AutomateWallpaperService.b(this);
            super.F(automateService);
        }

        @Override // com.llamalab.automate.X2
        public final /* synthetic */ boolean Z(AutomateWallpaperService.b bVar) {
            return false;
        }

        @Override // com.llamalab.automate.stmt.InterfaceClicked.a, com.llamalab.automate.AbstractC1618p2
        public final void e(AutomateService automateService, Intent intent) {
            String action = intent.getAction();
            action.getClass();
            if (action.equals("com.llamalab.automate.intent.action.WALLPAPER_SETTINGS_CHANGED")) {
                o();
            } else {
                super.e(automateService, intent);
            }
        }

        @Override // com.llamalab.automate.X2
        public final void h2(HashSet hashSet) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                if (((AutomateWallpaperService.b) it.next()).f14668g == this.f16775N1) {
                    return;
                }
            }
            o();
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_interface_clicked);
        l8.v(this.interfaceUri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        w(c1708z0, ((Boolean) objArr[0]).booleanValue(), (String) objArr[1], (Double) objArr[2], (Double) objArr[3]);
        return true;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.interfaceUri);
        dVar.g(this.varViewId);
        dVar.g(this.varItemPosition);
        dVar.g(this.varChecked);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.interfaceUri);
        visitor.b(this.varViewId);
        visitor.b(this.varItemPosition);
        visitor.b(this.varChecked);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.interfaceUri = (InterfaceC1700x0) cVar.readObject();
        this.varViewId = (J3.l) cVar.readObject();
        this.varItemPosition = (J3.l) cVar.readObject();
        this.varChecked = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Cursor query;
        c1708z0.q(C2541R.string.stmt_interface_clicked_title);
        Uri A7 = J3.h.A(c1708z0, this.interfaceUri, null);
        if (A7 == null) {
            throw new RequiredArgumentNullException("InterfaceUri");
        }
        int match = C1827a.m.C0206a.f18790a.match(A7);
        com.llamalab.automate.F0 f02 = c1708z0.f17641Z;
        switch (match) {
            case 10:
                Y.h(f02.f14847y0, A7);
                query = c1708z0.getContentResolver().query(A7, new String[]{"native_id"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
                try {
                    if (!query.moveToNext()) {
                        w(c1708z0, false, null, null, null);
                        return true;
                    }
                    int i8 = query.getInt(0);
                    query.close();
                    b bVar = (b) c1708z0.d(b.class, this);
                    if (bVar != null) {
                        if (A7.equals(bVar.f16770M1) && i8 == bVar.f16771N1) {
                            bVar.i0();
                            return false;
                        }
                        bVar.a();
                    }
                    b bVar2 = new b(A7, i8);
                    c1708z0.w(bVar2);
                    bVar2.l(C2440r.E(1, A7, "com.llamalab.automate.intent.action.INTERFACE_CLICK"), new IntentFilter("android.appwidget.action.APPWIDGET_DELETED"));
                    if (!Y.e(c1708z0, AppWidgetManager.getInstance(c1708z0).getAppWidgetInfo(i8))) {
                        bVar2.a();
                        w(c1708z0, false, null, null, null);
                        return true;
                    }
                    return false;
                } finally {
                }
            case 11:
            default:
                throw new IllegalArgumentException("Unsupported interface URI");
            case 12:
                Y.h(f02.f14847y0, A7);
                query = c1708z0.getContentResolver().query(A7, new String[]{"native_id"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
                try {
                    if (!query.moveToNext()) {
                        w(c1708z0, false, null, null, null);
                        return true;
                    }
                    long j8 = query.getLong(0);
                    query.close();
                    c cVar = (c) c1708z0.d(c.class, this);
                    if (cVar != null) {
                        if (A7.equals(cVar.f16770M1) && j8 == cVar.f16772N1) {
                            cVar.i0();
                            return false;
                        }
                        cVar.a();
                    }
                    c cVar2 = new c(j8, A7);
                    c1708z0.w(cVar2);
                    cVar2.l(C2440r.E(1, A7, "com.llamalab.automate.intent.action.INTERFACE_CLICK"), new IntentFilter("com.llamalab.automate.intent.action.DREAM_SETTINGS_CHANGED"));
                    return false;
                } finally {
                }
            case 13:
                Y.h(f02.f14847y0, A7);
                query = c1708z0.getContentResolver().query(A7, new String[]{"native_id"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
                try {
                    if (!query.moveToNext()) {
                        w(c1708z0, false, null, null, null);
                        return true;
                    }
                    String string = query.getString(0);
                    int indexOf = string.indexOf(44);
                    int parseInt = Integer.parseInt(string.substring(0, indexOf));
                    String substring = string.substring(indexOf + 1);
                    query.close();
                    d dVar = (d) c1708z0.d(d.class, this);
                    if (dVar != null) {
                        if (A7.equals(dVar.f16770M1) && parseInt == dVar.f16773N1 && O.b.a(substring, dVar.f16774O1)) {
                            dVar.i0();
                            return false;
                        }
                        dVar.a();
                    }
                    d dVar2 = new d(parseInt, A7, substring);
                    c1708z0.w(dVar2);
                    int i9 = C1827a.i.AbstractC0205a.f18786b;
                    dVar2.l(C2440r.E(1, A7, "com.llamalab.automate.intent.action.INTERFACE_CLICK"), C2440r.E(0, C1827a.i.f18785a.buildUpon().appendEncodedPath("native").appendPath(parseInt + "," + substring).appendEncodedPath(D1.e(5)).build(), "com.llamalab.automate.intent.action.INTERFACE_DISMISSED"));
                    if (c1708z0.j2().o(parseInt, substring) == null) {
                        dVar2.a();
                        w(c1708z0, false, null, null, null);
                        return true;
                    }
                    return false;
                } finally {
                }
            case 14:
                Y.h(f02.f14847y0, A7);
                query = c1708z0.getContentResolver().query(A7, new String[]{"native_id"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
                try {
                    if (!query.moveToNext()) {
                        w(c1708z0, false, null, null, null);
                        return true;
                    }
                    long j9 = query.getLong(0);
                    query.close();
                    e eVar = (e) c1708z0.d(e.class, this);
                    if (eVar != null) {
                        if (A7.equals(eVar.f16770M1) && j9 == eVar.f16775N1) {
                            eVar.i0();
                            return false;
                        }
                        eVar.a();
                    }
                    e eVar2 = new e(j9, A7);
                    c1708z0.w(eVar2);
                    eVar2.l(C2440r.E(1, A7, "com.llamalab.automate.intent.action.INTERFACE_CLICK"), new IntentFilter("com.llamalab.automate.intent.action.WALLPAPER_SETTINGS_CHANGED"));
                    return false;
                } finally {
                }
        }
    }

    public final void w(C1708z0 c1708z0, boolean z7, String str, Double d8, Double d9) {
        J3.l lVar = this.varViewId;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varItemPosition;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d8);
        }
        J3.l lVar3 = this.varChecked;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d9);
        }
        o(c1708z0, z7);
    }
}
