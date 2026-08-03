package com.llamalab.automate.stmt;

import G1.C0970d;
import G1.C0971e;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.SystemClock;
import android.util.Log;
import androidx.appcompat.widget.C1231k;
import com.llamalab.android.util.GoogleApiException;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1625r2;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.IntentStatement;
import com.llamalab.automate.InterfaceC1622q2;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import i1.AbstractC1929p;
import j1.C1988p;
import java.util.ArrayList;
import x3.C2424b;
import x3.C2425c;
import z1.C2478a;
import z1.C2488k;

@F3.f("location_at.html")
@F3.a(C2541R.integer.ic_location_place)
@F3.i(C2541R.string.stmt_location_at_title)
@F3.h(C2541R.string.stmt_location_at_summary)
@F3.e(C2541R.layout.stmt_location_at_edit)
/* loaded from: classes.dex */
public final class LocationAt extends IntermittentDecision implements IntentStatement, InterfaceC1622q2 {

    /* renamed from: L1, reason: collision with root package name */
    public int f16849L1 = -1;
    public InterfaceC1700x0 latitude;
    public InterfaceC1700x0 longitude;
    public InterfaceC1700x0 radius;
    public InterfaceC1700x0 responsiveness;

    public static void B(C1708z0 c1708z0, boolean z7) {
        try {
            PendingIntent e8 = c1708z0.e("com.llamalab.automate.intent.action.GEOFENCE", null, C2424b.f23371b | 536870912);
            if (e8 != null) {
                if (z7) {
                    ((AlarmManager) c1708z0.getSystemService("alarm")).cancel(e8);
                }
                int i8 = G1.g.f3928a;
                C2488k c2488k = new C2488k(c1708z0);
                AbstractC1929p.a aVar = new AbstractC1929p.a();
                aVar.f19692a = new C2478a(1, e8);
                aVar.f19695d = 2425;
                c2488k.c(1, aVar.a());
                e8.cancel();
            }
        } catch (Throwable th) {
            Log.w("LocationAt", "Cleanup failed", th);
        }
    }

