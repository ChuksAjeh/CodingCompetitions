public class Photo {
    String[] tags;
    static int currentPhotos;
    int photoID;
    boolean isVertical;

    public Photo(boolean isVertical, String[] tags){
        this.isVertical = isVertical;
        this.tags = tags;
        photoID = currentPhotos;
        currentPhotos++;
    }
}
