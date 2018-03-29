package io.app.story;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;


public class StoryFrag extends Fragment {
    private static final String TAB_TITLE = "tab_title";

    @BindView(R.id.frag_recycler_view)
    RecyclerView fragRecyclerView;
    @BindView(R.id.frag_swipe_fresh_layout)
    SwipeRefreshLayout fragSwipeFreshLayout;
    StoryAdapter mStoryAdapter;

    private String mTabTitle;

    public StoryFrag() {
    }

    public static StoryFrag newInstance(String tabTitle) {
        StoryFrag fragment = new StoryFrag();
        Bundle args = new Bundle();
        args.putString(TAB_TITLE, tabTitle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTabTitle = getArguments().getString(TAB_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_story, container, false);
        ButterKnife.bind(this, root);
        initList();
        return root;
    }

    private void initList(){
        fragSwipeFreshLayout.setColorSchemeResources(R.color.colorPrimary,R.color.colorAccent);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        fragSwipeFreshLayout.setDistanceToTriggerSync((int) (128 * metrics.density));
        fragSwipeFreshLayout.setOnRefreshListener(mOnRefreshListener);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        fragRecyclerView.setLayoutManager(linearLayoutManager);
        if (mStoryAdapter == null){
            mStoryAdapter = new StoryAdapter();
        }
        fragRecyclerView.setAdapter(mStoryAdapter);
    }

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            new Handler().postDelayed(() -> {
                if (fragSwipeFreshLayout.isRefreshing()){
                    fragSwipeFreshLayout.setRefreshing(false);
                }
            }, 3000);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
