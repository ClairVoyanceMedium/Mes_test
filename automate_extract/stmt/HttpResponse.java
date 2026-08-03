package com.llamalab.automate.stmt;

import C1.D1;
import J3.e;
import X3.C1122h;
import X3.C1130p;
import X3.C1132s;
import X3.C1139z;
import Y3.EnumC1167c;
import Y3.InterfaceC1170f;
import Y3.J;
import Y3.y;
import a4.C1194c;
import a4.C1197f;
import a4.FutureC1199h;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Pair;
import androidx.appcompat.widget.C1231k;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.expr.func.JsonEncode;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.channels.SelectableChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import l4.InterfaceC2065a;
import p3.C2213b;
import x3.C2434l;

@F3.f("http_response.html")
@F3.a(C2541R.integer.ic_location_web_site)
@F3.i(C2541R.string.stmt_http_response_title)
@F3.h(C2541R.string.stmt_http_response_summary)
@F3.e(C2541R.layout.stmt_http_response_edit)
/* loaded from: classes.dex */
public final class HttpResponse extends Action implements AsyncStatement {
    public InterfaceC1700x0 bodyPart;
    public InterfaceC1700x0 bodyPath;
    public InterfaceC1700x0 contentType;
    public InterfaceC1700x0 headers;
    public InterfaceC1700x0 statusCode;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final AtomicReference<Pair<Y3.v, X3.H<InterfaceC1170f, ?>>> f16703L1;

        /* renamed from: M1, reason: collision with root package name */
        public final y.a f16704M1;

        /* renamed from: N1, reason: collision with root package name */
        public final Charset f16705N1;

        /* renamed from: O1, reason: collision with root package name */
        public final CharSequence[] f16706O1;

        /* renamed from: P1, reason: collision with root package name */
        public final com.llamalab.safs.n[] f16707P1;

