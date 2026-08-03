package com.llamalab.automate.stmt;

import android.accessibilityservice.InputMethod;
import android.content.Context;
import android.os.Build;
import android.view.inputmethod.InputConnection;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.N2;
import com.llamalab.automate.Visitor;

@F3.f("key_send_characters.html")
@F3.i(C2541R.string.stmt_key_send_characters_title)
@F3.h(C2541R.string.stmt_key_send_characters_summary)
@F3.e(C2541R.layout.stmt_key_send_characters_edit)
/* loaded from: classes.dex */
public final class KeySendCharacters extends KeySendBase {
    public InterfaceC1700x0 characters;

    public static final class a extends P {

        /* renamed from: Q1, reason: collision with root package name */
        public final String f16845Q1;

        public a(String str) {
            this.f16845Q1 = str;
        }

        @Override // com.llamalab.automate.stmt.P
        public final void v2(InputMethod.AccessibilityInputConnection accessibilityInputConnection) {
            accessibilityInputConnection.commitText(this.f16845Q1, 1, null);
        }
    }

    public static final class b extends Q {

        /* renamed from: L1, reason: collision with root package name */
        public final String f16846L1;

        public b(String str) {
            this.f16846L1 = str;
        }

        @Override // com.llamalab.automate.stmt.Q
        public final boolean v2(InputConnection inputConnection) {
            return inputConnection.commitText(this.f16846L1, 1);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_key_send_characters);
        l8.v(this.characters, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.KeySendBase, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.characters);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        if (!(visitor instanceof C1625r2) || 12 <= ((C1625r2) visitor).f16204b) {
            visitor.b(this.characters);
        }
    }

    @Override // com.llamalab.automate.stmt.KeySendBase, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.characters = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        N2 bVar;
        c1708z0.q(C2541R.string.stmt_key_send_characters_title);
        String x7 = J3.h.x(c1708z0, this.characters, "");
        int i8 = this.method;
        if (i8 == 0) {
            bVar = new b(x7);
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("method");
            }
            if (33 > Build.VERSION.SDK_INT) {
                throw new IncapableAndroidVersionException(33, "accessibility method");
            }
            bVar = new a(x7);
        }
        c1708z0.w(bVar);
        return false;
    }
}
