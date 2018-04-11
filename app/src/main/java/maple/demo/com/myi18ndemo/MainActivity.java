package maple.demo.com.myi18ndemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import maple.demo.com.myi18ndemo.base.BaseActivity;
import maple.demo.com.myi18ndemo.utils.I18NUtils;

public class MainActivity extends BaseActivity {
    private TextView tvSettingLanguage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSettingLanguage = findViewById(R.id.tv_setting_language);
        registerForContextMenu(tvSettingLanguage);

        tvSettingLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
            }
        });
    }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.setting_language, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_zh:
                toSetLanguage(2);
                break;
            case R.id.item_en:
                toSetLanguage(1);
                break;
            case R.id.item_sys:
                toSetLanguage(0);
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void toSetLanguage(int type) {
        boolean sameLanguage = I18NUtils.isSameLanguage(this, type);
        if (!sameLanguage) {
            I18NUtils.setLocale(this, type);
            // 前面取系统语言时判断spType=0时取第一值，所以设置完语言后缓存type
            I18NUtils.putLanguageType(this, type);
            I18NUtils.toRestartMainActvity(this);
        } else {
            // 缓存用户此次选择的类型，可能出现type不同而locale一样的情况（如：系统默认泰语type = 0，而我选择的也是泰语type = 3）
            I18NUtils.putLanguageType(this, type);
        }
    }
}
