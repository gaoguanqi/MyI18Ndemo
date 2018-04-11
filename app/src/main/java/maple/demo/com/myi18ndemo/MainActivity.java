package maple.demo.com.myi18ndemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import maple.demo.com.myi18ndemo.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private TextView tvSettingLanguage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSettingLanguage = findViewById(R.id.tv_setting_language);
        registerForContextMenu(tvSettingLanguage);
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

                break;
            case R.id.item_en:

                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }
}
