package com.llamalab.automate.expr.func;

import D1.P;
import F3.g;
import J3.h;
import W3.a;
import android.graphics.Color;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import java.math.BigInteger;
import java.util.Locale;
import java.util.regex.Pattern;
import y4.j;

@g(2)
/* loaded from: classes.dex */
public final class ColorRecode extends TernaryFunction {
    public static final String NAME = "colorRecode";

    /* renamed from: x0, reason: collision with root package name */
    public static final Pattern f15716x0 = Pattern.compile("\\s+");

    public static int b(double d8, double[] dArr) {
        return Color.argb(c(d8), c(dArr[0]), c(dArr[1]), c(dArr[2]));
    }

    public static int c(double d8) {
        return j.d((int) ((d8 * 255.0d) + 0.5d), 0, 255);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        String[] strArr;
        a aVar;
        int intValue;
        double[] dArr;
        InterfaceC1700x0 interfaceC1700x0;
        int alpha;
        double i8;
        double[] dArr2;
        double[] dArr3;
        char c8;
        Object c22 = this.f4940X.c2(c1708z0);
        if (c22 == null) {
            return c22;
        }
        String[] split = f15716x0.split(h.x(c1708z0, this.f4941Y, ""));
        int length = split.length;
        int i9 = 0;
        char c9 = 0;
        a aVar2 = null;
        double[] dArr4 = null;
        double d8 = 1.0d;
        while (i9 < length) {
            String str = split[i9];
            boolean equalsIgnoreCase = "pack".equalsIgnoreCase(str);
            a.b bVar = a.f7161X;
            if (equalsIgnoreCase) {
                if (bVar != aVar2) {
                    throw new IllegalArgumentException("transform");
                }
                c22 = Double.valueOf(b(d8, dArr4));
            } else if ("hex".equalsIgnoreCase(str)) {
                if (bVar != aVar2) {
                    throw new IllegalArgumentException("transform");
                }
                c22 = Integer.toHexString(b(d8, dArr4));
            } else if (!"hex-argb8".equalsIgnoreCase(str)) {
                if ("hex-rgba8".equalsIgnoreCase(str)) {
                    if (bVar != aVar2) {
                        throw new IllegalArgumentException("transform");
                    }
                    c22 = String.format(Locale.US, "%02x%02x%02x%02x", Integer.valueOf(c(dArr4[0])), Integer.valueOf(c(dArr4[1])), Integer.valueOf(c(dArr4[2])), Integer.valueOf(c(d8)));
                    strArr = split;
                    aVar = aVar2;
                    dArr3 = dArr4;
                    c8 = 2;
                } else if (!"hex-rgb6".equalsIgnoreCase(str)) {
                    a[] values = a.values();
                    int length2 = values.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length2) {
                            strArr = split;
                            aVar = null;
                            break;
                        }
                        a aVar3 = values[i10];
                        strArr = split;
                        if (aVar3.name().equalsIgnoreCase(str)) {
                            aVar = aVar3;
                            break;
                        }
                        i10++;
                        split = strArr;
                    }
                    if (aVar == null) {
                        throw new IllegalArgumentException("transform");
                    }
                    if (aVar2 != null) {
                        dArr3 = aVar.g(aVar2, dArr4);
                    } else {
                        if (c22 instanceof J3.a) {
                            J3.a aVar4 = (J3.a) c22;
                            if (aVar4.f4627Y != aVar.f()) {
                                throw new IllegalArgumentException("color");
                            }
                            int i11 = aVar4.f4627Y;
                            dArr2 = new double[i11];
                            while (true) {
                                i11--;
                                if (i11 < 0) {
                                    break;
                                }
                                dArr2[i11] = h.W(aVar4.get(i11));
                            }
                            i8 = h.i(c1708z0, this.f4942Z, 1.0d);
                        } else {
                            if (aVar.ordinal() != 1) {
                                throw new IllegalArgumentException("color");
                            }
                            if (c22 instanceof Double) {
                                intValue = ((Double) c22).intValue();
                            } else {
                                if (!(c22 instanceof String)) {
                                    throw new IllegalArgumentException("color");
                                }
                                intValue = new BigInteger((String) c22, 16).intValue();
                            }
                            if (2 == c9) {
                                double d9 = (intValue >>> 24) & 255;
                                Double.isNaN(d9);
                                Double.isNaN(d9);
                                double d10 = (intValue >>> 16) & 255;
                                Double.isNaN(d10);
                                Double.isNaN(d10);
                                double d11 = (intValue >>> 8) & 255;
                                Double.isNaN(d11);
                                Double.isNaN(d11);
                                dArr = new double[]{d9 / 255.0d, d10 / 255.0d, d11 / 255.0d};
                                alpha = intValue & 255;
                                interfaceC1700x0 = this.f4942Z;
                            } else {
                                double red = Color.red(intValue);
                                Double.isNaN(red);
                                Double.isNaN(red);
                                double green = Color.green(intValue);
                                Double.isNaN(green);
                                Double.isNaN(green);
                                double blue = Color.blue(intValue);
                                Double.isNaN(blue);
                                Double.isNaN(blue);
                                dArr = new double[]{red / 255.0d, green / 255.0d, blue / 255.0d};
                                interfaceC1700x0 = this.f4942Z;
                                alpha = Color.alpha(intValue);
                            }
                            double d12 = alpha;
                            Double.isNaN(d12);
                            Double.isNaN(d12);
                            i8 = h.i(c1708z0, interfaceC1700x0, d12 / 255.0d);
                            dArr2 = dArr;
                        }
                        d8 = i8;
                        dArr3 = dArr2;
                    }
                    c8 = 0;
                } else {
                    if (bVar != aVar2) {
                        throw new IllegalArgumentException("transform");
                    }
                    c22 = String.format(Locale.US, "%02x%02x%02x", Integer.valueOf(c(dArr4[0])), Integer.valueOf(c(dArr4[1])), Integer.valueOf(c(dArr4[2])));
                    strArr = split;
                    aVar = aVar2;
                    dArr3 = dArr4;
                    d8 = 1.0d;
                    c8 = 3;
                }
                i9++;
                aVar2 = aVar;
                dArr4 = dArr3;
                c9 = c8;
                split = strArr;
            } else {
                if (bVar != aVar2) {
                    throw new IllegalArgumentException("transform");
                }
                c22 = String.format(Locale.US, "%02x%02x%02x%02x", Integer.valueOf(c(d8)), Integer.valueOf(c(dArr4[0])), Integer.valueOf(c(dArr4[1])), Integer.valueOf(c(dArr4[2])));
            }
            strArr = split;
            aVar = aVar2;
            dArr3 = dArr4;
            c8 = 1;
            i9++;
            aVar2 = aVar;
            dArr4 = dArr3;
            c9 = c8;
            split = strArr;
        }
        return c9 == 0 ? aVar2 != null ? h.G(dArr4, aVar2.f()) : P.g(c22, null) : c22;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
