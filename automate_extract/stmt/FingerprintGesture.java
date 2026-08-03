package com.llamalab.automate.stmt;

import android.accessibilityservice.FingerprintGestureController;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1619q;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import x3.C2425c;

@F3.f("fingerprint_gesture.html")
@F3.a(C2541R.integer.ic_action_fingerprint)
@F3.i(C2541R.string.stmt_fingerprint_gesture_title)
@F3.h(C2541R.string.stmt_fingerprint_gesture_summary)
@F3.e(C2541R.layout.stmt_fingerprint_gesture_edit)
/* loaded from: classes.dex */
public final class FingerprintGesture extends Action implements AsyncStatement {
    public InterfaceC1700x0 gestures;
    public J3.l varGesturePerformed;

    public static final class a extends C1619q {

        /* renamed from: N1, reason: collision with root package name */
        public final int f16627N1;

        /* renamed from: O1, reason: collision with root package name */
        public final boolean f16628O1;

        /* renamed from: P1, reason: collision with root package name */
        public FingerprintGestureController f16629P1;

        /* renamed from: Q1, reason: collision with root package name */
        public final C0172a f16630Q1;

        /* renamed from: com.llamalab.automate.stmt.FingerprintGesture$a$a, reason: collision with other inner class name */
        public class C0172a extends FingerprintGestureController.FingerprintGestureCallback {
            public C0172a() {
            }

            @Override // android.accessibilityservice.FingerprintGestureController.FingerprintGestureCallback
            public final void onGestureDetected(int i8) {
                a aVar = a.this;
                int i9 = aVar.f16627N1;
                if (i9 == 0 || (i9 & i8) != 0) {
                    aVar.q2(Double.valueOf(i8), false);
                }
            }

            @Override // android.accessibilityservice.FingerprintGestureController.FingerprintGestureCallback
            public final void onGestureDetectionAvailabilityChanged(boolean z7) {
                a aVar = a.this;
                if (aVar.f16628O1) {
                    aVar.v2(z7);
                }
            }
        }

        public a(int i8, boolean z7) {
            super(0, 512);
            this.f16630Q1 = new C0172a();
            this.f16627N1 = i8;
            this.f16628O1 = z7;
        }

        @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
        public final void U1(AutomateAccessibilityService automateAccessibilityService) {
            boolean isGestureDetectionAvailable;
            super.U1(automateAccessibilityService);
            if (this.f16629P1 == null) {
                try {
                    FingerprintGestureController fingerprintGestureController = automateAccessibilityService.getFingerprintGestureController();
                    this.f16629P1 = fingerprintGestureController;
                    if (fingerprintGestureController == null) {
                        throw new UnsupportedOperationException("Fingerprint gestures not supported");
                    }
                    if (this.f16628O1) {
                        isGestureDetectionAvailable = fingerprintGestureController.isGestureDetectionAvailable();
                        v2(isGestureDetectionAvailable);
                    }
                    this.f16629P1.registerFingerprintGestureCallback(this.f16630Q1, this.f15400Y.f14581L1);
                } catch (Throwable th) {
                    r2(th);
                }
            }
        }

        public final void v2(boolean z7) {
            String str;
            if (z7) {
                str = "FingerprintGesture detection available";
            } else {
                int identifier = Resources.getSystem().getIdentifier("config_fingerprintSupportsGestures", "bool", "android");
                if (identifier != 0) {
                    str = "FingerprintGesture detection unavailable (config_fingerprintSupportsGestures=" + Resources.getSystem().getBoolean(identifier) + ")";
                } else {
                    str = "FingerprintGesture detection unavailable";
                }
            }
            F5.n.f(this, str);
        }

        @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
        public final void y1(AutomateAccessibilityService automateAccessibilityService) {
            FingerprintGestureController fingerprintGestureController = this.f16629P1;
            if (fingerprintGestureController != null) {
                try {
                    fingerprintGestureController.unregisterFingerprintGestureCallback(this.f16630Q1);
                } catch (Throwable unused) {
                }
                this.f16629P1 = null;
            }
            super.y1(automateAccessibilityService);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 28 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.f15540a, com.llamalab.automate.access.c.j("android.permission.USE_BIOMETRIC")} : 26 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.f15540a, com.llamalab.automate.access.c.j("android.permission.USE_FINGERPRINT")} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_fingerprint_gesture);
        l8.h(this.gestures, null, C2541R.xml.fingerprint_gestures);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.gestures);
        dVar.g(this.varGesturePerformed);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.gestures);
        visitor.b(this.varGesturePerformed);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.gestures = (InterfaceC1700x0) cVar.readObject();
        this.varGesturePerformed = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_fingerprint_gesture_title);
        IncapableAndroidVersionException.a(26);
        c1708z0.w(new a(J3.h.m(c1708z0, this.gestures, 0) & 15, C1710z2.a(C2425c.c(c1708z0))));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varGesturePerformed;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
