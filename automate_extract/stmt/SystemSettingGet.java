package com.llamalab.automate.stmt;

import android.content.ComponentName;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import com.llamalab.auth3p.MicrosoftClient;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1616p0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.J1;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import x3.C2440r;

@F3.f("system_setting_get.html")
@F3.a(C2541R.integer.ic_action_settings)
@F3.i(C2541R.string.stmt_system_setting_get_title)
@F3.h(C2541R.string.stmt_system_setting_get_summary)
@F3.e(C2541R.layout.stmt_system_setting_get_edit)
/* loaded from: classes.dex */
public class SystemSettingGet extends IntermittentAction implements AsyncStatement {
    public InterfaceC1700x0 category;
    public InterfaceC1700x0 name;
    public J3.l varValue;

    public static final class a extends J1 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f17175L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f17176M1;

        /* renamed from: N1, reason: collision with root package name */
        public final boolean f17177N1;

        /* renamed from: O1, reason: collision with root package name */
        public ContentObserver f17178O1;

        /* renamed from: P1, reason: collision with root package name */
        public String f17179P1;

        /* renamed from: Q1, reason: collision with root package name */
        public boolean f17180Q1;

        /* renamed from: com.llamalab.automate.stmt.SystemSettingGet$a$a, reason: collision with other inner class name */
        public class C0181a extends ContentObserver {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ O3.a f17181a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0181a(Handler handler, O3.a aVar) {
                super(handler);
                this.f17181a = aVar;
            }

            @Override // android.database.ContentObserver
            public final void onChange(boolean z7, Uri uri) {
                a aVar = a.this;
                try {
                    String s8 = SystemSettingGet.s(this.f17181a, aVar.f17176M1, aVar.f17175L1);
                    if (C2440r.h(aVar.f17179P1, s8)) {
                        return;
                    }
                    aVar.q2(s8, false);
                } catch (Throwable th) {
                    aVar.r2(th);
                }
            }
        }

        public a(int i8, String str, boolean z7) {
            this.f17176M1 = i8;
            this.f17175L1 = str;
            this.f17177N1 = z7;
        }

