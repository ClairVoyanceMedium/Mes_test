package J3;

import J3.e;
import L3.I;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Rect;
import android.hardware.usb.UsbDevice;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.view.KeyEvent;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.expr.ConversionType;
import com.llamalab.safs.f;
import com.llamalab.safs.n;
import i4.C1949c;
import java.io.File;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p3.C2212a;
import s4.AbstractC2313a;
import x3.C2440r;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f4650a = Pattern.compile("\\s*,\\s*");

    /* renamed from: b, reason: collision with root package name */
    public static final a f4651b = new a();

    public class a implements Comparator<Object> {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            if (!(obj instanceof J3.b)) {
                if (!(obj2 instanceof J3.b)) {
                    return Double.compare(h.W(obj), h.W(obj2));
                }
                return -Double.compare(((J3.b) obj2).doubleValue(), h.W(obj));
            }
            J3.b bVar = (J3.b) obj;
            if (obj2 instanceof J3.b) {
                return bVar.compareTo((J3.b) obj2);
            }
            return Double.compare(bVar.doubleValue(), h.W(obj2));
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4652a;

        static {
            int[] iArr = new int[ConversionType.values().length];
            f4652a = iArr;
            try {
                iArr[ConversionType.Boolean.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4652a[ConversionType.BooleanArray.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4652a[ConversionType.Byte.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4652a[ConversionType.ByteArray.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4652a[ConversionType.Char.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4652a[ConversionType.CharArray.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4652a[ConversionType.Double.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4652a[ConversionType.DoubleArray.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4652a[ConversionType.Float.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4652a[ConversionType.FloatArray.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4652a[ConversionType.Int.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4652a[ConversionType.IntArray.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4652a[ConversionType.IntList.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4652a[ConversionType.Long.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f4652a[ConversionType.LongArray.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f4652a[ConversionType.Short.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f4652a[ConversionType.ShortArray.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f4652a[ConversionType.String.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f4652a[ConversionType.StringArray.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f4652a[ConversionType.StringList.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f4652a[ConversionType.CharSequence.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f4652a[ConversionType.CharSequenceArray.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f4652a[ConversionType.CharSequenceList.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f4652a[ConversionType.Bundle.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f4652a[ConversionType.BundleArray.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f4652a[ConversionType.BundleList.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f4652a[ConversionType.Uri.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f4652a[ConversionType.UriArray.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f4652a[ConversionType.UriList.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f4652a[ConversionType.ComponentName.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f4652a[ConversionType.ComponentNameArray.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f4652a[ConversionType.ComponentNameList.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f4652a[ConversionType.Intent.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f4652a[ConversionType.IntentArray.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f4652a[ConversionType.IntentList.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f4652a[ConversionType.Rect.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f4652a[ConversionType.Uuid.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
        }
    }

    public static Uri A(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, Uri uri) {
        String f02;
        return (interfaceC1700x0 == null || (f02 = f0(null, interfaceC1700x0.c2(c1708z0))) == null) ? uri : Uri.parse(f02);
    }

    public static boolean B(Object obj) {
        return obj == null || (obj instanceof I);
    }

    public static boolean C(char c8) {
        return c8 == '\t' || c8 == '\n' || c8 == '\f' || c8 == '\r' || c8 == ' ';
    }

    public static J3.a D(Rect rect) {
        return new J3.a(4, new Object[]{Double.valueOf(rect.left), Double.valueOf(rect.top), Double.valueOf(rect.right), Double.valueOf(rect.bottom)});
    }

    public static J3.a E(Collection<?> collection) {
        int size = collection.size();
        Object[] objArr = new Object[size];
        Iterator<?> it = collection.iterator();
        int i8 = -1;
        while (it.hasNext()) {
            i8++;
            objArr[i8] = U(it.next());
        }
        return new J3.a(size, objArr);
    }

    public static J3.a F(Matcher matcher) {
        int groupCount = matcher.groupCount() + 1;
        Object[] objArr = new Object[groupCount];
        int i8 = groupCount;
        while (true) {
            i8--;
            if (i8 < 0) {
                return new J3.a(groupCount, objArr);
            }
            objArr[i8] = matcher.group(i8);
        }
    }

    public static J3.a G(double[] dArr, int i8) {
        int i9 = i8 + 0;
        Object[] objArr = new Object[i9];
        int min = Math.min(i8, dArr.length);
        int i10 = 0;
        for (int i11 = 0; i11 < min; i11++) {
            objArr[i10] = Double.valueOf(dArr[i11]);
            i10++;
        }
        return new J3.a(i9, objArr);
    }

    public static J3.a H(int[] iArr) {
        int length = iArr.length;
        Object[] objArr = new Object[length];
        int i8 = length;
        while (true) {
            i8--;
            if (i8 < 0) {
                return new J3.a(length, objArr);
            }
            objArr[i8] = Double.valueOf(iArr[i8]);
        }
    }

    public static J3.b I(Object obj) {
        J3.b U7;
        int i8;
        int i9;
        int byteValue;
        if (obj == null) {
            return J3.b.f4633Z;
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (number instanceof J3.b) {
                return (J3.b) number;
            }
            if (number instanceof Double) {
                return J3.b.b0(((Double) number).doubleValue());
            }
            if (number instanceof Integer) {
                byteValue = ((Integer) number).intValue();
            } else {
                if (number instanceof Long) {
                    return J3.b.d0(((Long) number).longValue());
                }
                if (number instanceof Float) {
                    return J3.b.b0(((Float) number).floatValue());
                }
                if (number instanceof Short) {
                    byteValue = ((Short) number).shortValue();
                } else {
                    if (!(number instanceof Byte)) {
                        throw new NumberFormatException("Can't convert number to bigint");
                    }
                    byteValue = ((Byte) number).byteValue();
                }
            }
            if (byteValue == 0) {
                return J3.b.f4633Z;
            }
            return byteValue < 0 ? new J3.b(-1, -byteValue) : new J3.b(1, byteValue);
        }
        if (!(obj instanceof CharSequence)) {
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() ? J3.b.f4634x0 : J3.b.f4633Z : obj instanceof k ? I(((k) obj).value()) : J3.b.f4633Z;
        }
        String obj2 = obj.toString();
        int length = obj2.length();
        for (int i10 = 0; i10 != length; i10++) {
            if (!C(obj2.charAt(i10))) {
                while (i10 < length) {
                    int i11 = length - 1;
                    if (!C(obj2.charAt(i11))) {
                        break;
                    }
                    length = i11;
                }
                if (obj2.regionMatches(i10, "0x", 0, 2)) {
                    i9 = i10 + 2;
                } else {
                    if (!obj2.regionMatches(i10, "+0x", 0, 3)) {
                        if (!obj2.regionMatches(i10, "-0x", 0, 3)) {
                            if (obj2.regionMatches(i10, "0b", 0, 2)) {
                                i8 = i10 + 2;
                            } else if (obj2.regionMatches(i10, "+0b", 0, 3)) {
                                i8 = i10 + 3;
                            } else {
                                if (!obj2.regionMatches(i10, "-0b", 0, 3)) {
                                    return J3.b.U(i10, length, 10, obj2);
                                }
                                U7 = J3.b.U(i10 + 3, length, 2, obj2);
                            }
                            return J3.b.U(i8, length, 2, obj2);
                        }
                        U7 = J3.b.U(i10 + 3, length, 16, obj2);
                        return U7.T();
                    }
                    i9 = i10 + 3;
                }
                return J3.b.U(i9, length, 16, obj2);
            }
        }
        return J3.b.f4633Z;
    }

    public static boolean J(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (!(number instanceof J3.b)) {
                double doubleValue = number.doubleValue();
                if (doubleValue != doubleValue || doubleValue == 0.0d) {
                    return false;
                }
            } else if (((J3.b) number).f4638X == 0) {
                return false;
            }
            return true;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() != 0;
        }
        if (obj instanceof J3.a) {
            return ((J3.a) obj).f4627Y != 0;
        }
        if (obj instanceof e) {
            return ((e) obj).f4641x1 != 0;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof k) {
            return J(((k) obj).value());
        }
        return false;
    }

    public static Bundle K(e eVar) {
        Parcelable K7;
        ArrayList<? extends Parcelable> arrayList;
        Bundle bundle = new Bundle(eVar.f4641x1);
        C1231k c1231k = (C1231k) eVar.f9362Z;
        while (true) {
            int i8 = 0;
            if (!(c1231k != eVar)) {
                return bundle;
            }
            if (c1231k == eVar) {
                throw new NoSuchElementException();
            }
            C1231k c1231k2 = (C1231k) c1231k.f9362Z;
            e.a aVar = (e.a) c1231k;
            Object obj = aVar.f4644x1;
            ConversionType conversionType = aVar.f4646y1;
            if (conversionType == null) {
                if (obj instanceof Double) {
                    conversionType = ConversionType.Double;
                } else if (obj instanceof String) {
                    conversionType = ConversionType.String;
                } else if (obj instanceof e) {
                    conversionType = ConversionType.Bundle;
                } else {
                    continue;
                    c1231k = c1231k2;
                }
            }
            int i9 = b.f4652a[conversionType.ordinal()];
            String str = aVar.f4645y0;
            switch (i9) {
                case 1:
                    if (obj != null) {
                        bundle.putBoolean(str, J(obj));
                    }
                    c1231k = c1231k2;
                case 2:
                    if (obj instanceof J3.a) {
                        J3.a aVar2 = (J3.a) obj;
                        int i10 = aVar2.f4627Y;
                        boolean[] zArr = new boolean[i10];
                        while (true) {
                            i10--;
                            if (i10 >= 0) {
                                zArr[i10] = J(aVar2.get(i10));
                            } else {
                                bundle.putBooleanArray(str, zArr);
                            }
                        }
                    }
                    c1231k = c1231k2;
                case 3:
                    if (obj != null) {
                        bundle.putByte(str, (byte) R(obj));
                    }
                    c1231k = c1231k2;
                case 4:
                    if (obj instanceof J3.a) {
                        J3.a aVar3 = (J3.a) obj;
                        int i11 = aVar3.f4627Y;
                        byte[] bArr = new byte[i11];
                        while (true) {
                            i11--;
                            if (i11 >= 0) {
                                bArr[i11] = (byte) R(aVar3.get(i11));
                            } else {
                                bundle.putByteArray(str, bArr);
                            }
                        }
                    } else if (obj != null) {
                        bundle.putByteArray(str, e0(obj).getBytes());
                    }
                    c1231k = c1231k2;
                case 5:
                    if (obj != null) {
                        bundle.putChar(str, (char) R(obj));
                    }
                    c1231k = c1231k2;
                case 6:
                    if (obj instanceof J3.a) {
                        J3.a aVar4 = (J3.a) obj;
                        int i12 = aVar4.f4627Y;
                        char[] cArr = new char[i12];
                        while (true) {
                            i12--;
                            if (i12 >= 0) {
                                cArr[i12] = (char) R(aVar4.get(i12));
                            } else {
                                bundle.putCharArray(str, cArr);
                            }
                        }
                    } else if (obj != null) {
                        bundle.putCharArray(str, e0(obj).toCharArray());
                    }
                    c1231k = c1231k2;
                case 7:
                    if (obj != null) {
                        bundle.putDouble(str, W(obj));
                    }
                    c1231k = c1231k2;
                case 8:
                    if (obj instanceof J3.a) {
                        J3.a aVar5 = (J3.a) obj;
                        int i13 = aVar5.f4627Y;
                        double[] dArr = new double[i13];
                        while (true) {
                            i13--;
                            if (i13 >= 0) {
                                dArr[i13] = W(aVar5.get(i13));
                            } else {
                                bundle.putDoubleArray(str, dArr);
                            }
                        }
                    }
                    c1231k = c1231k2;
                case 9:
                    if (obj != null) {
                        bundle.putFloat(str, (float) W(obj));
                    }
                    c1231k = c1231k2;
                case 10:
                    if (obj instanceof J3.a) {
                        J3.a aVar6 = (J3.a) obj;
                        int i14 = aVar6.f4627Y;
                        float[] fArr = new float[i14];
                        while (true) {
                            i14--;
                            if (i14 >= 0) {
                                fArr[i14] = (float) W(aVar6.get(i14));
                            } else {
                                bundle.putFloatArray(str, fArr);
                            }
                        }
                    }
                    c1231k = c1231k2;
                case 11:
                    if (obj != null) {
                        bundle.putInt(str, R(obj));
                    }
                    c1231k = c1231k2;
                case 12:
                    if (obj instanceof J3.a) {
                        bundle.putIntArray(str, S((J3.a) obj));
                    }
                    c1231k = c1231k2;
                case 13:
                    if (obj instanceof J3.a) {
                        J3.a aVar7 = (J3.a) obj;
                        int i15 = aVar7.f4627Y;
                        ArrayList<Integer> arrayList2 = new ArrayList<>(i15);
                        while (true) {
                            i15--;
                            if (i15 >= 0) {
                                int i16 = i8 + 1;
                                Object obj2 = aVar7.get(i8);
                                arrayList2.add(obj2 != null ? Integer.valueOf(R(obj2)) : null);
                                i8 = i16;
                            } else {
                                bundle.putIntegerArrayList(str, arrayList2);
                            }
                        }
                    }
                    c1231k = c1231k2;
                case 14:
                    if (obj != null) {
                        bundle.putLong(str, T(obj));
                    }
                    c1231k = c1231k2;
                case 15:
                    if (obj instanceof J3.a) {
                        J3.a aVar8 = (J3.a) obj;
                        int i17 = aVar8.f4627Y;
                        long[] jArr = new long[i17];
                        while (true) {
                            i17--;
                            if (i17 >= 0) {
                                jArr[i17] = T(aVar8.get(i17));
                            } else {
                                bundle.putLongArray(str, jArr);
                            }
                        }
                    }
                    c1231k = c1231k2;
                case 16:
                    if (obj != null) {
                        bundle.putShort(str, (short) R(obj));
                    }
                    c1231k = c1231k2;
                case 17:
                    if (obj instanceof J3.a) {
                        J3.a aVar9 = (J3.a) obj;
                        int i18 = aVar9.f4627Y;
                        short[] sArr = new short[i18];
                        while (true) {
                            i18--;
                            if (i18 >= 0) {
                                sArr[i18] = (short) R(aVar9.get(i18));
                            } else {
                                bundle.putShortArray(str, sArr);
                            }
                        }
                    }
                    c1231k = c1231k2;
                case 18:
                    if (obj != null) {
                        bundle.putString(str, e0(obj));
                    }
                    c1231k = c1231k2;
                case 19:
                    if (obj instanceof J3.a) {
                        bundle.putStringArray(str, i0((J3.a) obj));
                    }
                    c1231k = c1231k2;
                case 20:
                    if (obj instanceof J3.a) {
                        bundle.putStringArrayList(str, j0((J3.a) obj));
                    }
                    c1231k = c1231k2;
                case 21:
                    if (obj != null) {
                        bundle.putCharSequence(str, e0(obj));
                    }
                    c1231k = c1231k2;
                case 22:
                    if (obj instanceof J3.a) {
                        bundle.putCharSequenceArray(str, M((J3.a) obj));
                    }
                    c1231k = c1231k2;
                case 23:
                    if (obj instanceof J3.a) {
                        bundle.putCharSequenceArrayList(str, j0((J3.a) obj));
                    }
                    c1231k = c1231k2;
                case 24:
                    if (obj instanceof e) {
                        K7 = K((e) obj);
                        bundle.putParcelable(str, K7);
                        c1231k = c1231k2;
                    } else {
                        c1231k = c1231k2;
                    }
                case 25:
                    if (obj instanceof J3.a) {
                        J3.a aVar10 = (J3.a) obj;
                        int i19 = aVar10.f4627Y;
                        Bundle[] bundleArr = new Bundle[i19];
                        while (true) {
                            i19--;
                            if (i19 >= 0) {
                                Object obj3 = aVar10.get(i19);
                                if (obj3 instanceof e) {
                                    bundleArr[i19] = K((e) obj3);
                                }
                            } else {
                                bundle.putParcelableArray(str, (Parcelable[]) Parcelable[].class.cast(bundleArr));
                            }
                        }
                    }
                    c1231k = c1231k2;
                case 26:
                    if (obj instanceof J3.a) {
                        J3.a aVar11 = (J3.a) obj;
                        int i20 = aVar11.f4627Y;
                        arrayList = new ArrayList<>(i20);
                        while (true) {
                            i20--;
                            if (i20 >= 0) {
                                int i21 = i8 + 1;
                                Object obj4 = aVar11.get(i8);
                                arrayList.add(obj4 instanceof e ? K((e) obj4) : null);
                                i8 = i21;
                            } else {
                                bundle.putParcelableArrayList(str, arrayList);
                                c1231k = c1231k2;
                            }
                        }
                    } else {
                        c1231k = c1231k2;
                    }
                case 27:
                    if (obj != null) {
                        K7 = Uri.parse(e0(obj));
                        bundle.putParcelable(str, K7);
                        c1231k = c1231k2;
                    } else {
                        c1231k = c1231k2;
                    }
                case 28:
                    if (obj instanceof J3.a) {
                        J3.a aVar12 = (J3.a) obj;
                        int i22 = aVar12.f4627Y;
                        Uri[] uriArr = new Uri[i22];
                        while (true) {
                            i22--;
                            if (i22 >= 0) {
                                Object obj5 = aVar12.get(i22);
                                if (obj5 != null) {
                                    uriArr[i22] = Uri.parse(e0(obj5));
                                }
                            } else {
                                bundle.putParcelableArray(str, (Parcelable[]) Parcelable[].class.cast(uriArr));
                            }
                        }
                    }
                    c1231k = c1231k2;
                case 29:
                    if (obj instanceof J3.a) {
                        J3.a aVar13 = (J3.a) obj;
                        int i23 = aVar13.f4627Y;
                        arrayList = new ArrayList<>(i23);
                        while (true) {
                            i23--;
                            if (i23 >= 0) {
                                int i24 = i8 + 1;
                                Object obj6 = aVar13.get(i8);
                                arrayList.add(obj6 != null ? Uri.parse(e0(obj6)) : null);
                                i8 = i24;
                            } else {
                                bundle.putParcelableArrayList(str, arrayList);
                                c1231k = c1231k2;
                            }
                        }
                    } else {
                        c1231k = c1231k2;
                    }
                case 30:
                    if (obj != null) {
                        K7 = ComponentName.unflattenFromString(e0(obj));
                        bundle.putParcelable(str, K7);
                        c1231k = c1231k2;
                    } else {
                        c1231k = c1231k2;
                    }
                case 31:
                    if (obj instanceof J3.a) {
                        J3.a aVar14 = (J3.a) obj;
                        int i25 = aVar14.f4627Y;
                        ComponentName[] componentNameArr = new ComponentName[i25];
                        while (true) {
                            i25--;
                            if (i25 >= 0) {
                                Object obj7 = aVar14.get(i25);
                                if (obj7 != null) {
                                    componentNameArr[i25] = ComponentName.unflattenFromString(e0(obj7));
                                }
                            } else {
                                bundle.putParcelableArray(str, (Parcelable[]) Parcelable[].class.cast(componentNameArr));
                            }
                        }
                    }
                    c1231k = c1231k2;
                case 32:
                    if (obj instanceof J3.a) {
                        J3.a aVar15 = (J3.a) obj;
                        int i26 = aVar15.f4627Y;
                        arrayList = new ArrayList<>(i26);
                        while (true) {
                            i26--;
                            if (i26 >= 0) {
                                int i27 = i8 + 1;
                                Object obj8 = aVar15.get(i8);
                                arrayList.add(obj8 != null ? ComponentName.unflattenFromString(e0(obj8)) : null);
                                i8 = i27;
                            } else {
                                bundle.putParcelableArrayList(str, arrayList);
                                c1231k = c1231k2;
                            }
                        }
                    } else {
                        c1231k = c1231k2;
                    }
                case 33:
                    if (obj != null) {
                        try {
                            bundle.putParcelable(str, Intent.parseUri(f0(null, obj), 0));
                        } catch (URISyntaxException e8) {
                            throw new IllegalArgumentException(e8);
                        }
                    } else {
                        continue;
                    }
                    c1231k = c1231k2;
                case 34:
                    if (obj instanceof J3.a) {
                        J3.a aVar16 = (J3.a) obj;
                        try {
                            int i28 = aVar16.f4627Y;
                            Intent[] intentArr = new Intent[i28];
                            while (true) {
                                i28--;
                                if (i28 >= 0) {
                                    Object obj9 = aVar16.get(i28);
                                    if (obj9 != null) {
                                        intentArr[i28] = Intent.parseUri(e0(obj9), 0);
                                    }
                                } else {
                                    bundle.putParcelableArray(str, (Parcelable[]) Parcelable[].class.cast(intentArr));
                                }
                            }
                        } catch (URISyntaxException e9) {
                            throw new IllegalArgumentException(e9);
                        }
                    } else {
                        continue;
                    }
                    c1231k = c1231k2;
                case 35:
                    if (obj instanceof J3.a) {
                        J3.a aVar17 = (J3.a) obj;
                        try {
                            int i29 = aVar17.f4627Y;
                            arrayList = new ArrayList<>(i29);
                            int i30 = 0;
                            while (true) {
                                i29--;
                                if (i29 >= 0) {
                                    int i31 = i30 + 1;
                                    Object obj10 = aVar17.get(i30);
                                    arrayList.add(obj10 != null ? Intent.parseUri(e0(obj10), 0) : null);
                                    i30 = i31;
                                } else {
                                    bundle.putParcelableArrayList(str, arrayList);
                                    c1231k = c1231k2;
                                }
                            }
                        } catch (URISyntaxException e10) {
                            throw new IllegalArgumentException(e10);
                        }
                    } else {
                        continue;
                        c1231k = c1231k2;
                    }
                case 36:
                    if (obj instanceof J3.a) {
                        J3.a aVar18 = (J3.a) obj;
                        Rect rect = new Rect();
                        int i32 = aVar18.f4627Y;
                        if (i32 != 0) {
                            if (i32 != 1) {
                                if (i32 != 2) {
                                    if (i32 != 3) {
                                        rect.bottom = R(aVar18.get(3));
                                    }
                                    rect.right = R(aVar18.get(2));
                                }
                                rect.top = R(aVar18.get(1));
                            }
                            rect.left = R(aVar18.get(0));
                        }
                        bundle.putParcelable(str, rect);
                    }
                    c1231k = c1231k2;
                case 37:
                    if (obj != null) {
                        K7 = ParcelUuid.fromString(e0(obj));
                        bundle.putParcelable(str, K7);
                        c1231k = c1231k2;
                    } else {
                        c1231k = c1231k2;
                    }
                default:
                    continue;
                    c1231k = c1231k2;
            }
        }
    }

    public static String L(int i8, String str, InterfaceC1700x0... interfaceC1700x0Arr) {
        StringBuilder sb = new StringBuilder();
        int i9 = 0;
        if ((i8 & 1) != 0) {
            sb.append(interfaceC1700x0Arr[0].x(0));
            sb.append(';');
            sb.append(str);
            int length = interfaceC1700x0Arr.length;
            while (true) {
                length--;
                if (length <= 0) {
                    break;
                }
                i9++;
                InterfaceC1700x0 interfaceC1700x0 = interfaceC1700x0Arr[i9];
                if (interfaceC1700x0 != null) {
                    sb.append(';');
                    sb.append(interfaceC1700x0.x(i8 | 2));
                }
            }
        } else {
            sb.append(str);
            sb.append('(');
            String str2 = "";
            for (InterfaceC1700x0 interfaceC1700x02 : interfaceC1700x0Arr) {
                if (interfaceC1700x02 != null) {
                    sb.append(str2);
                    sb.append(interfaceC1700x02.x(0));
                    str2 = ", ";
                }
            }
            sb.append(')');
        }
        return sb.toString();
    }

    public static CharSequence[] M(J3.a aVar) {
        int i8 = aVar.f4627Y;
        CharSequence[] charSequenceArr = new CharSequence[i8];
        while (true) {
            i8--;
            if (i8 < 0) {
                return charSequenceArr;
            }
            charSequenceArr[i8] = f0(null, aVar.get(i8));
        }
    }

    public static ContentValues N(e eVar) {
        ContentValues contentValues = new ContentValues(eVar.f4641x1);
        C1231k c1231k = (C1231k) eVar.f9362Z;
        while (true) {
            if (!(c1231k != eVar)) {
                return contentValues;
            }
            if (c1231k == eVar) {
                throw new NoSuchElementException();
            }
            C1231k c1231k2 = (C1231k) c1231k.f9362Z;
            e.a aVar = (e.a) c1231k;
            Object obj = aVar.f4644x1;
            String str = aVar.f4645y0;
            if (obj == null) {
                contentValues.putNull(str);
            } else if (obj instanceof Number) {
                contentValues.put(str, Double.valueOf(((Number) obj).doubleValue()));
            } else {
                contentValues.put(str, e0(obj));
            }
            c1231k = c1231k2;
        }
    }

    public static e O(int i8, Bundle bundle) {
        e eVar = new e(bundle.size());
        for (String str : bundle.keySet()) {
            try {
                Object obj = bundle.get(str);
                ConversionType conversionType = null;
                if (obj == null) {
                    eVar.m0(str, null, null);
                } else {
                    if (obj instanceof Boolean) {
                        obj = Double.valueOf(Y(((Boolean) obj).booleanValue()));
                        conversionType = ConversionType.Boolean;
                    } else if (obj instanceof Byte) {
                        obj = Double.valueOf(((Byte) obj).byteValue());
                        conversionType = ConversionType.Byte;
                    } else if (obj instanceof Character) {
                        obj = Double.valueOf(((Character) obj).charValue());
                        conversionType = ConversionType.Char;
                    } else if (obj instanceof Double) {
                        conversionType = ConversionType.Double;
                    } else if (obj instanceof Float) {
                        obj = Double.valueOf(((Float) obj).floatValue());
                        conversionType = ConversionType.Float;
                    } else if (obj instanceof Integer) {
                        obj = Double.valueOf(((Integer) obj).intValue());
                        conversionType = ConversionType.Int;
                    } else if (obj instanceof Long) {
                        long longValue = ((Long) obj).longValue();
                        obj = 1 <= i8 ? J3.b.d0(longValue) : Double.valueOf(longValue);
                        conversionType = ConversionType.Long;
                    } else if (obj instanceof Short) {
                        obj = Double.valueOf(((Short) obj).shortValue());
                        conversionType = ConversionType.Short;
                    } else if (obj instanceof String) {
                        conversionType = ConversionType.String;
                    } else if (obj instanceof CharSequence) {
                        obj = obj.toString();
                        conversionType = ConversionType.CharSequence;
                    } else if (obj instanceof Bundle) {
                        obj = O(i8, (Bundle) obj);
                        conversionType = ConversionType.Bundle;
                    } else if (obj instanceof Uri) {
                        obj = obj.toString();
                        conversionType = ConversionType.Uri;
                    } else if (obj instanceof ComponentName) {
                        obj = ((ComponentName) obj).flattenToShortString();
                        conversionType = ConversionType.ComponentName;
                    } else if (obj instanceof Intent) {
                        obj = ((Intent) obj).toUri(0);
                        conversionType = ConversionType.Intent;
                    } else if (obj instanceof Rect) {
                        obj = D((Rect) obj);
                        conversionType = ConversionType.Rect;
                    } else if (obj instanceof ParcelUuid) {
                        obj = obj.toString();
                        conversionType = ConversionType.Uuid;
                    } else if (obj instanceof KeyEvent) {
                        obj = Double.valueOf(((KeyEvent) obj).getKeyCode());
                    } else if (obj instanceof UsbDevice) {
                        obj = ((UsbDevice) obj).getDeviceName();
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        int size = arrayList.size();
                        Object[] objArr = new Object[size];
                        for (int i9 = 0; i9 < size; i9++) {
                            Object obj2 = arrayList.get(i9);
                            if (obj2 instanceof Integer) {
                                objArr[i9] = Double.valueOf(((Integer) obj2).intValue());
                                conversionType = ConversionType.IntList;
                            } else if (obj2 instanceof String) {
                                objArr[i9] = obj2;
                                conversionType = ConversionType.StringList;
                            } else if (obj2 instanceof CharSequence) {
                                objArr[i9] = obj2.toString();
                                conversionType = ConversionType.CharSequenceList;
                            } else if (obj2 instanceof Bundle) {
                                objArr[i9] = O(i8, (Bundle) obj2);
                                conversionType = ConversionType.BundleList;
                            } else if (obj2 instanceof Uri) {
                                objArr[i9] = obj2.toString();
                                conversionType = ConversionType.UriList;
                            } else if (obj2 instanceof ComponentName) {
                                objArr[i9] = ((ComponentName) obj2).flattenToShortString();
                                conversionType = ConversionType.ComponentNameList;
                            } else if (obj2 instanceof Intent) {
                                objArr[i9] = ((Intent) obj2).toUri(0);
                                conversionType = ConversionType.IntentList;
                            }
                        }
                        if (conversionType != null) {
                            obj = new J3.a(size, objArr);
                        }
                    } else if (obj.getClass().isArray()) {
                        Class<?> componentType = obj.getClass().getComponentType();
                        if (Boolean.TYPE == componentType) {
                            boolean[] zArr = (boolean[]) obj;
                            int length = zArr.length;
                            Object[] objArr2 = new Object[length];
                            int i10 = length;
                            while (true) {
                                i10--;
                                if (i10 < 0) {
                                    break;
                                }
                                objArr2[i10] = Boolean.valueOf(J(Boolean.valueOf(zArr[i10])));
                            }
                            obj = new J3.a(length, objArr2);
                            conversionType = ConversionType.BooleanArray;
                        } else if (Byte.TYPE == componentType) {
                            int length2 = ((byte[]) obj).length;
                            Object[] objArr3 = new Object[length2];
                            int i11 = length2;
                            while (true) {
                                i11--;
                                if (i11 < 0) {
                                    break;
                                }
                                objArr3[i11] = Double.valueOf(r3[i11]);
                            }
                            obj = new J3.a(length2, objArr3);
                            conversionType = ConversionType.ByteArray;
                        } else if (Character.TYPE == componentType) {
                            int length3 = ((char[]) obj).length;
                            Object[] objArr4 = new Object[length3];
                            int i12 = length3;
                            while (true) {
                                i12--;
                                if (i12 < 0) {
                                    break;
                                }
                                objArr4[i12] = Double.valueOf(r3[i12]);
                            }
                            obj = new J3.a(length3, objArr4);
                            conversionType = ConversionType.CharArray;
                        } else if (Double.TYPE == componentType) {
                            double[] dArr = (double[]) obj;
                            obj = G(dArr, dArr.length);
                            conversionType = ConversionType.DoubleArray;
                        } else if (Float.TYPE == componentType) {
                            int length4 = ((float[]) obj).length;
                            Object[] objArr5 = new Object[length4];
                            int i13 = length4;
                            while (true) {
                                i13--;
                                if (i13 < 0) {
                                    break;
                                }
                                objArr5[i13] = Double.valueOf(r3[i13]);
                            }
                            obj = new J3.a(length4, objArr5);
                            conversionType = ConversionType.FloatArray;
                        } else if (Integer.TYPE == componentType) {
                            obj = H((int[]) obj);
                            conversionType = ConversionType.IntArray;
                        } else if (Long.TYPE == componentType) {
                            long[] jArr = (long[]) obj;
                            if (1 <= i8) {
                                int length5 = jArr.length;
                                Object[] objArr6 = new Object[length5];
                                int i14 = length5;
                                while (true) {
                                    i14--;
                                    if (i14 < 0) {
                                        break;
                                    }
                                    objArr6[i14] = J3.b.d0(jArr[i14]);
                                }
                                obj = new J3.a(length5, objArr6);
                            } else {
                                int length6 = jArr.length;
                                Object[] objArr7 = new Object[length6];
                                int i15 = length6;
                                while (true) {
                                    i15--;
                                    if (i15 < 0) {
                                        break;
                                    }
                                    objArr7[i15] = Double.valueOf(jArr[i15]);
                                }
                                obj = new J3.a(length6, objArr7);
                            }
                            conversionType = ConversionType.LongArray;
                        } else if (Short.TYPE == componentType) {
                            int length7 = ((short[]) obj).length;
                            Object[] objArr8 = new Object[length7];
                            int i16 = length7;
                            while (true) {
                                i16--;
                                if (i16 < 0) {
                                    break;
                                }
                                objArr8[i16] = Double.valueOf(r3[i16]);
                            }
                            obj = new J3.a(length7, objArr8);
                            conversionType = ConversionType.ShortArray;
                        } else if (String.class == componentType) {
                            String[] strArr = (String[]) obj;
                            int length8 = strArr.length;
                            Object[] objArr9 = new Object[length8];
                            System.arraycopy(strArr, 0, objArr9, 0, length8);
                            obj = new J3.a(length8, objArr9);
                            conversionType = ConversionType.StringArray;
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            obj = h0((CharSequence[]) obj);
                            conversionType = ConversionType.CharSequenceArray;
                        } else if (Bundle.class.isAssignableFrom(componentType)) {
                            obj = h0((Bundle[]) obj);
                            conversionType = ConversionType.BundleArray;
                        } else if (Uri.class.isAssignableFrom(componentType)) {
                            obj = h0((Uri[]) obj);
                            conversionType = ConversionType.UriArray;
                        } else if (ComponentName.class.isAssignableFrom(componentType)) {
                            ComponentName[] componentNameArr = (ComponentName[]) obj;
                            int length9 = componentNameArr.length;
                            Object[] objArr10 = new Object[length9];
                            int i17 = length9;
                            while (true) {
                                i17--;
                                if (i17 < 0) {
                                    break;
                                }
                                ComponentName componentName = componentNameArr[i17];
                                if (componentName != null) {
                                    objArr10[i17] = componentName.flattenToShortString();
                                }
                            }
                            obj = new J3.a(length9, objArr10);
                            conversionType = ConversionType.ComponentNameArray;
                        } else if (Intent.class.isAssignableFrom(componentType)) {
                            Intent[] intentArr = (Intent[]) obj;
                            int length10 = intentArr.length;
                            Object[] objArr11 = new Object[length10];
                            int i18 = length10;
                            while (true) {
                                i18--;
                                if (i18 < 0) {
                                    break;
                                }
                                Intent intent = intentArr[i18];
                                if (intent != null) {
                                    objArr11[i18] = intent.toUri(0);
                                }
                            }
                            obj = new J3.a(length10, objArr11);
                            conversionType = ConversionType.IntentArray;
                        }
                    }
                    eVar.m0(str, obj, conversionType);
                }
            } catch (BadParcelableException unused) {
            }
        }
        return eVar;
    }

    public static e P(Map<?, ?> map) {
        e eVar = new e(map.size());
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            eVar.m0(e0(entry.getKey()), U(entry.getValue()), null);
        }
        return eVar;
    }

    public static <T> int Q(k<T> kVar) {
        return R(kVar.value());
    }

    public static int R(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof CharSequence) {
            return (int) X(obj.toString());
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? 1 : 0;
        }
        if (obj instanceof k) {
            return R(((k) obj).value());
        }
        return 0;
    }

    public static int[] S(J3.a aVar) {
        int i8 = aVar.f4627Y;
        int[] iArr = new int[i8];
        while (true) {
            i8--;
            if (i8 < 0) {
                return iArr;
            }
            iArr[i8] = R(aVar.get(i8));
        }
    }

    public static long T(Object obj) {
        if (obj == null) {
            return 0L;
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof CharSequence) {
            return (long) X(obj.toString());
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? 1L : 0L;
        }
        if (obj instanceof k) {
            return T(((k) obj).value());
        }
        return 0L;
    }

    public static Object U(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Double) {
            return obj;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof Character) {
            return Double.valueOf(((Character) obj).charValue());
        }
        if ((obj instanceof CharSequence) || (obj instanceof Uri)) {
            return obj.toString();
        }
        if (obj instanceof Bundle) {
            return O(0, (Bundle) obj);
        }
        if (obj instanceof Collection) {
            return E((Collection) obj);
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Map) {
                return P((Map) obj);
            }
            if (obj instanceof Rect) {
                return D((Rect) obj);
            }
            if (obj instanceof KeyEvent) {
                return Double.valueOf(((KeyEvent) obj).getKeyCode());
            }
            if (obj instanceof UsbDevice) {
                return ((UsbDevice) obj).getDeviceName();
            }
            return null;
        }
        int length = Array.getLength(obj);
        Object[] objArr = new Object[length];
        int i8 = length;
        while (true) {
            i8--;
            if (i8 < 0) {
                return new J3.a(length, objArr);
            }
            objArr[i8] = U(Array.get(obj, i8));
        }
    }

    public static <T> double V(k<T> kVar) {
        return W(kVar.value());
    }

    public static double W(Object obj) {
        if (obj == null) {
            return 0.0d;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        if (obj instanceof CharSequence) {
            return X(obj.toString());
        }
        if (obj instanceof Boolean) {
            return Y(((Boolean) obj).booleanValue());
        }
        if (obj instanceof k) {
            return W(((k) obj).value());
        }
        return Double.NaN;
    }

    public static double X(String str) {
        BigInteger bigInteger;
        int length = str.length();
        for (int i8 = 0; i8 != length; i8++) {
            if (!C(str.charAt(i8))) {
                while (i8 < length && C(str.charAt(length - 1))) {
                    length--;
                }
                if (str.regionMatches(true, i8, "NaN", 0, 3) && i8 + 3 == length) {
                    return Double.NaN;
                }
                if (str.regionMatches(true, i8, "Infinity", 0, 8) && i8 + 8 == length) {
                    return Double.POSITIVE_INFINITY;
                }
                if (str.regionMatches(true, i8, "+Infinity", 0, 9) && i8 + 9 == length) {
                    return Double.POSITIVE_INFINITY;
                }
                if (str.regionMatches(true, i8, "-Infinity", 0, 9) && i8 + 9 == length) {
                    return Double.NEGATIVE_INFINITY;
                }
                try {
                    if (str.regionMatches(i8, "0x", 0, 2)) {
                        return new BigInteger(str.substring(i8 + 2, length), 16).intValue();
                    }
                    if (str.regionMatches(i8, "+0x", 0, 3)) {
                        return new BigInteger(str.substring(i8 + 3, length), 16).intValue();
                    }
                    if (str.regionMatches(i8, "-0x", 0, 3)) {
                        bigInteger = new BigInteger(str.substring(i8 + 3, length), 16);
                    } else {
                        if (str.regionMatches(i8, "0b", 0, 2)) {
                            return new BigInteger(str.substring(i8 + 2, length), 2).intValue();
                        }
                        if (str.regionMatches(i8, "+0b", 0, 3)) {
                            return new BigInteger(str.substring(i8 + 3, length), 2).intValue();
                        }
                        if (!str.regionMatches(i8, "-0b", 0, 3)) {
                            return Double.parseDouble(str.substring(i8));
                        }
                        bigInteger = new BigInteger(str.substring(i8 + 3, length), 2);
                    }
                    return -bigInteger.intValue();
                } catch (NumberFormatException unused) {
                    return Double.NaN;
                }
            }
        }
        return 0.0d;
    }

    public static double Y(boolean z7) {
        return z7 ? 1.0d : 0.0d;
    }

    public static <T> double Z(k<T> kVar) {
        return a0(kVar.value());
    }

    public static String a(int i8, CharSequence charSequence) {
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length + 8);
        if ((i8 & 1) != 0) {
            b(charSequence, length, i8, sb);
        } else {
            sb.append('\"');
            b(charSequence, length, i8, sb);
            sb.append('\"');
        }
        return sb.toString();
    }

    public static double a0(Object obj) {
        if (obj == null) {
            return 0.0d;
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (number instanceof J3.b) {
                throw new NumberFormatException("Can't convert bigint to number");
            }
            return number.doubleValue();
        }
        if (obj instanceof CharSequence) {
            return X(obj.toString());
        }
        if (obj instanceof Boolean) {
            return Y(((Boolean) obj).booleanValue());
        }
        if (obj instanceof k) {
            return Z((k) obj);
        }
        return Double.NaN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0086, code lost:
    
        if ((r11 & 2) != 0) goto L50;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0049. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(CharSequence charSequence, int i8, int i9, StringBuilder sb) {
        String str;
        int i10 = 0;
        if ((i9 & 4) != 0) {
            while (true) {
                i8--;
                if (i8 < 0) {
                    return;
                }
                int i11 = i10 + 1;
                char charAt = charSequence.charAt(i10);
                if (charAt != ';') {
                    if (charAt != '{') {
                        if (charAt != '}') {
                            sb.append(charAt);
                            i10 = i11;
                        }
                    }
                    sb.append('\\');
                    sb.append(charAt);
                    i10 = i11;
                }
                if ((i9 & 2) == 0) {
                    sb.append(charAt);
                    i10 = i11;
                }
                sb.append('\\');
                sb.append(charAt);
                i10 = i11;
            }
        } else {
            int i12 = 0;
            while (true) {
                i8--;
                if (i8 < 0) {
                    return;
                }
                int i13 = i12 + 1;
                char charAt2 = charSequence.charAt(i12);
                if (charAt2 == '\f') {
                    str = "\\f";
                } else if (charAt2 != '\r') {
                    if (charAt2 != '\"') {
                        if (charAt2 != ';') {
                            if (charAt2 != '\\' && charAt2 != '{') {
                                if (charAt2 != '}') {
                                    switch (charAt2) {
                                        case '\b':
                                            str = "\\b";
                                            break;
                                        case '\t':
                                            str = "\\t";
                                            break;
                                        case '\n':
                                            str = "\\n";
                                            break;
                                        default:
                                            if (charAt2 < ' ' || ((charAt2 >= 128 && charAt2 < 160) || ((charAt2 >= 8192 && charAt2 < 8448) || (charAt2 >= 55296 && charAt2 <= 57343)))) {
                                                str = Integer.toHexString(charAt2);
                                                sb.append("\\u0000", 0, 6 - str.length());
                                                break;
                                            }
                                            sb.append(charAt2);
                                            break;
                                    }
                                    i12 = i13;
                                }
                            }
                        }
                    }
                    sb.append('\\');
                    sb.append(charAt2);
                    i12 = i13;
                } else {
                    str = "\\r";
                }
                sb.append(str);
                i12 = i13;
            }
        }
    }

    public static n b0(String str, n nVar, n nVar2, com.llamalab.safs.e eVar) {
        if (str == null) {
            return nVar;
        }
        if (nVar2 != null) {
            return ".".equals(str) ? nVar2 : nVar2.r(str);
        }
        AbstractC2313a abstractC2313a = (AbstractC2313a) eVar;
        abstractC2313a.getClass();
        return abstractC2313a.f(s4.d.q(str, new String[0]));
    }

    public static C1231k c(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0) {
        String x7 = x(c1708z0, interfaceC1700x0, null);
        if (x7 != null) {
            return C1231k.z(c1708z0, x7);
        }
        return null;
    }

    public static String c0(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof Number) {
            if (!(obj instanceof J3.b)) {
                return d0(((Number) obj).doubleValue());
            }
            return obj.toString() + 'n';
        }
        int i8 = 0;
        if (obj instanceof CharSequence) {
            return a(0, (CharSequence) obj);
        }
        String str = "";
        if (obj instanceof J3.a) {
            J3.a aVar = (J3.a) obj;
            StringBuilder sb = new StringBuilder("[");
            int i9 = aVar.f4627Y;
            while (true) {
                i9--;
                if (i9 < 0) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(str);
                sb.append(c0(aVar.f4626X[i8]));
                i8++;
                str = ", ";
            }
        } else {
            if (!(obj instanceof e)) {
                if (obj instanceof k) {
                    return ((k) obj).x(0);
                }
                throw new IllegalArgumentException(obj.getClass().getName());
            }
            e eVar = (e) obj;
            StringBuilder sb2 = new StringBuilder("{");
            C1231k c1231k = (C1231k) eVar.f9362Z;
            while (true) {
                if (!(c1231k != eVar)) {
                    sb2.append('}');
                    return sb2.toString();
                }
                if (c1231k == eVar) {
                    throw new NoSuchElementException();
                }
                C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                e.a aVar2 = (e.a) c1231k;
                sb2.append(str);
                sb2.append(c0(aVar2.f4645y0));
                if (aVar2.f4646y1 != null) {
                    sb2.append(" as ");
                    sb2.append(aVar2.f4646y1);
                }
                sb2.append(": ");
                sb2.append(c0(aVar2.f4644x1));
                str = ", ";
                c1231k = c1231k2;
            }
        }
    }

    public static Bundle d(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0) {
        e h8 = h(c1708z0, interfaceC1700x0);
        if (h8 == null || h8.isEmpty()) {
            return null;
        }
        Bundle K7 = K(h8);
        if (!K7.containsKey("android:activity.packageName")) {
            K7.putString("android:activity.packageName", c1708z0.getPackageName());
        }
        return K7;
    }

    public static String d0(double d8) {
        if (d8 == 0.0d) {
            return "0";
        }
        if (d8 != d8) {
            return "NaN";
        }
        if (d8 == Double.POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d8 == Double.NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        long j8 = (long) d8;
        return ((double) j8) == d8 ? Long.toString(j8) : Double.toString(d8);
    }

    public static J3.a e(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0) {
        if (interfaceC1700x0 == null) {
            return null;
        }
        Object c22 = interfaceC1700x0.c2(c1708z0);
        if (c22 instanceof J3.a) {
            return (J3.a) c22;
        }
        if (c22 != null) {
            return new J3.a(1, new Object[]{c22});
        }
        return null;
    }

    public static String e0(Object obj) {
        return f0("null", obj);
    }

    public static boolean f(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, boolean z7) {
        Object c22;
        return (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) ? z7 : J(c22);
    }

    public static String f0(String str, Object obj) {
        if (obj == null) {
            return str;
        }
        if (obj instanceof Number) {
            return obj instanceof J3.b ? obj.toString() : d0(((Number) obj).doubleValue());
        }
        if (!(obj instanceof CharSequence) && (obj instanceof k)) {
            return e0(((k) obj).value());
        }
        return obj.toString();
    }

    public static Uri g(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, Uri uri) {
        Uri fromFile = Uri.fromFile(Environment.getExternalStorageDirectory());
        String x7 = x(c1708z0, interfaceC1700x0, null);
        if (x7 == null) {
            return uri;
        }
        Uri parse = Uri.parse(x7);
        if (fromFile != null) {
            parse = C2212a.a(fromFile, parse);
        }
        return parse;
    }

    public static J3.a g0(HashSet hashSet) {
        int size = hashSet.size();
        Object[] objArr = new Object[size];
        Iterator it = hashSet.iterator();
        int i8 = -1;
        while (it.hasNext()) {
            i8++;
            objArr[i8] = f0(null, it.next());
        }
        return new J3.a(size, objArr);
    }

    public static e h(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0) {
        if (interfaceC1700x0 == null) {
            return null;
        }
        Object c22 = interfaceC1700x0.c2(c1708z0);
        if (c22 instanceof e) {
            return (e) c22;
        }
        return null;
    }

    public static <T> J3.a h0(T[] tArr) {
        int length = tArr.length;
        Object[] objArr = new Object[length];
        int i8 = length;
        while (true) {
            i8--;
            if (i8 < 0) {
                return new J3.a(length, objArr);
            }
            objArr[i8] = f0(null, tArr[i8]);
        }
    }

    public static double i(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, double d8) {
        Object c22;
        return (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) ? d8 : W(c22);
    }

    public static String[] i0(J3.a aVar) {
        int i8 = aVar.f4627Y;
        String[] strArr = new String[i8];
        while (true) {
            i8--;
            if (i8 < 0) {
                return strArr;
            }
            strArr[i8] = f0(null, aVar.get(i8));
        }
    }

    public static Double j(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0) {
        Object c22;
        if (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) {
            return null;
        }
        return Double.valueOf(W(c22));
    }

    public static ArrayList<String> j0(J3.a aVar) {
        int i8 = aVar.f4627Y;
        ArrayList<String> arrayList = new ArrayList<>(i8);
        int i9 = 0;
        while (true) {
            i8--;
            if (i8 < 0) {
                return arrayList;
            }
            arrayList.add(f0(null, aVar.get(i9)));
            i9++;
        }
    }

    public static File k(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, File file, File file2) {
        String x7 = x(c1708z0, interfaceC1700x0, null);
        if (x7 == null) {
            return file;
        }
        File file3 = new File(x7);
        return (file2 == null || file3.isAbsolute()) ? file3 : new File(file2, x7);
    }

    public static float l(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, float f8) {
        Object c22;
        return (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) ? f8 : (float) W(c22);
    }

    public static int m(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, int i8) {
        Object c22;
        return (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) ? i8 : R(c22);
    }

    public static int[] n(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, int[] iArr) {
        if (interfaceC1700x0 != null) {
            Object c22 = interfaceC1700x0.c2(c1708z0);
            if (c22 instanceof J3.a) {
                return S((J3.a) c22);
            }
            if (c22 != null) {
                return new int[]{R(c22)};
            }
        }
        return iArr;
    }

    public static Integer o(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, Integer num) {
        Object c22;
        return (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) ? num : Integer.valueOf(R(c22));
    }

    public static n p(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0) {
        C1949c c1949c = (C1949c) f.a.f17733a;
        return v(c1708z0, interfaceC1700x0, null, c1949c.v(), c1949c);
    }

    public static n[] q(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, n[] nVarArr) {
        Object u8 = u(c1708z0, interfaceC1700x0, null);
        if (!(u8 instanceof J3.a)) {
            C1949c c1949c = (C1949c) f.a.f17733a;
            n b02 = b0(f0(null, u8), null, c1949c.v(), c1949c);
            return b02 != null ? new n[]{b02} : nVarArr;
        }
        J3.a aVar = (J3.a) u8;
        C1949c c1949c2 = (C1949c) f.a.f17733a;
        n v8 = c1949c2.v();
        int i8 = aVar.f4627Y;
        n[] nVarArr2 = new n[i8];
        while (true) {
            i8--;
            if (i8 < 0) {
                return nVarArr2;
            }
            nVarArr2[i8] = b0(f0(null, aVar.get(i8)), null, v8, c1949c2);
        }
    }

    public static Locale r(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, Locale locale) {
        return interfaceC1700x0 != null ? C2440r.A(f0(null, interfaceC1700x0.c2(c1708z0)), locale) : locale;
    }

    public static long s(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0) {
        Object c22;
        if (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) {
            return 0L;
        }
        return T(c22);
    }

    public static long t(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, long j8) {
        Object c22;
        return (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) ? j8 : (long) (W(c22) * 1000.0d);
    }

    public static Object u(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, Object obj) {
        Object c22;
        return (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) ? obj : c22;
    }

    public static n v(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, n nVar, n nVar2, com.llamalab.safs.e eVar) {
        return b0(x(c1708z0, interfaceC1700x0, null), nVar, nVar2, eVar);
    }

    public static String[] w(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, String[] strArr) {
        if (interfaceC1700x0 != null) {
            Object c22 = interfaceC1700x0.c2(c1708z0);
            if (c22 instanceof J3.a) {
                return i0((J3.a) c22);
            }
            if (c22 != null) {
                return f4650a.split(e0(c22));
            }
        }
        return strArr;
    }

    public static String x(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, String str) {
        return interfaceC1700x0 != null ? f0(str, interfaceC1700x0.c2(c1708z0)) : str;
    }

    public static String[] y(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0) {
        if (interfaceC1700x0 == null) {
            return null;
        }
        Object c22 = interfaceC1700x0.c2(c1708z0);
        if (c22 instanceof J3.a) {
            return i0((J3.a) c22);
        }
        if (c22 != null) {
            return new String[]{e0(c22)};
        }
        return null;
    }

    public static TimeZone z(C1708z0 c1708z0, InterfaceC1700x0 interfaceC1700x0, TimeZone timeZone) {
        Object c22;
        return (interfaceC1700x0 == null || (c22 = interfaceC1700x0.c2(c1708z0)) == null) ? timeZone : TimeZone.getTimeZone(e0(c22));
    }
}
