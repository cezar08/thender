package app.thender.thender;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.thender.thender.adapter.UserAdapter;
import app.thender.thender.model.vo.UserVO;
import app.thender.thender.task.UserTask;

public class UserActivity extends ListActivity {

    private List<UserVO> listaUsers;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        executarTask();
    }

    private void executarTask() {
        UserTask task = new UserTask(this);
        task.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    public void receberUsers(List<UserVO> users) {
        this.listaUsers = users;
        UserAdapter adapter = new UserAdapter(this, users);
        setListAdapter(adapter);
    }

}

