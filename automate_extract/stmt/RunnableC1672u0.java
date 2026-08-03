package com.llamalab.automate.stmt;

import C1.D1;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1617p1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.FlowStore;
import com.llamalab.automate.I1;
import com.llamalab.automate.InterfaceC1590i2;
import com.llamalab.automate.InterfaceC1592j0;
import com.llamalab.automate.InterfaceC1606m2;
import com.llamalab.automate.K1;
import com.llamalab.automate.S1;
import g4.C1827a;
import h4.C1881g;
import i0.C1896a;
import java.io.StringReader;
import m3.C2145c;
import x3.C2424b;
import x3.C2425c;

/* renamed from: com.llamalab.automate.stmt.u0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC1672u0 extends S1 implements InterfaceC1592j0, InterfaceC1590i2, Runnable {

    /* renamed from: L1, reason: collision with root package name */
    public String f17531L1;

    /* renamed from: M1, reason: collision with root package name */
    public String f17532M1;

    /* renamed from: N1, reason: collision with root package name */
    public Uri f17533N1;

    /* renamed from: O1, reason: collision with root package name */
    public Uri f17534O1;

    /* renamed from: P1, reason: collision with root package name */
    public Uri f17535P1;

    /* renamed from: Q1, reason: collision with root package name */
    public Uri f17536Q1;

    /* renamed from: R1, reason: collision with root package name */
    public String f17537R1;

    /* renamed from: S1, reason: collision with root package name */
    public String f17538S1;

    /* renamed from: T1, reason: collision with root package name */
    public String f17539T1;
    public int U1;

    /* renamed from: V1, reason: collision with root package name */
    public boolean f17540V1;
    public int W1;

    /* renamed from: X1, reason: collision with root package name */
    public int f17541X1;

    /* renamed from: Y1, reason: collision with root package name */
    public String f17542Y1;

    /* renamed from: Z1, reason: collision with root package name */
    public String f17543Z1;

    /* renamed from: a2, reason: collision with root package name */
    public String f17544a2;

    /* renamed from: b2, reason: collision with root package name */
    public String f17545b2;

    /* renamed from: c2, reason: collision with root package name */
    public float f17546c2;

    /* renamed from: d2, reason: collision with root package name */
    public long f17547d2;

    /* renamed from: e2, reason: collision with root package name */
    public boolean f17548e2;

    /* renamed from: y1, reason: collision with root package name */
    public String f17549y1;

    public static PendingIntent C2(Context context, InterfaceC1606m2 interfaceC1606m2) {
        return C2424b.g(0, 1207959552 | C2424b.f23370a, context, new Intent("com.llamalab.automate.intent.action.CONTENT_CLICKED", C1827a.e.C0202a.a(interfaceC1606m2.G0(), interfaceC1606m2.h1(), interfaceC1606m2.g()).build(), context, AutomateService.class));
    }

    public final void A2(AutomateService automateService, com.llamalab.automate.F0 f02, InterfaceC1606m2 interfaceC1606m2, boolean z7, Bundle bundle) {
        Notification a8 = C2424b.a(B2(automateService, f02, interfaceC1606m2, z7, bundle));
        if (36 > Build.VERSION.SDK_INT) {
            y2(automateService, a8);
            return;
        }
        if (C1710z2.a(C2425c.c(automateService))) {
            s2("NotificationShowTask hasPromotableCharacteristics=" + a8.hasPromotableCharacteristics());
        }
        y2(automateService, a8);
        automateService.c0(f02, v2(), x2());
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v2 */
    public final Notification.Builder B2(AutomateService automateService, com.llamalab.automate.F0 f02, InterfaceC1606m2 interfaceC1606m2, boolean z7, Bundle bundle) {
        int i8;
        Uri b8;
        C1668s0 c1668s0;
        ContentProviderClient contentProviderClient;
        C1668s0 c1668s02;
        int i9;
        C1668s0 c1668s03;
        Notification.Builder group;
        Notification.Style bigText;
        ContentProviderClient contentProviderClient2 = 1;
        Notification.Builder onlyAlertOnce = automateService.B().b(new String[]{this.f17544a2, this.f17545b2, "da34068b-5b0a-50be-829b-b38f72ddb6a7"}, this.f17541X1).setTicker(this.f17549y1).setContentTitle(this.f17549y1).setContentText(this.f17531L1).setOnlyAlertOnce(true);
        int i10 = Build.VERSION.SDK_INT;
        if (16 <= i10) {
            if (this.f17533N1 != null) {
                try {
                    bigText = 31 <= i10 ? new Notification.BigPictureStyle().bigPicture(C1617p1.u(automateService).z(this.f17533N1)) : new Notification.BigPictureStyle().bigPicture(C1617p1.u(automateService).y(this.f17533N1));
                } catch (Exception e8) {
                    Log.w("NotificationShowTask", "Failed to load picture", e8);
                }
                onlyAlertOnce.setStyle(bigText);
            }
            if (36 > Build.VERSION.SDK_INT || Float.isNaN(this.f17546c2)) {
                bigText = this.f17531L1 != null ? new Notification.BigTextStyle().bigText(this.f17531L1) : null;
            } else {
                bigText = new Notification.ProgressStyle();
                if (this.f17546c2 < 0.0f) {
                    bigText.setProgressIndeterminate(true);
                } else {
                    Notification.ProgressStyle.Segment segment = new Notification.ProgressStyle.Segment(1000);
                    int i11 = this.U1;
                    if (i11 != 0) {
                        segment.setColor(i11);
                    }
                    bigText.addProgressSegment(segment).setProgress(Math.round(Math.min(this.f17546c2, 100.0f) * 10.0f));
                }
            }
            onlyAlertOnce.setStyle(bigText);
        }
        int i12 = Build.VERSION.SDK_INT;
        if (20 <= i12) {
            group = onlyAlertOnce.setGroup(v2());
            group.setLocalOnly(false);
        }
        if (21 <= i12) {
            onlyAlertOnce.setCategory(this.f17542Y1);
            Uri uri = this.f17534O1;
            if (uri != null) {
                onlyAlertOnce.addPerson(uri.toString());
            }
        }
        if (24 <= i12) {
            onlyAlertOnce.setSubText(f02.A(automateService));
        } else if (16 <= i12) {
            onlyAlertOnce.setContentInfo(f02.A(automateService));
        }
        if (36 <= i12) {
            if (this.W1 == 2) {
                bundle.putBoolean("android.requestPromotedOngoing", true);
            }
            onlyAlertOnce.setShortCriticalText(this.f17532M1);
        }
        onlyAlertOnce.setSmallIcon(C2541R.drawable.ic_stat_notify_announcement);
        if (this.f17535P1 != null) {
            if (23 <= i12) {
                try {
                    if (!C2424b.n()) {
                        onlyAlertOnce.setSmallIcon(C1617p1.u(automateService).E(this.f17535P1));
                    }
                } catch (Exception e9) {
                    Log.w("NotificationShowTask", "Failed to load small icon", e9);
                }
            }
            C1617p1.u(automateService).Y(onlyAlertOnce, this.f17535P1);
        }
        if (this.f17536Q1 != null) {
            try {
                if (23 > Build.VERSION.SDK_INT || C2424b.n()) {
                    onlyAlertOnce.setLargeIcon(C1617p1.u(automateService).A(this.f17536Q1));
                } else {
                    onlyAlertOnce.setLargeIcon(C1617p1.u(automateService).C(this.f17536Q1));
                }
            } catch (Exception e10) {
                Log.w("NotificationShowTask", "Failed to load large icon", e10);
            }
        }
        if ((this.f17537R1 == null && this.f17538S1 == null && this.f17539T1 == null) ? false : true) {
            ContentProviderClient acquireContentProviderClient = automateService.getContentResolver().acquireContentProviderClient(C1827a.f18775a);
            try {
                try {
                    Cursor query = acquireContentProviderClient.query(C1827a.f.a(f02.f14847y0).build(), new String[]{"_id", "data"}, "flow_version=? and native_id=? and type=5", new String[]{String.valueOf(f02.f14848y1), D2()}, null);
                    try {
                        if (query.moveToNext()) {
                            b8 = C1827a.f.a(f02.f14847y0).appendEncodedPath(Long.toString(query.getLong(0))).appendEncodedPath(D1.e(5)).build();
                            c1668s0 = new C1668s0(query.getBlob(1));
                            c1668s0.f17519b.f19475a = null;
                            c1668s0.f17520c.f19475a = null;
                            c1668s0.f17521d.f19475a = null;
                        } else {
                            b8 = Y.b(acquireContentProviderClient, f02, 5, D2(), new ContentValues());
                            c1668s0 = new C1668s0(null);
                        }
                        C1668s0 c1668s04 = c1668s0;
                        query.close();
                        C1881g w8 = D1.w(automateService, c1668s04.f17518a, 48);
                        if (this.f17537R1 != null) {
                            i9 = 24;
                            contentProviderClient = acquireContentProviderClient;
                            c1668s02 = c1668s04;
                            onlyAlertOnce.setContent(new I1(automateService, w8, c1668s04.f17519b, 48, b8).a(new StringReader(this.f17537R1)));
                        } else {
                            contentProviderClient = acquireContentProviderClient;
                            c1668s02 = c1668s04;
                            i9 = 24;
                        }
                        if (i9 <= Build.VERSION.SDK_INT) {
                            if (this.f17538S1 != null) {
                                c1668s03 = c1668s02;
                                onlyAlertOnce.setCustomBigContentView(new I1(automateService, w8, c1668s03.f17520c, 48, b8).a(new StringReader(this.f17538S1)));
                            } else {
                                c1668s03 = c1668s02;
                            }
                            if (this.f17539T1 != null) {
                                onlyAlertOnce.setCustomHeadsUpContentView(new I1(automateService, w8, c1668s03.f17521d, 48, b8).a(new StringReader(this.f17539T1)));
                            }
                        } else {
                            c1668s03 = c1668s02;
                        }
                        Y.j(contentProviderClient, b8, f02, c1668s03.a());
                        bundle.putParcelable("com.llamalab.automate.intent.extra.INTERFACE_URI", b8);
                        contentProviderClient.release();
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    contentProviderClient2 = acquireContentProviderClient;
                    contentProviderClient2.release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                contentProviderClient2.release();
                throw th;
            }
        }
        int i13 = Build.VERSION.SDK_INT;
        if (21 <= i13 && (i8 = this.U1) != 0) {
            onlyAlertOnce.setColor(i8);
        }
        if (!Float.isNaN(this.f17546c2)) {
            float f8 = this.f17546c2;
            if (f8 < 0.0f) {
                onlyAlertOnce.setProgress(0, 0, true);
            } else {
                onlyAlertOnce.setProgress(1000, Math.round(Math.min(f8, 100.0f) * 10.0f), false);
            }
        }
        long j8 = this.f17547d2;
        if (j8 != Long.MIN_VALUE) {
            onlyAlertOnce.setWhen(j8);
            if (17 <= i13) {
                onlyAlertOnce.setShowWhen(true);
            }
        } else if (17 <= i13) {
            onlyAlertOnce.setShowWhen(false);
        } else {
            onlyAlertOnce.setWhen(0L);
        }
        onlyAlertOnce.setOngoing(34 > i13 ? !(this.W1 == 0 && this.f17540V1) : this.W1 != 0);
        onlyAlertOnce.setDeleteIntent(AutomateService.t(automateService, this, interfaceC1606m2));
        if (z7) {
            onlyAlertOnce.setAutoCancel(this.f17540V1);
        } else {
            onlyAlertOnce.setContentIntent(C2(automateService, interfaceC1606m2));
        }
        if (20 <= i13) {
            onlyAlertOnce.addExtras(bundle);
        }
        return onlyAlertOnce;
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        boolean z7 = this.f15404y0 != 0;
        super.C(automateService, j8, j9, j10);
        if (z7) {
            A2(automateService, automateService.f14588S1.e(j8), this, true, new Bundle());
        }
    }

    public final String D2() {
        return "0," + x2();
    }

    @Override // com.llamalab.automate.S1, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        automateService.f14581L1.removeCallbacks(this);
        PendingIntent t8 = AutomateService.t(automateService, this, this);
        if (t8 != null) {
            t8.cancel();
        }
        PendingIntent C22 = C2(automateService, this);
        if (C22 != null) {
            C22.cancel();
        }
        if ((this.f17537R1 == null && this.f17538S1 == null && this.f17539T1 == null) ? false : true) {
            C1896a a8 = C1896a.a(automateService);
            String D22 = D2();
            int i8 = C1827a.i.AbstractC0205a.f18786b;
            a8.c(new Intent("com.llamalab.automate.intent.action.INTERFACE_DISMISSED", C1827a.i.f18785a.buildUpon().appendEncodedPath("native").appendPath(D22).appendEncodedPath(D1.e(5)).build()));
        }
        super.F(automateService);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.llamalab.automate.InterfaceC1592j0
    public final void P0(AutomateService automateService, Intent intent) {
        K1 e8;
        long j8;
        FlowStore.CorruptFlowException corruptFlowException;
        if (34 <= Build.VERSION.SDK_INT || (this.W1 == 0 && this.f17540V1)) {
            if (this.f17548e2) {
                q2(null, false);
                return;
            }
            if (a()) {
                automateService.getClass();
                try {
                    C1708z0 u8 = automateService.u(this.f15401Z, this.f15402x0);
                    if (u8 != null) {
                        automateService.g(u8);
                    }
                } catch (FlowStore.CorruptFiberException e9) {
                    Log.e("AutomateService", e9.getMessage(), e9);
                    e8 = K1.e(automateService, e9.f14946X);
                    j8 = e9.f14947Y;
                    corruptFlowException = e9;
                    e8.c(j8, 0L, corruptFlowException);
                } catch (FlowStore.CorruptFlowException e10) {
                    Log.e("AutomateService", e10.getMessage(), e10);
                    e8 = K1.e(automateService, e10.f14948X);
                    j8 = 0;
                    corruptFlowException = e10;
                    e8.c(j8, 0L, corruptFlowException);
                }
            }
        }
    }

    @Override // com.llamalab.automate.W, R3.e
    public final void Y0(R3.d dVar) {
        char c8;
        dVar.d(this.f15404y0);
        dVar.k(this.f17549y1);
        dVar.k(this.f17531L1);
        if (14 <= dVar.f6413Z) {
            dVar.k(this.f17532M1);
        }
        if (9 <= dVar.f6413Z) {
            dVar.n(this.f17533N1);
            dVar.n(this.f17534O1);
        }
        if (11 <= dVar.f6413Z) {
            dVar.n(this.f17535P1);
            dVar.n(this.f17536Q1);
        } else {
            try {
                c8 = (char) C2145c.b(this.f17535P1, 1);
            } catch (Throwable unused) {
                c8 = 0;
            }
            dVar.writeShort(c8);
        }
        if (15 <= dVar.f6413Z) {
            dVar.k(this.f17537R1);
            dVar.k(this.f17538S1);
            dVar.k(this.f17539T1);
        }
        if (11 <= dVar.f6413Z) {
            dVar.writeInt(this.U1);
        }
        dVar.write(this.f17540V1 ? 1 : 0);
        if (14 <= dVar.f6413Z) {
            dVar.writeInt(this.W1);
        } else {
            dVar.write(this.W1 != 0 ? 1 : 0);
        }
        if (8 > dVar.f6413Z) {
            dVar.c(0);
        }
        dVar.c(this.f17541X1);
        dVar.k(this.f17542Y1);
        if (14 <= dVar.f6413Z) {
            dVar.k(this.f17543Z1);
        }
        if (8 <= dVar.f6413Z) {
            dVar.k(this.f17544a2);
            dVar.k(this.f17545b2);
        } else {
            dVar.write(0);
            dVar.write(0);
            dVar.f(0);
            dVar.write(0);
        }
        if (9 <= dVar.f6413Z) {
            dVar.writeFloat(this.f17546c2);
        } else {
            dVar.write((Float.isNaN(this.f17546c2) || this.f17546c2 >= 0.0f) ? 0 : 1);
        }
        dVar.d(this.f17547d2);
    }

    @Override // com.llamalab.automate.W, R3.e
    public final void o0(R3.c cVar) {
        this.f15404y0 = cVar.b();
        this.f17549y1 = cVar.i();
        this.f17531L1 = cVar.i();
        if (14 <= cVar.f6409x0) {
            this.f17532M1 = cVar.i();
        }
        if (9 <= cVar.f6409x0) {
            this.f17533N1 = cVar.m();
            this.f17534O1 = cVar.m();
        }
        if (11 <= cVar.f6409x0) {
            this.f17535P1 = cVar.m();
            this.f17536Q1 = cVar.m();
        } else {
            this.f17535P1 = C1827a.h.a((char) cVar.readShort()).build();
        }
        if (15 <= cVar.f6409x0) {
            this.f17537R1 = cVar.i();
            this.f17538S1 = cVar.i();
            this.f17539T1 = cVar.i();
        }
        if (11 <= cVar.f6409x0) {
            this.U1 = cVar.readInt();
        }
        this.f17540V1 = cVar.readBoolean();
        this.W1 = 14 <= cVar.f6409x0 ? cVar.readInt() : cVar.readBoolean();
        if (8 > cVar.f6409x0) {
            cVar.a();
        }
        this.f17541X1 = cVar.a();
        this.f17542Y1 = cVar.i();
        if (14 <= cVar.f6409x0) {
            this.f17543Z1 = cVar.i();
        }
        if (8 <= cVar.f6409x0) {
            this.f17544a2 = cVar.i();
            this.f17545b2 = cVar.i();
        } else {
            cVar.readBoolean();
            cVar.readBoolean();
            cVar.d();
            cVar.readBoolean();
        }
        this.f17546c2 = 9 <= cVar.f6409x0 ? cVar.readFloat() : cVar.readBoolean() ? -1.0f : Float.NaN;
        this.f17547d2 = cVar.b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        q2(null, true);
    }

    @Override // com.llamalab.automate.S1
    public final String v2() {
        if (this.f17543Z1 == null) {
            return super.v2();
        }
        return this.f15401Z + "#" + this.f17543Z1;
    }
}
