package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.MacAddress;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.N2;
import com.llamalab.automate.Visitor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

@F3.f("wifi_ap_clients_connected.html")
@F3.a(C2541R.integer.ic_wifi_access_point)
@F3.i(C2541R.string.stmt_wifi_ap_clients_connected_title)
@F3.h(C2541R.string.stmt_wifi_ap_clients_connected_summary)
@F3.e(C2541R.layout.stmt_wifi_ap_clients_connected_edit)
/* loaded from: classes.dex */
public final class WifiApClientsConnected extends IntermittentAction implements AsyncStatement {
    public J3.l varClientCount;
    public J3.l varClientMacAccesses;

    public static final class a extends c {

        /* renamed from: O1, reason: collision with root package name */
        public final boolean f17289O1;

        /* renamed from: P1, reason: collision with root package name */
        public volatile HashSet f17290P1;

        public a(boolean z7) {
            this.f17289O1 = z7;
        }

        @Override // com.llamalab.automate.stmt.WifiApClientsConnected.c
        public final void y2(int i8, ArrayList<MacAddress> arrayList) {
            try {
                HashSet hashSet = new HashSet(arrayList);
                if (this.f17289O1) {
                    o2(500L, new Object[]{Double.valueOf(hashSet.size()), J3.h.g0(hashSet)});
                } else if (this.f17290P1 != null && !this.f17290P1.equals(hashSet)) {
                    o2(500L, new Object[]{Double.valueOf(hashSet.size()), J3.h.g0(hashSet)});
                }
                this.f17290P1 = hashSet;
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static final class b extends c {

        /* renamed from: O1, reason: collision with root package name */
        public final boolean f17291O1;

        /* renamed from: P1, reason: collision with root package name */
        public volatile int f17292P1 = -1;

        public b(boolean z7) {
            this.f17291O1 = z7;
        }

        @Override // com.llamalab.automate.stmt.WifiApClientsConnected.c
        public final void y2(int i8, ArrayList<MacAddress> arrayList) {
            try {
                if (this.f17291O1) {
                    o2(500L, new Object[]{Double.valueOf(i8), null});
                } else if (this.f17292P1 != -1 && this.f17292P1 != i8) {
                    o2(500L, new Object[]{Double.valueOf(i8), null});
                }
                this.f17292P1 = i8;
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static abstract class c extends AbstractC1602l2 implements Handler.Callback {

        /* renamed from: M1, reason: collision with root package name */
        public final AtomicBoolean f17293M1 = new AtomicBoolean();

        /* renamed from: N1, reason: collision with root package name */
        public Messenger f17294N1;

        @Override // com.llamalab.automate.AbstractC1602l2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            this.f17294N1 = new Messenger(new Handler(automateService.f14583N1.a(), this));
            super.C(automateService, j8, j9, j10);
        }

        @Override // com.llamalab.automate.AbstractC1602l2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            InterfaceC1585h1 interfaceC1585h1;
            if (this.f17293M1.compareAndSet(true, false) && (interfaceC1585h1 = this.f16043y1) != null) {
                try {
                    t3.l lVar = new t3.l();
                    interfaceC1585h1.i1(this.f17294N1, lVar);
                    lVar.c();
                } catch (Throwable unused) {
                }
            }
            super.F(automateService);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            Bundle data = message.getData();
            y2(message.arg1, data != null ? data.getParcelableArrayList("clients") : null);
            return true;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.u1(this.f17294N1, lVar);
                lVar.c();
                this.f17293M1.set(true);
            } catch (Throwable th) {
                r2(th);
            }
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void x2() {
            this.f17293M1.set(false);
        }

        public abstract void y2(int i8, ArrayList<MacAddress> arrayList);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 28 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_wifi_ap_clients_connected_immediate, C2541R.string.caption_wifi_ap_clients_connected_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varClientCount);
        dVar.g(this.varClientMacAccesses);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.varClientCount);
        visitor.b(this.varClientMacAccesses);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varClientCount = (J3.l) cVar.readObject();
        this.varClientMacAccesses = (J3.l) cVar.readObject();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        N2 bVar;
        b bVar2;
        c1708z0.q(C2541R.string.stmt_wifi_ap_clients_connected_title);
        IncapableAndroidVersionException.a(28);
        boolean z7 = J1(1) == 0;
        if (30 <= Build.VERSION.SDK_INT) {
            a aVar = (a) c1708z0.c(a.class);
            if (aVar == 0) {
                bVar = new a(z7);
                c1708z0.w(bVar);
            } else {
                if (z7) {
                    s(c1708z0, Double.valueOf(r1.size()), J3.h.g0(aVar.f17290P1));
                    return true;
                }
                F5.n.h(aVar);
                bVar2 = aVar;
                bVar2.f15404y0 = this.f16218X;
            }
        } else {
            b bVar3 = (b) c1708z0.c(b.class);
            if (bVar3 == null) {
                bVar = new b(z7);
                c1708z0.w(bVar);
            } else {
                if (z7) {
                    s(c1708z0, Double.valueOf(bVar3.f17292P1), null);
                    return true;
                }
                F5.n.h(bVar3);
                bVar2 = bVar3;
                bVar2.f15404y0 = this.f16218X;
            }
        }
        return false;
    }

    public final void s(C1708z0 c1708z0, Double d8, J3.a aVar) {
        J3.l lVar = this.varClientCount;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        J3.l lVar2 = this.varClientMacAccesses;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, aVar);
        }
        c1708z0.f17642x0 = this.onComplete;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        s(c1708z0, (Double) objArr[0], (J3.a) objArr[1]);
        return true;
    }
}
