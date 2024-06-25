import java.util.Scanner;
public class JobScheduler {

    /*
    * To represent a process with its values .s
    * Created a class for the process
    */ 
    static class Process {
        int id;
        int arrivalTime;
        int burstTime;
        int completionTime;
        int waitingTime;
        int turnAroundTime;

        // Constructor to initialize the process attributes
        Process(int id , int arrivalTime, int burstTime){
            this.id=id;
            this.arrivalTime=arrivalTime;
            this.burstTime=burstTime;
        }
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for no. of processes and their arrival and burst time

        System.out.print("Enter the number of Processes");
        int n = scanner.nextInt();

        Process[] processes = new Process[n];

        for (int i=0;i<n;i++){
            System.out.println("Enter the arrival time for thr process"+(i+1)+":");
            int arrivalTime=scanner.nextInt();
            System.out.println("Enter the burst time for process"+(i+1)+":");
            int burstTime=scanner.nextInt();
            processes[i]=new Process(i+1, arrivalTime, burstTime);
        }

        // calculating the required time completion, Trun Around and Waiting.

        calculateCompletionTime(processes);
        calculateTurnAroundTime(processes);
        calculateWaitingTime(processes);

        //Print process in table form
        printProcesses(processes);

        //Print the average and maximum waiting time
        printAverageWaitingTime(processes);
        printMaximumWaitingTime(processes);

        scanner.close();

    }

    // Methods to calculate Completion time
    public static void calculateCompletionTime(Process[] processes){
        int currentTime = 0;
        for (Process process : processes){
            if (currentTime<process.arrivalTime){
                currentTime=process.arrivalTime;
            }
            process.completionTime=currentTime+process.burstTime;
            currentTime=process.completionTime;
        }
    }

    // Method to calculate Turn Around Time
    public static void calculateTurnAroundTime(Process[] processes){
        for(Process process : processes){
            process.turnAroundTime=process.completionTime-process.arrivalTime;
        }
    }

    //Method to Calculate Waiting Time
    public static void calculateWaitingTime(Process[] processes){
        for(Process process : processes){
            process.waitingTime=process.turnAroundTime-process.burstTime;
        }
    }

    //Method to Print Process in table form

    public static void printProcesses(Process[] processes){
        System.out.println("Process\tArrival Time\tBurst Time\tCompletion Time\tTurn Around Time\tWaiting Time");
        for(Process process:processes){
            System.out.println(process.id+"\t\t"+process.arrivalTime+"\t\t"+process.burstTime+"\t\t"+process.completionTime+"\t\t"+process.turnAroundTime+"\t\t"+process.waitingTime);

        }
    }

    // Method to print Average Waiting time.
    public static void printAverageWaitingTime(Process[] processes){
        double totalWaitingTime=0;
        for(Process process:processes){
            totalWaitingTime += process.waitingTime;
        }
        double averageWaitingTime = totalWaitingTime / processes.length;
        System.out.println("Average Waiting Time: "+ averageWaitingTime);
    }

    // Method to Print Maximum Waiting time.
    public static void printMaximumWaitingTime(Process[] processes){
        int maxWaitingTime = Integer.MIN_VALUE;
        for(Process process : processes){
            if(process.waitingTime>maxWaitingTime){
                maxWaitingTime=process.waitingTime;
            }
        }
        System.out.println("Maximum Waiting Time: " + maxWaitingTime);
    }
}


// When process arrival time is not in the sorted manner like process 2 comes first we have to resolve that case also.