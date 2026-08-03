package com.llamalab.automate.stmt;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.telephony.PhoneNumberUtils;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1616p0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("sms_sent.html")
@F3.a(C2541R.integer.ic_social_chat_out)
@F3.i(C2541R.string.stmt_sms_sent_title)
@F3.h(C2541R.string.stmt_sms_sent_summary)
@F3.e(C2541R.layout.stmt_sms_sent_edit)
/* loaded from: classes.dex */
public final class SmsSent extends SmsEvent implements AsyncStatement {

    public static final class a extends C1616p0 {

        /* renamed from: L1, reason: collision with root package name */
        public final String f17131L1;

        /* renamed from: M1, reason: collision with root package name */
        public final Integer f17132M1;

        /* renamed from: N1, reason: collision with root package name */
        public long f17133N1;

        public a(String str, Integer num) {
            this.f17131L1 = str;
            this.f17132M1 = num;
        }

        @Override // com.llamalab.automate.C1616p0, com.llamalab.automate.W, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            ContentResolver v22 = v2();
            Uri uri = w3.n.f23255b;
            Cursor query = v22.query(uri, new String[]{"_id"}, "type=2", null, "_id desc");
            try {
                if (query.moveToFirst()) {
                    this.f17133N1 = query.getLong(0);
                }
                query.close();
                w2(true, uri);
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }

        @Override // com.llamalab.automate.C1616p0
        public final void x2(Uri uri) {
            Double d8;
            int i8;
            try {
                Cursor query = v2().query(w3.n.f23255b, 22 <= Build.VERSION.SDK_INT ? new String[]{"_id", "address", "body", "date_sent", "sub_id"} : new String[]{"_id", "address", "body", "date_sent"}, "type=2 and _id > " + this.f17133N1, null, "_id asc");
                while (query.moveToNext()) {
                    try {
                        this.f17133N1 = query.getInt(0);
                        String string = query.getString(1);
                        String str = this.f17131L1;
                        if (str == null || (string != null && PhoneNumberUtils.compare(this.f15400Y, str, string))) {
                            Double d9 = null;
                            if (22 > Build.VERSION.SDK_INT || query.isNull(4) || (i8 = query.getInt(4)) < 0) {
                                d8 = null;
                            } else {
                                Integer num = this.f17132M1;
                                if (num == null || num.intValue() == i8) {
                                    d8 = Double.valueOf(i8);
                                }
                            }
                            String string2 = query.getString(2);
                            long j8 = query.getLong(3);
                            if (j8 > 0) {
                                double d10 = j8;
                                Double.isNaN(d10);
                                Double.isNaN(d10);
                                d9 = Double.valueOf(d10 / 1000.0d);
                            }
                            q2(new Object[]{string, string2, d9, d8}, false);
                            query.close();
                        }
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                query.close();
            } catch (Throwable th2) {
                r2(th2);
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_SMS")};
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_sms_sent_title);
        c1708z0.w(new a(J3.h.x(c1708z0, this.phoneNumber, null), J3.h.o(c1708z0, this.subscriptionId, null)));
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        q(c1708z0, (String) objArr[0], (Double) objArr[3], (String) objArr[1], (Double) objArr[2]);
        return true;
    }
}
