package com.llamalab.automate.stmt;

import A4.f;
import A4.g;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AutomateApplication;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.fs.AutomateFileTypeDetector;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import x3.C2425c;
import x3.C2443u;
import z4.AbstractC2530k;
import z4.C2519C;
import z4.C2522c;
import z4.C2523d;
import z4.C2524e;
import z4.C2533n;
import z4.C2534o;
import z4.C2538s;
import z4.EnumC2528i;
import z4.InterfaceC2521b;
import z4.InterfaceC2525f;
import z4.InterfaceC2529j;
import z4.InterfaceC2537r;
import z4.t;

/* renamed from: com.llamalab.automate.stmt.k0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1653k0 extends AbstractRunnableC1694v2 {

    /* renamed from: L1, reason: collision with root package name */
    public final String[] f17451L1;

    /* renamed from: M1, reason: collision with root package name */
    public final String f17452M1;

    /* renamed from: N1, reason: collision with root package name */
    public final String f17453N1;

    /* renamed from: O1, reason: collision with root package name */
    public final com.llamalab.safs.n f17454O1;

    /* renamed from: P1, reason: collision with root package name */
    public final int f17455P1;

    /* renamed from: Q1, reason: collision with root package name */
    public TelephonyManager f17456Q1;

    /* renamed from: R1, reason: collision with root package name */
    public SharedPreferences f17457R1;

    /* renamed from: com.llamalab.automate.stmt.k0$a */
    public static final class a implements InterfaceC2525f {

        /* renamed from: X, reason: collision with root package name */
        public final com.llamalab.safs.n f17458X;

        public a(com.llamalab.safs.n nVar) {
            this.f17458X = nVar;
        }

        @Override // z4.InterfaceC2525f
        public final void e(C2538s c2538s, AbstractC2530k abstractC2530k) {
            InputStream k8 = com.llamalab.safs.i.k(this.f17458X);
            try {
                com.llamalab.safs.internal.m.i(k8, c2538s, new byte[8192]);
                k8.close();
            } catch (Throwable th) {
                if (k8 != null) {
                    try {
                        k8.close();
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

        public final String toString() {
            return "<file " + this.f17458X + ">";
        }
    }

    public AbstractC1653k0(String[] strArr, String str, String str2, com.llamalab.safs.n nVar, int i8) {
        this.f17451L1 = strArr;
        this.f17452M1 = str;
        this.f17453N1 = str2;
        this.f17454O1 = nVar;
        this.f17455P1 = i8;
    }

    public static void y2(InputStream inputStream) {
        C2533n c2533n = new C2533n(inputStream);
        try {
            A4.k kVar = new A4.k(c2533n);
            A4.m mVar = (A4.m) kVar.c(g.c.f84l);
            if (!A4.m.m_send_conf.equals(mVar)) {
                throw new IOException("Illegal response message-type: " + mVar);
            }
            A4.t tVar = (A4.t) kVar.c(g.c.f90r);
            int ordinal = tVar.ordinal();
            if (ordinal == 0) {
                c2533n.close();
                return;
            }
            if (ordinal == 7 || ordinal == 18) {
                throw new IllegalArgumentException("Unacceptable attachment type");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(tVar);
            sb.append(": ");
            InterfaceC2537r[] interfaceC2537rArr = (InterfaceC2537r[]) kVar.f23792a.get(g.c.f91s);
            sb.append(interfaceC2537rArr != null ? interfaceC2537rArr[0] : null);
            throw new IOException(sb.toString());
        } catch (Throwable th) {
            try {
                c2533n.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
    
        r1 = w3.n.l(r3.f17455P1).getCarrierConfigValues();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long A2() {
        Bundle carrierConfigValues;
        int i8 = this.f17457R1.getInt("mmsSizeLimit", 307200);
        if (Integer.MAX_VALUE == i8) {
            return Long.MAX_VALUE;
        }
        return (21 > Build.VERSION.SDK_INT || carrierConfigValues == null) ? i8 : Math.min(carrierConfigValues.getInt("maxMessageSize", i8), i8);
    }

    public final void B2(int i8) {
        if (!C1710z2.b(this.f17457R1, "mms").a(i8)) {
            throw new SecurityException("User MMS send rate exceeded, see Settings.");
        }
        C2443u c2443u = AutomateApplication.f14521x0;
        synchronized (c2443u) {
            if (!c2443u.a(i8)) {
                throw new SecurityException("Maximum MMS send rate exceeded.");
            }
        }
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        this.f17456Q1 = (TelephonyManager) automateService.getSystemService("phone");
        this.f17457R1 = C2425c.c(automateService);
    }

    public final A4.k z2() {
        String str;
        C2523d c2523d = new C2523d();
        C2524e c2524e = new C2524e();
        C2522c<InterfaceC2529j> c2522c = C2522c.InterfaceC0272c.f23746c;
        InterfaceC2529j.e eVar = InterfaceC2529j.e.f23786Y;
        z4.t<EnumC2528i> tVar = t.c.f23814b;
        EnumC2528i enumC2528i = EnumC2528i.UTF_8;
        InterfaceC2529j.d dVar = new InterfaceC2529j.d(eVar);
        dVar.f23734Y.put(tVar, enumC2528i);
        z4.t<z4.z> tVar2 = t.c.f23817e;
        dVar.h(tVar2, new z4.z("message"));
        c2524e.a(c2522c, dVar);
        c2524e.f23793b = new z4.y(this.f17453N1);
        ArrayList arrayList = c2523d.f23773X;
        arrayList.add(c2524e);
        com.llamalab.safs.n nVar = this.f17454O1;
        if (nVar != null) {
            String m8 = com.llamalab.safs.i.m(nVar);
            if (m8 == null) {
                m8 = AutomateFileTypeDetector.OCTET_STREAM;
            }
            InterfaceC2529j.c cVar = new InterfaceC2529j.c(m8);
            z4.z zVar = new z4.z("attachment");
            InterfaceC2529j.d dVar2 = new InterfaceC2529j.d(cVar);
            dVar2.f23734Y.put(tVar2, zVar);
            long p8 = com.llamalab.safs.i.p(nVar);
            C2524e c2524e2 = new C2524e();
            c2524e2.a(c2522c, dVar2);
            c2524e2.a(C2522c.InterfaceC0272c.f23764u, InterfaceC2521b.c.f23736Y);
            c2524e2.a(C2522c.InterfaceC0272c.f23744a, new C2534o(p8));
            c2524e2.f23793b = new a(nVar);
            arrayList.add(c2524e2);
        }
        try {
            str = w3.n.g(this.f17456Q1, this.f17455P1);
        } catch (SecurityException unused) {
            str = null;
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        EnumC2528i enumC2528i2 = EnumC2528i.US_ASCII;
        InterfaceC2537r cVar2 = isEmpty ? A4.f.f59a : new f.c(new A4.e(enumC2528i2, str));
        A4.k kVar = new A4.k();
        kVar.e(g.c.f84l, A4.m.m_send_req);
        kVar.e(g.c.f96x, new z4.z("U" + Long.toHexString(System.currentTimeMillis())));
        kVar.e(g.c.f85m, C2519C.f23728Z);
        kVar.e(g.c.f81i, cVar2);
        kVar.e(g.c.f76d, InterfaceC2529j.e.f23787Z);
        kVar.f23793b = c2523d;
        String str2 = this.f17452M1;
        if (!TextUtils.isEmpty(str2)) {
            kVar.e(g.c.f94v, new A4.e(enumC2528i, str2));
        }
        for (String str3 : this.f17451L1) {
            kVar.e(g.c.f95w, new A4.e(enumC2528i2, str3));
        }
        return kVar;
    }
}
