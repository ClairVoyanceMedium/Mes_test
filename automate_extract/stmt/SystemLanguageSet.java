package com.llamalab.automate.stmt;

import android.app.backup.BackupManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.CautionStatement;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Locale;

@F3.f("system_language_set.html")
@F3.a(C2541R.integer.ic_device_access_language)
@F3.i(C2541R.string.stmt_system_language_set_title)
@F3.h(C2541R.string.stmt_system_language_set_summary)
@F3.e(C2541R.layout.stmt_system_language_set_edit)
/* loaded from: classes.dex */
public final class SystemLanguageSet extends Action implements AsyncStatement, CautionStatement {
    public InterfaceC1700x0 language;

    public static final class a extends AbstractC1602l2 {

        /* renamed from: M1, reason: collision with root package name */
        public final Locale f17174M1;

        public a(Locale locale) {
            this.f17174M1 = locale;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            Locale locale = this.f17174M1;
            try {
                t3.l lVar = new t3.l();
                interfaceC1585h1.x0(locale.getLanguage(), locale.getCountry(), locale.getVariant(), lVar);
                lVar.c();
                p2(null);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.CHANGE_CONFIGURATION"), com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_system_language_set);
        l8.v(this.language, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.language);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.language);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.language = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_system_language_set_title);
        Locale r8 = J3.h.r(c1708z0, this.language, Locale.getDefault());
        int i8 = Build.VERSION.SDK_INT;
        if (23 <= i8) {
            c1708z0.w(new a(r8));
            return false;
        }
        Object invoke = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]).invoke(null, new Object[0]);
        Class<?> cls = invoke.getClass();
        Configuration configuration = (Configuration) cls.getMethod("getConfiguration", new Class[0]).invoke(invoke, new Object[0]);
        if (configuration == null) {
            throw new NullPointerException("No configuration");
        }
        if (!r8.equals(configuration.locale)) {
            Class<?> cls2 = configuration.getClass();
            if (17 <= i8) {
                cls2.getMethod("setLocale", Locale.class).invoke(configuration, r8);
            } else {
                cls2.getField("locale").set(configuration, r8);
            }
            cls2.getField("userSetLocale").setBoolean(configuration, true);
            cls.getMethod("updateConfiguration", Configuration.class).invoke(invoke, configuration);
            BackupManager.dataChanged("com.android.providers.settings");
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
