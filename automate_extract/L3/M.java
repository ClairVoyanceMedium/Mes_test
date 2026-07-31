package L3;

import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* loaded from: classes.dex */
public abstract class M implements InterfaceC1700x0 {

    /* renamed from: X, reason: collision with root package name */
    public InterfaceC1700x0 f4936X;

    /* renamed from: Y, reason: collision with root package name */
    public InterfaceC1700x0 f4937Y;

    /* renamed from: Z, reason: collision with root package name */
    public InterfaceC1700x0 f4938Z;

    /* renamed from: x0, reason: collision with root package name */
    public InterfaceC1700x0 f4939x0;

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        dVar.g(this.f4936X);
        dVar.g(this.f4937Y);
        dVar.g(this.f4938Z);
        dVar.g(this.f4939x0);
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.f4936X);
        visitor.b(this.f4937Y);
        visitor.b(this.f4938Z);
        visitor.b(this.f4939x0);
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        this.f4936X = (InterfaceC1700x0) cVar.readObject();
        this.f4937Y = (InterfaceC1700x0) cVar.readObject();
        this.f4938Z = (InterfaceC1700x0) cVar.readObject();
        this.f4939x0 = (InterfaceC1700x0) cVar.readObject();
    }
}