    public static void C(C1708z0 c1708z0, boolean z7) {
        try {
            PendingIntent e8 = c1708z0.e("com.llamalab.automate.intent.action.PROXIMITY_ALERT", null, C2424b.f23371b | 536870912);
            if (e8 != null) {
                if (z7) {
                    ((AlarmManager) c1708z0.getSystemService("alarm")).cancel(e8);
                }
                ((LocationManager) c1708z0.getSystemService("location")).removeProximityAlert(e8);
                e8.cancel();
            }
        } catch (Throwable th) {
            Log.w("LocationAt", "Cleanup failed", th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
    
        if (r1 != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void D(C1708z0 c1708z0, PendingIntent pendingIntent) {
        boolean canScheduleExactAlarms;
        long elapsedRealtime = SystemClock.elapsedRealtime() + 15000;
        AlarmManager alarmManager = (AlarmManager) c1708z0.getSystemService("alarm");
        int i8 = Build.VERSION.SDK_INT;
        if (31 <= i8) {
            canScheduleExactAlarms = alarmManager.canScheduleExactAlarms();
        }
        if (23 <= i8) {
            alarmManager.setExactAndAllowWhileIdle(2, elapsedRealtime, pendingIntent);
            return;
        }
        if (19 <= i8) {
            alarmManager.setExact(2, elapsedRealtime, pendingIntent);
            return;
        }
        if (23 <= Build.VERSION.SDK_INT) {
            alarmManager.setAndAllowWhileIdle(2, elapsedRealtime, pendingIntent);
        } else {
            alarmManager.set(2, elapsedRealtime, pendingIntent);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final void C1(C1708z0 c1708z0) {
        boolean z7 = J1(1) == 0;
        B(c1708z0, z7);
        C(c1708z0, z7);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return (31 > i8 || J1(1) != 0) ? 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_FINE_LOCATION")} : new E3.b[]{com.llamalab.automate.access.c.f15557r, com.llamalab.automate.access.c.j("android.permission.ACCESS_BACKGROUND_LOCATION")};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 c1596k0 = new C1596k0(context);
        c1596k0.j(this, 1, C2541R.string.caption_location_at_immediate, C2541R.string.caption_location_at_change);
        c1596k0.w(3, this.latitude);
        return c1596k0.c(4, this.longitude).f16030c;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x005a  */
    @Override // com.llamalab.automate.IntentStatement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        ArrayList arrayList;
        ArrayList arrayList2;
        C0970d c0970d;
        boolean z7;
        String str;
        boolean a8 = C1710z2.a(C2425c.c(c1708z0));
        boolean z8 = J1(1) == 0;
        int i8 = this.f16849L1;
        Boolean bool = i8 != -1 ? (Boolean) c1708z0.j(i8) : null;
        String action = intent.getAction();
        if (!"com.llamalab.automate.intent.action.GEOFENCE".equals(action)) {
            if ("com.llamalab.automate.intent.action.PROXIMITY_ALERT".equals(action)) {
                boolean booleanExtra = intent.getBooleanExtra("entering", false);
                if (a8) {
                    c1708z0.p("LocationAt ACTION_PROXIMITY_ALERT: entering=" + booleanExtra + ", lastState=" + bool);
                }
                if (z8) {
                    C(c1708z0, true);
                    o(c1708z0, booleanExtra);
                    return true;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - intent.getLongExtra("com.llamalab.automate.intent.extra.REQUEST_TIME", elapsedRealtime) > 10000 || (bool != null && bool.booleanValue() != booleanExtra)) {
                    C(c1708z0, false);
                    Boolean valueOf = Boolean.valueOf(booleanExtra);
                    int i9 = this.f16849L1;
                    if (i9 != -1) {
                        c1708z0.z(i9, valueOf);
                    }
                    o(c1708z0, booleanExtra);
                    return true;
                }
            }
            return false;
        }
        int intExtra = intent.getIntExtra("gms_error_code", -1);
        int intExtra2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra2 != -1) {
            if (intExtra2 != 1 && intExtra2 != 2) {
                if (intExtra2 == 4) {
                    intExtra2 = 4;
                }
            }
            arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
            if (arrayList != null) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList(arrayList.size());
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    byte[] bArr = (byte[]) arrayList.get(i10);
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    z1.G createFromParcel = z1.G.CREATOR.createFromParcel(obtain);
                    obtain.recycle();
                    arrayList2.add(createFromParcel);
                    i10++;
                    arrayList = arrayList;
                }
            }
            c0970d = (arrayList2 == null || intExtra != -1) ? new C0970d(intExtra, intExtra2, arrayList2) : null;
            if (c0970d != null) {
                int i11 = c0970d.f3921a;
                if (i11 != -1) {
                    B(c1708z0, z8);
                    StringBuilder sb = new StringBuilder("addGeofence failed: ");
                    switch (i11) {
                        case 1000:
                            str = "GEOFENCE_NOT_AVAILABLE";
                            break;
                        case 1001:
                            str = "GEOFENCE_TOO_MANY_GEOFENCES";
                            break;
                        case 1002:
                            str = "GEOFENCE_TOO_MANY_PENDING_INTENTS";
                            break;
                        case 1003:
                        default:
                            if (i11 == -1) {
                                str = "SUCCESS_CACHE";
                                break;
                            } else if (i11 == 0) {
                                str = "SUCCESS";
                                break;
                            } else if (i11 == 10) {
                                str = "DEVELOPER_ERROR";
                                break;
                            } else if (i11 == 1500) {
                                str = "DRIVE_EXTERNAL_STORAGE_REQUIRED";
                                break;
                            } else {
                                switch (i11) {
                                    case 2:
                                        str = "SERVICE_VERSION_UPDATE_REQUIRED";
                                        break;
                                    case 3:
                                        str = "SERVICE_DISABLED";
                                        break;
                                    case 4:
                                        str = "SIGN_IN_REQUIRED";
                                        break;
                                    case 5:
                                        str = "INVALID_ACCOUNT";
                                        break;
                                    case 6:
                                        str = "RESOLUTION_REQUIRED";
                                        break;
                                    case 7:
                                        str = "NETWORK_ERROR";
                                        break;
                                    case 8:
                                        str = "INTERNAL_ERROR";
                                        break;
                                    default:
                                        switch (i11) {
                                            case 12:
                                                str = "DATE_INVALID";
                                                break;
                                            case 13:
                                                str = "ERROR";
                                                break;
                                            case 14:
                                                str = "INTERRUPTED";
                                                break;
                                            case 15:
                                                str = "TIMEOUT";
                                                break;
                                            case 16:
                                                str = "CANCELED";
                                                break;
                                            case 17:
                                                str = "API_NOT_CONNECTED";
                                                break;
                                            default:
                                                str = Integer.toString(i11);
                                                break;
                                        }
                                }
                            }
                        case 1004:
                            str = "GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION";
                            break;
                        case 1005:
                            str = "GEOFENCE_REQUEST_TOO_FREQUENT";
                            break;
                    }
                    sb.append(str);
                    throw new GoogleApiException(sb.toString());
                }
                int i12 = c0970d.f3922b;
                if (i12 != -1 && (i12 & 1) != 0) {
                    z7 = true;
                    if (a8) {
                        c1708z0.p("LocationAt ACTION_GEOFENCE: entering=" + z7 + ", lastState=" + bool);
                    }
                    if (z8) {
                        B(c1708z0, true);
                        o(c1708z0, z7);
                        return true;
                    }
                    B(c1708z0, false);
                    Boolean valueOf2 = Boolean.valueOf(z7);
                    int i13 = this.f16849L1;
                    if (i13 != -1) {
                        c1708z0.z(i13, valueOf2);
                    }
                    o(c1708z0, z7);
                    return true;
                }
            }
            z7 = false;
            if (a8) {
            }
            if (z8) {
            }
        }
        intExtra2 = -1;
        arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList != null) {
        }
        if (arrayList2 == null) {
        }
        if (c0970d != null) {
        }
        z7 = false;
        if (a8) {
        }
        if (z8) {
        }
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.latitude);
        dVar.g(this.longitude);
        dVar.g(this.radius);
        if (87 <= dVar.f6413Z) {
            dVar.g(this.responsiveness);
        }
    }

    @Override // com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.latitude);
        visitor.b(this.longitude);
        visitor.b(this.radius);
        visitor.b(this.responsiveness);
    }

