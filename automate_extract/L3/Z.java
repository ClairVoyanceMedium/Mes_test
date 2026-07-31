package L3;

import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class Z implements InterfaceC1700x0 {

    /* renamed from: X, reason: collision with root package name */
    public InterfaceC1700x0 f4947X;

    public Z() {
    }

    public Z(InterfaceC1700x0 interfaceC1700x0) {
        this.f4947X = interfaceC1700x0;
    }

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        dVar.g(this.f4947X);
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.f4947X);
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        this.f4947X = (InterfaceC1700x0) cVar.readObject();
    }
}
