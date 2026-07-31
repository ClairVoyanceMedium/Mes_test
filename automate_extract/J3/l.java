package J3;

import android.text.Editable;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.Visitor;

@F3.h(C2541R.string.var_mutable)
/* loaded from: classes.dex */
public final class l implements m, InterfaceC1622q2 {

    /* renamed from: Z, reason: collision with root package name */
    public static final l[] f4657Z = new l[0];

    /* renamed from: X, reason: collision with root package name */
    public String f4658X;

    /* renamed from: Y, reason: collision with root package name */
    public int f4659Y;

    public l() {
    }

    public l(Editable editable) {
        this.f4658X = editable.toString();
    }

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        dVar.writeUTF(this.f4658X);
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f4659Y = c1625r2.d(true);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        return c1708z0.j(this.f4659Y);
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        this.f4658X = cVar.readUTF();
    }

    public final String toString() {
        return this.f4658X;
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        return this.f4658X;
    }
}
