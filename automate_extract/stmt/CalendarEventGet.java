package com.llamalab.automate.stmt;

import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract;
import com.google.android.gms.internal.play_billing.I2;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@F3.f("calendar_event_get.html")
@F3.a(C2541R.integer.ic_content_event)
@F3.i(C2541R.string.stmt_calendar_event_get_title)
@F3.h(C2541R.string.stmt_calendar_event_get_summary)
@F3.e(C2541R.layout.stmt_calendar_event_get_edit)
/* loaded from: classes.dex */
public final class CalendarEventGet extends Action {

    /* renamed from: L1, reason: collision with root package name */
    public static final Pattern f16406L1 = Pattern.compile(CalendarContract.Events.CONTENT_URI + "/([0-9]+)(?:/EventTime/([0-9]+)/([0-9]+))?");
    public InterfaceC1700x0 eventUri;
    public J3.l varAccessLevel;
    public J3.l varAllDay;
    public J3.l varAttendees;
    public J3.l varAvailability;
    public J3.l varBeginTimestamp;
    public J3.l varCalendarUri;
    public J3.l varColor;
    public J3.l varDescription;
    public J3.l varEndTimestamp;
    public J3.l varLocationName;
    public J3.l varTimeZone;
    public J3.l varTitle;

    public static double q(String str, long j8, boolean z7, String str2) {
        if (str != null) {
            j8 = Long.parseLong(str);
        } else if (z7) {
            Calendar calendar = Calendar.getInstance(com.llamalab.safs.internal.m.f17839c);
            calendar.setTimeInMillis(j8);
            I2.u(calendar, TimeZone.getTimeZone(str2));
            j8 = calendar.getTimeInMillis();
        }
        double d8 = j8;
        Double.isNaN(d8);
        return d8 / 1000.0d;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_CALENDAR")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_calendar_event_get);
        l8.v(this.eventUri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.eventUri);
        dVar.g(this.varCalendarUri);
        dVar.g(this.varBeginTimestamp);
        dVar.g(this.varEndTimestamp);
        dVar.g(this.varAllDay);
        dVar.g(this.varTimeZone);
        dVar.g(this.varTitle);
        dVar.g(this.varDescription);
        dVar.g(this.varLocationName);
        if (104 <= dVar.f6413Z) {
            dVar.g(this.varAttendees);
        }
        if (21 <= dVar.f6413Z) {
            dVar.g(this.varColor);
        }
        dVar.g(this.varAvailability);
        dVar.g(this.varAccessLevel);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.eventUri);
        visitor.b(this.varCalendarUri);
        visitor.b(this.varBeginTimestamp);
        visitor.b(this.varEndTimestamp);
        visitor.b(this.varAllDay);
        visitor.b(this.varTimeZone);
        visitor.b(this.varTitle);
        visitor.b(this.varDescription);
        visitor.b(this.varLocationName);
        visitor.b(this.varAttendees);
        visitor.b(this.varColor);
        visitor.b(this.varAvailability);
        visitor.b(this.varAccessLevel);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.eventUri = (InterfaceC1700x0) cVar.readObject();
        this.varCalendarUri = (J3.l) cVar.readObject();
        this.varBeginTimestamp = (J3.l) cVar.readObject();
        this.varEndTimestamp = (J3.l) cVar.readObject();
        this.varAllDay = (J3.l) cVar.readObject();
        this.varTimeZone = (J3.l) cVar.readObject();
        this.varTitle = (J3.l) cVar.readObject();
        this.varDescription = (J3.l) cVar.readObject();
        this.varLocationName = (J3.l) cVar.readObject();
        if (104 <= cVar.f6409x0) {
            this.varAttendees = (J3.l) cVar.readObject();
        }
        if (21 <= cVar.f6409x0) {
            this.varColor = (J3.l) cVar.readObject();
        }
        this.varAvailability = (J3.l) cVar.readObject();
        this.varAccessLevel = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        J3.a aVar;
        c1708z0.q(C2541R.string.stmt_calendar_event_get_title);
        String x7 = J3.h.x(c1708z0, this.eventUri, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("eventUri");
        }
        Matcher matcher = f16406L1.matcher(x7);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("eventUri");
        }
        Cursor query = c1708z0.getContentResolver().query(CalendarContract.Events.CONTENT_URI.buildUpon().appendEncodedPath(matcher.group(1)).build(), new String[]{"calendar_id", "allDay", "eventTimezone", "calendar_timezone", "dtstart", "dtend", "title", "description", "eventLocation", "eventColor", "availability", "accessLevel"}, null, null, null);
        try {
            if (!query.moveToFirst()) {
                throw new IllegalArgumentException("Event not found");
            }
            if (this.varCalendarUri != null) {
                c1708z0.z(this.varCalendarUri.f4659Y, CalendarContract.Calendars.CONTENT_URI.buildUpon().appendEncodedPath(Long.toString(query.getLong(0))).toString());
            }
            boolean z7 = query.getInt(1) != 0;
            String string = query.getString(z7 ? 3 : 2);
            J3.l lVar = this.varBeginTimestamp;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, Double.valueOf(q(matcher.group(2), query.getLong(4), z7, string)));
            }
            J3.l lVar2 = this.varEndTimestamp;
            if (lVar2 != null) {
                c1708z0.z(lVar2.f4659Y, Double.valueOf(q(matcher.group(3), query.getLong(5), z7, string)));
            }
            J3.l lVar3 = this.varAllDay;
            if (lVar3 != null) {
                c1708z0.z(lVar3.f4659Y, Double.valueOf(J3.h.Y(z7)));
            }
            J3.l lVar4 = this.varTimeZone;
            if (lVar4 != null) {
                c1708z0.z(lVar4.f4659Y, string);
            }
            J3.l lVar5 = this.varTitle;
            if (lVar5 != null) {
                c1708z0.z(lVar5.f4659Y, query.getString(6));
            }
            J3.l lVar6 = this.varDescription;
            if (lVar6 != null) {
                c1708z0.z(lVar6.f4659Y, query.getString(7));
            }
            J3.l lVar7 = this.varLocationName;
            if (lVar7 != null) {
                c1708z0.z(lVar7.f4659Y, query.getString(8));
            }
            J3.l lVar8 = this.varColor;
            if (lVar8 != null) {
                c1708z0.z(lVar8.f4659Y, query.isNull(9) ? null : Double.valueOf(query.getInt(9)));
            }
            J3.l lVar9 = this.varAvailability;
            if (lVar9 != null) {
                c1708z0.z(lVar9.f4659Y, query.isNull(10) ? null : Double.valueOf(1 << query.getInt(10)));
            }
            J3.l lVar10 = this.varAccessLevel;
            if (lVar10 != null) {
                c1708z0.z(lVar10.f4659Y, query.isNull(11) ? null : Double.valueOf(query.getInt(11)));
            }
            query.close();
            if (this.varAttendees != null) {
                Cursor query2 = CalendarContract.Attendees.query(c1708z0.getContentResolver(), Long.parseLong(matcher.group(1)), new String[]{"attendeeEmail"});
                try {
                    J3.l lVar11 = this.varAttendees;
                    if (query2.moveToFirst()) {
                        J3.a aVar2 = new J3.a();
                        do {
                            String string2 = query2.getString(0);
                            if (string2 != null) {
                                aVar2.add(string2);
                            }
                        } while (query2.moveToNext());
                        aVar = aVar2.isEmpty() ? null : aVar2;
                    } else {
                        aVar = null;
                    }
                    c1708z0.z(lVar11.f4659Y, aVar);
                } finally {
                    query2.close();
                }
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }
}
