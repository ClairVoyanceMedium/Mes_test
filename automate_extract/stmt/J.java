package com.llamalab.automate.stmt;

import Q3.e;
import Q3.e.a;
import Q3.e.d;
import Q3.e.f;
import Y3.EnumC1167c;
import Y3.InterfaceC1170f;
import a4.C1209r;
import android.os.Build;
import android.os.Environment;
import android.util.Pair;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C2541R;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.AbstractMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import l4.InterfaceC2065a;
import p3.C2213b;
import s1.C2305a;
import x3.C2429g;

/* loaded from: classes.dex */
public final class J extends AbstractRunnableC1694v2 implements e.b {

    /* renamed from: L1, reason: collision with root package name */
    public final AtomicReference<Pair<Y3.v, X3.H<InterfaceC1170f, ?>>> f16810L1 = new AtomicReference<>();

    /* renamed from: M1, reason: collision with root package name */
    public final Q3.p f16811M1;

    /* renamed from: N1, reason: collision with root package name */
    public final Q3.c f16812N1;

    /* renamed from: O1, reason: collision with root package name */
    public final int f16813O1;

    /* renamed from: P1, reason: collision with root package name */
    public final com.llamalab.safs.n f16814P1;

    /* renamed from: Q1, reason: collision with root package name */
    public Q3.b f16815Q1;

    public J(Q3.q qVar, Q3.c cVar, int i8, com.llamalab.safs.n nVar) {
        this.f16811M1 = qVar;
        this.f16812N1 = cVar;
        this.f16813O1 = i8;
        this.f16814P1 = nVar;
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        e.g gVar;
        super.C(automateService, j8, j9, j10);
        Q3.e y7 = automateService.y();
        Q3.p pVar = this.f16811M1;
        Q3.c cVar = this.f16812N1;
        boolean z7 = this.f16813O1 != 0;
        y7.getClass();
        pVar.getClass();
        cVar.getClass();
        synchronized (y7.f6177c) {
            Pair<Class<? extends Q3.p>, ?> a8 = pVar.a();
            gVar = (e.g) y7.f6177c.get(a8);
            if (gVar == null) {
                if (pVar instanceof Q3.q) {
                    gVar = 21 <= Build.VERSION.SDK_INT ? y7.new f((Q3.q) pVar) : y7.new d((Q3.q) pVar);
                } else {
                    if (!(pVar instanceof Q3.a)) {
                        throw new IllegalArgumentException();
                    }
                    gVar = y7.new a((Q3.a) pVar);
                }
                y7.f6177c.put(a8, gVar);
            }
        }
        gVar.g(pVar, cVar, z7, this);
    }

    @Override // Q3.e.b
    public final void E(Throwable th) {
        F5.n.f(this, "HttpAcceptTask onHttpServerFailure: " + th);
    }

