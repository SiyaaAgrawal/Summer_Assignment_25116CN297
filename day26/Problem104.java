import java.util.*;
class Question{
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;
    public Question(String questionText,String options[],int correctAnswerIndex){
        this.questionText=questionText;
        this.options=options;
        this.correctAnswerIndex=correctAnswerIndex;
    }
    public String getQuestionText(){
        return questionText;
    }
    public String[] getOption(){
        return options;
    }
    public int getCorrectAnswerIndex(){
        return correctAnswerIndex;
    }
}
public class Problem104 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int score=0;
        Question quizRepository[]={
            new Question("Question 1",new String[]{"1.String","2.String"},1),
            new Question("Question2",new String[]{"1.String"},1), 
            new Question("Question3",new String[]{"1.String"},1),
        };
        System.out.println("-----------JAVA QUIZ GAME------------");
        for(int i=0;i<quizRepository.length;i++){
            Question currentQuestion=quizRepository[i];
            System.out.println("Question"+(i+1)+":"+currentQuestion.getQuestionText());
            for(String option:currentQuestion.getOption()){
                System.out.println(option);
            }
            int userChoice=-1;
            while(true){
                System.out.println("your answer(Enter option no. 1-4):");
                if(sc.hasNextInt()){
                    userChoice=sc.nextInt();
                    if(userChoice>=1 && userChoice<=4){
                        break;
                    }
                }else{
                    sc.next();
                }
                System.out.println("Invalid choice");
            }
            if((userChoice-1)==currentQuestion.getCorrectAnswerIndex()){
                System.out.println("REsult Correct.");
                score++;
            }else{
                int correctNumber=currentQuestion.getCorrectAnswerIndex()+1;
                System.out.println("Result:Wrong");
            }
        }

            System.out.println("------------QUIZ FINISHED-------------");
            System.out.println("final Score:"+score+"/n"+quizRepository.length);
            double percentage=((double)score/quizRepository.length)*100;
            if(percentage==1){
                System.out.println("Outstanding.");
            }else if(percentage>=75){
                System.out.println("GReat Job.");
            }else {
                System.out.println("better luck next time.");
            }
            System.out.println("-----------------------------------");
    }
}
