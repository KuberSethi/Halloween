package michael.com.halloween;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CreateEventFragment extends DialogFragment {

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.create_event,container);
        Button exit = view.findViewById(R.id.submit);
        final EditText comments = (EditText)view.findViewById(R.id.comments);
        final RatingBar rating = (RatingBar)view.findViewById(R.id.rating);
        Bundle bundle = this.getArguments();
        final LatLng latLng = new LatLng(bundle.getDouble("latitude"),bundle.getDouble("longitude"));


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String commentString = comments.getText().toString();

            if(!commentString.equals("") && rating.getNumStars() >= 0){

                Toast.makeText(getActivity(),"Form submitted",Toast.LENGTH_LONG).show();
                DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference();
                String key = dataRef.push().getKey();
                dataRef.child(key).setValue(new Event(commentString,rating.getRating(),latLng));

                dismiss();
            }



            }
        });




        return view;
    }








}
