package com.llamalab.automate.stmt;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.KeyEvent;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1619q;
import com.llamalab.automate.C1695w;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import x3.C2434l;
import x3.C2440r;

@F3.f("key_pressed.html")
@F3.a(C2541R.integer.ic_action_key_press)
@F3.i(C2541R.string.stmt_key_pressed_title)
@F3.h(C2541R.string.stmt_key_pressed_summary)
@F3.b(C2541R.layout.block_key_pressed)
@F3.e(C2541R.layout.stmt_key_pressed_edit)
/* loaded from: classes.dex */
public final class KeyPressed extends Decision implements AsyncStatement {
    public InterfaceC1700x0 consume;
    public InterfaceC1700x0 flags;
    public InterfaceC1700x0 keyCodes;
    public InterfaceC1700x0 modifiers;
    public J3.l varDeadChar;
    public J3.l varKeyCode;
    public J3.l varMetaState;
    public J3.l varUnicodeChar;

    public static class a extends C1619q.a {

        /* renamed from: R1, reason: collision with root package name */
        public final boolean f16831R1;

        /* renamed from: S1, reason: collision with root package name */
        public int[] f16832S1;

        /* renamed from: T1, reason: collision with root package name */
        public int f16833T1;
        public int U1;

        /* renamed from: V1, reason: collision with root package name */
        public boolean f16834V1;

        public a(boolean z7) {
            super(0, 32);
            this.f16831R1 = z7;
        }

        public final synchronized void A2(int[] iArr, int i8, int i9, boolean z7) {
            this.f16832S1 = iArr;
            this.f16833T1 = i8;
            this.U1 = i9;
            this.f16834V1 = z7;
        }

