package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IInterface;
import android.os.Parcel;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.J1;
import com.llamalab.automate.N2;
import java.lang.reflect.Field;
import x3.C2425c;
import x3.C2446x;

@F3.f("wifi_set_state.html")
@F3.a(C2541R.integer.ic_device_access_network_wifi)
@F3.i(C2541R.string.stmt_wifi_set_state_title)
@F3.h(C2541R.string.stmt_wifi_set_state_summary)
@F3.e(C2541R.layout.stmt_wifi_set_state_edit)
/* loaded from: classes.dex */
public final class WifiSetState extends SetStateAction implements AsyncStatement {

    public static final class a extends J1 {

        /* renamed from: L1, reason: collision with root package name */
        public final boolean f17318L1;

        public a(boolean z7) {
            this.f17318L1 = z7;
        }

        @Override // com.llamalab.automate.J1
        public final void w2(O3.a aVar) {
            try {
                t3.l lVar = new t3.l();
                boolean j8 = aVar.j(this.f17318L1, lVar);
                lVar.c();
                q2(Boolean.valueOf(j8), false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static final class b extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f17319M1;

        public b(boolean z7) {
            this.f17319M1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                boolean j8 = interfaceC1585h1.j(this.f17319M1, lVar);
                lVar.c();
                q2(Boolean.valueOf(j8), false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return (29 > i8 || 1 != C2425c.c(context).getInt("wifiWorkaround", 0)) ? 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CHANGE_WIFI_STATE"), com.llamalab.automate.access.c.f15550k} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CHANGE_WIFI_STATE")} : new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, true, C2541R.string.caption_wifi_enable, C2541R.string.caption_wifi_disable).r(C2541R.string.caption_wifi_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        N2 aVar;
        c1708z0.q(C2541R.string.stmt_wifi_set_state_title);
        boolean q8 = q(c1708z0, true);
        int i8 = Build.VERSION.SDK_INT;
        if (29 > i8 || 1 != C2425c.c(c1708z0).getInt("wifiWorkaround", 0)) {
            if (29 <= i8) {
                if (com.llamalab.automate.access.c.f15550k.A(c1708z0)) {
                    aVar = new a(q8);
                } else if (c1708z0.getPackageManager().checkSignatures(c1708z0.getPackageName(), "com.llamalab.automate.ext.network") == 0) {
                    WifiManager l8 = AbstractStatement.l(c1708z0);
                    Field declaredField = l8.getClass().getDeclaredField("mService");
                    declaredField.setAccessible(true);
                    IInterface iInterface = (IInterface) declaredField.get(l8);
                    if (36 <= i8) {
                        throw new UnsupportedOperationException("setWifiEnabled AIDL");
                    }
                    int i9 = 35 <= i8 ? 43 : 34 <= i8 ? 42 : 33 <= i8 ? 40 : 31 <= i8 ? 31 : 30 <= i8 ? 30 : C2446x.c(Build.MANUFACTURER, "samsung") ? 27 : 26;
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("android.net.wifi.IWifiManager");
                        obtain.writeString("com.llamalab.automate.ext.network");
                        obtain.writeInt(q8 ? 1 : 0);
                        iInterface.asBinder().transact(i9, obtain, obtain2, 0);
                        obtain2.readException();
                        obtain2.readInt();
                        c1708z0.f17642x0 = this.onComplete;
                        return true;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }
            AbstractStatement.l(c1708z0).setWifiEnabled(q8);
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        aVar = new b(q8);
        c1708z0.w(aVar);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
