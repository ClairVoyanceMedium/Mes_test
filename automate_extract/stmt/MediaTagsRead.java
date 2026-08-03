package com.llamalab.automate.stmt;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import android.util.Pair;
import b0.C1286a;
import com.google.android.gms.internal.play_billing.I2;
import com.llamalab.android.util.IncapableAndroidVersionException;
import com.llamalab.automate.AbstractRunnableC1694v2;
import com.llamalab.automate.AsyncStatement;
import com.llamalab.automate.C1596k0;
import com.llamalab.automate.C1708z0;
import com.llamalab.automate.C2541R;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.RequiredArgumentNullException;
import com.llamalab.automate.Visitor;
import i4.C1951e;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import x3.C2427e;
import x3.C2429g;

@F3.f("media_tags_read.html")
@F3.a(C2541R.integer.ic_collections_labels)
@F3.i(C2541R.string.stmt_media_tags_read_title)
@F3.h(C2541R.string.stmt_media_tags_read_summary)
@F3.e(C2541R.layout.stmt_media_tags_read_edit)
/* loaded from: classes.dex */
public final class MediaTagsRead extends Action implements AsyncStatement {
    public InterfaceC1700x0 uri;
    public J3.l varAlbum;
    public J3.l varArtist;
    public J3.l varDuration;
    public J3.l varGenre;
    public J3.l varLatitude;
    public J3.l varLongitude;
    public J3.l varOrientation;
    public J3.l varReleaseDate;
    public J3.l varTitle;
    public J3.l varTrackNumber;

    public static final class a extends AbstractRunnableC1694v2 {

        /* renamed from: L1, reason: collision with root package name */
        public final Uri f16918L1;

