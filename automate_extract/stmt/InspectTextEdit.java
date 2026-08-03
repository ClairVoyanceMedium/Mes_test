package com.llamalab.automate.stmt;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1619q;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import x3.C2440r;

@F3.f("inspect_text_edit.html")
@F3.a(C2541R.integer.ic_action_key_press)
@F3.i(C2541R.string.stmt_inspect_text_edit_title)
@F3.h(C2541R.string.stmt_inspect_text_edit_summary)
@F3.e(C2541R.layout.stmt_inspect_text_edit_edit)
/* loaded from: classes.dex */
public final class InspectTextEdit extends Action implements AsyncStatement {
    public InterfaceC1700x0 inputType;
    public InterfaceC1700x0 packageName;
    public J3.l varInputType;
    public J3.l varNewText;
    public J3.l varOldText;
    public J3.l varPackageName;
    public J3.l varSelectionEnd;
    public J3.l varSelectionStart;
    public J3.l varTextMaxLength;

    public static final class a extends C1619q.a {

        /* renamed from: R1, reason: collision with root package name */
        public int f16740R1;

        /* renamed from: S1, reason: collision with root package name */
        public String f16741S1;

        /* renamed from: T1, reason: collision with root package name */
        public AccessibilityNodeInfo f16742T1;

        public a() {
            super(8216, 0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
        
            r2 = r2.getMaxTextLength();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Double A2(AccessibilityNodeInfo accessibilityNodeInfo) {
            int maxTextLength;
            if (21 > Build.VERSION.SDK_INT || maxTextLength < 0) {
                return null;
            }
            return Double.valueOf(maxTextLength);
        }

        public final boolean B2(int i8, int i9) {
            int textSelectionStart;
            int textSelectionEnd;
            textSelectionStart = this.f16742T1.getTextSelectionStart();
            if (Math.max(0, textSelectionStart) != Math.max(0, i8)) {
                return false;
            }
            textSelectionEnd = this.f16742T1.getTextSelectionEnd();
            return Math.max(0, textSelectionEnd) == Math.max(0, i9);
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00f1  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
        @Override // com.llamalab.automate.C1619q.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void x2(AccessibilityEvent accessibilityEvent) {
            int inputType;
            boolean z7;
            int textSelectionStart;
            boolean z8;
            CharSequence charSequence;
            boolean isEditable;
            int inputType2;
            int textSelectionStart2;
            int textSelectionEnd;
            int inputType3;
            int textSelectionStart3;
            int textSelectionEnd2;
            int textSelectionEnd3;
            int textSelectionStart4;
            boolean z9;
            AccessibilityNodeInfo accessibilityNodeInfo;
            int textSelectionStart5;
            int textSelectionEnd4;
            int inputType4;
            int textSelectionEnd5;
            int inputType5;
            AccessibilityNodeInfo source = accessibilityEvent.getSource();
            if (source == null) {
                return;
            }
            String str = this.f16741S1;
            if (str == null || str.contentEquals(source.getPackageName())) {
                inputType = source.getInputType();
                int i8 = this.f16740R1;
                if ((inputType & i8) == i8) {
                    z7 = true;
                    if (z7) {
                        return;
                    }
                    int eventType = accessibilityEvent.getEventType();
                    if (eventType == 8) {
                        textSelectionStart = source.getTextSelectionStart();
                        if (textSelectionStart != -1) {
                            textSelectionEnd3 = source.getTextSelectionEnd();
                            if (textSelectionEnd3 != -1) {
                                z8 = true;
                                charSequence = z8 ? (CharSequence) C2440r.l(accessibilityEvent.getText()) : null;
                                isEditable = source.isEditable();
                                if (isEditable || !"android.widget.EditText".contentEquals(accessibilityEvent.getClassName())) {
                                    return;
                                }
                                inputType2 = source.getInputType();
                                if (inputType2 == 0 || source.equals(this.f16742T1)) {
                                    return;
                                }
                                if (this.f16742T1 != null) {
                                    textSelectionStart3 = source.getTextSelectionStart();
                                    textSelectionEnd2 = source.getTextSelectionEnd();
                                    if (B2(textSelectionStart3, textSelectionEnd2) && TextUtils.equals(this.f16742T1.getText(), charSequence)) {
                                        return;
                                    }
                                }
                                AccessibilityNodeInfo accessibilityNodeInfo2 = this.f16742T1;
                                if (accessibilityNodeInfo2 != null) {
                                    accessibilityNodeInfo2.recycle();
                                }
                                this.f16742T1 = AccessibilityNodeInfo.obtain(source);
                                String d8 = O.b.d("", charSequence);
                                textSelectionStart2 = source.getTextSelectionStart();
                                textSelectionEnd = source.getTextSelectionEnd();
                                inputType3 = source.getInputType();
                                q2(new Object[]{d8, d8, Double.valueOf(Math.max(0, textSelectionStart2)), Double.valueOf(Math.max(0, textSelectionEnd)), A2(source), Double.valueOf(inputType3), source.getPackageName()}, false);
                                return;
                            }
                        }
                        z8 = false;
                        if (z8) {
                        }
                        isEditable = source.isEditable();
                        if (isEditable) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (eventType != 16) {
                        if (eventType != 8192) {
                            return;
                        }
                        charSequence = accessibilityEvent.getFromIndex() != -1 && accessibilityEvent.getToIndex() != -1 ? (CharSequence) C2440r.l(accessibilityEvent.getText()) : null;
                        if (!source.equals(this.f16742T1) || (TextUtils.equals(this.f16742T1.getText(), charSequence) && !B2(accessibilityEvent.getFromIndex(), accessibilityEvent.getToIndex()))) {
                            AccessibilityNodeInfo accessibilityNodeInfo3 = this.f16742T1;
                            if (accessibilityNodeInfo3 != null) {
                                accessibilityNodeInfo3.recycle();
                            }
                            this.f16742T1 = AccessibilityNodeInfo.obtain(source);
                            String d9 = O.b.d("", charSequence);
                            inputType5 = source.getInputType();
                            q2(new Object[]{d9, d9, Double.valueOf(Math.max(0, accessibilityEvent.getFromIndex())), Double.valueOf(Math.max(0, accessibilityEvent.getToIndex())), A2(source), Double.valueOf(inputType5), source.getPackageName()}, false);
                            return;
                        }
                        return;
                    }
                    textSelectionStart4 = source.getTextSelectionStart();
                    if (textSelectionStart4 != -1) {
                        textSelectionEnd5 = source.getTextSelectionEnd();
                        if (textSelectionEnd5 != -1) {
                            z9 = true;
                            charSequence = z9 ? (CharSequence) C2440r.l(accessibilityEvent.getText()) : null;
                            accessibilityNodeInfo = this.f16742T1;
                            if (accessibilityNodeInfo != null) {
                                accessibilityNodeInfo.recycle();
                            }
                            this.f16742T1 = AccessibilityNodeInfo.obtain(source);
                            textSelectionStart5 = source.getTextSelectionStart();
                            textSelectionEnd4 = source.getTextSelectionEnd();
                            inputType4 = source.getInputType();
                            q2(new Object[]{O.b.d("", charSequence), O.b.d("", accessibilityEvent.getBeforeText()), Double.valueOf(Math.max(0, textSelectionStart5)), Double.valueOf(Math.max(0, textSelectionEnd4)), A2(source), Double.valueOf(inputType4), source.getPackageName()}, false);
                            return;
                        }
                    }
                    z9 = false;
                    if (z9) {
                    }
                    accessibilityNodeInfo = this.f16742T1;
                    if (accessibilityNodeInfo != null) {
                    }
                    this.f16742T1 = AccessibilityNodeInfo.obtain(source);
                    textSelectionStart5 = source.getTextSelectionStart();
                    textSelectionEnd4 = source.getTextSelectionEnd();
                    inputType4 = source.getInputType();
                    q2(new Object[]{O.b.d("", charSequence), O.b.d("", accessibilityEvent.getBeforeText()), Double.valueOf(Math.max(0, textSelectionStart5)), Double.valueOf(Math.max(0, textSelectionEnd4)), A2(source), Double.valueOf(inputType4), source.getPackageName()}, false);
                    return;
                }
            }
            z7 = false;
            if (z7) {
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15540a};
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.inputType);
        dVar.g(this.packageName);
        dVar.g(this.varNewText);
        dVar.g(this.varOldText);
        dVar.g(this.varSelectionStart);
        dVar.g(this.varSelectionEnd);
        dVar.g(this.varTextMaxLength);
        dVar.g(this.varInputType);
        dVar.g(this.varPackageName);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.inputType);
        visitor.b(this.packageName);
        visitor.b(this.varNewText);
        visitor.b(this.varOldText);
        visitor.b(this.varSelectionStart);
        visitor.b(this.varSelectionEnd);
        visitor.b(this.varTextMaxLength);
        visitor.b(this.varInputType);
        visitor.b(this.varPackageName);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.inputType = (InterfaceC1700x0) cVar.readObject();
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        this.varNewText = (J3.l) cVar.readObject();
        this.varOldText = (J3.l) cVar.readObject();
        this.varSelectionStart = (J3.l) cVar.readObject();
        this.varSelectionEnd = (J3.l) cVar.readObject();
        this.varTextMaxLength = (J3.l) cVar.readObject();
        this.varInputType = (J3.l) cVar.readObject();
        this.varPackageName = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_inspect_text_edit_title);
        IncapableAndroidVersionException.a(19);
        int m8 = J3.h.m(c1708z0, this.inputType, 1);
        String x7 = J3.h.x(c1708z0, this.packageName, null);
        a aVar = (a) c1708z0.c(a.class);
        if (aVar == null) {
            a aVar2 = new a();
            aVar2.f16740R1 = m8;
            aVar2.f16741S1 = x7;
            c1708z0.w(aVar2);
            return false;
        }
        F5.n.h(aVar);
        aVar.f16740R1 = m8;
        aVar.f16741S1 = x7;
        aVar.z2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        Double d8 = (Double) objArr[2];
        Double d9 = (Double) objArr[3];
        Double d10 = (Double) objArr[4];
        Double d11 = (Double) objArr[5];
        String str3 = (String) objArr[6];
        J3.l lVar = this.varNewText;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varOldText;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str2);
        }
        J3.l lVar3 = this.varSelectionStart;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, d8);
        }
        J3.l lVar4 = this.varSelectionEnd;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, d9);
        }
        J3.l lVar5 = this.varTextMaxLength;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, d10);
        }
        J3.l lVar6 = this.varInputType;
        if (lVar6 != null) {
            c1708z0.z(lVar6.f4659Y, d11);
        }
        J3.l lVar7 = this.varPackageName;
        if (lVar7 != null) {
            c1708z0.z(lVar7.f4659Y, str3);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
