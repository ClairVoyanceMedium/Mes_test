package L3;

/* loaded from: classes.dex */
public final class r extends C1037b {
    public r() {
    }

    public r(J3.b bVar) {
        super(bVar);
    }

    @Override // L3.C1037b, com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb;
        J3.b bVar;
        if (this.f4949X.f4638X < 0) {
            sb = new StringBuilder("-0x");
            bVar = this.f4949X.T();
        } else {
            sb = new StringBuilder("0x");
            bVar = this.f4949X;
        }
        sb.append(bVar.a0(16));
        sb.append('n');
        return sb.toString();
    }
}
