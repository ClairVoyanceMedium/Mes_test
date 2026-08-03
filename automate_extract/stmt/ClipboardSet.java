package com.llamalab.automate.stmt;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.fs.AutomateFileTypeDetector;
import x3.C2440r;

@F3.f("clipboard_set.html")
@F3.a(C2541R.integer.ic_content_copy)
@F3.i(C2541R.string.stmt_clipboard_set_title)
@F3.h(C2541R.string.stmt_clipboard_set_summary)
@F3.e(C2541R.layout.stmt_clipboard_set_edit)
/* loaded from: classes.dex */
public final class ClipboardSet extends Action {
    public InterfaceC1700x0 htmlText;
    public InterfaceC1700x0 label;
    public InterfaceC1700x0 mimeType;
    public InterfaceC1700x0 sensitive;
    public InterfaceC1700x0 text;
    public InterfaceC1700x0 uri;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_clipboard_set);
        l8.v(this.text, 0);
        l8.v(this.uri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.text);
        if (104 <= dVar.f6413Z) {
            dVar.g(this.htmlText);
            dVar.g(this.uri);
            dVar.g(this.mimeType);
            dVar.g(this.label);
        }
        if (100 <= dVar.f6413Z) {
            dVar.g(this.sensitive);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.text);
        visitor.b(this.htmlText);
        visitor.b(this.uri);
        visitor.b(this.mimeType);
        visitor.b(this.label);
        visitor.b(this.sensitive);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.text = (InterfaceC1700x0) cVar.readObject();
        if (104 <= cVar.f6409x0) {
            this.htmlText = (InterfaceC1700x0) cVar.readObject();
            this.uri = (InterfaceC1700x0) cVar.readObject();
            this.mimeType = (InterfaceC1700x0) cVar.readObject();
            this.label = (InterfaceC1700x0) cVar.readObject();
        }
        if (100 <= cVar.f6409x0) {
            this.sensitive = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        String[] strArr;
        String[] strArr2;
        ClipData clipData;
        c1708z0.q(C2541R.string.stmt_clipboard_set_title);
        String x7 = J3.h.x(c1708z0, this.text, null);
        String x8 = J3.h.x(c1708z0, this.htmlText, null);
        Uri A7 = J3.h.A(c1708z0, this.uri, null);
        String x9 = J3.h.x(c1708z0, this.mimeType, null);
        String x10 = J3.h.x(c1708z0, this.label, null);
        boolean f8 = J3.h.f(c1708z0, this.sensitive, false);
        ClipboardManager clipboardManager = (ClipboardManager) c1708z0.getSystemService("clipboard");
        if (x7 == null && x8 == null && A7 == null) {
            if (28 <= Build.VERSION.SDK_INT) {
                clipboardManager.clearPrimaryClip();
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
            clipData = ClipData.newPlainText(null, null);
        } else {
            if (x8 != null && x7 == null) {
                throw new RequiredArgumentNullException("html also requires text");
            }
            if (x9 != null) {
                strArr = new String[]{x9};
            } else if (A7 != null) {
                ContentResolver contentResolver = c1708z0.getContentResolver();
                if ("content".equals(A7.getScheme())) {
                    String type = contentResolver.getType(A7);
                    strArr2 = contentResolver.getStreamTypes(A7, "*/*");
                    if (type != null) {
                        if (strArr2 == null) {
                            strArr2 = new String[]{type};
                        } else if (!C2440r.f(strArr2, type)) {
                            String[] strArr3 = new String[strArr2.length + 1];
                            strArr3[0] = type;
                            System.arraycopy(strArr2, 0, strArr3, 1, strArr2.length);
                            strArr2 = strArr3;
                        }
                    }
                } else {
                    strArr2 = null;
                }
                if (strArr2 == null) {
                    strArr2 = new String[]{"text/uri-list"};
                }
                strArr = strArr2;
            } else if (16 > Build.VERSION.SDK_INT || x8 == null) {
                strArr = new String[1];
                if (x7 != null) {
                    strArr[0] = "text/plain";
                } else {
                    strArr[0] = AutomateFileTypeDetector.OCTET_STREAM;
                }
            } else {
                strArr = new String[]{"text/html"};
            }
            int i8 = Build.VERSION.SDK_INT;
            clipData = new ClipData(x10, strArr, 16 <= i8 ? new ClipData.Item(x7, x8, null, A7) : new ClipData.Item(x7, null, A7));
            if (24 <= i8 && f8) {
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putBoolean("android.content.extra.IS_SENSITIVE", true);
                clipData.getDescription().setExtras(persistableBundle);
            }
        }
        clipboardManager.setPrimaryClip(clipData);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
