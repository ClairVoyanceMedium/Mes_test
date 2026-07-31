package L3;

import android.text.TextUtils;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public final class W implements J3.k<String> {

    /* renamed from: X, reason: collision with root package name */
    public String f4946X;

    public W() {
    }

    public W(CharSequence charSequence) {
        this.f4946X = charSequence.toString();
    }

    public static W b(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        return new W(charSequence);
    }

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        dVar.writeUTF(this.f4946X);
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        return this.f4946X;
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        this.f4946X = cVar.readUTF();
    }

    public final String toString() {
        return J3.h.a(5, this.f4946X);
    }

    @Override // J3.k
    public final String value() {
        return this.f4946X;
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        return J3.h.a(i8, this.f4946X);
    }

    public W(String str) {
        str.getClass();
        this.f4946X = str;
    }
}
