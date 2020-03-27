package college_counseling;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CollegeCounseling counseling = new CollegeCounseling();
        //counseling.showStudentDetail();
        
        counseling.genrateQueue();
        counseling.show();
        counseling.saveData();
    }
}
