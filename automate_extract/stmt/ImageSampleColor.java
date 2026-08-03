package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.image.ImageOps;
import com.llamalab.image.PixelFormat;
import com.llamalab.image.UnsupportedFormatException;

@F3.f("image_sample_color.html")
@F3.a(C2541R.integer.ic_colorize)
@F3.i(C2541R.string.stmt_image_sample_color_title)
@F3.h(C2541R.string.stmt_image_sample_color_summary)
@F3.e(C2541R.layout.stmt_image_sample_color_edit)
/* loaded from: classes.dex */
public final class ImageSampleColor extends Action implements AsyncStatement {
    public InterfaceC1700x0 centerX;
    public InterfaceC1700x0 centerY;
    public InterfaceC1700x0 sampleSize;
    public J3.l varColorModel;
    public J3.l varSampledAlpha;
    public J3.l varSampledComponents;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16726a;

        static {
            int[] iArr = new int[PixelFormat.values().length];
            f16726a = iArr;
            try {
                iArr[PixelFormat.GRAY_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16726a[PixelFormat.GRAY_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16726a[PixelFormat.GRAY_4.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16726a[PixelFormat.GRAY_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16726a[PixelFormat.GRAY_16.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16726a[PixelFormat.GRAY_ALPHA_88.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16726a[PixelFormat.GRAY_ALPHA_1616.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16726a[PixelFormat.ALPHA_GRAY_88.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16726a[PixelFormat.ALPHA_GRAY_1616.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f16726a[PixelFormat.RGB_565.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f16726a[PixelFormat.RGB_888.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f16726a[PixelFormat.RGB_161616.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f16726a[PixelFormat.RGBA_8888.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f16726a[PixelFormat.RGBA_1010102.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f16726a[PixelFormat.RGBA_16161616.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f16726a[PixelFormat.RGBA_FP16.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f16726a[PixelFormat.RGBX_8888.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f16726a[PixelFormat.RGBX_16161616.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f16726a[PixelFormat.ARGB_4444.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f16726a[PixelFormat.ARGB_8888.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f16726a[PixelFormat.ARGB_16161616.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f16726a[PixelFormat.XRGB_8888.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f16726a[PixelFormat.XRGB_16161616.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f16726a[PixelFormat.BGR_888.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f16726a[PixelFormat.BGR_161616.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f16726a[PixelFormat.BGRA_8888.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f16726a[PixelFormat.BGRA_16161616.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f16726a[PixelFormat.BGRX_8888.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f16726a[PixelFormat.BGRX_16161616.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f16726a[PixelFormat.ABGR_8888.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f16726a[PixelFormat.ABGR_16161616.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f16726a[PixelFormat.XBGR_8888.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f16726a[PixelFormat.XBGR_16161616.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f16726a[PixelFormat.YCbCr_888.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f16726a[PixelFormat.CMYK_8888.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f16726a[PixelFormat.INVERTED_CMYK_8888.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f16726a[PixelFormat.ADOBE_YCCK_8888.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
        }
    }

    public static final class b extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final O f16727L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16728M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16729N1;

        /* renamed from: O1, reason: collision with root package name */
        public final int f16730O1;

        /* renamed from: P1, reason: collision with root package name */
        public final int f16731P1;

        public b(O o6, int i8, int i9, int i10, int i11) {
            this.f16727L1 = o6;
            this.f16728M1 = i8;
            this.f16729N1 = i9;
            this.f16730O1 = i10;
            this.f16731P1 = i11;
        }

        public static Object[] A2(double d8, double d9) {
            return new Object[]{"Grayscale", new J3.a(1, new Object[]{Double.valueOf(d8)}), Double.valueOf(d9)};
        }

        public static Object[] B2(double d8, double d9, double d10) {
            return C2(d8, d9, d10, 1.0d);
        }

        public static Object[] C2(double d8, double d9, double d10, double d11) {
            return new Object[]{"RGB", new J3.a(3, new Object[]{Double.valueOf(d8), Double.valueOf(d9), Double.valueOf(d10)}), Double.valueOf(d11)};
        }

        public static Object[] y2(double d8, double d9, double d10, double d11) {
            return new Object[]{"CMYK", new J3.a(4, new Object[]{Double.valueOf(d8), Double.valueOf(d9), Double.valueOf(d10), Double.valueOf(d11)}), Double.valueOf(1.0d)};
        }

        public static Object[] z2(PixelFormat pixelFormat, double[] dArr) {
            int i8 = a.f16726a[pixelFormat.ordinal()];
            Double valueOf = Double.valueOf(1.0d);
            switch (i8) {
                case 1:
                    return A2(dArr[0], 1.0d);
                case 2:
                    return A2(dArr[0] / 3.0d, 1.0d);
                case 3:
                    return A2(dArr[0] / 15.0d, 1.0d);
                case 4:
                    return A2(dArr[0] / 255.0d, 1.0d);
                case 5:
                    return A2(dArr[0] / 65535.0d, 1.0d);
                case 6:
                    return A2(dArr[0] / 255.0d, dArr[1] / 255.0d);
                case 7:
                    return A2(dArr[0] / 65535.0d, dArr[1] / 65535.0d);
                case 8:
                    return A2(dArr[1] / 255.0d, dArr[0] / 255.0d);
                case 9:
                    return A2(dArr[1] / 65535.0d, dArr[0] / 65535.0d);
                case 10:
                    return B2(dArr[0] / 31.0d, dArr[1] / 63.0d, dArr[2] / 31.0d);
                case 11:
                    return B2(dArr[0] / 255.0d, dArr[1] / 255.0d, dArr[2] / 255.0d);
                case 12:
                    return B2(dArr[0] / 65535.0d, dArr[1] / 65535.0d, dArr[2] / 65535.0d);
                case 13:
                    return C2(dArr[0] / 255.0d, dArr[1] / 255.0d, dArr[2] / 255.0d, dArr[3] / 255.0d);
                case 14:
                    return C2(dArr[0] / 1023.0d, dArr[1] / 1023.0d, dArr[2] / 1023.0d, dArr[3] / 3.0d);
                case 15:
                    return C2(dArr[0] / 65535.0d, dArr[1] / 65535.0d, dArr[2] / 65535.0d, dArr[3] / 65535.0d);
                case 16:
                    return C2(dArr[0], dArr[1], dArr[2], dArr[3]);
                case 17:
                    return B2(dArr[0] / 255.0d, dArr[1] / 255.0d, dArr[2] / 255.0d);
                case 18:
                    return B2(dArr[0] / 65535.0d, dArr[1] / 65535.0d, dArr[2] / 65535.0d);
                case 19:
                    return C2(dArr[1] / 15.0d, dArr[2] / 15.0d, dArr[3] / 15.0d, dArr[0] / 15.0d);
                case 20:
                    return C2(dArr[1] / 255.0d, dArr[2] / 255.0d, dArr[3] / 255.0d, dArr[0] / 255.0d);
                case 21:
                    return C2(dArr[1] / 65535.0d, dArr[2] / 65535.0d, dArr[3] / 65535.0d, dArr[0] / 65535.0d);
                case 22:
                    return B2(dArr[1] / 255.0d, dArr[2] / 255.0d, dArr[3] / 255.0d);
                case 23:
                    return B2(dArr[1] / 65535.0d, dArr[2] / 65535.0d, dArr[3] / 65535.0d);
                case 24:
                    return B2(dArr[2] / 255.0d, dArr[1] / 255.0d, dArr[0] / 255.0d);
                case 25:
                    return B2(dArr[2] / 65535.0d, dArr[1] / 65535.0d, dArr[0] / 65535.0d);
                case 26:
                    return C2(dArr[2] / 255.0d, dArr[1] / 255.0d, dArr[0] / 255.0d, dArr[3] / 255.0d);
                case 27:
                    return C2(dArr[2] / 65535.0d, dArr[1] / 65535.0d, dArr[0] / 65535.0d, dArr[3] / 65535.0d);
                case 28:
                    return B2(dArr[2] / 255.0d, dArr[1] / 255.0d, dArr[0] / 255.0d);
                case 29:
                    return B2(dArr[2] / 65535.0d, dArr[1] / 65535.0d, dArr[0] / 65535.0d);
                case 30:
                    return C2(dArr[3] / 255.0d, dArr[2] / 255.0d, dArr[1] / 255.0d, dArr[0] / 255.0d);
                case 31:
                    return C2(dArr[3] / 65535.0d, dArr[2] / 65535.0d, dArr[1] / 65535.0d, dArr[0] / 65535.0d);
                case 32:
                    return B2(dArr[3] / 255.0d, dArr[2] / 255.0d, dArr[1] / 255.0d);
                case 33:
                    return B2(dArr[3] / 65535.0d, dArr[2] / 65535.0d, dArr[1] / 65535.0d);
                case 34:
                    return new Object[]{"YCbCr", new J3.a(3, new Object[]{Double.valueOf(dArr[0] / 255.0d), Double.valueOf((dArr[1] - 128.0d) / 255.0d), Double.valueOf((dArr[2] - 128.0d) / 255.0d)}), valueOf};
                case 35:
                    return y2(dArr[0] / 255.0d, dArr[1] / 255.0d, dArr[2] / 255.0d, dArr[3] / 255.0d);
                case 36:
                    return y2(1.0d - (dArr[0] / 255.0d), 1.0d - (dArr[1] / 255.0d), 1.0d - (dArr[2] / 255.0d), 1.0d - (dArr[3] / 255.0d));
                case 37:
                    return new Object[]{"YCCK", new J3.a(4, new Object[]{Double.valueOf(dArr[0] / 255.0d), Double.valueOf((dArr[1] - 128.0d) / 255.0d), Double.valueOf((dArr[2] - 128.0d) / 255.0d), Double.valueOf(1.0d - (dArr[3] / 255.0d))}), valueOf};
                default:
                    throw new UnsupportedFormatException(pixelFormat.toString());
            }
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            double[] dArr = new double[4];
            O o6 = this.f16727L1;
            if (o6.f17001M1.isIndexed()) {
                ImageOps.sampleColorAverage(o6.v2(this.f15400Y), o6.f17001M1, o6.f17004P1, o6.f17005Q1, o6.y2(this.f15400Y), o6.f17002N1, this.f16728M1, this.f16729N1, this.f16730O1, this.f16731P1, dArr);
                q2(z2(o6.f17002N1, dArr), false);
            } else {
                ImageOps.sampleColorAverage(o6.v2(this.f15400Y), o6.f17001M1, o6.f17004P1, o6.f17005Q1, null, null, this.f16728M1, this.f16729N1, this.f16730O1, this.f16731P1, dArr);
                q2(z2(o6.f17001M1, dArr), false);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_image_sample_color_title);
        l8.v(this.centerX, 0);
        l8.v(this.centerY, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.centerX);
        dVar.g(this.centerY);
        dVar.g(this.sampleSize);
        dVar.g(this.varColorModel);
        dVar.g(this.varSampledComponents);
        dVar.g(this.varSampledAlpha);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.centerX);
        visitor.b(this.centerY);
        visitor.b(this.sampleSize);
        visitor.b(this.varColorModel);
        visitor.b(this.varSampledComponents);
        visitor.b(this.varSampledAlpha);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.centerX = (InterfaceC1700x0) cVar.readObject();
        this.centerY = (InterfaceC1700x0) cVar.readObject();
        this.sampleSize = (InterfaceC1700x0) cVar.readObject();
        this.varColorModel = (J3.l) cVar.readObject();
        this.varSampledComponents = (J3.l) cVar.readObject();
        this.varSampledAlpha = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_image_sample_color_title);
        O o6 = (O) c1708z0.c(O.class);
        if (o6 == null) {
            throw new IllegalStateException("No bitmap loaded");
        }
        Integer o8 = J3.h.o(c1708z0, this.centerX, null);
        Integer o9 = J3.h.o(c1708z0, this.centerY, null);
        int m8 = J3.h.m(c1708z0, this.sampleSize, 1);
        if (o8 == null) {
            throw new RequiredArgumentNullException("x");
        }
        if (o9 == null) {
            throw new RequiredArgumentNullException("y");
        }
        if (o8.intValue() < 0 || o8.intValue() >= o6.f17004P1) {
            throw new IllegalArgumentException("x");
        }
        if (o9.intValue() < 0 || o9.intValue() >= o6.f17005Q1) {
            throw new IllegalArgumentException("y");
        }
        if (m8 < 1 || m8 % 2 == 0) {
            throw new IllegalArgumentException("sampleSize");
        }
        int i8 = m8 / 2;
        int i9 = (m8 + 1) / 2;
        b bVar = new b(o6, Math.max(o8.intValue() - i8, 0), Math.max(o9.intValue() - i8, 0), Math.min(o8.intValue() + i9, o6.f17004P1), Math.min(o9.intValue() + i9, o6.f17005Q1));
        c1708z0.w(bVar);
        bVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varColorModel;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, (String) objArr[0]);
        }
        J3.l lVar2 = this.varSampledComponents;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, (J3.a) objArr[1]);
        }
        J3.l lVar3 = this.varSampledAlpha;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, (Double) objArr[2]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
