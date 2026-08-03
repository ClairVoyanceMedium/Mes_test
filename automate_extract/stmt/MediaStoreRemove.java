package com.llamalab.automate.stmt;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;

@F3.f("media_store_remove.html")
@F3.a(C2541R.integer.ic_content_remove_picture)
@F3.i(C2541R.string.stmt_media_store_remove_title)
@F3.h(C2541R.string.stmt_media_store_remove_summary)
@F3.e(C2541R.layout.stmt_media_store_remove_edit)
/* loaded from: classes.dex */
public final class MediaStoreRemove extends Action implements AsyncStatement {
    public InterfaceC1700x0 path;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final com.llamalab.safs.n f16917L1;

        public a(com.llamalab.safs.n nVar) {
            this.f16917L1 = nVar;
        }

        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        public final void x2() {
            String obj = this.f16917L1.N().toString();
            if (obj.isEmpty()) {
                throw new IllegalArgumentException("path");
            }
            ContentProviderClient acquireContentProviderClient = this.f15400Y.getContentResolver().acquireContentProviderClient("media");
            try {
                Uri build = MediaStore.Files.getContentUri("external").buildUpon().appendQueryParameter("deletedata", "false").build();
                acquireContentProviderClient.delete(build, "_data = ?", new String[]{obj});
                acquireContentProviderClient.delete(build, "_data like ? escape ':'", new String[]{obj.replaceAll("([%_])", ":$1") + "/%"});
                acquireContentProviderClient.release();
                p2(null);
            } catch (Throwable th) {
                acquireContentProviderClient.release();
                throw th;
            }
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        if (30 > Build.VERSION.SDK_INT) {
            return new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_media_store_remove);
        l8.v(this.path, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.path);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.path);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.path = (InterfaceC1700x0) cVar.readObject();
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_media_store_remove_title);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.path);
        if (p8 == null) {
            throw new RequiredArgumentNullException("path");
        }
        a aVar = new a(p8);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
