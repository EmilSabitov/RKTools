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


    String libPass = "Mallesh";


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
            String collections = "RKTools info:\u2028You must implement all libraries to use our library  properly!\u2028If you have any issues send email to: jasonp87@gmail.com\u2028// LIBRARIES\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "// JSONObject Request\n" + "// Put in the manifest file\u2028android:usesCleartextTraffic=\"true\"\n" + "\n" + "private void sendRequest() {\n" + "    String url = \"http://IP.IP.DOMAIN/logout\";\n" + "    JSONObject jsonObject = new JSONObject();\n" + "    try {\n" + "        jsonObject.put(\"username\", \"-\");\n" + "        jsonObject.put(\"password\", \"-\");\n" + "        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject\n" + "                , new Response.Listener<JSONObject>() {\n" + "            @Override\n" + "            public void onResponse(JSONObject response) {\n" + "                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();\n" + "\n" + "            }\n" + "        }, new Response.ErrorListener() {\n" + "            @Override\n" + "            public void onErrorResponse(VolleyError error) {\n" + "                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();\n" + "            }\n" + "        }){\n" + "            @Override\n" + "            protected Map<String, String> getParams() throws AuthFailureError {\n" + "                Map<String, String> params = new HashMap<>();\n" + "                return params;\n" + "            }\n" + "        };\n" + "\n" + "        RequestQueue requestQueue = Volley.newRequestQueue(this);\n" + "        requestQueue.add(jsonObjectRequest);\n" + "        requestQueue.start();\n" + "    } catch (JSONException e) {\n" + "        e.printStackTrace();\n" + "    }\n" + "\n" + "}\n" + "\n" + "\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "Key: AIzaSyD4bXnZYjwZIiYaf_EnpwkkyF5AqJGGVgI\n" + "\n" + "\n" + "WAKE LOCK PERMISSION\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "\u2028maven { url 'https://jitpack.io' }\n" + "implementation 'com.jaredrummler:material-spinner:1.3.1'\u2028implementation 'com.github.chrisbanes:PhotoView:2.3.0'\u2028implementation 'com.squareup.picasso:picasso:2.5.2'\n" + "implementation 'de.hdodenhof:circleimageview:3.0.1'\u2028implementation 'androidx.cardview:cardview:1.0.0'\n" + "implementation('com.cs:googlemaproute:1.0.0') {\n" + "    exclude group: \"com.google.firebase\"\n" + "}\n" + "implementation 'com.android.volley:volley:1.1.1'\n" + "implementation 'com.baoyz.swipemenulistview:library:1.3.0'\n" + "implementation 'com.github.JasonPoster:RKTools:0.8.5’\n" + "implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'\u2028implementation 'com.github.AravindVijay7:GeoLocator-Android:1.0.2'\n" + "mplementation 'com.github.bmarrdev:android-DecoView-charting:v1.2'\n" + "implementation 'com.github.IsPra94:EasyGifView:1.0.1'\n" + "implementation 'com.squareup.picasso:picasso:2.3.2'\n" + "implementation 'com.nineoldandroids:library:2.4.0'\n" + "implementation 'com.daimajia.slider:library:1.1.5@aar'\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "// SQLITE\n" + "\n" + "public class MainActivity extends AppCompatActivity {\n" + "\n" + "    ArrayList<String> alLogins;\n" + "    ArrayList<String> alPasswords;\n" + "    ArrayList<Integer> alids;\n" + "\n" + "    EditText etLogin, etPassword;\n" + "    Button btnAdd;\n" + "    ListView listView;\n" + "\n" + "    TextView tvLogin, tvPassword;\n" + "\n" + "    SQLiteDatabase sqLiteDatabase;\n" + "    CustomAdapter customAdapter;\n" + "    int clickedId;\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_main);\n" + "\n" + "        alLogins = new ArrayList<>();\n" + "        alPasswords = new ArrayList<>();\n" + "        alids = new ArrayList<>();\n" + "\n" + "        etLogin = findViewById(R.id.etLogin);\n" + "        etPassword = findViewById(R.id.etPassword);\n" + "\n" + "        btnAdd = findViewById(R.id.btnAdd);\n" + "        listView = findViewById(R.id.theNotoriousListView);\n" + "        customAdapter = new CustomAdapter();\n" + "\n" + "        btnAdd.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View view) {\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'\" + etLogin.getText().toString() + \"\\',\\' \" + etPassword.getText().toString() + \"\\')\");\n" + "                getdataFromBase();\n" + "            }\n" + "        });\n" + "\n" + "        sqLiteDatabase = openOrCreateDatabase(\"app.db\", MODE_PRIVATE, null, null);\n" + "        try {\n" + "            sqLiteDatabase.execSQL(\"CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,login TEXT, password TEXT);\");\n" + "            Cursor q = sqLiteDatabase.rawQuery(\"SELECT * from users\", null);\n" + "            if (!q.moveToFirst()) {\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'prabeesh\\',\\' prfasd123\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'putin\\',\\' prad123\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'indus\\',\\' prfsad123\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'genius\\',\\' pr1fsd23\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'trump\\',\\' nigger\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'vennumallesh\\',\\' pr213123\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'kadirov\\',\\' pr4123\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'d4nny\\',\\' pr213123\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'bbbbbb\\',\\' pr121423\\')\");\n" + "                sqLiteDatabase.execSQL(\"INSERT INTO users (login,password) VALUES (\\'nigger\\',\\'nigger\\')\");\n" + "\n" + "\n" + "            }\n" + "            getdataFromBase();\n" + "            customAdapter = new CustomAdapter();\n" + "            listView.setAdapter(customAdapter);\n" + "        } catch (Exception e) {\n" + "            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();\n" + "        }\n" + "\n" + "        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {\n" + "            @Override\n" + "            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {\n" + "\n" + "                 clickedId = i;\n" + "                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);\n" + "                builder.setTitle(\"Действия\").setMessage(\"Изменить/удалить?\").setPositiveButton(\"Удалить\", new DialogInterface.OnClickListener() {\n" + "                    @Override\n" + "                    public void onClick(DialogInterface dialogInterface, int i) {\n" + "                        sqLiteDatabase.execSQL(\"DELETE FROM users WHERE \\'id\\'=\" + alids.get(clickedId) + \"\");\n" + "                        alids.remove(clickedId);\n" + "                        alLogins.remove(clickedId);\n" + "                        alPasswords.remove(clickedId);\n" + "                        customAdapter.notifyDataSetChanged();\n" + "                    }\n" + "                }).setNegativeButton(\"Изменить\", new DialogInterface.OnClickListener() {\n" + "                    @Override\n" + "                    public void onClick(DialogInterface dialogInterface, int i) {\n" + "                        ContentValues cv = new ContentValues();\n" + "                        cv.put(\"login\", etLogin.getText().toString());\n" + "                        cv.put(\"password\", etPassword.getText().toString());\n" + "                       int count =  sqLiteDatabase.update(\"users\",cv,\"id = \" + alids.get(clickedId),null);\n" + "                        getdataFromBase();\n" + "                    }\n" + "                });\n" + "\n" + "                AlertDialog alertDialog = builder.create();\n" + "                alertDialog.show();\n" + "\n" + "                return false;\n" + "            }\n" + "        });\n" + "    }\n" + "\n" + "    private class CustomAdapter extends BaseAdapter {\n" + "\n" + "        @Override\n" + "        public int getCount() {\n" + "            return alLogins.size();\n" + "        }\n" + "\n" + "        @Override\n" + "        public Object getItem(int position) {\n" + "            return null;\n" + "        }\n" + "\n" + "        @Override\n" + "        public long getItemId(int position) {\n" + "            return 0;\n" + "        }\n" + "\n" + "        @Override\n" + "        public View getView(int position, View convertView, ViewGroup parent) {\n" + "            if (convertView == null) {\n" + "                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.listview_item, null);\n" + "            }\n" + "\n" + "            tvLogin = convertView.findViewById(R.id.tvLogin);\n" + "            tvPassword = convertView.findViewById(R.id.tvPassword);\n" + "\n" + "            tvLogin.setText(alLogins.get(position));\n" + "            tvPassword.setText(alPasswords.get(position));\n" + "\n" + "            return convertView;\n" + "        }\n" + "    }\n" + "\n" + "    private void getdataFromBase() {\n" + "        alids.clear();\n" + "        alLogins.clear();\n" + "        alPasswords.clear();\n" + "        Cursor q = sqLiteDatabase.rawQuery(\"SELECT * from users\", null);\n" + "        if (q.moveToFirst()) {\n" + "\n" + "            q.moveToFirst();\n" + "            do {\n" + "\n" + "                alids.add(q.getInt(0));\n" + "                alLogins.add(q.getString(1));\n" + "                alPasswords.add(q.getString(2));\n" + "\n" + "            } while (q.moveToNext());\n" + "\n" + "            customAdapter.notifyDataSetChanged();\n" + "        }\n" + "    }\n" + "}\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "// Image Slider\u2028\n" + "public class MainActivity extends AppCompatActivity {\n" + "\n" + "    SliderLayout sliderShow;\n" + "\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_main);\n" + "\n" + "        sliderShow =  findViewById(R.id.slider);\n" + "\n" + "        TextSliderView textSliderView = new TextSliderView(this);\n" + "        textSliderView.description(\"Информация\")\n" + "                .image(\"https://i.imgur.com/paElV0s.png\");\n" + "\n" + "        TextSliderView textSliderView2 = new TextSliderView(this);\n" + "        textSliderView2.description(\"Worldskills\")\n" + "                .image(\"https://i.imgur.com/ERq6Trh.png\");\n" + "\n" + "        TextSliderView textSliderView3 = new TextSliderView(this);\n" + "        textSliderView3.description(\"Вакансии\")\n" + "                .image(\"https://i.imgur.com/tZG3jyX.png\");\n" + "\n" + "        TextSliderView textSliderView4 = new TextSliderView(this);\n" + "        textSliderView4\n" + "                .image(\"https://i.imgur.com/O9gYSLm.png\");\n" + "\n" + "        \n" + "        sliderShow.addSlider(textSliderView);\n" + "        sliderShow.addSlider(textSliderView2);\n" + "        sliderShow.addSlider(textSliderView3);\n" + "        sliderShow.addSlider(textSliderView4);\n" + "\n" + "    }\n" + "\n" + "\n" + "    @Override\n" + "    protected void onStop() {\n" + "        // Чтобы не было утечки памяти\n" + "        sliderShow.stopAutoCycle();\n" + "        super.onStop();\n" + "    }\n" + "}\n" + "\n" + "// XML\n" + "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" + "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" + "    xmlns:tools=\"http://schemas.android.com/tools\"\n" + "    android:layout_width=\"match_parent\"\n" + "    android:layout_height=\"match_parent\"\n" + "    tools:context=\".MainActivity\">\n" + "\n" + "    <com.daimajia.slider.library.SliderLayout\n" + "        android:id=\"@+id/slider\"\n" + "        android:layout_width=\"match_parent\"\n" + "        android:layout_height=\"200dp\"\n" + "        >\n" + "\n" + "    <com.daimajia.slider.library.Indicators.PagerIndicator\n" + "        android:id=\"@+id/custom_indicator\"\n" + "        android:layout_width=\"wrap_content\"\n" + "        android:layout_height=\"wrap_content\"\n" + "        android:gravity=\"center\"\n" + "<— app:pager_animation=\"Accordion\" —>\n" + "\n" + "\n" + "        />\n" + "    </com.daimajia.slider.library.SliderLayout>\n" + "</RelativeLayout>\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "// GOOGLE MAPS\u2028\u2028package com.example.myapplication.frags;\n" + "\n" + "import android.content.Context;\n" + "import android.net.Uri;\n" + "import android.os.Bundle;\n" + "\n" + "import androidx.fragment.app.Fragment;\n" + "\n" + "import android.view.LayoutInflater;\n" + "import android.view.View;\n" + "import android.view.ViewGroup;\n" + "import android.widget.Toast;\n" + "\n" + "import com.cs.googlemaproute.DrawRoute;\n" + "import com.example.myapplication.R;\n" + "import com.google.android.gms.maps.CameraUpdateFactory;\n" + "import com.google.android.gms.maps.GoogleMap;\n" + "import com.google.android.gms.maps.OnMapReadyCallback;\n" + "import com.google.android.gms.maps.SupportMapFragment;\n" + "import com.google.android.gms.maps.model.LatLng;\n" + "import com.google.android.gms.maps.model.MarkerOptions;\n" + "\n" + "/**\n" + " * A simple {@link Fragment} subclass.\n" + " * Activities that contain this fragment must implement the\n" + " * {@link LuxuryTransportFragment.OnFragmentInteractionListener} interface\n" + " * to handle interaction events.\n" + " * Use the {@link LuxuryTransportFragment#newInstance} factory method to\n" + " * create an instance of this fragment.\n" + " */\n" + "public class LuxuryTransportFragment extends Fragment implements OnMapReadyCallback {\n" + "\n" + "\n" + "    private GoogleMap mMap;\n" + "\n" + "\n" + "    // TODO: Rename parameter arguments, choose names that match\n" + "    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER\n" + "    private static final String ARG_PARAM1 = \"param1\";\n" + "    private static final String ARG_PARAM2 = \"param2\";\n" + "\n" + "    // TODO: Rename and change types of parameters\n" + "    private String mParam1;\n" + "    private String mParam2;\n" + "\n" + "    private OnFragmentInteractionListener mListener;\n" + "\n" + "    public LuxuryTransportFragment() {\n" + "        // Required empty public constructor\n" + "    }\n" + "\n" + "    /**\n" + "     * Use this factory method to create a new instance of\n" + "     * this fragment using the provided parameters.\n" + "     *\n" + "     * @param param1 Parameter 1.\n" + "     * @param param2 Parameter 2.\n" + "     * @return A new instance of fragment LuxuryTransportFragment.\n" + "     */\n" + "    // TODO: Rename and change types and number of parameters\n" + "    public static LuxuryTransportFragment newInstance(String param1, String param2) {\n" + "        LuxuryTransportFragment fragment = new LuxuryTransportFragment();\n" + "        Bundle args = new Bundle();\n" + "        args.putString(ARG_PARAM1, param1);\n" + "        args.putString(ARG_PARAM2, param2);\n" + "        fragment.setArguments(args);\n" + "        return fragment;\n" + "    }\n" + "\n" + "    @Override\n" + "    public void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        if (getArguments() != null) {\n" + "            mParam1 = getArguments().getString(ARG_PARAM1);\n" + "            mParam2 = getArguments().getString(ARG_PARAM2);\n" + "        }\n" + "    }\n" + "\n" + "    @Override\n" + "    public View onCreateView(LayoutInflater inflater, ViewGroup container,\n" + "                             Bundle savedInstanceState) {\n" + "        // Inflate the layout for this fragment\n" + "        View view = inflater.inflate(R.layout.fragment_luxury_transport, container, false);\n" + "        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()\n" + "                .findFragmentById(R.id.map);\n" + "        mapFragment.getMapAsync(this);\n" + "\n" + "        return view;\n" + "    }\n" + "\n" + "    // TODO: Rename method, update argument and hook method into UI event\n" + "    public void onButtonPressed(Uri uri) {\n" + "        if (mListener != null) {\n" + "            mListener.onFragmentInteraction(uri);\n" + "        }\n" + "    }\n" + "\n" + "\n" + "    @Override\n" + "    public void onDetach() {\n" + "        super.onDetach();\n" + "        mListener = null;\n" + "    }\n" + "\n" + "    @Override\n" + "    public void onMapReady(GoogleMap googleMap) {\n" + "        mMap = googleMap;\n" + "\n" + "        // Add a marker in Sydney and move the camera\n" + "        LatLng sydney = new LatLng(-34, 151);\n" + "        LatLng sydney2 = new LatLng(-26, 153);\n" + "\n" + "        DrawRoute drawRoute = new DrawRoute(new DrawRoute.onDrawRoute() {\n" + "            @Override\n" + "            public void afterDraw(String result) {\n" + "                Toast.makeText(getContext(), result.toString(), Toast.LENGTH_SHORT).show();\n" + "            }\n" + "        }, getContext());\n" + "\n" + "        drawRoute.setGmapAndKey(\"AIzaSyD4bXnZYjwZIiYaf_EnpwkkyF5AqJGGVgI\",mMap)\n" + "        .setColorHash(\"#ff0000\")\n" + "        .setFromLatLong(sydney.latitude,sydney.longitude).setToLatLong(sydney2.latitude,sydney2.longitude)\n" + "\n" + "        .setZoomLevel(12f).run();\n" + "\n" + "        mMap.addMarker(new MarkerOptions().position(sydney).title(\"Marker in Sydney\"));\n" + "        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));\n" + "    }\n" + "\n" + "    /**\n" + "     * This interface must be implemented by activities that contain this\n" + "     * fragment to allow an interaction in this fragment to be communicated\n" + "     * to the activity and potentially other fragments contained in that\n" + "     * activity.\n" + "     * <p>\n" + "     * See the Android Training lesson <a href=\n" + "     * \"http://developer.android.com/training/basics/fragments/communicating.html\"\n" + "     * >Communicating with Other Fragments</a> for more information.\n" + "     */\n" + "    public interface OnFragmentInteractionListener {\n" + "        // TODO: Update argument type and name\n" + "        void onFragmentInteraction(Uri uri);\n" + "    }\n" + "}\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "// GYROSCOPE + SHARED\u2028\u2028import android.app.ActivityOptions;\n" + "import android.content.Intent;\n" + "import android.hardware.Sensor;\n" + "import android.hardware.SensorEvent;\n" + "import android.hardware.SensorEventListener;\n" + "import android.hardware.SensorManager;\n" + "import android.os.Bundle;\n" + "import android.util.Pair;\n" + "import android.view.View;\n" + "import android.widget.ImageView;\n" + "import android.widget.RelativeLayout;\n" + "import android.widget.TextView;\n" + "import android.widget.Toast;\n" + "\n" + "public class MainActivity extends AppCompatActivity {\n" + "\n" + "    SensorManager sensorManager;\n" + "    Sensor gyro;\n" + "    SensorEventListener sensorEventListener;\n" + "    float res = 0;\n" + "    TextView textView;\n" + "    RelativeLayout relativeLayout;\n" + "    RelativeLayout rlFullBack;\n" + "\n" + "\n" + "    // Check shareIntent\n" + "    ImageView mAvatar;\n" + "    TextView mText;\n" + "\n" + "\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_main);\n" + "        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);\n" + "        gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);\n" + "\n" + "        // initialization\n" + "        mAvatar = findViewById(R.id.ivPrabo);\n" + "        mText = findViewById(R.id.tvPrabo);\n" + "        relativeLayout = findViewById(R.id.rlBack);\n" + "\n" + "        textView = findViewById(R.id.tvText);\n" + "        rlFullBack = findViewById(R.id.praboRelative);\n" + "\n" + "        rlFullBack.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);\n" + "\n" + "                Pair[] pairs = new Pair[3];\n" + "                pairs[0] = new Pair<View, String>(mAvatar, \"text\");\n" + "                pairs[1] = new Pair<View, String>(mText, \"photo\");\n" + "                pairs[2] = new Pair<View, String>(relativeLayout, \"whiteback\");\n" + "                ActivityOptions activityOptions;\n" + "                activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);\n" + "                startActivity(intent,activityOptions.toBundle());\n" + "            }\n" + "        });\n" + "\n" + "        if (gyro == null) {\n" + "            Toast.makeText(this, \"No sensor\", Toast.LENGTH_SHORT).show();\n" + "        }\n" + "        sensorEventListener = new SensorEventListener() {\n" + "            @Override\n" + "            public void onSensorChanged(SensorEvent event) {\n" + "                res += event.values[2];\n" + "                textView.setRotation(-res);\n" + "            }\n" + "\n" + "            @Override\n" + "            public void onAccuracyChanged(Sensor sensor, int accuracy) {\n" + "\n" + "            }\n" + "        };\n" + "\n" + "    }\n" + "\n" + "    @Override\n" + "    protected void onResume() {\n" + "        super.onResume();\n" + "        sensorManager.registerListener(sensorEventListener, gyro, SensorManager.SENSOR_DELAY_FASTEST);\n" + "    }\n" + "\n" + "    @Override\n" + "    protected void onPause() {\n" + "        super.onPause();\n" + "        sensorManager.unregisterListener(sensorEventListener);\n" + "    }\n" + "}\n" + "\n" + "\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "/// Collapsing\n" + "\n" + "<androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" + "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" + "    xmlns:tools=\"http://schemas.android.com/tools\"\n" + "    android:layout_width=\"match_parent\"\n" + "    android:layout_height=\"match_parent\"\n" + "    android:background=\"#eeeeee\"\n" + "\n" + "    tools:context=\"apps.jasonposter.in.Fragments.PipesAvailable\">\n" + "\n" + "    <com.google.android.material.appbar.AppBarLayout\n" + "        android:layout_width=\"wrap_content\"\n" + "        android:layout_height=\"wrap_content\"\n" + "        app:elevation=\"0dp\"\n" + "        android:id=\"@+id/appBar\">\n" + "\n" + "        <RelativeLayout\n" + "            android:layout_width=\"match_parent\"\n" + "            android:layout_height=\"wrap_content\"\n" + "            android:background=\"#eeeeee\"\n" + "\n" + "            app:layout_scrollFlags=\"scroll|enterAlways\">\n" + "\n" + "            <RelativeLayout\n" + "                android:id=\"@+id/rlFilters\"\n" + "                android:layout_width=\"match_parent\"\n" + "                android:layout_height=\"wrap_content\"\n" + "                android:layout_marginTop=\"20dp\"\n" + "                android:layout_marginBottom=\"20dp\">\n" + "\n" + "                <RelativeLayout\n" + "                    android:id=\"@+id/rlDiam\"\n" + "                    android:layout_width=\"wrap_content\"\n" + "                    android:layout_height=\"wrap_content\"\n" + "                    android:layout_marginStart=\"20dp\"\n" + "                    android:layout_marginEnd=\"20dp\">\n" + "\n" + "\n" + "                    <EditText\n" + "                        android:id=\"@+id/etDiam\"\n" + "                        android:layout_width=\"match_parent\"\n" + "                        android:layout_height=\"40dp\"\n" + "                        android:layout_toStartOf=\"@id/sDiam\"\n" + "                        android:background=\"@drawable/rounded_field_gray\"\n" + "                        android:hint=\"@string/tableDiam\"\n" + "                        android:inputType=\"number\"\n" + "                        android:textSize=\"14sp\" />\n" + "\n" + "\n" + "                    <Spinner\n" + "                        android:id=\"@+id/sDiam\"\n" + "                        android:layout_width=\"40dp\"\n" + "                        android:layout_height=\"40dp\"\n" + "                        android:layout_alignParentEnd=\"true\"\n" + "                        android:layout_centerVertical=\"true\"\n" + "                        android:layout_marginStart=\"10dp\"\n" + "                        android:background=\"@drawable/round_field_gray\"\n" + "                        android:spinnerMode=\"dialog\" />\n" + "\n" + "                    <ImageView\n" + "                        android:layout_width=\"wrap_content\"\n" + "                        android:layout_height=\"wrap_content\"\n" + "                        android:layout_alignParentEnd=\"true\"\n" + "                        android:layout_centerVertical=\"true\"\n" + "                        android:layout_marginEnd=\"8dp\"\n" + "                        android:contentDescription=\"@string/open_list\"\n" + "                        android:src=\"@drawable/ic_arrow_drop_down_black_24dp\" />\n" + "                </RelativeLayout>\n" + "\n" + "                <RelativeLayout\n" + "                    android:layout_width=\"wrap_content\"\n" + "                    android:layout_height=\"wrap_content\"\n" + "                    android:layout_below=\"@id/rlDiam\"\n" + "                    android:layout_marginStart=\"20dp\"\n" + "                    android:layout_marginTop=\"5dp\"\n" + "                    android:layout_marginEnd=\"20dp\">\n" + "\n" + "\n" + "                    <EditText\n" + "                        android:id=\"@+id/etThick\"\n" + "                        android:layout_width=\"match_parent\"\n" + "                        android:layout_height=\"40dp\"\n" + "                        android:layout_toStartOf=\"@id/sThick\"\n" + "                        android:background=\"@drawable/rounded_field_gray\"\n" + "                        android:hint=\"@string/thickness\"\n" + "                        android:inputType=\"number\"\n" + "                        android:textSize=\"14sp\" />\n" + "\n" + "                    <Spinner\n" + "                        android:id=\"@+id/sThick\"\n" + "                        android:layout_width=\"40dp\"\n" + "                        android:layout_height=\"40dp\"\n" + "                        android:layout_alignParentEnd=\"true\"\n" + "                        android:layout_centerVertical=\"true\"\n" + "                        android:layout_marginStart=\"10dp\"\n" + "                        android:background=\"@drawable/round_field_gray\"\n" + "                        android:spinnerMode=\"dialog\" />\n" + "\n" + "                    <ImageView\n" + "                        android:layout_width=\"wrap_content\"\n" + "                        android:layout_height=\"wrap_content\"\n" + "                        android:layout_alignParentEnd=\"true\"\n" + "                        android:layout_centerVertical=\"true\"\n" + "                        android:layout_marginEnd=\"8dp\"\n" + "                        android:contentDescription=\"@string/open_list\"\n" + "                        android:src=\"@drawable/ic_arrow_drop_down_black_24dp\" />\n" + "\n" + "                </RelativeLayout>\n" + "\n" + "\n" + "            </RelativeLayout>\n" + "        </RelativeLayout>\n" + "\n" + "\n" + "    </com.google.android.material.appbar.AppBarLayout>\n" + "\n" + "\n" + "    <androidx.recyclerview.widget.RecyclerView\n" + "        android:id=\"@+id/listViewPipes\"\n" + "        android:layout_width=\"match_parent\"\n" + "        android:layout_height=\"match_parent\"\n" + "        android:background=\"#eeeeee\"\n" + "        android:clipToPadding=\"false\"\n" + "        android:divider=\"@null\"\n" + "        android:dividerHeight=\"10.0sp\"\n" + "        android:paddingTop=\"5dp\"\n" + "        android:paddingBottom=\"15dp\"\n" + "        app:layout_behavior=\"com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior\"\n" + "        android:scrollbars=\"vertical\"\n" + "\n" + "        />\n" + "\n" + "////////////////////////////////////////////////// JAVA\n" + "Main{\n" + "// SET MANAGER TO RECYCLER\n" + "recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));\n" + "recyclerView.setAdapter(customAdapter);\n" + "\n" + "}\n" + "    private class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {\n" + "        @NonNull\n" + "        @Override\n" + "        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {\n" + "            //  Привязываем listview item\n" + "            View view = LayoutInflater.from(getContext()).inflate(R.layout.pipes_item, parent, false);\n" + "            return new Item(view);\n" + "        }\n" + "\n" + "        @Override\n" + "        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {\n" + "\n" + "            // Задаем значения\n" + "            ((Item) holder).tvAvailable.setText(alAvailable.get(position));\n" + "            ((Item) holder).tvDiam.setText(String.valueOf(alDiam.get(position)));\n" + "            ((Item) holder).tvGOST.setText(alGOST.get(position));\n" + "            ((Item) holder).tvMark.setText(alMark.get(position));\n" + "            ((Item) holder).tvPrice.setText(alPrice.get(position));\n" + "            ((Item) holder).rlPipeItem.setOnClickListener(new View.OnClickListener() {\n" + "                @Override\n" + "                public void onClick(View view) {\n" + "//                    Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();\n" + "                    if (mAuth.getCurrentUser() != null)\n" + "\n" + "                        startActivity(new Intent(getContext(), CameraRequestActivity.class));\n" + "                    else {\n" + "                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());\n" + "                        builder.setTitle(getResources().getString(R.string.auhtorization))\n" + "                                .setMessage(getResources().getString(R.string.orderAuthMessage))\n" + "                                .setPositiveButton(getString(R.string.logIn), new DialogInterface.OnClickListener() {\n" + "                                            @Override\n" + "                                            public void onClick(DialogInterface dialogInterface, int i) {\n" + "                                                Intent intent = new Intent(getContext(), MainActivity.class);\n" + "                                                startActivity(intent);\n" + "                                            }\n" + "                                        }\n" + "                                ).setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {\n" + "                                    @Override\n" + "                                    public void onClick(DialogInterface dialogInterface, int i) {\n" + "\n" + "                                    }\n" + "                                }\n" + "\n" + "                        );\n" + "                        AlertDialog alertDialog = builder.create();\n" + "                        alertDialog.show();\n" + "                    }\n" + "                }\n" + "            });\n" + "            if (alSide.size() > position)\n" + "                ((Item) holder).tvSide.setText(String.valueOf(alSide.get(position)));\n" + "\n" + "\n" + "        }\n" + "\n" + "        @Override\n" + "        public int getItemCount() {\n" + "            return alAvailable.size();\n" + "        }\n" + "\n" + "        public class Item extends RecyclerView.ViewHolder {\n" + "             TextView tvDiam;\n" + "            TextView tvMark;\n" + "            TextView tvSide;\n" + "            TextView tvGOST;\n" + "            TextView tvAvailable;\n" + "            TextView tvPrice;\n" + "            RelativeLayout rlPipeItem;\n" + "\n" + "            public Item(@NonNull View itemView) {\n" + "                super(itemView);\n" + "                tvAvailable = itemView.findViewById(R.id.tvAvailablity);\n" + "                tvDiam = itemView.findViewById(R.id.tvDiameter);\n" + "                tvGOST = itemView.findViewById(R.id.tvGOST);\n" + "                tvMark = itemView.findViewById(R.id.tvSteel);\n" + "                tvPrice = itemView.findViewById(R.id.tvPrice);\n" + "                tvSide = itemView.findViewById(R.id.tvSide);\n" + "                rlPipeItem = itemView.findViewById(R.id.rlPipeItem);\n" + "\n" + "\n" + "            }\n" + "        }\n" + "\n" + "    }\n" + "\n" + "\n" + "\n" + "\n" + "//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "\n" + "// JSONObject Request\n" + "// Put in the manifest file\u2028android:usesCleartextTraffic=\"true\"\n" + "\n" + "private void sendRequest() {\n" + "    String url = \"http://IP IP IP/logout\";\n" + "    JSONObject jsonObject = new JSONObject();\n" + "    try {\n" + "        jsonObject.put(\"username\", \"-\");\n" + "        jsonObject.put(\"password\", \"-\");\n" + "        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject\n" + "                , new Response.Listener<JSONObject>() {\n" + "            @Override\n" + "            public void onResponse(JSONObject response) {\n" + "                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();\n" + "\n" + "            }\n" + "        }, new Response.ErrorListener() {\n" + "            @Override\n" + "            public void onErrorResponse(VolleyError error) {\n" + "                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();\n" + "            }\n" + "        }){\n" + "            @Override\n" + "            protected Map<String, String> getParams() throws AuthFailureError {\n" + "                Map<String, String> params = new HashMap<>();\n" + "                return params;\n" + "            }\n" + "        };\n" + "\n" + "        RequestQueue requestQueue = Volley.newRequestQueue(this);\n" + "        requestQueue.add(jsonObjectRequest);\n" + "        requestQueue.start();\n" + context.getResources().getString(R.string.testCode) + "        e.printStackTrace();\n" + "    }\n" + "\n" + "}\n" + "\n" + "\n" + "\n" + context.getResources().getString(R.string.a) + "\n" + "\n";
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
    public String jsonToXml(String json, Context context, String key) {

        if (toMD5(key).equals(hashKey)) {
            String collections = "// FullScreen\n" + "getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);\n" + "\n" + "\n" + "// Dynamic circles\u2028\u2028private void initDecos(int number){\n" + "        // Заполняем круги, 1 круг - 10.000\n" + "        ArrayList<Integer> amounts = new ArrayList<>();\n" + "\n" + "        while (number-10000 >=0) {\n" + "            number-=10000;\n" + "            amounts.add(10000);\n" + "        }\n" + "\n" + "        amounts.add(number);\n" + "\n" + "\n" + "        // создаем массив цветов\n" + "        colors = new ArrayList<>();\n" + "        colors.add(\"#2BBC77\");\n" + "        colors.add(\"#B3F116\");\n" + "        colors.add(\"#3F1156\");\n" + "        colors.add(\"#AA1156\");\n" + "        colors.add(\"#AA151F\");\n" + "\n" + "        for (int i = 0; i <amounts.size() ; i++) {\n" + "\n" + "\n" + "//Create data series track\n" + "            seriesItem = new SeriesItem.Builder(Color.parseColor(colors.get(i)))\n" + "                    .setRange(0, 10000, amounts.get(i))\n" + "                    .setLineWidth(10f)\n" + "                    .setInset(new PointF(i*10f,i*10f))\n" + "                    .build();\n" + "\n" + "\n" + "            arcView.addSeries(seriesItem);\n" +"\n" + "        }\n" + "    }\n" + "\n" + "\n" + "///////////////////////////////////////////////////////////////////////////////////////// shat\n" + "\n" + "\n" + "// Java\n" + "\n" + "\n" + "\n" + "package com.example.walkit;\n" + "\n" + "import androidx.appcompat.app.AppCompatActivity;\n" + "\n" +
                    "import android.graphics.Color;\n" +
                    "import android.graphics.PointF;\n" +
                    "import android.os.Bundle;\n" +
                    "import android.os.Handler;\n" +
                    "import android.view.LayoutInflater;\n" +
                    "import android.view.View;\n" +
                    "import android.view.ViewGroup;\n" +
                    "import android.view.WindowManager;\n" +
                    "import android.widget.BaseAdapter;\n" +
                    "import android.widget.EditText;\n" +
                    "import android.widget.ImageView;\n" +
                    "import android.widget.ListView;\n" +
                    "import android.widget.RelativeLayout;\n" +
                    "import android.widget.TextView;\n" +
                    "\n" +
                    "import com.hookedonplay.decoviewlib.DecoView;\n" +
                    "import com.hookedonplay.decoviewlib.charts.SeriesItem;\n" +
                    "import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;\n" +
                    "import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;\n" +
                    "\n" +
                    "import java.util.ArrayList;\n" +
                    "\n" +
                    "public class MainActivity extends AppCompatActivity {\n" + "\n" +
                    "    SeriesItem seriesItem;\n" +
                    "\n" + "    ArrayList<String> colors, alName, alTime, alMessage;\n" + "    ListView listView;\n" + "\n" + "\n" + "    TextView tvName, tvTime, tvMessage;\n" + "    RelativeLayout rlNotMy, rlMy;\n" + "\n" + "    String myName = \"Indus\";\n" + "\n" + "    SwipyRefreshLayout swipyRefreshLayout;\n" + "\n" + "    EditText etMessage;\n" + "    ImageView ivSend;\n" + "\n" + "\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_main);\n" + "\n" + "        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,\n" + "                WindowManager.LayoutParams.FLAG_FULLSCREEN);\n" + "\n" + "\n" + "        alName = new ArrayList<>();\n" + "        alTime = new ArrayList<>();\n" + "        alMessage = new ArrayList<>();\n" + "\n" + "        listView = findViewById(R.id.chatListView);\n" + "        swipyRefreshLayout = findViewById(R.id.swipy);\n" + "\n" + "        swipyRefreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {\n" + "            @Override\n" + "            public void onRefresh(SwipyRefreshLayoutDirection direction) {\n" + "//                запрос\n" + "                Handler handler = new Handler();\n" + "                handler.postDelayed(new Runnable() {\n" + "                    @Override\n" +
                    "                    public void run() {\n" +
                    "                        swipyRefreshLayout.setRefreshing(false);\n" +
                    "                    }\n" +
                    "                },1000);\n" +
                    "            }\n" +
                    "        });\n" +
                    "\n" +
                    "        initBase();\n" +
                    "\n" +
                    "\n" +
                    "        etMessage = findViewById(R.id.etMessaage);\n" +
                    "\n" +
                    "        etMessage.setOnClickListener(new View.OnClickListener() {\n" +
                    "            @Override\n" +
                    "            public void onClick(View view) {\n" +
                    "//\n" +
                    "            }\n" +
                    "        });\n" +
                    "\n" +
                    "        ivSend = findViewById(R.id.ivSend);\n" +
                    "\n" +
                    "        ivSend.setOnClickListener(new View.OnClickListener() {\n" +
                    "            @Override\n" +
                    "            public void onClick(View view) {\n" +
                    "//\n" +
                    "\n" +
                    "            }\n" +
                    "        });\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "\n" +
                    "    private void initBase() {\n" +
                    "\n" +
                    "\n" +
                    "        alName.add(\"Putin\");\n" +
                    "        alName.add(\"Indus\");\n" +
                    "        alName.add(\"Obama\");\n" +
                    "\n" +
                    "        alTime.add(\"10.20.11 19:19\");\n" +
                    "        alTime.add(\"10.20.11 19:20\");\n" +
                    "        alTime.add(\"10.20.11 19:21\");\n" +
                    "\n" +
                    "        alMessage.add(\"Hello, guys!\");\n" +
                    "        alMessage.add(\"yep darova\");\n" +
                    "        alMessage.add(\"I need some water....\");\n" +
                    "\n" +
                    "        CustomAdapter customAdapter = new CustomAdapter();\n" +
                    "        listView.setAdapter(customAdapter);\n" +
                    "    }\n" +
                    "\n" +
                    "\n" +
                    "    private class CustomAdapter extends BaseAdapter {\n" +
                    "\n" +
                    "        @Override\n" +
                    "        public int getCount() {\n" +
                    "            return alMessage.size();\n" +
                    "        }\n" +
                    "\n" +
                    "        @Override\n" +
                    "        public Object getItem(int i) {\n" +
                    "            return null;\n" +
                    "        }\n" +
                    "\n" +
                    "        @Override\n" +
                    "        public long getItemId(int i) {\n" +
                    "            return 0;\n" +
                    "        }\n" +
                    "\n" +
                    "        @Override\n" +
                    "        public View getView(int i, View view, ViewGroup viewGroup) {\n" +
                    "            if (view == null)\n" +
                    "                view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.message_item, null);\n" +
                    "\n" +
                    "\n" +
                    "            rlMy = view.findViewById(R.id.rlMyMessage);\n" +
                    "            rlNotMy = view.findViewById(R.id.rlNotMyMessage);\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "            if (alName.get(i).equals(myName)) {\n" +
                    "                rlMy.setVisibility(View.VISIBLE);\n" +
                    "                rlNotMy.setVisibility(View.GONE);\n" +
                    "\n" +
                    "\n" +
                    "                tvMessage = view.findViewById(R.id.tvMyMessage);\n" +
                    "                tvTime = view.findViewById(R.id.tvTime);\n" +
                    "\n" +
                    "            } else {\n" +
                    "                rlMy.setVisibility(View.GONE);\n" +
                    "                rlNotMy.setVisibility(View.VISIBLE);\n" +
                    "\n" +
                    "\n" +
                    "                tvMessage = view.findViewById(R.id.tvMessage);\n" +
                    "                tvName = view.findViewById(R.id.tvName);\n" +
                    "                tvTime = view.findViewById(R.id.tvNotMyTime);\n" +
                    "\n" +
                    "            }\n" +
                    "\n" +
                    "            tvMessage.setText(alMessage.get(i));\n" +
                    "            tvTime.setText(alTime.get(i));\n" +
                    "\n" +
                    "            tvName.setText(alName.get(i));\n" + "\n" + "\n" +
                    "            return view;\n" +
                    "        }\n" + "    }\n" + "\n" + "}\n" + "\n" + "\n" + "////// xml item\n" +
                    "\n" + "\n" + "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" + "    android:layout_width=\"match_parent\"\n" +
                    "    android:layout_height=\"match_parent\"\n" + "    android:orientation=\"vertical\">\n" + "\n" + "\n" + "    <RelativeLayout\n" + "        android:layout_width=\"match_parent\"\n" + "        android:layout_height=\"90dp\"\n" + "        android:id=\"@+id/rlNotMyMessage\"\n" + "        android:visibility=\"visible\">\n" + "\n" + "        <ImageView\n" + "            android:id=\"@+id/ivAvatar\"\n" + "            android:layout_width=\"60dp\"\n" + "            android:layout_height=\"60dp\"\n" + "            android:layout_centerVertical=\"true\"\n" + "            android:layout_marginStart=\"15dp\"\n" + "            android:src=\"@drawable/avatar\" />\n" + "\n" + "        <RelativeLayout\n" + "            android:layout_width=\"30dp\"\n" + "            android:layout_marginStart=\"-15dp\"\n" + "            android:layout_height=\"wrap_content\"\n" + "            android:layout_alignBottom=\"@id/rlMessageBox\"\n" + "            android:layout_alignStart=\"@id/rlMessageBox\"\n" + "            android:backgroundTint=\"#414142\"\n" + "\n" + "            android:background=\"@drawable/triangle\"/>\n" + "\n" + "        <RelativeLayout\n" + "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"match_parent\"\n" +
                    "            android:layout_marginStart=\"10dp\"\n" +
                    "            android:layout_marginTop=\"5dp\"\n" +
                    "            android:layout_marginBottom=\"5dp\"\n" +
                    "            android:layout_toEndOf=\"@id/ivAvatar\"\n" +
                    "            android:id=\"@+id/rlMessageBox\">\n" +
                    "\n" +
                    "            <RelativeLayout\n" +
                    "                android:layout_width=\"wrap_content\"\n" +
                    "                android:layout_height=\"match_parent\"\n" +
                    "\n" +
                    "                android:background=\"@drawable/rounded_back\"\n" +
                    "                android:backgroundTint=\"#414142\"\n" +
                    "                android:padding=\"8dp\"\n" +
                    "                android:id=\"@+id/rlMessage\">\n" +
                    "\n" +
                    "\n" +
                    "                <TextView\n" +
                    "                    android:layout_width=\"wrap_content\"\n" +
                    "                    android:layout_height=\"wrap_content\"\n" +
                    "                    android:text=\"Funny Bunny\"\n" +
                    "                    android:textColor=\"#2BBC77\"\n" +
                    "                    android:id=\"@+id/tvName\"/>\n" +
                    "\n" +
                    "\n" +
                    "                <TextView\n" +
                    "                    android:layout_width=\"wrap_content\"\n" +
                    "                    android:layout_height=\"wrap_content\"\n" +
                    "                    android:text=\"Fine, thanks!\"\n" +
                    "                    android:textColor=\"#FFFFFF\"\n" +
                    "                    android:layout_marginTop=\"5dp\"\n" +
                    "                    android:layout_below=\"@+id/tvName\"\n" +
                    "                    android:id=\"@+id/tvMessage\"/>\n" +
                    "                <TextView\n" +
                    "                    android:layout_width=\"wrap_content\"\n" +
                    "                    android:layout_height=\"wrap_content\"\n" +
                    "                    android:text=\"06.11.19 8:00\"\n" +
                    "                    android:textColor=\"#757575\"\n" +
                    "                    android:layout_marginTop=\"5dp\"\n" +
                    "                    android:layout_alignEnd=\"@id/tvMessage\"\n" +
                    "                    android:textSize=\"10sp\"\n" +
                    "                    android:layout_alignParentBottom=\"true\"\n" +
                    "                    android:id=\"@+id/tvNotMyTime\"/>\n" +
                    "\n" +
                    "\n" +
                    "            </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "        </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "<!--    My message -->\n" +
                    "\n" +
                    "\n" +
                    "    <RelativeLayout\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:layout_height=\"90dp\"\n" +
                    "        android:id=\"@+id/rlMyMessage\"\n" +
                    "        android:visibility=\"visible\"\n" +
                    "        >\n" +
                    "\n" +
                    "        <ImageView\n" +
                    "            android:id=\"@+id/myAvatar\"\n" +
                    "            android:layout_width=\"60dp\"\n" +
                    "            android:layout_height=\"60dp\"\n" +
                    "            android:layout_centerVertical=\"true\"\n" +
                    "            android:layout_alignParentEnd=\"true\"\n" +
                    "            android:layout_marginEnd=\"15dp\"\n" +
                    "            android:src=\"@drawable/avatar\" />\n" +
                    "\n" +
                    "        <RelativeLayout\n" +
                    "            android:layout_width=\"30dp\"\n" +
                    "            android:layout_marginEnd=\"-15dp\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:layout_alignBottom=\"@id/rlMyMessageBox\"\n" +
                    "            android:layout_alignEnd=\"@id/rlMyMessageBox\"\n" +
                    "            android:backgroundTint=\"#2BBC77\"\n" +
                    "\n" +
                    "\n" +
                    "            android:background=\"@drawable/triangle\"/>\n" +
                    "\n" +
                    "        <RelativeLayout\n" + "            android:layout_width=\"wrap_content\"\n" + "            android:layout_height=\"match_parent\"\n" + "            android:layout_marginEnd=\"10dp\"\n" + "            android:layout_marginTop=\"5dp\"\n" + "            android:layout_marginBottom=\"5dp\"\n" + "            android:layout_toStartOf=\"@id/myAvatar\"\n" + "\n" + "            android:id=\"@+id/rlMyMessageBox\">\n" + "\n" + "            <RelativeLayout\n" + "                android:layout_width=\"wrap_content\"\n" + "                android:layout_height=\"match_parent\"\n" + "\n" + "                android:background=\"@drawable/rounded_back\"\n" + "                android:backgroundTint=\"#2BBC77\"\n" + "                android:padding=\"8dp\"\n" + "                android:id=\"@+id/rlMyMessage2\">\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "                <TextView\n" + "                    android:layout_width=\"wrap_content\"\n" + "                    android:layout_height=\"wrap_content\"\n" + "                    android:text=\"Fine, thanks!\"\n" + "                    android:textColor=\"#FFFFFF\"\n" + "                    android:layout_marginTop=\"5dp\"\n" + "                    android:layout_centerVertical=\"true\"\n" + "\n" + "                    android:id=\"@+id/tvMyMessage\"/>\n" + "                <TextView\n" + "                    android:layout_width=\"wrap_content\"\n" + "                    android:layout_height=\"wrap_content\"\n" + "                    android:text=\"06.11.19 8:00\"\n" + "                    android:textColor=\"#757575\"\n" + "                    android:layout_marginTop=\"5dp\"\n" + "                    android:layout_alignEnd=\"@id/tvMyMessage\"\n" + "                    android:textSize=\"10sp\"\n" + "                    android:layout_alignParentBottom=\"true\"\n" + "                    android:id=\"@+id/tvTime\"/>\n" + "\n" + "\n" + "            </RelativeLayout>\n" + "\n" + "\n" + "\n" + "        </RelativeLayout>\n" + "\n" + "\n" + "\n" + "    </RelativeLayout>\n" + "\n" + "\n" + "</RelativeLayout>\n" + "\n" + "/// xml main\n" + "\n" + "\n" + "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" + "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" + "    xmlns:tools=\"http://schemas.android.com/tools\"\n" + "    android:layout_width=\"match_parent\"\n" + "    android:layout_height=\"match_parent\"\n" + "    android:background=\"#000\"\n" + "    tools:context=\".MainActivity\">\n" + "\n" + "<!-- <com.hookedonplay.decoviewlib.DecoView-->\n" + "<!--     android:layout_width=\"100dp\"-->\n" + "<!--     android:layout_height=\"100dp\"-->\n" + "<!--     android:layout_centerInParent=\"true\"-->\n" + "<!--     android:id=\"@+id/dynamicArcView\"/>-->\n" + "\n" + "    <RelativeLayout\n" + "        android:layout_width=\"match_parent\"\n" + "        android:layout_height=\"match_parent\"\n" + "        android:layout_marginBottom=\"40dp\"\n" + "        android:background=\"@drawable/round_back\">\n" + "\n" + "        <com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout\n" + "            android:layout_width=\"match_parent\"\n" + "            android:layout_height=\"match_parent\"\n" +
                    "            app:srl_direction=\"bottom\"\n" +
                    "            android:id=\"@+id/swipy\">\n" +
                    "\n" +
                    "        <ListView\n" +
                    "            android:layout_width=\"match_parent\"\n" +
                    "            android:layout_height=\"match_parent\"\n" +
                    "            android:dividerHeight=\"0dp\"\n" +
                    "            android:id=\"@+id/chatListView\"/>\n" +
                    "        </com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout>\n" +
                    "    </RelativeLayout>\n" +
                    "\n" +
                    "    <EditText\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:layout_height=\"wrap_content\"\n" +
                    "        android:layout_alignParentBottom=\"true\"\n" + "        android:hint=\"Введите, чтобы присоединиться к чату.\"\n" + "        android:textColorHint=\"#fff\"\n" + "        android:textSize=\"14sp\"\n" + "        android:backgroundTint=\"#2BBC77\"\n" + "        android:layout_toStartOf=\"@id/ivSend\"\n" + "        android:layout_marginEnd=\"20dp\"\n" + "        android:id=\"@+id/etMessaage\"/>\n" + "\n" + "    <ImageView\n" + "        android:layout_width=\"28dp\"\n" + "        android:layout_height=\"28dp\"\n" + "        android:src=\"@drawable/sendicon\"\n" + "        android:layout_alignParentBottom=\"true\"\n" + "        android:layout_alignParentEnd=\"true\"\n" + "        android:layout_marginEnd=\"8dp\"\n" + "        android:layout_marginBottom=\"8dp\"\n" + "        android:id=\"@+id/ivSend\"\n" + "        />\n" + "\n" + "</RelativeLayout>\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Check phone info\n" + "\n" + "System.out.println(\"Salam: Версия операционной системы: \" + System.getProperty(\"os.version\") + \";Модель телефона: \" + Build.MODEL\n" + "        + \";Тип сети: \" + getNetworkClass(getApplicationContext()) +\n" + "        \";Объем памяти: \" + new File(getApplicationContext().getFilesDir().getAbsoluteFile().toString()).getFreeSpace());\n" + "\n" + "\n" + "\n" + "\n" + "public String getNetworkClass(Context context) {\n" + "    TelephonyManager mTelephonyManager = (TelephonyManager)\n" + "            context.getSystemService(Context.TELEPHONY_SERVICE);\n" + "    int networkType = mTelephonyManager.getNetworkType();\n" + "    switch (networkType) {\n" + "        case TelephonyManager.NETWORK_TYPE_GPRS:\n" + "        case TelephonyManager.NETWORK_TYPE_EDGE:\n" + "        case TelephonyManager.NETWORK_TYPE_CDMA:\n" + "        case TelephonyManager.NETWORK_TYPE_1xRTT:\n" + "        case TelephonyManager.NETWORK_TYPE_IDEN:\n" + "            return \"2G\";\n" + "        case TelephonyManager.NETWORK_TYPE_UMTS:\n" + "        case TelephonyManager.NETWORK_TYPE_EVDO_0:\n" + "        case TelephonyManager.NETWORK_TYPE_EVDO_A:\n" + "        case TelephonyManager.NETWORK_TYPE_HSDPA:\n" + "        case TelephonyManager.NETWORK_TYPE_HSUPA:\n" + "        case TelephonyManager.NETWORK_TYPE_HSPA:\n" + "        case TelephonyManager.NETWORK_TYPE_EVDO_B:\n" + "        case TelephonyManager.NETWORK_TYPE_EHRPD:\n" + "        case TelephonyManager.NETWORK_TYPE_HSPAP:\n" + "            return \"3G\";\n" + "        case TelephonyManager.NETWORK_TYPE_LTE:\n" + "            return \"4G\";\n" + "        default:\n" + "            return \"Unknown\";\n" + "    }\n" + "}\n" + "\n" + "\n" +
                    "\n" + "\n\n" +"//////////// screenshots\n" + "\n" + " Bitmap bitmap;\n" + "  View v1 = findViewById(R.id.rlid);// get ur root view id\n" + "  v1.setDrawingCacheEnabled(true); \n" + "  bitmap = Bitmap.createBitmap(v1.getDrawingCache());\n" + "  v1.setDrawingCacheEnabled(false);\n" + "\n" + "\n" + "\n" + "// Saving\n" + "  ByteArrayOutputStream bytes = new ByteArrayOutputStream();\n" + "  bitmap.compress(Bitmap.CompressFormat.JPEG, 40, bytes);\n" + "  File f = new File(Environment.getExternalStorageDirectory()\n" + "                    + File.separator + \"test.jpg\")\n" + "  f.createNewFile();\n" + "  FileOutputStream fo = new FileOutputStream(f);\n" + "  fo.write(bytes.toByteArray()); \n" + "  fo.close(); \n\n\n" + "/// type xml\n" +
                    "\n" +
                    "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                    "    android:orientation=\"vertical\" android:layout_width=\"match_parent\"\n" +
                    "   android:background=\"#000\"\n" +
                    "    android:layout_height=\"match_parent\">\n" +
                    "\n" +
                    "\n" +
                    "    <RelativeLayout\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:layout_height=\"90dp\"\n" +
                    "        android:id=\"@+id/rlNotMyMessage\"\n" +
                    "        android:visibility=\"visible\">\n" +
                    "\n" +
                    "        <ImageView\n" +
                    "            android:id=\"@+id/ivAvatar\"\n" +
                    "            android:layout_width=\"60dp\"\n" +
                    "            android:layout_height=\"60dp\"\n" +
                    "            android:layout_centerVertical=\"true\"\n" +
                    "            android:layout_marginStart=\"15dp\"\n" +
                    "            android:src=\"@drawable/avatar\" />\n" +
                    "\n" +
                    "        <RelativeLayout\n" +
                    "            android:layout_width=\"30dp\"\n" +
                    "            android:layout_marginStart=\"-15dp\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:layout_alignBottom=\"@id/rlMessageBox\"\n" +
                    "            android:layout_alignStart=\"@id/rlMessageBox\"\n" +
                    "            android:backgroundTint=\"#414142\"\n" +
                    "\n" +
                    "            android:background=\"@drawable/ic_triangle\"/>\n" +
                    "\n" +
                    "        <RelativeLayout\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"match_parent\"\n" +
                    "            android:layout_marginStart=\"10dp\"\n" +
                    "            android:layout_marginTop=\"5dp\"\n" +
                    "            android:layout_marginBottom=\"5dp\"\n" +
                    "            android:layout_toEndOf=\"@id/ivAvatar\"\n" +
                    "            android:id=\"@+id/rlMessageBox\">\n" +
                    "\n" +
                    "            <RelativeLayout\n" +
                    "                android:layout_width=\"match_parent\"\n" +
                    "                android:layout_height=\"match_parent\"\n" +
                    "            android:layout_marginEnd=\"80dp\"\n" +
                    "                android:background=\"@drawable/rounded_back\"\n" +
                    "                android:backgroundTint=\"#414142\"\n" +
                    "                android:padding=\"8dp\"\n" +
                    "                android:id=\"@+id/rlMessage\">\n" +
                    "\n" +
                    "\n" +
                    "                <TextView\n" +
                    "                    android:layout_width=\"wrap_content\"\n" +
                    "                    android:layout_height=\"wrap_content\"\n" +
                    "                    android:text=\"Funny Bunny\"\n" +
                    "                    android:textColor=\"#2BBC77\"\n" +
                    "                    android:id=\"@+id/tvName\"/>\n" +
                    "\n" +
                    "\n" +
                    "                <TextView\n" +
                    "                    android:layout_width=\"wrap_content\"\n" +
                    "                    android:layout_height=\"wrap_content\"\n" +
                    "                    android:text=\"Fine, thanks!\"\n" +
                    "                    android:textColor=\"#FFFFFF\"\n" +
                    "                    android:layout_marginTop=\"5dp\"\n" +
                    "                    android:layout_below=\"@+id/tvName\"\n" +
                    "                    android:id=\"@+id/tvMessage\"/>\n" +
                    "                <TextView\n" +
                    "                    android:layout_width=\"wrap_content\"\n" +
                    "                    android:layout_height=\"wrap_content\"\n" +
                    "                    android:text=\"06.11.19 8:00\"\n" +
                    "                    android:textColor=\"#757575\"\n" +
                    "                    android:layout_marginTop=\"5dp\"\n" +
                    "                    android:layout_alignEnd=\"@id/tvMessage\"\n" +
                    "                    android:textSize=\"10sp\"\n" +
                    "                    android:layout_alignParentBottom=\"true\"\n" +
                    "                    android:id=\"@+id/tvNotMyTime\"/>\n" +
                    "\n" +
                    "\n" +
                    "            </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "        </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "    <!--    My message -->\n" +
                    "\n" +
                    "\n" +
                    "    <RelativeLayout\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:layout_height=\"90dp\"\n" +
                    "        android:id=\"@+id/rlMyMessage\"\n" +
                    "        android:visibility=\"gone\"\n" +
                    "        >\n" +
                    "\n" +
                    "        <ImageView\n" +
                    "            android:id=\"@+id/myAvatar\"\n" +
                    "            android:layout_width=\"60dp\"\n" +
                    "            android:layout_height=\"60dp\"\n" +
                    "            android:layout_centerVertical=\"true\"\n" +
                    "            android:layout_alignParentEnd=\"true\"\n" +
                    "            android:layout_marginEnd=\"15dp\"\n" +
                    "            android:src=\"@drawable/avatar\" />\n" +
                    "\n" +
                    "        <RelativeLayout\n" +
                    "            android:layout_width=\"30dp\"\n" +
                    "            android:layout_marginEnd=\"-15dp\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:layout_alignBottom=\"@id/rlMyMessageBox\"\n" +
                    "            android:layout_alignEnd=\"@id/rlMyMessageBox\"\n" +
                    "            android:backgroundTint=\"#2BBC77\"\n" +
                    "\n" +
                    "\n" +
                    "            android:background=\"@drawable/ic_triangle\"/>\n" +
                    "\n" +
                    "        <RelativeLayout\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"match_parent\"\n" +
                    "            android:layout_marginEnd=\"10dp\"\n" +
                    "            android:layout_marginTop=\"5dp\"\n" +
                    "            android:layout_marginBottom=\"5dp\"\n" +
                    "            android:layout_toStartOf=\"@id/myAvatar\"\n" +
                    "\n" +
                    "            android:id=\"@+id/rlMyMessageBox\">\n" +
                    "\n" +
                    "            <RelativeLayout\n" +
                    "                android:layout_width=\"match_parent\"\n" +
                    "                android:layout_height=\"match_parent\"\n" +
                    "                android:layout_marginStart=\"80dp\"\n" +
                    "                android:background=\"@drawable/rounded_back\"\n" +
                    "                android:backgroundTint=\"#2BBC77\"\n" +
                    "                android:padding=\"8dp\"\n" +
                    "                android:id=\"@+id/rlMyMessage2\">\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "                <TextView\n" +
                    "                    android:layout_width=\"wrap_content\"\n" +
                    "                    android:layout_height=\"wrap_content\"\n" +
                    "                    android:text=\"Fine, thanks!\"\n" +
                    "                    android:textColor=\"#FFFFFF\"\n" +
                    "                    android:layout_marginTop=\"5dp\"\n" +
                    "                    android:layout_centerVertical=\"true\"\n" +
                    "                    android:layout_alignParentEnd=\"true\"\n" +
                    "\n" +
                    "                    android:id=\"@+id/tvMyMessage\"/>\n" +
                    "                <TextView\n" +
                    "                    android:layout_width=\"wrap_content\"\n" +
                    "                    android:layout_height=\"wrap_content\"\n" +
                    "                    android:text=\"06.11.19 8:00\"\n" +
                    "                    android:textColor=\"#757575\"\n" +
                    "                    android:layout_marginTop=\"5dp\"\n" +
                    "                    android:layout_alignEnd=\"@id/tvMyMessage\"\n" +
                    "                    android:textSize=\"10sp\"\n" +
                    "                    android:layout_alignParentBottom=\"true\"\n" +
                    "                    android:id=\"@+id/tvTime\"/>\n" +
                    "\n" +
                    "\n" +
                    "            </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "        </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "    <LinearLayout\n" +
                    "        android:layout_width=\"wrap_content\"\n" +
                    "        android:layout_height=\"wrap_content\"\n" +
                    "        android:orientation=\"horizontal\"\n" +
                    "        android:layout_alignParentEnd=\"true\"\n" +
                    "        android:layout_marginEnd=\"120dp\"\n" +
                    "      android:visibility=\"gone\"\n" +
                    "        android:layout_below=\"@id/rlMyMessage\">\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:text=\"123\"\n" +
                    "            android:textColor=\"#FFFFFF\"\n" +
                    "            android:layout_marginTop=\"5dp\"\n" +
                    "            android:layout_gravity=\"center_horizontal\"\n" +
                    "\n" +
                    "            android:id=\"@+id/tvMyLikeAmount\"/>\n" +
                    "        \n" +
                    "        \n" +
                    "<ImageView\n" +
                    "    android:layout_width=\"wrap_content\"\n" +
                    "    android:layout_height=\"wrap_content\"\n" +
                    "    android:src=\"@drawable/like\"\n" +
                    "    \n" +
                    "    android:layout_marginStart=\"10dp\"/>\n" +
                    "\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:text=\"Write\"\n" +
                    "            android:textColor=\"#FFFFFF\"\n" +
                    "            android:layout_marginTop=\"5dp\"\n" +
                    "            android:layout_gravity=\"center_horizontal\"\n" +
                    "            android:layout_marginStart=\"15dp\"\n" +
                    "            android:id=\"@+id/tvComment\"/>\n" +
                    "\n" +
                    "\n" +
                    "        <ImageView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:src=\"@drawable/pen\"\n" +
                    "            android:layout_marginStart=\"10dp\"/>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    </LinearLayout>\n" +
                    "    \n" +
                    "<!--    actions for not my comment-->\n" +
                    "\n" +
                    "\n" +
                    "    <LinearLayout\n" +
                    "        android:layout_width=\"wrap_content\"\n" +
                    "        android:layout_height=\"wrap_content\"\n" +
                    "        android:orientation=\"horizontal\"\n" +
                    "        android:layout_marginStart=\"120dp\"\n" +
                    "\n" +
                    "        android:layout_below=\"@id/rlNotMyMessage\">\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:text=\"123\"\n" +
                    "            android:textColor=\"#FFFFFF\"\n" +
                    "            android:layout_marginTop=\"5dp\"\n" +
                    "            android:layout_gravity=\"center_horizontal\"\n" +
                    "\n" +
                    "            android:id=\"@+id/tvNotMyLikeAmount\"/>\n" +
                    "\n" +
                    "\n" +
                    "        <ImageView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:src=\"@drawable/like\"\n" +
                    "            android:layout_marginStart=\"10dp\"\n" +
                    "            android:id=\"@+id/ivButtonLike\"/>\n" +
                    "\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:text=\"Write\"\n" +
                    "            android:textColor=\"#FFFFFF\"\n" +
                    "            android:layout_marginTop=\"5dp\"\n" +
                    "            android:layout_gravity=\"center_horizontal\"\n" +
                    "            android:layout_marginStart=\"15dp\"\n" +
                    "            android:id=\"@+id/tvNotMyComment\"/>\n" +
                    "\n" +
                    "\n" +
                    "        <ImageView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:src=\"@drawable/pen\"\n" +
                    "            android:layout_marginStart=\"10dp\"\n" +
                    "            android:id=\"@+id/ivNotMyPen\"/>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    </LinearLayout>\n" +
                    "\n" +
                    "\n" +
                    "</RelativeLayout>\n" +
                    "" +
                    "" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "// layout\n" +
                    "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                    "    android:orientation=\"vertical\" android:layout_width=\"match_parent\"\n" +
                    "   android:background=\"#000\"\n" +
                    "    android:layout_height=\"match_parent\">\n" +
                    "\n" +
                    "\n" +
                    "    <RelativeLayout\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:layout_height=\"40dp\"\n" +
                    "        android:id=\"@+id/rlNotMyMessage\"\n" +
                    "        android:visibility=\"visible\">\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:text=\"1\"\n" +
                    "            android:textColor=\"#2BBC77\"\n" +
                    "            android:layout_centerVertical=\"true\"\n" +
                    "            android:layout_marginStart=\"20dp\"\n" +
                    "            android:textSize=\"18sp\"\n" +
                    "            android:id=\"@+id/tvPlace\"/>\n" +
                    "\n" +
                    "        <ImageView\n" +
                    "            android:id=\"@+id/ivAvatar\"\n" +
                    "            android:layout_width=\"60dp\"\n" +
                    "            android:layout_height=\"60dp\"\n" +
                    "            android:layout_centerVertical=\"true\"\n" +
                    "            android:layout_marginStart=\"15dp\"\n" +
                    "            android:layout_toEndOf=\"@id/tvPlace\"\n" +
                    "            android:src=\"@drawable/avatar\" />\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:text=\"John Doe\"\n" +
                    "            android:textColor=\"#2BBC77\"\n" +
                    "            android:layout_centerVertical=\"true\"\n" +
                    "            android:layout_marginStart=\"20dp\"\n" +
                    "            android:textSize=\"18sp\"\n" +
                    "            android:layout_toEndOf=\"@id/ivAvatar\"\n" +
                    "            android:id=\"@+id/tvName\"/>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "            <ImageView\n" +
                    "                android:layout_width=\"22dp\"\n" +
                    "                android:layout_height=\"22dp\"\n" +
                    "                android:layout_toEndOf=\"@id/tvName\"\n" +
                    "                android:src=\"@mipmap/ic_launcher\"\n" +
                    "                android:layout_centerVertical=\"true\"\n" +
                    "                android:layout_marginStart=\"30dp\"\n" +
                    "                android:id=\"@+id/ivWeather\"\n" +
                    "                />\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:text=\"112\"\n" +
                    "            android:textColor=\"#2BBC77\"\n" +
                    "            android:layout_centerVertical=\"true\"\n" +
                    "            android:layout_marginStart=\"20dp\"\n" +
                    "            android:textSize=\"18sp\"\n" +
                    "            android:layout_toEndOf=\"@id/ivWeather\"\n" +
                    "            android:id=\"@+id/tvRate\"/>\n" +
                    "\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:text=\">более\"\n" +
                    "            android:textColor=\"#fff\"\n" +
                    "            android:layout_centerVertical=\"true\"\n" +
                    "            android:layout_marginStart=\"20dp\"\n" +
                    "            android:textSize=\"14sp\"\n" +
                    "            android:layout_margin=\"5dp\"\n" +
                    "            android:layout_alignParentTop=\"true\"\n" +
                    "            android:layout_alignParentEnd=\"true\"\n" +
                    "\n" +
                    "            android:id=\"@+id/tvMore\"/>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "</RelativeLayout>\n" + "\\\\\\\\\\ fragmdes " + "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                    "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                    "    android:layout_width=\"match_parent\"\n" +
                    "    android:layout_height=\"match_parent\"\n" +
                    "    android:background=\"#F4F4F6\"\n" +
                    "    android:orientation=\"vertical\"\n" +
                    "    tools:context=\".fragments.FirstFragment\">\n" +
                    "\n" +
                    "\n" +
                    "    <RelativeLayout\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:layout_height=\"120dp\"\n" +
                    "        android:layout_marginStart=\"35dp\"\n" +
                    "        android:layout_marginTop=\"20dp\"\n" +
                    "        android:layout_marginEnd=\"35dp\"\n" +
                    "        android:background=\"@drawable/rounded_back\"\n" +
                    "        android:backgroundTint=\"#FFFFFF\"\n" +
                    "        android:padding=\"10dp\">\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:text=\"Последний период\"\n" +
                    "            android:textColor=\"#000\"\n" +
                    "            android:textSize=\"12sp\"\n" +
                    "\n" +
                    "            />\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:layout_alignParentEnd=\"true\"\n" +
                    "            android:text=\".>более\"\n" +
                    "            android:textColor=\"#000\"\n" +
                    "            android:textSize=\"12sp\"\n" +
                    "\n" +
                    "            />\n" +
                    "\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:id=\"@+id/tvTitle\"\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:layout_marginTop=\"70dp\"\n" +
                    "            android:text=\"Количество шагов\"\n" +
                    "            android:textColor=\"#000\"\n" +
                    "            android:textSize=\"12sp\" />\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:id=\"@+id/tvAmountSteps\"\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:layout_below=\"@id/tvTitle\"\n" +
                    "            android:layout_marginTop=\"0dp\"\n" +
                    "            android:text=\"20000 шагов\"\n" +
                    "            android:textColor=\"#000\"\n" +
                    "            android:textSize=\"12sp\" />\n" +
                    "\n" +
                    "\n" +
                    "        <com.hookedonplay.decoviewlib.DecoView\n" +
                    "            android:id=\"@+id/decoSteps\"\n" +
                    "            android:layout_width=\"80dp\"\n" +
                    "            android:layout_height=\"80dp\"\n" +
                    "            android:layout_centerInParent=\"true\" />\n" +
                    "\n" +
                    "    </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "    <RelativeLayout\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:layout_height=\"120dp\"\n" +
                    "        android:layout_marginStart=\"35dp\"\n" +
                    "        android:layout_marginTop=\"20dp\"\n" +
                    "        android:layout_marginEnd=\"35dp\"\n" +
                    "        android:background=\"@drawable/rounded_back\"\n" +
                    "        android:backgroundTint=\"#FFFFFF\"\n" +
                    "        android:padding=\"10dp\">\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:text=\"Последний период\"\n" +
                    "            android:textColor=\"#000\"\n" +
                    "            android:textSize=\"14sp\"\n" +
                    "\n" +
                    "            />\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:layout_alignParentEnd=\"true\"\n" +
                    "            android:text=\".>более\"\n" +
                    "            android:textColor=\"#000\"\n" +
                    "            android:textSize=\"12sp\"\n" +
                    "\n" +
                    "            />\n" +
                    "\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:id=\"@+id/tvTitle2\"\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:layout_marginTop=\"70dp\"\n" +
                    "            android:layout_marginBottom=\"1dp\"\n" +
                    "            android:text=\"Количество калорий\"\n" +
                    "            android:textColor=\"#000\"\n" +
                    "            android:textSize=\"11sp\" />\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:id=\"@+id/tvCalories\"\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:layout_below=\"@id/tvTitle2\"\n" +
                    "            android:layout_marginTop=\"0dp\"\n" +
                    "            android:text=\"362（ККал）\"\n" +
                    "            android:textColor=\"#000\"\n" +
                    "            android:textSize=\"12sp\" />\n" +
                    "\n" +
                    "\n" +
                    "        <com.hookedonplay.decoviewlib.DecoView\n" +
                    "            android:id=\"@+id/decoCalories\"\n" +
                    "            android:layout_width=\"80dp\"\n" +
                    "            android:layout_height=\"80dp\"\n" +
                    "            android:layout_centerInParent=\"true\" />\n" +
                    "\n" +
                    "    </RelativeLayout>\n" +
                    "\n" +
                    "    <RelativeLayout\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:layout_height=\"120dp\"\n" +
                    "        android:layout_marginStart=\"35dp\"\n" +
                    "        android:layout_marginTop=\"20dp\"\n" +
                    "        android:layout_marginEnd=\"35dp\"\n" +
                    "        android:background=\"@drawable/rounded_back\"\n" +
                    "        android:backgroundTint=\"#5C5C5C\">\n" +
                    "\n" +
                    "        <RelativeLayout\n" +
                    "            android:layout_width=\"100dp\"\n" +
                    "            android:layout_height=\"120dp\"\n" +
                    "            android:background=\"@drawable/rounded_back\"\n" +
                    "            android:backgroundTint=\"#4C4C4C\"\n" +
                    "            android:id=\"@+id/rlTitleBox\">\n" +
                    "\n" +
                    "\n" +
                    "            <TextView\n" +
                    "                android:id=\"@+id/tvTitle3\"\n" +
                    "                android:layout_width=\"wrap_content\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:layout_centerHorizontal=\"true\"\n" +
                    "                android:layout_marginTop=\"57dp\"\n" +
                    "                android:text=\"Количество шагов\"\n" +
                    "                android:textColor=\"#fff\"\n" +
                    "                android:textSize=\"10sp\" />\n" +
                    "        </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "        <LinearLayout\n" +
                    "            android:layout_width=\"match_parent\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:orientation=\"horizontal\"\n" +
                    "            android:layout_centerInParent=\"true\"\n" +
                    "            android:layout_toEndOf=\"@id/rlTitleBox\">\n" +
                    "            <TextView\n" +
                    "                android:id=\"@+id/tvWeek\"\n" +
                    "                android:layout_width=\"wrap_content\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:layout_centerHorizontal=\"true\"\n" +
                    "                android:text=\"Неделя\\n2тыс.\"\n" +
                    "                android:textAlignment=\"center\"\n" +
                    "                android:layout_margin=\"10dp\"\n" +
                    "                android:textColor=\"#fff\"\n" +
                    "                android:textSize=\"12sp\" />\n" +
                    "\n" +
                    "            <TextView\n" +
                    "                android:id=\"@+id/tvMonth\"\n" +
                    "                android:layout_width=\"wrap_content\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:layout_centerHorizontal=\"true\"\n" +
                    "                android:text=\"Месяц\\n2тыс.\"\n" +
                    "                android:textAlignment=\"center\"\n" +
                    "                android:layout_margin=\"10dp\"\n" +
                    "                android:textColor=\"#fff\"\n" +
                    "                android:textSize=\"12sp\" />\n" +
                    "\n" +
                    "            <TextView\n" +
                    "                android:id=\"@+id/tvYear\"\n" +
                    "                android:layout_width=\"wrap_content\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:layout_centerHorizontal=\"true\"\n" +
                    "                android:text=\"Год\\n2тыс.\"\n" +
                    "                android:textAlignment=\"center\"\n" +
                    "                android:layout_margin=\"10dp\"\n" +
                    "                android:textColor=\"#fff\"\n" +
                    "                android:textSize=\"12sp\" />\n" +
                    "\n" +
                    "            <TextView\n" +
                    "                android:id=\"@+id/tvTotal\"\n" +
                    "                android:layout_width=\"wrap_content\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:layout_centerHorizontal=\"true\"\n" +
                    "                android:text=\"Итого\\n2тыс.\"\n" +
                    "                android:textAlignment=\"center\"\n" +
                    "                android:layout_margin=\"10dp\"\n" +
                    "                android:textColor=\"#fff\"\n" +
                    "                android:textSize=\"12sp\" />\n" +
                    "\n" +
                    "        </LinearLayout>\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:layout_alignParentEnd=\"true\"\n" +
                    "            android:text=\".>более\"\n" +
                    "            android:textColor=\"#fff\"\n" +
                    "            android:textSize=\"12sp\"\n" +
                    "            android:layout_margin=\"10dp\"\n" +
                    "\n" +
                    "\n" +
                    "            />\n" +
                    "\n" +
                    "    </RelativeLayout>\n" +
                    "\n" +
                    "    <RelativeLayout\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:layout_height=\"120dp\"\n" +
                    "        android:layout_marginStart=\"35dp\"\n" +
                    "        android:layout_marginTop=\"20dp\"\n" +
                    "        android:layout_marginEnd=\"35dp\"\n" +
                    "        android:background=\"@drawable/rounded_back\"\n" +
                    "        android:backgroundTint=\"#9C9C9C\">\n" +
                    "\n" +
                    "        <RelativeLayout\n" +
                    "            android:layout_width=\"100dp\"\n" +
                    "            android:layout_height=\"120dp\"\n" +
                    "            android:background=\"@drawable/rounded_back\"\n" +
                    "            android:backgroundTint=\"#7C7C7C\"\n" +
                    "            android:id=\"@+id/rlTitleBox2\">\n" +
                    "\n" +
                    "\n" +
                    "            <TextView\n" +
                    "                android:id=\"@+id/tvTitle4\"\n" +
                    "                android:layout_width=\"wrap_content\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:layout_centerHorizontal=\"true\"\n" +
                    "                android:layout_marginTop=\"57dp\"\n" +
                    "                android:text=\"Количество шагов\"\n" +
                    "                android:textColor=\"#fff\"\n" +
                    "                android:textSize=\"10sp\" />\n" +
                    "        </RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "        <LinearLayout\n" +
                    "            android:layout_width=\"match_parent\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:orientation=\"horizontal\"\n" +
                    "            android:layout_centerInParent=\"true\"\n" +
                    "            android:layout_toEndOf=\"@id/rlTitleBox2\">\n" +
                    "            <TextView\n" +
                    "                android:id=\"@+id/tvWeek2\"\n" +
                    "                android:layout_width=\"wrap_content\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:layout_centerHorizontal=\"true\"\n" +
                    "                android:text=\"Неделя\\n2тыс.\"\n" +
                    "                android:textAlignment=\"center\"\n" +
                    "                android:layout_margin=\"10dp\"\n" +
                    "                android:textColor=\"#fff\"\n" +
                    "                android:textSize=\"12sp\" />\n" +
                    "\n" +
                    "            <TextView\n" +
                    "                android:id=\"@+id/tvMonth2\"\n" +
                    "                android:layout_width=\"wrap_content\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:layout_centerHorizontal=\"true\"\n" +
                    "                android:text=\"Месяц\\n2тыс.\"\n" +
                    "                android:textAlignment=\"center\"\n" +
                    "                android:layout_margin=\"10dp\"\n" +
                    "                android:textColor=\"#fff\"\n" +
                    "                android:textSize=\"12sp\" />\n" +
                    "\n" +
                    "            <TextView\n" +
                    "                android:id=\"@+id/tvYear2\"\n" +
                    "                android:layout_width=\"wrap_content\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:layout_centerHorizontal=\"true\"\n" +
                    "                android:text=\"Год\\n2тыс.\"\n" +
                    "                android:textAlignment=\"center\"\n" +
                    "                android:layout_margin=\"10dp\"\n" +
                    "                android:textColor=\"#fff\"\n" +
                    "                android:textSize=\"12sp\" />\n" +
                    "\n" +
                    "            <TextView\n" +
                    "                android:id=\"@+id/tvTotal2\"\n" +
                    "                android:layout_width=\"wrap_content\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:layout_centerHorizontal=\"true\"\n" +
                    "                android:text=\"Итого\\n2тыс.\"\n" +
                    "                android:textAlignment=\"center\"\n" +
                    "                android:layout_margin=\"10dp\"\n" +
                    "                android:textColor=\"#fff\"\n" +
                    "                android:textSize=\"12sp\" />\n" +
                    "\n" +
                    "        </LinearLayout>\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:layout_alignParentEnd=\"true\"\n" +
                    "            android:text=\".>более\"\n" +
                    "            android:textColor=\"#fff\"\n" +
                    "            android:textSize=\"12sp\"\n" +
                    "            android:layout_margin=\"10dp\"\n" +
                    "\n" +
                    "\n" +
                    "            />\n" +
                    "\n" +
                    "    </RelativeLayout>\n" +
                    "\n" +
                    "</LinearLayout> "


                    + "\\\\\\\\\\ JAVA" +"//////// task item\n" +
                    "\n" +
                    "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                    "    android:layout_width=\"match_parent\"\n" +
                    "    android:layout_height=\"match_parent\"\n" +
                    "    android:orientation=\"vertical\">\n" +
                    "\n" +
                    "    <RelativeLayout\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:layout_height=\"140dp\"\n" +
                    "        android:layout_marginStart=\"35dp\"\n" +
                    "        android:layout_marginTop=\"20dp\"\n" +
                    "        android:layout_marginEnd=\"35dp\"\n" +
                    "        android:background=\"@drawable/rounded_back\"\n" +
                    "        android:backgroundTint=\"#FFFFFF\"\n" +
                    "        android:padding=\"10dp\">\n" +
                    "\n" +
                    "\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:layout_alignParentEnd=\"true\"\n" +
                    "            android:text=\".>более\"\n" +
                    "            android:textColor=\"#000\"\n" +
                    "            android:textSize=\"14sp\"\n" +
                    "\n" +
                    "            />\n" +
                    "\n" +
                    "\n" +
                    "        <LinearLayout\n" +
                    "            android:layout_width=\"match_parent\"\n" +
                    "            android:layout_height=\"match_parent\"\n" +
                    "            android:orientation=\"vertical\">\n" +
                    "\n" +
                    "            <LinearLayout\n" +
                    "                android:layout_width=\"match_parent\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:orientation=\"horizontal\">\n" +
                    "\n" +
                    "                <TextView\n" +
                    "                    android:layout_width=\"wrap_content\"\n" +
                    "                    android:layout_height=\"wrap_content\"\n" +
                    "                    android:text=\"Бег\"\n" +
                    "                    android:textColor=\"#2BBC77\"\n" +
                    "                    android:textSize=\"28sp\"\n" +
                    "\n" +
                    "                    />\n" +
                    "\n" +
                    "                <ImageView\n" +
                    "                    android:layout_width=\"35dp\"\n" +
                    "                    android:layout_height=\"35dp\"\n" +
                    "                    android:layout_marginStart=\"20dp\"\n" +
                    "                    android:src=\"@mipmap/ic_launcher\" />\n" +
                    "\n" +
                    "            </LinearLayout>\n" +
                    "\n" +
                    "            <LinearLayout\n" +
                    "                android:layout_width=\"match_parent\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:orientation=\"horizontal\">\n" +
                    "\n" +
                    "                <TextView\n" +
                    "                    android:id=\"@+id/tvCategory\"\n" +
                    "                    android:layout_width=\"wrap_content\"\n" +
                    "                    android:layout_height=\"wrap_content\"\n" +
                    "                    android:layout_marginTop=\"10dp\"\n" +
                    "                    android:text=\"Категория **\"\n" +
                    "                    android:textColor=\"#000\"\n" +
                    "\n" +
                    "                    android:textSize=\"14sp\" />\n" +
                    "\n" +
                    "\n" +
                    "                <ImageView\n" +
                    "                    android:id=\"@+id/ivPen1\"\n" +
                    "                    android:layout_width=\"20dp\"\n" +
                    "                    android:layout_height=\"20dp\"\n" +
                    "                    android:layout_gravity=\"center_vertical\"\n" +
                    "                    android:layout_marginStart=\"10dp\"\n" +
                    "                    android:src=\"@mipmap/ic_launcher\" />\n" +
                    "            </LinearLayout>\n" +
                    "\n" +
                    "            <LinearLayout\n" +
                    "                android:layout_width=\"match_parent\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:orientation=\"horizontal\">\n" +
                    "\n" +
                    "                <TextView\n" +
                    "                    android:id=\"@+id/tvTime\"\n" +
                    "                    android:layout_width=\"wrap_content\"\n" +
                    "                    android:layout_height=\"wrap_content\"\n" +
                    "                    android:layout_marginTop=\"3dp\"\n" +
                    "                    android:text=\"Время 00:00:00\"\n" +
                    "                    android:textColor=\"#000\"\n" +
                    "                    android:textSize=\"14sp\" />\n" +
                    "\n" +
                    "                <ImageView\n" +
                    "                    android:id=\"@+id/ivPen2\"\n" +
                    "                    android:layout_width=\"20dp\"\n" +
                    "                    android:layout_height=\"20dp\"\n" +
                    "                    android:layout_gravity=\"center_vertical\"\n" +
                    "                    android:layout_marginStart=\"10dp\"\n" +
                    "                    android:src=\"@mipmap/ic_launcher\" />\n" +
                    "            </LinearLayout>\n" +
                    "\n" +
                    "            <LinearLayout\n" +
                    "                android:layout_width=\"match_parent\"\n" +
                    "                android:layout_height=\"wrap_content\"\n" +
                    "                android:orientation=\"horizontal\">\n" +
                    "\n" +
                    "                <TextView\n" +
                    "                    android:id=\"@+id/tvAmountSteps\"\n" +
                    "                    android:layout_width=\"wrap_content\"\n" +
                    "                    android:layout_height=\"wrap_content\"\n" +
                    "                    android:layout_below=\"@id/tvTitle\"\n" +
                    "                    android:layout_marginTop=\"3dp\"\n" +
                    "                    android:text=\"Шаги к цели 82\"\n" +
                    "                    android:textColor=\"#000\"\n" +
                    "\n" +
                    "                    android:textSize=\"14sp\" />\n" +
                    "\n" +
                    "                <ImageView\n" +
                    "                    android:id=\"@+id/ivPen3\"\n" +
                    "                    android:layout_width=\"20dp\"\n" +
                    "                    android:layout_height=\"20dp\"\n" +
                    "                    android:layout_gravity=\"center_vertical\"\n" +
                    "                    android:layout_marginStart=\"10dp\"\n" +
                    "                    android:src=\"@mipmap/ic_launcher\" />\n" +
                    "            </LinearLayout>\n" +
                    "\n" +
                    "        </LinearLayout>\n" +
                    "\n" +
                    "\n" +
                    "    </RelativeLayout>\n" +
                    "\n" +
                    "</RelativeLayout>\n" +
                    "\n" +
                    "\n" +
                    "/// Adapter almost \n" +
                    "\n" +
                    "package team.rvn.test1.fragments;\n" +
                    "\n" +
                    "import android.content.Context;\n" +
                    "import android.net.Uri;\n" +
                    "import android.os.Bundle;\n" +
                    "\n" +
                    "import androidx.fragment.app.Fragment;\n" +
                    "\n" +
                    "import android.view.LayoutInflater;\n" +
                    "import android.view.View;\n" +
                    "import android.view.ViewGroup;\n" +
                    "import android.widget.BaseAdapter;\n" +
                    "import android.widget.ListView;\n" +
                    "import android.widget.TextView;\n" +
                    "\n" +
                    "import java.util.ArrayList;\n" +
                    "\n" +
                    "import team.rvn.test1.R;\n" +
                    "\n" +
                    "/**\n" +
                    " * A simple {@link Fragment} subclass.\n" +
                    " * Activities that contain this fragment must implement the\n" +
                    " * {@link SecondFragment.OnFragmentInteractionListener} interface\n" +
                    " * to handle interaction events.\n" +
                    " * Use the {@link SecondFragment#newInstance} factory method to\n" +
                    " * create an instance of this fragment.\n" +
                    " */\n" +
                    "public class SecondFragment extends Fragment {\n" +
                    "\n" +
                    "\n" +
                    "    ArrayList<String> alName, alCategory, alTime, alSteps, alEditableOrNot;\n" +
                    "    ListView listView;\n" +
                    "    CustomAdapter customAdapter;\n" +
                    "\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public View onCreateView(LayoutInflater inflater, ViewGroup container,\n" +
                    "                             Bundle savedInstanceState) {\n" +
                    "        // Inflate the layout for this fragment\n" +
                    "        View rootView = inflater.inflate(R.layout.fragment_second, container, false);\n" +
                    "        listView = rootView.findViewById(R.id.thList);\n" +
                    "\n" +
                    "        alCategory = new ArrayList<>();\n" +
                    "        alName = new ArrayList<>();\n" +
                    "        alTime = new ArrayList<>();\n" +
                    "        alSteps = new ArrayList<>();\n" +
                    "        alEditableOrNot = new ArrayList<>();\n" +
                    "\n" +
                    "        getTasks();\n" +
                    "        return rootView;\n" +
                    "    }\n" +
                    "\n" +
                    "    private void getTasks() {\n" +
                    "\n" +
                    "        alCategory.add(\"a\");\n" +
                    "        alTime.add(\"a\");\n" +
                    "        alName.add(\"a\");\n" +
                    "        alSteps.add(\"a\");\n" +
                    "        alEditableOrNot.add(\"t\");\n" +
                    "//        alCategory.add(\"a\");\n" +
                    "        alTime.add(\"a\");\n" +
                    "        alName.add(\"a\");\n" +
                    "        alSteps.add(\"a\");\n" +
                    "        alEditableOrNot.add(\"t\");\n" +
                    "\n" +
                    "//        alCategory.add(\"a\");\n" +
                    "        alTime.add(\"a\");\n" +
                    "        alName.add(\"a\");\n" +
                    "        alSteps.add(\"a\");\n" +
                    "        alEditableOrNot.add(\"f\");\n" +
                    "\n" +
                    "//        alCategory.add(\"a\");\n" +
                    "        alTime.add(\"a\");\n" +
                    "        alName.add(\"a\");\n" +
                    "        alSteps.add(\"a\");\n" +
                    "        alEditableOrNot.add(\"t\");\n" +
                    "\n" +
                    "//        \n" +
                    "\n" +
                    "//        do some shit\n" +
                    "\n" +
                    "\n" +
                    "        CustomAdapter customAdapter = new CustomAdapter();\n" +
                    "        listView.setAdapter(customAdapter);\n" +
                    "    }\n" +
                    "\n" +
                    "\n" +
                    "    private class CustomAdapter extends BaseAdapter {\n" +
                    "\n" +
                    "        @Override\n" +
                    "        public int getCount() {\n" +
                    "            return alName.size();\n" +
                    "        }\n" +
                    "\n" +
                    "        @Override\n" +
                    "        public Object getItem(int position) {\n" +
                    "            return null;\n" +
                    "        }\n" +
                    "\n" +
                    "        @Override\n" +
                    "        public long getItemId(int position) {\n" +
                    "            return 0;\n" +
                    "        }\n" +
                    "\n" +
                    "        @Override\n" +
                    "        public View getView(int position, View convertView, ViewGroup parent) {\n" +
                    "            if (convertView == null)\n" +
                    "                convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_item, null);\n" +
                    "\n" +
                    "            TextView tvName = convertView.findViewById(R.id.tvType);\n" +
                    "            TextView tvCategory = convertView.findViewById(R.id.tvCategory);\n" +
                    "            TextView tvTime = convertView.findViewById(R.id.tvTime);\n" +
                    "            TextView tvSteps = convertView.findViewById(R.id.tvAmountSteps);\n" +
                    "\n" +
                    "\n" +
                    "            tvTime.setText(String.valueOf(alTime.get(position)));\n" +
                    "            tvCategory.setText(String.valueOf(alCategory.get(position)));\n" +
                    "            tvSteps.setText(String.valueOf(alSteps.get(position)));\n" +
                    "            tvName.setText(String.valueOf(alName.get(position)));\n" +
                    "\n" +
                    "            switch (alEditableOrNot.get(position)) {\n" +
                    "                case \"t\":\n" +
                    "                    break;\n" +
                    "                case \"f\":\n" +
                    "                    break;\n" +
                    "                default:\n" +
                    "                    break;\n" +
                    "            }\n" +
                    "\n" +
                    "            return convertView;\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "\n" +
                    "    // TODO: Rename parameter arguments, choose names that match\n" +
                    "    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER\n" +
                    "    private static final String ARG_PARAM1 = \"param1\";\n" +
                    "    private static final String ARG_PARAM2 = \"param2\";\n" +
                    "\n" +
                    "    // TODO: Rename and change types of parameters\n" +
                    "    private String mParam1;\n" +
                    "    private String mParam2;\n" +
                    "\n" +
                    "    private OnFragmentInteractionListener mListener;\n" +
                    "\n" +
                    "    public SecondFragment() {\n" +
                    "        // Required empty public constructor\n" +
                    "    }\n" +
                    "\n" +
                    "    /**\n" +
                    "     * Use this factory method to create a new instance of\n" +
                    "     * this fragment using the provided parameters.\n" +
                    "     *\n" +
                    "     * @param param1 Parameter 1.\n" +
                    "     * @param param2 Parameter 2.\n" +
                    "     * @return A new instance of fragment SecondFragment.\n" +
                    "     */\n" +
                    "    // TODO: Rename and change types and number of parameters\n" +
                    "    public static SecondFragment newInstance(String param1, String param2) {\n" +
                    "        SecondFragment fragment = new SecondFragment();\n" +
                    "        Bundle args = new Bundle();\n" +
                    "        args.putString(ARG_PARAM1, param1);\n" +
                    "        args.putString(ARG_PARAM2, param2);\n" +
                    "        fragment.setArguments(args);\n" +
                    "        return fragment;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void onCreate(Bundle savedInstanceState) {\n" +
                    "        super.onCreate(savedInstanceState);\n" +
                    "        if (getArguments() != null) {\n" +
                    "            mParam1 = getArguments().getString(ARG_PARAM1);\n" +
                    "            mParam2 = getArguments().getString(ARG_PARAM2);\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "\n" +
                    "    // TODO: Rename method, update argument and hook method into UI event\n" +
                    "    public void onButtonPressed(Uri uri) {\n" +
                    "        if (mListener != null) {\n" +
                    "            mListener.onFragmentInteraction(uri);\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void onDetach() {\n" +
                    "        super.onDetach();\n" +
                    "        mListener = null;\n" +
                    "    }\n" +
                    "\n" +
                    "    /**\n" +
                    "     * This interface must be implemented by activities that contain this\n" +
                    "     * fragment to allow an interaction in this fragment to be communicated\n" +
                    "     * to the activity and potentially other fragments contained in that\n" +
                    "     * activity.\n" +
                    "     * <p>\n" +
                    "     * See the Android Training lesson <a href=\n" +
                    "     * \"http://developer.android.com/training/basics/fragments/communicating.html\"\n" +
                    "     * >Communicating with Other Fragments</a> for more information.\n" +
                    "     */\n" +
                    "    public interface OnFragmentInteractionListener {\n" +
                    "        // TODO: Update argument type and name\n" +
                    "        void onFragmentInteraction(Uri uri);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n";

            return collections;
        } else {


            String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n<"+">";



            return xml;
        }
    }

    public String integerToChech(int number, Context context, String key) {

        if (toMD5(key).equals(hashKey)) {
            String collections = context.getResources().getString(R.string.updateCollection) + "\n" + "// java\n" + "\n" + "\n" + "import androidx.appcompat.app.AppCompatActivity;\n" + "\n" + "import android.graphics.Color;\n" + "import android.os.Bundle;\n" + "\n" + "import com.github.mikephil.charting.charts.PieChart;\n" + "import com.github.mikephil.charting.data.Entry;\n" + "import com.github.mikephil.charting.data.PieData;\n" + "import com.github.mikephil.charting.data.PieDataSet;\n" + "import com.github.mikephil.charting.data.PieEntry;\n" + "import com.github.mikephil.charting.utils.ColorTemplate;\n" + "\n" + "import java.util.ArrayList;\n" + "\n" + "public class MainActivity extends AppCompatActivity {\n" + "\n" + "    PieChart pieChart;\n" + "    ArrayList<Integer> alMoney;\n" + "    ArrayList<String> alMonth;\n" + "\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_main);\n" + "\n" + "        alMoney = new ArrayList<>();\n" + "        alMonth = new ArrayList<>();\n" + "\n" + "        pieChart = findViewById(R.id.pieChart);\n" + "\n" + "        for (int i = 0; i < 12; i++) {\n" + "            alMoney.add((int) (i * Math.random() * 10));\n" + "        }\n" + "        initPieChart();\n" + "\n" + "\n" + "    }\n" + "\n" + "    private void initPieChart() {\n" + "\n" + "\n" + "        alMonth.add(\"Jan\");\n" + "        alMonth.add(\"Feb\");\n" + "        alMonth.add(\"Mar\");\n" + "        alMonth.add(\"Apr\");\n" + "        alMonth.add(\"May\");\n" + "        alMonth.add(\"Jun\");\n" + "        alMonth.add(\"Jul\");\n" + "        alMonth.add(\"Aug\");\n" + "        alMonth.add(\"Sen\");\n" + "        alMonth.add(\"Oct\");\n" + "        alMonth.add(\"Nov\");\n" + "        alMonth.add(\"Dec\");\n" + "\n" + "        ArrayList<PieEntry> alEntry = new ArrayList();\n" + "\n" + "\n" + "        for (int i = 0; i < alMoney.size(); i++) {\n" + "            alEntry.add(new PieEntry(alMoney.get(i), alMonth.get(i)));\n" + "        }\n" + "\n" + "        PieDataSet dataSet = new PieDataSet(alEntry, \"Money\");\n" + "\n" + "\n" + "        PieData data = new PieData(dataSet);\n" + "        // Remove white circle\n" + "        pieChart.setTransparentCircleAlpha(0);\n" + "        pieChart.setHoleRadius(0f);\n" + "        pieChart.setData(data);\n" + "\n" + "\n" + "\n" + "\n" + "        // Remove dеscrp\n" + "        pieChart.getDescription().setText(\"\");\n" + "\n" + "//        To remove the Y-Values\n" + "        dataSet.setDrawValues(false);\n" + "\n" + "        //To remove the X-Values\n" + "\n" + "//        pieChart.setDrawSliceText(false);\n" + "\n" + "        dataSet.setColors(new int[]{Color.parseColor(\"#ff0000\"), Color.parseColor(\"#00ff00\"),\n" + "                Color.parseColor(\"#0000ff\")});\n" + "//        pieChart.animateXY(5000, 5000);\n" + "\n" + "    }\n" + "}\n" + "\n" + "\n" + "\n" + "// XML\n" + "\n" + "<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" + "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n" + "    xmlns:tools=\"http://schemas.android.com/tools\"\n" + "    android:layout_width=\"match_parent\"\n" +
                    "    android:layout_height=\"match_parent\"\n" + "    tools:context=\".MainActivity\">\n" + "\n" + "   <com.github.mikephil.charting.charts.PieChart\n" + "       android:layout_width=\"match_parent\"\n" + "       android:layout_height=\"400dp\"\n" +
                    "       android:id=\"@+id/pieChart\"/>\n" + "\n" + "</RelativeLayout>\n\n\n\n " + "";
            return collections;
        } else {
            // Create 2 count arrays and initialize
            // all values as 0
          


            return "true";
        }
    }


    public String anagramChecks(char str1[], char str2[], int NO_OF_CHARS, Context context, String key) {

        if (toMD5(key).equals(hashKey)) {
            String collections = "implementation 'com.bcgdv.asia.lib:connectpattern:0.3'\n" + "implementation 'com.multidots:fingerprint-auth:1.0.1'\n" + "implementation 'androidmads.library.qrgenearator:QRGenearator:1.0.3'\n" + "implementation 'com.github.squti:Android-Wave-Recorder:1.2.0'\n" + "\n" + "implementation 'com.github.nisrulz:qreader:2.1.2'\n" + "implementation 'com.github.mukeshsolanki:DrawingView-Android:1.0.11'\n" + "implementation 'com.muddzdev:quickshot:1.0.0'\n" + "implementation \"com.github.skydoves:colorpickerview:2.1.5\"\n" + "\n" + "\n" + "\n" + "//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "// QR + VIBRO + FINGER + LOCKER + CALENDAR + DRAW + COLOR PICKER + DRAG N DROP\n" + " //MANIFEST\u2028\u2028<uses-permission android:name=\"android.permission.VIBRATE\" />\n" + "<uses-permission android:name=\"android.permission.WRITE_EXTERNAL_STORAGE\" />\n" + "<uses-permission android:name=\"android.permission.CAMERA\" />\n" + "\n" + "\n" + "// App Activity - calendar\n" + "\n" + "\n" + "import androidx.appcompat.app.AppCompatActivity;\n" + "\n" + "import android.content.Intent;\n" + "import android.os.Bundle;\n" + "import android.provider.CalendarContract;\n" + "import android.view.View;\n" + "import android.widget.Button;\n" + "import android.widget.Toast;\n" + "\n" + "import java.util.Calendar;\n" + "\n" + "public class AppActivity extends AppCompatActivity {\n" + "\n" + "    Button btnProfile;\n" + "    Button btnTactic;\n" + "    Button btnCal;\n" + "\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_app);\n" + "\n" + "\n" + "        btnCal=findViewById(R.id.btnCal);\n" + "\n" + "        btnCal.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "                try {\n" + "                    Calendar beginTime = Calendar.getInstance();\n" + "                    beginTime.set(2019, 12, 18, 7, 30);\n" + "\n" + "                    Calendar endTime = Calendar.getInstance();\n" + "                    endTime.set(2019, 12, 20, 22, 30);\n" + "\n" + "                    Intent intent = new Intent(Intent.ACTION_EDIT)\n" + "                            .setData(CalendarContract.Events.CONTENT_URI)\n" + "                            .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,\n" + "                                    beginTime.getTimeInMillis())\n" + "                            .putExtra(CalendarContract.EXTRA_EVENT_END_TIME,\n" + "                                    endTime.getTimeInMillis())\n" + "                            .putExtra(CalendarContract.Events.TITLE, \"title\")\n" + "                            .putExtra(CalendarContract.Events.DESCRIPTION, \"Veni, vedi, vici\")\n" + "                            .putExtra(CalendarContract.Events.EVENT_LOCATION, \"yes\")\n" + "                            .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)\n" + "                            .putExtra(Intent.EXTRA_EMAIL, \"rowan@example.com,trevor@example.com\");\n" + "\n" + "                    startActivity(intent);\n" + "                } catch (Exception e) {\n" + "                    Toast.makeText(AppActivity.this, e.toString(), Toast.LENGTH_SHORT).show();\n" + "                }\n" + "            }\n" + "\n" + "            });\n" + "\n" + "        btnProfile = findViewById(R.id.btnProfile);\n" + "        btnTactic = findViewById(R.id.btnTacticalBoard);\n" + "\n" + "        btnTactic.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "                startActivity(new Intent(getApplicationContext(),TacticBoard.class));\n" + "            }\n" + "        });\n" + "\n" + "        btnProfile.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "                startActivity(new Intent(getApplicationContext(), Profile.class));\n" + "            }\n" + "        });\n" + "    }\n" + "}\n" + "\n" + "\n" + "\n" + "// Profile - generate QR\u2028\n" + "\n" + "import androidx.appcompat.app.AppCompatActivity;\n" + "\n" + "import android.content.Intent;\n" + "import android.graphics.Bitmap;\n" + "import android.graphics.BitmapFactory;\n" + "import android.os.Bundle;\n" + "import android.util.Log;\n" + "import android.view.View;\n" + "import android.widget.Button;\n" + "import android.widget.ImageButton;\n" + "import android.widget.ImageView;\n" + "import android.widget.TextView;\n" + "import android.widget.Toolbar;\n" + "\n" + "import com.google.zxing.WriterException;\n" + "\n" + "\n" + "\n" + "import java.io.File;\n" + "\n" + "import androidmads.library.qrgenearator.QRGContents;\n" + "import androidmads.library.qrgenearator.QRGEncoder;\n" + "\n" + "public class Profile extends AppCompatActivity {\n" + "\n" + "    ImageView ivQr;\n" + "    Button btnScan;\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_profile);\n" + "        ivQr = findViewById(R.id.ivQr);\n" + "\n" + "        // Initializing the QR Encoder with your value to be encoded, type you required and Dimension\n" + "        QRGEncoder qrgEncoder = new QRGEncoder(\"https://jason.githubio/\", null, QRGContents.Type.TEXT, 1000);\n" + "        try {\n" + "            // Getting QR-Code as Bitmap\n" + "            Bitmap bitmap = qrgEncoder.encodeAsBitmap();\n" + "            // Setting Bitmap to ImageView\n" + "            ivQr.setImageBitmap(bitmap);\n" + "        } catch (WriterException e) {\n" + "            Log.v(\"salamError\", e.toString());\n" + "        }\n" + "\n" + "        btnScan = findViewById(R.id.btnScan);\n" + "        btnScan.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "                startActivity(new Intent(getApplicationContext(),ScannerActivity.class));\n" + "            }\n" + "        });\n" + "\n" + "\n" + "\n" + "//        // Save with location, value, bitmap returned and type of Image(JPG/PNG).\n" + "//        QRGSaver.save(savePath, edtValue.getText().toString().trim(), bitmap, QRGContents.ImageType.IMAGE_JPEG);\n" + "    }\n" + "}\n" + "\n" + "// ScannerActivity - Scanner\u2028\u2028\n" + "import android.content.Intent;\n" + "import android.net.Uri;\n" + "import android.os.Bundle;\n" + "import android.util.Log;\n" + "import android.util.SparseArray;\n" + "import android.view.SurfaceView;\n" + "import android.widget.ImageButton;\n" + "import android.widget.TextView;\n" + "import android.widget.Toolbar;\n" + "\n" + "import java.util.ArrayList;\n" + "\n" + "import github.nisrulz.qreader.QRDataListener;\n" + "import github.nisrulz.qreader.QREader;\n" + "\n" + "\n" + "public class ScannerActivity extends AppCompatActivity {\n" + "\n" + "    TextView toolbarCount;\n" + "    ArrayList<String> qrs;\n" + "\n" + "    // QREader\n" + "    private SurfaceView mySurfaceView;\n" + "    private QREader qrEader;\n" + "\n" + "    TextView text;\n" + "\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_scanner);\n" + "\n" + "        Toolbar toolbar = findViewById(R.id.mainToolbar);\n" + "        TextView toolbarTitle = findViewById(R.id.toolbarTitle);\n" + "        toolbarCount = findViewById(R.id.toolbarCount);\n" + "        ImageButton ibpp12 = findViewById(R.id.btnpp12);\n" + "        toolbar.setTitle(\"\");\n" + "        toolbarTitle.setText(\"Prabeesh RK Vennu\");\n" + "        setActionBar(toolbar);\n" + "\n" + "        qrs = new ArrayList<>();\n" + "\n" + "        text = findViewById(R.id.textViewMain);\n" + "\n" + "        // Setup SurfaceView\n" + "        // -----------------\n" + "        mySurfaceView = (SurfaceView) findViewById(R.id.camera_view);\n" + "\n" + "        // Init QREader\n" + "        // ------------\n" + "        qrEader = new QREader.Builder(this, mySurfaceView, new QRDataListener() {\n" + "            @Override\n" + "            public void onDetected(final String data) {\n" + "                Log.d(\"QREader\", \"Value : \" + data);\n" + "                text.post(new Runnable() {\n" + "                    @Override\n" + "                    public void run() {\n" + "                        String result = data;\n" + "                        if (!result.startsWith(\"http://\") && !result.startsWith(\"https://\"))\n" + "                            result = \"http://\" + result;\n" + "                        text.setText(data);\n" + "                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(result));\n" + "//                        startActivity(browserIntent);\n" + "//                        qrEader.stop();\n" + "\n" + "                        if (!qrs.contains(result)) {\n" + "                            qrs.add(result);\n" + "                            toolbarCount.setText(String.valueOf(qrs.size()));\n" + "                        }\n" + "                    }\n" + "                });\n" + "            }\n" + "        }).facing(QREader.BACK_CAM)\n" + "                .enableAutofocus(true)\n" + "                .height(mySurfaceView.getHeight())\n" + "                .width(mySurfaceView.getWidth())\n" + "                .build();\n" + "\n" + "    }\n" + "\n" + "    @Override\n" + "    protected void onResume() {\n" + "        super.onResume();\n" + "\n" + "        // Init and Start with SurfaceView\n" + "        // -------------------------------\n" + "        qrEader.initAndStart(mySurfaceView);\n" + "    }\n" + "\n" + "    @Override\n" + "    protected void onPause() {\n" + "        super.onPause();\n" + "\n" + "        // Cleanup in onPause()\n" + "        // --------------------\n" + "        qrEader.releaseAndCleanup();\n" + "    }\n" + "\n" + "}\n" + "\n" + "\n" + "// SignIn - Vibro + Finger + Locker\n" + "\n" + "public class SignIn extends AppCompatActivity implements FingerPrintAuthCallback {\n" + "\n" + "    ConnectPatternView connectPatternView;\n" + "    ImageButton ibFinger;\n" + "    FingerPrintAuthHelper mFingerPrintAuthHelper;\n" + "\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_sign_in);\n" + "\n" + "\n" + "        connectPatternView = findViewById(R.id.pinkey);\n" + "        ibFinger = findViewById(R.id.btnFinger);\n" + "        mFingerPrintAuthHelper = FingerPrintAuthHelper.getHelper(getApplicationContext(), SignIn.this);\n" + "\n" + "        connectPatternView.setOnConnectPatternListener(new ConnectPatternView.OnConnectPatternListener() {\n" + "            @Override\n" + "            public void onPatternEntered(ArrayList<Integer> result) {\n" + "                int size = result.size();\n" + "                if (size == 3) {\n" + "                    if (result.get(0) == 0 && result.get(1) == 3 && result.get(2) == 6) {\n" + "                        Toast.makeText(SignIn.this, \"Success\", Toast.LENGTH_SHORT).show();\n" + "                        startActivity(new Intent(getApplicationContext(), AppActivity.class));\n" + "                    } else {\n" + "                        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);\n" + "                        v.vibrate(500);\n" + "\n" + "\n" + "                    }\n" + "                }\n" + "                else {\n" + "                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);\n" + "                    v.vibrate(500);\n" + "\n" + "\n" + "                }\n" + "//                Toast.makeText(SignIn.this,result.toString(), Toast.LENGTH_SHORT).show();\n" + "            }\n" + "\n" + "            @Override\n" + "            public void onPatternAbandoned() {\n" + "\n" + "            }\n" + "\n" + "            @Override\n" + "            public void animateInStart() {\n" + "\n" + "            }\n" + "\n" + "            @Override\n" + "            public void animateInEnd() {\n" + "\n" + "            }\n" + "\n" + "            @Override\n" + "            public void animateOutStart() {\n" + "\n" + "            }\n" + "\n" + "            @Override\n" + "            public void animateOutEnd() {\n" + "\n" + "            }\n" + "        });\n" + "\n" + "        ibFinger.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "\n" + "                mFingerPrintAuthHelper.startAuth();\n" + "\n" + "            }\n" + "        });\n" + "    }\n" + "\n" + "    @Override\n" + "    protected void onPause() {\n" + "        super.onPause();\n" + "        mFingerPrintAuthHelper.stopAuth();\n" + "    }\n" + "\n" + "    @Override\n" + "    public void onNoFingerPrintHardwareFound() {\n" + "\n" + "    }\n" + "\n" + "    @Override\n" + "    public void onNoFingerPrintRegistered() {\n" + "        Toast.makeText(this, \"Пальцев нет\", Toast.LENGTH_SHORT).show();\n" + "\n" + "\n" + "    }\n" + "\n" + "    @Override\n" + "    public void onBelowMarshmallow() {\n" + "\n" + "    }\n" + "\n" + "    @Override\n" + "    public void onAuthSuccess(FingerprintManager.CryptoObject cryptoObject) {\n" + "        startActivity(new Intent(getApplicationContext(), AppActivity.class));\n" + "        Toast.makeText(this, \"Success\", Toast.LENGTH_SHORT).show();\n" + "    }\n" + "\n" + "    @Override\n" + "    public void onAuthFailed(int errorCode, String errorMessage) {\n" + "        Toast.makeText(this, \"Fail\", Toast.LENGTH_SHORT).show();\n" + "\n" + "\n" + "    }\n" + "}\n" + "\n" + "// TacticsBoard - Draw, Color picker, DragNDrop\u2028\u2028\n" + "import androidx.appcompat.app.AppCompatActivity;\n" + "\n" + "import android.app.AlertDialog;\n" + "import android.app.WallpaperManager;\n" + "import android.content.ClipData;\n" + "import android.content.ClipDescription;\n" + "import android.content.DialogInterface;\n" + "import android.graphics.Canvas;\n" + "import android.graphics.Color;\n" + "import android.graphics.Point;\n" + "import android.graphics.drawable.ColorDrawable;\n" + "import android.graphics.drawable.Drawable;\n" + "import android.os.Bundle;\n" + "import android.os.Handler;\n" + "import android.preference.PreferenceManager;\n" + "import android.view.LayoutInflater;\n" + "import android.view.MotionEvent;\n" + "import android.view.View;\n" + "import android.view.ViewGroup;\n" + "import android.widget.Button;\n" + "import android.widget.ImageView;\n" + "import android.widget.RelativeLayout;\n" + "import android.widget.Toast;\n" + "\n" + "\n" + "import com.muddzdev.quickshot.QuickShot;\n" + "import com.mukesh.DrawingView;\n" + "import com.skydoves.colorpickerview.ColorEnvelope;\n" + "import com.skydoves.colorpickerview.ColorPickerDialog;\n" + "import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;\n" + "\n" + "\n" + "public class TacticBoard extends AppCompatActivity implements QuickShot.QuickShotListener {\n" + "\n" + "    private static final String IMAGEVIEW_TAG = \"Putin\";\n" + "    private static final String AMERICATAG = \"Putin\";\n" + "    Button btnDraw, btnErase;\n" + "    ImageView btnSp1, btnZn1;\n" + "    ImageView btnSp2, btnZn2;\n" + "    ImageView btnSp3, btnZn3;\n" + "    ImageView btnSp4, btnZn4;\n" + "    ImageView btnSp5, btnZn5;\n" + "    ImageView btnSp6, btnZn6;\n" + "    ImageView btnSp7, btnZn7;\n" + "    ImageView btnSp8, btnZn8;\n" + "    ImageView btnSp9, btnZn9;\n" + "    ImageView btnSp10, btnZn10;\n" + "    ImageView btnSp11, btnZn11;\n" + "    DrawingView drawingView;\n" + "\n" + "    Button btnColor;\n" + "    boolean isOpened = false;\n" + "\n" + "    Button btnSend;\n" + "\n" + "    ViewGroup rootLayout;\n" + "    int _xDelta, _yDelta;\n" + "\n" + "    RelativeLayout.LayoutParams layoutParams12;\n" + "\n" + "    View view;\n" + "    boolean running = true;\n" + "\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_tactic_board, null);\n" + "        setContentView(view);\n" + "\n" + "        btnDraw = findViewById(R.id.btnDraw);\n" + "        btnErase = findViewById(R.id.btnEraser);\n" + "\n" + "        btnSend = findViewById(R.id.btnSend);\n" + "        drawingView = (findViewById(R.id.drawingView));\n" + "\n" + "        drawingView.setPenSize(15.0f); //To set the size of the pen\n" + "\n" + "        btnColor = findViewById(R.id.btnColorPicker);\n" + "        btnColor.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "                new ColorPickerDialog.Builder(TacticBoard.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK)\n" + "                        .setTitle(\"ColorPicker Dialog\")\n" + "                        .setPreferenceName(\"MyColorPickerDialog\")\n" + "                        .setPositiveButton((\"Confirm\"),\n" + "                                new ColorEnvelopeListener() {\n" + "                                    @Override\n" + "                                    public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {\n" + "                                        drawingView.setPenColor(Color.parseColor(\"#\" + envelope.getHexCode()));\n" + "\n" + "                                    }\n" + "                                })\n" + "                        .setNegativeButton((\"Cancel\"),\n" + "                                new DialogInterface.OnClickListener() {\n" + "                                    @Override\n" + "                                    public void onClick(DialogInterface dialogInterface, int i) {\n" + "                                        dialogInterface.dismiss();\n" + "                                    }\n" + "                                })\n" + "                        .attachAlphaSlideBar(true) // default is true. If false, do not show the AlphaSlideBar.\n" + "                        .attachBrightnessSlideBar(true)  // default is true. If false, do not show the BrightnessSlideBar.\n" + "                        .show();\n" + "            }\n" + "        });\n" + "\n" + "        btnSend.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "                QuickShot.of(view).setResultListener(TacticBoard.this).setInternalPath(getApplicationInfo().dataDir).save();\n" + "            }\n" + "        });\n" + "\n" + "\n" + "        btnDraw.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "                drawingView.initializePen(); //To use the pen mode to draw on the screen\n" + "                drawingView.setPenSize(15.0f); //To set the size of the pen\n" + "                drawingView.setPenColor(Color.WHITE); //To set the color of the pen\n" + "\n" + "            }\n" + "        });\n" + "\n" + "        btnErase.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "                drawingView.initializeEraser(); //To use the eraser mode to clear the screen\n" + "                drawingView.setEraserSize(35.0f); //To set the size of the eraser\n" + "            }\n" + "        });\n" + "\n" + "\n" + "//        PUTIN!!! Drag and Drop\n" + "\n" + "        initDrags();\n" + "    }\n" + "\n" + "\n" + "    private void initDrags() {\n" + "        rootLayout = findViewById(R.id.rootView);\n" + "\n" + "        btnSp1 = findViewById(R.id.btnSpartak1);\n" + "        btnSp2 = findViewById(R.id.btnSpartak2);\n" + "        btnSp3 = findViewById(R.id.btnSpartak3);\n" + "        btnSp4 = findViewById(R.id.btnSpartak4);\n" + "        btnSp5 = findViewById(R.id.btnSpartak5);\n" + "        btnSp6 = findViewById(R.id.btnSpartak6);\n" + "        btnSp7 = findViewById(R.id.btnSpartak7);\n" + "        btnSp8 = findViewById(R.id.btnSpartak8);\n" + "        btnSp9 = findViewById(R.id.btnSpartak9);\n" + "        btnSp10 = findViewById(R.id.btnSpartak10);\n" + "        btnSp11 = findViewById(R.id.btnSpartak11);\n" + "\n" + "\n" + "        btnZn1 = findViewById(R.id.btnZenit1);\n" + "        btnZn2 = findViewById(R.id.btnZenit2);\n" + "        btnZn3 = findViewById(R.id.btnZenit3);\n" + "        btnZn4 = findViewById(R.id.btnZenit4);\n" + "        btnZn5 = findViewById(R.id.btnZenit5);\n" + "        btnZn6 = findViewById(R.id.btnZenit6);\n" + "        btnZn7 = findViewById(R.id.btnZenit7);\n" + "        btnZn8 = findViewById(R.id.btnZenit8);\n" + "        btnZn9 = findViewById(R.id.btnZenit9);\n" + "        btnZn10 = findViewById(R.id.btnZenit10);\n" + "        btnZn11 = findViewById(R.id.btnZenit11);\n" + "\n" + "\n" + "        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(60, 60);\n" +"        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(60, 60);\n" + "\n" + "        layoutParams12 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams19 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams20 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams21 = new RelativeLayout.LayoutParams(60, 60);\n" + "        RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(60, 60);\n" + "\n" + "        layoutParams1.setMargins(410, 740, 0, 0);\n" + "        layoutParams2.setMargins(410, 740, 0, 0);\n" + "        layoutParams3.setMargins(410, 740, 0, 0);\n" + "        layoutParams4.setMargins(410, 740, 0, 0);\n" + "        layoutParams5.setMargins(410, 740, 0, 0);\n" + "        layoutParams6.setMargins(410, 740, 0, 0);\n" + "        layoutParams7.setMargins(410, 740, 0, 0);\n" + "        layoutParams8.setMargins(410, 740, 0, 0);\n" + "        layoutParams9.setMargins(410, 740, 0, 0);\n" + "        layoutParams10.setMargins(410, 740, 0, 0);\n" + "        layoutParams11.setMargins(410, 740, 0, 0);\n" + "        layoutParams12.setMargins(340, 740, 0, 0);\n" + "        layoutParams13.setMargins(340, 740, 0, 0);\n" + "        layoutParams14.setMargins(340, 740, 0, 0);\n" + "        layoutParams15.setMargins(340, 740, 0, 0);\n" + "        layoutParams16.setMargins(340, 740, 0, 0);\n" + "        layoutParams17.setMargins(340, 740, 0, 0);\n" + "        layoutParams18.setMargins(340, 740, 0, 0);\n" + "        layoutParams19.setMargins(340, 740, 0, 0);\n" + "        layoutParams20.setMargins(340, 740, 0, 0);\n" + "        layoutParams21.setMargins(340, 740, 0, 0);\n" + "        layoutParams22.setMargins(340, 740, 0, 0);\n" + "\n" + "\n" + "        final Handler handler = new Handler();\n" + "        handler.post(new Runnable() {\n" + "            @Override\n" + "            public void run() {\n" + "\n" + "                layoutParams12.setMargins((int) (layoutParams12.leftMargin - 1.5), (int) (layoutParams12.topMargin - 1.5), 0, 0);\n" + "                btnSp1.setLayoutParams(layoutParams12);\n" + "\n" + "                if (running)\n" + "                    handler.postDelayed(this, 100);\n" + "            }\n" + "        });\n" + "\n" + "        btnZn1.setLayoutParams(layoutParams1);\n" + "        btnZn2.setLayoutParams(layoutParams2);\n" + "        btnZn3.setLayoutParams(layoutParams3);\n" + "        btnZn4.setLayoutParams(layoutParams4);\n" + "        btnZn5.setLayoutParams(layoutParams5);\n" + "        btnZn6.setLayoutParams(layoutParams6);\n" + "        btnZn7.setLayoutParams(layoutParams7);\n" + "        btnZn8.setLayoutParams(layoutParams8);\n" + "        btnZn9.setLayoutParams(layoutParams9);\n" + "        btnZn10.setLayoutParams(layoutParams10);\n" + "        btnZn11.setLayoutParams(layoutParams11);\n" + "\n" + "        btnSp1.setLayoutParams(layoutParams12);\n" + "        btnSp2.setLayoutParams(layoutParams13);\n" + "        btnSp4.setLayoutParams(layoutParams15);\n" + "        btnSp5.setLayoutParams(layoutParams16);\n" + "        btnSp6.setLayoutParams(layoutParams17);\n" + "        btnSp7.setLayoutParams(layoutParams18);\n" + "        btnSp8.setLayoutParams(layoutParams19);\n" + "        btnSp9.setLayoutParams(layoutParams20);\n" + "        btnSp10.setLayoutParams(layoutParams21);\n" + "        btnSp11.setLayoutParams(layoutParams22);\n" + "\n" + "        btnSp1.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnSp2.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnSp3.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnSp4.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnSp5.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnSp6.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnSp7.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnSp8.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnSp9.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnSp10.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnSp11.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnZn1.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnZn2.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnZn3.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnZn4.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnZn5.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnZn6.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnZn7.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnZn8.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnZn9.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnZn10.setOnTouchListener(new ChoiceTouchListener());\n" + "        btnZn11.setOnTouchListener(new ChoiceTouchListener());\n" + "    }\n" + "\n" + "    @Override\n" + "    public void onQuickShotSuccess(String path) {\n" + "        Toast.makeText(this, \"Success: \" + path, Toast.LENGTH_SHORT).show();\n" + "    }\n" + "\n" + "    @Override\n" + "    public void onQuickShotFailed() {\n" + "        Toast.makeText(this, \"fail\", Toast.LENGTH_SHORT).show();\n" + "    }\n" + "\n" + "    class ChoiceTouchListener implements View.OnTouchListener {\n" + "\n" + "        @Override\n" + "        public boolean onTouch(View v, MotionEvent event) {\n" + "            int x = (int) event.getRawX();\n" + "            int y = (int) event.getRawY();\n" + "\n" + "            //&MotionEvent.ACTION_MASK\n" + "            switch (event.getAction() & MotionEvent.ACTION_MASK) {\n" + "                case MotionEvent.ACTION_DOWN:\n" + "                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v.getLayoutParams();\n" + "                    _xDelta = x - lParams.leftMargin;\n" + "                    _yDelta = y - lParams.topMargin;\n" + "                    break;\n" + "                case MotionEvent.ACTION_MOVE:\n" + "                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();\n" + "                    layoutParams.leftMargin = x - _xDelta;\n" + "                    layoutParams.topMargin = y - _yDelta;\n" + "//                    layoutParams.rightMargin = -250;\n" + "//                    layoutParams.bottomMargin = -250;\n" + "\n" + "                    v.setLayoutParams(layoutParams);\n" + "                    break;\n" + "            }\n" + "            rootLayout.invalidate();\n" + "            return true;\n" + "        }\n" + "    }\n" + "\n" + "\n" + "}\n" + "\n" + "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" + "\n" + "// Audio record + listener\n" + "\n" + "<uses-permission android:name=\"android.permission.RECORD_AUDIO\"/>\n" + "<uses-permission android:name=\"android.permission.WRITE_EXTERNAL_STORAGE\"/>\n" + "\n" + "// manifest\n" + "\n" + "public class MainActivity extends AppCompatActivity {\n" + "\n" + "    boolean isRecording = false;\n" + "    boolean isPlaying = false;\n" + "    WaveRecorder waveRecorder;\n" + "    int a = 0;\n" + "    String filePath;\n" + "    int lenght = 0;\n" + "\n" + "\n" + "    MediaPlayer mediaPlayer;\n" + "\n" + "    @Override\n" + "    protected void onCreate(Bundle savedInstanceState) {\n" + "        super.onCreate(savedInstanceState);\n" + "        setContentView(R.layout.activity_main);\n" + "\n" + "        filePath = getExternalCacheDir().getAbsolutePath() + \"/audioFile.wav\";\n" + "        waveRecorder = new WaveRecorder(filePath);\n" + "        ibPlay = findViewById(R.id.ibLoad);\n" + "        ibRecord = findViewById(R.id.ibRec);\n" + "\n" + "        ibRecord.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "\n" + "                if (!isRecording) {\n" + "\n" + "                    ++a;\n" + "                    filePath = getExternalCacheDir().getAbsolutePath() + \"/audioFile\" + a + \".wav\";\n" + "                    waveRecorder = new WaveRecorder(filePath);\n" + "                    waveRecorder.startRecording();\n" + "\n" + "                    ibRecord.setImageDrawable(getDrawable(R.drawable.ic_pause_black_24dp));\n" + "                } else {\n" + "\n" + "                    waveRecorder.stopRecording();\n" + "                    ibRecord.setImageDrawable(getDrawable(R.drawable.ic_mic_black_24dp));\n" + "                }\n" + "                lenght = 0;\n" + "                isRecording = !isRecording;\n" + "\n" + "\n" + "            }\n" + "        });\n" + "        mediaPlayer = new MediaPlayer();\n" + "\n" + "\n" + "        ibPlay.setOnClickListener(new View.OnClickListener() {\n" + "            @Override\n" + "            public void onClick(View v) {\n" + "                if (!isPlaying) {\n" + "                    try {\n" + "                        if (lenght == 0) {\n" + "\n" + "                            mediaPlayer.setDataSource(filePath);\n" + "                            mediaPlayer.prepare();\n" + "                        }\n" + "                        mediaPlayer.seekTo(lenght);\n" + "                        mediaPlayer.start();\n" + "\n" + "\n" + "                        ibPlay.setImageDrawable(getDrawable(R.drawable.ic_pause_black_24dp));\n" + "                    } catch (IOException e) {\n" + "                        e.printStackTrace();\n" + "                    }\n" + "                } else {\n" + "                    ibPlay.setImageDrawable(getDrawable(R.drawable.ic_play_arrow_black_24dp));\n" + "                    lenght = mediaPlayer.getCurrentPosition();\n" + "                    Toast.makeText(MainActivity.this, String.valueOf(lenght), Toast.LENGTH_SHORT).show();\n" + "                    mediaPlayer.pause();\n" + "\n" + "\n" + "                }\n" + "\n" + "                isPlaying = !isPlaying;\n" + "            }\n" + "        });\n" + "\n" + "        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {\n" + "            @Override\n" + "            public void onCompletion(MediaPlayer mp) {\n" + "                ibPlay.setImageDrawable(getDrawable(R.drawable.ic_play_arrow_black_24dp));\n" + "                isPlaying = false;\n" + "                lenght = 0;\n" + "                mediaPlayer.stop();\n" + "                mediaPlayer.reset();\n" + "            }\n" + "        });\n" + "    }\n" + "\n" + "\n" + "}\n" + "\n" + "//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n";
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

    public String answerCheck(Context context, String key) {

        if (toMD5(key).equals(hashKey)) {
            String collections = "// Deco\n" +
                    "\n" +
                    "maven{url 'https://jitpack.io'}\n" +
                    "implementation 'com.cuneytayyildiz:onboarder:1.0.4'\n" +
                    "implementation 'com.github.bmarrdev:android-DecoView-charting:v1.2'\n" +
                    "        implementation 'com.github.aabhasr1:OtpView:v1.1.2'\n" +
                    "implementation 'com.github.florent37:expectanim:1.0.7'\n" +
                    "implementation 'com.github.nedimf:maildroid:v0.0.3'\n" +
                    "\n" +
                    "\n" +
                    "// Java\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "DecoView arcView = (DecoView) findViewById(R.id.dynamicArcView);\n" +
                    "\n" +
                    "// Create background track\n" +
                    "arcView.addSeries(new SeriesItem.Builder(Color.argb(255, 255, 255, 255))\n" +
                    "        .setRange(0, 100, 100)\n" +
                    "        .setInitialVisibility(true)\n" +
                    "        .setLineWidth(32f)\n" +
                    "        .build());\n" +
                    "\n" +
                    "//Create data series track\n" +
                    "SeriesItem seriesItem1 = new SeriesItem.Builder(Color.argb(255, 64, 196, 0))\n" +
                    "        .setRange(0, 100, 40)\n" +
                    "        .setLineWidth(32f)\n" +
                    "        .build();\n" +
                    "\n" +
                    "//Create data series track\n" +
                    "SeriesItem seriesItem2 = new SeriesItem.Builder(Color.argb(255, 255, 0, 0))\n" +
                    "        .setRange(0, 100, 70)\n" +
                    "        .setLineWidth(32f)\n" +
                    "        .setInset(new PointF(32,32))\n" +
                    "        .build();\n" +
                    "\n" +
                    "int series1Index = arcView.addSeries(seriesItem1);\n" +
                    "int series1Index2 = arcView.addSeries(seriesItem2);\n" +
                    "\n" +
                    "\n" +
                    "//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" +
                    "///////////////////////////////////////////////////////////\n" +
                    "\n" +
                    "\n" +
                    "// On boarder\n" +
                    "implementation 'com.cuneytayyildiz:onboarder:1.0.4'\n" +
                    "\n" +
                    "// JAVA\n" +
                    "\n" +
                    "public class MainActivity extends OnboarderActivity implements OnboarderPageChangeListener {\n" +
                    "\n" +
                    "    @Override\n" +
                    "    protected void onCreate(Bundle savedInstanceState) {\n" +
                    "        super.onCreate(savedInstanceState);\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "        List<OnboarderPage> pages = Arrays.asList(\n" +
                    "                new OnboarderPage.Builder()\n" +
                    "\n" +
                    "                        .imageResourceId(R.drawable.pict)\n" +
                    "                        .backgroundColorId(R.color.white)\n" +
                    "                        .title(\"This is a title\")\n" +
                    "                        .description(\"So this is a description\")\n" +
                    "                        .textPaddingBottomDp(60)\n" +
                    "                        .descriptionColor(R.color.inactive_indicator)\n" +
                    "                        .titleColor(R.color.inactive_indicator)\n" +
                    "                        .multilineDescriptionCentered(true)\n" +
                    "                        .build(), new OnboarderPage.Builder()\n" +
                    "\n" +
                    "                        .imageResourceId(R.drawable.pict)\n" +
                    "                        .backgroundColorId(R.color.white)\n" +
                    "                        .title(\"This is a title\")\n" +
                    "                        .description(\"So this is a description\")\n" +
                    "                        .textPaddingBottomDp(60)\n" +
                    "                        .descriptionColor(R.color.inactive_indicator)\n" +
                    "                        .titleColor(R.color.inactive_indicator)\n" +
                    "                        .multilineDescriptionCentered(true)\n" +
                    "                        .build(), new OnboarderPage.Builder()\n" +
                    "\n" +
                    "                        .imageResourceId(R.drawable.pict)\n" +
                    "                        .backgroundColorId(R.color.white)\n" +
                    "                        .title(\"This is a title\")\n" +
                    "                        .description(\"So this is a description\")\n" +
                    "                        .textPaddingBottomDp(60)\n" +
                    "                        .descriptionColor(R.color.inactive_indicator)\n" +
                    "                        .titleColor(R.color.inactive_indicator)\n" +
                    "                        .multilineDescriptionCentered(true)\n" +
                    "                        .build()\n" +
                    "\n" +
                    "\n" +
                    "        );\n" +
                    "        try {\n" +
                    "            setActiveIndicatorColor(R.color.point);\n" +
                    "            setSkipButtonTitle(\"Пропустить\");\n" +
                    "            setFinishButtonTitle(\"\");\n" +
                    "            setNextButtonTitle(\"СЛЕДУЮЩАЯ\");\n" +
                    "            setInactiveIndicatorColor(R.color.pointInactive);\n" +
                    "//            setDividerVisibility(Divide);\n" +
                    "            setDividerColor(getResources().getColor(R.color.white));\n" +
                    "            setNextButtonTextColor(R.color.inactive_indicator);\n" +
                    "            setFinishButtonTextColor(R.color.inactive_indicator);\n" +
                    "            setSkipButtonTextColor(R.color.inactive_indicator);\n" +
                    "\n" +
                    "            setOnboarderPageChangeListener(this);\n" +
                    "            initOnboardingPages(pages);\n" +
                    "\n" +
                    "        } catch (Exception e) {\n" +
                    "            e.toString();\n" +
                    "            e.toString();\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void onFinishButtonPressed() {\n" +
                    "        Toast.makeText(this, \"Finish button was pressed\", Toast.LENGTH_SHORT).show();\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void onPageChanged(int position) {\n" +
                    "        Toast.makeText(this, \"onPageChanged: \" + position, Toast.LENGTH_SHORT).show();\n" +
                    "\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\n" +
                    "\n" +
                    "// OTPVIEW\n" +
                    "\n" +
                    "        implementation 'com.github.aabhasr1:OtpView:v1.1.2'\n" +
                    "// XML\n" +
                    "\n" +
                    "<in.aabhasjindal.otptextview.OtpTextView\n" +
                    "    android:id=\"@+id/otp_view\"\n" +
                    "    android:layout_width=\"wrap_content\"\n" +
                    "    android:layout_height=\"wrap_content\"\n" +
                    "    android:textColor=\"#ffffff\"\n" +
                    "    app:height=\"40dp\"\n" +
                    "    app:width=\"40dp\"\n" +
                    "    app:bar_enabled=\"true\"\n" +
                    "    app:bar_height=\"2dp\"\n" +
                    "    app:length=\"4\"\n" +
                    "    app:otp=\"\"\n" +
                    "    app:otp_text_size=\"24dp\"\n" +
                    "    app:bar_inactive_color=\"#808080\"\n" +
                    "    app:bar_active_color=\"#808080\"\n" +
                    "    app:hide_otp=\"true\"\n" +
                    "    app:hide_otp_drawable=\"@drawable/a\"\n" +
                    "    android:layout_centerInParent=\"true\"/>\n" +
                    "\n" +
                    "\n" +
                    "/// JAVA\n" +
                    "// OPT\n" +
                    "\n" +
                    "otpTextView = findViewById(R.id.otp_view);\n" +
                    "otpTextView.setOtpListener(new OTPListener() {\n" +
                    "    @Override\n" +
                    "    public void onInteractionListener() {\n" +
                    "        // fired when user types something in the Otpbox\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void onOTPComplete(String otp) {\n" +
                    "        // fired when user has entered the OTP fully.\n" +
                    "        Toast.makeText(TestActivity.this, \"The OTP is \" + otp, Toast.LENGTH_SHORT).show();\n" +
                    "    }\n" +
                    "});\n" +
                    "\n" +
                    "////////////////////////////////////////////////////////////////////////////////////////////// Animation\n" +
                    "\n" +
                    "implementation 'com.github.florent37:expectanim:1.0.7'\n" +
                    "\n" +
                    "// Java\n" +
                    "\n" +
                    "// scale\n" +
                    "\n" +
                    "new ExpectAnim().expect(tvSample)\n" +
                    "        .toBe(Expectations.scale(0, 0))\n" +
                    "        .toAnimation()\n" +
                    "        .setDuration(0)\n" +
                    "        .start();\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "new ExpectAnim().expect(tvSample)\n" +
                    "        .toBe(Expectations.scale(1, 1))\n" +
                    "        .toAnimation()\n" +
                    "        .setDuration(500)\n" +
                    "        .start();\n" +
                    "\n" +
                    "\n" +
                    "// alpha\n" +
                    "\n" +
                    "new ExpectAnim().expect(tvSample)\n" +
                    "        .toBe(Expectations.alpha(0))\n" +
                    "        .toAnimation()\n" +
                    "        .setDuration(0)\n" +
                    "        .start();\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "new ExpectAnim().expect(tvSample)\n" +
                    "        .toBe(Expectations.alpha(1))\n" +
                    "        .toAnimation()\n" +
                    "        .setDuration(500)\n" +
                    "        .start();\n" +
                    "\n" +
                    "// transform\n" +
                    "\n" +
                    "new ExpectAnim().expect(tvSample)\n" +
                    "        .toBe(Expectations.outOfScreen(Gravity.RIGHT),Expectations.centerVerticalInParent())\n" +
                    "        .toAnimation()\n" +
                    "        .setDuration(0)\n" +
                    "        .start();\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "new ExpectAnim().expect(tvSample)\n" +
                    "        .toBe(Expectations.centerInParent(true,true))\n" +
                    "        .toAnimation()\n" +
                    "        .setDuration(500)\n" +
                    "        .start();\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "////////////////////////////////////////////////////////////////////////////////////////// MAIL\n" +
                    "internet perms, network\u2028uses clear text\n" +
                    "implementation 'com.github.nedimf:maildroid:v0.0.3'\n" +
                    "\n" +
                    "\n" +
                    "new MaildroidX.Builder()\n" +
                    "        .smtp(\"smtp.mail.com\")\n" +
                    "        .smtpUsername(\"test@mail.com\")\n" +
                    "        .smtpPassword(\"test\")\n" +
                    "        .smtpAuthentication(true)\n" +
                    "        .port(\"465\")\n" +
                    "        .type(MaildroidXType.HTML)\n" +
                    "        .to(\"test@mail.com\")\n" +
                    "        .from(\"test@mail.com\")\n" +
                    "        .subject(\"Test1\")\n" +
                    "        .body(\"Test2\")\n" +
                    "        .onCompleteCallback(new MaildroidX.onCompleteCallback() {\n" +
                    "            @Override\n" +
                    "            public void onSuccess() {\n" +
                    "                Toast.makeText(MainActivity.this, \"Success\", Toast.LENGTH_SHORT).show();\n" +
                    "            }\n" +
                    "\n" +
                    "            @Override\n" +
                    "            public void onFail(String s) {\n" +
                    "                Toast.makeText(MainActivity.this, \"Error: \" + s, Toast.LENGTH_SHORT).show();\n" +
                    "\n" +
                    "            }\n" +
                    "\n" +
                    "            @Override\n" +
                    "            public long getTimeout() {\n" +
                    "                return 15;\n" +
                    "            }\n" +
                    "        }).send();\n" +
                    "\n" +
                    "//////////////////////////////////////// Block orientation\u2028\n" +
                    "\n" +
                    "<activity android:name=\".MainActivity\"\n" +
                    "    android:screenOrientation=\"landscape\"\n" +
                    "    \n" +
                    "    \n" +
                    "    >\n" +
                    "\n" +
                    "\n" +
                    "//////////////////////////////// Side menu\n" +
                    "\n" +
                    "\n" +
                    "btn1 = findViewById(R.id.btn1);\n" +
                    "btn2 = findViewById(R.id.btn2);\n" +
                    "\n" +
                    "btn1.setOnClickListener(new View.OnClickListener() {\n" +
                    "    @Override\n" +
                    "    public void onClick(View view) {\n" +
                    "        firstFragment = new FirstFragment();\n" +
                    "        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();\n" +
                    "        ft.replace(R.id.theContainer,firstFragment);\n" +
                    "        ft.commit();\n" +
                    "    }\n" +
                    "});\n" +
                    "\n" +
                    "btn2.setOnClickListener(new View.OnClickListener() {\n" +
                    "    @Override\n" +
                    "    public void onClick(View view) {\n" +
                    "        secondFragment = new SecondFragment();\n" +
                    "        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();\n" +
                    "        ft.replace(R.id.theContainer,secondFragment);\n" +
                    "        ft.commit();\n" +
                    "    }\n" +
                    "});\n" +
                    "\n";
            return collections;
        } else {



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

//            DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
//            String date = df.format(Calendar.getInstance().getTime());
            return "Under construction";
        } else
            return null;
    }

    public static void main(String[] args) {

    }


    // New Beta methods


    public String myVal(String pass) {
        if (pass.equals(libPass)) {
            return "\n" +
                    "class MyValueConverter : IValueConverter\n" +
                    "    {\n" +
                    "        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)\n" +
                    "        {\n" +
                    "            if ((bool)value) return new SolidColorBrush(Color.FromRgb(25, 106, 166));\n" +
                    "            else\n" +
                    "                return new SolidColorBrush(Color.FromRgb(250, 200, 38));\n" +
                    "        }\n" +
                    "\n" +
                    "        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)\n" +
                    "        {\n" +
                    "            throw new NotImplementedException();\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "\n" +
                    "XML\n" +
                    " <local:MyValueConverter x:Key=\"colorConverter\"/>\n" +
                    "<Style TargetType=\"DataGridRow\">\n" +
                    "                <Setter Property=\"Background\" Value=\"{Binding isSuccess, Converter={StaticResource colorConverter}}\"/>\n" +
                    "                <Setter Property=\"FontSize\" Value=\"15\"/>\n" +
                    "                <!--<Setter Property=\"Background\" Value=\"#196AA6\"/>-->\n" +
                    "                <Setter Property=\"Foreground\" Value=\"#F79420\"/>\n" +
                    "                <Setter Property=\"FontFamily\" Value=\"./#TeXGyreAdventor-Regular.ttf\"/>\n" +
                    "            </Style>";
        }

        return "Error501";
    }


    public String graph(String pass) {
        if (pass.equals(libPass)) {
            return "XML\n" +
                    "<WindowsFormsHost><dvc:Chart x:Name=\"chart\" /></WindowsFormsHost>\n" +
                    "\n" +
                    "<Window xmlns=\"http://schemas.microsoft.com/winfx/2006/xaml/presentation\"\n" +
                    "...\n" +
                    "xmlns:dvc=\"clr-namespace:System.Windows.Forms.DataVisualization.Charting; assembly=System.Windows.Forms.DataVisualization\">\n" +
                    "<StackPanel>\n" +
                    "<WindowsFormsHost><dvc:Chart x:Name=\"chart\" /></WindowsFormsHost>\n" +
                    "</StackPanel>\n" +
                    "</Window>\n" +
                    "\n" +
                    "C#\n" +
                    "WindowsFormsHost><dvc:Chart x:Name=\"chart\" /></WindowsFormsHost>\n" +
                    "using System.Windows.Forms.DataVisualization.Charting\n" +
                    "chart.ChartAreas.Add(new ChartArea(\"Default\"));\n" +
                    "\n" +
                    "chart.Series.Add(new Series(\"Series1\"));\n" +
                    "chart.Series[\"Series1\"].ChartArea = \"Default\";\n" +
                    "chart.Series[\"Series1\"].ChartType = SeriesChartType.Line;\n" +
                    "\n" +
                    "string[] axisXData = new string[] {\"a\", \"b\", \"c\"};\n" +
                    "double[] axisYData = new double[] {0.1, 1.5, 1.9};\n" +
                    "chart.Series[\"Series1\"].Points.DataBindXY(axisXData, axisYData);";
        }
        return "Error";
    }

    public String meths(String pass) {
        if (pass.equals(libPass)) {
            return "private static int LevensteinDistance(string word1, int length1, string word2, int length2)\n" +
                    "        {\n" +
                    "            if (length1 == 0)\n" +
                    "            {\n" +
                    "                return length2;\n" +
                    "            }\n" +
                    "            if (length2 == 0)\n" +
                    "            {\n" +
                    "                return length1;\n" +
                    "            }\n" +
                    "            var subcost = 1;\n" +
                    "            if (word1[length1-1]==word2[length2-1])\n" +
                    "            {\n" +
                    "                subcost = 0;\n" +
                    "            }\n" +
                    "            var substitution = LevensteinDistance(word1, length1-1, word2, length2-1) +subcost;\n" +
                    "            var deletion = LevensteinDistance(word1, length1 - 1, word2, length2) + 1;\n" +
                    "            var insertion = LevensteinDistance(word1, length1, word2, length2 - 1) + 1;\n" +
                    "            return Math.Min(substitution, Math.Min(deletion, insertion));\n" +
                    "\n" +
                    "        }\n" +
                    "        public static int LevensteinDistance(string word1, string word2) => LevensteinDistance(word1, word1.Length, word2, word2.Length);\n" +
                    "\n" +
                    "        public string Md5Converter(string password)\n" +
                    "        {\n" +
                    "            byte[] bytes = Encoding.Unicode.GetBytes(password);\n" +
                    "            string hash = \"\";\n" +
                    "            MD5CryptoServiceProvider provider = new MD5CryptoServiceProvider();\n" +
                    "            bytes = provider.ComputeHash(bytes);\n" +
                    "            foreach (var item in bytes)\n" +
                    "            {\n" +
                    "                hash += string.Format(\"{0:x2}\", item);\n" +
                    "            }\n" +
                    "            return hash;\n" +
                    "        }\n" +
                    "        public static byte[] ImageConverter(BitmapImage bitmapImage)\n" +
                    "        {\n" +
                    "            if (bitmapImage == null) return null;\n" +
                    "            MemoryStream stream = new MemoryStream();\n" +
                    "            JpegBitmapEncoder encoder = new JpegBitmapEncoder();\n" +
                    "            encoder.Frames.Add(BitmapFrame.Create(bitmapImage));\n" +
                    "            encoder.Save(stream);\n" +
                    "            return stream.ToArray();\n" +
                    "        }\n" +
                    "        public static BitmapImage ImageConverter(byte[] buffer)\n" +
                    "        {\n" +
                    "            if (buffer == null) return null;\n" +
                    "            MemoryStream stream = new MemoryStream();\n" +
                    "            stream.Write(buffer, 0, buffer.Length);\n" +
                    "            stream.Position = 0;\n" +
                    "            BitmapImage image = new BitmapImage();\n" +
                    "            image.BeginInit();\n" +
                    "            image.StreamSource = stream;\n" +
                    "            image.EndInit();\n" +
                    "            return image;\n" +
                    "        }\n" +
                    "        public static void ShowWindow(object w, object sender)\n" +
                    "        {\n" +
                    "            //w - куда перейти; sender - откуда\n" +
                    "            ((Window)w).Left = ((Window)sender).Left;\n" +
                    "            ((Window)w).Top = ((Window)sender).Top;\n" +
                    "            ((Window)w).Show();\n" +
                    "            ((Window)sender).Close();\n" +
                    "        }";
        }
        return "0";
    }

    public String capture(String pass) {
        if (pass.equals(libPass)) {
            return "XML\n" +
                    "<StackPanel Grid.Row=\"1\">\n" +
                    "            <StackPanel Orientation=\"Horizontal\">\n" +
                    "                <StackPanel>\n" +
                    "                    <TextBlock x:Name=\"tbCaptcha1\" Width=\"50\" FontSize=\"25\" Text=\"1\" Style=\"{StaticResource tbDefault}\"/>\n" +
                    "                </StackPanel>\n" +
                    "                <StackPanel>\n" +
                    "                    <TextBlock x:Name=\"tbCaptcha2\" Width=\"50\" FontSize=\"25\" Text=\"2\" Style=\"{StaticResource tbDefault}\"/>\n" +
                    "                </StackPanel>\n" +
                    "                <StackPanel>\n" +
                    "                    <TextBlock x:Name=\"tbCaptcha3\" Width=\"50\" FontSize=\"25\" Text=\"3\" Style=\"{StaticResource tbDefault}\"/>\n" +
                    "                </StackPanel>\n" +
                    "                <StackPanel>\n" +
                    "                    <TextBlock x:Name=\"tbCaptcha4\" Width=\"50\" FontSize=\"25\" Text=\"4\" Style=\"{StaticResource tbDefault}\"/>\n" +
                    "                </StackPanel>\n" +
                    "            </StackPanel>\n" +
                    "            <TextBox Margin=\"5\" x:Name=\"tbxCapcha\" Width=\"300\"/>\n" +
                    "            <Button Margin=\"5\" Content=\"ReCapcha\" x:Name=\"btnCapcha\" Click=\"btnCapcha_Click\"/>\n" +
                    "        </StackPanel>\n" +
                    "\n" +
                    "C#\n" +
                    "\n" +
                    " Random r;\n" +
                    "        string letters= \"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890\";\n" +
                    "        string capch=\"\";\n" +
                    "\n" +
                    " public void Recapctha()\n" +
                    "        {\n" +
                    "            tbCaptcha1.Text = letters[r.Next(0,letters.Length-1)].ToString();\n" +
                    "            tbCaptcha1.RenderTransform = new RotateTransform (r.Next(-90, 90));\n" +
                    "            tbCaptcha2.Text = letters[r.Next(0, letters.Length - 1)].ToString();\n" +
                    "            tbCaptcha2.RenderTransform = new RotateTransform(r.Next(-90, 90));\n" +
                    "            tbCaptcha3.Text = letters[r.Next(0, letters.Length - 1)].ToString();\n" +
                    "            tbCaptcha3.RenderTransform = new RotateTransform(r.Next(-90, 90));\n" +
                    "            tbCaptcha4.Text = letters[r.Next(0, letters.Length - 1)].ToString();\n" +
                    "            tbCaptcha4.RenderTransform = new RotateTransform(r.Next(-90, 90));\n" +
                    "            tbxCapcha.Text = \"\";\n" +
                    "            capch = tbCaptcha1.Text + tbCaptcha2.Text + tbCaptcha3.Text + tbCaptcha4.Text;\n" +
                    "\n" +
                    "        }\n" +
                    "\n" +
                    "\n" +
                    "private void btnLogin_Click(object sender, RoutedEventArgs e)\n" +
                    "        {\n" +
                    "            if (tbxCapcha.Text!=capch)\n" +
                    "            {\n" +
                    "                MessageBox.Show(\"Неправильный ввод капчи!\");\n" +
                    "                Recapctha();\n" +
                    "                return;\n" +
                    "            }\n" +
                    "            if (db.Table.FirstOrDefault(a=>a.Email==tbxEmail.Text && a.Password==pasBox.Password)!=null)\n" +
                    "            {\n" +
                    "                if (cbxRememberMe.IsChecked==true)\n" +
                    "                {\n" +
                    "                    File.WriteAllText(\"Password\",tbxEmail.Text+\"\\n\"+pasBox.Password);\n" +
                    "                }\n" +
                    "                MessageBox.Show(\"Вы удачно авторизовались!\");\n" +
                    "                UserScreen w = new UserScreen();\n" +
                    "                w.Show();\n" +
                    "                this.Close();\n" +
                    "            }\n" +
                    "            else\n" +
                    "            {\n" +
                    "                MessageBox.Show(\"неверная связка логин/пароль!\");\n" +
                    "                Recapctha();\n" +
                    "            }\n" +
                    "        }";
        }
        return "0";
    }

    public String dataGrinder(String pass) {
        if (pass.equals(libPass)) {
            return "i<DataGrid x:Name=\"DG\" Grid.Row=\"2\">\n" +
                    "            <DataGrid.Columns>\n" +
                    "                <DataGridTemplateColumn>\n" +
                    "                    <DataGridTemplateColumn.CellTemplate>\n" +
                    "                        <DataTemplate>\n" +
                    "                            <Button x:Name=\"btnTest\" Click=\"btnTest_Click\" Visibility=\"Collapsed\"/>\n" +
                    "                        </DataTemplate>\n" +
                    "                    </DataGridTemplateColumn.CellTemplate>\n" +
                    "                </DataGridTemplateColumn>\n" +
                    "                <DataGridTextColumn Header=\"First name\" Binding=\"{Binding Path=firstName}\"/> \n" +
                    " </DataGrid.Columns>\n" +
                    "        </DataGrid>";
        }
        return "0";
    }


    public String add(String pass) {
        if (pass.equals(libPass)) {
            return "XML\n" +
                    "<Grid.RowDefinitions>\n" +
                    "            <RowDefinition/>\n" +
                    "            <RowDefinition Height=\"0.2*\"/>\n" +
                    "        </Grid.RowDefinitions>\n" +
                    "        <StackPanel HorizontalAlignment=\"Center\">\n" +
                    "            <StackPanel Orientation=\"Horizontal\">\n" +
                    "                <TextBlock Text=\"Email address\" Style=\"{StaticResource tbDefault}\" Margin=\"0 15\"/>\n" +
                    "                <TextBox x:Name=\"tbemail\" Width=\"350\"/>\n" +
                    "            </StackPanel>\n" +
                    "<StackPanel Orientation=\"Horizontal\">\n" +
                    "                <TextBlock Text=\"Office\" Style=\"{StaticResource tbDefault}\" Margin=\"0 15\"/>\n" +
                    "                <ComboBox x:Name=\"cbxOffices\" Width=\"350\" VerticalAlignment=\"Center\"/>\n" +
                    "            </StackPanel>\n" +
                    "            <StackPanel Orientation=\"Horizontal\">\n" +
                    "                <TextBlock Text=\"Birthdate\" Style=\"{StaticResource tbDefault}\" Margin=\"0 15\"/>\n" +
                    "                <DatePicker x:Name=\"dpBirthdate\" Width=\"350\"/>\n" +
                    "            </StackPanel>\n" +
                    "</StackPanel>\n" +
                    "<StackPanel Grid.Row=\"1\" Orientation=\"Horizontal\" VerticalAlignment=\"Center\" HorizontalAlignment=\"Center\">\n" +
                    "            <Button Content=\"Save\" x:Name=\"btnSave\" Click=\"btnSave_Click\"/>\n" +
                    "            <Button Content=\"Cancel\" Background=\"#f79420\" x:Name=\"btnCancel\" Click=\"btnCancel_Click\"/>\n" +
                    "        </StackPanel>\n" +
                    "\n" +
                    "C#\n" +
                    "InitializeComponent();\n" +
                    "            try\n" +
                    "            {\n" +
                    "                db = new ModelDB();\n" +
                    "                cbxOffices.ItemsSource = db.Offices.ToList().Select(a => a.Title).ToList();\n" +
                    "            }\n" +
                    "            catch (Exception ex)\n" +
                    "            {\n" +
                    "                UnexpectedExit w = new UnexpectedExit();\n" +
                    "                w.ShowDialog();\n" +
                    "                if (string.IsNullOrWhiteSpace(w.tbDesc.Text))\n" +
                    "                {\n" +
                    "                    Properties.Settings.Default.udesc = w.tbDesc.Text;\n" +
                    "                }\n" +
                    "                //  MessageBox.Show(\"Good bye!\");\n" +
                    "                Properties.Settings.Default.exception = ex.ToString();\n" +
                    "                this.Close();\n" +
                    "\n" +
                    "\n" +
                    "            }\n" +
                    "\n" +
                    "        }\n" +
                    "\n" +
                    "        private void btnSave_Click(object sender, RoutedEventArgs e)\n" +
                    "        {\n" +
                    "            try\n" +
                    "            {\n" +
                    "                DateTime date;\n" +
                    "                if (string.IsNullOrWhiteSpace(tbemail.Text) || string.IsNullOrWhiteSpace(dpBirthdate.Text) || !DateTime.TryParse(dpBirthdate.Text, out date) || string.IsNullOrWhiteSpace(tbPassword.Text) || string.IsNullOrWhiteSpace(tbLastName.Text) || string.IsNullOrWhiteSpace(tbFirstName.Text))\n" +
                    "                {\n" +
                    "                    MessageBox.Show(\"Нужно заполнить все поля!\");\n" +
                    "                }\n" +
                    "                else\n" +
                    "                {\n" +
                    "                    User u = new User();\n" +
                    "                    u.ID = db.Users.ToList().Count()+1;\n" +
                    "                    u.Active = true;\n" +
                    "                    u.Birthdate = dpBirthdate.DisplayDate;\n" +
                    "                    u.Email = tbemail.Text;\n" +
                    "                    u.Password = MD5Converter.Do(tbPassword.Text);\n" +
                    "                    u.OfficeID = db.Offices.ToList().FirstOrDefault(a=>a.Title==cbxOffices.Text).ID;\n" +
                    "                    u.FirstName = tbFirstName.Text;\n" +
                    "                    u.LastName = tbLastName.Text;\n" +
                    "                    u.RoleID = 2;\n" +
                    "                    db.Users.Add(u);\n" +
                    "                    db.SaveChanges();\n" +
                    "                    DialogResult = true;\n" +
                    "                }\n" +
                    "            }\n" +
                    "            catch (Exception ex)\n" +
                    "            {\n" +
                    "                UnexpectedExit w = new UnexpectedExit();\n" +
                    "                w.ShowDialog();\n" +
                    "                if (!string.IsNullOrEmpty(w.tbDesc.Text))\n" +
                    "                {\n" +
                    "                    Properties.Settings.Default.udesc = w.tbDesc.Text;\n" +
                    "                }\n" +
                    "                //  MessageBox.Show(\"Good bye!\");\n" +
                    "                Properties.Settings.Default.exception = ex.ToString();\n" +
                    "                DialogResult = false;\n" +
                    "                this.Close();\n" +
                    "\n" +
                    "\n" +
                    "            }\n" +
                    "\n" +
                    "        }\n" +
                    "\n" +
                    "        private void btnCancel_Click(object sender, RoutedEventArgs e)\n" +
                    "        {\n" +
                    "            DialogResult = false;\n" +
                    "            return;\n" +
                    "        }";
        }
        return "0";
    }

    public String jsonParsing(String pass){
        if (pass.equals(libPass)){
            return " public class JSONTask extends AsyncTask<String, String, String>\n" +
                    "    {\n" +
                    "        @Override\n" +
                    "        protected void onPostExecute(String s) {\n" +
                    "            super.onPostExecute(s);\n" +
                    "            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();\n" +
                    "        }\n" +
                    "\n" +
                    "        @Override\n" +
                    "        protected String doInBackground(String... strings) {\n" +
                    "\n" +
                    "\n" +
                    "            try {\n" +
                    "                URL url= new URL(\"https://api.myjson.com/bins/b4pdd\");\n" +
                    "                HttpURLConnection connection = (HttpURLConnection)url.openConnection();\n" +
                    "                InputStream is = connection.getInputStream();\n" +
                    "                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));\n" +
                    "                StringBuffer stringBuffer = new StringBuffer();\n" +
                    "                StringBuffer lastBuffer = new StringBuffer();\n" +
                    "                String line = \"\";\n" +
                    "                while ((line=bufferedReader.readLine())!=null)\n" +
                    "                {\n" +
                    "                    stringBuffer.append(line);\n" +
                    "                }\n" +
                    "                String text = stringBuffer.toString();\n" +
                    "                JSONObject jsonObject = new JSONObject(text);\n" +
                    "                JSONArray jsonArray = jsonObject.getJSONArray(\"studentinfo\");\n" +
                    "                Cursor cursor = db.rawQuery(\"SELECT * FROM users\", null);\n" +
                    "                if (cursor.getCount() == 0)\n" +
                    "                {\n" +
                    "                    for (int i = 0; i < jsonArray.length(); i++) {\n" +
                    "                        ContentValues cv = new ContentValues();\n" +
                    "                        JSONObject obj = jsonArray.getJSONObject(i);\n" +
                    "                        cv.put(\"name\", obj.getString(\"name\"));\n" +
                    "                        cv.put(\"age\", obj.getString(\"age\"));\n" +
                    "                        cv.put(\"description\", obj.getString(\"description\"));\n" +
                    "                        db.insert(\"users\", null, cv);\n" +
                    "                        lastBuffer.append(obj.getString(\"name\") + \" \" + obj.getString(\"age\")+ \" \" +obj.getString(\"description\") +\"\\n\");\n" +
                    "                    }\n" +
                    "                }\n" +
                    "                else\n" +
                    "                {\n" +
                    "                    boolean flag = false;\n" +
                    "                    for (int i = 0; i < jsonArray.length(); i++) {\n" +
                    "                        cursor.moveToFirst();\n" +
                    "                        flag = false;\n" +
                    "                        ContentValues cv = new ContentValues();\n" +
                    "                        JSONObject obj = jsonArray.getJSONObject(i);\n" +
                    "                        do {\n" +
                    "                            if (obj.getString(\"name\") == cursor.getString(0)) {\n" +
                    "                            flag = true;\n" +
                    "                            }\n" +
                    "                        }while (cursor.moveToNext());\n" +
                    "                        if (flag == false) {\n" +
                    "                            cv.put(\"name\", obj.getString(\"name\"));\n" +
                    "                            cv.put(\"age\", obj.getString(\"age\"));\n" +
                    "                            cv.put(\"description\", obj.getString(\"description\"));\n" +
                    "                            db.insert(\"users\", null, cv);\n" +
                    "\n" +
                    "                        }\n" +
                    "                        lastBuffer.append(obj.getString(\"name\") + \" \" + obj.getString(\"age\")+ \" \" +obj.getString(\"description\") +\"\\n\");\n" +
                    "                    }\n" +
                    "                }\n" +
                    "\n" +
                    "                return lastBuffer.toString();\n" +
                    "\n" +
                    "            } catch (MalformedURLException e) {\n" +
                    "                e.printStackTrace();\n" +
                    "            } catch (IOException e) {\n" +
                    "                e.printStackTrace();\n" +
                    "            } catch (JSONException e) {\n" +
                    "                e.printStackTrace();\n" +
                    "            }\n" +
                    "\n" +
                    "\n" +
                    "            return null;\n" +
                    "        }\n" +
                    "    }";
        }
        return "Error";
    }


    public String marginCounter(String key){
        if (toMD5(key).equals(hashKey)){



            return  "\n" +
                    "Type emulator’s name\n" +
                    "\n" +
                    "implementation 'com.google.android.material:material:1.1.0'\n" +
                    "\n" +
                    "implementation 'com.google.code.gson:gson:2.6.2'\n" +
                    "implementation 'com.squareup.retrofit2:retrofit:2.0.2'\n" +
                    "implementation 'com.squareup.retrofit2:converter-gson:2.0.2'\n" +
                    "\n" +
                    "implementation 'com.jakewharton:butterknife:10.2.1'\n" +
                    "annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.1'\n" +
                    "\n" +
                    "implementation 'de.hdodenhof:circleimageview:3.1.0'\n" +
                    "\n" +
                    "implementation 'com.squareup.picasso:picasso:2.71828'\n" +
                    "implementation 'com.android.volley:volley:1.1.1'\n" +
                    "implementation 'com.baoyz.swipemenulistview:library:1.3.0'\n" +
                    "\n" +
                    "implementation 'com.squareup.retrofit2:converter-simplexml:2.7.1'\n" +
                    "\n" +
                    "implementation 'com.squareup.okhttp3:logging-interceptor:4.7.0'\n" +
                    "\n" +
                    "\n" +
                    "//// EDIT MANIFEST\n" +
                    "////\n" +
                    "////\n" +
                    "////\n" +
                    "////////// BUILD.GRADLE\n" +
                    "allprojects {\n" +
                    "    repositories {\n" +
                    "        google()\n" +
                    "        jcenter()\n" +
                    "        maven { url 'https://jitpack.io' }\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "/// shared transition\n" +
                    "\n" +
                    "In styles:\u2028<item name=\"android:windowActivityTransitions\">true</item>\n" +
                    "\n" +
                    "In xml:\n" +
                    "transitionname=“”\n" +
                    "\n" +
                    "in activity А:\n" +
                    "\u2028Intent intent = new Intent(getApplicationContext(), AuthorInfo.class);\n" +
                    "\n" +
                    "Pair[] pairs = new Pair[2];\n" +
                    "pairs[0] = new Pair<View, String>(circleImageView, \"image\");\n" +
                    "pairs[1] = new Pair<View, String>(tvName, \"name\");\n" +
                    "\n" +
                    "ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,\n" +
                    "        pairs);\n" +
                    "startActivity(intent,options.toBundle());\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "// Image from url\n" +
                    "Picasso. get(). load(\"http://i.imgur.com/DvpvklR.png\").into(circleImageView);\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "// Read from HTML\n" +
                    "Html.fromHtml(string, Html.FROM_HTML_MODE_COMPACT)\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "// Create table\n" +
                    "sqLiteDatabase.execSQL(\"CREATE TABLE IF NOT EXISTS `news` (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, title TEXT, excerpt TEXT, date TEXT)\");\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "// Add to table\n" +
                    "sqLiteDatabase = getApplicationContext().openOrCreateDatabase(\"app.db\", MODE_PRIVATE, null);\n" +
                    "\n" +
                    "for (int i = 0; i <data.size() ; i++) {\n" +
                    "\n" +
                    "    ContentValues cv = new ContentValues();\n" +
                    "    cv.put(\"title\",data.get(i).getTitle().getRendered());\n" +
                    "    cv.put(\"excerpt\",data.get(i).getExcerpt().getRendered());\n" +
                    "    cv.put(\"date\",data.get(i).getDate());\n" +
                    "    sqLiteDatabase.insert(\"news\",null,cv);\n" +
                    "}\n" +
                    "sqLiteDatabase.close();\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "// Read from base\n" +
                    "  sqLiteDatabase = getApplicationContext().openOrCreateDatabase(\"app.db\", MODE_PRIVATE, null);\n" +
                    "        sqLiteDatabase.execSQL(\"CREATE TABLE IF NOT EXISTS `news` (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, title TEXT, excerpt TEXT, date TEXT)\");\n" +
                    "\n" +
                    "\n" +
                    "//        Check for data in Base\n" +
                    "        Cursor q = sqLiteDatabase.rawQuery(\"SELECT * FROM `news`\", null);\n" +
                    "        if (q.moveToFirst()) {\n" +
                    "\n" +
                    "            Toast.makeText(this, \"С базы\", Toast.LENGTH_SHORT).show();\n" +
                    "            do {\n" +
                    "                String sTitle = q.getString(1);\n" +
                    "                String sExcerpt = q.getString(2);\n" +
                    "                String date = q.getString(3);\n" +
                    "\n" +
                    "                Title title = new Title(sTitle);\n" +
                    "                Excerpt excerpt = new Excerpt(sExcerpt);\n" +
                    "\n" +
                    "                news.add(new News(date, title, excerpt));\n" +
                    "\n" +
                    "            } while (q.moveToNext());\n" +
                    "\n" +
                    "            newsAdapter = new NewsAdapter(news, getApplicationContext());\n" +
                    "            rv.setAdapter(newsAdapter);\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "        }else {\n" +
                    "            Toast.makeText(this, \"С сервера\", Toast.LENGTH_SHORT).show();\n" +
                    "            refreshRL();\n" +
                    "        }\n" +
                    "\n" +
                    "        q.close();\n" +
                    "        sqLiteDatabase.close();\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "/// ApiInterface\n" +
                    "\n" +
                    "\n" +
                    "￼\n" +
                    "\n" +
                    "//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// RETROFIT\n" +
                    "//////////////// ApiInterface\n" +
                    "public interface ApiInterface {\n" +
                    "\n" +
                    "    @GET(\"api/students\")\n" +
                    "    Call<List<String>> getStudents();\n" +
                    "    @GET(\"api/post\")\n" +
                    "    Call<List<String>> getStudentsByFL(@Query(\"sym\") String letter, @Query(\"facultyId\") Integer facultyId);\n" +
                    "    @POST(\"api/students\")\n" +
                    "    Call<Student> createStudent(@Body Student student);\n" +
                    "    @GET(\"api/post/savestudent\")\n" +
                    "    Call<Student> createStudentAsGet(@Query(\"Name\") String name, @Query(\"Email\") String email, @Query(\"FacultyId\") Integer facultyId);\n" +
                    "    @PUT(\"api/students/{id}\")\n" +
                    "    Call<Student> changeStudent(@Path(\"id\") Integer id, @Body Student student);\n" +
                    "    @DELETE(\"api/students/{id}\")\n" +
                    "    Call<Void> deleteStudent(@Path(\"id\") int id);\n" +
                    "\n" +
                    "    @GET(\"api/test\")\n" +
                    "    Call<List<Faculty>> getFaculties();\n" +
                    "}\n" +
                    "\n" +
                    "//////////////// ApiClient\n" +
                    "\n" +
                    "public class ApiClient {\n" +
                    "\n" +
                    "    public static final String BASE_URL = \"http://vongu3-001-site1.ctempurl.com/\";\n" +
                    "    private static Retrofit retrofit = null;\n" +
                    "\n" +
                    "    public static Retrofit getClient()\n" +
                    "    {\n" +
                    "        if(retrofit == null)\n" +
                    "        {\n" +
                    "            retrofit = new Retrofit.Builder()\n" +
                    "                    .baseUrl(BASE_URL)\n" +
                    "                    .addConverterFactory(GsonConverterFactory.create())\n" +
                    "                    .build();\n" +
                    "        }\n" +
                    "\n" +
                    "        return retrofit;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "//////////////// MainActivity\n" +
                    "//////////////// \n" +
                    "\n" +
                    "public class MainActivity extends AppCompatActivity {\n" +
                    "\n" +
                    "    ApiInterface apiService;\n" +
                    "\n" +
                    "    @BindView(R.id.rv)\n" +
                    "    RecyclerView rv;\n" +
                    "    @BindView(R.id.etName)\n" +
                    "    EditText etName;\n" +
                    "    @BindView(R.id.etEmail)\n" +
                    "    EditText etEmail;\n" +
                    "    @BindView(R.id.etFacultyId)\n" +
                    "    EditText etFacultyId;\n" +
                    "    StudentAdapter adapter;\n" +
                    "\n" +
                    "    @Override\n" +
                    "    protected void onCreate(Bundle savedInstanceState) {\n" +
                    "        super.onCreate(savedInstanceState);\n" +
                    "        setContentView(R.layout.activity_main);\n" +
                    "        ButterKnife.bind(this);\n" +
                    "\n" +
                    "        apiService = ApiClient.getClient().create(ApiInterface.class);\n" +
                    "\n" +
                    "        Call<List<Faculty>> call = apiService.getFaculties();\n" +
                    "        call.enqueue(new Callback<List<Faculty>>() {\n" +
                    "            @Override\n" +
                    "            public void onResponse(Call<List<Faculty>> call, Response<List<Faculty>> response) {\n" +
                    "                List<Faculty> data = response.body();\n" +
                    "            }\n" +
                    "\n" +
                    "            @Override\n" +
                    "            public void onFailure(Call<List<Faculty>> call, Throwable t) {\n" +
                    "\n" +
                    "            }\n" +
                    "        });\n" +
                    "\n" +
                    "        RefreshRV();\n" +
                    "    }\n" +
                    "\n" +
                    "    public void RefreshRV() {\n" +
                    "        Call<List<String>> call = apiService.getStudents();\n" +
                    "        call.enqueue(new Callback<List<String>>() {\n" +
                    "            @Override\n" +
                    "            public void onResponse(Call<List<String>> call, Response<List<String>> response) {\n" +
                    "                List<String> data = response.body();\n" +
                    "                adapter = new StudentAdapter(data, getApplicationContext());\n" +
                    "                rv.setAdapter(adapter);\n" +
                    "            }\n" +
                    "\n" +
                    "            @Override\n" +
                    "            public void onFailure(Call<List<String>> call, Throwable t) {\n" +
                    "\n" +
                    "            }\n" +
                    "        });\n" +
                    "    }\n" +
                    "\n" +
                    "    public void btnAdd_onClick(View view) {\n" +
                    "\n" +
                    "        String Name =etName.getText().toString();\n" +
                    "        String Email =etEmail.getText().toString();\n" +
                    "        Integer facultyId = Integer.parseInt(etFacultyId.getText().toString());\n" +
                    "\n" +
                    "        Call<Student> call = apiService.createStudentAsGet(Name, Email, facultyId);\n" +
                    "        call.enqueue(new Callback<Student>() {\n" +
                    "            @Override\n" +
                    "            public void onResponse(Call<Student> call, Response<Student> response) {\n" +
                    "                RefreshRV();\n" +
                    "                Toast.makeText(MainActivity.this, \"Пользователь добавлен! code:\" + String.valueOf(response.code()), Toast.LENGTH_SHORT).show();\n" +
                    "            }\n" +
                    "\n" +
                    "            @Override\n" +
                    "            public void onFailure(Call<Student> call, Throwable t) {\n" +
                    "                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();\n" +
                    "            }\n" +
                    "        });\n" +
                    "\n" +
                    "\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  RECYCLERVIEW + CLICK\n" +
                    "/////////////// XML\n" +
                    "\n" +
                    "<androidx.recyclerview.widget.RecyclerView\n" +
                    "    android:id=\"@+id/rv\"\n" +
                    "    android:layout_width=\"0dp\"\n" +
                    "    android:layout_height=\"0dp\"\n" +
                    "    app:layoutManager=\"androidx.recyclerview.widget.LinearLayoutManager\"\n" +
                    "    app:layout_constraintBottom_toBottomOf=\"parent\"\n" +
                    "    app:layout_constraintEnd_toEndOf=\"parent\"\n" +
                    "    app:layout_constraintStart_toStartOf=\"parent\"\n" +
                    "    app:layout_constraintTop_toTopOf=\"parent\"\n" +
                    "    tools:listitem=\"@layout/item_news\" />\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "/////////////// Adapter\n" +
                    "public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {\n" +
                    "\n" +
                    "//    private final View.OnClickListener mOnCliclKistener;\n" +
                    "\n" +
                    "    List<News> news;\n" +
                    "    Context context;\n" +
                    "\n" +
                    "//    OnClick\n" +
                    "    private OnItemClickListener mListener;\n" +
                    "    public interface OnItemClickListener{\n" +
                    "        void onItemClick(int position);\n" +
                    "    }\n" +
                    "    public void setOnItemClickListener(OnItemClickListener listener){\n" +
                    "        mListener = listener;\n" +
                    "    }\n" +
                    "\n" +
                    "\n" +
                    "    public NewsAdapter(List<News> news, Context context) {\n" +
                    "        this.news = news;\n" +
                    "        this.context = context;\n" +
                    "    }\n" +
                    "\n" +
                    "    @NonNull\n" +
                    "    @Override\n" +
                    "    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {\n" +
                    "        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);\n" +
                    "        return new NewsViewHolder(view);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {\n" +
                    "        holder.tvTitle.setText(news.get(position).getTitle().getRendered());\n" +
                    "        holder.tvText.setText(Html.fromHtml(news.get(position).getExcerpt().getRendered(), Html.FROM_HTML_MODE_COMPACT));\n" +
                    "        holder.tvDate.setText(news.get(position).getDate());\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public int getItemCount() {\n" +
                    "        return news.size();\n" +
                    "    }\n" +
                    "\n" +
                    "    public class NewsViewHolder extends RecyclerView.ViewHolder {\n" +
                    "\n" +
                    "        TextView tvTitle;\n" +
                    "        TextView tvText;\n" +
                    "        TextView tvDate;\n" +
                    "\n" +
                    "        public NewsViewHolder(@NonNull View itemView) {\n" +
                    "            super(itemView);\n" +
                    "            tvTitle = itemView.findViewById(R.id.tvTitle);\n" +
                    "            tvText = itemView.findViewById(R.id.tvText);\n" +
                    "            tvDate = itemView.findViewById(R.id.tvDate);\n" +
                    "\n" +
                    "            itemView.setOnClickListener(new View.OnClickListener() {\n" +
                    "                @Override\n" +
                    "                public void onClick(View view) {\n" +
                    "                    if (mListener!=null){\n" +
                    "                        int position = getAdapterPosition();\n" +
                    "                        if (position!= RecyclerView.NO_POSITION){\n" +
                    "                            mListener.onItemClick(position);\n" +
                    "                        }\n" +
                    "                    }\n" +
                    "                }\n" +
                    "            });\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "}\n" +
                    "\n" +
                    "/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Json VOLLEY\n" +
                    " private void sendRequest() {\n" +
                    "        String url = \"http://PUTURL_PUTURL\";\n" +
                    "        JSONObject jsonObject = new JSONObject();\n" +
                    "        try {\n" +
                    "            jsonObject.put(\"categories\", \"12\");\n" +
                    "//            jsonObject.put(\"per_page\", \"100\");\n" +
                    "            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, jsonObject\n" +
                    "                    , new Response.Listener<JSONObject>() {\n" +
                    "                @Override\n" +
                    "                public void onResponse(JSONObject response) {\n" +
                    "                    Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();\n" +
                    "\n" +
                    "                }\n" +
                    "            }, new Response.ErrorListener() {\n" +
                    "                @Override\n" +
                    "                public void onErrorResponse(VolleyError error) {\n" +
                    "                    Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();\n" +
                    "                }\n" +
                    "            }){\n" +
                    "                @Override\n" +
                    "                protected Map<String, String> getParams() throws AuthFailureError {\n" +
                    "                    Map<String, String> params = new HashMap<>();\n" +
                    "                    return params;\n" +
                    "                }\n" +
                    "            };\n" +
                    "\n" +
                    "            RequestQueue requestQueue = Volley.newRequestQueue(this);\n" +
                    "            requestQueue.add(jsonObjectRequest);\n" +
                    "            requestQueue.start();\n" +
                    "        } catch (Exception e) {\n" +
                    "            e.printStackTrace();\n" +
                    "        }\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "////////////////////////////////////////////////////// Swipe\n" +
                    "\n" +
                    "\n" +
                    "////// XML:\n" +
                    "<com.baoyz.swipemenulistview.SwipeMenuListView\n" +
                    "        android:id=\"@+id/listView\"\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:layout_height=\"match_parent\" />\n" +
                    "\n" +
                    "\n" +
                    "//////// CODE:\u2028\u2028SwipeMenuCreator creator = new SwipeMenuCreator() {\n" +
                    "\n" +
                    "\t@Override\n" +
                    "\tpublic void create(SwipeMenu menu) {\n" +
                    "\t\t// create \"open\" item\n" +
                    "\t\tSwipeMenuItem openItem = new SwipeMenuItem(\n" +
                    "\t\t\t\tgetApplicationContext());\n" +
                    "\t\t// set item background\n" +
                    "\t\topenItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,\n" +
                    "\t\t\t\t0xCE)));\n" +
                    "\t\t// set item width\n" +
                    "\t\topenItem.setWidth(dp2px(90));\n" +
                    "\t\t// set item title\n" +
                    "\t\topenItem.setTitle(\"Open\");\n" +
                    "\t\t// set item title fontsize\n" +
                    "\t\topenItem.setTitleSize(18);\n" +
                    "\t\t// set item title font color\n" +
                    "\t\topenItem.setTitleColor(Color.WHITE);\n" +
                    "\t\t// add to menu\n" +
                    "\t\tmenu.addMenuItem(openItem);\n" +
                    "\n" +
                    "\t\t// create \"delete\" item\n" +
                    "\t\tSwipeMenuItem deleteItem = new SwipeMenuItem(\n" +
                    "\t\t\t\tgetApplicationContext());\n" +
                    "\t\t// set item background\n" +
                    "\t\tdeleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,\n" +
                    "\t\t\t\t0x3F, 0x25)));\n" +
                    "\t\t// set item width\n" +
                    "\t\tdeleteItem.setWidth(dp2px(90));\n" +
                    "\t\t// set a icon\n" +
                    "\t\tdeleteItem.setIcon(R.drawable.ic_delete);\n" +
                    "\t\t// add to menu\n" +
                    "\t\tmenu.addMenuItem(deleteItem);\n" +
                    "\t}\n" +
                    "};\n" +
                    "\n" +
                    "// set creator\n" +
                    "listView.setMenuCreator(creator);\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Swipe Refresh\u2028\u2028PUT ABOVE YOUR CONSTRUCTION SWIPEREFRESHLAYOUT\n" +
                    "\n" +
                    "CODE:\n" +
                    "\n" +
                    "swipeRefreshLayout = findViewById(R.id.refresh);\n" +
                    "swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {\n" +
                    "    @Override\n" +
                    "    public void onRefresh() {\n" +
                    "        Toast.makeText(MainActivity.this, \"Refreshed\", Toast.LENGTH_SHORT).show();\n" +
                    "        swipeRefreshLayout.setRefreshing(false);\n" +
                    "    }\n" +
                    "});\n" +
                    "\n" +
                    "\n" +
                    "//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// REMOVE STATUS BAR\n" +
                    "        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,\n" +
                    "        WindowManager.LayoutParams.FLAG_FULLSCREEN);\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// XML PARSING RETROFIT\n" +
                    "\n" +
                    "//////////////////////////////////////////////////////// API CLIENT\n" +
                    "public class ApiClient {\n" +
                    "\n" +
                    "    public static final String BASE_URL = \"http://www.cbr.ru/scripts/\";\n" +
                    "    private static Retrofit retrofit = null;\n" +
                    "\n" +
                    "    public static Retrofit getClient()\n" +
                    "    {\n" +
                    "        if(retrofit == null)\n" +
                    "        {\n" +
                    "            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();\n" +
                    "            logging.setLevel(HttpLoggingInterceptor.Level.BODY);\n" +
                    "            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();\n" +
                    "            httpClient.addInterceptor(logging);\n" +
                    "            retrofit = new Retrofit.Builder()\n" +
                    "                    .baseUrl(BASE_URL)\n" +
                    "                    .client(httpClient.build())\n" +
                    "                    .addConverterFactory(SimpleXmlConverterFactory.create())\n" +
                    "                    .build();\n" +
                    "        }\n" +
                    "\n" +
                    "        return retrofit;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "//////////////////////////////////////////////////////// API INTERFACE\n" +
                    "public interface ApiInterface {\n" +
                    "    @GET(\"XML_daily.asp\")\n" +
                    "    Call<ListCur> getCur();\n" +
                    "}\n" +
                    "\n" +
                    "//////////////////////////////////////////////////////// ListCur\u2028\n" +
                    "@Root(name = \"ValCurs\")\n" +
                    "public class ListCur {\n" +
                    "    @ElementList(inline = true)\n" +
                    "    List<Cur> curList;\n" +
                    "\n" +
                    "    @Attribute(required = false)\n" +
                    "    private String Date;\n" +
                    "\n" +
                    "    @Attribute(required = false)\n" +
                    "    private String name;\n" +
                    "\n" +
                    "    public List<Cur> getCurList() {\n" +
                    "        return curList;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void setCurList(List<Cur> curList) {\n" +
                    "        this.curList = curList;\n" +
                    "    }\n" +
                    "\n" +
                    "    public String getDate() {\n" +
                    "        return Date;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void setDate(String date) {\n" +
                    "        Date = date;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "//////////////////////////////////////////////////////// Cur\n" +
                    "\n" +
                    "@Root(name = \"Valute\")\n" +
                    "public class Cur {\n" +
                    "    @Element(name = \"NumCode\")\n" +
                    "    private Integer code;\n" +
                    "    @Element(name = \"CharCode\")\n" +
                    "    private String charcode;\n" +
                    "    @Element(name = \"Nominal\")\n" +
                    "    private Integer nominal;\n" +
                    "    @Element(name = \"Name\")\n" +
                    "    private String name;\n" +
                    "    @Element(name = \"Value\")\n" +
                    "    private String value;\n" +
                    "\n" +
                    "    @Attribute(required = false)\n" +
                    "    private String ID;\n" +
                    "\n" +
                    "\n" +
                    "    public Integer getCode() {\n" +
                    "        return code;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void setCode(Integer code) {\n" +
                    "        this.code = code;\n" +
                    "    }\n" +
                    "\n" +
                    "    public String getCharcode() {\n" +
                    "        return charcode;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void setCharcode(String charcode) {\n" +
                    "        this.charcode = charcode;\n" +
                    "    }\n" +
                    "\n" +
                    "    public Integer getNominal() {\n" +
                    "        return nominal;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void setNominal(Integer nominal) {\n" +
                    "        this.nominal = nominal;\n" +
                    "    }\n" +
                    "\n" +
                    "    public String getName() {\n" +
                    "        return name;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void setName(String name) {\n" +
                    "        this.name = name;\n" +
                    "    }\n" +
                    "\n" +
                    "    public String getValue() {\n" +
                    "        return value;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void setValue(String value) {\n" +
                    "        this.value = value;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "//////////////////////////////////////////////////////// MainActivity\n" +
                    "\n" +
                    "\n" +
                    "public class MainActivity extends AppCompatActivity {\n" +
                    "\n" +
                    "    @Override\n" +
                    "    protected void onCreate(Bundle savedInstanceState) {\n" +
                    "        super.onCreate(savedInstanceState);\n" +
                    "        setContentView(R.layout.activity_main);\n" +
                    "\n" +
                    "        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);\n" +
                    "        Call<ListCur> call = apiService.getCur();\n" +
                    "        call.enqueue(new Callback<ListCur>() {\n" +
                    "            @Override\n" +
                    "            public void onResponse(Call<ListCur> call, Response<ListCur> response) {\n" +
                    "                int i;\n" +
                    "                ListCur data = response.body();\n" +
                    "            }\n" +
                    "\n" +
                    "            @Override\n" +
                    "            public void onFailure(Call<ListCur> call, Throwable t) {\n" +
                    "                Log.d(\"Error!!!!\", t.getMessage());\n" +
                    "            }\n" +
                    "        });\n" +
                    "\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "////////////////////////////////////////////////// GRADLE\n" +
                    "\n" +
                    "android {\n" +
                    "    ….\n" +
                    "\n" +
                    "    compileOptions {\n" +
                    "        sourceCompatibility JavaVersion.VERSION_1_8\n" +
                    "        targetCompatibility JavaVersion.VERSION_1_8\n" +
                    "    }\n" +
                    "\n" +
                    "    defaultConfig {\n" +
                    "      ….\n" +
                    "    }\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "dependencies {\n" +
                    "    implementation fileTree(dir: 'libs', include: ['*.jar'])\n" +
                    "\n" +
                    "    implementation 'androidx.appcompat:appcompat:1.1.0'\n" +
                    "    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'\n" +
                    "    testImplementation 'junit:junit:4.12'\n" +
                    "    androidTestImplementation 'androidx.test.ext:junit:1.1.1'\n" +
                    "    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'\n" +
                    "\n" +
                    "    implementation 'com.squareup.retrofit2:retrofit:2.0.2'\n" +
                    "    implementation 'com.squareup.retrofit2:converter-simplexml:2.7.1'\n" +
                    "\n" +
                    "    implementation 'com.squareup.okhttp3:logging-interceptor:4.7.0'\n" +
                    "}\n" +
                    "\n";
        }
        else return "0dp";
    }


    public String editAndDelete(String pass){
        if (pass.equals(libPass)){
            return " lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {\n" +
                    "            @Override\n" +
                    "            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {\n" +
                    "                Intent i = new Intent(getApplicationContext(), EditOrDeleteForm.class);\n" +
                    "                i.putExtra(\"name\", names.get(position));\n" +
                    "                i.putExtra(\"age\", ages.get(position));\n" +
                    "                i.putExtra(\"description\", descriptions.get(position));\n" +
                    "                startActivity(i);\n" +
                    "            }\n" +
                    "        });\n" +
                    "->\n" +
                    "XML\n" +
                    " <TextView\n" +
                    "        android:id=\"@+id/tvName1\"\n" +
                    "        android:layout_width=\"wrap_content\"\n" +
                    "        android:layout_height=\"wrap_content\"\n" +
                    "        android:layout_alignParentStart=\"true\"\n" +
                    "        android:layout_alignParentTop=\"true\"\n" +
                    "        android:layout_marginStart=\"73dp\"\n" +
                    "        android:layout_marginTop=\"8dp\"\n" +
                    "        android:text=\"Name:\"\n" +
                    "        android:textSize=\"30dp\" />\n" +
                    "\n" +
                    "    <TextView\n" +
                    "        android:id=\"@+id/tvAge1\"\n" +
                    "        android:layout_width=\"wrap_content\"\n" +
                    "        android:layout_height=\"wrap_content\"\n" +
                    "        android:layout_alignParentStart=\"true\"\n" +
                    "        android:layout_alignParentTop=\"true\"\n" +
                    "        android:layout_marginStart=\"99dp\"\n" +
                    "        android:layout_marginTop=\"62dp\"\n" +
                    "        android:text=\"Age:\"\n" +
                    "        android:textSize=\"30dp\" />\n" +
                    "\n" +
                    "    <TextView\n" +
                    "        android:id=\"@+id/tvDescription1\"\n" +
                    "        android:layout_width=\"wrap_content\"\n" +
                    "        android:layout_height=\"wrap_content\"\n" +
                    "        android:layout_alignParentStart=\"true\"\n" +
                    "        android:layout_alignParentTop=\"true\"\n" +
                    "        android:layout_marginStart=\"0dp\"\n" +
                    "        android:layout_marginTop=\"121dp\"\n" +
                    "        android:text=\"Description:\"\n" +
                    "        android:textSize=\"30dp\" />\n" +
                    "\n" +
                    "    <EditText\n" +
                    "        android:id=\"@+id/etNameEdit\"\n" +
                    "        android:layout_width=\"200dp\"\n" +
                    "        android:layout_height=\"wrap_content\"\n" +
                    "        android:layout_alignParentTop=\"true\"\n" +
                    "        android:layout_alignParentEnd=\"true\"\n" +
                    "        android:layout_marginTop=\"5dp\"\n" +
                    "        android:layout_marginEnd=\"24dp\" />\n" +
                    "\n" +
                    "    <EditText\n" +
                    "        android:id=\"@+id/etAgeEdit\"\n" +
                    "        android:layout_width=\"200dp\"\n" +
                    "        android:layout_height=\"wrap_content\"\n" +
                    "        android:layout_alignParentTop=\"true\"\n" +
                    "        android:layout_alignParentEnd=\"true\"\n" +
                    "        android:layout_marginTop=\"59dp\"\n" +
                    "        android:layout_marginEnd=\"28dp\"\n" +
                    "        android:inputType=\"number\" />\n" +
                    "\n" +
                    "    <EditText\n" +
                    "        android:id=\"@+id/etDescriptionEdit\"\n" +
                    "        android:layout_width=\"200dp\"\n" +
                    "        android:layout_height=\"wrap_content\"\n" +
                    "        android:layout_alignParentTop=\"true\"\n" +
                    "        android:layout_alignParentEnd=\"true\"\n" +
                    "        android:layout_marginTop=\"119dp\"\n" +
                    "        android:layout_marginEnd=\"33dp\" />\n" +
                    "\n" +
                    "    <Button\n" +
                    "        android:id=\"@+id/btnEditForm\"\n" +
                    "        android:layout_width=\"wrap_content\"\n" +
                    "        android:layout_height=\"wrap_content\"\n" +
                    "        android:layout_alignParentStart=\"true\"\n" +
                    "        android:layout_alignParentTop=\"true\"\n" +
                    "        android:layout_marginStart=\"43dp\"\n" +
                    "        android:layout_marginTop=\"247dp\"\n" +
                    "        android:onClick=\"btnAddEditForm_Click\"\n" +
                    "        android:text=\"Изменить\" />\n" +
                    "\n" +
                    "    <Button\n" +
                    "        android:id=\"@+id/btnDeleteForm\"\n" +
                    "        android:layout_width=\"wrap_content\"\n" +
                    "        android:layout_height=\"wrap_content\"\n" +
                    "        android:layout_alignParentStart=\"true\"\n" +
                    "        android:layout_alignParentTop=\"true\"\n" +
                    "        android:layout_marginStart=\"252dp\"\n" +
                    "        android:layout_marginTop=\"247dp\"\n" +
                    "        android:onClick=\"btnDeleteForm_Click\"\n" +
                    "        android:text=\"Удалить\" />\n" +
                    "->\n" +
                    " Intent i= getIntent();\n" +
                    "        db = getBaseContext().openOrCreateDatabase(\"mydb.db\", MODE_PRIVATE, null);\n" +
                    "        etName = findViewById(R.id.etNameEdit);\n" +
                    "        etAge = findViewById(R.id.etAgeEdit);\n" +
                    "        etDesc = findViewById(R.id.etDescriptionEdit);\n" +
                    "        etName.setText(i.getStringExtra(\"name\"));\n" +
                    "        etAge.setText(i.getStringExtra(\"age\"));\n" +
                    "        etDesc.setText(i.getStringExtra(\"description\"));\n" +
                    "->\n" +
                    " public void btnAddEditForm_Click(View view) {\n" +
                    "        Cursor cursor = db.rawQuery(\"SELECT * FROM users WHERE name='\"+getIntent().getExtras().getString(\"name\")+\"'\",null);\n" +
                    "        if (cursor.getCount() == 1) {\n" +
                    "            Cursor c = db.rawQuery(\"SELECT * FROM users WHERE name='\"+etName.getText().toString()+\"'\",null);\n" +
                    "            if (c.getCount() != 0) {\n" +
                    "                Toast.makeText(this, \"Такой уже есть!\", Toast.LENGTH_SHORT).show();\n" +
                    "                return;\n" +
                    "            }\n" +
                    "            ContentValues cv = new ContentValues();\n" +
                    "            cv.put(\"name\", etName.getText().toString());\n" +
                    "            cv.put(\"age\", etAge.getText().toString());\n" +
                    "            cv.put(\"description\", etDesc.getText().toString());\n" +
                    "            db.update(\"users\", cv, \"name='\"+getIntent().getExtras().getString(\"name\")+\"'\", null);\n" +
                    "            Intent i = new Intent(this, MainActivity.class);\n" +
                    "            startActivity(i);\n" +
                    "        }\n" +
                    "        else Toast.makeText(this, \"Такой уже есть(\", Toast.LENGTH_SHORT).show();\n" +
                    "\n" +
                    "    }\n" +
                    "->\n" +
                    " public void btnDeleteForm_Click(View view) {\n" +
                    "        Intent intent= getIntent();\n" +
                    "        db.delete(\"users\", \"name='\"+intent.getStringExtra(\"name\")+\"'\",null);\n" +
                    "        Intent i = new Intent(this, MainActivity.class);\n" +
                    "        startActivity(i);\n" +
                    "    }";
        }
        return "Error";
    }


    public String addJava(String pass){
        if (pass.equals(libPass)){
            return " EditText etName, etAge, etDescription;\n" +
                    "        etName = findViewById(R.id.etName);\n" +
                    "        etAge = findViewById(R.id.etAge);\n" +
                    "        etDescription = findViewById(R.id.etDescription);\n" +
                    "        Cursor cursor = db.rawQuery(\"SELECT * FROM users WHERE name='\"+etName.getText().toString()+\"'\",null);\n" +
                    "        if (cursor.getCount() == 0) {\n" +
                    "            ContentValues cv = new ContentValues();\n" +
                    "            cv.put(\"name\", etName.getText().toString());\n" +
                    "            cv.put(\"age\", etAge.getText().toString());\n" +
                    "            cv.put(\"description\", etDescription.getText().toString());\n" +
                    "            db.insert(\"users\", null,cv);\n" +
                    "            Toast.makeText(this, \"Inserted\", Toast.LENGTH_SHORT).show();\n" +
                    "            names.add(etName.getText().toString());\n" +
                    "            ages.add(etAge.getText().toString());\n" +
                    "            descriptions.add(etDescription.getText().toString());\n" +
                    "            CustomAdapter adapter = new CustomAdapter(names, ages, descriptions,getApplicationContext());\n" +
                    "            ListView lv = findViewById(R.id.lvUsers);\n" +
                    "            lv.setAdapter(adapter);\n" +
                    "        }\n" +
                    " else Toast.makeText(this, \"Такой уже есть(\", Toast.LENGTH_SHORT).show();";
        }
        return "null";
    }

    public String customList(String pass){
        if(pass.equals(libPass)){
            return "XML\n" +
                    " <LinearLayout\n" +
                    "        android:layout_width=\"match_parent\"\n" +
                    "        android:layout_height=\"wrap_content\" android:orientation=\"horizontal\">\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:id=\"@+id/tvNameTemplate\"/>\n" +
                    "        <TextView\n" +
                    "            android:layout_width=\"wrap_content\"\n" +
                    "            android:layout_height=\"wrap_content\"\n" +
                    "            android:id=\"@+id/tvAgeTemplate\"/>\n" +
                    "    </LinearLayout>\n" +
                    "\n" +
                    "    <TextView\n" +
                    "        android:layout_width=\"wrap_content\"\n" +
                    "        android:layout_height=\"wrap_content\"\n" +
                    "        android:id=\"@+id/tvDescriptionTemplate\"/>\n" +
                    "->\n" +
                    "public class CustomAdapter extends BaseAdapter {\n" +
                    "    ArrayList<String> names, ages, descriptions;\n" +
                    "    Context context;\n" +
                    "\n" +
                    "    public CustomAdapter(ArrayList<String> names, ArrayList<String> ages, ArrayList<String> descriptions, Context context) {\n" +
                    "        this.names = names;\n" +
                    "        this.ages = ages;\n" +
                    "        this.descriptions = descriptions;\n" +
                    "        this.context = context;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public int getCount() {\n" +
                    "        return names.size();\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public Object getItem(int position) {\n" +
                    "        return null;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public long getItemId(int position) {\n" +
                    "        return position;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public View getView(int position, View convertView, ViewGroup parent) {\n" +
                    "        TextView tvNameTemplate, tvAgeTemplate, tvDescriptionTemplate;\n" +
                    "        View v = LayoutInflater.from(context).inflate(R.layout.users_template, null);\n" +
                    "        tvNameTemplate = v.findViewById(R.id.tvNameTemplate);\n" +
                    "        tvAgeTemplate = v.findViewById(R.id.tvAgeTemplate);\n" +
                    "        tvDescriptionTemplate = v.findViewById(R.id.tvDescriptionTemplate);\n" +
                    "        tvNameTemplate.setText(names.get(position));\n" +
                    "        tvAgeTemplate.setText(ages.get(position));\n" +
                    "        tvDescriptionTemplate.setText(descriptions.get(position));\n" +
                    "        return v;\n" +
                    "    }\n" +
                    "}";
        }
        return "Error";
    }



    public String sql(String pass){
        if (pass.equals(libPass)){
            return " db = getBaseContext().openOrCreateDatabase(\"mydb.db\",MODE_PRIVATE,null);\n" +
                    "        db.execSQL(\"CREATE TABLE IF NOT EXISTS users(name TEXT, age TEXT, description TEXT)\");\n" +
                    "\n" +
                    "        names = new ArrayList<>();\n" +
                    "        ages = new ArrayList<>();\n" +
                    "        descriptions = new ArrayList<>();\n" +
                    "\n" +
                    "        Cursor cursor = db.rawQuery(\"SELECT * FROM users\", null);\n" +
                    "        if (cursor.getCount() != 0) {\n" +
                    "            cursor.moveToFirst();\n" +
                    "            do {\n" +
                    "                names.add(cursor.getString(0));\n" +
                    "                ages.add(cursor.getString(1));\n" +
                    "                descriptions.add(cursor.getString(2));\n" +
                    "            }while (cursor.moveToNext());\n" +
                    "        }\n" +
                    "        CustomAdapter adapter = new CustomAdapter(names, ages, descriptions,getApplicationContext());\n" +
                    "        ListView lv = findViewById(R.id.lvUsers);\n" +
                    "        lv.setAdapter(adapter);";
        }

        return "Error";
    }

    public String xml(String pass){
        if (pass.equals(libPass)){
            return "public class MainActivity extends AppCompatActivity {\n" +
                    "\n" +
                    "    private TextView txt;\n" +
                    "    private ListView lv;\n" +
                    "    ArrayAdapter<String> adapter;\n" +
                    "    ArrayList<String> lst;\n" +
                    "\n" +
                    "    @Override\n" +
                    "    protected void onCreate(Bundle savedInstanceState) {\n" +
                    "        super.onCreate(savedInstanceState);\n" +
                    "        setContentView(R.layout.activity_main);\n" +
                    "\n" +
                    "        // Важно!!! Иначе будет хуйня!\n" +
                    "        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();\n" +
                    "        StrictMode.setThreadPolicy(policy);\n" +
                    "\n" +
                    "        lv = findViewById(R.id.lstv);\n" +
                    "        lst = new ArrayList<>();\n" +
                    "\n" +
                    "        XmlParsing parsing = new XmlParsing();\n" +
                    "        parsing.execute();\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "    public class XmlParsing extends AsyncTask<XmlPullParser, XmlPullParser, XmlPullParser> {\n" +
                    "\n" +
                    "        @Override\n" +
                    "        protected XmlPullParser doInBackground(XmlPullParser... xmlPullParsers) {\n" +
                    "            XmlPullParserFactory parseFactory;\n" +
                    "            HttpURLConnection connection;\n" +
                    "            try {\n" +
                    "                URL url = new URL(\"https://itbad.000webhostapp.com/myxml.xml\");\n" +
                    "                connection = (HttpURLConnection) url.openConnection();\n" +
                    "                parseFactory = XmlPullParserFactory.newInstance();\n" +
                    "                XmlPullParser parser = parseFactory.newPullParser();\n" +
                    "                InputStream is = connection.getInputStream();\n" +
                    "                parser.setInput(is, null);\n" +
                    "\n" +
                    "                return parser;\n" +
                    "\n" +
                    "            } catch (Exception e){\n" +
                    "                e.printStackTrace();\n" +
                    "            }\n" +
                    "            return null;\n" +
                    "        }\n" +
                    "\n" +
                    "        @Override\n" +
                    "        protected void onPostExecute(XmlPullParser parser) {\n" +
                    "            super.onPostExecute(parser);\n" +
                    "\n" +
                    "            try {\n" +
                    "                processParsing(parser);\n" +
                    "            } catch (Exception e) {\n" +
                    "\n" +
                    "            }\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "\n" +
                    "    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {\n" +
                    "        ArrayList<Player> players = new ArrayList<>();\n" +
                    "        int eventType = parser.getEventType();\n" +
                    "        Player currentPlayer = null;\n" +
                    "\n" +
                    "        while (eventType != XmlPullParser.END_DOCUMENT) {\n" +
                    "            String eltName = parser.getName();\n" +
                    "\n" +
                    "            switch (eventType) {\n" +
                    "                case XmlPullParser.START_TAG:\n" +
                    "                    eltName = parser.getName();\n" +
                    "\n" +
                    "                    if (\"Valute\".equals(eltName)) {\n" +
                    "                        currentPlayer = new Player();\n" +
                    "                        players.add(currentPlayer);\n" +
                    "                    } else if (currentPlayer != null) {\n" +
                    "                        if (\"NumCode\".equals(eltName)) {\n" +
                    "                            currentPlayer.NumCode = parser.nextText();\n" +
                    "                        } else if (\"CharCode\".equals(eltName)) {\n" +
                    "                            currentPlayer.CharCode = parser.nextText();\n" +
                    "                        } else if (\"Name\".equals(eltName)) {\n" +
                    "                            currentPlayer.Name = parser.nextText();\n" +
                    "                        } else if (\"Value\".equals(eltName)) {\n" +
                    "                            currentPlayer.Value = parser.nextText();\n" +
                    "                        }\n" +
                    "                    }\n" +
                    "                    break;\n" +
                    "            }\n" +
                    "            eventType = parser.next();\n" +
                    "        }\n" +
                    "\n" +
                    "        for (Player player : players) {\n" +
                    "            lst.add(player.CharCode + \" \" + player.Value + \" \" + player.Name);\n" +
                    "        }\n" +
                    "\n" +
                    "        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvItem, lst);\n" +
                    "        lv.setAdapter(adapter);\n" +
                    "\n" +
                    "    }";


        }

        return "Error";
    }


    public String xmlFromFile(String pass){
        if (pass.equals(libPass)){
            return  "XmlDocument xDoc = new XmlDocument();\n" +
                    "xDoc.Load(\"D://users.xml\");\n" +
                    "XmlElement xRoot = xDoc.DocumentElement;\n" +
                    "foreach (XmlElement xnode in xRoot)\n" +
                    "{\n" +
                    "User user = new User();\n" +
                    "XmlNode attr = xnode.Attributes.GetNamedItem(\"name\");\n" +
                    "if (attr != null)\n" +
                    "user.Name = attr.Value;\n" +
                    "\n" +
                    "foreach (XmlNode childnode in xnode.ChildNodes)\n" +
                    "{\n" +
                    "if (childnode.Name == \"company\")\n" +
                    "user.Company = childnode.InnerText;\n" +
                    "\n" +
                    "if (childnode.Name == \"age\")\n" +
                    "user.Age = Int32.Parse(childnode.InnerText);\n" +
                    "}\n" +
                    "users.Add(user);\n" +
                    "}\n" +
                    "foreach (User u in users)\n" +
                    "Console.WriteLine($\"{u.Name} ({u.Company}) - {u.Age}\");";
        }

        return "Error";
    }


}
