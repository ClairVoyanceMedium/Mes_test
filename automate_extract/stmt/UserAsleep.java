package com.llamalab.automate.stmt;

import G1.C0967a;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import g1.C1808d;
import i1.AbstractC1929p;
import j1.C1988p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import k1.C2042c;
import x3.C2424b;
import z1.C2478a;
import z1.C2479b;
import z1.C2483f;

@F3.f("user_asleep.html")
@F3.a(C2541R.integer.ic_device_doze)
@F3.i(C2541R.string.stmt_user_asleep_title)
@F3.h(C2541R.string.stmt_user_asleep_summary)
@F3.c(C2541R.string.caption_user_asleep)
@F3.e(C2541R.layout.stmt_user_asleep_edit)
/* loaded from: classes.dex */
public final class UserAsleep extends Decision implements IntentStatement, InterfaceC1622q2 {

    /* renamed from: M1, reason: collision with root package name */
    public static final a f17223M1 = new a();

    /* renamed from: L1, reason: collision with root package name */
    public int f17224L1 = -1;
    public InterfaceC1700x0 maxConfidence;
    public InterfaceC1700x0 minConfidence;
    public J3.l varAmbientLight;
    public J3.l varConfidence;
    public J3.l varDeviceMotion;

    public class a implements Comparator<G1.h> {
        @Override // java.util.Comparator
        public final int compare(G1.h hVar, G1.h hVar2) {
            long j8 = hVar.f3931X * 1000;
            long j9 = hVar2.f3931X * 1000;
            if (j8 == j9) {
                return 0;
            }
            return j8 < j9 ? -1 : 1;
        }
    }

