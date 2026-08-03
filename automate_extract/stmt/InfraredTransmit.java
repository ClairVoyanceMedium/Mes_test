package com.llamalab.automate.stmt;

import android.content.Context;
import android.hardware.ConsumerIrManager;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("infrared_transmit.html")
@F3.a(C2541R.integer.ic_remote)
@F3.i(C2541R.string.stmt_infrared_transmit_title)
@F3.h(C2541R.string.stmt_infrared_transmit_summary)
@F3.c(C2541R.string.caption_infrared_transmit)
@F3.e(C2541R.layout.stmt_infrared_transmit_edit)
/* loaded from: classes.dex */
public class InfraredTransmit extends Action implements AsyncStatement {
    public InterfaceC1700x0 carrierFrequency;
    public InterfaceC1700x0 pattern;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final int f16736L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int[] f16737M1;

        public a(int i8, int[] iArr) {
            this.f16736L1 = i8;
            this.f16737M1 = iArr;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            boolean hasIrEmitter;
            ConsumerIrManager f8 = B.B.f(this.f15400Y.getSystemService("consumer_ir"));
            if (f8 != null) {
                hasIrEmitter = f8.hasIrEmitter();
                if (hasIrEmitter) {
                    f8.transmit(this.f16736L1, this.f16737M1);
                    p2(null);
                    return;
                }
            }
            throw new UnsupportedOperationException("No IR emitter");
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.TRANSMIT_IR")};
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.carrierFrequency);
        dVar.g(this.pattern);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.carrierFrequency);
        visitor.b(this.pattern);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.carrierFrequency = (InterfaceC1700x0) cVar.readObject();
        this.pattern = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_infrared_transmit_title);
        IncapableAndroidVersionException.a(19);
        int m8 = J3.h.m(c1708z0, this.carrierFrequency, 38000);
        Object u8 = J3.h.u(c1708z0, this.pattern, null);
        if (u8 == null) {
            throw new RequiredArgumentNullException("pattern");
        }
        if (!(u8 instanceof J3.a)) {
            throw new IllegalArgumentException("pattern");
        }
        int[] S7 = J3.h.S((J3.a) u8);
        long j8 = 0;
        for (int i8 : S7) {
            j8 += i8;
        }
        if (j8 == 0) {
            throw new IllegalArgumentException("Pattern has no duration");
        }
        if (j8 >= 2000000) {
            throw new IllegalArgumentException("Pattern duration is 2 seconds or longer");
        }
        a aVar = new a(m8, S7);
        c1708z0.w(aVar);
        aVar.v2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
