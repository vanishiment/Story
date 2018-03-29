package io.app.story;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


public class StoryFrag extends Fragment {
    private static final String TAB_TITLE = "tab_title";

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
        ButterKnife.bind(this,root);
        return root;
    }

}
