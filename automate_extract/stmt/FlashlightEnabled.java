package com.llamalab.automate.stmt;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1695w;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.W;

@F3.f("flashlight_enabled.html")
@F3.a(C2541R.integer.ic_device_access_flash_on)
@F3.i(C2541R.string.stmt_flashlight_enabled_title)
@F3.h(C2541R.string.stmt_flashlight_enabled_summary)
@F3.e(C2541R.layout.stmt_flashlight_enabled_edit)
/* loaded from: classes.dex */
public final class FlashlightEnabled extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 cameraId;

    public static final class a extends W.a<Boolean> {

        /* renamed from: N1, reason: collision with root package name */
        public final String f16632N1;

        /* renamed from: O1, reason: collision with root package name */
        public CameraManager f16633O1;

        /* renamed from: P1, reason: collision with root package name */
        public boolean f16634P1;

        /* renamed from: Q1, reason: collision with root package name */
        public boolean f16635Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final C0173a f16636R1;

        /* renamed from: com.llamalab.automate.stmt.FlashlightEnabled$a$a, reason: collision with other inner class name */
        public class C0173a extends CameraManager.TorchCallback {
            public C0173a() {
            }

            @Override // android.hardware.camera2.CameraManager.TorchCallback
            public final void onTorchModeChanged(String str, boolean z7) {
                if (a.this.f16632N1.equals(str)) {
                    a.this.v2(Boolean.valueOf(z7));
                }
            }
        }

        public a(String str, boolean z7) {
            super(256, 1000L);
            this.f16636R1 = new C0173a();
            this.f16632N1 = str;
            this.f16634P1 = z7;
        }

        @Override // com.llamalab.automate.W.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            CameraManager k8 = C1695w.k(automateService.getSystemService("camera"));
            this.f16633O1 = k8;
            k8.registerTorchCallback(this.f16636R1, automateService.f14581L1);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            try {
                this.f16633O1.unregisterTorchCallback(this.f16636R1);
            } catch (Throwable unused) {
            }
            u2();
        }

        @Override // com.llamalab.automate.W.a
        public final void w2(Boolean bool) {
            Boolean bool2 = bool;
            this.f16635Q1 = bool2.booleanValue();
            if (this.f16634P1) {
                q2(bool2, false);
            } else {
                this.f16634P1 = true;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CAMERA")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_flashlight_enabled_immediate, C2541R.string.caption_flashlight_enabled_change);
        c1596k0.v(this.cameraId, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.cameraId);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.cameraId);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.cameraId = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        a aVar;
        c1708z0.q(C2541R.string.stmt_flashlight_enabled_title);
        IncapableAndroidVersionException.a(23);
        String x7 = J3.h.x(c1708z0, this.cameraId, "0");
        boolean z7 = J1(1) == 0;
        a aVar2 = (a) c1708z0.c(a.class);
        if (aVar2 == null) {
            aVar = new a(x7, z7);
        } else {
            if (aVar2.f16632N1.equals(x7)) {
                aVar2.f15404y0 = this.f16218X;
                if (!z7) {
                    aVar2.x2();
                    return false;
                }
                F5.n.h(aVar2);
                F5.n.i(aVar2, aVar2.f15405L1);
                o(c1708z0, aVar2.f16635Q1);
                return true;
            }
            aVar2.a();
            aVar = new a(x7, z7);
        }
        c1708z0.w(aVar);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
