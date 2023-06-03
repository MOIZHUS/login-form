//package com.example.project_android.retrofit;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class Retrofit {
//    private static String baseurl = "https://reqres.in/api/";
//
//    static Gson gson = new GsonBuilder().setLenient().create();
//
//    private static retrofit2.Retrofit retrofit;
//
//    public static retrofit2.Retrofit getRetrofit(){
//        if(retrofit== null){
//            retrofit = new retrofit2.Retrofit.Builder()
//                    .baseUrl(baseurl)
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .build();
//        }
//        return retrofit;
//    }
//
//}







//package com.example.project_android.retrofit;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.project_android.Entity.Resource;
//import com.example.project_android.R;
//import com.example.project_android.retrofit.APIClient;
//import com.example.project_android.retrofit.APIinterface;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class Retrofit extends AppCompatActivity {
//
//    APIinterface apIinterface;
//
//    TextView fstname,userid,lstname,email;
//    ImageView imgs;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.cardlayout);
//
//        fstname = findViewById(R.id.fstname);
//        userid= findViewById(R.id.user_id);
//        lstname=findViewById(R.id.lstname);
//        email=findViewById(R.id.email);
//
//        imgs=findViewById(R.id.imgs);
//
//        apIinterface  = APIClient.getClient().create(APIinterface.class);
//
//        Call<Resource> call = apIinterface.getData();
//        call.enqueue(new Callback<Resource>(){
//
//
//            @Override
//            public void onResponse(Call<Resource> call, Response<Resource> response) {
//                String displayResponse = "";
//                Resource resource =response.body();
//
//                displayResponse += "Moizresponse" + response.body().getTotalPages();
//                fstname.setText(displayResponse);
//            }
//
//            @Override
//            public void onFailure(Call<Resource> call, Throwable t) {
//
//            }
//        });
//    }
//
//}




