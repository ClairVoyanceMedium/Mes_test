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

@F3.f("image_flip.html")
@F3.a(C2541R.integer.ic_flip)
@F3.i(C2541R.string.stmt_image_flip_title)
@F3.h(C2541R.string.stmt_image_flip_summary)
@F3.e(C2541R.layout.stmt_image_flip_edit)
/* loaded from: classes.dex */
public final class ImageFlip extends Action implements AsyncStatement {
    public InterfaceC1700x0 axis;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final O f16716L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16717M1;

        public a(O o6, int i8) {
            this.f16716L1 = o6;
            this.f16717M1 = i8;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            O o6 = this.f16716L1;
            int i8 = this.f16717M1;
            if (i8 == 1) {
                ImageOps.flipVertically(o6.v2(this.f15400Y), o6.f17001M1, o6.f17004P1, o6.f17005Q1);
            } else if (i8 == 2) {
                ImageOps.flipHorizontally(o6.v2(this.f15400Y), o6.f17001M1, o6.f17004P1, o6.f17005Q1);
            } else if (i8 == 3) {
                ImageOps.rotate180(o6.v2(this.f15400Y), o6.f17001M1, o6.f17004P1, o6.f17005Q1);
            }
            q2(o6, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.stmt_image_flip_title);
        l8.h(this.axis, 0, C2541R.xml.flip_axes);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.axis);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.axis);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.axis = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_image_flip_title);
        O o6 = (O) c1708z0.c(O.class);
        if (o6 == null) {
            throw new IllegalStateException("No bitmap loaded");
        }
        int m8 = J3.h.m(c1708z0, this.axis, 0) & 3;
        if (m8 == 0) {
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        a aVar = new a(o6, m8);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
