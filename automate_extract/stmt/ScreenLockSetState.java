package com.llamalab.automate.stmt;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Binder;
import android.util.Log;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1590i2;
import com.llamalab.automate.N2;
import java.util.concurrent.atomic.AtomicBoolean;

@F3.f("screen_lock_set_state.html")
@F3.a(C2541R.integer.ic_screen_lock_off)
@F3.i(C2541R.string.stmt_screen_lock_set_state_title)
@F3.h(C2541R.string.stmt_screen_lock_set_state_summary)
@F3.e(C2541R.layout.stmt_screen_lock_set_state_edit)
/* loaded from: classes.dex */
public final class ScreenLockSetState extends SetStateAction {
    public boolean secure;

    public static final class a extends com.llamalab.automate.W implements b, InterfaceC1590i2 {

        /* renamed from: y1, reason: collision with root package name */
        public KeyguardManager.KeyguardLock f17089y1;

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            KeyguardManager.KeyguardLock newKeyguardLock = ((KeyguardManager) automateService.getSystemService("keyguard")).newKeyguardLock("InsecureScreenLockTask@" + j9);
            this.f17089y1 = newKeyguardLock;
            newKeyguardLock.disableKeyguard();
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            KeyguardManager.KeyguardLock keyguardLock = this.f17089y1;
            if (keyguardLock != null) {
                try {
                    keyguardLock.reenableKeyguard();
                } catch (Throwable unused) {
                }
                this.f17089y1 = null;
            }
            u2();
        }

        @Override // com.llamalab.automate.stmt.ScreenLockSetState.b
        public final void H0() {
            this.f17089y1.disableKeyguard();
        }
    }

    public interface b extends N2 {
        void H0();
    }

    public static final class c extends AbstractC1602l2 implements b, InterfaceC1590i2 {

        /* renamed from: M1, reason: collision with root package name */
        public final AtomicBoolean f17090M1 = new AtomicBoolean();

        /* renamed from: N1, reason: collision with root package name */
        public Binder f17091N1 = new Binder();

        /* renamed from: O1, reason: collision with root package name */
        public volatile boolean f17092O1;

        @Override // com.llamalab.automate.AbstractC1602l2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            if (this.f17090M1.compareAndSet(false, true)) {
                this.f17092O1 = true;
                InterfaceC1585h1 interfaceC1585h1 = this.f16043y1;
                if (interfaceC1585h1 != null) {
                    y2(interfaceC1585h1);
                } else {
                    try {
                        v2(0L);
                    } catch (Throwable unused) {
                    }
                }
            }
            super.F(automateService);
        }

        @Override // com.llamalab.automate.stmt.ScreenLockSetState.b
        public final void H0() {
            this.f17092O1 = false;
            InterfaceC1585h1 interfaceC1585h1 = this.f16043y1;
            if (interfaceC1585h1 == null) {
                v2(0L);
                return;
            }
            t3.l lVar = new t3.l();
            interfaceC1585h1.L1(this.f17091N1, "SecureScreenLockTask@" + this.f15402x0, t3.o.b(), lVar);
            lVar.c();
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            if (this.f17090M1.get()) {
                y2(interfaceC1585h1);
                return;
            }
            try {
                t3.l lVar = new t3.l();
                if (this.f17092O1) {
                    interfaceC1585h1.z(this.f17091N1, t3.o.b(), lVar);
                } else {
                    interfaceC1585h1.L1(this.f17091N1, "SecureScreenLockTask@" + this.f15402x0, t3.o.b(), lVar);
                }
                lVar.c();
            } catch (Throwable th) {
                r2(th);
            }
        }

        public final void y2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.z(this.f17091N1, t3.o.b(), lVar);
                lVar.c();
            } catch (Throwable th) {
                Log.e("SecureScreenLockTask", "Failed to reenable keyguard", th);
            }
            this.f17091N1 = null;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return this.secure ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.DISABLE_KEYGUARD"), com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.DISABLE_KEYGUARD")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_screen_lock_reenable, C2541R.string.caption_screen_lock_disable).r(C2541R.string.caption_screen_lock_set_state).b(this.state).x(C2541R.string.caption_secure, this.secure, 0).f16030c;
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (49 <= dVar.f6413Z) {
            dVar.write(this.secure ? 1 : 0);
        }
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (49 <= cVar.f6409x0) {
            this.secure = cVar.readBoolean();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        N2 aVar;
        c1708z0.q(C2541R.string.stmt_screen_lock_set_state_title);
        boolean q8 = q(c1708z0, false);
        b bVar = (b) c1708z0.c(b.class);
        if (q8) {
            if (bVar != null) {
                bVar.a();
            }
        } else if (this.secure) {
            if (!(bVar instanceof c)) {
                if (bVar != null) {
                    bVar.a();
                }
                aVar = new c();
                c1708z0.w(aVar);
            }
            bVar.H0();
        } else {
            if (!(bVar instanceof a)) {
                if (bVar != null) {
                    bVar.a();
                }
                aVar = new a();
                c1708z0.w(aVar);
            }
            bVar.H0();
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
