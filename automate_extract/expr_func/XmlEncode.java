package com.llamalab.automate.expr.func;

import F3.g;
import J3.e;
import J3.h;
import androidx.appcompat.widget.C1231k;
import com.llamalab.auth3p.MicrosoftClient;
import com.llamalab.automate.C1708z0;
import java.io.CharArrayWriter;
import java.util.NoSuchElementException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.ext.Attributes2Impl;
import org.xml.sax.helpers.XMLFilterImpl;
import w0.L;
import x3.C2440r;

@g(1)
/* loaded from: classes.dex */
public final class XmlEncode extends TernaryFunction {
    public static final String NAME = "xmlEncode";

    public static final class a extends c {
        public a(e eVar, e eVar2) {
            super(eVar, eVar2);
        }

        @Override // com.llamalab.automate.expr.func.XmlEncode.c
        public final void d(e eVar) {
            eVar.getClass();
            C1231k c1231k = (C1231k) eVar.f9362Z;
            while (true) {
                if (!(c1231k != eVar)) {
                    throw new SAXException("Missing document element");
                }
                if (c1231k == eVar) {
                    throw new NoSuchElementException();
                }
                C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                e.a aVar = (e.a) c1231k;
                if (c(aVar.f4645y0, false)) {
                    e(this.f15721d, this.f15722e, this.f15723f, aVar.f4644x1);
                    return;
                }
                c1231k = c1231k2;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0092 A[EDGE_INSN: B:22:0x0092->B:23:0x0092 BREAK  A[LOOP:0: B:8:0x002f->B:16:0x0051], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void e(String str, String str2, String str3, Object obj) {
            String e02;
            C1231k c1231k;
            if (obj instanceof e) {
                e eVar = (e) obj;
                startElement(str, str2, str3, b(eVar));
                Object j02 = eVar.j0("#text");
                if (!(j02 instanceof J3.a)) {
                    if (j02 != null) {
                        e02 = h.e0(j02);
                    }
                    c1231k = (C1231k) eVar.f9362Z;
                    while (true) {
                        if (c1231k == eVar) {
                            break;
                        }
                        if (c1231k == eVar) {
                            throw new NoSuchElementException();
                        }
                        C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                        e.a aVar = (e.a) c1231k;
                        if (c(aVar.f4645y0, false)) {
                            e(this.f15721d, this.f15722e, this.f15723f, aVar.f4644x1);
                        }
                        c1231k = c1231k2;
                    }
                } else {
                    e02 = ((J3.a) j02).l("");
                }
                a(e02);
                c1231k = (C1231k) eVar.f9362Z;
                while (true) {
                    if (c1231k == eVar) {
                    }
                    c1231k = c1231k2;
                }
            } else if (obj instanceof J3.a) {
                J3.a aVar2 = (J3.a) obj;
                aVar2.getClass();
                int i8 = 0;
                while (true) {
                    if (!(i8 < aVar2.f4627Y)) {
                        return;
                    }
                    if (i8 >= aVar2.f4627Y) {
                        throw new NoSuchElementException();
                    }
                    e(str, str2, str3, aVar2.get(i8));
                    i8++;
                }
            } else {
                startElement(str, str2, str3, b(null));
                if (obj != null) {
                    a(h.e0(obj));
                }
            }
            endElement(str, str2, str3);
        }
    }

    public static final class b extends c {
        public b(e eVar, e eVar2) {
            super(eVar, eVar2);
        }

        @Override // com.llamalab.automate.expr.func.XmlEncode.c
        public final void d(e eVar) {
            Object j02 = eVar.j0(MicrosoftClient.PROP_NAME);
            if ((j02 instanceof String) && c((String) j02, false)) {
                String str = this.f15721d;
                String str2 = this.f15722e;
                String str3 = this.f15723f;
                startElement(str, str2, str3, b(eVar));
                Object j03 = eVar.j0("children");
                if (j03 instanceof J3.a) {
                    J3.a aVar = (J3.a) j03;
                    aVar.getClass();
                    int i8 = 0;
                    while (true) {
                        if (!(i8 < aVar.f4627Y)) {
                            break;
                        }
                        if (i8 >= aVar.f4627Y) {
                            throw new NoSuchElementException();
                        }
                        int i9 = i8 + 1;
                        Object obj = aVar.get(i8);
                        if (obj instanceof e) {
                            d((e) obj);
                        } else if (obj != null) {
                            a(h.e0(obj));
                        }
                        i8 = i9;
                    }
                } else if (j03 instanceof e) {
                    d((e) j03);
                } else if (j03 != null) {
                    a(h.e0(j03));
                }
                endElement(str, str2, str3);
            }
        }
    }

    public static abstract class c extends XMLFilterImpl {

        /* renamed from: a, reason: collision with root package name */
        public final e f15718a;

        /* renamed from: b, reason: collision with root package name */
        public final e f15719b;

        /* renamed from: d, reason: collision with root package name */
        public String f15721d;

        /* renamed from: e, reason: collision with root package name */
        public String f15722e;

        /* renamed from: f, reason: collision with root package name */
        public String f15723f;

        /* renamed from: c, reason: collision with root package name */
        public final Attributes2Impl f15720c = new Attributes2Impl();

        /* renamed from: g, reason: collision with root package name */
        public final char[] f15724g = new char[512];

        public c(e eVar, e eVar2) {
            this.f15719b = eVar;
            this.f15718a = eVar2;
        }

        public final void a(String str) {
            int length = str.length();
            while (length > 0) {
                int min = Math.min(length, 512);
                char[] cArr = this.f15724g;
                str.getChars(0, 0 + min, cArr, 0);
                characters(cArr, 0, min);
                length -= min;
            }
        }

        public final Attributes2Impl b(e eVar) {
            Attributes2Impl attributes2Impl = this.f15720c;
            attributes2Impl.clear();
            if (eVar != null) {
                C1231k c1231k = (C1231k) eVar.f9362Z;
                while (true) {
                    if (!(c1231k != eVar)) {
                        break;
                    }
                    if (c1231k == eVar) {
                        throw new NoSuchElementException();
                    }
                    C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                    e.a aVar = (e.a) c1231k;
                    if (c(aVar.f4645y0, true)) {
                        attributes2Impl.addAttribute(this.f15721d, this.f15722e, this.f15723f, "CDATA", h.f0("", aVar.f4644x1));
                    }
                    c1231k = c1231k2;
                }
            }
            return attributes2Impl;
        }

        public final boolean c(String str, boolean z7) {
            int i8;
            int i9;
            int length = str.length();
            if (!z7) {
                i8 = 0;
                i9 = 0;
            } else {
                if (1 >= length || '@' != str.charAt(0)) {
                    return false;
                }
                i8 = 1;
                i9 = 1;
            }
            if (i8 < length) {
                char charAt = str.charAt(i8);
                if (charAt == '_' || Character.isLetter(charAt)) {
                    int i10 = -1;
                    while (i8 < length) {
                        char charAt2 = str.charAt(i8);
                        if (!(charAt2 == '-' || charAt2 == '.' || charAt2 == '_' || Character.isLetterOrDigit(charAt2))) {
                            if (':' != charAt2 || i10 != -1) {
                                return false;
                            }
                            i10 = i8;
                        }
                        i8++;
                    }
                    e eVar = this.f15719b;
                    if (i10 == -1) {
                        this.f15721d = eVar != null ? h.f0("", eVar.j0("")) : "";
                        String substring = str.substring(i9, length);
                        this.f15723f = substring;
                        this.f15722e = substring;
                    } else if (i10 != i9 && i10 != length - 1) {
                        this.f15721d = eVar != null ? h.f0("", eVar.j0(str.substring(i9, i10))) : "";
                        this.f15722e = str.substring(i10 + 1, length);
                        this.f15723f = str.substring(i9, length);
                    }
                    return true;
                }
            }
            return false;
        }

        public abstract void d(e eVar);

        @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.XMLReader
        public final void parse(String str) {
            parse((InputSource) null);
        }

        @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.XMLReader
        public final void parse(InputSource inputSource) {
            startDocument();
            e eVar = this.f15719b;
            if (eVar != null) {
                eVar.getClass();
                C1231k c1231k = (C1231k) eVar.f9362Z;
                while (true) {
                    if (!(c1231k != eVar)) {
                        break;
                    }
                    if (c1231k == eVar) {
                        throw new NoSuchElementException();
                    }
                    C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                    e.a aVar = (e.a) c1231k;
                    startPrefixMapping(aVar.f4645y0, h.e0(aVar.f4644x1));
                    c1231k = c1231k2;
                }
            }
            d(this.f15718a);
            endDocument();
        }
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        SAXSource sAXSource;
        StreamResult streamResult;
        Object c22 = this.f4940X.c2(c1708z0);
        e eVar = null;
        if (!(c22 instanceof e)) {
            if (c22 != null) {
                return C2440r.k(h.e0(c22));
            }
            return null;
        }
        String x7 = h.x(c1708z0, this.f4941Y, "");
        int length = x7.length();
        int i8 = 0;
        boolean z7 = false;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            char charAt = x7.charAt(length);
            if (charAt == '1') {
                z7 = true;
            } else if (charAt == 'i') {
                i8 |= 2;
            } else if (charAt == 'n') {
                i8 |= 1;
            } else if (charAt == 'o') {
                i8 |= 4;
            }
        }
        e eVar2 = (e) c22;
        if ((i8 & 1) != 0) {
            e eVar3 = new e();
            Object j02 = eVar2.j0("#xmlns");
            if (j02 instanceof e) {
                e eVar4 = (e) j02;
                eVar4.getClass();
                C1231k c1231k = (C1231k) eVar4.f9362Z;
                while (true) {
                    if (!(c1231k != eVar4)) {
                        break;
                    }
                    if (c1231k == eVar4) {
                        throw new NoSuchElementException();
                    }
                    C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                    e.a aVar = (e.a) c1231k;
                    eVar3.m0(h.f0("", aVar.f4644x1), aVar.f4645y0, null);
                    c1231k = c1231k2;
                }
            }
            Object u8 = h.u(c1708z0, this.f4942Z, null);
            if (u8 instanceof e) {
                e eVar5 = (e) u8;
                eVar5.getClass();
                C1231k c1231k3 = (C1231k) eVar5.f9362Z;
                while (true) {
                    if (!(c1231k3 != eVar5)) {
                        break;
                    }
                    if (c1231k3 == eVar5) {
                        throw new NoSuchElementException();
                    }
                    C1231k c1231k4 = (C1231k) c1231k3.f9362Z;
                    e.a aVar2 = (e.a) c1231k3;
                    eVar3.m0(h.f0("", aVar2.f4644x1), aVar2.f4645y0, null);
                    c1231k3 = c1231k4;
                }
            } else if (u8 != null) {
                eVar3.m0("", h.e0(u8), null);
            }
            eVar = eVar3;
        }
        try {
            TransformerFactory newInstance = TransformerFactory.newInstance();
            L.B(newInstance);
            if (!newInstance.getFeature("http://javax.xml.transform.sax.SAXSource/feature")) {
                throw new IllegalStateException("SAX transformation not supported");
            }
            Transformer newTransformer = newInstance.newTransformer();
            newTransformer.setOutputProperty("method", "xml");
            String str = "yes";
            newTransformer.setOutputProperty("omit-xml-declaration", (i8 & 4) != 0 ? "yes" : "no");
            newTransformer.setOutputProperty("encoding", "UTF-8");
            if ((i8 & 2) == 0) {
                str = "no";
            }
            newTransformer.setOutputProperty("indent", str);
            try {
                newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            } catch (Exception unused) {
            }
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            if (!z7) {
                sAXSource = new SAXSource(new a(eVar, eVar2), new InputSource());
                streamResult = new StreamResult(charArrayWriter);
            } else {
                if (!z7) {
                    return charArrayWriter.toString();
                }
                sAXSource = new SAXSource(new b(eVar, eVar2), new InputSource());
                streamResult = new StreamResult(charArrayWriter);
            }
            newTransformer.transform(sAXSource, streamResult);
            return charArrayWriter.toString();
        } catch (Exception e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
