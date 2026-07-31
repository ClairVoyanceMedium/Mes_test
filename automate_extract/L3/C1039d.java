package L3;

import java.util.regex.Pattern;

/* renamed from: L3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1039d extends J {
    public C1039d() {
    }

    public C1039d(int i8) {
        super(i8);
    }

    @Override // L3.J, com.llamalab.automate.InterfaceC1700x0
    public final String x(int i8) {
        StringBuilder sb = new StringBuilder("0b");
        double d8 = this.f4934X;
        Pattern pattern = J3.h.f4650a;
        sb.append(Integer.toBinaryString((int) d8));
        return sb.toString();
    }
}
