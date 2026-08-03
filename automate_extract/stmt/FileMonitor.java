package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.safs.r;
import java.io.Closeable;

@F3.f("file_monitor.html")
@F3.a(C2541R.integer.ic_heart_monitor)
@F3.i(C2541R.string.stmt_file_monitor_title)
@F3.h(C2541R.string.stmt_file_monitor_summary)
@F3.e(C2541R.layout.stmt_file_monitor_edit)
/* loaded from: classes.dex */
public final class FileMonitor extends Action implements AsyncStatement {
    public InterfaceC1700x0 events;
    public InterfaceC1700x0 path;
    public J3.l varAlterationEvent;
    public J3.l varAlterationPath;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_file_monitor);
        l8.h(this.events, null, C2541R.xml.file_events);
        l8.t(this.path);
        return l8.q(this.path).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.path);
        dVar.g(this.events);
        dVar.g(this.varAlterationPath);
        dVar.g(this.varAlterationEvent);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.path);
        visitor.b(this.events);
        visitor.b(this.varAlterationPath);
        visitor.b(this.varAlterationEvent);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.path = (InterfaceC1700x0) cVar.readObject();
        this.events = (InterfaceC1700x0) cVar.readObject();
        this.varAlterationPath = (J3.l) cVar.readObject();
        this.varAlterationEvent = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_file_monitor_title);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.path);
        if (p8 == null) {
            throw new RequiredArgumentNullException("path");
        }
        int m8 = J3.h.m(c1708z0, this.events, MoreOsConstants.IN_ALL_EVENTS) & 12287;
        int bitCount = Integer.bitCount(m8);
        r.a[] aVarArr = new r.a[bitCount];
        int i8 = 14;
        int i9 = bitCount;
        while (true) {
            i8--;
            if (i8 < 0) {
                break;
            }
            if (((1 << i8) & m8) != 0) {
                i9--;
                aVarArr[i9] = i4.j.f19807f[i8];
            }
        }
        if (bitCount == 0) {
            throw new IllegalArgumentException("No events");
        }
        P3.p pVar = new P3.p(p8, aVarArr, new Closeable[0]);
        c1708z0.w(pVar);
        pVar.v2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varAlterationPath;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[0]);
        }
        J3.l lVar2 = this.varAlterationEvent;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[1]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
