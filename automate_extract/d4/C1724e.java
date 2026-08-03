package d4;

import java.io.DataInput;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.io.UTFDataFormatException;

/* renamed from: d4.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1724e extends FilterInputStream implements DataInput {

    /* renamed from: X, reason: collision with root package name */
    public final byte[] f17973X;

    public C1724e(InputStream inputStream) {
        super(inputStream);
        this.f17973X = new byte[8];
    }

    public static String c(DataInput dataInput, int i8) {
        int i9;
        int i10;
        byte[] bArr = new byte[i8];
        dataInput.readFully(bArr);
        char[] cArr = new char[i8];
        int i11 = 0;
        int i12 = 0;
        while (i11 < i8) {
            int i13 = i11 + 1;
            char c8 = (char) bArr[i11];
            cArr[i12] = c8;
            if (c8 < 128) {
                i12++;
                i11 = i13;
            } else {
                if ((c8 & 224) == 192) {
                    if (i13 >= i8) {
                        throw new UTFDataFormatException(B4.g.g("Bad second byte at ", i13));
                    }
                    i9 = i13 + 1;
                    byte b8 = bArr[i13];
                    if ((b8 & 192) != 128) {
                        StringBuilder sb = new StringBuilder("Bad second byte at ");
                        sb.append(i9 - 1);
                        throw new UTFDataFormatException(sb.toString());
                    }
                    i10 = i12 + 1;
                    cArr[i12] = (char) (((c8 & 31) << 6) | (b8 & 63));
                } else {
                    if ((c8 & 240) != 224) {
                        StringBuilder sb2 = new StringBuilder("Bad byte at ");
                        sb2.append(i13 - 1);
                        throw new UTFDataFormatException(sb2.toString());
                    }
                    int i14 = i13 + 1;
                    if (i14 >= i8) {
                        throw new UTFDataFormatException(B4.g.g("Bad third byte at ", i14));
                    }
                    byte b9 = bArr[i13];
                    i9 = i14 + 1;
                    byte b10 = bArr[i14];
                    if ((b9 & 192) != 128 || (b10 & 192) != 128) {
                        StringBuilder sb3 = new StringBuilder("Bad second or third byte at ");
                        sb3.append(i9 - 2);
                        throw new UTFDataFormatException(sb3.toString());
                    }
                    i10 = i12 + 1;
                    cArr[i12] = (char) (((c8 & 15) << 12) | ((b9 & 63) << 6) | (b10 & 63));
                }
                i12 = i10;
                i11 = i9;
            }
        }
        return new String(cArr, 0, i12);
    }

    public final int a() {
        int d8 = d();
        return (d8 & Integer.MIN_VALUE) ^ ((((d8 << 31) >> 31) ^ d8) >> 1);
    }

    public final long b() {
        long j8 = 0;
        long j9 = 0;
        do {
            long readUnsignedByte = (byte) readUnsignedByte();
            if ((128 & readUnsignedByte) == 0) {
                long j10 = (readUnsignedByte << ((int) j8)) | j9;
                return (j10 & Long.MIN_VALUE) ^ ((((j10 << 63) >> 63) ^ j10) >> 1);
            }
            j9 |= (readUnsignedByte & 127) << ((int) j8);
            j8 += 7;
        } while (j8 <= 63);
        throw new StreamCorruptedException("Variable length quantity is too long (must be <= 63)");
    }

    public final int d() {
        int i8 = 0;
        int i9 = 0;
        do {
            byte readUnsignedByte = (byte) readUnsignedByte();
            if ((readUnsignedByte & 128) == 0) {
                return i8 | (readUnsignedByte << i9);
            }
            i8 |= (readUnsignedByte & Byte.MAX_VALUE) << i9;
            i9 += 7;
        } while (i9 <= 35);
        throw new StreamCorruptedException("Variable length quantity is too long (must be <= 35)");
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        return readUnsignedByte() != 0;
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        return (char) readShort();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        byte[] bArr = this.f17973X;
        readFully(bArr, 0, 4);
        return ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
    }

    @Override // java.io.DataInput
    @Deprecated
    public final String readLine() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public final long readLong() {
        readFully(this.f17973X, 0, 8);
        return ((((((r0[0] & 255) << 24) | ((r0[1] & 255) << 16)) | ((r0[2] & 255) << 8)) | (r0[3] & 255)) << 32) | (((r0[7] & 255) | ((r0[6] & 255) << 8) | ((r0[4] & 255) << 24) | ((r0[5] & 255) << 16)) & 4294967295L);
    }

    @Override // java.io.DataInput
    public final short readShort() {
        byte[] bArr = this.f17973X;
        readFully(bArr, 0, 2);
        return (short) ((bArr[0] << 8) | (bArr[1] & 255));
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        int read = read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        return readShort() & 65535;
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i8) {
        int i9 = 0;
        while (i9 < i8) {
            long skip = skip(i8 - i9);
            if (skip <= 0) {
                break;
            }
            i9 = (int) (i9 + skip);
        }
        return i9;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i8, int i9) {
        while (i9 != 0) {
            int read = read(bArr, i8, i9);
            if (read < 0) {
                throw new EOFException();
            }
            i8 += read;
            i9 -= read;
        }
    }
}
