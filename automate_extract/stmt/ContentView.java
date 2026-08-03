package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.fs.AutomateFileTypeDetector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@F3.f("content_view.html")
@F3.a(C2541R.integer.ic_eye)
@F3.i(C2541R.string.stmt_content_view_title)
@F3.h(C2541R.string.stmt_content_view_summary)
@F3.e(C2541R.layout.stmt_content_view_edit)
/* loaded from: classes.dex */
public final class ContentView extends Action {

    /* renamed from: L1, reason: collision with root package name */
    public static final Pattern f16496L1 = Pattern.compile("/events/([0-9]+)(?:/EventTime/([0-9]+)/([0-9]+))?");
    public InterfaceC1700x0 chooser;
    public InterfaceC1700x0 mimeType;
    public InterfaceC1700x0 packageName;
    public InterfaceC1700x0 uri;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 29 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15547h} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_content_view);
        l8.v(this.uri, 0);
        l8.v(this.mimeType, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.uri);
        dVar.g(this.mimeType);
        if (91 <= dVar.f6413Z) {
            dVar.g(this.packageName);
        }
        dVar.g(this.chooser);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.uri);
        visitor.b(this.mimeType);
        visitor.b(this.packageName);
        visitor.b(this.chooser);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.mimeType = (InterfaceC1700x0) cVar.readObject();
        if (91 <= cVar.f6409x0) {
            this.packageName = (InterfaceC1700x0) cVar.readObject();
        }
        this.chooser = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        String path;
        c1708z0.q(C2541R.string.stmt_content_view_title);
        e(c1708z0);
        Uri g8 = J3.h.g(c1708z0, this.uri, null);
        if (g8 == null) {
            throw new RequiredArgumentNullException("uri");
        }
        Intent addFlags = new Intent("android.intent.action.VIEW").addFlags(1);
        String x7 = J3.h.x(c1708z0, this.mimeType, null);
        if (x7 == null) {
            String scheme = g8.getScheme();
            if ("file".equals(scheme)) {
                x7 = AutomateFileTypeDetector.probeContentType(g8);
            } else if ("content".equals(scheme)) {
                try {
                    x7 = c1708z0.getContentResolver().getType(g8);
                } catch (Throwable unused) {
                }
                if (x7 == null && "com.android.calendar".equals(g8.getAuthority()) && (path = g8.getPath()) != null) {
                    Matcher matcher = f16496L1.matcher(path);
                    if (matcher.matches()) {
                        String group = matcher.group(2);
                        if (group != null) {
                            addFlags.putExtra("beginTime", Long.parseLong(group)).putExtra("endTime", Long.parseLong(matcher.group(3)));
                            g8 = CalendarContract.Events.CONTENT_URI.buildUpon().appendEncodedPath(matcher.group(1)).build();
                            x7 = "vnd.android.cursor.item/event";
                        }
                    } else {
                        x7 = "time/epoch";
                    }
                }
            }
        }
        if (x7 != null) {
            addFlags.setDataAndType(g8, x7);
        } else {
            addFlags.setData(g8);
        }
        String x8 = J3.h.x(c1708z0, this.packageName, null);
        if (x8 != null) {
            addFlags.setPackage(x8);
        } else if (J3.h.f(c1708z0, this.chooser, false)) {
            addFlags = Intent.createChooser(addFlags, c1708z0.getText(C2541R.string.stmt_content_view_title));
        }
        addFlags.addFlags(268697600);
        c1708z0.startActivity(addFlags);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
