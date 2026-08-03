package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.image.ImageCodec;
import com.llamalab.image.ImageEncoder;
import l4.InterfaceC2065a;

@F3.f("image_write.html")
@F3.a(C2541R.integer.ic_add_photo_alternate)
@F3.i(C2541R.string.stmt_image_write_title)
@F3.h(C2541R.string.stmt_image_write_summary)
@F3.e(C2541R.layout.stmt_image_write_edit)
/* loaded from: classes.dex */
public final class ImageWrite extends Action implements AsyncStatement {
    public InterfaceC1700x0 mimeType;
    public InterfaceC1700x0 quality;
    public InterfaceC1700x0 targetPath;
    public J3.l varImageFile;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final O f16732L1;

        /* renamed from: M1, reason: collision with root package name */
        public final ImageCodec f16733M1;

        /* renamed from: N1, reason: collision with root package name */
        public final com.llamalab.safs.n f16734N1;

        /* renamed from: O1, reason: collision with root package name */
        public final float f16735O1;

        public a(O o6, ImageCodec imageCodec, float f8, com.llamalab.safs.n nVar) {
            this.f16732L1 = o6;
            this.f16733M1 = imageCodec;
            this.f16735O1 = f8;
            this.f16734N1 = nVar;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            O o6 = this.f16732L1;
            ImageCodec imageCodec = this.f16733M1;
            com.llamalab.safs.n t8 = w0.L.t(this.f16734N1, Environment.DIRECTORY_DCIM, null, C2541R.string.format_image_file, imageCodec.getFilenameSuffix().substring(1));
            try {
                InterfaceC2065a j8 = com.llamalab.safs.i.j(t8, com.llamalab.safs.p.CREATE, com.llamalab.safs.p.TRUNCATE_EXISTING, com.llamalab.safs.p.WRITE);
                try {
                    ImageEncoder encode = imageCodec.encode(j8);
                    try {
                        encode.setSourceFormat(o6.f17001M1);
                        encode.setBestTargetFormatFor(o6.f17001M1);
                        encode.setBitmapSize(o6.f17004P1, o6.f17005Q1);
                        encode.setQuality(this.f16735O1);
                        if (encode.getTargetFormat().isIndexed()) {
                            encode.setPalette(o6.y2(this.f15400Y), o6.f17002N1);
                        }
                        encode.writeHeader();
                        encode.writeBitmap(o6.v2(this.f15400Y));
                        encode.close();
                        if (j8 != null) {
                            j8.close();
                        }
                        q2(t8.toString(), false);
                    } catch (Throwable th) {
                        if (encode != null) {
                            try {
                                encode.close();
                            } catch (Throwable th2) {
                                try {
                                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                } catch (Exception unused) {
                                }
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (j8 != null) {
                        try {
                            j8.close();
                        } catch (Throwable th4) {
                            try {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th3, th4);
                            } catch (Exception unused2) {
                            }
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                com.llamalab.safs.i.f(t8);
                throw th5;
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
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_image_write_title);
        l8.t(this.targetPath);
        return l8.q(this.targetPath).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.targetPath);
        dVar.g(this.mimeType);
        dVar.g(this.quality);
        dVar.g(this.varImageFile);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.targetPath);
        visitor.b(this.mimeType);
        visitor.b(this.quality);
        visitor.b(this.varImageFile);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.targetPath = (InterfaceC1700x0) cVar.readObject();
        this.mimeType = (InterfaceC1700x0) cVar.readObject();
        this.quality = (InterfaceC1700x0) cVar.readObject();
        this.varImageFile = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_image_write_title);
        O o6 = (O) c1708z0.c(O.class);
        if (o6 == null) {
            throw new IllegalStateException("No bitmap loaded");
        }
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.targetPath);
        String x7 = J3.h.x(c1708z0, this.mimeType, o6.f17003O1);
        a aVar = new a(o6, ImageCodec.forMimeType(x7), y4.j.c(J3.h.l(c1708z0, this.quality, 100.0f) / 100.0f, 0.0f, 1.0f), p8);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
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
