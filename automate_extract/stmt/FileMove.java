package com.llamalab.automate.stmt;

import android.content.Context;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.RequiredArgumentNullException;
import java.io.Closeable;
import java.util.HashSet;

@F3.f("file_move.html")
@F3.a(C2541R.integer.ic_storage_move)
@F3.i(C2541R.string.stmt_file_move_title)
@F3.h(C2541R.string.stmt_file_move_summary)
@F3.e(C2541R.layout.stmt_file_move_edit)
/* loaded from: classes.dex */
public class FileMove extends FileTransferAction {
    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_file_move);
        l8.t(this.sourcePath);
        C1596k0 q8 = l8.q(this.sourcePath);
        q8.t(this.targetPath);
        return q8.q(this.targetPath).y(this.recursive, C2541R.string.caption_recursive, 0).f16030c;
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_file_move_title);
        com.llamalab.safs.n p8 = J3.h.p(c1708z0, this.sourcePath);
        if (p8 == null) {
            throw new RequiredArgumentNullException("sourcePath");
        }
        com.llamalab.safs.n p9 = J3.h.p(c1708z0, this.targetPath);
        if (p9 == null) {
            throw new RequiredArgumentNullException("targetPath");
        }
        HashSet hashSet = new HashSet(3);
        hashSet.add(com.llamalab.safs.o.REPLACE_EXISTING);
        hashSet.add(P3.s.MERGE_DIRECTORIES);
        if (J3.h.f(c1708z0, this.recursive, false)) {
            hashSet.add(P3.t.f5936X);
        }
        P3.l lVar = new P3.l(p8, p9, hashSet, new Closeable[0]);
        c1708z0.w(lVar);
        lVar.w2();
        return false;
    }
}
