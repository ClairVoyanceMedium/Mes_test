package com.llamalab.automate.stmt;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InputDialogActivity;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.Visitor;
import java.util.regex.Pattern;

@F3.f("dialog_input.html")
@F3.a(C2541R.integer.ic_dialog_input)
@F3.i(C2541R.string.stmt_dialog_input_title)
@F3.h(C2541R.string.stmt_dialog_input_summary)
@F3.e(C2541R.layout.stmt_dialog_input_edit)
/* loaded from: classes.dex */
public final class DialogInput extends ActivityDecision {
    public InterfaceC1700x0 hint;
    public InterfaceC1700x0 inputType;
    public InterfaceC1700x0 prepopulate;
    public InterfaceC1700x0 regex;
    public InterfaceC1700x0 suggestions;
    public InterfaceC1700x0 title;
    public J3.l varResultText;

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_dialog_input);
        l8.v(this.title, 0);
        l8.v(this.regex, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.IntentStatement
    public final boolean V(C1708z0 c1708z0, Intent intent) {
        Bundle bundle;
        if (21 <= Build.VERSION.SDK_INT) {
            try {
                bundle = RemoteInput.getResultsFromIntent(intent);
            } catch (NullPointerException unused) {
                bundle = null;
            }
            if (bundle != null) {
                CharSequence charSequence = bundle.getCharSequence("android.intent.extra.TEXT");
                Pattern pattern = J3.h.f4650a;
                String charSequence2 = charSequence != null ? charSequence.toString() : null;
                J3.l lVar = this.varResultText;
                if (lVar != null) {
                    c1708z0.z(lVar.f4659Y, charSequence2);
                }
                o(c1708z0, true);
                return true;
            }
        }
        D1.P.d(this, c1708z0, intent);
        return true;
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.title);
        dVar.g(this.inputType);
        dVar.g(this.regex);
        if (79 <= dVar.f6413Z) {
            dVar.g(this.hint);
        }
        if (31 <= dVar.f6413Z) {
            dVar.g(this.prepopulate);
        }
        if (103 <= dVar.f6413Z) {
            dVar.g(this.suggestions);
        }
        dVar.g(this.varResultText);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.title);
        visitor.b(this.inputType);
        visitor.b(this.regex);
        visitor.b(this.hint);
        visitor.b(this.prepopulate);
        visitor.b(this.suggestions);
        visitor.b(this.varResultText);
    }

    @Override // com.llamalab.automate.stmt.ActivityDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.title = (InterfaceC1700x0) cVar.readObject();
        this.inputType = (InterfaceC1700x0) cVar.readObject();
        InterfaceC1700x0 interfaceC1700x0 = (InterfaceC1700x0) cVar.readObject();
        this.regex = interfaceC1700x0;
        if (75 > cVar.f6409x0 && interfaceC1700x0 == null) {
            this.regex = new L3.W("(?s).*?\\S+.*");
        }
        if (79 <= cVar.f6409x0) {
            this.hint = (InterfaceC1700x0) cVar.readObject();
        }
        if (31 <= cVar.f6409x0) {
            this.prepopulate = (InterfaceC1700x0) cVar.readObject();
        }
        if (103 <= cVar.f6409x0) {
            this.suggestions = (InterfaceC1700x0) cVar.readObject();
        }
        this.varResultText = (J3.l) cVar.readObject();
    }

    @Override // com.llamalab.automate.stmt.StartActivityForResultStatement
    public final void o1(C1708z0 c1708z0, int i8, Intent intent) {
        if (-1 != i8) {
            J3.l lVar = this.varResultText;
            if (lVar != null) {
                c1708z0.z(lVar.f4659Y, null);
            }
            o(c1708z0, false);
            return;
        }
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.TEXT");
        Pattern pattern = J3.h.f4650a;
        String charSequence = charSequenceExtra != null ? charSequenceExtra.toString() : null;
        J3.l lVar2 = this.varResultText;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, charSequence);
        }
        o(c1708z0, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0128  */
    /* JADX WARN: Type inference failed for: r20v0, types: [android.content.Context, com.llamalab.automate.m2, com.llamalab.automate.z0] */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.lang.CharSequence] */
    @Override // com.llamalab.automate.A2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean r1(C1708z0 c1708z0) {
        String str;
        Pattern pattern;
        RemoteInput.Builder builder;
        String x7;
        String x8;
        String[] y7;
        Notification.Builder s8;
        int i8;
        int i9;
        c1708z0.q(C2541R.string.stmt_dialog_input_title);
        Intent intent = new Intent((Context) c1708z0, (Class<?>) InputDialogActivity.class);
        String x9 = J3.h.x(c1708z0, this.title, null);
        if (TextUtils.isEmpty(x9)) {
            str = c1708z0.getText(C2541R.string.stmt_dialog_input_title);
        } else {
            intent.putExtra("android.intent.extra.TITLE", (CharSequence) x9);
            str = x9;
        }
        int intValue = J3.h.o(c1708z0, this.inputType, 1).intValue();
        intent.putExtra("com.llamalab.automate.intent.extra.INPUT_TYPE", intValue);
        String x10 = J3.h.x(c1708z0, this.regex, null);
        if (TextUtils.isEmpty(x10)) {
            pattern = null;
        } else {
            pattern = Pattern.compile(x10);
            intent.putExtra("com.llamalab.automate.intent.extra.REGEX", pattern);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (21 <= i10 && (pattern == null || "(?s).+".equals(pattern.pattern()))) {
            if (intValue >= 0 && (intValue & 15) == 1 && (131072 & intValue) != 0 && (intValue & 28672) == 0 && (i9 = intValue & 4080) != 128 && i9 != 224) {
                builder = new RemoteInput.Builder("android.intent.extra.TEXT").setAllowFreeFormInput(true);
                x7 = J3.h.x(c1708z0, this.hint, null);
                if (!TextUtils.isEmpty(x7)) {
                    intent.putExtra("com.llamalab.automate.intent.extra.HINT", x7);
                    if (21 <= i10 && builder != null) {
                        builder.setLabel(x7);
                    }
                }
                x8 = J3.h.x(c1708z0, this.prepopulate, null);
                if (!TextUtils.isEmpty(x8)) {
                    if (pattern != null && !pattern.matcher(x8).matches()) {
                        throw new IllegalArgumentException("Pre-populate text not matching regular expression");
                    }
                    intent.putExtra("android.intent.extra.TEXT", x8);
                }
                y7 = J3.h.y(c1708z0, this.suggestions);
                if (!(y7 != null || y7.length == 0)) {
                    for (String str2 : y7) {
                        if (str2 == null) {
                            throw new IllegalArgumentException("Suggestion text null");
                        }
                        if (pattern != null && !pattern.matcher(str2).matches()) {
                            throw new IllegalArgumentException("Suggestion text not matching regular expression");
                        }
                    }
                    intent.putExtra("com.llamalab.automate.intent.extra.AUTOCOMPLETE_SUGGESTIONS", (CharSequence[]) y7);
                }
                s8 = c1708z0.s(this);
                i8 = Build.VERSION.SDK_INT;
                if (21 <= i8 && builder != null) {
                    if (y7 != null || y7.length == 0) {
                        builder.setChoices(y7);
                    } else if (!TextUtils.isEmpty(x8)) {
                        builder.setChoices(new CharSequence[]{x8});
                    }
                    s8.setLocalOnly(false);
                    Notification.WearableExtender contentIntentAvailableOffline = new Notification.WearableExtender().setContentIntentAvailableOffline(false);
                    if (24 <= i8) {
                        contentIntentAvailableOffline.setHintContentIntentLaunchesActivity(false);
                    }
                    Notification.Action.Builder addRemoteInput = new Notification.Action.Builder(C2541R.drawable.ic_check_white80_24dp, c1708z0.getText(C2541R.string.action_input), c1708z0.j2().s(1, F5.n.c(c1708z0), -1, new Intent(), true, 4)).addRemoteInput(builder.build());
                    if (24 <= i8) {
                        addRemoteInput.setAllowGeneratedReplies(false);
                    }
                    s8.addAction(addRemoteInput.build());
                    Notification.Action.WearableExtender availableOffline = new Notification.Action.WearableExtender().setAvailableOffline(false);
                    if (24 <= i8) {
                        availableOffline.setHintLaunchesActivity(false);
                    }
                    if (25 <= i8) {
                        availableOffline.setHintDisplayActionInline(true);
                    }
                    contentIntentAvailableOffline.addAction(availableOffline.extend(addRemoteInput).build());
                    s8.extend(contentIntentAvailableOffline);
                }
                c1708z0.B(intent, null, B(c1708z0), z(c1708z0), c1708z0.f(C2541R.integer.ic_dialog_input), str, s8);
                return false;
            }
        }
        builder = null;
        x7 = J3.h.x(c1708z0, this.hint, null);
        if (!TextUtils.isEmpty(x7)) {
        }
        x8 = J3.h.x(c1708z0, this.prepopulate, null);
        if (!TextUtils.isEmpty(x8)) {
        }
        y7 = J3.h.y(c1708z0, this.suggestions);
        if (!(y7 != null || y7.length == 0)) {
        }
        s8 = c1708z0.s(this);
        i8 = Build.VERSION.SDK_INT;
        if (21 <= i8) {
            if (y7 != null || y7.length == 0) {
            }
            s8.setLocalOnly(false);
            Notification.WearableExtender contentIntentAvailableOffline2 = new Notification.WearableExtender().setContentIntentAvailableOffline(false);
            if (24 <= i8) {
            }
            Notification.Action.Builder addRemoteInput2 = new Notification.Action.Builder(C2541R.drawable.ic_check_white80_24dp, c1708z0.getText(C2541R.string.action_input), c1708z0.j2().s(1, F5.n.c(c1708z0), -1, new Intent(), true, 4)).addRemoteInput(builder.build());
            if (24 <= i8) {
            }
            s8.addAction(addRemoteInput2.build());
            Notification.Action.WearableExtender availableOffline2 = new Notification.Action.WearableExtender().setAvailableOffline(false);
            if (24 <= i8) {
            }
            if (25 <= i8) {
            }
            contentIntentAvailableOffline2.addAction(availableOffline2.extend(addRemoteInput2).build());
            s8.extend(contentIntentAvailableOffline2);
        }
        c1708z0.B(intent, null, B(c1708z0), z(c1708z0), c1708z0.f(C2541R.integer.ic_dialog_input), str, s8);
        return false;
    }
}
