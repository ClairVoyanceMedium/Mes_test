package com.llamalab.automate.stmt;

import L3.C1053s;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.util.Linkify;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.MessageDialogActivity;
import com.llamalab.automate.Visitor;

@F3.f("dialog_confirm.html")
@F3.a(C2541R.integer.ic_dialog_confirm)
@F3.i(C2541R.string.stmt_dialog_confirm_title)
@F3.h(C2541R.string.stmt_dialog_confirm_summary)
@F3.e(C2541R.layout.stmt_dialog_confirm_edit)
/* loaded from: classes.dex */
public final class DialogConfirm extends ActivityDecision {
    public InterfaceC1700x0 linkify;
    public InterfaceC1700x0 message;
    public InterfaceC1700x0 negative;
    public InterfaceC1700x0 positive;
    public InterfaceC1700x0 title;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_dialog_confirm);
        l8.v(this.title, 0);
        l8.v(this.message, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.title);
        dVar.g(this.message);
        if (90 <= dVar.f6413Z) {
            dVar.g(this.linkify);
        }
        if (5 <= dVar.f6413Z) {
            dVar.g(this.positive);
            dVar.g(this.negative);
        }
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.title);
        visitor.b(this.message);
        visitor.b(this.linkify);
        visitor.b(this.positive);
        visitor.b(this.negative);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.title = (InterfaceC1700x0) cVar.readObject();
        this.message = (InterfaceC1700x0) cVar.readObject();
        this.linkify = 90 <= cVar.f6409x0 ? (InterfaceC1700x0) cVar.readObject() : new C1053s(15);
        if (5 <= cVar.f6409x0) {
            this.positive = (InterfaceC1700x0) cVar.readObject();
            this.negative = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        o(c1708z0, -1 == i8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [android.content.Context, com.llamalab.automate.m2, com.llamalab.automate.z0] */
    /* JADX WARN: Type inference failed for: r6v13, types: [android.text.Spannable, android.text.SpannableString] */
    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        CharSequence charSequence;
        c1708z0.q(C2541R.string.stmt_dialog_confirm_title);
        Intent intent = new Intent((Context) c1708z0, (Class<?>) MessageDialogActivity.class);
        String x7 = J3.h.x(c1708z0, this.title, null);
        if (TextUtils.isEmpty(x7)) {
            charSequence = c1708z0.getText(C2541R.string.stmt_dialog_confirm_title);
        } else {
            intent.putExtra("android.intent.extra.TITLE", (CharSequence) x7);
            charSequence = x7;
        }
        String x8 = J3.h.x(c1708z0, this.message, null);
        int m8 = J3.h.m(c1708z0, this.linkify, 0) & 15;
        if (m8 != 0 && !TextUtils.isEmpty(x8)) {
            ?? spannableString = new SpannableString(x8);
            if (Linkify.addLinks((Spannable) spannableString, m8)) {
                x8 = spannableString;
            }
        }
        intent.putExtra("android.intent.extra.TEXT", (CharSequence) x8);
        CharSequence x9 = J3.h.x(c1708z0, this.positive, null);
        if (TextUtils.isEmpty(x9)) {
            x9 = c1708z0.getText(C2541R.string.action_ok);
        } else {
            intent.putExtra("com.llamalab.automate.intent.extra.POSITIVE_TEXT", x9);
        }
        String x10 = J3.h.x(c1708z0, this.negative, null);
        if (!TextUtils.isEmpty(x10)) {
            intent.putExtra("com.llamalab.automate.intent.extra.NEGATIVE_TEXT", (CharSequence) x10);
        }
        Notification.Builder contentText = c1708z0.s(this).setContentText(x8);
        int i8 = Build.VERSION.SDK_INT;
        if (16 <= i8) {
            contentText.setStyle(new Notification.BigTextStyle().setBigContentTitle(charSequence).bigText(x8));
        }
        if (21 <= i8) {
            contentText.setLocalOnly(false);
            Notification.WearableExtender contentIntentAvailableOffline = new Notification.WearableExtender().setContentIntentAvailableOffline(false);
            if (24 <= i8) {
                contentIntentAvailableOffline.setHintContentIntentLaunchesActivity(false);
            }
            Notification.Action.Builder builder = new Notification.Action.Builder(C2541R.drawable.ic_check_white80_24dp, x9, c1708z0.j2().s(1, F5.n.c(c1708z0), -1, null, false, 2));
            contentText.addAction(builder.build());
            Notification.Action.WearableExtender availableOffline = new Notification.Action.WearableExtender().setAvailableOffline(false);
            if (24 <= i8) {
                availableOffline.setHintLaunchesActivity(false);
            }
            if (25 <= i8) {
                availableOffline.setHintDisplayActionInline(true);
            }
            contentIntentAvailableOffline.addAction(availableOffline.extend(builder).build());
            contentText.extend(contentIntentAvailableOffline);
        }
        c1708z0.B(intent, null, B(c1708z0), z(c1708z0), c1708z0.f(C2541R.integer.ic_dialog_confirm), charSequence, contentText);
        return false;
    }
}
