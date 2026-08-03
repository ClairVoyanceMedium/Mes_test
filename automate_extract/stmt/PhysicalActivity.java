package com.llamalab.automate.stmt;

import G1.C0967a;
import G1.C0969c;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import i1.AbstractC1929p;
import j1.C1988p;
import java.util.ArrayList;
import k0.C2030g;
import k1.C2042c;
import x3.C2424b;
import x3.C2425c;
import y6.C2472a;
import z1.C2483f;

@F3.f("physical_activity.html")
@F3.a(C2541R.integer.ic_running)
@F3.i(C2541R.string.stmt_physical_activity_title)
@F3.h(C2541R.string.stmt_physical_activity_summary)
@F3.e(C2541R.layout.stmt_physical_activity_edit)
/* loaded from: classes.dex */
public final class PhysicalActivity extends Action implements IntentStatement {
    public InterfaceC1700x0 activities;
    public InterfaceC1700x0 interval;
    public InterfaceC1700x0 minConfidence;
    public J3.l varConfidence;
    public J3.l varCurrentActivity;

    public static void q(C1708z0 c1708z0) {
        PendingIntent l8 = c1708z0.l(536870912 | C2424b.f23371b, "com.llamalab.automate.intent.action.ACTIVITY_RECOGNITION_UPDATE");
        if (l8 != null) {
            int i8 = C0967a.f3909a;
            C2483f c2483f = new C2483f(c1708z0);
            AbstractC1929p.a aVar = new AbstractC1929p.a();
            aVar.f19692a = new C2472a(l8);
            aVar.f19695d = 2402;
            c2483f.c(1, aVar.a());
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final void C1(C1708z0 c1708z0) {
        q(c1708z0);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACTIVITY_RECOGNITION")} : new E3.b[]{com.llamalab.automate.access.c.j("com.google.android.gms.permission.ACTIVITY_RECOGNITION")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_physical_activity);
        l8.h(this.activities, null, C2541R.xml.physical_activities);
        C1596k0 q8 = l8.q(this.activities);
        q8.w(1, this.interval);
        return q8.f16030c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0043, code lost:
    
        if ((r3 instanceof com.google.android.gms.location.ActivityRecognitionResult) != false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x004d  */
    @Override // com.llamalab.automate.IntentStatement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        ActivityRecognitionResult activityRecognitionResult;
        Bundle extras;
        ArrayList b8;
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        ActivityRecognitionResult activityRecognitionResult2 = null;
        if ((intent != null && (intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT") || !((b8 = ActivityRecognitionResult.b(intent)) == null || b8.isEmpty()))) && (extras = intent.getExtras()) != null) {
            Object obj = extras.get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
            if (obj instanceof byte[]) {
                obj = C2042c.a((byte[]) obj, ActivityRecognitionResult.CREATOR);
            }
            activityRecognitionResult = (ActivityRecognitionResult) obj;
            if (activityRecognitionResult == null) {
                activityRecognitionResult2 = activityRecognitionResult;
            } else {
                ArrayList b9 = ActivityRecognitionResult.b(intent);
                if (b9 != null && !b9.isEmpty()) {
                    activityRecognitionResult2 = (ActivityRecognitionResult) b9.get(b9.size() - 1);
                }
            }
            if (a8) {
                c1708z0.p("PhysicalActivityActivityRecognitionResult: " + activityRecognitionResult2);
            }
            if (activityRecognitionResult2 != null) {
                int m8 = J3.h.m(c1708z0, this.activities, 0);
                double i8 = J3.h.i(c1708z0, this.minConfidence, 0.0d);
                for (C0969c c0969c : activityRecognitionResult2.f12693X) {
                    if (m8 == 0 || ((1 << c0969c.b()) & m8) != 0) {
                        if (i8 <= c0969c.f3920Y) {
                            q(c1708z0);
                            Double valueOf = Double.valueOf(1 << c0969c.b());
                            Double valueOf2 = Double.valueOf(c0969c.f3920Y);
                            J3.l lVar = this.varCurrentActivity;
                            if (lVar != null) {
                                c1708z0.z(lVar.f4659Y, valueOf);
                            }
                            J3.l lVar2 = this.varConfidence;
                            if (lVar2 != null) {
                                c1708z0.z(lVar2.f4659Y, valueOf2);
                            }
                            c1708z0.f17642x0 = this.onComplete;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        activityRecognitionResult = null;
        if (activityRecognitionResult == null) {
        }
        if (a8) {
        }
        if (activityRecognitionResult2 != null) {
        }
        return false;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.activities);
        dVar.g(this.minConfidence);
        dVar.g(this.interval);
        dVar.g(this.varCurrentActivity);
        dVar.g(this.varConfidence);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.activities);
        visitor.b(this.minConfidence);
        visitor.b(this.interval);
        visitor.b(this.varCurrentActivity);
        visitor.b(this.varConfidence);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.activities = (InterfaceC1700x0) cVar.readObject();
        this.minConfidence = (InterfaceC1700x0) cVar.readObject();
        this.interval = (InterfaceC1700x0) cVar.readObject();
        this.varCurrentActivity = (J3.l) cVar.readObject();
        this.varConfidence = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_physical_activity_title);
        long t8 = J3.h.t(c1708z0, this.interval, 30000L);
        PendingIntent l8 = c1708z0.l(268435456 | C2424b.f23371b, "com.llamalab.automate.intent.action.ACTIVITY_RECOGNITION_UPDATE");
        int i8 = C0967a.f3909a;
        C2483f c2483f = new C2483f(c1708z0);
        C1988p.a("intervalMillis can't be negative.", t8 >= 0);
        C1988p.j("Must set intervalMillis.", t8 != Long.MIN_VALUE);
        G1.p pVar = new G1.p(t8, true, null, null, null, false, null, 0L, null);
        pVar.f3949M1 = c2483f.f19140b;
        AbstractC1929p.a aVar = new AbstractC1929p.a();
        aVar.f19692a = new C2030g(pVar, 11, l8);
        aVar.f19695d = 2401;
        N1.t c8 = c2483f.c(1, aVar.a());
        I i9 = new I(false);
        c1708z0.w(i9);
        c8.n(i9);
        return false;
    }
}
