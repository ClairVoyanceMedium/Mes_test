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
import x3.C2440r;

@F3.f("image_rotate.html")
@F3.a(C2541R.integer.ic_rotate_90_degrees_cw)
@F3.i(C2541R.string.stmt_image_rotate_title)
@F3.h(C2541R.string.stmt_image_rotate_summary)
@F3.e(C2541R.layout.stmt_image_rotate_edit)
/* loaded from: classes.dex */
public final class ImageRotate extends Action implements AsyncStatement {
    public InterfaceC1700x0 rotation;
    public J3.l varResultHeight;
    public J3.l varResultWidth;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final O f16724L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16725M1;

        public a(O o6, int i8) {
            this.f16724L1 = o6;
            this.f16725M1 = i8;
        }

        public static void y2(O o6) {
            int i8 = o6.f17004P1;
            o6.f17004P1 = o6.f17005Q1;
            o6.f17005Q1 = i8;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            O o6 = this.f16724L1;
            int i8 = this.f16725M1;
            if (i8 == 90) {
                ImageOps.rotate90(o6.w2(this.f15400Y, o6.f17001M1.getBitmapSize(o6.f17005Q1, o6.f17004P1)), o6.f17001M1, o6.f17004P1, o6.f17005Q1);
            } else if (i8 == 180) {
                ImageOps.rotate180(o6.v2(this.f15400Y), o6.f17001M1, o6.f17004P1, o6.f17005Q1);
                q2(o6, false);
            } else {
                if (i8 != 270) {
                    throw new IllegalArgumentException("rotation");
                }
                ImageOps.rotate270(o6.w2(this.f15400Y, o6.f17001M1.getBitmapSize(o6.f17005Q1, o6.f17004P1)), o6.f17001M1, o6.f17004P1, o6.f17005Q1);
            }
            y2(o6);
            q2(o6, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_image_rotate_title);
        l8.v(this.rotation, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.rotation);
        dVar.g(this.varResultWidth);
        dVar.g(this.varResultHeight);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.rotation);
        visitor.b(this.varResultWidth);
        visitor.b(this.varResultHeight);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.rotation = (InterfaceC1700x0) cVar.readObject();
        this.varResultWidth = (J3.l) cVar.readObject();
        this.varResultHeight = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_image_rotate_title);
        O o6 = (O) c1708z0.c(O.class);
        if (o6 == null) {
            throw new IllegalStateException("No bitmap loaded");
        }
        int s8 = C2440r.s(J3.h.i(c1708z0, this.rotation, 0.0d));
        if (s8 != 0) {
            a aVar = new a(o6, s8);
            c1708z0.w(aVar);
            aVar.w2();
            return false;
        }
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