        @Override // com.llamalab.automate.AbstractServiceConnectionC1580g0, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            x2();
            super.F(automateService);
        }

        @Override // com.llamalab.automate.AbstractServiceConnectionC1580g0, android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            x2();
        }

        @Override // com.llamalab.automate.J1
        public final void w2(O3.a aVar) {
            Uri uriFor;
            try {
                if (4 > aVar.Y()) {
                    throw new UnsupportedOperationException("Legacy extension must be updated");
                }
                boolean z7 = this.f17177N1;
                String str = this.f17175L1;
                int i8 = this.f17176M1;
                if (z7) {
                    q2(SystemSettingGet.s(aVar, i8, str), false);
                    return;
                }
                String s8 = SystemSettingGet.s(aVar, i8, str);
                if (this.f17180Q1 && !C2440r.h(this.f17179P1, s8)) {
                    q2(s8, false);
                    return;
                }
                this.f17179P1 = s8;
                this.f17180Q1 = true;
                if (i8 != 1) {
                    if (i8 == 2 && 17 <= Build.VERSION.SDK_INT) {
                        uriFor = Settings.Global.getUriFor(str);
                    }
                    uriFor = Settings.System.getUriFor(str);
                } else {
                    uriFor = Settings.Secure.getUriFor(str);
                }
                C0181a c0181a = new C0181a(this.f15400Y.f14581L1, aVar);
                x2();
                this.f17178O1 = c0181a;
                this.f15400Y.getContentResolver().registerContentObserver(uriFor, false, c0181a);
            } catch (Throwable th) {
                r2(th);
            }
        }

        public final void x2() {
            if (this.f17178O1 != null) {
                this.f15400Y.getContentResolver().unregisterContentObserver(this.f17178O1);
                this.f17178O1 = null;
            }
        }
    }

    public static final class b extends C1616p0 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f17183L1;

        /* renamed from: M1, reason: collision with root package name */
        public final String f17184M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f17185N1;

        public b(int i8, String str, String str2) {
            this.f17185N1 = i8;
            this.f17183L1 = str;
            this.f17184M1 = str2;
        }

        @Override // com.llamalab.automate.C1616p0
        public final void x2(Uri uri) {
            try {
                String u8 = SystemSettingGet.u(this.f17185N1, this.f15400Y, this.f17183L1);
                if (C2440r.h(this.f17184M1, u8)) {
                    return;
                }
                q2(u8, false);
            } catch (Throwable th) {
                r2(th);
            }
        }
    }

    public static String s(O3.a aVar, int i8, String str) {
        t3.l lVar = new t3.l();
        String W02 = i8 != 1 ? i8 != 2 ? aVar.W0(str, lVar) : aVar.c1(str, lVar) : aVar.Y0(str, lVar);
        lVar.c();
        return W02;
    }

    public static String u(int i8, Context context, String str) {
        String string;
        if (i8 == 1) {
            return Settings.Secure.getString(context.getContentResolver(), str);
        }
        if (i8 != 2 || 17 > Build.VERSION.SDK_INT) {
            return Settings.System.getString(context.getContentResolver(), str);
        }
        string = Settings.Global.getString(context.getContentResolver(), str);
        return string;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_system_setting_get_immediate, C2541R.string.caption_system_setting_get_change);
        return c1596k0.o(-1, this.name).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.category);
        dVar.g(this.name);
        dVar.g(this.varValue);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.category);
        visitor.b(this.name);
        visitor.b(this.varValue);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.category = (InterfaceC1700x0) cVar.readObject();
        this.name = (InterfaceC1700x0) cVar.readObject();
        this.varValue = (J3.l) cVar.readObject();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        if (java.util.Arrays.binarySearch(com.llamalab.automate.stmt.e1.f17395g, r0) < 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0066, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        if (java.util.Arrays.binarySearch(com.llamalab.automate.stmt.e1.f17397i, r0) < 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        if (java.util.Arrays.binarySearch(com.llamalab.automate.stmt.e1.f17394f, r0) < 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
    
        if (java.util.Arrays.binarySearch(com.llamalab.automate.stmt.e1.f17396h, r0) < 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
    
        if (java.util.Arrays.binarySearch(com.llamalab.automate.stmt.e1.f17398j, r0) < 0) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        boolean z7;
        c1708z0.q(C2541R.string.stmt_system_setting_get_title);
        String x7 = J3.h.x(c1708z0, this.name, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException(MicrosoftClient.PROP_NAME);
        }
        int m8 = J3.h.m(c1708z0, this.category, 0);
        boolean z8 = J1(1) == 0;
        int i8 = Build.VERSION.SDK_INT;
        if (31 <= i8) {
            if (m8 == 1) {
                if (34 > i8) {
                    if (33 > i8) {
                        if (31 <= i8) {
                        }
                        Uri uri = e1.f17389a;
                        z7 = true;
                    }
                }
                if (!z7) {
                }
            } else if (m8 != 2) {
                if (33 <= i8) {
                }
                Uri uri2 = e1.f17389a;
                z7 = true;
                if (!z7 && com.llamalab.automate.access.c.f15550k.A(c1708z0)) {
                    c1708z0.w(new a(m8, x7, z8));
                }
            } else {
                if (33 <= i8) {
                }
                Uri uri22 = e1.f17389a;
                z7 = true;
                if (!z7) {
                    c1708z0.w(new a(m8, x7, z8));
                }
            }
            return false;
        }
        String u8 = u(m8, c1708z0, x7);
        if (!z8) {
            b bVar = new b(m8, x7, u8);
            c1708z0.w(bVar);
            bVar.w2(false, m8 != 1 ? (m8 == 2 && 17 <= i8) ? Settings.Global.getUriFor(x7) : Settings.System.getUriFor(x7) : Settings.Secure.getUriFor(x7));
            return false;
        }
        J3.l lVar = this.varValue;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, u8);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        String str = (String) obj;
        J3.l lVar = this.varValue;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
