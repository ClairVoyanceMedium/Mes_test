package com.llamalab.automate.stmt;

import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AutomateService;
import com.llamalab.automate.AutomateTileService;
import com.llamalab.automate.C1617p1;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1590i2;
import com.llamalab.automate.InterfaceC1592j0;
import com.llamalab.automate.InterfaceC1606m2;
import com.llamalab.automate.NoOpActivity;
import com.llamalab.automate.O2;
import g4.C1827a;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import k0.RunnableC2034k;
import x3.C2424b;

/* loaded from: classes.dex */
public final class M0 extends com.llamalab.automate.W implements O2, InterfaceC1590i2, InterfaceC1592j0 {

    /* renamed from: Q1, reason: collision with root package name */
    public static final a f16885Q1 = new a();

    /* renamed from: L1, reason: collision with root package name */
    public String f16886L1;

    /* renamed from: M1, reason: collision with root package name */
    public Uri f16887M1;

    /* renamed from: N1, reason: collision with root package name */
    public String f16888N1;

    /* renamed from: O1, reason: collision with root package name */
    public boolean f16889O1;

    /* renamed from: P1, reason: collision with root package name */
    public int f16890P1;

    /* renamed from: y1, reason: collision with root package name */
    public int f16891y1;

    public class a implements Comparator<M0> {
        @Override // java.util.Comparator
        public final int compare(M0 m02, M0 m03) {
            int i8 = m02.f16891y1;
            int i9 = m03.f16891y1;
            if (i8 < i9) {
                return -1;
            }
            return i8 == i9 ? 0 : 1;
        }
    }

    public static int w2(AutomateTileService automateTileService) {
        int i8 = automateTileService.isLocked() ? 4194304 : 0;
        return automateTileService.isSecure() ? i8 | 8388608 : i8;
    }

    public static int x2(AutomateService automateService) {
        List q8 = automateService.q(M0.class);
        Collections.sort(q8, f16885Q1);
        Iterator it = q8.iterator();
        int i8 = 1;
        while (it.hasNext()) {
            int i9 = ((M0) it.next()).f16891y1;
            if (i9 != 0) {
                if (i9 != i8) {
                    break;
                }
                i8++;
            }
        }
        if (i8 > 9) {
            return 0;
        }
        return i8;
    }

    public static PendingIntent y2(Context context, InterfaceC1606m2 interfaceC1606m2, boolean z7, int i8, int i9) {
        return C2424b.g(i8, i9, context, new Intent("com.llamalab.automate.intent.action.CANCEL_TASK", C1827a.e.C0202a.a(interfaceC1606m2.G0(), interfaceC1606m2.h1(), interfaceC1606m2.g()).build(), context, AutomateService.class).putExtra("com.llamalab.automate.intent.extra.TASK_TYPE", M0.class.getName()).putExtra("com.llamalab.automate.intent.extra.TILE_DELETED", z7));
    }

    public final void A2() {
        q2(new Object[]{Boolean.FALSE, null}, false);
    }

