package app.thender.thender.task;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import app.thender.thender.UserActivity;
import app.thender.thender.model.vo.UserVO;

public class UserTask extends AsyncTask<Void, Void, List<UserVO>> {

    private UserActivity activity;
    private List<UserVO> userList;

    public UserTask(UserActivity activity) {this.activity = activity; }

    @Override
    protected List<UserVO> doInBackground(Void... voids) {

        try{
            URL ws = new URL("http://104.131.77.44:8080/application/users-activity/list");
            //URL ws = new URL("http://crs.unochapeco.edu.br/json.json");

            HttpURLConnection con = (HttpURLConnection) ws.openConnection();

            InputStream is = con.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            Gson g = new Gson();
            TypeToken<List<UserVO>> tpToken = new TypeToken<List<UserVO>>(){};
            userList = g.fromJson(reader, tpToken.getType());
            con.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }

        return userList;
    }


    @Override
    protected void onPostExecute(List<UserVO> userVOs) {
        activity.receberUsers(userVOs);
    }
}
