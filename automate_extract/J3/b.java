package J3;

import java.io.Serializable;
import java.util.Arrays;
import x3.C2434l;

/* loaded from: classes.dex */
public final class b extends Number implements Comparable<b> {

    /* renamed from: L1, reason: collision with root package name */
    public static final byte[] f4631L1;

    /* renamed from: M1, reason: collision with root package name */
    public static final int[] f4632M1;

    /* renamed from: Z, reason: collision with root package name */
    public static final b f4633Z = new b(0, C2434l.f23393d);

    /* renamed from: x0, reason: collision with root package name */
    public static final b f4634x0;

    /* renamed from: x1, reason: collision with root package name */
    public static final byte[] f4635x1;

    /* renamed from: y0, reason: collision with root package name */
    public static final b f4636y0;

    /* renamed from: y1, reason: collision with root package name */
    public static final short[] f4637y1;

    /* renamed from: X, reason: collision with root package name */
    public final int f4638X;

    /* renamed from: Y, reason: collision with root package name */
    public final int[] f4639Y;

    static {
        b bVar = new b(1, 1);
        f4634x0 = bVar;
        f4636y0 = new b(-1, bVar.f4639Y);
        f4635x1 = new byte[]{Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE};
        f4637y1 = new short[]{0, 0, 1024, 1624, 2048, 2378, 2648, 2875, 3072, 3247, 3402, 3543, 3672, 3790, 3899, 4001, 4096, 4186, 4271, 4350, 4426, 4498, 4567, 4633, 4696, 4756, 4814, 4870, 4923, 4975, 5025, 5074, 5120, 5166, 5210, 5253, 5295};
        f4631L1 = new byte[]{0, 0, 30, 19, 15, 13, 11, 11, 10, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5};
        f4632M1 = new int[]{0, 0, 1073741824, 1162261467, 1073741824, 1220703125, 362797056, 1977326743, 1073741824, 387420489, 1000000000, 214358881, 429981696, 815730721, 1475789056, 170859375, 268435456, 410338673, 612220032, 893871739, 1280000000, 1801088541, 113379904, 148035889, 191102976, 244140625, 308915776, 387420489, 481890304, 594823321, 729000000, 887503681, 1073741824, 1291467969, 1544804416, 1838265625, 60466176};
    }

    public b(int i8, int... iArr) {
        this.f4638X = i8;
        this.f4639Y = iArr;
    }

    public static int[] S(int i8, int[] iArr) {
        if (((-i8) & i8) == i8) {
            return W(Integer.numberOfTrailingZeros(i8), iArr);
        }
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int y7 = y(iArr2, iArr, i8, 0L);
        if (y7 == 0) {
            return iArr2;
        }
        int[] iArr3 = new int[length + 1];
        System.arraycopy(iArr2, 0, iArr3, 1, length);
        iArr3[0] = y7;
        return iArr3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f3, code lost:
    
        throw new java.lang.NumberFormatException("Illegal digit");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b U(int i8, int i9, int i10, CharSequence charSequence) {
        int i11;
        int i12;
        int i13;
        int i14 = i8;
        int i15 = i9;
        if (i10 < 2 || i10 > 36) {
            throw new NumberFormatException("Radix out of range");
        }
        if (i14 > i15) {
            throw new IndexOutOfBoundsException();
        }
        if (i14 == i15) {
            throw new NumberFormatException("Empty string");
        }
        char charAt = charSequence.charAt(i14);
        boolean z7 = '-' == charAt;
        if (z7 || '+' == charAt) {
            i14++;
        }
        int i16 = i14;
        while (i16 != i15) {
            if ('0' != charSequence.charAt(i16)) {
                boolean z8 = ((-i10) & i10) == i10;
                char c8 = 127;
                int i17 = -1;
                byte[] bArr = f4635x1;
                if (z8) {
                    int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i10);
                    int i18 = y4.j.f23551b;
                    int i19 = ((((i15 - i16) * numberOfLeadingZeros) + 32) - 1) / 32;
                    int[] iArr = new int[i19];
                    int i20 = i19;
                    loop1: while (true) {
                        int i21 = 0;
                        int i22 = 0;
                        while (i16 < i15) {
                            i15--;
                            char charAt2 = charSequence.charAt(i15);
                            if (charAt2 > 127 || (i13 = bArr[charAt2]) >= i10) {
                                break loop1;
                            }
                            i21 |= i13 << i22;
                            int i23 = i22 + numberOfLeadingZeros;
                            if (i23 < 32) {
                                i22 = i23;
                            } else {
                                i20--;
                                iArr[i20] = i21;
                                if (i23 == 32) {
                                    break;
                                }
                                i22 = i23 - 32;
                                i21 = i13 >>> (numberOfLeadingZeros - i22);
                            }
                        }
                        if (i21 != 0) {
                            i20--;
                            iArr[i20] = i21;
                        }
                        int i24 = z7 ? -1 : 1;
                        if (i20 != 0) {
                            iArr = Arrays.copyOfRange(iArr, i20, i19);
                        }
                        return new b(i24, iArr);
                    }
                    throw new NumberFormatException("Illegal digit");
                }
                int i25 = i15 - i16;
                int i26 = f4631L1[i10];
                int i27 = f4632M1[i10];
                int i28 = y4.j.f23551b;
                int i29 = (int) ((((((i25 * f4637y1[i10]) / 1024) + 1) + 32) - 1) / 32);
                int[] iArr2 = new int[i29];
                int i30 = i25 % i26;
                if (i30 == 0) {
                    i30 = i26;
                }
                int min = Math.min(i30, i25);
                int i31 = 0;
                while (true) {
                    min--;
                    if (min < 0) {
                        iArr2[i29 - 1] = i31;
                        int i32 = i26;
                        int i33 = 0;
                        while (i16 < i15) {
                            int i34 = i16 + 1;
                            char charAt3 = charSequence.charAt(i16);
                            if (charAt3 > c8 || (i11 = bArr[charAt3]) >= i10) {
                                throw new NumberFormatException("Illegal digit");
                            }
                            i33 = (i33 * i10) + i11;
                            i32 += i17;
                            if (i32 > 0) {
                                i16 = i34;
                            } else {
                                y(iArr2, iArr2, i27, i33);
                                i16 = i34;
                                i32 = i26;
                                i33 = 0;
                                c8 = 127;
                                i17 = -1;
                            }
                        }
                        int i35 = 0;
                        while (i35 < i29 && iArr2[i35] == 0) {
                            i35++;
                        }
                        int i36 = z7 ? -1 : 1;
                        if (i35 != 0) {
                            iArr2 = Arrays.copyOfRange(iArr2, i35, i29);
                        }
                        return new b(i36, iArr2);
                    }
                    int i37 = i16 + 1;
                    char charAt4 = charSequence.charAt(i16);
                    if (charAt4 > 127 || (i12 = bArr[charAt4]) >= i10) {
                        break;
                    }
                    i31 = (i31 * i10) + i12;
                    i16 = i37;
                }
            } else {
                i16++;
            }
        }
        if (i16 != i14) {
            return f4633Z;
        }
        throw new NumberFormatException("No digits");
    }

