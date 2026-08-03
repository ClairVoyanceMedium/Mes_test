package com.llamalab.automate.stmt;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.J1;
import com.llamalab.automate.N2;
import x3.C2425c;

@F3.f("bluetooth_set_state.html")
@F3.a(C2541R.integer.ic_device_access_bluetooth)
@F3.i(C2541R.string.stmt_bluetooth_set_state_title)
@F3.h(C2541R.string.stmt_bluetooth_set_state_summary)
@F3.e(C2541R.layout.stmt_bluetooth_set_state_edit)
/* loaded from: classes.dex */
public final class BluetoothSetState extends SetStateAction implements AsyncStatement {

    public static final class a extends J1 {

        /* renamed from: L1, reason: collision with root package name */
        public final boolean f16385L1;

        public a(boolean z7) {
            this.f16385L1 = z7;
        }

        @Override // com.llamalab.automate.J1
        public final void w2(O3.a aVar) {
            try {
                if (3 > aVar.Y()) {
                    throw new IllegalStateException("Legacy extension outdated");
                }
                t3.l lVar = new t3.l();
                boolean i8 = this.f16385L1 ? aVar.i(lVar) : aVar.n(lVar);
                lVar.c();
                q2(Boolean.valueOf(i8), false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static final class b extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f16386M1;

        public b(boolean z7) {
            this.f16386M1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                boolean i8 = this.f16386M1 ? interfaceC1585h1.i(lVar) : interfaceC1585h1.n(lVar);
                lVar.c();
                q2(Boolean.valueOf(i8), false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = C2425c.c(context).getInt("btWorkaround", 0);
        if (i8 == 1) {
            return new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
        }
        if (i8 == 3) {
            return new E3.b[]{com.llamalab.automate.access.c.f15550k};
        }
        int i9 = Build.VERSION.SDK_INT;
        return 33 <= i9 ? new E3.b[]{com.llamalab.automate.access.c.f15550k} : 31 <= i9 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_CONNECT")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.BLUETOOTH_ADMIN")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, true, C2541R.string.caption_bluetooth_enable, C2541R.string.caption_bluetooth_disable).r(C2541R.string.caption_bluetooth_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        N2 bVar;
        c1708z0.q(C2541R.string.stmt_bluetooth_set_state_title);
        boolean q8 = q(c1708z0, true);
        int i8 = C2425c.c(c1708z0).getInt("btWorkaround", 0);
        if (i8 == 1) {
            bVar = new b(q8);
        } else if (i8 == 3) {
            bVar = new a(q8);
        } else {
            if (33 > Build.VERSION.SDK_INT) {
                BluetoothAdapter h8 = AbstractStatement.h(c1708z0);
                if (q8) {
                    h8.enable();
                } else {
                    h8.disable();
                }
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
            bVar = new a(q8);
        }
        c1708z0.w(bVar);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
