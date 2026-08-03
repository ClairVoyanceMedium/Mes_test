package com.llamalab.automate.stmt;

import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;

@F3.f("video_record_stop.html")
@F3.a(C2541R.integer.ic_device_access_video_stop)
@F3.i(C2541R.string.stmt_video_record_stop_title)
@F3.h(C2541R.string.stmt_video_record_stop_summary)
@F3.c(C2541R.string.caption_video_record_stop)
@F3.e(C2541R.layout.stmt_video_record_stop_edit)
/* loaded from: classes.dex */
public class VideoRecordStop extends Action {
    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_video_record_stop_title);
        c1708z0.H(t1.class);
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