    public static b V(R3.c cVar) {
        int i8;
        int a8 = cVar.a();
        if (a8 == 0) {
            return f4633Z;
        }
        if (a8 < 0) {
            a8 = -a8;
            i8 = -1;
        } else {
            i8 = 1;
        }
        int[] iArr = new int[a8];
        for (int i9 = 0; i9 < a8; i9++) {
            iArr[i9] = cVar.readInt();
        }
        return new b(i8, iArr);
    }

    public static int[] W(int i8, int[] iArr) {
        int[] iArr2;
        int i9;
        int length = iArr.length;
        int i10 = i8 / 32;
        int i11 = i8 % 32;
        int i12 = 32 - i11;
        int i13 = 0;
        if (i11 == 0) {
            int[] iArr3 = new int[i10 + length];
            System.arraycopy(iArr, 0, iArr3, 0, length);
            return iArr3;
        }
        int i14 = iArr[0];
        int i15 = i14 >>> i12;
        int i16 = i10 + length;
        if (i15 != 0) {
            iArr2 = new int[i16 + 1];
            iArr2[0] = i15;
            i9 = 1;
        } else {
            iArr2 = new int[i16];
            i9 = 0;
        }
        int i17 = i14 << i11;
        while (true) {
            i13++;
            if (i13 >= length) {
                iArr2[i9] = i17;
                return iArr2;
            }
            int i18 = iArr[i13];
            iArr2[i9] = i17 | (i18 >>> i12);
            i17 = i18 << i11;
            i9++;
        }
    }

