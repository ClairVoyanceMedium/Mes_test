package com.llamalab.automate.expr.func;

import J3.h;
import android.view.KeyCharacterMap;
import com.llamalab.automate.C1708z0;

/* loaded from: classes.dex */
public final class Undead extends BinaryFunction {
    public static final String NAME = "undead";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22;
        int deadChar;
        Object c23 = this.f4950X.c2(c1708z0);
        if (c23 == null || (c22 = this.f4951Y.c2(c1708z0)) == null || (deadChar = KeyCharacterMap.getDeadChar((int) h.W(c23), (int) h.W(c22))) == 0) {
            return null;
        }
        return Double.valueOf(deadChar);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
