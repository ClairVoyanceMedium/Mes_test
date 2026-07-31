package L3;

/* renamed from: L3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1037b extends K<J3.b> {

    /* renamed from: X, reason: collision with root package name */
    public J3.b f4949X;

    public C1037b() {
    }

    public C1037b(J3.b bVar) {
        bVar.getClass();
        this.f4949X = bVar;
    }

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        J3.b bVar = this.f4949X;
        int i8 = bVar.f4638X;
        if (i8 == 0) {
            dVar.c(0);
            return;
        }
        int[] iArr = bVar.f4639Y;
        dVar.c(i8 * iArr.length);
        for (int i9 : iArr) {
            dVar.writeInt(i9);
        }
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        this.f4949X = J3.b.V(cVar);
    }

    public final String toString() {
        return this.f4949X.toString();
    }

    @Override // J3.k
    public final Object value() {
        return this.f4949X;
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public String x(int i8) {
        return this.f4949X.toString() + 'n';
    }
}
