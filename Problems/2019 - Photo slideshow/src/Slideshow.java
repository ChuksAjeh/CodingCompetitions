import java.util.ArrayList;

public class Slideshow {
    ArrayList<Slide> slides = new ArrayList<Slide>();
    int score;

    public Slideshow(ArrayList<Photo> randomPhotos){
        createSlides(randomPhotos);
        //TODO: Calculate score for slideshow
        //TODO: Create slides
        //TODO: Order slides
    }

    public static void main(String[] args) {
        Slideshow test = Parser.readSlideshow("a_example.txt");
        System.out.println(test.slides.get(0).getPhoto(2).photoID);
    }

    public void calculateScore(){
        //TODO: Find intersection of tags
    }

    public void createSlides(ArrayList<Photo> randomPhotos){
        Slide someSlide = new Slide(randomPhotos.get(0), randomPhotos.get(1));
        slides.add(someSlide);

    }

    //TODO: Order/re-order slides
}
