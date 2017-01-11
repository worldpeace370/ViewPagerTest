package com.wxk.viewpagertest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends LazyLoadBaseFragment {

  private static final String ARG_PARAM1 = "param1";

  private String mParam1;
  private View mRootView;
  private boolean mHasLoadedOnce;
  private TextView mTextView;

  public BlankFragment() {
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param param1 Parameter 1.
   * @return A new instance of fragment BlankFragment.
   */
  public static BlankFragment newInstance(String param1) {
    BlankFragment fragment = new BlankFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    if (mRootView == null) {
      AppLog.i("Fragment", "mRootView = null" + ", current page is " + mParam1);
      mRootView = inflater.inflate(R.layout.fragment_blank, container, false);
      isPrepared = true;
      lazyLoad();
    }
    ViewGroup parent = (ViewGroup) mRootView.getParent();
    if (parent != null) {
      parent.removeView(mRootView);
    }
    AppLog.i("Fragment", "parent = " + parent + ", current page is " + mParam1); // parent 始终为null
    return mRootView;
  }

  @Override
  protected void onInvisible() {

  }

  @Override
  protected void lazyLoad() {
    if (!isPrepared || !isVisible || mHasLoadedOnce) {
      return;
    }
    initView();
    initData();
    mHasLoadedOnce = true;
  }

  private void initData() {
    mTextView.setText(mParam1);
  }

  private void initView() {
    mTextView = ((TextView) mRootView.findViewById(R.id.textView));
  }
}
