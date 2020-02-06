import java.util.ArrayList;
import java.util.InputMismatchException;

public class Slide {
    Photo mainPhoto;
    Photo optionalPhoto;

    //TODO: Enforce 2 pictures must be vertical
    //This is easy simply if photo1.isVertical == false then throw error
    public Slide(Photo photo1, Photo photo2){
        mainPhoto = photo1;
        optionalPhoto = photo2;
    }

    public Slide(Photo mainPhoto){
        this.mainPhoto = mainPhoto;
        optionalPhoto = null;
    }


    public Photo getPhoto(int p){
        if(p == 1){
            return mainPhoto;
        }
        if(p == 2){
            return optionalPhoto;
        }
        else{
            throw new InputMismatchException("Photo position must be atleast 1 and at most 2");
        }
    }

    public void addPhoto(Photo p, int position){
        if(position == 1){
            this.mainPhoto = p;
        }
        if(position == 2){
            this.optionalPhoto = p;
        }
        else{
            throw new InputMismatchException("Photo position must be atleast 1 and at most 2");
        }
    }

    public void removePhoto(int p){
        if(p == 1){
            this.mainPhoto = null;
        }
        if(p == 2){
            this.optionalPhoto = null;
        }
        else{
            throw new InputMismatchException("Photo position must be atleast 1 and at most 2");
        }
    }
}
