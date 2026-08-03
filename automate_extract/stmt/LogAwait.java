package com.llamalab.automate.stmt;

import C1.D1;
import android.content.Context;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateApplication;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.N2;
import com.llamalab.automate.Visitor;
import f.RunnableC1764A;
import java.nio.charset.Charset;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import r3.AbstractRunnableC2258a;
import r3.EnumC2263f;
import r3.InterfaceC2264g;
import x3.C2425c;

@F3.f("log_await.html")
@F3.a(C2541R.integer.ic_log_scroll)
@F3.i(C2541R.string.stmt_log_await_title)
@F3.h(C2541R.string.stmt_log_await_summary)
@F3.e(C2541R.layout.stmt_log_await_edit)
/* loaded from: classes.dex */
public final class LogAwait extends Action implements AsyncStatement {
    public InterfaceC1700x0 log;
    public InterfaceC1700x0 message;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 priority;
    public InterfaceC1700x0 tag;
    public J3.l varLoggedMessage;
    public J3.l varLoggedTime;
    public J3.l varLoggingUidName;

    public static final class a extends com.llamalab.automate.W implements c {

        /* renamed from: y1, reason: collision with root package name */
        public final C0176a f16869y1;

        /* renamed from: com.llamalab.automate.stmt.LogAwait$a$a, reason: collision with other inner class name */
        public class C0176a extends b {
            public C0176a(EnumC2263f enumC2263f, String str, Pattern pattern, int i8, int i9) {
                super(enumC2263f, str, pattern, i8, i9);
            }

            @Override // com.llamalab.automate.stmt.LogAwait.b
            public final void c(long j8, Object obj) {
                a.this.o2(3000L, obj);
            }

            @Override // com.llamalab.automate.stmt.LogAwait.b
            public final void d(Throwable th) {
                a.this.r2(th);
            }

            @Override // com.llamalab.automate.stmt.LogAwait.b
            public final AutomateService e() {
                return a.this.f15400Y;
            }
        }

        public a(EnumC2263f enumC2263f, String str, Pattern pattern, int i8, int i9) {
            this.f16869y1 = new C0176a(enumC2263f, str, pattern, i8, i9);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            try {
                C0176a c0176a = this.f16869y1;
                c0176a.f16875x1 = D1.x(EnumSet.of(c0176a.f16871X), System.currentTimeMillis(), true, c0176a);
            } catch (Throwable th) {
                r2(th);
            }
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            C0176a c0176a = this.f16869y1;
            AbstractRunnableC2258a abstractRunnableC2258a = c0176a.f16875x1;
            if (abstractRunnableC2258a != null) {
                abstractRunnableC2258a.a();
                c0176a.f16875x1 = null;
            }
            u2();
        }

        @Override // com.llamalab.automate.stmt.LogAwait.c
        public final boolean R1(EnumC2263f enumC2263f, String str, Pattern pattern, int i8, int i9) {
            C0176a c0176a = this.f16869y1;
            if (c0176a.f16871X != enumC2263f) {
                return false;
            }
            c0176a.f16872Y = str;
            c0176a.f16873Z = pattern;
            c0176a.f16874x0 = i8;
            c0176a.f16876y0 = i9;
            AbstractRunnableC2258a abstractRunnableC2258a = c0176a.f16875x1;
            AtomicBoolean atomicBoolean = abstractRunnableC2258a.f21887Y;
            if (atomicBoolean.get()) {
                while (abstractRunnableC2258a.e()) {
                }
                atomicBoolean.set(false);
            }
            return true;
        }
    }

    public static abstract class b implements InterfaceC2264g {

        /* renamed from: X, reason: collision with root package name */
        public final EnumC2263f f16871X;

        /* renamed from: Y, reason: collision with root package name */
        public String f16872Y;

        /* renamed from: Z, reason: collision with root package name */
        public Pattern f16873Z;

        /* renamed from: x0, reason: collision with root package name */
        public int f16874x0;

        /* renamed from: x1, reason: collision with root package name */
        public AbstractRunnableC2258a f16875x1;

        /* renamed from: y0, reason: collision with root package name */
        public int f16876y0;

        /* renamed from: y1, reason: collision with root package name */
        public Matcher f16877y1;

        public b(EnumC2263f enumC2263f, String str, Pattern pattern, int i8, int i9) {
            this.f16871X = enumC2263f;
            this.f16872Y = str;
            this.f16873Z = pattern;
            this.f16874x0 = i8;
            this.f16876y0 = i9;
        }

