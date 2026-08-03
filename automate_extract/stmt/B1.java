package com.llamalab.automate.stmt;

import P.C1091g;
import android.os.AsyncTask;
import android.os.Build;
import android.view.Display;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1619q;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.xpath.XPathExpression;
import k0.RunnableC2034k;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public abstract class B1 extends C1619q {

    /* renamed from: N1, reason: collision with root package name */
    public final AtomicBoolean f16324N1;

    /* renamed from: O1, reason: collision with root package name */
    public final String f16325O1;

    /* renamed from: P1, reason: collision with root package name */
    public final int f16326P1;

    /* renamed from: Q1, reason: collision with root package name */
    public final String f16327Q1;

    /* renamed from: R1, reason: collision with root package name */
    public final XPathExpression f16328R1;

    public B1(boolean z7, String str, int i8, String str2, XPathExpression xPathExpression) {
        super(z7 ? 0 : 2080, 0);
        this.f16324N1 = new AtomicBoolean();
        this.f16325O1 = str;
        this.f16326P1 = i8;
        this.f16327Q1 = str2;
        this.f16328R1 = xPathExpression;
    }

    public abstract boolean A2(AutomateAccessibilityService automateAccessibilityService, Node node, long j8);

    @Override // com.llamalab.automate.C1619q, com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        this.f16324N1.set(true);
        super.F(automateService);
    }

    @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
    public final void R0(AutomateAccessibilityService automateAccessibilityService, AccessibilityEvent accessibilityEvent) {
        if ((this.f16186L1 == 0) || this.f16324N1.get() || !w2(accessibilityEvent)) {
            return;
        }
        automateAccessibilityService.h(this.f16327Q1);
    }

    @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
    public final void U1(AutomateAccessibilityService automateAccessibilityService) {
        super.U1(automateAccessibilityService);
        if (this.f16186L1 == 0) {
            AtomicBoolean atomicBoolean = this.f16324N1;
            if (atomicBoolean.get()) {
                return;
            }
            try {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(new RunnableC2034k(this, 27, automateAccessibilityService));
            } catch (RejectedExecutionException e8) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    r2(e8);
                }
            }
        }
    }

    @Override // com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
    public final void r0(AutomateAccessibilityService automateAccessibilityService, AccessibilityEvent accessibilityEvent, Element element, String str, long j8) {
        boolean z7;
        if (this.f16327Q1.equals(str)) {
            if (this.f16186L1 == 0) {
                return;
            }
            AtomicBoolean atomicBoolean = this.f16324N1;
            if (atomicBoolean.get() || !w2(accessibilityEvent)) {
                return;
            }
            try {
                A2(automateAccessibilityService, element, j8);
            } catch (Throwable th) {
                Throwable th2 = th;
                while (true) {
                    if (th2 == null) {
                        z7 = false;
                        break;
                    } else {
                        if ((th2 instanceof DOMException) && ((DOMException) th2).code == 11) {
                            z7 = true;
                            break;
                        }
                        th2 = th2.getCause();
                    }
                }
                if (z7 || !atomicBoolean.compareAndSet(false, true)) {
                    return;
                }
                r2(th);
            }
        }
    }

    public final boolean v2(AutomateAccessibilityService automateAccessibilityService) {
        Display display;
        long nanoTime = System.nanoTime();
        display = C1091g.e(automateAccessibilityService.getSystemService("display")).getDisplay(this.f16326P1);
        if (display == null) {
            throw new DOMException((short) 11, "display lost");
        }
        List<AccessibilityWindowInfo> e8 = automateAccessibilityService.e(display.getDisplayId());
        automateAccessibilityService.f14511y1.getClass();
        i3.m a8 = i3.r.a(display, e8);
        try {
            return A2(automateAccessibilityService, a8, System.nanoTime() - nanoTime);
        } finally {
            a8.a();
        }
    }

    public final boolean w2(AccessibilityEvent accessibilityEvent) {
        int eventType = accessibilityEvent.getEventType();
        if (eventType != 32 && eventType != 2048) {
            return false;
        }
        CharSequence packageName = accessibilityEvent.getPackageName();
        if (packageName == null) {
            packageName = "android";
        }
        return y2(packageName);
    }

    public final boolean x2(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityWindowInfo window;
        int displayId;
        boolean z7;
        CharSequence packageName = accessibilityNodeInfo.getPackageName();
        if (packageName == null) {
            packageName = "android";
        }
        if (!y2(packageName)) {
            return false;
        }
        if (30 <= Build.VERSION.SDK_INT) {
            int i8 = this.f16326P1;
            if (-1 == i8) {
                z7 = true;
            } else {
                window = accessibilityNodeInfo.getWindow();
                if (window == null) {
                    throw new DOMException((short) 11, "node window lost");
                }
                try {
                    displayId = window.getDisplayId();
                    z7 = i8 == displayId;
                } finally {
                    window.recycle();
                }
            }
            if (!z7) {
                return false;
            }
        }
        return true;
    }

    public boolean y2(CharSequence charSequence) {
        String str = this.f16325O1;
        return str == null || str.contentEquals(charSequence);
    }

    public abstract void z2(boolean z7);
}
