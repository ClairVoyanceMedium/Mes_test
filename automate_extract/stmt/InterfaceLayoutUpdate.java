package com.llamalab.automate.stmt;

import C1.D1;
import android.appwidget.AppWidgetManager;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateDreamService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.AutomateWallpaperService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1686t2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.E1;
import com.llamalab.automate.F1;
import com.llamalab.automate.I1;
import com.llamalab.automate.InterfaceC1692v0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.X2;
import g4.C1827a;
import h4.C1875a;
import h4.C1881g;
import h4.C1885k;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import m3.C2145c;
import y4.C2466a;

@F3.a(C2541R.integer.ic_publish)
@F3.f("interface_layout_update.html")
@F3.i(C2541R.string.stmt_interface_layout_update_title)
@F3.h(C2541R.string.stmt_interface_layout_update_summary)
@F3.c(C2541R.string.caption_interface_layout_update)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_interface_layout_update_edit)
/* loaded from: classes.dex */
public final class InterfaceLayoutUpdate extends Decision implements AsyncStatement {
    public InterfaceC1700x0 adapterViewId;
    public InterfaceC1700x0 interfaceUri;
    public InterfaceC1700x0 itemPosition;
    public InterfaceC1700x0 layoutXml;
    public J3.l varItemInterfaceUri;

    public static final class a extends com.llamalab.automate.W implements InterfaceC1692v0 {

        /* renamed from: L1, reason: collision with root package name */
        public final C1686t2 f16792L1;

        /* renamed from: M1, reason: collision with root package name */
        public final Uri f16793M1;

        /* renamed from: N1, reason: collision with root package name */
        public final C1646h f16794N1;

        /* renamed from: y1, reason: collision with root package name */
        public final long f16795y1;

