package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import android.text.TextUtils;
import com.llamalab.automate.C1708z0;
import java.text.Normalizer;

@g(1)
/* loaded from: classes.dex */
public final class Unorm extends BinaryFunction {
    public static final String NAME = "unorm";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Normalizer.Form form;
        String x7 = h.x(c1708z0, this.f4950X, null);
        if (TextUtils.isEmpty(x7)) {
            return x7;
        }
        String x8 = h.x(c1708z0, this.f4951Y, "nfc");
        if ("nfc".equalsIgnoreCase(x8)) {
            form = Normalizer.Form.NFC;
        } else if ("nfd".equalsIgnoreCase(x8)) {
            form = Normalizer.Form.NFD;
        } else if ("nfkc".equalsIgnoreCase(x8)) {
            form = Normalizer.Form.NFKC;
        } else {
            if (!"nfkd".equalsIgnoreCase(x8)) {
                return null;
            }
            form = Normalizer.Form.NFKD;
        }
        return Normalizer.normalize(x7, form);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
