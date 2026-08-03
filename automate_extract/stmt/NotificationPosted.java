package com.llamalab.automate.stmt;

import L3.C1041f;
import L3.C1047l;
import L3.C1053s;
import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import com.llamalab.android.app.f;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.AutomateNotificationListenerService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1619q;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.K1;
import com.llamalab.automate.R1;
import com.llamalab.automate.Visitor;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Pattern;
import x3.C2424b;
import x3.C2425c;
import x3.C2440r;
import x3.C2446x;

@F3.f("notification_posted.html")
@F3.a(C2541R.integer.ic_notification_query)
@F3.i(C2541R.string.stmt_notification_posted_title)
@F3.h(C2541R.string.stmt_notification_posted_summary)
@F3.e(C2541R.layout.stmt_notification_posted_edit)
/* loaded from: classes.dex */
public final class NotificationPosted extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 channelId;
    public InterfaceC1700x0 flagsExclude;
    public InterfaceC1700x0 index;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 picturePath;
    public InterfaceC1700x0 title;
    public J3.l varActions;

    @Deprecated
    public J3.l varAdditional;
    public J3.l varCategory;
    public J3.l varChannelId;
    public J3.l varExtras;
    public J3.l varKey;
    public J3.l varMessage;
    public J3.l varPackageName;
    public J3.l varPersonUris;
    public J3.l varRemoveReason;
    public J3.l varTicker;
    public J3.l varTitle;
    public J3.l varWhen;
    public InterfaceC1700x0 visibility;

    public static final class a extends R1 {

        /* renamed from: y1, reason: collision with root package name */
        public final c f16971y1;

        public a(d dVar) {
            this.f16971y1 = new c(this, dVar);
        }

        @Override // com.llamalab.automate.R1, com.llamalab.automate.Z1
        public final void D0(AutomateNotificationListenerService automateNotificationListenerService, StatusBarNotification statusBarNotification) {
            v2(automateNotificationListenerService, true, statusBarNotification, 0);
        }

        @Override // com.llamalab.automate.R1, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            c cVar = this.f16971y1;
            cVar.f16976x0 = true;
            automateService.f14581L1.removeCallbacks(cVar);
            super.F(automateService);
        }

        @Override // com.llamalab.automate.R1, com.llamalab.automate.Z1
        public final void e1(AutomateNotificationListenerService automateNotificationListenerService, StatusBarNotification statusBarNotification, int i8) {
            v2(automateNotificationListenerService, false, statusBarNotification, i8);
        }

        public final void v2(AutomateNotificationListenerService automateNotificationListenerService, boolean z7, StatusBarNotification statusBarNotification, int i8) {
            String packageName;
            Notification notification;
            try {
                c cVar = this.f16971y1;
                packageName = statusBarNotification.getPackageName();
                String str = packageName != null ? packageName : "android";
                String l8 = C2424b.l(automateNotificationListenerService, statusBarNotification);
                notification = statusBarNotification.getNotification();
                cVar.b(z7, str, l8, new com.llamalab.android.app.f(notification), i8);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static final class b extends C1619q {

        /* renamed from: N1, reason: collision with root package name */
        public final c f16972N1;

        public b(d dVar) {
            super(64, 0);
            this.f16972N1 = new c(this, dVar);
        }

        @Override // com.llamalab.automate.C1619q, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            c cVar = this.f16972N1;
            cVar.f16976x0 = true;
            automateService.f14581L1.removeCallbacks(cVar);
            super.F(automateService);
        }

        @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
        public final void R0(AutomateAccessibilityService automateAccessibilityService, AccessibilityEvent accessibilityEvent) {
            try {
                if (64 == accessibilityEvent.getEventType()) {
                    Parcelable parcelableData = accessibilityEvent.getParcelableData();
                    if (parcelableData instanceof Notification) {
                        c cVar = this.f16972N1;
                        CharSequence packageName = accessibilityEvent.getPackageName();
                        if (packageName == null) {
                            packageName = "android";
                        }
                        cVar.b(true, packageName.toString(), null, new com.llamalab.android.app.f((Notification) parcelableData), 0);
                    }
                }
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static final class c implements Runnable {

        /* renamed from: X, reason: collision with root package name */
        public final ArrayBlockingQueue f16973X = new ArrayBlockingQueue(64);

        /* renamed from: Y, reason: collision with root package name */
        public final com.llamalab.automate.W f16974Y;

        /* renamed from: Z, reason: collision with root package name */
        public volatile d f16975Z;

        /* renamed from: x0, reason: collision with root package name */
        public volatile boolean f16976x0;

        public c(com.llamalab.automate.W w8, d dVar) {
            this.f16974Y = w8;
            this.f16975Z = dVar;
        }

        public final void a() {
            Object[] objArr;
            while (!this.f16976x0 && (objArr = (Object[]) this.f16973X.poll()) != null) {
                try {
                    if (this.f16975Z.a((String) objArr[1], (com.llamalab.android.app.f) objArr[3])) {
                        this.f16976x0 = true;
                        com.llamalab.automate.W w8 = this.f16974Y;
                        w8.getClass();
                        F5.n.i(w8, 500L);
                        com.llamalab.automate.W w9 = this.f16974Y;
                        w9.f15400Y.n(w9, objArr);
                        return;
                    }
                } catch (Throwable th) {
                    com.llamalab.automate.W w10 = this.f16974Y;
                    w10.f15400Y.U(w10, th);
                    return;
                }
            }
        }

        public final void b(boolean z7, String str, String str2, com.llamalab.android.app.f fVar, int i8) {
            if (this.f16975Z.a(str, fVar) && !this.f16973X.offer(new Object[]{Boolean.valueOf(z7), str, str2, fVar, null, Integer.valueOf(i8)})) {
                com.llamalab.automate.W w8 = this.f16974Y;
                w8.getClass();
                F5.n.g(w8, "Queue full");
            }
            a();
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f16976x0 = false;
            a();
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f16977a;

        /* renamed from: b, reason: collision with root package name */
        public final String f16978b;

        /* renamed from: c, reason: collision with root package name */
        public final String f16979c;

        /* renamed from: d, reason: collision with root package name */
        public final int f16980d;

        /* renamed from: e, reason: collision with root package name */
        public final int f16981e;

        public d(int i8, int i9, String str, String str2, String str3) {
            this.f16977a = str;
            this.f16978b = str2;
            this.f16979c = str3;
            this.f16980d = i8;
            this.f16981e = i9;
        }

        public final boolean a(CharSequence charSequence, com.llamalab.android.app.f fVar) {
            String str;
            int i8;
            if ((fVar.f14182g & this.f16981e) != 0) {
                return false;
            }
            int i9 = Build.VERSION.SDK_INT;
            if (21 <= i9 && (i8 = this.f16980d) != 0 && (i8 & (1 << fVar.f14183h)) == 0) {
                return false;
            }
            String str2 = this.f16977a;
            if (str2 != null && !str2.contentEquals(charSequence)) {
                return false;
            }
            if (26 <= i9 && (str = this.f16978b) != null && !str.equals(fVar.f14180e)) {
                return false;
            }
            String str3 = this.f16979c;
            if (str3 != null) {
                CharSequence charSequence2 = fVar.f14176a.getCharSequence("android.title");
                if (charSequence2 == null) {
                    charSequence2 = "";
                }
                if (!C2440r.v(str3, charSequence2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final class e extends g {

        /* renamed from: M1, reason: collision with root package name */
        public final Bitmap f16982M1;

        public e(Bitmap bitmap, Object... objArr) {
            super(objArr);
            this.f16982M1 = bitmap;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            z2(g.y2(this.f16982M1, C2425c.e(this.f15400Y)));
            q2(this.f16984L1, false);
        }
    }

    public static final class f extends g {

        /* renamed from: M1, reason: collision with root package name */
        public final Icon f16983M1;

        public f(Icon icon, Object... objArr) {
            super(objArr);
            this.f16983M1 = icon;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            Drawable loadDrawable;
            Bitmap bitmap;
            Bitmap bitmap2;
            loadDrawable = this.f16983M1.loadDrawable(this.f15400Y);
            Point e8 = C2425c.e(this.f15400Y);
            if (!(loadDrawable instanceof BitmapDrawable) || (bitmap2 = ((BitmapDrawable) loadDrawable).getBitmap()) == null) {
                int intrinsicWidth = loadDrawable.getIntrinsicWidth();
                int intrinsicHeight = loadDrawable.getIntrinsicHeight();
                if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                    intrinsicWidth = e8.y;
                    intrinsicHeight = e8.x;
                } else {
                    int i8 = e8.x;
                    if (intrinsicWidth > i8 || intrinsicHeight > e8.y) {
                        float f8 = intrinsicWidth;
                        float f9 = intrinsicHeight;
                        float min = Math.min(i8 / f8, e8.y / f9);
                        intrinsicWidth = Math.max(1, (int) (f8 * min));
                        intrinsicHeight = Math.max(1, (int) (min * f9));
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                loadDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                loadDrawable.draw(new Canvas(createBitmap));
                bitmap = createBitmap;
            } else {
                bitmap = g.y2(bitmap2, e8);
            }
            z2(bitmap);
            q2(this.f16984L1, false);
        }
    }

    public static abstract class g extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final Object[] f16984L1;

        public g(Object[] objArr) {
            this.f16984L1 = objArr;
        }

        public static Bitmap y2(Bitmap bitmap, Point point) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i8 = point.x;
            if (width <= i8 && height <= point.y) {
                return bitmap;
            }
            float f8 = width;
            float f9 = height;
            float min = Math.min(i8 / f8, point.y / f9);
            return min < 0.97f ? Bitmap.createScaledBitmap(bitmap, Math.max(1, (int) (f8 * min)), Math.max(1, (int) (min * f9)), true) : bitmap;
        }

        public final void z2(Bitmap bitmap) {
            OutputStream l8 = com.llamalab.safs.i.l((com.llamalab.safs.n) this.f16984L1[4], new com.llamalab.safs.l[0]);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 95, l8);
                if (l8 != null) {
                    l8.close();
                }
            } catch (Throwable th) {
                if (l8 != null) {
                    try {
                        l8.close();
                    } catch (Throwable th2) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        } catch (Exception unused) {
                        }
                    }
                }
                throw th;
            }
        }
    }

    public final void B(C1708z0 c1708z0, boolean z7, String str, String str2, com.llamalab.android.app.f fVar, int i8) {
        J3.a aVar;
        Double d8;
        J3.a aVar2;
        J3.a aVar3;
        J3.l lVar = this.varPackageName;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varChannelId;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, fVar.f14180e);
        }
        J3.l lVar3 = this.varTitle;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, C2446x.l(fVar.f14176a.getCharSequence("android.title")));
        }
        J3.l lVar4 = this.varMessage;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, C2446x.l(fVar.f14176a.getCharSequence("android.text")));
        }
        J3.l lVar5 = this.varTicker;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, C2446x.l(fVar.f14178c));
        }
        J3.l lVar6 = this.varAdditional;
        if (lVar6 != null) {
            CharSequence charSequence = fVar.f14176a.getCharSequence("android.infoText");
            Bundle bundle = fVar.f14176a;
            CharSequence charSequence2 = bundle.getCharSequence("android.title.big");
            CharSequence charSequence3 = bundle.getCharSequence("android.bigText");
            CharSequence[] charSequenceArray = bundle.getCharSequenceArray("android.textLines");
            if (charSequence == null && charSequence2 == null && charSequence3 == null && charSequenceArray == null) {
                aVar3 = null;
            } else {
                aVar3 = new J3.a(4);
                if (charSequence != null) {
                    aVar3.add(charSequence.toString());
                }
                if (charSequence2 != null) {
                    aVar3.add(charSequence2.toString());
                }
                if (charSequence3 != null) {
                    aVar3.add(charSequence3.toString());
                }
                if (charSequenceArray != null && charSequenceArray.length != 0) {
                    aVar3.add(TextUtils.join("\n", charSequenceArray));
                }
            }
            c1708z0.z(lVar6.f4659Y, aVar3);
        }
        J3.l lVar7 = this.varPersonUris;
        if (lVar7 != null) {
            String[] stringArray = fVar.f14176a.getStringArray("android.people");
            if (stringArray == null || stringArray.length == 0) {
                aVar2 = null;
            } else {
                Pattern pattern = J3.h.f4650a;
                int length = stringArray.length;
                Object[] objArr = new Object[length];
                int i9 = length;
                while (true) {
                    i9--;
                    if (i9 < 0) {
                        break;
                    }
                    String str3 = stringArray[i9];
                    if (str3 != null) {
                        objArr[i9] = str3;
                    }
                }
                aVar2 = new J3.a(length, objArr);
            }
            c1708z0.z(lVar7.f4659Y, aVar2);
        }
        J3.l lVar8 = this.varCategory;
        if (lVar8 != null) {
            c1708z0.z(lVar8.f4659Y, fVar.f14179d);
        }
        J3.l lVar9 = this.varWhen;
        if (lVar9 != null) {
            long j8 = fVar.f14181f;
            if (j8 > 0) {
                double d9 = j8;
                d8 = F5.n.l(d9, d9, d9, 1000.0d);
            } else {
                d8 = null;
            }
            c1708z0.z(lVar9.f4659Y, d8);
        }
        J3.l lVar10 = this.varExtras;
        if (lVar10 != null) {
            c1708z0.z(lVar10.f4659Y, J3.h.O(0, fVar.f14176a));
        }
        J3.l lVar11 = this.varActions;
        if (lVar11 != null) {
            f.a[] aVarArr = fVar.f14177b;
            if (aVarArr == null || aVarArr.length == 0) {
                aVar = null;
            } else {
                aVar = new J3.a(aVarArr.length);
                for (f.a aVar4 : aVarArr) {
                    aVar.add(C2446x.l(aVar4.f14184a));
                }
            }
            c1708z0.z(lVar11.f4659Y, aVar);
        }
        J3.l lVar12 = this.varKey;
        if (lVar12 != null) {
            c1708z0.z(lVar12.f4659Y, str2);
        }
        J3.l lVar13 = this.varRemoveReason;
        if (lVar13 != null) {
            c1708z0.z(lVar13.f4659Y, i8 > 0 ? Double.valueOf(1 << (i8 - 1)) : null);
        }
        o(c1708z0, z7);
    }

    public final boolean C(C1708z0 c1708z0, boolean z7, String str, String str2, com.llamalab.android.app.f fVar, int i8) {
        com.llamalab.safs.n p8;
        Bitmap bitmap;
        Icon h8;
        if (z7 && (p8 = J3.h.p(c1708z0, this.picturePath)) != null) {
            int i9 = Build.VERSION.SDK_INT;
            if (23 <= i9 && (h8 = D.d.h(fVar.f14176a.getParcelable("android.pictureIcon"))) != null) {
                f fVar2 = new f(h8, Boolean.valueOf(z7), str, str2, fVar, p8, Integer.valueOf(i8));
                c1708z0.w(fVar2);
                fVar2.w2();
                return true;
            }
            if (16 <= i9 && (bitmap = (Bitmap) fVar.f14176a.getParcelable("android.picture")) != null) {
                e eVar = new e(bitmap, Boolean.valueOf(z7), str, str2, fVar, p8, Integer.valueOf(i8));
                c1708z0.w(eVar);
                eVar.w2();
                return true;
            }
        }
        return false;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        int i8 = Build.VERSION.SDK_INT;
        if (30 > i8 || this.picturePath == null) {
            return 18 <= i8 ? this.picturePath != null ? new E3.b[]{com.llamalab.automate.access.c.f15554o, com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15554o} : this.picturePath != null ? new E3.b[]{com.llamalab.automate.access.c.f15540a, com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15540a};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.f15554o, com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15554o, com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_notification_posted_immediate, C2541R.string.caption_notification_posted_transition);
        return c1596k0.o(2, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        if (106 <= dVar.f6413Z) {
            dVar.g(this.channelId);
        }
        dVar.g(this.title);
        if (87 <= dVar.f6413Z) {
            dVar.g(this.visibility);
        }
        if (103 <= dVar.f6413Z) {
            dVar.g(this.flagsExclude);
        } else {
            InterfaceC1700x0 interfaceC1700x0 = this.flagsExclude;
            dVar.g(interfaceC1700x0 != null ? new C1041f(interfaceC1700x0, new C1053s(2)) : null);
        }
        if (97 <= dVar.f6413Z) {
            dVar.g(this.picturePath);
            dVar.g(this.index);
        }
        dVar.g(this.varPackageName);
        if (106 <= dVar.f6413Z) {
            dVar.g(this.varChannelId);
        }
        dVar.g(this.varTitle);
        dVar.g(this.varMessage);
        dVar.g(this.varTicker);
        if (45 <= dVar.f6413Z) {
            dVar.g(this.varAdditional);
            dVar.g(this.varPersonUris);
        }
        if (35 <= dVar.f6413Z) {
            dVar.g(this.varCategory);
        }
        dVar.g(this.varWhen);
        if (94 <= dVar.f6413Z) {
            dVar.g(this.varExtras);
        }
        if (50 <= dVar.f6413Z) {
            dVar.g(this.varActions);
        }
        dVar.g(this.varKey);
        if (81 <= dVar.f6413Z) {
            dVar.g(this.varRemoveReason);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.packageName);
        visitor.b(this.channelId);
        visitor.b(this.title);
        visitor.b(this.visibility);
        visitor.b(this.flagsExclude);
        visitor.b(this.picturePath);
        visitor.b(this.index);
        visitor.b(this.varPackageName);
        visitor.b(this.varChannelId);
        visitor.b(this.varTitle);
        visitor.b(this.varMessage);
        visitor.b(this.varTicker);
        visitor.b(this.varAdditional);
        visitor.b(this.varPersonUris);
        visitor.b(this.varCategory);
        visitor.b(this.varWhen);
        visitor.b(this.varExtras);
        visitor.b(this.varActions);
        visitor.b(this.varKey);
        visitor.b(this.varRemoveReason);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o0(R3.c cVar) {
        InterfaceC1700x0 c1053s;
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        if (106 <= cVar.f6409x0) {
            this.channelId = (InterfaceC1700x0) cVar.readObject();
        }
        this.title = (InterfaceC1700x0) cVar.readObject();
        if (87 <= cVar.f6409x0) {
            this.visibility = (InterfaceC1700x0) cVar.readObject();
        }
        if (103 <= cVar.f6409x0) {
            c1053s = (InterfaceC1700x0) cVar.readObject();
        } else {
            InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
            this.flagsExclude = interfaceC1700x0;
            if (!(interfaceC1700x0 instanceof L3.J)) {
                if (interfaceC1700x0 != null) {
                    this.flagsExclude = new C1047l(interfaceC1700x0, new C1053s(2), new L3.J(0));
                }
                if (97 <= cVar.f6409x0) {
                    this.picturePath = (InterfaceC1700x0) cVar.readObject();
                    this.index = (InterfaceC1700x0) cVar.readObject();
                }
                this.varPackageName = (J3.l) cVar.readObject();
                if (106 <= cVar.f6409x0) {
                    this.varChannelId = (J3.l) cVar.readObject();
                }
                this.varTitle = (J3.l) cVar.readObject();
                this.varMessage = (J3.l) cVar.readObject();
                this.varTicker = (J3.l) cVar.readObject();
                if (45 <= cVar.f6409x0) {
                    this.varAdditional = (J3.l) cVar.readObject();
                    this.varPersonUris = (J3.l) cVar.readObject();
                }
                if (35 <= cVar.f6409x0) {
                    this.varCategory = (J3.l) cVar.readObject();
                }
                this.varWhen = (J3.l) cVar.readObject();
                if (94 <= cVar.f6409x0) {
                    this.varExtras = (J3.l) cVar.readObject();
                }
                if (50 <= cVar.f6409x0) {
                    this.varActions = (J3.l) cVar.readObject();
                }
                this.varKey = (J3.l) cVar.readObject();
                if (81 > cVar.f6409x0) {
                    this.varRemoveReason = (J3.l) cVar.readObject();
                    return;
                }
                return;
            }
            c1053s = J3.h.J(interfaceC1700x0) ? new C1053s(2) : null;
        }
        this.flagsExclude = c1053s;
        if (97 <= cVar.f6409x0) {
        }
        this.varPackageName = (J3.l) cVar.readObject();
        if (106 <= cVar.f6409x0) {
        }
        this.varTitle = (J3.l) cVar.readObject();
        this.varMessage = (J3.l) cVar.readObject();
        this.varTicker = (J3.l) cVar.readObject();
        if (45 <= cVar.f6409x0) {
        }
        if (35 <= cVar.f6409x0) {
        }
        this.varWhen = (J3.l) cVar.readObject();
        if (94 <= cVar.f6409x0) {
        }
        if (50 <= cVar.f6409x0) {
        }
        this.varKey = (J3.l) cVar.readObject();
        if (81 > cVar.f6409x0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0096, code lost:
    
        return true;
     */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        String packageName;
        Notification notification;
        c1708z0.q(C2541R.string.stmt_notification_posted_title);
        d dVar = new d(J3.h.m(c1708z0, this.visibility, 0) & (-2147483645), J3.h.m(c1708z0, this.flagsExclude, 0), J3.h.x(c1708z0, this.packageName, null), J3.h.x(c1708z0, this.channelId, null), J3.h.x(c1708z0, this.title, null));
        if (18 > Build.VERSION.SDK_INT) {
            if (J1(1) == 0) {
                K1 g12 = c1708z0.g1();
                g12.g(c1708z0.f17644y0, c1708z0.g(), "W", g12.f15091a.getText(C2541R.string.log_notification_posted_immediate_unsupported));
                o(c1708z0, false);
                return true;
            }
            b bVar = (b) c1708z0.d(b.class, this);
            if (bVar == null) {
                c1708z0.w(new b(dVar));
                return false;
            }
            c cVar = bVar.f16972N1;
            com.llamalab.automate.W w8 = cVar.f16974Y;
            w8.getClass();
            F5.n.h(w8);
            cVar.f16975Z = dVar;
            cVar.f16974Y.f15400Y.f14581L1.post(cVar);
            return false;
        }
        if (J1(1) != 0) {
            a aVar = (a) c1708z0.d(a.class, this);
            if (aVar == null) {
                c1708z0.w(new a(dVar));
                return false;
            }
            c cVar2 = aVar.f16971y1;
            com.llamalab.automate.W w9 = cVar2.f16974Y;
            w9.getClass();
            F5.n.h(w9);
            cVar2.f16975Z = dVar;
            cVar2.f16974Y.f15400Y.f14581L1.post(cVar2);
            return false;
        }
        int m8 = J3.h.m(c1708z0, this.index, 0);
        StatusBarNotification[] activeNotifications = AbstractStatement.j().getActiveNotifications();
        int length = activeNotifications.length;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i8 >= length) {
                o(c1708z0, false);
                break;
            }
            StatusBarNotification statusBarNotification = activeNotifications[i8];
            packageName = statusBarNotification.getPackageName();
            notification = statusBarNotification.getNotification();
            com.llamalab.android.app.f fVar = new com.llamalab.android.app.f(notification);
            if (dVar.a(packageName, fVar)) {
                int i10 = i9 + 1;
                if (m8 == i9) {
                    String l8 = C2424b.l(c1708z0, statusBarNotification);
                    if (C(c1708z0, true, packageName, l8, fVar, 0)) {
                        return false;
                    }
                    B(c1708z0, true, packageName, l8, fVar, 0);
                } else {
                    i9 = i10;
                }
            }
            i8++;
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        String str = (String) objArr[1];
        String str2 = (String) objArr[2];
        com.llamalab.android.app.f fVar = (com.llamalab.android.app.f) objArr[3];
        int intValue = ((Integer) objArr[5]).intValue();
        if (!(w8 instanceof g) && C(c1708z0, booleanValue, str, str2, fVar, intValue)) {
            return false;
        }
        B(c1708z0, booleanValue, str, str2, fVar, intValue);
        return true;
    }
}
