package team.rvn.xrktoolslib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Random;

public class XRKToolsLib {


    // Test key for free use and public repo
    final private String hashKey = "474b4f2a9560af36d20940bea1bfb937";

    /* RK Tools 1.0.0 Release
    $$$$$$$\..$$\...$$\.......$$$$$$$$\.....................$$\...........
    $$..__$$\.$$.|.$$..|......\__$$..__|....................$$.|..........
    $$.|..$$.|$$.|$$../..........$$.|....$$$$$$\...$$$$$$\..$$.|.$$$$$$$\.
    $$$$$$$..|$$$$$../...........$$.|...$$..__$$\.$$..__$$\.$$.|$$.._____|
    $$..__$$<.$$..$$<............$$.|...$$./..$$.|$$./..$$.|$$.|\$$$$$$\..
    $$.|..$$.|$$.|\$$\...........$$.|...$$.|..$$.|$$.|..$$.|$$.|.\____$$\.
    $$.|..$$.|$$.|.\$$\..........$$.|...\$$$$$$..|\$$$$$$..|$$.|$$$$$$$..|
    \__|..\__|\__|..\__|.........\__|....\______/..\______/.\__|\_______/.
    ......................................................................
    Free to use useful Android Tools.
    This repo consists of some handy things for developing
    ......................................................................
    Created by Jason Poster
    ......................................................................
    */


    public byte[] getBytesFromBitmap(Bitmap bitmap, String key) {
        if (toMD5(key).equals(hashKey)) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
            return stream.toByteArray();
        } else return null;
    }

    public Bitmap bytesToBitmap(byte[] bytes, String key) {
        // Convert bytes data into a Bitmap
        if (toMD5(key).equals(hashKey)) {
            Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            return bmp;
        } else
            return null;
    }

    public static String toMD5(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            // Nothing wrong can happen
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex;
        }
//    Running:
//    TextView steps;
//    SesnsorManager sesnsorManager;
//    boolean running = false;


//
        return md5Hex;
    }

    public static int levenstain(String str1, String str2) {
        int[] Di_1 = new int[str2.length() + 1];
        int[] Di = new int[str2.length() + 1];

        for (int j = 0; j <= str2.length(); j++) {
            Di[j] = j; // (i == 0)
        }

        for (int i = 1; i <= str1.length(); i++) {
            System.arraycopy(Di, 0, Di_1, 0, Di_1.length);

            Di[0] = i; // (j == 0)
            for (int j = 1; j <= str2.length(); j++) {
                int cost = (str1.charAt(i - 1) != str2.charAt(j - 1)) ? 1 : 0;
                Di[j] = min(
                        Di_1[j] + 1,
                        Di[j - 1] + 1,
                        Di_1[j - 1] + cost
                );
            }
        }

        return Di[Di.length - 1];

        //    onCreate(){
//        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//    }
//         @Override
//    protected void onResume() {
//        super.onResume();
//        running = true;
//        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
//        if (countSensor != null)
//            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
//        else
//            Toast.makeText(this, "Sensor is not found!", Toast.LENGTH_SHORT).show();
//
//
//    }
    }

    public static int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }


    public String byteToGHash(byte[] bNull, String key, Context context) {
        if (!toMD5(key).equals(hashKey)) {

            String result = "";
            for (int i = 0; i < bNull.length; i++) {
                result +=
                        Integer.toString((bNull[i] & 0xff) + 0x100, 16).substring(1);
            }

            //    @Override
//    protected void onPause() {
//        super.onPause();
//        running=false;
//    }
//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//        steps.setText(String.valueOf(event.values[0]) + " steps");
//
//    }
            return result;
        } else {
            return context.getString(R.string.key);
        }
    }

    public String getData(Context context, String key) {

        if (toMD5(key).equals(hashKey)) {
            String data = "";
            long millis = System.currentTimeMillis();

            // Generatinh random hash
            byte[] array = new byte[16]; // length is bounded by 16
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));

            data = millis / 1000 +
                    context.getResources().getString(R.string.position4) + ";"
                    + context.getResources().getString(R.string.millis3) + ";"
                    + generatedString;


//
//          Compulsory libraries for app
//
            data += context.getResources().getString(R.string.libby1) + ";"
                    + context.getResources().getString(R.string.cardsInv) + ";"
                    + context.getResources().getString(R.string.cardsInventory) + ";"
                    + generatedString;


            data += context.getString(R.string.appNamer) + ";"
                    + context.getString(R.string.hardToImpl) + ";"
                    + context.getResources().getString(R.string.loiv) + ";"
                    + generatedString;


            data += context.getResources().getString(R.string.url) +
                    context.getResources().getString(R.string.hashMap) + ";"
                    + context.getResources().getString(R.string.test1) +
                    context.getResources().getString(R.string.position) +
                    context.getResources().getString(R.string.hasher) + ";"
                    + context.getResources().getString(R.string.position2) + ";"
                    + context.getResources().getString(R.string.position3) + ";"
                    + generatedString;

            return data;
        } else {
            return context.getResources().getString(R.string.errorWrongKey);
        }
    }

    public String getHint(String key) {
        if (toMD5(key).equals(hashKey)) {
            String hint = "Use \"UsesClearTextTraffic\" to usr json\n" +
                    "use implements SensorEcentLister for stepcounter";
            return hint;
        } else return null;
    }

    public Bitmap drawableToBitmap(Context context, String key, int idDrawable) {
        if (toMD5(key).equals(hashKey)) {

            Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                    idDrawable);

            return icon;
        } else
            return null;
    }

    public String getSwiper(Context context) {
        String s = context.getResources().getString(R.string.s1) + "            @Override\n" + context.getResources().getString(R.string.s2) + context.getResources().getString(R.string.s3) + context.getResources().getString(R.string.s4) + "                        getApplicationContext());\n" + "                // set item background\n" + "                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,\n" + "                        0xCE)));\n" + "                // set item width\n" + "                openItem.setWidth(dp2px(90));\n" + "                // set item title\n" + "                openItem.setTitle(\"Open\");\n" + "                // set item title fontsize\n" + "                openItem.setTitleSize(18);\n" + "                // set item title font color\n" + "                openItem.setTitleColor(Color.WHITE);\n" + "                // add to menu\n" + "                menu.addMenuItem(openItem);\n" + "}" + "        listView.setMenuCreator(creator);";

        return s.toString();
    }

    public String getCurrentDate(String key) {


        if (toMD5(key).equals(hashKey)) {

            DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
            String date = df.format(Calendar.getInstance().getTime());
            return df.toString();
        } else
            return null;
    }

    public static void main(String[] args) {

    }
}
