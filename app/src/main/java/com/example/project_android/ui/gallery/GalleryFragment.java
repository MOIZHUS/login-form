package com.example.project_android.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.project_android.R;
//import com.example.project_android.databinding.FragmentGalleryBinding;
//import com.example.project_android.retrofit.APIinterface;
//import com.example.project_android.retrofit.Pojo;
//import com.example.project_android.retrofit.Retrofit;
//import com.squareup.picasso.Picasso;
//
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

public class GalleryFragment extends Fragment {

//    private FragmentGalleryBinding binding;
//    RecyclerView recycle;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        GalleryViewModel galleryViewModel =
//                new ViewModelProvider(this).get(GalleryViewModel.class);
//
//        binding = FragmentGalleryBinding.inflate(inflater, container, false);
//
//        recycle=binding.recycler;
//        listingdata();
//        LinearLayoutManager llm= new LinearLayoutManager(getActivity().getApplicationContext()
//                ,LinearLayoutManager.VERTICAL,false);
//        recycle.setLayoutManager(llm);
//
//        return recycle;
//    }
//    private void listingdata(){
//        APIinterface apIinterface= Retrofit.getRetrofit().create(APIinterface.class);
//        Call<Pojo> listingdata=apIinterface.getData();
//        listingdata.enqueue(new Callback<Pojo>() {
//            @Override
//            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
//                if(response.isSuccessful()){
//                    recycleradapter recycleradapter=new recycleradapter(response.body().getData());
//                    recycle.setAdapter(recycleradapter);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Pojo> call, Throwable t) {
//                Toast.makeText(getActivity().getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    class recycleradapter extends RecyclerView.Adapter<recycleradapter.MyViewHolder>{
//        List<Pojo.Datum> list;
//
//        public recycleradapter(List<Pojo.Datum> list){
//            this.list=list;
//        }
//        @NonNull
//        @Override
//        public recycleradapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,null);
//            recycleradapter.MyViewHolder viewHolder=new recycleradapter.MyViewHolder(view);
//            return viewHolder;
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull recycleradapter.MyViewHolder holder, int position) {
//            holder.email.setText(list.get(position).getEmail());
//            holder.fstname.setText(list.get(position).getFirstName());
//            holder.lstname.setText(list.get(position).getLastName());
//
//            Picasso.with(getActivity().getApplicationContext()).load(list.get(position).getAvatar())
//                    .placeholder(R.drawable.ic_launcher_background)
//                    .fit().into(holder.imgs);
//        }
//
//        @Override
//        public int getItemCount() {
//            return list.size();
//        }
//        class MyViewHolder extends RecyclerView.ViewHolder{
//            TextView fstname,userid,lstname,email;
//            ImageView imgs;
//            public MyViewHolder(@NonNull View itemView) {
//                super(itemView);
//                email=itemView.findViewById(R.id.email);
//                fstname=itemView.findViewById(R.id.fstname);
//                lstname=itemView.findViewById(R.id.lstname);
//                userid=itemView.findViewById(R.id.user_id);
//                imgs=itemView.findViewById(R.id.imgs);
//
//            }
//        }
//    }
}


