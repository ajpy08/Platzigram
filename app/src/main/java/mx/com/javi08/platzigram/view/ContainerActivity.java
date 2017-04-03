package mx.com.javi08.platzigram.view;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.com.javi08.platzigram.R;
import mx.com.javi08.platzigram.view.fragment.HomeFragment;
import mx.com.javi08.platzigram.view.fragment.ProfileFragment;
import mx.com.javi08.platzigram.view.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @BindView(R.id.bottombar)
    BottomBar bottombar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        ButterKnife.bind(this);
        //BottomBar bottombar = (BottomBar) findViewById(R.id.bottombar);

        // Sirve para definir cual de nuestras tab mostrara por default pasando su id
        bottombar.setDefaultTab(R.id.home);
        // Escuchara y estara atento para cuando le demos un clic al bottombar sepa que mostrar
        bottombar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.home:
                        HomeFragment homefragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homefragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.profile:
                        ProfileFragment profilefragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profilefragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.search:
                        SearchFragment searchfragment = new SearchFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, searchfragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                }
            }
        });
    }
}
