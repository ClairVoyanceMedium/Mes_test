package com.llamalab.automate.stmt;

import C1.D1;
import android.content.Context;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.stmt.FtpAction;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import p3.C2212a;
import x3.C2440r;

@F3.f("ftp_list.html")
@F3.a(C2541R.integer.ic_ftp_list)
@F3.i(C2541R.string.stmt_ftp_list_title)
@F3.h(C2541R.string.stmt_ftp_list_summary)
@F3.e(C2541R.layout.stmt_ftp_list_edit)
/* loaded from: classes.dex */
public final class FtpList extends FtpAction {
    public InterfaceC1700x0 modifiedSince;
    public InterfaceC1700x0 remotePath;
    public InterfaceC1700x0 types;
    public J3.l varFiles;

    public static final class a extends FtpAction.a {

        /* renamed from: V1, reason: collision with root package name */
        public static final C0174a f16659V1 = new C0174a();

        /* renamed from: Q1, reason: collision with root package name */
        public final File f16660Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final int f16661R1;

        /* renamed from: S1, reason: collision with root package name */
        public final long f16662S1;

        /* renamed from: T1, reason: collision with root package name */
        public String f16663T1;
        public J3.a U1;

        /* renamed from: com.llamalab.automate.stmt.FtpList$a$a, reason: collision with other inner class name */
        public class C0174a implements Comparator<g5.e> {
            @Override // java.util.Comparator
            public final int compare(g5.e eVar, g5.e eVar2) {
                return eVar.f18828Z.compareTo(eVar2.f18828Z);
            }
        }

        public a(g5.c cVar, String str, int i8, C1231k c1231k, String str2, File file, int i9, long j8) {
            super(cVar, str, i8, c1231k, str2);
            this.f16660Q1 = file;
            this.f16661R1 = i9;
            this.f16662S1 = j8;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            String path;
            y2();
            g5.c cVar = this.f16651L1;
            File file = this.f16660Q1;
            if (cVar.o(file.getPath())) {
                path = file.getPath();
            } else {
                this.f16663T1 = file.getName();
                path = file.getParent();
                if (path == null) {
                    path = "/";
                }
            }
            g5.h q8 = this.f16651L1.q(path);
            ArrayList arrayList = new ArrayList();
            for (String str : q8.f18832a) {
                g5.e d8 = q8.f18833b.d(str);
                if (d8 == null && q8.f18834c) {
                    d8 = new g5.e(str);
                }
                if (z2(d8)) {
                    arrayList.add(d8);
                }
            }
            g5.e[] eVarArr = (g5.e[]) arrayList.toArray(g5.h.f18831d);
            if (eVarArr == null) {
                throw new IOException(D1.k("list failed: ", path));
            }
            Arrays.sort(eVarArr, f16659V1);
            this.U1 = new J3.a(eVarArr.length);
            for (g5.e eVar : eVarArr) {
                this.U1.add(new File(path, eVar.f18828Z).getPath());
            }
            this.f16651L1.t();
            q2(null, false);
        }

        public final boolean z2(g5.e eVar) {
            Calendar calendar;
            if (eVar == null) {
                return false;
            }
            String str = this.f16663T1;
            if (str != null && !C2440r.v(str, eVar.f18828Z)) {
                return false;
            }
            int i8 = this.f16661R1;
            if (i8 == 1) {
                if (!(eVar.f18826X == 0)) {
                    return false;
                }
            } else if (i8 == 2 && !eVar.a()) {
                return false;
            }
            long j8 = this.f16662S1;
            return j8 <= Long.MIN_VALUE || (calendar = eVar.f18829x0) == null || calendar.getTimeInMillis() >= j8;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 q8 = D1.P.l(context, C2541R.string.caption_ftp_list).o(-2, this.host).q(this.host);
        q8.t(this.remotePath);
        return q8.q(this.remotePath).f16030c;
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.remotePath);
        dVar.g(this.types);
        dVar.g(this.modifiedSince);
        dVar.g(this.varFiles);
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.remotePath);
        visitor.b(this.types);
        visitor.b(this.modifiedSince);
        visitor.b(this.varFiles);
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.remotePath = (InterfaceC1700x0) cVar.readObject();
        this.types = (InterfaceC1700x0) cVar.readObject();
        this.modifiedSince = (InterfaceC1700x0) cVar.readObject();
        this.varFiles = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.FtpAction
    public final void q(C1708z0 c1708z0, g5.c cVar, String str, int i8, C1231k c1231k, String str2) {
        String x7 = J3.h.x(c1708z0, this.remotePath, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("remotePath");
        }
        String g8 = C2212a.g(x7);
        if (g8 == null) {
            throw new IllegalArgumentException("remotePath");
        }
        a aVar = new a(cVar, str, i8, c1231k, str2, new File(g8), J3.h.m(c1708z0, this.types, 3) & 3, J3.h.t(c1708z0, this.modifiedSince, Long.MIN_VALUE));
        c1708z0.w(aVar);
        aVar.w2();
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_ftp_list_title);
        super.r1(c1708z0);
        return false;
    }

    @Override // com.llamalab.automate.stmt.FtpAction, com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.a aVar = ((a) w8).U1;
        J3.l lVar = this.varFiles;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, aVar);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
