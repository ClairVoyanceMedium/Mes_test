package com.llamalab.automate.expr.func;

import S5.n;

/* loaded from: classes.dex */
public final class Sha1 extends HashFunction {
    public static final String NAME = "sha1";

    @Override // com.llamalab.automate.expr.func.HashFunction
    public final byte[] c(byte[] bArr) {
        n nVar = new n();
        nVar.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[20];
        nVar.c(bArr2, 0);
        return bArr2;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
