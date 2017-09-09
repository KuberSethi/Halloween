package michael.com.halloween;

import com.google.android.gms.maps.model.LatLng;



public class Event {

    private String comment;
    private float rating;
    private LatLng latlng;

    public Event(String comment,float rating,LatLng latlng){

        this.comment = comment;
        this.rating = rating;
        this.latlng = latlng;
    }

    public String getComment() {
        return comment;
    }

    public float getRating() {
        return rating;
    }

    public LatLng getLatlng() {
        return latlng;
    }
}
