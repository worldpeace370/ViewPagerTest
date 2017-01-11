
package com.wxk.viewpagertest;


import android.support.v4.app.Fragment;

/**
 * 延迟加载（ViewPager不预加载Fragment）
 *
 * @author dingguofeng
 * @since 2015年4月23日
 */
public abstract class LazyLoadBaseFragment extends Fragment{
  /** Fragment当前状态是否可见 */
  public boolean isVisible;
  /** 标志位，标志已经初始化完成 */
  protected boolean isPrepared;
  /** 是否已被加载过一次，第二次就不再去请求数据了 */
  protected boolean mHasLoadedOnce;

  @Override
  public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    if (getUserVisibleHint()) {
      isVisible = true;
      onVisible();
    } else {
      isVisible = false;
      onInvisible();
    }
  }

  /**
   * 可见
   */
  protected void onVisible() {
    lazyLoad();
  }

  /**
   * 不可见
   */
  protected abstract void onInvisible();

  /**
   * 延迟加载 子类必须重写此方法
   */
  protected abstract void lazyLoad();

  /**
   * 标记当前的fragment是否可见
   *
   * @return
   */
  public boolean isFragmentVisible() {
    return isVisible;
  }
}
