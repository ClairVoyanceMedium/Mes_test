package com.llamalab.automate.stmt;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.llamalab.automate.C1701x1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("appwidget_configure.html")
@F3.a(C2541R.integer.ic_widgets)
@F3.i(C2541R.string.stmt_appwidget_configure_title)
@F3.h(C2541R.string.stmt_appwidget_configure_summary)
@F3.c(C2541R.string.caption_appwidget_configure)
@F3.e(C2541R.layout.stmt_appwidget_configure_edit)
/* loaded from: classes.dex */
public final class AppWidgetConfigure extends Action implements IntentStatement {
    public InterfaceC1700x0 hostCategories;
    public InterfaceC1700x0 title;
    public J3.l varHostCategory;
    public J3.l varInterfaceUri;

    public static IntentFilter q(String... strArr) {
        IntentFilter intentFilter = new IntentFilter("com.llamalab.automate.intent.action.APPWIDGET_CONFIGURE_ANNOUNCE");
        for (String str : strArr) {
            intentFilter.addCategory(str);
        }
        return intentFilter;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[Catch: all -> 0x0056, TryCatch #2 {all -> 0x0056, blocks: (B:36:0x004f, B:12:0x0059, B:14:0x0067, B:15:0x006e, B:17:0x0072, B:18:0x0077, B:20:0x007b, B:21:0x0080), top: B:35:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0072 A[Catch: all -> 0x0056, TryCatch #2 {all -> 0x0056, blocks: (B:36:0x004f, B:12:0x0059, B:14:0x0067, B:15:0x006e, B:17:0x0072, B:18:0x0077, B:20:0x007b, B:21:0x0080), top: B:35:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[Catch: all -> 0x0056, TryCatch #2 {all -> 0x0056, blocks: (B:36:0x004f, B:12:0x0059, B:14:0x0067, B:15:0x006e, B:17:0x0072, B:18:0x0077, B:20:0x007b, B:21:0x0080), top: B:35:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.llamalab.automate.IntentStatement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        Uri uri;
        Bundle bundleExtra;
        int i8;
        J3.l lVar;
        J3.l lVar2;
        c1708z0.I(C1701x1.class, this.f16218X);
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("com.llamalab.automate.intent.extra.PENDING_RESULT");
        O.b.c("EXTRA_PENDING_RESULT", pendingIntent);
        try {
            int intExtra = ((Intent) intent.getParcelableExtra("android.intent.extra.INTENT")).getIntExtra("appWidgetId", 0);
            if (intExtra == 0) {
                throw new IllegalStateException("Invalid app widget id");
            }
            if (16 <= Build.VERSION.SDK_INT) {
                try {
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(c1708z0);
                    bundleExtra = intent.getBundleExtra("appWidgetOptions");
                    if (bundleExtra == null) {
                        try {
                            bundleExtra = appWidgetManager.getAppWidgetOptions(intExtra);
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                } catch (IllegalArgumentException unused2) {
                }
                uri = Y.c(c1708z0.getContentResolver(), c1708z0.f17641Z, 2, String.valueOf(intExtra));
                if (bundleExtra == null) {
                    try {
                        i8 = bundleExtra.getInt("appWidgetCategory", 0);
                    } catch (Throwable th) {
                        th = th;
                        if (uri != null) {
                            c1708z0.getContentResolver().delete(uri, null, null);
                        }
                        try {
                            pendingIntent.send(c1708z0, 0, (Intent) null);
                        } catch (PendingIntent.CanceledException unused3) {
                        }
                        throw th;
                    }
                } else {
                    i8 = 0;
                }
                c1708z0.w(new C1644g(pendingIntent, intExtra, uri));
                String uri2 = uri.toString();
                Double valueOf = i8 == 0 ? Double.valueOf(i8) : null;
                lVar = this.varInterfaceUri;
                if (lVar != null) {
                    c1708z0.z(lVar.f4659Y, uri2);
                }
                lVar2 = this.varHostCategory;
                if (lVar2 != null) {
                    c1708z0.z(lVar2.f4659Y, valueOf);
                }
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
            bundleExtra = null;
            uri = Y.c(c1708z0.getContentResolver(), c1708z0.f17641Z, 2, String.valueOf(intExtra));
            if (bundleExtra == null) {
            }
            c1708z0.w(new C1644g(pendingIntent, intExtra, uri));
            String uri22 = uri.toString();
            if (i8 == 0) {
            }
            lVar = this.varInterfaceUri;
            if (lVar != null) {
            }
            lVar2 = this.varHostCategory;
            if (lVar2 != null) {
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        } catch (Throwable th2) {
            th = th2;
            uri = null;
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.title);
        dVar.g(this.hostCategories);
        dVar.g(this.varInterfaceUri);
        dVar.g(this.varHostCategory);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.title);
        visitor.b(this.hostCategories);
        visitor.b(this.varInterfaceUri);
        visitor.b(this.varHostCategory);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.title = (InterfaceC1700x0) cVar.readObject();
        this.hostCategories = (InterfaceC1700x0) cVar.readObject();
        this.varInterfaceUri = (J3.l) cVar.readObject();
        this.varHostCategory = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_appwidget_configure_title);
        c1708z0.H(C1644g.class);
        String x7 = J3.h.x(c1708z0, this.title, null);
        int m8 = J3.h.m(c1708z0, this.hostCategories, 15);
        C1701x1 c1701x1 = new C1701x1(C1701x1.s(c1708z0, "android.appwidget.action.APPWIDGET_CONFIGURE", x7));
        c1708z0.w(c1701x1);
        int i8 = Build.VERSION.SDK_INT;
        if (21 <= i8 && (m8 & 4) != 0) {
            c1701x1.m(4, q("com.llamalab.automate.intent.category.SEARCHBOX"));
        }
        if (17 <= i8) {
            if ((m8 & 1) != 0) {
                c1701x1.m(4, q("com.llamalab.automate.intent.category.HOME_SCREEN"));
            }
            if ((m8 & 2) != 0) {
                c1701x1.m(4, q("com.llamalab.automate.intent.category.KEYGUARD"));
            }
        }
        c1701x1.m(4, q(new String[0]));
        return false;
    }
}
