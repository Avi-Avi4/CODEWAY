import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", 
            new String[]{"London", "Paris", "Berlin", "Madrid"}, 2));
        questions.add(new Question("Which planet is known as the Red Planet?", 
            new String[]{"Mars", "Venus", "Jupiter", "Saturn"}, 0));
        questions.add(new Question("What is the largest ocean in the world?", 
            new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, 3));
        questions.add(new Question("Who painted the Mona Lisa?", 
            new String[]{"Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo"}, 0));

        int score = 0;
        
        for (Question question : questions) {
            System.out.println(question.getQuestion());
            for (int i = 0; i < question.getOptions().length; i++) {
                System.out.println((i + 1) + ". " + question.getOptions()[i]);
            }
            
            System.out.print("Enter your answer (1-" + question.getOptions().length + "): ");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            
            if (answer - 1 == question.getCorrectAnswer()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
            
            System.out.println();
        }
        
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctAnswer;
    
    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public String[] getOptions() {
        return options;
    }
    
    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
