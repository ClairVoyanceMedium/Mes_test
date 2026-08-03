package com.llamalab.automate.stmt;

import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("image_unload.html")
@F3.a(C2541R.integer.ic_image_not_supported)
@F3.i(C2541R.string.stmt_image_unload_title)
@F3.h(C2541R.string.stmt_image_unload_summary)
@F3.e(C2541R.layout.stmt_image_unload_edit)
/* loaded from: classes.dex */
public final class ImageUnload extends Action {
    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_image_unload_title);
        c1708z0.H(O.class);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
