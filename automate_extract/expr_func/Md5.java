package com.llamalab.automate.expr.func;

import S5.i;

/* loaded from: classes.dex */
public final class Md5 extends HashFunction {
    public static final String NAME = "md5";

    @Override // com.llamalab.automate.expr.func.HashFunction
    public final byte[] c(byte[] bArr) {
        i iVar = new i();
        iVar.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[16];
        iVar.c(bArr2, 0);
        return bArr2;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
