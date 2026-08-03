package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.util.Log;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import x3.C2425c;
import x3.C2440r;

@F3.f("shortcut_update.html")
@F3.i(C2541R.string.stmt_shortcut_update_title)
@F3.h(C2541R.string.stmt_shortcut_update_summary)
@F3.e(C2541R.layout.stmt_shortcut_update_edit)
/* loaded from: classes.dex */
public final class ShortcutUpdate extends ShortcutDecision implements AsyncStatement {
    public InterfaceC1700x0 shortcutId;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final ShortcutInfo f17123L1;

        public a(ShortcutInfo shortcutInfo) {
            this.f17123L1 = shortcutInfo;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
        
            r3 = r4.isPinned();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        
            if (r3 == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
        
            r3 = r4.isDynamic();
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
        
            if (r3 != false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        
            r3 = r4.isDeclaredInManifest();
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        
            if (r3 != false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        
            r0 = r2.updateShortcuts(java.util.Collections.singletonList(r0));
         */
        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void x2() {
            boolean isRequestPinShortcutSupported;
            List pinnedShortcuts;
            String id;
            String id2;
            ShortcutInfo shortcutInfo = this.f17123L1;
            try {
                ShortcutManager a8 = S.i.a(this.f15400Y.getSystemService("shortcut"));
                isRequestPinShortcutSupported = a8.isRequestPinShortcutSupported();
                if (isRequestPinShortcutSupported) {
                    pinnedShortcuts = a8.getPinnedShortcuts();
                    Iterator it = pinnedShortcuts.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ShortcutInfo a9 = X0.a(it.next());
                        id = shortcutInfo.getId();
                        id2 = a9.getId();
                        if (C2440r.h(id, id2)) {
                            break;
                        }
                    }
                }
            } catch (IllegalStateException e8) {
                Log.w("ShortcutUpdate", "updateShortcuts failed", e8);
            }
            boolean z7 = false;
            q2(Boolean.valueOf(z7), false);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        return D1.P.l(context, C2541R.string.caption_shortcut_update).o(-1, this.action).o(-1, this.className).q(this.className).o(-1, this.packageName).q(this.packageName).f16030c;
    }

    @Override // com.llamalab.automate.stmt.ShortcutDecision, com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.shortcutId);
    }

    @Override // com.llamalab.automate.stmt.ShortcutDecision, com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        super.a(visitor);
        visitor.b(this.shortcutId);
    }

    @Override // com.llamalab.automate.stmt.ShortcutDecision, com.llamalab.automate.stmt.IntentDecision, com.llamalab.automate.stmt.Decision, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.shortcutId = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_shortcut_update_title);
        IncapableAndroidVersionException.a(26);
        String x7 = J3.h.x(c1708z0, this.shortcutId, null);
        if (x7 == null) {
            throw new RequiredArgumentNullException("shortcutId");
        }
        try {
            UUID.fromString(x7);
            boolean a8 = C1710z2.a(C2425c.c(c1708z0));
            Intent w8 = w(2091644631, c1708z0, true);
            ActivityInfo resolveActivityInfo = w8.resolveActivityInfo(c1708z0.getPackageManager(), 0);
            String B7 = B(c1708z0, resolveActivityInfo);
            a aVar = new a(new ShortcutInfo.Builder(c1708z0, "flow_v2:".concat(x7)).setIntent(w8).setShortLabel(B7).setIcon(z(c1708z0, resolveActivityInfo, a8)).build());
            c1708z0.w(aVar);
            aVar.w2();
            return false;
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("shortcutId");
        }
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        o(c1708z0, ((Boolean) obj).booleanValue());
        return true;
    }
}
