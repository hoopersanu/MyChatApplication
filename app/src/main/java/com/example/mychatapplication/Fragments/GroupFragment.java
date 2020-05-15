package com.example.mychatapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mychatapplication.Adapter.GroupAdapter;
import com.example.mychatapplication.Model.Group;
import com.example.mychatapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class GroupFragment extends Fragment {

    private View view;
    private RecyclerView rv_group_list;
    private GroupAdapter mgroupAdapter;
    private List<Group> mgroups;

    private DatabaseReference GroupsRef;

    public GroupFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_group, container, false);

        rv_group_list = view.findViewById(R.id.rv_group);
        rv_group_list.setLayoutManager(new LinearLayoutManager(getContext()));

        GroupsRef = FirebaseDatabase.getInstance().getReference().child("Groups");
        mgroups = new ArrayList<>();

//        InitializeFields(view);


        List<Integer>users = new ArrayList<>();
        users.add(12344);
        users.add(12345);
        users.add(12346);
        users.add(12347);

//        String imageurl = "default";
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("name", "Group Name will go here");
//        hashMap.put("users", users);
//        hashMap.put("imageurl", imageurl);


        String id  = java.util.UUID.randomUUID().toString();
        Group group = new Group(id, "Test Name", users);
//        HashMap<String, Object> hashMap = new HashMap<>();
//        hashMap.put("name", group);
        //GroupsRef.child(id).setValue(group.toHashMap());

        RetriveAndDisplayGroups();

        return view;
    }



//    private void InitializeFields() {
//        list_view = (ListView) gropuFragmentView.findViewById(R.id.listview);
//        arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, list_of_groups);
//        list_view.setAdapter(arrayAdapter);
//    }

    private void RetriveAndDisplayGroups() {
        GroupsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mgroups.clear();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    Group group = snapshot.getValue(Group.class);
                    assert group != null;
                    mgroups.add(group);
                }

                mgroupAdapter = new GroupAdapter(getContext(), mgroups);
                rv_group_list.setAdapter(mgroupAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
