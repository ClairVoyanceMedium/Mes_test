package com.llamalab.automate.expr.func;

import J3.h;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.fs.AutomateFileTypeDetector;

/* loaded from: classes.dex */
public final class MimeType extends UnaryFunction {
    public static final String NAME = "mimeType";

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        if (c22 != null) {
            return AutomateFileTypeDetector.probeContentType(h.e0(c22));
        }
        return null;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
