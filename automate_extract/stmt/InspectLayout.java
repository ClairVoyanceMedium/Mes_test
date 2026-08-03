package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateAccessibilityService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.io.CharArrayWriter;
import java.util.Locale;
import javax.xml.namespace.QName;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import x3.C2425c;

@F3.f("inspect_layout.html")
@F3.a(C2541R.integer.ic_action_screen_click)
@F3.i(C2541R.string.stmt_inspect_layout_title)
@F3.h(C2541R.string.stmt_inspect_layout_summary)
@F3.e(C2541R.layout.stmt_inspect_layout_edit)
/* loaded from: classes.dex */
public final class InspectLayout extends IntermittentDecision implements AsyncStatement {
    public InterfaceC1700x0 displayId;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 resultType;
    public InterfaceC1700x0 schema;
    public J3.l varResult;
    public InterfaceC1700x0 xpathExpression;

    public static final class a extends B1 {

        /* renamed from: S1, reason: collision with root package name */
        public final QName f16738S1;

        /* renamed from: T1, reason: collision with root package name */
        public final boolean f16739T1;

        public a(boolean z7, String str, int i8, String str2, XPathExpression xPathExpression, QName qName, boolean z8) {
            super(z7, str, i8, str2, xPathExpression);
            this.f16738S1 = qName;
            this.f16739T1 = z8;
        }

        @Override // com.llamalab.automate.stmt.B1
        public final boolean A2(AutomateAccessibilityService automateAccessibilityService, Node node, long j8) {
            long nanoTime = System.nanoTime();
            Object evaluate = this.f16328R1.evaluate(node, this.f16738S1);
            long nanoTime2 = System.nanoTime();
            if (evaluate instanceof Node) {
                CharArrayWriter charArrayWriter = new CharArrayWriter(MoreOsConstants.O_DIRECTORY);
                TransformerFactory newInstance = TransformerFactory.newInstance();
                w0.L.B(newInstance);
                Transformer newTransformer = newInstance.newTransformer();
                newTransformer.setOutputProperty("method", "xml");
                newTransformer.setOutputProperty("omit-xml-declaration", "yes");
                newTransformer.transform(new DOMSource((Node) evaluate), new StreamResult(charArrayWriter));
                evaluate = charArrayWriter.toString();
            } else if (evaluate instanceof NodeList) {
                NodeList nodeList = (NodeList) evaluate;
                int length = nodeList.getLength();
                if (length == 0) {
                    evaluate = null;
                } else {
                    CharArrayWriter charArrayWriter2 = new CharArrayWriter(MoreOsConstants.O_DIRECTORY);
                    StreamResult streamResult = new StreamResult(charArrayWriter2);
                    TransformerFactory newInstance2 = TransformerFactory.newInstance();
                    w0.L.B(newInstance2);
                    Transformer newTransformer2 = newInstance2.newTransformer();
                    newTransformer2.setOutputProperty("method", "xml");
                    newTransformer2.setOutputProperty("omit-xml-declaration", "yes");
                    J3.a aVar = new J3.a(length);
                    for (int i8 = 0; i8 < length; i8++) {
                        newTransformer2.transform(new DOMSource(nodeList.item(i8)), streamResult);
                        aVar.add(charArrayWriter2.toString());
                        charArrayWriter2.reset();
                    }
                    evaluate = aVar;
                }
            }
            long nanoTime3 = System.nanoTime() - nanoTime2;
            long j9 = nanoTime2 - nanoTime;
            long j10 = j8 + j9 + nanoTime3;
            if (this.f16739T1) {
                double d8 = j8;
                double d9 = j9;
                double d10 = nanoTime3;
                double d11 = j10;
                F5.n.f(this, String.format(Locale.US, "%s xml_time_stats: document=%.2fms, evaluate=%.2fms, serialize=%.2fms, total=%.2fms", "InspectLayout", F5.n.l(d8, d8, d8, 1000000.0d), F5.n.l(d9, d9, d9, 1000000.0d), F5.n.l(d10, d10, d10, 1000000.0d), F5.n.l(d11, d11, d11, 1000000.0d)));
            }
            if (evaluate instanceof Boolean) {
                Boolean bool = (Boolean) evaluate;
                B2(Double.valueOf(J3.h.Y(bool.booleanValue())), bool.booleanValue());
                return true;
            }
            if (evaluate == null) {
                return false;
            }
            B2(evaluate, true);
            return true;
        }

        public final void B2(Object obj, boolean z7) {
            if (this.f16324N1.compareAndSet(false, true)) {
                q2(new Object[]{Boolean.valueOf(z7), obj}, false);
            }
        }

        @Override // com.llamalab.automate.stmt.B1
        public final void z2(boolean z7) {
            if (z7) {
                return;
            }
            B2(null, false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.f15540a};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 0, C2541R.string.caption_inspect_layout_immediate, C2541R.string.caption_inspect_layout_change);
        c1596k0.v(this.xpathExpression, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.packageName);
        if (105 <= dVar.f6413Z) {
            dVar.g(this.displayId);
            dVar.g(this.schema);
        }
        dVar.g(this.xpathExpression);
        dVar.g(this.resultType);
        dVar.g(this.varResult);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.packageName);
        visitor.b(this.displayId);
        visitor.b(this.schema);
        visitor.b(this.xpathExpression);
        visitor.b(this.resultType);
        visitor.b(this.varResult);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new V();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.packageName = (InterfaceC1700x0) cVar.readObject();
        if (105 <= cVar.f6409x0) {
            this.displayId = (InterfaceC1700x0) cVar.readObject();
            this.schema = (InterfaceC1700x0) cVar.readObject();
        }
        this.xpathExpression = (InterfaceC1700x0) cVar.readObject();
        this.resultType = (InterfaceC1700x0) cVar.readObject();
        this.varResult = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_inspect_layout_title);
        c1708z0.w(new a(J1(1) == 0, J3.h.x(c1708z0, this.packageName, null), J3.h.m(c1708z0, this.displayId, 0), J3.h.x(c1708z0, this.schema, "http://schemas.android.com/apk/res/android/layout"), com.llamalab.automate.J.e().compile(J3.h.x(c1708z0, this.xpathExpression, ".")), QName.valueOf(J3.h.x(c1708z0, this.resultType, XPathConstants.NODE.toString())), C1710z2.a(C2425c.c(c1708z0))));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        Object obj2 = objArr[1];
        J3.l lVar = this.varResult;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj2);
        }
        o(c1708z0, booleanValue);
        return true;
    }
}