        @Override // r3.InterfaceC2264g
        public final boolean a(int i8) {
            int i9 = this.f16874x0;
            return i9 == -1 || i9 == i8;
        }

        @Override // r3.InterfaceC2264g
        public final boolean b(CharSequence charSequence) {
            String str = this.f16872Y;
            return str == null || str.contentEquals(charSequence);
        }

        public abstract void c(long j8, Object obj);

        public abstract void d(Throwable th);

        public abstract AutomateService e();

        @Override // r3.InterfaceC2264g
        public final void h(EnumC2263f enumC2263f, long j8, int i8, int i9, CharSequence charSequence, CharSequence charSequence2) {
            J3.a aVar;
            String str;
            try {
                int i10 = this.f16876y0;
                if (i10 == -1 || i10 == i9) {
                    Pattern pattern = this.f16873Z;
                    if (pattern != null) {
                        Matcher matcher = this.f16877y1;
                        if (matcher != null) {
                            matcher.reset(charSequence2);
                        } else {
                            this.f16877y1 = pattern.matcher(charSequence2);
                        }
                        if (!this.f16877y1.matches()) {
                            return;
                        } else {
                            aVar = J3.h.F(this.f16877y1);
                        }
                    } else {
                        aVar = new J3.a(1, new Object[]{charSequence2.toString()});
                    }
                    if (i8 != -1) {
                        str = e().getPackageManager().getNameForUid(i8);
                        if (str == null) {
                            str = Integer.toString(i8);
                        }
                    } else {
                        str = null;
                    }
                    this.f16875x1.f21887Y.set(true);
                    Object[] objArr = new Object[3];
                    objArr[0] = aVar;
                    double d8 = j8;
                    Double.isNaN(d8);
                    Double.isNaN(d8);
                    objArr[1] = Double.valueOf(d8 / 1000.0d);
                    objArr[2] = str;
                    c(3000L, objArr);
                }
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    public interface c extends N2 {
        boolean R1(EnumC2263f enumC2263f, String str, Pattern pattern, int i8, int i9);
    }

    public static final class d extends AbstractC1602l2 implements c {

        /* renamed from: M1, reason: collision with root package name */
        public final a f16878M1;

        public class a extends b {
            public a(EnumC2263f enumC2263f, String str, Pattern pattern, int i8, int i9) {
                super(enumC2263f, str, pattern, i8, i9);
            }

            @Override // com.llamalab.automate.stmt.LogAwait.b
            public final void c(long j8, Object obj) {
                d.this.o2(3000L, obj);
            }

            @Override // com.llamalab.automate.stmt.LogAwait.b
            public final void d(Throwable th) {
                d.this.r2(th);
            }

            @Override // com.llamalab.automate.stmt.LogAwait.b
            public final AutomateService e() {
                return d.this.f15400Y;
            }
        }

        public d(EnumC2263f enumC2263f, String str, Pattern pattern, int i8, int i9) {
            this.f16878M1 = new a(enumC2263f, str, pattern, i8, i9);
        }

        @Override // com.llamalab.automate.AbstractC1602l2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            a aVar = this.f16878M1;
            AbstractRunnableC2258a abstractRunnableC2258a = aVar.f16875x1;
            if (abstractRunnableC2258a != null) {
                abstractRunnableC2258a.a();
                aVar.f16875x1 = null;
            }
            super.F(automateService);
        }

        @Override // com.llamalab.automate.stmt.LogAwait.c
        public final boolean R1(EnumC2263f enumC2263f, String str, Pattern pattern, int i8, int i9) {
            a aVar = this.f16878M1;
            if (aVar.f16871X != enumC2263f) {
                return false;
            }
            aVar.f16872Y = str;
            aVar.f16873Z = pattern;
            aVar.f16874x0 = i8;
            aVar.f16876y0 = i9;
            AbstractRunnableC2258a abstractRunnableC2258a = aVar.f16875x1;
            AtomicBoolean atomicBoolean = abstractRunnableC2258a.f21887Y;
            if (atomicBoolean.get()) {
                while (abstractRunnableC2258a.e()) {
                }
                atomicBoolean.set(false);
            }
            return true;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                a aVar = this.f16878M1;
                EnumSet of = EnumSet.of(aVar.f16871X);
                EnumC2263f enumC2263f = EnumC2263f.f21926x1;
                int[] iArr = new int[of.size()];
                Iterator it = of.iterator();
                int i8 = 0;
                while (it.hasNext()) {
                    int i9 = i8 + 1;
                    int i10 = ((EnumC2263f) it.next()).f21929Y;
                    iArr[i8] = i10;
                    if (i10 == -1) {
                        throw new IllegalArgumentException();
                    }
                    i8 = i9;
                }
                ParcelFileDescriptor[] U1 = interfaceC1585h1.U1(iArr, lVar);
                lVar.c();
                try {
                    EnumSet of2 = EnumSet.of(aVar.f16871X);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (24 > Build.VERSION.SDK_INT) {
                        throw new UnsupportedOperationException();
                    }
                    aVar.f16875x1 = new r3.j(U1, of2, currentTimeMillis, aVar);
                    try {
                        com.llamalab.android.app.h hVar = ((AutomateApplication) this.f15400Y.getApplicationContext()).f14526Y;
                        hVar.getClass();
                        hVar.f14189e.post(new RunnableC1764A(hVar, 7, this));
                    } catch (Throwable unused) {
                    }
                } catch (Throwable th) {
                    for (ParcelFileDescriptor parcelFileDescriptor : U1) {
                        Charset charset = com.llamalab.safs.internal.m.f17837a;
                        try {
                            parcelFileDescriptor.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                r2(th2);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return (33 > Build.VERSION.SDK_INT || 1 != C2425c.c(context).getInt("logcatWorkaround", 0)) ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_LOGS")} : new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 o6 = D1.P.l(context, C2541R.string.stmt_log_await_title).o(0, this.log);
        EnumC2263f enumC2263f = EnumC2263f.f21926x1;
        return o6.s("main").f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.log);
        dVar.g(this.tag);
        dVar.g(this.message);
        dVar.g(this.priority);
        dVar.g(this.packageName);
        dVar.g(this.varLoggedMessage);
        dVar.g(this.varLoggedTime);
        dVar.g(this.varLoggingUidName);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.log);
        visitor.b(this.tag);
        visitor.b(this.message);
        visitor.b(this.priority);
        visitor.b(this.packageName);
        visitor.b(this.varLoggedMessage);
        visitor.b(this.varLoggedTime);
        visitor.b(this.varLoggingUidName);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new RunnableC1639d0();
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.log = (InterfaceC1700x0) cVar.readObject();
        this.tag = (InterfaceC1700x0) cVar.readObject();
        this.message = (InterfaceC1700x0) cVar.readObject();
        this.priority = (InterfaceC1700x0) cVar.readObject();
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.varLoggedMessage = (J3.l) cVar.readObject();
        this.varLoggedTime = (J3.l) cVar.readObject();
        this.varLoggingUidName = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_log_await_title);
        InterfaceC1700x0 interfaceC1700x0 = this.log;
        EnumC2263f enumC2263f = EnumC2263f.f21926x1;
        String x7 = J3.h.x(c1708z0, interfaceC1700x0, "main");
        String x8 = J3.h.x(c1708z0, this.tag, null);
        String x9 = J3.h.x(c1708z0, this.message, null);
        int m8 = J3.h.m(c1708z0, this.priority, -1);
        String x10 = J3.h.x(c1708z0, this.packageName, null);
        EnumC2263f valueOf = EnumC2263f.valueOf(x7);
        IncapableAndroidVersionException.b(valueOf.f21928X, "log " + valueOf);
        Pattern compile = x9 != null ? Pattern.compile(x9) : null;
        int i8 = "root".equals(x10) ? 0 : "system".equals(x10) ? 1000 : "phone".equals(x10) ? 1001 : x10 != null ? c1708z0.getPackageManager().getApplicationInfo(x10, 0).uid : -1;
        c cVar = (c) c1708z0.d(c.class, this);
        if (cVar != null) {
            cVar.N();
            if (cVar.R1(valueOf, x8, compile, i8, m8)) {
                return false;
            }
            cVar.a();
        }
        c1708z0.w((33 > Build.VERSION.SDK_INT || 1 != C2425c.c(c1708z0).getInt("logcatWorkaround", 0)) ? new a(valueOf, x8, compile, i8, m8) : new d(valueOf, x8, compile, i8, m8));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varLoggedMessage;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[0]);
        }
        J3.l lVar2 = this.varLoggedTime;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[1]);
        }
        J3.l lVar3 = this.varLoggingUidName;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, objArr[2]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
