package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Arrays;

@F3.f("mobile_network_preferred_set.html")
@F3.a(C2541R.integer.ic_device_access_network_g)
@F3.i(C2541R.string.stmt_mobile_network_preferred_set_title)
@F3.h(C2541R.string.stmt_mobile_network_preferred_set_summary)
@F3.e(C2541R.layout.stmt_mobile_network_preferred_set_edit)
/* loaded from: classes.dex */
public final class MobileNetworkPreferredSet extends Action implements AsyncStatement {
    public InterfaceC1700x0 networkType;
    public InterfaceC1700x0 subscriptionId;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final int f16933M1;

        /* renamed from: N1, reason: collision with root package name */
        public final long f16934N1;

        public a(int i8, long j8) {
            this.f16933M1 = i8;
            this.f16934N1 = j8;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            int slotIndex;
            int i8 = this.f16933M1;
            try {
                t3.l lVar = new t3.l();
                slotIndex = SubscriptionManager.getSlotIndex(i8);
                if (-1 == slotIndex) {
                    throw new IllegalStateException("No slot index for subscription: " + i8);
                }
                long c22 = interfaceC1585h1.c2(slotIndex, lVar, "root");
                lVar.c();
                long j8 = this.f16934N1;
                long j9 = j8 & c22;
                if (0 == j9) {
                    throw new IllegalArgumentException("Network types not supported by subscription: " + Arrays.toString(w3.n.j(j8)));
                }
                boolean y12 = interfaceC1585h1.y1(this.f16933M1, 0, j9, lVar);
                lVar.c();
                if (y12) {
                    p2(null);
                } else {
                    throw new IllegalStateException("Failed to set allowed network types: " + Arrays.toString(w3.n.j(j9)));
                }
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static final class b extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final int f16935M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16936N1;

        public b(int i8, int i9) {
            this.f16935M1 = i8;
            this.f16936N1 = i9;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            int i8 = this.f16936N1;
            try {
                t3.l lVar = new t3.l();
                boolean k12 = interfaceC1585h1.k1(this.f16935M1, i8, lVar);
                lVar.c();
                if (k12) {
                    p2(null);
                } else {
                    throw new IllegalStateException("Failed to set preferred network type: " + i8);
                }
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : new E3.b[]{com.llamalab.automate.access.c.j("com.android.phone.CHANGE_NETWORK_MODE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_mobile_network_preferred_set).e(this.networkType, 0, C2541R.xml.preferred_mobile_networks_all).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.networkType);
        if (64 <= dVar.f6413Z) {
            dVar.g(this.subscriptionId);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.networkType);
        visitor.b(this.subscriptionId);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.networkType = (InterfaceC1700x0) cVar.readObject();
        if (64 <= cVar.f6409x0) {
            this.subscriptionId = (InterfaceC1700x0) cVar.readObject();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00fa, code lost:
    
        r4 = r4.createForSubscriptionId(r2);
     */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        long j8;
        c1708z0.q(C2541R.string.stmt_mobile_network_preferred_set_title);
        int m8 = J3.h.m(c1708z0, this.networkType, 0);
        int m9 = J3.h.m(c1708z0, this.subscriptionId, w3.n.d());
        int i8 = Build.VERSION.SDK_INT;
        if (31 > i8) {
            if (21 <= i8) {
                TelephonyManager telephonyManager = (TelephonyManager) c1708z0.getSystemService("phone");
                if (telephonyManager == null) {
                    throw new NullPointerException("No TelephonyManager, maybe the SIM is disabled");
                }
                if (24 <= i8 && !w3.n.n(m9) && telephonyManager == null) {
                    throw new NullPointerException(C1.H0.o("No TelephonyManager for subscription ", m9, ", maybe the SIM is disabled"));
                }
                c1708z0.w(new b(m9, w3.o.d(telephonyManager, m8)));
                return false;
            }
            TelephonyManager telephonyManager2 = (TelephonyManager) c1708z0.getSystemService("phone");
            if (telephonyManager2 == null) {
                throw new NullPointerException("No TelephonyManager, maybe the SIM is disabled");
            }
            Intent putExtra = new Intent("com.android.internal.telephony.MODIFY_NETWORK_MODE").putExtra("networkMode", w3.o.d(telephonyManager2, m8));
            if (c1708z0.getPackageManager().queryBroadcastReceivers(putExtra, 0).isEmpty()) {
                throw new UnsupportedOperationException("CyanogenMod or MODIFY_NETWORK_MODE receiver required");
            }
            c1708z0.sendBroadcast(putExtra);
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        switch (w3.o.f23258a) {
            case 0:
            case 3:
                j8 = 50055;
                break;
            case 1:
                j8 = 32771;
                break;
            case 2:
                j8 = 17284;
                break;
            case 4:
                j8 = 10360;
                break;
            case 5:
                j8 = 72;
                break;
            case 6:
                j8 = 10288;
                break;
            case 7:
                j8 = 60415;
                break;
            case 8:
                j8 = 276600;
                break;
            case 9:
                j8 = 316295;
                break;
            case 10:
                j8 = 326655;
                break;
            case 11:
                j8 = 266240;
                break;
            case 12:
                j8 = 283524;
                break;
            case 13:
                j8 = 65536;
                break;
            case 14:
                j8 = 82820;
                break;
            case 15:
                j8 = 331776;
                break;
            case 16:
                j8 = 98307;
                break;
            case 17:
                j8 = 364547;
                break;
            case 18:
                j8 = 115591;
                break;
            case 19:
                j8 = 349060;
                break;
            case 20:
                j8 = 381831;
                break;
            case 21:
                j8 = 125951;
                break;
            case 22:
                j8 = 392191;
                break;
            case 23:
                j8 = 524288;
                break;
            case 24:
                j8 = 790528;
                break;
            case 25:
                j8 = 800888;
                break;
            case 26:
                j8 = 840583;
                break;
            case 27:
                j8 = 850943;
                break;
            case 28:
                j8 = 807812;
                break;
            case 29:
                j8 = 856064;
                break;
            case 30:
                j8 = 888835;
                break;
            case 31:
                j8 = 873348;
                break;
            case 32:
                j8 = 906119;
                break;
            case 33:
                j8 = 916479;
                break;
            default:
                j8 = 1047551;
                break;
        }
        long j9 = (m8 & 2) != 0 ? 32843L : 0L;
        if ((m8 & 4) != 0) {
            j9 |= 93108;
        }
        if ((m8 & 8) != 0) {
            j9 |= 397312;
        }
        if ((m8 & 16) != 0) {
            j9 |= 524288;
        }
        if (j9 != 0) {
            j8 = j9;
        }
        c1708z0.w(new a(m9, j8));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