    public static void z(C1708z0 c1708z0) {
        PendingIntent l8 = c1708z0.l(536870912 | C2424b.f23371b, "com.llamalab.automate.intent.action.SLEEP_SEGMENT_UPDATE");
        if (l8 != null) {
            int i8 = C0967a.f3909a;
            C2483f c2483f = new C2483f(c1708z0);
            AbstractC1929p.a aVar = new AbstractC1929p.a();
            aVar.f19692a = new C2478a(0, l8);
            aVar.f19695d = 2411;
            c2483f.c(1, aVar.a());
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final void C1(C1708z0 c1708z0) {
        z(c1708z0);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACTIVITY_RECOGNITION")} : new E3.b[]{com.llamalab.automate.access.c.j("com.google.android.gms.permission.ACTIVITY_RECOGNITION")};
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        List emptyList;
        ArrayList arrayList;
        C1988p.h(intent);
        if (intent.hasExtra("com.google.android.location.internal.EXTRA_SLEEP_CLASSIFY_RESULT") && (arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.internal.EXTRA_SLEEP_CLASSIFY_RESULT")) != null) {
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                byte[] bArr = (byte[]) arrayList.get(i8);
                C1988p.h(bArr);
                arrayList2.add((G1.h) C2042c.a(bArr, G1.h.CREATOR));
            }
            emptyList = Collections.unmodifiableList(arrayList2);
        } else {
            emptyList = Collections.emptyList();
        }
        int size2 = emptyList.size();
        if (size2 == 0) {
            return false;
        }
        boolean z7 = true;
        if (size2 != 1) {
            ArrayList arrayList3 = new ArrayList(emptyList);
            Collections.sort(arrayList3, f17223M1);
            emptyList = arrayList3;
        }
        Double j8 = J3.h.j(c1708z0, this.minConfidence);
        Double j9 = J3.h.j(c1708z0, this.maxConfidence);
        long longExtra = intent.getLongExtra("com.llamalab.automate.intent.extra.REQUEST_TIME", 0L);
        Double d8 = (Double) c1708z0.j(this.f17224L1);
        Iterator it = emptyList.iterator();
        while (true) {
            G1.h hVar = (G1.h) it.next();
            boolean hasNext = it.hasNext();
            double d9 = hVar.f3932Y;
            if (!hasNext && longExtra < hVar.f3931X * 1000) {
                int i9 = hVar.f3933Z;
                int i10 = hVar.f3934x0;
                if (j8 == null && j9 == null) {
                    z(c1708z0);
                    c1708z0.z(this.f17224L1, Double.valueOf(d9));
                    Double valueOf = Double.valueOf(d9);
                    double d10 = i10;
                    Double.isNaN(d10);
                    Double.isNaN(d10);
                    Double valueOf2 = Double.valueOf((d10 / 6.0d) * 100.0d);
                    double d11 = i9;
                    Double.isNaN(d11);
                    Double.isNaN(d11);
                    w(c1708z0, true, valueOf, valueOf2, Double.valueOf((d11 / 6.0d) * 100.0d));
                    return z7;
                }
                if (d8 != null) {
                    if ((j8 != null && d9 < j8.doubleValue()) || (j9 != null && d9 > j9.doubleValue())) {
                        z7 = false;
                    }
                    double doubleValue = d8.doubleValue();
                    if (z7 != ((j8 == null || doubleValue >= j8.doubleValue()) && (j9 == null || doubleValue <= j9.doubleValue()))) {
                        z(c1708z0);
                        c1708z0.z(this.f17224L1, Double.valueOf(d9));
                        Double valueOf3 = Double.valueOf(d9);
                        double d12 = i10;
                        Double.isNaN(d12);
                        Double.isNaN(d12);
                        Double valueOf4 = Double.valueOf((d12 / 6.0d) * 100.0d);
                        double d13 = i9;
                        Double.isNaN(d13);
                        Double.isNaN(d13);
                        w(c1708z0, z7, valueOf3, valueOf4, Double.valueOf((d13 / 6.0d) * 100.0d));
                        return true;
                    }
                }
            }
            c1708z0.z(this.f17224L1, Double.valueOf(d9));
            Double valueOf5 = Double.valueOf(d9);
            if (!hasNext) {
                return false;
            }
            d8 = valueOf5;
            z7 = true;
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.minConfidence);
        dVar.g(this.maxConfidence);
        dVar.g(this.varConfidence);
        dVar.g(this.varAmbientLight);
        dVar.g(this.varDeviceMotion);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.minConfidence);
        visitor.b(this.maxConfidence);
        visitor.b(this.varConfidence);
        visitor.b(this.varAmbientLight);
        visitor.b(this.varDeviceMotion);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f17224L1 = c1625r2.d(false);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.minConfidence = (InterfaceC1700x0) cVar.readObject();
        this.maxConfidence = (InterfaceC1700x0) cVar.readObject();
        this.varConfidence = (J3.l) cVar.readObject();
        this.varAmbientLight = (J3.l) cVar.readObject();
        this.varDeviceMotion = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_user_asleep_title);
        Bundle bundle = new Bundle();
        bundle.putLong("com.llamalab.automate.intent.extra.REQUEST_TIME", System.currentTimeMillis());
        PendingIntent m8 = c1708z0.m("com.llamalab.automate.intent.action.SLEEP_SEGMENT_UPDATE", bundle, 134217728 | C2424b.f23371b, 0);
        int i8 = C0967a.f3909a;
        C2483f c2483f = new C2483f(c1708z0);
        G1.i iVar = new G1.i(2, null);
        C1988p.i(m8, "PendingIntent must be specified.");
        AbstractC1929p.a aVar = new AbstractC1929p.a();
        aVar.f19692a = new C2479b(c2483f, m8, iVar);
        aVar.f19694c = new C1808d[]{G1.u.f3957a};
        aVar.f19695d = 2410;
        N1.t c8 = c2483f.c(0, aVar.a());
        I i9 = new I(false);
        c1708z0.w(i9);
        c8.n(i9);
        return false;
    }

    public final void w(C1708z0 c1708z0, boolean z7, Double d8, Double d9, Double d10) {
        J3.l lVar = this.varConfidence;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        J3.l lVar2 = this.varAmbientLight;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, d9);
        }
        J3.l lVar3 = this.varDeviceMotion;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d10);
        }
        o(c1708z0, z7);
    }
}
