import java.util.ArrayList;
import java.util.InputMismatchException;

public class Slide {
    Photo mainPhoto;
    Photo optionalPhoto;

    public Slide(Photo firstPhoto, Photo secondPhoto){
        if(firstPhoto.isVertical == false || secondPhoto.isVertical == false){
            throw new IllegalArgumentException("You cannot have a slide without 2 vertical photos");
        }
        else{
            mainPhoto = firstPhoto;
            optionalPhoto = secondPhoto;
        }
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