        @Override // com.llamalab.automate.C1619q.a, com.llamalab.automate.C1619q, com.llamalab.automate.InterfaceC1611o
        public final boolean f0(AutomateAccessibilityService automateAccessibilityService, KeyEvent keyEvent) {
            int[] iArr;
            int i8;
            int i9;
            boolean z7;
            synchronized (this) {
                iArr = this.f16832S1;
                i8 = this.f16833T1;
                i9 = this.U1;
                z7 = this.f16834V1;
            }
            try {
                int action = keyEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        return false;
                    }
                    if (i9 > 0) {
                        i9 &= -129;
                    }
                } else if (keyEvent.getRepeatCount() > 0 && (i9 & 128) == 0) {
                    return false;
                }
                if (i9 == 0) {
                    if (keyEvent.getFlags() != 0) {
                        return false;
                    }
                } else if (i9 > 0 && (keyEvent.getFlags() & i9) != i9) {
                    return false;
                }
                if (i8 >= 0 && !keyEvent.hasModifiers(i8)) {
                    return false;
                }
                if (iArr.length != 0 && Arrays.binarySearch(iArr, keyEvent.getKeyCode()) < 0) {
                    return false;
                }
                super.f0(automateAccessibilityService, keyEvent);
                return z7;
            } catch (Throwable th) {
                r2(th);
                return false;
            }
        }

        @Override // com.llamalab.automate.C1619q.a
        public final void y2(KeyEvent keyEvent) {
            Double d8;
            int unicodeChar;
            Double d9 = null;
            if (!this.f16831R1 || (unicodeChar = keyEvent.getUnicodeChar()) == 0) {
                d8 = null;
            } else if ((Integer.MIN_VALUE & unicodeChar) != 0) {
                d8 = Double.valueOf(unicodeChar & Integer.MAX_VALUE);
            } else {
                d9 = Double.valueOf(unicodeChar);
                d8 = null;
            }
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(keyEvent.getAction() == 0);
            objArr[1] = Double.valueOf(keyEvent.getKeyCode());
            objArr[2] = Double.valueOf(keyEvent.getMetaState());
            objArr[3] = d9;
            objArr[4] = d8;
            q2(objArr, false);
        }
    }

    public static final class b extends a implements InvocationHandler {
        public PowerManager W1;

        /* renamed from: X1, reason: collision with root package name */
        public MediaSessionManager f16835X1;

        /* renamed from: Y1, reason: collision with root package name */
        public Method f16836Y1;

        /* renamed from: Z1, reason: collision with root package name */
        public Object f16837Z1;

        /* renamed from: a2, reason: collision with root package name */
        public boolean f16838a2;

        public b(boolean z7) {
            super(z7);
        }

        public final void B2(boolean z7) {
            if (this.f16838a2 != z7) {
                try {
                    if (z7) {
                        if (this.f16837Z1 == null) {
                            this.W1 = (PowerManager) this.f15400Y.getSystemService("power");
                            this.f16835X1 = C1695w.m(this.f15400Y.getSystemService("media_session"));
                            Class<?> cls = Class.forName("android.media.session.MediaSessionManager$OnVolumeKeyLongPressListener");
                            this.f16836Y1 = this.f16835X1.getClass().getMethod("setOnVolumeKeyLongPressListener", cls, Handler.class);
                            this.f16837Z1 = Proxy.newProxyInstance(b.class.getClassLoader(), new Class[]{cls}, this);
                        }
                        this.f16836Y1.invoke(this.f16835X1, this.f16837Z1, this.f15400Y.f14581L1);
                    } else {
                        this.f16836Y1.invoke(this.f16835X1, null, null);
                    }
                    this.f16838a2 = z7;
                } catch (Throwable th) {
                    Log.w("KeyPressed", "setOnVolumeKeyLongPressListener failed", th);
                }
            }
        }

        @Override // com.llamalab.automate.C1619q.a, com.llamalab.automate.C1619q, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            B2(C2());
        }

        public final boolean C2() {
            return this.f16834V1 && (this.U1 & 128) != 0 && (Arrays.binarySearch(this.f16832S1, 24) >= 0 || Arrays.binarySearch(this.f16832S1, 25) >= 0) && com.llamalab.automate.access.c.j("android.permission.SET_VOLUME_KEY_LONG_PRESS_LISTENER").A(this.f15400Y);
        }

        @Override // com.llamalab.automate.C1619q, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            super.F(automateService);
            B2(false);
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            boolean isInteractive;
            String name = method.getName();
            name.getClass();
            switch (name) {
                case "toString":
                    return obj.toString();
                case "equals":
                    return Boolean.valueOf(obj == objArr[0]);
                case "hashCode":
                    return Integer.valueOf(System.identityHashCode(obj));
                case "onVolumeKeyLongPress":
                    KeyEvent keyEvent = (KeyEvent) objArr[0];
                    if ((keyEvent.getFlags() & 128) == 0) {
                        isInteractive = this.W1.isInteractive();
                        if (isInteractive) {
                            return null;
                        }
                        if (keyEvent.getAction() == 0) {
                            keyEvent = KeyEvent.changeFlags(keyEvent, keyEvent.getFlags() | 128);
                        }
                    }
                    f0(w2(), keyEvent);
                    return null;
                default:
                    throw new NoSuchMethodException(method.toString());
            }
        }

        @Override // com.llamalab.automate.C1619q.a
        public final void z2() {
            B2(C2());
            super.z2();
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 18 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15540a} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_key_pressed);
        l8.v(this.keyCodes, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.keyCodes);
        dVar.g(this.modifiers);
        if (80 <= dVar.f6413Z) {
            dVar.g(this.flags);
        }
        dVar.g(this.consume);
        dVar.g(this.varKeyCode);
        dVar.g(this.varMetaState);
        if (106 <= dVar.f6413Z) {
            dVar.g(this.varUnicodeChar);
            dVar.g(this.varDeadChar);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.keyCodes);
        visitor.b(this.modifiers);
        visitor.b(this.flags);
        visitor.b(this.consume);
        visitor.b(this.varKeyCode);
        visitor.b(this.varMetaState);
        visitor.b(this.varUnicodeChar);
        visitor.b(this.varDeadChar);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.keyCodes = (InterfaceC1700x0) cVar.readObject();
        this.modifiers = (InterfaceC1700x0) cVar.readObject();
        if (80 <= cVar.f6409x0) {
            this.flags = (InterfaceC1700x0) cVar.readObject();
        }
        this.consume = (InterfaceC1700x0) cVar.readObject();
        this.varKeyCode = (J3.l) cVar.readObject();
        this.varMetaState = (J3.l) cVar.readObject();
        if (106 <= cVar.f6409x0) {
            this.varUnicodeChar = (J3.l) cVar.readObject();
            this.varDeadChar = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_key_pressed_title);
        IncapableAndroidVersionException.a(18);
        int[] F7 = C2440r.F(J3.h.n(c1708z0, this.keyCodes, C2434l.f23393d));
        int m8 = J3.h.m(c1708z0, this.modifiers, -1);
        if (m8 >= 0 && ((KeyEvent.getModifierMetaStateMask() ^ (-1)) & m8) != 0) {
            throw new IllegalArgumentException("modifiers");
        }
        int m9 = J3.h.m(c1708z0, this.flags, -1);
        if (m9 >= 0 && (m9 & (-1243)) != 0) {
            throw new IllegalArgumentException("flags");
        }
        boolean f8 = J3.h.f(c1708z0, this.consume, false);
        a aVar = (a) c1708z0.d(a.class, this);
        if (aVar != null) {
            synchronized (aVar) {
                aVar.f16832S1 = F7;
                aVar.f16833T1 = m8;
                aVar.U1 = m9;
                aVar.f16834V1 = f8;
            }
            aVar.z2();
        } else {
            boolean z7 = (this.varUnicodeChar == null && this.varDeadChar == null) ? false : true;
            a bVar = 26 <= Build.VERSION.SDK_INT ? new b(z7) : new a(z7);
            bVar.A2(F7, m8, m9, f8);
            c1708z0.w(bVar);
        }
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varKeyCode;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[1]);
        }
        J3.l lVar2 = this.varMetaState;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[2]);
        }
        J3.l lVar3 = this.varUnicodeChar;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, objArr[3]);
        }
        J3.l lVar4 = this.varDeadChar;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, objArr[4]);
        }
        o(c1708z0, ((Boolean) objArr[0]).booleanValue());
        return true;
    }
}
