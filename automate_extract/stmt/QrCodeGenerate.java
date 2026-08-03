package com.llamalab.automate.stmt;

import E4.d;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.image.ImageCodec;
import com.llamalab.image.ImageEncoder;
import com.llamalab.image.PixelFormat;
import com.llamalab.image.png.PngCodec;
import io.nayuki.qrcodegen.DataTooLongException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import l4.InterfaceC2065a;
import p3.C2213b;
import s.C2279g;

@F3.f("qrcode_generate.html")
@F3.a(C2541R.integer.ic_qr_code_2)
@F3.i(C2541R.string.stmt_qrcode_generate_title)
@F3.h(C2541R.string.stmt_qrcode_generate_summary)
@F3.e(C2541R.layout.stmt_qrcode_generate_edit)
/* loaded from: classes.dex */
public final class QrCodeGenerate extends Action implements AsyncStatement {
    public InterfaceC1700x0 content;
    public InterfaceC1700x0 errorCorrectionLevel;
    public InterfaceC1700x0 mimeType;
    public InterfaceC1700x0 padding;
    public InterfaceC1700x0 targetPath;
    public J3.l varImageFile;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final E4.c f17060L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f17061M1;

        /* renamed from: N1, reason: collision with root package name */
        public final com.llamalab.safs.n f17062N1;

