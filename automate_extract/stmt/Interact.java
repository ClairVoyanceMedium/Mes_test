package com.llamalab.automate.stmt;

import C1.D1;
import L3.C1046k;
import L3.C1047l;
import L3.C1049n;
import L3.C1052q;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractC1553a2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.expr.func.XPathEncode;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import x3.C2425c;
import x3.C2446x;

@F3.f("interact.html")
@F3.a(C2541R.integer.ic_action_screen_click)
@F3.i(C2541R.string.stmt_interact_title)
@F3.h(C2541R.string.stmt_interact_summary)
@F3.e(C2541R.layout.stmt_interact_edit)
/* loaded from: classes.dex */
public final class Interact extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 action;
    public InterfaceC1700x0 argX;
    public InterfaceC1700x0 argY;
    public InterfaceC1700x0 displayId;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 schema;
    public J3.l varContent;
    public InterfaceC1700x0 xpathExpression;

    public static class a extends e {
        public final int U1;

        public a(boolean z7, String str, int i8, String str2, XPathExpression xPathExpression, int i9, int i10, boolean z8) {
            super(z7, str, i8, str2, xPathExpression, i9, z8);
            this.U1 = i10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x002c, code lost:
        
            if ((r6.getActions() & r4) == r4) goto L12;
         */
        @Override // com.llamalab.automate.stmt.Interact.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean C2(AccessibilityNodeInfo accessibilityNodeInfo) {
            boolean z7;
            List actionList;
            int id;
            int i8 = Build.VERSION.SDK_INT;
            int i9 = this.U1;
            if (21 <= i8) {
                actionList = accessibilityNodeInfo.getActionList();
                Iterator it = actionList.iterator();
                while (it.hasNext()) {
                    id = B.H.q(it.next()).getId();
                    if (i9 == id) {
                        z7 = true;
                        break;
                    }
                }
                z7 = false;
            }
            if (z7) {
                B2(null, D2(accessibilityNodeInfo));
                return true;
            }
            if (this.f16746T1) {
                F5.n.f(this, "Interact Action not allowed on node");
            }
            return false;
        }

        public boolean D2(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.performAction(this.U1);
        }
    }

    public static class b extends a {

        /* renamed from: V1, reason: collision with root package name */
        public final Bundle f16743V1;

        public b(boolean z7, String str, int i8, String str2, XPathExpression xPathExpression, int i9, int i10, Bundle bundle, boolean z8) {
            super(z7, str, i8, str2, xPathExpression, i9, i10, z8);
            this.f16743V1 = bundle;
        }

        @Override // com.llamalab.automate.stmt.Interact.a
        public final boolean D2(AccessibilityNodeInfo accessibilityNodeInfo) {
            boolean performAction;
            performAction = accessibilityNodeInfo.performAction(this.U1, this.f16743V1);
            return performAction;
        }
    }

    public static abstract class c extends AbstractC1553a2 implements View.OnAttachStateChangeListener, Runnable {

        /* renamed from: N1, reason: collision with root package name */
        public final AtomicBoolean f16744N1 = new AtomicBoolean();

        @Override // com.llamalab.automate.AbstractC1553a2, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            automateService.f14581L1.removeCallbacks(this);
            super.F(automateService);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            try {
                if (view.hasWindowFocus()) {
                    this.f15400Y.f14581L1.post(this);
                } else if (!view.requestFocus()) {
                    throw new IllegalStateException("Failed to request focus");
                }
            } catch (Throwable th) {
                r2(th);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int x22;
            try {
                if (!this.f16744N1.compareAndSet(false, true) || (x22 = x2((InputMethodManager) this.f15400Y.getSystemService("input_method"))) <= 0) {
                    q2(new Object[]{Boolean.TRUE, null}, false);
                } else {
                    this.f15400Y.f14581L1.postDelayed(this, x22);
                }
            } catch (Throwable th) {
                r2(th);
            }
        }

        @Override // com.llamalab.automate.AbstractC1553a2
        public final View v2(AutomateService automateService) {
            U u8 = new U(this, automateService);
            u8.addOnAttachStateChangeListener(this);
            return u8;
        }

        public abstract int x2(InputMethodManager inputMethodManager);
    }

    public static class d extends e {
        public d(boolean z7, String str, int i8, String str2, XPathExpression xPathExpression, boolean z8) {
            super(z7, str, i8, str2, xPathExpression, 0, z8);
        }

        @Override // com.llamalab.automate.stmt.Interact.e
        public final boolean C2(AccessibilityNodeInfo accessibilityNodeInfo) {
            B2(C2446x.l(accessibilityNodeInfo.getText()), true);
            return true;
        }
    }

    public static abstract class e extends B1 {

        /* renamed from: S1, reason: collision with root package name */
        public final int f16745S1;

        /* renamed from: T1, reason: collision with root package name */
        public final boolean f16746T1;

        public e(boolean z7, String str, int i8, String str2, XPathExpression xPathExpression, int i9, boolean z8) {
            super(z7, str, i8, str2, xPathExpression);
            this.f16745S1 = i9;
            this.f16746T1 = z8;
        }

        @Override // com.llamalab.automate.stmt.B1
        public final boolean A2(AutomateAccessibilityService automateAccessibilityService, Node node, long j8) {
            long nanoTime = System.nanoTime();
            NodeList nodeList = (NodeList) this.f16328R1.evaluate(node, XPathConstants.NODESET);
            long nanoTime2 = System.nanoTime() - nanoTime;
            long j9 = j8 + nanoTime2;
            if (this.f16746T1) {
                double d8 = j8;
                double d9 = nanoTime2;
                double d10 = j9;
                F5.n.f(this, String.format(Locale.US, "%s xml_time_stats: document=%.2fms, evaluate=%.2fms, total=%.2fms", "Interact", F5.n.l(d8, d8, d8, 1000000.0d), F5.n.l(d9, d9, d9, 1000000.0d), F5.n.l(d10, d10, d10, 1000000.0d)));
            }
            if (nodeList != null) {
                int i8 = -1;
                while (true) {
                    i8++;
                    Node item = nodeList.item(i8);
                    if (item == null) {
                        break;
                    }
                    if (21 <= Build.VERSION.SDK_INT) {
                        if (("http://schemas.android.com/apk/res/android/display".equals(this.f16327Q1) && 1 == item.getNodeType() && "window".equals(item.getNodeName())) && (this.f16745S1 & 1) != 0) {
                            item = item.getLastChild().getFirstChild();
                        }
                    }
                    AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) item.getFeature("+AccessibilityNodeInfo", null);
                    if (accessibilityNodeInfo != null && x2(accessibilityNodeInfo) && C2(accessibilityNodeInfo)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final void B2(Object obj, boolean z7) {
            if (this.f16324N1.compareAndSet(false, true)) {
                q2(new Object[]{Boolean.valueOf(z7), obj}, false);
            }
        }

        public abstract boolean C2(AccessibilityNodeInfo accessibilityNodeInfo);

        @Override // com.llamalab.automate.stmt.B1
        public final boolean y2(CharSequence charSequence) {
            return super.y2(charSequence) && !this.f15400Y.getPackageName().contentEquals(charSequence);
        }

        @Override // com.llamalab.automate.stmt.B1
        public final void z2(boolean z7) {
            if (z7) {
                return;
            }
            B2(null, false);
        }
    }

    public static final class f extends c {
        @Override // com.llamalab.automate.AbstractC1553a2
        public final AbstractC1553a2 w2(WindowManager.LayoutParams layoutParams) {
            layoutParams.softInputMode = 1;
            super.w2(layoutParams);
            return this;
        }

        @Override // com.llamalab.automate.stmt.Interact.c
        public final int x2(InputMethodManager inputMethodManager) {
            inputMethodManager.showInputMethodPicker();
            return MoreOsConstants.KEY_PLAYCD;
        }
    }

    public static final class g extends c {
        @Override // com.llamalab.automate.AbstractC1553a2
        public final AbstractC1553a2 w2(WindowManager.LayoutParams layoutParams) {
            layoutParams.softInputMode = 5;
            super.w2(layoutParams);
            return this;
        }

        @Override // com.llamalab.automate.stmt.Interact.c
        public final int x2(InputMethodManager inputMethodManager) {
            inputMethodManager.showSoftInput(this.f15481L1, 2);
            if (34 > Build.VERSION.SDK_INT) {
                return 0;
            }
            inputMethodManager.restartInput(this.f15481L1);
            return 0;
        }
    }

    public static void B(int i8, int i9) {
        if (i8 > Build.VERSION.SDK_INT) {
            throw new IncapableAndroidVersionException(i8, B4.g.f(i9, new StringBuilder("action 0x")));
        }
    }

    public final boolean C(C1708z0 c1708z0, boolean z7, Object obj) {
        J3.l lVar = this.varContent;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        o(c1708z0, z7);
        return true;
    }

    public final XPathExpression D(C1708z0 c1708z0) {
        return com.llamalab.automate.J.e().compile(J3.h.x(c1708z0, this.xpathExpression, ".//*[not(window) and @android:focused]"));
    }

    public final void E(C1708z0 c1708z0, int i8) {
        c1708z0.w(new a(J1(0) == 0, J3.h.x(c1708z0, this.packageName, null), J3.h.m(c1708z0, this.displayId, 0), J3.h.x(c1708z0, this.schema, "http://schemas.android.com/apk/res/android/layout"), D(c1708z0), 0, i8, C1710z2.a(C2425c.c(c1708z0))));
    }

    public final void F(C1708z0 c1708z0, int i8, Bundle bundle, int i9) {
        c1708z0.w(new b(J1(0) == 0, J3.h.x(c1708z0, this.packageName, null), J3.h.m(c1708z0, this.displayId, 0), J3.h.x(c1708z0, this.schema, "http://schemas.android.com/apk/res/android/layout"), D(c1708z0), i9, i8, bundle, C1710z2.a(C2425c.c(c1708z0))));
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15540a};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 0, C2541R.string.caption_interact_immediate, C2541R.string.caption_interact_change);
        C1596k0 o6 = c1596k0.e(this.action, null, C2541R.xml.interactions).o(0, this.packageName);
        o6.v(this.xpathExpression, 0);
        return o6.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        InterfaceC1700x0 interfaceC1700x0;
        z(dVar, 59);
        dVar.g(this.action);
        dVar.g(this.argX);
        if (94 <= dVar.f6413Z) {
            dVar.g(this.argY);
        }
        if (75 <= dVar.f6413Z) {
            dVar.g(this.packageName);
        }
        if (105 <= dVar.f6413Z) {
            dVar.g(this.displayId);
            dVar.g(this.schema);
        }
        if (90 <= dVar.f6413Z) {
            interfaceC1700x0 = this.xpathExpression;
        } else {
            interfaceC1700x0 = null;
            dVar.g(null);
            dVar.g(null);
        }
        dVar.g(interfaceC1700x0);
        if (48 <= dVar.f6413Z) {
            dVar.g(this.varContent);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.action);
        visitor.b(this.argX);
        visitor.b(this.argY);
        visitor.b(this.packageName);
        visitor.b(this.displayId);
        visitor.b(this.schema);
        visitor.b(this.xpathExpression);
        visitor.b(this.varContent);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new V();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        boolean z7;
        int i8;
        int i9;
        InterfaceC1700x0 interfaceC1700x0;
        Interact interact = this;
        interact.w(cVar, 59);
        interact.action = (InterfaceC1700x0) cVar.readObject();
        interact.argX = (InterfaceC1700x0) cVar.readObject();
        if (94 <= cVar.f6409x0) {
            interact.argY = (InterfaceC1700x0) cVar.readObject();
        }
        if (75 <= cVar.f6409x0) {
            interact.packageName = (InterfaceC1700x0) cVar.readObject();
        }
        if (105 <= cVar.f6409x0) {
            interact.displayId = (InterfaceC1700x0) cVar.readObject();
            interact.schema = (InterfaceC1700x0) cVar.readObject();
        }
        if (90 <= cVar.f6409x0) {
            interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        } else {
            InterfaceC1700x0 interfaceC1700x02 = (InterfaceC1700x0) cVar.readObject();
            InterfaceC1700x0 interfaceC1700x03 = (InterfaceC1700x0) cVar.readObject();
            InterfaceC1700x0 interfaceC1700x04 = (InterfaceC1700x0) cVar.readObject();
            if (interfaceC1700x02 == null && interfaceC1700x03 == null && interfaceC1700x04 == null) {
                interfaceC1700x0 = null;
            } else {
                String[] strArr = new String[4];
                InterfaceC1700x0[] interfaceC1700x0Arr = new InterfaceC1700x0[3];
                if (interfaceC1700x02 != null) {
                    L3.V v8 = new L3.V(1);
                    String[] strArr2 = v8.f4943X;
                    strArr2[0] = "fn:choose(@class,string(@class),name())=";
                    v8.f4944Y[0] = new XPathEncode(interfaceC1700x02);
                    strArr2[1] = "";
                    v8.f4945Z[0] = 1;
                    strArr[0] = "fn:reverse((.//*[";
                    interfaceC1700x0Arr[0] = new C1047l(new C1049n(new C1052q(interfaceC1700x02)), new L3.W("true()"), v8);
                    z7 = true;
                    i8 = 1;
                } else {
                    strArr[0] = "fn:reverse((.//*";
                    z7 = false;
                    i8 = 0;
                }
                if (interfaceC1700x03 != null) {
                    L3.V v9 = new L3.V(1);
                    String[] strArr3 = v9.f4943X;
                    strArr3[0] = "(@android:contentDescription|@android:text[not(../@android:editable)])[fn:glob(.,";
                    v9.f4944Y[0] = new XPathEncode(interfaceC1700x03);
                    strArr3[1] = ")]";
                    v9.f4945Z[0] = 1;
                    if (z7) {
                        strArr[1] = " and ";
                        i9 = 2;
                    } else {
                        strArr[0] = D1.m(new StringBuilder(), strArr[0], "[");
                        i9 = 1;
                    }
                    interfaceC1700x0Arr[i8] = new C1047l(new C1049n(new C1052q(interfaceC1700x03)), new L3.W("true()"), v9);
                    i8++;
                    z7 = true;
                } else {
                    i9 = 1;
                }
                if (interfaceC1700x04 != null) {
                    L3.V v10 = new L3.V(1);
                    v10.f4943X[0] = "@android:id=";
                    v10.f4944Y[0] = new XPathEncode(new C1046k(new L3.W("@"), new C1052q(interfaceC1700x04)));
                    v10.f4943X[1] = "";
                    v10.f4945Z[0] = 1;
                    if (z7) {
                        strArr[i9] = " and ";
                        i9++;
                    } else {
                        int i10 = i9 - 1;
                        strArr[i10] = D1.m(new StringBuilder(), strArr[i10], "[");
                    }
                    interfaceC1700x0Arr[i8] = new C1047l(new C1049n(new C1052q(interfaceC1700x04)), new L3.W("true()"), v10);
                    i8++;
                }
                int i11 = i9 + 1;
                strArr[i9] = "])[1]/ancestor-or-self::*)";
                L3.V v11 = new L3.V(i8);
                System.arraycopy(strArr, 0, v11.f4943X, 0, i11);
                System.arraycopy(interfaceC1700x0Arr, 0, v11.f4944Y, 0, i8);
                interfaceC1700x0 = v11;
            }
            interact = this;
        }
        interact.xpathExpression = interfaceC1700x0;
        if (48 <= cVar.f6409x0) {
            interact.varContent = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
        int id;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
        int id2;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
        int id3;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
        int id4;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
        int id5;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
        int id6;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
        int id7;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
        int id8;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
        int id9;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
        int id10;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
        int id11;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
        int id12;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
        int id13;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
        int id14;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
        int id15;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
        int id16;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
        int id17;
        c1708z0.q(C2541R.string.stmt_interact_title);
        int m8 = J3.h.m(c1708z0, this.action, 0);
        if (m8 == 0) {
            c1708z0.w(new d(J1(0) == 0, J3.h.x(c1708z0, this.packageName, null), J3.h.m(c1708z0, this.displayId, 0), J3.h.x(c1708z0, this.schema, "http://schemas.android.com/apk/res/android/layout"), D(c1708z0), C1710z2.a(C2425c.c(c1708z0))));
            return false;
        }
        if (m8 != 1 && m8 != 2) {
            switch (m8) {
                case 4:
                case 8:
                    break;
                case 16:
                case 32:
                case 64:
                case 128:
                case MoreOsConstants.O_DSYNC /* 4096 */:
                case 8192:
                    B(16, m8);
                    E(c1708z0, m8 & 16777215);
                    return false;
                case 256:
                case 512:
                    B(16, m8);
                    int m9 = J3.h.m(c1708z0, this.argX, 1);
                    boolean f8 = J3.h.f(c1708z0, this.argY, false);
                    Bundle bundle = new Bundle();
                    bundle.putInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT", m9);
                    if (18 <= Build.VERSION.SDK_INT) {
                        bundle.putBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN", f8);
                    }
                    F(c1708z0, m8 & 16777215, bundle, 0);
                    return false;
                case 1024:
                case 2048:
                    B(16, m8);
                    String upperCase = J3.h.x(c1708z0, this.argX, "INPUT").toUpperCase(Locale.US);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("ACTION_ARGUMENT_HTML_ELEMENT_STRING", upperCase);
                    F(c1708z0, m8 & 16777215, bundle2, 0);
                    return false;
                case MoreOsConstants.IN_Q_OVERFLOW /* 16384 */:
                case 32768:
                case MoreOsConstants.O_DIRECTORY /* 65536 */:
                    B(18, m8);
                    E(c1708z0, m8 & 16777215);
                    return false;
                case MoreOsConstants.O_NOFOLLOW /* 131072 */:
                    B(18, m8);
                    Integer o6 = J3.h.o(c1708z0, this.argX, null);
                    Integer o8 = J3.h.o(c1708z0, this.argY, null);
                    Bundle bundle3 = new Bundle();
                    if (o6 != null) {
                        bundle3.putInt("ACTION_ARGUMENT_SELECTION_START_INT", o6.intValue());
                    }
                    if (o8 != null) {
                        bundle3.putInt("ACTION_ARGUMENT_SELECTION_END_INT", o8.intValue());
                    }
                    F(c1708z0, m8 & 16777215, bundle3, 0);
                    return false;
                case 262144:
                case 524288:
                case 1048576:
                    B(19, m8);
                    E(c1708z0, m8 & 16777215);
                    return false;
                case MoreOsConstants.O_PATH /* 2097152 */:
                    B(21, m8);
                    String x7 = J3.h.x(c1708z0, this.argX, null);
                    Bundle bundle4 = new Bundle();
                    bundle4.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", x7);
                    F(c1708z0, m8 & 16777215, bundle4, 0);
                    return false;
                default:
                    switch (m8) {
                        case 4194305:
                            B(23, m8);
                            accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
                            id = accessibilityAction.getId();
                            E(c1708z0, id);
                            return false;
                        case 4194306:
                            B(23, m8);
                            Integer o9 = J3.h.o(c1708z0, this.argX, null);
                            Integer o10 = J3.h.o(c1708z0, this.argY, null);
                            Bundle bundle5 = new Bundle();
                            if (o9 != null) {
                                bundle5.putInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT", o9.intValue());
                            }
                            if (o10 != null) {
                                bundle5.putInt("android.view.accessibility.action.ARGUMENT_ROW_INT", o10.intValue());
                            }
                            accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
                            id2 = accessibilityAction2.getId();
                            F(c1708z0, id2, bundle5, 0);
                            return false;
                        case 4194307:
                            B(23, m8);
                            accessibilityAction3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
                            id3 = accessibilityAction3.getId();
                            E(c1708z0, id3);
                            return false;
                        case 4194308:
                            B(23, m8);
                            accessibilityAction4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
                            id4 = accessibilityAction4.getId();
                            E(c1708z0, id4);
                            return false;
                        case 4194309:
                            B(23, m8);
                            accessibilityAction5 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
                            id5 = accessibilityAction5.getId();
                            E(c1708z0, id5);
                            return false;
                        case 4194310:
                            B(23, m8);
                            accessibilityAction6 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
                            id6 = accessibilityAction6.getId();
                            E(c1708z0, id6);
                            return false;
                        case 4194311:
                            B(23, m8);
                            accessibilityAction7 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
                            id7 = accessibilityAction7.getId();
                            E(c1708z0, id7);
                            return false;
                        case 4194312:
                            B(24, m8);
                            float l8 = J3.h.l(c1708z0, this.argX, 0.0f);
                            Bundle bundle6 = new Bundle();
                            bundle6.putFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE", l8);
                            accessibilityAction8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
                            id8 = accessibilityAction8.getId();
                            F(c1708z0, id8, bundle6, 0);
                            return false;
                        case 4194313:
                            B(26, m8);
                            Integer o11 = J3.h.o(c1708z0, this.argX, null);
                            Integer o12 = J3.h.o(c1708z0, this.argY, null);
                            Bundle bundle7 = new Bundle();
                            if (o11 != null) {
                                bundle7.putInt("ACTION_ARGUMENT_MOVE_WINDOW_X", o11.intValue());
                            }
                            if (o12 != null) {
                                bundle7.putInt("ACTION_ARGUMENT_MOVE_WINDOW_Y", o12.intValue());
                            }
                            accessibilityAction9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
                            id9 = accessibilityAction9.getId();
                            F(c1708z0, id9, bundle7, 1);
                            return false;
                        case 4194314:
                            B(28, m8);
                            accessibilityAction10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
                            id10 = accessibilityAction10.getId();
                            E(c1708z0, id10);
                            return false;
                        case 4194315:
                            B(28, m8);
                            accessibilityAction11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
                            id11 = accessibilityAction11.getId();
                            E(c1708z0, id11);
                            return false;
                        case 4194316:
                            B(29, m8);
                            accessibilityAction12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
                            id12 = accessibilityAction12.getId();
                            E(c1708z0, id12);
                            return false;
                        case 4194317:
                            B(29, m8);
                            accessibilityAction13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
                            id13 = accessibilityAction13.getId();
                            E(c1708z0, id13);
                            return false;
                        case 4194318:
                            B(29, m8);
                            accessibilityAction14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
                            id14 = accessibilityAction14.getId();
                            E(c1708z0, id14);
                            return false;
                        case 4194319:
                            B(29, m8);
                            accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
                            id15 = accessibilityAction15.getId();
                            E(c1708z0, id15);
                            return false;
                        case 4194320:
                            B(30, m8);
                            int e8 = (int) y4.j.e(J3.h.t(c1708z0, this.argX, 0L), 0L, 10000L);
                            Bundle bundle8 = new Bundle();
                            bundle8.putInt("android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT", e8);
                            accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
                            id16 = accessibilityAction16.getId();
                            F(c1708z0, id16, bundle8, 0);
                            return false;
                        case 4194321:
                            B(30, m8);
                            accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
                            id17 = accessibilityAction17.getId();
                            E(c1708z0, id17);
                            return false;
                        default:
                            switch (m8) {
                                case 16777217:
                                case 16777218:
                                case 16777219:
                                case 16777220:
                                case 16777221:
                                case 16777222:
                                    B(16, m8);
                                    o(c1708z0, AbstractStatement.f().performGlobalAction(m8 & 16777215));
                                    return true;
                                case 16777223:
                                    B(24, m8);
                                    o(c1708z0, AbstractStatement.f().performGlobalAction(m8 & 16777215));
                                    return true;
                                case 16777224:
                                case 16777225:
                                    B(28, m8);
                                    o(c1708z0, AbstractStatement.f().performGlobalAction(m8 & 16777215));
                                    return true;
                                case 16777226:
                                case 16777227:
                                case 16777228:
                                case 16777229:
                                case 16777230:
                                case 16777231:
                                    B(31, m8);
                                    o(c1708z0, AbstractStatement.f().performGlobalAction(m8 & 16777215));
                                    return true;
                                default:
                                    switch (m8) {
                                        case 33554433:
                                            if (31 <= Build.VERSION.SDK_INT) {
                                                o(c1708z0, AbstractStatement.f().performGlobalAction(15));
                                                return true;
                                            }
                                            c1708z0.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                                            C(c1708z0, true, null);
                                            return true;
                                        case 33554434:
                                            if (28 > Build.VERSION.SDK_INT) {
                                                ((InputMethodManager) c1708z0.getSystemService("input_method")).showInputMethodPicker();
                                                C(c1708z0, true, null);
                                                return true;
                                            }
                                            com.llamalab.automate.access.c.f15547h.w(c1708z0);
                                            f fVar = new f();
                                            c1708z0.w(fVar);
                                            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, AbstractC1553a2.f15480M1, 304, -3);
                                            layoutParams.gravity = 51;
                                            fVar.w2(layoutParams);
                                            return false;
                                        case 33554435:
                                            ((AudioManager) c1708z0.getSystemService("audio")).adjustVolume(0, 1);
                                            C(c1708z0, true, null);
                                            return true;
                                        case 33554436:
                                            com.llamalab.automate.access.c.f15547h.w(c1708z0);
                                            g gVar = new g();
                                            c1708z0.w(gVar);
                                            WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(0, 0, AbstractC1553a2.f15480M1, 304, -3);
                                            layoutParams2.gravity = 51;
                                            gVar.w2(layoutParams2);
                                            return false;
                                        default:
                                            throw new IllegalArgumentException(B4.g.f(m8, new StringBuilder("Illegal action: 0x")));
                                    }
                            }
                    }
            }
        }
        E(c1708z0, m8 & 16777215);
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        C(c1708z0, ((Boolean) objArr[0]).booleanValue(), objArr[1]);
        return true;
    }
}