        public a(Uri uri) {
            this.f16918L1 = uri;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0114  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void A2(MediaMetadataRetriever mediaMetadataRetriever) {
            Double valueOf;
            String extractMetadata;
            Double valueOf2;
            String extractMetadata2;
            Double valueOf3;
            String extractMetadata3;
            Double valueOf4;
            Double d8;
            Double d9;
            Double d10;
            Double d11;
            Double d12;
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(7);
            String extractMetadata5 = mediaMetadataRetriever.extractMetadata(1);
            String extractMetadata6 = mediaMetadataRetriever.extractMetadata(2);
            String extractMetadata7 = mediaMetadataRetriever.extractMetadata(6);
            String extractMetadata8 = mediaMetadataRetriever.extractMetadata(9);
            if (!TextUtils.isEmpty(extractMetadata8)) {
                if (TextUtils.isDigitsOnly(extractMetadata8)) {
                    double parseLong = Long.parseLong(extractMetadata8);
                    Double.isNaN(parseLong);
                    Double.isNaN(parseLong);
                    valueOf = Double.valueOf(parseLong / 1000.0d);
                    extractMetadata = mediaMetadataRetriever.extractMetadata(0);
                    if (!TextUtils.isEmpty(extractMetadata)) {
                        try {
                        } catch (Throwable unused) {
                        }
                        if (Pattern.compile("(\\d+)(?:\\s*/\\s*\\d+)?").matcher(extractMetadata).matches()) {
                            valueOf2 = Double.valueOf(Long.parseLong(r8.group(1)));
                            extractMetadata2 = mediaMetadataRetriever.extractMetadata(8);
                            if (!TextUtils.isEmpty(extractMetadata2)) {
                                try {
                                    Time time = new Time();
                                    time.year = Integer.parseInt(extractMetadata2);
                                    double millis = time.toMillis(true);
                                    Double.isNaN(millis);
                                    Double.isNaN(millis);
                                    valueOf3 = Double.valueOf(millis / 1000.0d);
                                } catch (Throwable unused2) {
                                }
                                extractMetadata3 = mediaMetadataRetriever.extractMetadata(5);
                                if (!TextUtils.isEmpty(extractMetadata3)) {
                                    try {
                                        double time2 = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSz", Locale.US).parse(extractMetadata3.replace("Z", "UTC")).getTime();
                                        Double.isNaN(time2);
                                        Double.isNaN(time2);
                                        valueOf4 = Double.valueOf(time2 / 1000.0d);
                                    } catch (Throwable unused3) {
                                    }
                                    if (15 <= Build.VERSION.SDK_INT) {
                                        String extractMetadata9 = mediaMetadataRetriever.extractMetadata(23);
                                        if (!TextUtils.isEmpty(extractMetadata9)) {
                                            try {
                                                Matcher matcher = Pattern.compile("([+-]\\d+(?:\\.\\d+)?)([+-]\\d+(?:\\.\\d+)?)").matcher(extractMetadata9);
                                                if (matcher.matches()) {
                                                    d8 = Double.valueOf(Double.parseDouble(matcher.group(1)));
                                                    try {
                                                        d12 = Double.valueOf(Double.parseDouble(matcher.group(2)));
                                                    } catch (Throwable unused4) {
                                                    }
                                                } else {
                                                    d8 = null;
                                                    d12 = null;
                                                }
                                                d9 = d8;
                                                d10 = d12;
                                            } catch (Throwable unused5) {
                                            }
                                            if (17 <= Build.VERSION.SDK_INT) {
                                                String extractMetadata10 = mediaMetadataRetriever.extractMetadata(24);
                                                if (!TextUtils.isEmpty(extractMetadata10)) {
                                                    try {
                                                        int parseInt = Integer.parseInt(extractMetadata10);
                                                        d11 = parseInt != 0 ? parseInt != 90 ? parseInt != 180 ? parseInt != 270 ? null : Double.valueOf(8.0d) : Double.valueOf(3.0d) : Double.valueOf(6.0d) : Double.valueOf(1.0d);
                                                    } catch (Throwable unused6) {
                                                    }
                                                    y2(extractMetadata4, extractMetadata5, extractMetadata6, extractMetadata7, valueOf, valueOf2, valueOf4, d9, d10, d11);
                                                }
                                            }
                                            d11 = null;
                                            y2(extractMetadata4, extractMetadata5, extractMetadata6, extractMetadata7, valueOf, valueOf2, valueOf4, d9, d10, d11);
                                        }
                                    }
                                    d8 = null;
                                    d9 = d8;
                                    d10 = null;
                                    if (17 <= Build.VERSION.SDK_INT) {
                                    }
                                    d11 = null;
                                    y2(extractMetadata4, extractMetadata5, extractMetadata6, extractMetadata7, valueOf, valueOf2, valueOf4, d9, d10, d11);
                                }
                                valueOf4 = valueOf3;
                                if (15 <= Build.VERSION.SDK_INT) {
                                }
                                d8 = null;
                                d9 = d8;
                                d10 = null;
                                if (17 <= Build.VERSION.SDK_INT) {
                                }
                                d11 = null;
                                y2(extractMetadata4, extractMetadata5, extractMetadata6, extractMetadata7, valueOf, valueOf2, valueOf4, d9, d10, d11);
                            }
                            valueOf3 = null;
                            extractMetadata3 = mediaMetadataRetriever.extractMetadata(5);
                            if (!TextUtils.isEmpty(extractMetadata3)) {
                            }
                            valueOf4 = valueOf3;
                            if (15 <= Build.VERSION.SDK_INT) {
                            }
                            d8 = null;
                            d9 = d8;
                            d10 = null;
                            if (17 <= Build.VERSION.SDK_INT) {
                            }
                            d11 = null;
                            y2(extractMetadata4, extractMetadata5, extractMetadata6, extractMetadata7, valueOf, valueOf2, valueOf4, d9, d10, d11);
                        }
                    }
                    valueOf2 = null;
                    extractMetadata2 = mediaMetadataRetriever.extractMetadata(8);
                    if (!TextUtils.isEmpty(extractMetadata2)) {
                    }
                    valueOf3 = null;
                    extractMetadata3 = mediaMetadataRetriever.extractMetadata(5);
                    if (!TextUtils.isEmpty(extractMetadata3)) {
                    }
                    valueOf4 = valueOf3;
                    if (15 <= Build.VERSION.SDK_INT) {
                    }
                    d8 = null;
                    d9 = d8;
                    d10 = null;
                    if (17 <= Build.VERSION.SDK_INT) {
                    }
                    d11 = null;
                    y2(extractMetadata4, extractMetadata5, extractMetadata6, extractMetadata7, valueOf, valueOf2, valueOf4, d9, d10, d11);
                }
            }
            valueOf = null;
            extractMetadata = mediaMetadataRetriever.extractMetadata(0);
            if (!TextUtils.isEmpty(extractMetadata)) {
            }
            valueOf2 = null;
            extractMetadata2 = mediaMetadataRetriever.extractMetadata(8);
            if (!TextUtils.isEmpty(extractMetadata2)) {
            }
            valueOf3 = null;
            extractMetadata3 = mediaMetadataRetriever.extractMetadata(5);
            if (!TextUtils.isEmpty(extractMetadata3)) {
            }
            valueOf4 = valueOf3;
            if (15 <= Build.VERSION.SDK_INT) {
            }
            d8 = null;
            d9 = d8;
            d10 = null;
            if (17 <= Build.VERSION.SDK_INT) {
            }
            d11 = null;
            y2(extractMetadata4, extractMetadata5, extractMetadata6, extractMetadata7, valueOf, valueOf2, valueOf4, d9, d10, d11);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(12:46|47|48|(4:89|90|(1:94)|96)|(3:85|86|(7:88|(7:53|54|55|56|57|58|59)(5:77|78|79|80|59)|70|71|72|73|74))|51|(0)(0)|70|71|72|73|74) */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00c1 A[Catch: all -> 0x00bc, TRY_LEAVE, TryCatch #12 {all -> 0x00bc, blocks: (B:86:0x00b5, B:53:0x00c1, B:56:0x00d2, B:64:0x00d9, B:67:0x00de, B:77:0x00df, B:80:0x00ee, B:83:0x00f7, B:84:0x00fa, B:79:0x00e4, B:55:0x00ca), top: B:85:0x00b5, inners: #9, #11 }] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x00df A[Catch: all -> 0x00bc, TRY_LEAVE, TryCatch #12 {all -> 0x00bc, blocks: (B:86:0x00b5, B:53:0x00c1, B:56:0x00d2, B:64:0x00d9, B:67:0x00de, B:77:0x00df, B:80:0x00ee, B:83:0x00f7, B:84:0x00fa, B:79:0x00e4, B:55:0x00ca), top: B:85:0x00b5, inners: #9, #11 }] */
        @Override // com.llamalab.automate.AbstractRunnableC1694v2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void x2() {
            MediaMetadataRetriever mediaMetadataRetriever;
            int columnIndex;
            Uri uri = this.f16918L1;
            String scheme = uri.getScheme();
            try {
                if (!"file".equals(scheme)) {
                    if (!"content".equals(scheme)) {
                        if (!"data".equals(scheme)) {
                            mediaMetadataRetriever = new MediaMetadataRetriever();
                            try {
                                mediaMetadataRetriever.setDataSource(uri.toString(), Collections.emptyMap());
                                A2(mediaMetadataRetriever);
                                return;
                            } finally {
                            }
                        }
                        Pair<String, byte[]> j8 = C2429g.j(uri);
                        String str = (String) j8.first;
                        if (str != null && str.startsWith("image/")) {
                            z2(new C1286a(new ByteArrayInputStream((byte[]) j8.second)));
                            return;
                        }
                        IncapableAndroidVersionException.b(23, "read metadata from memory");
                        mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(new C2427e(ByteBuffer.wrap((byte[]) j8.second)));
                            A2(mediaMetadataRetriever);
                            return;
                        } finally {
                        }
                    }
                    Uri uri2 = this.f16918L1;
                    ContentResolver contentResolver = this.f15400Y.getContentResolver();
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri2, "r");
                    if (openFileDescriptor == null) {
                        throw new NullPointerException("openFileDescriptor");
                    }
                    String str2 = null;
                    try {
                        Cursor query = contentResolver.query(uri2, null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.moveToFirst() && (columnIndex = query.getColumnIndex("mime_type")) != -1) {
                                    str2 = query.getString(columnIndex);
                                }
                                query.close();
                            } catch (Throwable th) {
                                query.close();
                                throw th;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    if (str2 != null) {
                        try {
                        } catch (Throwable th2) {
                            openFileDescriptor.close();
                            throw th2;
                        }
                        if (str2.startsWith("image/")) {
                            if (r4) {
                                mediaMetadataRetriever = new MediaMetadataRetriever();
                                try {
                                    mediaMetadataRetriever.setDataSource(openFileDescriptor.getFileDescriptor());
                                    A2(mediaMetadataRetriever);
                                    openFileDescriptor.close();
                                } finally {
                                }
                            } else {
                                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                                try {
                                    z2(new C1286a(fileInputStream));
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable unused2) {
                                    }
                                    openFileDescriptor.close();
                                } finally {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable unused3) {
                                    }
                                }
                            }
                            openFileDescriptor.close();
                            throw th2;
                        }
                    }
                    r4 = false;
                    if (r4) {
                    }
                    openFileDescriptor.close();
                    throw th2;
                }
                s4.d k8 = I2.k(uri.getPath(), new String[0]);
                String m8 = com.llamalab.safs.i.m(k8);
                boolean z7 = m8 != null && m8.startsWith("image/");
                com.llamalab.safs.p pVar = com.llamalab.safs.p.READ;
                if (!z7) {
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                    ParcelFileDescriptor newParcelFileDescriptor = C1951e.c(k8).newParcelFileDescriptor(k8, pVar);
                    try {
                        mediaMetadataRetriever.setDataSource(newParcelFileDescriptor.getFileDescriptor());
                        A2(mediaMetadataRetriever);
                        mediaMetadataRetriever.release();
                        newParcelFileDescriptor.close();
                        return;
                    } finally {
                        try {
                            newParcelFileDescriptor.close();
                        } catch (IOException unused4) {
                        }
                    }
                }
                InputStream k9 = com.llamalab.safs.i.k(k8);
                try {
                    z2(new C1286a(k9));
                    k9.close();
                } finally {
                    try {
                        k9.close();
                    } catch (Throwable unused5) {
                    }
                }
            } catch (IOException unused6) {
            }
        }