    public static int X(int i8, int[] iArr, int i9, int[] iArr2) {
        int i10 = i9 - i8;
        if (i10 <= 0) {
            return 0;
        }
        int i11 = i10 - 0;
        if ((iArr2[i8] >>> 1) == 0 && i11 - 1 == 0) {
            return i9;
        }
        int i12 = (i9 + 0) - 1;
        int i13 = iArr2[i12] >>> 1;
        int i14 = i12;
        int i15 = i9;
        while (true) {
            i14--;
            if (i14 < i8) {
                break;
            }
            int i16 = iArr2[i14];
            i9--;
            int i17 = i13 | (i16 << 31);
            iArr[i9] = i17;
            if (i17 != 0) {
                i15 = i9;
            }
            i13 = i16 >>> 1;
        }
        if (i13 == 0) {
            return i15;
        }
        int i18 = i9 - 1;
        iArr[i18] = i13;
        return i18;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        if (r0 == false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] Y(int i8, boolean z7, int[] iArr) {
        int i9;
        boolean z8;
        int[] iArr2;
        boolean z9;
        int length = iArr.length;
        int i10 = i8 / 32;
        b bVar = f4633Z;
        b bVar2 = f4634x0;
        if (i10 >= length) {
            return z7 ? bVar2.f4639Y : bVar.f4639Y;
        }
        int i11 = i8 % 32;
        int i12 = length - i10;
        int i13 = i12 - 1;
        if (z7) {
            z8 = true;
            if ((((1 << i11) - 1) & iArr[i13]) == 0) {
                int i14 = i13 + 1;
                while (true) {
                    if (i14 >= length) {
                        z9 = true;
                        break;
                    }
                    int i15 = i14 + 1;
                    if (iArr[i14] != 0) {
                        z9 = false;
                        break;
                    }
                    i14 = i15;
                }
            }
            i9 = (i11 == 0 && iArr[0] == -1) ? i12 + 1 : i12;
            if (i11 != 0) {
                iArr2 = new int[i9];
                System.arraycopy(iArr, 0, iArr2, i9 - i12, i12);
            } else {
                if ((iArr[0] >>> i11) == 0 && i9 - 1 == 0) {
                    return z8 ? bVar2.f4639Y : bVar.f4639Y;
                }
                int[] iArr3 = new int[i9];
                int i16 = iArr[i13] >>> i11;
                int i17 = 32 - i11;
                while (true) {
                    i13--;
                    if (i13 < 0) {
                        break;
                    }
                    int i18 = iArr[i13];
                    i9--;
                    iArr3[i9] = i16 | (i18 << i17);
                    i16 = i18 >>> i11;
                }
                if (i16 != 0) {
                    iArr3[i9 - 1] = i16;
                }
                iArr2 = iArr3;
            }
            if (z8) {
                f(iArr2, iArr2, bVar2.f4639Y);
            }
            return iArr2;
        }
        i9 = i12;
        z8 = false;
        if (i11 != 0) {
        }
        if (z8) {
        }
        return iArr2;
    }

    public static int Z(int i8, int i9, int i10, int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        int i12;
        int i13 = i9;
        int i14 = i13;
        int i15 = i14;
        int i16 = i11;
        long j8 = 0;
        do {
            i13--;
            i14--;
            i16--;
            j8 = (j8 >> 32) + ((iArr2[i14] & 4294967295L) - (4294967295L & iArr3[i16]));
            int i17 = (int) j8;
            iArr[i13] = i17;
            if (i17 != 0) {
                i12 = i10;
                i15 = i13;
            } else {
                i12 = i10;
            }
        } while (i12 < i16);
        boolean z7 = (j8 >> 32) != 0;
        while (z7 && i8 < i14) {
            i13--;
            i14--;
            int i18 = iArr2[i14] - 1;
            iArr[i13] = i18;
            boolean z8 = i18 == -1;
            if (i18 != 0) {
                i15 = i13;
            }
            z7 = z8;
        }
        while (i8 < i14) {
            i13--;
            i14--;
            int i19 = iArr2[i14];
            iArr[i13] = i19;
            if (i19 != 0) {
                i15 = i13;
            }
        }
        return i15;
    }

    public static b b0(double d8) {
        if (d8 == 0.0d) {
            return f4633Z;
        }
        if (!((Double.isInfinite(d8) || Double.isNaN(d8)) ? false : true)) {
            throw new NumberFormatException("Number not finite");
        }
        long doubleToLongBits = Double.doubleToLongBits(d8);
        int i8 = ((int) ((9218868437227405312L & doubleToLongBits) >>> 52)) - 1023;
        long j8 = (doubleToLongBits & 4503599627370495L) | 4503599627370496L;
        if (i8 < 0 || (i8 < 52 && (j8 & ((1 << (52 - i8)) - 1)) != 0)) {
            throw new NumberFormatException("Number not an integer");
        }
        int[] iArr = new int[(i8 / 32) + 1];
        int i9 = i8 % 32;
        if (i9 < 52) {
            int i10 = 52 - i9;
            iArr[0] = (int) (j8 >>> i10);
            long j9 = j8 << (64 - i10);
            int i11 = 1;
            while (j9 != 0) {
                iArr[i11] = (int) (j9 >>> 32);
                j9 <<= 32;
                i11++;
            }
        } else {
            iArr[0] = (int) (j8 << (i9 - 52));
        }
        return new b(d8 < 0.0d ? -1 : 1, iArr);
    }

    public static b c0(int i8, int i9, int i10) {
        return i9 != 0 ? new b(i8, i9, i10) : i10 != 0 ? new b(i8, i10) : f4633Z;
    }

    public static b d0(long j8) {
        int i8;
        if (j8 == 0) {
            return f4633Z;
        }
        if (j8 < 0) {
            j8 = -j8;
            i8 = -1;
        } else {
            i8 = 1;
        }
        int i9 = (int) (j8 >>> 32);
        return i9 == 0 ? new b(i8, (int) j8) : new b(i8, i9, (int) j8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        if (r0 <= 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        r0 = r0 - 1;
        r1 = r13[r0] + 1;
        r12[r0] = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        if (r1 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        if (r12 == r13) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
    
        if (r0 <= 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
    
        r0 = r0 - 1;
        r12[r0] = r13[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0028, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0024, code lost:
    
        if ((r4 >>> 32) != 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0027, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
    
        if (r1 == false) goto L22;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0033 -> B:6:0x0027). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean f(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr2.length;
        int length2 = iArr3.length;
        long j8 = 0;
        do {
            length--;
            length2--;
            j8 = (j8 >>> 32) + (iArr2[length] & 4294967295L) + (4294967295L & iArr3[length2]);
            iArr[length] = (int) j8;
        } while (length2 > 0);
    }

    public static b g(b bVar, b bVar2, boolean z7) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4 = bVar2.f4639Y;
        int[] iArr5 = bVar.f4639Y;
        int length = iArr5.length;
        int length2 = iArr4.length;
        int i8 = bVar2.f4638X;
        if (length == 0) {
            return (z7 || length2 == 0) ? bVar2 : new b(-i8, iArr4);
        }
        if (length2 == 0) {
            return bVar;
        }
        int i9 = bVar.f4638X;
        if ((i9 == i8) != z7) {
            int t8 = t(0, length, 0, length2, iArr5, iArr4);
            if (t8 == 0) {
                return f4633Z;
            }
            int i10 = i9 * t8;
            if (t8 > 0) {
                int length3 = iArr5.length;
                iArr = new int[length3];
                int Z7 = Z(0, iArr5.length, 0, iArr4.length, iArr, iArr5, iArr4);
                if (Z7 != 0) {
                    iArr = Arrays.copyOfRange(iArr, Z7, length3);
                }
            } else {
                int length4 = iArr4.length;
                iArr = new int[length4];
                int Z8 = Z(0, iArr4.length, 0, iArr5.length, iArr, iArr4, iArr5);
                if (Z8 != 0) {
                    iArr = Arrays.copyOfRange(iArr, Z8, length4);
                }
            }
            return new b(i10, iArr);
        }
        if (length > length2) {
            int length5 = iArr5.length;
            iArr2 = new int[length5];
            if (f(iArr2, iArr5, iArr4)) {
                iArr3 = new int[length5 + 1];
                System.arraycopy(iArr2, 0, iArr3, 1, length5);
                iArr3[0] = 1;
                iArr2 = iArr3;
            }
            return new b(i9, iArr2);
        }
        int length6 = iArr4.length;
        iArr2 = new int[length6];
        if (f(iArr2, iArr4, iArr5)) {
            iArr3 = new int[length6 + 1];
            System.arraycopy(iArr2, 0, iArr3, 1, length6);
            iArr3[0] = 1;
            iArr2 = iArr3;
        }
        return new b(i9, iArr2);
    }

    public static int i(int[] iArr) {
        return (iArr.length * 32) - Integer.numberOfLeadingZeros(iArr[0]);
    }

    public static b k(int[] iArr, int i8, boolean z7, int[] iArr2, int i9, boolean z8, int i10) {
        int i11;
        if (i8 < i9) {
            return k(iArr2, i9, z8, iArr, i8, z7, i10);
        }
        int[] iArr3 = new int[i8];
        int i12 = i8;
        boolean z9 = true;
        boolean z10 = true;
        while (true) {
            i11 = 0;
            if (i9 <= 0) {
                break;
            }
            i12--;
            int i13 = iArr[i12];
            i9--;
            int i14 = iArr2[i9];
            if (z7) {
                if (z9) {
                    z9 = i13 == 0;
                    i13 = -i13;
                } else {
                    i13 ^= -1;
                }
            }
            if (z8) {
                if (z10) {
                    z10 = i14 == 0;
                    i14 = -i14;
                } else {
                    i14 ^= -1;
                }
            }
            iArr3[i12] = i10 == 1 ? i13 & i14 : i10 == 2 ? i13 | i14 : i13 ^ i14;
        }
        int i15 = z8 ? -1 : 0;
        while (i12 > 0) {
            i12--;
            int i16 = iArr[i12];
            if (z7) {
                if (z9) {
                    z9 = i16 == 0;
                    i16 = -i16;
                } else {
                    i16 ^= -1;
                }
            }
            iArr3[i12] = i10 == 1 ? i16 & i15 : i10 == 2 ? i16 | i15 : i10 == 3 ? i16 ^ i15 : i16 ^ (-1);
        }
        int i17 = z7 ? -1 : 0;
        int i18 = i10 == 1 ? i17 & i15 : i10 == 2 ? i17 | i15 : i10 == 3 ? i17 ^ i15 : i17 ^ (-1);
        if (i18 > 0) {
            int[] iArr4 = new int[i8 + 1];
            System.arraycopy(iArr3, 0, iArr4, 1, i8);
            iArr4[0] = i18;
            return new b(1, iArr4);
        }
        if (i18 == 0) {
            while (i11 < i8 && iArr3[i11] == 0) {
                i11++;
            }
            if (i11 == i8) {
                return f4633Z;
            }
            if (i11 != 0) {
                iArr3 = Arrays.copyOfRange(iArr3, i11, i8);
            }
            return new b(1, iArr3);
        }
        int i19 = 0;
        while (i19 < i8 && iArr3[i19] == -1) {
            i19++;
        }
        int i20 = i8;
        do {
            i20--;
            if (i20 < i19) {
                break;
            }
        } while (iArr3[i20] == 0);
        if (i20 < i19) {
            int[] iArr5 = new int[(i8 - i19) + 1];
            iArr5[0] = 1;
            return new b(-1, iArr5);
        }
        int[] iArr6 = i19 == 0 ? iArr3 : new int[i8 - i19];
        iArr6[i20 - i19] = -iArr3[i20];
        while (true) {
            i20--;
            if (i20 < i19) {
                return new b(-1, iArr6);
            }
            iArr6[i20 - i19] = iArr3[i20] ^ (-1);
        }
    }

    public static int t(int i8, int i9, int i10, int i11, int[] iArr, int[] iArr2) {
        if (i9 < i11) {
            return -1;
        }
        if (i9 > i11) {
            return 1;
        }
        while (true) {
            i9--;
            if (i9 < 0) {
                return 0;
            }
            int i12 = i8 + 1;
            long j8 = iArr[i8] & 4294967295L;
            int i13 = i10 + 1;
            long j9 = 4294967295L & iArr2[i10];
            if (j8 < j9) {
                return -1;
            }
            if (j8 > j9) {
                return 1;
            }
            i10 = i13;
            i8 = i12;
        }
    }

    public static int v(int i8, int i9, int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        long j8 = i10 & 4294967295L;
        if (i8 + 1 == i9) {
            long j9 = 4294967295L & iArr3[i8];
            long j10 = j9 / j8;
            if (iArr != null) {
                iArr[i8] = (int) j10;
            }
            if (iArr2 != null) {
                iArr2[0] = (int) (j9 % j8);
            }
            return j10 != 0 ? i8 : i9;
        }
        int i11 = i9;
        long j11 = 0;
        for (int i12 = i8; i12 < i9; i12++) {
            long j12 = (j11 << 32) | (iArr3[i12] & 4294967295L);
            long j13 = ((j12 >>> 1) / j8) << 1;
            long j14 = j12 - (j13 * j8);
            long j15 = (j14 - j8) ^ (-1);
            long j16 = j13 + ((j14 | j15) >>> 63);
            j11 = j14 - ((j15 >> 63) & j8);
            if (iArr != null) {
                iArr[i12] = (int) j16;
            }
            if (j16 != 0 && i11 == i9) {
                i11 = i12;
            }
        }
        if (iArr2 != null) {
            iArr2[0] = (int) j11;
        }
        return i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0196  */
    /* JADX WARN: Type inference failed for: r0v1, types: [J3.b[], java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Serializable x(b bVar, b bVar2, int i8) {
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6 = bVar;
        int[] iArr = bVar6.f4639Y;
        int[] iArr2 = bVar2.f4639Y;
        int length = iArr.length;
        int length2 = iArr2.length;
        b bVar7 = f4633Z;
        if (length != 0) {
            if (length2 == 0) {
                throw new ArithmeticException("Divide by zero");
            }
            if (t(0, length, 0, length2, iArr, iArr2) <= 0) {
                bVar3 = bVar7;
                bVar7 = bVar6;
            } else {
                int i9 = bVar2.f4638X;
                int i10 = bVar6.f4638X;
                int i11 = i10 == i9 ? 1 : -1;
                if (length2 > 1) {
                    int abs = Math.abs(length - length2) + 1;
                    int[] iArr3 = new int[abs];
                    int[] iArr4 = (int[]) iArr.clone();
                    int i12 = i(iArr) - i(iArr2);
                    int[] W7 = W(i12, iArr2);
                    int length3 = iArr4.length;
                    int length4 = W7.length;
                    int i13 = 0;
                    int i14 = 0;
                    while (i12 >= 0) {
                        if (t(i13, length3 - i13, i14, length4 - i14, iArr4, W7) >= 0) {
                            i13 = Z(i13, length3, i14, length4, iArr4, iArr4, W7);
                            int i15 = (abs - 1) - (i12 / 32);
                            iArr3[i15] = (1 << (i12 % 32)) | iArr3[i15];
                        }
                        i14 = X(i14, W7, length4, W7);
                        i12--;
                    }
                    if (i8 != 2) {
                        int i16 = 0;
                        while (i16 < abs && iArr3[i16] == 0) {
                            i16++;
                        }
                        if (i16 < abs) {
                            if (i16 != 0) {
                                iArr3 = Arrays.copyOfRange(iArr3, i16, abs);
                            }
                            bVar5 = new b(i11, iArr3);
                            if (i8 != 1 && i13 < length) {
                                if (i13 != 0) {
                                    iArr4 = Arrays.copyOfRange(iArr4, i13, length);
                                }
                                bVar7 = new b(i10, iArr4);
                            }
                            bVar3 = bVar5;
                        }
                    }
                    bVar5 = bVar7;
                    if (i8 != 1) {
                        if (i13 != 0) {
                        }
                        bVar7 = new b(i10, iArr4);
                    }
                    bVar3 = bVar5;
                } else {
                    int i17 = iArr2[0];
                    if (i17 == 1) {
                        if (i8 != 2) {
                            if (i11 != i10) {
                                bVar6 = new b(i11, iArr);
                            }
                        }
                    } else if (length == 1) {
                        long j8 = iArr[0] & 4294967295L;
                        long j9 = 4294967295L & i17;
                        if (i8 != 2) {
                            long j10 = j8 / j9;
                            if (j10 != 0) {
                                bVar6 = new b(i11, (int) j10);
                                if (i8 != 1) {
                                    long j11 = j8 % j9;
                                    if (j11 != 0) {
                                        bVar7 = new b(i10, (int) j11);
                                    }
                                }
                            }
                        }
                        bVar6 = bVar7;
                        if (i8 != 1) {
                        }
                    } else {
                        if (((-i17) & i17) == i17) {
                            int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i17);
                            bVar3 = i8 != 2 ? new b(i11, Y(numberOfLeadingZeros, false, iArr)) : bVar7;
                            if (i8 != 1) {
                                int i18 = y4.j.f23551b;
                                int i19 = ((numberOfLeadingZeros + 32) - 1) / 32;
                                int[] iArr5 = new int[i19];
                                System.arraycopy(iArr, iArr.length - i19, iArr5, 0, i19);
                                int i20 = numberOfLeadingZeros % 32;
                                if (i20 != 0) {
                                    iArr5[0] = ((1 << i20) - 1) & iArr5[0];
                                }
                                bVar4 = new b(i10, iArr5);
                                bVar3 = bVar3;
                                bVar7 = bVar4;
                            }
                        } else {
                            int[] iArr6 = i8 != 2 ? new int[Math.abs(length - length2) + 1] : null;
                            int[] iArr7 = i8 != 1 ? new int[1] : null;
                            int v8 = v(0, length, i17, iArr6, iArr7, iArr);
                            if (i8 == 2 || v8 >= iArr6.length) {
                                bVar3 = bVar7;
                            } else {
                                if (v8 != 0) {
                                    iArr6 = Arrays.copyOfRange(iArr6, v8, iArr6.length);
                                }
                                bVar3 = new b(i11, iArr6);
                            }
                            if (i8 != 1 && iArr7[0] != 0) {
                                bVar4 = new b(i10, iArr7);
                                bVar3 = bVar3;
                                bVar7 = bVar4;
                            }
                        }
                    }
                    bVar3 = bVar6;
                }
            }
            return i8 != 1 ? bVar3 : i8 == 2 ? bVar7 : new b[]{bVar3, bVar7};
        }
        bVar3 = bVar7;
        if (i8 != 1) {
        }
    }

    public static int y(int[] iArr, int[] iArr2, int i8, long j8) {
        long j9 = i8 & 4294967295L;
        int length = iArr2.length;
        int length2 = iArr.length;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            length2--;
            long j10 = ((iArr2[length] & 4294967295L) * j9) + j8;
            iArr[length2] = (int) j10;
            j8 = j10 >>> 32;
        }
        if (length2 == 0) {
            return (int) j8;
        }
        iArr[length2 - 1] = (int) j8;
        return 0;
    }

    public final b A(b bVar) {
        int i8;
        int i9 = this.f4638X;
        if (i9 == 0 || (i8 = bVar.f4638X) == 0) {
            return f4633Z;
        }
        int[] iArr = this.f4639Y;
        int length = iArr.length;
        int[] iArr2 = bVar.f4639Y;
        int length2 = iArr2.length;
        int i10 = i9 == i8 ? 1 : -1;
        if (length == 1) {
            return new b(i10, S(iArr[0], iArr2));
        }
        if (length2 == 1) {
            return new b(i10, S(iArr2[0], iArr));
        }
        int i11 = length + length2;
        int i12 = length - 1;
        int[] iArr3 = new int[i11];
        long j8 = iArr[i12] & 4294967295L;
        int i13 = length2;
        int i14 = i11;
        long j9 = 0;
        while (true) {
            i13--;
            if (i13 < 0) {
                break;
            }
            i14--;
            long j10 = ((iArr2[i13] & 4294967295L) * j8) + j9;
            iArr3[i14] = (int) j10;
            j9 = j10 >>> 32;
            i11 = i11;
        }
        int i15 = i11;
        iArr3[i12] = (int) j9;
        while (true) {
            int i16 = -1;
            i12--;
            if (i12 < 0) {
                break;
            }
            long j11 = iArr[i12] & 4294967295L;
            int i17 = length2 + i12;
            int i18 = length2;
            long j12 = 0;
            while (true) {
                i18 += i16;
                if (i18 >= 0) {
                    long j13 = ((iArr2[i18] & 4294967295L) * j11) + j12 + (iArr3[i17] & 4294967295L);
                    iArr3[i17] = (int) j13;
                    j12 = j13 >>> 32;
                    i17--;
                    iArr2 = iArr2;
                    i16 = -1;
                }
            }
            iArr3[i12] = (int) j12;
            iArr2 = iArr2;
        }
        int i19 = 0;
        while (i19 < i15 && iArr3[i19] == 0) {
            i19++;
        }
        if (i19 != 0) {
            iArr3 = Arrays.copyOfRange(iArr3, i19, i15);
        }
        return new b(i10, iArr3);
    }

    public final b T() {
        int i8 = this.f4638X;
        return i8 != 0 ? new b(-i8, this.f4639Y) : this;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085 A[LOOP:0: B:28:0x0072->B:33:0x0085, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087 A[EDGE_INSN: B:34:0x0087->B:35:0x0087 BREAK  A[LOOP:0: B:28:0x0072->B:33:0x0085], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0090 -> B:27:0x009a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a0(int i8) {
        int i9;
        int i10;
        int i11;
        int i12 = i8;
        int[] iArr = this.f4639Y;
        int length = iArr.length;
        if (length == 0) {
            return "0";
        }
        if (i12 < 2 || i12 > 36) {
            i12 = 10;
        }
        if (i(iArr) < 64) {
            return Long.toString(longValue(), i12);
        }
        boolean z7 = ((-i12) & i12) == i12;
        int i13 = this.f4638X;
        if (!z7) {
            StringBuilder sb = new StringBuilder();
            int[] iArr2 = (int[]) iArr.clone();
            int[] iArr3 = new int[1];
            int i14 = 0;
            while (i14 < length) {
                int[] iArr4 = iArr3;
                i14 = v(i14, length, i12, iArr2, iArr3, iArr2);
                int i15 = iArr4[0];
                sb.append((char) ((i15 < 10 ? 48 : 87) + i15));
                iArr3 = iArr4;
            }
            if (i13 < 0) {
                sb.append('-');
            }
            return sb.reverse().toString();
        }
        StringBuilder sb2 = i13 < 0 ? new StringBuilder("-") : new StringBuilder();
        int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(i12);
        int i16 = i12 - 1;
        int i17 = iArr[0];
        int i18 = y4.j.f23551b;
        int i19 = (((((r3 + numberOfLeadingZeros) - 1) / numberOfLeadingZeros) * numberOfLeadingZeros) % 32) - numberOfLeadingZeros;
        if (i19 < 0) {
            if (32 - Integer.numberOfLeadingZeros(i17) < numberOfLeadingZeros) {
                i9 = i17 << (-i19);
                i17 = iArr[1];
                i10 = 1;
            } else {
                i9 = 0;
                i10 = 0;
            }
            i19 += 32;
            while (true) {
                int i20 = (i9 | (i17 >>> i19)) & i16;
                sb2.append((char) ((i20 < 10 ? 48 : 87) + i20));
                i19 -= numberOfLeadingZeros;
                if (i19 < 0) {
                    break;
                }
                i9 = 0;
            }
            i11 = i10 + 1;
            if (i11 == length) {
                return sb2.toString();
            }
            int i21 = iArr[i11];
            i10 = i11;
            i9 = i17 << (-i19);
            i17 = i21;
            i19 += 32;
            while (true) {
                int i202 = (i9 | (i17 >>> i19)) & i16;
                sb2.append((char) ((i202 < 10 ? 48 : 87) + i202));
                i19 -= numberOfLeadingZeros;
                if (i19 < 0) {
                }
                i9 = 0;
            }
            i11 = i10 + 1;
            if (i11 == length) {
            }
        } else {
            i9 = 0;
            i10 = 0;
            while (true) {
                int i2022 = (i9 | (i17 >>> i19)) & i16;
                sb2.append((char) ((i2022 < 10 ? 48 : 87) + i2022));
                i19 -= numberOfLeadingZeros;
                if (i19 < 0) {
                }
                i9 = 0;
            }
            i11 = i10 + 1;
            if (i11 == length) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008b, code lost:
    
        if ((java.lang.Integer.numberOfTrailingZeros(r2[r8]) + (((r4 - r8) - 1) * 32)) < r6) goto L35;
     */
    @Override // java.lang.Number
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final double doubleValue() {
        int i8;
        int i9;
        int i10 = this.f4638X;
        if (i10 == 0) {
            return 0.0d;
        }
        int[] iArr = this.f4639Y;
        int i11 = i(iArr) - 1;
        if (i11 < 63) {
            return longValue();
        }
        if (i11 > 1023) {
            return i10 < 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        int i12 = i11 - 53;
        int i13 = i12 % 32;
        if (i13 == 0) {
            i9 = iArr[0];
            i8 = iArr[1];
        } else {
            int i14 = 32 - i13;
            int i15 = iArr[0];
            int i16 = i15 >>> i13;
            int i17 = iArr[1];
            i8 = (i15 << i14) | (i17 >>> i13);
            if (i16 == 0) {
                i8 = (iArr[2] >>> i13) | (i17 << i14);
                i9 = i8;
            } else {
                i9 = i16;
            }
        }
        long j8 = ((i9 & 4294967295L) << 32) | (4294967295L & i8);
        long j9 = (j8 >> 1) & 4503599627370495L;
        if ((j8 & 1) != 0) {
            if ((j9 & 1) == 0) {
                int length = iArr.length;
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (iArr[length] == 0);
            }
            j9++;
        }
        return Double.longBitsToDouble((i10 & Long.MIN_VALUE) | ((i11 + 1023) << 52) | j9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4638X == bVar.f4638X && Arrays.equals(this.f4639Y, bVar.f4639Y);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        if ((java.lang.Integer.numberOfTrailingZeros(r1[r6]) + (((r3 - r6) - 1) * 32)) < r5) goto L35;
     */
    @Override // java.lang.Number
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float floatValue() {
        int i8;
        int i9 = this.f4638X;
        if (i9 == 0) {
            return 0.0f;
        }
        int[] iArr = this.f4639Y;
        int i10 = i(iArr) - 1;
        if (i10 < 63) {
            return longValue();
        }
        if (i10 > 127) {
            return i9 < 0 ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        }
        int i11 = i10 - 24;
        int i12 = i11 % 32;
        if (i12 == 0) {
            i8 = iArr[0];
        } else {
            int i13 = 32 - i12;
            int i14 = iArr[0];
            int i15 = i14 >>> i12;
            i8 = i15 == 0 ? (iArr[1] >>> i12) | (i14 << i13) : i15;
        }
        int i16 = (i8 >> 1) & 8388607;
        if ((1 & i8) != 0) {
            if ((i16 & 1) == 0) {
                int length = iArr.length;
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (iArr[length] == 0);
            }
            i16++;
        }
        return Float.intBitsToFloat((i9 & Integer.MIN_VALUE) | ((i10 + 127) << 23) | i16);
    }

    public final int h() {
        boolean z7 = false;
        int i8 = this.f4638X;
        if (i8 == 0) {
            return 0;
        }
        int[] iArr = this.f4639Y;
        if (i8 < 0 && Integer.lowestOneBit(iArr[0]) == iArr[0]) {
            int length = iArr.length;
            int i9 = 1;
            while (true) {
                if (i9 >= length) {
                    z7 = true;
                    break;
                }
                int i10 = i9 + 1;
                if (iArr[i9] != 0) {
                    break;
                }
                i9 = i10;
            }
            if (z7) {
                return i(iArr) - 1;
            }
        }
        return i(iArr);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f4639Y) * this.f4638X;
    }

    @Override // java.lang.Number
    public final int intValue() {
        int i8 = this.f4638X;
        if (i8 == 0) {
            return 0;
        }
        int i9 = this.f4639Y[r1.length - 1];
        return i8 < 0 ? -i9 : i9;
    }

    public final int l(int i8) {
        if (this.f4639Y.length > 1 || h() >= 32) {
            return 1;
        }
        int intValue = intValue();
        if (intValue == i8) {
            return 0;
        }
        return intValue < i8 ? -1 : 1;
    }

    @Override // java.lang.Number
    public final long longValue() {
        int i8 = this.f4638X;
        if (i8 == 0) {
            return 0L;
        }
        long j8 = r1[r2 - 1] & 4294967295L;
        if (this.f4639Y.length == 1) {
            return i8 < 0 ? -j8 : j8;
        }
        long j9 = (r1[r2 - 2] << 32) | j8;
        return i8 < 0 ? -j9 : j9;
    }

    @Override // java.lang.Comparable
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final int compareTo(b bVar) {
        int i8 = bVar.f4638X;
        int i9 = this.f4638X;
        if (i9 != i8) {
            return i9 < i8 ? -1 : 1;
        }
        int[] iArr = this.f4639Y;
        int length = iArr.length;
        int[] iArr2 = bVar.f4639Y;
        return i9 * t(0, length, 0, iArr2.length, iArr, iArr2);
    }

    public final int s(Number number) {
        if (number instanceof b) {
            return compareTo((b) number);
        }
        if (number instanceof Double) {
            return Double.compare(doubleValue(), ((Double) number).doubleValue());
        }
        if (number instanceof Integer) {
            return l(((Integer) number).intValue());
        }
        if (!(number instanceof Long)) {
            if (number instanceof Float) {
                return Float.compare(floatValue(), ((Float) number).floatValue());
            }
            if (number instanceof Short) {
                return l(((Short) number).shortValue());
            }
            if (number instanceof Byte) {
                return l(((Byte) number).byteValue());
            }
            throw new NumberFormatException("Can't convert number to bigint");
        }
        long longValue = ((Long) number).longValue();
        if (this.f4639Y.length <= 2 && h() < 64) {
            long longValue2 = longValue();
            if (longValue2 == longValue) {
                return 0;
            }
            if (longValue2 < longValue) {
                return -1;
            }
        }
        return 1;
    }

    public final String toString() {
        return a0(10);
    }
}
