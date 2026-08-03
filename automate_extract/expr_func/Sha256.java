package com.llamalab.automate.expr.func;

import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class Sha256 extends HashFunction {
    public static final String NAME = "sha256";

    @Override // com.llamalab.automate.expr.func.HashFunction
    public final byte[] c(byte[] bArr) {
        return MessageDigest.getInstance("SHA256").digest(bArr);
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
