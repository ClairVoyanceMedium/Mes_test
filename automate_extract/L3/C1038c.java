package L3;

/* renamed from: L3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1038c extends C1037b {
    public C1038c() {
    }

    public C1038c(J3.b bVar) {
        super(bVar);
    }

    @Override // L3.C1037b, com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb;
        J3.b bVar;
        if (this.f4949X.f4638X < 0) {
            sb = new StringBuilder("-0b");
            bVar = this.f4949X.T();
        } else {
            sb = new StringBuilder("0b");
            bVar = this.f4949X;
        }
        sb.append(bVar.a0(2));
        sb.append('n');
        return sb.toString();
    }
}
