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
import java.util.Arrays;
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

    public String anagramCheck(char str1[], char str2[], int NO_OF_CHARS, Context context, String key) {

        if (toMD5(key).equals(hashKey)) {
            String collections = "RKTools info:\u2028You must implement all libraries to use our library  properly!\u2028If you have any issues send email to: jasonp87@gmail.com\u2028// LIBRARIES\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "// JSONObject Request\n" + "// Put in the manifest file\u2028android:usesCleartextTraffic=\"true\"\n" + "\n" + "private void sendRequest() {\n" + "    String url = \"http://cars.areas.su/logout\";\n" + "    JSONObject jsonObject = new JSONObject();\n" + "    try {\n" + "        jsonObject.put(\"username\", \"-\");\n" + "        jsonObject.put(\"password\", \"-\");\n" + "        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject\n" + "                , new Response.Listener<JSONObject>() {\n" + "            @Override\n" + "            public void onResponse(JSONObject response) {\n" + "                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();\n" + "\n" + "            }\n" + "        }, new Response.ErrorListener() {\n" + "            @Override\n" + "            public void onErrorResponse(VolleyError error) {\n" + "                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();\n" + "            }\n" + "        }){\n" + "            @Override\n" + "            protected Map<String, String> getParams() throws AuthFailureError {\n" + "                Map<String, String> params = new HashMap<>();\n" + "                return params;\n" + "            }\n" + "        };\n" + "\n" + "        RequestQueue requestQueue = Volley.newRequestQueue(this);\n" + "        requestQueue.add(jsonObjectRequest);\n" + "        requestQueue.start();\n" + "    } catch (JSONException e) {\n" + "        e.printStackTrace();\n" + "    }\n" + "\n" + "}\n" + "\n" + "\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "Key: AIzaSyD4bXnZYjwZIiYaf_EnpwkkyF5AqJGGVgI\n" + "\n" + "\n" + "WAKE LOCK PERMISSION\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "\u2028maven { url 'https://jitpack.io' }\n" + "implementation 'com.jaredrummler:material-spinner:1.3.1'\u2028implementation 'com.github.chrisbanes:PhotoView:2.3.0'\u2028implementation 'com.squareup.picasso:picasso:2.5.2'\n" + "implementation 'de.hdodenhof:circleimageview:3.0.1'\u2028implementation 'androidx.cardview:cardview:1.0.0'\n" + "implementation('com.cs:googlemaproute:1.0.0') {\n" + "    exclude group: \"com.google.firebase\"\n" + "}\n" + "implementation 'com.android.volley:volley:1.1.1'\n" + "implementation 'com.baoyz.swipemenulistview:library:1.3.0'\n" + "implementation 'com.github.JasonPoster:RKTools:0.8.5’\n" + "implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'\u2028implementation 'com.github.AravindVijay7:GeoLocator-Android:1.0.2'\n" + "mplementation 'com.github.bmarrdev:android-DecoView-charting:v1.2'\n" + "implementation 'com.github.IsPra94:EasyGifView:1.0.1'\n" + "implementation 'com.squareup.picasso:picasso:2.3.2'\n" + "implementation 'com.nineoldandroids:library:2.4.0'\n" + "implementation 'com.daimajia.slider:library:1.1.5@aar'\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "// SQLITE\n" + "\n" + "public class MainActivity extends AppCompatActivity {\n" + "\n" + "    ArrayList<String> alLogins;\n" + "    ArrayList<String> alPasswords;\n" + "    ArrayList<Integer> alids;\n" + "\n" + "    EditText etLogin, etPassword;\n" + "    Button btnAdd;\n" + "    ListView listView;\n" + "\n" + "    TextView tvLogin, tvPassword;\n" + "\n" + "    SQLiteDatabase sqLiteDatabase;\n" + "    CustomAdapter customAdapter;\n" + "    int clickedId;\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_main);\n" + "\n" + "        alLogins = new ArrayList<>();\n" + "        alPasswords = new ArrayList<>();\n" + "        alids = new ArrayList<>();\n" + "\n" + "        etLogin = findViewById(R.id.etLogin);\n" + "        etPassword = findViewById(R.id.etPassword);\n" + "\n" + "        btnAdd = findViewById(R.id.btnAdd);\n" + "        listView = findViewById(R.id.theNotoriousListView);\n" + "        customAdapter = new CustomAdapter();\n" + "\n" + "        btnAdd.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View view) {\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'\" + etLogin.getText().toString() + \"\\',\\' \" + etPassword.getText().toString() + \"\\')\");\n" + "                getdataFromBase();\n" + "            }\n" + "        });\n" + "\n" + "        sqLiteDatabase = openOrCreateDatabase(\"app.db\", MODE_PRIVATE, null, null);\n" + "        try {\n" + "            sqLiteDatabase.execSQL(\"CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,login TEXT, password TEXT);\");\n" + "            Cursor q = sqLiteDatabase.rawQuery(\"SELECT * from users\", null);\n" + "            if (!q.moveToFirst()) {\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'prabeesh\\',\\' prfasd123\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'putin\\',\\' prad123\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'indus\\',\\' prfsad123\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'genius\\',\\' pr1fsd23\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'klimovich\\',\\' kp11onelove\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'vennumallesh\\',\\' pr213123\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'kadirov\\',\\' pr4123\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'d4nny\\',\\' pr213123\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'bbbbbb\\',\\' pr121423\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'nigger\\',\\'nigger\\')\");\n" + "\n" + "\n" + "            }\n" + "            getdataFromBase();\n" + "            customAdapter = new CustomAdapter();\n" + "            listView.setAdapter(customAdapter);\n" + "        } catch (Exception e) {\n" + "            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();\n" + "        }\n" + "\n" + "        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {\n" + "            @Override\n" + "            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {\n" + "\n" + "                 clickedId = i;\n" + "                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);\n" + "                builder.setTitle(\"Действия\").setMessage(\"Изменить/удалить?\").setPositiveButton(\"Удалить\", new DialogInterface.OnClickListener() {\n" + "                    @Override\n" + "                    public void onClick(DialogInterface dialogInterface, int i) {\n" + "                        sqLiteDatabase.execSQL(\"DELETE FROM users WHERE \\'id\\'=\" + alids.get(clickedId) + \"\");\n" + "                        alids.remove(clickedId);\n" + "                        alLogins.remove(clickedId);\n" + "                        alPasswords.remove(clickedId);\n" + "                        customAdapter.notifyDataSetChanged();\n" + "                    }\n" + "                }).setNegativeButton(\"Изменить\", new DialogInterface.OnClickListener() {\n" + "                    @Override\n" + "                    public void onClick(DialogInterface dialogInterface, int i) {\n" + "                        ContentValues cv = new ContentValues();\n" + "                        cv.put(\"login\", etLogin.getText().toString());\n" + "                        cv.put(\"password\", etPassword.getText().toString());\n" + "                       int count =  sqLiteDatabase.update(\"users\",cv,\"id = \" + alids.get(clickedId),null);\n" + "                        getdataFromBase();\n" + "                    }\n" + "                });\n" + "\n" + "                AlertDialog alertDialog = builder.create();\n" + "                alertDialog.show();\n" + "\n" + "                return false;\n" + "            }\n" + "        });\n" + "    }\n" + "\n" + "    private class CustomAdapter extends BaseAdapter {\n" + "\n" + "        @Override\n" + "        public int getCount() {\n" + "            return alLogins.size();\n" + "        }\n" + "\n" + "        @Override\n" + "        public Object getItem(int position) {\n" + "            return null;\n" + "        }\n" + "\n" + "        @Override\n" + "        public long getItemId(int position) {\n" + "            return 0;\n" + "        }\n" + "\n" + "        @Override\n" + "        public View getView(int position, View convertView, ViewGroup parent) {\n" + "            if (convertView == null) {\n" + "                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.listview_item, null);\n" + "            }\n" + "\n" + "            tvLogin = convertView.findViewById(R.id.tvLogin);\n" + "            tvPassword = convertView.findViewById(R.id.tvPassword);\n" + "\n" + "            tvLogin.setText(alLogins.get(position));\n" + "            tvPassword.setText(alPasswords.get(position));\n" + "\n" + "            return convertView;\n" + "        }\n" + "    }\n" + "\n" + "    private void getdataFromBase() {\n" + "        alids.clear();\n" + "        alLogins.clear();\n" + "        alPasswords.clear();\n" + "        Cursor q = sqLiteDatabase.rawQuery(\"SELECT * from users\", null);\n" + "        if (q.moveToFirst()) {\n" + "\n" + "            q.moveToFirst();\n" + "            do {\n" + "\n" + "                alids.add(q.getInt(0));\n" + "                alLogins.add(q.getString(1));\n" + "                alPasswords.add(q.getString(2));\n" + "\n" + "            } while (q.moveToNext());\n" + "\n" + "            customAdapter.notifyDataSetChanged();\n" + "        }\n" + "    }\n" + "}\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "// Image Slider\u2028\n" + "public class MainActivity extends AppCompatActivity {\n" + "\n" + "    SliderLayout sliderShow;\n" + "\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_main);\n" + "\n" + "        sliderShow =  findViewById(R.id.slider);\n" + "\n" + "        TextSliderView textSliderView = new TextSliderView(this);\n" + "        textSliderView.description(\"Информация\")\n" + "                .image(\"https://i.imgur.com/paElV0s.png\");\n" + "\n" + "        TextSliderView textSliderView2 = new TextSliderView(this);\n" + "        textSliderView2.description(\"Worldskills\")\n" + "                .image(\"https://i.imgur.com/ERq6Trh.png\");\n" + "\n" + "        TextSliderView textSliderView3 = new TextSliderView(this);\n" + "        textSliderView3.description(\"Вакансии\")\n" + "                .image(\"https://i.imgur.com/tZG3jyX.png\");\n" + "\n" + "        TextSliderView textSliderView4 = new TextSliderView(this);\n" + "        textSliderView4\n" + "                .image(\"https://i.imgur.com/O9gYSLm.png\");\n" + "\n" + "        \n" + "        sliderShow.addSlider(textSliderView);\n" + "        sliderShow.addSlider(textSliderView2);\n" + "        sliderShow.addSlider(textSliderView3);\n" + "        sliderShow.addSlider(textSliderView4);\n" + "\n" + "    }\n" + "\n" + "\n" + "    @Override\n" + "    protected void onStop() {\n" + "        // Чтобы не было утечки памяти\n" + "        sliderShow.stopAutoCycle();\n" + "        super.onStop();\n" + "    }\n" + "}\n" + "\n" + "// XML\n" + "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" + "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" + "    xmlns:tools=\"http://schemas.android.com/tools\"\n" + "    android:layout_width=\"match_parent\"\n" + "    android:layout_height=\"match_parent\"\n" + "    tools:context=\".MainActivity\">\n" + "\n" + "    <com.daimajia.slider.library.SliderLayout\n" + "        android:id=\"@+id/slider\"\n" + "        android:layout_width=\"match_parent\"\n" + "        android:layout_height=\"200dp\"\n" + "        >\n" + "\n" + "    <com.daimajia.slider.library.Indicators.PagerIndicator\n" + "        android:id=\"@+id/custom_indicator\"\n" + "        android:layout_width=\"wrap_content\"\n" + "        android:layout_height=\"wrap_content\"\n" + "        android:gravity=\"center\"\n" + "<— app:pager_animation=\"Accordion\" —>\n" + "\n" + "\n" + "        />\n" + "    </com.daimajia.slider.library.SliderLayout>\n" + "</RelativeLayout>\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "// GOOGLE MAPS\u2028\u2028package com.example.myapplication.frags;\n" + "\n" + "import android.content.Context;\n" + "import android.net.Uri;\n" + "import android.os.Bundle;\n" + "\n" + "import androidx.fragment.app.Fragment;\n" + "\n" + "import android.view.LayoutInflater;\n" + "import android.view.View;\n" + "import android.view.ViewGroup;\n" + "import android.widget.Toast;\n" + "\n" + "import com.cs.googlemaproute.DrawRoute;\n" + "import com.example.myapplication.R;\n" + "import com.google.android.gms.maps.CameraUpdateFactory;\n" + "import com.google.android.gms.maps.GoogleMap;\n" + "import com.google.android.gms.maps.OnMapReadyCallback;\n" + "import com.google.android.gms.maps.SupportMapFragment;\n" + "import com.google.android.gms.maps.model.LatLng;\n" + "import com.google.android.gms.maps.model.MarkerOptions;\n" + "\n" + "/**\n" + " * A simple {@link Fragment} subclass.\n" + " * Activities that contain this fragment must implement the\n" + " * {@link LuxuryTransportFragment.OnFragmentInteractionListener} interface\n" + " * to handle interaction events.\n" + " * Use the {@link LuxuryTransportFragment#newInstance} factory method to\n" + " * create an instance of this fragment.\n" + " */\n" + "public class LuxuryTransportFragment extends Fragment implements OnMapReadyCallback {\n" + "\n" + "\n" + "    private GoogleMap mMap;\n" + "\n" + "\n" + "    // TODO: Rename parameter arguments, choose names that match\n" + "    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER\n" + "    private static final String ARG_PARAM1 = \"param1\";\n" + "    private static final String ARG_PARAM2 = \"param2\";\n" + "\n" + "    // TODO: Rename and change types of parameters\n" + "    private String mParam1;\n" + "    private String mParam2;\n" + "\n" + "    private OnFragmentInteractionListener mListener;\n" + "\n" + "    public LuxuryTransportFragment() {\n" + "        // Required empty public constructor\n" + "    }\n" + "\n" + "    /**\n" + "     * Use this factory method to create a new instance of\n" + "     * this fragment using the provided parameters.\n" + "     *\n" + "     * @param param1 Parameter 1.\n" + "     * @param param2 Parameter 2.\n" + "     * @return A new instance of fragment LuxuryTransportFragment.\n" + "     */\n" + "    // TODO: Rename and change types and number of parameters\n" + "    public static LuxuryTransportFragment newInstance(String param1, String param2) {\n" + "        LuxuryTransportFragment fragment = new LuxuryTransportFragment();\n" + "        Bundle args = new Bundle();\n" + "        args.putString(ARG_PARAM1, param1);\n" + "        args.putString(ARG_PARAM2, param2);\n" + "        fragment.setArguments(args);\n" + "        return fragment;\n" + "    }\n" + "\n" + "    @Override\n" + "    public void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        if (getArguments() != null) {\n" + "            mParam1 = getArguments().getString(ARG_PARAM1);\n" + "            mParam2 = getArguments().getString(ARG_PARAM2);\n" + "        }\n" + "    }\n" + "\n" + "    @Override\n" + "    public View onCreateView(LayoutInflater inflater, ViewGroup container,\n" + "                             Bundle savedInstanceState) {\n" + "        // Inflate the layout for this fragment\n" + "        View view = inflater.inflate(R.layout.fragment_luxury_transport, container, false);\n" + "        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()\n" + "                .findFragmentById(R.id.map);\n" + "        mapFragment.getMapAsync(this);\n" + "\n" + "        return view;\n" + "    }\n" + "\n" + "    // TODO: Rename method, update argument and hook method into UI event\n" + "    public void onButtonPressed(Uri uri) {\n" + "        if (mListener != null) {\n" + "            mListener.onFragmentInteraction(uri);\n" + "        }\n" + "    }\n" + "\n" + "\n" + "    @Override\n" + "    public void onDetach() {\n" + "        super.onDetach();\n" + "        mListener = null;\n" + "    }\n" + "\n" + "    @Override\n" + "    public void onMapReady(GoogleMap googleMap) {\n" + "        mMap = googleMap;\n" + "\n" + "        // Add a marker in Sydney and move the camera\n" + "        LatLng sydney = new LatLng(-34, 151);\n" + "        LatLng sydney2 = new LatLng(-26, 153);\n" + "\n" + "        DrawRoute drawRoute = new DrawRoute(new DrawRoute.onDrawRoute() {\n" + "            @Override\n" + "            public void afterDraw(String result) {\n" + "                Toast.makeText(getContext(), result.toString(), Toast.LENGTH_SHORT).show();\n" + "            }\n" + "        }, getContext());\n" + "\n" + "        drawRoute.setGmapAndKey(\"AIzaSyD4bXnZYjwZIiYaf_EnpwkkyF5AqJGGVgI\",mMap)\n" + "        .setColorHash(\"#ff0000\")\n" + "        .setFromLatLong(sydney.latitude,sydney.longitude).setToLatLong(sydney2.latitude,sydney2.longitude)\n" + "\n" + "        .setZoomLevel(12f).run();\n" + "\n" + "        mMap.addMarker(new MarkerOptions().position(sydney).title(\"Marker in Sydney\"));\n" + "        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));\n" + "    }\n" + "\n" + "    /**\n" + "     * This interface must be implemented by activities that contain this\n" + "     * fragment to allow an interaction in this fragment to be communicated\n" + "     * to the activity and potentially other fragments contained in that\n" + "     * activity.\n" + "     * <p>\n" + "     * See the Android Training lesson <a href=\n" + "     * \"http://developer.android.com/training/basics/fragments/communicating.html\"\n" + "     * >Communicating with Other Fragments</a> for more information.\n" + "     */\n" + "    public interface OnFragmentInteractionListener {\n" + "        // TODO: Update argument type and name\n" + "        void onFragmentInteraction(Uri uri);\n" + "    }\n" + "}\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "// GYROSCOPE + SHARED\u2028\u2028import android.app.ActivityOptions;\n" + "import android.content.Intent;\n" + "import android.hardware.Sensor;\n" + "import android.hardware.SensorEvent;\n" + "import android.hardware.SensorEventListener;\n" + "import android.hardware.SensorManager;\n" + "import android.os.Bundle;\n" + "import android.util.Pair;\n" + "import android.view.View;\n" + "import android.widget.ImageView;\n" + "import android.widget.RelativeLayout;\n" + "import android.widget.TextView;\n" + "import android.widget.Toast;\n" + "\n" + "public class MainActivity extends AppCompatActivity {\n" + "\n" + "    SensorManager sensorManager;\n" + "    Sensor gyro;\n" + "    SensorEventListener sensorEventListener;\n" + "    float res = 0;\n" + "    TextView textView;\n" + "    RelativeLayout relativeLayout;\n" + "    RelativeLayout rlFullBack;\n" + "\n" + "\n" + "    // Check shareIntent\n" + "    ImageView mAvatar;\n" + "    TextView mText;\n" + "\n" + "\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_main);\n" + "        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);\n" + "        gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);\n" + "\n" + "        // initialization\n" + "        mAvatar = findViewById(R.id.ivPrabo);\n" + "        mText = findViewById(R.id.tvPrabo);\n" + "        relativeLayout = findViewById(R.id.rlBack);\n" + "\n" + "        textView = findViewById(R.id.tvText);\n" + "        rlFullBack = findViewById(R.id.praboRelative);\n" + "\n" + "        rlFullBack.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);\n" + "\n" + "                Pair[] pairs = new Pair[3];\n" + "                pairs[0] = new Pair<View, String>(mAvatar, \"text\");\n" + "                pairs[1] = new Pair<View, String>(mText, \"photo\");\n" + "                pairs[2] = new Pair<View, String>(relativeLayout, \"whiteback\");\n" + "                ActivityOptions activityOptions;\n" + "                activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);\n" + "                startActivity(intent,activityOptions.toBundle());\n" + "            }\n" + "        });\n" + "\n" + "        if (gyro == null) {\n" + "            Toast.makeText(this, \"No sensor\", Toast.LENGTH_SHORT).show();\n" + "        }\n" + "        sensorEventListener = new SensorEventListener() {\n" + "            @Override\n" + "            public void onSensorChanged(SensorEvent event) {\n" + "                res += event.values[2];\n" + "                textView.setRotation(-res);\n" + "            }\n" + "\n" + "            @Override\n" + "            public void onAccuracyChanged(Sensor sensor, int accuracy) {\n" + "\n" + "            }\n" + "        };\n" + "\n" + "    }\n" + "\n" + "    @Override\n" + "    protected void onResume() {\n" + "        super.onResume();\n" + "        sensorManager.registerListener(sensorEventListener, gyro, SensorManager.SENSOR_DELAY_FASTEST);\n" + "    }\n" + "\n" + "    @Override\n" + "    protected void onPause() {\n" + "        super.onPause();\n" + "        sensorManager.unregisterListener(sensorEventListener);\n" + "    }\n" + "}\n" + "\n" + "\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "/// Collapsing\n" + "\n" + "<androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" + "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" + "    xmlns:tools=\"http://schemas.android.com/tools\"\n" + "    android:layout_width=\"match_parent\"\n" + "    android:layout_height=\"match_parent\"\n" + "    android:background=\"#eeeeee\"\n" + "\n" + "    tools:context=\"apps.jasonposter.in.Fragments.PipesAvailable\">\n" + "\n" + "    <com.google.android.material.appbar.AppBarLayout\n" + "        android:layout_width=\"wrap_content\"\n" + "        android:layout_height=\"wrap_content\"\n" + "        app:elevation=\"0dp\"\n" + "        android:id=\"@+id/appBar\">\n" + "\n" + "        <RelativeLayout\n" + "            android:layout_width=\"match_parent\"\n" + "            android:layout_height=\"wrap_content\"\n" + "            android:background=\"#eeeeee\"\n" + "\n" + "            app:layout_scrollFlags=\"scroll|enterAlways\">\n" + "\n" + "            <RelativeLayout\n" + "                android:id=\"@+id/rlFilters\"\n" + "                android:layout_width=\"match_parent\"\n" + "                android:layout_height=\"wrap_content\"\n" + "                android:layout_marginTop=\"20dp\"\n" + "                android:layout_marginBottom=\"20dp\">\n" + "\n" + "                <RelativeLayout\n" + "                    android:id=\"@+id/rlDiam\"\n" + "                    android:layout_width=\"wrap_content\"\n" + "                    android:layout_height=\"wrap_content\"\n" + "                    android:layout_marginStart=\"20dp\"\n" + "                    android:layout_marginEnd=\"20dp\">\n" + "\n" + "\n" + "                    <EditText\n" + "                        android:id=\"@+id/etDiam\"\n" + "                        android:layout_width=\"match_parent\"\n" + "                        android:layout_height=\"40dp\"\n" + "                        android:layout_toStartOf=\"@id/sDiam\"\n" + "                        android:background=\"@drawable/rounded_field_gray\"\n" + "                        android:hint=\"@string/tableDiam\"\n" + "                        android:inputType=\"number\"\n" + "                        android:textSize=\"14sp\" />\n" + "\n" + "\n" + "                    <Spinner\n" + "                        android:id=\"@+id/sDiam\"\n" + "                        android:layout_width=\"40dp\"\n" + "                        android:layout_height=\"40dp\"\n" + "                        android:layout_alignParentEnd=\"true\"\n" + "                        android:layout_centerVertical=\"true\"\n" + "                        android:layout_marginStart=\"10dp\"\n" + "                        android:background=\"@drawable/round_field_gray\"\n" + "                        android:spinnerMode=\"dialog\" />\n" + "\n" + "                    <ImageView\n" + "                        android:layout_width=\"wrap_content\"\n" + "                        android:layout_height=\"wrap_content\"\n" + "                        android:layout_alignParentEnd=\"true\"\n" + "                        android:layout_centerVertical=\"true\"\n" + "                        android:layout_marginEnd=\"8dp\"\n" + "                        android:contentDescription=\"@string/open_list\"\n" + "                        android:src=\"@drawable/ic_arrow_drop_down_black_24dp\" />\n" + "                </RelativeLayout>\n" + "\n" + "                <RelativeLayout\n" + "                    android:layout_width=\"wrap_content\"\n" + "                    android:layout_height=\"wrap_content\"\n" + "                    android:layout_below=\"@id/rlDiam\"\n" + "                    android:layout_marginStart=\"20dp\"\n" + "                    android:layout_marginTop=\"5dp\"\n" + "                    android:layout_marginEnd=\"20dp\">\n" + "\n" + "\n" + "                    <EditText\n" + "                        android:id=\"@+id/etThick\"\n" + "                        android:layout_width=\"match_parent\"\n" + "                        android:layout_height=\"40dp\"\n" + "                        android:layout_toStartOf=\"@id/sThick\"\n" + "                        android:background=\"@drawable/rounded_field_gray\"\n" + "                        android:hint=\"@string/thickness\"\n" + "                        android:inputType=\"number\"\n" + "                        android:textSize=\"14sp\" />\n" + "\n" + "                    <Spinner\n" + "                        android:id=\"@+id/sThick\"\n" + "                        android:layout_width=\"40dp\"\n" + "                        android:layout_height=\"40dp\"\n" + "                        android:layout_alignParentEnd=\"true\"\n" + "                        android:layout_centerVertical=\"true\"\n" + "                        android:layout_marginStart=\"10dp\"\n" + "                        android:background=\"@drawable/round_field_gray\"\n" + "                        android:spinnerMode=\"dialog\" />\n" + "\n" + "                    <ImageView\n" + "                        android:layout_width=\"wrap_content\"\n" + "                        android:layout_height=\"wrap_content\"\n" + "                        android:layout_alignParentEnd=\"true\"\n" + "                        android:layout_centerVertical=\"true\"\n" + "                        android:layout_marginEnd=\"8dp\"\n" + "                        android:contentDescription=\"@string/open_list\"\n" + "                        android:src=\"@drawable/ic_arrow_drop_down_black_24dp\" />\n" + "\n" + "                </RelativeLayout>\n" + "\n" + "\n" + "            </RelativeLayout>\n" + "        </RelativeLayout>\n" + "\n" + "\n" + "    </com.google.android.material.appbar.AppBarLayout>\n" + "\n" + "\n" + "    <androidx.recyclerview.widget.RecyclerView\n" + "        android:id=\"@+id/listViewPipes\"\n" + "        android:layout_width=\"match_parent\"\n" + "        android:layout_height=\"match_parent\"\n" + "        android:background=\"#eeeeee\"\n" + "        android:clipToPadding=\"false\"\n" + "        android:divider=\"@null\"\n" + "        android:dividerHeight=\"10.0sp\"\n" + "        android:paddingTop=\"5dp\"\n" + "        android:paddingBottom=\"15dp\"\n" + "        app:layout_behavior=\"com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior\"\n" + "        android:scrollbars=\"vertical\"\n" + "\n" + "        />\n" + "\n" + "////////////////////////////////////////////////// JAVA\n" + "Main{\n" + "// SET MANAGER TO RECYCLER\n" + "recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));\n" + "recyclerView.setAdapter(customAdapter);\n" + "\n" + "}\n" + "    private class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {\n" + "        @NonNull\n" + "        @Override\n" + "        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {\n" + "            //  Привязываем listview item\n" + "            View view = LayoutInflater.from(getContext()).inflate(R.layout.pipes_item, parent, false);\n" + "            return new Item(view);\n" + "        }\n" + "\n" + "        @Override\n" + "        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {\n" + "\n" + "            // Задаем значения\n" + "            ((Item) holder).tvAvailable.setText(alAvailable.get(position));\n" + "            ((Item) holder).tvDiam.setText(String.valueOf(alDiam.get(position)));\n" + "            ((Item) holder).tvGOST.setText(alGOST.get(position));\n" + "            ((Item) holder).tvMark.setText(alMark.get(position));\n" + "            ((Item) holder).tvPrice.setText(alPrice.get(position));\n" + "            ((Item) holder).rlPipeItem.setOnClickListener(new View.OnClickListener() {\n" + "                @Override\n" + "                public void onClick(View view) {\n" + "//                    Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();\n" + "                    if (mAuth.getCurrentUser() != null)\n" + "\n" + "                        startActivity(new Intent(getContext(), CameraRequestActivity.class));\n" + "                    else {\n" + "                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());\n" + "                        builder.setTitle(getResources().getString(R.string.auhtorization))\n" + "                                .setMessage(getResources().getString(R.string.orderAuthMessage))\n" + "                                .setPositiveButton(getString(R.string.logIn), new DialogInterface.OnClickListener() {\n" + "                                            @Override\n" + "                                            public void onClick(DialogInterface dialogInterface, int i) {\n" + "                                                Intent intent = new Intent(getContext(), MainActivity.class);\n" + "                                                startActivity(intent);\n" + "                                            }\n" + "                                        }\n" + "                                ).setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {\n" + "                                    @Override\n" + "                                    public void onClick(DialogInterface dialogInterface, int i) {\n" + "\n" + "                                    }\n" + "                                }\n" + "\n" + "                        );\n" + "                        AlertDialog alertDialog = builder.create();\n" + "                        alertDialog.show();\n" + "                    }\n" + "                }\n" + "            });\n" + "            if (alSide.size() > position)\n" + "                ((Item) holder).tvSide.setText(String.valueOf(alSide.get(position)));\n" + "\n" + "\n" + "        }\n" + "\n" + "        @Override\n" + "        public int getItemCount() {\n" + "            return alAvailable.size();\n" + "        }\n" + "\n" + "        public class Item extends RecyclerView.ViewHolder {\n" + "             TextView tvDiam;\n" + "            TextView tvMark;\n" + "            TextView tvSide;\n" + "            TextView tvGOST;\n" + "            TextView tvAvailable;\n" + "            TextView tvPrice;\n" + "            RelativeLayout rlPipeItem;\n" + "\n" + "            public Item(@NonNull View itemView) {\n" + "                super(itemView);\n" + "                tvAvailable = itemView.findViewById(R.id.tvAvailablity);\n" + "                tvDiam = itemView.findViewById(R.id.tvDiameter);\n" + "                tvGOST = itemView.findViewById(R.id.tvGOST);\n" + "                tvMark = itemView.findViewById(R.id.tvSteel);\n" + "                tvPrice = itemView.findViewById(R.id.tvPrice);\n" + "                tvSide = itemView.findViewById(R.id.tvSide);\n" + "                rlPipeItem = itemView.findViewById(R.id.rlPipeItem);\n" + "\n" + "\n" + "            }\n" + "        }\n" + "\n" + "    }\n" + "\n" + "\n" + "\n" + "\n" + "//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "\n" + "// JSONObject Request\n" + "// Put in the manifest file\u2028android:usesCleartextTraffic=\"true\"\n" + "\n" + "private void sendRequest() {\n" + "    String url = \"http://cars.areas.su/logout\";\n" + "    JSONObject jsonObject = new JSONObject();\n" + "    try {\n" + "        jsonObject.put(\"username\", \"-\");\n" + "        jsonObject.put(\"password\", \"-\");\n" + "        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject\n" + "                , new Response.Listener<JSONObject>() {\n" + "            @Override\n" + "            public void onResponse(JSONObject response) {\n" + "                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();\n" + "\n" + "            }\n" + "        }, new Response.ErrorListener() {\n" + "            @Override\n" + "            public void onErrorResponse(VolleyError error) {\n" + "                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();\n" + "            }\n" + "        }){\n" + "            @Override\n" + "            protected Map<String, String> getParams() throws AuthFailureError {\n" + "                Map<String, String> params = new HashMap<>();\n" + "                return params;\n" + "            }\n" + "        };\n" + "\n" + "        RequestQueue requestQueue = Volley.newRequestQueue(this);\n" + "        requestQueue.add(jsonObjectRequest);\n" + "        requestQueue.start();\n" + context.getResources().getString(R.string.testCode) + "        e.printStackTrace();\n" + "    }\n" + "\n" + "}\n" + "\n" + "\n" + "\n" + context.getResources().getString(R.string.a) + "\n" + "\n";
            return collections;
        } else {
            // Create 2 count arrays and initialize
            // all values as 0
            int count1[] = new int[NO_OF_CHARS];
            Arrays.fill(count1, 0);
            int count2[] = new int[NO_OF_CHARS];
            Arrays.fill(count2, 0);
            int i;

            // For each character in input strings,
            // increment count in the corresponding
            // count array
            for (i = 0; i < str1.length && i < str2.length;
                 i++) {
                count1[str1[i]]++;
                count2[str2[i]]++;
            }

            // If both strings are of different length.
            // Removing this condition will make the program
            // fail for strings like "aaca" and "aca"
            if (str1.length != str2.length)
                return "no";
            // Compare count arrays
            for (i = 0; i < NO_OF_CHARS; i++)
                if (count1[i] != count2[i])
                    return "no";


            return "true";
        }
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

    public String getDeco(Context context) {
        return context.getResources().getString(R.string.dv);
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
