package com.llamalab.automate.stmt;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;

@F3.f("contact_query.html")
@F3.a(C2541R.integer.ic_social_phonebook)
@F3.i(C2541R.string.stmt_contact_query_title)
@F3.h(C2541R.string.stmt_contact_query_summary)
@F3.e(C2541R.layout.stmt_contact_query_edit)
/* loaded from: classes.dex */
public final class ContactQuery extends Decision {
    public InterfaceC1700x0 queryValue;
    public InterfaceC1700x0 valueType;
    public J3.l varCompany;
    public J3.l varDisplayName;
    public J3.l varEmail;
    public J3.l varGroups;
    public J3.l varNickname;
    public J3.l varPhoneNumber;
    public J3.l varPostalAddress;
    public J3.l varUri;

    public static String z(ContentResolver contentResolver, long j8, String str) {
        Cursor query = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"data1"}, "contact_id=? and mimetype=?", new String[]{Long.toString(j8), str}, "is_super_primary desc, is_primary desc");
        try {
            return query.moveToFirst() ? query.getString(0) : null;
        } finally {
            query.close();
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_CONTACTS")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 f8 = D1.P.l(context, C2541R.string.caption_contact_query).f(this.valueType, null, C2541R.xml.contact_content_types);
        f8.v(this.queryValue, 0);
        return f8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.queryValue);
        dVar.g(this.valueType);
        dVar.g(this.varDisplayName);
        if (36 <= dVar.f6413Z) {
            dVar.g(this.varNickname);
        }
        dVar.g(this.varCompany);
        dVar.g(this.varPhoneNumber);
        dVar.g(this.varEmail);
        if (31 <= dVar.f6413Z) {
            dVar.g(this.varPostalAddress);
        }
        dVar.g(this.varGroups);
        dVar.g(this.varUri);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.queryValue);
        visitor.b(this.valueType);
        visitor.b(this.varDisplayName);
        visitor.b(this.varNickname);
        visitor.b(this.varCompany);
        visitor.b(this.varPhoneNumber);
        visitor.b(this.varEmail);
        visitor.b(this.varPostalAddress);
        visitor.b(this.varGroups);
        visitor.b(this.varUri);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.queryValue = (InterfaceC1700x0) cVar.readObject();
        this.valueType = (InterfaceC1700x0) cVar.readObject();
        this.varDisplayName = (J3.l) cVar.readObject();
        if (36 <= cVar.f6409x0) {
            this.varNickname = (J3.l) cVar.readObject();
        }
        this.varCompany = (J3.l) cVar.readObject();
        this.varPhoneNumber = (J3.l) cVar.readObject();
        this.varEmail = (J3.l) cVar.readObject();
        if (31 <= cVar.f6409x0) {
            this.varPostalAddress = (J3.l) cVar.readObject();
        }
        this.varGroups = (J3.l) cVar.readObject();
        this.varUri = (J3.l) cVar.readObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e8 A[Catch: all -> 0x00fc, TRY_LEAVE, TryCatch #2 {all -> 0x00fc, blocks: (B:29:0x00e2, B:31:0x00e8, B:35:0x0100), top: B:28:0x00e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ff  */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        String str;
        Uri uri;
        String[] strArr;
        String[] strArr2;
        String p8;
        Uri withAppendedPath;
        String[] strArr3;
        Cursor query;
        String z7;
        String str2;
        J3.a aVar;
        String str3;
        String str4;
        boolean z8;
        String str5;
        String str6;
        String str7;
        J3.a aVar2;
        c1708z0.q(C2541R.string.stmt_contact_query_title);
        String str8 = "";
        String x7 = J3.h.x(c1708z0, this.queryValue, "");
        String str9 = null;
        String x8 = J3.h.x(c1708z0, this.valueType, null);
        if (x8 == null) {
            if (x7.startsWith("mailto:")) {
                x7 = x7.substring(7);
                x8 = "vnd.android.cursor.item/email_v2";
            } else {
                if (x7.startsWith("tel:") || x7.startsWith("mms:") || x7.startsWith("sms:")) {
                    x7 = x7.substring(4);
                } else if (x7.startsWith("content:")) {
                    x8 = "vnd.android.cursor.item/contact";
                }
                x8 = "vnd.android.cursor.item/phone_v2";
            }
        }
        if (TextUtils.isEmpty(x7)) {
            str7 = null;
            str6 = null;
            z7 = null;
            str5 = null;
            str4 = null;
            aVar2 = null;
            str3 = null;
            z8 = false;
        } else {
            try {
                if ("vnd.android.cursor.item/contact".equals(x8)) {
                    withAppendedPath = Uri.parse(x7);
                    strArr3 = new String[]{"_id", "lookup", "display_name"};
                } else if ("vnd.android.cursor.item/phone_v2".equals(x8)) {
                    if (21 <= Build.VERSION.SDK_INT) {
                        String[] strArr4 = w3.n.f23254a;
                        p8 = PhoneNumberUtils.normalizeNumber(x7);
                    } else {
                        p8 = w3.n.p(x7);
                    }
                    withAppendedPath = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(p8));
                    strArr3 = new String[]{"_id", "lookup", "display_name"};
                } else {
                    str = "mimetype=? and data1 glob ?";
                    uri = ContactsContract.Data.CONTENT_URI;
                    strArr = new String[]{x8, x7};
                    strArr2 = new String[]{"contact_id", "lookup", "display_name"};
                    ContentResolver contentResolver = c1708z0.getContentResolver();
                    query = contentResolver.query(uri, strArr2, str, strArr, null);
                    if (query.moveToFirst()) {
                        w(c1708z0, false, null, null, null, null, null, null, null, null);
                        return true;
                    }
                    long j8 = query.getLong(0);
                    String uri2 = ContactsContract.Contacts.CONTENT_LOOKUP_URI.buildUpon().appendEncodedPath(query.getString(1)).appendEncodedPath(Long.toString(j8)).build().toString();
                    String string = query.getString(2);
                    query.close();
                    String z9 = z(contentResolver, j8, "vnd.android.cursor.item/nickname");
                    String z10 = z(contentResolver, j8, "vnd.android.cursor.item/organization");
                    z7 = z(contentResolver, j8, "vnd.android.cursor.item/phone_v2");
                    String z11 = z(contentResolver, j8, "vnd.android.cursor.item/email_v2");
                    String z12 = z(contentResolver, j8, "vnd.android.cursor.item/postal-address_v2");
                    query = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"data1"}, "contact_id=? and mimetype=?", new String[]{Long.toString(j8), "vnd.android.cursor.item/group_membership"}, null);
                    try {
                        if (query.moveToFirst()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("_id");
                            sb.append(" in (");
                            while (true) {
                                sb.append(str8);
                                str2 = z10;
                                sb.append(query.getLong(0));
                                str8 = ",";
                                if (!query.moveToNext()) {
                                    break;
                                }
                                z10 = str2;
                            }
                            sb.append(')');
                            String sb2 = sb.toString();
                            query.close();
                            query = contentResolver.query(ContactsContract.Groups.CONTENT_URI, new String[]{"title"}, sb2, null, "title");
                            try {
                                if (query.moveToFirst()) {
                                    int count = query.getCount();
                                    Object[] objArr = new Object[count];
                                    do {
                                        objArr[query.getPosition()] = query.getString(0);
                                    } while (query.moveToNext());
                                    aVar = new J3.a(count, objArr);
                                    str3 = uri2;
                                    str4 = z12;
                                    z8 = true;
                                    str5 = z11;
                                    str6 = str2;
                                    str7 = z9;
                                    aVar2 = aVar;
                                    str9 = string;
                                } else {
                                    query.close();
                                }
                            } finally {
                            }
                        } else {
                            query.close();
                            str2 = z10;
                        }
                        aVar = null;
                        str3 = uri2;
                        str4 = z12;
                        z8 = true;
                        str5 = z11;
                        str6 = str2;
                        str7 = z9;
                        aVar2 = aVar;
                        str9 = string;
                    } finally {
                    }
                }
                if (query.moveToFirst()) {
                }
            } finally {
            }
            uri = withAppendedPath;
            strArr2 = strArr3;
            str = null;
            strArr = null;
            ContentResolver contentResolver2 = c1708z0.getContentResolver();
            query = contentResolver2.query(uri, strArr2, str, strArr, null);
        }
        w(c1708z0, z8, str9, str7, str6, z7, str5, str4, aVar2, str3);
        return true;
    }

    public final void w(C1708z0 c1708z0, boolean z7, String str, String str2, String str3, String str4, String str5, String str6, J3.a aVar, String str7) {
        J3.l lVar = this.varDisplayName;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, str);
        }
        J3.l lVar2 = this.varNickname;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, str2);
        }
        J3.l lVar3 = this.varCompany;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, str3);
        }
        J3.l lVar4 = this.varPhoneNumber;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, str4);
        }
        J3.l lVar5 = this.varEmail;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, str5);
        }
        J3.l lVar6 = this.varPostalAddress;
        if (lVar6 != null) {
            c1708z0.z(lVar6.f4659Y, str6);
        }
        J3.l lVar7 = this.varGroups;
        if (lVar7 != null) {
            c1708z0.z(lVar7.f4659Y, aVar);
        }
        J3.l lVar8 = this.varUri;
        if (lVar8 != null) {
            c1708z0.z(lVar8.f4659Y, str7);
        }
        o(c1708z0, z7);
    }
}
