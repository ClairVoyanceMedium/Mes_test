package com.llamalab.automate.stmt;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.SystemClock;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1695w;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("camera_available.html")
@F3.a(C2541R.integer.ic_device_access_camera)
@F3.i(C2541R.string.stmt_camera_available_title)
@F3.h(C2541R.string.stmt_camera_available_summary)
@F3.e(C2541R.layout.stmt_camera_available_edit)
/* loaded from: classes.dex */
public final class CameraAvailable extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 cameraId;
    public J3.l varCameraId;

    public static abstract class a extends com.llamalab.automate.W {

        /* renamed from: L1, reason: collision with root package name */
        public final String f16422L1;

        /* renamed from: M1, reason: collision with root package name */
        public final C0170a f16423M1 = new C0170a();

        /* renamed from: y1, reason: collision with root package name */
        public CameraManager f16424y1;

        /* renamed from: com.llamalab.automate.stmt.CameraAvailable$a$a, reason: collision with other inner class name */
        public class C0170a extends CameraManager.AvailabilityCallback {
            public C0170a() {
            }

            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public final void onCameraAvailable(String str) {
                a.this.v2(str);
            }

            @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
            public final void onCameraUnavailable(String str) {
                a.this.w2(str);
            }
        }

        public a(String str) {
            this.f16422L1 = str;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            CameraManager k8 = C1695w.k(automateService.getSystemService("camera"));
            this.f16424y1 = k8;
            k8.registerAvailabilityCallback(this.f16423M1, automateService.f14581L1);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public void F(AutomateService automateService) {
            try {
                this.f16424y1.unregisterAvailabilityCallback(this.f16423M1);
            } catch (Throwable unused) {
            }
            u2();
        }

        public abstract void v2(String str);

        public void w2(String str) {
        }
    }

    public static final class b extends a implements Runnable {

        /* renamed from: N1, reason: collision with root package name */
        public boolean f16426N1;

        public b(String str) {
            super(str);
        }

        @Override // com.llamalab.automate.stmt.CameraAvailable.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            automateService.f14581L1.postDelayed(this, 100L);
        }

        @Override // com.llamalab.automate.stmt.CameraAvailable.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            automateService.f14581L1.removeCallbacks(this);
            super.F(automateService);
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f16426N1) {
                return;
            }
            this.f16426N1 = true;
            q2(new Object[]{Boolean.FALSE, this.f16422L1}, false);
        }

        @Override // com.llamalab.automate.stmt.CameraAvailable.a
        public final void v2(String str) {
            String str2 = this.f16422L1;
            if ((str2 == null || str2.equals(str)) && !this.f16426N1) {
                this.f16426N1 = true;
                q2(new Object[]{Boolean.TRUE, str}, false);
            }
        }
    }

    public static final class c extends a {

        /* renamed from: N1, reason: collision with root package name */
        public long f16427N1;

        /* renamed from: O1, reason: collision with root package name */
        public boolean f16428O1;

        public c(String str) {
            super(str);
            this.f16427N1 = Long.MAX_VALUE;
        }

        @Override // com.llamalab.automate.stmt.CameraAvailable.a, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            this.f16427N1 = SystemClock.elapsedRealtime() + 100;
        }

        @Override // com.llamalab.automate.stmt.CameraAvailable.a
        public final void v2(String str) {
            x2(str, true);
        }

        @Override // com.llamalab.automate.stmt.CameraAvailable.a
        public final void w2(String str) {
            x2(str, false);
        }

        public final void x2(String str, boolean z7) {
            if (this.f16428O1) {
                return;
            }
            String str2 = this.f16422L1;
            if ((str2 == null || str2.equals(str)) && this.f16427N1 < SystemClock.elapsedRealtime()) {
                this.f16428O1 = true;
                q2(new Object[]{Boolean.valueOf(z7), str}, false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_camera_available_immediate, C2541R.string.caption_camera_available_change);
        c1596k0.v(this.cameraId, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.cameraId);
        dVar.g(this.varCameraId);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.cameraId);
        visitor.b(this.varCameraId);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.cameraId = (InterfaceC1700x0) cVar.readObject();
        this.varCameraId = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_camera_available_title);
        IncapableAndroidVersionException.a(21);
        String x7 = J3.h.x(c1708z0, this.cameraId, null);
        c1708z0.w(J1(1) == 0 ? new b(x7) : new c(x7));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varCameraId;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[1]);
        }
        o(c1708z0, ((Boolean) objArr[0]).booleanValue());
        return true;
    }
}
