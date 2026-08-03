package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import java.util.regex.Pattern;

@F3.f("usb_configured.html")
@F3.a(C2541R.integer.ic_device_access_usb)
@F3.i(C2541R.string.stmt_usb_configured_title)
@F3.h(C2541R.string.stmt_usb_configured_summary)
@F3.e(C2541R.layout.stmt_usb_configured_edit)
/* loaded from: classes.dex */
public final class UsbConfigured extends IntermittentDecision implements ReceiverStatement {
    public InterfaceC1700x0 functions;
    public J3.l varCurrentFunctions;

    public static final class a extends AbstractC1618p2.c {

        /* renamed from: L1, reason: collision with root package name */
        public boolean f17212L1;

        /* renamed from: x1, reason: collision with root package name */
        public final Long f17213x1;

        /* renamed from: y1, reason: collision with root package name */
        public long f17214y1 = 0;

        public a(Long l8) {
            this.f17213x1 = l8;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            long B7 = UsbConfigured.B(intent);
            boolean booleanExtra = intent.getBooleanExtra("configured", false);
            if (!isInitialStickyBroadcast()) {
                Long l8 = this.f17213x1;
                if (l8 != null) {
                    boolean z7 = booleanExtra && UsbConfigured.C(l8.longValue(), B7);
                    if (z7 != (this.f17212L1 && UsbConfigured.C(l8.longValue(), this.f17214y1))) {
                        c(intent, new Object[]{Boolean.valueOf(z7), Double.valueOf(B7)}, false);
                    }
                } else if (booleanExtra != this.f17212L1 || B7 != this.f17214y1) {
                    c(intent, new Object[]{Boolean.valueOf(booleanExtra), Double.valueOf(B7)}, false);
                }
            }
            this.f17214y1 = B7;
            this.f17212L1 = booleanExtra;
        }
    }

    public static long B(Intent intent) {
        int i8 = Build.VERSION.SDK_INT;
        if (23 > i8 || intent.getBooleanExtra("unlocked", false)) {
            r2 = intent.getBooleanExtra("mtp", false) ? 4L : 0L;
            if (intent.getBooleanExtra("ptp", false)) {
                r2 |= 16;
            }
        }
        if (intent.getBooleanExtra("adb", false)) {
            r2 |= 1;
        }
        if (intent.getBooleanExtra("rndis", false)) {
            r2 |= 32;
        }
        if (intent.getBooleanExtra("accessory", false)) {
            r2 |= 2;
        }
        if (23 <= i8 && intent.getBooleanExtra("midi", false)) {
            r2 |= 8;
        }
        if (30 <= i8 && intent.getBooleanExtra("ncm", false)) {
            r2 |= 1024;
        }
        return (33 > i8 || !intent.getBooleanExtra("uvc", false)) ? r2 : r2 | 128;
    }

    public static boolean C(long j8, long j9) {
        if (0 == j8) {
            if (0 == j9) {
                return true;
            }
        } else if ((j8 & j9) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_usb_configured_immediate, C2541R.string.caption_usb_configured_change);
        c1596k0.h(this.functions, null, C2541R.xml.usb_functions);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        Double d8 = (Double) objArr[1];
        J3.l lVar = this.varCurrentFunctions;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        o(c1708z0, booleanValue);
        return true;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.functions);
        dVar.g(this.varCurrentFunctions);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.functions);
        visitor.b(this.varCurrentFunctions);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.functions = (InterfaceC1700x0) cVar.readObject();
        this.varCurrentFunctions = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Object c22;
        c1708z0.q(C2541R.string.stmt_usb_configured_title);
        InterfaceC1700x0 interfaceC1700x0 = this.functions;
        Pattern pattern = J3.h.f4650a;
        Long valueOf = (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) ? null : Long.valueOf(J3.h.T(c22));
        boolean z7 = false;
        if (J1(1) != 0) {
            a aVar = new a(valueOf);
            c1708z0.w(aVar);
            aVar.o(2, "android.hardware.usb.action.USB_STATE");
            return false;
        }
        Intent j8 = D.c.j(c1708z0, null, new IntentFilter("android.hardware.usb.action.USB_STATE"), 2);
        if (j8 == null) {
            J3.l lVar = this.varCurrentFunctions;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return true;
        }
        long B7 = B(j8);
        if (j8.getBooleanExtra("configured", false) && (valueOf == null || C(valueOf.longValue(), B7))) {
            z7 = true;
        }
        Double valueOf2 = Double.valueOf(B7);
        J3.l lVar2 = this.varCurrentFunctions;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, valueOf2);
        }
        o(c1708z0, z7);
        return true;
    }
}
