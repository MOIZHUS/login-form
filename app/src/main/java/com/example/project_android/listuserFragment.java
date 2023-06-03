package com.example.project_android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_android.Entity.UserEntity;
import com.example.project_android.retrofit.APIClient;
import com.example.project_android.retrofit.APIinterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 */
public class listuserFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public listuserFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static listuserFragment newInstance(int columnCount) {
        listuserFragment fragment = new listuserFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        APIinterface apiInterface;

        View view = inflater.inflate(R.layout.cardlayout, container, false);

        // Create an instance of the Retrofit API interface
        apiInterface = APIClient.getClient().create(APIinterface.class);

        // Make the API call to fetch user data
        Call<UserEntity> call = apiInterface.getUserData("1");
        call.enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                if (response.isSuccessful()) {
                    // Get the list of users from the API response
                    assert response.body() != null;
                    List<UserEntity.Datum> userList = response.body().getData();


                    // Create the adapter with the user list
                    MylistuserRecyclerViewAdapter adapter = new MylistuserRecyclerViewAdapter(userList);

                    // Set the adapter to the RecyclerView
                    RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(adapter);
                } else {
                    // Handle API error
                    // ...
                }
            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {
                // Handle API failure
                // ...
            }
        });

        return view;
    }
}


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        APIinterface apIinterface;
//
//        View view = inflater.inflate(R.layout.cardlayout, container, false);
//        // Create an instance of the Retrofit API interface
//         apIinterface  = APIClient.getClient().create(APIinterface.class);
//
//        // Make the API call
//        Call<Resource> call = apIinterface.getData();
//        call.enqueue(new Callback<Resource>() {
//            @Override
//            public void onResponse(Call<Resource> call, Response<Resource> response) {
//                if (response.isSuccessful()) {
//                    // Get the list of data items from the API response
//                    List<DatumResource> dataList = response.body().getData();
//
//                    List<UserEntity.Datum> userList = ...; // Your user list data
//                    MylistuserRecyclerViewAdapter adapter = new MylistuserRecyclerViewAdapter(userList);
//                    recyclerView.setAdapter(adapter);
//                    // Create an adapter and set it to the RecyclerView
////                    MylistuserRecyclerViewAdapter adapter = new MylistuserRecyclerViewAdapter();
////                    recyclerView.setAdapter(adapter);
//                } else {
//                    // Handle API error
//                    // ...
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Resource> call, Throwable t) {
//                // Handle API failure
//                // ...
//            }
//        });
//
//        return view;
//    }
//}
        // Set the adapter
//        if (view instanceof RecyclerView) {
//            Context context = view.getContext();
//            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
//            recyclerView.setAdapter(new MylistuserRecyclerViewAdapter(PlaceholderContent.ITEMS));
//        }
//        return view;
//    }
//}