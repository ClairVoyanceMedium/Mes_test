package com.llamalab.automate.stmt;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.WebDialogActivity;
import g4.C1828b;
import java.util.regex.Pattern;
import x3.C2425c;

@F3.f("dialog_web.html")
@F3.a(C2541R.integer.ic_dialog_html)
@F3.i(C2541R.string.stmt_dialog_web_title)
@F3.h(C2541R.string.stmt_dialog_web_summary)
@F3.e(C2541R.layout.stmt_dialog_web_edit)
/* loaded from: classes.dex */
public final class DialogWeb extends ActivityDecision {
    public InterfaceC1700x0 account;
    public int allowed = 3;
    public InterfaceC1700x0 body;
    public InterfaceC1700x0 regex;
    public InterfaceC1700x0 url;
    public InterfaceC1700x0 userAgent;
    public J3.l varResultTitle;
    public J3.l varResultUrl;
    public InterfaceC1700x0 viewport;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return WebDialogActivity.U(this.allowed & (-9));
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_dialog_web);
        l8.v(this.url, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (97 <= dVar.f6413Z) {
            dVar.writeInt(this.allowed);
        }
        dVar.g(this.url);
        dVar.g(this.body);
        dVar.g(this.regex);
        dVar.g(this.account);
        if (79 <= dVar.f6413Z) {
            dVar.g(this.userAgent);
        }
        if (103 <= dVar.f6413Z) {
            dVar.g(this.viewport);
        }
        dVar.g(this.varResultUrl);
        dVar.g(this.varResultTitle);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.url);
        visitor.b(this.body);
        visitor.b(this.regex);
        visitor.b(this.account);
        visitor.b(this.userAgent);
        visitor.b(this.viewport);
        visitor.b(this.varResultUrl);
        visitor.b(this.varResultTitle);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.allowed = 97 <= cVar.f6409x0 ? cVar.readInt() : 51;
        this.url = (InterfaceC1700x0) cVar.readObject();
        this.body = (InterfaceC1700x0) cVar.readObject();
        this.regex = (InterfaceC1700x0) cVar.readObject();
        this.account = (InterfaceC1700x0) cVar.readObject();
        if (79 <= cVar.f6409x0) {
            this.userAgent = (InterfaceC1700x0) cVar.readObject();
        }
        if (103 <= cVar.f6409x0) {
            this.viewport = (InterfaceC1700x0) cVar.readObject();
        }
        this.varResultUrl = (J3.l) cVar.readObject();
        this.varResultTitle = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        String str;
        String str2;
        if (intent != null) {
            str = intent.getDataString();
            str2 = intent.getStringExtra("android.intent.extra.TITLE");
        } else {
            str = null;
            str2 = null;
        }
        J3.l lVar = this.varResultUrl;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varResultTitle;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str2);
        }
        o(c1708z0, -1 == i8);
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        Uri uri;
        c1708z0.q(C2541R.string.stmt_dialog_web_title);
        String x7 = J3.h.x(c1708z0, this.url, null);
        if (TextUtils.isEmpty(x7)) {
            uri = null;
        } else {
            uri = Uri.parse(x7);
            if (!uri.isAbsolute()) {
                uri = Uri.parse("http://" + x7);
            }
            if ((this.allowed & 32) == 0 && (C1828b.b(uri) || C1828b.a.a(uri))) {
                throw new SecurityException("Loading an content://" + uri.getScheme() + " URL requires file access to be allowed");
            }
        }
        Intent intent = new Intent("android.intent.action.VIEW", uri, c1708z0, WebDialogActivity.class);
        ClipData newRawUri = ClipData.newRawUri(null, F5.n.c(c1708z0));
        if (16 <= Build.VERSION.SDK_INT) {
            intent.setClipData(newRawUri);
        } else if (newRawUri != null) {
            intent.putExtra("com.llamalab.automate.intent.extra.CLIP_DATA", newRawUri);
        } else {
            intent.removeExtra("com.llamalab.automate.intent.extra.CLIP_DATA");
        }
        int i8 = this.allowed;
        if (i8 != 0) {
            intent.putExtra("com.llamalab.automate.intent.extra.ALLOWED", i8);
        }
        String x8 = J3.h.x(c1708z0, this.body, null);
        if (!TextUtils.isEmpty(x8)) {
            intent.putExtra("android.intent.extra.HTML_TEXT", x8);
        }
        String x9 = J3.h.x(c1708z0, this.regex, null);
        if (!TextUtils.isEmpty(x9)) {
            intent.putExtra("com.llamalab.automate.intent.extra.REGEX", Pattern.compile(x9, 2));
        }
        String x10 = J3.h.x(c1708z0, this.account, null);
        if (!TextUtils.isEmpty(x10)) {
            intent.putExtra("authAccount", x10);
        }
        String x11 = J3.h.x(c1708z0, this.userAgent, null);
        if (!TextUtils.isEmpty(x11)) {
            intent.putExtra("com.llamalab.automate.intent.extra.USER_AGENT", x11);
        }
        intent.putExtra("com.llamalab.automate.intent.extra.WIDE_VIEWPORT", !J3.h.f(c1708z0, this.viewport, false));
        if (C1710z2.a(C2425c.c(c1708z0))) {
            intent.putExtra("com.llamalab.automate.intent.extra.CONSOLE_LOGGING", true);
        }
        c1708z0.D(intent, null, this, c1708z0.f(C2541R.integer.ic_dialog_html), c1708z0.getText(C2541R.string.stmt_dialog_web_title));
        return false;
    }
}
