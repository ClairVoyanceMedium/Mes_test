package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.image.ImageOps;
import com.llamalab.image.PixelFormat;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.MappedByteBuffer;

@F3.f("image_rescale.html")
@F3.a(C2541R.integer.ic_photo_size_select_large)
@F3.i(C2541R.string.stmt_image_rescale_title)
@F3.h(C2541R.string.stmt_image_rescale_summary)
@F3.e(C2541R.layout.stmt_image_rescale_edit)
/* loaded from: classes.dex */
public final class ImageRescale extends Action implements AsyncStatement {
    public InterfaceC1700x0 scaledHeight;
    public InterfaceC1700x0 scaledWidth;
    public J3.l varResultHeight;
    public J3.l varResultWidth;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final O f16721L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16722M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16723N1;

        public a(O o6, int i8, int i9) {
            this.f16721L1 = o6;
            this.f16722M1 = i8;
            this.f16723N1 = i9;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0066 A[Catch: all -> 0x0081, TRY_LEAVE, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x000e, B:5:0x0023, B:8:0x002a, B:9:0x0053, B:11:0x0066, B:15:0x0079, B:16:0x0080, B:17:0x003f), top: B:2:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0079 A[Catch: all -> 0x0081, TRY_ENTER, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x000e, B:5:0x0023, B:8:0x002a, B:9:0x0053, B:11:0x0066, B:15:0x0079, B:16:0x0080, B:17:0x003f), top: B:2:0x000e }] */
        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void x2() {
            int i8 = this.f16723N1;
            int i9 = this.f16722M1;
            O o6 = this.f16721L1;
            File x22 = O.x2(this.f15400Y, this, ".tmp");
            try {
                MappedByteBuffer z22 = O.z2(x22, o6.f17001M1.getBitmapSize(i9, i8));
                System.nanoTime();
                if (!o6.f17001M1.isIndexed() && PixelFormat.GRAY_1 != o6.f17001M1) {
                    ImageOps.scaleBicubicTo(o6.v2(this.f15400Y), o6.f17001M1, o6.f17004P1, o6.f17005Q1, this.f16722M1, this.f16723N1, z22);
                    o6.f17006y1.clear();
                    if (x22.renameTo(O.x2(this.f15400Y, this, ".bmp"))) {
                        throw new IOException("Failed to rename scaled bitmap file");
                    }
                    o6.f17006y1 = new WeakReference<>(z22);
                    o6.f17004P1 = i9;
                    o6.f17005Q1 = i8;
                    x22.delete();
                    q2(o6, false);
                    return;
                }
                ImageOps.scaleNearestNeighborTo(o6.v2(this.f15400Y), o6.f17001M1, o6.f17004P1, o6.f17005Q1, this.f16722M1, this.f16723N1, z22);
                o6.f17006y1.clear();
                if (x22.renameTo(O.x2(this.f15400Y, this, ".bmp"))) {
                }
            } catch (Throwable th) {
                x22.delete();
                throw th;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_image_rescale_title);
        l8.v(this.scaledWidth, 0);
        l8.v(this.scaledHeight, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.scaledWidth);
        dVar.g(this.scaledHeight);
        dVar.g(this.varResultWidth);
        dVar.g(this.varResultHeight);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.scaledWidth);
        visitor.b(this.scaledHeight);
        visitor.b(this.varResultWidth);
        visitor.b(this.varResultHeight);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.scaledWidth = (InterfaceC1700x0) cVar.readObject();
        this.scaledHeight = (InterfaceC1700x0) cVar.readObject();
        this.varResultWidth = (J3.l) cVar.readObject();
        this.varResultHeight = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_image_rescale_title);
        O o6 = (O) c1708z0.c(O.class);
        if (o6 == null) {
            throw new IllegalStateException("No bitmap loaded");
        }
        int m8 = J3.h.m(c1708z0, this.scaledWidth, o6.f17004P1);
        int m9 = J3.h.m(c1708z0, this.scaledHeight, o6.f17005Q1);
        if (m8 <= 0) {
            throw new IllegalArgumentException("scaledWidth");
        }
        if (m9 <= 0) {
            throw new IllegalArgumentException("scaledHeight");
        }
        int i8 = o6.f17004P1;
        if (m8 != i8 || m9 != o6.f17005Q1) {
            a aVar = new a(o6, m8, m9);
            c1708z0.w(aVar);
            aVar.w2();
            return false;
        }
        Double valueOf = Double.valueOf(i8);
        Double valueOf2 = Double.valueOf(o6.f17005Q1);
        J3.l lVar = this.varResultWidth;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, valueOf);
        }
        J3.l lVar2 = this.varResultHeight;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, valueOf2);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        O o6 = (O) obj;
        Double valueOf = Double.valueOf(o6.f17004P1);
        Double valueOf2 = Double.valueOf(o6.f17005Q1);
        J3.l lVar = this.varResultWidth;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, valueOf);
        }
        J3.l lVar2 = this.varResultHeight;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, valueOf2);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
