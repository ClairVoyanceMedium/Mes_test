package com.llamalab.automate.stmt;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AutomateNotificationListenerService;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1592j0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.S1;
import com.llamalab.automate.SendPendingIntentActivity;
import com.llamalab.automate.Visitor;
import com.llamalab.automate.fs.AutomateFileTypeDetector;
import java.util.Set;

@F3.f("notification_interact.html")
@F3.a(C2541R.integer.ic_action_notification_click)
@F3.i(C2541R.string.stmt_notification_interact_title)
@F3.h(C2541R.string.stmt_notification_interact_summary)
@F3.e(C2541R.layout.stmt_notification_interact_edit)
/* loaded from: classes.dex */
public final class NotificationInteract extends Action {
    public InterfaceC1700x0 action;
    public InterfaceC1700x0 argX;
    public InterfaceC1700x0 key;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        int i8 = Build.VERSION.SDK_INT;
        return 33 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.f15554o, com.llamalab.automate.access.c.f15547h} : 18 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.f15554o} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return new C1596k0(context).e(this.action, 1, C2541R.xml.notification_interact_captions).r(C2541R.string.caption_notification_interact).b(this.action).p(this.key, 3, '|').q(this.key).f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.key);
        if (50 <= dVar.f6413Z) {
            dVar.g(this.action);
        }
        if (100 <= dVar.f6413Z) {
            dVar.g(this.argX);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.key);
        visitor.b(this.action);
        visitor.b(this.argX);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.key = (InterfaceC1700x0) cVar.readObject();
        if (50 <= cVar.f6409x0) {
            this.action = (InterfaceC1700x0) cVar.readObject();
        }
        if (100 <= cVar.f6409x0) {
            this.argX = (InterfaceC1700x0) cVar.readObject();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0182, code lost:
    
        r2 = r2.getNotification();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01b2, code lost:
    
        r2 = r2.getNotification();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        r2 = r2.getNotification();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        r2 = r2.actions;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        r4 = r2.getRemoteInputs();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ca, code lost:
    
        r3 = r13.getAllowedDataTypes();
     */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        Notification notification;
        PendingIntent pendingIntent;
        Notification notification2;
        PendingIntent pendingIntent2;
        String[] strArr;
        String key;
        Notification notification3;
        Notification.Action[] actionArr;
        Notification.Action action;
        PendingIntent pendingIntent3;
        Intent intent;
        PendingIntent pendingIntent4;
        RemoteInput[] remoteInputs;
        boolean allowFreeFormInput;
        CharSequence[] choices;
        Set allowedDataTypes;
        String resultKey;
        String resultKey2;
        c1708z0.q(C2541R.string.stmt_notification_interact_title);
        String str = null;
        String x7 = J3.h.x(c1708z0, this.key, null);
        int m8 = J3.h.m(c1708z0, this.action, 1);
        if (m8 == 1) {
            if (x7 != null) {
                NotificationCancel.q(c1708z0.j2(), x7);
            } else if (18 <= Build.VERSION.SDK_INT) {
                AbstractStatement.j().cancelAllNotifications();
            } else {
                AutomateService j22 = c1708z0.j2();
                for (AutomateService.f fVar : j22.f14591X.values()) {
                    int i8 = Build.VERSION.SDK_INT;
                    AutomateService automateService = AutomateService.this;
                    if (26 > i8) {
                        automateService.f14581L1.removeCallbacks(fVar);
                    }
                    automateService.f14615y0.cancel(fVar.f14625Z, fVar.f14626x0);
                    fVar.a();
                    fVar.b(0);
                }
                Intent intent2 = new Intent();
                for (Object obj : j22.q(S1.class)) {
                    if (obj instanceof InterfaceC1592j0) {
                        ((InterfaceC1592j0) obj).P0(j22, intent2);
                    }
                }
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        if (m8 == 2) {
            if (x7 == null) {
                throw new RequiredArgumentNullException("key");
            }
            IncapableAndroidVersionException.b(18, "Access notification content intent");
            StatusBarNotification a8 = AbstractStatement.j().a(x7);
            if (a8 == null || notification == null || (pendingIntent = notification.contentIntent) == null) {
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
            try {
                SendPendingIntentActivity.a(pendingIntent, c1708z0, null);
            } catch (PendingIntent.CanceledException unused) {
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        if (m8 == 3) {
            if (x7 == null) {
                throw new RequiredArgumentNullException("key");
            }
            IncapableAndroidVersionException.b(18, "Access notification full screen intent");
            StatusBarNotification a9 = AbstractStatement.j().a(x7);
            if (a9 == null || notification2 == null || (pendingIntent2 = notification2.fullScreenIntent) == null) {
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
            try {
                SendPendingIntentActivity.a(pendingIntent2, c1708z0, null);
            } catch (PendingIntent.CanceledException unused2) {
            }
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        if (m8 == 4) {
            IncapableAndroidVersionException.b(23, "Mark notification as seen");
            AutomateNotificationListenerService j8 = AbstractStatement.j();
            if (x7 == null) {
                StatusBarNotification[] activeNotifications = j8.getActiveNotifications();
                int length = activeNotifications.length;
                strArr = new String[length];
                while (true) {
                    length--;
                    if (length < 0) {
                        break;
                    }
                    key = activeNotifications[length].getKey();
                    strArr[length] = key;
                }
            } else {
                strArr = new String[]{x7};
            }
            j8.setNotificationsShown(strArr);
            c1708z0.f17642x0 = this.onComplete;
            return true;
        }
        if ((268435456 & m8) == 0) {
            throw new IllegalArgumentException("action");
        }
        int i9 = m8 & (-268435457);
        if (x7 == null) {
            throw new RequiredArgumentNullException("key");
        }
        IncapableAndroidVersionException.b(18, "Access notification actions");
        StatusBarNotification a10 = AbstractStatement.j().a(x7);
        if (a10 != null && notification3 != null && actionArr != null && i9 < actionArr.length && (action = actionArr[i9]) != null) {
            pendingIntent3 = action.actionIntent;
            if (pendingIntent3 != null) {
                if (21 > Build.VERSION.SDK_INT || remoteInputs == null || remoteInputs.length == 0) {
                    intent = null;
                } else {
                    J3.a e8 = J3.h.e(c1708z0, this.argX);
                    Intent intent3 = new Intent();
                    Bundle bundle = new Bundle();
                    Intent putExtra = new Intent().putExtra("android.remoteinput.resultsData", bundle);
                    int i10 = 0;
                    while (i10 < remoteInputs.length) {
                        RemoteInput remoteInput = remoteInputs[i10];
                        String f02 = e8 != null ? J3.h.f0(str, e8.get(i10)) : str;
                        allowFreeFormInput = remoteInput.getAllowFreeFormInput();
                        if (!allowFreeFormInput) {
                            choices = remoteInput.getChoices();
                            if (choices != null && choices.length != 0) {
                                for (CharSequence charSequence : choices) {
                                    if (TextUtils.equals(charSequence, f02)) {
                                        resultKey2 = remoteInput.getResultKey();
                                        bundle.putCharSequence(resultKey2, f02);
                                        break;
                                    }
                                }
                            } else if (26 <= Build.VERSION.SDK_INT && allowedDataTypes != null && !allowedDataTypes.isEmpty() && f02 != null) {
                                String type = c1708z0.getContentResolver().getType(Uri.parse(f02));
                                if (type == null) {
                                    type = AutomateFileTypeDetector.probeContentType(f02);
                                }
                                if (type != null && allowedDataTypes.contains(type)) {
                                    String concat = "android.remoteinput.dataTypeResultsData".concat(type);
                                    Bundle bundleExtra = putExtra.getBundleExtra(concat);
                                    if (bundleExtra == null) {
                                        bundleExtra = new Bundle();
                                        putExtra.putExtra(concat, bundleExtra);
                                    }
                                    resultKey = remoteInput.getResultKey();
                                    bundleExtra.putString(resultKey, f02);
                                }
                            }
                            i10++;
                            str = null;
                        } else if (f02 != null) {
                            resultKey2 = remoteInput.getResultKey();
                            bundle.putCharSequence(resultKey2, f02);
                            break;
                            i10++;
                            str = null;
                        } else {
                            i10++;
                            str = null;
                        }
                    }
                    intent3.setClipData(ClipData.newIntent("android.remoteinput.results", putExtra));
                    intent = intent3;
                }
                pendingIntent4 = action.actionIntent;
                try {
                    SendPendingIntentActivity.a(pendingIntent4, c1708z0, intent);
                } catch (PendingIntent.CanceledException unused3) {
                }
                c1708z0.f17642x0 = this.onComplete;
                return true;
            }
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
