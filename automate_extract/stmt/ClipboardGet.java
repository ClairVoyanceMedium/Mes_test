package com.llamalab.automate.stmt;

import C1.D1;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.view.View;
import android.view.WindowManager;
import com.llamalab.automate.AbstractC1602l2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1585h1;
import com.llamalab.automate.N2;
import com.llamalab.automate.Visitor;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;
import r3.AbstractRunnableC2258a;
import r3.EnumC2263f;
import r3.InterfaceC2264g;
import x3.C2425c;

@F3.f("clipboard_get.html")
@F3.a(C2541R.integer.ic_content_paste)
@F3.i(C2541R.string.stmt_clipboard_get_title)
@F3.h(C2541R.string.stmt_clipboard_get_summary)
@F3.e(C2541R.layout.stmt_clipboard_get_edit)
/* loaded from: classes.dex */
public final class ClipboardGet extends IntermittentAction implements AsyncStatement {
    public J3.l varContent;

    public static abstract class a implements ClipboardManager.OnPrimaryClipChangedListener {

        /* renamed from: X, reason: collision with root package name */
        public ClipboardManager f16446X;

        public abstract void c(Object obj);

        public abstract AutomateService d();

        @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
        public final void onPrimaryClipChanged() {
            c(this.f16446X.getPrimaryClip());
        }
    }

    public static final class b extends com.llamalab.automate.W {

        /* renamed from: y1, reason: collision with root package name */
        public final a f16447y1 = new a();

        public class a extends a {
            public a() {
            }

            @Override // com.llamalab.automate.stmt.ClipboardGet.a
            public final void c(Object obj) {
                b.this.q2(obj, false);
            }
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            a aVar = this.f16447y1;
            aVar.getClass();
            ClipboardManager clipboardManager = (ClipboardManager) automateService.getSystemService("clipboard");
            aVar.f16446X = clipboardManager;
            clipboardManager.addPrimaryClipChangedListener(aVar);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            a aVar = this.f16447y1;
            aVar.getClass();
            try {
                aVar.f16446X.removePrimaryClipChangedListener(aVar);
            } catch (Throwable unused) {
            }
            u2();
        }
    }

    public static abstract class c extends e implements InterfaceC2264g {

        /* renamed from: x0, reason: collision with root package name */
        public final String f16449x0;

        /* renamed from: y0, reason: collision with root package name */
        public AbstractRunnableC2258a f16450y0;

        public c() {
            StringBuilder sb = 30 <= Build.VERSION.SDK_INT ? new StringBuilder("Denying clipboard access to com.llamalab.automate, application is not in focus nor is it a system service for user ") : new StringBuilder("Denying clipboard access to com.llamalab.automate, application is not in focus neither is a system service for user ");
            sb.append(t3.o.b());
            this.f16449x0 = sb.toString();
        }

        @Override // r3.InterfaceC2264g
        public final boolean a(int i8) {
            return 1000 == i8;
        }

        @Override // r3.InterfaceC2264g
        public final boolean b(CharSequence charSequence) {
            return "ClipboardService".contentEquals(charSequence);
        }

        @Override // com.llamalab.automate.stmt.ClipboardGet.e
        public final void f(AutomateService automateService) {
            super.f(automateService);
            AbstractRunnableC2258a abstractRunnableC2258a = this.f16450y0;
            if (abstractRunnableC2258a != null) {
                abstractRunnableC2258a.a();
                this.f16450y0 = null;
            }
        }

        @Override // r3.InterfaceC2264g
        public final void h(EnumC2263f enumC2263f, long j8, int i8, int i9, CharSequence charSequence, CharSequence charSequence2) {
            if (6 == i9) {
                try {
                    if (this.f16449x0.contentEquals(charSequence2)) {
                        this.f16450y0.f21887Y.set(true);
                        d().Z(this);
                    }
                } catch (Throwable th) {
                    e(th);
                }
            }
        }
    }

    public static final class d extends com.llamalab.automate.W {

        /* renamed from: y1, reason: collision with root package name */
        public final a f16451y1 = new a();

        public class a extends c {
            public a() {
            }

            @Override // com.llamalab.automate.stmt.ClipboardGet.a
            public final void c(Object obj) {
                d.this.q2(obj, false);
            }

            @Override // com.llamalab.automate.stmt.ClipboardGet.a
            public final AutomateService d() {
                return d.this.f15400Y;
            }

            @Override // com.llamalab.automate.stmt.ClipboardGet.e
            public final void e(Throwable th) {
                d.this.r2(th);
            }
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            a aVar = this.f16451y1;
            aVar.g(automateService, j8, j9, j10);
            aVar.f16446X.addPrimaryClipChangedListener(aVar);
            aVar.f16450y0 = D1.x(EnumSet.of(EnumC2263f.f21927y1), System.currentTimeMillis(), true, aVar);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            this.f16451y1.f(automateService);
            u2();
        }
    }

    public static abstract class e extends a implements Runnable {

        /* renamed from: Y, reason: collision with root package name */
        public WindowManager f16453Y;

        /* renamed from: Z, reason: collision with root package name */
        public a f16454Z;

        public class a extends View {
            public a(AutomateService automateService) {
                super(automateService);
            }

            @Override // android.view.View
            public final void onWindowFocusChanged(boolean z7) {
                super.onWindowFocusChanged(z7);
                if (z7) {
                    e.this.onPrimaryClipChanged();
                }
            }
        }

        public abstract void e(Throwable th);

