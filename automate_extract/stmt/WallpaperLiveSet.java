package com.llamalab.automate.stmt;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("wallpaper_live_set.html")
@F3.a(C2541R.integer.ic_content_picture)
@F3.i(C2541R.string.stmt_wallpaper_live_set_title)
@F3.h(C2541R.string.stmt_wallpaper_live_set_summary)
@F3.e(C2541R.layout.stmt_wallpaper_live_set_edit)
/* loaded from: classes.dex */
public final class WallpaperLiveSet extends PackageAction implements AsyncStatement {
    public InterfaceC1700x0 className;
    public InterfaceC1700x0 which;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final ComponentName f17274M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f17275N1;

        public a(ComponentName componentName, int i8) {
            this.f17274M1 = componentName;
            this.f17275N1 = i8;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.M(this.f17274M1, this.f17275N1, t3.o.b(), lVar);
                lVar.c();
                p2(null);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_wallpaper_live_set).o(-1, this.className).o(2, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.PackageAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.className);
        if (111 <= dVar.f6413Z) {
            dVar.g(this.which);
        }
    }

    @Override // com.llamalab.automate.stmt.PackageAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.className);
        visitor.b(this.which);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return ViewOnClickListenerC1667s.w(new Intent("android.service.wallpaper.WallpaperService"), 4);
    }

    @Override // com.llamalab.automate.stmt.PackageAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.className = (InterfaceC1700x0) cVar.readObject();
        if (111 <= cVar.f6409x0) {
            this.which = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_wallpaper_live_set_title);
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("packageName");
        }
        String x8 = J3.h.x(c1708z0, this.className, null);
        if (x8 == null) {
            throw new RequiredArgumentNullException("className");
        }
        int m8 = J3.h.m(c1708z0, this.which, 1);
        if (34 > Build.VERSION.SDK_INT && (m8 & 2) != 0) {
            throw new IncapableAndroidVersionException(34, "lock screen wallpaper");
        }
        c1708z0.w(new a(new ComponentName(x7, x8), m8));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
