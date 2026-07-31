package t3;

import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.llamalab.image.png.PngText;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f22408a;

    public static class a extends SecureRandomSpi {

        /* renamed from: Y, reason: collision with root package name */
        public static final File f22409Y = new File("/dev/urandom");

        /* renamed from: Z, reason: collision with root package name */
        public static final Object f22410Z = new Object();

        /* renamed from: x0, reason: collision with root package name */
        public static DataInputStream f22411x0;

        /* renamed from: y0, reason: collision with root package name */
        public static FileOutputStream f22412y0;

        /* renamed from: X, reason: collision with root package name */
        public boolean f22413X;

        public static DataInputStream a() {
            DataInputStream dataInputStream;
            synchronized (f22410Z) {
                if (f22411x0 == null) {
                    try {
                        f22411x0 = new DataInputStream(new FileInputStream(f22409Y));
                    } catch (IOException e8) {
                        throw new SecurityException("Failed to open " + f22409Y + " for reading", e8);
                    }
                }
                dataInputStream = f22411x0;
            }
            return dataInputStream;
        }

        public static OutputStream b() {
            FileOutputStream fileOutputStream;
            synchronized (f22410Z) {
                if (f22412y0 == null) {
                    f22412y0 = new FileOutputStream(f22409Y);
                }
                fileOutputStream = f22412y0;
            }
            return fileOutputStream;
        }

        @Override // java.security.SecureRandomSpi
        public final byte[] engineGenerateSeed(int i8) {
            byte[] bArr = new byte[i8];
            engineNextBytes(bArr);
            return bArr;
        }

        @Override // java.security.SecureRandomSpi
        public final void engineNextBytes(byte[] bArr) {
            DataInputStream a8;
            if (!this.f22413X) {
                engineSetSeed(j.b());
            }
            try {
                synchronized (f22410Z) {
                    a8 = a();
                }
                synchronized (a8) {
                    a8.readFully(bArr);
                }
            } catch (IOException e8) {
                throw new SecurityException("Failed to read from " + f22409Y, e8);
            }
        }

        @Override // java.security.SecureRandomSpi
        public final void engineSetSeed(byte[] bArr) {
            OutputStream b8;
            try {
                try {
                    synchronized (f22410Z) {
                        b8 = b();
                    }
                    b8.write(bArr);
                    b8.flush();
                } catch (IOException unused) {
                    Log.w(j.class.getSimpleName(), "Failed to mix seed into " + f22409Y);
                }
            } finally {
                this.f22413X = true;
            }
        }
    }

    public static class b extends Provider {
        public b() {
            super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
            put("SecureRandom.SHA1PRNG", a.class.getName());
            put("SecureRandom.SHA1PRNG ImplementedIn", PngText.SOFTWARE);
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = Build.FINGERPRINT;
        if (str != null) {
            sb.append(str);
        }
        String str2 = null;
        try {
            str2 = (String) Build.class.getField("SERIAL").get(null);
        } catch (Exception unused) {
        }
        if (str2 != null) {
            sb.append(str2);
        }
        try {
            f22408a = sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused2) {
            throw new RuntimeException("UTF-8 encoding not supported");
        }
    }

    public static void a() {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 16 || i8 > 18) {
            return;
        }
        try {
            Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", byte[].class).invoke(null, b());
            int intValue = ((Integer) Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", String.class, Long.TYPE).invoke(null, "/dev/urandom", 1024)).intValue();
            if (intValue == 1024) {
                return;
            }
            throw new IOException("Unexpected number of bytes read from Linux PRNG: " + intValue);
        } catch (Exception e8) {
            throw new SecurityException("Failed to seed OpenSSL PRNG", e8);
        }
    }

    public static byte[] b() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeLong(System.currentTimeMillis());
            dataOutputStream.writeLong(System.nanoTime());
            dataOutputStream.writeInt(Process.myPid());
            dataOutputStream.writeInt(Process.myUid());
            dataOutputStream.write(f22408a);
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e8) {
            throw new SecurityException("Failed to generate seed", e8);
        }
    }

    public static void c() {
        if (Build.VERSION.SDK_INT > 18) {
            return;
        }
        Provider[] providers = Security.getProviders("SecureRandom.SHA1PRNG");
        if (providers == null || providers.length < 1 || !b.class.equals(providers[0].getClass())) {
            Security.insertProviderAt(new b(), 1);
        }
        SecureRandom secureRandom = new SecureRandom();
        if (!b.class.equals(secureRandom.getProvider().getClass())) {
            throw new SecurityException("new SecureRandom() backed by wrong Provider: " + secureRandom.getProvider().getClass());
        }
        try {
            SecureRandom secureRandom2 = SecureRandom.getInstance("SHA1PRNG");
            if (b.class.equals(secureRandom2.getProvider().getClass())) {
                return;
            }
            throw new SecurityException("SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: " + secureRandom2.getProvider().getClass());
        } catch (NoSuchAlgorithmException e8) {
            throw new SecurityException("SHA1PRNG not available", e8);
        }
    }
}
