package com.llamalab.automate.expr.func;

import J3.h;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import x3.C2440r;

/* loaded from: classes.dex */
public final class XPathEncode extends UnaryFunction {
    public static final String NAME = "xpathEncode";

    public XPathEncode() {
    }

    public XPathEncode(InterfaceC1700x0 interfaceC1700x0) {
        super(interfaceC1700x0);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        return C2440r.j(h.f0("", this.f4947X.c2(c1708z0)));
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
