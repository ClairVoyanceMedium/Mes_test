package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import x3.C2429g;

@F3.f("network_type.html")
@F3.a(C2541R.integer.ic_device_access_network_type)
@F3.i(C2541R.string.stmt_network_type_title)
@F3.h(C2541R.string.stmt_network_type_summary)
@Deprecated
@F3.e(C2541R.layout.stmt_network_type_edit)
/* loaded from: classes.dex */
public final class NetworkType extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 networkTypes;
    public J3.l varNetworkType;
    public J3.l varNetworkTypeName;

    public static class a extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public final boolean f16965L1;

        /* renamed from: x1, reason: collision with root package name */
        public final boolean f16966x1;

        /* renamed from: y1, reason: collision with root package name */
        public final int f16967y1;

        public a(int i8, boolean z7, boolean z8) {
            this.f16966x1 = z7 || i8 == 0;
            this.f16967y1 = i8;
            this.f16965L1 = z8;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            int type;
            try {
                if (isInitialStickyBroadcast()) {
                    return;
                }
                if (!intent.getBooleanExtra("noConnectivity", false)) {
                    if (17 <= Build.VERSION.SDK_INT) {
                        type = intent.getIntExtra("networkType", 30);
                    } else {
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        type = networkInfo != null ? networkInfo.getType() : 30;
                    }
                    r1 = C2429g.f(type);
                }
                boolean z7 = ((1 << r1) & this.f16967y1) != 0;
                if (this.f16966x1 || this.f16965L1 != z7) {
                    c(intent, new Object[]{Boolean.valueOf(z7), Integer.valueOf(r1)}, false);
                }
            } catch (Throwable th) {
                d(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_NETWORK_STATE")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_network_type_immediate, C2541R.string.caption_network_type_change);
        c1596k0.h(this.networkTypes, null, C2541R.xml.network_types_none);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        NetworkInfo networkInfo;
        Object[] objArr = (Object[]) obj;
        int intValue = ((Integer) objArr[1]).intValue();
        String typeName = (30 == intValue || (networkInfo = ((ConnectivityManager) c1708z0.getSystemService("connectivity")).getNetworkInfo(intValue)) == null) ? null : networkInfo.getTypeName();
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        int i8 = 1 << intValue;
        J3.l lVar = this.varNetworkType;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, Double.valueOf(i8));
        }
        J3.l lVar2 = this.varNetworkTypeName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, typeName);
        }
        o(c1708z0, booleanValue);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.networkTypes);
        dVar.g(this.varNetworkType);
        dVar.g(this.varNetworkTypeName);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.networkTypes);
        visitor.b(this.varNetworkType);
        visitor.b(this.varNetworkTypeName);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.networkTypes = (InterfaceC1700x0) cVar.readObject();
        this.varNetworkType = (J3.l) cVar.readObject();
        this.varNetworkTypeName = (J3.l) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003f, code lost:
    
        if (((1 << r5.getType()) & r0) != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0045, code lost:
    
        if ((1073741824 & r0) != 0) goto L16;
     */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        boolean z7;
        c1708z0.q(C2541R.string.stmt_network_type_title);
        int m8 = J3.h.m(c1708z0, this.networkTypes, 0) & 1073873603;
        boolean z8 = J1(1) == 0;
        ConnectivityManager connectivityManager = (ConnectivityManager) c1708z0.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            int type = activeNetworkInfo.getType();
            int f8 = C2429g.f(type);
            if (f8 != type) {
                activeNetworkInfo = connectivityManager.getNetworkInfo(f8);
            }
        }
        if (!z8) {
            a aVar = new a(m8, z8, z7);
            c1708z0.w(aVar);
            aVar.h("android.net.conn.CONNECTIVITY_CHANGE");
            return false;
        }
        int type2 = 1 << (activeNetworkInfo != null ? activeNetworkInfo.getType() : 30);
        String typeName = activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : null;
        J3.l lVar = this.varNetworkType;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, Double.valueOf(type2));
        }
        J3.l lVar2 = this.varNetworkTypeName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, typeName);
        }
        o(c1708z0, z7);
        return true;
    }
}
