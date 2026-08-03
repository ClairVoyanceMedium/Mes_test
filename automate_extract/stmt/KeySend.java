package com.llamalab.automate.stmt;

import android.accessibilityservice.InputMethod;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.N2;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("key_send.html")
@F3.i(C2541R.string.stmt_key_send_title)
@F3.h(C2541R.string.stmt_key_send_summary)
@F3.e(C2541R.layout.stmt_key_send_edit)
/* loaded from: classes.dex */
public final class KeySend extends KeySendBase {
    public InterfaceC1700x0 action;
    public InterfaceC1700x0 keyCode;
    public InterfaceC1700x0 modifiers;

    public static final class a extends P {

        /* renamed from: Q1, reason: collision with root package name */
        public final int f16839Q1;

        /* renamed from: R1, reason: collision with root package name */
        public final int f16840R1;

        /* renamed from: S1, reason: collision with root package name */
        public final int f16841S1;

        public a(int i8, int i9, int i10) {
            this.f16839Q1 = i8;
            this.f16840R1 = i9;
            this.f16841S1 = i10;
        }

        @Override // com.llamalab.automate.stmt.P
        public final void v2(InputMethod.AccessibilityInputConnection accessibilityInputConnection) {
            int i8 = this.f16839Q1;
            int i9 = this.f16840R1;
            int i10 = this.f16841S1;
            long uptimeMillis = SystemClock.uptimeMillis();
            if (-1 != i8) {
                accessibilityInputConnection.sendKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, i8, i9, 0, i10));
            } else {
                accessibilityInputConnection.sendKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, 0, i9, 0, i10));
                accessibilityInputConnection.sendKeyEvent(new KeyEvent(uptimeMillis, SystemClock.uptimeMillis(), 1, i9, 0, i10));
            }
        }
    }

    public static final class b extends Q {

        /* renamed from: L1, reason: collision with root package name */
        public final int f16842L1;

        /* renamed from: M1, reason: collision with root package name */
        public final int f16843M1;

        /* renamed from: N1, reason: collision with root package name */
        public final int f16844N1;

        public b(int i8, int i9, int i10) {
            this.f16842L1 = i8;
            this.f16843M1 = i9;
            this.f16844N1 = i10;
        }

        @Override // com.llamalab.automate.stmt.Q
        public final boolean v2(InputConnection inputConnection) {
            int i8 = this.f16842L1;
            int i9 = this.f16843M1;
            int i10 = this.f16844N1;
            long uptimeMillis = SystemClock.uptimeMillis();
            if (-1 != i8) {
                return inputConnection.sendKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, i8, i9, 0, i10));
            }
            if (!inputConnection.sendKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, 0, i9, 0, i10))) {
                return false;
            }
            inputConnection.sendKeyEvent(new KeyEvent(uptimeMillis, SystemClock.uptimeMillis(), 1, i9, 0, i10));
            return true;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_key_send);
        l8.v(this.keyCode, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.KeySendBase, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.action);
        dVar.g(this.keyCode);
        dVar.g(this.modifiers);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        if (!(visitor instanceof C1625r2) || 12 <= ((C1625r2) visitor).f16204b) {
            visitor.b(this.action);
            visitor.b(this.keyCode);
            visitor.b(this.modifiers);
        }
    }

    @Override // com.llamalab.automate.stmt.KeySendBase, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.action = (InterfaceC1700x0) cVar.readObject();
        this.keyCode = (InterfaceC1700x0) cVar.readObject();
        this.modifiers = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        N2 bVar;
        c1708z0.q(C2541R.string.stmt_key_send_title);
        int m8 = J3.h.m(c1708z0, this.action, -1);
        if (m8 != -1 && m8 != 0 && m8 != 1) {
            throw new IllegalArgumentException("action");
        }
        Integer o6 = J3.h.o(c1708z0, this.keyCode, null);
        if (o6 == null) {
            throw new RequiredArgumentNullException("keyCode");
        }
        if (o6.intValue() <= 0 || o6.intValue() > KeyEvent.getMaxKeyCode()) {
            throw new IllegalArgumentException("keyCode");
        }
        int m9 = J3.h.m(c1708z0, this.modifiers, 0);
        if ((((-1) ^ KeyEvent.getModifierMetaStateMask()) & m9) != 0) {
            throw new IllegalArgumentException("modifiers");
        }
        int i8 = this.method;
        if (i8 == 0) {
            bVar = new b(m8, o6.intValue(), m9);
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("method");
            }
            if (33 > Build.VERSION.SDK_INT) {
                throw new IncapableAndroidVersionException(33, "accessibility method");
            }
            bVar = new a(m8, o6.intValue(), m9);
        }
        c1708z0.w(bVar);
        return false;
    }
}
