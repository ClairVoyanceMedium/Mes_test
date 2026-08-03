package com.llamalab.automate.expr.func;

import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class Crc32 extends HashFunction {
    public static final String NAME = "crc32";

    @Override // com.llamalab.automate.expr.func.HashFunction
    public final byte[] c(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        return new byte[]{(byte) ((value >> 24) & 255), (byte) ((value >> 16) & 255), (byte) ((value >> 8) & 255), (byte) (value & 255)};
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
