package com.llamalab.automate.stmt;

import D1.C0604c;
import android.content.Context;
import android.os.Vibrator;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Arrays;

@F3.f("vibrate_start.html")
@F3.a(C2541R.integer.ic_audio_ring_notif_vibrate_am)
@F3.i(C2541R.string.stmt_vibrate_start_title)
@F3.h(C2541R.string.stmt_vibrate_start_summary)
@F3.e(C2541R.layout.stmt_vibrate_start_edit)
/* loaded from: classes.dex */
public final class VibrateStart extends Action {

    /* renamed from: L1, reason: collision with root package name */
    public static final long[][] f17239L1 = {new long[]{0, 20, 5, 20, 5, 20, 5, 20, 5, 20, 5}, new long[]{0, 80, 10, 80, 10, 80, 10, 80, 10, 80, 10}, new long[]{0, 200, 100, 500}, new long[]{0, 40, 80, 100}, new long[]{0, 300, 700, 300, 700, 300, 700, 1000}, new long[]{0, 50, 100, 50, 100, 50, 1000}, new long[]{0, 10, 20, 240, 40, 240, 40, 10, 400, 10, 20, 240, 40, 240, 40, 10, 400, 10, 20, 240, 40, 240, 40, 10, 400}, new long[]{0, 100, 30, 100, 30, 100, 200, 200, 30, 200, 30, 200, 200, 100, 30, 100, 30, 100}, new long[]{0, 100, 200, 100, 100, 100, 100, 200, 200, 100, 600, 200, 225, 200}, new long[]{0, 200, 100, 200, 275, 425, 100, 200, 100, 200, 275, 425, 100, 75, 25, 75, 125, 75, 25, 75, 125, 100, 100}, new long[]{0, 125, 75, 125, 275, 200, 275, 125, 75, 125, 275, 200, 600, 200, 600}, new long[]{0, 500, 110, 500, 110, 450, 110, 200, 110, 170, 40, 450, 110, 200, 110, 170, 40, 500}, new long[]{0, 50, 100, 50, 100, 50, 100, 400, 100, 300, 100, 350, 50, 200, 100, 100, 50, 600}, new long[]{0, 75, 75, 75, 75, 75, 75, 75, 75, 150, 150, 150, 450, 75, 75, 75, 75, 75, 525}, new long[]{0, 100, 200, 100, 200, 100, 200, 100, 200, 100, 100, 100, 100, 100, 200, 100, 200, 100, 200, 100, 200, 100, 100, 100, 100, 100, 200, 100, 200, 100, 200, 100, 200, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 50, 50, 100, 800}, new long[]{0, 150, 150, 150, 150, 75, 75, 150, 150, 150, 150, 450}, new long[]{0, 250, 200, 150, 150, 100, 50, 450, 450, 150, 150, 100, 50, 900, 2250}, new long[]{0, 75, 38, 75, 488, 75, 38, 75, 200, 75, 38, 75, 400}, new long[]{0, 75, 25, 75, 25, 75, 25, 75, 525, 75, 25, 75, 25, 75, 25, 75, 25, 75, 25, 75, 25, 75, 225, 75, 25, 75, 25, 75, 25, 75, 225, 75, 25, 75, 25, 75, 25, 75, 525, 75, 25, 75, 25, 75, 25, 75, 25, 75, 25, 75, 25, 75, 225, 75, 25, 75, 25, 75, 25, 75, 225}, new long[]{0, 100, 50, 100, 50, 100, 50, 100, 350, 100, 50, 100, 50, 100, 50, 100, 350, 100, 50, 100, 50, 100, 500, 100, 50, 100, 50, 100, 50, 100, 1400}, new long[]{0, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 80, 320, 160, 320, 160, 320}, new long[]{0, 50, 50, 50, 50, 50, 50, 50, 550, 300, 300, 100, 200, 50, 50, 50, 50, 50, 50, 50, 250}, new long[]{0, 75, 75, 75, 75, 75, 225, 75, 75, 75, 75, 75, 75, 75, 225, 75, 75, 75, 75, 75, 75, 75, 225, 75, 75, 75, 75, 75, 75, 75, 225, 75, 75, 75, 75, 75, 75, 75, 225, 75, 75, 75, 75, 75, 225, 75, 75, 75, 225, 75, 75, 75, 225, 75, 75, 75, 225, 75, 75, 75, 75, 75, 225, 75, 75, 75, 75, 75, 75, 75, 225, 75, 75, 75, 75, 75, 75, 75, 225, 75, 75, 75, 75, 75, 75, 75, 225, 75, 75, 75, 75, 75, 75, 75, 225, 75, 75, 75, 75, 75, 75}, new long[]{0, 660, 60, 180, 60, 60, 180, 60, 180, 60, 180, 420, 60, 180, 60, 60, 180, 60, 180, 60, 180, 420, 60, 180, 60, 60, 180, 60, 180, 60, 180, 420, 60, 180, 60, 60, 180, 60, 180, 420, 60, 420, 60}, new long[]{0, 75, 225, 75, 75, 75, 75, 75, 225, 75, 225, 75, 225, 75, 75, 75, 225, 75, 225, 75, 75, 75, 75, 75, 225, 75, 225, 75, 225, 75, 75, 75, 225, 75, 225, 75, 75, 75, 75, 75, 225, 75, 225, 150, 150, 75, 75, 75, 225, 75, 375, 75, 75, 75, 75, 75, 225, 75, 225, 75, 225, 75, 75, 75, 225, 75, 225, 75, 75, 75, 75, 75, 225, 75, 225, 75, 225, 75, 75, 75, 225, 75, 225, 75, 75, 75, 75, 150, 150}};
    public InterfaceC1700x0 pattern;
    public InterfaceC1700x0 repeat;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.VIBRATE")};
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.pattern);
        dVar.g(this.repeat);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.pattern);
        visitor.b(this.repeat);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.pattern = (InterfaceC1700x0) cVar.readObject();
        this.repeat = (InterfaceC1700x0) cVar.readObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0180  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        long[] jArr;
        long j8;
        String str;
        c1708z0.q(C2541R.string.stmt_vibrate_start_title);
        Vibrator vibrator = (Vibrator) c1708z0.getSystemService("vibrator");
        if (vibrator == null || !vibrator.hasVibrator()) {
            throw new UnsupportedOperationException("No vibrator");
        }
        Object u8 = J3.h.u(c1708z0, this.pattern, null);
        boolean f8 = J3.h.f(c1708z0, this.repeat, false);
        long[][] jArr2 = f17239L1;
        int i8 = -1;
        if (u8 == null) {
            jArr = jArr2[2];
        } else if (u8 instanceof Double) {
            jArr = jArr2[y4.j.d(((Double) u8).intValue(), 0, 24)];
        } else {
            if (!(u8 instanceof String)) {
                if (!(u8 instanceof J3.a)) {
                    throw new IllegalArgumentException("pattern");
                }
                J3.a aVar = (J3.a) u8;
                int i9 = aVar.f4627Y;
                long[] jArr3 = new long[i9];
                while (true) {
                    i9--;
                    if (i9 < 0) {
                        break;
                    }
                    jArr3[i9] = J3.h.T(aVar.get(i9));
                }
                jArr = jArr3;
                if (jArr.length > 1) {
                    vibrator.vibrate(jArr, f8 ? 1 : -1);
                    if (f8 && c1708z0.c(s1.class) == null) {
                        c1708z0.w(new s1(vibrator));
                    }
                }
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
            C0604c c0604c = new C0604c(1);
            long j9 = 0;
            c0604c.a(0L);
            String str2 = (String) u8;
            int length = str2.length();
            int i10 = 0;
            while (true) {
                length += i8;
                if (length >= 0) {
                    switch (str2.charAt(i10)) {
                        case ' ':
                            j8 = j9;
                            c0604c.a(j8);
                            c0604c.a(700L);
                            i10++;
                            j9 = j8;
                            i8 = -1;
                        case '!':
                            str = "-.-.--";
                            break;
                        case '\"':
                            str = ".-..-.";
                            break;
                        case '#':
                        case '$':
                        case '%':
                        case '&':
                        case '*':
                        case '<':
                        case '=':
                        case '>':
                        case '@':
                        case '[':
                        case '\\':
                        case ']':
                        case '^':
                        case '_':
                        case '`':
                        default:
                            j8 = j9;
                            i10++;
                            j9 = j8;
                            i8 = -1;
                        case '\'':
                            str = ".----.";
                            break;
                        case '(':
                            str = "-.--.";
                            break;
                        case ')':
                            str = "-.--.-";
                            break;
                        case '+':
                            str = ".-.-.";
                            break;
                        case ',':
                            str = "--..--";
                            break;
                        case '-':
                            str = "-....-";
                            break;
                        case '.':
                            str = ".-.-.-";
                            break;
                        case '/':
                            str = "-..-.";
                            break;
                        case '0':
                            str = "-----";
                            break;
                        case '1':
                            str = ".----";
                            break;
                        case '2':
                            str = "..---";
                            break;
                        case '3':
                            str = "...--";
                            break;
                        case '4':
                            str = "....-";
                            break;
                        case '5':
                            str = ".....";
                            break;
                        case '6':
                            str = "-....";
                            break;
                        case '7':
                            str = "--...";
                            break;
                        case '8':
                            str = "---..";
                            break;
                        case '9':
                            str = "----.";
                            break;
                        case ':':
                            str = "---...";
                            break;
                        case ';':
                            str = "-.-.-.";
                            break;
                        case '?':
                            str = "..--..";
                            break;
                        case 'A':
                        case 'a':
                            str = ".-";
                            break;
                        case 'B':
                        case 'b':
                            str = "-...";
                            break;
                        case 'C':
                        case 'c':
                            str = "-.-.";
                            break;
                        case 'D':
                        case 'd':
                            str = "-..";
                            break;
                        case 'E':
                        case 'e':
                            str = ".";
                            break;
                        case 'F':
                        case 'f':
                            str = "..-.";
                            break;
                        case 'G':
                        case 'g':
                            str = "--.";
                            break;
                        case 'H':
                        case 'h':
                            str = "....";
                            break;
                        case 'I':
                        case 'i':
                            str = "..";
                            break;
                        case 'J':
                        case 'j':
                            str = ".---";
                            break;
                        case 'K':
                        case 'k':
                            str = "-.-";
                            break;
                        case 'L':
                        case 'l':
                            str = ".-..";
                            break;
                        case 'M':
                        case 'm':
                            str = "--";
                            break;
                        case 'N':
                        case 'n':
                            str = "-.";
                            break;
                        case 'O':
                        case 'o':
                            str = "---";
                            break;
                        case 'P':
                        case 'p':
                            str = ".--.";
                            break;
                        case 'Q':
                        case 'q':
                            str = "--.-";
                            break;
                        case 'R':
                        case 'r':
                            str = ".-.";
                            break;
                        case 'S':
                        case 's':
                            str = "...";
                            break;
                        case MoreOsConstants.EILSEQ /* 84 */:
                        case 't':
                            str = "-";
                            break;
                        case 'U':
                        case 'u':
                            str = "..-";
                            break;
                        case 'V':
                        case 'v':
                            str = "...-";
                            break;
                        case 'W':
                        case 'w':
                            str = ".--";
                            break;
                        case 'X':
                        case 'x':
                            str = "-..-";
                            break;
                        case 'Y':
                        case 'y':
                            str = "-.--";
                            break;
                        case 'Z':
                        case 'z':
                            str = "--..";
                            break;
                    }
                    int length2 = str.length();
                    int i11 = 0;
                    while (true) {
                        length2 += i8;
                        if (length2 >= 0) {
                            char charAt = str.charAt(i11);
                            if (charAt == '-') {
                                c0604c.a(300L);
                            } else {
                                if (charAt != '.') {
                                    throw new IllegalArgumentException();
                                }
                                c0604c.a(100L);
                            }
                            c0604c.a(300L);
                            i11++;
                            i8 = -1;
                        } else {
                            j8 = 0;
                        }
                    }
                    i10++;
                    j9 = j8;
                    i8 = -1;
                } else {
                    jArr = Arrays.copyOf((long[]) c0604c.f1934b, c0604c.f1933a);
                }
            }
        }
        if (jArr.length > 1) {
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