    @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        try {
            automateService.y().j(this.f16811M1, this.f16812N1, this);
        } catch (Throwable unused) {
        }
        Pair<Y3.v, X3.H<InterfaceC1170f, ?>> andSet = this.f16810L1.getAndSet(null);
        if (andSet != null) {
            try {
                Q3.e y7 = automateService.y();
                Y3.J j8 = ((Y3.v) andSet.first).j();
                int c8 = ((Y3.v) andSet.first).c();
                EnumC1167c enumC1167c = EnumC1167c.f7850N1;
                X3.H h8 = (X3.H) andSet.second;
                y7.getClass();
                y7.g(Q3.e.i(j8, c8, enumC1167c), h8);
            } catch (Throwable unused2) {
            }
        }
        try {
            Q3.b bVar = this.f16815Q1;
            if (bVar != null) {
                bVar.b();
                this.f16815Q1 = null;
            }
        } catch (Throwable unused3) {
        }
        super.F(automateService);
    }

    @Override // Q3.e.b
    public final void w1(Y3.v vVar, Q3.b bVar, X3.H h8) {
        try {
            this.f16810L1.set(new Pair<>(vVar, h8));
            if (bVar != null) {
                this.f16815Q1 = bVar;
                int i8 = this.f16813O1;
                if (i8 == 1) {
                    z2();
                    return;
                } else if (i8 == 2) {
                    w2();
                    return;
                }
            }
            o2(5100L, new Object[]{y2(vVar.k()), J3.h.P(vVar.h().f()), null, null});
        } catch (Throwable th) {
            Q3.b bVar2 = this.f16815Q1;
            if (bVar2 != null) {
                try {
                    bVar2.b();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
                this.f16815Q1 = null;
            }
            r2(th);
        }
    }

    @Override // com.llamalab.automate.AbstractRunnableC1694v2
    public final void x2() {
        Y3.v vVar = (Y3.v) this.f16810L1.get().first;
        String h8 = C2429g.h(((CharSequence) Y3.F.a(vVar.h().e(), C2213b.f21559a).getKey()).toString());
        com.llamalab.safs.n nVar = this.f16815Q1.f6405x1;
        com.llamalab.safs.n t8 = w0.L.t(this.f16814P1, Environment.DIRECTORY_DOWNLOADS, null, C2541R.string.format_upload_file, h8);
        if (nVar != null) {
            com.llamalab.safs.k[] kVarArr = com.llamalab.safs.i.f17783a;
            com.llamalab.safs.j.a(nVar, t8, true, false, new com.llamalab.safs.b[0]);
        } else {
            InterfaceC2065a j8 = com.llamalab.safs.i.j(t8, com.llamalab.safs.p.WRITE, com.llamalab.safs.p.CREATE, com.llamalab.safs.p.TRUNCATE_EXISTING);
            try {
                this.f16815Q1.h(j8);
                if (j8 != null) {
                    j8.close();
                }
            } catch (Throwable th) {
                if (j8 != null) {
                    try {
                        j8.close();
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
        this.f16815Q1.b();
        this.f16815Q1 = null;
        o2(5100L, new Object[]{y2(vVar.k()), J3.h.P(vVar.h().f()), t8.toString()});
    }

    public final J3.a y2(CharSequence charSequence) {
        CharBuffer decode = C1209r.f8266a.decode(C1209r.a(charSequence, 671088641L, -6052662140534259712L));
        Matcher matcher = this.f16812N1.f6170b.matcher(decode);
        return matcher.matches() ? J3.h.F(matcher) : new J3.a(1, new Object[]{decode.toString()});
    }

    public final void z2() {
        ByteBuffer d8;
        Y3.v vVar = (Y3.v) this.f16810L1.get().first;
        AbstractMap.SimpleImmutableEntry a8 = Y3.F.a(vVar.h().e(), C2213b.f21559a);
        CharSequence b8 = Y3.F.b(a8, "charset", "application/json".contentEquals((CharSequence) a8.getKey()) ? "UTF-8" : null);
        Q3.b bVar = this.f16815Q1;
        bVar.getClass();
        try {
            d8 = bVar.g();
        } catch (ClosedChannelException e8) {
            if (bVar.f6405x1 == null) {
                throw e8;
            }
            InterfaceC2065a j8 = com.llamalab.safs.i.j(bVar.f6405x1, com.llamalab.safs.p.READ);
            try {
                long size = j8.size();
                if (size > 2147483647L) {
                    throw new BufferOverflowException();
                }
                d8 = bVar.d(j8, (int) size);
                j8.close();
            } catch (Throwable th) {
                if (j8 != null) {
                    try {
                        j8.close();
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
        this.f16815Q1.b();
        this.f16815Q1 = null;
        if (b8 == null) {
            q7.b bVar2 = new q7.b();
            bVar2.b(d8.array(), d8.position() + d8.arrayOffset(), d8.remaining());
            bVar2.a();
            b8 = (CharSequence) C2305a.o(bVar2.f21852f, "UTF-8");
        }
        o2(5100L, new Object[]{y2(vVar.k()), J3.h.P(vVar.h().f()), new String(d8.array(), d8.position() + d8.arrayOffset(), d8.remaining(), b8.toString())});
    }
}
