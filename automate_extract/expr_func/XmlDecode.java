package com.llamalab.automate.expr.func;

import C1.C1;
import F3.g;
import J3.a;
import J3.e;
import J3.h;
import android.util.Xml;
import androidx.appcompat.widget.C1231k;
import com.llamalab.auth3p.MicrosoftClient;
import com.llamalab.automate.C1708z0;
import java.io.StringReader;
import java.util.NoSuchElementException;
import org.xmlpull.v1.XmlPullParser;

@g(1)
/* loaded from: classes.dex */
public final class XmlDecode extends TernaryFunction {
    public static final String NAME = "xmlDecode";

    public static e b(int i8, e eVar, XmlPullParser xmlPullParser) {
        Object b8;
        a aVar;
        e eVar2 = new e();
        eVar2.m0(MicrosoftClient.PROP_NAME, d(xmlPullParser, eVar), null);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i9 = 0;
        while (true) {
            attributeCount--;
            if (attributeCount < 0) {
                break;
            }
            String attributeName = xmlPullParser.getAttributeName(i9);
            String attributePrefix = xmlPullParser.getAttributePrefix(i9);
            if (attributePrefix != null) {
                attributeName = e(attributeName, xmlPullParser.getAttributeNamespace(i9), attributePrefix, eVar);
            }
            eVar2.p0("@" + attributeName, xmlPullParser.getAttributeValue(i9), null);
            i9++;
        }
        a aVar2 = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                break;
            }
            if (next == 2) {
                b8 = b(i8, eVar, xmlPullParser);
                if (aVar2 != null) {
                    aVar2.add(b8);
                } else {
                    aVar = new a(1, new Object[]{b8});
                    aVar2 = aVar;
                    eVar2.m0("children", aVar2, null);
                }
            } else {
                if (next == 3) {
                    break;
                }
                if (next == 4 && ((i8 & 2) == 0 || !xmlPullParser.isWhitespace())) {
                    if (aVar2 != null) {
                        b8 = xmlPullParser.getText();
                        aVar2.add(b8);
                    } else {
                        aVar = new a(1, new Object[]{xmlPullParser.getText()});
                        aVar2 = aVar;
                        eVar2.m0("children", aVar2, null);
                    }
                }
            }
        }
        return eVar2;
    }

    public static Object c(int i8, e eVar, XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        e eVar2 = null;
        int i9 = 0;
        while (true) {
            attributeCount--;
            if (attributeCount < 0) {
                break;
            }
            String attributeName = xmlPullParser.getAttributeName(i9);
            String attributePrefix = xmlPullParser.getAttributePrefix(i9);
            if (attributePrefix != null) {
                attributeName = e(attributeName, xmlPullParser.getAttributeNamespace(i9), attributePrefix, eVar);
            }
            String attributeValue = xmlPullParser.getAttributeValue(i9);
            if (eVar2 == null) {
                eVar2 = new e();
            }
            eVar2.p0("@" + attributeName, attributeValue, null);
            i9++;
        }
        Object obj = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                break;
            }
            if (next == 2) {
                if (eVar2 == null) {
                    eVar2 = new e();
                }
                String d8 = d(xmlPullParser, eVar);
                Object c8 = c(i8, eVar, xmlPullParser);
                Object j02 = eVar2.j0(d8);
                if (j02 instanceof a) {
                    ((a) j02).add(c8);
                } else {
                    if (j02 != null) {
                        c8 = new a(2, new Object[]{j02, c8});
                    }
                    eVar2.m0(d8, c8, null);
                }
            } else {
                if (next == 3) {
                    break;
                }
                if (next == 4 && ((i8 & 2) == 0 || !xmlPullParser.isWhitespace())) {
                    if (obj instanceof a) {
                        ((a) obj).add(xmlPullParser.getText());
                    } else {
                        obj = obj != null ? new a(2, new Object[]{obj, xmlPullParser.getText()}) : xmlPullParser.getText();
                    }
                }
            }
        }
        if (obj != null) {
            if (eVar2 == null) {
                return obj;
            }
            eVar2.m0("#text", obj, null);
        }
        return eVar2;
    }

    public static String d(XmlPullParser xmlPullParser, e eVar) {
        String prefix = xmlPullParser.getPrefix();
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (prefix == null) {
            prefix = "";
        }
        return e(name, namespace, prefix, eVar);
    }

    public static String e(String str, String str2, String str3, e eVar) {
        String str4;
        if (eVar == null) {
            return str;
        }
        Object j02 = eVar.j0(str2);
        if (j02 != null) {
            str4 = h.e0(j02);
        } else {
            char c8 = 'a';
            loop0: while (true) {
                if (c8 > 'z') {
                    break;
                }
                C1231k c1231k = (C1231k) eVar.f9362Z;
                while (true) {
                    if (!(c1231k != eVar)) {
                        eVar.m0(str2, str3, null);
                        break loop0;
                    }
                    if (c1231k == eVar) {
                        throw new NoSuchElementException();
                    }
                    C1231k c1231k2 = (C1231k) c1231k.f9362Z;
                    if (str3.equals(h.f0(null, ((e.a) c1231k).f4644x1))) {
                        break;
                    }
                    c1231k = c1231k2;
                }
                char c9 = (char) (c8 + 1);
                String ch = Character.toString(c8);
                c8 = c9;
                str3 = ch;
            }
            str4 = str3;
        }
        return str4.isEmpty() ? str : C1.d(str4, ":", str);
    }

    @Override // com.llamalab.automate.InterfaceC1700x0
    public final Object c2(C1708z0 c1708z0) {
        e eVar;
        Object c22 = this.f4940X.c2(c1708z0);
        if (c22 != null) {
            try {
                StringReader stringReader = new StringReader(h.e0(c22));
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
                    }
                }
                if ((i8 & 1) != 0) {
                    Object u8 = h.u(c1708z0, this.f4942Z, null);
                    if (u8 instanceof e) {
                        eVar = (e) u8;
                    } else {
                        e eVar2 = new e();
                        if (u8 != null) {
                            eVar2.p0(h.e0(u8), "", null);
                        }
                        eVar = eVar2;
                    }
                } else {
                    eVar = null;
                }
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                newPullParser.setInput(stringReader);
                if (!z7) {
                    e eVar3 = null;
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            return eVar3;
                        }
                        if (next == 2) {
                            eVar3 = new e();
                            eVar3.m0(d(newPullParser, eVar), c(i8, eVar, newPullParser), null);
                            if (eVar != null && !eVar.isEmpty()) {
                                eVar3.m0("#xmlns", eVar, null);
                            }
                        }
                    }
                } else if (z7) {
                    e eVar4 = null;
                    while (true) {
                        int next2 = newPullParser.next();
                        if (next2 == 1) {
                            return eVar4;
                        }
                        if (next2 == 2) {
                            eVar4 = b(i8, eVar, newPullParser);
                            if (eVar != null && !eVar.isEmpty()) {
                                eVar4.m0("#xmlns", eVar, null);
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // J3.f
    public final String k() {
        return NAME;
    }
}
