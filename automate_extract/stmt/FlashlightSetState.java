package com.llamalab.automate.stmt;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1695w;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import x3.C2433k;
import x3.C2440r;

@F3.f("flashlight_set_state.html")
@F3.a(C2541R.integer.ic_device_access_flash_on)
@F3.i(C2541R.string.stmt_flashlight_set_state_title)
@F3.h(C2541R.string.stmt_flashlight_set_state_summary)
@F3.e(C2541R.layout.stmt_flashlight_set_state_edit)
/* loaded from: classes.dex */
public final class FlashlightSetState extends SetStateAction {
    public InterfaceC1700x0 cameraId;
    public InterfaceC1700x0 strength;

    public static final class a extends com.llamalab.automate.W {

        /* renamed from: L1, reason: collision with root package name */
        public CameraManager f16638L1;

        /* renamed from: y1, reason: collision with root package name */
        public String f16639y1;

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            this.f16638L1 = C1695w.k(automateService.getSystemService("camera"));
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            String str = this.f16639y1;
            if (str != null) {
                try {
                    this.f16638L1.setTorchMode(str, false);
                } catch (Throwable unused) {
                }
                this.f16639y1 = null;
            }
            u2();
        }

        public final void v2(String str, Double d8) {
            CameraCharacteristics cameraCharacteristics;
            CameraCharacteristics.Key key;
            Object obj;
            String str2;
            if (!C2440r.h(this.f16639y1, str) && (str2 = this.f16639y1) != null) {
                try {
                    this.f16638L1.setTorchMode(str2, false);
                } catch (Throwable unused) {
                }
                this.f16639y1 = null;
            }
            cameraCharacteristics = this.f16638L1.getCameraCharacteristics(str);
            if (33 <= Build.VERSION.SDK_INT) {
                if (d8 != null) {
                    key = CameraCharacteristics.FLASH_INFO_STRENGTH_MAXIMUM_LEVEL;
                    obj = cameraCharacteristics.get(key);
                    Integer num = (Integer) obj;
                    if (num != null && num.intValue() > 1) {
                        CameraManager cameraManager = this.f16638L1;
                        double intValue = num.intValue();
                        double b8 = y4.j.b(d8.doubleValue() / 100.0d, 0.0d, 1.0d);
                        Double.isNaN(intValue);
                        Double.isNaN(intValue);
                        cameraManager.turnOnTorchWithStrengthLevel(str, (int) Math.round(((intValue - 1.0d) * b8) + 1.0d));
                    }
                }
                this.f16638L1.setTorchMode(str, true);
            } else {
                this.f16638L1.setTorchMode(str, true);
            }
            this.f16639y1 = str;
        }
    }

    public static final class b extends com.llamalab.automate.W implements Camera.ErrorCallback {

        /* renamed from: L1, reason: collision with root package name */
        public Camera f16640L1;

        /* renamed from: M1, reason: collision with root package name */
        public C2433k f16641M1;

        /* renamed from: N1, reason: collision with root package name */
        public String f16642N1;

        /* renamed from: y1, reason: collision with root package name */
        public int f16643y1 = -1;

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            F5.n.h(this);
            Camera camera = this.f16640L1;
            if (camera != null) {
                try {
                    camera.release();
                } catch (Exception unused) {
                }
                this.f16640L1 = null;
            }
            C2433k c2433k = this.f16641M1;
            if (c2433k != null) {
                try {
                    c2433k.release();
                } catch (Exception unused2) {
                }
                this.f16641M1 = null;
            }
            u2();
        }

        @Override // android.hardware.Camera.ErrorCallback
        public final void onError(int i8, Camera camera) {
            r2(100 == i8 ? new RuntimeException("Media server died").fillInStackTrace() : new RuntimeException(B4.g.f(i8, new StringBuilder("Unknown camera error: 0x"))).fillInStackTrace());
        }

        public final void v2(int i8) {
            if (this.f16643y1 == i8) {
                Camera.Parameters parameters = this.f16640L1.getParameters();
                parameters.setFlashMode(this.f16642N1);
                this.f16640L1.setParameters(parameters);
                return;
            }
            this.f16643y1 = i8;
            Camera camera = this.f16640L1;
            if (camera != null) {
                try {
                    camera.release();
                } catch (Exception unused) {
                }
                this.f16640L1 = null;
            }
            C2433k c2433k = this.f16641M1;
            if (c2433k != null) {
                try {
                    c2433k.release();
                } catch (Exception unused2) {
                }
                this.f16641M1 = null;
            }
            Camera open = Camera.open(i8);
            this.f16640L1 = open;
            if (open == null) {
                throw new IllegalStateException("No such camera");
            }
            Camera.Parameters parameters2 = open.getParameters();
            List<String> supportedFlashModes = parameters2.getSupportedFlashModes();
            List<String> emptyList = Collections.emptyList();
            if (supportedFlashModes == null) {
                supportedFlashModes = emptyList;
            }
            List<String> list = supportedFlashModes;
            String str = "torch";
            if (!list.contains("torch")) {
                str = "on";
                if (!list.contains("on")) {
                    throw new IllegalStateException("Camera has no flash");
                }
            }
            this.f16642N1 = str;
            Camera.Size size = (Camera.Size) Collections.min(parameters2.getSupportedPreviewSizes(), C2440r.f23421e);
            parameters2.setPreviewSize(size.width, size.height);
            parameters2.setFlashMode(this.f16642N1);
            this.f16640L1.setParameters(parameters2);
            this.f16640L1.startPreview();
            C2433k c2433k2 = new C2433k();
            this.f16641M1 = c2433k2;
            c2433k2.a(size);
            this.f16640L1.setPreviewTexture(this.f16641M1);
            this.f16640L1.setErrorCallback(this);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 23 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CAMERA")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.FLASHLIGHT")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).z(this.state, false, C2541R.string.caption_flashlight_enable, C2541R.string.caption_flashlight_disable).r(C2541R.string.caption_flashlight_set_state).b(this.state).f16030c;
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (51 <= dVar.f6413Z) {
            dVar.g(this.cameraId);
        }
        if (98 <= dVar.f6413Z) {
            dVar.g(this.strength);
        }
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.cameraId);
        visitor.b(this.strength);
    }

    @Override // com.llamalab.automate.stmt.SetStateAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (51 <= cVar.f6409x0) {
            InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
            this.cameraId = interfaceC1700x0;
            if (98 > cVar.f6409x0 && (interfaceC1700x0 instanceof L3.K)) {
                Pattern pattern = J3.h.f4650a;
                this.cameraId = new L3.W(J3.h.e0(((L3.K) interfaceC1700x0).value()));
            }
        }
        if (98 <= cVar.f6409x0) {
            this.strength = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int i8;
        c1708z0.q(C2541R.string.stmt_flashlight_set_state_title);
        e(c1708z0);
        String x7 = J3.h.x(c1708z0, this.cameraId, "0");
        Double j8 = J3.h.j(c1708z0, this.strength);
        boolean q8 = q(c1708z0, false);
        if (23 <= Build.VERSION.SDK_INT) {
            a aVar = (a) c1708z0.c(a.class);
            try {
                if (q8) {
                    if (aVar == null) {
                        a aVar2 = new a();
                        c1708z0.w(aVar2);
                        aVar = aVar2;
                    }
                    aVar.v2(x7, j8);
                } else if (aVar != null) {
                    aVar.a();
                } else {
                    C1695w.k(c1708z0.getSystemService("camera")).setTorchMode(x7, false);
                }
                c1708z0.f17642x0 = this.onComplete;
                return true;
            } catch (Throwable th) {
                if (aVar != null) {
                    aVar.a();
                }
                throw th;
            }
        }
        try {
            i8 = Integer.parseInt(x7);
        } catch (NumberFormatException unused) {
            i8 = -1;
        }
        b bVar = (b) c1708z0.c(b.class);
        try {
            if (q8) {
                if (bVar == null) {
                    b bVar2 = new b();
                    c1708z0.w(bVar2);
                    bVar = bVar2;
                } else {
                    F5.n.h(bVar);
                }
                bVar.v2(i8);
            } else if (bVar != null) {
                F5.n.h(bVar);
                Camera camera = bVar.f16640L1;
                if (camera != null) {
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode("off");
                    bVar.f16640L1.setParameters(parameters);
                }
                F5.n.i(bVar, 1000L);
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        } catch (Throwable th2) {
            if (bVar != null) {
                bVar.a();
            }
            throw th2;
        }
    }
}
