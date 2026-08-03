package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.field.CellSiteExprField;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import w3.AbstractC2395a;
import w3.b;
import x3.C2425c;

@F3.f("cell_site_near.html")
@F3.a(C2541R.integer.ic_cell_tower)
@F3.i(C2541R.string.stmt_cell_site_near_title)
@F3.h(C2541R.string.stmt_cell_site_near_summary)
@F3.e(C2541R.layout.stmt_cell_site_near_edit)
/* loaded from: classes.dex */
public final class CellSiteNear extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 connectionStatus;
    public InterfaceC1700x0 matchCells;
    public InterfaceC1700x0 subscriptionId;
    public J3.l varCellRssis;
    public J3.l varNearbyCells;

    public static final class a extends com.llamalab.automate.W implements b.a {

        /* renamed from: L1, reason: collision with root package name */
        public TelephonyManager f16437L1;

        /* renamed from: M1, reason: collision with root package name */
        public final Set<AbstractC2395a> f16438M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16439N1;

        /* renamed from: O1, reason: collision with root package name */
        public final int f16440O1;

        /* renamed from: P1, reason: collision with root package name */
        public final boolean f16441P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final boolean f16442Q1;

        /* renamed from: S1, reason: collision with root package name */
        public Set<AbstractC2395a> f16444S1;

        /* renamed from: y1, reason: collision with root package name */
        public final AtomicBoolean f16445y1 = new AtomicBoolean();

        /* renamed from: R1, reason: collision with root package name */
        public w3.b f16443R1 = w3.b.f23213H1;

        public a(LinkedHashSet linkedHashSet, int i8, int i9, boolean z7, boolean z8) {
            this.f16438M1 = linkedHashSet;
            this.f16439N1 = i8;
            this.f16440O1 = i9;
            this.f16441P1 = z7;
            this.f16442Q1 = z8;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            TelephonyManager telephonyManager = (TelephonyManager) automateService.getSystemService("phone");
            this.f16437L1 = telephonyManager;
            this.f16443R1 = F5.n.s(telephonyManager, this.f16440O1, AsyncTask.SERIAL_EXECUTOR, this);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            this.f16443R1.stop();
            u2();
        }

        @Override // w3.b.a
        public final void d2() {
            if (this.f16442Q1) {
                F5.n.f(this, "CellSiteNear initial scan complete");
            }
            if (this.f16441P1 || this.f16445y1.get()) {
                return;
            }
            this.f16443R1 = F5.n.t(this.f16437L1, this.f16440O1, AsyncTask.SERIAL_EXECUTOR, this);
        }

        @Override // w3.b.a
        public final void p(int i8, Throwable th) {
            if (this.f16445y1.compareAndSet(false, true)) {
                r2(new IllegalStateException(i8 != 1 ? i8 != 2 ? Integer.toString(i8) : "Modem error" : "Timeout", th).fillInStackTrace());
            }
        }

        @Override // com.llamalab.automate.W
        public final void p2(Object obj) {
            if (this.f16445y1.compareAndSet(false, true)) {
                q2(obj, false);
            }
        }

        @Override // w3.b.a
        public final void s1(Set<AbstractC2395a> set) {
            boolean z7 = this.f16442Q1;
            if (z7) {
                F5.n.f(this, "CellSiteNear nearby cells: " + set);
            }
            int i8 = this.f16439N1;
            if (i8 != 0 && !set.isEmpty()) {
                HashSet hashSet = new HashSet(set.size());
                for (AbstractC2395a abstractC2395a : set) {
                    int i9 = abstractC2395a.f23207x0;
                    if ((((i9 < 0 || i9 > 2) ? -1 : 1 << i9) & i8) != 0) {
                        hashSet.add(abstractC2395a);
                    }
                }
                if (z7) {
                    F5.n.f(this, "CellSiteNear nearby 0x" + Integer.toHexString(i8) + " filtered cells: " + hashSet);
                }
                set = hashSet;
            }
            boolean z8 = this.f16441P1;
            Set<AbstractC2395a> set2 = this.f16438M1;
            if (z8) {
                p2(new Object[]{Boolean.valueOf(set2.isEmpty() || !Collections.disjoint(set2, set)), set});
            } else if (this.f16444S1 != null) {
                if (!set2.isEmpty()) {
                    boolean z9 = !Collections.disjoint(set2, set);
                    if (z9 != (!Collections.disjoint(set2, this.f16444S1))) {
                        if (z7) {
                            F5.n.f(this, "CellSiteNear disjoint: " + Collections.disjoint(set2, set));
                        }
                        p2(new Object[]{Boolean.valueOf(z9), set});
                    }
                } else if (!this.f16444S1.equals(set)) {
                    p2(new Object[]{Boolean.TRUE, set});
                }
            }
            this.f16444S1 = set;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 31 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_PHONE_STATE"), com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")} : 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_COARSE_LOCATION")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        boolean z7 = true;
        c1596k0.j(this, 1, C2541R.string.caption_cell_site_near_immediate, C2541R.string.caption_cell_site_near_change);
        InterfaceC1700x0 interfaceC1700x0 = this.matchCells;
        if (interfaceC1700x0 != null) {
            try {
                new M3.c(true).b(interfaceC1700x0);
            } catch (Visitor.AbortException unused) {
                z7 = false;
            }
            if (z7) {
                c1596k0.v(interfaceC1700x0, 9);
                return c1596k0.q(this.matchCells).f16030c;
            }
        }
        c1596k0.k(false);
        return c1596k0.q(this.matchCells).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.matchCells);
        if (95 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
            dVar.g(this.connectionStatus);
        }
        dVar.g(this.varNearbyCells);
        if (52 <= dVar.f6413Z) {
            dVar.g(this.varCellRssis);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.matchCells);
        visitor.b(this.subscriptionId);
        visitor.b(this.connectionStatus);
        visitor.b(this.varNearbyCells);
        visitor.b(this.varCellRssis);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.matchCells = (InterfaceC1700x0) cVar.readObject();
        if (95 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
            this.connectionStatus = (InterfaceC1700x0) cVar.readObject();
        }
        this.varNearbyCells = (J3.l) cVar.readObject();
        if (52 <= cVar.f6409x0) {
            this.varCellRssis = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_cell_site_near_title);
        e(c1708z0);
        LinkedHashSet o6 = CellSiteExprField.o(c1708z0, this.matchCells);
        int m8 = J3.h.m(c1708z0, this.subscriptionId, w3.n.d());
        int m9 = J3.h.m(c1708z0, this.connectionStatus, 0);
        boolean z7 = J1(1) == 0;
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        if (a8) {
            c1708z0.p("CellSiteNear match cells: " + o6);
        }
        c1708z0.w(new a(o6, m9, m8, z7, a8));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.a aVar;
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        Collection collection = (Collection) objArr[1];
        int size = collection.size();
        J3.l lVar = this.varNearbyCells;
        J3.a aVar2 = null;
        if (lVar != null) {
            aVar = new J3.a(size);
            c1708z0.z(lVar.f4659Y, aVar);
        } else {
            aVar = null;
        }
        J3.l lVar2 = this.varCellRssis;
        if (lVar2 != null) {
            aVar2 = new J3.a(size);
            c1708z0.z(lVar2.f4659Y, aVar2);
        }
        if (aVar != null || aVar2 != null) {
            AbstractC2395a[] abstractC2395aArr = (AbstractC2395a[]) collection.toArray(AbstractC2395a.f23201x1);
            Arrays.sort(abstractC2395aArr, AbstractC2395a.f23202y0);
            for (AbstractC2395a abstractC2395a : abstractC2395aArr) {
                if (aVar != null) {
                    aVar.add(abstractC2395a.toString());
                }
                if (aVar2 != null) {
                    int i8 = abstractC2395a.f23205Y;
                    aVar2.add(Double.valueOf(i8 == 0 ? Double.NEGATIVE_INFINITY : i8));
                }
            }
        }
        o(c1708z0, booleanValue);
        return true;
    }
}
