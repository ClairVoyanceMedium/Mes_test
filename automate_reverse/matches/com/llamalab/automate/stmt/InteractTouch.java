package com.llamalab.automate.stmt;

import P.C1091g;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1619q;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import x3.C2424b;

@F3.f("interact_touch.html")
@F3.a(C2541R.integer.ic_action_screen_click)
@F3.i(C2541R.string.stmt_interact_touch_title)
@F3.h(C2541R.string.stmt_interact_touch_summary)
@F3.e(C2541R.layout.stmt_interact_touch_edit)
/* loaded from: classes.dex */
public final class InteractTouch extends Decision implements AsyncStatement {
    public InterfaceC1700x0 displayId;
    public InterfaceC1700x0 gesture;
    public InterfaceC1700x0 speed;

    /* renamed from: x0, reason: collision with root package name */
    public InterfaceC1700x0 f16747x0;

    /* renamed from: x1, reason: collision with root package name */
    public InterfaceC1700x0 f16748x1;

    /* renamed from: y0, reason: collision with root package name */
    public InterfaceC1700x0 f16749y0;

    /* renamed from: y1, reason: collision with root package name */
    public InterfaceC1700x0 f16750y1;

    public static final class a extends C1619q {

        /* renamed from: N1, reason: collision with root package name */
        public final GestureDescription f16751N1;

        /* renamed from: O1, reason: collision with root package name */
        public final C0175a f16752O1;

        /* renamed from: com.llamalab.automate.stmt.InteractTouch$a$a, reason: collision with other inner class name */
        public class C0175a extends AccessibilityService.GestureResultCallback {
            public C0175a() {
            }

            @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
            public final void onCancelled(GestureDescription gestureDescription) {
                a.this.q2(Boolean.FALSE, false);
            }

            @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
            public final void onCompleted(GestureDescription gestureDescription) {
                a.this.q2(Boolean.TRUE, false);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c[] cVarArr, int i8) {
            super(0, 0);
            this.f16752O1 = new C0175a();
            GestureDescription.Builder builder = new GestureDescription.Builder();
            if (30 <= Build.VERSION.SDK_INT) {
                builder.setDisplayId(i8);
            }
            for (c cVar : cVarArr) {
                Path path = cVar.f16767a;
                long j8 = cVar.f16768b;
                builder.addStroke(new GestureDescription.StrokeDescription(path, j8, cVar.f16769c - j8));
            }
            this.f16751N1 = builder.build();
        }

