package com.llamalab.automate.stmt;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1616p0;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import x3.C2425c;
import x3.C2434l;

@F3.f("calendar_event_query.html")
@F3.a(C2541R.integer.ic_content_filofax)
@F3.i(C2541R.string.stmt_calendar_event_query_title)
@F3.h(C2541R.string.stmt_calendar_event_query_summary)
@F3.e(C2541R.layout.stmt_calendar_event_query_edit)
/* loaded from: classes.dex */
public final class CalendarEventQuery extends IntermittentDecision implements IntentStatement, AsyncStatement, InterfaceC1622q2 {

    /* renamed from: M1, reason: collision with root package name */
    public static final Pattern f16407M1 = Pattern.compile(CalendarContract.Calendars.CONTENT_URI + "/([0-9]+)");

    /* renamed from: N1, reason: collision with root package name */
    public static final String[] f16408N1 = {"event_id", "begin", "end"};

    /* renamed from: O1, reason: collision with root package name */
    public static final String[] f16409O1 = {"attendeeEmail"};

    /* renamed from: L1, reason: collision with root package name */
    public int f16410L1 = -1;
    public InterfaceC1700x0 attendees;
    public InterfaceC1700x0 availability;
    public InterfaceC1700x0 calendarUri;
    public InterfaceC1700x0 description;
    public InterfaceC1700x0 endOffset;
    public InterfaceC1700x0 ignoreAllDay;
    public InterfaceC1700x0 locationName;
    public InterfaceC1700x0 maxTimestamp;
    public InterfaceC1700x0 minTimestamp;
    public InterfaceC1700x0 startOffset;
    public InterfaceC1700x0 title;
    public J3.l varEventUris;

    public static final class a extends C1616p0.a {
    }

    public static boolean D(ContentProviderClient contentProviderClient, long j8, String[] strArr) {
        StringBuilder sb = new StringBuilder("event_id=");
        sb.append(j8);
        sb.append(" and attendeeEmail in (");
        int i8 = 0;
        for (String str : strArr) {
            if (str != null) {
                DatabaseUtils.appendEscapedSQLString(sb, str);
                i8++;
            }
        }
        if (i8 == 0) {
            return true;
        }
        sb.append(')');
        Cursor query = contentProviderClient.query(CalendarContract.Attendees.CONTENT_URI, f16409O1, sb.toString(), null, null);
        O.b.c("Attendees query failed", query);
        try {
            return query.getCount() > 0;
        } finally {
            query.close();
        }
    }

    public static boolean E(String str) {
        return str == null || str.length() == 0 || "*".contentEquals(str);
    }

    public static String G(Cursor cursor) {
        return CalendarContract.Events.CONTENT_URI.buildUpon().appendEncodedPath(Long.toString(cursor.getLong(0))).appendEncodedPath("EventTime").appendEncodedPath(Long.toString(cursor.getLong(1))).appendEncodedPath(Long.toString(cursor.getLong(2))).toString();
    }

