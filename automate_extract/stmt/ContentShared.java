package com.llamalab.automate.stmt;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1693v1;
import com.llamalab.automate.C1701x1;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.ContentSharedActivity;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import com.llamalab.safs.f;
import i4.C1949c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@F3.f("content_shared.html")
@F3.a(C2541R.integer.ic_social_share)
@F3.i(C2541R.string.stmt_content_shared_title)
@F3.h(C2541R.string.stmt_content_shared_summary)
@F3.e(C2541R.layout.stmt_content_shared_edit)
/* loaded from: classes.dex */
public final class ContentShared extends Action implements IntentStatement {
    public InterfaceC1700x0 mimeType;
    public InterfaceC1700x0 multiple;
    public InterfaceC1700x0 title;
    public J3.l varContentMimeType;
    public J3.l varContentSubject;
    public J3.l varContentText;
    public J3.l varContentUri;

    public static <T> List<T> q(Intent intent, String str, Class<T> cls) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        Object obj = extras.get(str);
        if (cls.isInstance(obj)) {
            return Collections.singletonList(cls.cast(obj));
        }
        if (obj instanceof ArrayList) {
            return (ArrayList) obj;
        }
        return null;
    }

    public static J3.a s(int i8, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object[] objArr = new Object[i8];
        int size = list.size();
        int i9 = 0;
        String str = null;
        while (i9 < size) {
            str = O.b.d(null, list.get(i9));
            objArr[i9] = str;
            i9++;
        }
        Arrays.fill(objArr, i9, i8, str);
        return new J3.a(i8, objArr);
    }

    public static J3.a u(Object obj) {
        if (obj == null) {
            return null;
        }
        return new J3.a(1, new Object[]{obj.toString()});
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_content_shared);
        l8.v(this.title, 0);
        l8.v(this.mimeType, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        List list;
        Object s8;
        Object s9;
        Object s10;
        Object s11;
        Uri data;
        c1708z0.H(C1693v1.class);
        boolean booleanExtra = intent.getBooleanExtra("com.llamalab.automate.intent.extra.MULTIPLE", false);
        Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.INTENT");
        if (19 <= Build.VERSION.SDK_INT) {
            ((C1949c) f.a.f17733a).O(intent2);
        }
        List list2 = null;
        if ("android.intent.action.SEND_MULTIPLE".equals(intent2.getAction())) {
            List q8 = this.varContentText != null ? q(intent2, "android.intent.extra.TEXT", CharSequence.class) : null;
            List q9 = this.varContentSubject != null ? q(intent2, "android.intent.extra.SUBJECT", String.class) : null;
            if (this.varContentUri != null) {
                list = q(intent2, "android.intent.extra.STREAM", Uri.class);
                if (list == null && (data = intent2.getData()) != null) {
                    list = Collections.singletonList(data);
                }
            } else {
                list = null;
            }
            if (this.varContentMimeType != null) {
                String type = intent2.getType();
                if (type != null && !"*/*".equals(type) && !type.endsWith("/*")) {
                    list2 = Collections.singletonList(type);
                } else if (list != null) {
                    ContentResolver contentResolver = c1708z0.getContentResolver();
                    ArrayList arrayList = new ArrayList(list.size());
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            arrayList.add(contentResolver.getType((Uri) it.next()));
                        } catch (Throwable unused) {
                            arrayList.add(null);
                        }
                    }
                    list2 = arrayList;
                }
            }
            int max = Math.max(q8 == null ? 0 : q8.size(), Math.max(q9 == null ? 0 : q9.size(), Math.max(list == null ? 0 : list.size(), list2 != null ? list2.size() : 0)));
            s8 = s(max, q8);
            s9 = s(max, q9);
            s10 = s(max, list);
            s11 = s(max, list2);
        } else {
            CharSequence charSequenceExtra = intent2.getCharSequenceExtra("android.intent.extra.TEXT");
            s9 = intent2.getStringExtra("android.intent.extra.SUBJECT");
            Uri uri = (Uri) intent2.getParcelableExtra("android.intent.extra.STREAM");
            Uri data2 = intent2.getData();
            if (uri == null) {
                uri = data2;
            }
            s11 = intent2.getType();
            if (booleanExtra) {
                s8 = u(charSequenceExtra);
                s9 = u(s9);
                s10 = u(uri);
                s11 = u(s11);
            } else {
                s8 = O.b.d(null, charSequenceExtra);
                s10 = O.b.d(null, uri);
            }
        }
        r(c1708z0, s8, s9, s10, s11);
        return true;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.title);
        dVar.g(this.mimeType);
        if (105 <= dVar.f6413Z) {
            dVar.g(this.multiple);
        }
        dVar.g(this.varContentText);
        if (84 <= dVar.f6413Z) {
            dVar.g(this.varContentSubject);
        }
        dVar.g(this.varContentUri);
        if (2 <= dVar.f6413Z) {
            dVar.g(this.varContentMimeType);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.title);
        visitor.b(this.mimeType);
        visitor.b(this.multiple);
        visitor.b(this.varContentText);
        visitor.b(this.varContentSubject);
        visitor.b(this.varContentUri);
        visitor.b(this.varContentMimeType);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.title = (InterfaceC1700x0) cVar.readObject();
        this.mimeType = (InterfaceC1700x0) cVar.readObject();
        if (105 <= cVar.f6409x0) {
            this.multiple = (InterfaceC1700x0) cVar.readObject();
        }
        this.varContentText = (J3.l) cVar.readObject();
        if (84 <= cVar.f6409x0) {
            this.varContentSubject = (J3.l) cVar.readObject();
        }
        this.varContentUri = (J3.l) cVar.readObject();
        if (2 <= cVar.f6409x0) {
            this.varContentMimeType = (J3.l) cVar.readObject();
        }
    }

    public final void r(C1708z0 c1708z0, Object obj, Object obj2, Object obj3, Object obj4) {
        J3.l lVar = this.varContentText;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        J3.l lVar2 = this.varContentSubject;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, obj2);
        }
        J3.l lVar3 = this.varContentUri;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, obj3);
        }
        J3.l lVar4 = this.varContentMimeType;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, obj4);
        }
        c1708z0.f17642x0 = this.onComplete;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_content_shared_title);
        String x7 = J3.h.x(c1708z0, this.title, null);
        String x8 = J3.h.x(c1708z0, this.mimeType, "*/*");
        Intent putExtra = C1701x1.s(c1708z0, "com.llamalab.automate.intent.action.CONTENT_SHARED", x7).putExtra("com.llamalab.automate.intent.extra.MULTIPLE", J3.h.f(c1708z0, this.multiple, false));
        IntentFilter intentFilter = new IntentFilter("com.llamalab.automate.intent.action.CONTENT_SHARED_ANNOUNCE");
        intentFilter.addDataType(x8);
        C1693v1 c1693v1 = new C1693v1(putExtra, c1708z0, ContentSharedActivity.class);
        c1708z0.w(c1693v1);
        c1693v1.m(4, intentFilter);
        return false;
    }
}
