package L3;

import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

/* renamed from: L3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1040e implements InterfaceC1700x0 {

    /* renamed from: X, reason: collision with root package name */
    public InterfaceC1700x0 f4950X;

    /* renamed from: Y, reason: collision with root package name */
    public InterfaceC1700x0 f4951Y;

    public AbstractC1040e() {
    }

    public AbstractC1040e(InterfaceC1700x0 interfaceC1700x0, InterfaceC1700x0 interfaceC1700x02) {
        this.f4950X = interfaceC1700x0;
        this.f4951Y = interfaceC1700x02;
    }

    @Override // R3.e
    public void Y0(R3.d dVar) {
        dVar.g(this.f4950X);
        dVar.g(this.f4951Y);
    }

    @Override // com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.f4950X);
        visitor.b(this.f4951Y);
    }

    public final void b(R3.c cVar, int i8) {
        this.f4950X = (InterfaceC1700x0) cVar.readObject();
        if (i8 <= cVar.f6409x0) {
            this.f4951Y = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // R3.e
    public void o0(R3.c cVar) {
        this.f4950X = (InterfaceC1700x0) cVar.readObject();
        this.f4951Y = (InterfaceC1700x0) cVar.readObject();
    }
}