    public final void B(C1708z0 c1708z0, boolean z7, J3.a aVar, boolean z8, boolean z9) {
        if (z9) {
            AbstractStatement.d(c1708z0, this, "com.llamalab.automate.intent.action.CALENDAR_EVENT_QUERY");
        }
        if (z8) {
            c1708z0.I(a.class, this.f16218X);
        }
        J3.l lVar = this.varEventUris;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, aVar);
        }
        o(c1708z0, z7);
    }

    public final boolean C(C1708z0 c1708z0, long j8, long j9, Long l8, Long l9, boolean z7, boolean z8) {
        long j10;
        ContentProviderClient contentProviderClient;
        Cursor F7;
        J3.a aVar;
        J3.a aVar2;
        boolean z9;
        C1708z0 c1708z02;
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        long t8 = J3.h.t(c1708z0, this.startOffset, 0L);
        long t9 = J3.h.t(c1708z0, this.endOffset, 0L);
        long j11 = j9 - t8;
        long j12 = j9 - t9;
        if (j11 > j12) {
            j10 = j12;
        } else {
            j11 = j12;
            j10 = j11;
        }
        long j13 = j8 < j11 ? j11 + 604800000 : j8 + 604800000;
        if (a8) {
            c1708z0.p(String.format(Locale.US, "CalendarEventQuery query %1$tFT%1$tT - %2$tFT%2$tT", Long.valueOf(j10), Long.valueOf(j13)));
        }
        String[] w8 = J3.h.w(c1708z0, this.attendees, C2434l.f23396g);
        ContentProviderClient acquireContentProviderClient = c1708z0.getContentResolver().acquireContentProviderClient("com.android.calendar");
        O.b.c("Calendar provider client", acquireContentProviderClient);
        ContentProviderClient contentProviderClient2 = acquireContentProviderClient;
        boolean z10 = false;
        try {
            F7 = F(c1708z0, contentProviderClient2, j10, j13);
            aVar = null;
            aVar2 = null;
            while (F7.moveToNext()) {
                try {
                    try {
                        if (w8.length > 0) {
                            contentProviderClient = contentProviderClient2;
                            try {
                                if (!D(contentProviderClient, F7.getLong(0), w8)) {
                                    contentProviderClient2 = contentProviderClient;
                                }
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    F7.close();
                                    throw th;
                                } catch (Throwable th2) {
                                    th = th2;
                                    contentProviderClient.release();
                                    throw th;
                                }
                            }
                        } else {
                            contentProviderClient = contentProviderClient2;
                        }
                        long j14 = F7.getLong(1) + t8;
                        long j15 = F7.getLong(2) + t9;
                        if (l8 != null && l8.longValue() == j14) {
                            if (aVar2 == null) {
                                aVar2 = new J3.a(4);
                            }
                            aVar2.add(G(F7));
                        }
                        if (l9 != null && l9.longValue() == j15) {
                            if (aVar == null) {
                                aVar = new J3.a(4);
                            }
                            aVar.add(G(F7));
                        }
                        if (j9 < j14 && j13 > j14) {
                            j13 = j14;
                        }
                        if (j9 < j15 && j13 > j15) {
                            j13 = j15;
                        }
                        contentProviderClient2 = contentProviderClient;
                    } catch (Throwable th3) {
                        th = th3;
                        contentProviderClient = contentProviderClient2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    contentProviderClient = contentProviderClient2;
                }
            }
            contentProviderClient = contentProviderClient2;
        } catch (Throwable th5) {
            th = th5;
            contentProviderClient = contentProviderClient2;
        }
        try {
            F7.close();
            contentProviderClient.release();
            if (aVar != null) {
                if (a8) {
                    c1708z02 = c1708z0;
                    z9 = true;
                    c1708z02.p("CalendarEventQuery found events ending");
                } else {
                    c1708z02 = c1708z0;
                    z9 = true;
                }
                c1708z02.z(this.f16410L1, aVar2 != null ? l8 : null);
            } else {
                z9 = true;
                c1708z0.z(this.f16410L1, null);
                if (aVar2 == null) {
                    if (a8) {
                        c1708z0.p(String.format(Locale.US, "CalendarEventQuery no events, await %1$tFT%1$tT", Long.valueOf(j13)));
                    }
                    Bundle bundle = new Bundle();
                    bundle.putLong("com.llamalab.automate.intent.extra.MATCH_MILLIS", j13);
                    AbstractStatement.m(c1708z0, 0, true, j13, 0L, "com.llamalab.automate.intent.action.CALENDAR_EVENT_QUERY", bundle);
                    if (!z7) {
                        a aVar3 = new a();
                        c1708z0.w(aVar3);
                        aVar3.w2(false, CalendarContract.Instances.CONTENT_URI);
                    }
                    return false;
                }
                if (a8) {
                    c1708z0.p("CalendarEventQuery found events starting");
                }
                aVar = aVar2;
                z10 = true;
            }
            B(c1708z0, z10, aVar, z7, z8);
            return z9;
        } catch (Throwable th6) {
            th = th6;
            contentProviderClient.release();
            throw th;
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final void C1(C1708z0 c1708z0) {
        AbstractStatement.d(c1708z0, this, "com.llamalab.automate.intent.action.CALENDAR_EVENT_QUERY");
    }

    public final Cursor F(C1708z0 c1708z0, ContentProviderClient contentProviderClient, long j8, long j9) {
        int i8;
        String x7 = J3.h.x(c1708z0, this.calendarUri, null);
        String x8 = J3.h.x(c1708z0, this.title, null);
        String x9 = J3.h.x(c1708z0, this.description, null);
        String x10 = J3.h.x(c1708z0, this.locationName, null);
        int m8 = J3.h.m(c1708z0, this.availability, 0) & 7;
        boolean f8 = J3.h.f(c1708z0, this.ignoreAllDay, false);
        Uri build = CalendarContract.Instances.CONTENT_URI.buildUpon().appendEncodedPath(Long.toString(j8)).appendEncodedPath(Long.toString(j9)).build();
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[4];
        if (x7 != null) {
            Matcher matcher = f16407M1.matcher(x7);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("calendarUri");
            }
            sb.append("calendar_id=?");
            strArr[0] = matcher.group(1);
            i8 = 1;
        } else {
            sb.append("visible=1");
            i8 = 0;
        }
        if (f8) {
            sb.append(" and allDay=0");
        }
        if (!E(x8)) {
            sb.append(" and title glob ?");
            strArr[i8] = x8;
            i8++;
        }
        if (!E(x9)) {
            sb.append(" and description glob ?");
            strArr[i8] = x9;
            i8++;
        }
        if (!E(x10)) {
            sb.append(" and eventLocation glob ?");
            strArr[i8] = x10;
            i8++;
        }
        if (m8 != 0) {
            sb.append(" and availability in (");
            String str = "";
            for (int i9 = 0; i9 < 32; i9++) {
                if (((1 << i9) & m8) != 0) {
                    sb.append(str);
                    sb.append(i9);
                    str = ",";
                }
            }
            sb.append(')');
        }
        Cursor query = contentProviderClient.query(build, f16408N1, sb.toString(), (String[]) Arrays.copyOf(strArr, i8), "begin asc, end asc");
        O.b.c("Calendar event query failed", query);
        return query;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return (31 > Build.VERSION.SDK_INT || 1 != J1(1)) ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_CALENDAR")} : new E3.b[]{com.llamalab.automate.access.c.f15557r, com.llamalab.automate.access.c.j("android.permission.READ_CALENDAR")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_calendar_event_query_immediate, C2541R.string.caption_calendar_event_query_change);
        c1596k0.v(this.title, 0);
        c1596k0.v(this.description, 0);
        c1596k0.v(this.locationName, 0);
        return c1596k0.f16030c;
    }

    @Override // com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        long b8 = c1708z0.b();
        long longExtra = intent.getLongExtra("com.llamalab.automate.intent.extra.MATCH_MILLIS", b8);
        return C(c1708z0, b8, longExtra, Long.valueOf(longExtra), Long.valueOf(longExtra), true, false);
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.calendarUri);
        dVar.g(this.minTimestamp);
        dVar.g(this.maxTimestamp);
        if (31 <= dVar.f6413Z) {
            dVar.g(this.startOffset);
            dVar.g(this.endOffset);
        }
        dVar.g(this.title);
        dVar.g(this.description);
        dVar.g(this.locationName);
        if (110 <= dVar.f6413Z) {
            dVar.g(this.attendees);
        }
        dVar.g(this.availability);
        dVar.g(this.ignoreAllDay);
        dVar.g(this.varEventUris);
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.calendarUri);
        visitor.b(this.minTimestamp);
        visitor.b(this.maxTimestamp);
        visitor.b(this.startOffset);
        visitor.b(this.endOffset);
        visitor.b(this.title);
        visitor.b(this.description);
        visitor.b(this.locationName);
        visitor.b(this.attendees);
        visitor.b(this.availability);
        visitor.b(this.ignoreAllDay);
        visitor.b(this.varEventUris);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        this.f16410L1 = c1625r2.d(false);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new C1662p();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.calendarUri = (InterfaceC1700x0) cVar.readObject();
        this.minTimestamp = (InterfaceC1700x0) cVar.readObject();
        this.maxTimestamp = (InterfaceC1700x0) cVar.readObject();
        if (31 <= cVar.f6409x0) {
            this.startOffset = (InterfaceC1700x0) cVar.readObject();
            this.endOffset = (InterfaceC1700x0) cVar.readObject();
        }
        this.title = (InterfaceC1700x0) cVar.readObject();
        this.description = (InterfaceC1700x0) cVar.readObject();
        this.locationName = (InterfaceC1700x0) cVar.readObject();
        if (110 <= cVar.f6409x0) {
            this.attendees = (InterfaceC1700x0) cVar.readObject();
        }
        this.availability = (InterfaceC1700x0) cVar.readObject();
        this.ignoreAllDay = (InterfaceC1700x0) cVar.readObject();
        this.varEventUris = (J3.l) cVar.readObject();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [long] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        long j8;
        long j9;
        ContentProviderClient contentProviderClient;
        c1708z0.q(C2541R.string.stmt_calendar_event_query_title);
        if (J1(1) != 0) {
            long b8 = c1708z0.b();
            Long l8 = (Long) c1708z0.j(this.f16410L1);
            return (l8 == null || b8 - l8.longValue() >= 60000) ? C(c1708z0, b8, b8, Long.valueOf(b8), Long.valueOf(b8), false, false) : C(c1708z0, b8, l8.longValue(), l8, null, false, false);
        }
        ContentProviderClient t8 = J3.h.t(c1708z0, this.minTimestamp, c1708z0.b());
        long t9 = J3.h.t(c1708z0, this.maxTimestamp, t8);
        if (t8 > t9) {
            B(c1708z0, false, null, false, false);
            return true;
        }
        long t10 = J3.h.t(c1708z0, this.startOffset, 0L);
        long t11 = J3.h.t(c1708z0, this.endOffset, 0L);
        long j10 = t8 - t10;
        long j11 = t9 - t11;
        if (j10 > j11) {
            j8 = j10;
            j9 = j11;
        } else {
            j8 = j11;
            j9 = j10;
        }
        String[] w8 = J3.h.w(c1708z0, this.attendees, C2434l.f23396g);
        ContentProviderClient acquireContentProviderClient = c1708z0.getContentResolver().acquireContentProviderClient("com.android.calendar");
        O.b.c("Calendar provider client", acquireContentProviderClient);
        ContentProviderClient contentProviderClient2 = acquireContentProviderClient;
        try {
            Cursor F7 = F(c1708z0, contentProviderClient2, j9, j8);
            J3.a aVar = null;
            while (F7.moveToNext()) {
                try {
                    try {
                        if (w8.length > 0) {
                            contentProviderClient = contentProviderClient2;
                            try {
                                if (!D(contentProviderClient, F7.getLong(0), w8)) {
                                    contentProviderClient2 = contentProviderClient;
                                }
                            } catch (Throwable th) {
                                th = th;
                                F7.close();
                                throw th;
                            }
                        } else {
                            contentProviderClient = contentProviderClient2;
                        }
                        long j12 = F7.getLong(1) + t10;
                        long j13 = F7.getLong(2) + t11;
                        if (j12 > j13) {
                            j12 = j13;
                            j13 = j12;
                        }
                        if (j12 <= t9 && t8 <= j13) {
                            if (this.varEventUris == null) {
                                o(c1708z0, true);
                                try {
                                    F7.close();
                                    contentProviderClient.release();
                                    return true;
                                } catch (Throwable th2) {
                                    th = th2;
                                    t8 = contentProviderClient;
                                    t8.release();
                                    throw th;
                                }
                            }
                            if (aVar == null) {
                                aVar = new J3.a(4);
                            }
                            aVar.add(G(F7));
                        }
                        contentProviderClient2 = contentProviderClient;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            ContentProviderClient contentProviderClient3 = contentProviderClient2;
            try {
                B(c1708z0, aVar != null, aVar, false, false);
                F7.close();
                contentProviderClient3.release();
                return true;
            } catch (Throwable th5) {
                th = th5;
                F7.close();
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            t8 = contentProviderClient2;
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Long l8;
        Long l9;
        long j8;
        boolean z7;
        long b8 = c1708z0.b();
        if (w8 instanceof com.llamalab.automate.D) {
            long j9 = ((Bundle) obj).getLong("com.llamalab.automate.intent.extra.MATCH_MILLIS", b8);
            j8 = j9;
            l8 = Long.valueOf(j9);
            l9 = Long.valueOf(j9);
            z7 = false;
        } else {
            if (!(w8 instanceof a)) {
                throw new ClassCastException(w8.getClass().getName());
            }
            l8 = null;
            l9 = null;
            j8 = b8;
            z7 = true;
        }
        return C(c1708z0, b8, j8, l8, l9, true, z7);
    }
}