    public final boolean B2() {
        AutomateService automateService = this.f15400Y;
        int i8 = Build.VERSION.SDK_INT;
        if (24 <= i8) {
            int i9 = this.f16891y1;
            ComponentName[] componentNameArr = AutomateTileService.f14639y0;
            if (i9 == 0 || !AutomateTileService.d(i9 - 1, automateService, this)) {
                i9 = 0;
                while (true) {
                    if (i9 >= 9) {
                        i9 = 0;
                        break;
                    }
                    boolean d8 = AutomateTileService.d(i9, automateService, this);
                    i9++;
                    if (d8) {
                        break;
                    }
                }
            }
            this.f16891y1 = i9;
            return i9 != 0;
        }
        if (1 > C4.a.f1771a) {
            if (23 > i8) {
                throw new IncapableAndroidVersionException(23, "Quick Settings tile");
            }
            if (this.f16891y1 == 0) {
                int x22 = x2(automateService);
                this.f16891y1 = x22;
                if (x22 == 0) {
                    return false;
                }
            }
            Intent putExtra = new Intent("com.llamalab.automate.tile.Automate" + this.f16891y1).putExtra("package", automateService.getPackageName()).putExtra("visible", true).putExtra("label", this.f16886L1);
            C1617p1 u8 = C1617p1.u(automateService);
            Bitmap h8 = u8.h(this.f16887M1, 0.8333333f, u8.H(), u8.G(this.f16889O1));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (!h8.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)) {
                    throw new IllegalStateException("Failed to compress bitmap");
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                h8.recycle();
                automateService.sendBroadcast(putExtra.putExtra("iconBitmap", byteArray).putExtra("onClick", y2(automateService, this, false, 0, 1207959552 | C2424b.f23370a)));
                return true;
            } catch (Throwable th) {
                h8.recycle();
                throw th;
            }
        }
        if (this.f16891y1 == 0) {
            int x23 = x2(automateService);
            this.f16891y1 = x23;
            if (x23 == 0) {
                return false;
            }
        }
        String str = this.f16886L1;
        C1617p1 u9 = C1617p1.u(automateService);
        Bitmap h9 = u9.h(this.f16887M1, 0.8333333f, u9.H(), u9.G(this.f16889O1));
        int i10 = C2424b.f23370a | 134217728;
        PendingIntent y22 = y2(automateService, this, false, 0, i10);
        PendingIntent y23 = y2(automateService, this, true, 1, i10);
        B4.b bVar = new B4.b();
        bVar.f416X = automateService.getPackageName();
        bVar.f417Y = y22;
        bVar.f418Z = null;
        bVar.f419x0 = null;
        bVar.f420x1 = null;
        bVar.f422y1 = str;
        bVar.f410L1 = null;
        bVar.f413O1 = null;
        bVar.f411M1 = 0;
        bVar.f414P1 = false;
        bVar.f412N1 = h9;
        bVar.f421y0 = y23;
        bVar.f415Q1 = false;
        if (B4.a.f408c == null) {
            B4.a.f408c = new B4.a(automateService);
        }
        B4.a.f408c.b("com.llamalab.automate.tile.Automate" + this.f16891y1, this.f16891y1, bVar);
        return true;
    }

    @Override // com.llamalab.automate.W, com.llamalab.automate.N2
    public final void F(AutomateService automateService) {
        u2();
        try {
            int i8 = Build.VERSION.SDK_INT;
            if (24 <= i8) {
                int i9 = this.f16891y1;
                if (i9 == 0) {
                    ComponentName[] componentNameArr = AutomateTileService.f14639y0;
                    return;
                }
                int i10 = i9 - 1;
                AutomateTileService.f14638x1[i10].clear();
                AutomateTileService automateTileService = AutomateTileService.f14640y1[i10].get();
                if (automateTileService != null) {
                    automateTileService.f14641X.sendEmptyMessage(0);
                }
                TileService.requestListeningState(automateService, AutomateTileService.f14639y0[i10]);
                return;
            }
            if (1 > C4.a.f1771a) {
                if (23 > i8 || this.f16891y1 == 0) {
                    return;
                }
                automateService.sendBroadcast(new Intent("com.llamalab.automate.tile.Automate" + this.f16891y1).putExtra("package", automateService.getPackageName()).putExtra("visible", false).putExtra("label", automateService.getString(C2541R.string.unknown)).putExtra("iconId", C2541R.drawable.ic_todo_white20_24dp).putExtra("iconPackage", automateService.getPackageName()));
                return;
            }
            if (this.f16891y1 != 0) {
                PendingIntent y22 = y2(automateService, this, true, 1, 536870912);
                if (y22 != null) {
                    y22.cancel();
                }
                PendingIntent y23 = y2(automateService, this, false, 0, 536870912);
                if (y23 != null) {
                    y23.cancel();
                }
                if (B4.a.f408c == null) {
                    B4.a.f408c = new B4.a(automateService);
                }
                B4.a.f408c.c(this.f16891y1, "com.llamalab.automate.tile.Automate" + this.f16891y1);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.llamalab.automate.O2
    public final void L1(AutomateTileService automateTileService) {
        try {
            Tile qsTile = automateTileService.getQsTile();
            qsTile.setLabel(this.f16886L1);
            qsTile.setIcon(C1617p1.u(automateTileService).F(this.f16889O1, this.f16887M1));
            if (29 <= Build.VERSION.SDK_INT) {
                qsTile.setSubtitle(this.f16888N1);
            }
            qsTile.setState(this.f16889O1 ? 2 : 1);
            qsTile.updateTile();
        } catch (Throwable th) {
            r2(th);
        }
    }

    @Override // com.llamalab.automate.O2
    public final /* synthetic */ void O1() {
    }

    @Override // com.llamalab.automate.InterfaceC1592j0
    public final void P0(AutomateService automateService, Intent intent) {
        boolean isKeyguardLocked;
        boolean isKeyguardSecure;
        int i8 = 0;
        if (intent.getBooleanExtra("com.llamalab.automate.intent.extra.TILE_DELETED", false)) {
            A2();
            return;
        }
        if (16 <= Build.VERSION.SDK_INT) {
            KeyguardManager keyguardManager = (KeyguardManager) automateService.getSystemService("keyguard");
            isKeyguardLocked = keyguardManager.isKeyguardLocked();
            if (isKeyguardLocked) {
                isKeyguardSecure = keyguardManager.isKeyguardSecure();
                i8 = isKeyguardSecure ? 12582912 : 4194304;
            }
        }
        z2(i8);
    }

    @Override // com.llamalab.automate.W, R3.e
    public final void Y0(R3.d dVar) {
        dVar.d(this.f15404y0);
        dVar.c(this.f16891y1);
        dVar.k(this.f16886L1);
        if (11 <= dVar.f6413Z) {
            dVar.n(this.f16887M1);
        } else {
            dVar.writeShort((char) Integer.parseInt(this.f16887M1.getPathSegments().get(1)));
        }
        if (10 <= dVar.f6413Z) {
            dVar.k(this.f16888N1);
        }
        dVar.write(this.f16889O1 ? 1 : 0);
        if (13 <= dVar.f6413Z) {
            dVar.c(this.f16890P1);
        }
    }

    @Override // com.llamalab.automate.O2
    public final void j0(AutomateTileService automateTileService) {
        z2(w2(automateTileService) | 128);
    }

    @Override // com.llamalab.automate.O2
    public final void k0(AutomateTileService automateTileService) {
        if ((this.f16890P1 & 2) != 0) {
            automateTileService.unlockAndRun(new RunnableC2034k(this, 26, automateTileService));
        } else {
            v2(automateTileService);
            z2(w2(automateTileService));
        }
    }

    @Override // com.llamalab.automate.W, R3.e
    public final void o0(R3.c cVar) {
        this.f15404y0 = cVar.b();
        this.f16891y1 = cVar.a();
        this.f16886L1 = cVar.i();
        this.f16887M1 = 11 <= cVar.f6409x0 ? cVar.m() : C1827a.h.a((char) cVar.readShort()).build();
        if (10 <= cVar.f6409x0) {
            this.f16888N1 = cVar.i();
        }
        this.f16889O1 = cVar.readBoolean();
        if (13 <= cVar.f6409x0) {
            this.f16890P1 = cVar.a();
        }
    }

    @Override // com.llamalab.automate.O2
    public final void p1() {
        A2();
    }

    public final void v2(AutomateTileService automateTileService) {
        if ((this.f16890P1 & 1) != 0) {
            Intent addFlags = new Intent(automateTileService, (Class<?>) NoOpActivity.class).addFlags(268435456);
            if (34 <= Build.VERSION.SDK_INT) {
                automateTileService.startActivityAndCollapse(PendingIntent.getActivity(automateTileService, 0, addFlags, 1342177280 | C2424b.f23370a));
            } else {
                automateTileService.startActivityAndCollapse(addFlags);
            }
        }
    }

    @Override // com.llamalab.automate.O2
    public final /* synthetic */ void z0() {
    }

    public final void z2(int i8) {
        o2(1000L, new Object[]{Boolean.TRUE, Double.valueOf(i8)});
    }
}
