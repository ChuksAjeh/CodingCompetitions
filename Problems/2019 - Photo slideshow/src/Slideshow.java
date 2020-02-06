import java.util.ArrayList;

public class Slideshow {
    ArrayList<Slide> slides = new ArrayList<Slide>();
    int score;

    public Slideshow(ArrayList<Photo> randomPhotos){
        if(randomPhotos.isEmpty() == true){
            throw new IllegalStateException("Must pass in atleast 1 photo");
        }
        else{
            createSlides(randomPhotos);
            //TODO: Create slides
            //TODO: Order slides
            //TODO: Calculate score for slideshow
        }
    }

    public static void main(String[] args) {
        Slideshow test = Parser.readSlideshow("a_example.txt");
        System.out.println(test.slides.get(0).getPhoto(2).photoID);
    }

    public int calculateScore(){
        int score = 0;
        if(slides.size() == 1){
            return score;
        }
        //TODO: Else if find intersection of tags
        return 0;
    }

    public void createSlides(ArrayList<Photo> randomPhotos){
        //THIS IS FOR THE SAKE OF TESTING
        //TODO: Create slides based on spec
        Slide someSlide = new Slide(randomPhotos.get(0), randomPhotos.get(1));
        slides.add(someSlide);

    }

    public void orderSlides(){
        //TODO: Order slides based on common tags, remove tags unrelated to neighbours
    }

    //CONSIDER A PRIVATE "compareSlides" METHOD TO COMPARE 2 SLIDES FOR COMMON TAGS AND RETURN int - Can use this in "orderSlides"


}
