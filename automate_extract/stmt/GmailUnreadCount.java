package com.llamalab.automate.stmt;

import C1.D1;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1616p0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("gmail_unread_count.html")
@F3.a(C2541R.integer.ic_content_gmail_unread)
@F3.i(C2541R.string.stmt_gmail_unread_count_title)
@F3.h(C2541R.string.stmt_gmail_unread_count_summary)
@F3.e(C2541R.layout.stmt_gmail_unread_count_edit)
/* loaded from: classes.dex */
public final class GmailUnreadCount extends IntermittentAction implements AsyncStatement {

    /* renamed from: L1, reason: collision with root package name */
    public static final Uri f16689L1 = Uri.parse("content://com.google.android.gm");
    public InterfaceC1700x0 account;
    public InterfaceC1700x0 inbox;
    public J3.l varUnreadCount;

    public static final class a extends C1616p0 {

        /* renamed from: L1, reason: collision with root package name */
        public final Uri f16690L1;

        /* renamed from: M1, reason: collision with root package name */
        public final boolean f16691M1;

        /* renamed from: N1, reason: collision with root package name */
        public int f16692N1;

        public a(Uri uri, boolean z7, int i8) {
            this.f16690L1 = uri;
            this.f16691M1 = z7;
            this.f16692N1 = i8;
        }

        @Override // com.llamalab.automate.C1616p0
        public final void x2(Uri uri) {
            Double valueOf;
            try {
                String[] strArr = {"numUnreadConversations"};
                ContentResolver v22 = v2();
                if (uri == null) {
                    uri = this.f16690L1;
                }
                Cursor query = v22.query(uri, strArr, null, null, null);
                try {
                    if (query.moveToNext()) {
                        int i8 = query.getInt(0);
                        int i9 = this.f16692N1;
                        if (i9 < i8) {
                            this.f16692N1 = i8;
                            valueOf = Double.valueOf(i8);
                        } else if (i9 > i8) {
                            this.f16692N1 = i8;
                            if (this.f16691M1) {
                                valueOf = Double.valueOf(i8);
                            }
                        }
                        q2(valueOf, false);
                    }
                    query.close();
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            } catch (Throwable th2) {
                r2(th2);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("com.google.android.gm.permission.READ_CONTENT_PROVIDER")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_gmail_unread_count_immediate, C2541R.string.caption_gmail_unread_count_change, C2541R.string.caption_gmail_unread_count_increased);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.account);
        dVar.g(this.inbox);
        dVar.g(this.varUnreadCount);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.account);
        visitor.b(this.inbox);
        visitor.b(this.varUnreadCount);
    }

    @Override // com.llamalab.automate.stmt.IntermittentAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.account = (InterfaceC1700x0) cVar.readObject();
        this.inbox = (InterfaceC1700x0) cVar.readObject();
        this.varUnreadCount = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_gmail_unread_count_title);
        String x7 = J3.h.x(c1708z0, this.account, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("account");
        }
        String x8 = J3.h.x(c1708z0, this.inbox, "^i");
        ContentResolver contentResolver = c1708z0.getContentResolver();
        Uri build = f16689L1.buildUpon().appendEncodedPath(x7).appendPath("labels").build();
        Cursor query = contentResolver.query(build, new String[]{"canonicalName", "numUnreadConversations", "labelUri"}, null, null, null);
        do {
            try {
                if (!query.moveToNext()) {
                    query.close();
                    throw new IllegalStateException(D1.k("Inbox not found: ", x8));
                }
            } finally {
                query.close();
            }
        } while (!x8.equals(query.getString(0)));
        int J12 = J1(1);
        if (J12 != 0) {
            a aVar = new a(build, 2 != J12, query.getInt(1));
            c1708z0.w(aVar);
            aVar.w2(false, Uri.parse(query.getString(2)));
            return false;
        }
        Double valueOf = Double.valueOf(query.getInt(1));
        J3.l lVar = this.varUnreadCount;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, valueOf);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Double d8 = (Double) obj;
        J3.l lVar = this.varUnreadCount;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, d8);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