        public final void y2(String str, String str2, String str3, String str4, Double d8, Double d9, Double d10, Double d11, Double d12, Double d13) {
            q2(new Object[]{str, str2, str3, str4, d8, d9, d10, d11, d12, d13}, false);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x006e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void z2(C1286a c1286a) {
            double[] dArr;
            Double d8;
            Double d9;
            String c8;
            Double valueOf;
            C1286a.c d10;
            String c9 = c1286a.c("GPSLatitude");
            String c10 = c1286a.c("GPSLatitudeRef");
            String c11 = c1286a.c("GPSLongitude");
            String c12 = c1286a.c("GPSLongitudeRef");
            int i8 = 0;
            if (c9 != null && c10 != null && c11 != null && c12 != null) {
                try {
                    dArr = new double[]{C1286a.b(c9, c10), C1286a.b(c11, c12)};
                } catch (IllegalArgumentException unused) {
                    Log.w("ExifInterface", "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", c9, c10, c11, c12));
                }
                if (dArr == null) {
                    d8 = Double.valueOf(dArr[0]);
                    d9 = Double.valueOf(dArr[1]);
                } else {
                    d8 = null;
                    d9 = null;
                }
                c8 = c1286a.c("DateTime");
                if (c8 != null) {
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
                        simpleDateFormat.setTimeZone(com.llamalab.safs.internal.m.f17839c);
                        long time = simpleDateFormat.parse(c8).getTime();
                        String c13 = c1286a.c("SubSecTime");
                        if (c13 != null) {
                            try {
                                long parseLong = Long.parseLong(c13);
                                while (parseLong > 1000) {
                                    parseLong /= 10;
                                }
                                time += parseLong;
                            } catch (NumberFormatException unused2) {
                            }
                        }
                        double d11 = time;
                        Double.isNaN(d11);
                        Double.isNaN(d11);
                        valueOf = Double.valueOf(d11 / 1000.0d);
                    } catch (ParseException unused3) {
                    }
                    d10 = c1286a.d("Orientation");
                    if (d10 != null) {
                        try {
                            i8 = d10.f(c1286a.f11452f);
                        } catch (NumberFormatException unused4) {
                        }
                    }
                    y2(null, null, null, null, null, null, valueOf, d8, d9, i8 != 0 ? Double.valueOf(i8) : null);
                }
                valueOf = null;
                d10 = c1286a.d("Orientation");
                if (d10 != null) {
                }
                y2(null, null, null, null, null, null, valueOf, d8, d9, i8 != 0 ? Double.valueOf(i8) : null);
            }
            dArr = null;
            if (dArr == null) {
            }
            c8 = c1286a.c("DateTime");
            if (c8 != null) {
            }
            valueOf = null;
            d10 = c1286a.d("Orientation");
            if (d10 != null) {
            }
            y2(null, null, null, null, null, null, valueOf, d8, d9, i8 != 0 ? Double.valueOf(i8) : null);
        }
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final E3.b[] K0(Context context) {
        boolean isExternalStorageLegacy;
        int i8 = Build.VERSION.SDK_INT;
        if (30 > i8) {
            return 29 <= i8 ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_MEDIA_LOCATION"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")};
        }
        isExternalStorageLegacy = Environment.isExternalStorageLegacy();
        return isExternalStorageLegacy ? new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_MEDIA_LOCATION"), com.llamalab.automate.access.c.j("android.permission.READ_EXTERNAL_STORAGE")} : new E3.b[]{com.llamalab.automate.access.c.j("android.permission.ACCESS_MEDIA_LOCATION"), com.llamalab.automate.access.c.f15551l};
    }

    @Override // com.llamalab.automate.stmt.AbstractStatement, com.llamalab.automate.A2
    public final CharSequence M1(Context context) {
        C1596k0 l8 = D1.P.l(context, C2541R.string.caption_media_tags_read);
        l8.v(this.uri, 0);
        return l8.f16030c;
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void Y0(R3.d dVar) {
        super.Y0(dVar);
        dVar.g(this.uri);
        dVar.g(this.varTitle);
        dVar.g(this.varAlbum);
        dVar.g(this.varArtist);
        if (79 <= dVar.f6413Z) {
            dVar.g(this.varGenre);
        }
        dVar.g(this.varDuration);
        dVar.g(this.varTrackNumber);
        dVar.g(this.varReleaseDate);
        dVar.g(this.varLatitude);
        dVar.g(this.varLongitude);
        if (96 <= dVar.f6413Z) {
            dVar.g(this.varOrientation);
        }
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.T2
    public final void a(Visitor visitor) {
        visitor.b(this.onComplete);
        visitor.b(this.uri);
        visitor.b(this.varTitle);
        visitor.b(this.varAlbum);
        visitor.b(this.varArtist);
        visitor.b(this.varGenre);
        visitor.b(this.varDuration);
        visitor.b(this.varTrackNumber);
        visitor.b(this.varReleaseDate);
        visitor.b(this.varLatitude);
        visitor.b(this.varLongitude);
        visitor.b(this.varOrientation);
    }

    @Override // com.llamalab.automate.stmt.Action, com.llamalab.automate.stmt.AbstractStatement, R3.e
    public final void o0(R3.c cVar) {
        super.o0(cVar);
        this.uri = (InterfaceC1700x0) cVar.readObject();
        this.varTitle = (J3.l) cVar.readObject();
        this.varAlbum = (J3.l) cVar.readObject();
        this.varArtist = (J3.l) cVar.readObject();
        if (79 <= cVar.f6409x0) {
            this.varGenre = (J3.l) cVar.readObject();
        }
        this.varDuration = (J3.l) cVar.readObject();
        this.varTrackNumber = (J3.l) cVar.readObject();
        this.varReleaseDate = (J3.l) cVar.readObject();
        this.varLatitude = (J3.l) cVar.readObject();
        this.varLongitude = (J3.l) cVar.readObject();
        if (96 <= cVar.f6409x0) {
            this.varOrientation = (J3.l) cVar.readObject();
        }
    }

    @Override // com.llamalab.automate.A2
    public final boolean r1(C1708z0 c1708z0) {
        c1708z0.q(C2541R.string.stmt_media_tags_read_title);
        Uri g8 = J3.h.g(c1708z0, this.uri, null);
        if (g8 == null) {
            throw new RequiredArgumentNullException("uri");
        }
        a aVar = new a(g8);
        c1708z0.w(aVar);
        aVar.w2();
        return false;
    }

    @Override // com.llamalab.automate.AsyncStatement
    public final boolean w0(C1708z0 c1708z0, com.llamalab.automate.W w8, Object obj) {
        Object[] objArr = (Object[]) obj;
        J3.l lVar = this.varTitle;
        if (lVar != null) {
            c1708z0.z(lVar.f4659Y, objArr[0]);
        }
        J3.l lVar2 = this.varAlbum;
        if (lVar2 != null) {
            c1708z0.z(lVar2.f4659Y, objArr[1]);
        }
        J3.l lVar3 = this.varArtist;
        if (lVar3 != null) {
            c1708z0.z(lVar3.f4659Y, objArr[2]);
        }
        J3.l lVar4 = this.varGenre;
        if (lVar4 != null) {
            c1708z0.z(lVar4.f4659Y, objArr[3]);
        }
        J3.l lVar5 = this.varDuration;
        if (lVar5 != null) {
            c1708z0.z(lVar5.f4659Y, objArr[4]);
        }
        J3.l lVar6 = this.varTrackNumber;
        if (lVar6 != null) {
            c1708z0.z(lVar6.f4659Y, objArr[5]);
        }
        J3.l lVar7 = this.varReleaseDate;
        if (lVar7 != null) {
            c1708z0.z(lVar7.f4659Y, objArr[6]);
        }
        J3.l lVar8 = this.varLatitude;
        if (lVar8 != null) {
            c1708z0.z(lVar8.f4659Y, objArr[7]);
        }
        J3.l lVar9 = this.varLongitude;
        if (lVar9 != null) {
            c1708z0.z(lVar9.f4659Y, objArr[8]);
        }
        J3.l lVar10 = this.varOrientation;
        if (lVar10 != null) {
            c1708z0.z(lVar10.f4659Y, objArr[9]);
        }
        c1708z0.f17642x0 = this.onComplete;
        return true;
    }
}
