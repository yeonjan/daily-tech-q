import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/// Users/ yeonjin/ personal/ prepare-interview/ src/ questions/ questions_java. txt
public class Main {
    public static List<String> subjects = Arrays.asList("java", "spring", "network", "os", "db", "data_Structure", "algorithm");


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        String todaySubject = getTodaySubject(sb, br);
        createTodayQuestion(sb, todaySubject);


    }

    public static String getTodaySubject(StringBuilder sb, BufferedReader br) throws IOException {
        sb.append("오늘의 주제는?").append("\n");
        for (int i = 0; i < subjects.size(); i++) {
            sb.append(i).append(". ").append(subjects.get(i)).append("\n");
        }
        sb.append("입력: ");
        System.out.print(sb);
        sb.setLength(0);

        while (true) {
            try {
                String input = br.readLine();
                int selectionNum = Integer.parseInt(input);
                return subjects.get(selectionNum);
            } catch (NumberFormatException e) {
                System.out.println("보기에 있는 숫자를 입력해주세요");
            }
        }

    }

    public static void createTodayQuestion(StringBuilder sb, String subject) throws IOException {
        List<String> questions = Files.readAllLines(Paths.get("questions_" + subject + ".txt"));
        Collections.shuffle(questions);
        sb.append("***************************************").append("\n");
        sb.append(questions.getFirst()).append("\n");
        sb.append("***************************************").append("\n");
        System.out.println(sb);

    }
}