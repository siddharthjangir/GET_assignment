import java.util.Scanner;
/*
 * This class is used to give some analysis on the grades of the Students
 */
public class Marksheet {

    /**
     * This method is to Give the average grade of the Students
     * @param grades
     * @return Average Grade 
     */
    static double averageGrade(double[] grades){
        double sum =0;
        for(int i=0;i<grades.length;i++){
            sum = sum +grades[i];
        }
        double average=sum/grades.length;
        return average;
    }
    /**
     * This method is to Give the maximum of grades.
     * @param grades
     * @return Maximum Grade 
     */
    static double maximunGrade(double[] grades){
        double temp = 0.0;
        for(int i=0;i<grades.length;i++){
            if(grades[i]>temp){
                temp=grades[i];
            }
        }
        return temp;
    }
     /**
     * This method is to Give the Minimum of grades.
     * @param grades
     * @return Minimum Grade 
     */
    static double minimunGrade(double[] grades){
        double temp = 100.00;
        for(int i=0;i<grades.length;i++){
            if(grades[i]<temp){
                temp=grades[i];
            }
        }
        return temp;
    }
     /**
     * This method is to Give the Percentage of passed students.(Above then 40.0 grades are marked as passed)
     * @param grades
     * @return %passed students
     */
    static double percentageOfStudentsPassed(double[] grades){
        int count =0;
        for(int i=0;i<grades.length;i++){
            if(grades[i]>=40.00){
                count=count+1;
            }
        }
        double result = ((double)(count) / (double)(grades.length));
        result *= 100.00;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number of Students");
        
        //Taking input from the User for number of students

        int n = scanner.nextInt();
        double grades[];
        grades = new double[n];
        scanner.close();
        //Taking input from user to get Students grade

        for(int i=0;i<n;i++){
            System.out.println("Enter the Grade of Student "+ (i+1));
            double dumy =scanner.nextDouble();
            if(dumy<0 || dumy>100){
                System.out.println("Please Enter a valid grade number else BOOM");
                double dumy1 =scanner.nextDouble();
                if(dumy1<0 || dumy1>100){
                    throw new IllegalArgumentException("Grades should be between 0 to 100");
                }
                grades[i]=dumy1;
                
            }
            else{
                grades[i]=dumy;
            }
            
        }
        //Printing Average Grade
        double avg = averageGrade(grades);
        System.out.println("Average of the all the grades : " + avg);

        //Printing Maximum Grade
        double max = maximunGrade(grades);
        System.out.println("MAximum of grades is : " + max);

        //Printing Minimum Grades
        double min = minimunGrade(grades);
        System.out.println("Minimum of all the grades : " + min);

        //Printing Percentage of Passed Students
        double passed = percentageOfStudentsPassed(grades);
        System.out.println("Percentage of students passed exams: " + passed);
    }
    
}