        @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
        public final void U1(AutomateAccessibilityService automateAccessibilityService) {
            super.U1(automateAccessibilityService);
            try {
                if (automateAccessibilityService.dispatchGesture(this.f16751N1, this.f16752O1, this.f15400Y.f14581L1)) {
                    return;
                }
                q2(Boolean.FALSE, false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static final class b extends AbstractC1602l2 implements Runnable {

        /* renamed from: M1, reason: collision with root package name */
        public final float[] f16754M1 = new float[2];

        /* renamed from: N1, reason: collision with root package name */
        public final c[] f16755N1;

        /* renamed from: O1, reason: collision with root package name */
        public final a[] f16756O1;

        /* renamed from: P1, reason: collision with root package name */
        public MotionEvent.PointerCoords[] f16757P1;

        /* renamed from: Q1, reason: collision with root package name */
        public MotionEvent.PointerProperties[] f16758Q1;

        /* renamed from: R1, reason: collision with root package name */
        public long f16759R1;

        /* renamed from: S1, reason: collision with root package name */
        public long f16760S1;

        /* renamed from: T1, reason: collision with root package name */
        public long f16761T1;
        public int U1;

        /* renamed from: V1, reason: collision with root package name */
        public int f16762V1;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public final MotionEvent.PointerCoords f16763a;

            /* renamed from: b, reason: collision with root package name */
            public final MotionEvent.PointerProperties f16764b;

            /* renamed from: c, reason: collision with root package name */
            public final PathMeasure f16765c;

            /* renamed from: d, reason: collision with root package name */
            public final float f16766d;

            public a(c cVar, int i8) {
                MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                this.f16763a = pointerCoords;
                MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
                this.f16764b = pointerProperties;
                Path path = cVar.f16767a;
                PathMeasure pathMeasure = new PathMeasure(path, false);
                this.f16765c = pathMeasure;
                float length = pathMeasure.getLength();
                this.f16766d = length;
                if (length == 0.0f) {
                    Path path2 = new Path(path);
                    path2.lineTo(-1.0f, -1.0f);
                    pathMeasure.setPath(path2, false);
                }
                pointerProperties.id = i8;
                pointerCoords.y = Float.NaN;
                pointerCoords.x = Float.NaN;
                pointerCoords.pressure = 1.0f;
                pointerCoords.size = 1.0f;
            }
        }

        public b(c[] cVarArr) {
            long j8 = 0;
            for (c cVar : cVarArr) {
                long j9 = cVar.f16769c;
                if (j8 < j9) {
                    j8 = j9;
                }
            }
            int i8 = C2424b.f23370a;
            if (j8 > (24 <= Build.VERSION.SDK_INT ? GestureDescription.getMaxGestureDuration() : 60000L)) {
                throw new IllegalStateException("Maximum gesture duration exceeded");
            }
            this.f16755N1 = cVarArr;
            this.f16756O1 = new a[cVarArr.length];
        }

        public final void A2(long j8, long j9) {
            c[] cVarArr;
            a[] aVarArr;
            boolean z7;
            do {
                long j10 = this.f16761T1;
                int i8 = -1;
                int i9 = 0;
                int i10 = -1;
                while (true) {
                    cVarArr = this.f16755N1;
                    int length = cVarArr.length;
                    aVarArr = this.f16756O1;
                    if (i9 >= length) {
                        break;
                    }
                    c cVar = cVarArr[i9];
                    if (aVarArr[i9] != null) {
                        long j11 = cVar.f16769c;
                        if (j10 <= j11 && j11 <= j9 && (i10 == -1 || j11 < cVarArr[i10].f16769c)) {
                            i10 = i9;
                        }
                    } else {
                        long j12 = cVar.f16768b;
                        if (j10 <= j12 && j12 <= j9 && (i8 == -1 || j12 < cVarArr[i8].f16768b)) {
                            i8 = i9;
                        }
                    }
                    i9++;
                }
                z7 = true;
                if (i10 != -1) {
                    if (i8 == -1 || cVarArr[i10].f16769c <= cVarArr[i8].f16768b) {
                        long j13 = j9 - cVarArr[i10].f16769c;
                        long j14 = j8 - j13;
                        long j15 = j9 - j13;
                        z2(j14, j15, 2, -1, false);
                        aVarArr[i10].f16763a.pressure = 0.0f;
                        if (this.U1 == 1) {
                            z2(j14, j15, 1, -1, true);
                            this.f16762V1 = 0;
                        } else {
                            z2(j14, j15, 6, i10, true);
                        }
                        aVarArr[i10] = null;
                        this.U1--;
                    }
                    y2(i8, j8, j9);
                } else {
                    if (i8 == -1) {
                        z7 = false;
                    }
                    y2(i8, j8, j9);
                }
            } while (z7);
            if (this.U1 != 0) {
                z2(j8, j9, 2, -1, false);
            }
            long j16 = Long.MAX_VALUE;
            for (c cVar2 : cVarArr) {
                long j17 = cVar2.f16768b;
                if (j9 >= j17 || j17 >= j16) {
                    long j18 = cVar2.f16769c;
                    if (j9 < j18 && j18 < j16) {
                        j16 = j18;
                    }
                } else {
                    j16 = j17;
                }
            }
            if (j16 != Long.MAX_VALUE) {
                this.f15400Y.f14581L1.postDelayed(this, Math.min(j16 - j9, 100L));
            } else {
                q2(Boolean.TRUE, false);
            }
        }

        @Override // com.llamalab.automate.AbstractC1602l2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            automateService.f14581L1.removeCallbacks(this);
            super.F(automateService);
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                A2(uptimeMillis, uptimeMillis - this.f16759R1);
            } catch (Throwable th) {
                r2(th);
            }
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f16759R1 = uptimeMillis;
                A2(uptimeMillis, 0L);
            } catch (Throwable th) {
                r2(th);
            }
        }

        public final void y2(int i8, long j8, long j9) {
            b bVar;
            long j10;
            long j11;
            int i9;
            int i10;
            boolean z7;
            c cVar = this.f16755N1[i8];
            long j12 = j9 - cVar.f16768b;
            long j13 = j8 - j12;
            long j14 = j9 - j12;
            int i11 = this.f16762V1 + 1;
            this.f16762V1 = i11;
            this.f16756O1[i8] = new a(cVar, i11);
            int i12 = this.U1 + 1;
            this.U1 = i12;
            if (i12 == 1) {
                this.f16760S1 = j13;
                bVar = this;
                j10 = j13;
                j11 = j14;
                i9 = 0;
                i10 = -1;
                z7 = true;
            } else {
                bVar = this;
                j10 = j13;
                j11 = j14;
                i9 = 5;
                i10 = i8;
                z7 = true;
            }
            bVar.z2(j10, j11, i9, i10, z7);
        }

