package com.llamalab.automate.stmt;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import com.llamalab.automate.AbstractRunnableC1586h2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1619q;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.List;

@F3.f("app_foreground.html")
@F3.a(C2541R.integer.ic_app_foreground)
@F3.i(C2541R.string.stmt_app_foreground_title)
@F3.h(C2541R.string.stmt_app_foreground_summary)
@F3.e(C2541R.layout.stmt_app_foreground_edit)
/* loaded from: classes.dex */
public final class AppForeground extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 className;
    public InterfaceC1700x0 packageName;
    public J3.l varForegroundClassName;
    public J3.l varForegroundPackageName;

    public static final class a extends AbstractRunnableC1586h2 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f16241L1;

        /* renamed from: M1, reason: collision with root package name */
        public final String f16242M1;

        /* renamed from: N1, reason: collision with root package name */
        public ActivityManager f16243N1;

        /* renamed from: O1, reason: collision with root package name */
        public ComponentName f16244O1;

        /* renamed from: P1, reason: collision with root package name */
        public boolean f16245P1;

        public a(boolean z7, String str, String str2, ComponentName componentName) {
            super(500L);
            this.f16245P1 = z7;
            this.f16241L1 = str;
            this.f16242M1 = str2;
            this.f16244O1 = componentName;
        }

        @Override // com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            this.f16243N1 = (ActivityManager) automateService.getSystemService("activity");
            super.C(automateService, j8, j9, j10);
        }

        @Override // com.llamalab.automate.AbstractRunnableC1586h2
        public final boolean v2() {
            List<ActivityManager.RunningTaskInfo> runningTasks = this.f16243N1.getRunningTasks(1);
            ComponentName componentName = (runningTasks == null || runningTasks.isEmpty()) ? null : runningTasks.get(0).topActivity;
            if (componentName != null && !componentName.equals(this.f16244O1)) {
                this.f16244O1 = componentName;
                String str = this.f16242M1;
                String str2 = this.f16241L1;
                if (str2 == null && str == null) {
                    this.f16245P1 = true;
                    q2(new Object[]{Boolean.TRUE, componentName}, false);
                    return false;
                }
                if (this.f16245P1 != AppForeground.C(componentName, str2, str)) {
                    boolean z7 = !this.f16245P1;
                    this.f16245P1 = z7;
                    q2(new Object[]{Boolean.valueOf(z7), this.f16244O1}, false);
                    return false;
                }
            }
            return true;
        }
    }

    public static final class b extends C1619q {

        /* renamed from: N1, reason: collision with root package name */
        public final String f16246N1;

        /* renamed from: O1, reason: collision with root package name */
        public final String f16247O1;

        /* renamed from: P1, reason: collision with root package name */
        public ComponentName f16248P1;

        /* renamed from: Q1, reason: collision with root package name */
        public boolean f16249Q1;

        public b(boolean z7, String str, String str2, ComponentName componentName) {
            super(32, 0);
            this.f16249Q1 = z7;
            this.f16246N1 = str;
            this.f16247O1 = str2;
            this.f16248P1 = componentName;
        }

        @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
        public final void R0(AutomateAccessibilityService automateAccessibilityService, AccessibilityEvent accessibilityEvent) {
            if (32 == accessibilityEvent.getEventType()) {
                try {
                    ComponentName componentName = automateAccessibilityService.f14503N1;
                    if (componentName != null && componentName != this.f16248P1) {
                        this.f16248P1 = componentName;
                        String str = this.f16246N1;
                        if (str == null && this.f16247O1 == null) {
                            this.f16249Q1 = true;
                            q2(new Object[]{Boolean.TRUE, componentName}, false);
                        } else if (this.f16249Q1 != AppForeground.C(componentName, str, this.f16247O1)) {
                            boolean z7 = !this.f16249Q1;
                            this.f16249Q1 = z7;
                            q2(new Object[]{Boolean.valueOf(z7), this.f16248P1}, false);
                        }
                    }
                } catch (Throwable th) {
                    r2(th);
                }
            }
        }
    }

    public static boolean C(ComponentName componentName, String str, String str2) {
        return (str == null || str.equals(componentName.getPackageName())) && (str2 == null || str2.equals(componentName.getClassName()));
    }

    public final void B(C1708z0 c1708z0, boolean z7, ComponentName componentName) {
        J3.l lVar = this.varForegroundPackageName;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, componentName != null ? componentName.getPackageName() : null);
        }
        J3.l lVar2 = this.varForegroundClassName;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, componentName != null ? componentName.getClassName() : null);
        }
        o(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 21 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15540a} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.GET_TASKS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_app_foreground_immediate, C2541R.string.caption_app_foreground_change);
        return c1596k0.o(-1, this.className).o(2, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        dVar.g(this.className);
        dVar.g(this.varForegroundPackageName);
        dVar.g(this.varForegroundClassName);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.packageName);
        visitor.b(this.className);
        visitor.b(this.varForegroundPackageName);
        visitor.b(this.varForegroundClassName);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return ViewOnClickListenerC1667s.w(null, 1);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.className = (InterfaceC1700x0) cVar.readObject();
        this.varForegroundPackageName = (J3.l) cVar.readObject();
        this.varForegroundClassName = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_app_foreground_title);
        ComponentName componentName = null;
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        String x8 = J3.h.x(c1708z0, this.className, null);
        if (21 <= Build.VERSION.SDK_INT) {
            ComponentName componentName2 = AbstractStatement.f().f14503N1;
            boolean z7 = componentName2 != null && C(componentName2, x7, x8);
            if (J1(1) == 0) {
                B(c1708z0, z7, componentName2);
                return true;
            }
            c1708z0.w(new b(z7, x7, x8, componentName2));
            return false;
        }
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) c1708z0.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && !runningTasks.isEmpty()) {
            componentName = runningTasks.get(0).topActivity;
        }
        boolean z8 = componentName != null && C(componentName, x7, x8);
        if (J1(1) == 0) {
            B(c1708z0, z8, componentName);
            return true;
        }
        a aVar = new a(z8, x7, x8, componentName);
        c1708z0.w(aVar);
        aVar.f15400Y.f14581L1.post(aVar);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        B(c1708z0, ((Boolean) objArr[0]).booleanValue(), (ComponentName) objArr[1]);
        return true;
    }
}
