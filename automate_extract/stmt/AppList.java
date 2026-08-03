package com.llamalab.automate.stmt;

import L3.C1053s;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Iterator;
import x3.C2440r;

@F3.f("app_list.html")
@F3.a(C2541R.integer.ic_app_list)
@F3.i(C2541R.string.stmt_app_list_title)
@F3.h(C2541R.string.stmt_app_list_summary)
@F3.c(C2541R.string.caption_app_list)
@F3.e(C2541R.layout.stmt_app_list_edit)
/* loaded from: classes.dex */
public final class AppList extends Action implements AsyncStatement {
    public InterfaceC1700x0 categories;
    public InterfaceC1700x0 flagsExclude;
    public InterfaceC1700x0 flagsInclude;
    public InterfaceC1700x0 states;
    public J3.l varDisplayNames;
    public J3.l varPackageNames;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final int f16258L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16259M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16260N1;

        /* renamed from: O1, reason: collision with root package name */
        public final int f16261O1;

        /* renamed from: P1, reason: collision with root package name */
        public final boolean f16262P1;

        public a(int i8, int i9, int i10, int i11, boolean z7) {
            this.f16258L1 = i8;
            this.f16259M1 = i9;
            this.f16260N1 = i10;
            this.f16261O1 = i11;
            this.f16262P1 = z7;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            int i8;
            J3.a aVar = new J3.a();
            J3.a aVar2 = this.f16262P1 ? new J3.a() : null;
            PackageManager packageManager = this.f15400Y.getPackageManager();
            int i9 = this.f16258L1;
            Iterator<ApplicationInfo> it = C2440r.n(packageManager, com.llamalab.automate.P.a(i9, i9)).iterator();
            while (true) {
                boolean z7 = false;
                if (!it.hasNext()) {
                    q2(new Object[]{aVar, aVar2}, false);
                    return;
                }
                ApplicationInfo next = it.next();
                if ((i9 == 0 || (next.flags & i9) == i9) && (next.flags & this.f16259M1) == 0) {
                    if (((next.enabled ? 1 : 2) & this.f16260N1) != 0) {
                        z7 = true;
                    }
                }
                if (z7) {
                    if (26 <= Build.VERSION.SDK_INT) {
                        i8 = next.category;
                        if (((1 << (i8 + 1)) & this.f16261O1) == 0) {
                        }
                    }
                    aVar.add(next.packageName);
                    if (aVar2 != null) {
                        aVar2.add(next.loadLabel(packageManager).toString());
                    }
                }
            }
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.flagsInclude);
        if (106 <= dVar.f6413Z) {
            dVar.g(this.flagsExclude);
            dVar.g(this.states);
        }
        if (74 <= dVar.f6413Z) {
            dVar.g(this.categories);
        }
        dVar.g(this.varPackageNames);
        if (111 <= dVar.f6413Z) {
            dVar.g(this.varDisplayNames);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.flagsInclude);
        visitor.b(this.flagsExclude);
        visitor.b(this.states);
        visitor.b(this.categories);
        visitor.b(this.varPackageNames);
        visitor.b(this.varDisplayNames);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.flagsInclude = (InterfaceC1700x0) cVar.readObject();
        if (106 <= cVar.f6409x0) {
            this.flagsExclude = (InterfaceC1700x0) cVar.readObject();
            this.states = (InterfaceC1700x0) cVar.readObject();
        } else {
            this.flagsExclude = new C1053s(MoreOsConstants.IN_ONLYDIR);
        }
        if (74 <= cVar.f6409x0) {
            this.categories = (InterfaceC1700x0) cVar.readObject();
        }
        this.varPackageNames = (J3.l) cVar.readObject();
        if (111 <= cVar.f6409x0) {
            this.varDisplayNames = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_app_list_title);
        a aVar = new a(J3.h.m(c1708z0, this.flagsInclude, 0), J3.h.m(c1708z0, this.flagsExclude, 0), J3.h.m(c1708z0, this.states, 3), J3.h.m(c1708z0, this.categories, -1), this.varDisplayNames != null);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.a aVar = (J3.a) objArr[0];
        J3.a aVar2 = (J3.a) objArr[1];
        J3.l lVar = this.varPackageNames;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, aVar);
        }
        J3.l lVar2 = this.varDisplayNames;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, aVar2);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
