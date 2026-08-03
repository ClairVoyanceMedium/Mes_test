package com.llamalab.automate.expr.func;

import F3.g;
import J3.b;
import J3.h;
import com.llamalab.automate.C1708z0;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Locale;

@g(1)
/* loaded from: classes.dex */
public final class NumberFormat extends TernaryFunction {
    public static final String NAME = "numberFormat";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object valueOf;
        Object c22 = this.f4940X.c2(c1708z0);
        String x7 = h.x(c1708z0, this.f4941Y, null);
        Locale r8 = h.r(c1708z0, this.f4942Z, c1708z0.h());
        Format decimalFormat = x7 != null ? new DecimalFormat(x7, DecimalFormatSymbols.getInstance(r8)) : java.text.NumberFormat.getInstance(r8);
        if (c22 instanceof b) {
            b bVar = (b) c22;
            int i8 = bVar.f4638X;
            if (i8 == 0) {
                valueOf = BigInteger.ZERO;
            } else {
                int[] iArr = bVar.f4639Y;
                ByteBuffer allocate = ByteBuffer.allocate(iArr.length * 4);
                allocate.asIntBuffer().put(iArr);
                valueOf = new BigInteger(i8, allocate.array());
            }
        } else {
            valueOf = Double.valueOf(h.W(c22));
        }
        return decimalFormat.format(valueOf);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
