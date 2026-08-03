package com.llamalab.automate.stmt;

import C1.D1;
import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ShortcutInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1617p1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.K1;
import com.llamalab.automate.Visitor;
import java.util.UUID;
import m3.C2146d;
import x3.C2425c;

@F3.f("shortcut_pin.html")
@F3.a(C2541R.integer.ic_shortcut)
@F3.i(C2541R.string.stmt_shortcut_pin_title)
@F3.h(C2541R.string.stmt_shortcut_pin_summary)
@F3.b(C2541R.layout.block_try)
@F3.e(C2541R.layout.stmt_shortcut_pin_edit)
/* loaded from: classes.dex */
public final class ShortcutPin extends ShortcutDecision implements AsyncStatement {
    public J3.l varShortcutId;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final ShortcutInfo f17121L1;

        /* renamed from: M1, reason: collision with root package name */
        public final String f17122M1;

        public a(ShortcutInfo shortcutInfo, String str) {
            this.f17121L1 = shortcutInfo;
            this.f17122M1 = str;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            boolean z7;
            try {
                z7 = S.i.a(this.f15400Y.getSystemService("shortcut")).requestPinShortcut(this.f17121L1, null);
            } catch (IllegalStateException e8) {
                Log.w("ShortcutPin", "requestPinShortcut failed", e8);
                z7 = false;
            }
            q2(new Object[]{Boolean.valueOf(z7), this.f17122M1}, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("com.android.launcher.permission.INSTALL_SHORTCUT")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_shortcut_pin).o(-1, this.action).o(-1, this.className).q(this.className).o(-1, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.ShortcutDecision, com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (97 <= dVar.f6413Z) {
            dVar.g(this.varShortcutId);
        }
    }

    @Override // com.llamalab.automate.stmt.ShortcutDecision, com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.varShortcutId);
    }

    @Override // com.llamalab.automate.stmt.ShortcutDecision, com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (97 <= cVar.f6409x0) {
            this.varShortcutId = (J3.l) cVar.readObject();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00f6  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        Parcelable b8;
        Parcelable parcelable;
        String str;
        J3.l lVar;
        ApplicationInfo applicationInfo;
        int i8;
        String str2;
        c1708z0.q(C2541R.string.stmt_shortcut_pin_title);
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        Intent w8 = w(2091644631, c1708z0, true);
        ActivityInfo resolveActivityInfo = w8.resolveActivityInfo(c1708z0.getPackageManager(), 0);
        String B7 = B(c1708z0, resolveActivityInfo);
        if (26 <= Build.VERSION.SDK_INT) {
            Icon z7 = z(c1708z0, resolveActivityInfo, a8);
            String uuid = UUID.randomUUID().toString();
            a aVar = new a(new ShortcutInfo.Builder(c1708z0, D1.k("flow_v2:", uuid)).setIntent(w8).setShortLabel(B7).setIcon(z7).build(), uuid);
            c1708z0.w(aVar);
            aVar.w2();
            return false;
        }
        Uri g8 = J3.h.g(c1708z0, this.iconUri, null);
        boolean f8 = J3.h.f(c1708z0, this.iconStyle, false);
        try {
        } catch (Resources.NotFoundException e8) {
            Log.w("ShortcutDecision", "Missing icon resource", e8);
        } catch (Exception e9) {
            e = e9;
            Log.w("ShortcutDecision", "Failed to load icon", e);
            if (a8) {
                K1 g12 = c1708z0.g1();
                long j8 = c1708z0.f17644y0;
                long g9 = c1708z0.g();
                while (true) {
                    Throwable cause = e.getCause();
                    if (cause == null) {
                        break;
                    }
                    e = cause;
                }
                g12.g(j8, g9, "W", e.toString());
            }
        }
        if (g8 != null) {
            b8 = C1617p1.u(c1708z0).x(f8, g8);
        } else {
            if (resolveActivityInfo == null || (i8 = resolveActivityInfo.icon) == 0) {
                if (resolveActivityInfo != null && (i8 = (applicationInfo = resolveActivityInfo.applicationInfo).icon) != 0) {
                    str2 = applicationInfo.packageName;
                }
                b8 = C2146d.b(R.drawable.sym_def_app_icon, c1708z0, "android");
            } else {
                str2 = resolveActivityInfo.packageName;
            }
            b8 = C2146d.b(i8, c1708z0, str2);
        }
        Intent putExtra = new Intent("com.android.launcher.action.INSTALL_SHORTCUT").putExtra("android.intent.extra.shortcut.INTENT", w8).putExtra("android.intent.extra.shortcut.NAME", B7);
        if (!(b8 instanceof Bitmap)) {
            if (b8 instanceof Intent.ShortcutIconResource) {
                parcelable = (Intent.ShortcutIconResource) b8;
                str = "android.intent.extra.shortcut.ICON_RESOURCE";
            }
            boolean c8 = C2146d.c(c1708z0, putExtra);
            lVar = this.varShortcutId;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, c8);
            return true;
        }
        parcelable = (Bitmap) b8;
        str = "android.intent.extra.shortcut.ICON";
        putExtra.putExtra(str, parcelable);
        boolean c82 = C2146d.c(c1708z0, putExtra);
        lVar = this.varShortcutId;
        if (lVar != null) {
        }
        o(c1708z0, c82);
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        String str = (String) objArr[1];
        J3.l lVar = this.varShortcutId;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        o(c1708z0, booleanValue);
        return true;
    }
}
