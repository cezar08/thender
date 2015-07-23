package app.thender.thender.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import app.thender.thender.R;
import app.thender.thender.UserActivity;
import app.thender.thender.model.vo.UserVO;

/**
 * Created by cezar on 22/07/15.
 */
public class UserAdapter extends ArrayAdapter<UserVO> {


    private List<UserVO> listaUsers;
    private LayoutInflater inflater;

    public UserAdapter(Context context, List<UserVO> objects) {
        super(context, R.layout.user_list, objects);

        this.listaUsers = objects;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = inflater.inflate(R.layout.user_list, null);

        UserVO user = listaUsers.get(position);

        TextView lblName = (TextView) item.findViewById(R.id.lblName);
        TextView lblLastLocation = (TextView) item.findViewById(R.id.lblLastLocation);

        lblName.setText(user.getName());
        lblLastLocation.setText(user.getLastLocation());

        return item;
    }


}