        public a(Pair pair, Y3.z zVar, Charset charset, CharSequence[] charSequenceArr, com.llamalab.safs.n[] nVarArr) {
            this.f16703L1 = new AtomicReference<>(pair);
            this.f16704M1 = zVar;
            this.f16705N1 = charset;
            this.f16706O1 = charSequenceArr;
            this.f16707P1 = nVarArr;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            Pair<Y3.v, X3.H<InterfaceC1170f, ?>> andSet = this.f16703L1.getAndSet(null);
            if (andSet != null) {
                try {
                    Q3.e y7 = automateService.y();
                    Y3.J j8 = ((Y3.v) andSet.first).j();
                    int c8 = ((Y3.v) andSet.first).c();
                    EnumC1167c enumC1167c = EnumC1167c.f7850N1;
                    X3.H h8 = (X3.H) andSet.second;
                    y7.getClass();
                    y7.g(Q3.e.i(j8, c8, enumC1167c), h8);
                } catch (Throwable unused) {
                }
            }
            super.F(automateService);
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2, java.lang.Runnable
        public final void run() {
            ByteBuffer[] byteBufferArr = C1194c.f8199a;
            R0.u uVar = new R0.u();
            ArrayList arrayList = new ArrayList();
            AtomicReference<Pair<Y3.v, X3.H<InterfaceC1170f, ?>>> atomicReference = this.f16703L1;
            try {
                Y3.v vVar = (Y3.v) atomicReference.get().first;
                Q3.e y7 = this.f15400Y.y();
                Y3.J j8 = vVar.j();
                j8.getClass();
                w7.b y22 = j8 instanceof J.c ? y2(vVar.c(), uVar, y7.f6176b, arrayList) : z2(vVar.c(), uVar, y7.f6176b, arrayList);
                X3.H h8 = (X3.H) atomicReference.getAndSet(null).second;
                y7.g(y22, h8);
                h8.b().b(FutureC1199h.g.f8229w1, new Q3.k(this, 1, arrayList));
            } catch (Throwable th) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        ((Closeable) it.next()).close();
                    } catch (IOException e8) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, e8);
                        } catch (Exception unused) {
                        }
                    }
                }
                r2(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final w7.b y2(int i8, R0.u uVar, ExecutorService executorService, ArrayList arrayList) {
            com.llamalab.safs.n nVar;
            CharSequence charSequence;
            ArrayList arrayList2 = new ArrayList();
            Y3.z zVar = (Y3.z) this.f16704M1;
            zVar.f("Transfer-Encoding", "chunked");
            arrayList2.add(C1139z.b(zVar.a()));
            CharsetEncoder charsetEncoder = null;
            int i9 = 0;
            while (true) {
                CharSequence[] charSequenceArr = this.f16706O1;
                boolean z7 = i9 < charSequenceArr.length;
                if (z7 && (charSequence = charSequenceArr[i9]) != null && charSequence.length() != 0) {
                    if (charsetEncoder == null) {
                        charsetEncoder = this.f16705N1.newEncoder();
                    }
                    C1132s b8 = C1139z.b(charSequence);
                    charsetEncoder.getClass();
                    C1130p c1130p = new C1130p(uVar, charsetEncoder);
                    Y3.o oVar = new Y3.o(i8);
                    b8.g(c1130p);
                    c1130p.g(oVar);
                    arrayList2.add(oVar);
                }
                com.llamalab.safs.n[] nVarArr = this.f16707P1;
                boolean z8 = i9 < nVarArr.length;
                if (z8 && (nVar = nVarArr[i9]) != null) {
                    InterfaceC2065a j8 = com.llamalab.safs.i.j(nVar, com.llamalab.safs.p.READ);
                    arrayList.add(j8);
                    if (!(j8 instanceof SelectableChannel)) {
                        j8.getClass();
                    } else if (!((SelectableChannel) j8).isBlocking()) {
                        throw new IllegalBlockingModeException();
                    }
                    executorService.getClass();
                    C1122h c1122h = new C1122h(uVar, j8, executorService);
                    Y3.n nVar2 = new Y3.n(i8);
                    c1122h.g(nVar2);
                    arrayList2.add(nVar2);
                }
                i9++;
                if (!z7 && !z8) {
                    arrayList2.add(C1139z.b(F5.n.r(i8, Collections.emptyList(), true)));
                    return C1139z.a(arrayList2);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final w7.b z2(int i8, R0.u uVar, ExecutorService executorService, ArrayList arrayList) {
            com.llamalab.safs.n nVar;
            CharSequence charSequence;
            ArrayList arrayList2 = new ArrayList();
            long j8 = 0;
            int i9 = 0;
            while (true) {
                CharSequence[] charSequenceArr = this.f16706O1;
                boolean z7 = i9 < charSequenceArr.length;
                if (z7 && (charSequence = charSequenceArr[i9]) != null && charSequence.length() != 0) {
                    arrayList2.add(C1139z.b(this.f16705N1.encode(CharBuffer.wrap(charSequence))));
                    j8 += r5.remaining();
                }
                com.llamalab.safs.n[] nVarArr = this.f16707P1;
                boolean z8 = i9 < nVarArr.length;
                if (z8 && (nVar = nVarArr[i9]) != null) {
                    InterfaceC2065a j9 = com.llamalab.safs.i.j(nVar, com.llamalab.safs.p.READ);
                    arrayList.add(j9);
                    if (!(j9 instanceof SelectableChannel)) {
                        j9.getClass();
                    } else if (!((SelectableChannel) j9).isBlocking()) {
                        throw new IllegalBlockingModeException();
                    }
                    executorService.getClass();
                    arrayList2.add(new C1122h(uVar, j9, executorService));
                    j8 = j9.size() + j8;
                }
                i9++;
                if (!z7 && !z8) {
                    String valueOf = String.valueOf(j8);
                    Y3.z zVar = (Y3.z) this.f16704M1;
                    zVar.f("Content-Length", valueOf);
                    if (arrayList2.isEmpty()) {
                        return C1139z.b(zVar.a());
                    }
                    w7.b a8 = C1139z.a(arrayList2);
                    Y3.n nVar2 = new Y3.n(i8);
                    a8.g(nVar2);
                    final w7.b[] bVarArr = {C1139z.b(zVar.a()), nVar2, C1139z.b(F5.n.r(i8, Collections.emptyList(), true))};
                    return new w7.b() { // from class: X3.u
                        @Override // w7.b
                        public final void g(w7.c cVar) {
                            cVar.d(new C1137x(cVar, bVarArr));
                        }
                    };
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void q(Y3.z zVar, J3.e eVar) {
        C1231k c1231k = (C1231k) eVar.f9362Z;
        while (true) {
            if (!(c1231k != eVar)) {
                return;
            }
            if (c1231k == eVar) {
                throw new NoSuchElementException();
            }
            C1231k c1231k2 = (C1231k) c1231k.f9362Z;
            e.a aVar = (e.a) c1231k;
            String str = aVar.f4645y0;
            if (!C1197f.e("Content-Length", str) && !C1197f.e("Transfer-Encoding", str)) {
                Object obj = aVar.f4644x1;
                if (obj instanceof J3.a) {
                    J3.a aVar2 = (J3.a) obj;
                    aVar2.getClass();
                    int i8 = 0;
                    while (true) {
                        if (i8 < aVar2.f4627Y) {
                            if (i8 >= aVar2.f4627Y) {
                                throw new NoSuchElementException();
                            }
                            int i9 = i8 + 1;
                            Object obj2 = aVar2.get(i8);
                            if (obj2 != null) {
                                zVar.e(str, J3.h.e0(obj2));
                            }
                            i8 = i9;
                        }
                    }
                } else if (obj != null) {
                    zVar.e(str, J3.h.e0(obj));
                }
            }
            c1231k = c1231k2;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        int i8 = Build.VERSION.SDK_INT;
        if (30 > i8) {
            return 21 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE"), com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE"), com.llamalab.automate.access.c.j("android.permission.INTERNET"), com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.stmt_http_response_title).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.statusCode);
        dVar.g(this.contentType);
        dVar.g(this.bodyPart);
        dVar.g(this.bodyPath);
        dVar.g(this.headers);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.statusCode);
        visitor.b(this.contentType);
        visitor.b(this.bodyPart);
        visitor.b(this.bodyPath);
        visitor.b(this.headers);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.statusCode = (InterfaceC1700x0) cVar.readObject();
        this.contentType = (InterfaceC1700x0) cVar.readObject();
        this.bodyPart = (InterfaceC1700x0) cVar.readObject();
        this.bodyPath = (InterfaceC1700x0) cVar.readObject();
        this.headers = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        String x7;
        CharSequence b8;
        CharSequence[] charSequenceArr;
        com.llamalab.safs.n[] nVarArr;
        c1708z0.q(C2541R.string.stmt_http_response_title);
        J j8 = (J) c1708z0.c(J.class);
        if (j8 != null) {
            Pair<Y3.v, X3.H<InterfaceC1170f, ?>> andSet = j8.f16810L1.getAndSet(null);
            j8.a();
            if (andSet != null) {
                try {
                    InterfaceC1700x0 interfaceC1700x0 = this.statusCode;
                    EnumC1167c enumC1167c = EnumC1167c.f7854Z;
                    int m8 = J3.h.m(c1708z0, interfaceC1700x0, MoreOsConstants.KEY_PLAYCD);
                    Object u8 = J3.h.u(c1708z0, this.bodyPart, null);
                    if (u8 instanceof J3.e) {
                        x7 = J3.h.x(c1708z0, this.contentType, "application/json");
                        AbstractMap.SimpleImmutableEntry a8 = Y3.F.a(x7, C2213b.f21561c);
                        b8 = Y3.F.b(a8, "charset", "UTF-8");
                        charSequenceArr = "application/json".contentEquals((CharSequence) a8.getKey()) ? new CharSequence[]{JsonEncode.b(u8)} : new CharSequence[]{J3.h.e0(u8)};
                    } else if (u8 instanceof J3.a) {
                        x7 = J3.h.x(c1708z0, this.contentType, "text/plain");
                        b8 = Y3.F.b(Y3.F.a(x7, C2213b.f21561c), "charset", "UTF-8");
                        charSequenceArr = J3.h.M((J3.a) u8);
                    } else if (u8 != null) {
                        x7 = J3.h.x(c1708z0, this.contentType, "text/plain");
                        b8 = Y3.F.b(Y3.F.a(x7, C2213b.f21561c), "charset", "UTF-8");
                        charSequenceArr = new CharSequence[]{J3.h.e0(u8)};
                    } else {
                        x7 = J3.h.x(c1708z0, this.contentType, null);
                        b8 = x7 != null ? Y3.F.b(Y3.F.a(x7, C2213b.f21561c), "charset", null) : null;
                        charSequenceArr = C2434l.f23398i;
                    }
                    com.llamalab.safs.n[] q8 = J3.h.q(c1708z0, this.bodyPath, C2434l.f23404o);
                    J3.e h8 = J3.h.h(c1708z0, this.headers);
                    if (((Y3.v) andSet.first).j().l(m8)) {
                        nVarArr = q8;
                    } else {
                        charSequenceArr = null;
                        x7 = null;
                        nVarArr = null;
                    }
                    Y3.l lVar = (Y3.l) andSet.first;
                    Y3.z zVar = new Y3.z(lVar.j(), lVar.c());
                    zVar.g(D1.t(m8));
                    if (h8 != null) {
                        if (b8 == null && x7 == null) {
                            b8 = Y3.F.b(Y3.F.a(J3.h.f0("text/plain", h8.j0("Content-Type")), C2213b.f21561c), "charset", null);
                        }
                        q(zVar, h8);
                    }
                    if (x7 != null) {
                        zVar.f("Content-Type", x7);
                    }
                    a aVar = new a(andSet, zVar, b8 != null ? Charset.forName(b8.toString()) : C2213b.f21561c, charSequenceArr, nVarArr);
                    c1708z0.w(aVar);
                    aVar.w2();
                    return false;
                } catch (Throwable th) {
                    Q3.e y7 = c1708z0.j2().y();
                    Y3.J j9 = ((Y3.v) andSet.first).j();
                    int c8 = ((Y3.v) andSet.first).c();
                    EnumC1167c enumC1167c2 = EnumC1167c.f7850N1;
                    X3.H h9 = (X3.H) andSet.second;
                    y7.getClass();
                    y7.g(Q3.e.i(j9, c8, enumC1167c2), h9);
                    throw th;
                }
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
