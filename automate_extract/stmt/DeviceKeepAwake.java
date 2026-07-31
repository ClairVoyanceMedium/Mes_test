package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1590i2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("device_keep_awake.html")
@F3.a(C2541R.integer.ic_device_no_sleep)
@F3.i(C2541R.string.stmt_device_keep_awake_title)
@F3.h(C2541R.string.stmt_device_keep_awake_summary)
@F3.e(C2541R.layout.stmt_device_keep_awake_edit)
/* loaded from: classes.dex */
public class DeviceKeepAwake extends Action {

    /* renamed from: L1, reason: collision with root package name */
    public boolean f16562L1;
    public InterfaceC1700x0 wakeState;
    public InterfaceC1700x0 wakeup;
    public InterfaceC1700x0 wifiState;

    public static final class a extends com.llamalab.automate.W implements InterfaceC1590i2 {

        /* renamed from: L1, reason: collision with root package name */
        public int f16563L1;

        /* renamed from: M1, reason: collision with root package name */
        public int f16564M1;

        /* renamed from: y1, reason: collision with root package name */
        public WifiManager.WifiLock f16565y1;

        public a() {
        }

        public a(int i8, int i9) {
            this.f16563L1 = i8;
            this.f16564M1 = i9;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            v2(this.f16563L1);
            w2(this.f16564M1);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            WifiManager.WifiLock wifiLock = this.f16565y1;
            if (wifiLock != null) {
                try {
                    wifiLock.release();
                } catch (Throwable unused) {
                }
                this.f16565y1 = null;
            }
            u2();
            u2();
        }

        @Override // com.llamalab.automate.W, R3.e
        public final void Y0(R3.d dVar) {
            dVar.d(this.f15404y0);
            dVar.c(this.f16563L1);
            dVar.c(this.f16564M1);
        }

        @Override // com.llamalab.automate.W
        public final /* bridge */ /* synthetic */ com.llamalab.automate.W n2(int i8) {
            v2(1);
            return this;
        }

        @Override // com.llamalab.automate.W, R3.e
        public final void o0(R3.c cVar) {
            this.f15404y0 = cVar.b();
            this.f16563L1 = cVar.a();
            this.f16564M1 = cVar.a();
        }

        public final synchronized void v2(int i8) {
            if (i8 != 0) {
                super.n2(i8);
            } else {
                u2();
            }
            this.f16563L1 = i8;
        }

        public final void w2(int i8) {
            if (i8 != 0) {
                WifiManager.WifiLock createWifiLock = ((WifiManager) this.f15400Y.getApplicationContext().getSystemService("wifi")).createWifiLock(this.f16564M1, F5.n.c(this).toString());
                createWifiLock.setReferenceCounted(false);
                createWifiLock.acquire();
                WifiManager.WifiLock wifiLock = this.f16565y1;
                if (wifiLock != null) {
                    try {
                        wifiLock.release();
                    } catch (Throwable unused) {
                    }
                    this.f16565y1 = null;
                }
                this.f16565y1 = createWifiLock;
            } else {
                WifiManager.WifiLock wifiLock2 = this.f16565y1;
                if (wifiLock2 != null) {
                    try {
                        wifiLock2.release();
                    } catch (Throwable unused2) {
                    }
                    this.f16565y1 = null;
                }
            }
            this.f16564M1 = i8;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).r(C2541R.string.caption_device_keep_awake).z(this.wakeState, false, C2541R.string.caption_cpu, 0).z(this.wifiState, false, C2541R.string.caption_wifi, 0).z(this.wakeup, true, C2541R.string.caption_illuminate, 0).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.wakeState);
        if (24 <= dVar.f6413Z) {
            dVar.g(this.wifiState);
            dVar.g(this.wakeup);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.wakeState);
        visitor.b(this.wifiState);
        visitor.b(this.wakeup);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.wakeState = (InterfaceC1700x0) cVar.readObject();
        if (24 > cVar.f6409x0) {
            this.f16562L1 = true;
        } else {
            this.wifiState = (InterfaceC1700x0) cVar.readObject();
            this.wakeup = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_device_keep_awake_title);
        int m8 = J3.h.m(c1708z0, this.wakeState, 0);
        int m9 = J3.h.m(c1708z0, this.wifiState, 0);
        boolean f8 = J3.h.f(c1708z0, this.wakeup, true);
        if (this.f16562L1 && f8) {
            if (m8 == 0) {
                m8 = 805306378;
            } else if (m8 != 1) {
                if (m8 != 6 && m8 != 10 && m8 != 26) {
                    throw new IllegalArgumentException("processor");
                }
                m8 |= 805306368;
            }
            PowerManager.WakeLock newWakeLock = ((PowerManager) c1708z0.getSystemService("power")).newWakeLock(m8, "DeviceKeepAwake");
            newWakeLock.acquire();
            newWakeLock.release();
        } else {
            a aVar = (a) c1708z0.c(a.class);
            if (m8 != 0 || m9 != 0) {
                if (m8 != 0 && m8 != 1) {
                    if (m8 != 6 && m8 != 10 && m8 != 26) {
                        throw new IllegalArgumentException("processor");
                    }
                    if (f8) {
                        m8 |= 268435456;
                    }
                }
                if (aVar != null) {
                    aVar.v2(m8);
                    aVar.w2(m9);
                } else {
                    c1708z0.w(new a(m8, m9));
                }
            } else if (aVar != null) {
                aVar.a();
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
