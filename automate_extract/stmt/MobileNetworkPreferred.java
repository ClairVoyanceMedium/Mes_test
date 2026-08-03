package com.llamalab.automate.stmt;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1616p0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("mobile_network_preferred.html")
@F3.a(C2541R.integer.ic_device_access_network_g)
@F3.i(C2541R.string.stmt_mobile_network_preferred_title)
@F3.h(C2541R.string.stmt_mobile_network_preferred_summary)
@F3.e(C2541R.layout.stmt_mobile_network_preferred_edit)
/* loaded from: classes.dex */
public final class MobileNetworkPreferred extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 networkType;
    public InterfaceC1700x0 subscriptionId;
    public J3.l varCurrentNetworkType;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final int f16928M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16929N1;

        public a(int i8, int i9) {
            this.f16928M1 = i8;
            this.f16929N1 = i9;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            boolean z7;
            try {
                t3.l lVar = new t3.l();
                long f22 = interfaceC1585h1.f2(this.f16928M1, 0, lVar);
                lVar.c();
                int i8 = w3.o.f23258a;
                int i9 = (32843 & f22) != 0 ? 2 : 0;
                if ((93108 & f22) != 0) {
                    i9 |= 4;
                }
                if ((397312 & f22) != 0) {
                    i9 |= 8;
                }
                if ((f22 & 524288) != 0) {
                    i9 |= 16;
                }
                if (i9 == 0) {
                    i9 = 0;
                }
                int i10 = this.f16929N1;
                if (i10 != 0 && (i10 & i9) == 0) {
                    z7 = false;
                    q2(new Object[]{Boolean.valueOf(z7), Double.valueOf(i9)}, false);
                }
                z7 = true;
                q2(new Object[]{Boolean.valueOf(z7), Double.valueOf(i9)}, false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static final class b extends C1616p0 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f16930L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16931M1;

        /* renamed from: N1, reason: collision with root package name */
        public final boolean f16932N1;

        public b(int i8, String str, boolean z7) {
            this.f16930L1 = str;
            this.f16931M1 = i8;
            this.f16932N1 = z7;
        }

        @Override // com.llamalab.automate.C1616p0
        public final void x2(Uri uri) {
            try {
                int B7 = MobileNetworkPreferred.B(this.f15400Y, this.f16930L1);
                int i8 = this.f16931M1;
                if (i8 == 0) {
                    q2(new Object[]{Boolean.TRUE, Double.valueOf(B7)}, false);
                } else {
                    boolean z7 = this.f16932N1;
                    if (z7 != ((i8 & B7) != 0)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(!z7);
                        objArr[1] = Double.valueOf(B7);
                        q2(objArr, false);
                    }
                }
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static int B(Context context, String str) {
        int i8 = Build.VERSION.SDK_INT;
        ContentResolver contentResolver = context.getContentResolver();
        switch (17 <= i8 ? Settings.Global.getInt(contentResolver, str, w3.o.f23258a) : Settings.System.getInt(contentResolver, str, w3.o.f23258a)) {
            case 0:
            case 3:
            case 4:
            case 7:
            case 16:
            case 18:
            case 21:
                return 6;
            case 1:
            case 5:
                return 2;
            case 2:
            case 6:
            case 13:
            case 14:
                return 4;
            case 8:
            case 9:
            case 10:
            case 17:
            case 20:
            case 22:
                return 14;
            case 11:
                return 8;
            case 12:
            case 15:
            case 19:
                return 12;
            case 23:
                return 16;
            case 24:
                return 24;
            case 25:
            case 26:
            case 27:
            case 28:
            case 30:
            case 32:
            case 33:
                return 30;
            case 29:
            case 31:
                return 28;
            default:
                return 0;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 31 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_mobile_network_preferred_immediate, C2541R.string.caption_mobile_network_preferred_change);
        return c1596k0.e(this.networkType, null, C2541R.xml.preferred_mobile_networks_all).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.networkType);
        if (75 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
        dVar.g(this.varCurrentNetworkType);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.networkType);
        visitor.b(this.subscriptionId);
        visitor.b(this.varCurrentNetworkType);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.networkType = (InterfaceC1700x0) cVar.readObject();
        if (75 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
        this.varCurrentNetworkType = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_mobile_network_preferred_title);
        int m8 = J3.h.m(c1708z0, this.networkType, 0) & 30;
        int m9 = J3.h.m(c1708z0, this.subscriptionId, w3.n.d());
        int i8 = Build.VERSION.SDK_INT;
        if (31 <= i8) {
            if (J1(1) != 0) {
                throw new IncapableAndroidVersionException(30, "Proceed 'When changed' don't work on Android 12+");
            }
            c1708z0.w(new a(m9, m8));
            return false;
        }
        String str = "preferred_network_mode";
        if (22 <= i8 && !w3.n.n(m9)) {
            str = B4.g.g("preferred_network_mode", m9);
        }
        int B7 = B(c1708z0, str);
        if (J1(1) != 0) {
            b bVar = new b(m8, str, (B7 & m8) != 0);
            c1708z0.w(bVar);
            bVar.w2(false, 17 <= i8 ? Settings.Global.getUriFor(str) : Settings.System.getUriFor(str));
            return false;
        }
        boolean z7 = m8 == 0 || (m8 & B7) != 0;
        Double valueOf = Double.valueOf(B7);
        J3.l lVar = this.varCurrentNetworkType;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, valueOf);
        }
        o(c1708z0, z7);
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        Double d8 = (Double) objArr[1];
        J3.l lVar = this.varCurrentNetworkType;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, booleanValue);
        return true;
    }
}
