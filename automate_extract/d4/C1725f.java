package d4;

import C1.H0;
import com.llamalab.android.system.MoreOsConstants;
import java.io.DataOutput;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.io.UTFDataFormatException;

/* renamed from: d4.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1725f extends FilterOutputStream implements DataOutput {

    /* renamed from: X, reason: collision with root package name */
    public final byte[] f17974X;

    public C1725f(OutputStream outputStream) {
        super(outputStream);
        this.f17974X = new byte[8];
    }

    public static byte[] a(int i8, String str) {
        int i9;
        int length = str.length();
        long j8 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            j8 += (charAt == 0 || charAt > 127) ? charAt <= 2047 ? 2L : 3L : 1L;
            if (j8 > i8) {
                throw new UTFDataFormatException(H0.o("String more than ", i8, " UTF bytes long"));
            }
        }
        byte[] bArr = new byte[(int) j8];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt2 = str.charAt(i12);
            if (charAt2 == 0 || charAt2 > 127) {
                int i13 = i11 + 1;
                if (charAt2 <= 2047) {
                    bArr[i11] = (byte) (((charAt2 >> 6) & 31) | 192);
                    i11 = i13 + 1;
                    bArr[i13] = (byte) ((charAt2 & '?') | 128);
                } else {
                    bArr[i11] = (byte) (((charAt2 >> '\f') & 15) | MoreOsConstants.KEY_BRIGHTNESSDOWN);
                    int i14 = i13 + 1;
                    bArr[i13] = (byte) (((charAt2 >> 6) & 63) | 128);
                    i9 = i14 + 1;
                    bArr[i14] = (byte) ((charAt2 & '?') | 128);
                }
            } else {
                i9 = i11 + 1;
                bArr[i11] = (byte) charAt2;
            }
            i11 = i9;
        }
        return bArr;
    }

    public final void b(String str) {
        byte[] a8 = a(Integer.MAX_VALUE, str);
        f(a8.length);
        write(a8);
    }

    public final void c(int i8) {
        f((i8 >> 31) ^ (i8 << 1));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((FilterOutputStream) this).out.close();
    }

    public final void d(long j8) {
        long j9 = (j8 >> 63) ^ (j8 << 1);
        while (((-128) & j9) != 0) {
            write((((int) j9) & 127) | 128);
            j9 >>>= 7;
        }
        write(((int) j9) & 127);
    }

    public final void f(int i8) {
        while ((i8 & (-128)) != 0) {
            write((i8 & 127) | 128);
            i8 >>>= 7;
        }
        write(i8 & 127);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public final void write(byte[] bArr, int i8, int i9) {
        ((FilterOutputStream) this).out.write(bArr, i8, i9);
    }

    @Override // java.io.DataOutput
    public final void writeBoolean(boolean z7) {
        write(z7 ? 1 : 0);
    }

    @Override // java.io.DataOutput
    public final void writeByte(int i8) {
        write(i8);
    }

    @Override // java.io.DataOutput
    public final void writeBytes(String str) {
        int length = str.length();
        if (length == 0) {
            return;
        }
        byte[] bArr = new byte[length];
        int i8 = 0;
        while (true) {
            length--;
            if (length < 0) {
                write(bArr);
                return;
            } else {
                bArr[i8] = (byte) str.charAt(i8);
                i8++;
            }
        }
    }

    @Override // java.io.DataOutput
    public final void writeChar(int i8) {
        writeShort(i8);
    }

    @Override // java.io.DataOutput
    public final void writeChars(String str) {
        write(str.getBytes("UTF-16BE"));
    }

    @Override // java.io.DataOutput
    public final void writeDouble(double d8) {
        writeLong(Double.doubleToLongBits(d8));
    }

    @Override // java.io.DataOutput
    public final void writeFloat(float f8) {
        writeInt(Float.floatToIntBits(f8));
    }

    @Override // java.io.DataOutput
    public final void writeInt(int i8) {
        byte[] bArr = this.f17974X;
        bArr[0] = (byte) ((i8 >> 24) & 255);
        bArr[1] = (byte) ((i8 >> 16) & 255);
        bArr[2] = (byte) ((i8 >> 8) & 255);
        bArr[3] = (byte) (i8 & 255);
        write(bArr, 0, 4);
    }

    @Override // java.io.DataOutput
    public final void writeLong(long j8) {
        int i8 = (int) (j8 >> 32);
        byte[] bArr = this.f17974X;
        bArr[0] = (byte) ((i8 >> 24) & 255);
        bArr[1] = (byte) ((i8 >> 16) & 255);
        bArr[2] = (byte) ((i8 >> 8) & 255);
        bArr[3] = (byte) (i8 & 255);
        int i9 = (int) j8;
        bArr[4] = (byte) ((i9 >> 24) & 255);
        bArr[5] = (byte) ((i9 >> 16) & 255);
        bArr[6] = (byte) ((i9 >> 8) & 255);
        bArr[7] = (byte) (i9 & 255);
        write(bArr, 0, 8);
    }

    @Override // java.io.DataOutput
    public final void writeShort(int i8) {
        byte[] bArr = this.f17974X;
        bArr[0] = (byte) ((i8 >> 8) & 255);
        bArr[1] = (byte) (i8 & 255);
        write(bArr, 0, 2);
    }

    public void writeUTF(String str) {
        byte[] a8 = a(65535, str);
        writeShort((short) a8.length);
        write(a8);
    }
}