        public a(long j8, C1686t2 c1686t2, Uri uri, C1646h c1646h) {
            this.f16795y1 = j8;
            this.f16792L1 = c1686t2;
            this.f16793M1 = uri;
            this.f16794N1 = c1646h;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            AutomateDreamService.a(this);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            AutomateDreamService.f14534P1.remove(this);
            u2();
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final /* synthetic */ void Q0(AutomateDreamService automateDreamService, Configuration configuration) {
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final boolean Y1(AutomateDreamService automateDreamService) {
            try {
                if (this.f16795y1 == automateDreamService.f14546y1) {
                    automateDreamService.f(this.f16792L1);
                    q2(new Object[]{Boolean.TRUE, null, this.f16793M1, this.f16794N1}, false);
                } else {
                    q2(new Object[]{Boolean.FALSE, null, null, null}, false);
                }
            } catch (Throwable th) {
                r2(th);
            }
            return false;
        }

        @Override // com.llamalab.automate.InterfaceC1692v0
        public final void t0() {
            q2(new Object[]{Boolean.FALSE, null, null, null}, false);
        }
    }

    public static final class b extends com.llamalab.automate.W implements X2 {

        /* renamed from: L1, reason: collision with root package name */
        public final C1686t2 f16796L1;

        /* renamed from: M1, reason: collision with root package name */
        public final Uri f16797M1;

        /* renamed from: N1, reason: collision with root package name */
        public final C1646h f16798N1;

        /* renamed from: y1, reason: collision with root package name */
        public final long f16799y1;

        public b(long j8, C1686t2 c1686t2, Uri uri, C1646h c1646h) {
            this.f16799y1 = j8;
            this.f16796L1 = c1686t2;
            this.f16797M1 = uri;
            this.f16798N1 = c1646h;
        }

        @Override // com.llamalab.automate.X2
        public final /* synthetic */ void B(int i8, int i9, DisplayMetrics displayMetrics, Display display, AutomateWallpaperService.b bVar) {
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            AutomateWallpaperService.a(this);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            AutomateWallpaperService.f14654x1.remove(this);
            u2();
        }

        @Override // com.llamalab.automate.X2
        public final /* synthetic */ boolean Z(AutomateWallpaperService.b bVar) {
            return false;
        }

        @Override // com.llamalab.automate.X2
        public final void h2(HashSet hashSet) {
            try {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    AutomateWallpaperService.b bVar = (AutomateWallpaperService.b) it.next();
                    if (this.f16799y1 == bVar.f14668g) {
                        bVar.d(this.f16796L1);
                        q2(new Object[]{Boolean.TRUE, null, this.f16797M1, this.f16798N1}, false);
                        return;
                    }
                }
                q2(new Object[]{Boolean.FALSE, null, null, null}, false);
            } catch (Throwable th) {
                r2(th);
            }
        }

        @Override // com.llamalab.automate.X2
        public final void q1() {
            q2(new Object[]{Boolean.FALSE, null, null, null}, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_interface_layout_update);
        l8.v(this.interfaceUri, 0);
        l8.v(this.adapterViewId, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.interfaceUri);
        dVar.g(this.adapterViewId);
        dVar.g(this.itemPosition);
        dVar.g(this.layoutXml);
        dVar.g(this.varItemInterfaceUri);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.interfaceUri);
        visitor.b(this.adapterViewId);
        visitor.b(this.itemPosition);
        visitor.b(this.layoutXml);
        visitor.b(this.varItemInterfaceUri);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.interfaceUri = (InterfaceC1700x0) cVar.readObject();
        this.adapterViewId = (InterfaceC1700x0) cVar.readObject();
        this.itemPosition = (InterfaceC1700x0) cVar.readObject();
        this.layoutXml = (InterfaceC1700x0) cVar.readObject();
        this.varItemInterfaceUri = (J3.l) cVar.readObject();
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v33, types: [com.llamalab.automate.E1] */
    /* JADX WARN: Type inference failed for: r9v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        ContentProviderClient contentProviderClient;
        ContentProviderClient contentProviderClient2;
        ContentProviderClient contentProviderClient3;
        Cursor cursor;
        ?? moveToNext;
        I1.b bVar;
        c1708z0.q(C2541R.string.stmt_interface_layout_update_title);
        Uri A7 = J3.h.A(c1708z0, this.interfaceUri, null);
        if (A7 == null) {
            throw new RequiredArgumentNullException("interfaceUri");
        }
        String x7 = J3.h.x(c1708z0, this.adapterViewId, null);
        Integer o6 = J3.h.o(c1708z0, this.itemPosition, null);
        if ((x7 != null) != (o6 != null)) {
            throw new RequiredArgumentNullException("Neither or both viewIdName, itemPosition");
        }
        String x8 = J3.h.x(c1708z0, this.layoutXml, null);
        if (x8 == null) {
            throw new RequiredArgumentNullException("layoutXml");
        }
        int match = C1827a.m.C0206a.f18790a.match(A7);
        com.llamalab.automate.F0 f02 = c1708z0.f17641Z;
        if (match == 10) {
            InterfaceLayoutUpdate interfaceLayoutUpdate = this;
            ?? r12 = x7;
            Y.h(f02.f14847y0, A7);
            ContentProviderClient acquireContentProviderClient = c1708z0.getContentResolver().acquireContentProviderClient("com.llamalab.automate.provider");
            try {
                Cursor query = acquireContentProviderClient.query(A7, new String[]{"native_id", "data"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
                try {
                    try {
                        if (query.moveToNext()) {
                            int i8 = query.getInt(0);
                            C1646h c1646h = new C1646h(query.getBlob(1));
                            C1885k c1885k = c1646h.f16947b;
                            query.close();
                            C1881g w8 = D1.w(c1708z0, c1646h.f16946a, 48);
                            F1 c8 = F1.c(c1708z0);
                            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(c1708z0);
                            try {
                                if (r12 != 0 && o6 != null) {
                                    c1885k.f19475a = null;
                                    try {
                                    } catch (Throwable th) {
                                        th = th;
                                        interfaceLayoutUpdate = this;
                                    }
                                    try {
                                        C1875a a8 = new I1.a(c1708z0, w8, c1885k, A7, i8).a(new StringReader(x8));
                                        a8.setOnClickFillInIntent(a8.getViewId(), new Intent().putExtra("com.llamalab.automate.intent.extra.ITEM_POSITION", o6));
                                        int i9 = Y.i(w8, r12);
                                        Uri build = C1827a.f.AbstractC0203a.b(i9, A7).build();
                                        long b8 = C2145c.b(A7, 3);
                                        Uri d8 = Y.d(acquireContentProviderClient, c1708z0.f17641Z, b8, o6.intValue(), i9);
                                        com.llamalab.automate.Q a9 = c8.a(build, i8);
                                        Y.k(acquireContentProviderClient, d8, b8, o6.intValue(), i9, c1646h.a());
                                        a9.d(o6.intValue(), C2145c.b(A7, 3), a8);
                                        interfaceLayoutUpdate = this;
                                        try {
                                            interfaceLayoutUpdate.w(c1708z0, true, d8.toString());
                                            contentProviderClient3 = acquireContentProviderClient;
                                            contentProviderClient3.release();
                                        } catch (Throwable th2) {
                                            th = th2;
                                            contentProviderClient = acquireContentProviderClient;
                                            contentProviderClient2 = contentProviderClient;
                                            contentProviderClient2.release();
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        contentProviderClient2 = acquireContentProviderClient;
                                        contentProviderClient2.release();
                                        throw th;
                                    }
                                }
                                C2466a c2466a = new C2466a();
                                P0.b bVar2 = new P0.b(7, c2466a);
                                C1885k.a aVar = c1885k.f19475a;
                                if (aVar != null) {
                                    aVar.c(bVar2);
                                }
                                c1885k.f19475a = null;
                                F1 f12 = c8;
                                C1875a a10 = new I1.a(c1708z0, w8, c1885k, A7, i8).a(new StringReader(x8));
                                S.d dVar = new S.d(9, c2466a);
                                C1885k.a aVar2 = c1885k.f19475a;
                                if (aVar2 != null) {
                                    aVar2.c(dVar);
                                }
                                if (Y.j(contentProviderClient, A7, f02, c1646h.a())) {
                                    appWidgetManager.updateAppWidget(i8, a10);
                                    int i10 = 0;
                                    while (true) {
                                        int i11 = c2466a.f23527b;
                                        if (i10 >= i11) {
                                            interfaceLayoutUpdate.w(c1708z0, true, null);
                                            contentProviderClient.release();
                                            return true;
                                        }
                                        if (i11 <= i10) {
                                            throw new ArrayIndexOutOfBoundsException();
                                        }
                                        F1 f13 = f12;
                                        f13.f(C1827a.f.AbstractC0203a.b(c2466a.f23526a[i10], A7).build());
                                        i10++;
                                        f12 = f13;
                                    }
                                } else {
                                    interfaceLayoutUpdate.w(c1708z0, false, null);
                                    contentProviderClient3 = contentProviderClient;
                                    contentProviderClient3.release();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                contentProviderClient2 = contentProviderClient;
                                contentProviderClient2.release();
                                throw th;
                            }
                            contentProviderClient = acquireContentProviderClient;
                        } else {
                            interfaceLayoutUpdate.w(c1708z0, false, null);
                            query.close();
                            acquireContentProviderClient.release();
                        }
                        return true;
                    } catch (Throwable th5) {
                        th = th5;
                        contentProviderClient2 = r12;
                    }
                } catch (Throwable th6) {
                    query.close();
                    throw th6;
                }
            } catch (Throwable th7) {
                th = th7;
                contentProviderClient = acquireContentProviderClient;
            }
        } else if (match == 12) {
            Y.h(f02.f14847y0, A7);
            IncapableAndroidVersionException.a(17);
            ContentProviderClient acquireContentProviderClient2 = c1708z0.getContentResolver().acquireContentProviderClient("com.llamalab.automate.provider");
            try {
                try {
                    Cursor query2 = acquireContentProviderClient2.query(A7, new String[]{"native_id", "data"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
                    try {
                        moveToNext = query2.moveToNext();
                    } catch (Throwable th8) {
                        th = th8;
                        cursor = query2;
                    }
                    try {
                        try {
                            if (moveToNext != 0) {
                                long j8 = query2.getLong(0);
                                C1646h c1646h2 = new C1646h(query2.getBlob(1));
                                query2.close();
                                c1646h2.f16947b.f19475a = null;
                                C1881g w9 = D1.w(c1708z0, c1646h2.f16946a, 32);
                                SparseArray sparseArray = new SparseArray();
                                I1.b bVar3 = bVar;
                                bVar = new I1.b(c1708z0, w9, c1646h2.f16947b, A7, sparseArray);
                                C1875a a11 = bVar3.a(new StringReader(x8));
                                if (x7 != null && o6 != null) {
                                    SparseArray sparseArray2 = new SparseArray();
                                    sparseArray2.put(a11.getViewId(), new Intent().putExtra("com.llamalab.automate.intent.extra.ITEM_POSITION", o6));
                                    int i12 = Y.i(w9, x7);
                                    Uri build2 = C1827a.f.AbstractC0203a.b(i12, A7).build();
                                    long b9 = C2145c.b(A7, 3);
                                    Uri d9 = Y.d(acquireContentProviderClient2, c1708z0.f17641Z, b9, o6.intValue(), i12);
                                    ?? b10 = F1.c(c1708z0).b(build2);
                                    if (b10 != 0) {
                                        Y.k(acquireContentProviderClient2, d9, b9, o6.intValue(), i12, c1646h2.a());
                                        b10.d(o6.intValue(), C2145c.b(A7, 3), new C1686t2(a11, sparseArray, sparseArray2));
                                    }
                                    w(c1708z0, true, d9.toString());
                                    query2 = b10;
                                    moveToNext = bVar3;
                                }
                                c1708z0.w(new a(j8, new C1686t2(a11, sparseArray, null), A7, c1646h2));
                                acquireContentProviderClient2.release();
                                return false;
                            }
                            InterfaceLayoutUpdate interfaceLayoutUpdate2 = this;
                            interfaceLayoutUpdate2.w(c1708z0, false, null);
                            query2.close();
                            query2 = query2;
                            moveToNext = interfaceLayoutUpdate2;
                            acquireContentProviderClient2.release();
                            return true;
                        } catch (Throwable th9) {
                            th = th9;
                            acquireContentProviderClient2.release();
                            throw th;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        cursor = query2;
                        cursor.close();
                        throw th;
                    }
                } catch (Throwable th11) {
                    th = th11;
                }
            } catch (Throwable th12) {
                th = th12;
            }
        } else {
            if (match != 14) {
                throw new IllegalArgumentException("Unsupported interface URI");
            }
            Y.h(f02.f14847y0, A7);
            IncapableAndroidVersionException.a(21);
            ContentProviderClient acquireContentProviderClient3 = c1708z0.getContentResolver().acquireContentProviderClient("com.llamalab.automate.provider");
            try {
                Cursor query3 = acquireContentProviderClient3.query(A7, new String[]{"native_id", "data"}, "flow_version=?", new String[]{String.valueOf(f02.f14848y1)}, null);
                try {
                    try {
                        if (query3.moveToNext()) {
                            long j9 = query3.getLong(0);
                            C1646h c1646h3 = new C1646h(query3.getBlob(1));
                            query3.close();
                            c1646h3.f16947b.f19475a = null;
                            C1881g w10 = D1.w(c1708z0, c1646h3.f16946a, 32);
                            SparseArray sparseArray3 = new SparseArray();
                            try {
                                C1875a a12 = new I1.b(c1708z0, w10, c1646h3.f16947b, A7, sparseArray3).a(new StringReader(x8));
                                if (x7 != null && o6 != null) {
                                    SparseArray sparseArray4 = new SparseArray();
                                    sparseArray4.put(a12.getViewId(), new Intent().putExtra("com.llamalab.automate.intent.extra.ITEM_POSITION", o6));
                                    int i13 = Y.i(w10, x7);
                                    Uri build3 = C1827a.f.AbstractC0203a.b(i13, A7).build();
                                    long b11 = C2145c.b(A7, 3);
                                    Uri d10 = Y.d(acquireContentProviderClient3, c1708z0.f17641Z, b11, o6.intValue(), i13);
                                    E1 b12 = F1.c(c1708z0).b(build3);
                                    if (b12 != null) {
                                        Y.k(acquireContentProviderClient3, d10, b11, o6.intValue(), i13, c1646h3.a());
                                        b12.d(o6.intValue(), C2145c.b(A7, 3), new C1686t2(a12, sparseArray3, sparseArray4));
                                    }
                                    w(c1708z0, true, d10.toString());
                                    acquireContentProviderClient3.release();
                                }
                                c1708z0.w(new b(j9, new C1686t2(a12, sparseArray3, null), A7, c1646h3));
                                acquireContentProviderClient3.release();
                                return false;
                            } catch (Throwable th13) {
                                th = th13;
                                acquireContentProviderClient3.release();
                                throw th;
                            }
                        }
                        w(c1708z0, false, null);
                        query3.close();
                        acquireContentProviderClient3.release();
                        return true;
                    } catch (Throwable th14) {
                        th = th14;
                    }
                } catch (Throwable th15) {
                    query3.close();
                    throw th15;
                }
            } catch (Throwable th16) {
                th = th16;
            }
        }
    }

    public final void w(C1708z0 c1708z0, boolean z7, String str) {
        J3.l lVar = this.varItemInterfaceUri;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        X x7 = (X) objArr[3];
        if (x7 != null) {
            ContentResolver contentResolver = c1708z0.getContentResolver();
            Uri uri = (Uri) objArr[2];
            byte[] a8 = x7.a();
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", a8);
            if (!(contentResolver.update(uri, contentValues, "flow_version=?", new String[]{String.valueOf(c1708z0.f17641Z.f14848y1)}) != 0)) {
                w(c1708z0, false, null);
                return true;
            }
        }
        w(c1708z0, ((Boolean) objArr[0]).booleanValue(), (String) objArr[1]);
        return true;
    }
}