        public final void z2(long j8, long j9, int i8, int i9, boolean z7) {
            int i10;
            MotionEvent.PointerCoords[] pointerCoordsArr = this.f16757P1;
            if (pointerCoordsArr == null || pointerCoordsArr.length != this.U1) {
                int i11 = this.U1;
                this.f16757P1 = new MotionEvent.PointerCoords[i11];
                this.f16758Q1 = new MotionEvent.PointerProperties[i11];
            }
            int i12 = i8;
            int i13 = 0;
            boolean z8 = false;
            int i14 = 0;
            while (true) {
                i10 = this.U1;
                if (i13 >= i10) {
                    break;
                }
                a aVar = this.f16756O1[i14];
                if (aVar != null) {
                    if (i9 == i14) {
                        i12 |= i13 << 8;
                    }
                    long j10 = this.f16755N1[i14].f16768b;
                    float f8 = (j9 - j10) / (r9.f16769c - j10);
                    float[] fArr = this.f16754M1;
                    aVar.f16765c.getPosTan(Math.min(f8, 1.0f) * aVar.f16766d, fArr, null);
                    MotionEvent.PointerCoords pointerCoords = aVar.f16763a;
                    float f9 = pointerCoords.x;
                    float f10 = fArr[0];
                    boolean z9 = true;
                    if (f9 == f10 && pointerCoords.y == fArr[1]) {
                        z9 = false;
                    } else {
                        pointerCoords.x = f10;
                        pointerCoords.y = fArr[1];
                    }
                    z8 |= z9;
                    this.f16757P1[i13] = pointerCoords;
                    this.f16758Q1[i13] = aVar.f16764b;
                    i13++;
                }
                i14++;
            }
            if (z8 || z7) {
                MotionEvent obtain = MotionEvent.obtain(this.f16760S1, j8, i12, i10, this.f16758Q1, this.f16757P1, 0, 0, 1.0f, 1.0f, 0, 0, 4098, 0);
                try {
                    t3.l lVar = new t3.l();
                    this.f16043y1.J(obtain, 0, lVar);
                    lVar.c();
                } finally {
                    obtain.recycle();
                }
            }
            this.f16761T1 = j9;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Path f16767a;

        /* renamed from: b, reason: collision with root package name */
        public final long f16768b;

        /* renamed from: c, reason: collision with root package name */
        public final long f16769c;

        public c(Path path, long j8, long j9) {
            this.f16767a = path;
            this.f16768b = j8;
            this.f16769c = j9;
        }
    }

    public static long B(Path path, float f8, float f9) {
        float length = new PathMeasure(path, false).getLength();
        if (length == 0.0f) {
            throw new IllegalArgumentException("Gesture has no length");
        }
        double d8 = length;
        double d9 = f9;
        double d10 = f8;
        Double.isNaN(d9);
        Double.isNaN(d10);
        Double.isNaN(d9);
        Double.isNaN(d10);
        Double.isNaN(d8);
        Double.isNaN(d8);
        long j8 = (long) ((d8 / (d9 * d10)) * 1000.0d);
        if (j8 > 0) {
            return j8;
        }
        throw new IllegalArgumentException("speed");
    }

    public static PointF C(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, InterfaceC1700x0 interfaceC1700x02, int i8) {
        Double j8 = J3.h.j(c1708z0, interfaceC1700x0);
        if (j8 == null) {
            throw new RequiredArgumentNullException(B4.g.g("x", i8));
        }
        Double j9 = J3.h.j(c1708z0, interfaceC1700x02);
        if (j9 != null) {
            return new PointF(y4.j.c(j8.floatValue() / 100.0f, 0.0f, 1.0f), y4.j.c(j9.floatValue() / 100.0f, 0.0f, 1.0f));
        }
        throw new RequiredArgumentNullException(B4.g.g("y", i8));
    }