    @Override // com.llamalab.automate.InterfaceC1622q2
    public final void b(C1625r2 c1625r2) {
        if (4 <= c1625r2.f16204b) {
            this.f16849L1 = c1625r2.d(false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final C2 e0() {
        return new ViewOnClickListenerC1634b0();
    }

    @Override // com.llamalab.automate.stmt.IntermittentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.latitude = (InterfaceC1700x0) cVar.readObject();
        this.longitude = (InterfaceC1700x0) cVar.readObject();
        this.radius = (InterfaceC1700x0) cVar.readObject();
        if (87 <= cVar.f6409x0) {
            this.responsiveness = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        boolean z7;
        c1708z0.q(C2541R.string.stmt_location_at_title);
        Double j8 = J3.h.j(c1708z0, this.latitude);
        if (j8 == null) {
            throw new RequiredArgumentNullException("latitude");
        }
        Double j9 = J3.h.j(c1708z0, this.longitude);
        if (j9 == null) {
            throw new RequiredArgumentNullException("longitude");
        }
        float l8 = J3.h.l(c1708z0, this.radius, 250.0f);
        int e8 = (int) y4.j.e(J3.h.t(c1708z0, this.responsiveness, 30000L), 5000L, 2147483647L);
        boolean z8 = J1(1) == 0;
        SharedPreferences c8 = C2425c.c(c1708z0);
        boolean a8 = C1710z2.a(c8);
        if (c8.getBoolean("gmsLocation", false)) {
            if (a8) {
                c1708z0.p("LocationAt Using Google Play services: immediate=" + z8);
            }
            ArrayList arrayList = new ArrayList();
            int i8 = (z8 ? 3 : 0) & 7;
            double doubleValue = j8.doubleValue();
            double doubleValue2 = j9.doubleValue();
            C1988p.a("Invalid latitude: " + doubleValue, doubleValue >= -90.0d && doubleValue <= 90.0d);
            C1988p.a("Invalid longitude: " + doubleValue2, doubleValue2 >= -180.0d && doubleValue2 <= 180.0d);
            C1988p.a("Invalid radius: " + l8, l8 > 0.0f);
            int i9 = z8 ? 100 : e8;
            String uri = F5.n.c(c1708z0).toString();
            C1988p.i(uri, "Request ID can't be set to null");
            if (i9 < 0) {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
            boolean z9 = z8;
            z7 = false;
            arrayList.add(new z1.G(uri, 3, (short) 1, doubleValue, doubleValue2, l8, -1L, i9, -1));
            C1988p.a("No geofence has been added to this request.", !arrayList.isEmpty());
            C0971e c0971e = new C0971e(i8, "", null, arrayList);
            Bundle bundle = new Bundle();
            bundle.putLong("com.llamalab.automate.intent.extra.REQUEST_TIME", SystemClock.elapsedRealtime());
            PendingIntent e9 = c1708z0.e("com.llamalab.automate.intent.action.GEOFENCE", bundle, C2424b.f23371b | 134217728);
            if (z9) {
                D(c1708z0, e9);
            }
            int i10 = G1.g.f3928a;
            C2488k c2488k = new C2488k(c1708z0);
            C0971e c0971e2 = new C0971e(c0971e.f3925Y, c0971e.f3926Z, c2488k.f19140b, c0971e.f3924X);
            AbstractC1929p.a aVar = new AbstractC1929p.a();
            aVar.f19692a = new C1231k(c0971e2, 10, e9);
            aVar.f19695d = 2424;
            N1.t c9 = c2488k.c(1, aVar.a());
            I i11 = new I(a8);
            c1708z0.w(i11);
            c9.n(i11);
        } else {
            boolean z10 = z8;
            z7 = false;
            if (a8) {
                c1708z0.p("LocationAt Using proximity alert: immediate=" + z10);
            }
            LocationManager locationManager = (LocationManager) c1708z0.getSystemService("location");
            Bundle bundle2 = new Bundle();
            bundle2.putLong("com.llamalab.automate.intent.extra.REQUEST_TIME", SystemClock.elapsedRealtime());
            PendingIntent e10 = c1708z0.e("com.llamalab.automate.intent.action.PROXIMITY_ALERT", bundle2, C2424b.f23371b | 134217728);
            locationManager.addProximityAlert(j8.doubleValue(), j9.doubleValue(), l8, -1L, e10);
            if (z10) {
                D(c1708z0, e10);
            }
        }
        return z7;
    }
}
