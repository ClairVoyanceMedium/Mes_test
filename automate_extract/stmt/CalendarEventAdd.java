package com.llamalab.automate.stmt;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import com.google.android.gms.internal.play_billing.I2;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
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
import x3.C2434l;

@F3.f("calendar_event_add.html")
@F3.a(C2541R.integer.ic_content_new_event)
@F3.i(C2541R.string.stmt_calendar_event_add_title)
@F3.h(C2541R.string.stmt_calendar_event_add_summary)
@F3.e(C2541R.layout.stmt_calendar_event_add_edit)
/* loaded from: classes.dex */
public final class CalendarEventAdd extends Action implements AsyncStatement {

    /* renamed from: L1, reason: collision with root package name */
    public static final Pattern f16402L1 = Pattern.compile(CalendarContract.Calendars.CONTENT_URI + "/([0-9]+)");
    public InterfaceC1700x0 accessLevel;
    public InterfaceC1700x0 attendees;
    public InterfaceC1700x0 availability;
    public InterfaceC1700x0 beginTimestamp;
    public InterfaceC1700x0 calendarUri;
    public InterfaceC1700x0 color;
    public InterfaceC1700x0 description;
    public InterfaceC1700x0 endTimestamp;
    public InterfaceC1700x0 locationName;
    public InterfaceC1700x0 reminderMethod;
    public InterfaceC1700x0 reminderPeriod;
    public InterfaceC1700x0 timeZone;
    public InterfaceC1700x0 title;
    public J3.l varEventUri;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final ContentValues f16403L1;

        /* renamed from: M1, reason: collision with root package name */
        public final ContentValues f16404M1;

        /* renamed from: N1, reason: collision with root package name */
        public final ContentValues[] f16405N1;