    public static void D(Context context, int i8, Point point, DisplayMetrics displayMetrics) {
        int i9 = Build.VERSION.SDK_INT;
        Context applicationContext = context.getApplicationContext();
        Display display = 17 <= i9 ? C1091g.e(applicationContext.getSystemService("display")).getDisplay(i8) : ((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay();
        if (display == null) {
            throw new IllegalStateException(B4.g.g("Display not found: ", i8));
        }
        C2424b.f(display, point);
        if (displayMetrics != null) {
            display.getMetrics(displayMetrics);
        }
    }

    public static void E(PointF pointF, Point point) {
        pointF.x *= point.x;
        pointF.y *= point.y;
    }

    public static Path F(PointF pointF, PointF pointF2) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        path.lineTo(pointF2.x, pointF2.y);
        return path;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 24 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15540a} : new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_interact_touch).e(this.gesture, 1, C2541R.xml.touch_gestures).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (101 <= dVar.f6413Z) {
            dVar.g(this.displayId);
        }
        dVar.g(this.gesture);
        dVar.g(this.f16747x0);
        dVar.g(this.f16749y0);
        dVar.g(this.f16748x1);
        dVar.g(this.f16750y1);
        dVar.g(this.speed);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.displayId);
        visitor.b(this.gesture);
        visitor.b(this.f16747x0);
        visitor.b(this.f16749y0);
        visitor.b(this.f16748x1);
        visitor.b(this.f16750y1);
        visitor.b(this.speed);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new W();
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (101 <= cVar.f6409x0) {
            this.displayId = (InterfaceC1700x0) cVar.readObject();
        }
        this.gesture = (InterfaceC1700x0) cVar.readObject();
        this.f16747x0 = (InterfaceC1700x0) cVar.readObject();
        this.f16749y0 = (InterfaceC1700x0) cVar.readObject();
        this.f16748x1 = (InterfaceC1700x0) cVar.readObject();
        this.f16750y1 = (InterfaceC1700x0) cVar.readObject();
        this.speed = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00ca  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        int tapTimeout;
        c[] w8;
        c1708z0.q(C2541R.string.stmt_interact_touch_title);
        int m8 = J3.h.m(c1708z0, this.gesture, 1);
        int m9 = J3.h.m(c1708z0, this.displayId, 0);
        switch (m8) {
            case 1:
                tapTimeout = ViewConfiguration.getTapTimeout() / 2;
                w8 = w(c1708z0, m9, tapTimeout);
                if (24 > Build.VERSION.SDK_INT) {
                    c1708z0.w(new a(w8, m9));
                } else {
                    b bVar = new b(w8);
                    c1708z0.w(bVar);
                    bVar.n2(1);
                }
                return false;
            case 2:
                tapTimeout = ViewConfiguration.getLongPressTimeout() + 50;
                w8 = w(c1708z0, m9, tapTimeout);
                if (24 > Build.VERSION.SDK_INT) {
                }
                return false;
            case 3:
                Point point = new Point();
                D(c1708z0, m9, point, null);
                int tapTimeout2 = ViewConfiguration.getTapTimeout() / 2;
                int doubleTapTimeout = ViewConfiguration.getDoubleTapTimeout() / 2;
                PointF C7 = C(c1708z0, this.f16747x0, this.f16749y0, 0);
                E(C7, point);
                Path path = new Path();
                path.moveTo(C7.x, C7.y);
                w8 = new c[]{new c(path, 0L, tapTimeout2), new c(path, doubleTapTimeout + tapTimeout2, r6 + tapTimeout2)};
                if (24 > Build.VERSION.SDK_INT) {
                }
                return false;
            case 4:
                Point point2 = new Point();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                D(c1708z0, m9, point2, displayMetrics);
                PointF C8 = C(c1708z0, this.f16747x0, this.f16749y0, 0);
                E(C8, point2);
                PointF C9 = C(c1708z0, this.f16748x1, this.f16750y1, 1);
                E(C9, point2);
                Path F7 = F(C8, C9);
                w8 = new c[]{new c(F7, 0L, B(F7, displayMetrics.density, J3.h.l(c1708z0, this.speed, 1000.0f)))};
                if (24 > Build.VERSION.SDK_INT) {
                }
                return false;
            case 5:
                w8 = z(c1708z0, m9, false);
                if (24 > Build.VERSION.SDK_INT) {
                }
                return false;
            case 6:
                w8 = z(c1708z0, m9, true);
                if (24 > Build.VERSION.SDK_INT) {
                }
                return false;
            default:
                throw new IllegalArgumentException("gesture");
        }
    }

    public final c[] w(C1708z0 c1708z0, int i8, int i9) {
        Point point = new Point();
        D(c1708z0, i8, point, null);
        PointF C7 = C(c1708z0, this.f16747x0, this.f16749y0, 0);
        E(C7, point);
        Path path = new Path();
        path.moveTo(C7.x, C7.y);
        return new c[]{new c(path, 0L, i9)};
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }

    public final c[] z(C1708z0 c1708z0, int i8, boolean z7) {
        Point point = new Point();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        D(c1708z0, i8, point, displayMetrics);
        PointF C7 = C(c1708z0, this.f16747x0, this.f16749y0, 0);
        E(C7, point);
        PointF C8 = C(c1708z0, this.f16748x1, this.f16750y1, 1);
        E(C8, point);
        PointF pointF = new PointF((C7.x + C8.x) * 0.5f, (C7.y + C8.y) * 0.5f);
        Path F7 = z7 ? F(C7, pointF) : F(pointF, C7);
        Path F8 = z7 ? F(C8, pointF) : F(pointF, C8);
        long B7 = B(F7, displayMetrics.density, J3.h.l(c1708z0, this.speed, 250.0f));
        return new c[]{new c(F7, 0L, B7), new c(F8, 0L, B7)};
    }
}
