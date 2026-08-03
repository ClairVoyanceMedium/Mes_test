package com.llamalab.automate.stmt;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.internal.play_billing.I2;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.CautionStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.image.ImageCodec;
import com.llamalab.image.ImageDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import x3.C2429g;

@F3.f("image_load.html")
@F3.a(C2541R.integer.ic_photo)
@F3.i(C2541R.string.stmt_image_load_title)
@F3.h(C2541R.string.stmt_image_load_summary)
@F3.e(C2541R.layout.stmt_image_load_edit)
/* loaded from: classes.dex */
public final class ImageLoad extends Action implements AsyncStatement, CautionStatement {
    public InterfaceC1700x0 uri;
    public J3.l varHeight;
    public J3.l varMimeType;
    public J3.l varWidth;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final Uri f16718L1;

        /* renamed from: M1, reason: collision with root package name */
        public File f16719M1;

        /* renamed from: N1, reason: collision with root package name */
        public File f16720N1;

        public a(Uri uri) {
            this.f16718L1 = uri;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            super.F(automateService);
            File file = this.f16719M1;
            if (file != null) {
                file.delete();
            }
            File file2 = this.f16720N1;
            if (file2 != null) {
                file2.delete();
            }
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            Uri uri = this.f16718L1;
            String scheme = uri.getScheme();
            if ("file".equals(scheme)) {
                ReadableByteChannel j8 = com.llamalab.safs.i.j(I2.k(uri.getPath(), new String[0]), new com.llamalab.safs.l[0]);
                try {
                    y2(j8);
                    if (j8 != null) {
                        j8.close();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (j8 != null) {
                        try {
                            j8.close();
                        } catch (Throwable th2) {
                            try {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                            } catch (Exception unused) {
                            }
                        }
                    }
                    throw th;
                }
            }
            if (!"content".equals(scheme)) {
                if (!"data".equals(scheme)) {
                    throw new IllegalArgumentException("Unsupported URI scheme");
                }
                y2(new d4.i(ByteBuffer.wrap((byte[]) C2429g.j(uri).second)));
                return;
            }
            ParcelFileDescriptor openFileDescriptor = this.f15400Y.getContentResolver().openFileDescriptor(uri, "r");
            if (openFileDescriptor == null) {
                throw new NullPointerException("openFileDescriptor");
            }
            try {
                FileChannel channel = new FileInputStream(openFileDescriptor.getFileDescriptor()).getChannel();
                try {
                    y2(channel);
                    if (channel != null) {
                        channel.close();
                    }
                } catch (Throwable th3) {
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable th4) {
                            try {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th3, th4);
                            } catch (Exception unused2) {
                            }
                        }
                    }
                    throw th3;
                }
            } finally {
                try {
                    openFileDescriptor.close();
                } catch (IOException unused3) {
                }
            }
        }

        public final void y2(ReadableByteChannel readableByteChannel) {
            ImageDecoder decodeByMagic = ImageCodec.decodeByMagic(readableByteChannel);
            try {
                decodeByMagic.readHeader();
                decodeByMagic.setTargetFormat(decodeByMagic.getSourceFormat());
                File x22 = O.x2(this.f15400Y, this, ".bmp");
                this.f16719M1 = x22;
                MappedByteBuffer z22 = O.z2(x22, decodeByMagic.getBitmapSize());
                decodeByMagic.readBitmap(z22);
                if (decodeByMagic.getTargetFormat().isIndexed()) {
                    ByteBuffer palette = decodeByMagic.getPalette();
                    this.f16720N1 = O.x2(this.f15400Y, this, ".plt");
                    FileChannel channel = new FileOutputStream(this.f16720N1).getChannel();
                    while (palette.hasRemaining()) {
                        try {
                            channel.write(palette);
                        } catch (Throwable th) {
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (Throwable th2) {
                                    try {
                                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                    if (channel != null) {
                        channel.close();
                    }
                }
                O o6 = new O();
                o6.f17006y1 = new WeakReference<>(z22);
                o6.f17001M1 = decodeByMagic.getTargetFormat();
                o6.f17002N1 = decodeByMagic.getPaletteFormat();
                o6.f17003O1 = decodeByMagic.codec().getMimeType();
                o6.f17004P1 = decodeByMagic.getWidth();
                o6.f17005Q1 = decodeByMagic.getHeight();
                q2(o6, true);
                decodeByMagic.close();
            } catch (Throwable th3) {
                if (decodeByMagic != null) {
                    try {
                        decodeByMagic.close();
                    } catch (Throwable th4) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th3, th4);
                        } catch (Exception unused2) {
                        }
                    }
                }
                throw th3;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        int i8 = Build.VERSION.SDK_INT;
        if (30 > i8) {
            return 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_MEDIA_LOCATION"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_MEDIA_LOCATION"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_MEDIA_LOCATION"), com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_image_load_title);
        l8.v(this.uri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.uri);
        dVar.g(this.varWidth);
        dVar.g(this.varHeight);
        dVar.g(this.varMimeType);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.uri);
        visitor.b(this.varWidth);
        visitor.b(this.varHeight);
        visitor.b(this.varMimeType);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.varWidth = (J3.l) cVar.readObject();
        this.varHeight = (J3.l) cVar.readObject();
        this.varMimeType = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_image_load_title);
        c1708z0.H(O.class);
        Uri g8 = J3.h.g(c1708z0, this.uri, null);
        if (g8 == null) {
            throw new RequiredArgumentNullException("uri");
        }
        a aVar = new a(g8);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        O o6 = (O) obj;
        c1708z0.w(o6);
        a aVar = (a) w8;
        aVar.f16720N1 = null;
        aVar.f16719M1 = null;
        w8.a();
        J3.l lVar = this.varWidth;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, Double.valueOf(o6.f17004P1));
        }
        J3.l lVar2 = this.varHeight;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, Double.valueOf(o6.f17005Q1));
        }
        J3.l lVar3 = this.varMimeType;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, o6.f17003O1);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
