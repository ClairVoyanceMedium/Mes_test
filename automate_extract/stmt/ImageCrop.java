package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.image.ImageOps;

@F3.f("image_crop.html")
@F3.a(C2541R.integer.ic_crop)
@F3.i(C2541R.string.stmt_image_crop_title)
@F3.h(C2541R.string.stmt_image_crop_summary)
@F3.e(C2541R.layout.stmt_image_crop_edit)
/* loaded from: classes.dex */
public final class ImageCrop extends Action implements AsyncStatement {
    public InterfaceC1700x0 croppedHeight;
    public InterfaceC1700x0 croppedLeft;
    public InterfaceC1700x0 croppedTop;
    public InterfaceC1700x0 croppedWidth;
    public J3.l varResultHeight;
    public J3.l varResultWidth;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final O f16711L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16712M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16713N1;

        /* renamed from: O1, reason: collision with root package name */
        public final int f16714O1;

        /* renamed from: P1, reason: collision with root package name */
        public final int f16715P1;

        public a(O o6, int i8, int i9, int i10, int i11) {
            this.f16711L1 = o6;
            this.f16712M1 = i8;
            this.f16713N1 = i9;
            this.f16714O1 = i10;
            this.f16715P1 = i11;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            AutomateService automateService = this.f15400Y;
            O o6 = this.f16711L1;
            ImageOps.crop(o6.v2(automateService), o6.f17001M1, o6.f17004P1, o6.f17005Q1, this.f16712M1, this.f16713N1, this.f16714O1, this.f16715P1);
            o6.f17004P1 = this.f16714O1 - this.f16712M1;
            o6.f17005Q1 = this.f16715P1 - this.f16713N1;
            q2(o6, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_image_crop_title);
        l8.v(this.croppedWidth, 0);
        l8.v(this.croppedHeight, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.croppedLeft);
        dVar.g(this.croppedTop);
        dVar.g(this.croppedWidth);
        dVar.g(this.croppedHeight);
        dVar.g(this.varResultWidth);
        dVar.g(this.varResultHeight);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.croppedLeft);
        visitor.b(this.croppedTop);
        visitor.b(this.croppedWidth);
        visitor.b(this.croppedHeight);
        visitor.b(this.varResultWidth);
        visitor.b(this.varResultHeight);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.croppedLeft = (InterfaceC1700x0) cVar.readObject();
        this.croppedTop = (InterfaceC1700x0) cVar.readObject();
        this.croppedWidth = (InterfaceC1700x0) cVar.readObject();
        this.croppedHeight = (InterfaceC1700x0) cVar.readObject();
        this.varResultWidth = (J3.l) cVar.readObject();
        this.varResultHeight = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        int i8;
        int i9;
        c1708z0.q(C2541R.string.stmt_image_crop_title);
        O o6 = (O) c1708z0.c(O.class);
        if (o6 == null) {
            throw new IllegalStateException("No bitmap loaded");
        }
        int m8 = J3.h.m(c1708z0, this.croppedLeft, 0);
        int m9 = J3.h.m(c1708z0, this.croppedTop, 0);
        int m10 = J3.h.m(c1708z0, this.croppedWidth, o6.f17004P1 - Math.max(m8, 0));
        int m11 = J3.h.m(c1708z0, this.croppedHeight, o6.f17005Q1 - Math.max(m9, 0));
        if (m8 < 0 || m8 >= (i8 = o6.f17004P1)) {
            throw new IllegalArgumentException("croppedLeft");
        }
        if (m9 < 0 || m9 >= (i9 = o6.f17005Q1)) {
            throw new IllegalArgumentException("croppedTop");
        }
        int i10 = m8 + m10;
        int i11 = m9 + m11;
        if (m10 <= 0 || i10 > i8) {
            throw new IllegalArgumentException("croppedWidth");
        }
        if (m11 <= 0 || i11 > i9) {
            throw new IllegalArgumentException("croppedHeight");
        }
        if (m8 != 0 || m9 != 0 || m10 != i8 || m11 != i9) {
            a aVar = new a(o6, m8, m9, i10, i11);
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
