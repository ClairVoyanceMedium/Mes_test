package com.llamalab.automate.stmt;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.KeyEvent;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.AbstractC1618p2;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C1710z2;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.M1;
import com.llamalab.automate.ReceiverStatement;
import com.llamalab.automate.Visitor;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import x3.C2425c;

@F3.f("media_button.html")
@F3.a(C2541R.integer.ic_av_play_over_video)
@F3.i(C2541R.string.stmt_media_button_title)
@F3.h(C2541R.string.stmt_media_button_summary)
@F3.e(C2541R.layout.stmt_media_button_edit)
/* loaded from: classes.dex */
public final class MediaButton extends ButtonAction implements ReceiverStatement {

    /* renamed from: L1, reason: collision with root package name */
    public static final int[] f16892L1;

    /* renamed from: M1, reason: collision with root package name */
    public static final int f16893M1;
    public InterfaceC1700x0 override;

    public static final class a extends AbstractC1618p2.b.a {

        /* renamed from: M1, reason: collision with root package name */
        public final AtomicBoolean f16894M1;

        /* renamed from: N1, reason: collision with root package name */
        public int f16895N1;

        /* renamed from: O1, reason: collision with root package name */
        public boolean f16896O1;

        /* renamed from: P1, reason: collision with root package name */
        public boolean f16897P1;

        public a(int i8, boolean z7) {
            super(128, 500L);
            this.f16894M1 = new AtomicBoolean();
            this.f16895N1 = i8;
            this.f16896O1 = z7;
        }

        @Override // com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void C(AutomateService automateService, long j8, long j9, long j10) {
            super.C(automateService, j8, j9, j10);
            if (this.f16894M1.compareAndSet(false, true)) {
                this.f16897P1 = C1710z2.a(C2425c.c(automateService));
                M1 A7 = automateService.A();
                if (A7.f15163Y.getAndIncrement() == 0) {
                    A7.a();
                }
                if (this.f16896O1 && A7.f15164Z.getAndIncrement() == 0) {
                    A7.f15165x0 = 0L;
                    A7.f15166y0 = 0;
                    A7.b();
                }
            }
        }

        @Override // com.llamalab.automate.AbstractC1618p2.b.a, com.llamalab.automate.AbstractC1618p2, com.llamalab.automate.N2
        public final void F(AutomateService automateService) {
            if (this.f16894M1.compareAndSet(true, false)) {
                M1 A7 = automateService.A();
                if (this.f16896O1 && A7.f15164Z.decrementAndGet() == 0) {
                    A7.d();
                }
                if (A7.f15163Y.decrementAndGet() == 0) {
                    A7.c();
                }
            }
            super.F(automateService);
        }

        @Override // com.llamalab.automate.AbstractC1618p2
        public final void e(AutomateService automateService, Intent intent) {
            int binarySearch;
            KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (keyEvent != null) {
                if (this.f16897P1) {
                    F5.n.f(this, "MediaButton action=" + keyEvent.getAction() + ", keycode=" + keyEvent.getKeyCode() + ", flags=0x" + Integer.toHexString(keyEvent.getFlags()));
                }
                if (1 != keyEvent.getAction() || (binarySearch = Arrays.binarySearch(MediaButton.f16892L1, keyEvent.getKeyCode())) < 0) {
                    return;
                }
                int i8 = 1 << binarySearch;
                int i9 = this.f16895N1;
                if (i9 == 0 || (i9 & i8) != 0) {
                    c(intent, Integer.valueOf(i8), false);
                }
            }
        }

        @Override // com.llamalab.automate.AbstractC1618p2.b, com.llamalab.automate.AbstractC1618p2, android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra("com.llamalab.automate.intent.extra.HACK", false)) {
                return;
            }
            super.onReceive(context, intent);
        }
    }

    static {
        int[] iArr = {79, 85, 86, 87, 88, 89, 90, 126, 127, 128, 129, 130, MoreOsConstants.KEY_ALTERASE};
        f16892L1 = iArr;
        f16893M1 = ((-1) << iArr.length) ^ (-1);
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        return 21 <= Build.VERSION.SDK_INT ? new E3.b[]{com.llamalab.automate.access.c.f15554o} : com.llamalab.automate.access.c.f15562w;
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_media_button);
        l8.h(this.buttons, null, C2541R.xml.media_buttons);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.ReceiverStatement
    public final boolean X1(C1708z0 c1708z0, AbstractC1618p2 abstractC1618p2, Intent intent, Object obj) {
        int intValue = ((Integer) obj).intValue();
        J3.l lVar = this.varButtonPressed;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, Double.valueOf(intValue));
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }

    @Override // com.llamalab.automate.stmt.ButtonAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        if (2 <= dVar.f6413Z) {
            dVar.g(this.override);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.buttons);
        visitor.b(this.varButtonPressed);
        visitor.b(this.override);
    }

    @Override // com.llamalab.automate.stmt.ButtonAction, com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        if (2 <= cVar.f6409x0) {
            this.override = (InterfaceC1700x0) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_media_button_title);
        int m8 = J3.h.m(c1708z0, this.buttons, 0) & f16893M1;
        boolean f8 = J3.h.f(c1708z0, this.override, false);
        a aVar = (a) c1708z0.d(a.class, this);
        if (aVar != null) {
            boolean z7 = aVar.f16896O1 != f8;
            aVar.f16895N1 = m8;
            aVar.f16896O1 = f8;
            if (z7 && aVar.f16894M1.get()) {
                M1 A7 = aVar.f16157Y.A();
                if (f8) {
                    if (A7.f15164Z.getAndIncrement() == 0) {
                        A7.f15165x0 = 0L;
                        A7.f15166y0 = 0;
                        A7.b();
                    }
                } else if (A7.f15164Z.decrementAndGet() == 0) {
                    A7.d();
                }
            }
            aVar.i0();
        } else {
            a aVar2 = new a(m8, f8);
            c1708z0.w(aVar2);
            aVar2.h("android.intent.action.MEDIA_BUTTON");
        }
        return false;
    }
}