        public a(E4.c cVar, int i8, com.llamalab.safs.n nVar) {
            this.f17060L1 = cVar;
            this.f17061M1 = i8;
            this.f17062N1 = nVar;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            int i8;
            PixelFormat pixelFormat = PixelFormat.GRAY_1;
            E4.c cVar = this.f17060L1;
            int i9 = cVar.f3476b;
            int i10 = this.f17061M1;
            int i11 = (i10 * 2) + i9;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(pixelFormat.getBitmapSize(i11, i11));
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    break;
                }
                int i13 = 0;
                while (i13 < i11) {
                    int i14 = 8;
                    int i15 = 0;
                    while (true) {
                        i14--;
                        if (i14 >= 0) {
                            int i16 = i13 - i10;
                            int i17 = i12 - i10;
                            if (!(i16 >= 0 && i16 < (i8 = cVar.f3476b) && i17 >= 0 && i17 < i8 && cVar.f3478d[i17][i16])) {
                                i15 |= 1 << i14;
                            }
                            i13++;
                        }
                    }
                    allocateDirect.put((byte) i15);
                }
                i12++;
            }
            ImageCodec forMimeType = ImageCodec.forMimeType(PngCodec.MIME_TYPE);
            com.llamalab.safs.n t8 = w0.L.t(this.f17062N1, Environment.DIRECTORY_DCIM, null, C2541R.string.format_image_file, forMimeType.getFilenameSuffix().substring(1));
            try {
                InterfaceC2065a j8 = com.llamalab.safs.i.j(t8, com.llamalab.safs.p.CREATE, com.llamalab.safs.p.TRUNCATE_EXISTING, com.llamalab.safs.p.WRITE);
                try {
                    ImageEncoder encode = forMimeType.encode(j8);
                    try {
                        encode.setSourceFormat(pixelFormat);
                        encode.setBestTargetFormatFor(pixelFormat);
                        encode.setBitmapSize(i11, i11);
                        encode.writeHeader();
                        encode.writeBitmap(allocateDirect);
                        encode.close();
                        if (j8 != null) {
                            j8.close();
                        }
                        q2(t8.toString(), false);
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                com.llamalab.safs.i.f(t8);
                throw th;
            }
        }
    }

    public static final class b extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final E4.c f17063L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f17064M1;

        /* renamed from: N1, reason: collision with root package name */
        public final com.llamalab.safs.n f17065N1;

        public b(E4.c cVar, int i8, com.llamalab.safs.n nVar) {
            this.f17063L1 = cVar;
            this.f17064M1 = i8;
            this.f17065N1 = nVar;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            E4.c cVar = this.f17063L1;
            int i8 = cVar.f3476b;
            int i9 = this.f17064M1;
            int i10 = (i9 * 2) + i8;
            com.llamalab.safs.n t8 = w0.L.t(this.f17065N1, Environment.DIRECTORY_DCIM, null, C2541R.string.format_image_file, "svg");
            try {
                Formatter formatter = new Formatter(com.llamalab.safs.i.i(t8, C2213b.f21560b, com.llamalab.safs.p.CREATE, com.llamalab.safs.p.TRUNCATE_EXISTING, com.llamalab.safs.p.WRITE), Locale.US);
                try {
                    formatter.format("<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 %d %d\">", Integer.valueOf(i10), Integer.valueOf(i10)).out().append("<rect fill=\"white\" width=\"100%\" height=\"100%\"/>").append("<path fill=\"black\" d=\"");
                    int i11 = 0;
                    while (true) {
                        int i12 = cVar.f3476b;
                        if (i11 >= i12) {
                            formatter.out().append("\"/>").append("</svg>");
                            if (formatter.ioException() != null) {
                                throw formatter.ioException();
                            }
                            formatter.close();
                            q2(t8.toString(), false);
                            return;
                        }
                        int i13 = 0;
                        while (i13 < i12) {
                            if (i13 >= 0 && i13 < i12 && i11 >= 0 && i11 < i12 && cVar.f3478d[i11][i13]) {
                                if ((i13 | i11) != 0) {
                                    formatter.out().append(' ');
                                }
                                formatter.format("M%d,%dh1v1h-1z", Integer.valueOf(i13 + i9), Integer.valueOf(i11 + i9));
                            }
                            i13++;
                        }
                        if (formatter.ioException() != null) {
                            throw formatter.ioException();
                        }
                        i11++;
                    }
                } catch (Throwable th) {
                    try {
                        formatter.close();
                    } catch (Throwable th2) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                com.llamalab.safs.i.f(t8);
                throw th3;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_qrcode_generate_title);
        l8.t(this.targetPath);
        return l8.q(this.targetPath).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.content);
        dVar.g(this.errorCorrectionLevel);
        dVar.g(this.padding);
        dVar.g(this.targetPath);
        dVar.g(this.mimeType);
        dVar.g(this.varImageFile);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.content);
        visitor.b(this.errorCorrectionLevel);
        visitor.b(this.padding);
        visitor.b(this.targetPath);
        visitor.b(this.mimeType);
        visitor.b(this.varImageFile);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.content = (InterfaceC1700x0) cVar.readObject();
        this.errorCorrectionLevel = (InterfaceC1700x0) cVar.readObject();
        this.padding = (InterfaceC1700x0) cVar.readObject();
        this.targetPath = (InterfaceC1700x0) cVar.readObject();
        this.mimeType = (InterfaceC1700x0) cVar.readObject();
        this.varImageFile = (J3.l) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x026d, code lost:
    
        throw new java.lang.IndexOutOfBoundsException();
     */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        int i8;
        int i9;
        int i10;
        E4.d dVar;
        c1708z0.q(C2541R.string.stmt_qrcode_generate_title);
        String x7 = J3.h.x(c1708z0, this.content, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("content");
        }
        int i11 = 1;
        int i12 = C2279g.c(4)[y4.j.d(J3.h.m(c1708z0, this.errorCorrectionLevel, 1), 0, 3)];
        int max = Math.max(0, J3.h.o(c1708z0, this.padding, 1).intValue());
        String x8 = J3.h.x(c1708z0, this.mimeType, PngCodec.MIME_TYPE);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.targetPath);
        if (i12 == 0) {
            throw null;
        }
        Pattern pattern = E4.d.f3480d;
        ArrayList arrayList = new ArrayList();
        if (!x7.equals("")) {
            Pattern pattern2 = E4.d.f3480d;
            if (!pattern2.matcher(x7).matches()) {
                Pattern pattern3 = E4.d.f3481e;
                if (!pattern3.matcher(x7).matches()) {
                    byte[] bytes = x7.getBytes(E4.b.f3472a);
                    bytes.getClass();
                    E4.a aVar = new E4.a();
                    for (byte b8 : bytes) {
                        aVar.a(b8 & 255, 8);
                    }
                    dVar = new E4.d(d.a.BYTE, bytes.length, aVar);
                } else {
                    if (!pattern3.matcher(x7).matches()) {
                        throw new IllegalArgumentException("String contains unencodable characters in alphanumeric mode");
                    }
                    E4.a aVar2 = new E4.a();
                    int i13 = 0;
                    while (i13 <= x7.length() - 2) {
                        aVar2.a("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".indexOf(x7.charAt(i13 + 1)) + ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".indexOf(x7.charAt(i13)) * 45), 11);
                        i13 += 2;
                    }
                    if (i13 < x7.length()) {
                        aVar2.a("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".indexOf(x7.charAt(i13)), 6);
                    }
                    dVar = new E4.d(d.a.ALPHANUMERIC, x7.length(), aVar2);
                }
            } else {
                if (!pattern2.matcher(x7).matches()) {
                    throw new IllegalArgumentException("String contains non-numeric characters");
                }
                E4.a aVar3 = new E4.a();
                int i14 = 0;
                while (i14 < x7.length()) {
                    int min = Math.min(x7.length() - i14, 3);
                    int i15 = i14 + min;
                    aVar3.a(Integer.parseInt(x7.subSequence(i14, i15).toString()), (min * 3) + 1);
                    i14 = i15;
                }
                dVar = new E4.d(d.a.NUMERIC, x7.length(), aVar3);
            }
            arrayList.add(dVar);
        }
        int i16 = 1;
        while (true) {
            int g8 = E4.c.g(i16, i12) * 8;
            Pattern pattern4 = E4.d.f3480d;
            Iterator it = arrayList.iterator();
            long j8 = 0;
            while (it.hasNext()) {
                E4.d dVar2 = (E4.d) it.next();
                dVar2.getClass();
                d.a aVar4 = dVar2.f3482a;
                aVar4.getClass();
                int i17 = aVar4.f3490Y[(i16 + 7) / 17];
                if (dVar2.f3483b >= (i11 << i17)) {
                    i8 = i12;
                } else {
                    i8 = i12;
                    Iterator it2 = it;
                    j8 += i17 + 4 + dVar2.f3484c.f3471Y;
                    if (j8 <= 2147483647L) {
                        it = it2;
                        i12 = i8;
                        i11 = 1;
                    }
                }
                i9 = -1;
            }
            i8 = i12;
            i9 = (int) j8;
            if (i9 != -1 && i9 <= g8) {
                int i18 = i8;
                for (int i19 : C2279g.c(4)) {
                    if (i9 <= E4.c.g(i16, i19) * 8) {
                        i18 = i19;
                    }
                }
                E4.a aVar5 = new E4.a();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    E4.d dVar3 = (E4.d) it3.next();
                    aVar5.a(dVar3.f3482a.f3489X, 4);
                    d.a aVar6 = dVar3.f3482a;
                    aVar6.getClass();
                    aVar5.a(dVar3.f3483b, aVar6.f3490Y[(i16 + 7) / 17]);
                    E4.a aVar7 = dVar3.f3484c;
                    aVar7.getClass();
                    if (Integer.MAX_VALUE - aVar5.f3471Y < aVar7.f3471Y) {
                        throw new IllegalStateException("Maximum length reached");
                    }
                    int i20 = 0;
                    while (i20 < aVar7.f3471Y) {
                        aVar5.f3470X.set(aVar5.f3471Y, aVar7.f3470X.get(i20));
                        i20++;
                        aVar5.f3471Y++;
                    }
                }
                int g9 = E4.c.g(i16, i18) * 8;
                aVar5.a(0, Math.min(4, g9 - aVar5.f3471Y));
                aVar5.a(0, (8 - (aVar5.f3471Y % 8)) % 8);
                int i21 = MoreOsConstants.KEY_BATTERY;
                while (true) {
                    i10 = aVar5.f3471Y;
                    if (i10 >= g9) {
                        break;
                    }
                    aVar5.a(i21, 8);
                    i21 ^= 253;
                }
                byte[] bArr = new byte[i10 / 8];
                int i22 = 0;
                while (true) {
                    int i23 = aVar5.f3471Y;
                    if (i22 >= i23) {
                        E4.c cVar = new E4.c(i16, i18, bArr);
                        x8.getClass();
                        AbstractRunnableC1694v2 aVar8 = !x8.equals("image/svg+xml") ? new a(cVar, max, p8) : new b(cVar, max, p8);
                        c1708z0.w(aVar8);
                        aVar8.w2();
                        return false;
                    }
                    int i24 = i22 >>> 3;
                    byte b9 = bArr[i24];
                    if (i22 < 0 || i22 >= i23) {
                        break;
                    }
                    bArr[i24] = (byte) (((aVar5.f3470X.get(i22) ? 1 : 0) << (7 - (i22 & 7))) | b9);
                    i22++;
                }
            } else {
                if (i16 >= 40) {
                    throw new DataTooLongException(i9 != -1 ? String.format(Locale.US, "Data length = %d bits, Max capacity = %d bits", Integer.valueOf(i9), Integer.valueOf(g8)) : "Segment too long");
                }
                i16++;
                i12 = i8;
                i11 = 1;
            }
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varImageFile;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, (String) obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
