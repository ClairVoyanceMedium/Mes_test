package L3;

import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class U implements InterfaceC1700x0 {

    /* renamed from: X, reason: collision with root package name */
    public InterfaceC1700x0 f4940X;

    /* renamed from: Y, reason: collision with root package name */
    public InterfaceC1700x0 f4941Y;

    /* renamed from: Z, reason: collision with root package name */
    public InterfaceC1700x0 f4942Z;

    public U() {
    }

    public U(InterfaceC1700x0 interfaceC1700x0, J3.k kVar, InterfaceC1700x0 interfaceC1700x02) {
        this.f4940X = interfaceC1700x0;
        this.f4941Y = kVar;
        this.f4942Z = interfaceC1700x02;
    }

    @Override // R3.e
    public void Y0(R3.d dVar) {
        dVar.g(this.f4940X);
        dVar.g(this.f4941Y);
        dVar.g(this.f4942Z);
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.f4940X);
        visitor.b(this.f4941Y);
        visitor.b(this.f4942Z);
    }

    @Override // R3.e
    public void o0(R3.c cVar) {
        this.f4940X = (InterfaceC1700x0) cVar.readObject();
        this.f4941Y = (InterfaceC1700x0) cVar.readObject();
        this.f4942Z = (InterfaceC1700x0) cVar.readObject();
    }
}
