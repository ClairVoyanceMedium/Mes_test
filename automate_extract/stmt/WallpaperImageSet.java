package com.llamalab.automate.stmt;

import android.app.WallpaperManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.io.InputStream;

@F3.f("wallpaper_image_set.html")
@F3.a(C2541R.integer.ic_content_picture)
@F3.i(C2541R.string.stmt_wallpaper_image_set_title)
@F3.h(C2541R.string.stmt_wallpaper_image_set_summary)
@F3.e(C2541R.layout.stmt_wallpaper_image_set_edit)
/* loaded from: classes.dex */
public class WallpaperImageSet extends Action implements AsyncStatement {
    public InterfaceC1700x0 imageUri;
    public InterfaceC1700x0 which;

    public static class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final Uri f17272L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f17273M1;

        public a(Uri uri, int i8) {
            this.f17272L1 = uri;
            this.f17273M1 = i8;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            AutomateService automateService = this.f15400Y;
            InputStream openInputStream = automateService.getContentResolver().openInputStream(this.f17272L1);
            try {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(automateService);
                if (24 <= Build.VERSION.SDK_INT) {
                    wallpaperManager.setStream(openInputStream, null, false, this.f17273M1);
                } else {
                    wallpaperManager.setStream(openInputStream);
                }
                openInputStream.close();
                q2(null, false);
            } catch (Throwable th) {
                openInputStream.close();
                throw th;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.SET_WALLPAPER")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_wallpaper_image_set);
        l8.v(this.imageUri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.imageUri);
        if (61 <= dVar.f6413Z) {
            dVar.g(this.which);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.imageUri);
        visitor.b(this.which);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.imageUri = (InterfaceC1700x0) cVar.readObject();
        if (61 <= cVar.f6409x0) {
            this.which = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_wallpaper_image_set_title);
        Uri g8 = J3.h.g(c1708z0, this.imageUri, null);
        int m8 = J3.h.m(c1708z0, this.which, 1);
        int i8 = Build.VERSION.SDK_INT;
        if (24 > i8 && (m8 & 2) != 0) {
            throw new IncapableAndroidVersionException(24, "lock screen wallpaper");
        }
        if (g8 != null) {
            a aVar = new a(g8, m8);
            c1708z0.w(aVar);
            aVar.w2();
            return false;
        }
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(c1708z0);
        if (24 <= i8) {
            wallpaperManager.clear(m8);
        } else {
            wallpaperManager.clear();
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
