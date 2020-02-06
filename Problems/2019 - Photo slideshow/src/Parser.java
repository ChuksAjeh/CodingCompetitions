import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    //basic file reader that opens and reads the file
    public static Slideshow readSlideshow(String filename){

        File fileIn = new File(filename);

        Scanner scan = null;

        try{

            scan = new Scanner(fileIn);

        }catch (FileNotFoundException e){

            System.out.println("Unable to open file or file not found.");

            System.exit(0);

        }



        return Parser.readSlideshow(scan);

    }

    /**

     * @param in overloads the readProfileSet method and takes in the scanned file.

     *           a nested scanner then looks at each line of the file and parses it

     *           into the create profile method whilst that profile is inserted into

     *           the tree.

     * */
    // reads the file and and will assign the
    private static Slideshow readSlideshow(Scanner in){
        in.useDelimiter("\n");
        ArrayList<Photo> randomPhotos = new ArrayList<Photo>();
        int numberOfPhotos = in.nextInt();
        in.nextLine();
        while(in.hasNextLine()){
            Scanner currLine = new Scanner(in.nextLine());
            Photo somePhoto = readPhoto(currLine);
            randomPhotos.add(somePhoto);
        }

        Slideshow newSlideshow = new Slideshow(randomPhotos);
        return newSlideshow;

    }

    private static Photo readPhoto(Scanner in ){
        boolean isVertical;
        String orientation = in.next();
        if(orientation == "V"){
            isVertical = true;
        }
        else{
            isVertical = false;
        }
        String[] tags = new String[in.nextInt()];
        for(int i = 0; i < tags.length-1; i++){
            tags[i] = in.next();
        }
        return new Photo(isVertical, tags);
    }


}
