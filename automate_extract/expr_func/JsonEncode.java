package com.llamalab.automate.expr.func;

import J3.e;
import J3.h;
import androidx.appcompat.widget.C1231k;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.expr.ConversionType;
import e4.C1758a;
import java.io.IOException;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class JsonEncode extends UnaryFunction {
    public static final String NAME = "jsonEncode";

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15717a;

        static {
            int[] iArr = new int[ConversionType.values().length];
            f15717a = iArr;
            try {
                iArr[ConversionType.BooleanArray.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15717a[ConversionType.DoubleArray.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15717a[ConversionType.StringArray.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15717a[ConversionType.Boolean.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15717a[ConversionType.Double.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15717a[ConversionType.String.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static CharSequence b(Object obj) {
        StringBuilder sb = new StringBuilder();
        C1758a c1758a = new C1758a(sb);
        try {
            c(obj, c1758a, null);
            c1758a.close();
            return sb;
        } catch (Throwable th) {
            c1758a.close();
            throw th;
        }
    }

    public static void c(Object obj, C1758a c1758a, ConversionType conversionType) {
        if (obj == null) {
            c1758a.i();
            return;
        }
        if (obj instanceof J3.a) {
            if (conversionType != null) {
                int i8 = a.f15717a[conversionType.ordinal()];
                if (i8 == 1) {
                    conversionType = ConversionType.Boolean;
                } else if (i8 == 2) {
                    conversionType = ConversionType.Double;
                } else if (i8 == 3) {
                    conversionType = ConversionType.String;
                }
            }
            c1758a.f();
            c1758a.a('[');
            J3.a aVar = (J3.a) obj;
            int i9 = 0;
            while (true) {
                if (!(i9 < aVar.f4627Y)) {
                    c1758a.a(']');
                    c1758a.f18162Y = true;
                    return;
                } else {
                    if (i9 >= aVar.f4627Y) {
                        throw new NoSuchElementException();
                    }
                    c(aVar.get(i9), c1758a, conversionType);
                    i9++;
                }
            }
        } else {
            if (!(obj instanceof e)) {
                if (conversionType != null) {
                    int i10 = a.f15717a[conversionType.ordinal()];
                    if (i10 == 4) {
                        c1758a.x(h.J(obj));
                        return;
                    } else if (i10 == 5) {
                        c1758a.v(h.W(obj));
                        return;
                    } else if (i10 == 6) {
                        c1758a.p(h.e0(obj));
                        return;
                    }
                }
                if (obj instanceof Number) {
                    c1758a.r((Number) obj);
                    return;
                } else if (obj instanceof CharSequence) {
                    c1758a.p(obj.toString());
                    return;
                } else {
                    throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                }
            }
            c1758a.n();
            e eVar = (e) obj;
            C1231k c1231k = (C1231k) eVar.f9362Z;
            while (true) {
                if (!(c1231k != eVar)) {
                    c1758a.g();
                    return;
                } else {
                    if (c1231k == eVar) {
                        throw new NoSuchElementException();
                    }
                    C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                    e.a aVar2 = (e.a) c1231k;
                    c1758a.m(aVar2.f4645y0);
                    c(aVar2.f4644x1, c1758a, aVar2.f4646y1);
                    c1231k = c1231k2;
                }
            }
        }
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        Object c22 = this.f4947X.c2(c1708z0);
        if (c22 == null) {
            return null;
        }
        try {
            return b(c22).toString();
        } catch (IOException e8) {
            throw new RuntimeException(e8);
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
