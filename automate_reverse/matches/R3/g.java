package R3;

import L3.A;
import L3.B;
import L3.C;
import L3.C1036a;
import L3.C1037b;
import L3.C1038c;
import L3.C1039d;
import L3.C1041f;
import L3.C1042g;
import L3.C1043h;
import L3.C1044i;
import L3.C1046k;
import L3.C1047l;
import L3.C1048m;
import L3.C1049n;
import L3.C1050o;
import L3.C1051p;
import L3.C1052q;
import L3.C1053s;
import L3.C1054t;
import L3.C1055u;
import L3.C1056v;
import L3.C1057w;
import L3.C1058x;
import L3.C1059y;
import L3.C1060z;
import L3.D;
import L3.E;
import L3.F;
import L3.G;
import L3.H;
import L3.I;
import L3.J;
import L3.L;
import L3.N;
import L3.O;
import L3.P;
import L3.Q;
import L3.S;
import L3.T;
import L3.V;
import L3.W;
import L3.X;
import L3.Y;
import com.llamalab.android.system.MoreOsConstants;
import com.llamalab.automate.C1704y0;
import com.llamalab.automate.InterfaceC1700x0;
import com.llamalab.automate.expr.func.Abs;
import com.llamalab.automate.expr.func.Acos;
import com.llamalab.automate.expr.func.Asin;
import com.llamalab.automate.expr.func.Associate;
import com.llamalab.automate.expr.func.Atan;
import com.llamalab.automate.expr.func.Atan2;
import com.llamalab.automate.expr.func.Base64Decode;
import com.llamalab.automate.expr.func.Base64Encode;
import com.llamalab.automate.expr.func.Bearing;
import com.llamalab.automate.expr.func.BigInt;
import com.llamalab.automate.expr.func.Ceil;
import com.llamalab.automate.expr.func.Celsius;
import com.llamalab.automate.expr.func.Char;
import com.llamalab.automate.expr.func.CliEncode;
import com.llamalab.automate.expr.func.Clock;
import com.llamalab.automate.expr.func.Coalesce;
import com.llamalab.automate.expr.func.ColorRecode;
import com.llamalab.automate.expr.func.Concat;
import com.llamalab.automate.expr.func.Contains;
import com.llamalab.automate.expr.func.ConvType;
import com.llamalab.automate.expr.func.CoordFormat;
import com.llamalab.automate.expr.func.Copy;
import com.llamalab.automate.expr.func.Cos;
import com.llamalab.automate.expr.func.Crc32;
import com.llamalab.automate.expr.func.Ctz;
import com.llamalab.automate.expr.func.Date;
import com.llamalab.automate.expr.func.DateFormat;
import com.llamalab.automate.expr.func.DateParse;
import com.llamalab.automate.expr.func.DateParts;
import com.llamalab.automate.expr.func.Declination;
import com.llamalab.automate.expr.func.Disjoint;
import com.llamalab.automate.expr.func.Distance;
import com.llamalab.automate.expr.func.Distinct;
import com.llamalab.automate.expr.func.DurationFormat;
import com.llamalab.automate.expr.func.Except;
import com.llamalab.automate.expr.func.Exp;
import com.llamalab.automate.expr.func.Extend;
import com.llamalab.automate.expr.func.Fahrenheit;
import com.llamalab.automate.expr.func.FileUri;
import com.llamalab.automate.expr.func.Filter;
import com.llamalab.automate.expr.func.FindAll;
import com.llamalab.automate.expr.func.Floor;
import com.llamalab.automate.expr.func.Glob;
import com.llamalab.automate.expr.func.HexDecode;
import com.llamalab.automate.expr.func.HexEncode;
import com.llamalab.automate.expr.func.IndexOf;
import com.llamalab.automate.expr.func.Intersect;
import com.llamalab.automate.expr.func.Join;
import com.llamalab.automate.expr.func.JsonDecode;
import com.llamalab.automate.expr.func.JsonEncode;
import com.llamalab.automate.expr.func.Keys;
import com.llamalab.automate.expr.func.Levenshtein;
import com.llamalab.automate.expr.func.LocalTime;
import com.llamalab.automate.expr.func.Log;
import com.llamalab.automate.expr.func.LowerCase;
import com.llamalab.automate.expr.func.Matches;
import com.llamalab.automate.expr.func.Max;
import com.llamalab.automate.expr.func.Md5;
import com.llamalab.automate.expr.func.MimeType;
import com.llamalab.automate.expr.func.Min;
import com.llamalab.automate.expr.func.NumberFormat;
import com.llamalab.automate.expr.func.PhoneEqual;
import com.llamalab.automate.expr.func.PhoneFormat;
import com.llamalab.automate.expr.func.Pow;
import com.llamalab.automate.expr.func.Random;
import com.llamalab.automate.expr.func.ReplaceAll;
import com.llamalab.automate.expr.func.Reverse;
import com.llamalab.automate.expr.func.Round;
import com.llamalab.automate.expr.func.Runtime;
import com.llamalab.automate.expr.func.Sha1;
import com.llamalab.automate.expr.func.Sha256;
import com.llamalab.automate.expr.func.Shuffle;
import com.llamalab.automate.expr.func.Sift;
import com.llamalab.automate.expr.func.Sin;
import com.llamalab.automate.expr.func.SizeFormat;
import com.llamalab.automate.expr.func.Slice;
import com.llamalab.automate.expr.func.Sort;
import com.llamalab.automate.expr.func.Split;
import com.llamalab.automate.expr.func.SqlEncode;
import com.llamalab.automate.expr.func.Sqrt;
import com.llamalab.automate.expr.func.Storage;
import com.llamalab.automate.expr.func.Substr;
import com.llamalab.automate.expr.func.Sum;
import com.llamalab.automate.expr.func.Tan;
import com.llamalab.automate.expr.func.Time;
import com.llamalab.automate.expr.func.TimeMerge;
import com.llamalab.automate.expr.func.TimePart;
import com.llamalab.automate.expr.func.Trim;
import com.llamalab.automate.expr.func.Trunc;
import com.llamalab.automate.expr.func.Type;
import com.llamalab.automate.expr.func.Undead;
import com.llamalab.automate.expr.func.Union;
import com.llamalab.automate.expr.func.Unorm;
import com.llamalab.automate.expr.func.UpperCase;
import com.llamalab.automate.expr.func.UrlDecode;
import com.llamalab.automate.expr.func.UrlEncode;
import com.llamalab.automate.expr.func.UtcTime;
import com.llamalab.automate.expr.func.Uuid4;
import com.llamalab.automate.expr.func.Values;
import com.llamalab.automate.expr.func.VersionCompare;
import com.llamalab.automate.expr.func.XPathEncode;
import com.llamalab.automate.expr.func.XmlDecode;
import com.llamalab.automate.expr.func.XmlEncode;
import com.llamalab.automate.stmt.AccessibilityButton;
import com.llamalab.automate.stmt.AccountGenericAdd;
import com.llamalab.automate.stmt.AccountPick;
import com.llamalab.automate.stmt.AccountSyncEnabled;
import com.llamalab.automate.stmt.AccountSyncRequest;
import com.llamalab.automate.stmt.AccountSyncSetState;
import com.llamalab.automate.stmt.ActivityStart;
import com.llamalab.automate.stmt.ActivityStartResult;
import com.llamalab.automate.stmt.ActivityStartVoice;
import com.llamalab.automate.stmt.AdbProtocolSet;
import com.llamalab.automate.stmt.AdbShellCommand;
import com.llamalab.automate.stmt.AirplaneModeEnabled;
import com.llamalab.automate.stmt.AirplaneModeSetState;
import com.llamalab.automate.stmt.Alarm;
import com.llamalab.automate.stmt.AlarmAdd;
import com.llamalab.automate.stmt.AlternativeLaunch;
import com.llamalab.automate.stmt.AmbientLight;
import com.llamalab.automate.stmt.AmbientTemperature;
import com.llamalab.automate.stmt.AndroidVersion;
import com.llamalab.automate.stmt.AppClearCache;
import com.llamalab.automate.stmt.AppForeground;
import com.llamalab.automate.stmt.AppInstalled;
import com.llamalab.automate.stmt.AppKill;
import com.llamalab.automate.stmt.AppKillBackground;
import com.llamalab.automate.stmt.AppList;
import com.llamalab.automate.stmt.AppNotificationsEnabled;
import com.llamalab.automate.stmt.AppNotificationsPriorityGet;
import com.llamalab.automate.stmt.AppNotificationsPrioritySet;
import com.llamalab.automate.stmt.AppNotificationsSetState;
import com.llamalab.automate.stmt.AppNotificationsVisibilityGet;
import com.llamalab.automate.stmt.AppNotificationsVisibilitySet;
import com.llamalab.automate.stmt.AppOpMode;
import com.llamalab.automate.stmt.AppOpModeSet;
import com.llamalab.automate.stmt.AppPick;
import com.llamalab.automate.stmt.AppUsage;
import com.llamalab.automate.stmt.AppWidgetConfigure;
import com.llamalab.automate.stmt.ArrayAdd;
import com.llamalab.automate.stmt.ArrayRemove;
import com.llamalab.automate.stmt.ArraySet;
import com.llamalab.automate.stmt.AssistRequest;
import com.llamalab.automate.stmt.AtmosphericPressure;
import com.llamalab.automate.stmt.AtomicAdd;
import com.llamalab.automate.stmt.AtomicClearAll;
import com.llamalab.automate.stmt.AtomicCompareAndStore;
import com.llamalab.automate.stmt.AtomicLoad;
import com.llamalab.automate.stmt.AtomicStore;
import com.llamalab.automate.stmt.AttentionLight;
import com.llamalab.automate.stmt.AudioDeviceConnected;
import com.llamalab.automate.stmt.AudioDeviceRecording;
import com.llamalab.automate.stmt.AudioPlayerControl;
import com.llamalab.automate.stmt.AudioRecordStart;
import com.llamalab.automate.stmt.AudioRecordStop;
import com.llamalab.automate.stmt.AudioStreamMuted;
import com.llamalab.automate.stmt.AudioStreamSetMute;
import com.llamalab.automate.stmt.AudioVolume;
import com.llamalab.automate.stmt.AudioVolumeSet;
import com.llamalab.automate.stmt.BarcodeScan;
import com.llamalab.automate.stmt.BatteryCharging;
import com.llamalab.automate.stmt.BatteryLevel;
import com.llamalab.automate.stmt.BatteryProperties;
import com.llamalab.automate.stmt.BluetoothDeviceActiveSet;
import com.llamalab.automate.stmt.BluetoothDeviceBondCreate;
import com.llamalab.automate.stmt.BluetoothDeviceBondRemove;
import com.llamalab.automate.stmt.BluetoothDeviceConnect;
import com.llamalab.automate.stmt.BluetoothDeviceConnected;
import com.llamalab.automate.stmt.BluetoothDeviceDisconnect;
import com.llamalab.automate.stmt.BluetoothDevicePick;
import com.llamalab.automate.stmt.BluetoothDeviceScan;
import com.llamalab.automate.stmt.BluetoothEnabled;
import com.llamalab.automate.stmt.BluetoothGattRead;
import com.llamalab.automate.stmt.BluetoothScoSetState;
import com.llamalab.automate.stmt.BluetoothSetState;
import com.llamalab.automate.stmt.BluetoothTetherEnabled;
import com.llamalab.automate.stmt.BluetoothTetherSetState;
import com.llamalab.automate.stmt.BroadcastReceive;
import com.llamalab.automate.stmt.BroadcastSend;
import com.llamalab.automate.stmt.BroadcastSendOrdered;
import com.llamalab.automate.stmt.C1631a0;
import com.llamalab.automate.stmt.CalendarEventAdd;
import com.llamalab.automate.stmt.CalendarEventGet;
import com.llamalab.automate.stmt.CalendarEventQuery;
import com.llamalab.automate.stmt.CalendarPick;
import com.llamalab.automate.stmt.CallAnswer;
import com.llamalab.automate.stmt.CallEnd;
import com.llamalab.automate.stmt.CallIncoming;
import com.llamalab.automate.stmt.CallNumber;
import com.llamalab.automate.stmt.CallOutgoing;
import com.llamalab.automate.stmt.CallScreening;
import com.llamalab.automate.stmt.CallScreeningResponse;
import com.llamalab.automate.stmt.CallState;
import com.llamalab.automate.stmt.CameraAvailable;
import com.llamalab.automate.stmt.CaptureImage;
import com.llamalab.automate.stmt.CaptureVideo;
import com.llamalab.automate.stmt.CarModeEnabled;
import com.llamalab.automate.stmt.CarModeSetState;
import com.llamalab.automate.stmt.CellSignalLevel;
import com.llamalab.automate.stmt.CellSiteNear;
import com.llamalab.automate.stmt.CellSitePick;
import com.llamalab.automate.stmt.ClipboardGet;
import com.llamalab.automate.stmt.ClipboardSet;
import com.llamalab.automate.stmt.CloudMessageReceive;
import com.llamalab.automate.stmt.CloudMessageSend;
import com.llamalab.automate.stmt.ColorPick;
import com.llamalab.automate.stmt.ComposeEmail;
import com.llamalab.automate.stmt.ComposeMms;
import com.llamalab.automate.stmt.ComposeSms;
import com.llamalab.automate.stmt.ContactPick;
import com.llamalab.automate.stmt.ContactQuery;
import com.llamalab.automate.stmt.ContentChanged;
import com.llamalab.automate.stmt.ContentDelete;
import com.llamalab.automate.stmt.ContentInsert;
import com.llamalab.automate.stmt.ContentOffer;
import com.llamalab.automate.stmt.ContentOfferResult;
import com.llamalab.automate.stmt.ContentPick;
import com.llamalab.automate.stmt.ContentProviderCall;
import com.llamalab.automate.stmt.ContentQuery;
import com.llamalab.automate.stmt.ContentRead;
import com.llamalab.automate.stmt.ContentShared;
import com.llamalab.automate.stmt.ContentUpdate;
import com.llamalab.automate.stmt.ContentView;
import com.llamalab.automate.stmt.ContentWrite;
import com.llamalab.automate.stmt.CpuSpeedGet;
import com.llamalab.automate.stmt.CpuSpeedSet;
import com.llamalab.automate.stmt.CyanogenModProfile;
import com.llamalab.automate.stmt.CyanogenModProfileSet;
import com.llamalab.automate.stmt.DataNetworkDefault;
import com.llamalab.automate.stmt.DataUsage;
import com.llamalab.automate.stmt.DatabaseModify;
import com.llamalab.automate.stmt.DatabaseQuery;
import com.llamalab.automate.stmt.DatePick;
import com.llamalab.automate.stmt.Delay;
import com.llamalab.automate.stmt.DestructuringAssign;
import com.llamalab.automate.stmt.DeviceAcceleration;
import com.llamalab.automate.stmt.DeviceDocked;
import com.llamalab.automate.stmt.DeviceIdleModeActive;
import com.llamalab.automate.stmt.DeviceIdleModeSetState;
import com.llamalab.automate.stmt.DeviceInteractive;
import com.llamalab.automate.stmt.DeviceKeepAwake;
import com.llamalab.automate.stmt.DeviceLock;
import com.llamalab.automate.stmt.DeviceOrientation;
import com.llamalab.automate.stmt.DeviceReboot;
import com.llamalab.automate.stmt.DeviceRestart;
import com.llamalab.automate.stmt.DeviceSecure;
import com.llamalab.automate.stmt.DeviceShutdown;
import com.llamalab.automate.stmt.DeviceUnlocked;
import com.llamalab.automate.stmt.DialNumber;
import com.llamalab.automate.stmt.DialogChoice;
import com.llamalab.automate.stmt.DialogConfirm;
import com.llamalab.automate.stmt.DialogInput;
import com.llamalab.automate.stmt.DialogMessage;
import com.llamalab.automate.stmt.DialogNumber;
import com.llamalab.automate.stmt.DialogWeb;
import com.llamalab.automate.stmt.DictionaryPut;
import com.llamalab.automate.stmt.DictionaryRemove;
import com.llamalab.automate.stmt.DisplayMetricsGet;
import com.llamalab.automate.stmt.DisplayOn;
import com.llamalab.automate.stmt.DisplayPowerMode;
import com.llamalab.automate.stmt.DisplayPowerModeSet;
import com.llamalab.automate.stmt.DisplayQuery;
import com.llamalab.automate.stmt.DreamCreated;
import com.llamalab.automate.stmt.DreamSetup;
import com.llamalab.automate.stmt.DtmfTonePlay;
import com.llamalab.automate.stmt.DtmfToneStop;
import com.llamalab.automate.stmt.DurationPick;
import com.llamalab.automate.stmt.EmailSend;
import com.llamalab.automate.stmt.EthernetTetherSetState;
import com.llamalab.automate.stmt.ExpressionDecision;
import com.llamalab.automate.stmt.FailureCatch;
import com.llamalab.automate.stmt.FeatureUsage;
import com.llamalab.automate.stmt.FiberStop;
import com.llamalab.automate.stmt.FiberStopped;
import com.llamalab.automate.stmt.FileApkExtract;
import com.llamalab.automate.stmt.FileCopy;
import com.llamalab.automate.stmt.FileDelete;
import com.llamalab.automate.stmt.FileExists;
import com.llamalab.automate.stmt.FileList;
import com.llamalab.automate.stmt.FileMakeDirectory;
import com.llamalab.automate.stmt.FileMonitor;
import com.llamalab.automate.stmt.FileMove;
import com.llamalab.automate.stmt.FileMultipartExtract;
import com.llamalab.automate.stmt.FilePick;
import com.llamalab.automate.stmt.FileRead;
import com.llamalab.automate.stmt.FileWrite;
import com.llamalab.automate.stmt.FingerprintGesture;
import com.llamalab.automate.stmt.FlashlightEnabled;
import com.llamalab.automate.stmt.FlashlightSetState;
import com.llamalab.automate.stmt.FloatingButtonShow;
import com.llamalab.automate.stmt.FlowBeginning;
import com.llamalab.automate.stmt.FlowBeginningPick;
import com.llamalab.automate.stmt.FlowPick;
import com.llamalab.automate.stmt.FlowStart;
import com.llamalab.automate.stmt.FlowStop;
import com.llamalab.automate.stmt.ForEach;
import com.llamalab.automate.stmt.Fork;
import com.llamalab.automate.stmt.FtpDelete;
import com.llamalab.automate.stmt.FtpDownload;
import com.llamalab.automate.stmt.FtpList;
import com.llamalab.automate.stmt.FtpMakeDirectory;
import com.llamalab.automate.stmt.FtpUpload;
import com.llamalab.automate.stmt.Fullscreen;
import com.llamalab.automate.stmt.GDriveDelete;
import com.llamalab.automate.stmt.GDriveDownload;
import com.llamalab.automate.stmt.GDriveFileExists;
import com.llamalab.automate.stmt.GDriveList;
import com.llamalab.automate.stmt.GDriveMakeDirectory;
import com.llamalab.automate.stmt.GDriveShare;
import com.llamalab.automate.stmt.GDriveUpload;
import com.llamalab.automate.stmt.Geocoding;
import com.llamalab.automate.stmt.GeocodingReverse;
import com.llamalab.automate.stmt.GmailSend;
import com.llamalab.automate.stmt.GmailUnreadCount;
import com.llamalab.automate.stmt.GoogleAssistantAction;
import com.llamalab.automate.stmt.Goto;
import com.llamalab.automate.stmt.HardwareKeyboardVisible;
import com.llamalab.automate.stmt.HeartRate;
import com.llamalab.automate.stmt.HingeAngle;
import com.llamalab.automate.stmt.HotwordDetected;
import com.llamalab.automate.stmt.HttpAcceptTcp;
import com.llamalab.automate.stmt.HttpRequest;
import com.llamalab.automate.stmt.HttpResponse;
import com.llamalab.automate.stmt.IconPick;
import com.llamalab.automate.stmt.ImageCrop;
import com.llamalab.automate.stmt.ImageFlip;
import com.llamalab.automate.stmt.ImageLoad;
import com.llamalab.automate.stmt.ImageRescale;
import com.llamalab.automate.stmt.ImageRotate;
import com.llamalab.automate.stmt.ImageSampleColor;
import com.llamalab.automate.stmt.ImageUnload;
import com.llamalab.automate.stmt.ImageWrite;
import com.llamalab.automate.stmt.InfraredTransmit;
import com.llamalab.automate.stmt.InputMethodPick;
import com.llamalab.automate.stmt.InputMethodSet;
import com.llamalab.automate.stmt.InspectLayout;
import com.llamalab.automate.stmt.InspectTextEdit;
import com.llamalab.automate.stmt.Interact;
import com.llamalab.automate.stmt.InteractTouch;
import com.llamalab.automate.stmt.InterfaceAdapterUpdate;
import com.llamalab.automate.stmt.InterfaceClicked;
import com.llamalab.automate.stmt.InterfaceItemRequest;
import com.llamalab.automate.stmt.InterfaceLayoutUpdate;
import com.llamalab.automate.stmt.InterfaceRequest;
import com.llamalab.automate.stmt.InterruptionFilter;
import com.llamalab.automate.stmt.InterruptionFilterSet;
import com.llamalab.automate.stmt.KeyChainAliasPick;
import com.llamalab.automate.stmt.KeyPressed;
import com.llamalab.automate.stmt.KeySend;
import com.llamalab.automate.stmt.KeySendCharacters;
import com.llamalab.automate.stmt.Label;
import com.llamalab.automate.stmt.LocationAt;
import com.llamalab.automate.stmt.LocationGet;
import com.llamalab.automate.stmt.LocationMock;
import com.llamalab.automate.stmt.LocationPick;
import com.llamalab.automate.stmt.LocationProviderEnabled;
import com.llamalab.automate.stmt.LocationProviderSetState;
import com.llamalab.automate.stmt.LocationShow;
import com.llamalab.automate.stmt.LogAppend;
import com.llamalab.automate.stmt.LogAwait;
import com.llamalab.automate.stmt.M0;
import com.llamalab.automate.stmt.MagneticFieldStrength;
import com.llamalab.automate.stmt.MediaButton;
import com.llamalab.automate.stmt.MediaPlaying;
import com.llamalab.automate.stmt.MediaStoreAdd;
import com.llamalab.automate.stmt.MediaStoreRemove;
import com.llamalab.automate.stmt.MediaTagsRead;
import com.llamalab.automate.stmt.MicrophoneMuted;
import com.llamalab.automate.stmt.MicrophoneSetMute;
import com.llamalab.automate.stmt.MmsSend;
import com.llamalab.automate.stmt.MobileDataEnabled;
import com.llamalab.automate.stmt.MobileDataNetworkType;
import com.llamalab.automate.stmt.MobileDataSetState;
import com.llamalab.automate.stmt.MobileNetworkPreferred;
import com.llamalab.automate.stmt.MobileNetworkPreferredSet;
import com.llamalab.automate.stmt.MobileOperator;
import com.llamalab.automate.stmt.MobileServiceState;
import com.llamalab.automate.stmt.MotionGesture;
import com.llamalab.automate.stmt.NetworkConnected;
import com.llamalab.automate.stmt.NetworkThroughput;
import com.llamalab.automate.stmt.NetworkType;
import com.llamalab.automate.stmt.NfcEnabled;
import com.llamalab.automate.stmt.NfcSetState;
import com.llamalab.automate.stmt.NfcTagScanned;
import com.llamalab.automate.stmt.NfcTagWrite;
import com.llamalab.automate.stmt.NightModeEnabled;
import com.llamalab.automate.stmt.NightModeSetState;
import com.llamalab.automate.stmt.NotificationAction;
import com.llamalab.automate.stmt.NotificationCancel;
import com.llamalab.automate.stmt.NotificationChannelPick;
import com.llamalab.automate.stmt.NotificationInteract;
import com.llamalab.automate.stmt.NotificationPolicyGet;
import com.llamalab.automate.stmt.NotificationPolicySet;
import com.llamalab.automate.stmt.NotificationPosted;
import com.llamalab.automate.stmt.NotificationShow;
import com.llamalab.automate.stmt.NotificationSnooze;
import com.llamalab.automate.stmt.NsdDiscover;
import com.llamalab.automate.stmt.OneDriveDelete;
import com.llamalab.automate.stmt.OneDriveDownload;
import com.llamalab.automate.stmt.OneDriveFileExists;
import com.llamalab.automate.stmt.OneDriveList;
import com.llamalab.automate.stmt.OneDriveMakeDirectory;
import com.llamalab.automate.stmt.OneDriveUpload;
import com.llamalab.automate.stmt.PasswordFailed;
import com.llamalab.automate.stmt.Pedometer;
import com.llamalab.automate.stmt.PhysicalActivity;
import com.llamalab.automate.stmt.Ping;
import com.llamalab.automate.stmt.PlugInCondition;
import com.llamalab.automate.stmt.PlugInEvent;
import com.llamalab.automate.stmt.PlugInSetting;
import com.llamalab.automate.stmt.PowerSaveModeEnabled;
import com.llamalab.automate.stmt.PowerSaveModeSetState;
import com.llamalab.automate.stmt.PowerSourcePlugged;
import com.llamalab.automate.stmt.PreferredActivity;
import com.llamalab.automate.stmt.ProcessText;
import com.llamalab.automate.stmt.ProcessTextResult;
import com.llamalab.automate.stmt.ProfileQuietModeEnabled;
import com.llamalab.automate.stmt.ProfileQuietModeRequest;
import com.llamalab.automate.stmt.Proximity;
import com.llamalab.automate.stmt.QrCodeGenerate;
import com.llamalab.automate.stmt.QuickSettingsTileShow;
import com.llamalab.automate.stmt.RelativeHumidity;
import com.llamalab.automate.stmt.ResolveActivity;
import com.llamalab.automate.stmt.ResolveReceiver;
import com.llamalab.automate.stmt.ResolveService;
import com.llamalab.automate.stmt.RestrictBackgroundDataEnabled;
import com.llamalab.automate.stmt.RestrictBackgroundDataSetState;
import com.llamalab.automate.stmt.RingerMode;
import com.llamalab.automate.stmt.RingerModeSet;
import com.llamalab.automate.stmt.RingerSilence;
import com.llamalab.automate.stmt.RingtoneGet;
import com.llamalab.automate.stmt.RingtonePick;
import com.llamalab.automate.stmt.RingtoneSet;
import com.llamalab.automate.stmt.Roaming;
import com.llamalab.automate.stmt.RunnableC1672u0;
import com.llamalab.automate.stmt.ScreenBrightness;
import com.llamalab.automate.stmt.ScreenBrightnessSet;
import com.llamalab.automate.stmt.ScreenLockSetState;
import com.llamalab.automate.stmt.ScreenOffTimeout;
import com.llamalab.automate.stmt.ScreenOffTimeoutSet;
import com.llamalab.automate.stmt.ScreenOrientation;
import com.llamalab.automate.stmt.ScreenOrientationSet;
import com.llamalab.automate.stmt.Screenshot;
import com.llamalab.automate.stmt.ServiceStart;
import com.llamalab.automate.stmt.ShellCommand;
import com.llamalab.automate.stmt.ShellCommandPrivileged;
import com.llamalab.automate.stmt.ShellCommandSuperuser;
import com.llamalab.automate.stmt.ShortcutPin;
import com.llamalab.automate.stmt.ShortcutStart;
import com.llamalab.automate.stmt.ShortcutUpdate;
import com.llamalab.automate.stmt.SignificantDeviceMotion;
import com.llamalab.automate.stmt.SmsReceived;
import com.llamalab.automate.stmt.SmsSend;
import com.llamalab.automate.stmt.SmsSent;
import com.llamalab.automate.stmt.SoftwareKeyboardVisible;
import com.llamalab.automate.stmt.SoundLevel;
import com.llamalab.automate.stmt.SoundPlay;
import com.llamalab.automate.stmt.SoundStop;
import com.llamalab.automate.stmt.SpeakPlay;
import com.llamalab.automate.stmt.SpeakStop;
import com.llamalab.automate.stmt.SpeakToFile;
import com.llamalab.automate.stmt.SpeakerphoneOn;
import com.llamalab.automate.stmt.SpeakerphoneSetState;
import com.llamalab.automate.stmt.SpeechRecognition;
import com.llamalab.automate.stmt.SplitScreenModeEnabled;
import com.llamalab.automate.stmt.StorageMediaMounted;
import com.llamalab.automate.stmt.StorageSpace;
import com.llamalab.automate.stmt.StorageVolumeList;
import com.llamalab.automate.stmt.Subroutine;
import com.llamalab.automate.stmt.SubscriptionDefaultGet;
import com.llamalab.automate.stmt.SubscriptionDefaultSet;
import com.llamalab.automate.stmt.SubscriptionPick;
import com.llamalab.automate.stmt.SubscriptionSetState;
import com.llamalab.automate.stmt.SystemLanguageGet;
import com.llamalab.automate.stmt.SystemLanguageSet;
import com.llamalab.automate.stmt.SystemPropertyGet;
import com.llamalab.automate.stmt.SystemSettingGet;
import com.llamalab.automate.stmt.SystemSettingSet;
import com.llamalab.automate.stmt.TakePicture;
import com.llamalab.automate.stmt.TextRecognition;
import com.llamalab.automate.stmt.TimeAwait;
import com.llamalab.automate.stmt.TimePick;
import com.llamalab.automate.stmt.TimeWindow;
import com.llamalab.automate.stmt.TimeZoneGet;
import com.llamalab.automate.stmt.TimeZoneSet;
import com.llamalab.automate.stmt.TimerAdd;
import com.llamalab.automate.stmt.ToastPosted;
import com.llamalab.automate.stmt.ToastShow;
import com.llamalab.automate.stmt.TonePlay;
import com.llamalab.automate.stmt.ToneStop;
import com.llamalab.automate.stmt.UsbConfigured;
import com.llamalab.automate.stmt.UsbDeviceAttached;
import com.llamalab.automate.stmt.UsbFunctionSet;
import com.llamalab.automate.stmt.UsbTetherEnabled;
import com.llamalab.automate.stmt.UsbTetherSetState;
import com.llamalab.automate.stmt.UserAsleep;
import com.llamalab.automate.stmt.UssdRequest;
import com.llamalab.automate.stmt.VariableAssign;
import com.llamalab.automate.stmt.VariablesGive;
import com.llamalab.automate.stmt.VariablesTake;
import com.llamalab.automate.stmt.VibrateStart;
import com.llamalab.automate.stmt.VibrateStop;
import com.llamalab.automate.stmt.VideoRecordStart;
import com.llamalab.automate.stmt.VideoRecordStop;
import com.llamalab.automate.stmt.WakeOnLanSend;
import com.llamalab.automate.stmt.WallpaperColorsGet;
import com.llamalab.automate.stmt.WallpaperCreated;
import com.llamalab.automate.stmt.WallpaperImageSet;
import com.llamalab.automate.stmt.WallpaperLiveSet;
import com.llamalab.automate.stmt.WallpaperSetup;
import com.llamalab.automate.stmt.Weather;
import com.llamalab.automate.stmt.WifiApClientsConnected;
import com.llamalab.automate.stmt.WifiApEnabled;
import com.llamalab.automate.stmt.WifiApSetState;
import com.llamalab.automate.stmt.WifiEnabled;
import com.llamalab.automate.stmt.WifiNetworkConnect;
import com.llamalab.automate.stmt.WifiNetworkConnected;
import com.llamalab.automate.stmt.WifiNetworkPick;
import com.llamalab.automate.stmt.WifiNetworkScan;
import com.llamalab.automate.stmt.WifiSetState;
import com.llamalab.automate.stmt.WifiSignalLevel;
import com.llamalab.automate.stmt.WiredHeadset;
import com.llamalab.automate.stmt.ZipCompress;
import com.llamalab.automate.stmt.ZipExtract;
import com.llamalab.automate.stmt.ZipList;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final f<?>[] f6418a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f6419b;

    public static class a<T extends e> extends f<T> {
        public a(int i8, Class<T> cls) {
            super(i8, cls);
        }

        @Override // R3.f
        public final Object a(R3.c cVar) {
            try {
                e eVar = (e) this.f6417b.newInstance();
                cVar.f(eVar);
                eVar.o0(cVar);
                return eVar;
            } catch (IllegalAccessException e8) {
                throw new IOException(e8);
            } catch (InstantiationException e9) {
                throw new IOException(e9);
            }
        }

        @Override // R3.f
        public final void b(R3.d dVar, Object obj) {
            ((e) obj).Y0(dVar);
        }
    }

    public static class b<T> extends f<T[]> {
        public b(int i8, Class<T> cls) {
            super(i8, Array.newInstance((Class<?>) cls, 0).getClass());
        }

        @Override // R3.f
        public final Object a(R3.c cVar) {
            int d8 = cVar.d();
            Object[] objArr = (Object[]) Array.newInstance(this.f6417b.getComponentType(), d8);
            cVar.f(objArr);
            for (int i8 = 0; i8 < d8; i8++) {
                objArr[i8] = cVar.readObject();
            }
            return objArr;
        }

        @Override // R3.f
        public final void b(R3.d dVar, Object obj) {
            Object[] objArr = (Object[]) obj;
            dVar.f(objArr.length);
            for (Object obj2 : objArr) {
                dVar.g(obj2);
            }
        }
    }

    public static class c<T> extends f<T> {

        /* renamed from: d, reason: collision with root package name */
        public final T f6420d;

        /* JADX WARN: Multi-variable type inference failed */
        public c(int i8, InterfaceC1700x0 interfaceC1700x0) {
            super(i8, interfaceC1700x0.getClass());
            this.f6420d = interfaceC1700x0;
        }

        @Override // R3.f
        public final T a(R3.c cVar) {
            T t8 = this.f6420d;
            cVar.f(t8);
            return t8;
        }

        @Override // R3.f
        public final void b(R3.d dVar, T t8) {
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static final g f6421a = new g(new a(100, C1039d.class), new a(101, C1053s.class), new a(102, J3.l.class), new c(103, I.f4933X), new a(104, J.class), new a(105, V.class), new a(106, W.class), new a(107, C1037b.class), new a(108, C1038c.class), new a(109, L3.r.class), new a(110, C1036a.class), new a(111, C1059y.class), new a(112, C1041f.class), new a(113, C1042g.class), new a(114, O.class), new a(115, P.class), new a(116, Q.class), new a(117, C1043h.class), new a(118, C1044i.class), new a(119, C1046k.class), new a(120, C1047l.class), new a(121, C1048m.class), new a(122, C1049n.class), new a(123, C1050o.class), new a(124, C1051p.class), new a(125, C1052q.class), new a(126, C1056v.class), new a(127, C1057w.class), new a(128, C1058x.class), new a(129, N.class), new a(130, B.class), new a(131, D.class), new a(132, E.class), new a(133, F.class), new a(MoreOsConstants.KEY_OPEN, C1060z.class), new a(MoreOsConstants.KEY_PASTE, G.class), new a(MoreOsConstants.KEY_FIND, A.class), new a(MoreOsConstants.KEY_CUT, S.class), new a(MoreOsConstants.KEY_HELP, T.class), new a(MoreOsConstants.KEY_MENU, X.class), new a(MoreOsConstants.KEY_CALC, Y.class), new a(MoreOsConstants.KEY_SETUP, C1055u.class), new c(MoreOsConstants.KEY_PLAYCD, C1054t.f4952X), new c(MoreOsConstants.KEY_PAUSECD, C.f4927X), new c(MoreOsConstants.KEY_PROG3, H.f4932X), new c(MoreOsConstants.KEY_PROG4, L.f4935X), new a(300, Abs.class), new a(301, Acos.class), new a(302, Asin.class), new a(MoreOsConstants.BTN_DEAD, Atan.class), new a(304, Atan2.class), new a(305, Ceil.class), new a(MoreOsConstants.BTN_C, Contains.class), new a(307, CoordFormat.class), new a(308, Cos.class), new a(MoreOsConstants.BTN_Z, DateFormat.class), new a(MoreOsConstants.BTN_TL, DateParts.class), new a(MoreOsConstants.BTN_TR, Distance.class), new a(MoreOsConstants.BTN_TL2, PhoneEqual.class), new a(MoreOsConstants.BTN_TR2, Exp.class), new a(MoreOsConstants.BTN_SELECT, Floor.class), new a(MoreOsConstants.BTN_START, JsonDecode.class), new a(MoreOsConstants.BTN_MODE, JsonEncode.class), new a(MoreOsConstants.BTN_THUMBL, Join.class), new a(MoreOsConstants.BTN_THUMBR, LocalTime.class), new a(319, Log.class), new a(320, LowerCase.class), new a(MoreOsConstants.BTN_TOOL_RUBBER, Date.class), new a(MoreOsConstants.BTN_TOOL_BRUSH, Matches.class), new a(MoreOsConstants.BTN_TOOL_PENCIL, Max.class), new a(MoreOsConstants.BTN_TOOL_AIRBRUSH, TimeMerge.class), new a(MoreOsConstants.BTN_TOOL_FINGER, MimeType.class), new a(MoreOsConstants.BTN_TOOL_MOUSE, Min.class), new a(MoreOsConstants.BTN_TOOL_LENS, NumberFormat.class), new a(MoreOsConstants.BTN_TOOL_QUINTTAP, Pow.class), new a(329, ReplaceAll.class), new a(MoreOsConstants.BTN_TOUCH, Round.class), new a(MoreOsConstants.BTN_STYLUS, Sift.class), new a(MoreOsConstants.BTN_STYLUS2, Sin.class), new a(MoreOsConstants.BTN_TOOL_DOUBLETAP, Split.class), new a(MoreOsConstants.BTN_TOOL_TRIPLETAP, Sqrt.class), new a(MoreOsConstants.BTN_TOOL_QUADTAP, Tan.class), new a(336, Trim.class), new a(MoreOsConstants.BTN_GEAR_UP, Trunc.class), new a(338, UpperCase.class), new a(339, UrlEncode.class), new a(340, UtcTime.class), new a(341, CliEncode.class), new a(342, Glob.class), new a(343, Keys.class), new a(344, Shuffle.class), new a(345, DurationFormat.class), new a(346, Substr.class), new a(347, Storage.class), new a(348, Copy.class), new a(349, Random.class), new a(350, HexEncode.class), new a(351, Char.class), new a(MoreOsConstants.KEY_OK, UrlDecode.class), new a(MoreOsConstants.KEY_SELECT, Bearing.class), new a(MoreOsConstants.KEY_GOTO, Celsius.class), new a(MoreOsConstants.KEY_CLEAR, Fahrenheit.class), new a(MoreOsConstants.KEY_POWER2, Type.class), new a(MoreOsConstants.KEY_OPTION, XmlDecode.class), new a(MoreOsConstants.KEY_INFO, XmlEncode.class), new a(MoreOsConstants.KEY_TIME, Base64Decode.class), new a(MoreOsConstants.KEY_VENDOR, Base64Encode.class), new a(MoreOsConstants.KEY_ARCHIVE, HexDecode.class), new a(MoreOsConstants.KEY_PROGRAM, Sum.class), new a(MoreOsConstants.KEY_CHANNEL, Ctz.class), new a(MoreOsConstants.KEY_FAVORITES, Values.class), new a(MoreOsConstants.KEY_EPG, Declination.class), new a(MoreOsConstants.KEY_PVR, DateParse.class), new a(MoreOsConstants.KEY_MHP, Filter.class), new a(MoreOsConstants.KEY_LANGUAGE, Concat.class), new a(MoreOsConstants.KEY_TITLE, Extend.class), new a(MoreOsConstants.KEY_SUBTITLE, Intersect.class), new a(MoreOsConstants.KEY_ANGLE, Sort.class), new a(MoreOsConstants.KEY_ZOOM, Time.class), new a(MoreOsConstants.KEY_MODE, Disjoint.class), new a(MoreOsConstants.KEY_KEYBOARD, PhoneFormat.class), new a(MoreOsConstants.KEY_SCREEN, Reverse.class), new a(MoreOsConstants.KEY_PC, Distinct.class), new a(MoreOsConstants.KEY_TV, Levenshtein.class), new a(MoreOsConstants.KEY_TV2, Crc32.class), new a(MoreOsConstants.KEY_VCR, Md5.class), new a(MoreOsConstants.KEY_VCR2, Sha1.class), new a(MoreOsConstants.KEY_SAT, SqlEncode.class), new a(MoreOsConstants.KEY_SAT2, IndexOf.class), new a(MoreOsConstants.KEY_CD, Slice.class), new a(MoreOsConstants.KEY_TAPE, FindAll.class), new a(MoreOsConstants.KEY_RADIO, VersionCompare.class), new a(MoreOsConstants.KEY_TUNER, ColorRecode.class), new a(MoreOsConstants.KEY_PLAYER, TimePart.class), new a(MoreOsConstants.KEY_TEXT, ConvType.class), new a(MoreOsConstants.KEY_DVD, Clock.class), new a(MoreOsConstants.KEY_AUX, Except.class), new a(MoreOsConstants.KEY_MP3, Union.class), new a(MoreOsConstants.KEY_AUDIO, FileUri.class), new a(MoreOsConstants.KEY_VIDEO, Sha256.class), new a(MoreOsConstants.KEY_DIRECTORY, XPathEncode.class), new a(MoreOsConstants.KEY_LIST, SizeFormat.class), new a(MoreOsConstants.KEY_MEMO, Uuid4.class), new a(MoreOsConstants.KEY_CALENDAR, Coalesce.class), new a(MoreOsConstants.KEY_RED, Undead.class), new a(MoreOsConstants.KEY_GREEN, Unorm.class), new a(MoreOsConstants.KEY_YELLOW, Associate.class), new a(MoreOsConstants.KEY_BLUE, BigInt.class), new a(MoreOsConstants.KEY_CHANNELUP, Runtime.class), new a(1000, AccountPick.class), new a(1001, ActivityStart.class), new a(1002, ActivityStartResult.class), new a(1003, AirplaneModeEnabled.class), new a(1004, AmbientLight.class), new a(1005, AmbientTemperature.class), new a(1006, AppForeground.class), new a(1007, AppInstalled.class), new a(1008, AppKillBackground.class), new a(1009, ArrayAdd.class), new a(1010, ArrayRemove.class), new a(1011, ArraySet.class), new a(1012, VariableAssign.class), new a(1013, AssistRequest.class), new a(1014, AtmosphericPressure.class), new a(1015, AudioRecordStart.class), new a(1016, AudioRecordStop.class), new a(1017, AudioVolume.class), new a(1018, AudioVolumeSet.class), new a(1019, AccountSyncEnabled.class), new a(1020, AccountSyncSetState.class), new a(1021, BatteryLevel.class), new a(1022, BroadcastReceive.class), new a(1023, BroadcastSend.class), new a(1024, CallAnswer.class), new a(1025, CallEnd.class), new a(1026, CallIncoming.class), new a(1027, CallNumber.class), new a(1028, CallOutgoing.class), new a(1029, CallState.class), new a(1030, CellSignalLevel.class), new a(1031, CaptureImage.class), new a(1032, ClipboardGet.class), new a(1033, ClipboardSet.class), new a(1034, ComposeEmail.class), new a(1035, ComposeMms.class), new a(1036, ComposeSms.class), new a(1037, ContactQuery.class), new a(1038, ContactPick.class), new a(1039, ContentRead.class), new a(1040, ContentPick.class), new a(1041, ContentShared.class), new a(1042, ContentView.class), new a(1043, DatePick.class), new a(1044, RingtoneGet.class), new a(1045, RingtoneSet.class), new a(1046, Delay.class), new a(1047, DeviceDocked.class), new a(1048, DeviceLock.class), new a(1049, DeviceOrientation.class), new a(1050, DeviceUnlocked.class), new a(1051, DialNumber.class), new a(1052, DialogChoice.class), new a(1053, DialogConfirm.class), new a(1054, DialogInput.class), new a(1055, DictionaryPut.class), new a(1056, DictionaryRemove.class), new a(1057, DurationPick.class), new a(1058, ExpressionDecision.class), new a(1059, EmailSend.class), new a(1060, Fork.class), new a(1061, FiberStop.class), new a(1062, FileDelete.class), new a(1063, FileCopy.class), new a(1064, FileList.class), new a(1065, FileMonitor.class), new a(1066, FileMakeDirectory.class), new a(1067, FileMove.class), new a(1068, FilePick.class), new a(1069, FileRead.class), new a(1070, FileWrite.class), new a(1071, FlashlightSetState.class), new a(1072, FlowBeginning.class), new a(1073, ForEach.class), new a(1074, FtpDelete.class), new a(1075, FtpDownload.class), new a(1076, FtpList.class), new a(1077, FtpUpload.class), new a(1078, MediaStoreAdd.class), new a(1079, GDriveDelete.class), new a(1080, GDriveDownload.class), new a(1081, GDriveList.class), new a(1082, GDriveUpload.class), new a(1083, GmailSend.class), new a(1084, Geocoding.class), new a(1085, GeocodingReverse.class), new a(1087, HttpRequest.class), new a(1088, LocationAt.class), new a(1089, LocationGet.class), new a(1090, LocationPick.class), new a(1091, LocationShow.class), new a(1092, LocationProviderEnabled.class), new a(1093, LogAppend.class), new a(1094, MediaButton.class), new a(1095, MicrophoneMuted.class), new a(1096, MicrophoneSetMute.class), new a(1097, WifiNetworkPick.class), new a(1098, NetworkType.class), new a(1099, NfcEnabled.class), new a(1100, NfcTagScanned.class), new a(1101, NfcTagWrite.class), new a(1102, NotificationCancel.class), new a(1103, NotificationShow.class), new a(1104, PlugInCondition.class), new a(1105, PlugInEvent.class), new a(1106, PlugInSetting.class), new a(1107, PasswordFailed.class), new a(1108, PowerSourcePlugged.class), new a(1109, Proximity.class), new a(1110, Roaming.class), new a(1111, RingerMode.class), new a(1112, RingerModeSet.class), new a(1113, ScreenBrightness.class), new a(1114, ScreenBrightnessSet.class), new a(1116, ScreenOffTimeout.class), new a(1117, ScreenOffTimeoutSet.class), new a(1118, DeviceInteractive.class), new a(1119, ScreenOrientation.class), new a(1120, ToastShow.class), new a(1121, SmsReceived.class), new a(1122, SmsSend.class), new a(1123, SmsSent.class), new a(1124, SoundPlay.class), new a(1125, SoundStop.class), new a(1126, SpeechRecognition.class), new a(1127, SpeakPlay.class), new a(1128, SpeakStop.class), new a(1129, SpeakToFile.class), new a(1130, SpeakerphoneOn.class), new a(1131, SpeakerphoneSetState.class), new a(1132, StorageMediaMounted.class), new a(1133, StorageSpace.class), new a(1134, SystemSettingGet.class), new a(1135, SystemSettingSet.class), new a(1136, TakePicture.class), new a(1137, TimeWindow.class), new a(1138, TimePick.class), new a(1139, VibrateStart.class), new a(1140, VibrateStop.class), new a(1141, WallpaperImageSet.class), new a(1142, Weather.class), new a(1143, WifiApEnabled.class), new a(1144, WifiApSetState.class), new a(1145, WifiNetworkConnect.class), new a(1146, WifiNetworkConnected.class), new a(1147, WifiEnabled.class), new a(1148, WifiNetworkScan.class), new a(1149, WifiSetState.class), new a(1150, ZipExtract.class), new a(1151, ZipCompress.class), new a(1152, AudioPlayerControl.class), new a(1153, BluetoothDeviceConnected.class), new a(1154, BluetoothDevicePick.class), new a(1155, BluetoothEnabled.class), new a(1156, BluetoothSetState.class), new a(1157, GmailUnreadCount.class), new a(1158, ServiceStart.class), new a(1159, ShellCommand.class), new a(1160, WiredHeadset.class), new a(1161, FlowStop.class), new a(1162, MobileDataEnabled.class), new a(1163, MobileDataSetState.class), new a(1164, ShortcutStart.class), new a(1165, AirplaneModeSetState.class), new a(1166, LocationProviderSetState.class), new a(1167, NfcSetState.class), new a(1168, ScreenOrientationSet.class), new a(1169, TimeAwait.class), new a(1170, CalendarEventAdd.class), new a(1171, CalendarPick.class), new a(1172, FlowBeginningPick.class), new a(1173, FlowStart.class), new a(1174, FileExists.class), new a(1175, RingtonePick.class), new a(1176, RingerSilence.class), new a(1177, InputMethodPick.class), new a(1178, InputMethodSet.class), new a(1179, PhysicalActivity.class), new a(1180, ShellCommandSuperuser.class), new a(1181, GoogleAssistantAction.class), new a(1182, AlarmAdd.class), new a(1183, ScreenLockSetState.class), new a(1184, CellSiteNear.class), new a(1185, CellSitePick.class), new a(1186, CalendarEventGet.class), new a(1187, CalendarEventQuery.class), new a(1188, SystemLanguageGet.class), new a(1189, TimeZoneGet.class), new a(1190, NetworkConnected.class), new a(1191, NotificationInteract.class), new a(1192, NotificationPosted.class), new a(1193, BluetoothTetherEnabled.class), new a(1194, BluetoothTetherSetState.class), new a(1195, FiberStopped.class), new a(1196, ResolveActivity.class), new a(1197, ResolveReceiver.class), new a(1198, ResolveService.class), new a(1200, ScreenLockSetState.a.class), new a(1201, CarModeEnabled.class), new a(1202, CarModeSetState.class), new a(1203, NightModeEnabled.class), new a(1204, NightModeSetState.class), new a(1205, AttentionLight.class), new a(1206, ColorPick.class), new a(1207, DataUsage.class), new a(1208, NetworkThroughput.class), new a(1209, MobileOperator.class), new a(1210, Alarm.class), new a(1211, BluetoothDeviceConnect.class), new a(1212, CpuSpeedGet.class), new a(1213, CpuSpeedSet.class), new a(1214, VariablesGive.class), new a(1215, VariablesTake.class), new a(1216, VariablesTake.a.class), new a(1115, DeviceKeepAwake.class), new a(1217, DeviceKeepAwake.a.class), new a(1218, DeviceReboot.class), new a(1219, DeviceShutdown.class), new a(1220, MotionGesture.class), new a(1221, AppKill.class), new a(1222, BluetoothScoSetState.class), new a(1223, BluetoothScoSetState.BluetoothScoTask.class), new a(1224, TonePlay.class), new a(1225, UsbTetherEnabled.class), new a(1226, UsbTetherSetState.class), new a(1227, Screenshot.class), new a(1228, Ping.class), new a(1229, Interact.class), new a(1230, AccountSyncRequest.class), new a(1231, WakeOnLanSend.class), new a(1232, PowerSaveModeEnabled.class), new a(1233, PowerSaveModeSetState.class), new a(1234, MobileNetworkPreferredSet.class), new a(1235, AppClearCache.class), new a(1236, AccountGenericAdd.class), new a(1237, AppPick.class), new a(1238, MediaPlaying.class), new a(1239, MediaTagsRead.class), new a(1240, TimerAdd.class), new a(1241, WifiSignalLevel.class), new a(1242, AppNotificationsEnabled.class), new a(1243, AppNotificationsSetState.class), new a(1244, AndroidVersion.class), new a(1245, InterruptionFilter.class), new a(1246, InterruptionFilterSet.class), new a(1247, FtpMakeDirectory.class), new a(1248, GDriveMakeDirectory.class), new a(1249, MmsSend.class), new a(1250, AppOpMode.class), new a(1251, AppOpModeSet.class), new a(1252, MobileNetworkPreferred.class), new a(1253, AtomicAdd.class), new a(1254, AtomicClearAll.class), new a(1255, AtomicCompareAndStore.class), new a(1256, AtomicLoad.class), new a(1257, AtomicStore.class), new a(1258, DeviceAcceleration.class), new a(1259, MagneticFieldStrength.class), new a(1260, WallpaperLiveSet.class), new a(1261, FlowPick.class), new a(1262, MediaStoreRemove.class), new a(1263, FailureCatch.class), new a(1264, C1704y0.class), new a(1265, CloudMessageReceive.class), new a(1266, CloudMessageSend.class), new a(1267, SubscriptionPick.class), new a(1268, SystemPropertyGet.class), new a(1269, ToastPosted.class), new a(1270, BluetoothDeviceDisconnect.class), new a(1271, TimeZoneSet.class), new a(1272, VideoRecordStart.class), new a(1273, VideoRecordStop.class), new a(1274, ScreenLockSetState.c.class), new a(1275, RunnableC1672u0.class), new a(1276, NotificationAction.class), new a(1277, BluetoothDeviceScan.class), new a(1278, Subroutine.class), new a(1279, GDriveShare.class), new a(1280, DialogWeb.class), new a(1281, DeviceRestart.class), new a(1282, InfraredTransmit.class), new a(1283, SignificantDeviceMotion.class), new a(1284, SoundLevel.class), new a(1285, CyanogenModProfile.class), new a(1286, CyanogenModProfileSet.class), new a(1287, Goto.class), new a(1288, Label.class), new a(1289, HardwareKeyboardVisible.class), new a(1290, MobileDataNetworkType.class), new a(1291, DeviceIdleModeActive.class), new a(1292, RestrictBackgroundDataEnabled.class), new a(1293, RestrictBackgroundDataSetState.class), new a(1294, ContentChanged.class), new a(1295, ContentDelete.class), new a(1296, ContentInsert.class), new a(1297, ContentQuery.class), new a(1298, ContentUpdate.class), new a(1299, DeviceIdleModeSetState.class), new a(1300, Pedometer.class), new a(1301, SystemLanguageSet.class), new a(1302, DialogNumber.class), new a(1303, QuickSettingsTileShow.class), new a(1304, M0.class), new a(1305, AppList.class), new a(1306, AppNotificationsPriorityGet.class), new a(1307, AppNotificationsPrioritySet.class), new a(1308, AppNotificationsVisibilityGet.class), new a(1309, AppNotificationsVisibilitySet.class), new a(1310, AppUsage.class), new a(1311, MobileServiceState.class), new a(1312, NotificationPolicyGet.class), new a(1313, NotificationPolicySet.class), new a(1314, ProcessText.class), new a(1315, ProcessTextResult.class), new a(1316, LocationMock.class), new a(1317, AudioStreamMuted.class), new a(1318, AudioStreamSetMute.class), new a(1319, DatabaseModify.class), new a(1320, DatabaseQuery.class), new a(1321, NotificationSnooze.class), new a(1322, FingerprintGesture.class), new a(1323, UssdRequest.class), new a(1324, KeyPressed.class), new a(1325, InteractTouch.class), new a(1326, BroadcastSendOrdered.class), new a(1327, Fullscreen.class), new a(1328, PreferredActivity.class), new a(1329, AudioDeviceConnected.class), new a(1330, DisplayOn.class), new a(1331, ToneStop.class), new a(1332, NotificationChannelPick.class), new a(1333, HotwordDetected.class), new a(1334, AccessibilityButton.class), new a(1335, DialogMessage.class), new a(1336, AlternativeLaunch.class), new a(1337, LogAwait.class), new a(1338, KeySend.class), new a(1339, HeartRate.class), new a(1340, HingeAngle.class), new a(1341, RelativeHumidity.class), new a(1342, AdbShellCommand.class), new a(1343, KeyChainAliasPick.class), new a(1344, NsdDiscover.class), new a(1345, CaptureVideo.class), new a(1346, ActivityStartVoice.class), new a(1347, ContentOffer.class), new a(1348, ContentOfferResult.class), new a(1349, AudioDeviceRecording.class), new a(1350, ShortcutPin.class), new a(1351, IconPick.class), new a(1352, UserAsleep.class), new a(1353, DisplayQuery.class), new a(1354, InspectLayout.class), new a(1355, CallScreening.class), new a(1356, CallScreeningResponse.class), new a(1357, SplitScreenModeEnabled.class), new a(1358, ZipList.class), new a(1359, SubscriptionSetState.class), new a(1360, com.llamalab.automate.stmt.O.class), new a(1361, ImageLoad.class), new a(1362, ImageUnload.class), new a(1363, ImageWrite.class), new a(1364, ImageCrop.class), new a(1365, ImageFlip.class), new a(1366, ImageRescale.class), new a(1367, ImageRotate.class), new a(1368, ImageSampleColor.class), new a(1369, BatteryCharging.class), new a(1370, BatteryProperties.class), new a(1371, BluetoothDeviceBondCreate.class), new a(1372, BluetoothGattRead.class), new a(1373, ShortcutUpdate.class), new a(1374, SubscriptionDefaultGet.class), new a(1375, SubscriptionDefaultSet.class), new a(1376, StorageVolumeList.class), new a(1377, DataNetworkDefault.class), new a(1378, CameraAvailable.class), new a(1379, KeySendCharacters.class), new a(1380, AdbProtocolSet.class), new a(1381, DisplayMetricsGet.class), new a(1382, ShellCommandPrivileged.class), new a(1383, BluetoothDeviceActiveSet.class), new a(1384, DisplayPowerModeSet.class), new a(1385, GDriveFileExists.class), new a(1386, WifiApClientsConnected.class), new a(1387, EthernetTetherSetState.class), new a(1388, FeatureUsage.class), new a(1389, TextRecognition.class), new a(1390, UsbConfigured.class), new a(1391, UsbFunctionSet.class), new a(1392, QrCodeGenerate.class), new a(1393, BluetoothDeviceBondRemove.class), new a(1394, DisplayPowerMode.class), new a(1395, FlashlightEnabled.class), new a(1396, ProfileQuietModeEnabled.class), new a(1397, ProfileQuietModeRequest.class), new a(1398, SoftwareKeyboardVisible.class), new a(1399, WallpaperColorsGet.class), new a(1400, DtmfTonePlay.class), new a(1401, DtmfToneStop.class), new a(1402, UsbDeviceAttached.class), new a(1403, DeviceSecure.class), new a(1404, InspectTextEdit.class), new a(1405, OneDriveDelete.class), new a(1406, OneDriveDownload.class), new a(1407, OneDriveFileExists.class), new a(1408, OneDriveList.class), new a(1409, OneDriveMakeDirectory.class), new a(1410, OneDriveUpload.class), new a(1411, BarcodeScan.class), new a(1412, DestructuringAssign.class), new a(1413, FloatingButtonShow.class), new a(1414, FileMultipartExtract.class), new a(1415, HttpAcceptTcp.class), new a(1416, HttpResponse.class), new a(1417, FileApkExtract.class), new a(1418, ContentProviderCall.class), new a(1419, C1631a0.class), new a(1420, ContentWrite.class), new a(1421, AppWidgetConfigure.class), new a(1422, InterfaceRequest.class), new a(1423, InterfaceLayoutUpdate.class), new a(1424, InterfaceClicked.class), new a(1425, InterfaceAdapterUpdate.class), new a(1426, DreamSetup.class), new a(1427, InterfaceItemRequest.class), new a(1428, WallpaperSetup.class), new a(1429, WallpaperCreated.class), new a(1430, DreamCreated.class), new j(), new b(2, Boolean.class), new k(), new l(), new b(5, Byte.class), new m(), new n(), new b(8, Character.class), new o(), new p(), new b(11, Double.class), new q(), new r(), new b(14, Float.class), new a(), new b(), new b(17, Integer.class), new c(), new C0049d(), new b(20, Long.class), new e(), new f(), new b(23, Short.class), new C0050g(), new h(), new b(26, String.class), new b(27, Object.class), new a(28, J3.a.class), new a(29, J3.e.class), new b(30, boolean[].class), new b(31, byte[].class), new b(32, char[].class), new b(33, double[].class), new b(34, float[].class), new b(35, int[].class), new b(36, long[].class), new b(37, short[].class), new a(38, n3.b.class), new a(39, n3.d.class), new i(), new b(41, J3.b.class));

        public class a extends R3.f<float[]> {
            public a() {
                super(15, float[].class);
            }

            @Override // R3.f
            public final float[] a(R3.c cVar) {
                int d8 = cVar.d();
                float[] fArr = new float[d8];
                int i8 = 0;
                while (true) {
                    d8--;
                    if (d8 < 0) {
                        cVar.f(fArr);
                        return fArr;
                    }
                    fArr[i8] = cVar.readFloat();
                    i8++;
                }
            }

            @Override // R3.f
            public final void b(R3.d dVar, float[] fArr) {
                float[] fArr2 = fArr;
                int length = fArr2.length;
                dVar.f(length);
                int i8 = 0;
                while (true) {
                    length--;
                    if (length < 0) {
                        return;
                    }
                    dVar.writeFloat(fArr2[i8]);
                    i8++;
                }
            }
        }

        public class b extends R3.f<Integer> {
            public b() {
                super(16, Integer.class);
            }

            @Override // R3.f
            public final Integer a(R3.c cVar) {
                Integer valueOf = Integer.valueOf(cVar.a());
                cVar.f(valueOf);
                return valueOf;
            }

            @Override // R3.f
            public final void b(R3.d dVar, Integer num) {
                dVar.c(num.intValue());
            }
        }

        public class c extends R3.f<int[]> {
            public c() {
                super(18, int[].class);
            }

            @Override // R3.f
            public final int[] a(R3.c cVar) {
                int d8 = cVar.d();
                int[] iArr = new int[d8];
                int i8 = 0;
                while (true) {
                    d8--;
                    if (d8 < 0) {
                        cVar.f(iArr);
                        return iArr;
                    }
                    iArr[i8] = cVar.a();
                    i8++;
                }
            }

            @Override // R3.f
            public final void b(R3.d dVar, int[] iArr) {
                int[] iArr2 = iArr;
                int length = iArr2.length;
                dVar.f(length);
                int i8 = 0;
                while (true) {
                    length--;
                    if (length < 0) {
                        return;
                    }
                    dVar.c(iArr2[i8]);
                    i8++;
                }
            }
        }

        /* renamed from: R3.g$d$d, reason: collision with other inner class name */
        public class C0049d extends R3.f<Long> {
            public C0049d() {
                super(19, Long.class);
            }

            @Override // R3.f
            public final Long a(R3.c cVar) {
                Long valueOf = Long.valueOf(cVar.b());
                cVar.f(valueOf);
                return valueOf;
            }

            @Override // R3.f
            public final void b(R3.d dVar, Long l8) {
                dVar.d(l8.longValue());
            }
        }

        public class e extends R3.f<long[]> {
            public e() {
                super(21, long[].class);
            }

            @Override // R3.f
            public final long[] a(R3.c cVar) {
                int d8 = cVar.d();
                long[] jArr = new long[d8];
                int i8 = 0;
                while (true) {
                    d8--;
                    if (d8 < 0) {
                        cVar.f(jArr);
                        return jArr;
                    }
                    jArr[i8] = cVar.b();
                    i8++;
                }
            }

            @Override // R3.f
            public final void b(R3.d dVar, long[] jArr) {
                long[] jArr2 = jArr;
                int length = jArr2.length;
                dVar.f(length);
                int i8 = 0;
                while (true) {
                    length--;
                    if (length < 0) {
                        return;
                    }
                    dVar.d(jArr2[i8]);
                    i8++;
                }
            }
        }

        public class f extends R3.f<Short> {
            public f() {
                super(22, Short.class);
            }

            @Override // R3.f
            public final Short a(R3.c cVar) {
                Short valueOf = Short.valueOf(cVar.readShort());
                cVar.f(valueOf);
                return valueOf;
            }

            @Override // R3.f
            public final void b(R3.d dVar, Short sh) {
                dVar.writeShort(sh.shortValue());
            }
        }

        /* renamed from: R3.g$d$g, reason: collision with other inner class name */
        public class C0050g extends R3.f<short[]> {
            public C0050g() {
                super(24, short[].class);
            }

            @Override // R3.f
            public final short[] a(R3.c cVar) {
                int d8 = cVar.d();
                short[] sArr = new short[d8];
                int i8 = 0;
                while (true) {
                    d8--;
                    if (d8 < 0) {
                        cVar.f(sArr);
                        return sArr;
                    }
                    sArr[i8] = cVar.readShort();
                    i8++;
                }
            }

            @Override // R3.f
            public final void b(R3.d dVar, short[] sArr) {
                short[] sArr2 = sArr;
                int length = sArr2.length;
                dVar.f(length);
                int i8 = 0;
                while (true) {
                    length--;
                    if (length < 0) {
                        return;
                    }
                    dVar.writeShort(sArr2[i8]);
                    i8++;
                }
            }
        }

        public class h extends R3.f<String> {
            public h() {
                super(25, String.class);
            }

            @Override // R3.f
            public final String a(R3.c cVar) {
                String readUTF = cVar.readUTF();
                cVar.f(readUTF);
                return readUTF;
            }

            @Override // R3.f
            public final void b(R3.d dVar, String str) {
                dVar.writeUTF(str);
            }
        }

        public class i extends R3.f<J3.b> {
            public i() {
                super(40, J3.b.class);
            }

            @Override // R3.f
            public final J3.b a(R3.c cVar) {
                J3.b V7 = J3.b.V(cVar);
                cVar.f(V7);
                return V7;
            }

            @Override // R3.f
            public final void b(R3.d dVar, J3.b bVar) {
                J3.b bVar2 = bVar;
                int i8 = bVar2.f4638X;
                if (i8 == 0) {
                    dVar.c(0);
                    return;
                }
                int[] iArr = bVar2.f4639Y;
                dVar.c(i8 * iArr.length);
                for (int i9 : iArr) {
                    dVar.writeInt(i9);
                }
            }
        }

        public class j extends R3.f<Boolean> {
            public j() {
                super(1, Boolean.class);
            }

            @Override // R3.f
            public final Boolean a(R3.c cVar) {
                Boolean valueOf = Boolean.valueOf(cVar.readBoolean());
                cVar.f(valueOf);
                return valueOf;
            }

            @Override // R3.f
            public final void b(R3.d dVar, Boolean bool) {
                dVar.write(bool.booleanValue() ? 1 : 0);
            }
        }

        public class k extends R3.f<boolean[]> {
            public k() {
                super(3, boolean[].class);
            }

            @Override // R3.f
            public final boolean[] a(R3.c cVar) {
                int d8 = cVar.d();
                boolean[] zArr = new boolean[d8];
                int i8 = 0;
                while (true) {
                    d8--;
                    if (d8 < 0) {
                        cVar.f(zArr);
                        return zArr;
                    }
                    zArr[i8] = cVar.readBoolean();
                    i8++;
                }
            }

            @Override // R3.f
            public final void b(R3.d dVar, boolean[] zArr) {
                boolean[] zArr2 = zArr;
                int length = zArr2.length;
                dVar.f(length);
                int i8 = 0;
                while (true) {
                    length--;
                    if (length < 0) {
                        return;
                    }
                    dVar.write(zArr2[i8] ? 1 : 0);
                    i8++;
                }
            }
        }

        public class l extends R3.f<Byte> {
            public l() {
                super(4, Byte.class);
            }

            @Override // R3.f
            public final Byte a(R3.c cVar) {
                Byte valueOf = Byte.valueOf((byte) cVar.readUnsignedByte());
                cVar.f(valueOf);
                return valueOf;
            }

            @Override // R3.f
            public final void b(R3.d dVar, Byte b8) {
                dVar.write(b8.byteValue());
            }
        }

        public class m extends R3.f<byte[]> {
            public m() {
                super(6, byte[].class);
            }

            @Override // R3.f
            public final byte[] a(R3.c cVar) {
                int d8 = cVar.d();
                byte[] bArr = new byte[d8];
                int i8 = 0;
                while (true) {
                    d8--;
                    if (d8 < 0) {
                        cVar.f(bArr);
                        return bArr;
                    }
                    bArr[i8] = (byte) cVar.readUnsignedByte();
                    i8++;
                }
            }

            @Override // R3.f
            public final void b(R3.d dVar, byte[] bArr) {
                byte[] bArr2 = bArr;
                int length = bArr2.length;
                dVar.f(length);
                int i8 = 0;
                while (true) {
                    length--;
                    if (length < 0) {
                        return;
                    }
                    dVar.write(bArr2[i8]);
                    i8++;
                }
            }
        }

        public class n extends R3.f<Character> {
            public n() {
                super(7, Character.class);
            }

            @Override // R3.f
            public final Character a(R3.c cVar) {
                Character valueOf = Character.valueOf((char) cVar.readShort());
                cVar.f(valueOf);
                return valueOf;
            }

            @Override // R3.f
            public final void b(R3.d dVar, Character ch) {
                dVar.writeShort(ch.charValue());
            }
        }

        public class o extends R3.f<char[]> {
            public o() {
                super(9, char[].class);
            }

            @Override // R3.f
            public final char[] a(R3.c cVar) {
                int d8 = cVar.d();
                char[] cArr = new char[d8];
                int i8 = 0;
                while (true) {
                    d8--;
                    if (d8 < 0) {
                        cVar.f(cArr);
                        return cArr;
                    }
                    cArr[i8] = (char) cVar.readShort();
                    i8++;
                }
            }

            @Override // R3.f
            public final void b(R3.d dVar, char[] cArr) {
                char[] cArr2 = cArr;
                int length = cArr2.length;
                dVar.f(length);
                int i8 = 0;
                while (true) {
                    length--;
                    if (length < 0) {
                        return;
                    }
                    dVar.writeShort(cArr2[i8]);
                    i8++;
                }
            }
        }

        public class p extends R3.f<Double> {
            public p() {
                super(10, Double.class);
            }

            @Override // R3.f
            public final Double a(R3.c cVar) {
                Double valueOf = Double.valueOf(cVar.readDouble());
                cVar.f(valueOf);
                return valueOf;
            }

            @Override // R3.f
            public final void b(R3.d dVar, Double d8) {
                dVar.writeDouble(d8.doubleValue());
            }
        }

        public class q extends R3.f<double[]> {
            public q() {
                super(12, double[].class);
            }

            @Override // R3.f
            public final double[] a(R3.c cVar) {
                int d8 = cVar.d();
                double[] dArr = new double[d8];
                int i8 = 0;
                while (true) {
                    d8--;
                    if (d8 < 0) {
                        cVar.f(dArr);
                        return dArr;
                    }
                    dArr[i8] = cVar.readDouble();
                    i8++;
                }
            }

            @Override // R3.f
            public final void b(R3.d dVar, double[] dArr) {
                double[] dArr2 = dArr;
                int length = dArr2.length;
                dVar.f(length);
                int i8 = 0;
                while (true) {
                    length--;
                    if (length < 0) {
                        return;
                    }
                    dVar.writeDouble(dArr2[i8]);
                    i8++;
                }
            }
        }

        public class r extends R3.f<Float> {
            public r() {
                super(13, Float.class);
            }

            @Override // R3.f
            public final Float a(R3.c cVar) {
                Float valueOf = Float.valueOf(cVar.readFloat());
                cVar.f(valueOf);
                return valueOf;
            }

            @Override // R3.f
            public final void b(R3.d dVar, Float f8) {
                dVar.writeFloat(f8.floatValue());
            }
        }
    }

    public g(f<?>... fVarArr) {
        this.f6418a = fVarArr;
        this.f6419b = new HashMap(fVarArr.length);
        for (f<?> fVar : fVarArr) {
            this.f6419b.put(fVar.f6417b, fVar);
        }
        Arrays.sort(this.f6418a, f.f6415c);
    }
}
