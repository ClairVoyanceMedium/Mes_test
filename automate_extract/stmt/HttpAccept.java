package com.llamalab.automate.stmt;

import android.security.KeyChain;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import v3.C2359a;
import v3.C2360b;

@F3.a(C2541R.integer.ic_location_web_site)
/* loaded from: classes.dex */
public abstract class HttpAccept extends Action implements AsyncStatement {
    public InterfaceC1700x0 alias;
    public InterfaceC1700x0 bodyPath;
    public InterfaceC1700x0 contentType;
    public InterfaceC1700x0 method;
    public InterfaceC1700x0 saveBody;
    public InterfaceC1700x0 uri;
    public J3.l varRequestBody;
    public J3.l varRequestHeaders;
    public J3.l varRequestUri;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f16701L1;

        public a(String str) {
            this.f16701L1 = str;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            AutomateService automateService = this.f15400Y;
            String str = this.f16701L1;
            C2359a c2359a = new C2359a(str, KeyChain.getCertificateChain(automateService, str), KeyChain.getPrivateKey(automateService, str));
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(new KeyManager[]{c2359a}, new TrustManager[]{new C2360b(c2359a.f22880b)}, null);
            q2(sSLContext, false);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.alias);
        dVar.g(this.method);
        dVar.g(this.uri);
        dVar.g(this.contentType);
        dVar.g(this.saveBody);
        dVar.g(this.bodyPath);
        dVar.g(this.varRequestUri);
        dVar.g(this.varRequestBody);
        dVar.g(this.varRequestHeaders);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public void o0(R3.c cVar) {
        super.o0(cVar);
        this.alias = (InterfaceC1700x0) cVar.readObject();
        this.method = (InterfaceC1700x0) cVar.readObject();
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.contentType = (InterfaceC1700x0) cVar.readObject();
        this.saveBody = (InterfaceC1700x0) cVar.readObject();
        this.bodyPath = (InterfaceC1700x0) cVar.readObject();
        this.varRequestUri = (J3.l) cVar.readObject();
        this.varRequestBody = (J3.l) cVar.readObject();
        this.varRequestHeaders = (J3.l) cVar.readObject();
    }

    public abstract void q(C1708z0 c1708z0, SSLContext sSLContext);

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        if (w8 instanceof a) {
            q(c1708z0, (SSLContext) obj);
            return false;
        }
        if (!(w8 instanceof J)) {
            throw new IllegalStateException();
        }
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varRequestUri;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[0]);
        }
        J3.l lVar2 = this.varRequestHeaders;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[1]);
        }
        J3.l lVar3 = this.varRequestBody;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, objArr[2]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