        public void f(AutomateService automateService) {
            automateService.f14581L1.removeCallbacks(this);
            automateService.Z(new androidx.activity.b(20, this));
            try {
                this.f16446X.removePrimaryClipChangedListener(this);
            } catch (Throwable unused) {
            }
        }

        public final void g(AutomateService automateService, long j8, long j9, long j10) {
            this.f16446X = (ClipboardManager) automateService.getSystemService("clipboard");
            this.f16453Y = (WindowManager) automateService.getSystemService("window");
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.f16454Z == null) {
                    a aVar = new a(d());
                    this.f16454Z = aVar;
                    aVar.setFocusable(1);
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, 2038, 304, -3);
                    layoutParams.gravity = 51;
                    layoutParams.alpha = 0.0f;
                    layoutParams.softInputMode = 1;
                    this.f16453Y.addView(this.f16454Z, layoutParams);
                    this.f16454Z.requestFocus();
                }
            } catch (Throwable th) {
                e(th);
            }
        }
    }

    public static final class f extends com.llamalab.automate.W {

        /* renamed from: y1, reason: collision with root package name */
        public final a f16456y1 = new a();

        public class a extends e {
            public a() {
            }

            @Override // com.llamalab.automate.stmt.ClipboardGet.a
            public final void c(Object obj) {
                f.this.q2(obj, false);
            }

            @Override // com.llamalab.automate.stmt.ClipboardGet.a
            public final AutomateService d() {
                return f.this.f15400Y;
            }

            @Override // com.llamalab.automate.stmt.ClipboardGet.e
            public final void e(Throwable th) {
                f.this.r2(th);
            }
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            a aVar = this.f16456y1;
            aVar.g(automateService, j8, j9, j10);
            aVar.d().Z(aVar);
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            this.f16456y1.f(automateService);
            u2();
        }
    }

    public static final class g extends AbstractC1602l2 implements Handler.Callback {

        /* renamed from: M1, reason: collision with root package name */
        public final AtomicBoolean f16458M1 = new AtomicBoolean();

        /* renamed from: N1, reason: collision with root package name */
        public final Messenger f16459N1 = new Messenger(new Handler(Looper.getMainLooper(), this));

        /* renamed from: O1, reason: collision with root package name */
        public volatile InterfaceC1585h1 f16460O1;

        @Override // com.llamalab.automate.AbstractC1602l2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            InterfaceC1585h1 interfaceC1585h1 = this.f16460O1;
            if (interfaceC1585h1 != null) {
                try {
                    t3.l lVar = new t3.l();
                    interfaceC1585h1.P0(this.f16459N1, lVar);
                    lVar.c();
                } catch (Throwable unused) {
                }
            }
            super.F(automateService);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            try {
                t3.l lVar = new t3.l();
                ClipData K02 = this.f16460O1.K0(lVar);
                lVar.c();
                if (this.f16458M1.compareAndSet(false, true)) {
                    q2(K02, false);
                }
            } catch (Throwable th) {
                if (this.f16458M1.compareAndSet(false, true)) {
                    r2(th);
                }
            }
            return true;
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void w2(InterfaceC1585h1 interfaceC1585h1) {
            try {
                this.f16460O1 = interfaceC1585h1;
                t3.l lVar = new t3.l();
                interfaceC1585h1.C1(this.f16459N1, lVar);
                lVar.c();
            } catch (Throwable th) {
                if (this.f16458M1.compareAndSet(false, true)) {
                    r2(th);
                }
            }
        }

        @Override // com.llamalab.automate.AbstractC1602l2
        public final void x2() {
            this.f16460O1 = null;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return (33 > i8 || 1 != C2425c.c(context).getInt("clipboardWorkaround", 0)) ? 29 <= i8 ? 1 == J1(1) ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_LOGS"), com.llamalab.automate.access.c.f15547h} : new E3.b[]{com.llamalab.automate.access.c.f15547h} : com.llamalab.automate.access.c.f15562w : 1 == J1(1) ? new E3.b[]{com.llamalab.automate.access.c.j("com.llamalab.automate.permission.ACCESS_PRIVILEGED")} : new E3.b[]{com.llamalab.automate.access.c.f15547h};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_clipboard_get_immediate, C2541R.string.caption_clipboard_get_change);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.varContent);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.varContent);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.varContent = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        N2 bVar;
        c1708z0.q(C2541R.string.stmt_clipboard_get_title);
        boolean z7 = J1(1) == 0;
        int i8 = Build.VERSION.SDK_INT;
        if (33 <= i8 && 1 == C2425c.c(c1708z0).getInt("clipboardWorkaround", 0)) {
            bVar = z7 ? new f() : new g();
        } else if (29 <= i8) {
            bVar = z7 ? new f() : new d();
        } else {
            if (z7) {
                s(c1708z0, ((ClipboardManager) c1708z0.getSystemService("clipboard")).getPrimaryClip());
                return true;
            }
            bVar = new b();
        }
        c1708z0.w(bVar);
        return false;
    }

    public final void s(C1708z0 c1708z0, ClipData clipData) {
        CharSequence coerceToText;
        if (this.varContent != null) {
            c1708z0.z(this.varContent.f4659Y, (clipData == null || clipData.getItemCount() <= 0 || (coerceToText = clipData.getItemAt(0).coerceToText(c1708z0)) == null) ? null : coerceToText.toString());
        }
        c1708z0.f17642x0 = this.onComplete;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        s(c1708z0, (ClipData) obj);
        return true;
    }
}
