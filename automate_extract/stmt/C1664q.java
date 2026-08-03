package com.llamalab.automate.stmt;

import android.net.Uri;
import android.os.Build;
import android.telecom.Call;
import android.telephony.PhoneNumberUtils;
import com.llamalab.automate.AutomateCallScreeningService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.InterfaceC1588i0;

/* renamed from: com.llamalab.automate.stmt.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1664q extends com.llamalab.automate.W implements InterfaceC1588i0 {

    /* renamed from: L1, reason: collision with root package name */
    public final int f17497L1;

    /* renamed from: M1, reason: collision with root package name */
    public com.llamalab.automate.X f17498M1;

    /* renamed from: y1, reason: collision with root package name */
    public final String f17499y1;

    public C1664q(String str, int i8) {
        this.f17499y1 = str;
        this.f17497L1 = i8;
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void C(AutomateService automateService, long j8, long j9, long j10) {
        super.C(automateService, j8, j9, j10);
        if (AutomateCallScreeningService.f14527Y.add(this)) {
            AutomateCallScreeningService.f14528Z.get();
        }
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        com.llamalab.automate.X x7 = this.f17498M1;
        if (x7 != null) {
            try {
                if (x7.f15454a.compareAndSet(false, true)) {
                    AutomateCallScreeningService.a aVar = x7.f15455b;
                    if (aVar.f14531b.decrementAndGet() == 0) {
                        AutomateCallScreeningService.a.a(aVar);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        if (AutomateCallScreeningService.f14527Y.remove(this)) {
            AutomateCallScreeningService.f14528Z.get();
        }
        u2();
    }

    @Override // com.llamalab.automate.InterfaceC1588i0
    public final void J() {
    }

    @Override // com.llamalab.automate.InterfaceC1588i0
    public final void K(AutomateCallScreeningService.a aVar) {
        int callDirection;
        int i8;
        Uri handle;
        int callerNumberVerificationStatus;
        try {
            if (this.f17498M1 != null) {
                return;
            }
            Call.Details details = aVar.f14533d;
            callDirection = details.getCallDirection();
            if (callDirection != 0) {
                return;
            }
            if (30 <= Build.VERSION.SDK_INT) {
                callerNumberVerificationStatus = details.getCallerNumberVerificationStatus();
                i8 = 1 << callerNumberVerificationStatus;
            } else {
                i8 = 1;
            }
            if ((this.f17497L1 & i8) == 0) {
                return;
            }
            handle = details.getHandle();
            String schemeSpecificPart = handle != null ? handle.getSchemeSpecificPart() : null;
            String str = this.f17499y1;
            if (str == null || (schemeSpecificPart != null && PhoneNumberUtils.compare(this.f15400Y, str, schemeSpecificPart))) {
                aVar.f14531b.incrementAndGet();
                this.f17498M1 = new com.llamalab.automate.X(aVar);
                if (AutomateCallScreeningService.f14527Y.remove(this)) {
                    AutomateCallScreeningService.f14528Z.get();
                }
                o2(4900L, new Object[]{schemeSpecificPart, Double.valueOf(i8)});
            }
        } catch (Throwable th) {
            r2(th);
        }
    }

    @Override // com.llamalab.automate.InterfaceC1588i0
    public final void M0() {
    }
}
