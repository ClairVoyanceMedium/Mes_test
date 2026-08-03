package com.llamalab.automate.expr.func;

import F3.g;
import J3.h;
import L3.I;
import R0.u;
import R3.c;
import R3.d;
import Y3.C1174j;
import a4.C1194c;
import a4.C1203l;
import a4.C1209r;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.InterfaceC1700x0;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;
import s1.C2305a;

@g(1)
/* loaded from: classes.dex */
public final class UrlDecode extends TernaryFunction {
    public static final String NAME = "urlDecode";

    @Override // L3.U, R3.e
    public final void Y0(d dVar) {
        dVar.g(this.f4940X);
        if (109 <= dVar.f6413Z) {
            dVar.g(this.f4941Y);
        }
        dVar.g(this.f4942Z);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        int i8;
        char c8;
        CharBuffer decode;
        Map map;
        Object c22 = this.f4940X.c2(c1708z0);
        if (c22 == null) {
            return null;
        }
        String x7 = h.x(c1708z0, this.f4941Y, "");
        int length = x7.length();
        loop0: while (true) {
            i8 = 0;
            c8 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    break loop0;
                }
                char charAt = x7.charAt(length);
                if (charAt != 'c') {
                    if (charAt == 'p') {
                        c8 = 2;
                    } else if (charAt == 'u') {
                        c8 = 1;
                    }
                }
            }
        }
        Charset forName = Charset.forName(h.x(c1708z0, this.f4942Z, "UTF-8"));
        if (c8 == 0) {
            decode = forName.decode(C1209r.a(h.e0(c22), 0L, 0L));
        } else {
            if (c8 != 1) {
                if (c8 != 2) {
                    return null;
                }
                String e02 = h.e0(c22);
                Charset charset = C1209r.f8266a;
                int length2 = e02.length();
                if (length2 == 0) {
                    map = Collections.emptyMap();
                } else {
                    C1203l c1203l = new C1203l(new C1174j(2), new u(8));
                    ByteBuffer byteBuffer = C1194c.f8200b;
                    CharSequence charSequence = "";
                    int i9 = 0;
                    while (i8 < length2) {
                        char charAt2 = e02.charAt(i8);
                        if ('&' == charAt2) {
                            if (charSequence.length() == 0) {
                                throw new IllegalArgumentException();
                            }
                            c1203l.g(charSequence, i9 > i8 ? forName.decode((ByteBuffer) byteBuffer.flip()) : e02.subSequence(i9, i8));
                            i9 = i8 + 1;
                            charSequence = "";
                        } else if ('=' == charAt2) {
                            charSequence = i9 > i8 ? forName.decode((ByteBuffer) byteBuffer.flip()) : e02.subSequence(i9, i8);
                            i9 = i8 + 1;
                        } else {
                            if (!byteBuffer.hasRemaining()) {
                                byteBuffer = ByteBuffer.allocate(Math.max(64, byteBuffer.capacity() << 1)).put((ByteBuffer) byteBuffer.flip());
                            }
                            if ('%' == charAt2) {
                                int i10 = i8 + 2;
                                int b8 = (C2305a.b(e02.charAt(i8 + 1)) << 4) | C2305a.b(e02.charAt(i10));
                                if (!C1209r.b(b8, 0L, 0L)) {
                                    byteBuffer.put((byte) b8);
                                    i8 = i10;
                                    i9 = Integer.MAX_VALUE;
                                }
                            }
                            if ('+' == charAt2) {
                                byteBuffer.put((byte) 32);
                                i9 = Integer.MAX_VALUE;
                            } else {
                                byteBuffer.put((byte) charAt2);
                            }
                        }
                        i8++;
                    }
                    if (byteBuffer.position() != 0) {
                        CharSequence decode2 = i9 > i8 ? forName.decode((ByteBuffer) byteBuffer.flip()) : e02.subSequence(i9, i8);
                        if (charSequence.length() != 0) {
                            c1203l.g(charSequence, decode2);
                        } else {
                            c1203l.g(decode2, "");
                        }
                    }
                    map = c1203l;
                }
                return h.P(map);
            }
            decode = forName.decode(C1209r.a(h.e0(c22), 671088641L, -6052662140534259712L));
        }
        return decode.toString();
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }

    @Override // L3.U, R3.e
    public final void o0(c cVar) {
        this.f4940X = (InterfaceC1700x0) cVar.readObject();
        if (109 <= cVar.f6409x0) {
            this.f4941Y = (InterfaceC1700x0) cVar.readObject();
            this.f4942Z = (InterfaceC1700x0) cVar.readObject();
            return;
        }
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        this.f4942Z = interfaceC1700x0;
        if (interfaceC1700x0 != null) {
            this.f4941Y = I.f4933X;
        }
    }
}