        public a(ContentValues contentValues, ContentValues contentValues2, ContentValues[] contentValuesArr) {
            this.f16403L1 = contentValues;
            this.f16404M1 = contentValues2;
            this.f16405N1 = contentValuesArr;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            Uri uri;
            ContentResolver contentResolver = this.f15400Y.getContentResolver();
            int i8 = Build.VERSION.SDK_INT;
            int i9 = 0;
            ContentValues contentValues = this.f16403L1;
            if (15 <= i8 && contentValues.containsKey("eventColor")) {
                int intValue = contentValues.getAsInteger("eventColor").intValue();
                uri = CalendarContract.Colors.CONTENT_URI;
                Cursor query = contentResolver.query(uri, new String[]{"color", "color_index"}, "color_type=1", null, null);
                String str = null;
                if (query != null) {
                    int red = Color.red(intValue);
                    int green = Color.green(intValue);
                    int blue = Color.blue(intValue);
                    double d8 = Double.MAX_VALUE;
                    while (query.moveToNext()) {
                        try {
                            int i10 = query.getInt(i9);
                            int red2 = Color.red(i10);
                            long j8 = (red + red2) / 2;
                            String str2 = str;
                            int i11 = red;
                            long j9 = red - red2;
                            long j10 = (((j8 + 512) * j9) * j9) >> 8;
                            long green2 = green - Color.green(i10);
                            long j11 = (4 * green2 * green2) + j10;
                            long j12 = 767 - j8;
                            long blue2 = blue - Color.blue(i10);
                            double sqrt = Math.sqrt(j11 + (((j12 * blue2) * blue2) >> 8));
                            if (sqrt < d8) {
                                d8 = sqrt;
                                str = query.getString(1);
                            } else {
                                str = str2;
                            }
                            red = i11;
                            i9 = 0;
                        } finally {
                            query.close();
                        }
                    }
                }
                if (str != null) {
                    contentValues.put("eventColor_index", str);
                }
            }
            Uri insert = contentResolver.insert(CalendarContract.Events.CONTENT_URI, contentValues);
            ContentValues contentValues2 = this.f16404M1;
            if (contentValues2 != null) {
                contentValues2.put("event_id", Long.valueOf(ContentUris.parseId(insert)));
                contentResolver.insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
            }
            ContentValues[] contentValuesArr = this.f16405N1;
            if (contentValuesArr != null) {
                for (ContentValues contentValues3 : contentValuesArr) {
                    contentValues3.put("event_id", Long.valueOf(ContentUris.parseId(insert)));
                }
                contentResolver.bulkInsert(CalendarContract.Attendees.CONTENT_URI, contentValuesArr);
            }
            q2(insert.toString(), false);
        }
    }

    public static boolean q(long j8, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(j8);
        return calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0 && calendar.get(14) == 0;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.WRITE_CALENDAR")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_calendar_event_add);
        l8.v(this.title, 0);
        l8.v(this.description, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.calendarUri);
        dVar.g(this.beginTimestamp);
        dVar.g(this.endTimestamp);
        dVar.g(this.timeZone);
        dVar.g(this.title);
        dVar.g(this.description);
        dVar.g(this.locationName);
        if (104 <= dVar.f6413Z) {
            dVar.g(this.attendees);
        }
        if (21 <= dVar.f6413Z) {
            dVar.g(this.color);
        }
        dVar.g(this.availability);
        dVar.g(this.accessLevel);
        dVar.g(this.reminderMethod);
        dVar.g(this.reminderPeriod);
        if (43 <= dVar.f6413Z) {
            dVar.g(this.varEventUri);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.calendarUri);
        visitor.b(this.beginTimestamp);
        visitor.b(this.endTimestamp);
        visitor.b(this.timeZone);
        visitor.b(this.title);
        visitor.b(this.description);
        visitor.b(this.locationName);
        visitor.b(this.attendees);
        visitor.b(this.color);
        visitor.b(this.availability);
        visitor.b(this.accessLevel);
        visitor.b(this.reminderMethod);
        visitor.b(this.reminderPeriod);
        visitor.b(this.varEventUri);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.calendarUri = (InterfaceC1700x0) cVar.readObject();
        this.beginTimestamp = (InterfaceC1700x0) cVar.readObject();
        this.endTimestamp = (InterfaceC1700x0) cVar.readObject();
        this.timeZone = (InterfaceC1700x0) cVar.readObject();
        this.title = (InterfaceC1700x0) cVar.readObject();
        this.description = (InterfaceC1700x0) cVar.readObject();
        this.locationName = (InterfaceC1700x0) cVar.readObject();
        if (104 <= cVar.f6409x0) {
            this.attendees = (InterfaceC1700x0) cVar.readObject();
        }
        if (21 <= cVar.f6409x0) {
            this.color = (InterfaceC1700x0) cVar.readObject();
        }
        this.availability = (InterfaceC1700x0) cVar.readObject();
        this.accessLevel = (InterfaceC1700x0) cVar.readObject();
        this.reminderMethod = (InterfaceC1700x0) cVar.readObject();
        this.reminderPeriod = (InterfaceC1700x0) cVar.readObject();
        if (43 <= cVar.f6409x0) {
            this.varEventUri = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        ContentValues contentValues;
        c1708z0.q(C2541R.string.stmt_calendar_event_add_title);
        ContentValues[] contentValuesArr = null;
        String x7 = J3.h.x(c1708z0, this.calendarUri, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("calendarUri");
        }
        Matcher matcher = f16402L1.matcher(x7);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("calendarUri");
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("calendar_id", Long.valueOf(Long.parseLong(matcher.group(1))));
        TimeZone z7 = J3.h.z(c1708z0, this.timeZone, c1708z0.o());
        long t8 = J3.h.t(c1708z0, this.beginTimestamp, c1708z0.b());
        long t9 = J3.h.t(c1708z0, this.endTimestamp, 3600000 + t8);
        if (q(t8, z7) && q(t9, z7)) {
            Calendar calendar = Calendar.getInstance(z7);
            calendar.setTimeInMillis(t8);
            TimeZone timeZone = com.llamalab.safs.internal.m.f17839c;
            I2.u(calendar, timeZone);
            long timeInMillis = calendar.getTimeInMillis();
            Calendar calendar2 = Calendar.getInstance(z7);
            calendar2.setTimeInMillis(t9);
            I2.u(calendar2, timeZone);
            t9 = calendar2.getTimeInMillis();
            contentValues2.put("allDay", Boolean.TRUE);
            z7 = timeZone;
            t8 = timeInMillis;
        }
        contentValues2.put("eventTimezone", z7.getID());
        contentValues2.put("dtstart", Long.valueOf(t8));
        contentValues2.put("dtend", Long.valueOf(t9));
        String x8 = J3.h.x(c1708z0, this.title, null);
        if (x8 != null) {
            contentValues2.put("title", x8);
        }
        String x9 = J3.h.x(c1708z0, this.description, null);
        if (x9 != null) {
            contentValues2.put("description", x9);
        }
        String x10 = J3.h.x(c1708z0, this.locationName, null);
        if (x10 != null) {
            contentValues2.put("eventLocation", x10);
        }
        Integer o6 = J3.h.o(c1708z0, this.color, null);
        if (o6 != null) {
            contentValues2.put("eventColor", Integer.valueOf(o6.intValue() | (-16777216)));
        }
        Integer o8 = J3.h.o(c1708z0, this.availability, null);
        if (o8 != null) {
            if (o8.intValue() < 0 || o8.intValue() > 2) {
                throw new IllegalArgumentException("availability");
            }
            contentValues2.put("availability", o8);
        }
        Integer o9 = J3.h.o(c1708z0, this.accessLevel, null);
        if (o9 != null) {
            if (o9.intValue() < 0 || o9.intValue() > 3) {
                throw new IllegalArgumentException("access");
            }
            contentValues2.put("accessLevel", o9);
        }
        Integer o10 = J3.h.o(c1708z0, this.reminderMethod, null);
        if (o10 == null) {
            contentValues = null;
        } else {
            if (o10.intValue() < 0 || o10.intValue() > 4) {
                throw new IllegalArgumentException("reminderMethod");
            }
            contentValues = new ContentValues();
            contentValues.put("method", o10);
            Double j8 = J3.h.j(c1708z0, this.reminderPeriod);
            contentValues.put("minutes", Integer.valueOf((j8 == null || j8.doubleValue() < 60.0d) ? -1 : (int) (j8.doubleValue() / 60.0d)));
        }
        String[] w8 = J3.h.w(c1708z0, this.attendees, C2434l.f23396g);
        if (w8.length != 0) {
            contentValuesArr = new ContentValues[w8.length];
            for (int i8 = 0; i8 < w8.length; i8++) {
                String str = w8[i8];
                if (str == null) {
                    throw new NullPointerException("attendee");
                }
                ContentValues contentValues3 = new ContentValues();
                contentValuesArr[i8] = contentValues3;
                contentValues3.put("attendeeEmail", str);
            }
        }
        a aVar = new a(contentValues2, contentValues, contentValuesArr);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        J3.l lVar = this.varEventUri;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, obj);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
