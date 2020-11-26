package munki.db.room.ui.main;

import android.os.Bundle;

import javax.inject.Inject;

import munki.db.room.R;
import munki.db.room.databinding.ActivityMainBinding;
import munki.db.room.ui.base.BaseActivity;

import static munki.db.room.BR.main;

/**
 * [MVVM] MainActivity - [ToolBar - AppBar]를 이용한 컨텐츠 제공 메인 화면입니다.
 * @author 나비이쁜이
 * @since 2020.11.26
 */
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator {

    /**
     * this.binding & this.viewmodel
     */
    private ActivityMainBinding mBinding;
    @Inject MainViewModel mViewModel;

    /************************************************************************************************************************************************/

    /**
     * variable - name을 BR class에서 가져옵니다.
     */
    @Override
    public int getBindingVariable() {
        return main;
    }

    /**
     * Get Resoucres Layout
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * Get ViewModel
     */
    @Override
    public MainViewModel getViewModel() {
        // ViewModel에 인터페이스를 전달하는 Navigation
        mViewModel.setNavigation(this);

        // Dagger를 통하여 생성된 viewModel return
        return mViewModel;
    }

    /************************************************************************************************************************************************/

    /**
     * onCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Databinding & Navigation Binding
        mBinding = getViewDataBinding();

        // observer init
        ObserverInit();
    }

    /**
     * Observer & Init
     */
    @Override
    protected void ObserverInit() {
        super.ObserverInit();

        // SetAdapter
        MainAdapter adapter = new MainAdapter(this);
        mBinding.searchRecyclerview.setAdapter(adapter);

        // LiveData
        mViewModel.getAllWords().observe(this, adapter::setWords);
    }

    /************************************************************************************************************************************************/

    /**
     * get Edit String
     */
    @Override
    public String getString() {
        return mBinding.etSearch.getText() != null ? mBinding.etSearch.getText().toString() : "null";
    }
}
