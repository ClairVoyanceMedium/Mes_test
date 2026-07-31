package b0;

import B4.g;
import C1.D1;
import C1.H0;
import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import b0.C1287b;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.image.png.PngText;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* renamed from: b0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1286a {

    /* renamed from: D, reason: collision with root package name */
    public static final String[] f11419D;

    /* renamed from: E, reason: collision with root package name */
    public static final int[] f11420E;

    /* renamed from: F, reason: collision with root package name */
    public static final byte[] f11421F;

    /* renamed from: G, reason: collision with root package name */
    public static final d f11422G;

    /* renamed from: H, reason: collision with root package name */
    public static final d[][] f11423H;

    /* renamed from: I, reason: collision with root package name */
    public static final d[] f11424I;

    /* renamed from: J, reason: collision with root package name */
    public static final HashMap<Integer, d>[] f11425J;

    /* renamed from: K, reason: collision with root package name */
    public static final HashMap<String, d>[] f11426K;

    /* renamed from: L, reason: collision with root package name */
    public static final HashSet<String> f11427L;

    /* renamed from: M, reason: collision with root package name */
    public static final HashMap<Integer, Integer> f11428M;

    /* renamed from: N, reason: collision with root package name */
    public static final Charset f11429N;

    /* renamed from: O, reason: collision with root package name */
    public static final byte[] f11430O;

    /* renamed from: P, reason: collision with root package name */
    public static final byte[] f11431P;

    /* renamed from: a, reason: collision with root package name */
    public final FileDescriptor f11447a;

    /* renamed from: b, reason: collision with root package name */
    public final AssetManager.AssetInputStream f11448b;

    /* renamed from: c, reason: collision with root package name */
    public int f11449c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap<String, c>[] f11450d;

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f11451e;

    /* renamed from: f, reason: collision with root package name */
    public ByteOrder f11452f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11453g;

    /* renamed from: h, reason: collision with root package name */
    public int f11454h;

    /* renamed from: i, reason: collision with root package name */
    public int f11455i;

    /* renamed from: j, reason: collision with root package name */
    public int f11456j;

    /* renamed from: k, reason: collision with root package name */
    public int f11457k;

    /* renamed from: l, reason: collision with root package name */
    public static final boolean f11432l = Log.isLoggable("ExifInterface", 3);

    /* renamed from: m, reason: collision with root package name */
    public static final List<Integer> f11433m = Arrays.asList(1, 6, 3, 8);

    /* renamed from: n, reason: collision with root package name */
    public static final List<Integer> f11434n = Arrays.asList(2, 7, 4, 5);

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f11435o = {8, 8, 8};

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f11436p = {8};

    /* renamed from: q, reason: collision with root package name */
    public static final byte[] f11437q = {-1, -40, -1};

    /* renamed from: r, reason: collision with root package name */
    public static final byte[] f11438r = {102, 116, 121, 112};

    /* renamed from: s, reason: collision with root package name */
    public static final byte[] f11439s = {109, 105, 102, 49};

    /* renamed from: t, reason: collision with root package name */
    public static final byte[] f11440t = {104, 101, 105, 99};

    /* renamed from: u, reason: collision with root package name */
    public static final byte[] f11441u = {79, 76, 89, 77, 80, 0};

    /* renamed from: v, reason: collision with root package name */
    public static final byte[] f11442v = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: w, reason: collision with root package name */
    public static final byte[] f11443w = {-119, 80, 78, 71, 13, 10, 26, 10};

    /* renamed from: x, reason: collision with root package name */
    public static final byte[] f11444x = {101, 88, 73, 102};

    /* renamed from: y, reason: collision with root package name */
    public static final byte[] f11445y = {73, 72, 68, 82};

    /* renamed from: z, reason: collision with root package name */
    public static final byte[] f11446z = {73, 69, 78, 68};

    /* renamed from: A, reason: collision with root package name */
    public static final byte[] f11416A = {82, 73, 70, 70};

    /* renamed from: B, reason: collision with root package name */
    public static final byte[] f11417B = {87, 69, 66, 80};

    /* renamed from: C, reason: collision with root package name */
    public static final byte[] f11418C = {69, 88, 73, 70};

    /* renamed from: b0.a$a, reason: collision with other inner class name */
    public class C0124a extends MediaDataSource {

        /* renamed from: X, reason: collision with root package name */
        public long f11458X;

        /* renamed from: Y, reason: collision with root package name */
        public final /* synthetic */ f f11459Y;

        public C0124a(f fVar) {
            this.f11459Y = fVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // android.media.MediaDataSource
        public final long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public final int readAt(long j8, byte[] bArr, int i8, int i9) {
            if (i9 == 0) {
                return 0;
            }
            if (j8 < 0) {
                return -1;
            }
            try {
                long j9 = this.f11458X;
                if (j9 != j8) {
                    if (j9 >= 0 && j8 >= j9 + this.f11459Y.available()) {
                        return -1;
                    }
                    this.f11459Y.b(j8);
                    this.f11458X = j8;
                }
                if (i9 > this.f11459Y.available()) {
                    i9 = this.f11459Y.available();
                }
                int read = this.f11459Y.read(bArr, i8, i9);
                if (read >= 0) {
                    this.f11458X += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f11458X = -1L;
            return -1;
        }
    }

    /* renamed from: b0.a$b */
    public static class b extends InputStream implements DataInput {

        /* renamed from: X, reason: collision with root package name */
        public final DataInputStream f11462X;

        /* renamed from: Y, reason: collision with root package name */
        public ByteOrder f11463Y;

        /* renamed from: Z, reason: collision with root package name */
        public int f11464Z;

        /* renamed from: x0, reason: collision with root package name */
        public byte[] f11465x0;

        /* renamed from: y0, reason: collision with root package name */
        public static final ByteOrder f11461y0 = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: x1, reason: collision with root package name */
        public static final ByteOrder f11460x1 = ByteOrder.BIG_ENDIAN;

        public b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public final void a(int i8) {
            int i9 = 0;
            while (i9 < i8) {
                DataInputStream dataInputStream = this.f11462X;
                int i10 = i8 - i9;
                int skip = (int) dataInputStream.skip(i10);
                if (skip <= 0) {
                    if (this.f11465x0 == null) {
                        this.f11465x0 = new byte[8192];
                    }
                    skip = dataInputStream.read(this.f11465x0, 0, Math.min(8192, i10));
                    if (skip == -1) {
                        throw new EOFException(H0.o("Reached EOF while skipping ", i8, " bytes."));
                    }
                }
                i9 += skip;
            }
            this.f11464Z += i9;
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.f11462X.available();
        }

        @Override // java.io.InputStream
        public final void mark(int i8) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public final int read() {
            this.f11464Z++;
            return this.f11462X.read();
        }

        @Override // java.io.DataInput
        public final boolean readBoolean() {
            this.f11464Z++;
            return this.f11462X.readBoolean();
        }

        @Override // java.io.DataInput
        public final byte readByte() {
            this.f11464Z++;
            int read = this.f11462X.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final char readChar() {
            this.f11464Z += 2;
            return this.f11462X.readChar();
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
            this.f11464Z += bArr.length;
            this.f11462X.readFully(bArr);
        }

        @Override // java.io.DataInput
        public final int readInt() {
            this.f11464Z += 4;
            DataInputStream dataInputStream = this.f11462X;
            int read = dataInputStream.read();
            int read2 = dataInputStream.read();
            int read3 = dataInputStream.read();
            int read4 = dataInputStream.read();
            if ((read | read2 | read3 | read4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f11463Y;
            if (byteOrder == f11461y0) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f11460x1) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            throw new IOException("Invalid byte order: " + this.f11463Y);
        }

        @Override // java.io.DataInput
        public final String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public final long readLong() {
            this.f11464Z += 8;
            DataInputStream dataInputStream = this.f11462X;
            int read = dataInputStream.read();
            int read2 = dataInputStream.read();
            int read3 = dataInputStream.read();
            int read4 = dataInputStream.read();
            int read5 = dataInputStream.read();
            int read6 = dataInputStream.read();
            int read7 = dataInputStream.read();
            int read8 = dataInputStream.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f11463Y;
            if (byteOrder == f11461y0) {
                return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f11460x1) {
                return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
            }
            throw new IOException("Invalid byte order: " + this.f11463Y);
        }

        @Override // java.io.DataInput
        public final short readShort() {
            this.f11464Z += 2;
            DataInputStream dataInputStream = this.f11462X;
            int read = dataInputStream.read();
            int read2 = dataInputStream.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f11463Y;
            if (byteOrder == f11461y0) {
                return (short) ((read2 << 8) + read);
            }
            if (byteOrder == f11460x1) {
                return (short) ((read << 8) + read2);
            }
            throw new IOException("Invalid byte order: " + this.f11463Y);
        }

        @Override // java.io.DataInput
        public final String readUTF() {
            this.f11464Z += 2;
            return this.f11462X.readUTF();
        }

        @Override // java.io.DataInput
        public final int readUnsignedByte() {
            this.f11464Z++;
            return this.f11462X.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public final int readUnsignedShort() {
            this.f11464Z += 2;
            DataInputStream dataInputStream = this.f11462X;
            int read = dataInputStream.read();
            int read2 = dataInputStream.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f11463Y;
            if (byteOrder == f11461y0) {
                return (read2 << 8) + read;
            }
            if (byteOrder == f11460x1) {
                return (read << 8) + read2;
            }
            throw new IOException("Invalid byte order: " + this.f11463Y);
        }

        @Override // java.io.InputStream
        public final void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public final int skipBytes(int i8) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public b(InputStream inputStream, ByteOrder byteOrder) {
            this.f11463Y = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f11462X = dataInputStream;
            dataInputStream.mark(0);
            this.f11464Z = 0;
            this.f11463Y = byteOrder;
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i8, int i9) {
            int read = this.f11462X.read(bArr, i8, i9);
            this.f11464Z += read;
            return read;
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr, int i8, int i9) {
            this.f11464Z += i9;
            this.f11462X.readFully(bArr, i8, i9);
        }

        public b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }
    }

    /* renamed from: b0.a$c */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f11466a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11467b;

        /* renamed from: c, reason: collision with root package name */
        public final long f11468c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f11469d;

        public c(long j8, byte[] bArr, int i8, int i9) {
            this.f11466a = i8;
            this.f11467b = i9;
            this.f11468c = j8;
            this.f11469d = bArr;
        }

        public static c a(String str) {
            byte[] bytes = str.concat("\u0000").getBytes(C1286a.f11429N);
            return new c(bytes, 2, bytes.length);
        }

        public static c b(long j8, ByteOrder byteOrder) {
            long[] jArr = {j8};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[C1286a.f11420E[4] * 1]);
            wrap.order(byteOrder);
            wrap.putInt((int) jArr[0]);
            return new c(wrap.array(), 4, 1);
        }

        public static c c(e eVar, ByteOrder byteOrder) {
            e[] eVarArr = {eVar};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[C1286a.f11420E[5] * 1]);
            wrap.order(byteOrder);
            e eVar2 = eVarArr[0];
            wrap.putInt((int) eVar2.f11474a);
            wrap.putInt((int) eVar2.f11475b);
            return new c(wrap.array(), 5, 1);
        }

        public static c d(int i8, ByteOrder byteOrder) {
            int[] iArr = {i8};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[C1286a.f11420E[3] * 1]);
            wrap.order(byteOrder);
            wrap.putShort((short) iArr[0]);
            return new c(wrap.array(), 3, 1);
        }

        public final double e(ByteOrder byteOrder) {
            Object h8 = h(byteOrder);
            if (h8 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (h8 instanceof String) {
                return Double.parseDouble((String) h8);
            }
            if (h8 instanceof long[]) {
                if (((long[]) h8).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (h8 instanceof int[]) {
                if (((int[]) h8).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (h8 instanceof double[]) {
                double[] dArr = (double[]) h8;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(h8 instanceof e[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            e[] eVarArr = (e[]) h8;
            if (eVarArr.length != 1) {
                throw new NumberFormatException("There are more than one component");
            }
            e eVar = eVarArr[0];
            double d8 = eVar.f11474a;
            double d9 = eVar.f11475b;
            Double.isNaN(d8);
            Double.isNaN(d9);
            Double.isNaN(d8);
            Double.isNaN(d9);
            Double.isNaN(d8);
            Double.isNaN(d9);
            return d8 / d9;
        }

        public final int f(ByteOrder byteOrder) {
            Object h8 = h(byteOrder);
            if (h8 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (h8 instanceof String) {
                return Integer.parseInt((String) h8);
            }
            if (h8 instanceof long[]) {
                long[] jArr = (long[]) h8;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(h8 instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) h8;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public final String g(ByteOrder byteOrder) {
            Object h8 = h(byteOrder);
            if (h8 == null) {
                return null;
            }
            if (h8 instanceof String) {
                return (String) h8;
            }
            StringBuilder sb = new StringBuilder();
            int i8 = 0;
            if (h8 instanceof long[]) {
                long[] jArr = (long[]) h8;
                while (i8 < jArr.length) {
                    sb.append(jArr[i8]);
                    i8++;
                    if (i8 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (h8 instanceof int[]) {
                int[] iArr = (int[]) h8;
                while (i8 < iArr.length) {
                    sb.append(iArr[i8]);
                    i8++;
                    if (i8 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (h8 instanceof double[]) {
                double[] dArr = (double[]) h8;
                while (i8 < dArr.length) {
                    sb.append(dArr[i8]);
                    i8++;
                    if (i8 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(h8 instanceof e[])) {
                return null;
            }
            e[] eVarArr = (e[]) h8;
            while (i8 < eVarArr.length) {
                sb.append(eVarArr[i8].f11474a);
                sb.append('/');
                sb.append(eVarArr[i8].f11475b);
                i8++;
                if (i8 != eVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:89|(3:91|(2:92|(1:101)(2:94|(2:97|98)(1:96)))|(1:100))|102|(2:104|(6:113|114|115|116|117|118)(3:106|(2:108|109)(2:111|112)|110))|122|115|116|117|118) */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x012a, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x012b, code lost:
        
            android.util.Log.e("ExifInterface", "IOException occurred while closing InputStream", r0);
         */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x0167: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:360), block:B:159:0x0167 */
        /* JADX WARN: Removed duplicated region for block: B:162:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r15v23, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r15v24, types: [java.io.Serializable, long[]] */
        /* JADX WARN: Type inference failed for: r15v25, types: [b0.a$e[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r15v26, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r15v27, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r15v28, types: [b0.a$e[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r15v29, types: [double[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r15v30, types: [double[], java.io.Serializable] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Serializable h(ByteOrder byteOrder) {
            b bVar;
            InputStream inputStream;
            byte b8;
            byte[] bArr;
            byte[] bArr2 = this.f11469d;
            InputStream inputStream2 = null;
            try {
                try {
                    bVar = new b(bArr2);
                    try {
                        bVar.f11463Y = byteOrder;
                        int i8 = this.f11466a;
                        int i9 = 0;
                        boolean z7 = true;
                        int i10 = this.f11467b;
                        switch (i8) {
                            case 1:
                            case 6:
                                if (bArr2.length != 1 || (b8 = bArr2[0]) < 0 || b8 > 1) {
                                    String str = new String(bArr2, C1286a.f11429N);
                                    try {
                                        bVar.close();
                                    } catch (IOException e8) {
                                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                                    }
                                    return str;
                                }
                                String str2 = new String(new char[]{(char) (b8 + 48)});
                                try {
                                    bVar.close();
                                } catch (IOException e9) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e9);
                                }
                                return str2;
                            case 2:
                            case 7:
                                if (i10 >= C1286a.f11421F.length) {
                                    int i11 = 0;
                                    while (true) {
                                        bArr = C1286a.f11421F;
                                        if (i11 < bArr.length) {
                                            if (bArr2[i11] != bArr[i11]) {
                                                z7 = false;
                                            } else {
                                                i11++;
                                            }
                                        }
                                    }
                                    if (z7) {
                                        i9 = bArr.length;
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                while (i9 < i10) {
                                    byte b9 = bArr2[i9];
                                    if (b9 == 0) {
                                        String sb2 = sb.toString();
                                        bVar.close();
                                        return sb2;
                                    }
                                    if (b9 >= 32) {
                                        sb.append((char) b9);
                                    } else {
                                        sb.append('?');
                                    }
                                    i9++;
                                }
                                String sb22 = sb.toString();
                                bVar.close();
                                return sb22;
                            case 3:
                                ?? r15 = new int[i10];
                                while (i9 < i10) {
                                    r15[i9] = bVar.readUnsignedShort();
                                    i9++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e10) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                                }
                                return r15;
                            case 4:
                                ?? r152 = new long[i10];
                                while (i9 < i10) {
                                    r152[i9] = bVar.readInt() & 4294967295L;
                                    i9++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e11) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                                }
                                return r152;
                            case 5:
                                ?? r153 = new e[i10];
                                while (i9 < i10) {
                                    r153[i9] = new e(bVar.readInt() & 4294967295L, bVar.readInt() & 4294967295L);
                                    i9++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e12) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                                }
                                return r153;
                            case 8:
                                ?? r154 = new int[i10];
                                while (i9 < i10) {
                                    r154[i9] = bVar.readShort();
                                    i9++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e13) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e13);
                                }
                                return r154;
                            case 9:
                                ?? r155 = new int[i10];
                                while (i9 < i10) {
                                    r155[i9] = bVar.readInt();
                                    i9++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e14) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                                }
                                return r155;
                            case 10:
                                ?? r156 = new e[i10];
                                while (i9 < i10) {
                                    r156[i9] = new e(bVar.readInt(), bVar.readInt());
                                    i9++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e15) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                                }
                                return r156;
                            case 11:
                                ?? r157 = new double[i10];
                                while (i9 < i10) {
                                    r157[i9] = bVar.readFloat();
                                    i9++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e16) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e16);
                                }
                                return r157;
                            case 12:
                                ?? r158 = new double[i10];
                                while (i9 < i10) {
                                    r158[i9] = bVar.readDouble();
                                    i9++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e17) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e17);
                                }
                                return r158;
                            default:
                                try {
                                    bVar.close();
                                } catch (IOException e18) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e18);
                                }
                                return null;
                        }
                    } catch (IOException e19) {
                        e = e19;
                        Log.w("ExifInterface", "IOException occurred during reading a value", e);
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException e20) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e20);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e21) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e21);
                        }
                    }
                    throw th;
                }
            } catch (IOException e22) {
                e = e22;
                bVar = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("(");
            sb.append(C1286a.f11419D[this.f11466a]);
            sb.append(", data length:");
            return D1.l(sb, this.f11469d.length, ")");
        }

        public c(byte[] bArr, int i8, int i9) {
            this(-1L, bArr, i8, i9);
        }
    }

    /* renamed from: b0.a$d */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f11470a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11471b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11472c;

        /* renamed from: d, reason: collision with root package name */
        public final int f11473d;

        public d(int i8, int i9, String str) {
            this.f11471b = str;
            this.f11470a = i8;
            this.f11472c = i9;
            this.f11473d = -1;
        }

        public d(String str, int i8, int i9, int i10) {
            this.f11471b = str;
            this.f11470a = i8;
            this.f11472c = i9;
            this.f11473d = i10;
        }
    }

    /* renamed from: b0.a$e */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final long f11474a;

        /* renamed from: b, reason: collision with root package name */
        public final long f11475b;

        public e(long j8, long j9) {
            if (j9 == 0) {
                this.f11474a = 0L;
                this.f11475b = 1L;
            } else {
                this.f11474a = j8;
                this.f11475b = j9;
            }
        }

        public final String toString() {
            return this.f11474a + "/" + this.f11475b;
        }
    }

    /* renamed from: b0.a$f */
    public static class f extends b {
        public f(InputStream inputStream) {
            super(inputStream);
            if (!inputStream.markSupported()) {
                throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            }
            this.f11462X.mark(Integer.MAX_VALUE);
        }

        public final void b(long j8) {
            int i8 = this.f11464Z;
            if (i8 > j8) {
                this.f11464Z = 0;
                this.f11462X.reset();
            } else {
                j8 -= i8;
            }
            a((int) j8);
        }

        public f(byte[] bArr) {
            super(bArr);
            this.f11462X.mark(Integer.MAX_VALUE);
        }
    }

    static {
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        f11419D = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        f11420E = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        f11421F = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        d[] dVarArr = {new d(254, 4, "NewSubfileType"), new d(255, 4, "SubfileType"), new d("ImageWidth", 256, 3, 4), new d("ImageLength", MoreOsConstants.BTN_1, 3, 4), new d(MoreOsConstants.BTN_2, 3, "BitsPerSample"), new d(MoreOsConstants.BTN_3, 3, "Compression"), new d(MoreOsConstants.BTN_6, 3, "PhotometricInterpretation"), new d(270, 2, "ImageDescription"), new d(271, 2, "Make"), new d(272, 2, "Model"), new d("StripOffsets", MoreOsConstants.BTN_RIGHT, 3, 4), new d(MoreOsConstants.BTN_MIDDLE, 3, "Orientation"), new d(MoreOsConstants.BTN_FORWARD, 3, "SamplesPerPixel"), new d("RowsPerStrip", MoreOsConstants.BTN_BACK, 3, 4), new d("StripByteCounts", MoreOsConstants.BTN_TASK, 3, 4), new d(282, 5, "XResolution"), new d(283, 5, "YResolution"), new d(284, 3, "PlanarConfiguration"), new d(MoreOsConstants.BTN_BASE3, 3, "ResolutionUnit"), new d(301, 3, "TransferFunction"), new d(305, 2, PngText.SOFTWARE), new d(MoreOsConstants.BTN_C, 2, "DateTime"), new d(MoreOsConstants.BTN_START, 2, "Artist"), new d(MoreOsConstants.BTN_THUMBR, 5, "WhitePoint"), new d(319, 5, "PrimaryChromaticities"), new d(MoreOsConstants.BTN_TOUCH, 4, "SubIFDPointer"), new d(MoreOsConstants.KEY_NUMERIC_1, 4, "JPEGInterchangeFormat"), new d(MoreOsConstants.KEY_NUMERIC_2, 4, "JPEGInterchangeFormatLength"), new d(MoreOsConstants.KEY_WPS_BUTTON, 5, "YCbCrCoefficients"), new d(MoreOsConstants.KEY_TOUCHPAD_TOGGLE, 3, "YCbCrSubSampling"), new d(MoreOsConstants.KEY_TOUCHPAD_ON, 3, "YCbCrPositioning"), new d(MoreOsConstants.KEY_TOUCHPAD_OFF, 5, "ReferenceBlackWhite"), new d(33432, 2, PngText.COPYRIGHT), new d(34665, 4, "ExifIFDPointer"), new d(34853, 4, "GPSInfoIFDPointer"), new d(4, 4, "SensorTopBorder"), new d(5, 4, "SensorLeftBorder"), new d(6, 4, "SensorBottomBorder"), new d(7, 4, "SensorRightBorder"), new d(23, 3, "ISO"), new d(46, 7, "JpgFromRaw"), new d(700, 1, "Xmp")};
        d[] dVarArr2 = {new d(33434, 5, "ExposureTime"), new d(33437, 5, "FNumber"), new d(34850, 3, "ExposureProgram"), new d(34852, 2, "SpectralSensitivity"), new d(34855, 3, "PhotographicSensitivity"), new d(34856, 7, "OECF"), new d(34864, 3, "SensitivityType"), new d(34865, 4, "StandardOutputSensitivity"), new d(34866, 4, "RecommendedExposureIndex"), new d(34867, 4, "ISOSpeed"), new d(34868, 4, "ISOSpeedLatitudeyyy"), new d(34869, 4, "ISOSpeedLatitudezzz"), new d(36864, 2, "ExifVersion"), new d(36867, 2, "DateTimeOriginal"), new d(36868, 2, "DateTimeDigitized"), new d(36880, 2, "OffsetTime"), new d(36881, 2, "OffsetTimeOriginal"), new d(36882, 2, "OffsetTimeDigitized"), new d(37121, 7, "ComponentsConfiguration"), new d(37122, 5, "CompressedBitsPerPixel"), new d(37377, 10, "ShutterSpeedValue"), new d(37378, 5, "ApertureValue"), new d(37379, 10, "BrightnessValue"), new d(37380, 10, "ExposureBiasValue"), new d(37381, 5, "MaxApertureValue"), new d(37382, 5, "SubjectDistance"), new d(37383, 3, "MeteringMode"), new d(37384, 3, "LightSource"), new d(37385, 3, "Flash"), new d(37386, 5, "FocalLength"), new d(37396, 3, "SubjectArea"), new d(37500, 7, "MakerNote"), new d(37510, 7, "UserComment"), new d(37520, 2, "SubSecTime"), new d(37521, 2, "SubSecTimeOriginal"), new d(37522, 2, "SubSecTimeDigitized"), new d(40960, 7, "FlashpixVersion"), new d(40961, 3, "ColorSpace"), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d(40964, 2, "RelatedSoundFile"), new d(40965, 4, "InteroperabilityIFDPointer"), new d(41483, 5, "FlashEnergy"), new d(41484, 7, "SpatialFrequencyResponse"), new d(41486, 5, "FocalPlaneXResolution"), new d(41487, 5, "FocalPlaneYResolution"), new d(41488, 3, "FocalPlaneResolutionUnit"), new d(41492, 3, "SubjectLocation"), new d(41493, 5, "ExposureIndex"), new d(41495, 3, "SensingMethod"), new d(41728, 7, "FileSource"), new d(41729, 7, "SceneType"), new d(41730, 7, "CFAPattern"), new d(41985, 3, "CustomRendered"), new d(41986, 3, "ExposureMode"), new d(41987, 3, "WhiteBalance"), new d(41988, 5, "DigitalZoomRatio"), new d(41989, 3, "FocalLengthIn35mmFilm"), new d(41990, 3, "SceneCaptureType"), new d(41991, 3, "GainControl"), new d(41992, 3, "Contrast"), new d(41993, 3, "Saturation"), new d(41994, 3, "Sharpness"), new d(41995, 7, "DeviceSettingDescription"), new d(41996, 3, "SubjectDistanceRange"), new d(42016, 2, "ImageUniqueID"), new d(42032, 2, "CameraOwnerName"), new d(42033, 2, "BodySerialNumber"), new d(42034, 5, "LensSpecification"), new d(42035, 2, "LensMake"), new d(42036, 2, "LensModel"), new d(42240, 5, "Gamma"), new d(50706, 1, "DNGVersion"), new d("DefaultCropSize", 50720, 3, 4)};
        d[] dVarArr3 = {new d(0, 1, "GPSVersionID"), new d(1, 2, "GPSLatitudeRef"), new d("GPSLatitude", 2, 5, 10), new d(3, 2, "GPSLongitudeRef"), new d("GPSLongitude", 4, 5, 10), new d(5, 1, "GPSAltitudeRef"), new d(6, 5, "GPSAltitude"), new d(7, 5, "GPSTimeStamp"), new d(8, 2, "GPSSatellites"), new d(9, 2, "GPSStatus"), new d(10, 2, "GPSMeasureMode"), new d(11, 5, "GPSDOP"), new d(12, 2, "GPSSpeedRef"), new d(13, 5, "GPSSpeed"), new d(14, 2, "GPSTrackRef"), new d(15, 5, "GPSTrack"), new d(16, 2, "GPSImgDirectionRef"), new d(17, 5, "GPSImgDirection"), new d(18, 2, "GPSMapDatum"), new d(19, 2, "GPSDestLatitudeRef"), new d(20, 5, "GPSDestLatitude"), new d(21, 2, "GPSDestLongitudeRef"), new d(22, 5, "GPSDestLongitude"), new d(23, 2, "GPSDestBearingRef"), new d(24, 5, "GPSDestBearing"), new d(25, 2, "GPSDestDistanceRef"), new d(26, 5, "GPSDestDistance"), new d(27, 7, "GPSProcessingMethod"), new d(28, 7, "GPSAreaInformation"), new d(29, 2, "GPSDateStamp"), new d(30, 3, "GPSDifferential"), new d(31, 5, "GPSHPositioningError")};
        d[] dVarArr4 = {new d(1, 2, "InteroperabilityIndex")};
        d[] dVarArr5 = {new d(254, 4, "NewSubfileType"), new d(255, 4, "SubfileType"), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", MoreOsConstants.BTN_1, 3, 4), new d(MoreOsConstants.BTN_2, 3, "BitsPerSample"), new d(MoreOsConstants.BTN_3, 3, "Compression"), new d(MoreOsConstants.BTN_6, 3, "PhotometricInterpretation"), new d(270, 2, "ImageDescription"), new d(271, 2, "Make"), new d(272, 2, "Model"), new d("StripOffsets", MoreOsConstants.BTN_RIGHT, 3, 4), new d(MoreOsConstants.BTN_MIDDLE, 3, "ThumbnailOrientation"), new d(MoreOsConstants.BTN_FORWARD, 3, "SamplesPerPixel"), new d("RowsPerStrip", MoreOsConstants.BTN_BACK, 3, 4), new d("StripByteCounts", MoreOsConstants.BTN_TASK, 3, 4), new d(282, 5, "XResolution"), new d(283, 5, "YResolution"), new d(284, 3, "PlanarConfiguration"), new d(MoreOsConstants.BTN_BASE3, 3, "ResolutionUnit"), new d(301, 3, "TransferFunction"), new d(305, 2, PngText.SOFTWARE), new d(MoreOsConstants.BTN_C, 2, "DateTime"), new d(MoreOsConstants.BTN_START, 2, "Artist"), new d(MoreOsConstants.BTN_THUMBR, 5, "WhitePoint"), new d(319, 5, "PrimaryChromaticities"), new d(MoreOsConstants.BTN_TOUCH, 4, "SubIFDPointer"), new d(MoreOsConstants.KEY_NUMERIC_1, 4, "JPEGInterchangeFormat"), new d(MoreOsConstants.KEY_NUMERIC_2, 4, "JPEGInterchangeFormatLength"), new d(MoreOsConstants.KEY_WPS_BUTTON, 5, "YCbCrCoefficients"), new d(MoreOsConstants.KEY_TOUCHPAD_TOGGLE, 3, "YCbCrSubSampling"), new d(MoreOsConstants.KEY_TOUCHPAD_ON, 3, "YCbCrPositioning"), new d(MoreOsConstants.KEY_TOUCHPAD_OFF, 5, "ReferenceBlackWhite"), new d(33432, 2, PngText.COPYRIGHT), new d(34665, 4, "ExifIFDPointer"), new d(34853, 4, "GPSInfoIFDPointer"), new d(50706, 1, "DNGVersion"), new d("DefaultCropSize", 50720, 3, 4)};
        f11422G = new d(MoreOsConstants.BTN_RIGHT, 3, "StripOffsets");
        f11423H = new d[][]{dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, new d[]{new d(256, 7, "ThumbnailImage"), new d(8224, 4, "CameraSettingsIFDPointer"), new d(8256, 4, "ImageProcessingIFDPointer")}, new d[]{new d(MoreOsConstants.BTN_1, 4, "PreviewImageStart"), new d(MoreOsConstants.BTN_2, 4, "PreviewImageLength")}, new d[]{new d(4371, 3, "AspectFrame")}, new d[]{new d(55, 3, "ColorSpace")}};
        f11424I = new d[]{new d(MoreOsConstants.BTN_TOUCH, 4, "SubIFDPointer"), new d(34665, 4, "ExifIFDPointer"), new d(34853, 4, "GPSInfoIFDPointer"), new d(40965, 4, "InteroperabilityIFDPointer"), new d(8224, 1, "CameraSettingsIFDPointer"), new d(8256, 1, "ImageProcessingIFDPointer")};
        f11425J = new HashMap[10];
        f11426K = new HashMap[10];
        f11427L = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f11428M = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        f11429N = forName;
        f11430O = "Exif\u0000\u0000".getBytes(forName);
        f11431P = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i8 = 0;
        while (true) {
            d[][] dVarArr6 = f11423H;
            if (i8 >= dVarArr6.length) {
                HashMap<Integer, Integer> hashMap = f11428M;
                d[] dVarArr7 = f11424I;
                hashMap.put(Integer.valueOf(dVarArr7[0].f11470a), 5);
                hashMap.put(Integer.valueOf(dVarArr7[1].f11470a), 1);
                hashMap.put(Integer.valueOf(dVarArr7[2].f11470a), 2);
                hashMap.put(Integer.valueOf(dVarArr7[3].f11470a), 3);
                hashMap.put(Integer.valueOf(dVarArr7[4].f11470a), 7);
                hashMap.put(Integer.valueOf(dVarArr7[5].f11470a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f11425J[i8] = new HashMap<>();
            f11426K[i8] = new HashMap<>();
            for (d dVar : dVarArr6[i8]) {
                f11425J[i8].put(Integer.valueOf(dVar.f11470a), dVar);
                f11426K[i8].put(dVar.f11471b, dVar);
            }
            i8++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C1286a(InputStream inputStream) {
        int i8;
        boolean z7;
        d[][] dVarArr = f11423H;
        this.f11450d = new HashMap[dVarArr.length];
        this.f11451e = new HashSet(dVarArr.length);
        this.f11452f = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new NullPointerException("inputStream cannot be null");
        }
        boolean z8 = inputStream instanceof AssetManager.AssetInputStream;
        FileDescriptor fileDescriptor = null;
        boolean z9 = f11432l;
        if (z8) {
            this.f11448b = (AssetManager.AssetInputStream) inputStream;
        } else {
            if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                FileDescriptor fd = fileInputStream.getFD();
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        i8 = OsConstants.SEEK_CUR;
                        C1287b.a.c(fd, 0L, i8);
                        z7 = true;
                    } catch (Exception unused) {
                        if (z9) {
                            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                        }
                    }
                    if (z7) {
                        this.f11448b = null;
                        fileDescriptor = fileInputStream.getFD();
                    }
                }
                z7 = false;
                if (z7) {
                }
            }
            this.f11448b = null;
        }
        this.f11447a = fileDescriptor;
        for (int i9 = 0; i9 < dVarArr.length; i9++) {
            try {
                try {
                    this.f11450d[i9] = new HashMap<>();
                } finally {
                    a();
                    if (z9) {
                        q();
                    }
                }
            } catch (IOException | UnsupportedOperationException e8) {
                if (z9) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e8);
                }
                if (!z9) {
                    return;
                }
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        int g8 = g(bufferedInputStream);
        this.f11449c = g8;
        if ((g8 == 4 || g8 == 9 || g8 == 13 || g8 == 14) ? false : true) {
            f fVar = new f(bufferedInputStream);
            int i10 = this.f11449c;
            if (i10 == 12) {
                e(fVar);
            } else if (i10 == 7) {
                h(fVar);
            } else if (i10 == 10) {
                l(fVar);
            } else {
                k(fVar);
            }
            fVar.b(this.f11454h);
            v(fVar);
        } else {
            b bVar = new b(bufferedInputStream);
            int i11 = this.f11449c;
            if (i11 == 4) {
                f(bVar, 0, 0);
            } else if (i11 == 13) {
                i(bVar);
            } else if (i11 == 9) {
                j(bVar);
            } else if (i11 == 14) {
                m(bVar);
            }
        }
        a();
        if (!z9) {
        }
    }

    public static double b(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            double parseDouble = Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim());
            String[] split3 = split[1].split("/", -1);
            double parseDouble2 = Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim());
            String[] split4 = split[2].split("/", -1);
            double parseDouble3 = ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d) + (parseDouble2 / 60.0d) + parseDouble;
            if (!str2.equals("S") && !str2.equals("W")) {
                if (!str2.equals("N") && !str2.equals("E")) {
                    throw new IllegalArgumentException();
                }
                return parseDouble3;
            }
            return -parseDouble3;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    public static ByteOrder r(b bVar) {
        short readShort = bVar.readShort();
        boolean z7 = f11432l;
        if (readShort == 18761) {
            if (z7) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort != 19789) {
            throw new IOException(g.f(readShort, new StringBuilder("Invalid byte order: ")));
        }
        if (z7) {
            Log.d("ExifInterface", "readExifSegment: Byte Align MM");
        }
        return ByteOrder.BIG_ENDIAN;
    }

    public final void a() {
        String c8 = c("DateTimeOriginal");
        HashMap<String, c>[] hashMapArr = this.f11450d;
        if (c8 != null && c("DateTime") == null) {
            hashMapArr[0].put("DateTime", c.a(c8));
        }
        if (c("ImageWidth") == null) {
            hashMapArr[0].put("ImageWidth", c.b(0L, this.f11452f));
        }
        if (c("ImageLength") == null) {
            hashMapArr[0].put("ImageLength", c.b(0L, this.f11452f));
        }
        if (c("Orientation") == null) {
            hashMapArr[0].put("Orientation", c.b(0L, this.f11452f));
        }
        if (c("LightSource") == null) {
            hashMapArr[1].put("LightSource", c.b(0L, this.f11452f));
        }
    }

    public final String c(String str) {
        String str2;
        c d8 = d(str);
        if (d8 != null) {
            if (!f11427L.contains(str)) {
                return d8.g(this.f11452f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i8 = d8.f11466a;
                if (i8 == 5 || i8 == 10) {
                    e[] eVarArr = (e[]) d8.h(this.f11452f);
                    if (eVarArr != null && eVarArr.length == 3) {
                        e eVar = eVarArr[0];
                        e eVar2 = eVarArr[1];
                        e eVar3 = eVarArr[2];
                        return String.format("%02d:%02d:%02d", Integer.valueOf((int) (eVar.f11474a / eVar.f11475b)), Integer.valueOf((int) (eVar2.f11474a / eVar2.f11475b)), Integer.valueOf((int) (eVar3.f11474a / eVar3.f11475b)));
                    }
                    str2 = "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr);
                } else {
                    str2 = g.g("GPS Timestamp format is not rational. format=", i8);
                }
                Log.w("ExifInterface", str2);
                return null;
            }
            try {
                return Double.toString(d8.e(this.f11452f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final c d(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            if (f11432l) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i8 = 0; i8 < f11423H.length; i8++) {
            c cVar = this.f11450d[i8].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(f fVar) {
        String str;
        String str2;
        String str3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                C1287b.C0125b.a(mediaMetadataRetriever, new C0124a(fVar));
                String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(extractMetadata3)) {
                    str = mediaMetadataRetriever.extractMetadata(29);
                    str2 = mediaMetadataRetriever.extractMetadata(30);
                    str3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(extractMetadata4)) {
                    str = mediaMetadataRetriever.extractMetadata(18);
                    str2 = mediaMetadataRetriever.extractMetadata(19);
                    str3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                }
                HashMap<String, c>[] hashMapArr = this.f11450d;
                if (str != null) {
                    hashMapArr[0].put("ImageWidth", c.d(Integer.parseInt(str), this.f11452f));
                }
                if (str2 != null) {
                    hashMapArr[0].put("ImageLength", c.d(Integer.parseInt(str2), this.f11452f));
                }
                if (str3 != null) {
                    int parseInt = Integer.parseInt(str3);
                    hashMapArr[0].put("Orientation", c.d(parseInt != 90 ? parseInt != 180 ? parseInt != 270 ? 1 : 8 : 3 : 6, this.f11452f));
                }
                if (extractMetadata != null && extractMetadata2 != null) {
                    int parseInt2 = Integer.parseInt(extractMetadata);
                    int parseInt3 = Integer.parseInt(extractMetadata2);
                    if (parseInt3 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    fVar.b(parseInt2);
                    byte[] bArr = new byte[6];
                    if (fVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i8 = parseInt2 + 6;
                    int i9 = parseInt3 - 6;
                    if (!Arrays.equals(bArr, f11430O)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i9];
                    if (fVar.read(bArr2) != i9) {
                        throw new IOException("Can't read exif");
                    }
                    this.f11454h = i8;
                    s(bArr2, 0);
                }
                if (f11432l) {
                    Log.d("ExifInterface", "Heif meta: " + str + "x" + str2 + ", rotation " + str3);
                }
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x019d, code lost:
    
        r21.f11463Y = r20.f11452f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01a1, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0189 A[LOOP:0: B:9:0x0034->B:32:0x0189, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ae A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(b bVar, int i8, int i9) {
        boolean z7;
        boolean z8;
        boolean z9 = f11432l;
        if (z9) {
            Log.d("ExifInterface", "getJpegAttributes starting with: " + bVar);
        }
        bVar.f11463Y = ByteOrder.BIG_ENDIAN;
        byte readByte = bVar.readByte();
        byte b8 = -1;
        if (readByte != -1) {
            throw new IOException(g.f(readByte & 255, new StringBuilder("Invalid marker: ")));
        }
        if (bVar.readByte() != -40) {
            throw new IOException(g.f(readByte & 255, new StringBuilder("Invalid marker: ")));
        }
        int i10 = 2;
        int i11 = 2;
        while (true) {
            byte readByte2 = bVar.readByte();
            if (readByte2 != b8) {
                throw new IOException(g.f(readByte2 & 255, new StringBuilder("Invalid marker:")));
            }
            int i12 = i11 + 1;
            byte readByte3 = bVar.readByte();
            if (z9) {
                Log.d("ExifInterface", "Found JPEG segment indicator: " + Integer.toHexString(readByte3 & 255));
            }
            int i13 = i12 + 1;
            if (readByte3 != -39 && readByte3 != -38) {
                int readUnsignedShort = bVar.readUnsignedShort() - i10;
                int i14 = i13 + i10;
                if (z9) {
                    Log.d("ExifInterface", "JPEG segment: " + Integer.toHexString(readByte3 & 255) + " (length: " + (readUnsignedShort + 2) + ")");
                }
                if (readUnsignedShort < 0) {
                    throw new IOException("Invalid length");
                }
                HashMap<String, c>[] hashMapArr = this.f11450d;
                if (readByte3 == -31) {
                    byte[] bArr = new byte[readUnsignedShort];
                    bVar.readFully(bArr);
                    int i15 = i14 + readUnsignedShort;
                    byte[] bArr2 = f11430O;
                    if (bArr2 != null && readUnsignedShort >= bArr2.length) {
                        for (int i16 = 0; i16 < bArr2.length; i16++) {
                            if (bArr[i16] == bArr2[i16]) {
                            }
                        }
                        z7 = true;
                        if (z7) {
                            byte[] bArr3 = f11431P;
                            if (bArr3 != null && readUnsignedShort >= bArr3.length) {
                                for (int i17 = 0; i17 < bArr3.length; i17++) {
                                    if (bArr[i17] == bArr3[i17]) {
                                    }
                                }
                                z8 = true;
                                if (z8) {
                                    int length = bArr3.length + i14;
                                    byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr3.length, readUnsignedShort);
                                    if (c("Xmp") == null) {
                                        hashMapArr[0].put("Xmp", new c(length, copyOfRange, 1, copyOfRange.length));
                                    }
                                }
                            }
                            z8 = false;
                            if (z8) {
                            }
                        } else {
                            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr2.length, readUnsignedShort);
                            this.f11454h = i8 + i14 + bArr2.length;
                            s(copyOfRange2, i9);
                            v(new b(copyOfRange2));
                        }
                        i14 = i15;
                    }
                    z7 = false;
                    if (z7) {
                    }
                    i14 = i15;
                } else if (readByte3 != -2) {
                    switch (readByte3) {
                        default:
                            switch (readByte3) {
                                default:
                                    switch (readByte3) {
                                        default:
                                            switch (readByte3) {
                                            }
                                        case -55:
                                        case -54:
                                        case -53:
                                            bVar.a(1);
                                            hashMapArr[i9].put(i9 != 4 ? "ImageLength" : "ThumbnailImageLength", c.b(bVar.readUnsignedShort(), this.f11452f));
                                            hashMapArr[i9].put(i9 != 4 ? "ImageWidth" : "ThumbnailImageWidth", c.b(bVar.readUnsignedShort(), this.f11452f));
                                            readUnsignedShort -= 5;
                                            break;
                                    }
                                case -59:
                                case -58:
                                case -57:
                                    break;
                            }
                        case -64:
                        case -63:
                        case -62:
                        case -61:
                            break;
                    }
                    if (readUnsignedShort >= 0) {
                        throw new IOException("Invalid length");
                    }
                    bVar.a(readUnsignedShort);
                    i11 = i14 + readUnsignedShort;
                    i10 = 2;
                    b8 = -1;
                } else {
                    byte[] bArr4 = new byte[readUnsignedShort];
                    if (bVar.read(bArr4) != readUnsignedShort) {
                        throw new IOException("Invalid exif");
                    }
                    if (c("UserComment") == null) {
                        hashMapArr[1].put("UserComment", c.a(new String(bArr4, f11429N)));
                    }
                }
                readUnsignedShort = 0;
                if (readUnsignedShort >= 0) {
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:162:0x00ce, code lost:
    
        if (r8 != null) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0111 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0113 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0147 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int g(BufferedInputStream bufferedInputStream) {
        boolean z7;
        boolean z8;
        b bVar;
        b bVar2;
        boolean z9;
        b bVar3;
        b bVar4;
        boolean z10;
        b bVar5;
        b bVar6;
        boolean z11;
        boolean z12;
        boolean z13;
        long j8;
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i8 = 0;
        while (true) {
            byte[] bArr2 = f11437q;
            if (i8 >= bArr2.length) {
                z7 = true;
                break;
            }
            if (bArr[i8] != bArr2[i8]) {
                z7 = false;
                break;
            }
            i8++;
        }
        if (z7) {
            return 4;
        }
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int i9 = 0;
        while (true) {
            if (i9 >= bytes.length) {
                z8 = true;
                break;
            }
            if (bArr[i9] != bytes[i9]) {
                z8 = false;
                break;
            }
            i9++;
        }
        if (z8) {
            return 9;
        }
        try {
            bVar2 = new b(bArr);
            try {
                long readInt = bVar2.readInt();
                byte[] bArr3 = new byte[4];
                bVar2.read(bArr3);
                if (Arrays.equals(bArr3, f11438r)) {
                    if (readInt == 1) {
                        readInt = bVar2.readLong();
                        j8 = 16;
                        if (readInt < 16) {
                        }
                    } else {
                        j8 = 8;
                    }
                    long j9 = 5000;
                    if (readInt > j9) {
                        readInt = j9;
                    }
                    long j10 = readInt - j8;
                    if (j10 >= 8) {
                        byte[] bArr4 = new byte[4];
                        boolean z14 = false;
                        boolean z15 = false;
                        for (long j11 = 0; j11 < j10 / 4 && bVar2.read(bArr4) == 4; j11++) {
                            if (j11 != 1) {
                                if (Arrays.equals(bArr4, f11439s)) {
                                    z14 = true;
                                } else if (Arrays.equals(bArr4, f11440t)) {
                                    z15 = true;
                                }
                                if (z14 && z15) {
                                    bVar2.close();
                                    z9 = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e8) {
                e = e8;
                try {
                    if (f11432l) {
                        Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
                    }
                } catch (Throwable th) {
                    th = th;
                    bVar = bVar2;
                    bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (bVar2 != null) {
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            bVar2 = null;
        } catch (Throwable th3) {
            th = th3;
            bVar = null;
            bVar2 = bVar;
            if (bVar2 != null) {
            }
            throw th;
        }
        bVar2.close();
        z9 = false;
        if (z9) {
            return 12;
        }
        try {
            bVar4 = new b(bArr);
            try {
                ByteOrder r8 = r(bVar4);
                this.f11452f = r8;
                bVar4.f11463Y = r8;
                short readShort = bVar4.readShort();
                z10 = readShort == 20306 || readShort == 21330;
                bVar4.close();
            } catch (Exception unused) {
                if (bVar4 != null) {
                    bVar4.close();
                }
                z10 = false;
                if (!z10) {
                }
            } catch (Throwable th4) {
                th = th4;
                bVar3 = bVar4;
                if (bVar3 != null) {
                    bVar3.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
            bVar4 = null;
        } catch (Throwable th5) {
            th = th5;
            bVar3 = null;
        }
        if (!z10) {
            return 7;
        }
        try {
            b bVar7 = new b(bArr);
            try {
                ByteOrder r9 = r(bVar7);
                this.f11452f = r9;
                bVar7.f11463Y = r9;
                z11 = bVar7.readShort() == 85;
                bVar7.close();
            } catch (Exception unused3) {
                bVar6 = bVar7;
                if (bVar6 != null) {
                    bVar6.close();
                }
                z11 = false;
                if (!z11) {
                }
            } catch (Throwable th6) {
                th = th6;
                bVar5 = bVar7;
                if (bVar5 != null) {
                    bVar5.close();
                }
                throw th;
            }
        } catch (Exception unused4) {
            bVar6 = null;
        } catch (Throwable th7) {
            th = th7;
            bVar5 = null;
        }
        if (!z11) {
            return 10;
        }
        int i10 = 0;
        while (true) {
            byte[] bArr5 = f11443w;
            if (i10 >= bArr5.length) {
                z12 = true;
                break;
            }
            if (bArr[i10] != bArr5[i10]) {
                z12 = false;
                break;
            }
            i10++;
        }
        if (z12) {
            return 13;
        }
        int i11 = 0;
        while (true) {
            byte[] bArr6 = f11416A;
            if (i11 >= bArr6.length) {
                int i12 = 0;
                while (true) {
                    byte[] bArr7 = f11417B;
                    if (i12 >= bArr7.length) {
                        z13 = true;
                        break;
                    }
                    if (bArr[bArr6.length + i12 + 4] != bArr7[i12]) {
                        break;
                    }
                    i12++;
                }
            } else {
                if (bArr[i11] != bArr6[i11]) {
                    break;
                }
                i11++;
            }
        }
        z13 = false;
        return z13 ? 14 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(f fVar) {
        c cVar;
        c cVar2;
        c cVar3;
        int i8;
        int i9;
        long j8;
        k(fVar);
        HashMap<String, c>[] hashMapArr = this.f11450d;
        c cVar4 = hashMapArr[1].get("MakerNote");
        if (cVar4 == null) {
            return;
        }
        f fVar2 = new f(cVar4.f11469d);
        fVar2.f11463Y = this.f11452f;
        byte[] bArr = f11441u;
        byte[] bArr2 = new byte[bArr.length];
        fVar2.readFully(bArr2);
        fVar2.b(0L);
        byte[] bArr3 = f11442v;
        byte[] bArr4 = new byte[bArr3.length];
        fVar2.readFully(bArr4);
        if (!Arrays.equals(bArr2, bArr)) {
            j8 = Arrays.equals(bArr4, bArr3) ? 12L : 8L;
            t(fVar2, 6);
            cVar = hashMapArr[7].get("PreviewImageStart");
            cVar2 = hashMapArr[7].get("PreviewImageLength");
            if (cVar != null && cVar2 != null) {
                hashMapArr[5].put("JPEGInterchangeFormat", cVar);
                hashMapArr[5].put("JPEGInterchangeFormatLength", cVar2);
            }
            cVar3 = hashMapArr[8].get("AspectFrame");
            if (cVar3 == null) {
                int[] iArr = (int[]) cVar3.h(this.f11452f);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i10 = iArr[2];
                int i11 = iArr[0];
                if (i10 <= i11 || (i8 = iArr[3]) <= (i9 = iArr[1])) {
                    return;
                }
                int i12 = (i10 - i11) + 1;
                int i13 = (i8 - i9) + 1;
                if (i12 < i13) {
                    int i14 = i12 + i13;
                    i13 = i14 - i13;
                    i12 = i14 - i13;
                }
                c d8 = c.d(i12, this.f11452f);
                c d9 = c.d(i13, this.f11452f);
                hashMapArr[0].put("ImageWidth", d8);
                hashMapArr[0].put("ImageLength", d9);
                return;
            }
            return;
        }
        fVar2.b(j8);
        t(fVar2, 6);
        cVar = hashMapArr[7].get("PreviewImageStart");
        cVar2 = hashMapArr[7].get("PreviewImageLength");
        if (cVar != null) {
            hashMapArr[5].put("JPEGInterchangeFormat", cVar);
            hashMapArr[5].put("JPEGInterchangeFormatLength", cVar2);
        }
        cVar3 = hashMapArr[8].get("AspectFrame");
        if (cVar3 == null) {
        }
    }

    public final void i(b bVar) {
        if (f11432l) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.f11463Y = ByteOrder.BIG_ENDIAN;
        byte[] bArr = f11443w;
        bVar.a(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = bVar.readInt();
                int i8 = length + 4;
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i9 = i8 + 4;
                if (i9 == 16 && !Arrays.equals(bArr2, f11445y)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, f11446z)) {
                    return;
                }
                if (Arrays.equals(bArr2, f11444x)) {
                    byte[] bArr3 = new byte[readInt];
                    if (bVar.read(bArr3) != readInt) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + C1287b.a(bArr2));
                    }
                    int readInt2 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == readInt2) {
                        this.f11454h = i9;
                        s(bArr3, 0);
                        y();
                        v(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                }
                int i10 = readInt + 4;
                bVar.a(i10);
                length = i9 + i10;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void j(b bVar) {
        boolean z7 = f11432l;
        if (z7) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.a(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i8 = ByteBuffer.wrap(bArr).getInt();
        int i9 = ByteBuffer.wrap(bArr2).getInt();
        int i10 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i9];
        bVar.a(i8 - bVar.f11464Z);
        bVar.read(bArr4);
        f(new b(bArr4), i8, 5);
        bVar.a(i10 - bVar.f11464Z);
        bVar.f11463Y = ByteOrder.BIG_ENDIAN;
        int readInt = bVar.readInt();
        if (z7) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i11 = 0; i11 < readInt; i11++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f11422G.f11470a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                c d8 = c.d(readShort, this.f11452f);
                c d9 = c.d(readShort2, this.f11452f);
                HashMap<String, c>[] hashMapArr = this.f11450d;
                hashMapArr[0].put("ImageLength", d8);
                hashMapArr[0].put("ImageWidth", d9);
                if (z7) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            bVar.a(readUnsignedShort2);
        }
    }

    public final void k(f fVar) {
        p(fVar);
        t(fVar, 0);
        x(fVar, 0);
        x(fVar, 5);
        x(fVar, 4);
        y();
        if (this.f11449c == 8) {
            HashMap<String, c>[] hashMapArr = this.f11450d;
            c cVar = hashMapArr[1].get("MakerNote");
            if (cVar != null) {
                f fVar2 = new f(cVar.f11469d);
                fVar2.f11463Y = this.f11452f;
                fVar2.a(6);
                t(fVar2, 9);
                c cVar2 = hashMapArr[9].get("ColorSpace");
                if (cVar2 != null) {
                    hashMapArr[1].put("ColorSpace", cVar2);
                }
            }
        }
    }

    public final void l(f fVar) {
        if (f11432l) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + fVar);
        }
        k(fVar);
        HashMap<String, c>[] hashMapArr = this.f11450d;
        c cVar = hashMapArr[0].get("JpgFromRaw");
        if (cVar != null) {
            f(new b(cVar.f11469d), (int) cVar.f11468c, 5);
        }
        c cVar2 = hashMapArr[0].get("ISO");
        c cVar3 = hashMapArr[1].get("PhotographicSensitivity");
        if (cVar2 == null || cVar3 != null) {
            return;
        }
        hashMapArr[1].put("PhotographicSensitivity", cVar2);
    }

    public final void m(b bVar) {
        if (f11432l) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.f11463Y = ByteOrder.LITTLE_ENDIAN;
        bVar.a(f11416A.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = f11417B;
        bVar.a(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int readInt2 = bVar.readInt();
                int i8 = length + 4 + 4;
                if (Arrays.equals(f11418C, bArr2)) {
                    byte[] bArr3 = new byte[readInt2];
                    if (bVar.read(bArr3) == readInt2) {
                        this.f11454h = i8;
                        s(bArr3, 0);
                        v(new b(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + C1287b.a(bArr2));
                    }
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                length = i8 + readInt2;
                if (length == readInt) {
                    return;
                }
                if (length > readInt) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.a(readInt2);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void n(b bVar, HashMap hashMap) {
        c cVar = (c) hashMap.get("JPEGInterchangeFormat");
        c cVar2 = (c) hashMap.get("JPEGInterchangeFormatLength");
        if (cVar == null || cVar2 == null) {
            return;
        }
        int f8 = cVar.f(this.f11452f);
        int f9 = cVar2.f(this.f11452f);
        if (this.f11449c == 7) {
            f8 += this.f11455i;
        }
        if (f8 > 0 && f9 > 0 && this.f11448b == null && this.f11447a == null) {
            bVar.skip(f8);
            bVar.read(new byte[f9]);
        }
        if (f11432l) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + f8 + ", length: " + f9);
        }
    }

    public final boolean o(HashMap hashMap) {
        c cVar = (c) hashMap.get("ImageLength");
        c cVar2 = (c) hashMap.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.f(this.f11452f) <= 512 && cVar2.f(this.f11452f) <= 512;
    }

    public final void p(b bVar) {
        ByteOrder r8 = r(bVar);
        this.f11452f = r8;
        bVar.f11463Y = r8;
        int readUnsignedShort = bVar.readUnsignedShort();
        int i8 = this.f11449c;
        if (i8 != 7 && i8 != 10 && readUnsignedShort != 42) {
            throw new IOException(g.f(readUnsignedShort, new StringBuilder("Invalid start code: ")));
        }
        int readInt = bVar.readInt();
        if (readInt < 8) {
            throw new IOException(g.g("Invalid first Ifd offset: ", readInt));
        }
        int i9 = readInt - 8;
        if (i9 > 0) {
            bVar.a(i9);
        }
    }

    public final void q() {
        int i8 = 0;
        while (true) {
            HashMap<String, c>[] hashMapArr = this.f11450d;
            if (i8 >= hashMapArr.length) {
                return;
            }
            Log.d("ExifInterface", "The size of tag group[" + i8 + "]: " + hashMapArr[i8].size());
            for (Map.Entry<String, c> entry : hashMapArr[i8].entrySet()) {
                c value = entry.getValue();
                Log.d("ExifInterface", "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.g(this.f11452f) + "'");
            }
            i8++;
        }
    }

    public final void s(byte[] bArr, int i8) {
        f fVar = new f(bArr);
        p(fVar);
        t(fVar, i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0298  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t(f fVar, int i8) {
        int i9;
        HashMap<String, c>[] hashMapArr;
        StringBuilder sb;
        short s8;
        short s9;
        long j8;
        StringBuilder sb2;
        boolean z7;
        long j9;
        boolean z8;
        int i10;
        HashSet hashSet;
        String str;
        int i11;
        int i12;
        String str2;
        long j10;
        HashSet hashSet2;
        int readUnsignedShort;
        long j11;
        HashSet hashSet3;
        StringBuilder sb3;
        Integer valueOf = Integer.valueOf(fVar.f11464Z);
        HashSet hashSet4 = this.f11451e;
        hashSet4.add(valueOf);
        short readShort = fVar.readShort();
        String str3 = "ExifInterface";
        boolean z9 = f11432l;
        if (z9) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + ((int) readShort));
        }
        if (readShort <= 0) {
            return;
        }
        short s10 = 0;
        while (true) {
            i9 = 5;
            hashMapArr = this.f11450d;
            if (s10 >= readShort) {
                break;
            }
            int readUnsignedShort2 = fVar.readUnsignedShort();
            int readUnsignedShort3 = fVar.readUnsignedShort();
            int readInt = fVar.readInt();
            long j12 = fVar.f11464Z + 4;
            d dVar = f11425J[i8].get(Integer.valueOf(readUnsignedShort2));
            if (z9) {
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(i8);
                objArr[1] = Integer.valueOf(readUnsignedShort2);
                objArr[2] = dVar != null ? dVar.f11471b : null;
                objArr[3] = Integer.valueOf(readUnsignedShort3);
                objArr[4] = Integer.valueOf(readInt);
                Log.d(str3, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr));
            }
            if (dVar == null) {
                if (z9) {
                    Log.d(str3, "Skip the tag entry since tag number is not defined: " + readUnsignedShort2);
                }
                s8 = readShort;
                s9 = s10;
            } else {
                if (readUnsignedShort3 > 0) {
                    if (readUnsignedShort3 < f11420E.length) {
                        int i13 = dVar.f11472c;
                        s8 = readShort;
                        if (i13 == 7 || readUnsignedShort3 == 7 || i13 == readUnsignedShort3 || (i10 = dVar.f11473d) == readUnsignedShort3) {
                            s9 = s10;
                        } else {
                            s9 = s10;
                            if (((i13 != 4 && i10 != 4) || readUnsignedShort3 != 3) && (((i13 != 9 && i10 != 9) || readUnsignedShort3 != 8) && ((i13 != 12 && i10 != 12) || readUnsignedShort3 != 11))) {
                                z7 = false;
                                if (!z7) {
                                    if (readUnsignedShort3 == 7) {
                                        readUnsignedShort3 = i13;
                                    }
                                    j8 = j12;
                                    j9 = r9[readUnsignedShort3] * readInt;
                                    if (j9 < 0 || j9 > 2147483647L) {
                                        if (z9) {
                                            Log.d(str3, "Skip the tag entry since the number of components is invalid: " + readInt);
                                        }
                                        z8 = false;
                                        if (z8) {
                                        }
                                        fVar.b(j10);
                                        s10 = (short) (s9 + 1);
                                        str3 = str2;
                                        hashSet4 = hashSet2;
                                        readShort = s8;
                                    } else {
                                        z8 = true;
                                        if (z8) {
                                        }
                                        fVar.b(j10);
                                        s10 = (short) (s9 + 1);
                                        str3 = str2;
                                        hashSet4 = hashSet2;
                                        readShort = s8;
                                    }
                                } else if (z9) {
                                    sb2 = new StringBuilder("Skip the tag entry since data format (");
                                    sb2.append(f11419D[readUnsignedShort3]);
                                    sb2.append(") is unexpected for tag: ");
                                    sb2.append(dVar.f11471b);
                                    j8 = j12;
                                    Log.d(str3, sb2.toString());
                                    j9 = 0;
                                    z8 = false;
                                    if (z8) {
                                        if (j9 > 4) {
                                            int readInt2 = fVar.readInt();
                                            if (z9) {
                                                Log.d(str3, "seek to data offset: " + readInt2);
                                            }
                                            if (this.f11449c == 7) {
                                                if ("MakerNote".equals(dVar.f11471b)) {
                                                    this.f11455i = readInt2;
                                                } else if (i8 == 6 && "ThumbnailImage".equals(dVar.f11471b)) {
                                                    this.f11456j = readInt2;
                                                    this.f11457k = readInt;
                                                    c d8 = c.d(6, this.f11452f);
                                                    i11 = readUnsignedShort3;
                                                    i12 = readInt;
                                                    c b8 = c.b(this.f11456j, this.f11452f);
                                                    hashSet = hashSet4;
                                                    str = str3;
                                                    c b9 = c.b(this.f11457k, this.f11452f);
                                                    hashMapArr[4].put("Compression", d8);
                                                    hashMapArr[4].put("JPEGInterchangeFormat", b8);
                                                    hashMapArr[4].put("JPEGInterchangeFormatLength", b9);
                                                    fVar.b(readInt2);
                                                }
                                            }
                                            hashSet = hashSet4;
                                            str = str3;
                                            i11 = readUnsignedShort3;
                                            i12 = readInt;
                                            fVar.b(readInt2);
                                        } else {
                                            hashSet = hashSet4;
                                            str = str3;
                                            i11 = readUnsignedShort3;
                                            i12 = readInt;
                                        }
                                        Integer num = f11428M.get(Integer.valueOf(readUnsignedShort2));
                                        if (z9) {
                                            str2 = str;
                                            Log.d(str2, "nextIfdType: " + num + " byteCount: " + j9);
                                        } else {
                                            str2 = str;
                                        }
                                        if (num != null) {
                                            int i14 = i11;
                                            if (i14 != 3) {
                                                if (i14 == 4) {
                                                    j11 = fVar.readInt() & 4294967295L;
                                                } else if (i14 == 8) {
                                                    readUnsignedShort = fVar.readShort();
                                                } else if (i14 == 9 || i14 == 13) {
                                                    readUnsignedShort = fVar.readInt();
                                                } else {
                                                    j11 = -1;
                                                }
                                                if (z9) {
                                                    Log.d(str2, String.format("Offset: %d, tagName: %s", Long.valueOf(j11), dVar.f11471b));
                                                }
                                                if (j11 <= 0) {
                                                    hashSet3 = hashSet;
                                                    if (!hashSet3.contains(Integer.valueOf((int) j11))) {
                                                        fVar.b(j11);
                                                        t(fVar, num.intValue());
                                                    } else if (z9) {
                                                        sb3 = new StringBuilder("Skip jump into the IFD since it has already been read: IfdType ");
                                                        sb3.append(num);
                                                        sb3.append(" (at ");
                                                        sb3.append(j11);
                                                        sb3.append(")");
                                                        Log.d(str2, sb3.toString());
                                                    }
                                                    fVar.b(j8);
                                                    hashSet2 = hashSet3;
                                                } else {
                                                    hashSet3 = hashSet;
                                                    if (z9) {
                                                        sb3 = new StringBuilder("Skip jump into the IFD since its offset is invalid: ");
                                                        sb3.append(j11);
                                                        Log.d(str2, sb3.toString());
                                                    }
                                                    fVar.b(j8);
                                                    hashSet2 = hashSet3;
                                                }
                                            } else {
                                                readUnsignedShort = fVar.readUnsignedShort();
                                            }
                                            j11 = readUnsignedShort;
                                            if (z9) {
                                            }
                                            if (j11 <= 0) {
                                            }
                                        } else {
                                            j10 = j8;
                                            int i15 = fVar.f11464Z + this.f11454h;
                                            byte[] bArr = new byte[(int) j9];
                                            fVar.readFully(bArr);
                                            hashSet2 = hashSet;
                                            c cVar = new c(i15, bArr, i11, i12);
                                            hashMapArr[i8].put(dVar.f11471b, cVar);
                                            String str4 = dVar.f11471b;
                                            if ("DNGVersion".equals(str4)) {
                                                this.f11449c = 3;
                                            }
                                            if ((("Make".equals(str4) || "Model".equals(str4)) && cVar.g(this.f11452f).contains("PENTAX")) || ("Compression".equals(str4) && cVar.f(this.f11452f) == 65535)) {
                                                this.f11449c = 8;
                                            }
                                            if (fVar.f11464Z == j10) {
                                            }
                                        }
                                        s10 = (short) (s9 + 1);
                                        str3 = str2;
                                        hashSet4 = hashSet2;
                                        readShort = s8;
                                    } else {
                                        hashSet2 = hashSet4;
                                        str2 = str3;
                                        j10 = j8;
                                    }
                                    fVar.b(j10);
                                    s10 = (short) (s9 + 1);
                                    str3 = str2;
                                    hashSet4 = hashSet2;
                                    readShort = s8;
                                }
                            }
                        }
                        z7 = true;
                        if (!z7) {
                        }
                    }
                }
                s8 = readShort;
                s9 = s10;
                j8 = j12;
                if (z9) {
                    sb2 = new StringBuilder("Skip the tag entry since data format is invalid: ");
                    sb2.append(readUnsignedShort3);
                    Log.d(str3, sb2.toString());
                }
                j9 = 0;
                z8 = false;
                if (z8) {
                }
                fVar.b(j10);
                s10 = (short) (s9 + 1);
                str3 = str2;
                hashSet4 = hashSet2;
                readShort = s8;
            }
            j8 = j12;
            j9 = 0;
            z8 = false;
            if (z8) {
            }
            fVar.b(j10);
            s10 = (short) (s9 + 1);
            str3 = str2;
            hashSet4 = hashSet2;
            readShort = s8;
        }
        HashSet hashSet5 = hashSet4;
        String str5 = str3;
        int readInt3 = fVar.readInt();
        if (z9) {
            Log.d(str5, String.format("nextIfdOffset: %d", Integer.valueOf(readInt3)));
        }
        long j13 = readInt3;
        if (j13 > 0) {
            if (!hashSet5.contains(Integer.valueOf(readInt3))) {
                fVar.b(j13);
                if (hashMapArr[4].isEmpty()) {
                    i9 = 4;
                } else if (!hashMapArr[5].isEmpty()) {
                    return;
                }
                t(fVar, i9);
                return;
            }
            if (!z9) {
                return;
            } else {
                sb = new StringBuilder("Stop reading file since re-reading an IFD may cause an infinite loop: ");
            }
        } else if (!z9) {
            return;
        } else {
            sb = new StringBuilder("Stop reading file since a wrong offset may cause an infinite loop: ");
        }
        sb.append(readInt3);
        Log.d(str5, sb.toString());
    }

    public final void u(int i8, String str, String str2) {
        HashMap<String, c>[] hashMapArr = this.f11450d;
        if (hashMapArr[i8].isEmpty() || hashMapArr[i8].get(str) == null) {
            return;
        }
        HashMap<String, c> hashMap = hashMapArr[i8];
        hashMap.put(str2, hashMap.get(str));
        hashMapArr[i8].remove(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void v(b bVar) {
        boolean z7;
        String str;
        String str2;
        StringBuilder sb;
        c cVar;
        int f8;
        HashMap<String, c> hashMap = this.f11450d[4];
        c cVar2 = hashMap.get("Compression");
        if (cVar2 != null) {
            int f9 = cVar2.f(this.f11452f);
            if (f9 != 1) {
                if (f9 != 6) {
                    if (f9 != 7) {
                        return;
                    }
                }
            }
            c cVar3 = hashMap.get("BitsPerSample");
            if (cVar3 != null) {
                int[] iArr = (int[]) cVar3.h(this.f11452f);
                int[] iArr2 = f11435o;
                if (Arrays.equals(iArr2, iArr) || (this.f11449c == 3 && (cVar = hashMap.get("PhotometricInterpretation")) != null && (((f8 = cVar.f(this.f11452f)) == 1 && Arrays.equals(iArr, f11436p)) || (f8 == 6 && Arrays.equals(iArr, iArr2))))) {
                    z7 = true;
                    if (z7) {
                        return;
                    }
                    c cVar4 = hashMap.get("StripOffsets");
                    c cVar5 = hashMap.get("StripByteCounts");
                    if (cVar4 == null || cVar5 == null) {
                        return;
                    }
                    long[] b8 = C1287b.b(cVar4.h(this.f11452f));
                    long[] b9 = C1287b.b(cVar5.h(this.f11452f));
                    if (b8 == null || b8.length == 0) {
                        str = "stripOffsets should not be null or have zero length.";
                    } else if (b9 == null || b9.length == 0) {
                        str = "stripByteCounts should not be null or have zero length.";
                    } else {
                        if (b8.length == b9.length) {
                            long j8 = 0;
                            for (long j9 : b9) {
                                j8 += j9;
                            }
                            byte[] bArr = new byte[(int) j8];
                            this.f11453g = true;
                            int i8 = 0;
                            int i9 = 0;
                            for (int i10 = 0; i10 < b8.length; i10++) {
                                int i11 = (int) b8[i10];
                                int i12 = (int) b9[i10];
                                if (i10 < b8.length - 1 && i11 + i12 != b8[i10 + 1]) {
                                    this.f11453g = false;
                                }
                                int i13 = i11 - i8;
                                if (i13 < 0) {
                                    str2 = "Invalid strip offset value";
                                } else {
                                    long j10 = i13;
                                    if (bVar.skip(j10) != j10) {
                                        sb = new StringBuilder("Failed to skip ");
                                        sb.append(i13);
                                    } else {
                                        int i14 = i8 + i13;
                                        byte[] bArr2 = new byte[i12];
                                        if (bVar.read(bArr2) != i12) {
                                            sb = new StringBuilder("Failed to read ");
                                            sb.append(i12);
                                        } else {
                                            i8 = i14 + i12;
                                            System.arraycopy(bArr2, 0, bArr, i9, i12);
                                            i9 += i12;
                                        }
                                    }
                                    sb.append(" bytes.");
                                    str2 = sb.toString();
                                }
                                Log.d("ExifInterface", str2);
                                return;
                            }
                            if (this.f11453g) {
                                long j11 = b8[0];
                                return;
                            }
                            return;
                        }
                        str = "stripOffsets and stripByteCounts should have same length.";
                    }
                    Log.w("ExifInterface", str);
                    return;
                }
            }
            if (f11432l) {
                Log.d("ExifInterface", "Unsupported data type value");
            }
            z7 = false;
            if (z7) {
            }
        }
        n(bVar, hashMap);
    }

    public final void w(int i8, int i9) {
        String str;
        HashMap<String, c>[] hashMapArr = this.f11450d;
        boolean isEmpty = hashMapArr[i8].isEmpty();
        boolean z7 = f11432l;
        if (isEmpty || hashMapArr[i9].isEmpty()) {
            if (z7) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        c cVar = hashMapArr[i8].get("ImageLength");
        c cVar2 = hashMapArr[i8].get("ImageWidth");
        c cVar3 = hashMapArr[i9].get("ImageLength");
        c cVar4 = hashMapArr[i9].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            if (!z7) {
                return;
            } else {
                str = "First image does not contain valid size information";
            }
        } else {
            if (cVar3 != null && cVar4 != null) {
                int f8 = cVar.f(this.f11452f);
                int f9 = cVar2.f(this.f11452f);
                int f10 = cVar3.f(this.f11452f);
                int f11 = cVar4.f(this.f11452f);
                if (f8 >= f10 || f9 >= f11) {
                    return;
                }
                HashMap<String, c> hashMap = hashMapArr[i8];
                hashMapArr[i8] = hashMapArr[i9];
                hashMapArr[i9] = hashMap;
                return;
            }
            if (!z7) {
                return;
            } else {
                str = "Second image does not contain valid size information";
            }
        }
        Log.d("ExifInterface", str);
    }

    public final void x(f fVar, int i8) {
        StringBuilder sb;
        String arrays;
        c d8;
        c d9;
        HashMap<String, c>[] hashMapArr = this.f11450d;
        c cVar = hashMapArr[i8].get("DefaultCropSize");
        c cVar2 = hashMapArr[i8].get("SensorTopBorder");
        c cVar3 = hashMapArr[i8].get("SensorLeftBorder");
        c cVar4 = hashMapArr[i8].get("SensorBottomBorder");
        c cVar5 = hashMapArr[i8].get("SensorRightBorder");
        if (cVar != null) {
            if (cVar.f11466a == 5) {
                e[] eVarArr = (e[]) cVar.h(this.f11452f);
                if (eVarArr == null || eVarArr.length != 2) {
                    sb = new StringBuilder("Invalid crop size values. cropSize=");
                    arrays = Arrays.toString(eVarArr);
                    sb.append(arrays);
                    Log.w("ExifInterface", sb.toString());
                    return;
                }
                d8 = c.c(eVarArr[0], this.f11452f);
                d9 = c.c(eVarArr[1], this.f11452f);
                hashMapArr[i8].put("ImageWidth", d8);
                hashMapArr[i8].put("ImageLength", d9);
                return;
            }
            int[] iArr = (int[]) cVar.h(this.f11452f);
            if (iArr == null || iArr.length != 2) {
                sb = new StringBuilder("Invalid crop size values. cropSize=");
                arrays = Arrays.toString(iArr);
                sb.append(arrays);
                Log.w("ExifInterface", sb.toString());
                return;
            }
            d8 = c.d(iArr[0], this.f11452f);
            d9 = c.d(iArr[1], this.f11452f);
            hashMapArr[i8].put("ImageWidth", d8);
            hashMapArr[i8].put("ImageLength", d9);
            return;
        }
        if (cVar2 != null && cVar3 != null && cVar4 != null && cVar5 != null) {
            int f8 = cVar2.f(this.f11452f);
            int f9 = cVar4.f(this.f11452f);
            int f10 = cVar5.f(this.f11452f);
            int f11 = cVar3.f(this.f11452f);
            if (f9 <= f8 || f10 <= f11) {
                return;
            }
            c d10 = c.d(f9 - f8, this.f11452f);
            c d11 = c.d(f10 - f11, this.f11452f);
            hashMapArr[i8].put("ImageLength", d10);
            hashMapArr[i8].put("ImageWidth", d11);
            return;
        }
        c cVar6 = hashMapArr[i8].get("ImageLength");
        c cVar7 = hashMapArr[i8].get("ImageWidth");
        if (cVar6 == null || cVar7 == null) {
            c cVar8 = hashMapArr[i8].get("JPEGInterchangeFormat");
            c cVar9 = hashMapArr[i8].get("JPEGInterchangeFormatLength");
            if (cVar8 == null || cVar9 == null) {
                return;
            }
            int f12 = cVar8.f(this.f11452f);
            int f13 = cVar8.f(this.f11452f);
            fVar.b(f12);
            byte[] bArr = new byte[f13];
            fVar.read(bArr);
            f(new b(bArr), f12, i8);
        }
    }

    public final void y() {
        w(0, 5);
        w(0, 4);
        w(5, 4);
        HashMap<String, c>[] hashMapArr = this.f11450d;
        c cVar = hashMapArr[1].get("PixelXDimension");
        c cVar2 = hashMapArr[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            hashMapArr[0].put("ImageWidth", cVar);
            hashMapArr[0].put("ImageLength", cVar2);
        }
        if (hashMapArr[4].isEmpty() && o(hashMapArr[5])) {
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!o(hashMapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        u(0, "ThumbnailOrientation", "Orientation");
        u(0, "ThumbnailImageLength", "ImageLength");
        u(0, "ThumbnailImageWidth", "ImageWidth");
        u(5, "ThumbnailOrientation", "Orientation");
        u(5, "ThumbnailImageLength", "ImageLength");
        u(5, "ThumbnailImageWidth", "ImageWidth");
        u(4, "Orientation", "ThumbnailOrientation");
        u(4, "ImageLength", "ThumbnailImageLength");
        u(4, "ImageWidth", "ThumbnailImageWidth");
    }
}
