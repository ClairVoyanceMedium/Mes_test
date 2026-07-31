package L3;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class J extends K<Double> {

    /* renamed from: X, reason: collision with root package name */
    public double f4934X;

    public J() {
    }

    public J(double d8) {
        this.f4934X = d8;
    }

    @Override // R3.e
    public final void Y0(R3.d dVar) {
        dVar.writeDouble(this.f4934X);
    }

    @Override // R3.e
    public final void o0(R3.c cVar) {
        this.f4934X = cVar.readDouble();
    }

    public final String toString() {
        return J3.h.d0(this.f4934X);
    }

    @Override // J3.k
    public final Object value() {
        return Double.valueOf(this.f4934X);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public String x(int i8) {
        return J3.h.d0(this.f4934X);
    }

    public J(int i8) {
        Pattern pattern = J3.h.f4650a;
        this.f4934X = i8;
    }

    public J(boolean z7) {
        this.f4934X = J3.h.Y(z7);
    }
}
